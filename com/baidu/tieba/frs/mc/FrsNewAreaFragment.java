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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ag, ah, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String fKA;
    private FrsLoadMoreModel fKD;
    private FrsNewAreaModelController fMW;
    private VoiceManager ftO;
    private com.baidu.tbadk.m.c fyL;
    private String ftH = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData fts = new FrsViewData();
    public long eXm = -1;
    public long czN = 0;
    public long czV = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fua = false;
    protected g fMX = null;
    private int egI = -1;
    private int fBj = 3;
    private boolean eLy = false;
    public boolean fKG = false;
    private boolean fKH = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fun = new SparseArray<>();
    private CustomMessageListener fwP = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.fyL != null && FrsNewAreaFragment.this.fyL.isViewAttached()) {
                FrsNewAreaFragment.this.fyL.kH(num.intValue());
            }
        }
    };
    private Runnable fKI = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.kc() || FrsNewAreaFragment.this.eLy) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.kF(false);
            }
        }
    };
    private CustomMessageListener fKJ = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                FrsNewAreaFragment.this.fKA = bgVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.fKA) && bgVar.aej() != null) {
                    FrsNewAreaFragment.this.st(bgVar.aej().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fuT = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.ald() != null) {
                        FrsNewAreaFragment.this.ald().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.fyL != null && FrsNewAreaFragment.this.fyL.isViewAttached()) {
                        FrsNewAreaFragment.this.kF(false);
                    } else if (FrsNewAreaFragment.this.fMX != null) {
                        FrsNewAreaFragment.this.fMX.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n fvi = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long fKM = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void rs(int i) {
            if (!FrsNewAreaFragment.this.fKH) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.fMX.bmS();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.fMX.gc(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.fKH) {
                if (FrsNewAreaFragment.this.brs().bqK() == null) {
                    FrsNewAreaFragment.this.fKH = false;
                    return;
                } else if (FrsNewAreaFragment.this.brs().bqK().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.fKH = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.fKM = 1L;
            } else if (bVar.isSuccess) {
                this.fKM = 0L;
            } else {
                this.fKM = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.fKD.resetData();
            }
            FrsNewAreaFragment.this.fMX.gc(false);
            if (FrsNewAreaFragment.this.brs().bqK() != null) {
                FrsNewAreaFragment.this.fts = FrsNewAreaFragment.this.brs().bqK();
            }
            FrsNewAreaFragment.this.egI = FrsNewAreaFragment.this.fts.getPage().adr();
            if (FrsNewAreaFragment.this.egI == 0 && (FrsNewAreaFragment.this.fts.getThreadListIds() == null || FrsNewAreaFragment.this.fts.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.fts.getThreadList() == null || FrsNewAreaFragment.this.fts.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.fMX.aKk();
                } else {
                    FrsNewAreaFragment.this.fMX.aKj();
                }
            } else {
                FrsNewAreaFragment.this.fMX.aKi();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.fKD.a(false, false, false, FrsNewAreaFragment.this.fts.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.fts.setThreadList(a2);
                    FrsNewAreaFragment.this.fMX.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.fts, FrsNewAreaFragment.this.egI);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.fMX.bmS();
                    break;
                case 2:
                    FrsNewAreaFragment.this.fMX.bmS();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.fts.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.fKM != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.fts != null) {
                    FrsNewAreaFragment.this.ftH = FrsNewAreaFragment.this.fts.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.fts.getForum().getId();
                    FrsNewAreaFragment.this.fMX.b(FrsNewAreaFragment.this.fts.getForum(), FrsNewAreaFragment.this.fts.getUserData());
                }
                if (FrsNewAreaFragment.this.fts != null) {
                    FrsNewAreaFragment.this.fts.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.fts == null || FrsNewAreaFragment.this.fts.getThreadList() == null || FrsNewAreaFragment.this.fts.getThreadList().size() != 0 || FrsNewAreaFragment.this.brs().getType() != 4) {
                    if (FrsNewAreaFragment.this.fts != null && (a = FrsNewAreaFragment.this.fKD.a(false, false, true, FrsNewAreaFragment.this.fts.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.fts.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bmg();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.eXm > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsNewAreaFragment.this.eXm, FrsNewAreaFragment.this.brs().bgm() - FrsNewAreaFragment.this.eXm, FrsNewAreaFragment.this.brs().bgk(), FrsNewAreaFragment.this.brs().bgl(), currentTimeMillis2 - FrsNewAreaFragment.this.brs().bgj());
                        FrsNewAreaFragment.this.eXm = -1L;
                    }
                    FrsNewAreaFragment.this.czV = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.eXm > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsNewAreaFragment.this.eXm, FrsNewAreaFragment.this.brs().bgm() - FrsNewAreaFragment.this.eXm, FrsNewAreaFragment.this.brs().bgk(), FrsNewAreaFragment.this.brs().bgl(), currentTimeMillis3 - FrsNewAreaFragment.this.brs().bgj());
                FrsNewAreaFragment.this.eXm = -1L;
            }
            FrsNewAreaFragment.this.czV = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
        }
    };
    private final CustomMessageListener bDy = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.fMX != null) {
                FrsNewAreaFragment.this.fMX.startPullRefresh();
            }
        }
    };
    private final h.c duh = new h.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.kc()) {
                com.baidu.tieba.a.d.aCF().sl("page_frs_good");
                FrsNewAreaFragment.this.kF(true);
                return;
            }
            FrsNewAreaFragment.this.fMX.gc(false);
        }
    };
    private final h.b caE = new h.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.coo().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.fua) {
                FrsNewAreaFragment.this.fua = true;
                FrsNewAreaFragment.this.fMX.bng();
            }
            if (i == 0) {
                t.aZN().iE(true);
                com.baidu.tieba.q.c.coo().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener cij = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
    private s fvo = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bf)) {
                bg bgVar = ((bf) mVar).threadData;
                if (bgVar.afp() == null || bgVar.afp().getGroup_id() == 0 || bd.cF(FrsNewAreaFragment.this.getActivity())) {
                    if (bgVar.afh() != 1 || bd.cF(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.EX(bgVar.getId())) {
                            readThreadHistory.EW(bgVar.getId());
                            if (FrsNewAreaFragment.this.fMX != null) {
                                FrsNewAreaFragment.this.fMX.bmS();
                            }
                        }
                        boolean z = false;
                        final String aeE = bgVar.aeE();
                        if (aeE != null && !aeE.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aeE);
                                    xVar.aiE().ajE().mIsNeedAddCommenParam = false;
                                    xVar.aiE().ajE().mIsUseCurrentBDUSS = false;
                                    xVar.aih();
                                }
                            }).start();
                        }
                        String tid = bgVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bgVar.aes() == 2 && !tid.startsWith("pb:")) {
                            bb.ajC().c(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bgVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bgVar, FrsNewAreaFragment.this.ftH, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsNewAreaFragment.this.fKG ? 15 : 3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.fts != null && FrsNewAreaFragment.this.fts.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fOD = FrsNewAreaFragment.this.fts.needLog == 1;
                            bVar.fOF = FrsNewAreaFragment.this.fts.getForum().getId();
                            bVar.fOE = FrsNewAreaFragment.this.fMW.brm();
                            if (com.baidu.tieba.frs.d.d.fCh != null) {
                                bVar.fOG = com.baidu.tieba.frs.d.d.fCh.fOG;
                                bVar.fOH = com.baidu.tieba.frs.d.d.fCh.fOH;
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
            this.fMW.ac(bgVar);
            this.fMX.blA();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.fts = frsViewData;
            hideLoadingView(this.fMX.aXy());
            if (this.fMX != null) {
                this.fMX.gc(false);
                this.fMX.a(null, this.mPn, this.fts, this.egI);
            }
        }
    }

    private void showLoadingView() {
        this.fMX.kp(false);
        showLoadingView(this.fMX.aXy(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fMX.kp(true);
        hideLoadingView(this.fMX.aXy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fMX.kp(false);
        this.fMX.boe().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fMX.aKk();
        this.fMX.getListView().getData().clear();
        this.fMX.bmS();
        if (this.fyL == null) {
            this.fyL = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fyL.setTitle(null);
            this.fyL.setButtonText(null);
            this.fyL.atI();
            this.fyL.atJ().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.fyL.qN(getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.fyL.qN(null);
        }
        this.fyL.onChangeSkinType();
        this.fyL.attachView(this.fMX.aXy(), true);
        registerListener(this.fwP);
    }

    private void aJh() {
        this.fMX.kp(true);
        this.fMX.boe().setEnabled(true);
        if (this.fyL != null && this.fyL.isViewAttached()) {
            this.fyL.dettachView(this.fMX.aXy());
        }
        MessageManager.getInstance().unRegisterListener(this.fwP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kF(boolean z) {
        this.eLy = true;
        bmj();
        aJh();
        if (!z) {
            aJh();
            showLoadingView();
        }
        this.fMW.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eXm = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eXm = System.currentTimeMillis();
        }
        this.forumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.czN = this.beginTime - this.eXm;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.coo().u(getUniqueId());
        this.fMW = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.fMW.K(arguments);
        } else if (bundle != null) {
            this.fMW.K(bundle);
        } else {
            this.fMW.K(null);
        }
        this.ftO = getVoiceManager();
        this.ftO.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bDy);
        registerListener(this.fKJ);
        registerListener(this.fuT);
        this.fKD = new FrsLoadMoreModel(this, null);
        this.fKD.registerListener();
        this.fKD.setPageType(3);
        this.fKD.kI(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fMX = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eLy) {
            if (com.baidu.adp.lib.util.j.kc()) {
                kF(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        aji();
    }

    private void aji() {
        an anVar = new an("c13008");
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bT("fid", this.forumId);
        anVar.P("obj_type", 6);
        anVar.P("obj_locate", 2);
        anVar.aji();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.ftO = getVoiceManager();
        this.ftO.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bqA();
        if (bundle != null) {
            this.ftH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.ftH = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bqA() {
        registerListener(2001118, this.cij);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fMX != null) {
            this.fMX.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fwP);
        com.baidu.tieba.q.c.coo().v(getUniqueId());
        t.aZN().iE(false);
        super.onDestroy();
        this.fMW.aFO();
        this.ftO = getVoiceManager();
        this.ftO.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fKI);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.ftH);
        bundle.putString("from", this.mFrom);
        this.fMW.onSaveInstanceState(bundle);
        this.ftO = getVoiceManager();
        if (this.ftO != null) {
            this.ftO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bg threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.fMX.bru().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.fts.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.hl(intent.getIntExtra("good_data", 0));
                            threadDataById.afn();
                            kF(false);
                            return;
                        } else if (intExtra == 0) {
                            this.fts.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.fts.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.m());
                            }
                            this.fMX.bqF();
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
            if (this.fBj == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.eLy) {
                com.baidu.adp.lib.g.e.iK().post(this.fKI);
            }
        }
        bnV();
    }

    private void bnV() {
        if (isPrimary()) {
            if (this.fyL != null && this.fyL.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fwP);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fwP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fMX != null) {
            this.fMX.bmS();
        }
        this.ftO = getVoiceManager();
        this.ftO.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fMX.setOnAdapterItemClickListener(this.fvo);
        this.fMX.setOnScrollListener(this.mScrollListener);
        this.fMX.setListPullRefreshListener(this.duh);
        this.fMX.a(this.caE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fBj != 3 || this.fMX != null) {
            this.fBj = i;
            super.onChangeSkinType(i);
            if (this.fMX != null) {
                this.fMX.onChangeSkinType(i);
            }
            if (this.fyL != null && this.fyL.isViewAttached()) {
                this.fyL.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> blm() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).blm();
        }
        return null;
    }

    private void bmf() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.iL().d(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.ER(FrsNewAreaFragment.this.ftH);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmg() {
        bmj();
        try {
            if (this.fts != null) {
                this.fMX.aVP();
                this.ftH = this.fts.getForum().getName();
                this.forumId = this.fts.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.fts.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fts.getUserData().getBimg_end_time());
                bmf();
                ArrayList<m> threadList = this.fts.getThreadList();
                if (threadList != null) {
                    this.fMX.a(threadList, this.mPn, this.fts, this.fts.getPage().adr());
                    bqC();
                    this.fMX.bqF();
                    if (this.fts.getIsNewUrl() == 1) {
                        this.fMX.bru().setFromCDN(true);
                    } else {
                        this.fMX.bru().setFromCDN(false);
                    }
                    this.fMX.setListViewSelection(bC(brs().getType(), this.mPn));
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
        this.ftO = getVoiceManager();
        this.ftO.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.aZN().iE(false);
        com.baidu.tieba.q.c.coo().b(getUniqueId(), false);
        if (this.fts != null && this.fts.getForum() != null) {
            com.baidu.tbadk.distribute.a.arL().a(getPageContext().getPageActivity(), "frs", this.fts.getForum().getId(), 0L);
        }
        this.ftO = getVoiceManager();
        if (this.ftO != null) {
            this.ftO.onStop(getPageContext());
        }
    }

    public void boz() {
        if (this.fMX != null) {
            this.fMX.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void st(int i) {
        ArrayList<m> threadList = this.fts.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bf) {
                    bg bgVar = ((bf) next).threadData;
                    if (bgVar.getId() != null && bgVar.getId().equals(this.fKA)) {
                        c(bgVar, i);
                        this.fKA = null;
                        break;
                    }
                }
            }
            this.fMX.bru().b(threadList, this.fts);
            this.fMX.bru().notifyDataSetChanged();
        }
    }

    private void c(bg bgVar, int i) {
        if (i == 1) {
            PraiseData aej = bgVar.aej();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aej == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bgVar.a(praiseData);
                    return;
                }
                bgVar.aej().getUser().add(0, metaData);
                bgVar.aej().setNum(bgVar.aej().getNum() + 1);
                bgVar.aej().setIsLike(i);
            }
        } else if (bgVar.aej() != null) {
            bgVar.aej().setIsLike(i);
            bgVar.aej().setNum(bgVar.aej().getNum() - 1);
            ArrayList<MetaData> user = bgVar.aej().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bgVar.aej().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ftO == null) {
            this.ftO = VoiceManager.instance();
        }
        return this.ftO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView ald() {
        if (this.fMX == null) {
            return null;
        }
        return this.fMX.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bmj() {
        this.ftO = getVoiceManager();
        this.ftO.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> ale() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).ale();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.fts != null && this.fMX != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fMX.bmS();
            }
        }
    }

    private void bqC() {
        HashMap<Integer, bg> boV;
        if (this.fMX != null && this.fMX.bru() != null && (boV = this.fMX.bru().boV()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bg> entry : boV.entrySet()) {
                bg value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.arQ().x(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        if (ald() == null) {
            return null;
        }
        return ald().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kc()) {
            kF(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bmo() {
        return this.fts;
    }

    public FrsNewAreaModelController brs() {
        return this.fMW;
    }

    public void xs(String str) {
        this.ftH = str;
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

    public void aIQ() {
        if (!this.fKD.isLoading && !this.fMW.pP()) {
            if (this.fKD.cj(this.fts.getThreadListIds())) {
                this.fMX.a(this.fKD.bqX(), this.mPn, this.fts, 0);
                this.fKD.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.fts.getThreadListIds(), this.ftH, this.mPn, this.fts.isBrandForum);
            } else if (this.egI != 0) {
                this.fMX.a(this.fKD.bqX(), this.mPn, this.fts, 0);
                this.mPn++;
                this.fMW.sv(this.mPn);
                this.fKD.loadingDone = false;
                this.fKD.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.kt()) {
            this.fMX.aKk();
        } else if (!this.fMX.bna()) {
            if (!this.fMW.bqM()) {
                this.fMX.aKk();
                return;
            }
            aJe();
            aIQ();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void wC(String str) {
        aJe();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void V(ArrayList<m> arrayList) {
        ArrayList<m> a;
        aJe();
        if (arrayList != null && arrayList.size() != 0 && (a = this.fKD.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.fts.setThreadList(a);
            this.fMX.a(a, this.mPn, this.fts, 0);
        }
    }

    public void ck(List<String> list) {
        bY(list);
        int i = 0;
        Iterator<m> it = this.fts.getThreadList().iterator();
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
            aIQ();
        }
    }

    private void bY(List<String> list) {
        if (!v.aa(list)) {
            ArrayList<m> threadList = this.fts.getThreadList();
            if (!v.aa(threadList) && this.fMX.getListView() != null && this.fMX.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.fMX.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    m next = it.next();
                    if (next instanceof bf) {
                        bg bgVar = ((bf) next).threadData;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!aq.bV(list.get(i2), bgVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.fKD.e(next);
                                this.fMX.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel bqB() {
        return this.fKD;
    }

    private void aJe() {
        if (this.egI == 0 && !this.fKD.cj(this.fts.getThreadListIds())) {
            if (this.fts.getThreadList() == null || this.fts.getThreadList().size() == 0) {
                this.fMX.aKk();
                return;
            } else {
                this.fMX.aKj();
                return;
            }
        }
        this.fMX.aKi();
    }

    public g brt() {
        return this.fMX;
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
        com.baidu.tbadk.distribute.a.arL().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bmi() {
        if (this.fMW != null) {
            this.fMW.bmi();
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
    public NavigationBar aLh() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.ftH;
    }

    @Override // com.baidu.tieba.frs.ag
    public void blA() {
        if (this.fMX != null && this.fMX.getListView() != null) {
            this.fMX.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKh() {
        if (this.fMX != null) {
            blA();
            this.fMX.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.fun.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a me(int i) {
        return this.fun.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }
}
