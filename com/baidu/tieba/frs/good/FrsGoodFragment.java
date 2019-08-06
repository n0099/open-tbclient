package com.baidu.tieba.frs.good;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.e.a.a;
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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.m.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a.d;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.data.f;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0041a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ag, ah, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String fLo;
    private FrsGoodModelController fLq;
    private FrsLoadMoreModel fLr;
    private com.baidu.tieba.frs.gametab.b fLt;
    private VoiceManager fun;
    private c fzk;
    private String mForumId;
    private String fug = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean fLp = false;
    private String forumId = null;
    private FrsViewData ftR = new FrsViewData();
    public long eXw = -1;
    public long czU = 0;
    public long cAc = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fuz = false;
    protected a fLs = null;
    private int egP = -1;
    private int mTabId = 0;
    private int fBX = 3;
    private boolean eLF = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fuM = new SparseArray<>();
    public boolean fLu = false;
    private boolean fLv = false;
    private CustomMessageListener fxo = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.fzk != null && FrsGoodFragment.this.fzk.isViewAttached()) {
                FrsGoodFragment.this.fzk.kI(num.intValue());
            }
        }
    };
    private Runnable fLw = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // java.lang.Runnable
        public void run() {
            if (!j.kc() || FrsGoodFragment.this.eLF) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.kF(false);
            }
        }
    };
    private CustomMessageListener fLx = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                bh bhVar = (bh) customResponsedMessage.getData();
                FrsGoodFragment.this.fLo = bhVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.fLo) && bhVar.aek() != null) {
                    FrsGoodFragment.this.sv(bhVar.aek().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fvs = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.alf() != null) {
                            FrsGoodFragment.this.alf().setSelection(0);
                        }
                        if (FrsGoodFragment.this.fzk != null && FrsGoodFragment.this.fzk.isViewAttached()) {
                            FrsGoodFragment.this.kF(false);
                        } else if (FrsGoodFragment.this.fLs != null) {
                            FrsGoodFragment.this.fLs.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final p fvH = new p() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        private long fLA = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void ru(int i) {
            if (!FrsGoodFragment.this.fLv) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.fLs.bnc();
                        return;
                    case 3:
                        FrsGoodFragment.this.fLs.gc(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.fLv) {
                if (FrsGoodFragment.this.bqQ().bqX() == null) {
                    FrsGoodFragment.this.fLv = false;
                    return;
                } else if (FrsGoodFragment.this.bqQ().bqX().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.fLv = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.fLA = 1L;
            } else if (bVar.isSuccess) {
                this.fLA = 0L;
            } else {
                this.fLA = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.fLr.resetData();
            }
            FrsGoodFragment.this.fLs.gc(false);
            if (FrsGoodFragment.this.bqQ().bqX() != null) {
                FrsGoodFragment.this.ftR = FrsGoodFragment.this.bqQ().bqX();
            }
            FrsGoodFragment.this.egP = FrsGoodFragment.this.ftR.getPage().ads();
            if (FrsGoodFragment.this.egP == 0 && (FrsGoodFragment.this.ftR.getThreadListIds() == null || FrsGoodFragment.this.ftR.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.ftR.getThreadList() == null || FrsGoodFragment.this.ftR.getThreadList().size() == 0) {
                    FrsGoodFragment.this.fLs.aKm();
                } else {
                    FrsGoodFragment.this.fLs.aKl();
                }
            } else {
                FrsGoodFragment.this.fLs.aKk();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.fLr.a(false, false, false, FrsGoodFragment.this.ftR.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.ftR.setThreadList(a2);
                    FrsGoodFragment.this.fLs.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.ftR, FrsGoodFragment.this.egP);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.fLs.bnc();
                    break;
                case 2:
                    FrsGoodFragment.this.fLs.bnc();
                    break;
                case 3:
                    if (FrsGoodFragment.this.ftR.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.fLA != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.ftR != null) {
                    FrsGoodFragment.this.fug = FrsGoodFragment.this.ftR.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.ftR.getForum().getId();
                    FrsGoodFragment.this.fLs.b(FrsGoodFragment.this.ftR.getForum(), FrsGoodFragment.this.ftR.getUserData());
                }
                if (FrsGoodFragment.this.ftR != null) {
                    FrsGoodFragment.this.ftR.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.fLs.c(FrsGoodFragment.this.ftR);
                if (FrsGoodFragment.this.ftR == null || FrsGoodFragment.this.ftR.getThreadList() == null || FrsGoodFragment.this.ftR.getThreadList().size() != 0 || FrsGoodFragment.this.bqQ().getType() != 4) {
                    if (FrsGoodFragment.this.ftR != null && (a = FrsGoodFragment.this.fLr.a(false, false, true, FrsGoodFragment.this.ftR.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.ftR.setThreadList(a);
                    }
                    FrsGoodFragment.this.bmq();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.eXw > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.eXw, FrsGoodFragment.this.bqQ().bgp() - FrsGoodFragment.this.eXw, FrsGoodFragment.this.bqQ().bgn(), FrsGoodFragment.this.bqQ().bgo(), currentTimeMillis2 - FrsGoodFragment.this.bqQ().bgm());
                        FrsGoodFragment.this.eXw = -1L;
                    }
                    FrsGoodFragment.this.cAc = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.eXw > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.eXw, FrsGoodFragment.this.bqQ().bgp() - FrsGoodFragment.this.eXw, FrsGoodFragment.this.bqQ().bgn(), FrsGoodFragment.this.bqQ().bgo(), currentTimeMillis3 - FrsGoodFragment.this.bqQ().bgm());
                FrsGoodFragment.this.eXw = -1L;
            }
            FrsGoodFragment.this.cAc = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(l lVar) {
        }
    };
    private final CustomMessageListener bDy = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.fLs != null) {
                FrsGoodFragment.this.fLs.startPullRefresh();
            }
        }
    };
    private final h.c duo = new h.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.kc()) {
                d.aCH().sl("page_frs_good");
                FrsGoodFragment.this.kF(true);
                return;
            }
            FrsGoodFragment.this.fLs.gc(false);
        }
    };
    private final h.b caK = new h.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.coG().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.fuz) {
                FrsGoodFragment.this.fuz = true;
                FrsGoodFragment.this.fLs.bnq();
            }
            if (i == 0) {
                t.aZP().iE(true);
                com.baidu.tieba.q.c.coG().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener ciq = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                FrsGoodFragment.this.f(customResponsedMessage);
            }
        }
    };
    private s fvN = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bg)) {
                bh bhVar = ((bg) mVar).threadData;
                if (bhVar.afq() == null || bhVar.afq().getGroup_id() == 0 || bd.cF(FrsGoodFragment.this.getActivity())) {
                    if (bhVar.afi() != 1 || bd.cF(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.EY(bhVar.getId())) {
                            readThreadHistory.EX(bhVar.getId());
                            if (FrsGoodFragment.this.fLs != null) {
                                FrsGoodFragment.this.fLs.bnc();
                            }
                        }
                        boolean z = false;
                        final String aeF = bhVar.aeF();
                        if (aeF != null && !aeF.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aeF);
                                    xVar.aiG().ajG().mIsNeedAddCommenParam = false;
                                    xVar.aiG().ajG().mIsUseCurrentBDUSS = false;
                                    xVar.aij();
                                }
                            }).start();
                        }
                        String tid = bhVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bhVar.aet() == 2 && !tid.startsWith("pb:")) {
                            bb.ajE().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bhVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bhVar, FrsGoodFragment.this.fug, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.fLu ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsGoodFragment.this.ftR != null && FrsGoodFragment.this.ftR.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fPr = FrsGoodFragment.this.ftR.needLog == 1;
                            bVar.fPt = FrsGoodFragment.this.ftR.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.fCV != null) {
                                bVar.fPu = com.baidu.tieba.frs.d.d.fCV.fPu;
                                bVar.fPv = com.baidu.tieba.frs.d.d.fCV.fPv;
                            }
                            com.baidu.tieba.frs.d.a.a(bhVar, 1, FrsGoodFragment.this.getUniqueId(), bVar);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fvR = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.fLs != null) {
                FrsGoodFragment.this.fLs.bny();
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
        this.fLs.kp(false);
        showLoadingView(this.fLs.aXA(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fLs.kp(true);
        hideLoadingView(this.fLs.aXA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fLs.kp(false);
        this.fLs.bop().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fLs.aKm();
        this.fLs.getListView().getData().clear();
        this.fLs.bnc();
        if (this.fzk == null) {
            this.fzk = new c(getPageContext().getContext(), getNetRefreshListener());
            this.fzk.setTitle(null);
            this.fzk.setButtonText(null);
            this.fzk.atK();
            this.fzk.atL().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.fzk.qN(getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.fzk.qN(null);
        }
        this.fzk.onChangeSkinType();
        this.fzk.attachView(this.fLs.aXA(), true);
        registerListener(this.fxo);
    }

    private void aJj() {
        this.fLs.kp(true);
        this.fLs.bop().setEnabled(true);
        if (this.fzk != null && this.fzk.isViewAttached()) {
            this.fzk.dettachView(this.fLs.aXA());
        }
        MessageManager.getInstance().unRegisterListener(this.fxo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kF(boolean z) {
        this.eLF = true;
        bmt();
        aJj();
        if (!z) {
            aJj();
            showLoadingView();
        }
        this.fLq.nd(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eXw = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eXw = System.currentTimeMillis();
        }
        this.mForumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.czU = this.beginTime - this.eXw;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.coG().u(getUniqueId());
        this.fLq = new FrsGoodModelController(this);
        if (arguments != null) {
            this.fLq.K(arguments);
            this.fLp = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.fLq.K(bundle);
            this.fLp = bundle.getBoolean("is_game_frs", false);
        } else {
            this.fLq.K(null);
        }
        this.fun = getVoiceManager();
        this.fun.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bDy);
        registerListener(this.fLx);
        registerListener(this.fvs);
        registerListener(this.fvR);
        this.fLr = new FrsLoadMoreModel(this, null);
        this.fLr.registerListener();
        this.fLr.setPageType(2);
        this.fLr.kI(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fLs = new a(this, inflate, this.fLp);
        this.fLs.bqU().kH(this.fLu);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eLF) {
            if (j.kc()) {
                kF(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").bT("fid", this.mForumId).bT("obj_type", "7").P("obj_locate", 2).bT("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fun = getVoiceManager();
        this.fun.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bqN();
        if (bundle != null) {
            this.fug = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fLu = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.fug = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.fLu = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bqN() {
        registerListener(2001118, this.ciq);
    }

    public FrsLoadMoreModel bqO() {
        return this.fLr;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fLs != null) {
            this.fLs.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fxo);
        com.baidu.tieba.q.c.coG().v(getUniqueId());
        t.aZP().iE(false);
        super.onDestroy();
        this.fLq.aFQ();
        this.fun = getVoiceManager();
        this.fun.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fLw);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.fug);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.fLp);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fLu);
        this.fLq.onSaveInstanceState(bundle);
        this.fun = getVoiceManager();
        if (this.fun != null) {
            this.fun.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bh threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.fLs.bqU().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.ftR.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.hl(intent.getIntExtra("good_data", 0));
                            threadDataById.afo();
                            kF(false);
                            return;
                        } else if (intExtra == 0) {
                            this.ftR.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.ftR.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.m());
                            }
                            this.fLs.bqS();
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
            if (this.fBX == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.eLF) {
                com.baidu.adp.lib.g.e.iK().post(this.fLw);
            }
        }
        bof();
    }

    private void bof() {
        if (isPrimary()) {
            if (this.fzk != null && this.fzk.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fxo);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fxo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fLs != null) {
            this.fLs.bnc();
        }
        this.fun = getVoiceManager();
        this.fun.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fLt = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.fLs.setOnAdapterItemClickListener(this.fvN);
        this.fLs.setOnScrollListener(this.mScrollListener);
        this.fLs.setListPullRefreshListener(this.duo);
        this.fLs.a(this.caK);
        this.fLs.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.fLt != null) {
                    FrsGoodFragment.this.fLt.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fBX != 3 || this.fLs != null) {
            this.fBX = i;
            super.onChangeSkinType(i);
            if (this.fLs != null) {
                this.fLs.onChangeSkinType(i);
            }
            if (this.fzk != null && this.fzk.isViewAttached()) {
                this.fzk.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> blt() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).blt();
        }
        return null;
    }

    private void bmp() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.iL().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.ES(FrsGoodFragment.this.fug);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmq() {
        bmt();
        try {
            if (this.ftR != null) {
                this.fLs.aVR();
                this.fug = this.ftR.getForum().getName();
                this.forumId = this.ftR.getForum().getId();
                if (this.ftR != null && this.ftR.getForum() != null) {
                    this.fLs.a(this.ftR.getForum().getThemeColorInfo());
                    this.fLs.c(this.ftR);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.ftR.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.ftR.getUserData().getBimg_end_time());
                bmp();
                if (!this.fLs.bqU().n(bh.bJD)) {
                    this.ftR.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.ftR.getThreadList();
                if (threadList != null) {
                    this.fLs.a(threadList, this.mPn, this.ftR, this.ftR.getPage().ads());
                    bqP();
                    this.fLs.bqS();
                    if (this.ftR.getIsNewUrl() == 1) {
                        this.fLs.bqU().setFromCDN(true);
                    } else {
                        this.fLs.bqU().setFromCDN(false);
                    }
                    this.fLs.setListViewSelection(bC(bqQ().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int bC(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fun = getVoiceManager();
        this.fun.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.aZP().iE(false);
        com.baidu.tieba.q.c.coG().b(getUniqueId(), false);
        if (this.ftR != null && this.ftR.getForum() != null) {
            com.baidu.tbadk.distribute.a.arN().a(getPageContext().getPageActivity(), "frs", this.ftR.getForum().getId(), 0L);
        }
        this.fun = getVoiceManager();
        if (this.fun != null) {
            this.fun.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sv(int i) {
        ArrayList<m> threadList = this.ftR.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bg) {
                    bh bhVar = ((bg) next).threadData;
                    if (bhVar.getId() != null && bhVar.getId().equals(this.fLo)) {
                        c(bhVar, i);
                        this.fLo = null;
                        break;
                    }
                }
            }
            this.fLs.bqU().b(threadList, this.ftR);
            this.fLs.bqU().notifyDataSetChanged();
        }
    }

    private void c(bh bhVar, int i) {
        if (i == 1) {
            PraiseData aek = bhVar.aek();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aek == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bhVar.a(praiseData);
                    return;
                }
                bhVar.aek().getUser().add(0, metaData);
                bhVar.aek().setNum(bhVar.aek().getNum() + 1);
                bhVar.aek().setIsLike(i);
            }
        } else if (bhVar.aek() != null) {
            bhVar.aek().setIsLike(i);
            bhVar.aek().setNum(bhVar.aek().getNum() - 1);
            ArrayList<MetaData> user = bhVar.aek().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bhVar.aek().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fun == null) {
            this.fun = VoiceManager.instance();
        }
        return this.fun;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView alf() {
        if (this.fLs == null) {
            return null;
        }
        return this.fLs.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bmt() {
        this.fun = getVoiceManager();
        this.fun.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> alg() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).alg();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.ftR != null && this.fLs != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fLs.bnc();
            }
        }
    }

    private void bqP() {
        HashMap<Integer, bh> bpi;
        if (this.fLs != null && this.fLs.bqU() != null && (bpi = this.fLs.bqU().bpi()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bh> entry : bpi.entrySet()) {
                bh value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.arS().x(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (alf() == null) {
            return null;
        }
        return alf().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kc()) {
            kF(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bmy() {
        return this.ftR;
    }

    public FrsGoodModelController bqQ() {
        return this.fLq;
    }

    public void xt(String str) {
        this.fug = str;
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
        if (!com.baidu.adp.lib.util.l.kt()) {
            this.fLs.aKm();
        } else if (!this.fLq.bqZ()) {
            this.fLs.aKm();
        } else {
            aJg();
            if (!this.fLr.isLoading && !this.fLq.pP()) {
                if (this.fLr.ci(this.ftR.getThreadListIds())) {
                    this.fLs.a(this.fLr.brk(), this.mPn, this.ftR, 0);
                    this.fLr.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.ftR.getThreadListIds(), this.fug, this.mPn, this.ftR.isBrandForum);
                } else if (this.egP != 0) {
                    this.fLs.a(this.fLr.brk(), this.mPn, this.ftR, 0);
                    this.mPn++;
                    this.fLq.sx(this.mPn);
                    this.fLr.loadingDone = false;
                    this.fLr.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void wD(String str) {
        aJg();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void V(ArrayList<m> arrayList) {
        ArrayList<m> a;
        aJg();
        if (arrayList != null && arrayList.size() != 0 && (a = this.fLr.a(false, false, false, arrayList, (f) null)) != null) {
            this.ftR.setThreadList(a);
            this.fLs.a(a, this.mPn, this.ftR, 0);
        }
    }

    private void aJg() {
        if (this.egP == 0 && !this.fLr.ci(this.ftR.getThreadListIds())) {
            if (this.ftR.getThreadList() == null || this.ftR.getThreadList().size() == 0) {
                this.fLs.aKm();
                return;
            } else {
                this.fLs.aKl();
                return;
            }
        }
        this.fLs.aKk();
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0041a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.cy(getActivity().getApplicationContext())) {
                al.c(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.arN().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bms() {
        if (this.fLq != null) {
            this.fLq.bms();
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

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aLj() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.fug;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sw(int i) {
        this.mTabId = i;
        if (j.kc()) {
            kF(false);
        } else {
            c((e.b) null);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void blH() {
        if (this.fLs != null && this.fLs.getListView() != null) {
            this.fLs.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKj() {
        if (this.fLs != null) {
            blH();
            this.fLs.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.fuM.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a mf(int i) {
        return this.fuM.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }
}
