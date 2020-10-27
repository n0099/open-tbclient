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
    private VoiceManager iBr;
    private com.baidu.tbadk.k.c iHF;
    private FrsLoadMoreModel iVA;
    private String iVx;
    private FrsNewAreaModelController iXV;
    private String iBk = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData iAQ = new FrsViewData();
    public long idU = -1;
    public long fpl = 0;
    public long fpw = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean iBE = false;
    protected g iXW = null;
    private int hvO = -1;
    private int iKp = 3;
    private boolean hXR = false;
    private boolean iVD = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iBS = new SparseArray<>();
    private int dDO = 0;
    private int iCq = 0;
    private CustomMessageListener iEU = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.iHF != null && FrsNewAreaFragment.this.iHF.isViewAttached()) {
                FrsNewAreaFragment.this.iHF.rs(num.intValue());
            }
        }
    };
    private Runnable iVE = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.hXR) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.pZ(false);
            }
        }
    };
    private CustomMessageListener iVF = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                bw bwVar = (bw) customResponsedMessage.getData();
                FrsNewAreaFragment.this.iVx = bwVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.iVx) && bwVar.bjL() != null) {
                    FrsNewAreaFragment.this.zG(bwVar.bjL().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener iCE = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.bqA() != null) {
                        FrsNewAreaFragment.this.bqA().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.iHF != null && FrsNewAreaFragment.this.iHF.isViewAttached()) {
                        FrsNewAreaFragment.this.pZ(false);
                    } else if (FrsNewAreaFragment.this.iXW != null) {
                        FrsNewAreaFragment.this.iXW.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final r iCW = new r() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long iVI = 1;

        @Override // com.baidu.tieba.tbadkCore.r
        public void yt(int i) {
            if (!FrsNewAreaFragment.this.iVD) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.iXW.cwW();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.iXW.kT(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<q> a2;
            if (FrsNewAreaFragment.this.iVD) {
                if (FrsNewAreaFragment.this.cCc().cBm() == null) {
                    FrsNewAreaFragment.this.iVD = false;
                    return;
                } else if (FrsNewAreaFragment.this.cCc().cBm().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.iVD = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.iVI = 1L;
            } else if (fVar.isSuccess) {
                this.iVI = 0L;
            } else {
                this.iVI = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.iVA.resetData();
            }
            FrsNewAreaFragment.this.iXW.kT(false);
            if (FrsNewAreaFragment.this.cCc().cBm() != null) {
                FrsNewAreaFragment.this.iAQ = FrsNewAreaFragment.this.cCc().cBm();
            }
            FrsNewAreaFragment.this.hvO = FrsNewAreaFragment.this.iAQ.getPage().biQ();
            if (FrsNewAreaFragment.this.hvO == 0 && (FrsNewAreaFragment.this.iAQ.getThreadListIds() == null || FrsNewAreaFragment.this.iAQ.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.iAQ.getThreadList() == null || FrsNewAreaFragment.this.iAQ.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.iXW.bNw();
                } else {
                    FrsNewAreaFragment.this.iXW.TJ();
                }
            } else {
                FrsNewAreaFragment.this.iXW.TI();
            }
            if (i == 4) {
                ArrayList<q> a3 = FrsNewAreaFragment.this.iVA.a(false, false, false, FrsNewAreaFragment.this.iAQ.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsNewAreaFragment.this.iAQ.setThreadList(a3);
                    FrsNewAreaFragment.this.iXW.a(a3, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.iAQ, FrsNewAreaFragment.this.hvO);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.iXW.cwW();
                    break;
                case 2:
                    FrsNewAreaFragment.this.iXW.cwW();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.iAQ.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.iVI != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.iAQ != null) {
                    FrsNewAreaFragment.this.iBk = FrsNewAreaFragment.this.iAQ.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.iAQ.getForum().getId();
                    FrsNewAreaFragment.this.iXW.b(FrsNewAreaFragment.this.iAQ.getForum(), FrsNewAreaFragment.this.iAQ.getUserData());
                }
                if (FrsNewAreaFragment.this.iAQ != null) {
                    FrsNewAreaFragment.this.iAQ.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.iAQ == null || FrsNewAreaFragment.this.iAQ.getThreadList() == null || FrsNewAreaFragment.this.iAQ.getThreadList().size() != 0 || FrsNewAreaFragment.this.cCc().getType() != 4) {
                    if (FrsNewAreaFragment.this.iAQ != null && (a2 = FrsNewAreaFragment.this.iVA.a(false, false, true, FrsNewAreaFragment.this.iAQ.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsNewAreaFragment.this.iAQ.setThreadList(a2);
                    }
                    FrsNewAreaFragment.this.cwe();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.idU > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.idU, FrsNewAreaFragment.this.cCc().cpV() - FrsNewAreaFragment.this.idU, FrsNewAreaFragment.this.cCc().cpT(), FrsNewAreaFragment.this.cCc().cpU(), currentTimeMillis2 - FrsNewAreaFragment.this.cCc().cpS());
                        FrsNewAreaFragment.this.idU = -1L;
                    }
                    FrsNewAreaFragment.this.fpw = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.idU > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.idU, FrsNewAreaFragment.this.cCc().cpV() - FrsNewAreaFragment.this.idU, FrsNewAreaFragment.this.cCc().cpT(), FrsNewAreaFragment.this.cCc().cpU(), currentTimeMillis3 - FrsNewAreaFragment.this.cCc().cpS());
                FrsNewAreaFragment.this.idU = -1L;
            }
            FrsNewAreaFragment.this.fpw = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cvY() {
        }
    };
    private final CustomMessageListener erp = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.iXW != null) {
                FrsNewAreaFragment.this.iXW.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.iBE) {
                FrsNewAreaFragment.this.iBE = true;
                FrsNewAreaFragment.this.iXW.cxl();
            }
            if (i == 0) {
                t.clQ().op(true);
                com.baidu.tieba.s.c.dGv().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.iCq += i2;
            if (FrsNewAreaFragment.this.iCq >= FrsNewAreaFragment.this.dDO * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener eZe = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
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
    private ab iDd = new ab() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bv)) {
                bw bwVar = ((bv) qVar).erH;
                if (bwVar.bla() == null || bwVar.bla().getGroup_id() == 0 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bwVar.bkN() != 1 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.SK(bwVar.getId())) {
                            readThreadHistory.SJ(bwVar.getId());
                            if (FrsNewAreaFragment.this.iXW != null) {
                                FrsNewAreaFragment.this.iXW.cwW();
                            }
                        }
                        boolean z = false;
                        final String bkg = bwVar.bkg();
                        if (bkg != null && !bkg.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(bkg);
                                    aaVar.bon().boT().mIsNeedAddCommenParam = false;
                                    aaVar.bon().boT().mIsUseCurrentBDUSS = false;
                                    aaVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bwVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bwVar.bjV() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.boR().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bwVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bwVar, FrsNewAreaFragment.this.iBk, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.iAQ != null && FrsNewAreaFragment.this.iAQ.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.iZE = FrsNewAreaFragment.this.iAQ.needLog == 1;
                            bVar.iZG = FrsNewAreaFragment.this.iAQ.getForum().getId();
                            bVar.iZF = FrsNewAreaFragment.this.iXV.cBQ();
                            if (com.baidu.tieba.frs.d.d.iLo != null) {
                                bVar.iZH = com.baidu.tieba.frs.d.d.iLo.iZH;
                                bVar.iZI = com.baidu.tieba.frs.d.d.iLo.iZI;
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
            this.iXV.an(bwVar);
            this.iXW.cvr();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.iAQ = frsViewData;
            hideLoadingView(this.iXW.chy());
            if (this.iXW != null) {
                this.iXW.kT(false);
                this.iXW.a(null, this.mPn, this.iAQ, this.hvO);
            }
        }
    }

    private void showLoadingView() {
        this.iXW.pI(false);
        showLoadingView(this.iXW.chy(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.iXW.pI(true);
        hideLoadingView(this.iXW.chy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.iXW.pI(false);
        this.iXW.pH(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.iXW.bNw();
        this.iXW.getListView().getData().clear();
        this.iXW.cwW();
        if (this.iHF == null) {
            this.iHF = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.iHF.setTitle(null);
            this.iHF.setButtonText(null);
            this.iHF.showRefreshButton();
            this.iHF.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.iHF.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.iHF.setSubText(null);
        }
        this.iHF.onChangeSkinType();
        this.iHF.attachView(this.iXW.chy(), true);
        registerListener(this.iEU);
    }

    private void TK() {
        this.iXW.pI(true);
        this.iXW.pH(true);
        if (this.iHF != null && this.iHF.isViewAttached()) {
            this.iHF.dettachView(this.iXW.chy());
        }
        MessageManager.getInstance().unRegisterListener(this.iEU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ(boolean z) {
        this.hXR = true;
        cwj();
        TK();
        if (!z) {
            TK();
            showLoadingView();
        }
        this.iXV.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.idU = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.idU = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.fpl = this.beginTime - this.idU;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dGv().z(getUniqueId());
        this.iXV = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.iXV.aj(arguments);
        } else if (bundle != null) {
            this.iXV.aj(bundle);
        } else {
            this.iXV.aj(null);
        }
        this.iBr = getVoiceManager();
        this.iBr.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.erp);
        registerListener(this.iVF);
        registerListener(this.iCE);
        this.iVA = new FrsLoadMoreModel(this, null);
        this.iVA.registerListener();
        this.iVA.setPageType(3);
        this.iVA.qb(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dDO = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.iXW = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.hXR) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                pZ(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        boK();
    }

    private void boK() {
        aq aqVar = new aq("c13008");
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dR("fid", this.forumId);
        aqVar.aj("obj_type", 6);
        aqVar.aj("obj_locate", 2);
        aqVar.boK();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.iBr = getVoiceManager();
        this.iBr.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cBb();
        if (bundle != null) {
            this.iBk = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.iBk = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cBb() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eZe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.iXW != null) {
            this.iXW.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iEU);
        com.baidu.tieba.s.c.dGv().A(getUniqueId());
        t.clQ().op(false);
        super.onDestroy();
        this.iXV.cBk();
        this.iBr = getVoiceManager();
        this.iBr.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iVE);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iBk);
        bundle.putString("from", this.mFrom);
        this.iXV.onSaveInstanceState(bundle);
        this.iBr = getVoiceManager();
        if (this.iBr != null) {
            this.iBr.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bw threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.iXW.cCe().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.iAQ.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.oc(intent.getIntExtra("good_data", 0));
                            threadDataById.bkY();
                            pZ(false);
                            return;
                        } else if (intExtra == 0) {
                            this.iAQ.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.iAQ.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new s());
                            }
                            this.iXW.cBg();
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
            if (this.iKp == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.hXR) {
                com.baidu.adp.lib.f.e.mY().post(this.iVE);
            }
        }
        cyn();
    }

    private void cyn() {
        if (isPrimary()) {
            if (this.iHF != null && this.iHF.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iEU);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iEU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iXW != null) {
            this.iXW.cwW();
        }
        this.iBr = getVoiceManager();
        this.iBr.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.iXW.a(this.iDd);
        this.iXW.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iKp != 3 || this.iXW != null) {
            this.iKp = i;
            super.onChangeSkinType(i);
            if (this.iXW != null) {
                this.iXW.onChangeSkinType(i);
            }
            if (this.iHF != null && this.iHF.isViewAttached()) {
                this.iHF.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cuY() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cuY();
        }
        return null;
    }

    private void cwd() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.SE(FrsNewAreaFragment.this.iBk);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwe() {
        cwj();
        try {
            if (this.iAQ != null) {
                this.iXW.cyx();
                this.iXW.bSR();
                this.iBk = this.iAQ.getForum().getName();
                this.forumId = this.iAQ.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.iAQ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iAQ.getUserData().getBimg_end_time());
                cwd();
                ArrayList<q> threadList = this.iAQ.getThreadList();
                if (threadList != null) {
                    this.iXW.a(threadList, this.mPn, this.iAQ, this.iAQ.getPage().biQ());
                    cBd();
                    this.iXW.cBg();
                    if (this.iAQ.getIsNewUrl() == 1) {
                        this.iXW.cCe().setFromCDN(true);
                    } else {
                        this.iXW.cCe().setFromCDN(false);
                    }
                    this.iXW.setListViewSelection(cw(cCc().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cw(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.iBr = getVoiceManager();
        this.iBr.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.clQ().op(false);
        com.baidu.tieba.s.c.dGv().b(getUniqueId(), false);
        if (this.iAQ != null && this.iAQ.getForum() != null) {
            com.baidu.tbadk.distribute.a.bwL().b(getPageContext().getPageActivity(), "frs", this.iAQ.getForum().getId(), 0L);
        }
        this.iBr = getVoiceManager();
        if (this.iBr != null) {
            this.iBr.onStop(getPageContext());
        }
    }

    public void cyV() {
        if (this.iXW != null && this.iXW.getListView() != null) {
            this.iXW.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsNewAreaFragment.this.iXW != null && FrsNewAreaFragment.this.iXW.getListView() != null && !FrsNewAreaFragment.this.iXW.getListView().isComputingLayout()) {
                        FrsNewAreaFragment.this.iXW.refreshView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zG(int i) {
        ArrayList<q> threadList = this.iAQ.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).erH;
                    if (bwVar.getId() != null && bwVar.getId().equals(this.iVx)) {
                        c(bwVar, i);
                        this.iVx = null;
                        break;
                    }
                }
            }
            this.iXW.cCe().b(threadList, this.iAQ);
            this.iXW.cCe().notifyDataSetChanged();
        }
    }

    private void c(bw bwVar, int i) {
        if (i == 1) {
            PraiseData bjL = bwVar.bjL();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bjL == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bwVar.a(praiseData);
                    return;
                }
                bwVar.bjL().getUser().add(0, metaData);
                bwVar.bjL().setNum(bwVar.bjL().getNum() + 1);
                bwVar.bjL().setIsLike(i);
            }
        } else if (bwVar.bjL() != null) {
            bwVar.bjL().setIsLike(i);
            bwVar.bjL().setNum(bwVar.bjL().getNum() - 1);
            ArrayList<MetaData> user = bwVar.bjL().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bwVar.bjL().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iBr == null) {
            this.iBr = VoiceManager.instance();
        }
        return this.iBr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView bqA() {
        if (this.iXW == null) {
            return null;
        }
        return this.iXW.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cwj() {
        this.iBr = getVoiceManager();
        this.iBr.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bqB() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bqB();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.iAQ != null && this.iXW != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.iXW.cwW();
            }
        }
    }

    private void cBd() {
        HashMap<Integer, bw> czz;
        if (this.iXW != null && this.iXW.cCe() != null && (czz = this.iXW.cCe().czz()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bw> entry : czz.entrySet()) {
                bw value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bwR().L(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        if (bqA() == null) {
            return null;
        }
        return bqA().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            pZ(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cwo() {
        return this.iAQ;
    }

    public FrsNewAreaModelController cCc() {
        return this.iXV;
    }

    public void Kw(String str) {
        this.iBk = str;
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

    public void bMi() {
        if (!this.iVA.isLoading && !this.iXV.isLoading()) {
            if (this.iVA.dg(this.iAQ.getThreadListIds())) {
                this.iXW.a(this.iVA.cBz(), this.mPn, this.iAQ, 0);
                this.iVA.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.iAQ.getThreadListIds(), this.iBk, this.mPn, this.iAQ.isBrandForum);
            } else if (this.hvO != 0) {
                this.iXW.a(this.iVA.cBz(), this.mPn, this.iAQ, 0);
                this.mPn++;
                this.iXV.zI(this.mPn);
                this.iVA.loadingDone = false;
                this.iVA.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.iXW.bNw();
        } else if (!this.iXW.cxf()) {
            if (!this.iXV.cBo()) {
                this.iXW.bNw();
                return;
            }
            bMx();
            bMi();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bMx();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ax(ArrayList<q> arrayList) {
        bMx();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<q> a2 = this.iVA.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.iAQ.setThreadList(a2);
                this.iXW.a(a2, this.mPn, this.iAQ, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iAQ.getForum()));
        }
    }

    public void dh(List<String> list) {
        cV(list);
        int i = 0;
        Iterator<q> it = this.iAQ.getThreadList().iterator();
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
            bMi();
        }
    }

    private void cV(List<String> list) {
        if (!y.isEmpty(list)) {
            ArrayList<q> threadList = this.iAQ.getThreadList();
            if (!y.isEmpty(threadList) && this.iXW.getListView() != null && this.iXW.getListView().getData() != null) {
                Iterator<q> it = threadList.iterator();
                List<q> data = this.iXW.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).erH;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iVA.d(next);
                                this.iXW.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cBc() {
        return this.iVA;
    }

    private void bMx() {
        if (this.hvO == 0 && !this.iVA.dg(this.iAQ.getThreadListIds())) {
            if (this.iAQ.getThreadList() == null || this.iAQ.getThreadList().size() == 0) {
                this.iXW.bNw();
                return;
            } else {
                this.iXW.TJ();
                return;
            }
        }
        this.iXW.TI();
    }

    public g cCd() {
        return this.iXW;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0238a
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
        com.baidu.tbadk.distribute.a.bwL().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void cwi() {
        if (this.iXV != null) {
            this.iXV.cwi();
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
    public NavigationBar bQh() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iBk;
    }

    @Override // com.baidu.tieba.frs.as
    public void cvr() {
        if (this.iXW != null && this.iXW.getListView() != null) {
            this.iXW.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bNv() {
        if (this.iXW != null) {
            cvr();
            this.iXW.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iBS.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sQ(int i) {
        return this.iBS.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.iAQ != null) {
            i = this.iAQ.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.i.Ag(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.au
    public void bqb() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bGs().EK("page_frs_good");
            pZ(true);
            return;
        }
        this.iXW.kT(false);
    }

    @Override // com.baidu.tieba.frs.au
    public void bqc() {
        com.baidu.tieba.s.c.dGv().b(getUniqueId(), false);
    }
}
