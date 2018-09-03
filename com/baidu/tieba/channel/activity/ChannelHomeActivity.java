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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ChannelHomeActivity extends BaseActivity implements BdListView.e, b {
    private a cDA;
    private long cDB;
    private i cDy;
    private ChannelHomeModel cDz;
    private int cDC = -1;
    private boolean cDD = false;
    private d cDE = null;
    private int mPn = 1;
    private HttpMessageListener cDF = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cDE != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> ajN = ChannelHomeActivity.this.cDE.ajN();
                        if (hVar != null && ajN != null) {
                            ajN.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.cDy.h(ChannelHomeActivity.this.cDE);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(f.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private HttpMessageListener cDG = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cDE != null && ChannelHomeActivity.this.cDE.ajM() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> ajN = ChannelHomeActivity.this.cDE.ajN();
                        if (hVar != null && ajN != null) {
                            ajN.remove(hVar);
                            ajN.checkBigVideoType();
                            ChannelInfo ajM = ChannelHomeActivity.this.cDE.ajM();
                            if (ChannelHomeActivity.this.cDE.ajM().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.cDE.ajM().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            ajM.setVideoCount(i);
                            ChannelHomeActivity.this.cDy.h(ChannelHomeActivity.this.cDE);
                            ChannelHomeActivity.this.cDy.f(ChannelHomeActivity.this.cDE);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(f.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private com.baidu.adp.framework.listener.a cDH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.cDz.eF(false);
            ChannelHomeActivity.this.cDy.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(f.j.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.cDD) {
                            ChannelHomeActivity.this.cDy.akh();
                            ChannelHomeActivity.this.cDy.Uq();
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
                            if (ChannelHomeActivity.this.cDE != null) {
                                if (dVar.ajK() != null) {
                                    ChannelHomeActivity.this.cDE.a(dVar.ajK());
                                }
                                ChannelHomeActivity.this.cDE.b(dVar.ajN());
                                ChannelHomeActivity.this.cDy.h(ChannelHomeActivity.this.cDE);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.cDE = dVar;
                        if (ChannelHomeActivity.this.cDB == 0 && dVar.ajM() != null) {
                            ChannelHomeActivity.this.cDB = dVar.ajM().getChannelId();
                        }
                        ChannelHomeActivity.this.cDy.g(dVar);
                        if (!ChannelHomeActivity.this.cDD) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.cDD = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener cDI = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> ajN = ChannelHomeActivity.this.cDE.ajN();
                    if (ajN != null) {
                        ajN.unSetTop();
                        ajN.checkBigVideoType();
                        ChannelHomeActivity.this.cDy.h(ChannelHomeActivity.this.cDE);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(f.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener cDJ = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.acV != null) {
                    if (aVar.acU == ChannelHomeActivity.this.getUniqueId()) {
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
    private CustomMessageListener cDK = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.cDz.a(ChannelHomeActivity.this.cDB, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.cDE.a(channelInfo);
                    ChannelHomeActivity.this.cDy.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.cDy = new i(this);
        this.cDz = new ChannelHomeModel(this);
        this.cDA = new com.baidu.tieba.channel.b.a(this);
        ajE();
        ajH();
        this.cDz.a(this.cDB, this.mPn, 20);
        this.cDy.showLoadingView();
    }

    private void ajH() {
        registerListener(2016511, this.cDK);
        registerListener(2016512, this.cDK);
    }

    private void ajE() {
        registerListener(this.cDF);
        registerListener(this.cDG);
        registerListener(this.cDH);
        registerListener(this.cDI);
        registerListener(this.cDJ);
    }

    private void initData() {
        this.cDB = getIntent().getLongExtra("channel_id", 0L);
        this.cDC = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cDy.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cDy.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cDy.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cDy.onChangeSkinType(i);
        if (this.cDA != null) {
            this.cDA.onChangeSkinType(i);
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
                if (WY() && this.cDE != null && this.cDE.ajM() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0099a.a(this.cDE.ajM().getChannelId(), getUniqueId())));
                    iY(4);
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
                    iY(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.cDB)));
                iY(5);
                return;
            case 11:
                if (this.cDE != null && this.cDE.ajM() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.cDE.ajM())));
                    iY(3);
                    return;
                }
                return;
            case 12:
                if (this.cDE != null && this.cDE.ajM() != null) {
                    this.cDE.ajM().isPushOpen();
                    this.cDA.b(this.cDE);
                    this.cDA.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.cDE != null && this.cDE.ajM() != null) {
                    showLoadingDialog(getResources().getString(f.j.Waiting));
                    this.cDz.b(this.cDE.ajM().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.cDE != null && this.cDE.ajM() != null) {
                    showLoadingDialog(getResources().getString(f.j.Waiting));
                    this.cDz.a(this.cDE.ajM().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.cDE != null && this.cDE.ajM() != null) {
                    showLoadingDialog(getResources().getString(f.j.Waiting));
                    this.cDz.c(this.cDE.ajM().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.cDE != null && this.cDE.ajM() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.cDE.ajM().getChannelId(), getUniqueId())));
                    iY(5);
                    return;
                }
                return;
            case 18:
                if (this.cDE != null && this.cDE.ajM() != null) {
                    long channelId = this.cDE.ajM().getChannelId();
                    boolean isPushOpen = this.cDE.ajM().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.acW = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    iY(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.cDE != null && this.cDE.ajM() != null) {
                    lm(this.cDE.ajM().getChannelCover());
                    iY(1);
                    return;
                }
                return;
            case 20:
                if (this.cDE != null && this.cDE.ajM() != null) {
                    lm(this.cDE.ajM().getChannelAvatar());
                    iY(2);
                    return;
                }
                return;
            case 21:
                if (this.cDE != null && this.cDE.ajM() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.cDB)));
                    if (this.cDE.isHost()) {
                        iY(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void lm(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.cDy.aki();
        this.cDy.showLoadingView();
        this.mPn = 1;
        this.cDz.a(this.cDB, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.acV;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(f.j.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.cDE != null && this.cDE.ajM() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.acW) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(f.j.channel_need_push), 1).show();
                    } else {
                        showToast(f.j.success_open_channel_push);
                    }
                } else {
                    showToast(f.j.success_close_channel_push);
                }
                this.cDE.ajM().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.acV;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(f.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cDE != null && this.cDE.ajM() != null) {
            this.cDE.ajM().setFansCount(this.cDE.ajM().getFansCount() + (-1) > 0 ? this.cDE.ajM().getFansCount() - 1 : 0);
            this.cDE.ajM().setIsSubscribe(0);
            this.cDE.ajM().setPushOpenOrClose(false);
            this.cDy.e(this.cDE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.acV;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(f.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cDE != null && this.cDE.ajM() != null) {
            this.cDE.ajM().setFansCount(this.cDE.ajM().getFansCount() + 1);
            this.cDE.ajM().setIsSubscribe(1);
            this.cDy.e(this.cDE);
            if (aVar.acU == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.cDE.ajM().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cDE != null && this.cDE.ajO() && !this.cDz.ajX()) {
            this.cDy.akg();
            this.mPn++;
            this.cDz.a(this.cDB, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new an("c11935").r("obj_type", dVar.isHost() ? 1 : 2).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.cDC).f(VideoPlayActivityConfig.OBJ_ID, dVar.ajM().getChannelId()));
    }

    private void iY(int i) {
        if (this.cDE != null && this.cDE.ajM() != null) {
            ChannelInfo ajM = this.cDE.ajM();
            an anVar = new an(this.cDE.isHost() ? "c11937" : "c11936");
            anVar.f(VideoPlayActivityConfig.OBJ_ID, ajM.getChannelId());
            anVar.r("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    private boolean WY() {
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
                    this.cDy.showLoadingView();
                    this.mPn = 1;
                    this.cDz.a(this.cDB, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
