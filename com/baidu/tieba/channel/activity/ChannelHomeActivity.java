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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ChannelHomeActivity extends BaseActivity implements BdListView.e, b {
    private i cSO;
    private ChannelHomeModel cSP;
    private a cSQ;
    private long cSR;
    private int cSS = -1;
    private boolean cST = false;
    private d cSU = null;
    private int mPn = 1;
    private HttpMessageListener cSV = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cSU != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> aoC = ChannelHomeActivity.this.cSU.aoC();
                        if (hVar != null && aoC != null) {
                            aoC.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.cSO.h(ChannelHomeActivity.this.cSU);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private HttpMessageListener cSW = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cSU != null && ChannelHomeActivity.this.cSU.aoB() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> aoC = ChannelHomeActivity.this.cSU.aoC();
                        if (hVar != null && aoC != null) {
                            aoC.remove(hVar);
                            aoC.checkBigVideoType();
                            ChannelInfo aoB = ChannelHomeActivity.this.cSU.aoB();
                            if (ChannelHomeActivity.this.cSU.aoB().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.cSU.aoB().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            aoB.setVideoCount(i);
                            ChannelHomeActivity.this.cSO.h(ChannelHomeActivity.this.cSU);
                            ChannelHomeActivity.this.cSO.f(ChannelHomeActivity.this.cSU);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private com.baidu.adp.framework.listener.a cSX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.cSP.fz(false);
            ChannelHomeActivity.this.cSO.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.cST) {
                            ChannelHomeActivity.this.cSO.showErrorView();
                            ChannelHomeActivity.this.cSO.ZV();
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
                            if (ChannelHomeActivity.this.cSU != null) {
                                if (dVar.aoz() != null) {
                                    ChannelHomeActivity.this.cSU.a(dVar.aoz());
                                }
                                ChannelHomeActivity.this.cSU.b(dVar.aoC());
                                ChannelHomeActivity.this.cSO.h(ChannelHomeActivity.this.cSU);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.cSU = dVar;
                        if (ChannelHomeActivity.this.cSR == 0 && dVar.aoB() != null) {
                            ChannelHomeActivity.this.cSR = dVar.aoB().getChannelId();
                        }
                        ChannelHomeActivity.this.cSO.g(dVar);
                        if (!ChannelHomeActivity.this.cST) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.cST = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener cSY = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> aoC = ChannelHomeActivity.this.cSU.aoC();
                    if (aoC != null) {
                        aoC.unSetTop();
                        aoC.checkBigVideoType();
                        ChannelHomeActivity.this.cSO.h(ChannelHomeActivity.this.cSU);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener cSZ = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.alg != null) {
                    if (aVar.alf == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0146a) {
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
    private CustomMessageListener cTa = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.cSP.a(ChannelHomeActivity.this.cSR, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.cSU.a(channelInfo);
                    ChannelHomeActivity.this.cSO.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.cSO = new i(this);
        this.cSP = new ChannelHomeModel(this);
        this.cSQ = new com.baidu.tieba.channel.b.a(this);
        aot();
        aow();
        this.cSP.a(this.cSR, this.mPn, 20);
        this.cSO.showLoadingView();
    }

    private void aow() {
        registerListener(2016511, this.cTa);
        registerListener(2016512, this.cTa);
    }

    private void aot() {
        registerListener(this.cSV);
        registerListener(this.cSW);
        registerListener(this.cSX);
        registerListener(this.cSY);
        registerListener(this.cSZ);
    }

    private void initData() {
        this.cSR = getIntent().getLongExtra("channel_id", 0L);
        this.cSS = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cSO.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cSO.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cSO.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cSO.onChangeSkinType(i);
        if (this.cSQ != null) {
            this.cSQ.onChangeSkinType(i);
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
                if (acz() && this.cSU != null && this.cSU.aoB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0146a.a(this.cSU.aoB().getChannelId(), getUniqueId())));
                    ko(4);
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
                    ko(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.cSR)));
                ko(5);
                return;
            case 11:
                if (this.cSU != null && this.cSU.aoB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.cSU.aoB())));
                    ko(3);
                    return;
                }
                return;
            case 12:
                if (this.cSU != null && this.cSU.aoB() != null) {
                    this.cSU.aoB().isPushOpen();
                    this.cSQ.b(this.cSU);
                    this.cSQ.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.cSU != null && this.cSU.aoB() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.cSP.b(this.cSU.aoB().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.cSU != null && this.cSU.aoB() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.cSP.a(this.cSU.aoB().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.cSU != null && this.cSU.aoB() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.cSP.c(this.cSU.aoB().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.cSU != null && this.cSU.aoB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.cSU.aoB().getChannelId(), getUniqueId())));
                    ko(5);
                    return;
                }
                return;
            case 18:
                if (this.cSU != null && this.cSU.aoB() != null) {
                    long channelId = this.cSU.aoB().getChannelId();
                    boolean isPushOpen = this.cSU.aoB().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.alh = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    ko(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.cSU != null && this.cSU.aoB() != null) {
                    mr(this.cSU.aoB().getChannelCover());
                    ko(1);
                    return;
                }
                return;
            case 20:
                if (this.cSU != null && this.cSU.aoB() != null) {
                    mr(this.cSU.aoB().getChannelAvatar());
                    ko(2);
                    return;
                }
                return;
            case 21:
                if (this.cSU != null && this.cSU.aoB() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.cSR)));
                    if (this.cSU.isHost()) {
                        ko(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void mr(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.cSO.hideErrorView();
        this.cSO.showLoadingView();
        this.mPn = 1;
        this.cSP.a(this.cSR, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.alg;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.cSU != null && this.cSU.aoB() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.alh) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(e.j.channel_need_push), 1).show();
                    } else {
                        showToast(e.j.success_open_channel_push);
                    }
                } else {
                    showToast(e.j.success_close_channel_push);
                }
                this.cSU.aoB().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.alg;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cSU != null && this.cSU.aoB() != null) {
            this.cSU.aoB().setFansCount(this.cSU.aoB().getFansCount() + (-1) > 0 ? this.cSU.aoB().getFansCount() - 1 : 0);
            this.cSU.aoB().setIsSubscribe(0);
            this.cSU.aoB().setPushOpenOrClose(false);
            this.cSO.e(this.cSU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.alg;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cSU != null && this.cSU.aoB() != null) {
            this.cSU.aoB().setFansCount(this.cSU.aoB().getFansCount() + 1);
            this.cSU.aoB().setIsSubscribe(1);
            this.cSO.e(this.cSU);
            if (aVar.alf == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.cSU.aoB().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cSU != null && this.cSU.aoD() && !this.cSP.aoM()) {
            this.cSO.aoU();
            this.mPn++;
            this.cSP.a(this.cSR, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new am("c11935").x("obj_type", dVar.isHost() ? 1 : 2).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.cSS).h(VideoPlayActivityConfig.OBJ_ID, dVar.aoB().getChannelId()));
    }

    private void ko(int i) {
        if (this.cSU != null && this.cSU.aoB() != null) {
            ChannelInfo aoB = this.cSU.aoB();
            am amVar = new am(this.cSU.isHost() ? "c11937" : "c11936");
            amVar.h(VideoPlayActivityConfig.OBJ_ID, aoB.getChannelId());
            amVar.x("obj_locate", i);
            TiebaStatic.log(amVar);
        }
    }

    private boolean acz() {
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
                    this.cSO.showLoadingView();
                    this.mPn = 1;
                    this.cSP.a(this.cSR, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
