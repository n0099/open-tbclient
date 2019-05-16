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
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, ag, ah, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String fFB;
    private FrsLoadMoreModel fFE;
    private FrsNewAreaModelController fHV;
    private VoiceManager foO;
    private com.baidu.tbadk.m.c ftO;
    private String foH = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData fos = new FrsViewData();
    public long eSl = -1;
    public long cyw = 0;
    public long cyE = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fpa = false;
    protected g fHW = null;
    private int ecl = -1;
    private int fwm = 3;
    private boolean eGB = false;
    public boolean fFH = false;
    private boolean fFI = false;
    private CustomMessageListener frR = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.ftO != null && FrsNewAreaFragment.this.ftO.isViewAttached()) {
                FrsNewAreaFragment.this.ftO.kB(num.intValue());
            }
        }
    };
    private Runnable fFJ = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.jS() || FrsNewAreaFragment.this.eGB) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.kv(false);
            }
        }
    };
    private CustomMessageListener fFK = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                FrsNewAreaFragment.this.fFB = bgVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.fFB) && bgVar.adh() != null) {
                    FrsNewAreaFragment.this.sb(bgVar.adh().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fpU = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.ajY() != null) {
                        FrsNewAreaFragment.this.ajY().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.ftO != null && FrsNewAreaFragment.this.ftO.isViewAttached()) {
                        FrsNewAreaFragment.this.kv(false);
                    } else if (FrsNewAreaFragment.this.fHW != null) {
                        FrsNewAreaFragment.this.fHW.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n fqj = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long fFN = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void ra(int i) {
            if (!FrsNewAreaFragment.this.fFI) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.fHW.bkN();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.fHW.fY(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.fFI) {
                if (FrsNewAreaFragment.this.bpm().boF() == null) {
                    FrsNewAreaFragment.this.fFI = false;
                    return;
                } else if (FrsNewAreaFragment.this.bpm().boF().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.fFI = false;
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
                FrsNewAreaFragment.this.fFE.resetData();
            }
            FrsNewAreaFragment.this.fHW.fY(false);
            if (FrsNewAreaFragment.this.bpm().boF() != null) {
                FrsNewAreaFragment.this.fos = FrsNewAreaFragment.this.bpm().boF();
            }
            FrsNewAreaFragment.this.ecl = FrsNewAreaFragment.this.fos.getPage().acp();
            if (FrsNewAreaFragment.this.ecl == 0 && (FrsNewAreaFragment.this.fos.getThreadListIds() == null || FrsNewAreaFragment.this.fos.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.fos.getThreadList() == null || FrsNewAreaFragment.this.fos.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.fHW.aIG();
                } else {
                    FrsNewAreaFragment.this.fHW.aIF();
                }
            } else {
                FrsNewAreaFragment.this.fHW.aIE();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.fFE.a(false, false, false, FrsNewAreaFragment.this.fos.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.fos.setThreadList(a2);
                    FrsNewAreaFragment.this.fHW.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.fos, FrsNewAreaFragment.this.ecl);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.fHW.bkN();
                    break;
                case 2:
                    FrsNewAreaFragment.this.fHW.bkN();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.fos.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.fFN != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.fos != null) {
                    FrsNewAreaFragment.this.foH = FrsNewAreaFragment.this.fos.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.fos.getForum().getId();
                    FrsNewAreaFragment.this.fHW.b(FrsNewAreaFragment.this.fos.getForum(), FrsNewAreaFragment.this.fos.getUserData());
                }
                if (FrsNewAreaFragment.this.fos != null) {
                    FrsNewAreaFragment.this.fos.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.fos == null || FrsNewAreaFragment.this.fos.getThreadList() == null || FrsNewAreaFragment.this.fos.getThreadList().size() != 0 || FrsNewAreaFragment.this.bpm().getType() != 4) {
                    if (FrsNewAreaFragment.this.fos != null && (a = FrsNewAreaFragment.this.fFE.a(false, false, true, FrsNewAreaFragment.this.fos.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.fos.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bkb();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.eSl > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsNewAreaFragment.this.eSl, FrsNewAreaFragment.this.bpm().beg() - FrsNewAreaFragment.this.eSl, FrsNewAreaFragment.this.bpm().bee(), FrsNewAreaFragment.this.bpm().bef(), currentTimeMillis2 - FrsNewAreaFragment.this.bpm().bed());
                        FrsNewAreaFragment.this.eSl = -1L;
                    }
                    FrsNewAreaFragment.this.cyE = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.eSl > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsNewAreaFragment.this.eSl, FrsNewAreaFragment.this.bpm().beg() - FrsNewAreaFragment.this.eSl, FrsNewAreaFragment.this.bpm().bee(), FrsNewAreaFragment.this.bpm().bef(), currentTimeMillis3 - FrsNewAreaFragment.this.bpm().bed());
                FrsNewAreaFragment.this.eSl = -1L;
            }
            FrsNewAreaFragment.this.cyE = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
        }
    };
    private final CustomMessageListener bCA = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.fHW != null) {
                FrsNewAreaFragment.this.fHW.startPullRefresh();
            }
        }
    };
    private final h.c drX = new h.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.jS()) {
                com.baidu.tieba.a.d.aBn().rU("page_frs_good");
                FrsNewAreaFragment.this.kv(true);
                return;
            }
            FrsNewAreaFragment.this.fHW.fY(false);
        }
    };
    private final h.b bZB = new h.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.clt().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.fpa) {
                FrsNewAreaFragment.this.fpa = true;
                FrsNewAreaFragment.this.fHW.blc();
            }
            if (i == 0) {
                t.aXM().iv(true);
                com.baidu.tieba.q.c.clt().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener chc = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
    private s fqp = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bf)) {
                bg bgVar = ((bf) mVar).threadData;
                if (bgVar.aen() == null || bgVar.aen().getGroup_id() == 0 || bc.cE(FrsNewAreaFragment.this.getActivity())) {
                    if (bgVar.aef() != 1 || bc.cE(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Ei(bgVar.getId())) {
                            readThreadHistory.Eh(bgVar.getId());
                            if (FrsNewAreaFragment.this.fHW != null) {
                                FrsNewAreaFragment.this.fHW.bkN();
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
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bgVar, FrsNewAreaFragment.this.foH, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bgVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsNewAreaFragment.this.fFH ? 15 : 3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.fos != null && FrsNewAreaFragment.this.fos.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fJC = FrsNewAreaFragment.this.fos.needLog == 1;
                            bVar.fJE = FrsNewAreaFragment.this.fos.getForum().getId();
                            bVar.fJD = FrsNewAreaFragment.this.fHV.bpg();
                            if (com.baidu.tieba.frs.d.d.fxk != null) {
                                bVar.fJF = com.baidu.tieba.frs.d.d.fxk.fJF;
                                bVar.fJG = com.baidu.tieba.frs.d.d.fxk.fJG;
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
            this.fHV.ac(bgVar);
            this.fHW.bjv();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.fos = frsViewData;
            hideLoadingView(this.fHW.bla());
            if (this.fHW != null) {
                this.fHW.fY(false);
                this.fHW.a(null, this.mPn, this.fos, this.ecl);
            }
        }
    }

    private void showLoadingView() {
        this.fHW.kf(false);
        showLoadingView(this.fHW.bla(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fHW.kf(true);
        hideLoadingView(this.fHW.bla());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fHW.kf(false);
        this.fHW.bma().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fHW.aIG();
        this.fHW.getListView().getData().clear();
        this.fHW.bkN();
        if (this.ftO == null) {
            this.ftO = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
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
        this.ftO.attachView(this.fHW.bla(), true);
        registerListener(this.frR);
    }

    private void aHH() {
        this.fHW.kf(true);
        this.fHW.bma().setEnabled(true);
        if (this.ftO != null && this.ftO.isViewAttached()) {
            this.ftO.dettachView(this.fHW.bla());
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
        this.fHV.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eSl = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.eSl = System.currentTimeMillis();
        }
        this.forumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.cyw = this.beginTime - this.eSl;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.clt().u(getUniqueId());
        this.fHV = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.fHV.K(arguments);
        } else if (bundle != null) {
            this.fHV.K(bundle);
        } else {
            this.fHV.K(null);
        }
        this.foO = getVoiceManager();
        this.foO.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bCA);
        registerListener(this.fFK);
        registerListener(this.fpU);
        this.fFE = new FrsLoadMoreModel(this, null);
        this.fFE.registerListener();
        this.fFE.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fHW = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eGB) {
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
        this.foO = getVoiceManager();
        this.foO.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bow();
        if (bundle != null) {
            this.foH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.foH = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
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
        if (this.fHW != null) {
            this.fHW.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.frR);
        com.baidu.tieba.q.c.clt().v(getUniqueId());
        t.aXM().iv(false);
        super.onDestroy();
        this.fHV.onActivityDestroy();
        this.foO = getVoiceManager();
        this.foO.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fFJ);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.foH);
        bundle.putString("from", this.mFrom);
        this.fHV.onSaveInstanceState(bundle);
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
                    this.fHW.bpo().notifyDataSetChanged();
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
                            this.fHW.boA();
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
        if (this.fHW != null) {
            this.fHW.bkN();
        }
        this.foO = getVoiceManager();
        this.foO.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fHW.setOnAdapterItemClickListener(this.fqp);
        this.fHW.setOnScrollListener(this.mScrollListener);
        this.fHW.setListPullRefreshListener(this.drX);
        this.fHW.a(this.bZB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fwm != 3 || this.fHW != null) {
            this.fwm = i;
            super.onChangeSkinType(i);
            if (this.fHW != null) {
                this.fHW.onChangeSkinType(i);
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
                com.baidu.adp.lib.g.h.iC().d(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Ec(FrsNewAreaFragment.this.foH);
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
                this.fHW.aUE();
                this.foH = this.fos.getForum().getName();
                this.forumId = this.fos.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.fos.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fos.getUserData().getBimg_end_time());
                bka();
                ArrayList<m> threadList = this.fos.getThreadList();
                if (threadList != null) {
                    this.fHW.a(threadList, this.mPn, this.fos, this.fos.getPage().acp());
                    box();
                    this.fHW.boA();
                    if (this.fos.getIsNewUrl() == 1) {
                        this.fHW.bpo().setFromCDN(true);
                    } else {
                        this.fHW.bpo().setFromCDN(false);
                    }
                    this.fHW.setListViewSelection(bx(bpm().getType(), this.mPn));
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

    public void bmv() {
        if (this.fHW != null) {
            this.fHW.refreshView();
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
            this.fHW.bpo().b(threadList, this.fos);
            this.fHW.bpo().notifyDataSetChanged();
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
        if (this.fHW == null) {
            return null;
        }
        return this.fHW.getListView();
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
        if (this.fos != null && this.fHW != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fHW.bkN();
            }
        }
    }

    private void box() {
        HashMap<Integer, bg> bmR;
        if (this.fHW != null && this.fHW.bpo() != null && (bmR = this.fHW.bpo().bmR()) != null) {
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
        if (com.baidu.adp.lib.util.j.jS()) {
            kv(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bkj() {
        return this.fos;
    }

    public FrsNewAreaModelController bpm() {
        return this.fHV;
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

    public void aHq() {
        if (!this.fFE.isLoading && !this.fHV.pu()) {
            if (this.fFE.ci(this.fos.getThreadListIds())) {
                this.fHW.a(this.fFE.boR(), this.mPn, this.fos, 0);
                this.fFE.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.fos.getThreadListIds(), this.foH, this.mPn, this.fos.isBrandForum);
            } else if (this.ecl != 0) {
                this.fHW.a(this.fFE.boR(), this.mPn, this.fos, 0);
                this.mPn++;
                this.fHV.sd(this.mPn);
                this.fFE.loadingDone = false;
                this.fFE.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.ki()) {
            this.fHW.aIG();
        } else if (!this.fHW.bkV()) {
            if (!this.fHV.boH()) {
                this.fHW.aIG();
                return;
            }
            aHE();
            aHq();
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.fFE.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.fos.setThreadList(a);
            this.fHW.a(a, this.mPn, this.fos, 0);
        }
    }

    public void cj(List<String> list) {
        bX(list);
        int i = 0;
        Iterator<m> it = this.fos.getThreadList().iterator();
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
            aHq();
        }
    }

    private void bX(List<String> list) {
        if (!v.aa(list)) {
            ArrayList<m> threadList = this.fos.getThreadList();
            if (!v.aa(threadList) && this.fHW.getListView() != null && this.fHW.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.fHW.getListView().getData();
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
                                this.fFE.e(next);
                                this.fHW.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    private void aHE() {
        if (this.ecl == 0 && !this.fFE.ci(this.fos.getThreadListIds())) {
            if (this.fos.getThreadList() == null || this.fos.getThreadList().size() == 0) {
                this.fHW.aIG();
                return;
            } else {
                this.fHW.aIF();
                return;
            }
        }
        this.fHW.aIE();
    }

    public g bpn() {
        return this.fHW;
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
        if (this.fHV != null) {
            this.fHV.bkd();
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

    @Override // com.baidu.tieba.frs.ag
    public void bjv() {
        if (this.fHW != null && this.fHW.getListView() != null) {
            this.fHW.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aID() {
        if (this.fHW != null) {
            bjv();
            this.fHW.startPullRefresh();
        }
    }
}
