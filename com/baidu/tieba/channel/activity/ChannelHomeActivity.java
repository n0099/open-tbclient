package com.baidu.tieba.channel.activity;

import android.content.Context;
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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ChannelHomeActivity extends BaseActivity implements BdListView.e, b {
    private i cDc;
    private ChannelHomeModel cDd;
    private a cDe;
    private long cDf;
    private int cDg = -1;
    private boolean cDh = false;
    private d cDi = null;
    private int mPn = 1;
    private HttpMessageListener cDj = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cDi != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> ajS = ChannelHomeActivity.this.cDi.ajS();
                        if (hVar != null && ajS != null) {
                            ajS.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.cDc.h(ChannelHomeActivity.this.cDi);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private HttpMessageListener cDk = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cDi != null && ChannelHomeActivity.this.cDi.ajR() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> ajS = ChannelHomeActivity.this.cDi.ajS();
                        if (hVar != null && ajS != null) {
                            ajS.remove(hVar);
                            ajS.checkBigVideoType();
                            ChannelInfo ajR = ChannelHomeActivity.this.cDi.ajR();
                            if (ChannelHomeActivity.this.cDi.ajR().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.cDi.ajR().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            ajR.setVideoCount(i);
                            ChannelHomeActivity.this.cDc.h(ChannelHomeActivity.this.cDi);
                            ChannelHomeActivity.this.cDc.f(ChannelHomeActivity.this.cDi);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private com.baidu.adp.framework.listener.a cDl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.cDd.eE(false);
            ChannelHomeActivity.this.cDc.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.k.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.cDh) {
                            ChannelHomeActivity.this.cDc.showErrorView();
                            ChannelHomeActivity.this.cDc.TL();
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.channel.data.d dVar = null;
                    if (responsedMessage instanceof ChannelInfoGetHttpResponseMessage) {
                        dVar = ((ChannelInfoGetHttpResponseMessage) responsedMessage).getData();
                    } else if (responsedMessage instanceof ChannelInfoGetSocketResponseMessage) {
                        dVar = ((ChannelInfoGetSocketResponseMessage) responsedMessage).getData();
                    }
                    if (dVar != null) {
                        if (ChannelHomeActivity.this.mPn != 1) {
                            if (ChannelHomeActivity.this.cDi != null) {
                                if (dVar.ajP() != null) {
                                    ChannelHomeActivity.this.cDi.a(dVar.ajP());
                                }
                                ChannelHomeActivity.this.cDi.b(dVar.ajS());
                                ChannelHomeActivity.this.cDc.h(ChannelHomeActivity.this.cDi);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.cDi = dVar;
                        if (ChannelHomeActivity.this.cDf == 0 && dVar.ajR() != null) {
                            ChannelHomeActivity.this.cDf = dVar.ajR().getChannelId();
                        }
                        ChannelHomeActivity.this.cDc.g(dVar);
                        if (!ChannelHomeActivity.this.cDh) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.cDh = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener cDm = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> ajS = ChannelHomeActivity.this.cDi.ajS();
                    if (ajS != null) {
                        ajS.unSetTop();
                        ajS.checkBigVideoType();
                        ChannelHomeActivity.this.cDc.h(ChannelHomeActivity.this.cDi);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener cDn = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.adb != null) {
                    if (aVar.ada == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0101a) {
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
    private CustomMessageListener cDo = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.cDd.a(ChannelHomeActivity.this.cDf, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.cDi.a(channelInfo);
                    ChannelHomeActivity.this.cDc.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.cDc = new i(this);
        this.cDd = new ChannelHomeModel(this);
        this.cDe = new com.baidu.tieba.channel.b.a(this);
        ajI();
        ajL();
        this.cDd.a(this.cDf, this.mPn, 20);
        this.cDc.showLoadingView();
    }

    private void ajL() {
        registerListener(2016511, this.cDo);
        registerListener(2016512, this.cDo);
    }

    private void ajI() {
        registerListener(this.cDj);
        registerListener(this.cDk);
        registerListener(this.cDl);
        registerListener(this.cDm);
        registerListener(this.cDn);
    }

    private void initData() {
        this.cDf = getIntent().getLongExtra("channel_id", 0L);
        this.cDg = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cDc.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cDc.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cDc.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cDc.onChangeSkinType(i);
        if (this.cDe != null) {
            this.cDe.onChangeSkinType(i);
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
                if (Wr() && this.cDi != null && this.cDi.ajR() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0101a.a(this.cDi.ajR().getChannelId(), getUniqueId())));
                    iP(4);
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
                    iP(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.cDf)));
                iP(5);
                return;
            case 11:
                if (this.cDi != null && this.cDi.ajR() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.cDi.ajR())));
                    iP(3);
                    return;
                }
                return;
            case 12:
                if (this.cDi != null && this.cDi.ajR() != null) {
                    this.cDi.ajR().isPushOpen();
                    this.cDe.b(this.cDi);
                    this.cDe.ajM();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.cDi != null && this.cDi.ajR() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.cDd.b(this.cDi.ajR().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.cDi != null && this.cDi.ajR() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.cDd.a(this.cDi.ajR().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.cDi != null && this.cDi.ajR() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.cDd.c(this.cDi.ajR().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.cDi != null && this.cDi.ajR() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.cDi.ajR().getChannelId(), getUniqueId())));
                    iP(5);
                    return;
                }
                return;
            case 18:
                if (this.cDi != null && this.cDi.ajR() != null) {
                    long channelId = this.cDi.ajR().getChannelId();
                    boolean isPushOpen = this.cDi.ajR().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.adc = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    iP(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.cDi != null && this.cDi.ajR() != null) {
                    lo(this.cDi.ajR().getChannelCover());
                    iP(1);
                    return;
                }
                return;
            case 20:
                if (this.cDi != null && this.cDi.ajR() != null) {
                    lo(this.cDi.ajR().getChannelAvatar());
                    iP(2);
                    return;
                }
                return;
            case 21:
                if (this.cDi != null && this.cDi.ajR() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.cDf)));
                    if (this.cDi.isHost()) {
                        iP(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void lo(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.cDc.akn();
        this.cDc.showLoadingView();
        this.mPn = 1;
        this.cDd.a(this.cDf, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.adb;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.cDi != null && this.cDi.ajR() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.adc) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(d.k.channel_need_push), 1).show();
                    } else {
                        showToast(d.k.success_open_channel_push);
                    }
                } else {
                    showToast(d.k.success_close_channel_push);
                }
                this.cDi.ajR().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.adb;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cDi != null && this.cDi.ajR() != null) {
            this.cDi.ajR().setFansCount(this.cDi.ajR().getFansCount() + (-1) > 0 ? this.cDi.ajR().getFansCount() - 1 : 0);
            this.cDi.ajR().setIsSubscribe(0);
            this.cDi.ajR().setPushOpenOrClose(false);
            this.cDc.e(this.cDi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.adb;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cDi != null && this.cDi.ajR() != null) {
            this.cDi.ajR().setFansCount(this.cDi.ajR().getFansCount() + 1);
            this.cDi.ajR().setIsSubscribe(1);
            this.cDc.e(this.cDi);
            if (aVar.ada == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.cDi.ajR().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cDi != null && this.cDi.ajT() && !this.cDd.akc()) {
            this.cDc.akm();
            this.mPn++;
            this.cDd.a(this.cDf, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.channel.data.d dVar) {
        TiebaStatic.logPagePV(new am("c11935").r("obj_type", dVar.isHost() ? 1 : 2).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.cDg).f(VideoPlayActivityConfig.OBJ_ID, dVar.ajR().getChannelId()));
    }

    private void iP(int i) {
        if (this.cDi != null && this.cDi.ajR() != null) {
            ChannelInfo ajR = this.cDi.ajR();
            am amVar = new am(this.cDi.isHost() ? "c11937" : "c11936");
            amVar.f(VideoPlayActivityConfig.OBJ_ID, ajR.getChannelId());
            amVar.r("obj_locate", i);
            TiebaStatic.log(amVar);
        }
    }

    private boolean Wr() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, 3)));
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
                    this.cDc.showLoadingView();
                    this.mPn = 1;
                    this.cDd.a(this.cDf, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
