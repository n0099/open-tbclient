package com.baidu.tieba.channel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelAddVideoActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelFansActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.b.a;
import com.baidu.tieba.channel.config.ChannelEditActivityConfig;
import com.baidu.tieba.channel.data.ChannelHomeVideoList;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.channel.data.d;
import com.baidu.tieba.channel.data.h;
import com.baidu.tieba.channel.message.ChannelInfoGetHttpResponseMessage;
import com.baidu.tieba.channel.message.ChannelInfoGetSocketResponseMessage;
import com.baidu.tieba.channel.message.ChannelUpdatePushHttpResponseMessage;
import com.baidu.tieba.channel.message.ChannelVideoRemoveHttpResponseMessage;
import com.baidu.tieba.channel.message.ChannelVideoSetTopHttpResponseMessage;
import com.baidu.tieba.channel.message.ChannelVideoUnSetTopHttpResponseMessage;
import com.baidu.tieba.channel.model.ChannelHomeModel;
import com.baidu.tieba.channel.view.b;
import com.baidu.tieba.channel.view.i;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ChannelHomeActivity extends BaseActivity implements BdListView.e, b {
    private ChannelHomeModel eHA;
    private a eHB;
    private long eHC;
    private i eHz;
    private int eHD = -1;
    private boolean eHE = false;
    private d eHF = null;
    private int mPn = 1;
    private HttpMessageListener eHG = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eHF != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> baE = ChannelHomeActivity.this.eHF.baE();
                        if (hVar != null && baE != null) {
                            baE.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.eHz.h(ChannelHomeActivity.this.eHF);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private HttpMessageListener eHH = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eHF != null && ChannelHomeActivity.this.eHF.baD() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> baE = ChannelHomeActivity.this.eHF.baE();
                        if (hVar != null && baE != null) {
                            baE.remove(hVar);
                            baE.checkBigVideoType();
                            ChannelInfo baD = ChannelHomeActivity.this.eHF.baD();
                            if (ChannelHomeActivity.this.eHF.baD().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.eHF.baD().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            baD.setVideoCount(i);
                            ChannelHomeActivity.this.eHz.h(ChannelHomeActivity.this.eHF);
                            ChannelHomeActivity.this.eHz.f(ChannelHomeActivity.this.eHF);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private com.baidu.adp.framework.listener.a eHI = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.eHA.iL(false);
            ChannelHomeActivity.this.eHz.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.eHE) {
                            ChannelHomeActivity.this.eHz.BN();
                            ChannelHomeActivity.this.eHz.aKm();
                            return;
                        }
                        return;
                    }
                    d dVar = null;
                    if (responsedMessage instanceof ChannelInfoGetHttpResponseMessage) {
                        dVar = ((ChannelInfoGetHttpResponseMessage) responsedMessage).getData();
                    } else if (responsedMessage instanceof ChannelInfoGetSocketResponseMessage) {
                        dVar = ((ChannelInfoGetSocketResponseMessage) responsedMessage).getData();
                    }
                    if (dVar != null) {
                        if (ChannelHomeActivity.this.mPn != 1) {
                            if (ChannelHomeActivity.this.eHF != null) {
                                if (dVar.baB() != null) {
                                    ChannelHomeActivity.this.eHF.a(dVar.baB());
                                }
                                ChannelHomeActivity.this.eHF.b(dVar.baE());
                                ChannelHomeActivity.this.eHz.h(ChannelHomeActivity.this.eHF);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.eHF = dVar;
                        if (ChannelHomeActivity.this.eHC == 0 && dVar.baD() != null) {
                            ChannelHomeActivity.this.eHC = dVar.baD().getChannelId();
                        }
                        ChannelHomeActivity.this.eHz.g(dVar);
                        if (!ChannelHomeActivity.this.eHE) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.eHE = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener eHJ = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> baE = ChannelHomeActivity.this.eHF.baE();
                    if (baE != null) {
                        baE.unSetTop();
                        baE.checkBigVideoType();
                        ChannelHomeActivity.this.eHz.h(ChannelHomeActivity.this.eHF);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener eHK = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.bEk != null) {
                    if (aVar.bEj == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0240a) {
                        ChannelHomeActivity.this.b(aVar);
                    } else if (aVar instanceof a.c) {
                        ChannelHomeActivity.this.a(aVar);
                    } else if (aVar instanceof a.b) {
                        ChannelHomeActivity.this.a((a.b) aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener eHL = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.eHA.a(ChannelHomeActivity.this.eHC, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.eHF.a(channelInfo);
                    ChannelHomeActivity.this.eHz.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.eHz = new i(this);
        this.eHA = new ChannelHomeModel(this);
        this.eHB = new com.baidu.tieba.channel.b.a(this);
        bav();
        bay();
        this.eHA.a(this.eHC, this.mPn, 20);
        this.eHz.showLoadingView();
    }

    private void bay() {
        registerListener(2016511, this.eHL);
        registerListener(2016512, this.eHL);
    }

    private void bav() {
        registerListener(this.eHG);
        registerListener(this.eHH);
        registerListener(this.eHI);
        registerListener(this.eHJ);
        registerListener(this.eHK);
    }

    private void initData() {
        this.eHC = getIntent().getLongExtra("channel_id", 0L);
        this.eHD = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eHz.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eHz.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eHz.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eHz.onChangeSkinType(i);
        if (this.eHB != null) {
            this.eHB.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.channel.view.b
    public void a(int i, View view, Object obj, int i2) {
        switch (i) {
            case 1:
            case 2:
                if (obj != null && (obj instanceof h)) {
                    sendMessage(new CustomMessage(2004001, new PbActivityConfig(getActivity()).createNormalCfg(((h) obj).getThreadId() + "", null, null)));
                    return;
                }
                return;
            case 3:
            case 5:
                if (aMS() && this.eHF != null && this.eHF.baD() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0240a.a(this.eHF.baD().getChannelId(), getUniqueId())));
                    pL(4);
                    return;
                }
                return;
            case 4:
                finish();
                return;
            case 6:
                if (obj != null && (obj instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) obj;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), channelInfo.getUserId() + "", channelInfo.getUserName())));
                    pL(3);
                    return;
                }
                return;
            case 7:
            default:
                return;
            case 8:
            case 9:
                if (obj != null && (obj instanceof h)) {
                    com.baidu.tieba.channel.c.b.a(this, (h) obj, i2, this);
                    return;
                }
                return;
            case 10:
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.eHC)));
                pL(5);
                return;
            case 11:
                if (this.eHF != null && this.eHF.baD() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.eHF.baD())));
                    pL(3);
                    return;
                }
                return;
            case 12:
                if (this.eHF != null && this.eHF.baD() != null) {
                    this.eHF.baD().isPushOpen();
                    this.eHB.b(this.eHF);
                    this.eHB.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.eHF != null && this.eHF.baD() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eHA.b(this.eHF.baD().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.eHF != null && this.eHF.baD() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eHA.a(this.eHF.baD().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.eHF != null && this.eHF.baD() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eHA.c(this.eHF.baD().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.eHF != null && this.eHF.baD() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.eHF.baD().getChannelId(), getUniqueId())));
                    pL(5);
                    return;
                }
                return;
            case 18:
                if (this.eHF != null && this.eHF.baD() != null) {
                    long channelId = this.eHF.baD().getChannelId();
                    boolean isPushOpen = this.eHF.baD().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.bEl = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    pL(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.eHF != null && this.eHF.baD() != null) {
                    vI(this.eHF.baD().getChannelCover());
                    pL(1);
                    return;
                }
                return;
            case 20:
                if (this.eHF != null && this.eHF.baD() != null) {
                    vI(this.eHF.baD().getChannelAvatar());
                    pL(2);
                    return;
                }
                return;
            case 21:
                if (this.eHF != null && this.eHF.baD() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.eHC)));
                    if (this.eHF.isHost()) {
                        pL(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void vI(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.eHz.BO();
        this.eHz.showLoadingView();
        this.mPn = 1;
        this.eHA.a(this.eHC, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.bEk;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.eHF != null && this.eHF.baD() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.bEl) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(R.string.channel_need_push), 1).show();
                    } else {
                        showToast(R.string.success_open_channel_push);
                    }
                } else {
                    showToast(R.string.success_close_channel_push);
                }
                this.eHF.baD().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bEk;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eHF != null && this.eHF.baD() != null) {
            this.eHF.baD().setFansCount(this.eHF.baD().getFansCount() + (-1) > 0 ? this.eHF.baD().getFansCount() - 1 : 0);
            this.eHF.baD().setIsSubscribe(0);
            this.eHF.baD().setPushOpenOrClose(false);
            this.eHz.e(this.eHF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bEk;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eHF != null && this.eHF.baD() != null) {
            this.eHF.baD().setFansCount(this.eHF.baD().getFansCount() + 1);
            this.eHF.baD().setIsSubscribe(1);
            this.eHz.e(this.eHF);
            if (aVar.bEj == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.eHF.baD().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eHF != null && this.eHF.baF() && !this.eHA.baO()) {
            this.eHz.baW();
            this.mPn++;
            this.eHA.a(this.eHC, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new an("c11935").P("obj_type", dVar.isHost() ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.eHD).l(VideoPlayActivityConfig.OBJ_ID, dVar.baD().getChannelId()));
    }

    private void pL(int i) {
        if (this.eHF != null && this.eHF.baD() != null) {
            ChannelInfo baD = this.eHF.baD();
            an anVar = new an(this.eHF.isHost() ? "c11937" : "c11936");
            anVar.l(VideoPlayActivityConfig.OBJ_ID, baD.getChannelId());
            anVar.P("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    private boolean aMS() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 3)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 3:
                    this.eHz.showLoadingView();
                    this.mPn = 1;
                    this.eHA.a(this.eHC, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
