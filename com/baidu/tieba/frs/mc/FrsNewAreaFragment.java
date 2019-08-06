package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ag, ah, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String fLo;
    private FrsLoadMoreModel fLr;
    private FrsNewAreaModelController fNK;
    private VoiceManager fun;
    private com.baidu.tbadk.m.c fzk;
    private String fug = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData ftR = new FrsViewData();
    public long eXw = -1;
    public long czU = 0;
    public long cAc = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fuz = false;
    protected g fNL = null;
    private int egP = -1;
    private int fBX = 3;
    private boolean eLF = false;
    public boolean fLu = false;
    private boolean fLv = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fuM = new SparseArray<>();
    private CustomMessageListener fxo = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.fzk != null && FrsNewAreaFragment.this.fzk.isViewAttached()) {
                FrsNewAreaFragment.this.fzk.kI(num.intValue());
            }
        }
    };
    private Runnable fLw = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.kc() || FrsNewAreaFragment.this.eLF) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.kF(false);
            }
        }
    };
    private CustomMessageListener fLx = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                bh bhVar = (bh) customResponsedMessage.getData();
                FrsNewAreaFragment.this.fLo = bhVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.fLo) && bhVar.aek() != null) {
                    FrsNewAreaFragment.this.sv(bhVar.aek().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fvs = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.alf() != null) {
                        FrsNewAreaFragment.this.alf().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.fzk != null && FrsNewAreaFragment.this.fzk.isViewAttached()) {
                        FrsNewAreaFragment.this.kF(false);
                    } else if (FrsNewAreaFragment.this.fNL != null) {
                        FrsNewAreaFragment.this.fNL.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final p fvH = new p() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long fLA = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void ru(int i) {
            if (!FrsNewAreaFragment.this.fLv) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.fNL.bnc();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.fNL.gc(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.fLv) {
                if (FrsNewAreaFragment.this.brF().bqX() == null) {
                    FrsNewAreaFragment.this.fLv = false;
                    return;
                } else if (FrsNewAreaFragment.this.brF().bqX().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.fLv = false;
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
                FrsNewAreaFragment.this.fLr.resetData();
            }
            FrsNewAreaFragment.this.fNL.gc(false);
            if (FrsNewAreaFragment.this.brF().bqX() != null) {
                FrsNewAreaFragment.this.ftR = FrsNewAreaFragment.this.brF().bqX();
            }
            FrsNewAreaFragment.this.egP = FrsNewAreaFragment.this.ftR.getPage().ads();
            if (FrsNewAreaFragment.this.egP == 0 && (FrsNewAreaFragment.this.ftR.getThreadListIds() == null || FrsNewAreaFragment.this.ftR.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.ftR.getThreadList() == null || FrsNewAreaFragment.this.ftR.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.fNL.aKm();
                } else {
                    FrsNewAreaFragment.this.fNL.aKl();
                }
            } else {
                FrsNewAreaFragment.this.fNL.aKk();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.fLr.a(false, false, false, FrsNewAreaFragment.this.ftR.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.ftR.setThreadList(a2);
                    FrsNewAreaFragment.this.fNL.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.ftR, FrsNewAreaFragment.this.egP);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.fNL.bnc();
                    break;
                case 2:
                    FrsNewAreaFragment.this.fNL.bnc();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.ftR.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.fLA != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.ftR != null) {
                    FrsNewAreaFragment.this.fug = FrsNewAreaFragment.this.ftR.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.ftR.getForum().getId();
                    FrsNewAreaFragment.this.fNL.b(FrsNewAreaFragment.this.ftR.getForum(), FrsNewAreaFragment.this.ftR.getUserData());
                }
                if (FrsNewAreaFragment.this.ftR != null) {
                    FrsNewAreaFragment.this.ftR.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.ftR == null || FrsNewAreaFragment.this.ftR.getThreadList() == null || FrsNewAreaFragment.this.ftR.getThreadList().size() != 0 || FrsNewAreaFragment.this.brF().getType() != 4) {
                    if (FrsNewAreaFragment.this.ftR != null && (a = FrsNewAreaFragment.this.fLr.a(false, false, true, FrsNewAreaFragment.this.ftR.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.ftR.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bmq();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.eXw > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsNewAreaFragment.this.eXw, FrsNewAreaFragment.this.brF().bgp() - FrsNewAreaFragment.this.eXw, FrsNewAreaFragment.this.brF().bgn(), FrsNewAreaFragment.this.brF().bgo(), currentTimeMillis2 - FrsNewAreaFragment.this.brF().bgm());
                        FrsNewAreaFragment.this.eXw = -1L;
                    }
                    FrsNewAreaFragment.this.cAc = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.eXw > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsNewAreaFragment.this.eXw, FrsNewAreaFragment.this.brF().bgp() - FrsNewAreaFragment.this.eXw, FrsNewAreaFragment.this.brF().bgn(), FrsNewAreaFragment.this.brF().bgo(), currentTimeMillis3 - FrsNewAreaFragment.this.brF().bgm());
                FrsNewAreaFragment.this.eXw = -1L;
            }
            FrsNewAreaFragment.this.cAc = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
        }
    };
    private final CustomMessageListener bDy = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.fNL != null) {
                FrsNewAreaFragment.this.fNL.startPullRefresh();
            }
        }
    };
    private final h.c duo = new h.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.kc()) {
                com.baidu.tieba.a.d.aCH().sl("page_frs_good");
                FrsNewAreaFragment.this.kF(true);
                return;
            }
            FrsNewAreaFragment.this.fNL.gc(false);
        }
    };
    private final h.b caK = new h.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.coG().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.fuz) {
                FrsNewAreaFragment.this.fuz = true;
                FrsNewAreaFragment.this.fNL.bnq();
            }
            if (i == 0) {
                t.aZP().iE(true);
                com.baidu.tieba.q.c.coG().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener ciq = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                FrsNewAreaFragment.this.f(customResponsedMessage);
            }
        }
    };
    private s fvN = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bg)) {
                bh bhVar = ((bg) mVar).threadData;
                if (bhVar.afq() == null || bhVar.afq().getGroup_id() == 0 || bd.cF(FrsNewAreaFragment.this.getActivity())) {
                    if (bhVar.afi() != 1 || bd.cF(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.EY(bhVar.getId())) {
                            readThreadHistory.EX(bhVar.getId());
                            if (FrsNewAreaFragment.this.fNL != null) {
                                FrsNewAreaFragment.this.fNL.bnc();
                            }
                        }
                        boolean z = false;
                        final String aeF = bhVar.aeF();
                        if (aeF != null && !aeF.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5.1
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
                            bb.ajE().c(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bhVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bhVar, FrsNewAreaFragment.this.fug, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsNewAreaFragment.this.fLu ? 15 : 3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.ftR != null && FrsNewAreaFragment.this.ftR.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fPr = FrsNewAreaFragment.this.ftR.needLog == 1;
                            bVar.fPt = FrsNewAreaFragment.this.ftR.getForum().getId();
                            bVar.fPs = FrsNewAreaFragment.this.fNK.brz();
                            if (com.baidu.tieba.frs.d.d.fCV != null) {
                                bVar.fPu = com.baidu.tieba.frs.d.d.fCV.fPu;
                                bVar.fPv = com.baidu.tieba.frs.d.d.fCV.fPv;
                            }
                            com.baidu.tieba.frs.d.a.a(bhVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar);
                        }
                    }
                }
            }
        }
    };

    static /* synthetic */ int k(FrsNewAreaFragment frsNewAreaFragment) {
        int i = frsNewAreaFragment.mPn;
        frsNewAreaFragment.mPn = i - 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public void ad(bh bhVar) {
        if (bhVar != null) {
            this.fNK.ad(bhVar);
            this.fNL.blH();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.ftR = frsViewData;
            hideLoadingView(this.fNL.aXA());
            if (this.fNL != null) {
                this.fNL.gc(false);
                this.fNL.a(null, this.mPn, this.ftR, this.egP);
            }
        }
    }

    private void showLoadingView() {
        this.fNL.kp(false);
        showLoadingView(this.fNL.aXA(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fNL.kp(true);
        hideLoadingView(this.fNL.aXA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fNL.kp(false);
        this.fNL.bop().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fNL.aKm();
        this.fNL.getListView().getData().clear();
        this.fNL.bnc();
        if (this.fzk == null) {
            this.fzk = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
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
        this.fzk.attachView(this.fNL.aXA(), true);
        registerListener(this.fxo);
    }

    private void aJj() {
        this.fNL.kp(true);
        this.fNL.bop().setEnabled(true);
        if (this.fzk != null && this.fzk.isViewAttached()) {
            this.fzk.dettachView(this.fNL.aXA());
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
        this.fNK.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eXw = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eXw = System.currentTimeMillis();
        }
        this.forumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.czU = this.beginTime - this.eXw;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.coG().u(getUniqueId());
        this.fNK = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.fNK.K(arguments);
        } else if (bundle != null) {
            this.fNK.K(bundle);
        } else {
            this.fNK.K(null);
        }
        this.fun = getVoiceManager();
        this.fun.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bDy);
        registerListener(this.fLx);
        registerListener(this.fvs);
        this.fLr = new FrsLoadMoreModel(this, null);
        this.fLr.registerListener();
        this.fLr.setPageType(3);
        this.fLr.kI(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fNL = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eLF) {
            if (com.baidu.adp.lib.util.j.kc()) {
                kF(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        ajk();
    }

    private void ajk() {
        an anVar = new an("c13008");
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bT("fid", this.forumId);
        anVar.P("obj_type", 6);
        anVar.P("obj_locate", 2);
        anVar.ajk();
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
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.fug = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bqN() {
        registerListener(2001118, this.ciq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fNL != null) {
            this.fNL.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fxo);
        com.baidu.tieba.q.c.coG().v(getUniqueId());
        t.aZP().iE(false);
        super.onDestroy();
        this.fNK.aFQ();
        this.fun = getVoiceManager();
        this.fun.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fLw);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.fug);
        bundle.putString("from", this.mFrom);
        this.fNK.onSaveInstanceState(bundle);
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
                    this.fNL.brH().notifyDataSetChanged();
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
                            this.fNL.bqS();
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
        if (this.fNL != null) {
            this.fNL.bnc();
        }
        this.fun = getVoiceManager();
        this.fun.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fNL.setOnAdapterItemClickListener(this.fvN);
        this.fNL.setOnScrollListener(this.mScrollListener);
        this.fNL.setListPullRefreshListener(this.duo);
        this.fNL.a(this.caK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fBX != 3 || this.fNL != null) {
            this.fBX = i;
            super.onChangeSkinType(i);
            if (this.fNL != null) {
                this.fNL.onChangeSkinType(i);
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
                com.baidu.adp.lib.g.h.iL().d(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.ES(FrsNewAreaFragment.this.fug);
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
                this.fNL.aVR();
                this.fug = this.ftR.getForum().getName();
                this.forumId = this.ftR.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.ftR.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.ftR.getUserData().getBimg_end_time());
                bmp();
                ArrayList<m> threadList = this.ftR.getThreadList();
                if (threadList != null) {
                    this.fNL.a(threadList, this.mPn, this.ftR, this.ftR.getPage().ads());
                    bqP();
                    this.fNL.bqS();
                    if (this.ftR.getIsNewUrl() == 1) {
                        this.fNL.brH().setFromCDN(true);
                    } else {
                        this.fNL.brH().setFromCDN(false);
                    }
                    this.fNL.setListViewSelection(bC(brF().getType(), this.mPn));
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

    public void boM() {
        if (this.fNL != null) {
            this.fNL.refreshView();
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
            this.fNL.brH().b(threadList, this.ftR);
            this.fNL.brH().notifyDataSetChanged();
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
        if (this.fNL == null) {
            return null;
        }
        return this.fNL.getListView();
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
        if (this.ftR != null && this.fNL != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fNL.bnc();
            }
        }
    }

    private void bqP() {
        HashMap<Integer, bh> bpi;
        if (this.fNL != null && this.fNL.brH() != null && (bpi = this.fNL.brH().bpi()) != null) {
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
        if (com.baidu.adp.lib.util.j.kc()) {
            kF(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bmy() {
        return this.ftR;
    }

    public FrsNewAreaModelController brF() {
        return this.fNK;
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

    public void aIS() {
        if (!this.fLr.isLoading && !this.fNK.pP()) {
            if (this.fLr.ci(this.ftR.getThreadListIds())) {
                this.fNL.a(this.fLr.brk(), this.mPn, this.ftR, 0);
                this.fLr.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.ftR.getThreadListIds(), this.fug, this.mPn, this.ftR.isBrandForum);
            } else if (this.egP != 0) {
                this.fNL.a(this.fLr.brk(), this.mPn, this.ftR, 0);
                this.mPn++;
                this.fNK.sx(this.mPn);
                this.fLr.loadingDone = false;
                this.fLr.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.kt()) {
            this.fNL.aKm();
        } else if (!this.fNL.bnk()) {
            if (!this.fNK.bqZ()) {
                this.fNL.aKm();
                return;
            }
            aJg();
            aIS();
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.fLr.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.ftR.setThreadList(a);
            this.fNL.a(a, this.mPn, this.ftR, 0);
        }
    }

    public void cj(List<String> list) {
        bY(list);
        int i = 0;
        Iterator<m> it = this.ftR.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bg ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            aIS();
        }
    }

    private void bY(List<String> list) {
        if (!v.aa(list)) {
            ArrayList<m> threadList = this.ftR.getThreadList();
            if (!v.aa(threadList) && this.fNL.getListView() != null && this.fNL.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.fNL.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    m next = it.next();
                    if (next instanceof bg) {
                        bh bhVar = ((bg) next).threadData;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!aq.bV(list.get(i2), bhVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.fLr.e(next);
                                this.fNL.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel bqO() {
        return this.fLr;
    }

    private void aJg() {
        if (this.egP == 0 && !this.fLr.ci(this.ftR.getThreadListIds())) {
            if (this.ftR.getThreadList() == null || this.ftR.getThreadList().size() == 0) {
                this.fNL.aKm();
                return;
            } else {
                this.fNL.aKl();
                return;
            }
        }
        this.fNL.aKk();
    }

    public g brG() {
        return this.fNL;
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
        if (this.fNK != null) {
            this.fNK.bms();
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

    @Override // com.baidu.tieba.frs.ag
    public void blH() {
        if (this.fNL != null && this.fNL.getListView() != null) {
            this.fNL.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKj() {
        if (this.fNL != null) {
            blH();
            this.fNL.startPullRefresh();
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
