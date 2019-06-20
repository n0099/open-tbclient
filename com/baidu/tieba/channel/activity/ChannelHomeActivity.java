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
import com.baidu.tbadk.core.util.am;
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
    private i eCw;
    private ChannelHomeModel eCx;
    private a eCy;
    private long eCz;
    private int eCA = -1;
    private boolean eCB = false;
    private d eCC = null;
    private int mPn = 1;
    private HttpMessageListener eCD = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eCC != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> aYD = ChannelHomeActivity.this.eCC.aYD();
                        if (hVar != null && aYD != null) {
                            aYD.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.eCw.h(ChannelHomeActivity.this.eCC);
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
    private HttpMessageListener eCE = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eCC != null && ChannelHomeActivity.this.eCC.aYC() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> aYD = ChannelHomeActivity.this.eCC.aYD();
                        if (hVar != null && aYD != null) {
                            aYD.remove(hVar);
                            aYD.checkBigVideoType();
                            ChannelInfo aYC = ChannelHomeActivity.this.eCC.aYC();
                            if (ChannelHomeActivity.this.eCC.aYC().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.eCC.aYC().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            aYC.setVideoCount(i);
                            ChannelHomeActivity.this.eCw.h(ChannelHomeActivity.this.eCC);
                            ChannelHomeActivity.this.eCw.f(ChannelHomeActivity.this.eCC);
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
    private com.baidu.adp.framework.listener.a eCF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.eCx.iC(false);
            ChannelHomeActivity.this.eCw.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.eCB) {
                            ChannelHomeActivity.this.eCw.Bf();
                            ChannelHomeActivity.this.eCw.aIJ();
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
                            if (ChannelHomeActivity.this.eCC != null) {
                                if (dVar.aYA() != null) {
                                    ChannelHomeActivity.this.eCC.a(dVar.aYA());
                                }
                                ChannelHomeActivity.this.eCC.b(dVar.aYD());
                                ChannelHomeActivity.this.eCw.h(ChannelHomeActivity.this.eCC);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.eCC = dVar;
                        if (ChannelHomeActivity.this.eCz == 0 && dVar.aYC() != null) {
                            ChannelHomeActivity.this.eCz = dVar.aYC().getChannelId();
                        }
                        ChannelHomeActivity.this.eCw.g(dVar);
                        if (!ChannelHomeActivity.this.eCB) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.eCB = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener eCG = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> aYD = ChannelHomeActivity.this.eCC.aYD();
                    if (aYD != null) {
                        aYD.unSetTop();
                        aYD.checkBigVideoType();
                        ChannelHomeActivity.this.eCw.h(ChannelHomeActivity.this.eCC);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener eCH = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.bDm != null) {
                    if (aVar.bDl == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0238a) {
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
    private CustomMessageListener eCI = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.eCx.a(ChannelHomeActivity.this.eCz, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.eCC.a(channelInfo);
                    ChannelHomeActivity.this.eCw.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.eCw = new i(this);
        this.eCx = new ChannelHomeModel(this);
        this.eCy = new com.baidu.tieba.channel.b.a(this);
        aYu();
        aYx();
        this.eCx.a(this.eCz, this.mPn, 20);
        this.eCw.showLoadingView();
    }

    private void aYx() {
        registerListener(2016511, this.eCI);
        registerListener(2016512, this.eCI);
    }

    private void aYu() {
        registerListener(this.eCD);
        registerListener(this.eCE);
        registerListener(this.eCF);
        registerListener(this.eCG);
        registerListener(this.eCH);
    }

    private void initData() {
        this.eCz = getIntent().getLongExtra("channel_id", 0L);
        this.eCA = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eCw.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eCw.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eCw.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eCw.onChangeSkinType(i);
        if (this.eCy != null) {
            this.eCy.onChangeSkinType(i);
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
                if (aLl() && this.eCC != null && this.eCC.aYC() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0238a.a(this.eCC.aYC().getChannelId(), getUniqueId())));
                    pu(4);
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
                    pu(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.eCz)));
                pu(5);
                return;
            case 11:
                if (this.eCC != null && this.eCC.aYC() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.eCC.aYC())));
                    pu(3);
                    return;
                }
                return;
            case 12:
                if (this.eCC != null && this.eCC.aYC() != null) {
                    this.eCC.aYC().isPushOpen();
                    this.eCy.b(this.eCC);
                    this.eCy.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.eCC != null && this.eCC.aYC() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eCx.b(this.eCC.aYC().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.eCC != null && this.eCC.aYC() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eCx.a(this.eCC.aYC().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.eCC != null && this.eCC.aYC() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eCx.c(this.eCC.aYC().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.eCC != null && this.eCC.aYC() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.eCC.aYC().getChannelId(), getUniqueId())));
                    pu(5);
                    return;
                }
                return;
            case 18:
                if (this.eCC != null && this.eCC.aYC() != null) {
                    long channelId = this.eCC.aYC().getChannelId();
                    boolean isPushOpen = this.eCC.aYC().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.bDn = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    pu(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.eCC != null && this.eCC.aYC() != null) {
                    vc(this.eCC.aYC().getChannelCover());
                    pu(1);
                    return;
                }
                return;
            case 20:
                if (this.eCC != null && this.eCC.aYC() != null) {
                    vc(this.eCC.aYC().getChannelAvatar());
                    pu(2);
                    return;
                }
                return;
            case 21:
                if (this.eCC != null && this.eCC.aYC() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.eCz)));
                    if (this.eCC.isHost()) {
                        pu(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void vc(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.eCw.Bg();
        this.eCw.showLoadingView();
        this.mPn = 1;
        this.eCx.a(this.eCz, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.bDm;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.eCC != null && this.eCC.aYC() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.bDn) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(R.string.channel_need_push), 1).show();
                    } else {
                        showToast(R.string.success_open_channel_push);
                    }
                } else {
                    showToast(R.string.success_close_channel_push);
                }
                this.eCC.aYC().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bDm;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eCC != null && this.eCC.aYC() != null) {
            this.eCC.aYC().setFansCount(this.eCC.aYC().getFansCount() + (-1) > 0 ? this.eCC.aYC().getFansCount() - 1 : 0);
            this.eCC.aYC().setIsSubscribe(0);
            this.eCC.aYC().setPushOpenOrClose(false);
            this.eCw.e(this.eCC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bDm;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eCC != null && this.eCC.aYC() != null) {
            this.eCC.aYC().setFansCount(this.eCC.aYC().getFansCount() + 1);
            this.eCC.aYC().setIsSubscribe(1);
            this.eCw.e(this.eCC);
            if (aVar.bDl == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.eCC.aYC().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eCC != null && this.eCC.aYE() && !this.eCx.aYN()) {
            this.eCw.aYV();
            this.mPn++;
            this.eCx.a(this.eCz, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new am("c11935").P("obj_type", dVar.isHost() ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.eCA).l(VideoPlayActivityConfig.OBJ_ID, dVar.aYC().getChannelId()));
    }

    private void pu(int i) {
        if (this.eCC != null && this.eCC.aYC() != null) {
            ChannelInfo aYC = this.eCC.aYC();
            am amVar = new am(this.eCC.isHost() ? "c11937" : "c11936");
            amVar.l(VideoPlayActivityConfig.OBJ_ID, aYC.getChannelId());
            amVar.P("obj_locate", i);
            TiebaStatic.log(amVar);
        }
    }

    private boolean aLl() {
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
                    this.eCw.showLoadingView();
                    this.mPn = 1;
                    this.eCx.a(this.eCz, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
