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
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
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
    private i dbw;
    private ChannelHomeModel dbx;
    private a dby;
    private long dbz;
    private int dbA = -1;
    private boolean dbB = false;
    private d dbC = null;
    private int mPn = 1;
    private HttpMessageListener dbD = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.dbC != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> amj = ChannelHomeActivity.this.dbC.amj();
                        if (hVar != null && amj != null) {
                            amj.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.dbw.h(ChannelHomeActivity.this.dbC);
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
    private HttpMessageListener dbE = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.dbC != null && ChannelHomeActivity.this.dbC.ami() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> amj = ChannelHomeActivity.this.dbC.amj();
                        if (hVar != null && amj != null) {
                            amj.remove(hVar);
                            amj.checkBigVideoType();
                            ChannelInfo ami = ChannelHomeActivity.this.dbC.ami();
                            if (ChannelHomeActivity.this.dbC.ami().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.dbC.ami().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            ami.setVideoCount(i);
                            ChannelHomeActivity.this.dbw.h(ChannelHomeActivity.this.dbC);
                            ChannelHomeActivity.this.dbw.f(ChannelHomeActivity.this.dbC);
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
    private com.baidu.adp.framework.listener.a dbF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.dbx.eU(false);
            ChannelHomeActivity.this.dbw.VU();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.j.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.dbB) {
                            ChannelHomeActivity.this.dbw.amE();
                            ChannelHomeActivity.this.dbw.XP();
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
                            if (ChannelHomeActivity.this.dbC != null) {
                                if (dVar.amg() != null) {
                                    ChannelHomeActivity.this.dbC.a(dVar.amg());
                                }
                                ChannelHomeActivity.this.dbC.b(dVar.amj());
                                ChannelHomeActivity.this.dbw.h(ChannelHomeActivity.this.dbC);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.dbC = dVar;
                        if (ChannelHomeActivity.this.dbz == 0 && dVar.ami() != null) {
                            ChannelHomeActivity.this.dbz = dVar.ami().getChannelId();
                        }
                        ChannelHomeActivity.this.dbw.g(dVar);
                        if (!ChannelHomeActivity.this.dbB) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.dbB = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener dbG = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> amj = ChannelHomeActivity.this.dbC.amj();
                    if (amj != null) {
                        amj.unSetTop();
                        amj.checkBigVideoType();
                        ChannelHomeActivity.this.dbw.h(ChannelHomeActivity.this.dbC);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener dbH = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.aJK != null) {
                    if (aVar.aJJ == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0095a) {
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
    private CustomMessageListener dbI = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.dbx.a(ChannelHomeActivity.this.dbz, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.dbC.a(channelInfo);
                    ChannelHomeActivity.this.dbw.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.dbw = new i(this);
        this.dbx = new ChannelHomeModel(this);
        this.dby = new com.baidu.tieba.channel.b.a(this);
        alZ();
        amc();
        this.dbx.a(this.dbz, this.mPn, 20);
        this.dbw.VT();
    }

    private void amc() {
        registerListener(2016511, this.dbI);
        registerListener(2016512, this.dbI);
    }

    private void alZ() {
        registerListener(this.dbD);
        registerListener(this.dbE);
        registerListener(this.dbF);
        registerListener(this.dbG);
        registerListener(this.dbH);
    }

    private void initData() {
        this.dbz = getIntent().getLongExtra("channel_id", 0L);
        this.dbA = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dbw.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dbw.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dbw.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dbw.onChangeSkinType(i);
        if (this.dby != null) {
            this.dby.onChangeSkinType(i);
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
                if (aap() && this.dbC != null && this.dbC.ami() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0095a.a(this.dbC.ami().getChannelId(), getUniqueId())));
                    lE(4);
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
                    lE(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.dbz)));
                lE(5);
                return;
            case 11:
                if (this.dbC != null && this.dbC.ami() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.dbC.ami())));
                    lE(3);
                    return;
                }
                return;
            case 12:
                if (this.dbC != null && this.dbC.ami() != null) {
                    this.dbC.ami().isPushOpen();
                    this.dby.b(this.dbC);
                    this.dby.amd();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.dbC != null && this.dbC.ami() != null) {
                    showLoadingDialog(getResources().getString(d.j.Waiting));
                    this.dbx.b(this.dbC.ami().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.dbC != null && this.dbC.ami() != null) {
                    showLoadingDialog(getResources().getString(d.j.Waiting));
                    this.dbx.a(this.dbC.ami().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.dbC != null && this.dbC.ami() != null) {
                    showLoadingDialog(getResources().getString(d.j.Waiting));
                    this.dbx.c(this.dbC.ami().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.dbC != null && this.dbC.ami() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.dbC.ami().getChannelId(), getUniqueId())));
                    lE(5);
                    return;
                }
                return;
            case 18:
                if (this.dbC != null && this.dbC.ami() != null) {
                    long channelId = this.dbC.ami().getChannelId();
                    boolean isPushOpen = this.dbC.ami().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.aJL = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    lE(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.dbC != null && this.dbC.ami() != null) {
                    kF(this.dbC.ami().getChannelCover());
                    lE(1);
                    return;
                }
                return;
            case 20:
                if (this.dbC != null && this.dbC.ami() != null) {
                    kF(this.dbC.ami().getChannelAvatar());
                    lE(2);
                    return;
                }
                return;
            case 21:
                if (this.dbC != null && this.dbC.ami() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.dbz)));
                    if (this.dbC.isHost()) {
                        lE(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void kF(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.dbw.amF();
        this.dbw.VT();
        this.mPn = 1;
        this.dbx.a(this.dbz, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.aJK;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.dbC != null && this.dbC.ami() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.aJL) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(d.j.channel_need_push), 1).show();
                    } else {
                        showToast(d.j.success_open_channel_push);
                    }
                } else {
                    showToast(d.j.success_close_channel_push);
                }
                this.dbC.ami().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.aJK;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.dbC != null && this.dbC.ami() != null) {
            this.dbC.ami().setFansCount(this.dbC.ami().getFansCount() + (-1) > 0 ? this.dbC.ami().getFansCount() - 1 : 0);
            this.dbC.ami().setIsSubscribe(0);
            this.dbC.ami().setPushOpenOrClose(false);
            this.dbw.e(this.dbC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.aJK;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.dbC != null && this.dbC.ami() != null) {
            this.dbC.ami().setFansCount(this.dbC.ami().getFansCount() + 1);
            this.dbC.ami().setIsSubscribe(1);
            this.dbw.e(this.dbC);
            if (aVar.aJJ == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.dbC.ami().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dbC != null && this.dbC.amk() && !this.dbx.amt()) {
            this.dbw.amD();
            this.mPn++;
            this.dbx.a(this.dbz, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.channel.data.d dVar) {
        TiebaStatic.logPagePV(new ak("c11935").s("obj_type", dVar.isHost() ? 1 : 2).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.dbA).f("obj_id", dVar.ami().getChannelId()));
    }

    private void lE(int i) {
        if (this.dbC != null && this.dbC.ami() != null) {
            ChannelInfo ami = this.dbC.ami();
            ak akVar = new ak(this.dbC.isHost() ? "c11937" : "c11936");
            akVar.f("obj_id", ami.getChannelId());
            akVar.s("obj_locate", i);
            TiebaStatic.log(akVar);
        }
    }

    private boolean aap() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 3)));
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
                    this.dbw.VT();
                    this.mPn = 1;
                    this.dbx.a(this.dbz, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
