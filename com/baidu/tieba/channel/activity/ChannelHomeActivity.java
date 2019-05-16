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
    private i eCv;
    private ChannelHomeModel eCw;
    private a eCx;
    private long eCy;
    private int eCz = -1;
    private boolean eCA = false;
    private d eCB = null;
    private int mPn = 1;
    private HttpMessageListener eCC = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eCB != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> aYA = ChannelHomeActivity.this.eCB.aYA();
                        if (hVar != null && aYA != null) {
                            aYA.setTopAndRemoveOldTop(hVar);
                            ChannelHomeActivity.this.eCv.h(ChannelHomeActivity.this.eCB);
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
    private HttpMessageListener eCD = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoRemoveHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (ChannelHomeActivity.this.eCB != null && ChannelHomeActivity.this.eCB.aYz() != null) {
                        h hVar = (h) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra();
                        ChannelHomeVideoList<h> aYA = ChannelHomeActivity.this.eCB.aYA();
                        if (hVar != null && aYA != null) {
                            aYA.remove(hVar);
                            aYA.checkBigVideoType();
                            ChannelInfo aYz = ChannelHomeActivity.this.eCB.aYz();
                            if (ChannelHomeActivity.this.eCB.aYz().getVideoCount() - 1 > 0) {
                                i = ChannelHomeActivity.this.eCB.aYz().getVideoCount() - 1;
                            } else {
                                i = 0;
                            }
                            aYz.setVideoCount(i);
                            ChannelHomeActivity.this.eCv.h(ChannelHomeActivity.this.eCB);
                            ChannelHomeActivity.this.eCv.f(ChannelHomeActivity.this.eCB);
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
    private com.baidu.adp.framework.listener.a eCE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHANNEL_GET_INFO, 309437) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            ChannelHomeActivity.this.eCw.iC(false);
            ChannelHomeActivity.this.eCv.hideLoadingView();
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ChannelInfoGetSocketResponseMessage) || (responsedMessage instanceof ChannelInfoGetHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ChannelHomeActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        if (!ChannelHomeActivity.this.eCA) {
                            ChannelHomeActivity.this.eCv.Bf();
                            ChannelHomeActivity.this.eCv.aIG();
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
                            if (ChannelHomeActivity.this.eCB != null) {
                                if (dVar.aYx() != null) {
                                    ChannelHomeActivity.this.eCB.a(dVar.aYx());
                                }
                                ChannelHomeActivity.this.eCB.b(dVar.aYA());
                                ChannelHomeActivity.this.eCv.h(ChannelHomeActivity.this.eCB);
                                return;
                            }
                            return;
                        }
                        dVar.checkBigVideoType();
                        ChannelHomeActivity.this.eCB = dVar;
                        if (ChannelHomeActivity.this.eCy == 0 && dVar.aYz() != null) {
                            ChannelHomeActivity.this.eCy = dVar.aYz().getChannelId();
                        }
                        ChannelHomeActivity.this.eCv.g(dVar);
                        if (!ChannelHomeActivity.this.eCA) {
                            ChannelHomeActivity.this.a(dVar);
                            ChannelHomeActivity.this.eCA = true;
                        }
                    }
                }
            }
        }
    };
    private HttpMessageListener eCF = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ChannelHomeActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelVideoUnSetTopHttpResponseMessage)) {
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    ChannelHomeVideoList<h> aYA = ChannelHomeActivity.this.eCB.aYA();
                    if (aYA != null) {
                        aYA.unSetTop();
                        aYA.checkBigVideoType();
                        ChannelHomeActivity.this.eCv.h(ChannelHomeActivity.this.eCB);
                        return;
                    }
                    return;
                }
                ChannelHomeActivity.this.showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? ChannelHomeActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    };
    private CustomMessageListener eCG = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                if (aVar.bDl != null) {
                    if (aVar.bDk == ChannelHomeActivity.this.getUniqueId()) {
                        ChannelHomeActivity.this.closeLoadingDialog();
                    }
                    if (aVar instanceof a.C0238a) {
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
    private CustomMessageListener eCH = new CustomMessageListener(0) { // from class: com.baidu.tieba.channel.activity.ChannelHomeActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016511) {
                    ChannelHomeActivity.this.mPn = 1;
                    ChannelHomeActivity.this.eCw.a(ChannelHomeActivity.this.eCy, ChannelHomeActivity.this.mPn, 20);
                } else if (customResponsedMessage.getCmd() == 2016512 && (data = customResponsedMessage.getData()) != null && (data instanceof ChannelInfo)) {
                    ChannelInfo channelInfo = (ChannelInfo) data;
                    ChannelHomeActivity.this.eCB.a(channelInfo);
                    ChannelHomeActivity.this.eCv.f(channelInfo);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.eCv = new i(this);
        this.eCw = new ChannelHomeModel(this);
        this.eCx = new com.baidu.tieba.channel.b.a(this);
        aYr();
        aYu();
        this.eCw.a(this.eCy, this.mPn, 20);
        this.eCv.showLoadingView();
    }

    private void aYu() {
        registerListener(2016511, this.eCH);
        registerListener(2016512, this.eCH);
    }

    private void aYr() {
        registerListener(this.eCC);
        registerListener(this.eCD);
        registerListener(this.eCE);
        registerListener(this.eCF);
        registerListener(this.eCG);
    }

    private void initData() {
        this.eCy = getIntent().getLongExtra("channel_id", 0L);
        this.eCz = getIntent().getIntExtra(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eCv.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eCv.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eCv.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eCv.onChangeSkinType(i);
        if (this.eCx != null) {
            this.eCx.onChangeSkinType(i);
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
                if (aLi() && this.eCB != null && this.eCB.aYz() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0238a.a(this.eCB.aYz().getChannelId(), getUniqueId())));
                    pu(4);
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
                    pu(3);
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
                sendMessage(new CustomMessage(2002001, new ChannelAddVideoActivityConfig(getBaseContext(), this.eCy)));
                pu(5);
                return;
            case 11:
                if (this.eCB != null && this.eCB.aYz() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelEditActivityConfig(getPageContext().getPageActivity(), this.eCB.aYz())));
                    pu(3);
                    return;
                }
                return;
            case 12:
                if (this.eCB != null && this.eCB.aYz() != null) {
                    this.eCB.aYz().isPushOpen();
                    this.eCx.b(this.eCB);
                    this.eCx.showPopWindow();
                    return;
                }
                return;
            case 13:
                if (obj != null && (obj instanceof h) && this.eCB != null && this.eCB.aYz() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eCw.b(this.eCB.aYz().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 14:
                if (obj != null && (obj instanceof h) && this.eCB != null && this.eCB.aYz() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eCw.a(this.eCB.aYz().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 15:
                if (obj != null && (obj instanceof h) && this.eCB != null && this.eCB.aYz() != null) {
                    showLoadingDialog(getResources().getString(R.string.Waiting));
                    this.eCw.c(this.eCB.aYz().getChannelId(), (h) obj);
                    return;
                }
                return;
            case 16:
            case 17:
                if (this.eCB != null && this.eCB.aYz() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.c.b(this.eCB.aYz().getChannelId(), getUniqueId())));
                    pu(5);
                    return;
                }
                return;
            case 18:
                if (this.eCB != null && this.eCB.aYz() != null) {
                    long channelId = this.eCB.aYz().getChannelId();
                    boolean isPushOpen = this.eCB.aYz().isPushOpen();
                    boolean booleanValue = (obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue();
                    a.b a = a.b.a(channelId, isPushOpen ? false : true, getUniqueId());
                    a.bDm = booleanValue;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a));
                    pu(isPushOpen ? 7 : 6);
                    return;
                }
                return;
            case 19:
                if (this.eCB != null && this.eCB.aYz() != null) {
                    vd(this.eCB.aYz().getChannelCover());
                    pu(1);
                    return;
                }
                return;
            case 20:
                if (this.eCB != null && this.eCB.aYz() != null) {
                    vd(this.eCB.aYz().getChannelAvatar());
                    pu(2);
                    return;
                }
                return;
            case 21:
                if (this.eCB != null && this.eCB.aYz() != null) {
                    sendMessage(new CustomMessage(2002001, new ChannelFansActivityConfig(getBaseContext(), this.eCy)));
                    if (this.eCB.isHost()) {
                        pu(4);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void vd(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        this.eCv.Bg();
        this.eCv.showLoadingView();
        this.mPn = 1;
        this.eCw.a(this.eCy, this.mPn, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        HttpResponsedMessage httpResponsedMessage = bVar.bDl;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
            if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            } else if (this.eCB != null && this.eCB.aYz() != null) {
                boolean z = bVar.isOpen;
                if (z) {
                    if (bVar.bDm) {
                        Toast.makeText(getPageContext().getPageActivity(), getPageContext().getResources().getString(R.string.channel_need_push), 1).show();
                    } else {
                        showToast(R.string.success_open_channel_push);
                    }
                } else {
                    showToast(R.string.success_close_channel_push);
                }
                this.eCB.aYz().setPushOpenOrClose(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bDl;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eCB != null && this.eCB.aYz() != null) {
            this.eCB.aYz().setFansCount(this.eCB.aYz().getFansCount() + (-1) > 0 ? this.eCB.aYz().getFansCount() - 1 : 0);
            this.eCB.aYz().setIsSubscribe(0);
            this.eCB.aYz().setPushOpenOrClose(false);
            this.eCv.e(this.eCB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.b.a aVar) {
        HttpResponsedMessage httpResponsedMessage = aVar.bDl;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            showToast(TextUtils.isEmpty(httpResponsedMessage.getErrorString()) ? getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
        } else if (this.eCB != null && this.eCB.aYz() != null) {
            this.eCB.aYz().setFansCount(this.eCB.aYz().getFansCount() + 1);
            this.eCB.aYz().setIsSubscribe(1);
            this.eCv.e(this.eCB);
            if (aVar.bDk == getUniqueId()) {
                com.baidu.tieba.channel.c.b.a((BaseActivity) this, this.eCB.aYz().isPushOpen(), true, (b) this);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eCB != null && this.eCB.aYB() && !this.eCw.aYK()) {
            this.eCv.aYS();
            this.mPn++;
            this.eCw.a(this.eCy, this.mPn, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        TiebaStatic.logPagePV(new am("c11935").P("obj_type", dVar.isHost() ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.eCz).l(VideoPlayActivityConfig.OBJ_ID, dVar.aYz().getChannelId()));
    }

    private void pu(int i) {
        if (this.eCB != null && this.eCB.aYz() != null) {
            ChannelInfo aYz = this.eCB.aYz();
            am amVar = new am(this.eCB.isHost() ? "c11937" : "c11936");
            amVar.l(VideoPlayActivityConfig.OBJ_ID, aYz.getChannelId());
            amVar.P("obj_locate", i);
            TiebaStatic.log(amVar);
        }
    }

    private boolean aLi() {
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
                    this.eCv.showLoadingView();
                    this.mPn = 1;
                    this.eCw.a(this.eCy, this.mPn, 20);
                    return;
                default:
                    return;
            }
        }
    }
}
