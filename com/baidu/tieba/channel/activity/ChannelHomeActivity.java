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
    private i eQW;
    private ChannelHomeModel eQX;
    private a eQY;
    private long eQZ;
    private int eRa = -1;
    private boolean eRb = false;
    private d eRc = null;
    private int mPn = 1;
    private HttpMessageListener eRd = new HttpMessageListener(1003305) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eRc != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> bbk = ChannelHomeActivity.this.eRc.bbk();
                        if (hVar != null && bbk != null) {
                            bbk.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.eQW.h(ChannelHomeActivity.this.eRc);
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
    private HttpMessageListener eRe = new HttpMessageListener(1003306) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eRc != null && ChannelHomeActivity.this.eRc.bbj() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> bbk = ChannelHomeActivity.this.eRc.bbk();
                        if (hVar != null && bbk != null) {
                            bbk.remove(hVar);
                            bbk.checkBigVideoType();
                            ChannelInfo bbj = ChannelHomeActivity.this.eRc.bbj();
                            if (ChannelHomeActivity.this.eRc.bbj().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.eRc.bbj().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            bbj.setVideoCount(i);
                            ChannelHomeActivity.this.eQW.h(ChannelHomeActivity.this.eRc);
                            ChannelHomeActivity.this.eQW.f(ChannelHomeActivity.this.eRc);
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
    private com.baidu.adp.framework.listener.a eRf = new com.baidu.adp.framework.listener.a(1003307, CmdConfigSocket.CMD_CHANNEL_GET_INFO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.eQX.iR(false);
            ChannelHomeActivity.this.eQW.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.eRb) {
                            ChannelHomeActivity.this.eQW.GM();
                            ChannelHomeActivity.this.eQW.aKi();
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
                            if (ChannelHomeActivity.this.eRc != null) {
                                if (dVar.bbh() != null) {
                                    ChannelHomeActivity.this.eRc.a(dVar.bbh());
                                }
                                ChannelHomeActivity.this.eRc.b(dVar.bbk());
                                ChannelHomeActivity.this.eQW.h(ChannelHomeActivity.this.eRc);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.eRc = dVar;
                        if (ChannelHomeActivity.this.eQZ == 0 && dVar.bbj() != null) {
                            ChannelHomeActivity.this.eQZ = dVar.bbj().getChannelId();
                        }
                        ChannelHomeActivity.this.eQW.g(dVar);
                        if (!ChannelHomeActivity.this.eRb) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.eRb = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener eRg = new HttpMessageListener(1003308) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> bbk = ChannelHomeActivity.this.eRc.bbk();
                    if (bbk != null) {
                        bbk.unSetTop();
                        bbk.checkBigVideoType();
                        ChannelHomeActivity.this.eQW.h(ChannelHomeActivity.this.eRc);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener eRh = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.bVI != null) {
                    if (aVar.bVH == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0276a) {
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
    private CustomMessageListener eRi = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.eQX.a(ChannelHomeActivity.this.eQZ, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.eRc.a(channelInfo);
                    ChannelHomeActivity.this.eQW.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.eQW = new i(this);
        this.eQX = new ChannelHomeModel(this);
        this.eQY = new com.baidu.tieba.channel.b.a(this);
        baZ();
        bbc();
        this.eQX.a(this.eQZ, this.mPn, 20);
        this.eQW.showLoadingView();
    }

    private void bbc() {
        registerListener(CmdConfigCustom.CMD_CHANNEL_HOME_ADD_VIDEO, this.eRi);
        registerListener(CmdConfigCustom.CMD_CHANNEL_HOME_INFO_UPDATE, this.eRi);
    }

    private void baZ() {
        registerListener(this.eRd);
        registerListener(this.eRe);
        registerListener(this.eRf);
        registerListener(this.eRg);
        registerListener(this.eRh);
    }

    private void initData() {
        this.eQZ = getIntent().getLongExtra("channel_id", 0L);
        this.eRa = getIntent().getIntExtra("obj_source", -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eQW.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eQW.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eQW.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eQW.onChangeSkinType(i);
        if (this.eQY != null) {
            this.eQY.onChangeSkinType(i);
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
                if (rB() && this.eRc != null && this.eRc.bbj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0276a.a(this.eRc.bbj().getChannelId(), getUniqueId())));
                    oQ(4);
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
                    oQ(3);
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
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelAddVideoActivityConfig(getBaseContext(), this.eQZ)));
                oQ(5);
                return;
            case 11:
                if (this.eRc != null && this.eRc.bbj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.eRc.bbj())));
                    oQ(3);
                    return;
                }
                return;
            case 12:
                if (this.eRc != null && this.eRc.bbj() != null) {
                    this.eRc.bbj().isPushOpen();
                    this.eQY.b(this.eRc);
                    this.eQY.bbd();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.eRc != null && this.eRc.bbj() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eQX.b(this.eRc.bbj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.eRc != null && this.eRc.bbj() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eQX.a(this.eRc.bbj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.eRc != null && this.eRc.bbj() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eQX.c(this.eRc.bbj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.eRc != null && this.eRc.bbj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.c.b(this.eRc.bbj().getChannelId(), getUniqueId())));
                    oQ(5);
                    return;
                }
                return;
            case 18:
                if (this.eRc != null && this.eRc.bbj() != null) {
                    long channelId = this.eRc.bbj().getChannelId();
                    boolean isPushOpen = this.eRc.bbj().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.bVJ = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a));
                    oQ(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.eRc != null && this.eRc.bbj() != null) {
                    uJ(this.eRc.bbj().getChannelCover());
                    oQ(1);
                    return;
                }
                return;
            case 20:
                if (this.eRc != null && this.eRc.bbj() != null) {
                    uJ(this.eRc.bbj().getChannelAvatar());
                    oQ(2);
                    return;
                }
                return;
            case 21:
                if (this.eRc != null && this.eRc.bbj() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelFansActivityConfig(getBaseContext(), this.eQZ)));
                    if (this.eRc.isHost()) {
                        oQ(4);
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
        this.eQW.GN();
        this.eQW.showLoadingView();
        this.mPn = 1;
        this.eQX.a(this.eQZ, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.bVI;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.eRc != null && this.eRc.bbj() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.bVJ) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(R.string.channel_need_push), 1).show();
                    } else {
                        showToast(R.string.success_open_channel_push);
                    }
                } else {
                    showToast(R.string.success_close_channel_push);
                }
                this.eRc.bbj().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bVI;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eRc != null && this.eRc.bbj() != null) {
            this.eRc.bbj().setFansCount(this.eRc.bbj().getFansCount() + (-1) > 0 ? this.eRc.bbj().getFansCount() - 1 : 0);
            this.eRc.bbj().setIsSubscribe(0);
            this.eRc.bbj().setPushOpenOrClose(false);
            this.eQW.e(this.eRc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bVI;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eRc != null && this.eRc.bbj() != null) {
            this.eRc.bbj().setFansCount(this.eRc.bbj().getFansCount() + 1);
            this.eRc.bbj().setIsSubscribe(1);
            this.eQW.e(this.eRc);
            if (aVar.bVH == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.eRc.bbj().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eRc != null && this.eRc.bbl() && !this.eQX.bbu()) {
            this.eQW.bbD();
            this.mPn++;
            this.eQX.a(this.eQZ, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new an("c11935").O("obj_type", dVar.isHost() ? 1 : 2).O("obj_source", this.eRa).p("obj_id", dVar.bbj().getChannelId()));
    }

    private void oQ(int i) {
        if (this.eRc != null && this.eRc.bbj() != null) {
            ChannelInfo bbj = this.eRc.bbj();
            an anVar = new an(this.eRc.isHost() ? "c11937" : "c11936");
            anVar.p("obj_id", bbj.getChannelId());
            anVar.O("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    private boolean rB() {
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
                    this.eQW.showLoadingView();
                    this.mPn = 1;
                    this.eQX.a(this.eQZ, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
