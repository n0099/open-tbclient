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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
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
    private String fFC;
    private FrsLoadMoreModel fFF;
    private FrsNewAreaModelController fHY;
    private VoiceManager foP;
    private com.baidu.tbadk.m.c ftP;
    private String foI = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData fot = new FrsViewData();
    public long eSm = -1;
    public long cyx = 0;
    public long cyF = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fpb = false;
    protected g fHZ = null;
    private int ecm = -1;
    private int fwn = 3;
    private boolean eGC = false;
    public boolean fFI = false;
    private boolean fFJ = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fpo = new SparseArray<>();
    private CustomMessageListener frS = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.ftP != null && FrsNewAreaFragment.this.ftP.isViewAttached()) {
                FrsNewAreaFragment.this.ftP.kB(num.intValue());
            }
        }
    };
    private Runnable fFK = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.jS() || FrsNewAreaFragment.this.eGC) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.kv(false);
            }
        }
    };
    private CustomMessageListener fFL = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                FrsNewAreaFragment.this.fFC = bgVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.fFC) && bgVar.adh() != null) {
                    FrsNewAreaFragment.this.sb(bgVar.adh().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fpV = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.ajY() != null) {
                        FrsNewAreaFragment.this.ajY().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.ftP != null && FrsNewAreaFragment.this.ftP.isViewAttached()) {
                        FrsNewAreaFragment.this.kv(false);
                    } else if (FrsNewAreaFragment.this.fHZ != null) {
                        FrsNewAreaFragment.this.fHZ.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n fqk = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long fFO = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void ra(int i) {
            if (!FrsNewAreaFragment.this.fFJ) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.fHZ.bkQ();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.fHZ.fY(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.fFJ) {
                if (FrsNewAreaFragment.this.bpr().boJ() == null) {
                    FrsNewAreaFragment.this.fFJ = false;
                    return;
                } else if (FrsNewAreaFragment.this.bpr().boJ().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.fFJ = false;
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
                FrsNewAreaFragment.this.fFF.resetData();
            }
            FrsNewAreaFragment.this.fHZ.fY(false);
            if (FrsNewAreaFragment.this.bpr().boJ() != null) {
                FrsNewAreaFragment.this.fot = FrsNewAreaFragment.this.bpr().boJ();
            }
            FrsNewAreaFragment.this.ecm = FrsNewAreaFragment.this.fot.getPage().acp();
            if (FrsNewAreaFragment.this.ecm == 0 && (FrsNewAreaFragment.this.fot.getThreadListIds() == null || FrsNewAreaFragment.this.fot.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.fot.getThreadList() == null || FrsNewAreaFragment.this.fot.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.fHZ.aIJ();
                } else {
                    FrsNewAreaFragment.this.fHZ.aII();
                }
            } else {
                FrsNewAreaFragment.this.fHZ.aIH();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.fFF.a(false, false, false, FrsNewAreaFragment.this.fot.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.fot.setThreadList(a2);
                    FrsNewAreaFragment.this.fHZ.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.fot, FrsNewAreaFragment.this.ecm);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.fHZ.bkQ();
                    break;
                case 2:
                    FrsNewAreaFragment.this.fHZ.bkQ();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.fot.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.fFO != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.fot != null) {
                    FrsNewAreaFragment.this.foI = FrsNewAreaFragment.this.fot.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.fot.getForum().getId();
                    FrsNewAreaFragment.this.fHZ.b(FrsNewAreaFragment.this.fot.getForum(), FrsNewAreaFragment.this.fot.getUserData());
                }
                if (FrsNewAreaFragment.this.fot != null) {
                    FrsNewAreaFragment.this.fot.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.fot == null || FrsNewAreaFragment.this.fot.getThreadList() == null || FrsNewAreaFragment.this.fot.getThreadList().size() != 0 || FrsNewAreaFragment.this.bpr().getType() != 4) {
                    if (FrsNewAreaFragment.this.fot != null && (a = FrsNewAreaFragment.this.fFF.a(false, false, true, FrsNewAreaFragment.this.fot.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.fot.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bke();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.eSm > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsNewAreaFragment.this.eSm, FrsNewAreaFragment.this.bpr().bej() - FrsNewAreaFragment.this.eSm, FrsNewAreaFragment.this.bpr().beh(), FrsNewAreaFragment.this.bpr().bei(), currentTimeMillis2 - FrsNewAreaFragment.this.bpr().beg());
                        FrsNewAreaFragment.this.eSm = -1L;
                    }
                    FrsNewAreaFragment.this.cyF = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.eSm > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsNewAreaFragment.this.eSm, FrsNewAreaFragment.this.bpr().bej() - FrsNewAreaFragment.this.eSm, FrsNewAreaFragment.this.bpr().beh(), FrsNewAreaFragment.this.bpr().bei(), currentTimeMillis3 - FrsNewAreaFragment.this.bpr().beg());
                FrsNewAreaFragment.this.eSm = -1L;
            }
            FrsNewAreaFragment.this.cyF = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
        }
    };
    private final CustomMessageListener bCB = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.fHZ != null) {
                FrsNewAreaFragment.this.fHZ.startPullRefresh();
            }
        }
    };
    private final h.c drY = new h.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.jS()) {
                com.baidu.tieba.a.d.aBq().rT("page_frs_good");
                FrsNewAreaFragment.this.kv(true);
                return;
            }
            FrsNewAreaFragment.this.fHZ.fY(false);
        }
    };
    private final h.b bZC = new h.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.clw().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.fpb) {
                FrsNewAreaFragment.this.fpb = true;
                FrsNewAreaFragment.this.fHZ.blf();
            }
            if (i == 0) {
                t.aXP().iv(true);
                com.baidu.tieba.q.c.clw().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener chd = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
    private s fqq = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bf)) {
                bg bgVar = ((bf) mVar).threadData;
                if (bgVar.aen() == null || bgVar.aen().getGroup_id() == 0 || bc.cE(FrsNewAreaFragment.this.getActivity())) {
                    if (bgVar.aef() != 1 || bc.cE(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Ek(bgVar.getId())) {
                            readThreadHistory.Ej(bgVar.getId());
                            if (FrsNewAreaFragment.this.fHZ != null) {
                                FrsNewAreaFragment.this.fHZ.bkQ();
                            }
                        }
                        boolean z = false;
                        final String adC = bgVar.adC();
                        if (adC != null && !adC.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5.1
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
                            ba.aiz().c(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bgVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bgVar, FrsNewAreaFragment.this.foI, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsNewAreaFragment.this.fFI ? 15 : 3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.fot != null && FrsNewAreaFragment.this.fot.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fJF = FrsNewAreaFragment.this.fot.needLog == 1;
                            bVar.fJH = FrsNewAreaFragment.this.fot.getForum().getId();
                            bVar.fJG = FrsNewAreaFragment.this.fHY.bpl();
                            if (com.baidu.tieba.frs.d.d.fxl != null) {
                                bVar.fJI = com.baidu.tieba.frs.d.d.fxl.fJI;
                                bVar.fJJ = com.baidu.tieba.frs.d.d.fxl.fJJ;
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
            this.fHY.ac(bgVar);
            this.fHZ.bjy();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.fot = frsViewData;
            hideLoadingView(this.fHZ.bld());
            if (this.fHZ != null) {
                this.fHZ.fY(false);
                this.fHZ.a(null, this.mPn, this.fot, this.ecm);
            }
        }
    }

    private void showLoadingView() {
        this.fHZ.kf(false);
        showLoadingView(this.fHZ.bld(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fHZ.kf(true);
        hideLoadingView(this.fHZ.bld());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fHZ.kf(false);
        this.fHZ.bmd().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fHZ.aIJ();
        this.fHZ.getListView().getData().clear();
        this.fHZ.bkQ();
        if (this.ftP == null) {
            this.ftP = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.ftP.setTitle(null);
            this.ftP.setButtonText(null);
            this.ftP.asB();
            this.ftP.asC().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.ftP.qw(getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.ftP.qw(null);
        }
        this.ftP.onChangeSkinType();
        this.ftP.attachView(this.fHZ.bld(), true);
        registerListener(this.frS);
    }

    private void aHK() {
        this.fHZ.kf(true);
        this.fHZ.bmd().setEnabled(true);
        if (this.ftP != null && this.ftP.isViewAttached()) {
            this.ftP.dettachView(this.fHZ.bld());
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
        this.fHY.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eSm = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eSm = System.currentTimeMillis();
        }
        this.forumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.cyx = this.beginTime - this.eSm;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.clw().u(getUniqueId());
        this.fHY = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.fHY.K(arguments);
        } else if (bundle != null) {
            this.fHY.K(bundle);
        } else {
            this.fHY.K(null);
        }
        this.foP = getVoiceManager();
        this.foP.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bCB);
        registerListener(this.fFL);
        registerListener(this.fpV);
        this.fFF = new FrsLoadMoreModel(this, null);
        this.fFF.registerListener();
        this.fFF.setPageType(3);
        this.fFF.ky(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fHZ = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eGC) {
            if (com.baidu.adp.lib.util.j.jS()) {
                kv(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        aif();
    }

    private void aif() {
        am amVar = new am("c13008");
        amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.bT("fid", this.forumId);
        amVar.P("obj_type", 6);
        amVar.P("obj_locate", 2);
        amVar.aif();
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
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.foI = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void boz() {
        registerListener(2001118, this.chd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fHZ != null) {
            this.fHZ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.frS);
        com.baidu.tieba.q.c.clw().v(getUniqueId());
        t.aXP().iv(false);
        super.onDestroy();
        this.fHY.onActivityDestroy();
        this.foP = getVoiceManager();
        this.foP.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fFK);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.foI);
        bundle.putString("from", this.mFrom);
        this.fHY.onSaveInstanceState(bundle);
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
                    this.fHZ.bpt().notifyDataSetChanged();
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
                            this.fHZ.boE();
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
        if (this.fHZ != null) {
            this.fHZ.bkQ();
        }
        this.foP = getVoiceManager();
        this.foP.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fHZ.setOnAdapterItemClickListener(this.fqq);
        this.fHZ.setOnScrollListener(this.mScrollListener);
        this.fHZ.setListPullRefreshListener(this.drY);
        this.fHZ.a(this.bZC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fwn != 3 || this.fHZ != null) {
            this.fwn = i;
            super.onChangeSkinType(i);
            if (this.fHZ != null) {
                this.fHZ.onChangeSkinType(i);
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
                com.baidu.adp.lib.g.h.iC().d(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Ee(FrsNewAreaFragment.this.foI);
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
                this.fHZ.aUH();
                this.foI = this.fot.getForum().getName();
                this.forumId = this.fot.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.fot.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fot.getUserData().getBimg_end_time());
                bkd();
                ArrayList<m> threadList = this.fot.getThreadList();
                if (threadList != null) {
                    this.fHZ.a(threadList, this.mPn, this.fot, this.fot.getPage().acp());
                    boB();
                    this.fHZ.boE();
                    if (this.fot.getIsNewUrl() == 1) {
                        this.fHZ.bpt().setFromCDN(true);
                    } else {
                        this.fHZ.bpt().setFromCDN(false);
                    }
                    this.fHZ.setListViewSelection(bx(bpr().getType(), this.mPn));
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
        com.baidu.tieba.q.c.clw().b(getUniqueId(), false);
        if (this.fot != null && this.fot.getForum() != null) {
            com.baidu.tbadk.distribute.a.aqF().a(getPageContext().getPageActivity(), "frs", this.fot.getForum().getId(), 0L);
        }
        this.foP = getVoiceManager();
        if (this.foP != null) {
            this.foP.onStop(getPageContext());
        }
    }

    public void bmy() {
        if (this.fHZ != null) {
            this.fHZ.refreshView();
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
            this.fHZ.bpt().b(threadList, this.fot);
            this.fHZ.bpt().notifyDataSetChanged();
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
        if (this.fHZ == null) {
            return null;
        }
        return this.fHZ.getListView();
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
        if (this.fot != null && this.fHZ != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fHZ.bkQ();
            }
        }
    }

    private void boB() {
        HashMap<Integer, bg> bmU;
        if (this.fHZ != null && this.fHZ.bpt() != null && (bmU = this.fHZ.bpt().bmU()) != null) {
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
        if (com.baidu.adp.lib.util.j.jS()) {
            kv(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bkm() {
        return this.fot;
    }

    public FrsNewAreaModelController bpr() {
        return this.fHY;
    }

    public void wN(String str) {
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

    public void aHt() {
        if (!this.fFF.isLoading && !this.fHY.pu()) {
            if (this.fFF.ci(this.fot.getThreadListIds())) {
                this.fHZ.a(this.fFF.boW(), this.mPn, this.fot, 0);
                this.fFF.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.fot.getThreadListIds(), this.foI, this.mPn, this.fot.isBrandForum);
            } else if (this.ecm != 0) {
                this.fHZ.a(this.fFF.boW(), this.mPn, this.fot, 0);
                this.mPn++;
                this.fHY.sd(this.mPn);
                this.fFF.loadingDone = false;
                this.fFF.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.ki()) {
            this.fHZ.aIJ();
        } else if (!this.fHZ.bkY()) {
            if (!this.fHY.boL()) {
                this.fHZ.aIJ();
                return;
            }
            aHH();
            aHt();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void vX(String str) {
        aHH();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void V(ArrayList<m> arrayList) {
        ArrayList<m> a;
        aHH();
        if (arrayList != null && arrayList.size() != 0 && (a = this.fFF.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.fot.setThreadList(a);
            this.fHZ.a(a, this.mPn, this.fot, 0);
        }
    }

    public void cj(List<String> list) {
        bX(list);
        int i = 0;
        Iterator<m> it = this.fot.getThreadList().iterator();
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
            aHt();
        }
    }

    private void bX(List<String> list) {
        if (!v.aa(list)) {
            ArrayList<m> threadList = this.fot.getThreadList();
            if (!v.aa(threadList) && this.fHZ.getListView() != null && this.fHZ.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.fHZ.getListView().getData();
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
                                this.fFF.e(next);
                                this.fHZ.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel boA() {
        return this.fFF;
    }

    private void aHH() {
        if (this.ecm == 0 && !this.fFF.ci(this.fot.getThreadListIds())) {
            if (this.fot.getThreadList() == null || this.fot.getThreadList().size() == 0) {
                this.fHZ.aIJ();
                return;
            } else {
                this.fHZ.aII();
                return;
            }
        }
        this.fHZ.aIH();
    }

    public g bps() {
        return this.fHZ;
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
        if (this.fHY != null) {
            this.fHY.bkg();
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

    @Override // com.baidu.tieba.frs.ag
    public void bjy() {
        if (this.fHZ != null && this.fHZ.getListView() != null) {
            this.fHZ.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aIG() {
        if (this.fHZ != null) {
            bjy();
            this.fHZ.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.fpo.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a lX(int i) {
        return this.fpo.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }
}
