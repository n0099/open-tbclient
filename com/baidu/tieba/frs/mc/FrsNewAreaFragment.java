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
    private VoiceManager eYS;
    private com.baidu.tbadk.m.c fdO;
    private String fpu;
    private FrsLoadMoreModel fpx;
    private FrsNewAreaModelController frQ;
    private String eYL = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData eYw = new FrsViewData();
    public long eCP = -1;
    public long cqn = 0;
    public long cqv = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean eZe = false;
    protected g frR = null;
    private int dSy = -1;
    private int fgn = 3;
    private boolean erl = false;
    public boolean fpA = false;
    private boolean fpB = false;
    private CustomMessageListener fbQ = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.fdO != null && FrsNewAreaFragment.this.fdO.isViewAttached()) {
                FrsNewAreaFragment.this.fdO.jO(num.intValue());
            }
        }
    };
    private Runnable fpC = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.kY() || FrsNewAreaFragment.this.erl) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.jJ(false);
            }
        }
    };
    private CustomMessageListener fpD = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                FrsNewAreaFragment.this.fpu = bgVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.fpu) && bgVar.YD() != null) {
                    FrsNewAreaFragment.this.qX(bgVar.YD().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener eZV = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.afc() != null) {
                        FrsNewAreaFragment.this.afc().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.fdO != null && FrsNewAreaFragment.this.fdO.isViewAttached()) {
                        FrsNewAreaFragment.this.jJ(false);
                    } else if (FrsNewAreaFragment.this.frR != null) {
                        FrsNewAreaFragment.this.frR.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n faj = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long fpG = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void pX(int i) {
            if (!FrsNewAreaFragment.this.fpB) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.frR.bdx();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.frR.fB(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.fpB) {
                if (FrsNewAreaFragment.this.bhV().bho() == null) {
                    FrsNewAreaFragment.this.fpB = false;
                    return;
                } else if (FrsNewAreaFragment.this.bhV().bho().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.fpB = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.fpG = 1L;
            } else if (bVar.isSuccess) {
                this.fpG = 0L;
            } else {
                this.fpG = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.fpx.resetData();
            }
            FrsNewAreaFragment.this.frR.fB(false);
            if (FrsNewAreaFragment.this.bhV().bho() != null) {
                FrsNewAreaFragment.this.eYw = FrsNewAreaFragment.this.bhV().bho();
            }
            FrsNewAreaFragment.this.dSy = FrsNewAreaFragment.this.eYw.getPage().XK();
            if (FrsNewAreaFragment.this.dSy == 0 && (FrsNewAreaFragment.this.eYw.getThreadListIds() == null || FrsNewAreaFragment.this.eYw.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.eYw.getThreadList() == null || FrsNewAreaFragment.this.eYw.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.frR.aCw();
                } else {
                    FrsNewAreaFragment.this.frR.aCv();
                }
            } else {
                FrsNewAreaFragment.this.frR.aCu();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.fpx.a(false, false, false, FrsNewAreaFragment.this.eYw.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.eYw.setThreadList(a2);
                    FrsNewAreaFragment.this.frR.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.eYw, FrsNewAreaFragment.this.dSy);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.frR.bdx();
                    break;
                case 2:
                    FrsNewAreaFragment.this.frR.bdx();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.eYw.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.fpG != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.eYw != null) {
                    FrsNewAreaFragment.this.eYL = FrsNewAreaFragment.this.eYw.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.eYw.getForum().getId();
                    FrsNewAreaFragment.this.frR.b(FrsNewAreaFragment.this.eYw.getForum(), FrsNewAreaFragment.this.eYw.getUserData());
                }
                if (FrsNewAreaFragment.this.eYw != null) {
                    FrsNewAreaFragment.this.eYw.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.eYw == null || FrsNewAreaFragment.this.eYw.getThreadList() == null || FrsNewAreaFragment.this.eYw.getThreadList().size() != 0 || FrsNewAreaFragment.this.bhV().getType() != 4) {
                    if (FrsNewAreaFragment.this.eYw != null && (a = FrsNewAreaFragment.this.fpx.a(false, false, true, FrsNewAreaFragment.this.eYw.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.eYw.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bcJ();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(d.j.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.eCP > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsNewAreaFragment.this.eCP, FrsNewAreaFragment.this.bhV().aWU() - FrsNewAreaFragment.this.eCP, FrsNewAreaFragment.this.bhV().aWS(), FrsNewAreaFragment.this.bhV().aWT(), currentTimeMillis2 - FrsNewAreaFragment.this.bhV().aWR());
                        FrsNewAreaFragment.this.eCP = -1L;
                    }
                    FrsNewAreaFragment.this.cqv = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.eCP > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsNewAreaFragment.this.eCP, FrsNewAreaFragment.this.bhV().aWU() - FrsNewAreaFragment.this.eCP, FrsNewAreaFragment.this.bhV().aWS(), FrsNewAreaFragment.this.bhV().aWT(), currentTimeMillis3 - FrsNewAreaFragment.this.bhV().aWR());
                FrsNewAreaFragment.this.eCP = -1L;
            }
            FrsNewAreaFragment.this.cqv = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
        }
    };
    private final CustomMessageListener bvr = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.frR != null) {
                FrsNewAreaFragment.this.frR.startPullRefresh();
            }
        }
    };
    private final h.c dhu = new h.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.kY()) {
                com.baidu.tieba.a.d.awk().qL("page_frs_good");
                FrsNewAreaFragment.this.jJ(true);
                return;
            }
            FrsNewAreaFragment.this.frR.fB(false);
        }
    };
    private final h.b bRG = new h.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.cdq().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.eZe) {
                FrsNewAreaFragment.this.eZe = true;
                FrsNewAreaFragment.this.frR.bdN();
            }
            if (i == 0) {
                t.aQF().hQ(true);
                com.baidu.tieba.q.c.cdq().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener bZb = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
    private s fap = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bf)) {
                bg bgVar = ((bf) mVar).threadData;
                if (bgVar.ZJ() == null || bgVar.ZJ().getGroup_id() == 0 || bc.cZ(FrsNewAreaFragment.this.getActivity())) {
                    if (bgVar.ZB() != 1 || bc.cZ(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.CO(bgVar.getId())) {
                            readThreadHistory.CN(bgVar.getId());
                            if (FrsNewAreaFragment.this.frR != null) {
                                FrsNewAreaFragment.this.frR.bdx();
                            }
                        }
                        boolean z = false;
                        final String YY = bgVar.YY();
                        if (YY != null && !YY.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(YY);
                                    xVar.acH().adF().mIsNeedAddCommenParam = false;
                                    xVar.acH().adF().mIsUseCurrentBDUSS = false;
                                    xVar.ack();
                                }
                            }).start();
                        }
                        String tid = bgVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bgVar.YM() == 2 && !tid.startsWith("pb:")) {
                            ba.adD().c(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bgVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bgVar, FrsNewAreaFragment.this.eYL, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsNewAreaFragment.this.fpA ? 15 : 3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.eYw != null && FrsNewAreaFragment.this.eYw.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.ftb = FrsNewAreaFragment.this.eYw.needLog == 1;
                            bVar.ftd = FrsNewAreaFragment.this.eYw.getForum().getId();
                            bVar.ftc = FrsNewAreaFragment.this.frQ.bhP();
                            if (com.baidu.tieba.frs.d.d.fhf != null) {
                                bVar.fte = com.baidu.tieba.frs.d.d.fhf.fte;
                                bVar.ftf = com.baidu.tieba.frs.d.d.fhf.ftf;
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

    public void ad(bg bgVar) {
        if (bgVar != null) {
            this.frQ.ad(bgVar);
            this.frR.bcd();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.eYw = frsViewData;
            hideLoadingView(this.frR.bdL());
            if (this.frR != null) {
                this.frR.fB(false);
                this.frR.a(null, this.mPn, this.eYw, this.dSy);
            }
        }
    }

    private void showLoadingView() {
        this.frR.jv(false);
        showLoadingView(this.frR.bdL(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.frR.jv(true);
        hideLoadingView(this.frR.bdL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.frR.jv(false);
        this.frR.beK().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.frR.aCw();
        this.frR.getListView().getData().clear();
        this.frR.bdx();
        if (this.fdO == null) {
            this.fdO = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fdO.setTitle(null);
            this.fdO.setButtonText(null);
            this.fdO.anC();
            this.fdO.anD().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.fdO.po(getPageContext().getResources().getString(d.j.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.fdO.po(null);
        }
        this.fdO.onChangeSkinType();
        this.fdO.attachView(this.frR.bdL(), true);
        registerListener(this.fbQ);
    }

    private void aBt() {
        this.frR.jv(true);
        this.frR.beK().setEnabled(true);
        if (this.fdO != null && this.fdO.isViewAttached()) {
            this.fdO.dettachView(this.frR.bdL());
        }
        MessageManager.getInstance().unRegisterListener(this.fbQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jJ(boolean z) {
        this.erl = true;
        bcM();
        aBt();
        if (!z) {
            aBt();
            showLoadingView();
        }
        this.frQ.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eCP = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eCP = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.cqn = this.beginTime - this.eCP;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cdq().s(getUniqueId());
        this.frQ = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.frQ.J(arguments);
        } else if (bundle != null) {
            this.frQ.J(bundle);
        } else {
            this.frQ.J(null);
        }
        this.eYS = getVoiceManager();
        this.eYS.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bvr);
        registerListener(this.fpD);
        registerListener(this.eZV);
        this.fpx = new FrsLoadMoreModel(this, null);
        this.fpx.registerListener();
        this.fpx.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_good_activity, (ViewGroup) null);
        this.frR = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.erl) {
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
        this.eYS = getVoiceManager();
        this.eYS.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bhf();
        if (bundle != null) {
            this.eYL = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.eYL = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bhf() {
        registerListener(2001118, this.bZb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.frR != null) {
            this.frR.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fbQ);
        com.baidu.tieba.q.c.cdq().t(getUniqueId());
        t.aQF().hQ(false);
        super.onDestroy();
        this.frQ.onActivityDestroy();
        this.eYS = getVoiceManager();
        this.eYS.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fpC);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.eYL);
        bundle.putString("from", this.mFrom);
        this.frQ.onSaveInstanceState(bundle);
        this.eYS = getVoiceManager();
        if (this.eYS != null) {
            this.eYS.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bg threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.frR.bhX().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.eYw.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.gu(intent.getIntExtra("good_data", 0));
                            threadDataById.ZH();
                            jJ(false);
                            return;
                        } else if (intExtra == 0) {
                            this.eYw.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.eYw.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.m());
                            }
                            this.frR.bhj();
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
            if (this.fgn == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.erl) {
                com.baidu.adp.lib.g.e.jH().post(this.fpC);
            }
        }
        beB();
    }

    private void beB() {
        if (isPrimary()) {
            if (this.fdO != null && this.fdO.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fbQ);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fbQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.frR != null) {
            this.frR.bdx();
        }
        this.eYS = getVoiceManager();
        this.eYS.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.frR.setOnAdapterItemClickListener(this.fap);
        this.frR.setOnScrollListener(this.mScrollListener);
        this.frR.setListPullRefreshListener(this.dhu);
        this.frR.a(this.bRG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fgn != 3 || this.frR != null) {
            this.fgn = i;
            super.onChangeSkinType(i);
            if (this.frR != null) {
                this.frR.onChangeSkinType(i);
            }
            if (this.fdO != null && this.fdO.isViewAttached()) {
                this.fdO.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bbQ() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bbQ();
        }
        return null;
    }

    private void bcI() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jI().d(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.CI(FrsNewAreaFragment.this.eYL);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcJ() {
        bcM();
        try {
            if (this.eYw != null) {
                this.frR.aOA();
                this.eYL = this.eYw.getForum().getName();
                this.forumId = this.eYw.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.eYw.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.eYw.getUserData().getBimg_end_time());
                bcI();
                ArrayList<m> threadList = this.eYw.getThreadList();
                if (threadList != null) {
                    this.frR.a(threadList, this.mPn, this.eYw, this.eYw.getPage().XK());
                    bhg();
                    this.frR.bhj();
                    if (this.eYw.getIsNewUrl() == 1) {
                        this.frR.bhX().setFromCDN(true);
                    } else {
                        this.frR.bhX().setFromCDN(false);
                    }
                    this.frR.setListViewSelection(bq(bhV().getType(), this.mPn));
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
        this.eYS = getVoiceManager();
        this.eYS.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.aQF().hQ(false);
        com.baidu.tieba.q.c.cdq().b(getUniqueId(), false);
        if (this.eYw != null && this.eYw.getForum() != null) {
            com.baidu.tbadk.distribute.a.alG().a(getPageContext().getPageActivity(), "frs", this.eYw.getForum().getId(), 0L);
        }
        this.eYS = getVoiceManager();
        if (this.eYS != null) {
            this.eYS.onStop(getPageContext());
        }
    }

    public void bfg() {
        if (this.frR != null) {
            this.frR.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX(int i) {
        ArrayList<m> threadList = this.eYw.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bf) {
                    bg bgVar = ((bf) next).threadData;
                    if (bgVar.getId() != null && bgVar.getId().equals(this.fpu)) {
                        c(bgVar, i);
                        this.fpu = null;
                        break;
                    }
                }
            }
            this.frR.bhX().b(threadList, this.eYw);
            this.frR.bhX().notifyDataSetChanged();
        }
    }

    private void c(bg bgVar, int i) {
        if (i == 1) {
            PraiseData YD = bgVar.YD();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (YD == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bgVar.a(praiseData);
                    return;
                }
                bgVar.YD().getUser().add(0, metaData);
                bgVar.YD().setNum(bgVar.YD().getNum() + 1);
                bgVar.YD().setIsLike(i);
            }
        } else if (bgVar.YD() != null) {
            bgVar.YD().setIsLike(i);
            bgVar.YD().setNum(bgVar.YD().getNum() - 1);
            ArrayList<MetaData> user = bgVar.YD().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bgVar.YD().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYS == null) {
            this.eYS = VoiceManager.instance();
        }
        return this.eYS;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView afc() {
        if (this.frR == null) {
            return null;
        }
        return this.frR.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bcM() {
        this.eYS = getVoiceManager();
        this.eYS.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> afd() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).afd();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.eYw != null && this.frR != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.frR.bdx();
            }
        }
    }

    private void bhg() {
        HashMap<Integer, bg> bfA;
        if (this.frR != null && this.frR.bhX() != null && (bfA = this.frR.bhX().bfA()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bg> entry : bfA.entrySet()) {
                bg value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.alL().u(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        if (afc() == null) {
            return null;
        }
        return afc().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kY()) {
            jJ(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bcR() {
        return this.eYw;
    }

    public FrsNewAreaModelController bhV() {
        return this.frQ;
    }

    public void vx(String str) {
        this.eYL = str;
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

    public void aBc() {
        if (!this.fpx.isLoading && !this.frQ.qz()) {
            if (this.fpx.cd(this.eYw.getThreadListIds())) {
                this.frR.a(this.fpx.bhA(), this.mPn, this.eYw, 0);
                this.fpx.a(com.baidu.adp.lib.g.b.d(this.forumId, 0L), this.eYw.getThreadListIds(), this.eYL, this.mPn, this.eYw.isBrandForum);
            } else if (this.dSy != 0) {
                this.frR.a(this.fpx.bhA(), this.mPn, this.eYw, 0);
                this.mPn++;
                this.frQ.qZ(this.mPn);
                this.fpx.loadingDone = false;
                this.fpx.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.lo()) {
            this.frR.aCw();
        } else if (!this.frR.bdG()) {
            if (!this.frQ.bhq()) {
                this.frR.aCw();
                return;
            }
            aBq();
            aBc();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void uG(String str) {
        aBq();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void R(ArrayList<m> arrayList) {
        ArrayList<m> a;
        aBq();
        if (arrayList != null && arrayList.size() != 0 && (a = this.fpx.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.eYw.setThreadList(a);
            this.frR.a(a, this.mPn, this.eYw, 0);
        }
    }

    public void ce(List<String> list) {
        bR(list);
        int i = 0;
        Iterator<m> it = this.eYw.getThreadList().iterator();
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
            aBc();
        }
    }

    private void bR(List<String> list) {
        if (!v.T(list)) {
            ArrayList<m> threadList = this.eYw.getThreadList();
            if (!v.T(threadList) && this.frR.getListView() != null && this.frR.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.frR.getListView().getData();
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
                                this.fpx.e(next);
                                this.frR.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    private void aBq() {
        if (this.dSy == 0 && !this.fpx.cd(this.eYw.getThreadListIds())) {
            if (this.eYw.getThreadList() == null || this.eYw.getThreadList().size() == 0) {
                this.frR.aCw();
                return;
            } else {
                this.frR.aCv();
                return;
            }
        }
        this.frR.aCu();
    }

    public g bhW() {
        return this.frR;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0040a
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
        com.baidu.tbadk.distribute.a.alG().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bcL() {
        if (this.frQ != null) {
            this.frQ.bcL();
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
    public NavigationBar aDp() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.eYL;
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcd() {
        if (this.frR != null && this.frR.getListView() != null) {
            this.frR.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCt() {
        if (this.frR != null) {
            bcd();
            this.frR.startPullRefresh();
        }
    }
}
