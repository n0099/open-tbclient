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
    private String fFB;
    private FrsGoodModelController fFD;
    private FrsLoadMoreModel fFE;
    private com.baidu.tieba.frs.gametab.b fFG;
    private VoiceManager foO;
    private c ftO;
    private String mForumId;
    private String foH = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean fFC = false;
    private String forumId = null;
    private FrsViewData fos = new FrsViewData();
    public long eSl = -1;
    public long cyw = 0;
    public long cyE = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fpa = false;
    protected a fFF = null;
    private int ecl = -1;
    private int mTabId = 0;
    private int fwm = 3;
    private boolean eGB = false;
    public boolean fFH = false;
    private boolean fFI = false;
    private CustomMessageListener frR = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.ftO != null && FrsGoodFragment.this.ftO.isViewAttached()) {
                FrsGoodFragment.this.ftO.kB(num.intValue());
            }
        }
    };
    private Runnable fFJ = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // java.lang.Runnable
        public void run() {
            if (!j.jS() || FrsGoodFragment.this.eGB) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.kv(false);
            }
        }
    };
    private CustomMessageListener fFK = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                FrsGoodFragment.this.fFB = bgVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.fFB) && bgVar.adh() != null) {
                    FrsGoodFragment.this.sb(bgVar.adh().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fpU = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
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
                        if (FrsGoodFragment.this.ftO != null && FrsGoodFragment.this.ftO.isViewAttached()) {
                            FrsGoodFragment.this.kv(false);
                        } else if (FrsGoodFragment.this.fFF != null) {
                            FrsGoodFragment.this.fFF.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n fqj = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        private long fFN = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void ra(int i) {
            if (!FrsGoodFragment.this.fFI) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.fFF.bkN();
                        return;
                    case 3:
                        FrsGoodFragment.this.fFF.fY(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.fFI) {
                if (FrsGoodFragment.this.boy().boF() == null) {
                    FrsGoodFragment.this.fFI = false;
                    return;
                } else if (FrsGoodFragment.this.boy().boF().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.fFI = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.fFN = 1L;
            } else if (bVar.isSuccess) {
                this.fFN = 0L;
            } else {
                this.fFN = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.fFE.resetData();
            }
            FrsGoodFragment.this.fFF.fY(false);
            if (FrsGoodFragment.this.boy().boF() != null) {
                FrsGoodFragment.this.fos = FrsGoodFragment.this.boy().boF();
            }
            FrsGoodFragment.this.ecl = FrsGoodFragment.this.fos.getPage().acp();
            if (FrsGoodFragment.this.ecl == 0 && (FrsGoodFragment.this.fos.getThreadListIds() == null || FrsGoodFragment.this.fos.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.fos.getThreadList() == null || FrsGoodFragment.this.fos.getThreadList().size() == 0) {
                    FrsGoodFragment.this.fFF.aIG();
                } else {
                    FrsGoodFragment.this.fFF.aIF();
                }
            } else {
                FrsGoodFragment.this.fFF.aIE();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.fFE.a(false, false, false, FrsGoodFragment.this.fos.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.fos.setThreadList(a2);
                    FrsGoodFragment.this.fFF.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.fos, FrsGoodFragment.this.ecl);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.fFF.bkN();
                    break;
                case 2:
                    FrsGoodFragment.this.fFF.bkN();
                    break;
                case 3:
                    if (FrsGoodFragment.this.fos.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.fFN != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.fos != null) {
                    FrsGoodFragment.this.foH = FrsGoodFragment.this.fos.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.fos.getForum().getId();
                    FrsGoodFragment.this.fFF.b(FrsGoodFragment.this.fos.getForum(), FrsGoodFragment.this.fos.getUserData());
                }
                if (FrsGoodFragment.this.fos != null) {
                    FrsGoodFragment.this.fos.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.fFF.c(FrsGoodFragment.this.fos);
                if (FrsGoodFragment.this.fos == null || FrsGoodFragment.this.fos.getThreadList() == null || FrsGoodFragment.this.fos.getThreadList().size() != 0 || FrsGoodFragment.this.boy().getType() != 4) {
                    if (FrsGoodFragment.this.fos != null && (a = FrsGoodFragment.this.fFE.a(false, false, true, FrsGoodFragment.this.fos.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.fos.setThreadList(a);
                    }
                    FrsGoodFragment.this.bkb();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.eSl > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.eSl, FrsGoodFragment.this.boy().beg() - FrsGoodFragment.this.eSl, FrsGoodFragment.this.boy().bee(), FrsGoodFragment.this.boy().bef(), currentTimeMillis2 - FrsGoodFragment.this.boy().bed());
                        FrsGoodFragment.this.eSl = -1L;
                    }
                    FrsGoodFragment.this.cyE = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.eSl > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.eSl, FrsGoodFragment.this.boy().beg() - FrsGoodFragment.this.eSl, FrsGoodFragment.this.boy().bee(), FrsGoodFragment.this.boy().bef(), currentTimeMillis3 - FrsGoodFragment.this.boy().bed());
                FrsGoodFragment.this.eSl = -1L;
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
            if (customResponsedMessage != null && FrsGoodFragment.this.fFF != null) {
                FrsGoodFragment.this.fFF.startPullRefresh();
            }
        }
    };
    private final h.c drX = new h.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.jS()) {
                d.aBn().rU("page_frs_good");
                FrsGoodFragment.this.kv(true);
                return;
            }
            FrsGoodFragment.this.fFF.fY(false);
        }
    };
    private final h.b bZB = new h.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.clt().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.fpa) {
                FrsGoodFragment.this.fpa = true;
                FrsGoodFragment.this.fFF.blc();
            }
            if (i == 0) {
                t.aXM().iv(true);
                com.baidu.tieba.q.c.clt().b(FrsGoodFragment.this.getUniqueId(), true);
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
    private s fqp = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
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
                            if (FrsGoodFragment.this.fFF != null) {
                                FrsGoodFragment.this.fFF.bkN();
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
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bgVar, FrsGoodFragment.this.foH, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.fFH ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsGoodFragment.this.fos != null && FrsGoodFragment.this.fos.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fJC = FrsGoodFragment.this.fos.needLog == 1;
                            bVar.fJE = FrsGoodFragment.this.fos.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.fxk != null) {
                                bVar.fJF = com.baidu.tieba.frs.d.d.fxk.fJF;
                                bVar.fJG = com.baidu.tieba.frs.d.d.fxk.fJG;
                            }
                            com.baidu.tieba.frs.d.a.a(bgVar, 1, FrsGoodFragment.this.getUniqueId(), bVar);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fqt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.fFF != null) {
                FrsGoodFragment.this.fFF.blk();
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
        this.fFF.kf(false);
        showLoadingView(this.fFF.bla(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fFF.kf(true);
        hideLoadingView(this.fFF.bla());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fFF.kf(false);
        this.fFF.bma().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fFF.aIG();
        this.fFF.getListView().getData().clear();
        this.fFF.bkN();
        if (this.ftO == null) {
            this.ftO = new c(getPageContext().getContext(), getNetRefreshListener());
            this.ftO.setTitle(null);
            this.ftO.setButtonText(null);
            this.ftO.asB();
            this.ftO.asC().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.ftO.qx(getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.ftO.qx(null);
        }
        this.ftO.onChangeSkinType();
        this.ftO.attachView(this.fFF.bla(), true);
        registerListener(this.frR);
    }

    private void aHH() {
        this.fFF.kf(true);
        this.fFF.bma().setEnabled(true);
        if (this.ftO != null && this.ftO.isViewAttached()) {
            this.ftO.dettachView(this.fFF.bla());
        }
        MessageManager.getInstance().unRegisterListener(this.frR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kv(boolean z) {
        this.eGB = true;
        bke();
        aHH();
        if (!z) {
            aHH();
            showLoadingView();
        }
        this.fFD.mV(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eSl = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eSl = System.currentTimeMillis();
        }
        this.mForumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.cyw = this.beginTime - this.eSl;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.clt().u(getUniqueId());
        this.fFD = new FrsGoodModelController(this);
        if (arguments != null) {
            this.fFD.K(arguments);
            this.fFC = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.fFD.K(bundle);
            this.fFC = bundle.getBoolean("is_game_frs", false);
        } else {
            this.fFD.K(null);
        }
        this.foO = getVoiceManager();
        this.foO.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bCA);
        registerListener(this.fFK);
        registerListener(this.fpU);
        registerListener(this.fqt);
        this.fFE = new FrsLoadMoreModel(this, null);
        this.fFE.registerListener();
        this.fFE.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fFF = new a(this, inflate, this.fFC);
        this.fFF.boC().kx(this.fFH);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eGB) {
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
        this.foO = getVoiceManager();
        this.foO.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bow();
        if (bundle != null) {
            this.foH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fFH = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.foH = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.fFH = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bow() {
        registerListener(2001118, this.chc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fFF != null) {
            this.fFF.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.frR);
        com.baidu.tieba.q.c.clt().v(getUniqueId());
        t.aXM().iv(false);
        super.onDestroy();
        this.fFD.onActivityDestroy();
        this.foO = getVoiceManager();
        this.foO.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fFJ);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.foH);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.fFC);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fFH);
        this.fFD.onSaveInstanceState(bundle);
        this.foO = getVoiceManager();
        if (this.foO != null) {
            this.foO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bg threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.fFF.boC().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.fos.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.hf(intent.getIntExtra("good_data", 0));
                            threadDataById.ael();
                            kv(false);
                            return;
                        } else if (intExtra == 0) {
                            this.fos.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.fos.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.m());
                            }
                            this.fFF.boA();
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
            if (this.fwm == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.eGB) {
                com.baidu.adp.lib.g.e.iB().post(this.fFJ);
            }
        }
        blR();
    }

    private void blR() {
        if (isPrimary()) {
            if (this.ftO != null && this.ftO.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.frR);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.frR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fFF != null) {
            this.fFF.bkN();
        }
        this.foO = getVoiceManager();
        this.foO.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fFG = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.fFF.setOnAdapterItemClickListener(this.fqp);
        this.fFF.setOnScrollListener(this.mScrollListener);
        this.fFF.setListPullRefreshListener(this.drX);
        this.fFF.a(this.bZB);
        this.fFF.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.fFG != null) {
                    FrsGoodFragment.this.fFG.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fwm != 3 || this.fFF != null) {
            this.fwm = i;
            super.onChangeSkinType(i);
            if (this.fFF != null) {
                this.fFF.onChangeSkinType(i);
            }
            if (this.ftO != null && this.ftO.isViewAttached()) {
                this.ftO.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bjh() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bjh();
        }
        return null;
    }

    private void bka() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.iC().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Ec(FrsGoodFragment.this.foH);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkb() {
        bke();
        try {
            if (this.fos != null) {
                this.fFF.aUE();
                this.foH = this.fos.getForum().getName();
                this.forumId = this.fos.getForum().getId();
                if (this.fos != null && this.fos.getForum() != null) {
                    this.fFF.a(this.fos.getForum().getThemeColorInfo());
                    this.fFF.c(this.fos);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.fos.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fos.getUserData().getBimg_end_time());
                bka();
                if (!this.fFF.boC().m(bg.bIx)) {
                    this.fos.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.fos.getThreadList();
                if (threadList != null) {
                    this.fFF.a(threadList, this.mPn, this.fos, this.fos.getPage().acp());
                    box();
                    this.fFF.boA();
                    if (this.fos.getIsNewUrl() == 1) {
                        this.fFF.boC().setFromCDN(true);
                    } else {
                        this.fFF.boC().setFromCDN(false);
                    }
                    this.fFF.setListViewSelection(bx(boy().getType(), this.mPn));
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
        this.foO = getVoiceManager();
        this.foO.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.aXM().iv(false);
        com.baidu.tieba.q.c.clt().b(getUniqueId(), false);
        if (this.fos != null && this.fos.getForum() != null) {
            com.baidu.tbadk.distribute.a.aqF().a(getPageContext().getPageActivity(), "frs", this.fos.getForum().getId(), 0L);
        }
        this.foO = getVoiceManager();
        if (this.foO != null) {
            this.foO.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb(int i) {
        ArrayList<m> threadList = this.fos.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bf) {
                    bg bgVar = ((bf) next).threadData;
                    if (bgVar.getId() != null && bgVar.getId().equals(this.fFB)) {
                        c(bgVar, i);
                        this.fFB = null;
                        break;
                    }
                }
            }
            this.fFF.boC().b(threadList, this.fos);
            this.fFF.boC().notifyDataSetChanged();
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
        if (this.foO == null) {
            this.foO = VoiceManager.instance();
        }
        return this.foO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView ajY() {
        if (this.fFF == null) {
            return null;
        }
        return this.fFF.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bke() {
        this.foO = getVoiceManager();
        this.foO.stopPlay();
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
        if (this.fos != null && this.fFF != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fFF.bkN();
            }
        }
    }

    private void box() {
        HashMap<Integer, bg> bmR;
        if (this.fFF != null && this.fFF.boC() != null && (bmR = this.fFF.boC().bmR()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bg> entry : bmR.entrySet()) {
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
    public FrsViewData bkj() {
        return this.fos;
    }

    public FrsGoodModelController boy() {
        return this.fFD;
    }

    public void wO(String str) {
        this.foH = str;
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
            this.fFF.aIG();
        } else if (!this.fFD.boH()) {
            this.fFF.aIG();
        } else {
            aHE();
            if (!this.fFE.isLoading && !this.fFD.pu()) {
                if (this.fFE.ci(this.fos.getThreadListIds())) {
                    this.fFF.a(this.fFE.boR(), this.mPn, this.fos, 0);
                    this.fFE.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.fos.getThreadListIds(), this.foH, this.mPn, this.fos.isBrandForum);
                } else if (this.ecl != 0) {
                    this.fFF.a(this.fFE.boR(), this.mPn, this.fos, 0);
                    this.mPn++;
                    this.fFD.sd(this.mPn);
                    this.fFE.loadingDone = false;
                    this.fFE.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void vY(String str) {
        aHE();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void V(ArrayList<m> arrayList) {
        ArrayList<m> a;
        aHE();
        if (arrayList != null && arrayList.size() != 0 && (a = this.fFE.a(false, false, false, arrayList, (f) null)) != null) {
            this.fos.setThreadList(a);
            this.fFF.a(a, this.mPn, this.fos, 0);
        }
    }

    private void aHE() {
        if (this.ecl == 0 && !this.fFE.ci(this.fos.getThreadListIds())) {
            if (this.fos.getThreadList() == null || this.fos.getThreadList().size() == 0) {
                this.fFF.aIG();
                return;
            } else {
                this.fFF.aIF();
                return;
            }
        }
        this.fFF.aIE();
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
    public void bkd() {
        if (this.fFD != null) {
            this.fFD.bkd();
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
    public NavigationBar aJz() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.foH;
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
    public void bjv() {
        if (this.fFF != null && this.fFF.getListView() != null) {
            this.fFF.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aID() {
        if (this.fFF != null) {
            bjv();
            this.fFF.startPullRefresh();
        }
    }
}
