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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
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
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes21.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, as, at, au, com.baidu.tieba.frs.loadmore.a, o, FrsCommonImageLayout.c {
    private VoiceManager iIc;
    private com.baidu.tbadk.k.c iOp;
    private String jcg;
    private FrsLoadMoreModel jcj;
    private FrsNewAreaModelController jeF;
    private String iHV = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData iHB = new FrsViewData();
    public long ikF = -1;
    public long fuq = 0;
    public long fuA = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean iIp = false;
    protected g jeG = null;
    private int hBs = -1;
    private int iQZ = 3;
    private boolean ieH = false;
    private boolean jcm = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iID = new SparseArray<>();
    private int dHY = 0;
    private int iJb = 0;
    private CustomMessageListener iLE = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.iOp != null && FrsNewAreaFragment.this.iOp.isViewAttached()) {
                FrsNewAreaFragment.this.iOp.sa(num.intValue());
            }
        }
    };
    private Runnable jcn = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.ieH) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.ql(false);
            }
        }
    };
    private CustomMessageListener jco = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bx)) {
                bx bxVar = (bx) customResponsedMessage.getData();
                FrsNewAreaFragment.this.jcg = bxVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.jcg) && bxVar.bln() != null) {
                    FrsNewAreaFragment.this.Ar(bxVar.bln().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener iJp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.bsq() != null) {
                        FrsNewAreaFragment.this.bsq().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.iOp != null && FrsNewAreaFragment.this.iOp.isViewAttached()) {
                        FrsNewAreaFragment.this.ql(false);
                    } else if (FrsNewAreaFragment.this.jeG != null) {
                        FrsNewAreaFragment.this.jeG.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final r iJH = new r() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long jcr = 1;

        @Override // com.baidu.tieba.tbadkCore.r
        public void ze(int i) {
            if (!FrsNewAreaFragment.this.jcm) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.jeG.cza();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.jeG.ld(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<q> a2;
            if (FrsNewAreaFragment.this.jcm) {
                if (FrsNewAreaFragment.this.cEh().cDr() == null) {
                    FrsNewAreaFragment.this.jcm = false;
                    return;
                } else if (FrsNewAreaFragment.this.cEh().cDr().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.jcm = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jcr = 1L;
            } else if (fVar.isSuccess) {
                this.jcr = 0L;
            } else {
                this.jcr = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.jcj.resetData();
            }
            FrsNewAreaFragment.this.jeG.ld(false);
            if (FrsNewAreaFragment.this.cEh().cDr() != null) {
                FrsNewAreaFragment.this.iHB = FrsNewAreaFragment.this.cEh().cDr();
            }
            FrsNewAreaFragment.this.hBs = FrsNewAreaFragment.this.iHB.getPage().bks();
            if (FrsNewAreaFragment.this.hBs == 0 && (FrsNewAreaFragment.this.iHB.getThreadListIds() == null || FrsNewAreaFragment.this.iHB.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.iHB.getThreadList() == null || FrsNewAreaFragment.this.iHB.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.jeG.bPp();
                } else {
                    FrsNewAreaFragment.this.jeG.VA();
                }
            } else {
                FrsNewAreaFragment.this.jeG.Vz();
            }
            if (i == 4) {
                ArrayList<q> a3 = FrsNewAreaFragment.this.jcj.a(false, false, false, FrsNewAreaFragment.this.iHB.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsNewAreaFragment.this.iHB.setThreadList(a3);
                    FrsNewAreaFragment.this.jeG.a(a3, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.iHB, FrsNewAreaFragment.this.hBs);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.jeG.cza();
                    break;
                case 2:
                    FrsNewAreaFragment.this.jeG.cza();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.iHB.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.jcr != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.iHB != null) {
                    FrsNewAreaFragment.this.iHV = FrsNewAreaFragment.this.iHB.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.iHB.getForum().getId();
                    FrsNewAreaFragment.this.jeG.b(FrsNewAreaFragment.this.iHB.getForum(), FrsNewAreaFragment.this.iHB.getUserData());
                }
                if (FrsNewAreaFragment.this.iHB != null) {
                    FrsNewAreaFragment.this.iHB.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.iHB == null || FrsNewAreaFragment.this.iHB.getThreadList() == null || FrsNewAreaFragment.this.iHB.getThreadList().size() != 0 || FrsNewAreaFragment.this.cEh().getType() != 4) {
                    if (FrsNewAreaFragment.this.iHB != null && (a2 = FrsNewAreaFragment.this.jcj.a(false, false, true, FrsNewAreaFragment.this.iHB.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsNewAreaFragment.this.iHB.setThreadList(a2);
                    }
                    FrsNewAreaFragment.this.cyi();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.ikF > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.ikF, FrsNewAreaFragment.this.cEh().crZ() - FrsNewAreaFragment.this.ikF, FrsNewAreaFragment.this.cEh().crX(), FrsNewAreaFragment.this.cEh().crY(), currentTimeMillis2 - FrsNewAreaFragment.this.cEh().crW());
                        FrsNewAreaFragment.this.ikF = -1L;
                    }
                    FrsNewAreaFragment.this.fuA = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.ikF > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.ikF, FrsNewAreaFragment.this.cEh().crZ() - FrsNewAreaFragment.this.ikF, FrsNewAreaFragment.this.cEh().crX(), FrsNewAreaFragment.this.cEh().crY(), currentTimeMillis3 - FrsNewAreaFragment.this.cEh().crW());
                FrsNewAreaFragment.this.ikF = -1L;
            }
            FrsNewAreaFragment.this.fuA = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cyc() {
        }
    };
    private final CustomMessageListener evz = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.jeG != null) {
                FrsNewAreaFragment.this.jeG.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.iIp) {
                FrsNewAreaFragment.this.iIp = true;
                FrsNewAreaFragment.this.jeG.czp();
            }
            if (i == 0) {
                t.cnT().oB(true);
                com.baidu.tieba.t.c.dIO().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.iJb += i2;
            if (FrsNewAreaFragment.this.iJb >= FrsNewAreaFragment.this.dHY * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener fed = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
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
    private ab iJO = new ab() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bw)) {
                bx bxVar = ((bw) qVar).evQ;
                if (bxVar.bmE() == null || bxVar.bmE().getGroup_id() == 0 || bh.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bxVar.bmp() != 1 || bh.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.SM(bxVar.getId())) {
                            readThreadHistory.SL(bxVar.getId());
                            if (FrsNewAreaFragment.this.jeG != null) {
                                FrsNewAreaFragment.this.jeG.cza();
                            }
                        }
                        boolean z = false;
                        final String blI = bxVar.blI();
                        if (blI != null && !blI.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(blI);
                                    aaVar.bqa().bqH().mIsNeedAddCommenParam = false;
                                    aaVar.bqa().bqH().mIsUseCurrentBDUSS = false;
                                    aaVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bxVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bxVar.blx() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bf.bqF().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bxVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bxVar, FrsNewAreaFragment.this.iHV, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bxVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.iHB != null && FrsNewAreaFragment.this.iHB.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.jgm = FrsNewAreaFragment.this.iHB.needLog == 1;
                            bVar.jgo = FrsNewAreaFragment.this.iHB.getForum().getId();
                            bVar.jgn = FrsNewAreaFragment.this.jeF.cDV();
                            if (com.baidu.tieba.frs.d.d.iRY != null) {
                                bVar.jgp = com.baidu.tieba.frs.d.d.iRY.jgp;
                                bVar.jgq = com.baidu.tieba.frs.d.d.iRY.jgq;
                            }
                            com.baidu.tieba.frs.d.a.a(bxVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar, FrsNewAreaFragment.this.getTbPageTag());
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

    public void ap(bx bxVar) {
        if (bxVar != null) {
            this.jeF.ap(bxVar);
            this.jeG.cxv();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.iHB = frsViewData;
            hideLoadingView(this.jeG.cjt());
            if (this.jeG != null) {
                this.jeG.ld(false);
                this.jeG.a(null, this.mPn, this.iHB, this.hBs);
            }
        }
    }

    private void showLoadingView() {
        this.jeG.pU(false);
        showLoadingView(this.jeG.cjt(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jeG.pU(true);
        hideLoadingView(this.jeG.cjt());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.jeG.pU(false);
        this.jeG.pT(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jeG.bPp();
        this.jeG.getListView().getData().clear();
        this.jeG.cza();
        if (this.iOp == null) {
            this.iOp = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.iOp.setTitle(null);
            this.iOp.setButtonText(null);
            this.iOp.showRefreshButton();
            this.iOp.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.iOp.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.iOp.setSubText(null);
        }
        this.iOp.onChangeSkinType();
        this.iOp.attachView(this.jeG.cjt(), true);
        registerListener(this.iLE);
    }

    private void VB() {
        this.jeG.pU(true);
        this.jeG.pT(true);
        if (this.iOp != null && this.iOp.isViewAttached()) {
            this.iOp.dettachView(this.jeG.cjt());
        }
        MessageManager.getInstance().unRegisterListener(this.iLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ql(boolean z) {
        this.ieH = true;
        cyn();
        VB();
        if (!z) {
            VB();
            showLoadingView();
        }
        this.jeF.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ikF = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.ikF = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.fuq = this.beginTime - this.ikF;
        super.onCreate(bundle);
        com.baidu.tieba.t.c.dIO().z(getUniqueId());
        this.jeF = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.jeF.aj(arguments);
        } else if (bundle != null) {
            this.jeF.aj(bundle);
        } else {
            this.jeF.aj(null);
        }
        this.iIc = getVoiceManager();
        this.iIc.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.evz);
        registerListener(this.jco);
        registerListener(this.iJp);
        this.jcj = new FrsLoadMoreModel(this, null);
        this.jcj.registerListener();
        this.jcj.setPageType(3);
        this.jcj.qn(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dHY = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jeG = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.ieH) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                ql(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bqy();
    }

    private void bqy() {
        ar arVar = new ar("c13008");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("fid", this.forumId);
        arVar.ak("obj_type", 6);
        arVar.ak("obj_locate", 2);
        arVar.bqy();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.iIc = getVoiceManager();
        this.iIc.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cDg();
        if (bundle != null) {
            this.iHV = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.iHV = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cDg() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fed);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jeG != null) {
            this.jeG.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iLE);
        com.baidu.tieba.t.c.dIO().A(getUniqueId());
        t.cnT().oB(false);
        super.onDestroy();
        this.jeF.cDp();
        this.iIc = getVoiceManager();
        this.iIc.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jcn);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iHV);
        bundle.putString("from", this.mFrom);
        this.jeF.onSaveInstanceState(bundle);
        this.iIc = getVoiceManager();
        if (this.iIc != null) {
            this.iIc.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bx threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jeG.cEj().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.iHB.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.oi(intent.getIntExtra("good_data", 0));
                            threadDataById.bmC();
                            ql(false);
                            return;
                        } else if (intExtra == 0) {
                            this.iHB.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.iHB.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new s());
                            }
                            this.jeG.cDl();
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
            if (this.iQZ == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.ieH) {
                com.baidu.adp.lib.f.e.mY().post(this.jcn);
            }
        }
        cAr();
    }

    private void cAr() {
        if (isPrimary()) {
            if (this.iOp != null && this.iOp.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iLE);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iLE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jeG != null) {
            this.jeG.cza();
        }
        this.iIc = getVoiceManager();
        this.iIc.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jeG.a(this.iJO);
        this.jeG.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iQZ != 3 || this.jeG != null) {
            this.iQZ = i;
            super.onChangeSkinType(i);
            if (this.jeG != null) {
                this.jeG.onChangeSkinType(i);
            }
            if (this.iOp != null && this.iOp.isViewAttached()) {
                this.iOp.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cxc() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cxc();
        }
        return null;
    }

    private void cyh() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.SG(FrsNewAreaFragment.this.iHV);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyi() {
        cyn();
        try {
            if (this.iHB != null) {
                this.jeG.cAB();
                this.jeG.bUJ();
                this.iHV = this.iHB.getForum().getName();
                this.forumId = this.iHB.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.iHB.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iHB.getUserData().getBimg_end_time());
                cyh();
                ArrayList<q> threadList = this.iHB.getThreadList();
                if (threadList != null) {
                    this.jeG.a(threadList, this.mPn, this.iHB, this.iHB.getPage().bks());
                    cDi();
                    this.jeG.cDl();
                    if (this.iHB.getIsNewUrl() == 1) {
                        this.jeG.cEj().setFromCDN(true);
                    } else {
                        this.jeG.cEj().setFromCDN(false);
                    }
                    this.jeG.setListViewSelection(cy(cEh().getType(), this.mPn));
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
        this.iIc = getVoiceManager();
        this.iIc.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.cnT().oB(false);
        com.baidu.tieba.t.c.dIO().b(getUniqueId(), false);
        if (this.iHB != null && this.iHB.getForum() != null) {
            com.baidu.tbadk.distribute.a.byA().b(getPageContext().getPageActivity(), "frs", this.iHB.getForum().getId(), 0L);
        }
        this.iIc = getVoiceManager();
        if (this.iIc != null) {
            this.iIc.onStop(getPageContext());
        }
    }

    public void cAZ() {
        if (this.jeG != null && this.jeG.getListView() != null) {
            this.jeG.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsNewAreaFragment.this.jeG != null && FrsNewAreaFragment.this.jeG.getListView() != null && !FrsNewAreaFragment.this.jeG.getListView().isComputingLayout()) {
                        FrsNewAreaFragment.this.jeG.refreshView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ar(int i) {
        ArrayList<q> threadList = this.iHB.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bw) {
                    bx bxVar = ((bw) next).evQ;
                    if (bxVar.getId() != null && bxVar.getId().equals(this.jcg)) {
                        c(bxVar, i);
                        this.jcg = null;
                        break;
                    }
                }
            }
            this.jeG.cEj().b(threadList, this.iHB);
            this.jeG.cEj().notifyDataSetChanged();
        }
    }

    private void c(bx bxVar, int i) {
        if (i == 1) {
            PraiseData bln = bxVar.bln();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bln == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bxVar.a(praiseData);
                    return;
                }
                bxVar.bln().getUser().add(0, metaData);
                bxVar.bln().setNum(bxVar.bln().getNum() + 1);
                bxVar.bln().setIsLike(i);
            }
        } else if (bxVar.bln() != null) {
            bxVar.bln().setIsLike(i);
            bxVar.bln().setNum(bxVar.bln().getNum() - 1);
            ArrayList<MetaData> user = bxVar.bln().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bxVar.bln().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iIc == null) {
            this.iIc = VoiceManager.instance();
        }
        return this.iIc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView bsq() {
        if (this.jeG == null) {
            return null;
        }
        return this.jeG.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cyn() {
        this.iIc = getVoiceManager();
        this.iIc.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bsr() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bsr();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.iHB != null && this.jeG != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jeG.cza();
            }
        }
    }

    private void cDi() {
        HashMap<Integer, bx> cBD;
        if (this.jeG != null && this.jeG.cEj() != null && (cBD = this.jeG.cEj().cBD()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bx> entry : cBD.entrySet()) {
                bx value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.byG().L(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        if (bsq() == null) {
            return null;
        }
        return bsq().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            ql(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cys() {
        return this.iHB;
    }

    public FrsNewAreaModelController cEh() {
        return this.jeF;
    }

    public void Ko(String str) {
        this.iHV = str;
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

    public void bOb() {
        if (!this.jcj.isLoading && !this.jeF.isLoading()) {
            if (this.jcj.m40do(this.iHB.getThreadListIds())) {
                this.jeG.a(this.jcj.cDE(), this.mPn, this.iHB, 0);
                this.jcj.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.iHB.getThreadListIds(), this.iHV, this.mPn, this.iHB.isBrandForum);
            } else if (this.hBs != 0) {
                this.jeG.a(this.jcj.cDE(), this.mPn, this.iHB, 0);
                this.mPn++;
                this.jeF.At(this.mPn);
                this.jcj.loadingDone = false;
                this.jcj.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.jeG.bPp();
        } else if (!this.jeG.czj()) {
            if (!this.jeF.cDt()) {
                this.jeG.bPp();
                return;
            }
            bOq();
            bOb();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bOq();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ay(ArrayList<q> arrayList) {
        bOq();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<q> a2 = this.jcj.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.iHB.setThreadList(a2);
                this.jeG.a(a2, this.mPn, this.iHB, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iHB.getForum()));
        }
    }

    public void dp(List<String> list) {
        dd(list);
        int i = 0;
        Iterator<q> it = this.iHB.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bw ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            bOb();
        }
    }

    private void dd(List<String> list) {
        if (!y.isEmpty(list)) {
            ArrayList<q> threadList = this.iHB.getThreadList();
            if (!y.isEmpty(threadList) && this.jeG.getListView() != null && this.jeG.getListView().getData() != null) {
                Iterator<q> it = threadList.iterator();
                List<q> data = this.jeG.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bw) {
                        bx bxVar = ((bw) next).evQ;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.au.equals(list.get(i2), bxVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jcj.d(next);
                                this.jeG.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cDh() {
        return this.jcj;
    }

    private void bOq() {
        if (this.hBs == 0 && !this.jcj.m40do(this.iHB.getThreadListIds())) {
            if (this.iHB.getThreadList() == null || this.iHB.getThreadList().size() == 0) {
                this.jeG.bPp();
                return;
            } else {
                this.jeG.VA();
                return;
            }
        }
        this.jeG.Vz();
    }

    public g cEi() {
        return this.jeG;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0248a
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

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.byA().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.o
    public void cym() {
        if (this.jeF != null) {
            this.jeF.cym();
        }
    }

    @Override // com.baidu.tieba.recapp.o
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.o
    public int getPageNum() {
        return this.mPn;
    }

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bSa() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iHV;
    }

    @Override // com.baidu.tieba.frs.as
    public void cxv() {
        if (this.jeG != null && this.jeG.getListView() != null) {
            this.jeG.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bPo() {
        if (this.jeG != null) {
            cxv();
            this.jeG.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iID.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ty(int i) {
        return this.iID.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.iHB != null) {
            i = this.iHB.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.i.AR(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.au
    public void brR() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bIl().Ez("page_frs_good");
            ql(true);
            return;
        }
        this.jeG.ld(false);
    }

    @Override // com.baidu.tieba.frs.au
    public void brS() {
        com.baidu.tieba.t.c.dIO().b(getUniqueId(), false);
    }
}
