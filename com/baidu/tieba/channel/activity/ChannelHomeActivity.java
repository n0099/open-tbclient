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
    private ChannelHomeModel cuA;
    private a cuB;
    private long cuC;
    private i cuz;
    private int cuD = -1;
    private boolean cuE = false;
    private d cuF = null;
    private int mPn = 1;
    private HttpMessageListener cuG = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cuF != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> agk = ChannelHomeActivity.this.cuF.agk();
                        if (hVar != null && agk != null) {
                            agk.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.cuz.h(ChannelHomeActivity.this.cuF);
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
    private HttpMessageListener cuH = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cuF != null && ChannelHomeActivity.this.cuF.agj() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> agk = ChannelHomeActivity.this.cuF.agk();
                        if (hVar != null && agk != null) {
                            agk.remove(hVar);
                            agk.checkBigVideoType();
                            ChannelInfo agj = ChannelHomeActivity.this.cuF.agj();
                            if (ChannelHomeActivity.this.cuF.agj().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.cuF.agj().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            agj.setVideoCount(i);
                            ChannelHomeActivity.this.cuz.h(ChannelHomeActivity.this.cuF);
                            ChannelHomeActivity.this.cuz.f(ChannelHomeActivity.this.cuF);
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
    private com.baidu.adp.framework.listener.a cuI = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.cuA.eA(false);
            ChannelHomeActivity.this.cuz.Os();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.k.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.cuE) {
                            ChannelHomeActivity.this.cuz.showErrorView();
                            ChannelHomeActivity.this.cuz.Qn();
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
                            if (ChannelHomeActivity.this.cuF != null) {
                                if (dVar.agh() != null) {
                                    ChannelHomeActivity.this.cuF.a(dVar.agh());
                                }
                                ChannelHomeActivity.this.cuF.b(dVar.agk());
                                ChannelHomeActivity.this.cuz.h(ChannelHomeActivity.this.cuF);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.cuF = dVar;
                        if (ChannelHomeActivity.this.cuC == 0 && dVar.agj() != null) {
                            ChannelHomeActivity.this.cuC = dVar.agj().getChannelId();
                        }
                        ChannelHomeActivity.this.cuz.g(dVar);
                        if (!ChannelHomeActivity.this.cuE) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.cuE = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener cuJ = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> agk = ChannelHomeActivity.this.cuF.agk();
                    if (agk != null) {
                        agk.unSetTop();
                        agk.checkBigVideoType();
                        ChannelHomeActivity.this.cuz.h(ChannelHomeActivity.this.cuF);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener cuK = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.Vc != null) {
                    if (aVar.Vb == ChannelHomeActivity.this.getUniqueId()) {
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
    private CustomMessageListener cuL = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.cuA.a(ChannelHomeActivity.this.cuC, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.cuF.a(channelInfo);
                    ChannelHomeActivity.this.cuz.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.cuz = new i(this);
        this.cuA = new ChannelHomeModel(this);
        this.cuB = new com.baidu.tieba.channel.b.a(this);
        aga();
        agd();
        this.cuA.a(this.cuC, this.mPn, 20);
        this.cuz.showLoadingView();
    }

    private void agd() {
        registerListener(2016511, this.cuL);
        registerListener(2016512, this.cuL);
    }

    private void aga() {
        registerListener(this.cuG);
        registerListener(this.cuH);
        registerListener(this.cuI);
        registerListener(this.cuJ);
        registerListener(this.cuK);
    }

    private void initData() {
        this.cuC = getIntent().getLongExtra("channel_id", 0L);
        this.cuD = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cuz.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cuz.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cuz.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cuz.onChangeSkinType(i);
        if (this.cuB != null) {
            this.cuB.onChangeSkinType(i);
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
                if (SS() && this.cuF != null && this.cuF.agj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0084a.a(this.cuF.agj().getChannelId(), getUniqueId())));
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.cuC)));
                iN(5);
                return;
            case 11:
                if (this.cuF != null && this.cuF.agj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.cuF.agj())));
                    iN(3);
                    return;
                }
                return;
            case 12:
                if (this.cuF != null && this.cuF.agj() != null) {
                    this.cuF.agj().isPushOpen();
                    this.cuB.b(this.cuF);
                    this.cuB.age();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.cuF != null && this.cuF.agj() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.cuA.b(this.cuF.agj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.cuF != null && this.cuF.agj() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.cuA.a(this.cuF.agj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.cuF != null && this.cuF.agj() != null) {
                    showLoadingDialog(getResources().getString(d.k.Waiting));
                    this.cuA.c(this.cuF.agj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.cuF != null && this.cuF.agj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.cuF.agj().getChannelId(), getUniqueId())));
                    iN(5);
                    return;
                }
                return;
            case 18:
                if (this.cuF != null && this.cuF.agj() != null) {
                    long channelId = this.cuF.agj().getChannelId();
                    boolean isPushOpen = this.cuF.agj().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.Vd = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    iN(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.cuF != null && this.cuF.agj() != null) {
                    kL(this.cuF.agj().getChannelCover());
                    iN(1);
                    return;
                }
                return;
            case 20:
                if (this.cuF != null && this.cuF.agj() != null) {
                    kL(this.cuF.agj().getChannelAvatar());
                    iN(2);
                    return;
                }
                return;
            case 21:
                if (this.cuF != null && this.cuF.agj() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.cuC)));
                    if (this.cuF.isHost()) {
                        iN(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void kL(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.cuz.agF();
        this.cuz.showLoadingView();
        this.mPn = 1;
        this.cuA.a(this.cuC, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.Vc;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.cuF != null && this.cuF.agj() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.Vd) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(d.k.channel_need_push), 1).show();
                    } else {
                        showToast(d.k.success_open_channel_push);
                    }
                } else {
                    showToast(d.k.success_close_channel_push);
                }
                this.cuF.agj().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.Vc;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cuF != null && this.cuF.agj() != null) {
            this.cuF.agj().setFansCount(this.cuF.agj().getFansCount() + (-1) > 0 ? this.cuF.agj().getFansCount() - 1 : 0);
            this.cuF.agj().setIsSubscribe(0);
            this.cuF.agj().setPushOpenOrClose(false);
            this.cuz.e(this.cuF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.Vc;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cuF != null && this.cuF.agj() != null) {
            this.cuF.agj().setFansCount(this.cuF.agj().getFansCount() + 1);
            this.cuF.agj().setIsSubscribe(1);
            this.cuz.e(this.cuF);
            if (aVar.Vb == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.cuF.agj().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cuF != null && this.cuF.agl() && !this.cuA.agu()) {
            this.cuz.agE();
            this.mPn++;
            this.cuA.a(this.cuC, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.channel.data.d dVar) {
        TiebaStatic.logPagePV(new al("c11935").r("obj_type", dVar.isHost() ? 1 : 2).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.cuD).f(VideoPlayActivityConfig.OBJ_ID, dVar.agj().getChannelId()));
    }

    private void iN(int i) {
        if (this.cuF != null && this.cuF.agj() != null) {
            ChannelInfo agj = this.cuF.agj();
            al alVar = new al(this.cuF.isHost() ? "c11937" : "c11936");
            alVar.f(VideoPlayActivityConfig.OBJ_ID, agj.getChannelId());
            alVar.r("obj_locate", i);
            TiebaStatic.log(alVar);
        }
    }

    private boolean SS() {
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
                    this.cuz.showLoadingView();
                    this.mPn = 1;
                    this.cuA.a(this.cuC, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
