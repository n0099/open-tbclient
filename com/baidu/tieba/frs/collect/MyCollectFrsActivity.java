package com.baidu.tieba.frs.collect;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class MyCollectFrsActivity extends BaseActivity<MyCollectFrsActivity> implements BdListView.e, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c {
    private static final int aZa = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds90);
    private static final int aZb = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds300);
    private String aXW;
    private z aZc;
    private com.baidu.adp.lib.f.b<TbImageView> aZv;
    private com.baidu.adp.lib.f.b<TbImageView> afK;
    private a bge;
    private l bgf;
    private z bgi;
    private long mForumId;
    private String mForumName;
    VoiceManager mVoiceManager;
    private String bgd = null;
    private String forumId = null;
    private p aZs = new p();
    private boolean mHasMore = false;
    private final q.a aZS = new b(this);
    com.baidu.adp.framework.listener.a bgg = new c(this, CmdConfigHttp.CMD_GET_USER_FORUM_STORE, 309112);
    private final bc bgh = new d(this);
    private boolean isNeedRefreshOnResume = false;
    private boolean bgj = false;
    private boolean aZd = false;
    private final NoNetworkView.a aXw = new e(this);
    private CustomMessageListener aYb = new f(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private v aZZ = new g(this);
    private w bac = new i(this);
    private View.OnClickListener Sy = new j(this);

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fU(int i) {
        ArrayList<u> threadList = this.aZs.getThreadList();
        if (threadList != null) {
            Iterator<u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                u next = it.next();
                if (next instanceof z) {
                    z zVar = (z) next;
                    if (zVar == this.aZc) {
                        b(zVar, i);
                        this.aZc = null;
                        break;
                    } else if (zVar.getId() != null && zVar.getId().equals(this.aXW)) {
                        b(zVar, i);
                        this.aXW = null;
                        break;
                    }
                }
            }
            this.bgf.Ot().a(threadList, this.aZs);
        }
    }

    private void b(z zVar, int i) {
        if (i == 1) {
            PraiseData praise = zVar.getPraise();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (praise == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    zVar.setPraise(praiseData);
                    return;
                }
                zVar.getPraise().getUser().add(0, metaData);
                zVar.getPraise().setNum(zVar.getPraise().getNum() + 1);
                zVar.getPraise().setIsLike(i);
            }
        } else if (zVar.getPraise() != null) {
            zVar.getPraise().setIsLike(i);
            zVar.getPraise().setNum(zVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = zVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        zVar.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.jg()) {
            this.bgf.NT();
        } else if (this.mHasMore) {
            MY();
            this.bge.Os();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> Mo() {
        if (this.aZv == null) {
            this.aZv = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.aZv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.bgf == null) {
            return null;
        }
        return this.bgf.getListView();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int wk() {
        if (this.bgf == null) {
            return 0;
        }
        return this.bgf.NJ();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wl() {
        if (this.afK == null) {
            this.afK = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.afK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY() {
        if (this.mHasMore) {
            this.bgf.NR();
        } else if (this.aZs.getThreadList() == null || this.aZs.getThreadList().size() == 0) {
            this.bgf.NT();
        } else {
            this.bgf.gg(aZa - (this.bge.qJ().size() * aZb));
            this.bgf.NS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.mForumId = getIntent().getLongExtra("forum_id", -1L);
        this.aZs.ajy().setName(this.mForumName);
        this.aZs.ajy().setId(String.valueOf(this.mForumId));
        registerListener(this.bgg);
        this.bge = new a(this, this.mForumId);
        this.bge.firstLoadData();
        setContentView(n.g.collect_frs_activity);
        this.bgf = new l(this);
        showLoadingView(this.bgf.getRootView());
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bgf.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    private void initUI() {
        this.bgf.a(this.aZZ);
        this.bgf.a(this.bac);
        this.bgf.a(this.aZS);
        this.bgf.f(this.aXw);
        this.bgf.Ot().b(this.bgh);
        this.bgf.n(this.Sy);
    }

    public void refresh() {
        stopVoice();
        this.bge.JU();
    }

    public void stopVoice() {
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(z zVar) {
        boolean tf = zVar == null ? true : zVar.tf();
        this.bgf.c(new k(this, zVar));
        this.bgf.a(zVar, tf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(z zVar) {
        boolean tf = zVar == null ? true : zVar.tf();
        if (this.bgd != null) {
            if (!tf) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.mForumName, null, 18003, true, true, this.bgj)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.mForumName, null, 18003, false, false, this.bgj)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(z zVar) {
        if (this.bgd != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.mForumName, null, 18003, false, false, this.bgj)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj(String str) {
        if (this.bge.qJ().isEmpty() && this.bgf != null) {
            this.bgf.hk(str);
        }
    }

    public void MS() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_name", this.mForumName);
        bundle.putLong("forum_id", this.mForumId);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isNeedRefreshOnResume) {
            this.isNeedRefreshOnResume = false;
            this.bgf.nD();
            return;
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
        registerListener(this.aYb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (!z) {
            finish();
        } else {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
        MessageManager.getInstance().unRegisterListener(this.aYb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object c;
        super.onStop();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
        BdListView listView = getListView();
        if (listView != null && (c = com.baidu.adp.lib.a.a.a.c(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.a.a.a.a("clear", c, c.getClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bgf != null) {
            this.bgf.onDestroy();
            this.bgf.release();
        }
        super.onDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }
}
