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
    private i cRI;
    private ChannelHomeModel cRJ;
    private a cRK;
    private long cRL;
    private int cRM = -1;
    private boolean cRN = false;
    private d cRO = null;
    private int mPn = 1;
    private HttpMessageListener cRP = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cRO != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> apa = ChannelHomeActivity.this.cRO.apa();
                        if (hVar != null && apa != null) {
                            apa.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.cRI.h(ChannelHomeActivity.this.cRO);
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
    private HttpMessageListener cRQ = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cRO != null && ChannelHomeActivity.this.cRO.aoZ() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> apa = ChannelHomeActivity.this.cRO.apa();
                        if (hVar != null && apa != null) {
                            apa.remove(hVar);
                            apa.checkBigVideoType();
                            ChannelInfo aoZ = ChannelHomeActivity.this.cRO.aoZ();
                            if (ChannelHomeActivity.this.cRO.aoZ().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.cRO.aoZ().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            aoZ.setVideoCount(i);
                            ChannelHomeActivity.this.cRI.h(ChannelHomeActivity.this.cRO);
                            ChannelHomeActivity.this.cRI.f(ChannelHomeActivity.this.cRO);
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
    private com.baidu.adp.framework.listener.a cRR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.cRJ.fo(false);
            ChannelHomeActivity.this.cRI.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.cRN) {
                            ChannelHomeActivity.this.cRI.showErrorView();
                            ChannelHomeActivity.this.cRI.ZK();
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
                            if (ChannelHomeActivity.this.cRO != null) {
                                if (dVar.aoX() != null) {
                                    ChannelHomeActivity.this.cRO.a(dVar.aoX());
                                }
                                ChannelHomeActivity.this.cRO.b(dVar.apa());
                                ChannelHomeActivity.this.cRI.h(ChannelHomeActivity.this.cRO);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.cRO = dVar;
                        if (ChannelHomeActivity.this.cRL == 0 && dVar.aoZ() != null) {
                            ChannelHomeActivity.this.cRL = dVar.aoZ().getChannelId();
                        }
                        ChannelHomeActivity.this.cRI.g(dVar);
                        if (!ChannelHomeActivity.this.cRN) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.cRN = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener cRS = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> apa = ChannelHomeActivity.this.cRO.apa();
                    if (apa != null) {
                        apa.unSetTop();
                        apa.checkBigVideoType();
                        ChannelHomeActivity.this.cRI.h(ChannelHomeActivity.this.cRO);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener cRT = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.akt != null) {
                    if (aVar.aks == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0122a) {
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
    private CustomMessageListener cRU = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.cRJ.a(ChannelHomeActivity.this.cRL, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.cRO.a(channelInfo);
                    ChannelHomeActivity.this.cRI.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.cRI = new i(this);
        this.cRJ = new ChannelHomeModel(this);
        this.cRK = new com.baidu.tieba.channel.b.a(this);
        aoR();
        aoU();
        this.cRJ.a(this.cRL, this.mPn, 20);
        this.cRI.showLoadingView();
    }

    private void aoU() {
        registerListener(2016511, this.cRU);
        registerListener(2016512, this.cRU);
    }

    private void aoR() {
        registerListener(this.cRP);
        registerListener(this.cRQ);
        registerListener(this.cRR);
        registerListener(this.cRS);
        registerListener(this.cRT);
    }

    private void initData() {
        this.cRL = getIntent().getLongExtra("channel_id", 0L);
        this.cRM = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cRI.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cRI.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cRI.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cRI.onChangeSkinType(i);
        if (this.cRK != null) {
            this.cRK.onChangeSkinType(i);
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
                if (act() && this.cRO != null && this.cRO.aoZ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0122a.a(this.cRO.aoZ().getChannelId(), getUniqueId())));
                    jV(4);
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
                    jV(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.cRL)));
                jV(5);
                return;
            case 11:
                if (this.cRO != null && this.cRO.aoZ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.cRO.aoZ())));
                    jV(3);
                    return;
                }
                return;
            case 12:
                if (this.cRO != null && this.cRO.aoZ() != null) {
                    this.cRO.aoZ().isPushOpen();
                    this.cRK.b(this.cRO);
                    this.cRK.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.cRO != null && this.cRO.aoZ() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.cRJ.b(this.cRO.aoZ().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.cRO != null && this.cRO.aoZ() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.cRJ.a(this.cRO.aoZ().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.cRO != null && this.cRO.aoZ() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.cRJ.c(this.cRO.aoZ().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.cRO != null && this.cRO.aoZ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.cRO.aoZ().getChannelId(), getUniqueId())));
                    jV(5);
                    return;
                }
                return;
            case 18:
                if (this.cRO != null && this.cRO.aoZ() != null) {
                    long channelId = this.cRO.aoZ().getChannelId();
                    boolean isPushOpen = this.cRO.aoZ().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.aku = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    jV(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.cRO != null && this.cRO.aoZ() != null) {
                    mq(this.cRO.aoZ().getChannelCover());
                    jV(1);
                    return;
                }
                return;
            case 20:
                if (this.cRO != null && this.cRO.aoZ() != null) {
                    mq(this.cRO.aoZ().getChannelAvatar());
                    jV(2);
                    return;
                }
                return;
            case 21:
                if (this.cRO != null && this.cRO.aoZ() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.cRL)));
                    if (this.cRO.isHost()) {
                        jV(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void mq(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.cRI.hideErrorView();
        this.cRI.showLoadingView();
        this.mPn = 1;
        this.cRJ.a(this.cRL, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.akt;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.cRO != null && this.cRO.aoZ() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.aku) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(e.j.channel_need_push), 1).show();
                    } else {
                        showToast(e.j.success_open_channel_push);
                    }
                } else {
                    showToast(e.j.success_close_channel_push);
                }
                this.cRO.aoZ().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.akt;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cRO != null && this.cRO.aoZ() != null) {
            this.cRO.aoZ().setFansCount(this.cRO.aoZ().getFansCount() + (-1) > 0 ? this.cRO.aoZ().getFansCount() - 1 : 0);
            this.cRO.aoZ().setIsSubscribe(0);
            this.cRO.aoZ().setPushOpenOrClose(false);
            this.cRI.e(this.cRO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.akt;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cRO != null && this.cRO.aoZ() != null) {
            this.cRO.aoZ().setFansCount(this.cRO.aoZ().getFansCount() + 1);
            this.cRO.aoZ().setIsSubscribe(1);
            this.cRI.e(this.cRO);
            if (aVar.aks == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.cRO.aoZ().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cRO != null && this.cRO.apb() && !this.cRJ.apl()) {
            this.cRI.apt();
            this.mPn++;
            this.cRJ.a(this.cRL, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new am("c11935").x("obj_type", dVar.isHost() ? 1 : 2).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.cRM).h(VideoPlayActivityConfig.OBJ_ID, dVar.aoZ().getChannelId()));
    }

    private void jV(int i) {
        if (this.cRO != null && this.cRO.aoZ() != null) {
            ChannelInfo aoZ = this.cRO.aoZ();
            am amVar = new am(this.cRO.isHost() ? "c11937" : "c11936");
            amVar.h(VideoPlayActivityConfig.OBJ_ID, aoZ.getChannelId());
            amVar.x("obj_locate", i);
            TiebaStatic.log(amVar);
        }
    }

    private boolean act() {
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
                    this.cRI.showLoadingView();
                    this.mPn = 1;
                    this.cRJ.a(this.cRL, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
