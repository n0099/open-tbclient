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
import com.baidu.tieba.R;
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
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ChannelHomeActivity extends BaseActivity implements BdListView.e, b {
    private i eJi;
    private ChannelHomeModel eJj;
    private a eJk;
    private long eJl;
    private int eJm = -1;
    private boolean eJn = false;
    private d eJo = null;
    private int mPn = 1;
    private HttpMessageListener eJp = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eJo != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> bbi = ChannelHomeActivity.this.eJo.bbi();
                        if (hVar != null && bbi != null) {
                            bbi.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.eJi.h(ChannelHomeActivity.this.eJo);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private HttpMessageListener eJq = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eJo != null && ChannelHomeActivity.this.eJo.bbh() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> bbi = ChannelHomeActivity.this.eJo.bbi();
                        if (hVar != null && bbi != null) {
                            bbi.remove(hVar);
                            bbi.checkBigVideoType();
                            ChannelInfo bbh = ChannelHomeActivity.this.eJo.bbh();
                            if (ChannelHomeActivity.this.eJo.bbh().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.eJo.bbh().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            bbh.setVideoCount(i);
                            ChannelHomeActivity.this.eJi.h(ChannelHomeActivity.this.eJo);
                            ChannelHomeActivity.this.eJi.f(ChannelHomeActivity.this.eJo);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private com.baidu.adp.framework.listener.a eJr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.eJj.iO(false);
            ChannelHomeActivity.this.eJi.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.eJn) {
                            ChannelHomeActivity.this.eJi.BR();
                            ChannelHomeActivity.this.eJi.aKQ();
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
                            if (ChannelHomeActivity.this.eJo != null) {
                                if (dVar.bbf() != null) {
                                    ChannelHomeActivity.this.eJo.a(dVar.bbf());
                                }
                                ChannelHomeActivity.this.eJo.b(dVar.bbi());
                                ChannelHomeActivity.this.eJi.h(ChannelHomeActivity.this.eJo);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.eJo = dVar;
                        if (ChannelHomeActivity.this.eJl == 0 && dVar.bbh() != null) {
                            ChannelHomeActivity.this.eJl = dVar.bbh().getChannelId();
                        }
                        ChannelHomeActivity.this.eJi.g(dVar);
                        if (!ChannelHomeActivity.this.eJn) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.eJn = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener eJs = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> bbi = ChannelHomeActivity.this.eJo.bbi();
                    if (bbi != null) {
                        bbi.unSetTop();
                        bbi.checkBigVideoType();
                        ChannelHomeActivity.this.eJi.h(ChannelHomeActivity.this.eJo);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener eJt = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.bEI != null) {
                    if (aVar.bEH == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0249a) {
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
    private CustomMessageListener eJu = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.eJj.a(ChannelHomeActivity.this.eJl, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.eJo.a(channelInfo);
                    ChannelHomeActivity.this.eJi.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.eJi = new i(this);
        this.eJj = new ChannelHomeModel(this);
        this.eJk = new com.baidu.tieba.channel.b.a(this);
        baZ();
        bbc();
        this.eJj.a(this.eJl, this.mPn, 20);
        this.eJi.showLoadingView();
    }

    private void bbc() {
        registerListener(2016511, this.eJu);
        registerListener(2016512, this.eJu);
    }

    private void baZ() {
        registerListener(this.eJp);
        registerListener(this.eJq);
        registerListener(this.eJr);
        registerListener(this.eJs);
        registerListener(this.eJt);
    }

    private void initData() {
        this.eJl = getIntent().getLongExtra("channel_id", 0L);
        this.eJm = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eJi.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eJi.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eJi.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eJi.onChangeSkinType(i);
        if (this.eJk != null) {
            this.eJk.onChangeSkinType(i);
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
                if (aNw() && this.eJo != null && this.eJo.bbh() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0249a.a(this.eJo.bbh().getChannelId(), getUniqueId())));
                    pP(4);
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
                    pP(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.eJl)));
                pP(5);
                return;
            case 11:
                if (this.eJo != null && this.eJo.bbh() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.eJo.bbh())));
                    pP(3);
                    return;
                }
                return;
            case 12:
                if (this.eJo != null && this.eJo.bbh() != null) {
                    this.eJo.bbh().isPushOpen();
                    this.eJk.b(this.eJo);
                    this.eJk.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.eJo != null && this.eJo.bbh() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eJj.b(this.eJo.bbh().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.eJo != null && this.eJo.bbh() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eJj.a(this.eJo.bbh().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.eJo != null && this.eJo.bbh() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eJj.c(this.eJo.bbh().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.eJo != null && this.eJo.bbh() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.eJo.bbh().getChannelId(), getUniqueId())));
                    pP(5);
                    return;
                }
                return;
            case 18:
                if (this.eJo != null && this.eJo.bbh() != null) {
                    long channelId = this.eJo.bbh().getChannelId();
                    boolean isPushOpen = this.eJo.bbh().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.bEJ = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    pP(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.eJo != null && this.eJo.bbh() != null) {
                    wh(this.eJo.bbh().getChannelCover());
                    pP(1);
                    return;
                }
                return;
            case 20:
                if (this.eJo != null && this.eJo.bbh() != null) {
                    wh(this.eJo.bbh().getChannelAvatar());
                    pP(2);
                    return;
                }
                return;
            case 21:
                if (this.eJo != null && this.eJo.bbh() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.eJl)));
                    if (this.eJo.isHost()) {
                        pP(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void wh(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.eJi.BS();
        this.eJi.showLoadingView();
        this.mPn = 1;
        this.eJj.a(this.eJl, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.bEI;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.eJo != null && this.eJo.bbh() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.bEJ) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(R.string.channel_need_push), 1).show();
                    } else {
                        showToast(R.string.success_open_channel_push);
                    }
                } else {
                    showToast(R.string.success_close_channel_push);
                }
                this.eJo.bbh().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bEI;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eJo != null && this.eJo.bbh() != null) {
            this.eJo.bbh().setFansCount(this.eJo.bbh().getFansCount() + (-1) > 0 ? this.eJo.bbh().getFansCount() - 1 : 0);
            this.eJo.bbh().setIsSubscribe(0);
            this.eJo.bbh().setPushOpenOrClose(false);
            this.eJi.e(this.eJo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bEI;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eJo != null && this.eJo.bbh() != null) {
            this.eJo.bbh().setFansCount(this.eJo.bbh().getFansCount() + 1);
            this.eJo.bbh().setIsSubscribe(1);
            this.eJi.e(this.eJo);
            if (aVar.bEH == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.eJo.bbh().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eJo != null && this.eJo.bbj() && !this.eJj.bbs()) {
            this.eJi.bbA();
            this.mPn++;
            this.eJj.a(this.eJl, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new an("c11935").P("obj_type", dVar.isHost() ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.eJm).n(VideoPlayActivityConfig.OBJ_ID, dVar.bbh().getChannelId()));
    }

    private void pP(int i) {
        if (this.eJo != null && this.eJo.bbh() != null) {
            ChannelInfo bbh = this.eJo.bbh();
            an anVar = new an(this.eJo.isHost() ? "c11937" : "c11936");
            anVar.n(VideoPlayActivityConfig.OBJ_ID, bbh.getChannelId());
            anVar.P("obj_locate", i);
            TiebaStatic.log(anVar);
        }
    }

    private boolean aNw() {
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
                    this.eJi.showLoadingView();
                    this.mPn = 1;
                    this.eJj.a(this.eJl, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
