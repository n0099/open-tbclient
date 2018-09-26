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
    private i cJp;
    private ChannelHomeModel cJq;
    private a cJr;
    private long cJs;
    private int cJt = -1;
    private boolean cJu = false;
    private d cJv = null;
    private int mPn = 1;
    private HttpMessageListener cJw = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cJv != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> aly = ChannelHomeActivity.this.cJv.aly();
                        if (hVar != null && aly != null) {
                            aly.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.cJp.h(ChannelHomeActivity.this.cJv);
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
    private HttpMessageListener cJx = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.cJv != null && ChannelHomeActivity.this.cJv.alx() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> aly = ChannelHomeActivity.this.cJv.aly();
                        if (hVar != null && aly != null) {
                            aly.remove(hVar);
                            aly.checkBigVideoType();
                            ChannelInfo alx = ChannelHomeActivity.this.cJv.alx();
                            if (ChannelHomeActivity.this.cJv.alx().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.cJv.alx().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            alx.setVideoCount(i);
                            ChannelHomeActivity.this.cJp.h(ChannelHomeActivity.this.cJv);
                            ChannelHomeActivity.this.cJp.f(ChannelHomeActivity.this.cJv);
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
    private com.baidu.adp.framework.listener.a cJy = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.cJq.eW(false);
            ChannelHomeActivity.this.cJp.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.cJu) {
                            ChannelHomeActivity.this.cJp.alS();
                            ChannelHomeActivity.this.cJp.Wd();
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
                            if (ChannelHomeActivity.this.cJv != null) {
                                if (dVar.alv() != null) {
                                    ChannelHomeActivity.this.cJv.a(dVar.alv());
                                }
                                ChannelHomeActivity.this.cJv.b(dVar.aly());
                                ChannelHomeActivity.this.cJp.h(ChannelHomeActivity.this.cJv);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.cJv = dVar;
                        if (ChannelHomeActivity.this.cJs == 0 && dVar.alx() != null) {
                            ChannelHomeActivity.this.cJs = dVar.alx().getChannelId();
                        }
                        ChannelHomeActivity.this.cJp.g(dVar);
                        if (!ChannelHomeActivity.this.cJu) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.cJu = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener cJz = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> aly = ChannelHomeActivity.this.cJv.aly();
                    if (aly != null) {
                        aly.unSetTop();
                        aly.checkBigVideoType();
                        ChannelHomeActivity.this.cJp.h(ChannelHomeActivity.this.cJv);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener cJA = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.afw != null) {
                    if (aVar.afv == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0098a) {
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
    private CustomMessageListener cJB = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.cJq.a(ChannelHomeActivity.this.cJs, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.cJv.a(channelInfo);
                    ChannelHomeActivity.this.cJp.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.cJp = new i(this);
        this.cJq = new ChannelHomeModel(this);
        this.cJr = new com.baidu.tieba.channel.b.a(this);
        alp();
        als();
        this.cJq.a(this.cJs, this.mPn, 20);
        this.cJp.showLoadingView();
    }

    private void als() {
        registerListener(2016511, this.cJB);
        registerListener(2016512, this.cJB);
    }

    private void alp() {
        registerListener(this.cJw);
        registerListener(this.cJx);
        registerListener(this.cJy);
        registerListener(this.cJz);
        registerListener(this.cJA);
    }

    private void initData() {
        this.cJs = getIntent().getLongExtra("channel_id", 0L);
        this.cJt = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cJp.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cJp.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cJp.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cJp.onChangeSkinType(i);
        if (this.cJr != null) {
            this.cJr.onChangeSkinType(i);
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
                if (YL() && this.cJv != null && this.cJv.alx() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0098a.a(this.cJv.alx().getChannelId(), getUniqueId())));
                    jx(4);
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
                    jx(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.cJs)));
                jx(5);
                return;
            case 11:
                if (this.cJv != null && this.cJv.alx() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.cJv.alx())));
                    jx(3);
                    return;
                }
                return;
            case 12:
                if (this.cJv != null && this.cJv.alx() != null) {
                    this.cJv.alx().isPushOpen();
                    this.cJr.b(this.cJv);
                    this.cJr.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.cJv != null && this.cJv.alx() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.cJq.b(this.cJv.alx().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.cJv != null && this.cJv.alx() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.cJq.a(this.cJv.alx().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.cJv != null && this.cJv.alx() != null) {
                    showLoadingDialog(getResources().getString(e.j.Waiting));
                    this.cJq.c(this.cJv.alx().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.cJv != null && this.cJv.alx() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.cJv.alx().getChannelId(), getUniqueId())));
                    jx(5);
                    return;
                }
                return;
            case 18:
                if (this.cJv != null && this.cJv.alx() != null) {
                    long channelId = this.cJv.alx().getChannelId();
                    boolean isPushOpen = this.cJv.alx().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.afx = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    jx(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.cJv != null && this.cJv.alx() != null) {
                    lO(this.cJv.alx().getChannelCover());
                    jx(1);
                    return;
                }
                return;
            case 20:
                if (this.cJv != null && this.cJv.alx() != null) {
                    lO(this.cJv.alx().getChannelAvatar());
                    jx(2);
                    return;
                }
                return;
            case 21:
                if (this.cJv != null && this.cJv.alx() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.cJs)));
                    if (this.cJv.isHost()) {
                        jx(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void lO(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.cJp.alT();
        this.cJp.showLoadingView();
        this.mPn = 1;
        this.cJq.a(this.cJs, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.afw;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.cJv != null && this.cJv.alx() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.afx) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(e.j.channel_need_push), 1).show();
                    } else {
                        showToast(e.j.success_open_channel_push);
                    }
                } else {
                    showToast(e.j.success_close_channel_push);
                }
                this.cJv.alx().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.afw;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cJv != null && this.cJv.alx() != null) {
            this.cJv.alx().setFansCount(this.cJv.alx().getFansCount() + (-1) > 0 ? this.cJv.alx().getFansCount() - 1 : 0);
            this.cJv.alx().setIsSubscribe(0);
            this.cJv.alx().setPushOpenOrClose(false);
            this.cJp.e(this.cJv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.afw;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.cJv != null && this.cJv.alx() != null) {
            this.cJv.alx().setFansCount(this.cJv.alx().getFansCount() + 1);
            this.cJv.alx().setIsSubscribe(1);
            this.cJp.e(this.cJv);
            if (aVar.afv == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.cJv.alx().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cJv != null && this.cJv.alz() && !this.cJq.alI()) {
            this.cJp.alR();
            this.mPn++;
            this.cJq.a(this.cJs, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new am("c11935").w("obj_type", dVar.isHost() ? 1 : 2).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.cJt).g(VideoPlayActivityConfig.OBJ_ID, dVar.alx().getChannelId()));
    }

    private void jx(int i) {
        if (this.cJv != null && this.cJv.alx() != null) {
            ChannelInfo alx = this.cJv.alx();
            am amVar = new am(this.cJv.isHost() ? "c11937" : "c11936");
            amVar.g(VideoPlayActivityConfig.OBJ_ID, alx.getChannelId());
            amVar.w("obj_locate", i);
            TiebaStatic.log(amVar);
        }
    }

    private boolean YL() {
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
                    this.cJp.showLoadingView();
                    this.mPn = 1;
                    this.cJq.a(this.cJs, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
