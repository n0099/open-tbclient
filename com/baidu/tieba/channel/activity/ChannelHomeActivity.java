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
    private i cDB;
    private ChannelHomeModel cDC;
    private a cDD;
    private long cDE;
    private int cDF = -1;
    private boolean cDG = false;
    private d cDH = null;
    private int mPn = 1;
    private HttpMessageListener cDI = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cDH != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> ajK = ChannelHomeActivity.this.cDH.ajK();
                        if (hVar != null && ajK != null) {
                            ajK.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.cDB.h(ChannelHomeActivity.this.cDH);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private HttpMessageListener cDJ = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cDH != null && ChannelHomeActivity.this.cDH.ajJ() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> ajK = ChannelHomeActivity.this.cDH.ajK();
                        if (hVar != null && ajK != null) {
                            ajK.remove(hVar);
                            ajK.checkBigVideoType();
                            ChannelInfo ajJ = ChannelHomeActivity.this.cDH.ajJ();
                            if (ChannelHomeActivity.this.cDH.ajJ().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.cDH.ajJ().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            ajJ.setVideoCount(i);
                            ChannelHomeActivity.this.cDB.h(ChannelHomeActivity.this.cDH);
                            ChannelHomeActivity.this.cDB.f(ChannelHomeActivity.this.cDH);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private com.baidu.adp.framework.listener.a cDK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.cDC.eF(false);
            ChannelHomeActivity.this.cDB.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.j.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.cDG) {
                            ChannelHomeActivity.this.cDB.akf();
                            ChannelHomeActivity.this.cDB.Un();
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
                            if (ChannelHomeActivity.this.cDH != null) {
                                if (dVar.ajH() != null) {
                                    ChannelHomeActivity.this.cDH.a(dVar.ajH());
                                }
                                ChannelHomeActivity.this.cDH.b(dVar.ajK());
                                ChannelHomeActivity.this.cDB.h(ChannelHomeActivity.this.cDH);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.cDH = dVar;
                        if (ChannelHomeActivity.this.cDE == 0 && dVar.ajJ() != null) {
                            ChannelHomeActivity.this.cDE = dVar.ajJ().getChannelId();
                        }
                        ChannelHomeActivity.this.cDB.g(dVar);
                        if (!ChannelHomeActivity.this.cDG) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.cDG = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener cDL = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> ajK = ChannelHomeActivity.this.cDH.ajK();
                    if (ajK != null) {
                        ajK.unSetTop();
                        ajK.checkBigVideoType();
                        ChannelHomeActivity.this.cDB.h(ChannelHomeActivity.this.cDH);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener cDM = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.acU != null) {
                    if (aVar.acT == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0099a) {
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
    private CustomMessageListener cDN = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.cDC.a(ChannelHomeActivity.this.cDE, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.cDH.a(channelInfo);
                    ChannelHomeActivity.this.cDB.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.cDB = new i(this);
        this.cDC = new ChannelHomeModel(this);
        this.cDD = new com.baidu.tieba.channel.b.a(this);
        ajB();
        ajE();
        this.cDC.a(this.cDE, this.mPn, 20);
        this.cDB.showLoadingView();
    }

    private void ajE() {
        registerListener(2016511, this.cDN);
        registerListener(2016512, this.cDN);
    }

    private void ajB() {
        registerListener(this.cDI);
        registerListener(this.cDJ);
        registerListener(this.cDK);
        registerListener(this.cDL);
        registerListener(this.cDM);
    }

    private void initData() {
        this.cDE = getIntent().getLongExtra("channel_id", 0L);
        this.cDF = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cDB.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cDB.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cDB.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cDB.onChangeSkinType(i);
        if (this.cDD != null) {
            this.cDD.onChangeSkinType(i);
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
                if (WV() && this.cDH != null && this.cDH.ajJ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0099a.a(this.cDH.ajJ().getChannelId(), getUniqueId())));
                    iZ(4);
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
                    iZ(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.cDE)));
                iZ(5);
                return;
            case 11:
                if (this.cDH != null && this.cDH.ajJ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.cDH.ajJ())));
                    iZ(3);
                    return;
                }
                return;
            case 12:
                if (this.cDH != null && this.cDH.ajJ() != null) {
                    this.cDH.ajJ().isPushOpen();
                    this.cDD.b(this.cDH);
                    this.cDD.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.cDH != null && this.cDH.ajJ() != null) {
                    showLoadingDialog(getResources().getString(d.j.Waiting));
                    this.cDC.b(this.cDH.ajJ().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.cDH != null && this.cDH.ajJ() != null) {
                    showLoadingDialog(getResources().getString(d.j.Waiting));
                    this.cDC.a(this.cDH.ajJ().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.cDH != null && this.cDH.ajJ() != null) {
                    showLoadingDialog(getResources().getString(d.j.Waiting));
                    this.cDC.c(this.cDH.ajJ().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.cDH != null && this.cDH.ajJ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.cDH.ajJ().getChannelId(), getUniqueId())));
                    iZ(5);
                    return;
                }
                return;
            case 18:
                if (this.cDH != null && this.cDH.ajJ() != null) {
                    long channelId = this.cDH.ajJ().getChannelId();
                    boolean isPushOpen = this.cDH.ajJ().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.acV = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    iZ(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.cDH != null && this.cDH.ajJ() != null) {
                    lk(this.cDH.ajJ().getChannelCover());
                    iZ(1);
                    return;
                }
                return;
            case 20:
                if (this.cDH != null && this.cDH.ajJ() != null) {
                    lk(this.cDH.ajJ().getChannelAvatar());
                    iZ(2);
                    return;
                }
                return;
            case 21:
                if (this.cDH != null && this.cDH.ajJ() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.cDE)));
                    if (this.cDH.isHost()) {
                        iZ(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void lk(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.cDB.akg();
        this.cDB.showLoadingView();
        this.mPn = 1;
        this.cDC.a(this.cDE, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.acU;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.cDH != null && this.cDH.ajJ() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.acV) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(d.j.channel_need_push), 1).show();
                    } else {
                        showToast(d.j.success_open_channel_push);
                    }
                } else {
                    showToast(d.j.success_close_channel_push);
                }
                this.cDH.ajJ().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.acU;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cDH != null && this.cDH.ajJ() != null) {
            this.cDH.ajJ().setFansCount(this.cDH.ajJ().getFansCount() + (-1) > 0 ? this.cDH.ajJ().getFansCount() - 1 : 0);
            this.cDH.ajJ().setIsSubscribe(0);
            this.cDH.ajJ().setPushOpenOrClose(false);
            this.cDB.e(this.cDH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.acU;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cDH != null && this.cDH.ajJ() != null) {
            this.cDH.ajJ().setFansCount(this.cDH.ajJ().getFansCount() + 1);
            this.cDH.ajJ().setIsSubscribe(1);
            this.cDB.e(this.cDH);
            if (aVar.acT == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.cDH.ajJ().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cDH != null && this.cDH.ajL() && !this.cDC.ajU()) {
            this.cDB.ake();
            this.mPn++;
            this.cDC.a(this.cDE, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.channel.data.d dVar) {
        TiebaStatic.logPagePV(new an("c11935").r("obj_type", dVar.isHost() ? 1 : 2).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.cDF).f(VideoPlayActivityConfig.OBJ_ID, dVar.ajJ().getChannelId()));
    }

    private void iZ(int i) {
        if (this.cDH != null && this.cDH.ajJ() != null) {
            ChannelInfo ajJ = this.cDH.ajJ();
            an anVar = new an(this.cDH.isHost() ? "c11937" : "c11936");
            anVar.f(VideoPlayActivityConfig.OBJ_ID, ajJ.getChannelId());
            anVar.r("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    private boolean WV() {
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
                    this.cDB.showLoadingView();
                    this.mPn = 1;
                    this.cDC.a(this.cDE, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
