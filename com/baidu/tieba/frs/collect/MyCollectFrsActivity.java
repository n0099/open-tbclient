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
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class MyCollectFrsActivity extends BaseActivity<MyCollectFrsActivity> implements BdListView.e, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c {
    private static final int bcW = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds90);
    private static final int bcX = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds300);
    private com.baidu.adp.lib.f.b<TbImageView> agI;
    private String bbW;
    private z bcY;
    private com.baidu.adp.lib.f.b<TbImageView> bdr;
    private a bjW;
    private l bjX;
    private z bka;
    private long mForumId;
    private String mForumName;
    VoiceManager mVoiceManager;
    private String bjV = null;
    private String forumId = null;
    private p bdo = new p();
    private boolean mHasMore = false;
    private final r.a bdP = new b(this);
    com.baidu.adp.framework.listener.a bjY = new c(this, CmdConfigHttp.CMD_GET_USER_FORUM_STORE, 309112);
    private final bf bjZ = new d(this);
    private boolean isNeedRefreshOnResume = false;
    private boolean bkb = false;
    private boolean bcZ = false;
    private final NoNetworkView.a bbw = new e(this);
    private CustomMessageListener agG = new f(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private v bdW = new g(this);
    private w bdZ = new i(this);
    private View.OnClickListener SY = new j(this);

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
    public void fP(int i) {
        ArrayList<u> threadList = this.bdo.getThreadList();
        if (threadList != null) {
            Iterator<u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                u next = it.next();
                if (next instanceof z) {
                    z zVar = (z) next;
                    if (zVar == this.bcY) {
                        b(zVar, i);
                        this.bcY = null;
                        break;
                    } else if (zVar.getId() != null && zVar.getId().equals(this.bbW)) {
                        b(zVar, i);
                        this.bbW = null;
                        break;
                    }
                }
            }
            this.bjX.OL().a(threadList, this.bdo);
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
        if (!com.baidu.adp.lib.util.k.jh()) {
            this.bjX.Om();
        } else if (this.mHasMore) {
            Ns();
            this.bjW.OK();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> MH() {
        if (this.bdr == null) {
            this.bdr = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.bdr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.bjX == null) {
            return null;
        }
        return this.bjX.getListView();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vU() {
        if (this.bjX == null) {
            return 0;
        }
        return this.bjX.Oc();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vV() {
        if (this.agI == null) {
            this.agI = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.agI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ns() {
        if (this.mHasMore) {
            this.bjX.Ok();
        } else if (this.bdo.getThreadList() == null || this.bdo.getThreadList().size() == 0) {
            this.bjX.Om();
        } else {
            this.bjX.gb(bcW - (this.bjW.qs().size() * bcX));
            this.bjX.Ol();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.mForumId = getIntent().getLongExtra("forum_id", -1L);
        this.bdo.akG().setName(this.mForumName);
        this.bdo.akG().setId(String.valueOf(this.mForumId));
        registerListener(this.bjY);
        this.bjW = new a(this, this.mForumId);
        this.bjW.firstLoadData();
        setContentView(n.h.collect_frs_activity);
        this.bjX = new l(this);
        showLoadingView(this.bjX.getRootView());
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bjX.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    private void initUI() {
        this.bjX.a(this.bdW);
        this.bjX.a(this.bdZ);
        this.bjX.a(this.bdP);
        this.bjX.f(this.bbw);
        this.bjX.OL().b(this.bjZ);
        this.bjX.n(this.SY);
    }

    public void refresh() {
        stopVoice();
        this.bjW.Kn();
    }

    public void stopVoice() {
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(z zVar) {
        boolean sP = zVar == null ? true : zVar.sP();
        this.bjX.c(new k(this, zVar));
        this.bjX.a(zVar, sP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(z zVar) {
        boolean sP = zVar == null ? true : zVar.sP();
        if (this.bjV != null) {
            if (!sP) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.mForumName, null, 18003, true, true, this.bkb)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.mForumName, null, 18003, false, false, this.bkb)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(z zVar) {
        if (this.bjV != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.mForumName, null, 18003, false, false, this.bkb)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu(String str) {
        if (this.bjW.qs().isEmpty() && this.bjX != null) {
            this.bjX.hv(str);
        }
    }

    public void Nm() {
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
            this.bjX.nb();
            return;
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
        registerListener(this.agG);
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
        MessageManager.getInstance().unRegisterListener(this.agG);
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
        if (this.bjX != null) {
            this.bjX.onDestroy();
            this.bjX.release();
        }
        super.onDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }
}
