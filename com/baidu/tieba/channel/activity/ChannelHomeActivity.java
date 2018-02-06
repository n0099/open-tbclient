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
    private i dbI;
    private ChannelHomeModel dbJ;
    private a dbK;
    private long dbL;
    private int dbM = -1;
    private boolean dbN = false;
    private d dbO = null;
    private int mPn = 1;
    private HttpMessageListener dbP = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.dbO != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> amk = ChannelHomeActivity.this.dbO.amk();
                        if (hVar != null && amk != null) {
                            amk.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.dbI.h(ChannelHomeActivity.this.dbO);
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
    private HttpMessageListener dbQ = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.dbO != null && ChannelHomeActivity.this.dbO.amj() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> amk = ChannelHomeActivity.this.dbO.amk();
                        if (hVar != null && amk != null) {
                            amk.remove(hVar);
                            amk.checkBigVideoType();
                            ChannelInfo amj = ChannelHomeActivity.this.dbO.amj();
                            if (ChannelHomeActivity.this.dbO.amj().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.dbO.amj().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            amj.setVideoCount(i);
                            ChannelHomeActivity.this.dbI.h(ChannelHomeActivity.this.dbO);
                            ChannelHomeActivity.this.dbI.f(ChannelHomeActivity.this.dbO);
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
    private com.baidu.adp.framework.listener.a dbR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.dbJ.eU(false);
            ChannelHomeActivity.this.dbI.VV();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.j.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.dbN) {
                            ChannelHomeActivity.this.dbI.amF();
                            ChannelHomeActivity.this.dbI.XQ();
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
                            if (ChannelHomeActivity.this.dbO != null) {
                                if (dVar.amh() != null) {
                                    ChannelHomeActivity.this.dbO.a(dVar.amh());
                                }
                                ChannelHomeActivity.this.dbO.b(dVar.amk());
                                ChannelHomeActivity.this.dbI.h(ChannelHomeActivity.this.dbO);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.dbO = dVar;
                        if (ChannelHomeActivity.this.dbL == 0 && dVar.amj() != null) {
                            ChannelHomeActivity.this.dbL = dVar.amj().getChannelId();
                        }
                        ChannelHomeActivity.this.dbI.g(dVar);
                        if (!ChannelHomeActivity.this.dbN) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.dbN = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener dbS = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> amk = ChannelHomeActivity.this.dbO.amk();
                    if (amk != null) {
                        amk.unSetTop();
                        amk.checkBigVideoType();
                        ChannelHomeActivity.this.dbI.h(ChannelHomeActivity.this.dbO);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener dbT = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.aJV != null) {
                    if (aVar.aJU == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0094a) {
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
    private CustomMessageListener dbU = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.dbJ.a(ChannelHomeActivity.this.dbL, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.dbO.a(channelInfo);
                    ChannelHomeActivity.this.dbI.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.dbI = new i(this);
        this.dbJ = new ChannelHomeModel(this);
        this.dbK = new com.baidu.tieba.channel.b.a(this);
        ama();
        amd();
        this.dbJ.a(this.dbL, this.mPn, 20);
        this.dbI.VU();
    }

    private void amd() {
        registerListener(2016511, this.dbU);
        registerListener(2016512, this.dbU);
    }

    private void ama() {
        registerListener(this.dbP);
        registerListener(this.dbQ);
        registerListener(this.dbR);
        registerListener(this.dbS);
        registerListener(this.dbT);
    }

    private void initData() {
        this.dbL = getIntent().getLongExtra("channel_id", 0L);
        this.dbM = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dbI.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dbI.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dbI.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dbI.onChangeSkinType(i);
        if (this.dbK != null) {
            this.dbK.onChangeSkinType(i);
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
                if (aaq() && this.dbO != null && this.dbO.amj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0094a.a(this.dbO.amj().getChannelId(), getUniqueId())));
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.dbL)));
                lE(5);
                return;
            case 11:
                if (this.dbO != null && this.dbO.amj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.dbO.amj())));
                    lE(3);
                    return;
                }
                return;
            case 12:
                if (this.dbO != null && this.dbO.amj() != null) {
                    this.dbO.amj().isPushOpen();
                    this.dbK.b(this.dbO);
                    this.dbK.ame();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.dbO != null && this.dbO.amj() != null) {
                    showLoadingDialog(getResources().getString(d.j.Waiting));
                    this.dbJ.b(this.dbO.amj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.dbO != null && this.dbO.amj() != null) {
                    showLoadingDialog(getResources().getString(d.j.Waiting));
                    this.dbJ.a(this.dbO.amj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.dbO != null && this.dbO.amj() != null) {
                    showLoadingDialog(getResources().getString(d.j.Waiting));
                    this.dbJ.c(this.dbO.amj().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.dbO != null && this.dbO.amj() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.dbO.amj().getChannelId(), getUniqueId())));
                    lE(5);
                    return;
                }
                return;
            case 18:
                if (this.dbO != null && this.dbO.amj() != null) {
                    long channelId = this.dbO.amj().getChannelId();
                    boolean isPushOpen = this.dbO.amj().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.aJW = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    lE(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.dbO != null && this.dbO.amj() != null) {
                    kF(this.dbO.amj().getChannelCover());
                    lE(1);
                    return;
                }
                return;
            case 20:
                if (this.dbO != null && this.dbO.amj() != null) {
                    kF(this.dbO.amj().getChannelAvatar());
                    lE(2);
                    return;
                }
                return;
            case 21:
                if (this.dbO != null && this.dbO.amj() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.dbL)));
                    if (this.dbO.isHost()) {
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
        this.dbI.amG();
        this.dbI.VU();
        this.mPn = 1;
        this.dbJ.a(this.dbL, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.aJV;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.dbO != null && this.dbO.amj() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.aJW) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(d.j.channel_need_push), 1).show();
                    } else {
                        showToast(d.j.success_open_channel_push);
                    }
                } else {
                    showToast(d.j.success_close_channel_push);
                }
                this.dbO.amj().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.aJV;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.dbO != null && this.dbO.amj() != null) {
            this.dbO.amj().setFansCount(this.dbO.amj().getFansCount() + (-1) > 0 ? this.dbO.amj().getFansCount() - 1 : 0);
            this.dbO.amj().setIsSubscribe(0);
            this.dbO.amj().setPushOpenOrClose(false);
            this.dbI.e(this.dbO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.aJV;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.dbO != null && this.dbO.amj() != null) {
            this.dbO.amj().setFansCount(this.dbO.amj().getFansCount() + 1);
            this.dbO.amj().setIsSubscribe(1);
            this.dbI.e(this.dbO);
            if (aVar.aJU == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.dbO.amj().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dbO != null && this.dbO.aml() && !this.dbJ.amu()) {
            this.dbI.amE();
            this.mPn++;
            this.dbJ.a(this.dbL, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.channel.data.d dVar) {
        TiebaStatic.logPagePV(new ak("c11935").s("obj_type", dVar.isHost() ? 1 : 2).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.dbM).f("obj_id", dVar.amj().getChannelId()));
    }

    private void lE(int i) {
        if (this.dbO != null && this.dbO.amj() != null) {
            ChannelInfo amj = this.dbO.amj();
            ak akVar = new ak(this.dbO.isHost() ? "c11937" : "c11936");
            akVar.f("obj_id", amj.getChannelId());
            akVar.s("obj_locate", i);
            TiebaStatic.log(akVar);
        }
    }

    private boolean aaq() {
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
                    this.dbI.VU();
                    this.mPn = 1;
                    this.dbJ.a(this.dbL, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
