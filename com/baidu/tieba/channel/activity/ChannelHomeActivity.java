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
    private i cAW;
    private ChannelHomeModel cAX;
    private a cAY;
    private long cAZ;
    private int cBa = -1;
    private boolean cBb = false;
    private d cBc = null;
    private int mPn = 1;
    private HttpMessageListener cBd = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cBc != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> ajm = ChannelHomeActivity.this.cBc.ajm();
                        if (hVar != null && ajm != null) {
                            ajm.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.cAW.h(ChannelHomeActivity.this.cBc);
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
    private HttpMessageListener cBe = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cBc != null && ChannelHomeActivity.this.cBc.ajl() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> ajm = ChannelHomeActivity.this.cBc.ajm();
                        if (hVar != null && ajm != null) {
                            ajm.remove(hVar);
                            ajm.checkBigVideoType();
                            ChannelInfo ajl = ChannelHomeActivity.this.cBc.ajl();
                            if (ChannelHomeActivity.this.cBc.ajl().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.cBc.ajl().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            ajl.setVideoCount(i);
                            ChannelHomeActivity.this.cAW.h(ChannelHomeActivity.this.cBc);
                            ChannelHomeActivity.this.cAW.f(ChannelHomeActivity.this.cBc);
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
    private com.baidu.adp.framework.listener.a cBf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.cAX.eE(false);
            ChannelHomeActivity.this.cAW.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.k.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.cBb) {
                            ChannelHomeActivity.this.cAW.showErrorView();
                            ChannelHomeActivity.this.cAW.Uf();
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
                            if (ChannelHomeActivity.this.cBc != null) {
                                if (dVar.ajj() != null) {
                                    ChannelHomeActivity.this.cBc.a(dVar.ajj());
                                }
                                ChannelHomeActivity.this.cBc.b(dVar.ajm());
                                ChannelHomeActivity.this.cAW.h(ChannelHomeActivity.this.cBc);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.cBc = dVar;
                        if (ChannelHomeActivity.this.cAZ == 0 && dVar.ajl() != null) {
                            ChannelHomeActivity.this.cAZ = dVar.ajl().getChannelId();
                        }
                        ChannelHomeActivity.this.cAW.g(dVar);
                        if (!ChannelHomeActivity.this.cBb) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.cBb = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener cBg = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> ajm = ChannelHomeActivity.this.cBc.ajm();
                    if (ajm != null) {
                        ajm.unSetTop();
                        ajm.checkBigVideoType();
                        ChannelHomeActivity.this.cAW.h(ChannelHomeActivity.this.cBc);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener cBh = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.adr != null) {
                    if (aVar.adq == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0102a) {
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
    private CustomMessageListener cBi = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.cAX.a(ChannelHomeActivity.this.cAZ, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.cBc.a(channelInfo);
                    ChannelHomeActivity.this.cAW.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.cAW = new i(this);
        this.cAX = new ChannelHomeModel(this);
        this.cAY = new com.baidu.tieba.channel.b.a(this);
        ajc();
        ajf();
        this.cAX.a(this.cAZ, this.mPn, 20);
        this.cAW.showLoadingView();
    }

    private void ajf() {
        registerListener(2016511, this.cBi);
        registerListener(2016512, this.cBi);
    }

    private void ajc() {
        registerListener(this.cBd);
        registerListener(this.cBe);
        registerListener(this.cBf);
        registerListener(this.cBg);
        registerListener(this.cBh);
    }

    private void initData() {
        this.cAZ = getIntent().getLongExtra("channel_id", 0L);
        this.cBa = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cAW.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cAW.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cAW.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cAW.onChangeSkinType(i);
        if (this.cAY != null) {
            this.cAY.onChangeSkinType(i);
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
                if (WM() && this.cBc != null && this.cBc.ajl() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0102a.a(this.cBc.ajl().getChannelId(), getUniqueId())));
                    iN(4);
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
                    iN(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.cAZ)));
                iN(5);
                return;
            case 11:
                if (this.cBc != null && this.cBc.ajl() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.cBc.ajl())));
                    iN(3);
                    return;
                }
                return;
            case 12:
                if (this.cBc != null && this.cBc.ajl() != null) {
                    this.cBc.ajl().isPushOpen();
                    this.cAY.b(this.cBc);
                    this.cAY.ajg();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.cBc != null && this.cBc.ajl() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.cAX.b(this.cBc.ajl().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.cBc != null && this.cBc.ajl() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.cAX.a(this.cBc.ajl().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.cBc != null && this.cBc.ajl() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.cAX.c(this.cBc.ajl().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.cBc != null && this.cBc.ajl() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.cBc.ajl().getChannelId(), getUniqueId())));
                    iN(5);
                    return;
                }
                return;
            case 18:
                if (this.cBc != null && this.cBc.ajl() != null) {
                    long channelId = this.cBc.ajl().getChannelId();
                    boolean isPushOpen = this.cBc.ajl().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.ads = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    iN(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.cBc != null && this.cBc.ajl() != null) {
                    ll(this.cBc.ajl().getChannelCover());
                    iN(1);
                    return;
                }
                return;
            case 20:
                if (this.cBc != null && this.cBc.ajl() != null) {
                    ll(this.cBc.ajl().getChannelAvatar());
                    iN(2);
                    return;
                }
                return;
            case 21:
                if (this.cBc != null && this.cBc.ajl() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.cAZ)));
                    if (this.cBc.isHost()) {
                        iN(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void ll(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.cAW.ajH();
        this.cAW.showLoadingView();
        this.mPn = 1;
        this.cAX.a(this.cAZ, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.adr;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.cBc != null && this.cBc.ajl() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.ads) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(d.k.channel_need_push), 1).show();
                    } else {
                        showToast(d.k.success_open_channel_push);
                    }
                } else {
                    showToast(d.k.success_close_channel_push);
                }
                this.cBc.ajl().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.adr;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cBc != null && this.cBc.ajl() != null) {
            this.cBc.ajl().setFansCount(this.cBc.ajl().getFansCount() + (-1) > 0 ? this.cBc.ajl().getFansCount() - 1 : 0);
            this.cBc.ajl().setIsSubscribe(0);
            this.cBc.ajl().setPushOpenOrClose(false);
            this.cAW.e(this.cBc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.adr;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cBc != null && this.cBc.ajl() != null) {
            this.cBc.ajl().setFansCount(this.cBc.ajl().getFansCount() + 1);
            this.cBc.ajl().setIsSubscribe(1);
            this.cAW.e(this.cBc);
            if (aVar.adq == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.cBc.ajl().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cBc != null && this.cBc.ajn() && !this.cAX.ajw()) {
            this.cAW.ajG();
            this.mPn++;
            this.cAX.a(this.cAZ, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.channel.data.d dVar) {
        TiebaStatic.logPagePV(new an("c11935").r("obj_type", dVar.isHost() ? 1 : 2).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.cBa).f(VideoPlayActivityConfig.OBJ_ID, dVar.ajl().getChannelId()));
    }

    private void iN(int i) {
        if (this.cBc != null && this.cBc.ajl() != null) {
            ChannelInfo ajl = this.cBc.ajl();
            an anVar = new an(this.cBc.isHost() ? "c11937" : "c11936");
            anVar.f(VideoPlayActivityConfig.OBJ_ID, ajl.getChannelId());
            anVar.r("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    private boolean WM() {
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
                    this.cAW.showLoadingView();
                    this.mPn = 1;
                    this.cAX.a(this.cAZ, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
