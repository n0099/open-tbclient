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
    private i dcn;
    private ChannelHomeModel dco;
    private a dcp;
    private long dcq;
    private int dcr = -1;
    private boolean dcs = false;
    private d dct = null;
    private int mPn = 1;
    private HttpMessageListener dcv = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.dct != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> are = ChannelHomeActivity.this.dct.are();
                        if (hVar != null && are != null) {
                            are.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.dcn.h(ChannelHomeActivity.this.dct);
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
    private HttpMessageListener dcw = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.dct != null && ChannelHomeActivity.this.dct.ard() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> are = ChannelHomeActivity.this.dct.are();
                        if (hVar != null && are != null) {
                            are.remove(hVar);
                            are.checkBigVideoType();
                            ChannelInfo ard = ChannelHomeActivity.this.dct.ard();
                            if (ChannelHomeActivity.this.dct.ard().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.dct.ard().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            ard.setVideoCount(i);
                            ChannelHomeActivity.this.dcn.h(ChannelHomeActivity.this.dct);
                            ChannelHomeActivity.this.dcn.f(ChannelHomeActivity.this.dct);
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
    private com.baidu.adp.framework.listener.a dcx = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.dco.fC(false);
            ChannelHomeActivity.this.dcn.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.dcs) {
                            ChannelHomeActivity.this.dcn.showErrorView();
                            ChannelHomeActivity.this.dcn.abd();
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
                            if (ChannelHomeActivity.this.dct != null) {
                                if (dVar.arb() != null) {
                                    ChannelHomeActivity.this.dct.a(dVar.arb());
                                }
                                ChannelHomeActivity.this.dct.b(dVar.are());
                                ChannelHomeActivity.this.dcn.h(ChannelHomeActivity.this.dct);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.dct = dVar;
                        if (ChannelHomeActivity.this.dcq == 0 && dVar.ard() != null) {
                            ChannelHomeActivity.this.dcq = dVar.ard().getChannelId();
                        }
                        ChannelHomeActivity.this.dcn.g(dVar);
                        if (!ChannelHomeActivity.this.dcs) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.dcs = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener dcy = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> are = ChannelHomeActivity.this.dct.are();
                    if (are != null) {
                        are.unSetTop();
                        are.checkBigVideoType();
                        ChannelHomeActivity.this.dcn.h(ChannelHomeActivity.this.dct);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener dcz = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
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
    private CustomMessageListener dcA = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.dco.a(ChannelHomeActivity.this.dcq, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.dct.a(channelInfo);
                    ChannelHomeActivity.this.dcn.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.dcn = new i(this);
        this.dco = new ChannelHomeModel(this);
        this.dcp = new com.baidu.tieba.channel.b.a(this);
        aqV();
        aqY();
        this.dco.a(this.dcq, this.mPn, 20);
        this.dcn.showLoadingView();
    }

    private void aqY() {
        registerListener(2016511, this.dcA);
        registerListener(2016512, this.dcA);
    }

    private void aqV() {
        registerListener(this.dcv);
        registerListener(this.dcw);
        registerListener(this.dcx);
        registerListener(this.dcy);
        registerListener(this.dcz);
    }

    private void initData() {
        this.dcq = getIntent().getLongExtra("channel_id", 0L);
        this.dcr = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dcn.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dcn.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dcn.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dcn.onChangeSkinType(i);
        if (this.dcp != null) {
            this.dcp.onChangeSkinType(i);
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
                if (adI() && this.dct != null && this.dct.ard() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0156a.a(this.dct.ard().getChannelId(), getUniqueId())));
                    kR(4);
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
                    kR(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.dcq)));
                kR(5);
                return;
            case 11:
                if (this.dct != null && this.dct.ard() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.dct.ard())));
                    kR(3);
                    return;
                }
                return;
            case 12:
                if (this.dct != null && this.dct.ard() != null) {
                    this.dct.ard().isPushOpen();
                    this.dcp.b(this.dct);
                    this.dcp.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.dct != null && this.dct.ard() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.dco.b(this.dct.ard().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.dct != null && this.dct.ard() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.dco.a(this.dct.ard().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.dct != null && this.dct.ard() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.dco.c(this.dct.ard().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.dct != null && this.dct.ard() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.dct.ard().getChannelId(), getUniqueId())));
                    kR(5);
                    return;
                }
                return;
            case 18:
                if (this.dct != null && this.dct.ard() != null) {
                    long channelId = this.dct.ard().getChannelId();
                    boolean isPushOpen = this.dct.ard().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.aoJ = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    kR(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.dct != null && this.dct.ard() != null) {
                    mT(this.dct.ard().getChannelCover());
                    kR(1);
                    return;
                }
                return;
            case 20:
                if (this.dct != null && this.dct.ard() != null) {
                    mT(this.dct.ard().getChannelAvatar());
                    kR(2);
                    return;
                }
                return;
            case 21:
                if (this.dct != null && this.dct.ard() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.dcq)));
                    if (this.dct.isHost()) {
                        kR(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void mT(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.dcn.hideErrorView();
        this.dcn.showLoadingView();
        this.mPn = 1;
        this.dco.a(this.dcq, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.aoI;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.dct != null && this.dct.ard() != null) {
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
                this.dct.ard().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.aoI;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.dct != null && this.dct.ard() != null) {
            this.dct.ard().setFansCount(this.dct.ard().getFansCount() + (-1) > 0 ? this.dct.ard().getFansCount() - 1 : 0);
            this.dct.ard().setIsSubscribe(0);
            this.dct.ard().setPushOpenOrClose(false);
            this.dcn.e(this.dct);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.aoI;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.dct != null && this.dct.ard() != null) {
            this.dct.ard().setFansCount(this.dct.ard().getFansCount() + 1);
            this.dct.ard().setIsSubscribe(1);
            this.dcn.e(this.dct);
            if (aVar.aoH == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.dct.ard().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dct != null && this.dct.arf() && !this.dco.aro()) {
            this.dcn.arw();
            this.mPn++;
            this.dco.a(this.dcq, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new am("c11935").x("obj_type", dVar.isHost() ? 1 : 2).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.dcr).i(VideoPlayActivityConfig.OBJ_ID, dVar.ard().getChannelId()));
    }

    private void kR(int i) {
        if (this.dct != null && this.dct.ard() != null) {
            ChannelInfo ard = this.dct.ard();
            am amVar = new am(this.dct.isHost() ? "c11937" : "c11936");
            amVar.i(VideoPlayActivityConfig.OBJ_ID, ard.getChannelId());
            amVar.x("obj_locate", i);
            TiebaStatic.log(amVar);
        }
    }

    private boolean adI() {
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
                    this.dcn.showLoadingView();
                    this.mPn = 1;
                    this.dco.a(this.dcq, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
