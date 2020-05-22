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
    private String hEC;
    private FrsLoadMoreModel hEF;
    private FrsNewAreaModelController hHd;
    private VoiceManager hnh;
    private com.baidu.tbadk.k.c hrY;
    private String hna = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData hmG = new FrsViewData();
    public long gPK = -1;
    public long erW = 0;
    public long esg = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean hns = false;
    protected g hHe = null;
    private int gmi = -1;
    private int huF = 3;
    private boolean gJK = false;
    private boolean hEI = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hnF = new SparseArray<>();
    private int cOy = 0;
    private int hod = 0;
    private CustomMessageListener hqj = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.hrY != null && FrsNewAreaFragment.this.hrY.isViewAttached()) {
                FrsNewAreaFragment.this.hrY.ns(num.intValue());
            }
        }
    };
    private Runnable hEJ = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.gJK) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.nz(false);
            }
        }
    };
    private CustomMessageListener hEK = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk)) {
                bk bkVar = (bk) customResponsedMessage.getData();
                FrsNewAreaFragment.this.hEC = bkVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.hEC) && bkVar.aQi() != null) {
                    FrsNewAreaFragment.this.uQ(bkVar.aQi().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener hoi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.aWN() != null) {
                        FrsNewAreaFragment.this.aWN().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.hrY != null && FrsNewAreaFragment.this.hrY.isViewAttached()) {
                        FrsNewAreaFragment.this.nz(false);
                    } else if (FrsNewAreaFragment.this.hHe != null) {
                        FrsNewAreaFragment.this.hHe.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final q hox = new q() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        private long hEN = 1;

        @Override // com.baidu.tieba.tbadkCore.q
        public void tK(int i) {
            if (!FrsNewAreaFragment.this.hEI) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.hHe.bVZ();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.hHe.iQ(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<o> a;
            if (FrsNewAreaFragment.this.hEI) {
                if (FrsNewAreaFragment.this.caD().bZR() == null) {
                    FrsNewAreaFragment.this.hEI = false;
                    return;
                } else if (FrsNewAreaFragment.this.caD().bZR().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.hEI = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.hEN = 1L;
            } else if (fVar.isSuccess) {
                this.hEN = 0L;
            } else {
                this.hEN = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.hEF.resetData();
            }
            FrsNewAreaFragment.this.hHe.iQ(false);
            if (FrsNewAreaFragment.this.caD().bZR() != null) {
                FrsNewAreaFragment.this.hmG = FrsNewAreaFragment.this.caD().bZR();
            }
            FrsNewAreaFragment.this.gmi = FrsNewAreaFragment.this.hmG.getPage().aPt();
            if (FrsNewAreaFragment.this.gmi == 0 && (FrsNewAreaFragment.this.hmG.getThreadListIds() == null || FrsNewAreaFragment.this.hmG.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.hmG.getThreadList() == null || FrsNewAreaFragment.this.hmG.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.hHe.brM();
                } else {
                    FrsNewAreaFragment.this.hHe.brL();
                }
            } else {
                FrsNewAreaFragment.this.hHe.brK();
            }
            if (i == 4) {
                ArrayList<o> a2 = FrsNewAreaFragment.this.hEF.a(false, false, false, FrsNewAreaFragment.this.hmG.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.hmG.setThreadList(a2);
                    FrsNewAreaFragment.this.hHe.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.hmG, FrsNewAreaFragment.this.gmi);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.hHe.bVZ();
                    break;
                case 2:
                    FrsNewAreaFragment.this.hHe.bVZ();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.hmG.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.hEN != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.hmG != null) {
                    FrsNewAreaFragment.this.hna = FrsNewAreaFragment.this.hmG.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.hmG.getForum().getId();
                    FrsNewAreaFragment.this.hHe.b(FrsNewAreaFragment.this.hmG.getForum(), FrsNewAreaFragment.this.hmG.getUserData());
                }
                if (FrsNewAreaFragment.this.hmG != null) {
                    FrsNewAreaFragment.this.hmG.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.hmG == null || FrsNewAreaFragment.this.hmG.getThreadList() == null || FrsNewAreaFragment.this.hmG.getThreadList().size() != 0 || FrsNewAreaFragment.this.caD().getType() != 4) {
                    if (FrsNewAreaFragment.this.hmG != null && (a = FrsNewAreaFragment.this.hEF.a(false, false, true, FrsNewAreaFragment.this.hmG.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.hmG.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bVk();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.gPK > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.gPK, FrsNewAreaFragment.this.caD().bPq() - FrsNewAreaFragment.this.gPK, FrsNewAreaFragment.this.caD().bPo(), FrsNewAreaFragment.this.caD().bPp(), currentTimeMillis2 - FrsNewAreaFragment.this.caD().bPn());
                        FrsNewAreaFragment.this.gPK = -1L;
                    }
                    FrsNewAreaFragment.this.esg = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.gPK > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.gPK, FrsNewAreaFragment.this.caD().bPq() - FrsNewAreaFragment.this.gPK, FrsNewAreaFragment.this.caD().bPo(), FrsNewAreaFragment.this.caD().bPp(), currentTimeMillis3 - FrsNewAreaFragment.this.caD().bPn());
                FrsNewAreaFragment.this.gPK = -1L;
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
            if (customResponsedMessage != null && FrsNewAreaFragment.this.hHe != null) {
                FrsNewAreaFragment.this.hHe.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.hns) {
                FrsNewAreaFragment.this.hns = true;
                FrsNewAreaFragment.this.hHe.bWo();
            }
            if (i == 0) {
                s.bLq().lT(true);
                com.baidu.tieba.s.c.dct().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.hod += i2;
            if (FrsNewAreaFragment.this.hod >= FrsNewAreaFragment.this.cOy * 2 && i2 < 0) {
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
    private x hoE = new x() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.x
        public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && oVar != null && (oVar instanceof bj)) {
                bk bkVar = ((bj) oVar).dEA;
                if (bkVar.aRy() == null || bkVar.aRy().getGroup_id() == 0 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bkVar.aRl() != 1 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.MO(bkVar.getId())) {
                            readThreadHistory.MN(bkVar.getId());
                            if (FrsNewAreaFragment.this.hHe != null) {
                                FrsNewAreaFragment.this.hHe.bVZ();
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
                                    xVar.aUA().aVa().mIsNeedAddCommenParam = false;
                                    xVar.aUA().aVa().mIsUseCurrentBDUSS = false;
                                    xVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bkVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bkVar.aQs() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aUZ().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bkVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bkVar, FrsNewAreaFragment.this.hna, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bkVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.hmG != null && FrsNewAreaFragment.this.hmG.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.hIN = FrsNewAreaFragment.this.hmG.needLog == 1;
                            bVar.hIP = FrsNewAreaFragment.this.hmG.getForum().getId();
                            bVar.hIO = FrsNewAreaFragment.this.hHd.cav();
                            if (com.baidu.tieba.frs.d.d.hvA != null) {
                                bVar.hIQ = com.baidu.tieba.frs.d.d.hvA.hIQ;
                                bVar.hIR = com.baidu.tieba.frs.d.d.hvA.hIR;
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
            this.hHd.ap(bkVar);
            this.hHe.bUy();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.hmG = frsViewData;
            hideLoadingView(this.hHe.bIL());
            if (this.hHe != null) {
                this.hHe.iQ(false);
                this.hHe.a(null, this.mPn, this.hmG, this.gmi);
            }
        }
    }

    private void showLoadingView() {
        this.hHe.nj(false);
        showLoadingView(this.hHe.bIL(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.hHe.nj(true);
        hideLoadingView(this.hHe.bIL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.hHe.nj(false);
        this.hHe.ni(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hHe.brM();
        this.hHe.getListView().getData().clear();
        this.hHe.bVZ();
        if (this.hrY == null) {
            this.hrY = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hrY.setTitle(null);
            this.hrY.setButtonText(null);
            this.hrY.showRefreshButton();
            this.hrY.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hrY.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hrY.setSubText(null);
        }
        this.hrY.onChangeSkinType();
        this.hrY.attachView(this.hHe.bIL(), true);
        registerListener(this.hqj);
    }

    private void bqO() {
        this.hHe.nj(true);
        this.hHe.ni(true);
        if (this.hrY != null && this.hrY.isViewAttached()) {
            this.hrY.dettachView(this.hHe.bIL());
        }
        MessageManager.getInstance().unRegisterListener(this.hqj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(boolean z) {
        this.gJK = true;
        bVn();
        bqO();
        if (!z) {
            bqO();
            showLoadingView();
        }
        this.hHd.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gPK = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.gPK = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.erW = this.beginTime - this.gPK;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dct().z(getUniqueId());
        this.hHd = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.hHd.aj(arguments);
        } else if (bundle != null) {
            this.hHd.aj(bundle);
        } else {
            this.hHd.aj(null);
        }
        this.hnh = getVoiceManager();
        this.hnh.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dzd);
        registerListener(this.hEK);
        registerListener(this.hoi);
        this.hEF = new FrsLoadMoreModel(this, null);
        this.hEF.registerListener();
        this.hEF.setPageType(3);
        this.hEF.nB(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cOy = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.hHe = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.gJK) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                nz(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        aUS();
    }

    private void aUS() {
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13008");
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.dh("fid", this.forumId);
        anVar.ag("obj_type", 6);
        anVar.ag("obj_locate", 2);
        anVar.aUS();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hnh = getVoiceManager();
        this.hnh.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bZG();
        if (bundle != null) {
            this.hna = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.hna = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bZG() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.edg);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hHe != null) {
            this.hHe.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hqj);
        com.baidu.tieba.s.c.dct().A(getUniqueId());
        s.bLq().lT(false);
        super.onDestroy();
        this.hHd.bZP();
        this.hnh = getVoiceManager();
        this.hnh.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hEJ);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hna);
        bundle.putString("from", this.mFrom);
        this.hHd.onSaveInstanceState(bundle);
        this.hnh = getVoiceManager();
        if (this.hnh != null) {
            this.hnh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bk threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.hHe.caF().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.hmG.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.kt(intent.getIntExtra("good_data", 0));
                            threadDataById.aRw();
                            nz(false);
                            return;
                        } else if (intExtra == 0) {
                            this.hmG.removeThreadData(threadDataById);
                            ArrayList<o> threadList = this.hmG.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new p());
                            }
                            this.hHe.bZL();
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
            if (this.huF == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.gJK) {
                com.baidu.adp.lib.f.e.ld().post(this.hEJ);
            }
        }
        bXe();
    }

    private void bXe() {
        if (isPrimary()) {
            if (this.hrY != null && this.hrY.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hqj);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hqj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hHe != null) {
            this.hHe.bVZ();
        }
        this.hnh = getVoiceManager();
        this.hnh.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.hHe.a(this.hoE);
        this.hHe.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.huF != 3 || this.hHe != null) {
            this.huF = i;
            super.onChangeSkinType(i);
            if (this.hHe != null) {
                this.hHe.onChangeSkinType(i);
            }
            if (this.hrY != null && this.hrY.isViewAttached()) {
                this.hrY.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bUj() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bUj();
        }
        return null;
    }

    private void bVj() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.le().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.MI(FrsNewAreaFragment.this.hna);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVk() {
        bVn();
        try {
            if (this.hmG != null) {
                this.hHe.bXo();
                this.hHe.bvM();
                this.hna = this.hmG.getForum().getName();
                this.forumId = this.hmG.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.hmG.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hmG.getUserData().getBimg_end_time());
                bVj();
                ArrayList<o> threadList = this.hmG.getThreadList();
                if (threadList != null) {
                    this.hHe.a(threadList, this.mPn, this.hmG, this.hmG.getPage().aPt());
                    bZI();
                    this.hHe.bZL();
                    if (this.hmG.getIsNewUrl() == 1) {
                        this.hHe.caF().setFromCDN(true);
                    } else {
                        this.hHe.caF().setFromCDN(false);
                    }
                    this.hHe.setListViewSelection(ca(caD().getType(), this.mPn));
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
        this.hnh = getVoiceManager();
        this.hnh.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.bLq().lT(false);
        com.baidu.tieba.s.c.dct().b(getUniqueId(), false);
        if (this.hmG != null && this.hmG.getForum() != null) {
            com.baidu.tbadk.distribute.a.bcK().b(getPageContext().getPageActivity(), "frs", this.hmG.getForum().getId(), 0L);
        }
        this.hnh = getVoiceManager();
        if (this.hnh != null) {
            this.hnh.onStop(getPageContext());
        }
    }

    public void bXL() {
        if (this.hHe != null) {
            this.hHe.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ(int i) {
        ArrayList<o> threadList = this.hmG.getThreadList();
        if (threadList != null) {
            Iterator<o> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next instanceof bj) {
                    bk bkVar = ((bj) next).dEA;
                    if (bkVar.getId() != null && bkVar.getId().equals(this.hEC)) {
                        c(bkVar, i);
                        this.hEC = null;
                        break;
                    }
                }
            }
            this.hHe.caF().b(threadList, this.hmG);
            this.hHe.caF().notifyDataSetChanged();
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
        if (this.hnh == null) {
            this.hnh = VoiceManager.instance();
        }
        return this.hnh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aWN() {
        if (this.hHe == null) {
            return null;
        }
        return this.hHe.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bVn() {
        this.hnh = getVoiceManager();
        this.hnh.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aWO() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aWO();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.hmG != null && this.hHe != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.hHe.bVZ();
            }
        }
    }

    private void bZI() {
        HashMap<Integer, bk> bYm;
        if (this.hHe != null && this.hHe.caF() != null && (bYm = this.hHe.caF().bYm()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bk> entry : bYm.entrySet()) {
                bk value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bcQ().E(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public r onGetPreLoadListView() {
        if (aWN() == null) {
            return null;
        }
        return aWN().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            nz(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bVs() {
        return this.hmG;
    }

    public FrsNewAreaModelController caD() {
        return this.hHd;
    }

    public void EW(String str) {
        this.hna = str;
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

    public void bqv() {
        if (!this.hEF.isLoading && !this.hHd.isLoading()) {
            if (this.hEF.cw(this.hmG.getThreadListIds())) {
                this.hHe.a(this.hEF.cae(), this.mPn, this.hmG, 0);
                this.hEF.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.hmG.getThreadListIds(), this.hna, this.mPn, this.hmG.isBrandForum);
            } else if (this.gmi != 0) {
                this.hHe.a(this.hEF.cae(), this.mPn, this.hmG, 0);
                this.mPn++;
                this.hHd.uS(this.mPn);
                this.hEF.loadingDone = false;
                this.hEF.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.hHe.brM();
        } else if (!this.hHe.bWi()) {
            if (!this.hHd.bZT()) {
                this.hHe.brM();
                return;
            }
            bqK();
            bqv();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bqK();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void an(ArrayList<o> arrayList) {
        ArrayList<o> a;
        bqK();
        if (arrayList != null && arrayList.size() != 0 && (a = this.hEF.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.hmG.setThreadList(a);
            this.hHe.a(a, this.mPn, this.hmG, 0);
        }
    }

    public void cx(List<String> list) {
        cm(list);
        int i = 0;
        Iterator<o> it = this.hmG.getThreadList().iterator();
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
            bqv();
        }
    }

    private void cm(List<String> list) {
        if (!v.isEmpty(list)) {
            ArrayList<o> threadList = this.hmG.getThreadList();
            if (!v.isEmpty(threadList) && this.hHe.getListView() != null && this.hHe.getListView().getData() != null) {
                Iterator<o> it = threadList.iterator();
                List<o> data = this.hHe.getListView().getData();
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
                                this.hEF.d(next);
                                this.hHe.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel bZH() {
        return this.hEF;
    }

    private void bqK() {
        if (this.gmi == 0 && !this.hEF.cw(this.hmG.getThreadListIds())) {
            if (this.hmG.getThreadList() == null || this.hmG.getThreadList().size() == 0) {
                this.hHe.brM();
                return;
            } else {
                this.hHe.brL();
                return;
            }
        }
        this.hHe.brK();
    }

    public g caE() {
        return this.hHe;
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
        com.baidu.tbadk.distribute.a.bcK().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.m
    public void bVm() {
        if (this.hHd != null) {
            this.hHd.bVm();
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
    public NavigationBar btY() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hna;
    }

    @Override // com.baidu.tieba.frs.al
    public void bUy() {
        if (this.hHe != null && this.hHe.getListView() != null) {
            this.hHe.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void brJ() {
        if (this.hHe != null) {
            bUy();
            this.hHe.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hnF.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oM(int i) {
        return this.hnF.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hmG != null) {
            i = this.hmG.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.vq(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.an
    public void aWo() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.blZ().zK("page_frs_good");
            nz(true);
            return;
        }
        this.hHe.iQ(false);
    }

    @Override // com.baidu.tieba.frs.an
    public void aWp() {
        com.baidu.tieba.s.c.dct().b(getUniqueId(), false);
    }
}
