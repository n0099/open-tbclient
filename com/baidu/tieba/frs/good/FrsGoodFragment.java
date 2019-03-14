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
    private VoiceManager eYR;
    private c fdN;
    private String fpt;
    private FrsGoodModelController fpv;
    private FrsLoadMoreModel fpw;
    private com.baidu.tieba.frs.gametab.b fpy;
    private String eYK = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean fpu = false;
    private String forumId = null;
    private FrsViewData eYv = new FrsViewData();
    public long eCL = -1;
    public long cqn = 0;
    public long cqv = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean eZd = false;
    protected a fpx = null;
    private int dSu = -1;
    private int mTabId = 0;
    private int fgm = 3;
    private boolean erh = false;
    public boolean fpz = false;
    private boolean fpA = false;
    private CustomMessageListener fbP = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.fdN != null && FrsGoodFragment.this.fdN.isViewAttached()) {
                FrsGoodFragment.this.fdN.jO(num.intValue());
            }
        }
    };
    private Runnable fpB = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        @Override // java.lang.Runnable
        public void run() {
            if (!j.kY() || FrsGoodFragment.this.erh) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.jJ(false);
            }
        }
    };
    private CustomMessageListener fpC = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                FrsGoodFragment.this.fpt = bgVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.fpt) && bgVar.YD() != null) {
                    FrsGoodFragment.this.qX(bgVar.YD().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener eZU = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.afc() != null) {
                            FrsGoodFragment.this.afc().setSelection(0);
                        }
                        if (FrsGoodFragment.this.fdN != null && FrsGoodFragment.this.fdN.isViewAttached()) {
                            FrsGoodFragment.this.jJ(false);
                        } else if (FrsGoodFragment.this.fpx != null) {
                            FrsGoodFragment.this.fpx.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n fai = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        private long fpF = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void pX(int i) {
            if (!FrsGoodFragment.this.fpA) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.fpx.bdx();
                        return;
                    case 3:
                        FrsGoodFragment.this.fpx.fB(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.fpA) {
                if (FrsGoodFragment.this.bhh().bho() == null) {
                    FrsGoodFragment.this.fpA = false;
                    return;
                } else if (FrsGoodFragment.this.bhh().bho().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.fpA = false;
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
                FrsGoodFragment.this.fpw.resetData();
            }
            FrsGoodFragment.this.fpx.fB(false);
            if (FrsGoodFragment.this.bhh().bho() != null) {
                FrsGoodFragment.this.eYv = FrsGoodFragment.this.bhh().bho();
            }
            FrsGoodFragment.this.dSu = FrsGoodFragment.this.eYv.getPage().XK();
            if (FrsGoodFragment.this.dSu == 0 && (FrsGoodFragment.this.eYv.getThreadListIds() == null || FrsGoodFragment.this.eYv.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.eYv.getThreadList() == null || FrsGoodFragment.this.eYv.getThreadList().size() == 0) {
                    FrsGoodFragment.this.fpx.aCw();
                } else {
                    FrsGoodFragment.this.fpx.aCv();
                }
            } else {
                FrsGoodFragment.this.fpx.aCu();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.fpw.a(false, false, false, FrsGoodFragment.this.eYv.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.eYv.setThreadList(a2);
                    FrsGoodFragment.this.fpx.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.eYv, FrsGoodFragment.this.dSu);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.fpx.bdx();
                    break;
                case 2:
                    FrsGoodFragment.this.fpx.bdx();
                    break;
                case 3:
                    if (FrsGoodFragment.this.eYv.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.fpF != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.eYv != null) {
                    FrsGoodFragment.this.eYK = FrsGoodFragment.this.eYv.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.eYv.getForum().getId();
                    FrsGoodFragment.this.fpx.b(FrsGoodFragment.this.eYv.getForum(), FrsGoodFragment.this.eYv.getUserData());
                }
                if (FrsGoodFragment.this.eYv != null) {
                    FrsGoodFragment.this.eYv.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.fpx.c(FrsGoodFragment.this.eYv);
                if (FrsGoodFragment.this.eYv == null || FrsGoodFragment.this.eYv.getThreadList() == null || FrsGoodFragment.this.eYv.getThreadList().size() != 0 || FrsGoodFragment.this.bhh().getType() != 4) {
                    if (FrsGoodFragment.this.eYv != null && (a = FrsGoodFragment.this.fpw.a(false, false, true, FrsGoodFragment.this.eYv.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.eYv.setThreadList(a);
                    }
                    FrsGoodFragment.this.bcJ();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(d.j.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.eCL > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.eCL, FrsGoodFragment.this.bhh().aWU() - FrsGoodFragment.this.eCL, FrsGoodFragment.this.bhh().aWS(), FrsGoodFragment.this.bhh().aWT(), currentTimeMillis2 - FrsGoodFragment.this.bhh().aWR());
                        FrsGoodFragment.this.eCL = -1L;
                    }
                    FrsGoodFragment.this.cqv = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.eCL > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.eCL, FrsGoodFragment.this.bhh().aWU() - FrsGoodFragment.this.eCL, FrsGoodFragment.this.bhh().aWS(), FrsGoodFragment.this.bhh().aWT(), currentTimeMillis3 - FrsGoodFragment.this.bhh().aWR());
                FrsGoodFragment.this.eCL = -1L;
            }
            FrsGoodFragment.this.cqv = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
        }
    };
    private final CustomMessageListener bvt = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.fpx != null) {
                FrsGoodFragment.this.fpx.startPullRefresh();
            }
        }
    };
    private final h.c dhq = new h.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.kY()) {
                com.baidu.tieba.a.d.awk().qK("page_frs_good");
                FrsGoodFragment.this.jJ(true);
                return;
            }
            FrsGoodFragment.this.fpx.fB(false);
        }
    };
    private final h.b bRH = new h.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.cdt().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.eZd) {
                FrsGoodFragment.this.eZd = true;
                FrsGoodFragment.this.fpx.bdN();
            }
            if (i == 0) {
                t.aQF().hQ(true);
                com.baidu.tieba.q.c.cdt().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener bZc = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
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
    private s fao = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bf)) {
                bg bgVar = ((bf) mVar).threadData;
                if (bgVar.ZJ() == null || bgVar.ZJ().getGroup_id() == 0 || bc.cZ(FrsGoodFragment.this.getActivity())) {
                    if (bgVar.ZB() != 1 || bc.cZ(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.CN(bgVar.getId())) {
                            readThreadHistory.CM(bgVar.getId());
                            if (FrsGoodFragment.this.fpx != null) {
                                FrsGoodFragment.this.fpx.bdx();
                            }
                        }
                        boolean z = false;
                        final String YY = bgVar.YY();
                        if (YY != null && !YY.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6.1
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
                            ba.adD().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bgVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bgVar, FrsGoodFragment.this.eYK, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.fpz ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsGoodFragment.this.eYv != null && FrsGoodFragment.this.eYv.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fta = FrsGoodFragment.this.eYv.needLog == 1;
                            bVar.ftc = FrsGoodFragment.this.eYv.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.fhe != null) {
                                bVar.ftd = com.baidu.tieba.frs.d.d.fhe.ftd;
                                bVar.fte = com.baidu.tieba.frs.d.d.fhe.fte;
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
        this.fpx.jv(false);
        showLoadingView(this.fpx.bdL(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fpx.jv(true);
        hideLoadingView(this.fpx.bdL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fpx.jv(false);
        this.fpx.beK().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fpx.aCw();
        this.fpx.getListView().getData().clear();
        this.fpx.bdx();
        if (this.fdN == null) {
            this.fdN = new c(getPageContext().getContext(), getNetRefreshListener());
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
        this.fdN.attachView(this.fpx.bdL(), true);
        registerListener(this.fbP);
    }

    private void aBt() {
        this.fpx.jv(true);
        this.fpx.beK().setEnabled(true);
        if (this.fdN != null && this.fdN.isViewAttached()) {
            this.fdN.dettachView(this.fpx.bdL());
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
        this.fpv.mf(this.mTabId);
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
        this.fpv = new FrsGoodModelController(this);
        if (arguments != null) {
            this.fpv.J(arguments);
            this.fpu = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.fpv.J(bundle);
            this.fpu = bundle.getBoolean("is_game_frs", false);
        } else {
            this.fpv.J(null);
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
        this.fpx = new a(this, inflate, this.fpu);
        this.fpx.bhl().jL(this.fpz);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.erh) {
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
        this.eYR = getVoiceManager();
        this.eYR.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bhf();
        if (bundle != null) {
            this.eYK = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fpz = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.eYK = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.fpz = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
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
        if (this.fpx != null) {
            this.fpx.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fbP);
        com.baidu.tieba.q.c.cdt().t(getUniqueId());
        t.aQF().hQ(false);
        super.onDestroy();
        this.fpv.onActivityDestroy();
        this.eYR = getVoiceManager();
        this.eYR.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fpB);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.eYK);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.fpu);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fpz);
        this.fpv.onSaveInstanceState(bundle);
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
                    this.fpx.bhl().notifyDataSetChanged();
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
                            this.fpx.bhj();
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
        if (this.fpx != null) {
            this.fpx.bdx();
        }
        this.eYR = getVoiceManager();
        this.eYR.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fpy = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.fpx.setOnAdapterItemClickListener(this.fao);
        this.fpx.setOnScrollListener(this.mScrollListener);
        this.fpx.setListPullRefreshListener(this.dhq);
        this.fpx.a(this.bRH);
        this.fpx.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.fpy != null) {
                    FrsGoodFragment.this.fpy.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fgm != 3 || this.fpx != null) {
            this.fgm = i;
            super.onChangeSkinType(i);
            if (this.fpx != null) {
                this.fpx.onChangeSkinType(i);
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
                com.baidu.adp.lib.g.h.jI().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.CH(FrsGoodFragment.this.eYK);
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
                this.fpx.aOA();
                this.eYK = this.eYv.getForum().getName();
                this.forumId = this.eYv.getForum().getId();
                if (this.eYv != null && this.eYv.getForum() != null) {
                    this.fpx.a(this.eYv.getForum().getThemeColorInfo());
                    this.fpx.c(this.eYv);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.eYv.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.eYv.getUserData().getBimg_end_time());
                bcI();
                if (!this.fpx.bhl().l(bg.bBe)) {
                    this.eYv.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.eYv.getThreadList();
                if (threadList != null) {
                    this.fpx.a(threadList, this.mPn, this.eYv, this.eYv.getPage().XK());
                    bhg();
                    this.fpx.bhj();
                    if (this.eYv.getIsNewUrl() == 1) {
                        this.fpx.bhl().setFromCDN(true);
                    } else {
                        this.fpx.bhl().setFromCDN(false);
                    }
                    this.fpx.setListViewSelection(bq(bhh().getType(), this.mPn));
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
            this.fpx.bhl().b(threadList, this.eYv);
            this.fpx.bhl().notifyDataSetChanged();
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
        if (this.fpx == null) {
            return null;
        }
        return this.fpx.getListView();
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
        if (this.eYv != null && this.fpx != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fpx.bdx();
            }
        }
    }

    private void bhg() {
        HashMap<Integer, bg> bfA;
        if (this.fpx != null && this.fpx.bhl() != null && (bfA = this.fpx.bhl().bfA()) != null) {
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
        if (j.kY()) {
            jJ(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bcR() {
        return this.eYv;
    }

    public FrsGoodModelController bhh() {
        return this.fpv;
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

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!l.lo()) {
            this.fpx.aCw();
        } else if (!this.fpv.bhq()) {
            this.fpx.aCw();
        } else {
            aBq();
            if (!this.fpw.isLoading && !this.fpv.qz()) {
                if (this.fpw.cd(this.eYv.getThreadListIds())) {
                    this.fpx.a(this.fpw.bhA(), this.mPn, this.eYv, 0);
                    this.fpw.a(com.baidu.adp.lib.g.b.d(this.forumId, 0L), this.eYv.getThreadListIds(), this.eYK, this.mPn, this.eYv.isBrandForum);
                } else if (this.dSu != 0) {
                    this.fpx.a(this.fpw.bhA(), this.mPn, this.eYv, 0);
                    this.mPn++;
                    this.fpv.qZ(this.mPn);
                    this.fpw.loadingDone = false;
                    this.fpw.loadIndex = 0;
                }
            }
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.fpw.a(false, false, false, arrayList, (f) null)) != null) {
            this.eYv.setThreadList(a);
            this.fpx.a(a, this.mPn, this.eYv, 0);
        }
    }

    private void aBq() {
        if (this.dSu == 0 && !this.fpw.cd(this.eYv.getThreadListIds())) {
            if (this.eYv.getThreadList() == null || this.eYv.getThreadList().size() == 0) {
                this.fpx.aCw();
                return;
            } else {
                this.fpx.aCv();
                return;
            }
        }
        this.fpx.aCu();
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
        if (this.fpv != null) {
            this.fpv.bcL();
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void qY(int i) {
        this.mTabId = i;
        if (j.kY()) {
            jJ(false);
        } else {
            c((e.b) null);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcd() {
        if (this.fpx != null && this.fpx.getListView() != null) {
            this.fpx.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCt() {
        if (this.fpx != null) {
            bcd();
            this.fpx.startPullRefresh();
        }
    }
}
