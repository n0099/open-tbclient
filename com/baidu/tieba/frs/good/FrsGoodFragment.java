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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
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
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0049a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ag, ah, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private c fAX;
    private String fNd;
    private FrsGoodModelController fNf;
    private FrsLoadMoreModel fNg;
    private com.baidu.tieba.frs.gametab.b fNi;
    private VoiceManager fwa;
    private String mForumId;
    private String fvT = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean fNe = false;
    private String forumId = null;
    private FrsViewData fvE = new FrsViewData();
    public long eZc = -1;
    public long cAQ = 0;
    public long cAY = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fwm = false;
    protected a fNh = null;
    private int eiz = -1;
    private int mTabId = 0;
    private int fDK = 3;
    private boolean eNo = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fwz = new SparseArray<>();
    public boolean fNj = false;
    private boolean fNk = false;
    private CustomMessageListener fzb = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.fAX != null && FrsGoodFragment.this.fAX.isViewAttached()) {
                FrsGoodFragment.this.fAX.kL(num.intValue());
            }
        }
    };
    private Runnable fNl = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // java.lang.Runnable
        public void run() {
            if (!j.kc() || FrsGoodFragment.this.eNo) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.kI(false);
            }
        }
    };
    private CustomMessageListener fNm = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                bh bhVar = (bh) customResponsedMessage.getData();
                FrsGoodFragment.this.fNd = bhVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.fNd) && bhVar.aeo() != null) {
                    FrsGoodFragment.this.sz(bhVar.aeo().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fxf = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.alr() != null) {
                            FrsGoodFragment.this.alr().setSelection(0);
                        }
                        if (FrsGoodFragment.this.fAX != null && FrsGoodFragment.this.fAX.isViewAttached()) {
                            FrsGoodFragment.this.kI(false);
                        } else if (FrsGoodFragment.this.fNh != null) {
                            FrsGoodFragment.this.fNh.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final p fxu = new p() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        private long fNp = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void rx(int i) {
            if (!FrsGoodFragment.this.fNk) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.fNh.bnN();
                        return;
                    case 3:
                        FrsGoodFragment.this.fNh.gf(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.fNk) {
                if (FrsGoodFragment.this.brB().brI() == null) {
                    FrsGoodFragment.this.fNk = false;
                    return;
                } else if (FrsGoodFragment.this.brB().brI().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.fNk = false;
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
                FrsGoodFragment.this.fNg.resetData();
            }
            FrsGoodFragment.this.fNh.gf(false);
            if (FrsGoodFragment.this.brB().brI() != null) {
                FrsGoodFragment.this.fvE = FrsGoodFragment.this.brB().brI();
            }
            FrsGoodFragment.this.eiz = FrsGoodFragment.this.fvE.getPage().adw();
            if (FrsGoodFragment.this.eiz == 0 && (FrsGoodFragment.this.fvE.getThreadListIds() == null || FrsGoodFragment.this.fvE.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.fvE.getThreadList() == null || FrsGoodFragment.this.fvE.getThreadList().size() == 0) {
                    FrsGoodFragment.this.fNh.aKQ();
                } else {
                    FrsGoodFragment.this.fNh.aKP();
                }
            } else {
                FrsGoodFragment.this.fNh.aKO();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.fNg.a(false, false, false, FrsGoodFragment.this.fvE.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.fvE.setThreadList(a2);
                    FrsGoodFragment.this.fNh.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.fvE, FrsGoodFragment.this.eiz);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.fNh.bnN();
                    break;
                case 2:
                    FrsGoodFragment.this.fNh.bnN();
                    break;
                case 3:
                    if (FrsGoodFragment.this.fvE.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.fNp != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.fvE != null) {
                    FrsGoodFragment.this.fvT = FrsGoodFragment.this.fvE.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.fvE.getForum().getId();
                    FrsGoodFragment.this.fNh.b(FrsGoodFragment.this.fvE.getForum(), FrsGoodFragment.this.fvE.getUserData());
                }
                if (FrsGoodFragment.this.fvE != null) {
                    FrsGoodFragment.this.fvE.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.fNh.c(FrsGoodFragment.this.fvE);
                if (FrsGoodFragment.this.fvE == null || FrsGoodFragment.this.fvE.getThreadList() == null || FrsGoodFragment.this.fvE.getThreadList().size() != 0 || FrsGoodFragment.this.brB().getType() != 4) {
                    if (FrsGoodFragment.this.fvE != null && (a = FrsGoodFragment.this.fNg.a(false, false, true, FrsGoodFragment.this.fvE.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.fvE.setThreadList(a);
                    }
                    FrsGoodFragment.this.bnb();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.eZc > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.eZc, FrsGoodFragment.this.brB().bgV() - FrsGoodFragment.this.eZc, FrsGoodFragment.this.brB().bgT(), FrsGoodFragment.this.brB().bgU(), currentTimeMillis2 - FrsGoodFragment.this.brB().bgS());
                        FrsGoodFragment.this.eZc = -1L;
                    }
                    FrsGoodFragment.this.cAY = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.eZc > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.eZc, FrsGoodFragment.this.brB().bgV() - FrsGoodFragment.this.eZc, FrsGoodFragment.this.brB().bgT(), FrsGoodFragment.this.brB().bgU(), currentTimeMillis3 - FrsGoodFragment.this.brB().bgS());
                FrsGoodFragment.this.eZc = -1L;
            }
            FrsGoodFragment.this.cAY = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(l lVar) {
        }
    };
    private final CustomMessageListener bDW = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.fNh != null) {
                FrsGoodFragment.this.fNh.startPullRefresh();
            }
        }
    };
    private final h.c dvZ = new h.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void eu(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.kc()) {
                d.aCV().sx("page_frs_good");
                FrsGoodFragment.this.kI(true);
                return;
            }
            FrsGoodFragment.this.fNh.gf(false);
        }
    };
    private final h.b cbD = new h.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.cpt().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.fwm) {
                FrsGoodFragment.this.fwm = true;
                FrsGoodFragment.this.fNh.bob();
            }
            if (i == 0) {
                t.bat().iH(true);
                com.baidu.tieba.q.c.cpt().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener cjl = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
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
    private s fxA = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bg)) {
                bh bhVar = ((bg) mVar).threadData;
                if (bhVar.afu() == null || bhVar.afu().getGroup_id() == 0 || bc.cF(FrsGoodFragment.this.getActivity())) {
                    if (bhVar.afm() != 1 || bc.cF(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Fy(bhVar.getId())) {
                            readThreadHistory.Fx(bhVar.getId());
                            if (FrsGoodFragment.this.fNh != null) {
                                FrsGoodFragment.this.fNh.bnN();
                            }
                        }
                        boolean z = false;
                        final String aeJ = bhVar.aeJ();
                        if (aeJ != null && !aeJ.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6.1
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
                            ba.ajK().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bhVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bhVar, FrsGoodFragment.this.fvT, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.fNj ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsGoodFragment.this.fvE != null && FrsGoodFragment.this.fvE.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fRi = FrsGoodFragment.this.fvE.needLog == 1;
                            bVar.fRk = FrsGoodFragment.this.fvE.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.fEI != null) {
                                bVar.fRl = com.baidu.tieba.frs.d.d.fEI.fRl;
                                bVar.fRm = com.baidu.tieba.frs.d.d.fEI.fRm;
                            }
                            com.baidu.tieba.frs.d.a.a(bhVar, 1, FrsGoodFragment.this.getUniqueId(), bVar);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fxE = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.fNh != null) {
                FrsGoodFragment.this.fNh.boj();
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
        this.fNh.ks(false);
        showLoadingView(this.fNh.aYe(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fNh.ks(true);
        hideLoadingView(this.fNh.aYe());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fNh.ks(false);
        this.fNh.bpa().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fNh.aKQ();
        this.fNh.getListView().getData().clear();
        this.fNh.bnN();
        if (this.fAX == null) {
            this.fAX = new c(getPageContext().getContext(), getNetRefreshListener());
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
        this.fAX.attachView(this.fNh.aYe(), true);
        registerListener(this.fzb);
    }

    private void aJN() {
        this.fNh.ks(true);
        this.fNh.bpa().setEnabled(true);
        if (this.fAX != null && this.fAX.isViewAttached()) {
            this.fAX.dettachView(this.fNh.aYe());
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
        this.fNf.nh(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eZc = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eZc = System.currentTimeMillis();
        }
        this.mForumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.cAQ = this.beginTime - this.eZc;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cpt().u(getUniqueId());
        this.fNf = new FrsGoodModelController(this);
        if (arguments != null) {
            this.fNf.K(arguments);
            this.fNe = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.fNf.K(bundle);
            this.fNe = bundle.getBoolean("is_game_frs", false);
        } else {
            this.fNf.K(null);
        }
        this.fwa = getVoiceManager();
        this.fwa.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bDW);
        registerListener(this.fNm);
        registerListener(this.fxf);
        registerListener(this.fxE);
        this.fNg = new FrsLoadMoreModel(this, null);
        this.fNg.registerListener();
        this.fNg.setPageType(2);
        this.fNg.kL(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fNh = new a(this, inflate, this.fNe);
        this.fNh.brF().kK(this.fNj);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eNo) {
            if (j.kc()) {
                kI(false);
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
        this.fwa = getVoiceManager();
        this.fwa.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bry();
        if (bundle != null) {
            this.fvT = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fNj = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.fvT = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.fNj = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bry() {
        registerListener(2001118, this.cjl);
    }

    public FrsLoadMoreModel brz() {
        return this.fNg;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fNh != null) {
            this.fNh.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fzb);
        com.baidu.tieba.q.c.cpt().v(getUniqueId());
        t.bat().iH(false);
        super.onDestroy();
        this.fNf.aGu();
        this.fwa = getVoiceManager();
        this.fwa.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fNl);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.fvT);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.fNe);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fNj);
        this.fNf.onSaveInstanceState(bundle);
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
                    this.fNh.brF().notifyDataSetChanged();
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
                            this.fNh.brD();
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
        if (this.fNh != null) {
            this.fNh.bnN();
        }
        this.fwa = getVoiceManager();
        this.fwa.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fNi = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.fNh.setOnAdapterItemClickListener(this.fxA);
        this.fNh.setOnScrollListener(this.mScrollListener);
        this.fNh.setListPullRefreshListener(this.dvZ);
        this.fNh.a(this.cbD);
        this.fNh.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.fNi != null) {
                    FrsGoodFragment.this.fNi.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fDK != 3 || this.fNh != null) {
            this.fDK = i;
            super.onChangeSkinType(i);
            if (this.fNh != null) {
                this.fNh.onChangeSkinType(i);
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
                com.baidu.adp.lib.g.h.iL().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Fs(FrsGoodFragment.this.fvT);
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
                this.fNh.aWv();
                this.fvT = this.fvE.getForum().getName();
                this.forumId = this.fvE.getForum().getId();
                if (this.fvE != null && this.fvE.getForum() != null) {
                    this.fNh.a(this.fvE.getForum().getThemeColorInfo());
                    this.fNh.c(this.fvE);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.fvE.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fvE.getUserData().getBimg_end_time());
                bna();
                if (!this.fNh.brF().n(bh.bKb)) {
                    this.fvE.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.fvE.getThreadList();
                if (threadList != null) {
                    this.fNh.a(threadList, this.mPn, this.fvE, this.fvE.getPage().adw());
                    brA();
                    this.fNh.brD();
                    if (this.fvE.getIsNewUrl() == 1) {
                        this.fNh.brF().setFromCDN(true);
                    } else {
                        this.fNh.brF().setFromCDN(false);
                    }
                    this.fNh.setListViewSelection(bC(brB().getType(), this.mPn));
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
            this.fNh.brF().b(threadList, this.fvE);
            this.fNh.brF().notifyDataSetChanged();
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
        if (this.fNh == null) {
            return null;
        }
        return this.fNh.getListView();
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
        if (this.fvE != null && this.fNh != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fNh.bnN();
            }
        }
    }

    private void brA() {
        HashMap<Integer, bh> bpT;
        if (this.fNh != null && this.fNh.brF() != null && (bpT = this.fNh.brF().bpT()) != null) {
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
        if (j.kc()) {
            kI(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bnj() {
        return this.fvE;
    }

    public FrsGoodModelController brB() {
        return this.fNf;
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

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.kt()) {
            this.fNh.aKQ();
        } else if (!this.fNf.brK()) {
            this.fNh.aKQ();
        } else {
            aJK();
            if (!this.fNg.isLoading && !this.fNf.pQ()) {
                if (this.fNg.ci(this.fvE.getThreadListIds())) {
                    this.fNh.a(this.fNg.brV(), this.mPn, this.fvE, 0);
                    this.fNg.a(com.baidu.adp.lib.g.b.e(this.forumId, 0L), this.fvE.getThreadListIds(), this.fvT, this.mPn, this.fvE.isBrandForum);
                } else if (this.eiz != 0) {
                    this.fNh.a(this.fNg.brV(), this.mPn, this.fvE, 0);
                    this.mPn++;
                    this.fNf.sB(this.mPn);
                    this.fNg.loadingDone = false;
                    this.fNg.loadIndex = 0;
                }
            }
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.fNg.a(false, false, false, arrayList, (f) null)) != null) {
            this.fvE.setThreadList(a);
            this.fNh.a(a, this.mPn, this.fvE, 0);
        }
    }

    private void aJK() {
        if (this.eiz == 0 && !this.fNg.ci(this.fvE.getThreadListIds())) {
            if (this.fvE.getThreadList() == null || this.fvE.getThreadList().size() == 0) {
                this.fNh.aKQ();
                return;
            } else {
                this.fNh.aKP();
                return;
            }
        }
        this.fNh.aKO();
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
        if (this.fNf != null) {
            this.fNf.bnd();
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void sA(int i) {
        this.mTabId = i;
        if (j.kc()) {
            kI(false);
        } else {
            c((e.b) null);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bms() {
        if (this.fNh != null && this.fNh.getListView() != null) {
            this.fNh.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKN() {
        if (this.fNh != null) {
            bms();
            this.fNh.startPullRefresh();
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
