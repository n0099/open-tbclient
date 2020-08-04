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
import com.baidu.adp.widget.ListView.t;
import com.baidu.adp.widget.ListView.z;
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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
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
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes16.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aq, ar, as, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.recapp.n, FrsCommonImageLayout.c {
    private VoiceManager hFy;
    private com.baidu.tbadk.k.c hKX;
    private String hYD;
    private FrsLoadMoreModel hYG;
    private FrsNewAreaModelController ibd;
    private String hFr = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData hEX = new FrsViewData();
    public long hio = -1;
    public long eHd = 0;
    public long eHn = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean hFL = false;
    protected g ibe = null;
    private int gEI = -1;
    private int hNH = 3;
    private boolean hcA = false;
    private boolean hYJ = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hFZ = new SparseArray<>();
    private int cXV = 0;
    private int hGx = 0;
    private CustomMessageListener hJb = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.hKX != null && FrsNewAreaFragment.this.hKX.isViewAttached()) {
                FrsNewAreaFragment.this.hKX.oh(num.intValue());
            }
        }
    };
    private Runnable hYK = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.hcA) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.oq(false);
            }
        }
    };
    private CustomMessageListener hYL = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bv)) {
                bv bvVar = (bv) customResponsedMessage.getData();
                FrsNewAreaFragment.this.hYD = bvVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.hYD) && bvVar.aVW() != null) {
                    FrsNewAreaFragment.this.vP(bvVar.aVW().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener hGL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.bcE() != null) {
                        FrsNewAreaFragment.this.bcE().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.hKX != null && FrsNewAreaFragment.this.hKX.isViewAttached()) {
                        FrsNewAreaFragment.this.oq(false);
                    } else if (FrsNewAreaFragment.this.ibe != null) {
                        FrsNewAreaFragment.this.ibe.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final q hHd = new q() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        private long hYO = 1;

        @Override // com.baidu.tieba.tbadkCore.q
        public void uG(int i) {
            if (!FrsNewAreaFragment.this.hYJ) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.ibe.ccH();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.ibe.jH(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<com.baidu.adp.widget.ListView.q> a;
            if (FrsNewAreaFragment.this.hYJ) {
                if (FrsNewAreaFragment.this.chE().cgN() == null) {
                    FrsNewAreaFragment.this.hYJ = false;
                    return;
                } else if (FrsNewAreaFragment.this.chE().cgN().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.hYJ = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.hYO = 1L;
            } else if (fVar.isSuccess) {
                this.hYO = 0L;
            } else {
                this.hYO = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.hYG.resetData();
            }
            FrsNewAreaFragment.this.ibe.jH(false);
            if (FrsNewAreaFragment.this.chE().cgN() != null) {
                FrsNewAreaFragment.this.hEX = FrsNewAreaFragment.this.chE().cgN();
            }
            FrsNewAreaFragment.this.gEI = FrsNewAreaFragment.this.hEX.getPage().aVb();
            if (FrsNewAreaFragment.this.gEI == 0 && (FrsNewAreaFragment.this.hEX.getThreadListIds() == null || FrsNewAreaFragment.this.hEX.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.hEX.getThreadList() == null || FrsNewAreaFragment.this.hEX.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.ibe.bxU();
                } else {
                    FrsNewAreaFragment.this.ibe.bxT();
                }
            } else {
                FrsNewAreaFragment.this.ibe.bxS();
            }
            if (i == 4) {
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsNewAreaFragment.this.hYG.a(false, false, false, FrsNewAreaFragment.this.hEX.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.hEX.setThreadList(a2);
                    FrsNewAreaFragment.this.ibe.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.hEX, FrsNewAreaFragment.this.gEI);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.ibe.ccH();
                    break;
                case 2:
                    FrsNewAreaFragment.this.ibe.ccH();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.hEX.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.hYO != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.hEX != null) {
                    FrsNewAreaFragment.this.hFr = FrsNewAreaFragment.this.hEX.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.hEX.getForum().getId();
                    FrsNewAreaFragment.this.ibe.b(FrsNewAreaFragment.this.hEX.getForum(), FrsNewAreaFragment.this.hEX.getUserData());
                }
                if (FrsNewAreaFragment.this.hEX != null) {
                    FrsNewAreaFragment.this.hEX.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.hEX == null || FrsNewAreaFragment.this.hEX.getThreadList() == null || FrsNewAreaFragment.this.hEX.getThreadList().size() != 0 || FrsNewAreaFragment.this.chE().getType() != 4) {
                    if (FrsNewAreaFragment.this.hEX != null && (a = FrsNewAreaFragment.this.hYG.a(false, false, true, FrsNewAreaFragment.this.hEX.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.hEX.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.cbP();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.hio > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.hio, FrsNewAreaFragment.this.chE().bVN() - FrsNewAreaFragment.this.hio, FrsNewAreaFragment.this.chE().bVL(), FrsNewAreaFragment.this.chE().bVM(), currentTimeMillis2 - FrsNewAreaFragment.this.chE().bVK());
                        FrsNewAreaFragment.this.hio = -1L;
                    }
                    FrsNewAreaFragment.this.eHn = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.hio > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.hio, FrsNewAreaFragment.this.chE().bVN() - FrsNewAreaFragment.this.hio, FrsNewAreaFragment.this.chE().bVL(), FrsNewAreaFragment.this.chE().bVM(), currentTimeMillis3 - FrsNewAreaFragment.this.chE().bVK());
                FrsNewAreaFragment.this.hio = -1L;
            }
            FrsNewAreaFragment.this.eHn = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void cbJ() {
        }
    };
    private final CustomMessageListener dLt = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.ibe != null) {
                FrsNewAreaFragment.this.ibe.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.hFL) {
                FrsNewAreaFragment.this.hFL = true;
                FrsNewAreaFragment.this.ibe.ccW();
            }
            if (i == 0) {
                s.bRL().mH(true);
                com.baidu.tieba.s.c.dkh().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.hGx += i2;
            if (FrsNewAreaFragment.this.hGx >= FrsNewAreaFragment.this.cXV * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener erZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
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
    private z hHk = new z() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.z
        public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bu)) {
                bv bvVar = ((bu) qVar).dLK;
                if (bvVar.aXl() == null || bvVar.aXl().getGroup_id() == 0 || bf.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bvVar.aWY() != 1 || bf.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.NZ(bvVar.getId())) {
                            readThreadHistory.NY(bvVar.getId());
                            if (FrsNewAreaFragment.this.ibe != null) {
                                FrsNewAreaFragment.this.ibe.ccH();
                            }
                        }
                        boolean z = false;
                        final String aWr = bvVar.aWr();
                        if (aWr != null && !aWr.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(aWr);
                                    zVar.bav().baW().mIsNeedAddCommenParam = false;
                                    zVar.bav().baW().mIsUseCurrentBDUSS = false;
                                    zVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bvVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bvVar.aWg() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bd.baV().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bvVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bvVar, FrsNewAreaFragment.this.hFr, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bvVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.hEX != null && FrsNewAreaFragment.this.hEX.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.icM = FrsNewAreaFragment.this.hEX.needLog == 1;
                            bVar.icO = FrsNewAreaFragment.this.hEX.getForum().getId();
                            bVar.icN = FrsNewAreaFragment.this.ibd.chr();
                            if (com.baidu.tieba.frs.d.d.hOG != null) {
                                bVar.icP = com.baidu.tieba.frs.d.d.hOG.icP;
                                bVar.icQ = com.baidu.tieba.frs.d.d.hOG.icQ;
                            }
                            com.baidu.tieba.frs.d.a.a(bvVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar, FrsNewAreaFragment.this.getTbPageTag());
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

    public void am(bv bvVar) {
        if (bvVar != null) {
            this.ibd.am(bvVar);
            this.ibe.cbd();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.hEX = frsViewData;
            hideLoadingView(this.ibe.bPb());
            if (this.ibe != null) {
                this.ibe.jH(false);
                this.ibe.a(null, this.mPn, this.hEX, this.gEI);
            }
        }
    }

    private void showLoadingView() {
        this.ibe.nZ(false);
        showLoadingView(this.ibe.bPb(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.ibe.nZ(true);
        hideLoadingView(this.ibe.bPb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.ibe.nZ(false);
        this.ibe.nY(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.ibe.bxU();
        this.ibe.getListView().getData().clear();
        this.ibe.ccH();
        if (this.hKX == null) {
            this.hKX = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hKX.setTitle(null);
            this.hKX.setButtonText(null);
            this.hKX.showRefreshButton();
            this.hKX.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hKX.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hKX.setSubText(null);
        }
        this.hKX.onChangeSkinType();
        this.hKX.attachView(this.ibe.bPb(), true);
        registerListener(this.hJb);
    }

    private void bwX() {
        this.ibe.nZ(true);
        this.ibe.nY(true);
        if (this.hKX != null && this.hKX.isViewAttached()) {
            this.hKX.dettachView(this.ibe.bPb());
        }
        MessageManager.getInstance().unRegisterListener(this.hJb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oq(boolean z) {
        this.hcA = true;
        cbU();
        bwX();
        if (!z) {
            bwX();
            showLoadingView();
        }
        this.ibd.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hio = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.hio = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.eHd = this.beginTime - this.hio;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dkh().A(getUniqueId());
        this.ibd = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.ibd.ak(arguments);
        } else if (bundle != null) {
            this.ibd.ak(bundle);
        } else {
            this.ibd.ak(null);
        }
        this.hFy = getVoiceManager();
        this.hFy.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dLt);
        registerListener(this.hYL);
        registerListener(this.hGL);
        this.hYG = new FrsLoadMoreModel(this, null);
        this.hYG.registerListener();
        this.hYG.setPageType(3);
        this.hYG.os(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cXV = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.ibe = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.hcA) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                oq(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        baO();
    }

    private void baO() {
        ap apVar = new ap("c13008");
        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
        apVar.dn("fid", this.forumId);
        apVar.ah("obj_type", 6);
        apVar.ah("obj_locate", 2);
        apVar.baO();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hFy = getVoiceManager();
        this.hFy.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cgC();
        if (bundle != null) {
            this.hFr = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.hFr = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cgC() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.erZ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ibe != null) {
            this.ibe.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hJb);
        com.baidu.tieba.s.c.dkh().B(getUniqueId());
        s.bRL().mH(false);
        super.onDestroy();
        this.ibd.cgL();
        this.hFy = getVoiceManager();
        this.hFy.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.hYK);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hFr);
        bundle.putString("from", this.mFrom);
        this.ibd.onSaveInstanceState(bundle);
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bv threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.ibe.chG().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.hEX.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.ld(intent.getIntExtra("good_data", 0));
                            threadDataById.aXj();
                            oq(false);
                            return;
                        } else if (intExtra == 0) {
                            this.hEX.removeThreadData(threadDataById);
                            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hEX.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new r());
                            }
                            this.ibe.cgH();
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
            if (this.hNH == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.hcA) {
                com.baidu.adp.lib.f.e.lt().post(this.hYK);
            }
        }
        cdQ();
    }

    private void cdQ() {
        if (isPrimary()) {
            if (this.hKX != null && this.hKX.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hJb);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hJb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ibe != null) {
            this.ibe.ccH();
        }
        this.hFy = getVoiceManager();
        this.hFy.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.ibe.a(this.hHk);
        this.ibe.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hNH != 3 || this.ibe != null) {
            this.hNH = i;
            super.onChangeSkinType(i);
            if (this.ibe != null) {
                this.ibe.onChangeSkinType(i);
            }
            if (this.hKX != null && this.hKX.isViewAttached()) {
                this.hKX.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> caJ() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).caJ();
        }
        return null;
    }

    private void cbO() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.lu().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.NT(FrsNewAreaFragment.this.hFr);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbP() {
        cbU();
        try {
            if (this.hEX != null) {
                this.ibe.cea();
                this.ibe.bBY();
                this.hFr = this.hEX.getForum().getName();
                this.forumId = this.hEX.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.hEX.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hEX.getUserData().getBimg_end_time());
                cbO();
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hEX.getThreadList();
                if (threadList != null) {
                    this.ibe.a(threadList, this.mPn, this.hEX, this.hEX.getPage().aVb());
                    cgE();
                    this.ibe.cgH();
                    if (this.hEX.getIsNewUrl() == 1) {
                        this.ibe.chG().setFromCDN(true);
                    } else {
                        this.ibe.chG().setFromCDN(false);
                    }
                    this.ibe.setListViewSelection(cj(chE().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cj(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hFy = getVoiceManager();
        this.hFy.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.bRL().mH(false);
        com.baidu.tieba.s.c.dkh().b(getUniqueId(), false);
        if (this.hEX != null && this.hEX.getForum() != null) {
            com.baidu.tbadk.distribute.a.biw().b(getPageContext().getPageActivity(), "frs", this.hEX.getForum().getId(), 0L);
        }
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onStop(getPageContext());
        }
    }

    public void cez() {
        if (this.ibe != null) {
            this.ibe.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vP(int i) {
        ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hEX.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q next = it.next();
                if (next instanceof bu) {
                    bv bvVar = ((bu) next).dLK;
                    if (bvVar.getId() != null && bvVar.getId().equals(this.hYD)) {
                        c(bvVar, i);
                        this.hYD = null;
                        break;
                    }
                }
            }
            this.ibe.chG().b(threadList, this.hEX);
            this.ibe.chG().notifyDataSetChanged();
        }
    }

    private void c(bv bvVar, int i) {
        if (i == 1) {
            PraiseData aVW = bvVar.aVW();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aVW == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bvVar.a(praiseData);
                    return;
                }
                bvVar.aVW().getUser().add(0, metaData);
                bvVar.aVW().setNum(bvVar.aVW().getNum() + 1);
                bvVar.aVW().setIsLike(i);
            }
        } else if (bvVar.aVW() != null) {
            bvVar.aVW().setIsLike(i);
            bvVar.aVW().setNum(bvVar.aVW().getNum() - 1);
            ArrayList<MetaData> user = bvVar.aVW().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bvVar.aVW().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hFy == null) {
            this.hFy = VoiceManager.instance();
        }
        return this.hFy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView bcE() {
        if (this.ibe == null) {
            return null;
        }
        return this.ibe.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cbU() {
        this.hFy = getVoiceManager();
        this.hFy.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bcF() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bcF();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.hEX != null && this.ibe != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.ibe.ccH();
            }
        }
    }

    private void cgE() {
        HashMap<Integer, bv> cfc;
        if (this.ibe != null && this.ibe.chG() != null && (cfc = this.ibe.chG().cfc()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bv> entry : cfc.entrySet()) {
                bv value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.biC().F(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        if (bcE() == null) {
            return null;
        }
        return bcE().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            oq(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cbZ() {
        return this.hEX;
    }

    public FrsNewAreaModelController chE() {
        return this.ibd;
    }

    public void Gj(String str) {
        this.hFr = str;
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

    public void bwE() {
        if (!this.hYG.isLoading && !this.ibd.isLoading()) {
            if (this.hYG.cM(this.hEX.getThreadListIds())) {
                this.ibe.a(this.hYG.cha(), this.mPn, this.hEX, 0);
                this.hYG.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.hEX.getThreadListIds(), this.hFr, this.mPn, this.hEX.isBrandForum);
            } else if (this.gEI != 0) {
                this.ibe.a(this.hYG.cha(), this.mPn, this.hEX, 0);
                this.mPn++;
                this.ibd.vR(this.mPn);
                this.hYG.loadingDone = false;
                this.hYG.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.ibe.bxU();
        } else if (!this.ibe.ccQ()) {
            if (!this.ibd.cgP()) {
                this.ibe.bxU();
                return;
            }
            bwT();
            bwE();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bwT();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ao(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.q> a;
        bwT();
        if (arrayList != null && arrayList.size() != 0 && (a = this.hYG.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.hEX.setThreadList(a);
            this.ibe.a(a, this.mPn, this.hEX, 0);
        }
    }

    public void cN(List<String> list) {
        cB(list);
        int i = 0;
        Iterator<com.baidu.adp.widget.ListView.q> it = this.hEX.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bu ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            bwE();
        }
    }

    private void cB(List<String> list) {
        if (!x.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hEX.getThreadList();
            if (!x.isEmpty(threadList) && this.ibe.getListView() != null && this.ibe.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.ibe.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bu) {
                        bv bvVar = ((bu) next).dLK;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.as.equals(list.get(i2), bvVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hYG.d(next);
                                this.ibe.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cgD() {
        return this.hYG;
    }

    private void bwT() {
        if (this.gEI == 0 && !this.hYG.cM(this.hEX.getThreadListIds())) {
            if (this.hEX.getThreadList() == null || this.hEX.getThreadList().size() == 0) {
                this.ibe.bxU();
                return;
            } else {
                this.ibe.bxT();
                return;
            }
        }
        this.ibe.bxS();
    }

    public g chF() {
        return this.ibe;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.i.a.a.InterfaceC0153a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ad.checkCamera(getActivity().getApplicationContext())) {
                an.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ad.transformPermissionResult(strArr, iArr);
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
        com.baidu.tbadk.distribute.a.biw().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void cbT() {
        if (this.ibd != null) {
            this.ibd.cbT();
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

    @Override // com.baidu.tieba.frs.ar
    public NavigationBar bAm() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hFr;
    }

    @Override // com.baidu.tieba.frs.aq
    public void cbd() {
        if (this.ibe != null && this.ibe.getListView() != null) {
            this.ibe.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxR() {
        if (this.ibe != null) {
            cbd();
            this.ibe.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hFZ.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a pE(int i) {
        return this.hFZ.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hEX != null) {
            i = this.hEX.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.wp(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.as
    public void bcg() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.brD().AO("page_frs_good");
            oq(true);
            return;
        }
        this.ibe.jH(false);
    }

    @Override // com.baidu.tieba.frs.as
    public void bch() {
        com.baidu.tieba.s.c.dkh().b(getUniqueId(), false);
    }
}
