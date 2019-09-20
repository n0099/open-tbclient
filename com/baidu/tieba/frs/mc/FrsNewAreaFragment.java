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
    private com.baidu.tbadk.m.c fAX;
    private String fNd;
    private FrsLoadMoreModel fNg;
    private FrsNewAreaModelController fPA;
    private VoiceManager fwa;
    private String fvT = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData fvE = new FrsViewData();
    public long eZc = -1;
    public long cAQ = 0;
    public long cAY = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fwm = false;
    protected g fPB = null;
    private int eiz = -1;
    private int fDK = 3;
    private boolean eNo = false;
    public boolean fNj = false;
    private boolean fNk = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fwz = new SparseArray<>();
    private CustomMessageListener fzb = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.fAX != null && FrsNewAreaFragment.this.fAX.isViewAttached()) {
                FrsNewAreaFragment.this.fAX.kL(num.intValue());
            }
        }
    };
    private Runnable fNl = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.kc() || FrsNewAreaFragment.this.eNo) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.kI(false);
            }
        }
    };
    private CustomMessageListener fNm = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                bh bhVar = (bh) customResponsedMessage.getData();
                FrsNewAreaFragment.this.fNd = bhVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.fNd) && bhVar.aeo() != null) {
                    FrsNewAreaFragment.this.sz(bhVar.aeo().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fxf = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.alr() != null) {
                        FrsNewAreaFragment.this.alr().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.fAX != null && FrsNewAreaFragment.this.fAX.isViewAttached()) {
                        FrsNewAreaFragment.this.kI(false);
                    } else if (FrsNewAreaFragment.this.fPB != null) {
                        FrsNewAreaFragment.this.fPB.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final p fxu = new p() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long fNp = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void rx(int i) {
            if (!FrsNewAreaFragment.this.fNk) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.fPB.bnN();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.fPB.gf(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.fNk) {
                if (FrsNewAreaFragment.this.bss().brI() == null) {
                    FrsNewAreaFragment.this.fNk = false;
                    return;
                } else if (FrsNewAreaFragment.this.bss().brI().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.fNk = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.fNp = 1L;
            } else if (bVar.isSuccess) {
                this.fNp = 0L;
            } else {
                this.fNp = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.fNg.resetData();
            }
            FrsNewAreaFragment.this.fPB.gf(false);
            if (FrsNewAreaFragment.this.bss().brI() != null) {
                FrsNewAreaFragment.this.fvE = FrsNewAreaFragment.this.bss().brI();
            }
            FrsNewAreaFragment.this.eiz = FrsNewAreaFragment.this.fvE.getPage().adw();
            if (FrsNewAreaFragment.this.eiz == 0 && (FrsNewAreaFragment.this.fvE.getThreadListIds() == null || FrsNewAreaFragment.this.fvE.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.fvE.getThreadList() == null || FrsNewAreaFragment.this.fvE.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.fPB.aKQ();
                } else {
                    FrsNewAreaFragment.this.fPB.aKP();
                }
            } else {
                FrsNewAreaFragment.this.fPB.aKO();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.fNg.a(false, false, false, FrsNewAreaFragment.this.fvE.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.fvE.setThreadList(a2);
                    FrsNewAreaFragment.this.fPB.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.fvE, FrsNewAreaFragment.this.eiz);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.fPB.bnN();
                    break;
                case 2:
                    FrsNewAreaFragment.this.fPB.bnN();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.fvE.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.fNp != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.fvE != null) {
                    FrsNewAreaFragment.this.fvT = FrsNewAreaFragment.this.fvE.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.fvE.getForum().getId();
                    FrsNewAreaFragment.this.fPB.b(FrsNewAreaFragment.this.fvE.getForum(), FrsNewAreaFragment.this.fvE.getUserData());
                }
                if (FrsNewAreaFragment.this.fvE != null) {
                    FrsNewAreaFragment.this.fvE.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.fvE == null || FrsNewAreaFragment.this.fvE.getThreadList() == null || FrsNewAreaFragment.this.fvE.getThreadList().size() != 0 || FrsNewAreaFragment.this.bss().getType() != 4) {
                    if (FrsNewAreaFragment.this.fvE != null && (a = FrsNewAreaFragment.this.fNg.a(false, false, true, FrsNewAreaFragment.this.fvE.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.fvE.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bnb();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.eZc > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsNewAreaFragment.this.eZc, FrsNewAreaFragment.this.bss().bgV() - FrsNewAreaFragment.this.eZc, FrsNewAreaFragment.this.bss().bgT(), FrsNewAreaFragment.this.bss().bgU(), currentTimeMillis2 - FrsNewAreaFragment.this.bss().bgS());
                        FrsNewAreaFragment.this.eZc = -1L;
                    }
                    FrsNewAreaFragment.this.cAY = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.eZc > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsNewAreaFragment.this.eZc, FrsNewAreaFragment.this.bss().bgV() - FrsNewAreaFragment.this.eZc, FrsNewAreaFragment.this.bss().bgT(), FrsNewAreaFragment.this.bss().bgU(), currentTimeMillis3 - FrsNewAreaFragment.this.bss().bgS());
                FrsNewAreaFragment.this.eZc = -1L;
            }
            FrsNewAreaFragment.this.cAY = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
        }
    };
    private final CustomMessageListener bDW = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.fPB != null) {
                FrsNewAreaFragment.this.fPB.startPullRefresh();
            }
        }
    };
    private final h.c dvZ = new h.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.h.c
        public void eu(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.kc()) {
                com.baidu.tieba.a.d.aCV().sx("page_frs_good");
                FrsNewAreaFragment.this.kI(true);
                return;
            }
            FrsNewAreaFragment.this.fPB.gf(false);
        }
    };
    private final h.b cbD = new h.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.cpt().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.fwm) {
                FrsNewAreaFragment.this.fwm = true;
                FrsNewAreaFragment.this.fPB.bob();
            }
            if (i == 0) {
                t.bat().iH(true);
                com.baidu.tieba.q.c.cpt().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener cjl = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
    private s fxA = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bg)) {
                bh bhVar = ((bg) mVar).threadData;
                if (bhVar.afu() == null || bhVar.afu().getGroup_id() == 0 || bc.cF(FrsNewAreaFragment.this.getActivity())) {
                    if (bhVar.afm() != 1 || bc.cF(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Fy(bhVar.getId())) {
                            readThreadHistory.Fx(bhVar.getId());
                            if (FrsNewAreaFragment.this.fPB != null) {
                                FrsNewAreaFragment.this.fPB.bnN();
                            }
                        }
                        boolean z = false;
                        final String aeJ = bhVar.aeJ();
                        if (aeJ != null && !aeJ.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aeJ);
                                    xVar.aiK().ajM().mIsNeedAddCommenParam = false;
                                    xVar.aiK().ajM().mIsUseCurrentBDUSS = false;
                                    xVar.ain();
                                }
                            }).start();
                        }
                        String tid = bhVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bhVar.aex() == 2 && !tid.startsWith("pb:")) {
                            ba.ajK().c(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bhVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bhVar, FrsNewAreaFragment.this.fvT, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsNewAreaFragment.this.fNj ? 15 : 3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.fvE != null && FrsNewAreaFragment.this.fvE.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fRi = FrsNewAreaFragment.this.fvE.needLog == 1;
                            bVar.fRk = FrsNewAreaFragment.this.fvE.getForum().getId();
                            bVar.fRj = FrsNewAreaFragment.this.fPA.bsl();
                            if (com.baidu.tieba.frs.d.d.fEI != null) {
                                bVar.fRl = com.baidu.tieba.frs.d.d.fEI.fRl;
                                bVar.fRm = com.baidu.tieba.frs.d.d.fEI.fRm;
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

    public void ae(bh bhVar) {
        if (bhVar != null) {
            this.fPA.ae(bhVar);
            this.fPB.bms();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.fvE = frsViewData;
            hideLoadingView(this.fPB.aYe());
            if (this.fPB != null) {
                this.fPB.gf(false);
                this.fPB.a(null, this.mPn, this.fvE, this.eiz);
            }
        }
    }

    private void showLoadingView() {
        this.fPB.ks(false);
        showLoadingView(this.fPB.aYe(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fPB.ks(true);
        hideLoadingView(this.fPB.aYe());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fPB.ks(false);
        this.fPB.bpa().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fPB.aKQ();
        this.fPB.getListView().getData().clear();
        this.fPB.bnN();
        if (this.fAX == null) {
            this.fAX = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fAX.setTitle(null);
            this.fAX.setButtonText(null);
            this.fAX.atW();
            this.fAX.atX().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.fAX.qY(getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.fAX.qY(null);
        }
        this.fAX.onChangeSkinType();
        this.fAX.attachView(this.fPB.aYe(), true);
        registerListener(this.fzb);
    }

    private void aJN() {
        this.fPB.ks(true);
        this.fPB.bpa().setEnabled(true);
        if (this.fAX != null && this.fAX.isViewAttached()) {
            this.fAX.dettachView(this.fPB.aYe());
        }
        MessageManager.getInstance().unRegisterListener(this.fzb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kI(boolean z) {
        this.eNo = true;
        bne();
        aJN();
        if (!z) {
            aJN();
            showLoadingView();
        }
        this.fPA.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eZc = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eZc = System.currentTimeMillis();
        }
        this.forumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.cAQ = this.beginTime - this.eZc;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cpt().u(getUniqueId());
        this.fPA = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.fPA.K(arguments);
        } else if (bundle != null) {
            this.fPA.K(bundle);
        } else {
            this.fPA.K(null);
        }
        this.fwa = getVoiceManager();
        this.fwa.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bDW);
        registerListener(this.fNm);
        registerListener(this.fxf);
        this.fNg = new FrsLoadMoreModel(this, null);
        this.fNg.registerListener();
        this.fNg.setPageType(3);
        this.fNg.kL(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fPB = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eNo) {
            if (com.baidu.adp.lib.util.j.kc()) {
                kI(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        ajq();
    }

    private void ajq() {
        an anVar = new an("c13008");
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bT("fid", this.forumId);
        anVar.P("obj_type", 6);
        anVar.P("obj_locate", 2);
        anVar.ajq();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fwa = getVoiceManager();
        this.fwa.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bry();
        if (bundle != null) {
            this.fvT = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.fvT = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bry() {
        registerListener(2001118, this.cjl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fPB != null) {
            this.fPB.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fzb);
        com.baidu.tieba.q.c.cpt().v(getUniqueId());
        t.bat().iH(false);
        super.onDestroy();
        this.fPA.aGu();
        this.fwa = getVoiceManager();
        this.fwa.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fNl);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.fvT);
        bundle.putString("from", this.mFrom);
        this.fPA.onSaveInstanceState(bundle);
        this.fwa = getVoiceManager();
        if (this.fwa != null) {
            this.fwa.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bh threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.fPB.bsu().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.fvE.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.hm(intent.getIntExtra("good_data", 0));
                            threadDataById.afs();
                            kI(false);
                            return;
                        } else if (intExtra == 0) {
                            this.fvE.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.fvE.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.m());
                            }
                            this.fPB.brD();
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
            if (this.fDK == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.eNo) {
                com.baidu.adp.lib.g.e.iK().post(this.fNl);
            }
        }
        boQ();
    }

    private void boQ() {
        if (isPrimary()) {
            if (this.fAX != null && this.fAX.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fzb);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fzb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fPB != null) {
            this.fPB.bnN();
        }
        this.fwa = getVoiceManager();
        this.fwa.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fPB.setOnAdapterItemClickListener(this.fxA);
        this.fPB.setOnScrollListener(this.mScrollListener);
        this.fPB.setListPullRefreshListener(this.dvZ);
        this.fPB.a(this.cbD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fDK != 3 || this.fPB != null) {
            this.fDK = i;
            super.onChangeSkinType(i);
            if (this.fPB != null) {
                this.fPB.onChangeSkinType(i);
            }
            if (this.fAX != null && this.fAX.isViewAttached()) {
                this.fAX.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bme() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bme();
        }
        return null;
    }

    private void bna() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.iL().d(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Fs(FrsNewAreaFragment.this.fvT);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnb() {
        bne();
        try {
            if (this.fvE != null) {
                this.fPB.aWv();
                this.fvT = this.fvE.getForum().getName();
                this.forumId = this.fvE.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.fvE.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fvE.getUserData().getBimg_end_time());
                bna();
                ArrayList<m> threadList = this.fvE.getThreadList();
                if (threadList != null) {
                    this.fPB.a(threadList, this.mPn, this.fvE, this.fvE.getPage().adw());
                    brA();
                    this.fPB.brD();
                    if (this.fvE.getIsNewUrl() == 1) {
                        this.fPB.bsu().setFromCDN(true);
                    } else {
                        this.fPB.bsu().setFromCDN(false);
                    }
                    this.fPB.setListViewSelection(bC(bss().getType(), this.mPn));
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
        this.fwa = getVoiceManager();
        this.fwa.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.bat().iH(false);
        com.baidu.tieba.q.c.cpt().b(getUniqueId(), false);
        if (this.fvE != null && this.fvE.getForum() != null) {
            com.baidu.tbadk.distribute.a.arZ().a(getPageContext().getPageActivity(), "frs", this.fvE.getForum().getId(), 0L);
        }
        this.fwa = getVoiceManager();
        if (this.fwa != null) {
            this.fwa.onStop(getPageContext());
        }
    }

    public void bpx() {
        if (this.fPB != null) {
            this.fPB.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sz(int i) {
        ArrayList<m> threadList = this.fvE.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bg) {
                    bh bhVar = ((bg) next).threadData;
                    if (bhVar.getId() != null && bhVar.getId().equals(this.fNd)) {
                        c(bhVar, i);
                        this.fNd = null;
                        break;
                    }
                }
            }
            this.fPB.bsu().b(threadList, this.fvE);
            this.fPB.bsu().notifyDataSetChanged();
        }
    }

    private void c(bh bhVar, int i) {
        if (i == 1) {
            PraiseData aeo = bhVar.aeo();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aeo == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bhVar.a(praiseData);
                    return;
                }
                bhVar.aeo().getUser().add(0, metaData);
                bhVar.aeo().setNum(bhVar.aeo().getNum() + 1);
                bhVar.aeo().setIsLike(i);
            }
        } else if (bhVar.aeo() != null) {
            bhVar.aeo().setIsLike(i);
            bhVar.aeo().setNum(bhVar.aeo().getNum() - 1);
            ArrayList<MetaData> user = bhVar.aeo().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bhVar.aeo().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fwa == null) {
            this.fwa = VoiceManager.instance();
        }
        return this.fwa;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView alr() {
        if (this.fPB == null) {
            return null;
        }
        return this.fPB.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bne() {
        this.fwa = getVoiceManager();
        this.fwa.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> als() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).als();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.fvE != null && this.fPB != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fPB.bnN();
            }
        }
    }

    private void brA() {
        HashMap<Integer, bh> bpT;
        if (this.fPB != null && this.fPB.bsu() != null && (bpT = this.fPB.bsu().bpT()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bh> entry : bpT.entrySet()) {
                bh value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.ase().x(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (alr() == null) {
            return null;
        }
        return alr().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kc()) {
            kI(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bnj() {
        return this.fvE;
    }

    public FrsNewAreaModelController bss() {
        return this.fPA;
    }

    public void xS(String str) {
        this.fvT = str;
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

    public void aJw() {
        if (!this.fNg.isLoading && !this.fPA.pQ()) {
            if (this.fNg.ci(this.fvE.getThreadListIds())) {
                this.fPB.a(this.fNg.brV(), this.mPn, this.fvE, 0);
                this.fNg.a(com.baidu.adp.lib.g.b.e(this.forumId, 0L), this.fvE.getThreadListIds(), this.fvT, this.mPn, this.fvE.isBrandForum);
            } else if (this.eiz != 0) {
                this.fPB.a(this.fNg.brV(), this.mPn, this.fvE, 0);
                this.mPn++;
                this.fPA.sB(this.mPn);
                this.fNg.loadingDone = false;
                this.fNg.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.kt()) {
            this.fPB.aKQ();
        } else if (!this.fPB.bnV()) {
            if (!this.fPA.brK()) {
                this.fPB.aKQ();
                return;
            }
            aJK();
            aJw();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void xc(String str) {
        aJK();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void V(ArrayList<m> arrayList) {
        ArrayList<m> a;
        aJK();
        if (arrayList != null && arrayList.size() != 0 && (a = this.fNg.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.fvE.setThreadList(a);
            this.fPB.a(a, this.mPn, this.fvE, 0);
        }
    }

    public void cj(List<String> list) {
        bY(list);
        int i = 0;
        Iterator<m> it = this.fvE.getThreadList().iterator();
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
            aJw();
        }
    }

    private void bY(List<String> list) {
        if (!v.aa(list)) {
            ArrayList<m> threadList = this.fvE.getThreadList();
            if (!v.aa(threadList) && this.fPB.getListView() != null && this.fPB.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.fPB.getListView().getData();
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
                                this.fNg.e(next);
                                this.fPB.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel brz() {
        return this.fNg;
    }

    private void aJK() {
        if (this.eiz == 0 && !this.fNg.ci(this.fvE.getThreadListIds())) {
            if (this.fvE.getThreadList() == null || this.fvE.getThreadList().size() == 0) {
                this.fPB.aKQ();
                return;
            } else {
                this.fPB.aKP();
                return;
            }
        }
        this.fPB.aKO();
    }

    public g bst() {
        return this.fPB;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0049a
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
        com.baidu.tbadk.distribute.a.arZ().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bnd() {
        if (this.fPA != null) {
            this.fPA.bnd();
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
    public NavigationBar aLN() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.fvT;
    }

    @Override // com.baidu.tieba.frs.ag
    public void bms() {
        if (this.fPB != null && this.fPB.getListView() != null) {
            this.fPB.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKN() {
        if (this.fPB != null) {
            bms();
            this.fPB.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.fwz.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a mj(int i) {
        return this.fwz.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }
}
