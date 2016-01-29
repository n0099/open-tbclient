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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bh;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class MyCollectFrsActivity extends BaseActivity<MyCollectFrsActivity> implements BdListView.e, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c {
    private static final int bfn = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds90);
    private static final int bfo = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds300);
    private com.baidu.adp.lib.f.b<TbImageView> ahx;
    private String beh;
    VoiceManager ben;
    private com.baidu.adp.lib.f.b<TbImageView> bfI;
    private ah bfp;
    private a bmS;
    private l bmT;
    private ah bmW;
    private long mForumId;
    private String mForumName;
    private String bmR = null;
    private String forumId = null;
    private o bfF = new o();
    private boolean mHasMore = false;
    private final r.a bgi = new b(this);
    com.baidu.adp.framework.listener.a bmU = new c(this, CmdConfigHttp.CMD_GET_USER_FORUM_STORE, 309112);
    private final bh bmV = new d(this);
    private boolean isNeedRefreshOnResume = false;
    private boolean bmX = false;
    private boolean bfq = false;
    private final NoNetworkView.a bdG = new e(this);
    private CustomMessageListener ahv = new f(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private v bgr = new g(this);
    private w bgv = new i(this);
    private View.OnClickListener Ss = new j(this);

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ben == null) {
            this.ben = VoiceManager.instance();
        }
        return this.ben;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl(int i) {
        ArrayList<u> threadList = this.bfF.getThreadList();
        if (threadList != null) {
            Iterator<u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                u next = it.next();
                if (next instanceof ah) {
                    ah ahVar = (ah) next;
                    if (ahVar == this.bfp) {
                        b(ahVar, i);
                        this.bfp = null;
                        break;
                    } else if (ahVar.getId() != null && ahVar.getId().equals(this.beh)) {
                        b(ahVar, i);
                        this.beh = null;
                        break;
                    }
                }
            }
            this.bmT.QO().a(threadList, this.bfF);
        }
    }

    private void b(ah ahVar, int i) {
        if (i == 1) {
            PraiseData praise = ahVar.getPraise();
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
                    ahVar.setPraise(praiseData);
                    return;
                }
                ahVar.getPraise().getUser().add(0, metaData);
                ahVar.getPraise().setNum(ahVar.getPraise().getNum() + 1);
                ahVar.getPraise().setIsLike(i);
            }
        } else if (ahVar.getPraise() != null) {
            ahVar.getPraise().setIsLike(i);
            ahVar.getPraise().setNum(ahVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = ahVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        ahVar.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        if (!com.baidu.adp.lib.util.k.jq()) {
            this.bmT.Qp();
        } else if (this.mHasMore) {
            Pp();
            this.bmS.QN();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> OC() {
        if (this.bfI == null) {
            this.bfI = FrsCommonImageLayout.l(getPageContext().getPageActivity(), 12);
        }
        return this.bfI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: KM */
    public BdListView getListView() {
        if (this.bmT == null) {
            return null;
        }
        return this.bmT.KM();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int xi() {
        if (this.bmT == null) {
            return 0;
        }
        return this.bmT.Qc();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> xj() {
        if (this.ahx == null) {
            this.ahx = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.ahx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pp() {
        if (this.mHasMore) {
            this.bmT.Qn();
        } else if (this.bfF.getThreadList() == null || this.bfF.getThreadList().size() == 0) {
            this.bmT.Qp();
        } else {
            this.bmT.gy(bfn - (this.bmS.qN().size() * bfo));
            this.bmT.Qo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.mForumId = getIntent().getLongExtra("forum_id", -1L);
        this.bfF.aoE().setName(this.mForumName);
        this.bfF.aoE().setId(String.valueOf(this.mForumId));
        registerListener(this.bmU);
        this.bmS = new a(this, this.mForumId);
        this.bmS.QM();
        setContentView(t.h.collect_frs_activity);
        this.bmT = new l(this);
        showLoadingView(this.bmT.getRootView());
        this.ben = getVoiceManager();
        this.ben.onCreate(getPageContext());
        qD();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bmT.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    private void qD() {
        this.bmT.a(this.bgr);
        this.bmT.a(this.bgv);
        this.bmT.a(this.bgi);
        this.bmT.f(this.bdG);
        this.bmT.QO().b(this.bmV);
        this.bmT.s(this.Ss);
    }

    public void refresh() {
        Oy();
        this.bmS.Me();
    }

    public void Oy() {
        this.ben = getVoiceManager();
        this.ben.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ah ahVar) {
        boolean tM = ahVar == null ? true : ahVar.tM();
        this.bmT.a(new k(this, ahVar));
        this.bmT.a(ahVar, tM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ah ahVar) {
        boolean tM = ahVar == null ? true : ahVar.tM();
        if (this.bmR != null) {
            if (!tM) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(ahVar, this.mForumName, null, 18003, true, true, this.bmX)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(ahVar, this.mForumName, null, 18003, false, false, this.bmX)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ah ahVar) {
        if (this.bmR != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(ahVar, this.mForumName, null, 18003, false, false, this.bmX)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hv(String str) {
        if (this.bmS.qN().isEmpty() && this.bmT != null) {
            this.bmT.hw(str);
        }
    }

    public void Pj() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_name", this.mForumName);
        bundle.putLong("forum_id", this.mForumId);
        this.ben = getVoiceManager();
        if (this.ben != null) {
            this.ben.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isNeedRefreshOnResume) {
            this.isNeedRefreshOnResume = false;
            this.bmT.ns();
            return;
        }
        this.ben = getVoiceManager();
        this.ben.onResume(getPageContext());
        registerListener(this.ahv);
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
        this.ben = getVoiceManager();
        this.ben.onPause(getPageContext());
        MessageManager.getInstance().unRegisterListener(this.ahv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object c;
        super.onStop();
        this.ben = getVoiceManager();
        if (this.ben != null) {
            this.ben.onStop(getPageContext());
        }
        BdListView listView = getListView();
        if (listView != null && (c = com.baidu.adp.lib.a.a.a.c(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.a.a.a.a("clear", c, c.getClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bmT != null) {
            this.bmT.onDestroy();
            this.bmT.release();
        }
        super.onDestroy();
        this.ben = getVoiceManager();
        this.ben.onDestory(getPageContext());
    }
}
