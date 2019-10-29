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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelAddVideoActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelFansActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.b.a;
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
    private i eRN;
    private ChannelHomeModel eRO;
    private a eRP;
    private long eRQ;
    private int eRR = -1;
    private boolean eRS = false;
    private d eRT = null;
    private int mPn = 1;
    private HttpMessageListener eRU = new HttpMessageListener(1003305) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eRT != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> bbm = ChannelHomeActivity.this.eRT.bbm();
                        if (hVar != null && bbm != null) {
                            bbm.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.eRN.h(ChannelHomeActivity.this.eRT);
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
    private HttpMessageListener eRV = new HttpMessageListener(1003306) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eRT != null && ChannelHomeActivity.this.eRT.bbl() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> bbm = ChannelHomeActivity.this.eRT.bbm();
                        if (hVar != null && bbm != null) {
                            bbm.remove(hVar);
                            bbm.checkBigVideoType();
                            ChannelInfo bbl = ChannelHomeActivity.this.eRT.bbl();
                            if (ChannelHomeActivity.this.eRT.bbl().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.eRT.bbl().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            bbl.setVideoCount(i);
                            ChannelHomeActivity.this.eRN.h(ChannelHomeActivity.this.eRT);
                            ChannelHomeActivity.this.eRN.f(ChannelHomeActivity.this.eRT);
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
    private com.baidu.adp.framework.listener.a eRW = new com.baidu.adp.framework.listener.a(1003307, CmdConfigSocket.CMD_CHANNEL_GET_INFO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.eRO.iR(false);
            ChannelHomeActivity.this.eRN.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.eRS) {
                            ChannelHomeActivity.this.eRN.GL();
                            ChannelHomeActivity.this.eRN.aKk();
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
                            if (ChannelHomeActivity.this.eRT != null) {
                                if (dVar.bbj() != null) {
                                    ChannelHomeActivity.this.eRT.a(dVar.bbj());
                                }
                                ChannelHomeActivity.this.eRT.b(dVar.bbm());
                                ChannelHomeActivity.this.eRN.h(ChannelHomeActivity.this.eRT);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.eRT = dVar;
                        if (ChannelHomeActivity.this.eRQ == 0 && dVar.bbl() != null) {
                            ChannelHomeActivity.this.eRQ = dVar.bbl().getChannelId();
                        }
                        ChannelHomeActivity.this.eRN.g(dVar);
                        if (!ChannelHomeActivity.this.eRS) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.eRS = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener eRX = new HttpMessageListener(1003308) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> bbm = ChannelHomeActivity.this.eRT.bbm();
                    if (bbm != null) {
                        bbm.unSetTop();
                        bbm.checkBigVideoType();
                        ChannelHomeActivity.this.eRN.h(ChannelHomeActivity.this.eRT);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener eRY = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.bWz != null) {
                    if (aVar.bWy == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0281a) {
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
    private CustomMessageListener eRZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.eRO.a(ChannelHomeActivity.this.eRQ, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.eRT.a(channelInfo);
                    ChannelHomeActivity.this.eRN.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.eRN = new i(this);
        this.eRO = new ChannelHomeModel(this);
        this.eRP = new com.baidu.tieba.channel.b.a(this);
        bbb();
        bbe();
        this.eRO.a(this.eRQ, this.mPn, 20);
        this.eRN.showLoadingView();
    }

    private void bbe() {
        registerListener(CmdConfigCustom.CMD_CHANNEL_HOME_ADD_VIDEO, this.eRZ);
        registerListener(CmdConfigCustom.CMD_CHANNEL_HOME_INFO_UPDATE, this.eRZ);
    }

    private void bbb() {
        registerListener(this.eRU);
        registerListener(this.eRV);
        registerListener(this.eRW);
        registerListener(this.eRX);
        registerListener(this.eRY);
    }

    private void initData() {
        this.eRQ = getIntent().getLongExtra("channel_id", 0L);
        this.eRR = getIntent().getIntExtra("obj_source", -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eRN.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eRN.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eRN.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eRN.onChangeSkinType(i);
        if (this.eRP != null) {
            this.eRP.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.channel.view.b
    public void a(int i, View view, Object obj, int i2) {
        switch (i) {
            case 1:
            case 2:
                if (obj != null && (obj instanceof h)) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getActivity()).createNormalCfg(((h) obj).getThreadId() + "", null, null)));
                    return;
                }
                return;
            case 3:
            case 5:
                if (rA() && this.eRT != null && this.eRT.bbl() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0281a.a(this.eRT.bbl().getChannelId(), getUniqueId())));
                    oR(4);
                    return;
                }
                return;
            case 4:
                finish();
                return;
            case 6:
                if (obj != null && (obj instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) obj;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), channelInfo.getUserId() + "", channelInfo.getUserName())));
                    oR(3);
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
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelAddVideoActivityConfig(getBaseContext(), this.eRQ)));
                oR(5);
                return;
            case 11:
                if (this.eRT != null && this.eRT.bbl() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.eRT.bbl())));
                    oR(3);
                    return;
                }
                return;
            case 12:
                if (this.eRT != null && this.eRT.bbl() != null) {
                    this.eRT.bbl().isPushOpen();
                    this.eRP.b(this.eRT);
                    this.eRP.bbf();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.eRT != null && this.eRT.bbl() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eRO.b(this.eRT.bbl().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.eRT != null && this.eRT.bbl() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eRO.a(this.eRT.bbl().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.eRT != null && this.eRT.bbl() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eRO.c(this.eRT.bbl().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.eRT != null && this.eRT.bbl() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.c.b(this.eRT.bbl().getChannelId(), getUniqueId())));
                    oR(5);
                    return;
                }
                return;
            case 18:
                if (this.eRT != null && this.eRT.bbl() != null) {
                    long channelId = this.eRT.bbl().getChannelId();
                    boolean isPushOpen = this.eRT.bbl().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.bWA = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a));
                    oR(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.eRT != null && this.eRT.bbl() != null) {
                    uJ(this.eRT.bbl().getChannelCover());
                    oR(1);
                    return;
                }
                return;
            case 20:
                if (this.eRT != null && this.eRT.bbl() != null) {
                    uJ(this.eRT.bbl().getChannelAvatar());
                    oR(2);
                    return;
                }
                return;
            case 21:
                if (this.eRT != null && this.eRT.bbl() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelFansActivityConfig(getBaseContext(), this.eRQ)));
                    if (this.eRT.isHost()) {
                        oR(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void uJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.eRN.GM();
        this.eRN.showLoadingView();
        this.mPn = 1;
        this.eRO.a(this.eRQ, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.bWz;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.eRT != null && this.eRT.bbl() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.bWA) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(R.string.channel_need_push), 1).show();
                    } else {
                        showToast(R.string.success_open_channel_push);
                    }
                } else {
                    showToast(R.string.success_close_channel_push);
                }
                this.eRT.bbl().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bWz;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eRT != null && this.eRT.bbl() != null) {
            this.eRT.bbl().setFansCount(this.eRT.bbl().getFansCount() + (-1) > 0 ? this.eRT.bbl().getFansCount() - 1 : 0);
            this.eRT.bbl().setIsSubscribe(0);
            this.eRT.bbl().setPushOpenOrClose(false);
            this.eRN.e(this.eRT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bWz;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eRT != null && this.eRT.bbl() != null) {
            this.eRT.bbl().setFansCount(this.eRT.bbl().getFansCount() + 1);
            this.eRT.bbl().setIsSubscribe(1);
            this.eRN.e(this.eRT);
            if (aVar.bWy == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.eRT.bbl().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eRT != null && this.eRT.bbn() && !this.eRO.bbw()) {
            this.eRN.bbF();
            this.mPn++;
            this.eRO.a(this.eRQ, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new an("c11935").O("obj_type", dVar.isHost() ? 1 : 2).O("obj_source", this.eRR).p("obj_id", dVar.bbl().getChannelId()));
    }

    private void oR(int i) {
        if (this.eRT != null && this.eRT.bbl() != null) {
            ChannelInfo bbl = this.eRT.bbl();
            an anVar = new an(this.eRT.isHost() ? "c11937" : "c11936");
            anVar.p("obj_id", bbl.getChannelId());
            anVar.O("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    private boolean rA() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 3)));
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
                    this.eRN.showLoadingView();
                    this.mPn = 1;
                    this.eRO.a(this.eRQ, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
