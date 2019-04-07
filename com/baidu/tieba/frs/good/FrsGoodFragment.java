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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.p;
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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.m.c;
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
import com.baidu.tieba.tbadkCore.data.f;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0042a, UserIconBox.b, VoiceManager.c, ag, ah, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private VoiceManager eYD;
    private c fdA;
    private String fpe;
    private FrsGoodModelController fpg;
    private FrsLoadMoreModel fph;
    private com.baidu.tieba.frs.gametab.b fpj;
    private String eYw = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean fpf = false;
    private String forumId = null;
    private FrsViewData eYh = new FrsViewData();
    public long eCw = -1;
    public long cqp = 0;
    public long cqx = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean eYP = false;
    protected a fpi = null;
    private int dRL = -1;
    private int mTabId = 0;
    private int ffZ = 3;
    private boolean eqT = false;
    public boolean fpk = false;
    private boolean fpl = false;
    private CustomMessageListener fbC = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.fdA != null && FrsGoodFragment.this.fdA.isViewAttached()) {
                FrsGoodFragment.this.fdA.jN(num.intValue());
            }
        }
    };
    private Runnable fpm = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        @Override // java.lang.Runnable
        public void run() {
            if (!j.kY() || FrsGoodFragment.this.eqT) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.jJ(false);
            }
        }
    };
    private CustomMessageListener fpn = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                FrsGoodFragment.this.fpe = bgVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.fpe) && bgVar.YA() != null) {
                    FrsGoodFragment.this.qT(bgVar.YA().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener eZG = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.aeZ() != null) {
                            FrsGoodFragment.this.aeZ().setSelection(0);
                        }
                        if (FrsGoodFragment.this.fdA != null && FrsGoodFragment.this.fdA.isViewAttached()) {
                            FrsGoodFragment.this.jJ(false);
                        } else if (FrsGoodFragment.this.fpi != null) {
                            FrsGoodFragment.this.fpi.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n eZU = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        private long fpq = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void pT(int i) {
            if (!FrsGoodFragment.this.fpl) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.fpi.bdv();
                        return;
                    case 3:
                        FrsGoodFragment.this.fpi.fB(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.fpl) {
                if (FrsGoodFragment.this.bhf().bhm() == null) {
                    FrsGoodFragment.this.fpl = false;
                    return;
                } else if (FrsGoodFragment.this.bhf().bhm().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.fpl = false;
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
                FrsGoodFragment.this.fph.resetData();
            }
            FrsGoodFragment.this.fpi.fB(false);
            if (FrsGoodFragment.this.bhf().bhm() != null) {
                FrsGoodFragment.this.eYh = FrsGoodFragment.this.bhf().bhm();
            }
            FrsGoodFragment.this.dRL = FrsGoodFragment.this.eYh.getPage().XH();
            if (FrsGoodFragment.this.dRL == 0 && (FrsGoodFragment.this.eYh.getThreadListIds() == null || FrsGoodFragment.this.eYh.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.eYh.getThreadList() == null || FrsGoodFragment.this.eYh.getThreadList().size() == 0) {
                    FrsGoodFragment.this.fpi.aCt();
                } else {
                    FrsGoodFragment.this.fpi.aCs();
                }
            } else {
                FrsGoodFragment.this.fpi.aCr();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.fph.a(false, false, false, FrsGoodFragment.this.eYh.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.eYh.setThreadList(a2);
                    FrsGoodFragment.this.fpi.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.eYh, FrsGoodFragment.this.dRL);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.fpi.bdv();
                    break;
                case 2:
                    FrsGoodFragment.this.fpi.bdv();
                    break;
                case 3:
                    if (FrsGoodFragment.this.eYh.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.fpq != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.eYh != null) {
                    FrsGoodFragment.this.eYw = FrsGoodFragment.this.eYh.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.eYh.getForum().getId();
                    FrsGoodFragment.this.fpi.b(FrsGoodFragment.this.eYh.getForum(), FrsGoodFragment.this.eYh.getUserData());
                }
                if (FrsGoodFragment.this.eYh != null) {
                    FrsGoodFragment.this.eYh.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.fpi.c(FrsGoodFragment.this.eYh);
                if (FrsGoodFragment.this.eYh == null || FrsGoodFragment.this.eYh.getThreadList() == null || FrsGoodFragment.this.eYh.getThreadList().size() != 0 || FrsGoodFragment.this.bhf().getType() != 4) {
                    if (FrsGoodFragment.this.eYh != null && (a = FrsGoodFragment.this.fph.a(false, false, true, FrsGoodFragment.this.eYh.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.eYh.setThreadList(a);
                    }
                    FrsGoodFragment.this.bcH();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(d.j.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.eCw > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.eCw, FrsGoodFragment.this.bhf().aWS() - FrsGoodFragment.this.eCw, FrsGoodFragment.this.bhf().aWQ(), FrsGoodFragment.this.bhf().aWR(), currentTimeMillis2 - FrsGoodFragment.this.bhf().aWP());
                        FrsGoodFragment.this.eCw = -1L;
                    }
                    FrsGoodFragment.this.cqx = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.eCw > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.eCw, FrsGoodFragment.this.bhf().aWS() - FrsGoodFragment.this.eCw, FrsGoodFragment.this.bhf().aWQ(), FrsGoodFragment.this.bhf().aWR(), currentTimeMillis3 - FrsGoodFragment.this.bhf().aWP());
                FrsGoodFragment.this.eCw = -1L;
            }
            FrsGoodFragment.this.cqx = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
        }
    };
    private final CustomMessageListener bvw = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.fpi != null) {
                FrsGoodFragment.this.fpi.startPullRefresh();
            }
        }
    };
    private final h.c dht = new h.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.kY()) {
                com.baidu.tieba.a.d.awh().qL("page_frs_good");
                FrsGoodFragment.this.jJ(true);
                return;
            }
            FrsGoodFragment.this.fpi.fB(false);
        }
    };
    private final h.b bRJ = new h.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.cdp().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.eYP) {
                FrsGoodFragment.this.eYP = true;
                FrsGoodFragment.this.fpi.bdL();
            }
            if (i == 0) {
                t.aQD().hQ(true);
                com.baidu.tieba.q.c.cdp().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener bZe = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
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
    private s faa = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bf)) {
                bg bgVar = ((bf) mVar).threadData;
                if (bgVar.ZG() == null || bgVar.ZG().getGroup_id() == 0 || bc.cZ(FrsGoodFragment.this.getActivity())) {
                    if (bgVar.Zy() != 1 || bc.cZ(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.CM(bgVar.getId())) {
                            readThreadHistory.CL(bgVar.getId());
                            if (FrsGoodFragment.this.fpi != null) {
                                FrsGoodFragment.this.fpi.bdv();
                            }
                        }
                        boolean z = false;
                        final String YV = bgVar.YV();
                        if (YV != null && !YV.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6.1
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
                            ba.adA().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bgVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bgVar, FrsGoodFragment.this.eYw, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.fpk ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsGoodFragment.this.eYh != null && FrsGoodFragment.this.eYh.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fsM = FrsGoodFragment.this.eYh.needLog == 1;
                            bVar.fsO = FrsGoodFragment.this.eYh.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.fgQ != null) {
                                bVar.fsP = com.baidu.tieba.frs.d.d.fgQ.fsP;
                                bVar.fsQ = com.baidu.tieba.frs.d.d.fgQ.fsQ;
                            }
                            com.baidu.tieba.frs.d.a.a(bgVar, 1, FrsGoodFragment.this.getUniqueId(), bVar);
                        }
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
        this.fpi.jv(false);
        showLoadingView(this.fpi.bdJ(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fpi.jv(true);
        hideLoadingView(this.fpi.bdJ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fpi.jv(false);
        this.fpi.beI().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fpi.aCt();
        this.fpi.getListView().getData().clear();
        this.fpi.bdv();
        if (this.fdA == null) {
            this.fdA = new c(getPageContext().getContext(), getNetRefreshListener());
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
        this.fdA.attachView(this.fpi.bdJ(), true);
        registerListener(this.fbC);
    }

    private void aBq() {
        this.fpi.jv(true);
        this.fpi.beI().setEnabled(true);
        if (this.fdA != null && this.fdA.isViewAttached()) {
            this.fdA.dettachView(this.fpi.bdJ());
        }
        MessageManager.getInstance().unRegisterListener(this.fbC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jJ(boolean z) {
        this.eqT = true;
        bcK();
        aBq();
        if (!z) {
            aBq();
            showLoadingView();
        }
        this.fpg.me(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eCw = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eCw = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.cqp = this.beginTime - this.eCw;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cdp().s(getUniqueId());
        this.fpg = new FrsGoodModelController(this);
        if (arguments != null) {
            this.fpg.J(arguments);
            this.fpf = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.fpg.J(bundle);
            this.fpf = bundle.getBoolean("is_game_frs", false);
        } else {
            this.fpg.J(null);
        }
        this.eYD = getVoiceManager();
        this.eYD.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bvw);
        registerListener(this.fpn);
        registerListener(this.eZG);
        this.fph = new FrsLoadMoreModel(this, null);
        this.fph.registerListener();
        this.fph.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_good_activity, (ViewGroup) null);
        this.fpi = new a(this, inflate, this.fpf);
        this.fpi.bhj().jL(this.fpk);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eqT) {
            if (j.kY()) {
                jJ(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.eYD = getVoiceManager();
        this.eYD.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bhd();
        if (bundle != null) {
            this.eYw = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fpk = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.eYw = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.fpk = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bhd() {
        registerListener(2001118, this.bZe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fpi != null) {
            this.fpi.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fbC);
        com.baidu.tieba.q.c.cdp().t(getUniqueId());
        t.aQD().hQ(false);
        super.onDestroy();
        this.fpg.onActivityDestroy();
        this.eYD = getVoiceManager();
        this.eYD.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fpm);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.eYw);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.fpf);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fpk);
        this.fpg.onSaveInstanceState(bundle);
        this.eYD = getVoiceManager();
        if (this.eYD != null) {
            this.eYD.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bg threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.fpi.bhj().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.eYh.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.gt(intent.getIntExtra("good_data", 0));
                            threadDataById.ZE();
                            jJ(false);
                            return;
                        } else if (intExtra == 0) {
                            this.eYh.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.eYh.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.m());
                            }
                            this.fpi.bhh();
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
            if (!this.eqT) {
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
        if (this.fpi != null) {
            this.fpi.bdv();
        }
        this.eYD = getVoiceManager();
        this.eYD.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fpj = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.fpi.setOnAdapterItemClickListener(this.faa);
        this.fpi.setOnScrollListener(this.mScrollListener);
        this.fpi.setListPullRefreshListener(this.dht);
        this.fpi.a(this.bRJ);
        this.fpi.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.fpj != null) {
                    FrsGoodFragment.this.fpj.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ffZ != 3 || this.fpi != null) {
            this.ffZ = i;
            super.onChangeSkinType(i);
            if (this.fpi != null) {
                this.fpi.onChangeSkinType(i);
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
                com.baidu.adp.lib.g.h.jI().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.CG(FrsGoodFragment.this.eYw);
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
            if (this.eYh != null) {
                this.fpi.aOs();
                this.eYw = this.eYh.getForum().getName();
                this.forumId = this.eYh.getForum().getId();
                if (this.eYh != null && this.eYh.getForum() != null) {
                    this.fpi.a(this.eYh.getForum().getThemeColorInfo());
                    this.fpi.c(this.eYh);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.eYh.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.eYh.getUserData().getBimg_end_time());
                bcG();
                if (!this.fpi.bhj().l(bg.bBh)) {
                    this.eYh.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.eYh.getThreadList();
                if (threadList != null) {
                    this.fpi.a(threadList, this.mPn, this.eYh, this.eYh.getPage().XH());
                    bhe();
                    this.fpi.bhh();
                    if (this.eYh.getIsNewUrl() == 1) {
                        this.fpi.bhj().setFromCDN(true);
                    } else {
                        this.fpi.bhj().setFromCDN(false);
                    }
                    this.fpi.setListViewSelection(bq(bhf().getType(), this.mPn));
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
        this.eYD = getVoiceManager();
        this.eYD.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.aQD().hQ(false);
        com.baidu.tieba.q.c.cdp().b(getUniqueId(), false);
        if (this.eYh != null && this.eYh.getForum() != null) {
            com.baidu.tbadk.distribute.a.alC().a(getPageContext().getPageActivity(), "frs", this.eYh.getForum().getId(), 0L);
        }
        this.eYD = getVoiceManager();
        if (this.eYD != null) {
            this.eYD.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qT(int i) {
        ArrayList<m> threadList = this.eYh.getThreadList();
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
            this.fpi.bhj().b(threadList, this.eYh);
            this.fpi.bhj().notifyDataSetChanged();
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
        if (this.eYD == null) {
            this.eYD = VoiceManager.instance();
        }
        return this.eYD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aeZ() {
        if (this.fpi == null) {
            return null;
        }
        return this.fpi.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bcK() {
        this.eYD = getVoiceManager();
        this.eYD.stopPlay();
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
        if (this.eYh != null && this.fpi != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fpi.bdv();
            }
        }
    }

    private void bhe() {
        HashMap<Integer, bg> bfy;
        if (this.fpi != null && this.fpi.bhj() != null && (bfy = this.fpi.bhj().bfy()) != null) {
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
        if (j.kY()) {
            jJ(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bcP() {
        return this.eYh;
    }

    public FrsGoodModelController bhf() {
        return this.fpg;
    }

    public void vv(String str) {
        this.eYw = str;
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
        if (!l.lo()) {
            this.fpi.aCt();
        } else if (!this.fpg.bho()) {
            this.fpi.aCt();
        } else {
            aBn();
            if (!this.fph.isLoading && !this.fpg.qz()) {
                if (this.fph.ca(this.eYh.getThreadListIds())) {
                    this.fpi.a(this.fph.bhy(), this.mPn, this.eYh, 0);
                    this.fph.a(com.baidu.adp.lib.g.b.d(this.forumId, 0L), this.eYh.getThreadListIds(), this.eYw, this.mPn, this.eYh.isBrandForum);
                } else if (this.dRL != 0) {
                    this.fpi.a(this.fph.bhy(), this.mPn, this.eYh, 0);
                    this.mPn++;
                    this.fpg.qV(this.mPn);
                    this.fph.loadingDone = false;
                    this.fph.loadIndex = 0;
                }
            }
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.fph.a(false, false, false, arrayList, (f) null)) != null) {
            this.eYh.setThreadList(a);
            this.fpi.a(a, this.mPn, this.eYh, 0);
        }
    }

    private void aBn() {
        if (this.dRL == 0 && !this.fph.ca(this.eYh.getThreadListIds())) {
            if (this.eYh.getThreadList() == null || this.eYh.getThreadList().size() == 0) {
                this.fpi.aCt();
                return;
            } else {
                this.fpi.aCs();
                return;
            }
        }
        this.fpi.aCr();
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
        if (this.fpg != null) {
            this.fpg.bcJ();
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
        return this.eYw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qU(int i) {
        this.mTabId = i;
        if (j.kY()) {
            jJ(false);
        } else {
            c((e.b) null);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcb() {
        if (this.fpi != null && this.fpi.getListView() != null) {
            this.fpi.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCq() {
        if (this.fpi != null) {
            bcb();
            this.fpi.startPullRefresh();
        }
    }
}
