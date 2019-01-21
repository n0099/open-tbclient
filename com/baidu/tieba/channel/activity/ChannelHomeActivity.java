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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ChannelHomeActivity extends BaseActivity implements BdListView.e, b {
    private i ddb;
    private ChannelHomeModel ddc;
    private a ddd;
    private long dde;
    private int ddf = -1;
    private boolean ddg = false;
    private d ddh = null;
    private int mPn = 1;
    private HttpMessageListener ddi = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.ddh != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> arC = ChannelHomeActivity.this.ddh.arC();
                        if (hVar != null && arC != null) {
                            arC.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.ddb.h(ChannelHomeActivity.this.ddh);
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
    private HttpMessageListener ddj = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.ddh != null && ChannelHomeActivity.this.ddh.arB() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> arC = ChannelHomeActivity.this.ddh.arC();
                        if (hVar != null && arC != null) {
                            arC.remove(hVar);
                            arC.checkBigVideoType();
                            ChannelInfo arB = ChannelHomeActivity.this.ddh.arB();
                            if (ChannelHomeActivity.this.ddh.arB().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.ddh.arB().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            arB.setVideoCount(i);
                            ChannelHomeActivity.this.ddb.h(ChannelHomeActivity.this.ddh);
                            ChannelHomeActivity.this.ddb.f(ChannelHomeActivity.this.ddh);
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
    private com.baidu.adp.framework.listener.a ddk = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.ddc.fF(false);
            ChannelHomeActivity.this.ddb.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.ddg) {
                            ChannelHomeActivity.this.ddb.showErrorView();
                            ChannelHomeActivity.this.ddb.abA();
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
                            if (ChannelHomeActivity.this.ddh != null) {
                                if (dVar.arz() != null) {
                                    ChannelHomeActivity.this.ddh.a(dVar.arz());
                                }
                                ChannelHomeActivity.this.ddh.b(dVar.arC());
                                ChannelHomeActivity.this.ddb.h(ChannelHomeActivity.this.ddh);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.ddh = dVar;
                        if (ChannelHomeActivity.this.dde == 0 && dVar.arB() != null) {
                            ChannelHomeActivity.this.dde = dVar.arB().getChannelId();
                        }
                        ChannelHomeActivity.this.ddb.g(dVar);
                        if (!ChannelHomeActivity.this.ddg) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.ddg = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener ddl = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> arC = ChannelHomeActivity.this.ddh.arC();
                    if (arC != null) {
                        arC.unSetTop();
                        arC.checkBigVideoType();
                        ChannelHomeActivity.this.ddb.h(ChannelHomeActivity.this.ddh);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener ddm = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.apl != null) {
                    if (aVar.apk == ChannelHomeActivity.this.getUniqueId()) {
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
    private CustomMessageListener ddn = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.ddc.a(ChannelHomeActivity.this.dde, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.ddh.a(channelInfo);
                    ChannelHomeActivity.this.ddb.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.ddb = new i(this);
        this.ddc = new ChannelHomeModel(this);
        this.ddd = new com.baidu.tieba.channel.b.a(this);
        art();
        arw();
        this.ddc.a(this.dde, this.mPn, 20);
        this.ddb.showLoadingView();
    }

    private void arw() {
        registerListener(2016511, this.ddn);
        registerListener(2016512, this.ddn);
    }

    private void art() {
        registerListener(this.ddi);
        registerListener(this.ddj);
        registerListener(this.ddk);
        registerListener(this.ddl);
        registerListener(this.ddm);
    }

    private void initData() {
        this.dde = getIntent().getLongExtra("channel_id", 0L);
        this.ddf = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ddb.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ddb.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ddb.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ddb.onChangeSkinType(i);
        if (this.ddd != null) {
            this.ddd.onChangeSkinType(i);
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
                if (aef() && this.ddh != null && this.ddh.arB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0156a.a(this.ddh.arB().getChannelId(), getUniqueId())));
                    kS(4);
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
                    kS(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.dde)));
                kS(5);
                return;
            case 11:
                if (this.ddh != null && this.ddh.arB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.ddh.arB())));
                    kS(3);
                    return;
                }
                return;
            case 12:
                if (this.ddh != null && this.ddh.arB() != null) {
                    this.ddh.arB().isPushOpen();
                    this.ddd.b(this.ddh);
                    this.ddd.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.ddh != null && this.ddh.arB() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.ddc.b(this.ddh.arB().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.ddh != null && this.ddh.arB() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.ddc.a(this.ddh.arB().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.ddh != null && this.ddh.arB() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.ddc.c(this.ddh.arB().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.ddh != null && this.ddh.arB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.ddh.arB().getChannelId(), getUniqueId())));
                    kS(5);
                    return;
                }
                return;
            case 18:
                if (this.ddh != null && this.ddh.arB() != null) {
                    long channelId = this.ddh.arB().getChannelId();
                    boolean isPushOpen = this.ddh.arB().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.apm = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    kS(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.ddh != null && this.ddh.arB() != null) {
                    nj(this.ddh.arB().getChannelCover());
                    kS(1);
                    return;
                }
                return;
            case 20:
                if (this.ddh != null && this.ddh.arB() != null) {
                    nj(this.ddh.arB().getChannelAvatar());
                    kS(2);
                    return;
                }
                return;
            case 21:
                if (this.ddh != null && this.ddh.arB() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.dde)));
                    if (this.ddh.isHost()) {
                        kS(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void nj(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.ddb.hideErrorView();
        this.ddb.showLoadingView();
        this.mPn = 1;
        this.ddc.a(this.dde, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.apl;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.ddh != null && this.ddh.arB() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.apm) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(e.j.channel_need_push), 1).show();
                    } else {
                        showToast(e.j.success_open_channel_push);
                    }
                } else {
                    showToast(e.j.success_close_channel_push);
                }
                this.ddh.arB().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.apl;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.ddh != null && this.ddh.arB() != null) {
            this.ddh.arB().setFansCount(this.ddh.arB().getFansCount() + (-1) > 0 ? this.ddh.arB().getFansCount() - 1 : 0);
            this.ddh.arB().setIsSubscribe(0);
            this.ddh.arB().setPushOpenOrClose(false);
            this.ddb.e(this.ddh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.apl;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.ddh != null && this.ddh.arB() != null) {
            this.ddh.arB().setFansCount(this.ddh.arB().getFansCount() + 1);
            this.ddh.arB().setIsSubscribe(1);
            this.ddb.e(this.ddh);
            if (aVar.apk == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.ddh.arB().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ddh != null && this.ddh.arD() && !this.ddc.arM()) {
            this.ddb.arU();
            this.mPn++;
            this.ddc.a(this.dde, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new am("c11935").y("obj_type", dVar.isHost() ? 1 : 2).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.ddf).i(VideoPlayActivityConfig.OBJ_ID, dVar.arB().getChannelId()));
    }

    private void kS(int i) {
        if (this.ddh != null && this.ddh.arB() != null) {
            ChannelInfo arB = this.ddh.arB();
            am amVar = new am(this.ddh.isHost() ? "c11937" : "c11936");
            amVar.i(VideoPlayActivityConfig.OBJ_ID, arB.getChannelId());
            amVar.y("obj_locate", i);
            TiebaStatic.log(amVar);
        }
    }

    private boolean aef() {
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
                    this.ddb.showLoadingView();
                    this.mPn = 1;
                    this.ddc.a(this.dde, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
