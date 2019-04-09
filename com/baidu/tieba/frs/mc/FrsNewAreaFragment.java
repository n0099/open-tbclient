package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.baidu.adp.widget.ListView.p;
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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, ag, ah, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private VoiceManager eYE;
    private com.baidu.tbadk.m.c fdA;
    private String fpe;
    private FrsLoadMoreModel fph;
    private FrsNewAreaModelController frB;
    private String eYx = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData eYi = new FrsViewData();
    public long eCx = -1;
    public long cqq = 0;
    public long cqy = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean eYQ = false;
    protected g frC = null;
    private int dRM = -1;
    private int ffZ = 3;
    private boolean eqU = false;
    public boolean fpk = false;
    private boolean fpl = false;
    private CustomMessageListener fbC = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.fdA != null && FrsNewAreaFragment.this.fdA.isViewAttached()) {
                FrsNewAreaFragment.this.fdA.jN(num.intValue());
            }
        }
    };
    private Runnable fpm = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.kY() || FrsNewAreaFragment.this.eqU) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.jJ(false);
            }
        }
    };
    private CustomMessageListener fpn = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                FrsNewAreaFragment.this.fpe = bgVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.fpe) && bgVar.YA() != null) {
                    FrsNewAreaFragment.this.qT(bgVar.YA().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener eZH = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.aeZ() != null) {
                        FrsNewAreaFragment.this.aeZ().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.fdA != null && FrsNewAreaFragment.this.fdA.isViewAttached()) {
                        FrsNewAreaFragment.this.jJ(false);
                    } else if (FrsNewAreaFragment.this.frC != null) {
                        FrsNewAreaFragment.this.frC.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n eZV = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long fpq = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void pT(int i) {
            if (!FrsNewAreaFragment.this.fpl) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.frC.bdv();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.frC.fB(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.fpl) {
                if (FrsNewAreaFragment.this.bhT().bhm() == null) {
                    FrsNewAreaFragment.this.fpl = false;
                    return;
                } else if (FrsNewAreaFragment.this.bhT().bhm().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.fpl = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.fpq = 1L;
            } else if (bVar.isSuccess) {
                this.fpq = 0L;
            } else {
                this.fpq = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.fph.resetData();
            }
            FrsNewAreaFragment.this.frC.fB(false);
            if (FrsNewAreaFragment.this.bhT().bhm() != null) {
                FrsNewAreaFragment.this.eYi = FrsNewAreaFragment.this.bhT().bhm();
            }
            FrsNewAreaFragment.this.dRM = FrsNewAreaFragment.this.eYi.getPage().XH();
            if (FrsNewAreaFragment.this.dRM == 0 && (FrsNewAreaFragment.this.eYi.getThreadListIds() == null || FrsNewAreaFragment.this.eYi.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.eYi.getThreadList() == null || FrsNewAreaFragment.this.eYi.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.frC.aCt();
                } else {
                    FrsNewAreaFragment.this.frC.aCs();
                }
            } else {
                FrsNewAreaFragment.this.frC.aCr();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.fph.a(false, false, false, FrsNewAreaFragment.this.eYi.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.eYi.setThreadList(a2);
                    FrsNewAreaFragment.this.frC.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.eYi, FrsNewAreaFragment.this.dRM);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.frC.bdv();
                    break;
                case 2:
                    FrsNewAreaFragment.this.frC.bdv();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.eYi.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.fpq != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.eYi != null) {
                    FrsNewAreaFragment.this.eYx = FrsNewAreaFragment.this.eYi.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.eYi.getForum().getId();
                    FrsNewAreaFragment.this.frC.b(FrsNewAreaFragment.this.eYi.getForum(), FrsNewAreaFragment.this.eYi.getUserData());
                }
                if (FrsNewAreaFragment.this.eYi != null) {
                    FrsNewAreaFragment.this.eYi.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.eYi == null || FrsNewAreaFragment.this.eYi.getThreadList() == null || FrsNewAreaFragment.this.eYi.getThreadList().size() != 0 || FrsNewAreaFragment.this.bhT().getType() != 4) {
                    if (FrsNewAreaFragment.this.eYi != null && (a = FrsNewAreaFragment.this.fph.a(false, false, true, FrsNewAreaFragment.this.eYi.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.eYi.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bcH();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(d.j.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.eCx > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsNewAreaFragment.this.eCx, FrsNewAreaFragment.this.bhT().aWS() - FrsNewAreaFragment.this.eCx, FrsNewAreaFragment.this.bhT().aWQ(), FrsNewAreaFragment.this.bhT().aWR(), currentTimeMillis2 - FrsNewAreaFragment.this.bhT().aWP());
                        FrsNewAreaFragment.this.eCx = -1L;
                    }
                    FrsNewAreaFragment.this.cqy = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.eCx > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsNewAreaFragment.this.eCx, FrsNewAreaFragment.this.bhT().aWS() - FrsNewAreaFragment.this.eCx, FrsNewAreaFragment.this.bhT().aWQ(), FrsNewAreaFragment.this.bhT().aWR(), currentTimeMillis3 - FrsNewAreaFragment.this.bhT().aWP());
                FrsNewAreaFragment.this.eCx = -1L;
            }
            FrsNewAreaFragment.this.cqy = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
        }
    };
    private final CustomMessageListener bvx = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.frC != null) {
                FrsNewAreaFragment.this.frC.startPullRefresh();
            }
        }
    };
    private final h.c dhu = new h.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.kY()) {
                com.baidu.tieba.a.d.awh().qL("page_frs_good");
                FrsNewAreaFragment.this.jJ(true);
                return;
            }
            FrsNewAreaFragment.this.frC.fB(false);
        }
    };
    private final h.b bRK = new h.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.cdp().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.eYQ) {
                FrsNewAreaFragment.this.eYQ = true;
                FrsNewAreaFragment.this.frC.bdL();
            }
            if (i == 0) {
                t.aQD().hQ(true);
                com.baidu.tieba.q.c.cdp().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener bZf = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                FrsNewAreaFragment.this.e(customResponsedMessage);
            }
        }
    };
    private s fab = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bf)) {
                bg bgVar = ((bf) mVar).threadData;
                if (bgVar.ZG() == null || bgVar.ZG().getGroup_id() == 0 || bc.cZ(FrsNewAreaFragment.this.getActivity())) {
                    if (bgVar.Zy() != 1 || bc.cZ(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.CM(bgVar.getId())) {
                            readThreadHistory.CL(bgVar.getId());
                            if (FrsNewAreaFragment.this.frC != null) {
                                FrsNewAreaFragment.this.frC.bdv();
                            }
                        }
                        boolean z = false;
                        final String YV = bgVar.YV();
                        if (YV != null && !YV.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(YV);
                                    xVar.acE().adC().mIsNeedAddCommenParam = false;
                                    xVar.acE().adC().mIsUseCurrentBDUSS = false;
                                    xVar.ach();
                                }
                            }).start();
                        }
                        String tid = bgVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bgVar.YJ() == 2 && !tid.startsWith("pb:")) {
                            ba.adA().c(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bgVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bgVar, FrsNewAreaFragment.this.eYx, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsNewAreaFragment.this.fpk ? 15 : 3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.eYi != null && FrsNewAreaFragment.this.eYi.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fsM = FrsNewAreaFragment.this.eYi.needLog == 1;
                            bVar.fsO = FrsNewAreaFragment.this.eYi.getForum().getId();
                            bVar.fsN = FrsNewAreaFragment.this.frB.bhN();
                            if (com.baidu.tieba.frs.d.d.fgQ != null) {
                                bVar.fsP = com.baidu.tieba.frs.d.d.fgQ.fsP;
                                bVar.fsQ = com.baidu.tieba.frs.d.d.fgQ.fsQ;
                            }
                            com.baidu.tieba.frs.d.a.a(bgVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar);
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

    public void ac(bg bgVar) {
        if (bgVar != null) {
            this.frB.ac(bgVar);
            this.frC.bcb();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.eYi = frsViewData;
            hideLoadingView(this.frC.bdJ());
            if (this.frC != null) {
                this.frC.fB(false);
                this.frC.a(null, this.mPn, this.eYi, this.dRM);
            }
        }
    }

    private void showLoadingView() {
        this.frC.jv(false);
        showLoadingView(this.frC.bdJ(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.frC.jv(true);
        hideLoadingView(this.frC.bdJ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.frC.jv(false);
        this.frC.beI().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.frC.aCt();
        this.frC.getListView().getData().clear();
        this.frC.bdv();
        if (this.fdA == null) {
            this.fdA = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fdA.setTitle(null);
            this.fdA.setButtonText(null);
            this.fdA.any();
            this.fdA.anz().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.fdA.pp(getPageContext().getResources().getString(d.j.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.fdA.pp(null);
        }
        this.fdA.onChangeSkinType();
        this.fdA.attachView(this.frC.bdJ(), true);
        registerListener(this.fbC);
    }

    private void aBq() {
        this.frC.jv(true);
        this.frC.beI().setEnabled(true);
        if (this.fdA != null && this.fdA.isViewAttached()) {
            this.fdA.dettachView(this.frC.bdJ());
        }
        MessageManager.getInstance().unRegisterListener(this.fbC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jJ(boolean z) {
        this.eqU = true;
        bcK();
        aBq();
        if (!z) {
            aBq();
            showLoadingView();
        }
        this.frB.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eCx = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eCx = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.cqq = this.beginTime - this.eCx;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cdp().s(getUniqueId());
        this.frB = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.frB.J(arguments);
        } else if (bundle != null) {
            this.frB.J(bundle);
        } else {
            this.frB.J(null);
        }
        this.eYE = getVoiceManager();
        this.eYE.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bvx);
        registerListener(this.fpn);
        registerListener(this.eZH);
        this.fph = new FrsLoadMoreModel(this, null);
        this.fph.registerListener();
        this.fph.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_good_activity, (ViewGroup) null);
        this.frC = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eqU) {
            if (com.baidu.adp.lib.util.j.kY()) {
                jJ(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.eYE = getVoiceManager();
        this.eYE.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bhd();
        if (bundle != null) {
            this.eYx = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.eYx = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bhd() {
        registerListener(2001118, this.bZf);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.frC != null) {
            this.frC.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fbC);
        com.baidu.tieba.q.c.cdp().t(getUniqueId());
        t.aQD().hQ(false);
        super.onDestroy();
        this.frB.onActivityDestroy();
        this.eYE = getVoiceManager();
        this.eYE.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fpm);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.eYx);
        bundle.putString("from", this.mFrom);
        this.frB.onSaveInstanceState(bundle);
        this.eYE = getVoiceManager();
        if (this.eYE != null) {
            this.eYE.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bg threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.frC.bhV().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.eYi.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.gt(intent.getIntExtra("good_data", 0));
                            threadDataById.ZE();
                            jJ(false);
                            return;
                        } else if (intExtra == 0) {
                            this.eYi.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.eYi.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.m());
                            }
                            this.frC.bhh();
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
            if (this.ffZ == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.eqU) {
                com.baidu.adp.lib.g.e.jH().post(this.fpm);
            }
        }
        bez();
    }

    private void bez() {
        if (isPrimary()) {
            if (this.fdA != null && this.fdA.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fbC);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fbC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.frC != null) {
            this.frC.bdv();
        }
        this.eYE = getVoiceManager();
        this.eYE.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.frC.setOnAdapterItemClickListener(this.fab);
        this.frC.setOnScrollListener(this.mScrollListener);
        this.frC.setListPullRefreshListener(this.dhu);
        this.frC.a(this.bRK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ffZ != 3 || this.frC != null) {
            this.ffZ = i;
            super.onChangeSkinType(i);
            if (this.frC != null) {
                this.frC.onChangeSkinType(i);
            }
            if (this.fdA != null && this.fdA.isViewAttached()) {
                this.fdA.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bbO() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bbO();
        }
        return null;
    }

    private void bcG() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jI().d(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.CG(FrsNewAreaFragment.this.eYx);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcH() {
        bcK();
        try {
            if (this.eYi != null) {
                this.frC.aOs();
                this.eYx = this.eYi.getForum().getName();
                this.forumId = this.eYi.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.eYi.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.eYi.getUserData().getBimg_end_time());
                bcG();
                ArrayList<m> threadList = this.eYi.getThreadList();
                if (threadList != null) {
                    this.frC.a(threadList, this.mPn, this.eYi, this.eYi.getPage().XH());
                    bhe();
                    this.frC.bhh();
                    if (this.eYi.getIsNewUrl() == 1) {
                        this.frC.bhV().setFromCDN(true);
                    } else {
                        this.frC.bhV().setFromCDN(false);
                    }
                    this.frC.setListViewSelection(bq(bhT().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int bq(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eYE = getVoiceManager();
        this.eYE.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.aQD().hQ(false);
        com.baidu.tieba.q.c.cdp().b(getUniqueId(), false);
        if (this.eYi != null && this.eYi.getForum() != null) {
            com.baidu.tbadk.distribute.a.alC().a(getPageContext().getPageActivity(), "frs", this.eYi.getForum().getId(), 0L);
        }
        this.eYE = getVoiceManager();
        if (this.eYE != null) {
            this.eYE.onStop(getPageContext());
        }
    }

    public void bfe() {
        if (this.frC != null) {
            this.frC.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qT(int i) {
        ArrayList<m> threadList = this.eYi.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bf) {
                    bg bgVar = ((bf) next).threadData;
                    if (bgVar.getId() != null && bgVar.getId().equals(this.fpe)) {
                        c(bgVar, i);
                        this.fpe = null;
                        break;
                    }
                }
            }
            this.frC.bhV().b(threadList, this.eYi);
            this.frC.bhV().notifyDataSetChanged();
        }
    }

    private void c(bg bgVar, int i) {
        if (i == 1) {
            PraiseData YA = bgVar.YA();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (YA == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bgVar.a(praiseData);
                    return;
                }
                bgVar.YA().getUser().add(0, metaData);
                bgVar.YA().setNum(bgVar.YA().getNum() + 1);
                bgVar.YA().setIsLike(i);
            }
        } else if (bgVar.YA() != null) {
            bgVar.YA().setIsLike(i);
            bgVar.YA().setNum(bgVar.YA().getNum() - 1);
            ArrayList<MetaData> user = bgVar.YA().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bgVar.YA().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYE == null) {
            this.eYE = VoiceManager.instance();
        }
        return this.eYE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aeZ() {
        if (this.frC == null) {
            return null;
        }
        return this.frC.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bcK() {
        this.eYE = getVoiceManager();
        this.eYE.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> afa() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).afa();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.eYi != null && this.frC != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.frC.bdv();
            }
        }
    }

    private void bhe() {
        HashMap<Integer, bg> bfy;
        if (this.frC != null && this.frC.bhV() != null && (bfy = this.frC.bhV().bfy()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bg> entry : bfy.entrySet()) {
                bg value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.alH().u(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        if (aeZ() == null) {
            return null;
        }
        return aeZ().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kY()) {
            jJ(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bcP() {
        return this.eYi;
    }

    public FrsNewAreaModelController bhT() {
        return this.frB;
    }

    public void vv(String str) {
        this.eYx = str;
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

    public void aAZ() {
        if (!this.fph.isLoading && !this.frB.qz()) {
            if (this.fph.ca(this.eYi.getThreadListIds())) {
                this.frC.a(this.fph.bhy(), this.mPn, this.eYi, 0);
                this.fph.a(com.baidu.adp.lib.g.b.d(this.forumId, 0L), this.eYi.getThreadListIds(), this.eYx, this.mPn, this.eYi.isBrandForum);
            } else if (this.dRM != 0) {
                this.frC.a(this.fph.bhy(), this.mPn, this.eYi, 0);
                this.mPn++;
                this.frB.qV(this.mPn);
                this.fph.loadingDone = false;
                this.fph.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.lo()) {
            this.frC.aCt();
        } else if (!this.frC.bdE()) {
            if (!this.frB.bho()) {
                this.frC.aCt();
                return;
            }
            aBn();
            aAZ();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void uE(String str) {
        aBn();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void R(ArrayList<m> arrayList) {
        ArrayList<m> a;
        aBn();
        if (arrayList != null && arrayList.size() != 0 && (a = this.fph.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.eYi.setThreadList(a);
            this.frC.a(a, this.mPn, this.eYi, 0);
        }
    }

    public void cb(List<String> list) {
        bP(list);
        int i = 0;
        Iterator<m> it = this.eYi.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bf ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            aAZ();
        }
    }

    private void bP(List<String> list) {
        if (!v.T(list)) {
            ArrayList<m> threadList = this.eYi.getThreadList();
            if (!v.T(threadList) && this.frC.getListView() != null && this.frC.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.frC.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    m next = it.next();
                    if (next instanceof bf) {
                        bg bgVar = ((bf) next).threadData;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!ap.equals(list.get(i2), bgVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.fph.e(next);
                                this.frC.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    private void aBn() {
        if (this.dRM == 0 && !this.fph.ca(this.eYi.getThreadListIds())) {
            if (this.eYi.getThreadList() == null || this.eYi.getThreadList().size() == 0) {
                this.frC.aCt();
                return;
            } else {
                this.frC.aCs();
                return;
            }
        }
        this.frC.aCr();
    }

    public g bhU() {
        return this.frC;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0042a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.cS(getActivity().getApplicationContext())) {
                ak.c(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.alC().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bcJ() {
        if (this.frB != null) {
            this.frB.bcJ();
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
    public NavigationBar aDm() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.eYx;
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcb() {
        if (this.frC != null && this.frC.getListView() != null) {
            this.frC.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCq() {
        if (this.frC != null) {
            bcb();
            this.frC.startPullRefresh();
        }
    }
}
