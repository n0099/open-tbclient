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
import com.baidu.adp.widget.ListView.t;
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
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes16.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, as, at, au, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.recapp.n, FrsCommonImageLayout.c {
    private VoiceManager hSO;
    private com.baidu.tbadk.k.c hZc;
    private String imL;
    private FrsLoadMoreModel imO;
    private FrsNewAreaModelController ipk;
    private String hSH = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData hSn = new FrsViewData();
    public long hvn = -1;
    public long eRJ = 0;
    public long eRT = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean hTb = false;
    protected g ipl = null;
    private int gRi = -1;
    private int ibM = 3;
    private boolean hpr = false;
    private boolean imR = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hTp = new SparseArray<>();
    private int dhe = 0;
    private int hTN = 0;
    private CustomMessageListener hWr = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.hZc != null && FrsNewAreaFragment.this.hZc.isViewAttached()) {
                FrsNewAreaFragment.this.hZc.qs(num.intValue());
            }
        }
    };
    private Runnable imS = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.hpr) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.oU(false);
            }
        }
    };
    private CustomMessageListener imT = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                bw bwVar = (bw) customResponsedMessage.getData();
                FrsNewAreaFragment.this.imL = bwVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.imL) && bwVar.bep() != null) {
                    FrsNewAreaFragment.this.yi(bwVar.bep().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener hUb = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.blc() != null) {
                        FrsNewAreaFragment.this.blc().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.hZc != null && FrsNewAreaFragment.this.hZc.isViewAttached()) {
                        FrsNewAreaFragment.this.oU(false);
                    } else if (FrsNewAreaFragment.this.ipl != null) {
                        FrsNewAreaFragment.this.ipl.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final r hUt = new r() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long imW = 1;

        @Override // com.baidu.tieba.tbadkCore.r
        public void wV(int i) {
            if (!FrsNewAreaFragment.this.imR) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.ipl.cne();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.ipl.kf(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<q> a;
            if (FrsNewAreaFragment.this.imR) {
                if (FrsNewAreaFragment.this.csi().crs() == null) {
                    FrsNewAreaFragment.this.imR = false;
                    return;
                } else if (FrsNewAreaFragment.this.csi().crs().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.imR = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.imW = 1L;
            } else if (fVar.isSuccess) {
                this.imW = 0L;
            } else {
                this.imW = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.imO.resetData();
            }
            FrsNewAreaFragment.this.ipl.kf(false);
            if (FrsNewAreaFragment.this.csi().crs() != null) {
                FrsNewAreaFragment.this.hSn = FrsNewAreaFragment.this.csi().crs();
            }
            FrsNewAreaFragment.this.gRi = FrsNewAreaFragment.this.hSn.getPage().bdu();
            if (FrsNewAreaFragment.this.gRi == 0 && (FrsNewAreaFragment.this.hSn.getThreadListIds() == null || FrsNewAreaFragment.this.hSn.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.hSn.getThreadList() == null || FrsNewAreaFragment.this.hSn.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.ipl.bGT();
                } else {
                    FrsNewAreaFragment.this.ipl.bGS();
                }
            } else {
                FrsNewAreaFragment.this.ipl.bGR();
            }
            if (i == 4) {
                ArrayList<q> a2 = FrsNewAreaFragment.this.imO.a(false, false, false, FrsNewAreaFragment.this.hSn.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.hSn.setThreadList(a2);
                    FrsNewAreaFragment.this.ipl.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.hSn, FrsNewAreaFragment.this.gRi);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.ipl.cne();
                    break;
                case 2:
                    FrsNewAreaFragment.this.ipl.cne();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.hSn.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.imW != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.hSn != null) {
                    FrsNewAreaFragment.this.hSH = FrsNewAreaFragment.this.hSn.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.hSn.getForum().getId();
                    FrsNewAreaFragment.this.ipl.b(FrsNewAreaFragment.this.hSn.getForum(), FrsNewAreaFragment.this.hSn.getUserData());
                }
                if (FrsNewAreaFragment.this.hSn != null) {
                    FrsNewAreaFragment.this.hSn.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.hSn == null || FrsNewAreaFragment.this.hSn.getThreadList() == null || FrsNewAreaFragment.this.hSn.getThreadList().size() != 0 || FrsNewAreaFragment.this.csi().getType() != 4) {
                    if (FrsNewAreaFragment.this.hSn != null && (a = FrsNewAreaFragment.this.imO.a(false, false, true, FrsNewAreaFragment.this.hSn.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.hSn.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.cmm();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.hvn > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.hvn, FrsNewAreaFragment.this.csi().cga() - FrsNewAreaFragment.this.hvn, FrsNewAreaFragment.this.csi().cfY(), FrsNewAreaFragment.this.csi().cfZ(), currentTimeMillis2 - FrsNewAreaFragment.this.csi().cfX());
                        FrsNewAreaFragment.this.hvn = -1L;
                    }
                    FrsNewAreaFragment.this.eRT = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.hvn > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.hvn, FrsNewAreaFragment.this.csi().cga() - FrsNewAreaFragment.this.hvn, FrsNewAreaFragment.this.csi().cfY(), FrsNewAreaFragment.this.csi().cfZ(), currentTimeMillis3 - FrsNewAreaFragment.this.csi().cfX());
                FrsNewAreaFragment.this.hvn = -1L;
            }
            FrsNewAreaFragment.this.eRT = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cmg() {
        }
    };
    private final CustomMessageListener dUB = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.ipl != null) {
                FrsNewAreaFragment.this.ipl.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.hTb) {
                FrsNewAreaFragment.this.hTb = true;
                FrsNewAreaFragment.this.ipl.cnt();
            }
            if (i == 0) {
                s.cbX().nk(true);
                com.baidu.tieba.s.c.dvE().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.hTN += i2;
            if (FrsNewAreaFragment.this.hTN >= FrsNewAreaFragment.this.dhe * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener eCs = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
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
    private ab hUA = new ab() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bv)) {
                bw bwVar = ((bv) qVar).dUS;
                if (bwVar.bfE() == null || bwVar.bfE().getGroup_id() == 0 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bwVar.bfr() != 1 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.QX(bwVar.getId())) {
                            readThreadHistory.QW(bwVar.getId());
                            if (FrsNewAreaFragment.this.ipl != null) {
                                FrsNewAreaFragment.this.ipl.cne();
                            }
                        }
                        boolean z = false;
                        final String beK = bwVar.beK();
                        if (beK != null && !beK.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(beK);
                                    aaVar.biQ().bjv().mIsNeedAddCommenParam = false;
                                    aaVar.biQ().bjv().mIsUseCurrentBDUSS = false;
                                    aaVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bwVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bwVar.bez() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.bju().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bwVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bwVar, FrsNewAreaFragment.this.hSH, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.hSn != null && FrsNewAreaFragment.this.hSn.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.iqT = FrsNewAreaFragment.this.hSn.needLog == 1;
                            bVar.iqV = FrsNewAreaFragment.this.hSn.getForum().getId();
                            bVar.iqU = FrsNewAreaFragment.this.ipk.crW();
                            if (com.baidu.tieba.frs.d.d.icL != null) {
                                bVar.iqW = com.baidu.tieba.frs.d.d.icL.iqW;
                                bVar.iqX = com.baidu.tieba.frs.d.d.icL.iqX;
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

    public void am(bw bwVar) {
        if (bwVar != null) {
            this.ipk.am(bwVar);
            this.ipl.clz();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.hSn = frsViewData;
            hideLoadingView(this.ipl.bZb());
            if (this.ipl != null) {
                this.ipl.kf(false);
                this.ipl.a(null, this.mPn, this.hSn, this.gRi);
            }
        }
    }

    private void showLoadingView() {
        this.ipl.oD(false);
        showLoadingView(this.ipl.bZb(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.ipl.oD(true);
        hideLoadingView(this.ipl.bZb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.ipl.oD(false);
        this.ipl.oC(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.ipl.bGT();
        this.ipl.getListView().getData().clear();
        this.ipl.cne();
        if (this.hZc == null) {
            this.hZc = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hZc.setTitle(null);
            this.hZc.setButtonText(null);
            this.hZc.showRefreshButton();
            this.hZc.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hZc.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hZc.setSubText(null);
        }
        this.hZc.onChangeSkinType();
        this.hZc.attachView(this.ipl.bZb(), true);
        registerListener(this.hWr);
    }

    private void bFW() {
        this.ipl.oD(true);
        this.ipl.oC(true);
        if (this.hZc != null && this.hZc.isViewAttached()) {
            this.hZc.dettachView(this.ipl.bZb());
        }
        MessageManager.getInstance().unRegisterListener(this.hWr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU(boolean z) {
        this.hpr = true;
        cmr();
        bFW();
        if (!z) {
            bFW();
            showLoadingView();
        }
        this.ipk.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hvn = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.hvn = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.eRJ = this.beginTime - this.hvn;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dvE().A(getUniqueId());
        this.ipk = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.ipk.aj(arguments);
        } else if (bundle != null) {
            this.ipk.aj(bundle);
        } else {
            this.ipk.aj(null);
        }
        this.hSO = getVoiceManager();
        this.hSO.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dUB);
        registerListener(this.imT);
        registerListener(this.hUb);
        this.imO = new FrsLoadMoreModel(this, null);
        this.imO.registerListener();
        this.imO.setPageType(3);
        this.imO.oW(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dhe = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.ipl = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.hpr) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                oU(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bjn();
    }

    private void bjn() {
        aq aqVar = new aq("c13008");
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dD("fid", this.forumId);
        aqVar.ai("obj_type", 6);
        aqVar.ai("obj_locate", 2);
        aqVar.bjn();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hSO = getVoiceManager();
        this.hSO.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        crh();
        if (bundle != null) {
            this.hSH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.hSH = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void crh() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eCs);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ipl != null) {
            this.ipl.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hWr);
        com.baidu.tieba.s.c.dvE().B(getUniqueId());
        s.cbX().nk(false);
        super.onDestroy();
        this.ipk.crq();
        this.hSO = getVoiceManager();
        this.hSO.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.imS);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hSH);
        bundle.putString("from", this.mFrom);
        this.ipk.onSaveInstanceState(bundle);
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bw threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.ipl.csk().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.hSn.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.nj(intent.getIntExtra("good_data", 0));
                            threadDataById.bfC();
                            oU(false);
                            return;
                        } else if (intExtra == 0) {
                            this.hSn.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.hSn.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.ipl.crm();
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
            if (this.ibM == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.hpr) {
                com.baidu.adp.lib.f.e.mS().post(this.imS);
            }
        }
        cou();
    }

    private void cou() {
        if (isPrimary()) {
            if (this.hZc != null && this.hZc.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hWr);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hWr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ipl != null) {
            this.ipl.cne();
        }
        this.hSO = getVoiceManager();
        this.hSO.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.ipl.a(this.hUA);
        this.ipl.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ibM != 3 || this.ipl != null) {
            this.ibM = i;
            super.onChangeSkinType(i);
            if (this.ipl != null) {
                this.ipl.onChangeSkinType(i);
            }
            if (this.hZc != null && this.hZc.isViewAttached()) {
                this.hZc.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> clf() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).clf();
        }
        return null;
    }

    private void cml() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mT().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.QR(FrsNewAreaFragment.this.hSH);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmm() {
        cmr();
        try {
            if (this.hSn != null) {
                this.ipl.coE();
                this.ipl.bLs();
                this.hSH = this.hSn.getForum().getName();
                this.forumId = this.hSn.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.hSn.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hSn.getUserData().getBimg_end_time());
                cml();
                ArrayList<q> threadList = this.hSn.getThreadList();
                if (threadList != null) {
                    this.ipl.a(threadList, this.mPn, this.hSn, this.hSn.getPage().bdu());
                    crj();
                    this.ipl.crm();
                    if (this.hSn.getIsNewUrl() == 1) {
                        this.ipl.csk().setFromCDN(true);
                    } else {
                        this.ipl.csk().setFromCDN(false);
                    }
                    this.ipl.setListViewSelection(cr(csi().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cr(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hSO = getVoiceManager();
        this.hSO.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.cbX().nk(false);
        com.baidu.tieba.s.c.dvE().b(getUniqueId(), false);
        if (this.hSn != null && this.hSn.getForum() != null) {
            com.baidu.tbadk.distribute.a.bri().b(getPageContext().getPageActivity(), "frs", this.hSn.getForum().getId(), 0L);
        }
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onStop(getPageContext());
        }
    }

    public void cpd() {
        if (this.ipl != null && this.ipl.getListView() != null) {
            this.ipl.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    FrsNewAreaFragment.this.ipl.refreshView();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yi(int i) {
        ArrayList<q> threadList = this.hSn.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).dUS;
                    if (bwVar.getId() != null && bwVar.getId().equals(this.imL)) {
                        c(bwVar, i);
                        this.imL = null;
                        break;
                    }
                }
            }
            this.ipl.csk().b(threadList, this.hSn);
            this.ipl.csk().notifyDataSetChanged();
        }
    }

    private void c(bw bwVar, int i) {
        if (i == 1) {
            PraiseData bep = bwVar.bep();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bep == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bwVar.a(praiseData);
                    return;
                }
                bwVar.bep().getUser().add(0, metaData);
                bwVar.bep().setNum(bwVar.bep().getNum() + 1);
                bwVar.bep().setIsLike(i);
            }
        } else if (bwVar.bep() != null) {
            bwVar.bep().setIsLike(i);
            bwVar.bep().setNum(bwVar.bep().getNum() - 1);
            ArrayList<MetaData> user = bwVar.bep().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bwVar.bep().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hSO == null) {
            this.hSO = VoiceManager.instance();
        }
        return this.hSO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView blc() {
        if (this.ipl == null) {
            return null;
        }
        return this.ipl.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cmr() {
        this.hSO = getVoiceManager();
        this.hSO.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bld() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bld();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.hSn != null && this.ipl != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.ipl.cne();
            }
        }
    }

    private void crj() {
        HashMap<Integer, bw> cpH;
        if (this.ipl != null && this.ipl.csk() != null && (cpH = this.ipl.csk().cpH()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bw> entry : cpH.entrySet()) {
                bw value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bro().L(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        if (blc() == null) {
            return null;
        }
        return blc().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            oU(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cmw() {
        return this.hSn;
    }

    public FrsNewAreaModelController csi() {
        return this.ipk;
    }

    public void IL(String str) {
        this.hSH = str;
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

    public void bFD() {
        if (!this.imO.isLoading && !this.ipk.isLoading()) {
            if (this.imO.cO(this.hSn.getThreadListIds())) {
                this.ipl.a(this.imO.crF(), this.mPn, this.hSn, 0);
                this.imO.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.hSn.getThreadListIds(), this.hSH, this.mPn, this.hSn.isBrandForum);
            } else if (this.gRi != 0) {
                this.ipl.a(this.imO.crF(), this.mPn, this.hSn, 0);
                this.mPn++;
                this.ipk.yk(this.mPn);
                this.imO.loadingDone = false;
                this.imO.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.ipl.bGT();
        } else if (!this.ipl.cnn()) {
            if (!this.ipk.cru()) {
                this.ipl.bGT();
                return;
            }
            bFS();
            bFD();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bFS();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void au(ArrayList<q> arrayList) {
        ArrayList<q> a;
        bFS();
        if (arrayList != null && arrayList.size() != 0 && (a = this.imO.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.hSn.setThreadList(a);
            this.ipl.a(a, this.mPn, this.hSn, 0);
        }
    }

    public void cP(List<String> list) {
        cD(list);
        int i = 0;
        Iterator<q> it = this.hSn.getThreadList().iterator();
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
            bFD();
        }
    }

    private void cD(List<String> list) {
        if (!y.isEmpty(list)) {
            ArrayList<q> threadList = this.hSn.getThreadList();
            if (!y.isEmpty(threadList) && this.ipl.getListView() != null && this.ipl.getListView().getData() != null) {
                Iterator<q> it = threadList.iterator();
                List<q> data = this.ipl.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).dUS;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.imO.d(next);
                                this.ipl.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cri() {
        return this.imO;
    }

    private void bFS() {
        if (this.gRi == 0 && !this.imO.cO(this.hSn.getThreadListIds())) {
            if (this.hSn.getThreadList() == null || this.hSn.getThreadList().size() == 0) {
                this.ipl.bGT();
                return;
            } else {
                this.ipl.bGS();
                return;
            }
        }
        this.ipl.bGR();
    }

    public g csj() {
        return this.ipl;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0210a
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
        com.baidu.tbadk.distribute.a.bri().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void cmq() {
        if (this.ipk != null) {
            this.ipk.cmq();
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
    public NavigationBar bJH() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hSH;
    }

    @Override // com.baidu.tieba.frs.as
    public void clz() {
        if (this.ipl != null && this.ipl.getListView() != null) {
            this.ipl.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bGQ() {
        if (this.ipl != null) {
            clz();
            this.ipl.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hTp.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a rQ(int i) {
        return this.hTp.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hSn != null) {
            i = this.hSn.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.yI(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.au
    public void bkD() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bAA().Di("page_frs_good");
            oU(true);
            return;
        }
        this.ipl.kf(false);
    }

    @Override // com.baidu.tieba.frs.au
    public void bkE() {
        com.baidu.tieba.s.c.dvE().b(getUniqueId(), false);
    }
}
