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
    private VoiceManager eYR;
    private com.baidu.tbadk.m.c fdN;
    private String fpt;
    private FrsLoadMoreModel fpw;
    private FrsNewAreaModelController frP;
    private String eYK = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData eYv = new FrsViewData();
    public long eCL = -1;
    public long cqn = 0;
    public long cqv = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean eZd = false;
    protected g frQ = null;
    private int dSu = -1;
    private int fgm = 3;
    private boolean erh = false;
    public boolean fpz = false;
    private boolean fpA = false;
    private CustomMessageListener fbP = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.fdN != null && FrsNewAreaFragment.this.fdN.isViewAttached()) {
                FrsNewAreaFragment.this.fdN.jO(num.intValue());
            }
        }
    };
    private Runnable fpB = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.kY() || FrsNewAreaFragment.this.erh) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.jJ(false);
            }
        }
    };
    private CustomMessageListener fpC = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                FrsNewAreaFragment.this.fpt = bgVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.fpt) && bgVar.YD() != null) {
                    FrsNewAreaFragment.this.qX(bgVar.YD().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener eZU = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.afc() != null) {
                        FrsNewAreaFragment.this.afc().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.fdN != null && FrsNewAreaFragment.this.fdN.isViewAttached()) {
                        FrsNewAreaFragment.this.jJ(false);
                    } else if (FrsNewAreaFragment.this.frQ != null) {
                        FrsNewAreaFragment.this.frQ.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n fai = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long fpF = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void pX(int i) {
            if (!FrsNewAreaFragment.this.fpA) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.frQ.bdx();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.frQ.fB(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.fpA) {
                if (FrsNewAreaFragment.this.bhV().bho() == null) {
                    FrsNewAreaFragment.this.fpA = false;
                    return;
                } else if (FrsNewAreaFragment.this.bhV().bho().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.fpA = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.fpF = 1L;
            } else if (bVar.isSuccess) {
                this.fpF = 0L;
            } else {
                this.fpF = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.fpw.resetData();
            }
            FrsNewAreaFragment.this.frQ.fB(false);
            if (FrsNewAreaFragment.this.bhV().bho() != null) {
                FrsNewAreaFragment.this.eYv = FrsNewAreaFragment.this.bhV().bho();
            }
            FrsNewAreaFragment.this.dSu = FrsNewAreaFragment.this.eYv.getPage().XK();
            if (FrsNewAreaFragment.this.dSu == 0 && (FrsNewAreaFragment.this.eYv.getThreadListIds() == null || FrsNewAreaFragment.this.eYv.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.eYv.getThreadList() == null || FrsNewAreaFragment.this.eYv.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.frQ.aCw();
                } else {
                    FrsNewAreaFragment.this.frQ.aCv();
                }
            } else {
                FrsNewAreaFragment.this.frQ.aCu();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.fpw.a(false, false, false, FrsNewAreaFragment.this.eYv.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.eYv.setThreadList(a2);
                    FrsNewAreaFragment.this.frQ.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.eYv, FrsNewAreaFragment.this.dSu);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.frQ.bdx();
                    break;
                case 2:
                    FrsNewAreaFragment.this.frQ.bdx();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.eYv.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.fpF != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.eYv != null) {
                    FrsNewAreaFragment.this.eYK = FrsNewAreaFragment.this.eYv.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.eYv.getForum().getId();
                    FrsNewAreaFragment.this.frQ.b(FrsNewAreaFragment.this.eYv.getForum(), FrsNewAreaFragment.this.eYv.getUserData());
                }
                if (FrsNewAreaFragment.this.eYv != null) {
                    FrsNewAreaFragment.this.eYv.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.eYv == null || FrsNewAreaFragment.this.eYv.getThreadList() == null || FrsNewAreaFragment.this.eYv.getThreadList().size() != 0 || FrsNewAreaFragment.this.bhV().getType() != 4) {
                    if (FrsNewAreaFragment.this.eYv != null && (a = FrsNewAreaFragment.this.fpw.a(false, false, true, FrsNewAreaFragment.this.eYv.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.eYv.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bcJ();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(d.j.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.eCL > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsNewAreaFragment.this.eCL, FrsNewAreaFragment.this.bhV().aWU() - FrsNewAreaFragment.this.eCL, FrsNewAreaFragment.this.bhV().aWS(), FrsNewAreaFragment.this.bhV().aWT(), currentTimeMillis2 - FrsNewAreaFragment.this.bhV().aWR());
                        FrsNewAreaFragment.this.eCL = -1L;
                    }
                    FrsNewAreaFragment.this.cqv = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.eCL > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsNewAreaFragment.this.eCL, FrsNewAreaFragment.this.bhV().aWU() - FrsNewAreaFragment.this.eCL, FrsNewAreaFragment.this.bhV().aWS(), FrsNewAreaFragment.this.bhV().aWT(), currentTimeMillis3 - FrsNewAreaFragment.this.bhV().aWR());
                FrsNewAreaFragment.this.eCL = -1L;
            }
            FrsNewAreaFragment.this.cqv = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
        }
    };
    private final CustomMessageListener bvt = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.frQ != null) {
                FrsNewAreaFragment.this.frQ.startPullRefresh();
            }
        }
    };
    private final h.c dhq = new h.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.kY()) {
                com.baidu.tieba.a.d.awk().qK("page_frs_good");
                FrsNewAreaFragment.this.jJ(true);
                return;
            }
            FrsNewAreaFragment.this.frQ.fB(false);
        }
    };
    private final h.b bRH = new h.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.cdt().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.eZd) {
                FrsNewAreaFragment.this.eZd = true;
                FrsNewAreaFragment.this.frQ.bdN();
            }
            if (i == 0) {
                t.aQF().hQ(true);
                com.baidu.tieba.q.c.cdt().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener bZc = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
    private s fao = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bf)) {
                bg bgVar = ((bf) mVar).threadData;
                if (bgVar.ZJ() == null || bgVar.ZJ().getGroup_id() == 0 || bc.cZ(FrsNewAreaFragment.this.getActivity())) {
                    if (bgVar.ZB() != 1 || bc.cZ(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.CN(bgVar.getId())) {
                            readThreadHistory.CM(bgVar.getId());
                            if (FrsNewAreaFragment.this.frQ != null) {
                                FrsNewAreaFragment.this.frQ.bdx();
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
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bgVar, FrsNewAreaFragment.this.eYK, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsNewAreaFragment.this.fpz ? 15 : 3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.eYv != null && FrsNewAreaFragment.this.eYv.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fta = FrsNewAreaFragment.this.eYv.needLog == 1;
                            bVar.ftc = FrsNewAreaFragment.this.eYv.getForum().getId();
                            bVar.ftb = FrsNewAreaFragment.this.frP.bhP();
                            if (com.baidu.tieba.frs.d.d.fhe != null) {
                                bVar.ftd = com.baidu.tieba.frs.d.d.fhe.ftd;
                                bVar.fte = com.baidu.tieba.frs.d.d.fhe.fte;
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
            this.frP.ad(bgVar);
            this.frQ.bcd();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.eYv = frsViewData;
            hideLoadingView(this.frQ.bdL());
            if (this.frQ != null) {
                this.frQ.fB(false);
                this.frQ.a(null, this.mPn, this.eYv, this.dSu);
            }
        }
    }

    private void showLoadingView() {
        this.frQ.jv(false);
        showLoadingView(this.frQ.bdL(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.frQ.jv(true);
        hideLoadingView(this.frQ.bdL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.frQ.jv(false);
        this.frQ.beK().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.frQ.aCw();
        this.frQ.getListView().getData().clear();
        this.frQ.bdx();
        if (this.fdN == null) {
            this.fdN = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fdN.setTitle(null);
            this.fdN.setButtonText(null);
            this.fdN.anB();
            this.fdN.anC().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.fdN.po(getPageContext().getResources().getString(d.j.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.fdN.po(null);
        }
        this.fdN.onChangeSkinType();
        this.fdN.attachView(this.frQ.bdL(), true);
        registerListener(this.fbP);
    }

    private void aBt() {
        this.frQ.jv(true);
        this.frQ.beK().setEnabled(true);
        if (this.fdN != null && this.fdN.isViewAttached()) {
            this.fdN.dettachView(this.frQ.bdL());
        }
        MessageManager.getInstance().unRegisterListener(this.fbP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jJ(boolean z) {
        this.erh = true;
        bcM();
        aBt();
        if (!z) {
            aBt();
            showLoadingView();
        }
        this.frP.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eCL = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eCL = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.cqn = this.beginTime - this.eCL;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cdt().s(getUniqueId());
        this.frP = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.frP.J(arguments);
        } else if (bundle != null) {
            this.frP.J(bundle);
        } else {
            this.frP.J(null);
        }
        this.eYR = getVoiceManager();
        this.eYR.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bvt);
        registerListener(this.fpC);
        registerListener(this.eZU);
        this.fpw = new FrsLoadMoreModel(this, null);
        this.fpw.registerListener();
        this.fpw.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_good_activity, (ViewGroup) null);
        this.frQ = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.erh) {
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
        this.eYR = getVoiceManager();
        this.eYR.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bhf();
        if (bundle != null) {
            this.eYK = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.eYK = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bhf() {
        registerListener(2001118, this.bZc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.frQ != null) {
            this.frQ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fbP);
        com.baidu.tieba.q.c.cdt().t(getUniqueId());
        t.aQF().hQ(false);
        super.onDestroy();
        this.frP.onActivityDestroy();
        this.eYR = getVoiceManager();
        this.eYR.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fpB);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.eYK);
        bundle.putString("from", this.mFrom);
        this.frP.onSaveInstanceState(bundle);
        this.eYR = getVoiceManager();
        if (this.eYR != null) {
            this.eYR.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bg threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.frQ.bhX().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.eYv.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.gu(intent.getIntExtra("good_data", 0));
                            threadDataById.ZH();
                            jJ(false);
                            return;
                        } else if (intExtra == 0) {
                            this.eYv.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.eYv.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.m());
                            }
                            this.frQ.bhj();
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
            if (this.fgm == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.erh) {
                com.baidu.adp.lib.g.e.jH().post(this.fpB);
            }
        }
        beB();
    }

    private void beB() {
        if (isPrimary()) {
            if (this.fdN != null && this.fdN.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fbP);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fbP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.frQ != null) {
            this.frQ.bdx();
        }
        this.eYR = getVoiceManager();
        this.eYR.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.frQ.setOnAdapterItemClickListener(this.fao);
        this.frQ.setOnScrollListener(this.mScrollListener);
        this.frQ.setListPullRefreshListener(this.dhq);
        this.frQ.a(this.bRH);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fgm != 3 || this.frQ != null) {
            this.fgm = i;
            super.onChangeSkinType(i);
            if (this.frQ != null) {
                this.frQ.onChangeSkinType(i);
            }
            if (this.fdN != null && this.fdN.isViewAttached()) {
                this.fdN.onChangeSkinType();
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
                        com.baidu.tieba.tbadkCore.util.a.CH(FrsNewAreaFragment.this.eYK);
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
            if (this.eYv != null) {
                this.frQ.aOA();
                this.eYK = this.eYv.getForum().getName();
                this.forumId = this.eYv.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.eYv.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.eYv.getUserData().getBimg_end_time());
                bcI();
                ArrayList<m> threadList = this.eYv.getThreadList();
                if (threadList != null) {
                    this.frQ.a(threadList, this.mPn, this.eYv, this.eYv.getPage().XK());
                    bhg();
                    this.frQ.bhj();
                    if (this.eYv.getIsNewUrl() == 1) {
                        this.frQ.bhX().setFromCDN(true);
                    } else {
                        this.frQ.bhX().setFromCDN(false);
                    }
                    this.frQ.setListViewSelection(bq(bhV().getType(), this.mPn));
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
        this.eYR = getVoiceManager();
        this.eYR.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.aQF().hQ(false);
        com.baidu.tieba.q.c.cdt().b(getUniqueId(), false);
        if (this.eYv != null && this.eYv.getForum() != null) {
            com.baidu.tbadk.distribute.a.alF().a(getPageContext().getPageActivity(), "frs", this.eYv.getForum().getId(), 0L);
        }
        this.eYR = getVoiceManager();
        if (this.eYR != null) {
            this.eYR.onStop(getPageContext());
        }
    }

    public void bfg() {
        if (this.frQ != null) {
            this.frQ.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX(int i) {
        ArrayList<m> threadList = this.eYv.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bf) {
                    bg bgVar = ((bf) next).threadData;
                    if (bgVar.getId() != null && bgVar.getId().equals(this.fpt)) {
                        c(bgVar, i);
                        this.fpt = null;
                        break;
                    }
                }
            }
            this.frQ.bhX().b(threadList, this.eYv);
            this.frQ.bhX().notifyDataSetChanged();
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
        if (this.eYR == null) {
            this.eYR = VoiceManager.instance();
        }
        return this.eYR;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView afc() {
        if (this.frQ == null) {
            return null;
        }
        return this.frQ.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bcM() {
        this.eYR = getVoiceManager();
        this.eYR.stopPlay();
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
        if (this.eYv != null && this.frQ != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.frQ.bdx();
            }
        }
    }

    private void bhg() {
        HashMap<Integer, bg> bfA;
        if (this.frQ != null && this.frQ.bhX() != null && (bfA = this.frQ.bhX().bfA()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bg> entry : bfA.entrySet()) {
                bg value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.alK().u(arrayList);
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
        return this.eYv;
    }

    public FrsNewAreaModelController bhV() {
        return this.frP;
    }

    public void vw(String str) {
        this.eYK = str;
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
        if (!this.fpw.isLoading && !this.frP.qz()) {
            if (this.fpw.cd(this.eYv.getThreadListIds())) {
                this.frQ.a(this.fpw.bhA(), this.mPn, this.eYv, 0);
                this.fpw.a(com.baidu.adp.lib.g.b.d(this.forumId, 0L), this.eYv.getThreadListIds(), this.eYK, this.mPn, this.eYv.isBrandForum);
            } else if (this.dSu != 0) {
                this.frQ.a(this.fpw.bhA(), this.mPn, this.eYv, 0);
                this.mPn++;
                this.frP.qZ(this.mPn);
                this.fpw.loadingDone = false;
                this.fpw.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.lo()) {
            this.frQ.aCw();
        } else if (!this.frQ.bdG()) {
            if (!this.frP.bhq()) {
                this.frQ.aCw();
                return;
            }
            aBq();
            aBc();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void uF(String str) {
        aBq();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void R(ArrayList<m> arrayList) {
        ArrayList<m> a;
        aBq();
        if (arrayList != null && arrayList.size() != 0 && (a = this.fpw.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.eYv.setThreadList(a);
            this.frQ.a(a, this.mPn, this.eYv, 0);
        }
    }

    public void ce(List<String> list) {
        bR(list);
        int i = 0;
        Iterator<m> it = this.eYv.getThreadList().iterator();
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
            ArrayList<m> threadList = this.eYv.getThreadList();
            if (!v.T(threadList) && this.frQ.getListView() != null && this.frQ.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.frQ.getListView().getData();
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
                                this.fpw.e(next);
                                this.frQ.getListView().getAdapter().notifyItemRemoved(i);
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
        if (this.dSu == 0 && !this.fpw.cd(this.eYv.getThreadListIds())) {
            if (this.eYv.getThreadList() == null || this.eYv.getThreadList().size() == 0) {
                this.frQ.aCw();
                return;
            } else {
                this.frQ.aCv();
                return;
            }
        }
        this.frQ.aCu();
    }

    public g bhW() {
        return this.frQ;
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
        com.baidu.tbadk.distribute.a.alF().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bcL() {
        if (this.frP != null) {
            this.frP.bcL();
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
        return this.eYK;
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcd() {
        if (this.frQ != null && this.frQ.getListView() != null) {
            this.frQ.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCt() {
        if (this.frQ != null) {
            bcd();
            this.frQ.startPullRefresh();
        }
    }
}
