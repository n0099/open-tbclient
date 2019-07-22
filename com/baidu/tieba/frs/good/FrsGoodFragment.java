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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0041a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ag, ah, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String fKA;
    private FrsGoodModelController fKC;
    private FrsLoadMoreModel fKD;
    private com.baidu.tieba.frs.gametab.b fKF;
    private VoiceManager ftO;
    private c fyL;
    private String mForumId;
    private String ftH = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean fKB = false;
    private String forumId = null;
    private FrsViewData fts = new FrsViewData();
    public long eXm = -1;
    public long czN = 0;
    public long czV = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fua = false;
    protected a fKE = null;
    private int egI = -1;
    private int mTabId = 0;
    private int fBj = 3;
    private boolean eLy = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fun = new SparseArray<>();
    public boolean fKG = false;
    private boolean fKH = false;
    private CustomMessageListener fwP = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.fyL != null && FrsGoodFragment.this.fyL.isViewAttached()) {
                FrsGoodFragment.this.fyL.kH(num.intValue());
            }
        }
    };
    private Runnable fKI = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // java.lang.Runnable
        public void run() {
            if (!j.kc() || FrsGoodFragment.this.eLy) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.kF(false);
            }
        }
    };
    private CustomMessageListener fKJ = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                FrsGoodFragment.this.fKA = bgVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.fKA) && bgVar.aej() != null) {
                    FrsGoodFragment.this.st(bgVar.aej().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fuT = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.ald() != null) {
                            FrsGoodFragment.this.ald().setSelection(0);
                        }
                        if (FrsGoodFragment.this.fyL != null && FrsGoodFragment.this.fyL.isViewAttached()) {
                            FrsGoodFragment.this.kF(false);
                        } else if (FrsGoodFragment.this.fKE != null) {
                            FrsGoodFragment.this.fKE.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n fvi = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        private long fKM = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void rs(int i) {
            if (!FrsGoodFragment.this.fKH) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.fKE.bmS();
                        return;
                    case 3:
                        FrsGoodFragment.this.fKE.gc(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.fKH) {
                if (FrsGoodFragment.this.bqD().bqK() == null) {
                    FrsGoodFragment.this.fKH = false;
                    return;
                } else if (FrsGoodFragment.this.bqD().bqK().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.fKH = false;
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
                FrsGoodFragment.this.fKD.resetData();
            }
            FrsGoodFragment.this.fKE.gc(false);
            if (FrsGoodFragment.this.bqD().bqK() != null) {
                FrsGoodFragment.this.fts = FrsGoodFragment.this.bqD().bqK();
            }
            FrsGoodFragment.this.egI = FrsGoodFragment.this.fts.getPage().adr();
            if (FrsGoodFragment.this.egI == 0 && (FrsGoodFragment.this.fts.getThreadListIds() == null || FrsGoodFragment.this.fts.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.fts.getThreadList() == null || FrsGoodFragment.this.fts.getThreadList().size() == 0) {
                    FrsGoodFragment.this.fKE.aKk();
                } else {
                    FrsGoodFragment.this.fKE.aKj();
                }
            } else {
                FrsGoodFragment.this.fKE.aKi();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.fKD.a(false, false, false, FrsGoodFragment.this.fts.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.fts.setThreadList(a2);
                    FrsGoodFragment.this.fKE.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.fts, FrsGoodFragment.this.egI);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.fKE.bmS();
                    break;
                case 2:
                    FrsGoodFragment.this.fKE.bmS();
                    break;
                case 3:
                    if (FrsGoodFragment.this.fts.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.fKM != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.fts != null) {
                    FrsGoodFragment.this.ftH = FrsGoodFragment.this.fts.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.fts.getForum().getId();
                    FrsGoodFragment.this.fKE.b(FrsGoodFragment.this.fts.getForum(), FrsGoodFragment.this.fts.getUserData());
                }
                if (FrsGoodFragment.this.fts != null) {
                    FrsGoodFragment.this.fts.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.fKE.c(FrsGoodFragment.this.fts);
                if (FrsGoodFragment.this.fts == null || FrsGoodFragment.this.fts.getThreadList() == null || FrsGoodFragment.this.fts.getThreadList().size() != 0 || FrsGoodFragment.this.bqD().getType() != 4) {
                    if (FrsGoodFragment.this.fts != null && (a = FrsGoodFragment.this.fKD.a(false, false, true, FrsGoodFragment.this.fts.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.fts.setThreadList(a);
                    }
                    FrsGoodFragment.this.bmg();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.eXm > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.eXm, FrsGoodFragment.this.bqD().bgm() - FrsGoodFragment.this.eXm, FrsGoodFragment.this.bqD().bgk(), FrsGoodFragment.this.bqD().bgl(), currentTimeMillis2 - FrsGoodFragment.this.bqD().bgj());
                        FrsGoodFragment.this.eXm = -1L;
                    }
                    FrsGoodFragment.this.czV = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.eXm > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.eXm, FrsGoodFragment.this.bqD().bgm() - FrsGoodFragment.this.eXm, FrsGoodFragment.this.bqD().bgk(), FrsGoodFragment.this.bqD().bgl(), currentTimeMillis3 - FrsGoodFragment.this.bqD().bgj());
                FrsGoodFragment.this.eXm = -1L;
            }
            FrsGoodFragment.this.czV = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
        }
    };
    private final CustomMessageListener bDy = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.fKE != null) {
                FrsGoodFragment.this.fKE.startPullRefresh();
            }
        }
    };
    private final h.c duh = new h.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.kc()) {
                d.aCF().sl("page_frs_good");
                FrsGoodFragment.this.kF(true);
                return;
            }
            FrsGoodFragment.this.fKE.gc(false);
        }
    };
    private final h.b caE = new h.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.coo().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.fua) {
                FrsGoodFragment.this.fua = true;
                FrsGoodFragment.this.fKE.bng();
            }
            if (i == 0) {
                t.aZN().iE(true);
                com.baidu.tieba.q.c.coo().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener cij = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
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
    private s fvo = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bf)) {
                bg bgVar = ((bf) mVar).threadData;
                if (bgVar.afp() == null || bgVar.afp().getGroup_id() == 0 || bd.cF(FrsGoodFragment.this.getActivity())) {
                    if (bgVar.afh() != 1 || bd.cF(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.EX(bgVar.getId())) {
                            readThreadHistory.EW(bgVar.getId());
                            if (FrsGoodFragment.this.fKE != null) {
                                FrsGoodFragment.this.fKE.bmS();
                            }
                        }
                        boolean z = false;
                        final String aeE = bgVar.aeE();
                        if (aeE != null && !aeE.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6.1
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
                            bb.ajC().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bgVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bgVar, FrsGoodFragment.this.ftH, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.fKG ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsGoodFragment.this.fts != null && FrsGoodFragment.this.fts.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fOD = FrsGoodFragment.this.fts.needLog == 1;
                            bVar.fOF = FrsGoodFragment.this.fts.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.fCh != null) {
                                bVar.fOG = com.baidu.tieba.frs.d.d.fCh.fOG;
                                bVar.fOH = com.baidu.tieba.frs.d.d.fCh.fOH;
                            }
                            com.baidu.tieba.frs.d.a.a(bgVar, 1, FrsGoodFragment.this.getUniqueId(), bVar);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fvs = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.fKE != null) {
                FrsGoodFragment.this.fKE.bno();
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
        this.fKE.kp(false);
        showLoadingView(this.fKE.aXy(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fKE.kp(true);
        hideLoadingView(this.fKE.aXy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fKE.kp(false);
        this.fKE.boe().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fKE.aKk();
        this.fKE.getListView().getData().clear();
        this.fKE.bmS();
        if (this.fyL == null) {
            this.fyL = new c(getPageContext().getContext(), getNetRefreshListener());
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
        this.fyL.attachView(this.fKE.aXy(), true);
        registerListener(this.fwP);
    }

    private void aJh() {
        this.fKE.kp(true);
        this.fKE.boe().setEnabled(true);
        if (this.fyL != null && this.fyL.isViewAttached()) {
            this.fyL.dettachView(this.fKE.aXy());
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
        this.fKC.nc(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eXm = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eXm = System.currentTimeMillis();
        }
        this.mForumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.czN = this.beginTime - this.eXm;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.coo().u(getUniqueId());
        this.fKC = new FrsGoodModelController(this);
        if (arguments != null) {
            this.fKC.K(arguments);
            this.fKB = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.fKC.K(bundle);
            this.fKB = bundle.getBoolean("is_game_frs", false);
        } else {
            this.fKC.K(null);
        }
        this.ftO = getVoiceManager();
        this.ftO.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bDy);
        registerListener(this.fKJ);
        registerListener(this.fuT);
        registerListener(this.fvs);
        this.fKD = new FrsLoadMoreModel(this, null);
        this.fKD.registerListener();
        this.fKD.setPageType(2);
        this.fKD.kI(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fKE = new a(this, inflate, this.fKB);
        this.fKE.bqH().kH(this.fKG);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eLy) {
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
        this.ftO = getVoiceManager();
        this.ftO.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bqA();
        if (bundle != null) {
            this.ftH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fKG = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.ftH = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.fKG = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bqA() {
        registerListener(2001118, this.cij);
    }

    public FrsLoadMoreModel bqB() {
        return this.fKD;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fKE != null) {
            this.fKE.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fwP);
        com.baidu.tieba.q.c.coo().v(getUniqueId());
        t.aZN().iE(false);
        super.onDestroy();
        this.fKC.aFO();
        this.ftO = getVoiceManager();
        this.ftO.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fKI);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.ftH);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.fKB);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fKG);
        this.fKC.onSaveInstanceState(bundle);
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
                    this.fKE.bqH().notifyDataSetChanged();
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
                            this.fKE.bqF();
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
        if (this.fKE != null) {
            this.fKE.bmS();
        }
        this.ftO = getVoiceManager();
        this.ftO.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fKF = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.fKE.setOnAdapterItemClickListener(this.fvo);
        this.fKE.setOnScrollListener(this.mScrollListener);
        this.fKE.setListPullRefreshListener(this.duh);
        this.fKE.a(this.caE);
        this.fKE.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.fKF != null) {
                    FrsGoodFragment.this.fKF.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fBj != 3 || this.fKE != null) {
            this.fBj = i;
            super.onChangeSkinType(i);
            if (this.fKE != null) {
                this.fKE.onChangeSkinType(i);
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
                com.baidu.adp.lib.g.h.iL().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.ER(FrsGoodFragment.this.ftH);
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
                this.fKE.aVP();
                this.ftH = this.fts.getForum().getName();
                this.forumId = this.fts.getForum().getId();
                if (this.fts != null && this.fts.getForum() != null) {
                    this.fKE.a(this.fts.getForum().getThemeColorInfo());
                    this.fKE.c(this.fts);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.fts.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fts.getUserData().getBimg_end_time());
                bmf();
                if (!this.fKE.bqH().n(bg.bJy)) {
                    this.fts.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.fts.getThreadList();
                if (threadList != null) {
                    this.fKE.a(threadList, this.mPn, this.fts, this.fts.getPage().adr());
                    bqC();
                    this.fKE.bqF();
                    if (this.fts.getIsNewUrl() == 1) {
                        this.fKE.bqH().setFromCDN(true);
                    } else {
                        this.fKE.bqH().setFromCDN(false);
                    }
                    this.fKE.setListViewSelection(bC(bqD().getType(), this.mPn));
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
            this.fKE.bqH().b(threadList, this.fts);
            this.fKE.bqH().notifyDataSetChanged();
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
        if (this.fKE == null) {
            return null;
        }
        return this.fKE.getListView();
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
        if (this.fts != null && this.fKE != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fKE.bmS();
            }
        }
    }

    private void bqC() {
        HashMap<Integer, bg> boV;
        if (this.fKE != null && this.fKE.bqH() != null && (boV = this.fKE.bqH().boV()) != null) {
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
        if (j.kc()) {
            kF(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bmo() {
        return this.fts;
    }

    public FrsGoodModelController bqD() {
        return this.fKC;
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

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!l.kt()) {
            this.fKE.aKk();
        } else if (!this.fKC.bqM()) {
            this.fKE.aKk();
        } else {
            aJe();
            if (!this.fKD.isLoading && !this.fKC.pP()) {
                if (this.fKD.cj(this.fts.getThreadListIds())) {
                    this.fKE.a(this.fKD.bqX(), this.mPn, this.fts, 0);
                    this.fKD.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.fts.getThreadListIds(), this.ftH, this.mPn, this.fts.isBrandForum);
                } else if (this.egI != 0) {
                    this.fKE.a(this.fKD.bqX(), this.mPn, this.fts, 0);
                    this.mPn++;
                    this.fKC.sv(this.mPn);
                    this.fKD.loadingDone = false;
                    this.fKD.loadIndex = 0;
                }
            }
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.fKD.a(false, false, false, arrayList, (f) null)) != null) {
            this.fts.setThreadList(a);
            this.fKE.a(a, this.mPn, this.fts, 0);
        }
    }

    private void aJe() {
        if (this.egI == 0 && !this.fKD.cj(this.fts.getThreadListIds())) {
            if (this.fts.getThreadList() == null || this.fts.getThreadList().size() == 0) {
                this.fKE.aKk();
                return;
            } else {
                this.fKE.aKj();
                return;
            }
        }
        this.fKE.aKi();
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
        if (this.fKC != null) {
            this.fKC.bmi();
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void su(int i) {
        this.mTabId = i;
        if (j.kc()) {
            kF(false);
        } else {
            c((e.b) null);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void blA() {
        if (this.fKE != null && this.fKE.getListView() != null) {
            this.fKE.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKh() {
        if (this.fKE != null) {
            blA();
            this.fKE.startPullRefresh();
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
