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
    private i cto;
    private ChannelHomeModel ctp;
    private a ctq;
    private long ctr;
    private int cts = -1;
    private boolean ctt = false;
    private d ctu = null;
    private int mPn = 1;
    private HttpMessageListener ctv = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.ctu != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> agk = ChannelHomeActivity.this.ctu.agk();
                        if (hVar != null && agk != null) {
                            agk.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.cto.h(ChannelHomeActivity.this.ctu);
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
    private HttpMessageListener ctw = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.ctu != null && ChannelHomeActivity.this.ctu.agj() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> agk = ChannelHomeActivity.this.ctu.agk();
                        if (hVar != null && agk != null) {
                            agk.remove(hVar);
                            agk.checkBigVideoType();
                            ChannelInfo agj = ChannelHomeActivity.this.ctu.agj();
                            if (ChannelHomeActivity.this.ctu.agj().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.ctu.agj().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            agj.setVideoCount(i);
                            ChannelHomeActivity.this.cto.h(ChannelHomeActivity.this.ctu);
                            ChannelHomeActivity.this.cto.f(ChannelHomeActivity.this.ctu);
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
    private com.baidu.adp.framework.listener.a cty = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.ctp.ez(false);
            ChannelHomeActivity.this.cto.Ou();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.k.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.ctt) {
                            ChannelHomeActivity.this.cto.showErrorView();
                            ChannelHomeActivity.this.cto.Qq();
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
                            if (ChannelHomeActivity.this.ctu != null) {
                                if (dVar.agh() != null) {
                                    ChannelHomeActivity.this.ctu.a(dVar.agh());
                                }
                                ChannelHomeActivity.this.ctu.b(dVar.agk());
                                ChannelHomeActivity.this.cto.h(ChannelHomeActivity.this.ctu);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.ctu = dVar;
                        if (ChannelHomeActivity.this.ctr == 0 && dVar.agj() != null) {
                            ChannelHomeActivity.this.ctr = dVar.agj().getChannelId();
                        }
                        ChannelHomeActivity.this.cto.g(dVar);
                        if (!ChannelHomeActivity.this.ctt) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.ctt = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener ctz = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> agk = ChannelHomeActivity.this.ctu.agk();
                    if (agk != null) {
                        agk.unSetTop();
                        agk.checkBigVideoType();
                        ChannelHomeActivity.this.cto.h(ChannelHomeActivity.this.ctu);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener ctA = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
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
    private CustomMessageListener ctB = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.ctp.a(ChannelHomeActivity.this.ctr, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.ctu.a(channelInfo);
                    ChannelHomeActivity.this.cto.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.cto = new i(this);
        this.ctp = new ChannelHomeModel(this);
        this.ctq = new com.baidu.tieba.channel.b.a(this);
        aga();
        agd();
        this.ctp.a(this.ctr, this.mPn, 20);
        this.cto.showLoadingView();
    }

    private void agd() {
        registerListener(2016511, this.ctB);
        registerListener(2016512, this.ctB);
    }

    private void aga() {
        registerListener(this.ctv);
        registerListener(this.ctw);
        registerListener(this.cty);
        registerListener(this.ctz);
        registerListener(this.ctA);
    }

    private void initData() {
        this.ctr = getIntent().getLongExtra("channel_id", 0L);
        this.cts = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cto.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cto.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cto.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cto.onChangeSkinType(i);
        if (this.ctq != null) {
            this.ctq.onChangeSkinType(i);
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
                if (SO() && this.ctu != null && this.ctu.agj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0084a.a(this.ctu.agj().getChannelId(), getUniqueId())));
                    iO(4);
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
                    iO(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.ctr)));
                iO(5);
                return;
            case 11:
                if (this.ctu != null && this.ctu.agj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.ctu.agj())));
                    iO(3);
                    return;
                }
                return;
            case 12:
                if (this.ctu != null && this.ctu.agj() != null) {
                    this.ctu.agj().isPushOpen();
                    this.ctq.b(this.ctu);
                    this.ctq.age();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.ctu != null && this.ctu.agj() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.ctp.b(this.ctu.agj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.ctu != null && this.ctu.agj() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.ctp.a(this.ctu.agj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.ctu != null && this.ctu.agj() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.ctp.c(this.ctu.agj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.ctu != null && this.ctu.agj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.ctu.agj().getChannelId(), getUniqueId())));
                    iO(5);
                    return;
                }
                return;
            case 18:
                if (this.ctu != null && this.ctu.agj() != null) {
                    long channelId = this.ctu.agj().getChannelId();
                    boolean isPushOpen = this.ctu.agj().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.Vh = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    iO(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.ctu != null && this.ctu.agj() != null) {
                    kI(this.ctu.agj().getChannelCover());
                    iO(1);
                    return;
                }
                return;
            case 20:
                if (this.ctu != null && this.ctu.agj() != null) {
                    kI(this.ctu.agj().getChannelAvatar());
                    iO(2);
                    return;
                }
                return;
            case 21:
                if (this.ctu != null && this.ctu.agj() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.ctr)));
                    if (this.ctu.isHost()) {
                        iO(4);
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
        this.cto.agF();
        this.cto.showLoadingView();
        this.mPn = 1;
        this.ctp.a(this.ctr, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.Vg;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.ctu != null && this.ctu.agj() != null) {
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
                this.ctu.agj().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.Vg;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.ctu != null && this.ctu.agj() != null) {
            this.ctu.agj().setFansCount(this.ctu.agj().getFansCount() + (-1) > 0 ? this.ctu.agj().getFansCount() - 1 : 0);
            this.ctu.agj().setIsSubscribe(0);
            this.ctu.agj().setPushOpenOrClose(false);
            this.cto.e(this.ctu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.Vg;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.ctu != null && this.ctu.agj() != null) {
            this.ctu.agj().setFansCount(this.ctu.agj().getFansCount() + 1);
            this.ctu.agj().setIsSubscribe(1);
            this.cto.e(this.ctu);
            if (aVar.Vf == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.ctu.agj().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ctu != null && this.ctu.agl() && !this.ctp.agu()) {
            this.cto.agE();
            this.mPn++;
            this.ctp.a(this.ctr, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.channel.data.d dVar) {
        TiebaStatic.logPagePV(new al("c11935").r("obj_type", dVar.isHost() ? 1 : 2).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.cts).f(VideoPlayActivityConfig.OBJ_ID, dVar.agj().getChannelId()));
    }

    private void iO(int i) {
        if (this.ctu != null && this.ctu.agj() != null) {
            ChannelInfo agj = this.ctu.agj();
            al alVar = new al(this.ctu.isHost() ? "c11937" : "c11936");
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
                    this.cto.showLoadingView();
                    this.mPn = 1;
                    this.ctp.a(this.ctr, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
