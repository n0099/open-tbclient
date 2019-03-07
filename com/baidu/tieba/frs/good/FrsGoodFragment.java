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
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0040a, UserIconBox.b, VoiceManager.c, ag, ah, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private VoiceManager eYS;
    private c fdO;
    private String fpu;
    private FrsGoodModelController fpw;
    private FrsLoadMoreModel fpx;
    private com.baidu.tieba.frs.gametab.b fpz;
    private String eYL = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean fpv = false;
    private String forumId = null;
    private FrsViewData eYw = new FrsViewData();
    public long eCP = -1;
    public long cqn = 0;
    public long cqv = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean eZe = false;
    protected a fpy = null;
    private int dSy = -1;
    private int mTabId = 0;
    private int fgn = 3;
    private boolean erl = false;
    public boolean fpA = false;
    private boolean fpB = false;
    private CustomMessageListener fbQ = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.fdO != null && FrsGoodFragment.this.fdO.isViewAttached()) {
                FrsGoodFragment.this.fdO.jO(num.intValue());
            }
        }
    };
    private Runnable fpC = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        @Override // java.lang.Runnable
        public void run() {
            if (!j.kY() || FrsGoodFragment.this.erl) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.jJ(false);
            }
        }
    };
    private CustomMessageListener fpD = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                FrsGoodFragment.this.fpu = bgVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.fpu) && bgVar.YD() != null) {
                    FrsGoodFragment.this.qX(bgVar.YD().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener eZV = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
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
                        if (FrsGoodFragment.this.fdO != null && FrsGoodFragment.this.fdO.isViewAttached()) {
                            FrsGoodFragment.this.jJ(false);
                        } else if (FrsGoodFragment.this.fpy != null) {
                            FrsGoodFragment.this.fpy.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n faj = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        private long fpG = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void pX(int i) {
            if (!FrsGoodFragment.this.fpB) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.fpy.bdx();
                        return;
                    case 3:
                        FrsGoodFragment.this.fpy.fB(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.fpB) {
                if (FrsGoodFragment.this.bhh().bho() == null) {
                    FrsGoodFragment.this.fpB = false;
                    return;
                } else if (FrsGoodFragment.this.bhh().bho().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.fpB = false;
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
                FrsGoodFragment.this.fpx.resetData();
            }
            FrsGoodFragment.this.fpy.fB(false);
            if (FrsGoodFragment.this.bhh().bho() != null) {
                FrsGoodFragment.this.eYw = FrsGoodFragment.this.bhh().bho();
            }
            FrsGoodFragment.this.dSy = FrsGoodFragment.this.eYw.getPage().XK();
            if (FrsGoodFragment.this.dSy == 0 && (FrsGoodFragment.this.eYw.getThreadListIds() == null || FrsGoodFragment.this.eYw.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.eYw.getThreadList() == null || FrsGoodFragment.this.eYw.getThreadList().size() == 0) {
                    FrsGoodFragment.this.fpy.aCw();
                } else {
                    FrsGoodFragment.this.fpy.aCv();
                }
            } else {
                FrsGoodFragment.this.fpy.aCu();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.fpx.a(false, false, false, FrsGoodFragment.this.eYw.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.eYw.setThreadList(a2);
                    FrsGoodFragment.this.fpy.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.eYw, FrsGoodFragment.this.dSy);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.fpy.bdx();
                    break;
                case 2:
                    FrsGoodFragment.this.fpy.bdx();
                    break;
                case 3:
                    if (FrsGoodFragment.this.eYw.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.fpG != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.eYw != null) {
                    FrsGoodFragment.this.eYL = FrsGoodFragment.this.eYw.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.eYw.getForum().getId();
                    FrsGoodFragment.this.fpy.b(FrsGoodFragment.this.eYw.getForum(), FrsGoodFragment.this.eYw.getUserData());
                }
                if (FrsGoodFragment.this.eYw != null) {
                    FrsGoodFragment.this.eYw.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.fpy.c(FrsGoodFragment.this.eYw);
                if (FrsGoodFragment.this.eYw == null || FrsGoodFragment.this.eYw.getThreadList() == null || FrsGoodFragment.this.eYw.getThreadList().size() != 0 || FrsGoodFragment.this.bhh().getType() != 4) {
                    if (FrsGoodFragment.this.eYw != null && (a = FrsGoodFragment.this.fpx.a(false, false, true, FrsGoodFragment.this.eYw.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.eYw.setThreadList(a);
                    }
                    FrsGoodFragment.this.bcJ();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(d.j.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.eCP > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.eCP, FrsGoodFragment.this.bhh().aWU() - FrsGoodFragment.this.eCP, FrsGoodFragment.this.bhh().aWS(), FrsGoodFragment.this.bhh().aWT(), currentTimeMillis2 - FrsGoodFragment.this.bhh().aWR());
                        FrsGoodFragment.this.eCP = -1L;
                    }
                    FrsGoodFragment.this.cqv = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.eCP > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.eCP, FrsGoodFragment.this.bhh().aWU() - FrsGoodFragment.this.eCP, FrsGoodFragment.this.bhh().aWS(), FrsGoodFragment.this.bhh().aWT(), currentTimeMillis3 - FrsGoodFragment.this.bhh().aWR());
                FrsGoodFragment.this.eCP = -1L;
            }
            FrsGoodFragment.this.cqv = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
        }
    };
    private final CustomMessageListener bvr = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.fpy != null) {
                FrsGoodFragment.this.fpy.startPullRefresh();
            }
        }
    };
    private final h.c dhu = new h.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.kY()) {
                com.baidu.tieba.a.d.awk().qL("page_frs_good");
                FrsGoodFragment.this.jJ(true);
                return;
            }
            FrsGoodFragment.this.fpy.fB(false);
        }
    };
    private final h.b bRG = new h.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.cdq().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.eZe) {
                FrsGoodFragment.this.eZe = true;
                FrsGoodFragment.this.fpy.bdN();
            }
            if (i == 0) {
                t.aQF().hQ(true);
                com.baidu.tieba.q.c.cdq().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener bZb = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
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
    private s fap = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bf)) {
                bg bgVar = ((bf) mVar).threadData;
                if (bgVar.ZJ() == null || bgVar.ZJ().getGroup_id() == 0 || bc.cZ(FrsGoodFragment.this.getActivity())) {
                    if (bgVar.ZB() != 1 || bc.cZ(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.CO(bgVar.getId())) {
                            readThreadHistory.CN(bgVar.getId());
                            if (FrsGoodFragment.this.fpy != null) {
                                FrsGoodFragment.this.fpy.bdx();
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
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bgVar, FrsGoodFragment.this.eYL, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.fpA ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsGoodFragment.this.eYw != null && FrsGoodFragment.this.eYw.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.ftb = FrsGoodFragment.this.eYw.needLog == 1;
                            bVar.ftd = FrsGoodFragment.this.eYw.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.fhf != null) {
                                bVar.fte = com.baidu.tieba.frs.d.d.fhf.fte;
                                bVar.ftf = com.baidu.tieba.frs.d.d.fhf.ftf;
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
        this.fpy.jv(false);
        showLoadingView(this.fpy.bdL(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fpy.jv(true);
        hideLoadingView(this.fpy.bdL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fpy.jv(false);
        this.fpy.beK().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fpy.aCw();
        this.fpy.getListView().getData().clear();
        this.fpy.bdx();
        if (this.fdO == null) {
            this.fdO = new c(getPageContext().getContext(), getNetRefreshListener());
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
        this.fdO.attachView(this.fpy.bdL(), true);
        registerListener(this.fbQ);
    }

    private void aBt() {
        this.fpy.jv(true);
        this.fpy.beK().setEnabled(true);
        if (this.fdO != null && this.fdO.isViewAttached()) {
            this.fdO.dettachView(this.fpy.bdL());
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
        this.fpw.mf(this.mTabId);
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
        this.fpw = new FrsGoodModelController(this);
        if (arguments != null) {
            this.fpw.J(arguments);
            this.fpv = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.fpw.J(bundle);
            this.fpv = bundle.getBoolean("is_game_frs", false);
        } else {
            this.fpw.J(null);
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
        this.fpy = new a(this, inflate, this.fpv);
        this.fpy.bhl().jL(this.fpA);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.erl) {
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
        this.eYS = getVoiceManager();
        this.eYS.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bhf();
        if (bundle != null) {
            this.eYL = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fpA = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.eYL = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.fpA = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
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
        if (this.fpy != null) {
            this.fpy.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fbQ);
        com.baidu.tieba.q.c.cdq().t(getUniqueId());
        t.aQF().hQ(false);
        super.onDestroy();
        this.fpw.onActivityDestroy();
        this.eYS = getVoiceManager();
        this.eYS.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fpC);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.eYL);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.fpv);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fpA);
        this.fpw.onSaveInstanceState(bundle);
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
                    this.fpy.bhl().notifyDataSetChanged();
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
                            this.fpy.bhj();
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
        if (this.fpy != null) {
            this.fpy.bdx();
        }
        this.eYS = getVoiceManager();
        this.eYS.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fpz = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.fpy.setOnAdapterItemClickListener(this.fap);
        this.fpy.setOnScrollListener(this.mScrollListener);
        this.fpy.setListPullRefreshListener(this.dhu);
        this.fpy.a(this.bRG);
        this.fpy.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.fpz != null) {
                    FrsGoodFragment.this.fpz.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fgn != 3 || this.fpy != null) {
            this.fgn = i;
            super.onChangeSkinType(i);
            if (this.fpy != null) {
                this.fpy.onChangeSkinType(i);
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
                com.baidu.adp.lib.g.h.jI().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.CI(FrsGoodFragment.this.eYL);
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
                this.fpy.aOA();
                this.eYL = this.eYw.getForum().getName();
                this.forumId = this.eYw.getForum().getId();
                if (this.eYw != null && this.eYw.getForum() != null) {
                    this.fpy.a(this.eYw.getForum().getThemeColorInfo());
                    this.fpy.c(this.eYw);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.eYw.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.eYw.getUserData().getBimg_end_time());
                bcI();
                if (!this.fpy.bhl().l(bg.bBc)) {
                    this.eYw.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.eYw.getThreadList();
                if (threadList != null) {
                    this.fpy.a(threadList, this.mPn, this.eYw, this.eYw.getPage().XK());
                    bhg();
                    this.fpy.bhj();
                    if (this.eYw.getIsNewUrl() == 1) {
                        this.fpy.bhl().setFromCDN(true);
                    } else {
                        this.fpy.bhl().setFromCDN(false);
                    }
                    this.fpy.setListViewSelection(bq(bhh().getType(), this.mPn));
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
            this.fpy.bhl().b(threadList, this.eYw);
            this.fpy.bhl().notifyDataSetChanged();
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
        if (this.fpy == null) {
            return null;
        }
        return this.fpy.getListView();
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
        if (this.eYw != null && this.fpy != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fpy.bdx();
            }
        }
    }

    private void bhg() {
        HashMap<Integer, bg> bfA;
        if (this.fpy != null && this.fpy.bhl() != null && (bfA = this.fpy.bhl().bfA()) != null) {
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
        if (j.kY()) {
            jJ(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bcR() {
        return this.eYw;
    }

    public FrsGoodModelController bhh() {
        return this.fpw;
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

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!l.lo()) {
            this.fpy.aCw();
        } else if (!this.fpw.bhq()) {
            this.fpy.aCw();
        } else {
            aBq();
            if (!this.fpx.isLoading && !this.fpw.qz()) {
                if (this.fpx.cd(this.eYw.getThreadListIds())) {
                    this.fpy.a(this.fpx.bhA(), this.mPn, this.eYw, 0);
                    this.fpx.a(com.baidu.adp.lib.g.b.d(this.forumId, 0L), this.eYw.getThreadListIds(), this.eYL, this.mPn, this.eYw.isBrandForum);
                } else if (this.dSy != 0) {
                    this.fpy.a(this.fpx.bhA(), this.mPn, this.eYw, 0);
                    this.mPn++;
                    this.fpw.qZ(this.mPn);
                    this.fpx.loadingDone = false;
                    this.fpx.loadIndex = 0;
                }
            }
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.fpx.a(false, false, false, arrayList, (f) null)) != null) {
            this.eYw.setThreadList(a);
            this.fpy.a(a, this.mPn, this.eYw, 0);
        }
    }

    private void aBq() {
        if (this.dSy == 0 && !this.fpx.cd(this.eYw.getThreadListIds())) {
            if (this.eYw.getThreadList() == null || this.eYw.getThreadList().size() == 0) {
                this.fpy.aCw();
                return;
            } else {
                this.fpy.aCv();
                return;
            }
        }
        this.fpy.aCu();
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
        if (this.fpw != null) {
            this.fpw.bcL();
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
        if (this.fpy != null && this.fpy.getListView() != null) {
            this.fpy.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCt() {
        if (this.fpy != null) {
            bcd();
            this.fpy.startPullRefresh();
        }
    }
}
