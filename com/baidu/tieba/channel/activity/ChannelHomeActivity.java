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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ChannelHomeActivity extends BaseActivity implements BdListView.e, b {
    private i cZv;
    private ChannelHomeModel cZw;
    private a cZx;
    private long cZy;
    private int cZz = -1;
    private boolean cZA = false;
    private d cZB = null;
    private int mPn = 1;
    private HttpMessageListener cZC = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cZB != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> aqp = ChannelHomeActivity.this.cZB.aqp();
                        if (hVar != null && aqp != null) {
                            aqp.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.cZv.h(ChannelHomeActivity.this.cZB);
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
    private HttpMessageListener cZD = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cZB != null && ChannelHomeActivity.this.cZB.aqo() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> aqp = ChannelHomeActivity.this.cZB.aqp();
                        if (hVar != null && aqp != null) {
                            aqp.remove(hVar);
                            aqp.checkBigVideoType();
                            ChannelInfo aqo = ChannelHomeActivity.this.cZB.aqo();
                            if (ChannelHomeActivity.this.cZB.aqo().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.cZB.aqo().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            aqo.setVideoCount(i);
                            ChannelHomeActivity.this.cZv.h(ChannelHomeActivity.this.cZB);
                            ChannelHomeActivity.this.cZv.f(ChannelHomeActivity.this.cZB);
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
    private com.baidu.adp.framework.listener.a cZE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.cZw.fA(false);
            ChannelHomeActivity.this.cZv.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.cZA) {
                            ChannelHomeActivity.this.cZv.showErrorView();
                            ChannelHomeActivity.this.cZv.abb();
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
                            if (ChannelHomeActivity.this.cZB != null) {
                                if (dVar.aqm() != null) {
                                    ChannelHomeActivity.this.cZB.a(dVar.aqm());
                                }
                                ChannelHomeActivity.this.cZB.b(dVar.aqp());
                                ChannelHomeActivity.this.cZv.h(ChannelHomeActivity.this.cZB);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.cZB = dVar;
                        if (ChannelHomeActivity.this.cZy == 0 && dVar.aqo() != null) {
                            ChannelHomeActivity.this.cZy = dVar.aqo().getChannelId();
                        }
                        ChannelHomeActivity.this.cZv.g(dVar);
                        if (!ChannelHomeActivity.this.cZA) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.cZA = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener cZF = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> aqp = ChannelHomeActivity.this.cZB.aqp();
                    if (aqp != null) {
                        aqp.unSetTop();
                        aqp.checkBigVideoType();
                        ChannelHomeActivity.this.cZv.h(ChannelHomeActivity.this.cZB);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener cZG = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.aoI != null) {
                    if (aVar.aoH == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0156a) {
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
    private CustomMessageListener cZH = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.cZw.a(ChannelHomeActivity.this.cZy, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.cZB.a(channelInfo);
                    ChannelHomeActivity.this.cZv.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.cZv = new i(this);
        this.cZw = new ChannelHomeModel(this);
        this.cZx = new com.baidu.tieba.channel.b.a(this);
        aqg();
        aqj();
        this.cZw.a(this.cZy, this.mPn, 20);
        this.cZv.showLoadingView();
    }

    private void aqj() {
        registerListener(2016511, this.cZH);
        registerListener(2016512, this.cZH);
    }

    private void aqg() {
        registerListener(this.cZC);
        registerListener(this.cZD);
        registerListener(this.cZE);
        registerListener(this.cZF);
        registerListener(this.cZG);
    }

    private void initData() {
        this.cZy = getIntent().getLongExtra("channel_id", 0L);
        this.cZz = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cZv.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cZv.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cZv.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cZv.onChangeSkinType(i);
        if (this.cZx != null) {
            this.cZx.onChangeSkinType(i);
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
                if (adF() && this.cZB != null && this.cZB.aqo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0156a.a(this.cZB.aqo().getChannelId(), getUniqueId())));
                    kE(4);
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
                    kE(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.cZy)));
                kE(5);
                return;
            case 11:
                if (this.cZB != null && this.cZB.aqo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.cZB.aqo())));
                    kE(3);
                    return;
                }
                return;
            case 12:
                if (this.cZB != null && this.cZB.aqo() != null) {
                    this.cZB.aqo().isPushOpen();
                    this.cZx.b(this.cZB);
                    this.cZx.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.cZB != null && this.cZB.aqo() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.cZw.b(this.cZB.aqo().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.cZB != null && this.cZB.aqo() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.cZw.a(this.cZB.aqo().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.cZB != null && this.cZB.aqo() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.cZw.c(this.cZB.aqo().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.cZB != null && this.cZB.aqo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.cZB.aqo().getChannelId(), getUniqueId())));
                    kE(5);
                    return;
                }
                return;
            case 18:
                if (this.cZB != null && this.cZB.aqo() != null) {
                    long channelId = this.cZB.aqo().getChannelId();
                    boolean isPushOpen = this.cZB.aqo().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.aoJ = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    kE(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.cZB != null && this.cZB.aqo() != null) {
                    mQ(this.cZB.aqo().getChannelCover());
                    kE(1);
                    return;
                }
                return;
            case 20:
                if (this.cZB != null && this.cZB.aqo() != null) {
                    mQ(this.cZB.aqo().getChannelAvatar());
                    kE(2);
                    return;
                }
                return;
            case 21:
                if (this.cZB != null && this.cZB.aqo() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.cZy)));
                    if (this.cZB.isHost()) {
                        kE(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void mQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.cZv.hideErrorView();
        this.cZv.showLoadingView();
        this.mPn = 1;
        this.cZw.a(this.cZy, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.aoI;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.cZB != null && this.cZB.aqo() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.aoJ) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(e.j.channel_need_push), 1).show();
                    } else {
                        showToast(e.j.success_open_channel_push);
                    }
                } else {
                    showToast(e.j.success_close_channel_push);
                }
                this.cZB.aqo().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.aoI;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cZB != null && this.cZB.aqo() != null) {
            this.cZB.aqo().setFansCount(this.cZB.aqo().getFansCount() + (-1) > 0 ? this.cZB.aqo().getFansCount() - 1 : 0);
            this.cZB.aqo().setIsSubscribe(0);
            this.cZB.aqo().setPushOpenOrClose(false);
            this.cZv.e(this.cZB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.aoI;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cZB != null && this.cZB.aqo() != null) {
            this.cZB.aqo().setFansCount(this.cZB.aqo().getFansCount() + 1);
            this.cZB.aqo().setIsSubscribe(1);
            this.cZv.e(this.cZB);
            if (aVar.aoH == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.cZB.aqo().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cZB != null && this.cZB.aqq() && !this.cZw.aqz()) {
            this.cZv.aqH();
            this.mPn++;
            this.cZw.a(this.cZy, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new am("c11935").x("obj_type", dVar.isHost() ? 1 : 2).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.cZz).i(VideoPlayActivityConfig.OBJ_ID, dVar.aqo().getChannelId()));
    }

    private void kE(int i) {
        if (this.cZB != null && this.cZB.aqo() != null) {
            ChannelInfo aqo = this.cZB.aqo();
            am amVar = new am(this.cZB.isHost() ? "c11937" : "c11936");
            amVar.i(VideoPlayActivityConfig.OBJ_ID, aqo.getChannelId());
            amVar.x("obj_locate", i);
            TiebaStatic.log(amVar);
        }
    }

    private boolean adF() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true, 3)));
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
                    this.cZv.showLoadingView();
                    this.mPn = 1;
                    this.cZw.a(this.cZy, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
