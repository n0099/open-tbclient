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
import com.baidu.tbadk.core.util.al;
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
    private i ctr;
    private ChannelHomeModel cts;
    private a ctt;
    private long ctu;
    private int ctv = -1;
    private boolean ctw = false;
    private d cty = null;
    private int mPn = 1;
    private HttpMessageListener ctz = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cty != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> agk = ChannelHomeActivity.this.cty.agk();
                        if (hVar != null && agk != null) {
                            agk.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.ctr.h(ChannelHomeActivity.this.cty);
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
    private HttpMessageListener ctA = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cty != null && ChannelHomeActivity.this.cty.agj() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> agk = ChannelHomeActivity.this.cty.agk();
                        if (hVar != null && agk != null) {
                            agk.remove(hVar);
                            agk.checkBigVideoType();
                            ChannelInfo agj = ChannelHomeActivity.this.cty.agj();
                            if (ChannelHomeActivity.this.cty.agj().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.cty.agj().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            agj.setVideoCount(i);
                            ChannelHomeActivity.this.ctr.h(ChannelHomeActivity.this.cty);
                            ChannelHomeActivity.this.ctr.f(ChannelHomeActivity.this.cty);
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
    private com.baidu.adp.framework.listener.a ctB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.cts.ez(false);
            ChannelHomeActivity.this.ctr.Ou();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.k.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.ctw) {
                            ChannelHomeActivity.this.ctr.showErrorView();
                            ChannelHomeActivity.this.ctr.Qq();
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
                            if (ChannelHomeActivity.this.cty != null) {
                                if (dVar.agh() != null) {
                                    ChannelHomeActivity.this.cty.a(dVar.agh());
                                }
                                ChannelHomeActivity.this.cty.b(dVar.agk());
                                ChannelHomeActivity.this.ctr.h(ChannelHomeActivity.this.cty);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.cty = dVar;
                        if (ChannelHomeActivity.this.ctu == 0 && dVar.agj() != null) {
                            ChannelHomeActivity.this.ctu = dVar.agj().getChannelId();
                        }
                        ChannelHomeActivity.this.ctr.g(dVar);
                        if (!ChannelHomeActivity.this.ctw) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.ctw = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener ctC = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> agk = ChannelHomeActivity.this.cty.agk();
                    if (agk != null) {
                        agk.unSetTop();
                        agk.checkBigVideoType();
                        ChannelHomeActivity.this.ctr.h(ChannelHomeActivity.this.cty);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener ctD = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.Vg != null) {
                    if (aVar.Vf == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0084a) {
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
    private CustomMessageListener ctE = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.cts.a(ChannelHomeActivity.this.ctu, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.cty.a(channelInfo);
                    ChannelHomeActivity.this.ctr.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.ctr = new i(this);
        this.cts = new ChannelHomeModel(this);
        this.ctt = new com.baidu.tieba.channel.b.a(this);
        aga();
        agd();
        this.cts.a(this.ctu, this.mPn, 20);
        this.ctr.showLoadingView();
    }

    private void agd() {
        registerListener(2016511, this.ctE);
        registerListener(2016512, this.ctE);
    }

    private void aga() {
        registerListener(this.ctz);
        registerListener(this.ctA);
        registerListener(this.ctB);
        registerListener(this.ctC);
        registerListener(this.ctD);
    }

    private void initData() {
        this.ctu = getIntent().getLongExtra("channel_id", 0L);
        this.ctv = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ctr.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ctr.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ctr.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ctr.onChangeSkinType(i);
        if (this.ctt != null) {
            this.ctt.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.channel.view.b
    public void a(int i, View view2, Object obj, int i2) {
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
                if (SO() && this.cty != null && this.cty.agj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0084a.a(this.cty.agj().getChannelId(), getUniqueId())));
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.ctu)));
                iP(5);
                return;
            case 11:
                if (this.cty != null && this.cty.agj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.cty.agj())));
                    iP(3);
                    return;
                }
                return;
            case 12:
                if (this.cty != null && this.cty.agj() != null) {
                    this.cty.agj().isPushOpen();
                    this.ctt.b(this.cty);
                    this.ctt.age();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.cty != null && this.cty.agj() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.cts.b(this.cty.agj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.cty != null && this.cty.agj() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.cts.a(this.cty.agj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.cty != null && this.cty.agj() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.cts.c(this.cty.agj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.cty != null && this.cty.agj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.cty.agj().getChannelId(), getUniqueId())));
                    iP(5);
                    return;
                }
                return;
            case 18:
                if (this.cty != null && this.cty.agj() != null) {
                    long channelId = this.cty.agj().getChannelId();
                    boolean isPushOpen = this.cty.agj().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.Vh = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    iP(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.cty != null && this.cty.agj() != null) {
                    kI(this.cty.agj().getChannelCover());
                    iP(1);
                    return;
                }
                return;
            case 20:
                if (this.cty != null && this.cty.agj() != null) {
                    kI(this.cty.agj().getChannelAvatar());
                    iP(2);
                    return;
                }
                return;
            case 21:
                if (this.cty != null && this.cty.agj() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.ctu)));
                    if (this.cty.isHost()) {
                        iP(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void kI(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.ctr.agF();
        this.ctr.showLoadingView();
        this.mPn = 1;
        this.cts.a(this.ctu, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.Vg;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.cty != null && this.cty.agj() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.Vh) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(d.k.channel_need_push), 1).show();
                    } else {
                        showToast(d.k.success_open_channel_push);
                    }
                } else {
                    showToast(d.k.success_close_channel_push);
                }
                this.cty.agj().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.Vg;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cty != null && this.cty.agj() != null) {
            this.cty.agj().setFansCount(this.cty.agj().getFansCount() + (-1) > 0 ? this.cty.agj().getFansCount() - 1 : 0);
            this.cty.agj().setIsSubscribe(0);
            this.cty.agj().setPushOpenOrClose(false);
            this.ctr.e(this.cty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.Vg;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cty != null && this.cty.agj() != null) {
            this.cty.agj().setFansCount(this.cty.agj().getFansCount() + 1);
            this.cty.agj().setIsSubscribe(1);
            this.ctr.e(this.cty);
            if (aVar.Vf == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.cty.agj().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cty != null && this.cty.agl() && !this.cts.agu()) {
            this.ctr.agE();
            this.mPn++;
            this.cts.a(this.ctu, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.channel.data.d dVar) {
        TiebaStatic.logPagePV(new al("c11935").r("obj_type", dVar.isHost() ? 1 : 2).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.ctv).f(VideoPlayActivityConfig.OBJ_ID, dVar.agj().getChannelId()));
    }

    private void iP(int i) {
        if (this.cty != null && this.cty.agj() != null) {
            ChannelInfo agj = this.cty.agj();
            al alVar = new al(this.cty.isHost() ? "c11937" : "c11936");
            alVar.f(VideoPlayActivityConfig.OBJ_ID, agj.getChannelId());
            alVar.r("obj_locate", i);
            TiebaStatic.log(alVar);
        }
    }

    private boolean SO() {
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
                    this.ctr.showLoadingView();
                    this.mPn = 1;
                    this.cts.a(this.ctu, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
