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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.x;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, al, am, an, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.recapp.m, FrsCommonImageLayout.c {
    private String hFp;
    private FrsLoadMoreModel hFs;
    private FrsNewAreaModelController hHQ;
    private VoiceManager hns;
    private com.baidu.tbadk.k.c hsj;
    private String hnl = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData hmR = new FrsViewData();
    public long gPV = -1;
    public long erW = 0;
    public long esg = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean hnD = false;
    protected g hHR = null;
    private int gmt = -1;
    private int huQ = 3;
    private boolean gJV = false;
    private boolean hFv = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hnQ = new SparseArray<>();
    private int cOy = 0;
    private int hoo = 0;
    private CustomMessageListener hqu = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.hsj != null && FrsNewAreaFragment.this.hsj.isViewAttached()) {
                FrsNewAreaFragment.this.hsj.nu(num.intValue());
            }
        }
    };
    private Runnable hFw = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.gJV) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.nz(false);
            }
        }
    };
    private CustomMessageListener hFx = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk)) {
                bk bkVar = (bk) customResponsedMessage.getData();
                FrsNewAreaFragment.this.hFp = bkVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.hFp) && bkVar.aQi() != null) {
                    FrsNewAreaFragment.this.uS(bkVar.aQi().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener hot = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.aWO() != null) {
                        FrsNewAreaFragment.this.aWO().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.hsj != null && FrsNewAreaFragment.this.hsj.isViewAttached()) {
                        FrsNewAreaFragment.this.nz(false);
                    } else if (FrsNewAreaFragment.this.hHR != null) {
                        FrsNewAreaFragment.this.hHR.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final q hoI = new q() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        private long hFA = 1;

        @Override // com.baidu.tieba.tbadkCore.q
        public void tM(int i) {
            if (!FrsNewAreaFragment.this.hFv) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.hHR.bWb();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.hHR.iQ(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<o> a;
            if (FrsNewAreaFragment.this.hFv) {
                if (FrsNewAreaFragment.this.caL().bZZ() == null) {
                    FrsNewAreaFragment.this.hFv = false;
                    return;
                } else if (FrsNewAreaFragment.this.caL().bZZ().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.hFv = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.hFA = 1L;
            } else if (fVar.isSuccess) {
                this.hFA = 0L;
            } else {
                this.hFA = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.hFs.resetData();
            }
            FrsNewAreaFragment.this.hHR.iQ(false);
            if (FrsNewAreaFragment.this.caL().bZZ() != null) {
                FrsNewAreaFragment.this.hmR = FrsNewAreaFragment.this.caL().bZZ();
            }
            FrsNewAreaFragment.this.gmt = FrsNewAreaFragment.this.hmR.getPage().aPt();
            if (FrsNewAreaFragment.this.gmt == 0 && (FrsNewAreaFragment.this.hmR.getThreadListIds() == null || FrsNewAreaFragment.this.hmR.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.hmR.getThreadList() == null || FrsNewAreaFragment.this.hmR.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.hHR.brO();
                } else {
                    FrsNewAreaFragment.this.hHR.brN();
                }
            } else {
                FrsNewAreaFragment.this.hHR.brM();
            }
            if (i == 4) {
                ArrayList<o> a2 = FrsNewAreaFragment.this.hFs.a(false, false, false, FrsNewAreaFragment.this.hmR.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.hmR.setThreadList(a2);
                    FrsNewAreaFragment.this.hHR.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.hmR, FrsNewAreaFragment.this.gmt);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.hHR.bWb();
                    break;
                case 2:
                    FrsNewAreaFragment.this.hHR.bWb();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.hmR.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.hFA != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.hmR != null) {
                    FrsNewAreaFragment.this.hnl = FrsNewAreaFragment.this.hmR.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.hmR.getForum().getId();
                    FrsNewAreaFragment.this.hHR.b(FrsNewAreaFragment.this.hmR.getForum(), FrsNewAreaFragment.this.hmR.getUserData());
                }
                if (FrsNewAreaFragment.this.hmR != null) {
                    FrsNewAreaFragment.this.hmR.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.hmR == null || FrsNewAreaFragment.this.hmR.getThreadList() == null || FrsNewAreaFragment.this.hmR.getThreadList().size() != 0 || FrsNewAreaFragment.this.caL().getType() != 4) {
                    if (FrsNewAreaFragment.this.hmR != null && (a = FrsNewAreaFragment.this.hFs.a(false, false, true, FrsNewAreaFragment.this.hmR.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.hmR.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bVm();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.gPV > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.gPV, FrsNewAreaFragment.this.caL().bPs() - FrsNewAreaFragment.this.gPV, FrsNewAreaFragment.this.caL().bPq(), FrsNewAreaFragment.this.caL().bPr(), currentTimeMillis2 - FrsNewAreaFragment.this.caL().bPp());
                        FrsNewAreaFragment.this.gPV = -1L;
                    }
                    FrsNewAreaFragment.this.esg = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.gPV > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.gPV, FrsNewAreaFragment.this.caL().bPs() - FrsNewAreaFragment.this.gPV, FrsNewAreaFragment.this.caL().bPq(), FrsNewAreaFragment.this.caL().bPr(), currentTimeMillis3 - FrsNewAreaFragment.this.caL().bPp());
                FrsNewAreaFragment.this.gPV = -1L;
            }
            FrsNewAreaFragment.this.esg = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }
    };
    private final CustomMessageListener dzd = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.hHR != null) {
                FrsNewAreaFragment.this.hHR.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.hnD) {
                FrsNewAreaFragment.this.hnD = true;
                FrsNewAreaFragment.this.hHR.bWq();
            }
            if (i == 0) {
                s.bLs().lT(true);
                com.baidu.tieba.s.c.dcI().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.hoo += i2;
            if (FrsNewAreaFragment.this.hoo >= FrsNewAreaFragment.this.cOy * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener edg = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
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
    private x hoP = new x() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.x
        public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && oVar != null && (oVar instanceof bj)) {
                bk bkVar = ((bj) oVar).dEA;
                if (bkVar.aRy() == null || bkVar.aRy().getGroup_id() == 0 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bkVar.aRl() != 1 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.MP(bkVar.getId())) {
                            readThreadHistory.MO(bkVar.getId());
                            if (FrsNewAreaFragment.this.hHR != null) {
                                FrsNewAreaFragment.this.hHR.bWb();
                            }
                        }
                        boolean z = false;
                        final String aQE = bkVar.aQE();
                        if (aQE != null && !aQE.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aQE);
                                    xVar.aUA().aVb().mIsNeedAddCommenParam = false;
                                    xVar.aUA().aVb().mIsUseCurrentBDUSS = false;
                                    xVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bkVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bkVar.aQs() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aVa().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bkVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bkVar, FrsNewAreaFragment.this.hnl, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bkVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.hmR != null && FrsNewAreaFragment.this.hmR.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.hJA = FrsNewAreaFragment.this.hmR.needLog == 1;
                            bVar.hJC = FrsNewAreaFragment.this.hmR.getForum().getId();
                            bVar.hJB = FrsNewAreaFragment.this.hHQ.caD();
                            if (com.baidu.tieba.frs.d.d.hvL != null) {
                                bVar.hJD = com.baidu.tieba.frs.d.d.hvL.hJD;
                                bVar.hJE = com.baidu.tieba.frs.d.d.hvL.hJE;
                            }
                            com.baidu.tieba.frs.d.a.a(bkVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar, FrsNewAreaFragment.this.getTbPageTag());
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

    public void ap(bk bkVar) {
        if (bkVar != null) {
            this.hHQ.ap(bkVar);
            this.hHR.bUA();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.hmR = frsViewData;
            hideLoadingView(this.hHR.bIN());
            if (this.hHR != null) {
                this.hHR.iQ(false);
                this.hHR.a(null, this.mPn, this.hmR, this.gmt);
            }
        }
    }

    private void showLoadingView() {
        this.hHR.nj(false);
        showLoadingView(this.hHR.bIN(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.hHR.nj(true);
        hideLoadingView(this.hHR.bIN());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.hHR.nj(false);
        this.hHR.ni(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hHR.brO();
        this.hHR.getListView().getData().clear();
        this.hHR.bWb();
        if (this.hsj == null) {
            this.hsj = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hsj.setTitle(null);
            this.hsj.setButtonText(null);
            this.hsj.showRefreshButton();
            this.hsj.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hsj.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hsj.setSubText(null);
        }
        this.hsj.onChangeSkinType();
        this.hsj.attachView(this.hHR.bIN(), true);
        registerListener(this.hqu);
    }

    private void bqQ() {
        this.hHR.nj(true);
        this.hHR.ni(true);
        if (this.hsj != null && this.hsj.isViewAttached()) {
            this.hsj.dettachView(this.hHR.bIN());
        }
        MessageManager.getInstance().unRegisterListener(this.hqu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(boolean z) {
        this.gJV = true;
        bVp();
        bqQ();
        if (!z) {
            bqQ();
            showLoadingView();
        }
        this.hHQ.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gPV = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.gPV = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.erW = this.beginTime - this.gPV;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dcI().z(getUniqueId());
        this.hHQ = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.hHQ.aj(arguments);
        } else if (bundle != null) {
            this.hHQ.aj(bundle);
        } else {
            this.hHQ.aj(null);
        }
        this.hns = getVoiceManager();
        this.hns.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dzd);
        registerListener(this.hFx);
        registerListener(this.hot);
        this.hFs = new FrsLoadMoreModel(this, null);
        this.hFs.registerListener();
        this.hFs.setPageType(3);
        this.hFs.nB(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cOy = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.hHR = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.gJV) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                nz(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        aUT();
    }

    private void aUT() {
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13008");
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.dh("fid", this.forumId);
        anVar.ag("obj_type", 6);
        anVar.ag("obj_locate", 2);
        anVar.aUT();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hns = getVoiceManager();
        this.hns.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bZO();
        if (bundle != null) {
            this.hnl = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.hnl = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bZO() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.edg);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hHR != null) {
            this.hHR.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hqu);
        com.baidu.tieba.s.c.dcI().A(getUniqueId());
        s.bLs().lT(false);
        super.onDestroy();
        this.hHQ.bZX();
        this.hns = getVoiceManager();
        this.hns.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hFw);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hnl);
        bundle.putString("from", this.mFrom);
        this.hHQ.onSaveInstanceState(bundle);
        this.hns = getVoiceManager();
        if (this.hns != null) {
            this.hns.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bk threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.hHR.caN().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.hmR.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.kv(intent.getIntExtra("good_data", 0));
                            threadDataById.aRw();
                            nz(false);
                            return;
                        } else if (intExtra == 0) {
                            this.hmR.removeThreadData(threadDataById);
                            ArrayList<o> threadList = this.hmR.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new p());
                            }
                            this.hHR.bZT();
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
            if (this.huQ == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.gJV) {
                com.baidu.adp.lib.f.e.ld().post(this.hFw);
            }
        }
        bXg();
    }

    private void bXg() {
        if (isPrimary()) {
            if (this.hsj != null && this.hsj.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hqu);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hqu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hHR != null) {
            this.hHR.bWb();
        }
        this.hns = getVoiceManager();
        this.hns.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.hHR.a(this.hoP);
        this.hHR.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.huQ != 3 || this.hHR != null) {
            this.huQ = i;
            super.onChangeSkinType(i);
            if (this.hHR != null) {
                this.hHR.onChangeSkinType(i);
            }
            if (this.hsj != null && this.hsj.isViewAttached()) {
                this.hsj.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bUl() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bUl();
        }
        return null;
    }

    private void bVl() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.le().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.MJ(FrsNewAreaFragment.this.hnl);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVm() {
        bVp();
        try {
            if (this.hmR != null) {
                this.hHR.bXq();
                this.hHR.bvO();
                this.hnl = this.hmR.getForum().getName();
                this.forumId = this.hmR.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.hmR.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hmR.getUserData().getBimg_end_time());
                bVl();
                ArrayList<o> threadList = this.hmR.getThreadList();
                if (threadList != null) {
                    this.hHR.a(threadList, this.mPn, this.hmR, this.hmR.getPage().aPt());
                    bZQ();
                    this.hHR.bZT();
                    if (this.hmR.getIsNewUrl() == 1) {
                        this.hHR.caN().setFromCDN(true);
                    } else {
                        this.hHR.caN().setFromCDN(false);
                    }
                    this.hHR.setListViewSelection(ca(caL().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int ca(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hns = getVoiceManager();
        this.hns.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.bLs().lT(false);
        com.baidu.tieba.s.c.dcI().b(getUniqueId(), false);
        if (this.hmR != null && this.hmR.getForum() != null) {
            com.baidu.tbadk.distribute.a.bcL().b(getPageContext().getPageActivity(), "frs", this.hmR.getForum().getId(), 0L);
        }
        this.hns = getVoiceManager();
        if (this.hns != null) {
            this.hns.onStop(getPageContext());
        }
    }

    public void bXN() {
        if (this.hHR != null) {
            this.hHR.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(int i) {
        ArrayList<o> threadList = this.hmR.getThreadList();
        if (threadList != null) {
            Iterator<o> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next instanceof bj) {
                    bk bkVar = ((bj) next).dEA;
                    if (bkVar.getId() != null && bkVar.getId().equals(this.hFp)) {
                        c(bkVar, i);
                        this.hFp = null;
                        break;
                    }
                }
            }
            this.hHR.caN().b(threadList, this.hmR);
            this.hHR.caN().notifyDataSetChanged();
        }
    }

    private void c(bk bkVar, int i) {
        if (i == 1) {
            PraiseData aQi = bkVar.aQi();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aQi == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bkVar.a(praiseData);
                    return;
                }
                bkVar.aQi().getUser().add(0, metaData);
                bkVar.aQi().setNum(bkVar.aQi().getNum() + 1);
                bkVar.aQi().setIsLike(i);
            }
        } else if (bkVar.aQi() != null) {
            bkVar.aQi().setIsLike(i);
            bkVar.aQi().setNum(bkVar.aQi().getNum() - 1);
            ArrayList<MetaData> user = bkVar.aQi().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bkVar.aQi().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hns == null) {
            this.hns = VoiceManager.instance();
        }
        return this.hns;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aWO() {
        if (this.hHR == null) {
            return null;
        }
        return this.hHR.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bVp() {
        this.hns = getVoiceManager();
        this.hns.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aWP() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aWP();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.hmR != null && this.hHR != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.hHR.bWb();
            }
        }
    }

    private void bZQ() {
        HashMap<Integer, bk> bYp;
        if (this.hHR != null && this.hHR.caN() != null && (bYp = this.hHR.caN().bYp()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bk> entry : bYp.entrySet()) {
                bk value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bcR().E(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public r onGetPreLoadListView() {
        if (aWO() == null) {
            return null;
        }
        return aWO().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            nz(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bVu() {
        return this.hmR;
    }

    public FrsNewAreaModelController caL() {
        return this.hHQ;
    }

    public void EW(String str) {
        this.hnl = str;
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

    public void bqx() {
        if (!this.hFs.isLoading && !this.hHQ.isLoading()) {
            if (this.hFs.cx(this.hmR.getThreadListIds())) {
                this.hHR.a(this.hFs.cam(), this.mPn, this.hmR, 0);
                this.hFs.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.hmR.getThreadListIds(), this.hnl, this.mPn, this.hmR.isBrandForum);
            } else if (this.gmt != 0) {
                this.hHR.a(this.hFs.cam(), this.mPn, this.hmR, 0);
                this.mPn++;
                this.hHQ.uU(this.mPn);
                this.hFs.loadingDone = false;
                this.hFs.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.hHR.brO();
        } else if (!this.hHR.bWk()) {
            if (!this.hHQ.cab()) {
                this.hHR.brO();
                return;
            }
            bqM();
            bqx();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bqM();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void an(ArrayList<o> arrayList) {
        ArrayList<o> a;
        bqM();
        if (arrayList != null && arrayList.size() != 0 && (a = this.hFs.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.hmR.setThreadList(a);
            this.hHR.a(a, this.mPn, this.hmR, 0);
        }
    }

    public void cy(List<String> list) {
        cm(list);
        int i = 0;
        Iterator<o> it = this.hmR.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bj ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            bqx();
        }
    }

    private void cm(List<String> list) {
        if (!v.isEmpty(list)) {
            ArrayList<o> threadList = this.hmR.getThreadList();
            if (!v.isEmpty(threadList) && this.hHR.getListView() != null && this.hHR.getListView().getData() != null) {
                Iterator<o> it = threadList.iterator();
                List<o> data = this.hHR.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    o next = it.next();
                    if (next instanceof bj) {
                        bk bkVar = ((bj) next).dEA;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!aq.equals(list.get(i2), bkVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hFs.d(next);
                                this.hHR.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel bZP() {
        return this.hFs;
    }

    private void bqM() {
        if (this.gmt == 0 && !this.hFs.cx(this.hmR.getThreadListIds())) {
            if (this.hmR.getThreadList() == null || this.hmR.getThreadList().size() == 0) {
                this.hHR.brO();
                return;
            } else {
                this.hHR.brN();
                return;
            }
        }
        this.hHR.brM();
    }

    public g caM() {
        return this.hHR;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.h.a.a.InterfaceC0125a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.checkCamera(getActivity().getApplicationContext())) {
                com.baidu.tbadk.core.util.al.d(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.m
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bcL().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.m
    public void bVo() {
        if (this.hHQ != null) {
            this.hHQ.bVo();
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.m
    public int getPageNum() {
        return this.mPn;
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar bua() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hnl;
    }

    @Override // com.baidu.tieba.frs.al
    public void bUA() {
        if (this.hHR != null && this.hHR.getListView() != null) {
            this.hHR.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void brL() {
        if (this.hHR != null) {
            bUA();
            this.hHR.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hnQ.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oO(int i) {
        return this.hnQ.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hmR != null) {
            i = this.hmR.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.vs(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.an
    public void aWp() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bmb().zK("page_frs_good");
            nz(true);
            return;
        }
        this.hHR.iQ(false);
    }

    @Override // com.baidu.tieba.frs.an
    public void aWq() {
        com.baidu.tieba.s.c.dcI().b(getUniqueId(), false);
    }
}
