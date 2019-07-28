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
    private i eHs;
    private ChannelHomeModel eHt;
    private a eHu;
    private long eHv;
    private int eHw = -1;
    private boolean eHx = false;
    private d eHy = null;
    private int mPn = 1;
    private HttpMessageListener eHz = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eHy != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> baC = ChannelHomeActivity.this.eHy.baC();
                        if (hVar != null && baC != null) {
                            baC.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.eHs.h(ChannelHomeActivity.this.eHy);
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
    private HttpMessageListener eHA = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eHy != null && ChannelHomeActivity.this.eHy.baB() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> baC = ChannelHomeActivity.this.eHy.baC();
                        if (hVar != null && baC != null) {
                            baC.remove(hVar);
                            baC.checkBigVideoType();
                            ChannelInfo baB = ChannelHomeActivity.this.eHy.baB();
                            if (ChannelHomeActivity.this.eHy.baB().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.eHy.baB().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            baB.setVideoCount(i);
                            ChannelHomeActivity.this.eHs.h(ChannelHomeActivity.this.eHy);
                            ChannelHomeActivity.this.eHs.f(ChannelHomeActivity.this.eHy);
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
    private com.baidu.adp.framework.listener.a eHB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.eHt.iL(false);
            ChannelHomeActivity.this.eHs.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.eHx) {
                            ChannelHomeActivity.this.eHs.BN();
                            ChannelHomeActivity.this.eHs.aKk();
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
                            if (ChannelHomeActivity.this.eHy != null) {
                                if (dVar.baz() != null) {
                                    ChannelHomeActivity.this.eHy.a(dVar.baz());
                                }
                                ChannelHomeActivity.this.eHy.b(dVar.baC());
                                ChannelHomeActivity.this.eHs.h(ChannelHomeActivity.this.eHy);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.eHy = dVar;
                        if (ChannelHomeActivity.this.eHv == 0 && dVar.baB() != null) {
                            ChannelHomeActivity.this.eHv = dVar.baB().getChannelId();
                        }
                        ChannelHomeActivity.this.eHs.g(dVar);
                        if (!ChannelHomeActivity.this.eHx) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.eHx = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener eHC = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> baC = ChannelHomeActivity.this.eHy.baC();
                    if (baC != null) {
                        baC.unSetTop();
                        baC.checkBigVideoType();
                        ChannelHomeActivity.this.eHs.h(ChannelHomeActivity.this.eHy);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener eHD = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.bEj != null) {
                    if (aVar.bEi == ChannelHomeActivity.this.getUniqueId()) {
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
    private CustomMessageListener eHE = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.eHt.a(ChannelHomeActivity.this.eHv, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.eHy.a(channelInfo);
                    ChannelHomeActivity.this.eHs.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.eHs = new i(this);
        this.eHt = new ChannelHomeModel(this);
        this.eHu = new com.baidu.tieba.channel.b.a(this);
        bat();
        baw();
        this.eHt.a(this.eHv, this.mPn, 20);
        this.eHs.showLoadingView();
    }

    private void baw() {
        registerListener(2016511, this.eHE);
        registerListener(2016512, this.eHE);
    }

    private void bat() {
        registerListener(this.eHz);
        registerListener(this.eHA);
        registerListener(this.eHB);
        registerListener(this.eHC);
        registerListener(this.eHD);
    }

    private void initData() {
        this.eHv = getIntent().getLongExtra("channel_id", 0L);
        this.eHw = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eHs.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eHs.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eHs.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eHs.onChangeSkinType(i);
        if (this.eHu != null) {
            this.eHu.onChangeSkinType(i);
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
                if (aMQ() && this.eHy != null && this.eHy.baB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0240a.a(this.eHy.baB().getChannelId(), getUniqueId())));
                    pK(4);
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
                    pK(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.eHv)));
                pK(5);
                return;
            case 11:
                if (this.eHy != null && this.eHy.baB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.eHy.baB())));
                    pK(3);
                    return;
                }
                return;
            case 12:
                if (this.eHy != null && this.eHy.baB() != null) {
                    this.eHy.baB().isPushOpen();
                    this.eHu.b(this.eHy);
                    this.eHu.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.eHy != null && this.eHy.baB() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eHt.b(this.eHy.baB().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.eHy != null && this.eHy.baB() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eHt.a(this.eHy.baB().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.eHy != null && this.eHy.baB() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eHt.c(this.eHy.baB().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.eHy != null && this.eHy.baB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.eHy.baB().getChannelId(), getUniqueId())));
                    pK(5);
                    return;
                }
                return;
            case 18:
                if (this.eHy != null && this.eHy.baB() != null) {
                    long channelId = this.eHy.baB().getChannelId();
                    boolean isPushOpen = this.eHy.baB().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.bEk = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    pK(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.eHy != null && this.eHy.baB() != null) {
                    vH(this.eHy.baB().getChannelCover());
                    pK(1);
                    return;
                }
                return;
            case 20:
                if (this.eHy != null && this.eHy.baB() != null) {
                    vH(this.eHy.baB().getChannelAvatar());
                    pK(2);
                    return;
                }
                return;
            case 21:
                if (this.eHy != null && this.eHy.baB() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.eHv)));
                    if (this.eHy.isHost()) {
                        pK(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void vH(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.eHs.BO();
        this.eHs.showLoadingView();
        this.mPn = 1;
        this.eHt.a(this.eHv, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.bEj;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.eHy != null && this.eHy.baB() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.bEk) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(R.string.channel_need_push), 1).show();
                    } else {
                        showToast(R.string.success_open_channel_push);
                    }
                } else {
                    showToast(R.string.success_close_channel_push);
                }
                this.eHy.baB().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bEj;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eHy != null && this.eHy.baB() != null) {
            this.eHy.baB().setFansCount(this.eHy.baB().getFansCount() + (-1) > 0 ? this.eHy.baB().getFansCount() - 1 : 0);
            this.eHy.baB().setIsSubscribe(0);
            this.eHy.baB().setPushOpenOrClose(false);
            this.eHs.e(this.eHy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bEj;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eHy != null && this.eHy.baB() != null) {
            this.eHy.baB().setFansCount(this.eHy.baB().getFansCount() + 1);
            this.eHy.baB().setIsSubscribe(1);
            this.eHs.e(this.eHy);
            if (aVar.bEi == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.eHy.baB().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eHy != null && this.eHy.baD() && !this.eHt.baM()) {
            this.eHs.baU();
            this.mPn++;
            this.eHt.a(this.eHv, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new an("c11935").P("obj_type", dVar.isHost() ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.eHw).l(VideoPlayActivityConfig.OBJ_ID, dVar.baB().getChannelId()));
    }

    private void pK(int i) {
        if (this.eHy != null && this.eHy.baB() != null) {
            ChannelInfo baB = this.eHy.baB();
            an anVar = new an(this.eHy.isHost() ? "c11937" : "c11936");
            anVar.l(VideoPlayActivityConfig.OBJ_ID, baB.getChannelId());
            anVar.P("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    private boolean aMQ() {
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
                    this.eHs.showLoadingView();
                    this.mPn = 1;
                    this.eHt.a(this.eHv, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
