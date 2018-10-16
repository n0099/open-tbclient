package com.baidu.tieba.frs.good;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.k;
import com.baidu.f.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0073a, UserIconBox.b, VoiceManager.c, aj, ak, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private VoiceManager dAm;
    private String dHp;
    private FrsGoodModelController dQO;
    private FrsLoadMoreModel dQP;
    private com.baidu.tieba.frs.gametab.b dQR;
    private String dAf = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dQN = false;
    private String forumId = null;
    private l dzP = new l();
    public long dgR = -1;
    public long bbA = 0;
    public long bbI = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dAu = false;
    protected b dQQ = null;
    private int cyj = -1;
    private int mTabId = 0;
    private int dGV = 3;
    private boolean cVR = false;
    public boolean dQS = false;
    private Runnable dQT = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (!j.kX() || FrsGoodFragment.this.cVR) {
                FrsGoodFragment.this.c((d.a) null);
            } else {
                FrsGoodFragment.this.gO(false);
            }
        }
    };
    private CustomMessageListener dHq = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                bb bbVar = (bb) customResponsedMessage.getData();
                FrsGoodFragment.this.dHp = bbVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.dHp) && bbVar.yi() != null) {
                    FrsGoodFragment.this.lO(bbVar.yi().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dBh = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.Eg() != null) {
                            FrsGoodFragment.this.Eg().setSelection(0);
                        }
                        if (FrsGoodFragment.this.mRefreshView != null && FrsGoodFragment.this.mRefreshView.Mq()) {
                            FrsGoodFragment.this.gO(false);
                        } else if (FrsGoodFragment.this.dQQ != null) {
                            FrsGoodFragment.this.dQQ.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dBu = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        private long dQW = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void lq(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsGoodFragment.this.dQQ.aAx();
                    return;
                case 3:
                    FrsGoodFragment.this.dQQ.cQ(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<h> a;
            if (aVar == null) {
                this.dQW = 1L;
            } else if (aVar.isSuccess) {
                this.dQW = 0L;
            } else {
                this.dQW = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.dQP.resetData();
            }
            FrsGoodFragment.this.dQQ.cQ(false);
            if (FrsGoodFragment.this.aEy().aEE() != null) {
                FrsGoodFragment.this.dzP = FrsGoodFragment.this.aEy().aEE();
            }
            FrsGoodFragment.this.cyj = FrsGoodFragment.this.dzP.xH().xD();
            if (FrsGoodFragment.this.cyj == 0 && (FrsGoodFragment.this.dzP.bAg() == null || FrsGoodFragment.this.dzP.bAg().size() == 0)) {
                if (FrsGoodFragment.this.dzP.getThreadList() == null || FrsGoodFragment.this.dzP.getThreadList().size() == 0) {
                    FrsGoodFragment.this.dQQ.ZK();
                } else {
                    FrsGoodFragment.this.dQQ.ZJ();
                }
            } else {
                FrsGoodFragment.this.dQQ.ZI();
            }
            if (i == 4) {
                ArrayList<h> a2 = FrsGoodFragment.this.dQP.a(false, false, false, FrsGoodFragment.this.dzP.getThreadList(), (e) null);
                if (a2 != null) {
                    FrsGoodFragment.this.dzP.ay(a2);
                    FrsGoodFragment.this.dQQ.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.dzP, FrsGoodFragment.this.cyj);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.dQQ.aAx();
                    break;
                case 2:
                    FrsGoodFragment.this.dQQ.aAx();
                    break;
                case 3:
                    if (FrsGoodFragment.this.dzP.bAx()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.dQW != 0) {
                FrsGoodFragment.this.c(aVar);
            } else {
                if (FrsGoodFragment.this.dzP != null) {
                    FrsGoodFragment.this.dAf = FrsGoodFragment.this.dzP.beT().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.dzP.beT().getId();
                    FrsGoodFragment.this.dQQ.b(FrsGoodFragment.this.dzP.beT(), FrsGoodFragment.this.dzP.getUserData());
                }
                if (FrsGoodFragment.this.dzP != null) {
                    FrsGoodFragment.this.dzP.bAR();
                }
                FrsGoodFragment.this.dQQ.d(FrsGoodFragment.this.dzP);
                if (FrsGoodFragment.this.dzP == null || FrsGoodFragment.this.dzP.getThreadList() == null || FrsGoodFragment.this.dzP.getThreadList().size() != 0 || FrsGoodFragment.this.aEy().getType() != 4) {
                    if (FrsGoodFragment.this.dzP != null && (a = FrsGoodFragment.this.dQP.a(false, false, true, FrsGoodFragment.this.dzP.getThreadList(), (e) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.dzP.ay(a);
                    }
                    FrsGoodFragment.this.azM();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(e.j.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.dgR > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.dgR, FrsGoodFragment.this.aEy().auq() - FrsGoodFragment.this.dgR, FrsGoodFragment.this.aEy().auo(), FrsGoodFragment.this.aEy().aup(), currentTimeMillis2 - FrsGoodFragment.this.aEy().aun());
                        FrsGoodFragment.this.dgR = -1L;
                    }
                    FrsGoodFragment.this.bbI = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.dgR > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.dgR, FrsGoodFragment.this.aEy().auq() - FrsGoodFragment.this.dgR, FrsGoodFragment.this.aEy().auo(), FrsGoodFragment.this.aEy().aup(), currentTimeMillis3 - FrsGoodFragment.this.aEy().aun());
                FrsGoodFragment.this.dgR = -1L;
            }
            FrsGoodFragment.this.bbI = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private final CustomMessageListener ajQ = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.dQQ != null) {
                FrsGoodFragment.this.dQQ.startPullRefresh();
            }
        }
    };
    private final j.b bMO = new j.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        @Override // com.baidu.tbadk.core.view.j.b
        public void bp(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.kX()) {
                com.baidu.tieba.a.d.Ux().jp("page_frs_good");
                FrsGoodFragment.this.gO(true);
                return;
            }
            FrsGoodFragment.this.dQQ.cQ(false);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.dAu) {
                FrsGoodFragment.this.dAu = true;
                FrsGoodFragment.this.dQQ.aAK();
            }
            if (i == 0) {
                v.aoo().fh(true);
            }
        }
    };
    private final CustomMessageListener aLF = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                FrsGoodFragment.this.e(customResponsedMessage);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n dBA = new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bb)) {
                bb bbVar = (bb) hVar;
                if (bbVar.zh() == null || bbVar.zh().getGroup_id() == 0 || ba.bI(FrsGoodFragment.this.getActivity())) {
                    if (bbVar.yZ() != 1 || ba.bI(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.vl(bbVar.getId())) {
                            readThreadHistory.vk(bbVar.getId());
                            if (FrsGoodFragment.this.dQQ != null) {
                                FrsGoodFragment.this.dQQ.aAx();
                            }
                        }
                        boolean z = false;
                        final String yD = bbVar.yD();
                        if (yD != null && !yD.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(yD);
                                    xVar.BY().CW().mIsNeedAddCommenParam = false;
                                    xVar.BY().CW().mIsUseCurrentBDUSS = false;
                                    xVar.BB();
                                }
                            }).start();
                        }
                        String tid = bbVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bbVar.yq() == 2 && !tid.startsWith("pb:")) {
                            ay.CU().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bbVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, FrsGoodFragment.this.dAf, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.dQS ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    }
                }
            }
        }
    };

    static /* synthetic */ int j(FrsGoodFragment frsGoodFragment) {
        int i = frsGoodFragment.mPn;
        frsGoodFragment.mPn = i - 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    private void showLoadingView() {
        this.dQQ.gG(false);
        showLoadingView(this.dQQ.aAI(), true, getResources().getDimensionPixelSize(e.C0175e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dQQ.gG(true);
        hideLoadingView(this.dQQ.aAI());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dQQ.gG(false);
        this.dQQ.aBH().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dQQ.ZK();
        this.dQQ.getListView().getData().clear();
        this.dQQ.aAx();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.My();
            this.mRefreshView.fA(getResources().getDimensionPixelSize(e.C0175e.ds_102));
            this.mRefreshView.Mw().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.hU(getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.hU(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.c(this.dQQ.aAI(), true);
    }

    private void ZH() {
        this.dQQ.gG(true);
        this.dQQ.aBH().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Mq()) {
            this.mRefreshView.ad(this.dQQ.aAI());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(boolean z) {
        this.cVR = true;
        azP();
        ZH();
        if (!z) {
            ZH();
            showLoadingView();
        }
        this.dQO.hQ(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dgR = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.dgR = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.bbA = this.beginTime - this.dgR;
        super.onCreate(bundle);
        this.dQO = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dQO.j(arguments);
            this.dQN = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dQO.j(bundle);
            this.dQN = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dQO.j(null);
        }
        this.dAm = getVoiceManager();
        this.dAm.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.ajQ);
        registerListener(this.dHq);
        registerListener(this.dBh);
        this.dQP = new FrsLoadMoreModel(this, null);
        this.dQP.registerListener();
        this.dQP.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_good_activity, (ViewGroup) null);
        this.dQQ = new b(this, inflate, this.dQN);
        this.dQQ.aEC().gX(this.dQS);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.cVR) {
            if (com.baidu.adp.lib.util.j.kX()) {
                gO(false);
            } else {
                c((d.a) null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dAm = getVoiceManager();
        this.dAm.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        aEw();
        if (bundle != null) {
            this.dAf = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dQS = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dAf = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.dQS = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void aEw() {
        registerListener(2001118, this.aLF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dQQ != null) {
            this.dQQ.onDestroy();
        }
        v.aoo().fh(false);
        super.onDestroy();
        this.dQO.onActivityDestroy();
        this.dAm = getVoiceManager();
        this.dAm.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.dQT);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dAf);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dQN);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.dQS);
        this.dQO.onSaveInstanceState(bundle);
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bb nJ;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dQQ.aEC().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (nJ = this.dzP.nJ(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            nJ.cq(intent.getIntExtra("good_data", 0));
                            nJ.zf();
                            gO(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dzP.ab(nJ);
                            ArrayList<h> threadList = this.dzP.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.dQQ.aEA();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.dGV == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.cVR) {
                com.baidu.adp.lib.g.e.jI().post(this.dQT);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dQQ != null) {
            this.dQQ.aAx();
        }
        this.dAm = getVoiceManager();
        this.dAm.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dQR = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dQQ.setOnAdapterItemClickListener(this.dBA);
        this.dQQ.setOnScrollListener(this.mScrollListener);
        this.dQQ.a(this.bMO);
        this.dQQ.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.dQR != null) {
                    FrsGoodFragment.this.dQR.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dGV != 3 || this.dQQ != null) {
            this.dGV = i;
            super.onChangeSkinType(i);
            if (this.dQQ != null) {
                this.dQQ.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> ayY() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).ayY();
        }
        return null;
    }

    private void azL() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jJ().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.vf(FrsGoodFragment.this.dAf);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azM() {
        azP();
        try {
            if (this.dzP != null) {
                this.dQQ.amg();
                this.dAf = this.dzP.beT().getName();
                this.forumId = this.dzP.beT().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dzP.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dzP.getUserData().getBimg_end_time());
                azL();
                if (!this.dQQ.aEC().k(bb.aoW)) {
                    this.dzP.bAT();
                }
                ArrayList<h> threadList = this.dzP.getThreadList();
                if (threadList != null) {
                    this.dQQ.a(threadList, this.mPn, this.dzP, this.dzP.xH().xD());
                    aEx();
                    this.dQQ.aEA();
                    if (this.dzP.bfi() == 1) {
                        this.dQQ.aEC().setFromCDN(true);
                    } else {
                        this.dQQ.aEC().setFromCDN(false);
                    }
                    this.dQQ.setListViewSelection(aL(aEy().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aL(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dAm = getVoiceManager();
        this.dAm.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        v.aoo().fh(false);
        if (this.dzP != null && this.dzP.beT() != null) {
            com.baidu.tbadk.distribute.a.Ku().a(getPageContext().getPageActivity(), "frs", this.dzP.beT().getId(), 0L);
        }
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(int i) {
        ArrayList<h> threadList = this.dzP.getThreadList();
        if (threadList != null) {
            Iterator<h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar.getId() != null && bbVar.getId().equals(this.dHp)) {
                        a(bbVar, i);
                        this.dHp = null;
                        break;
                    }
                }
            }
            this.dQQ.aEC().b(threadList, this.dzP);
            this.dQQ.aEC().notifyDataSetChanged();
        }
    }

    private void a(bb bbVar, int i) {
        if (i == 1) {
            PraiseData yi = bbVar.yi();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (yi == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bbVar.a(praiseData);
                    return;
                }
                bbVar.yi().getUser().add(0, metaData);
                bbVar.yi().setNum(bbVar.yi().getNum() + 1);
                bbVar.yi().setIsLike(i);
            }
        } else if (bbVar.yi() != null) {
            bbVar.yi().setIsLike(i);
            bbVar.yi().setNum(bbVar.yi().getNum() - 1);
            ArrayList<MetaData> user = bbVar.yi().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bbVar.yi().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dAm == null) {
            this.dAm = VoiceManager.instance();
        }
        return this.dAm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Eg() {
        if (this.dQQ == null) {
            return null;
        }
        return this.dQQ.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void azP() {
        this.dAm = getVoiceManager();
        this.dAm.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Eh() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).Eh();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.dzP != null && this.dQQ != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
            Iterator<DownloadData> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().getStatus() == 0) {
                    z = true;
                    break;
                }
            }
            if (z) {
                this.dQQ.aAx();
            }
        }
    }

    private void aEx() {
        HashMap<Integer, bb> aCF;
        if (this.dQQ != null && this.dQQ.aEC() != null && (aCF = this.dQQ.aEC().aCF()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bb> entry : aCF.entrySet()) {
                bb value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.Kz().s(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public k onGetPreLoadListView() {
        if (Eg() == null) {
            return null;
        }
        return Eg().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kX()) {
            gO(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l azR() {
        return this.dzP;
    }

    public FrsGoodModelController aEy() {
        return this.dQO;
    }

    public void nY(String str) {
        this.dAf = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.lo()) {
            this.dQQ.ZK();
        } else if (!this.dQO.aEG()) {
            this.dQQ.ZK();
        } else {
            YY();
            if (!this.dQP.isLoading && !this.dQO.DU()) {
                if (this.dQP.bO(this.dzP.bAg())) {
                    this.dQQ.a(this.dQP.aEU(), this.mPn, this.dzP, 0);
                    this.dQP.a(com.baidu.adp.lib.g.b.d(this.forumId, 0L), this.dzP.bAg(), this.dAf, this.mPn, this.dzP.isBrandForum);
                } else if (this.cyj != 0) {
                    this.dQQ.a(this.dQP.aEU(), this.mPn, this.dzP, 0);
                    this.mPn++;
                    this.dQO.mp(this.mPn);
                    this.dQP.loadingDone = false;
                    this.dQP.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void nh(String str) {
        YY();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<h> arrayList) {
        ArrayList<h> a;
        YY();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dQP.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.e) null)) != null) {
            this.dzP.ay(a);
            this.dQQ.a(a, this.mPn, this.dzP, 0);
        }
    }

    private void YY() {
        if (this.cyj == 0 && !this.dQP.bO(this.dzP.bAg())) {
            if (this.dzP.getThreadList() == null || this.dzP.getThreadList().size() == 0) {
                this.dQQ.ZK();
                return;
            } else {
                this.dQQ.ZJ();
                return;
            }
        }
        this.dQQ.ZI();
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aX(getActivity().getApplicationContext())) {
                com.baidu.tbadk.core.util.ak.b(getPageContext());
            } else {
                showToast(e.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(e.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Ku().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void azO() {
        if (this.dQO != null) {
            this.dQO.azO();
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.n
    public int getPageNum() {
        return this.mPn;
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar aaD() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dAf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mo(int i) {
        this.mTabId = i;
        if (com.baidu.adp.lib.util.j.kX()) {
            gO(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void azk() {
        if (this.dQQ != null && this.dQQ.getListView() != null) {
            this.dQQ.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void ZF() {
        if (this.dQQ != null) {
            azk();
            this.dQQ.startPullRefresh();
        }
    }
}
