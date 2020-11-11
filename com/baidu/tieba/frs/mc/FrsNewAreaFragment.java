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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes22.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, as, at, au, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.recapp.n, FrsCommonImageLayout.c {
    private VoiceManager iHo;
    private com.baidu.tbadk.k.c iNC;
    private String jbu;
    private FrsLoadMoreModel jbx;
    private FrsNewAreaModelController jdS;
    private String iHh = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData iGN = new FrsViewData();
    public long ijR = -1;
    public long fvg = 0;
    public long fvq = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean iHB = false;
    protected g jdT = null;
    private int hBL = -1;
    private int iQm = 3;
    private boolean idS = false;
    private boolean jbA = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iHP = new SparseArray<>();
    private int dJG = 0;
    private int iIn = 0;
    private CustomMessageListener iKR = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.iNC != null && FrsNewAreaFragment.this.iNC.isViewAttached()) {
                FrsNewAreaFragment.this.iNC.rC(num.intValue());
            }
        }
    };
    private Runnable jbB = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.idS) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.qi(false);
            }
        }
    };
    private CustomMessageListener jbC = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                bw bwVar = (bw) customResponsedMessage.getData();
                FrsNewAreaFragment.this.jbu = bwVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.jbu) && bwVar.bml() != null) {
                    FrsNewAreaFragment.this.zT(bwVar.bml().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener iIB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.bta() != null) {
                        FrsNewAreaFragment.this.bta().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.iNC != null && FrsNewAreaFragment.this.iNC.isViewAttached()) {
                        FrsNewAreaFragment.this.qi(false);
                    } else if (FrsNewAreaFragment.this.jdT != null) {
                        FrsNewAreaFragment.this.jdT.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final r iIT = new r() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long jbF = 1;

        @Override // com.baidu.tieba.tbadkCore.r
        public void yG(int i) {
            if (!FrsNewAreaFragment.this.jbA) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.jdT.czx();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.jdT.lc(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<q> a2;
            if (FrsNewAreaFragment.this.jbA) {
                if (FrsNewAreaFragment.this.cED().cDN() == null) {
                    FrsNewAreaFragment.this.jbA = false;
                    return;
                } else if (FrsNewAreaFragment.this.cED().cDN().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.jbA = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jbF = 1L;
            } else if (fVar.isSuccess) {
                this.jbF = 0L;
            } else {
                this.jbF = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.jbx.resetData();
            }
            FrsNewAreaFragment.this.jdT.lc(false);
            if (FrsNewAreaFragment.this.cED().cDN() != null) {
                FrsNewAreaFragment.this.iGN = FrsNewAreaFragment.this.cED().cDN();
            }
            FrsNewAreaFragment.this.hBL = FrsNewAreaFragment.this.iGN.getPage().blq();
            if (FrsNewAreaFragment.this.hBL == 0 && (FrsNewAreaFragment.this.iGN.getThreadListIds() == null || FrsNewAreaFragment.this.iGN.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.iGN.getThreadList() == null || FrsNewAreaFragment.this.iGN.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.jdT.bPW();
                } else {
                    FrsNewAreaFragment.this.jdT.Wj();
                }
            } else {
                FrsNewAreaFragment.this.jdT.Wi();
            }
            if (i == 4) {
                ArrayList<q> a3 = FrsNewAreaFragment.this.jbx.a(false, false, false, FrsNewAreaFragment.this.iGN.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsNewAreaFragment.this.iGN.setThreadList(a3);
                    FrsNewAreaFragment.this.jdT.a(a3, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.iGN, FrsNewAreaFragment.this.hBL);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.jdT.czx();
                    break;
                case 2:
                    FrsNewAreaFragment.this.jdT.czx();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.iGN.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.jbF != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.iGN != null) {
                    FrsNewAreaFragment.this.iHh = FrsNewAreaFragment.this.iGN.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.iGN.getForum().getId();
                    FrsNewAreaFragment.this.jdT.b(FrsNewAreaFragment.this.iGN.getForum(), FrsNewAreaFragment.this.iGN.getUserData());
                }
                if (FrsNewAreaFragment.this.iGN != null) {
                    FrsNewAreaFragment.this.iGN.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.iGN == null || FrsNewAreaFragment.this.iGN.getThreadList() == null || FrsNewAreaFragment.this.iGN.getThreadList().size() != 0 || FrsNewAreaFragment.this.cED().getType() != 4) {
                    if (FrsNewAreaFragment.this.iGN != null && (a2 = FrsNewAreaFragment.this.jbx.a(false, false, true, FrsNewAreaFragment.this.iGN.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsNewAreaFragment.this.iGN.setThreadList(a2);
                    }
                    FrsNewAreaFragment.this.cyF();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.ijR > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.ijR, FrsNewAreaFragment.this.cED().csw() - FrsNewAreaFragment.this.ijR, FrsNewAreaFragment.this.cED().csu(), FrsNewAreaFragment.this.cED().csv(), currentTimeMillis2 - FrsNewAreaFragment.this.cED().cst());
                        FrsNewAreaFragment.this.ijR = -1L;
                    }
                    FrsNewAreaFragment.this.fvq = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.ijR > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.ijR, FrsNewAreaFragment.this.cED().csw() - FrsNewAreaFragment.this.ijR, FrsNewAreaFragment.this.cED().csu(), FrsNewAreaFragment.this.cED().csv(), currentTimeMillis3 - FrsNewAreaFragment.this.cED().cst());
                FrsNewAreaFragment.this.ijR = -1L;
            }
            FrsNewAreaFragment.this.fvq = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cyz() {
        }
    };
    private final CustomMessageListener exi = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.jdT != null) {
                FrsNewAreaFragment.this.jdT.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.iHB) {
                FrsNewAreaFragment.this.iHB = true;
                FrsNewAreaFragment.this.jdT.czM();
            }
            if (i == 0) {
                t.cor().oy(true);
                com.baidu.tieba.s.c.dIX().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.iIn += i2;
            if (FrsNewAreaFragment.this.iIn >= FrsNewAreaFragment.this.dJG * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener feV = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
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
    private ab iJa = new ab() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bv)) {
                bw bwVar = ((bv) qVar).exA;
                if (bwVar.bnA() == null || bwVar.bnA().getGroup_id() == 0 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bwVar.bnn() != 1 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Tb(bwVar.getId())) {
                            readThreadHistory.Ta(bwVar.getId());
                            if (FrsNewAreaFragment.this.jdT != null) {
                                FrsNewAreaFragment.this.jdT.czx();
                            }
                        }
                        boolean z = false;
                        final String bmG = bwVar.bmG();
                        if (bmG != null && !bmG.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(bmG);
                                    aaVar.bqN().brt().mIsNeedAddCommenParam = false;
                                    aaVar.bqN().brt().mIsUseCurrentBDUSS = false;
                                    aaVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bwVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bwVar.bmv() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.brr().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bwVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bwVar, FrsNewAreaFragment.this.iHh, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.iGN != null && FrsNewAreaFragment.this.iGN.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.jfB = FrsNewAreaFragment.this.iGN.needLog == 1;
                            bVar.jfD = FrsNewAreaFragment.this.iGN.getForum().getId();
                            bVar.jfC = FrsNewAreaFragment.this.jdS.cEr();
                            if (com.baidu.tieba.frs.d.d.iRl != null) {
                                bVar.jfE = com.baidu.tieba.frs.d.d.iRl.jfE;
                                bVar.jfF = com.baidu.tieba.frs.d.d.iRl.jfF;
                            }
                            com.baidu.tieba.frs.d.a.a(bwVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar, FrsNewAreaFragment.this.getTbPageTag());
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

    public void an(bw bwVar) {
        if (bwVar != null) {
            this.jdS.an(bwVar);
            this.jdT.cxS();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.iGN = frsViewData;
            hideLoadingView(this.jdT.cka());
            if (this.jdT != null) {
                this.jdT.lc(false);
                this.jdT.a(null, this.mPn, this.iGN, this.hBL);
            }
        }
    }

    private void showLoadingView() {
        this.jdT.pR(false);
        showLoadingView(this.jdT.cka(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jdT.pR(true);
        hideLoadingView(this.jdT.cka());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.jdT.pR(false);
        this.jdT.pQ(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jdT.bPW();
        this.jdT.getListView().getData().clear();
        this.jdT.czx();
        if (this.iNC == null) {
            this.iNC = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.iNC.setTitle(null);
            this.iNC.setButtonText(null);
            this.iNC.showRefreshButton();
            this.iNC.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.iNC.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.iNC.setSubText(null);
        }
        this.iNC.onChangeSkinType();
        this.iNC.attachView(this.jdT.cka(), true);
        registerListener(this.iKR);
    }

    private void Wk() {
        this.jdT.pR(true);
        this.jdT.pQ(true);
        if (this.iNC != null && this.iNC.isViewAttached()) {
            this.iNC.dettachView(this.jdT.cka());
        }
        MessageManager.getInstance().unRegisterListener(this.iKR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(boolean z) {
        this.idS = true;
        cyK();
        Wk();
        if (!z) {
            Wk();
            showLoadingView();
        }
        this.jdS.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ijR = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.ijR = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.fvg = this.beginTime - this.ijR;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dIX().z(getUniqueId());
        this.jdS = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.jdS.aj(arguments);
        } else if (bundle != null) {
            this.jdS.aj(bundle);
        } else {
            this.jdS.aj(null);
        }
        this.iHo = getVoiceManager();
        this.iHo.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.exi);
        registerListener(this.jbC);
        registerListener(this.iIB);
        this.jbx = new FrsLoadMoreModel(this, null);
        this.jbx.registerListener();
        this.jbx.setPageType(3);
        this.jbx.qk(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dJG = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jdT = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.idS) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                qi(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        brk();
    }

    private void brk() {
        aq aqVar = new aq("c13008");
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dR("fid", this.forumId);
        aqVar.al("obj_type", 6);
        aqVar.al("obj_locate", 2);
        aqVar.brk();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.iHo = getVoiceManager();
        this.iHo.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cDC();
        if (bundle != null) {
            this.iHh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.iHh = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cDC() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.feV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jdT != null) {
            this.jdT.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iKR);
        com.baidu.tieba.s.c.dIX().A(getUniqueId());
        t.cor().oy(false);
        super.onDestroy();
        this.jdS.cDL();
        this.iHo = getVoiceManager();
        this.iHo.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jbB);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iHh);
        bundle.putString("from", this.mFrom);
        this.jdS.onSaveInstanceState(bundle);
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bw threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jdT.cEF().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.iGN.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.om(intent.getIntExtra("good_data", 0));
                            threadDataById.bny();
                            qi(false);
                            return;
                        } else if (intExtra == 0) {
                            this.iGN.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.iGN.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new s());
                            }
                            this.jdT.cDH();
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
            if (this.iQm == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.idS) {
                com.baidu.adp.lib.f.e.mY().post(this.jbB);
            }
        }
        cAO();
    }

    private void cAO() {
        if (isPrimary()) {
            if (this.iNC != null && this.iNC.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iKR);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iKR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jdT != null) {
            this.jdT.czx();
        }
        this.iHo = getVoiceManager();
        this.iHo.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jdT.a(this.iJa);
        this.jdT.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iQm != 3 || this.jdT != null) {
            this.iQm = i;
            super.onChangeSkinType(i);
            if (this.jdT != null) {
                this.jdT.onChangeSkinType(i);
            }
            if (this.iNC != null && this.iNC.isViewAttached()) {
                this.iNC.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cxz() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cxz();
        }
        return null;
    }

    private void cyE() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.SV(FrsNewAreaFragment.this.iHh);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyF() {
        cyK();
        try {
            if (this.iGN != null) {
                this.jdT.cAY();
                this.jdT.bVq();
                this.iHh = this.iGN.getForum().getName();
                this.forumId = this.iGN.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.iGN.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iGN.getUserData().getBimg_end_time());
                cyE();
                ArrayList<q> threadList = this.iGN.getThreadList();
                if (threadList != null) {
                    this.jdT.a(threadList, this.mPn, this.iGN, this.iGN.getPage().blq());
                    cDE();
                    this.jdT.cDH();
                    if (this.iGN.getIsNewUrl() == 1) {
                        this.jdT.cEF().setFromCDN(true);
                    } else {
                        this.jdT.cEF().setFromCDN(false);
                    }
                    this.jdT.setListViewSelection(cy(cED().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cy(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.iHo = getVoiceManager();
        this.iHo.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.cor().oy(false);
        com.baidu.tieba.s.c.dIX().b(getUniqueId(), false);
        if (this.iGN != null && this.iGN.getForum() != null) {
            com.baidu.tbadk.distribute.a.bzk().b(getPageContext().getPageActivity(), "frs", this.iGN.getForum().getId(), 0L);
        }
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onStop(getPageContext());
        }
    }

    public void cBw() {
        if (this.jdT != null && this.jdT.getListView() != null) {
            this.jdT.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsNewAreaFragment.this.jdT != null && FrsNewAreaFragment.this.jdT.getListView() != null && !FrsNewAreaFragment.this.jdT.getListView().isComputingLayout()) {
                        FrsNewAreaFragment.this.jdT.refreshView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT(int i) {
        ArrayList<q> threadList = this.iGN.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).exA;
                    if (bwVar.getId() != null && bwVar.getId().equals(this.jbu)) {
                        c(bwVar, i);
                        this.jbu = null;
                        break;
                    }
                }
            }
            this.jdT.cEF().b(threadList, this.iGN);
            this.jdT.cEF().notifyDataSetChanged();
        }
    }

    private void c(bw bwVar, int i) {
        if (i == 1) {
            PraiseData bml = bwVar.bml();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bml == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bwVar.a(praiseData);
                    return;
                }
                bwVar.bml().getUser().add(0, metaData);
                bwVar.bml().setNum(bwVar.bml().getNum() + 1);
                bwVar.bml().setIsLike(i);
            }
        } else if (bwVar.bml() != null) {
            bwVar.bml().setIsLike(i);
            bwVar.bml().setNum(bwVar.bml().getNum() - 1);
            ArrayList<MetaData> user = bwVar.bml().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bwVar.bml().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iHo == null) {
            this.iHo = VoiceManager.instance();
        }
        return this.iHo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView bta() {
        if (this.jdT == null) {
            return null;
        }
        return this.jdT.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cyK() {
        this.iHo = getVoiceManager();
        this.iHo.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> btb() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).btb();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.iGN != null && this.jdT != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jdT.czx();
            }
        }
    }

    private void cDE() {
        HashMap<Integer, bw> cCa;
        if (this.jdT != null && this.jdT.cEF() != null && (cCa = this.jdT.cEF().cCa()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bw> entry : cCa.entrySet()) {
                bw value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bzq().L(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        if (bta() == null) {
            return null;
        }
        return bta().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            qi(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cyP() {
        return this.iGN;
    }

    public FrsNewAreaModelController cED() {
        return this.jdS;
    }

    public void KN(String str) {
        this.iHh = str;
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

    public void bOI() {
        if (!this.jbx.isLoading && !this.jdS.isLoading()) {
            if (this.jbx.m40do(this.iGN.getThreadListIds())) {
                this.jdT.a(this.jbx.cEa(), this.mPn, this.iGN, 0);
                this.jbx.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.iGN.getThreadListIds(), this.iHh, this.mPn, this.iGN.isBrandForum);
            } else if (this.hBL != 0) {
                this.jdT.a(this.jbx.cEa(), this.mPn, this.iGN, 0);
                this.mPn++;
                this.jdS.zV(this.mPn);
                this.jbx.loadingDone = false;
                this.jbx.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.jdT.bPW();
        } else if (!this.jdT.czG()) {
            if (!this.jdS.cDP()) {
                this.jdT.bPW();
                return;
            }
            bOX();
            bOI();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bOX();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ax(ArrayList<q> arrayList) {
        bOX();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<q> a2 = this.jbx.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.iGN.setThreadList(a2);
                this.jdT.a(a2, this.mPn, this.iGN, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iGN.getForum()));
        }
    }

    public void dp(List<String> list) {
        dd(list);
        int i = 0;
        Iterator<q> it = this.iGN.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bv ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            bOI();
        }
    }

    private void dd(List<String> list) {
        if (!y.isEmpty(list)) {
            ArrayList<q> threadList = this.iGN.getThreadList();
            if (!y.isEmpty(threadList) && this.jdT.getListView() != null && this.jdT.getListView().getData() != null) {
                Iterator<q> it = threadList.iterator();
                List<q> data = this.jdT.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).exA;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jbx.d(next);
                                this.jdT.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cDD() {
        return this.jbx;
    }

    private void bOX() {
        if (this.hBL == 0 && !this.jbx.m40do(this.iGN.getThreadListIds())) {
            if (this.iGN.getThreadList() == null || this.iGN.getThreadList().size() == 0) {
                this.jdT.bPW();
                return;
            } else {
                this.jdT.Wj();
                return;
            }
        }
        this.jdT.Wi();
    }

    public g cEE() {
        return this.jdT;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0250a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ae.checkCamera(getActivity().getApplicationContext())) {
                ao.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
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
        com.baidu.tbadk.distribute.a.bzk().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void cyJ() {
        if (this.jdS != null) {
            this.jdS.cyJ();
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

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bSH() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iHh;
    }

    @Override // com.baidu.tieba.frs.as
    public void cxS() {
        if (this.jdT != null && this.jdT.getListView() != null) {
            this.jdT.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bPV() {
        if (this.jdT != null) {
            cxS();
            this.jdT.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iHP.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ta(int i) {
        return this.iHP.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.iGN != null) {
            i = this.iGN.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.i.At(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.au
    public void bsB() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bIR().EY("page_frs_good");
            qi(true);
            return;
        }
        this.jdT.lc(false);
    }

    @Override // com.baidu.tieba.frs.au
    public void bsC() {
        com.baidu.tieba.s.c.dIX().b(getUniqueId(), false);
    }
}
