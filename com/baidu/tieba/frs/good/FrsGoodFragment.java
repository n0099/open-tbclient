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
import com.baidu.tbadk.core.util.am;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0041a, UserIconBox.b, VoiceManager.c, ag, ah, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String fFC;
    private FrsGoodModelController fFE;
    private FrsLoadMoreModel fFF;
    private com.baidu.tieba.frs.gametab.b fFH;
    private VoiceManager foP;
    private c ftP;
    private String mForumId;
    private String foI = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean fFD = false;
    private String forumId = null;
    private FrsViewData fot = new FrsViewData();
    public long eSm = -1;
    public long cyw = 0;
    public long cyE = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fpb = false;
    protected a fFG = null;
    private int ecm = -1;
    private int mTabId = 0;
    private int fwn = 3;
    private boolean eGC = false;
    public boolean fFI = false;
    private boolean fFJ = false;
    private CustomMessageListener frS = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.ftP != null && FrsGoodFragment.this.ftP.isViewAttached()) {
                FrsGoodFragment.this.ftP.kB(num.intValue());
            }
        }
    };
    private Runnable fFK = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // java.lang.Runnable
        public void run() {
            if (!j.jS() || FrsGoodFragment.this.eGC) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.kv(false);
            }
        }
    };
    private CustomMessageListener fFL = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                FrsGoodFragment.this.fFC = bgVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.fFC) && bgVar.adh() != null) {
                    FrsGoodFragment.this.sb(bgVar.adh().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fpV = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.ajY() != null) {
                            FrsGoodFragment.this.ajY().setSelection(0);
                        }
                        if (FrsGoodFragment.this.ftP != null && FrsGoodFragment.this.ftP.isViewAttached()) {
                            FrsGoodFragment.this.kv(false);
                        } else if (FrsGoodFragment.this.fFG != null) {
                            FrsGoodFragment.this.fFG.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n fqk = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        private long fFO = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void ra(int i) {
            if (!FrsGoodFragment.this.fFJ) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.fFG.bkQ();
                        return;
                    case 3:
                        FrsGoodFragment.this.fFG.fY(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.fFJ) {
                if (FrsGoodFragment.this.boB().boI() == null) {
                    FrsGoodFragment.this.fFJ = false;
                    return;
                } else if (FrsGoodFragment.this.boB().boI().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.fFJ = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.fFO = 1L;
            } else if (bVar.isSuccess) {
                this.fFO = 0L;
            } else {
                this.fFO = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.fFF.resetData();
            }
            FrsGoodFragment.this.fFG.fY(false);
            if (FrsGoodFragment.this.boB().boI() != null) {
                FrsGoodFragment.this.fot = FrsGoodFragment.this.boB().boI();
            }
            FrsGoodFragment.this.ecm = FrsGoodFragment.this.fot.getPage().acp();
            if (FrsGoodFragment.this.ecm == 0 && (FrsGoodFragment.this.fot.getThreadListIds() == null || FrsGoodFragment.this.fot.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.fot.getThreadList() == null || FrsGoodFragment.this.fot.getThreadList().size() == 0) {
                    FrsGoodFragment.this.fFG.aIJ();
                } else {
                    FrsGoodFragment.this.fFG.aII();
                }
            } else {
                FrsGoodFragment.this.fFG.aIH();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.fFF.a(false, false, false, FrsGoodFragment.this.fot.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.fot.setThreadList(a2);
                    FrsGoodFragment.this.fFG.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.fot, FrsGoodFragment.this.ecm);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.fFG.bkQ();
                    break;
                case 2:
                    FrsGoodFragment.this.fFG.bkQ();
                    break;
                case 3:
                    if (FrsGoodFragment.this.fot.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.fFO != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.fot != null) {
                    FrsGoodFragment.this.foI = FrsGoodFragment.this.fot.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.fot.getForum().getId();
                    FrsGoodFragment.this.fFG.b(FrsGoodFragment.this.fot.getForum(), FrsGoodFragment.this.fot.getUserData());
                }
                if (FrsGoodFragment.this.fot != null) {
                    FrsGoodFragment.this.fot.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.fFG.c(FrsGoodFragment.this.fot);
                if (FrsGoodFragment.this.fot == null || FrsGoodFragment.this.fot.getThreadList() == null || FrsGoodFragment.this.fot.getThreadList().size() != 0 || FrsGoodFragment.this.boB().getType() != 4) {
                    if (FrsGoodFragment.this.fot != null && (a = FrsGoodFragment.this.fFF.a(false, false, true, FrsGoodFragment.this.fot.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.fot.setThreadList(a);
                    }
                    FrsGoodFragment.this.bke();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.eSm > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.eSm, FrsGoodFragment.this.boB().bej() - FrsGoodFragment.this.eSm, FrsGoodFragment.this.boB().beh(), FrsGoodFragment.this.boB().bei(), currentTimeMillis2 - FrsGoodFragment.this.boB().beg());
                        FrsGoodFragment.this.eSm = -1L;
                    }
                    FrsGoodFragment.this.cyE = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.eSm > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.eSm, FrsGoodFragment.this.boB().bej() - FrsGoodFragment.this.eSm, FrsGoodFragment.this.boB().beh(), FrsGoodFragment.this.boB().bei(), currentTimeMillis3 - FrsGoodFragment.this.boB().beg());
                FrsGoodFragment.this.eSm = -1L;
            }
            FrsGoodFragment.this.cyE = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
        }
    };
    private final CustomMessageListener bCA = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.fFG != null) {
                FrsGoodFragment.this.fFG.startPullRefresh();
            }
        }
    };
    private final h.c drY = new h.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.jS()) {
                d.aBq().rU("page_frs_good");
                FrsGoodFragment.this.kv(true);
                return;
            }
            FrsGoodFragment.this.fFG.fY(false);
        }
    };
    private final h.b bZB = new h.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.clv().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.fpb) {
                FrsGoodFragment.this.fpb = true;
                FrsGoodFragment.this.fFG.blf();
            }
            if (i == 0) {
                t.aXP().iv(true);
                com.baidu.tieba.q.c.clv().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener chc = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
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
    private s fqq = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bf)) {
                bg bgVar = ((bf) mVar).threadData;
                if (bgVar.aen() == null || bgVar.aen().getGroup_id() == 0 || bc.cE(FrsGoodFragment.this.getActivity())) {
                    if (bgVar.aef() != 1 || bc.cE(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Ei(bgVar.getId())) {
                            readThreadHistory.Eh(bgVar.getId());
                            if (FrsGoodFragment.this.fFG != null) {
                                FrsGoodFragment.this.fFG.bkQ();
                            }
                        }
                        boolean z = false;
                        final String adC = bgVar.adC();
                        if (adC != null && !adC.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(adC);
                                    xVar.ahC().aiB().mIsNeedAddCommenParam = false;
                                    xVar.ahC().aiB().mIsUseCurrentBDUSS = false;
                                    xVar.ahf();
                                }
                            }).start();
                        }
                        String tid = bgVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bgVar.adq() == 2 && !tid.startsWith("pb:")) {
                            ba.aiz().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bgVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bgVar, FrsGoodFragment.this.foI, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.fFI ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsGoodFragment.this.fot != null && FrsGoodFragment.this.fot.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fJD = FrsGoodFragment.this.fot.needLog == 1;
                            bVar.fJF = FrsGoodFragment.this.fot.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.fxl != null) {
                                bVar.fJG = com.baidu.tieba.frs.d.d.fxl.fJG;
                                bVar.fJH = com.baidu.tieba.frs.d.d.fxl.fJH;
                            }
                            com.baidu.tieba.frs.d.a.a(bgVar, 1, FrsGoodFragment.this.getUniqueId(), bVar);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fqu = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.fFG != null) {
                FrsGoodFragment.this.fFG.bln();
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
        this.fFG.kf(false);
        showLoadingView(this.fFG.bld(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fFG.kf(true);
        hideLoadingView(this.fFG.bld());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fFG.kf(false);
        this.fFG.bmd().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fFG.aIJ();
        this.fFG.getListView().getData().clear();
        this.fFG.bkQ();
        if (this.ftP == null) {
            this.ftP = new c(getPageContext().getContext(), getNetRefreshListener());
            this.ftP.setTitle(null);
            this.ftP.setButtonText(null);
            this.ftP.asB();
            this.ftP.asC().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.ftP.qx(getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.ftP.qx(null);
        }
        this.ftP.onChangeSkinType();
        this.ftP.attachView(this.fFG.bld(), true);
        registerListener(this.frS);
    }

    private void aHK() {
        this.fFG.kf(true);
        this.fFG.bmd().setEnabled(true);
        if (this.ftP != null && this.ftP.isViewAttached()) {
            this.ftP.dettachView(this.fFG.bld());
        }
        MessageManager.getInstance().unRegisterListener(this.frS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kv(boolean z) {
        this.eGC = true;
        bkh();
        aHK();
        if (!z) {
            aHK();
            showLoadingView();
        }
        this.fFE.mV(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eSm = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eSm = System.currentTimeMillis();
        }
        this.mForumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.cyw = this.beginTime - this.eSm;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.clv().u(getUniqueId());
        this.fFE = new FrsGoodModelController(this);
        if (arguments != null) {
            this.fFE.K(arguments);
            this.fFD = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.fFE.K(bundle);
            this.fFD = bundle.getBoolean("is_game_frs", false);
        } else {
            this.fFE.K(null);
        }
        this.foP = getVoiceManager();
        this.foP.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bCA);
        registerListener(this.fFL);
        registerListener(this.fpV);
        registerListener(this.fqu);
        this.fFF = new FrsLoadMoreModel(this, null);
        this.fFF.registerListener();
        this.fFF.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fFG = new a(this, inflate, this.fFD);
        this.fFG.boF().kx(this.fFI);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eGC) {
            if (j.jS()) {
                kv(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new am("c13008").bT("fid", this.mForumId).bT("obj_type", "7").P("obj_locate", 2).bT("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.foP = getVoiceManager();
        this.foP.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        boz();
        if (bundle != null) {
            this.foI = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fFI = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.foI = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.fFI = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void boz() {
        registerListener(2001118, this.chc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fFG != null) {
            this.fFG.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.frS);
        com.baidu.tieba.q.c.clv().v(getUniqueId());
        t.aXP().iv(false);
        super.onDestroy();
        this.fFE.onActivityDestroy();
        this.foP = getVoiceManager();
        this.foP.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fFK);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.foI);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.fFD);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fFI);
        this.fFE.onSaveInstanceState(bundle);
        this.foP = getVoiceManager();
        if (this.foP != null) {
            this.foP.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bg threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.fFG.boF().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.fot.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.hf(intent.getIntExtra("good_data", 0));
                            threadDataById.ael();
                            kv(false);
                            return;
                        } else if (intExtra == 0) {
                            this.fot.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.fot.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.m());
                            }
                            this.fFG.boD();
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
            if (this.fwn == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.eGC) {
                com.baidu.adp.lib.g.e.iB().post(this.fFK);
            }
        }
        blU();
    }

    private void blU() {
        if (isPrimary()) {
            if (this.ftP != null && this.ftP.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.frS);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.frS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fFG != null) {
            this.fFG.bkQ();
        }
        this.foP = getVoiceManager();
        this.foP.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fFH = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.fFG.setOnAdapterItemClickListener(this.fqq);
        this.fFG.setOnScrollListener(this.mScrollListener);
        this.fFG.setListPullRefreshListener(this.drY);
        this.fFG.a(this.bZB);
        this.fFG.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.fFH != null) {
                    FrsGoodFragment.this.fFH.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fwn != 3 || this.fFG != null) {
            this.fwn = i;
            super.onChangeSkinType(i);
            if (this.fFG != null) {
                this.fFG.onChangeSkinType(i);
            }
            if (this.ftP != null && this.ftP.isViewAttached()) {
                this.ftP.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bjk() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bjk();
        }
        return null;
    }

    private void bkd() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.iC().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Ec(FrsGoodFragment.this.foI);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bke() {
        bkh();
        try {
            if (this.fot != null) {
                this.fFG.aUH();
                this.foI = this.fot.getForum().getName();
                this.forumId = this.fot.getForum().getId();
                if (this.fot != null && this.fot.getForum() != null) {
                    this.fFG.a(this.fot.getForum().getThemeColorInfo());
                    this.fFG.c(this.fot);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.fot.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fot.getUserData().getBimg_end_time());
                bkd();
                if (!this.fFG.boF().m(bg.bIx)) {
                    this.fot.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.fot.getThreadList();
                if (threadList != null) {
                    this.fFG.a(threadList, this.mPn, this.fot, this.fot.getPage().acp());
                    boA();
                    this.fFG.boD();
                    if (this.fot.getIsNewUrl() == 1) {
                        this.fFG.boF().setFromCDN(true);
                    } else {
                        this.fFG.boF().setFromCDN(false);
                    }
                    this.fFG.setListViewSelection(bx(boB().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int bx(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.foP = getVoiceManager();
        this.foP.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.aXP().iv(false);
        com.baidu.tieba.q.c.clv().b(getUniqueId(), false);
        if (this.fot != null && this.fot.getForum() != null) {
            com.baidu.tbadk.distribute.a.aqF().a(getPageContext().getPageActivity(), "frs", this.fot.getForum().getId(), 0L);
        }
        this.foP = getVoiceManager();
        if (this.foP != null) {
            this.foP.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb(int i) {
        ArrayList<m> threadList = this.fot.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bf) {
                    bg bgVar = ((bf) next).threadData;
                    if (bgVar.getId() != null && bgVar.getId().equals(this.fFC)) {
                        c(bgVar, i);
                        this.fFC = null;
                        break;
                    }
                }
            }
            this.fFG.boF().b(threadList, this.fot);
            this.fFG.boF().notifyDataSetChanged();
        }
    }

    private void c(bg bgVar, int i) {
        if (i == 1) {
            PraiseData adh = bgVar.adh();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (adh == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bgVar.a(praiseData);
                    return;
                }
                bgVar.adh().getUser().add(0, metaData);
                bgVar.adh().setNum(bgVar.adh().getNum() + 1);
                bgVar.adh().setIsLike(i);
            }
        } else if (bgVar.adh() != null) {
            bgVar.adh().setIsLike(i);
            bgVar.adh().setNum(bgVar.adh().getNum() - 1);
            ArrayList<MetaData> user = bgVar.adh().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bgVar.adh().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.foP == null) {
            this.foP = VoiceManager.instance();
        }
        return this.foP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView ajY() {
        if (this.fFG == null) {
            return null;
        }
        return this.fFG.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bkh() {
        this.foP = getVoiceManager();
        this.foP.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> ajZ() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).ajZ();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.fot != null && this.fFG != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fFG.bkQ();
            }
        }
    }

    private void boA() {
        HashMap<Integer, bg> bmU;
        if (this.fFG != null && this.fFG.boF() != null && (bmU = this.fFG.boF().bmU()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bg> entry : bmU.entrySet()) {
                bg value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.aqK().x(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        if (ajY() == null) {
            return null;
        }
        return ajY().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jS()) {
            kv(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bkm() {
        return this.fot;
    }

    public FrsGoodModelController boB() {
        return this.fFE;
    }

    public void wO(String str) {
        this.foI = str;
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
        if (!l.ki()) {
            this.fFG.aIJ();
        } else if (!this.fFE.boK()) {
            this.fFG.aIJ();
        } else {
            aHH();
            if (!this.fFF.isLoading && !this.fFE.pu()) {
                if (this.fFF.ci(this.fot.getThreadListIds())) {
                    this.fFG.a(this.fFF.boU(), this.mPn, this.fot, 0);
                    this.fFF.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.fot.getThreadListIds(), this.foI, this.mPn, this.fot.isBrandForum);
                } else if (this.ecm != 0) {
                    this.fFG.a(this.fFF.boU(), this.mPn, this.fot, 0);
                    this.mPn++;
                    this.fFE.sd(this.mPn);
                    this.fFF.loadingDone = false;
                    this.fFF.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void vY(String str) {
        aHH();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void V(ArrayList<m> arrayList) {
        ArrayList<m> a;
        aHH();
        if (arrayList != null && arrayList.size() != 0 && (a = this.fFF.a(false, false, false, arrayList, (f) null)) != null) {
            this.fot.setThreadList(a);
            this.fFG.a(a, this.mPn, this.fot, 0);
        }
    }

    private void aHH() {
        if (this.ecm == 0 && !this.fFF.ci(this.fot.getThreadListIds())) {
            if (this.fot.getThreadList() == null || this.fot.getThreadList().size() == 0) {
                this.fFG.aIJ();
                return;
            } else {
                this.fFG.aII();
                return;
            }
        }
        this.fFG.aIH();
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0041a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.cx(getActivity().getApplicationContext())) {
                ak.c(getPageContext());
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
        com.baidu.tbadk.distribute.a.aqF().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bkg() {
        if (this.fFE != null) {
            this.fFE.bkg();
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
    public NavigationBar aJC() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.foI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sc(int i) {
        this.mTabId = i;
        if (j.jS()) {
            kv(false);
        } else {
            c((e.b) null);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjy() {
        if (this.fFG != null && this.fFG.getListView() != null) {
            this.fFG.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aIG() {
        if (this.fFG != null) {
            bjy();
            this.fFG.startPullRefresh();
        }
    }
}
