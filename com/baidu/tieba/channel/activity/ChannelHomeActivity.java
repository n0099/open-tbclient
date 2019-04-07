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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ChannelHomeActivity extends BaseActivity implements BdListView.e, b {
    private i emJ;
    private ChannelHomeModel emK;
    private a emL;
    private long emM;
    private int emN = -1;
    private boolean emO = false;
    private d emP = null;
    private int mPn = 1;
    private HttpMessageListener emQ = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.emP != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> aRr = ChannelHomeActivity.this.emP.aRr();
                        if (hVar != null && aRr != null) {
                            aRr.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.emJ.h(ChannelHomeActivity.this.emP);
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
    private HttpMessageListener emR = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.emP != null && ChannelHomeActivity.this.emP.aRq() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> aRr = ChannelHomeActivity.this.emP.aRr();
                        if (hVar != null && aRr != null) {
                            aRr.remove(hVar);
                            aRr.checkBigVideoType();
                            ChannelInfo aRq = ChannelHomeActivity.this.emP.aRq();
                            if (ChannelHomeActivity.this.emP.aRq().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.emP.aRq().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            aRq.setVideoCount(i);
                            ChannelHomeActivity.this.emJ.h(ChannelHomeActivity.this.emP);
                            ChannelHomeActivity.this.emJ.f(ChannelHomeActivity.this.emP);
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
    private com.baidu.adp.framework.listener.a emS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.emK.hX(false);
            ChannelHomeActivity.this.emJ.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.j.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.emO) {
                            ChannelHomeActivity.this.emJ.zX();
                            ChannelHomeActivity.this.emJ.aCt();
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
                            if (ChannelHomeActivity.this.emP != null) {
                                if (dVar.aRo() != null) {
                                    ChannelHomeActivity.this.emP.a(dVar.aRo());
                                }
                                ChannelHomeActivity.this.emP.b(dVar.aRr());
                                ChannelHomeActivity.this.emJ.h(ChannelHomeActivity.this.emP);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.emP = dVar;
                        if (ChannelHomeActivity.this.emM == 0 && dVar.aRq() != null) {
                            ChannelHomeActivity.this.emM = dVar.aRq().getChannelId();
                        }
                        ChannelHomeActivity.this.emJ.g(dVar);
                        if (!ChannelHomeActivity.this.emO) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.emO = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener emT = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> aRr = ChannelHomeActivity.this.emP.aRr();
                    if (aRr != null) {
                        aRr.unSetTop();
                        aRr.checkBigVideoType();
                        ChannelHomeActivity.this.emJ.h(ChannelHomeActivity.this.emP);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener emU = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.bvZ != null) {
                    if (aVar.bvY == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0223a) {
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
    private CustomMessageListener emV = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.emK.a(ChannelHomeActivity.this.emM, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.emP.a(channelInfo);
                    ChannelHomeActivity.this.emJ.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.emJ = new i(this);
        this.emK = new ChannelHomeModel(this);
        this.emL = new com.baidu.tieba.channel.b.a(this);
        aRi();
        aRl();
        this.emK.a(this.emM, this.mPn, 20);
        this.emJ.showLoadingView();
    }

    private void aRl() {
        registerListener(2016511, this.emV);
        registerListener(2016512, this.emV);
    }

    private void aRi() {
        registerListener(this.emQ);
        registerListener(this.emR);
        registerListener(this.emS);
        registerListener(this.emT);
        registerListener(this.emU);
    }

    private void initData() {
        this.emM = getIntent().getLongExtra("channel_id", 0L);
        this.emN = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.emJ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.emJ.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.emJ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.emJ.onChangeSkinType(i);
        if (this.emL != null) {
            this.emL.onChangeSkinType(i);
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
                if (aEY() && this.emP != null && this.emP.aRq() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0223a.a(this.emP.aRq().getChannelId(), getUniqueId())));
                    oq(4);
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
                    oq(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.emM)));
                oq(5);
                return;
            case 11:
                if (this.emP != null && this.emP.aRq() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.emP.aRq())));
                    oq(3);
                    return;
                }
                return;
            case 12:
                if (this.emP != null && this.emP.aRq() != null) {
                    this.emP.aRq().isPushOpen();
                    this.emL.b(this.emP);
                    this.emL.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.emP != null && this.emP.aRq() != null) {
                    showLoadingDialog(getResources().getString(d.j.Waiting));
                    this.emK.b(this.emP.aRq().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.emP != null && this.emP.aRq() != null) {
                    showLoadingDialog(getResources().getString(d.j.Waiting));
                    this.emK.a(this.emP.aRq().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.emP != null && this.emP.aRq() != null) {
                    showLoadingDialog(getResources().getString(d.j.Waiting));
                    this.emK.c(this.emP.aRq().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.emP != null && this.emP.aRq() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.emP.aRq().getChannelId(), getUniqueId())));
                    oq(5);
                    return;
                }
                return;
            case 18:
                if (this.emP != null && this.emP.aRq() != null) {
                    long channelId = this.emP.aRq().getChannelId();
                    boolean isPushOpen = this.emP.aRq().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.bwa = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    oq(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.emP != null && this.emP.aRq() != null) {
                    tK(this.emP.aRq().getChannelCover());
                    oq(1);
                    return;
                }
                return;
            case 20:
                if (this.emP != null && this.emP.aRq() != null) {
                    tK(this.emP.aRq().getChannelAvatar());
                    oq(2);
                    return;
                }
                return;
            case 21:
                if (this.emP != null && this.emP.aRq() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.emM)));
                    if (this.emP.isHost()) {
                        oq(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void tK(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.emJ.zY();
        this.emJ.showLoadingView();
        this.mPn = 1;
        this.emK.a(this.emM, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.bvZ;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.emP != null && this.emP.aRq() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.bwa) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(d.j.channel_need_push), 1).show();
                    } else {
                        showToast(d.j.success_open_channel_push);
                    }
                } else {
                    showToast(d.j.success_close_channel_push);
                }
                this.emP.aRq().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bvZ;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.emP != null && this.emP.aRq() != null) {
            this.emP.aRq().setFansCount(this.emP.aRq().getFansCount() + (-1) > 0 ? this.emP.aRq().getFansCount() - 1 : 0);
            this.emP.aRq().setIsSubscribe(0);
            this.emP.aRq().setPushOpenOrClose(false);
            this.emJ.e(this.emP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bvZ;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.emP != null && this.emP.aRq() != null) {
            this.emP.aRq().setFansCount(this.emP.aRq().getFansCount() + 1);
            this.emP.aRq().setIsSubscribe(1);
            this.emJ.e(this.emP);
            if (aVar.bvY == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.emP.aRq().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.emP != null && this.emP.aRs() && !this.emK.aRB()) {
            this.emJ.aRJ();
            this.mPn++;
            this.emK.a(this.emM, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.channel.data.d dVar) {
        TiebaStatic.logPagePV(new am("c11935").T("obj_type", dVar.isHost() ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.emN).k(VideoPlayActivityConfig.OBJ_ID, dVar.aRq().getChannelId()));
    }

    private void oq(int i) {
        if (this.emP != null && this.emP.aRq() != null) {
            ChannelInfo aRq = this.emP.aRq();
            am amVar = new am(this.emP.isHost() ? "c11937" : "c11936");
            amVar.k(VideoPlayActivityConfig.OBJ_ID, aRq.getChannelId());
            amVar.T("obj_locate", i);
            TiebaStatic.log(amVar);
        }
    }

    private boolean aEY() {
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
                    this.emJ.showLoadingView();
                    this.mPn = 1;
                    this.emK.a(this.emM, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
