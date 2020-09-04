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
    private VoiceManager hSU;
    private com.baidu.tbadk.k.c hZi;
    private String imR;
    private FrsLoadMoreModel imU;
    private FrsNewAreaModelController ipq;
    private String hSN = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData hSt = new FrsViewData();
    public long hvt = -1;
    public long eRN = 0;
    public long eRX = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean hTh = false;
    protected g ipr = null;
    private int gRm = -1;
    private int ibS = 3;
    private boolean hpv = false;
    private boolean imX = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hTv = new SparseArray<>();
    private int dhi = 0;
    private int hTT = 0;
    private CustomMessageListener hWx = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.hZi != null && FrsNewAreaFragment.this.hZi.isViewAttached()) {
                FrsNewAreaFragment.this.hZi.qs(num.intValue());
            }
        }
    };
    private Runnable imY = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.hpv) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.oW(false);
            }
        }
    };
    private CustomMessageListener imZ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                bw bwVar = (bw) customResponsedMessage.getData();
                FrsNewAreaFragment.this.imR = bwVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.imR) && bwVar.bep() != null) {
                    FrsNewAreaFragment.this.yi(bwVar.bep().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener hUh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.blc() != null) {
                        FrsNewAreaFragment.this.blc().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.hZi != null && FrsNewAreaFragment.this.hZi.isViewAttached()) {
                        FrsNewAreaFragment.this.oW(false);
                    } else if (FrsNewAreaFragment.this.ipr != null) {
                        FrsNewAreaFragment.this.ipr.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final r hUz = new r() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long inc = 1;

        @Override // com.baidu.tieba.tbadkCore.r
        public void wV(int i) {
            if (!FrsNewAreaFragment.this.imX) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.ipr.cnf();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.ipr.kh(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<q> a;
            if (FrsNewAreaFragment.this.imX) {
                if (FrsNewAreaFragment.this.csj().crt() == null) {
                    FrsNewAreaFragment.this.imX = false;
                    return;
                } else if (FrsNewAreaFragment.this.csj().crt().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.imX = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.inc = 1L;
            } else if (fVar.isSuccess) {
                this.inc = 0L;
            } else {
                this.inc = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.imU.resetData();
            }
            FrsNewAreaFragment.this.ipr.kh(false);
            if (FrsNewAreaFragment.this.csj().crt() != null) {
                FrsNewAreaFragment.this.hSt = FrsNewAreaFragment.this.csj().crt();
            }
            FrsNewAreaFragment.this.gRm = FrsNewAreaFragment.this.hSt.getPage().bdu();
            if (FrsNewAreaFragment.this.gRm == 0 && (FrsNewAreaFragment.this.hSt.getThreadListIds() == null || FrsNewAreaFragment.this.hSt.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.hSt.getThreadList() == null || FrsNewAreaFragment.this.hSt.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.ipr.bGU();
                } else {
                    FrsNewAreaFragment.this.ipr.bGT();
                }
            } else {
                FrsNewAreaFragment.this.ipr.bGS();
            }
            if (i == 4) {
                ArrayList<q> a2 = FrsNewAreaFragment.this.imU.a(false, false, false, FrsNewAreaFragment.this.hSt.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.hSt.setThreadList(a2);
                    FrsNewAreaFragment.this.ipr.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.hSt, FrsNewAreaFragment.this.gRm);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.ipr.cnf();
                    break;
                case 2:
                    FrsNewAreaFragment.this.ipr.cnf();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.hSt.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.inc != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.hSt != null) {
                    FrsNewAreaFragment.this.hSN = FrsNewAreaFragment.this.hSt.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.hSt.getForum().getId();
                    FrsNewAreaFragment.this.ipr.b(FrsNewAreaFragment.this.hSt.getForum(), FrsNewAreaFragment.this.hSt.getUserData());
                }
                if (FrsNewAreaFragment.this.hSt != null) {
                    FrsNewAreaFragment.this.hSt.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.hSt == null || FrsNewAreaFragment.this.hSt.getThreadList() == null || FrsNewAreaFragment.this.hSt.getThreadList().size() != 0 || FrsNewAreaFragment.this.csj().getType() != 4) {
                    if (FrsNewAreaFragment.this.hSt != null && (a = FrsNewAreaFragment.this.imU.a(false, false, true, FrsNewAreaFragment.this.hSt.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.hSt.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.cmn();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.hvt > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.hvt, FrsNewAreaFragment.this.csj().cgb() - FrsNewAreaFragment.this.hvt, FrsNewAreaFragment.this.csj().cfZ(), FrsNewAreaFragment.this.csj().cga(), currentTimeMillis2 - FrsNewAreaFragment.this.csj().cfY());
                        FrsNewAreaFragment.this.hvt = -1L;
                    }
                    FrsNewAreaFragment.this.eRX = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.hvt > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.hvt, FrsNewAreaFragment.this.csj().cgb() - FrsNewAreaFragment.this.hvt, FrsNewAreaFragment.this.csj().cfZ(), FrsNewAreaFragment.this.csj().cga(), currentTimeMillis3 - FrsNewAreaFragment.this.csj().cfY());
                FrsNewAreaFragment.this.hvt = -1L;
            }
            FrsNewAreaFragment.this.eRX = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cmh() {
        }
    };
    private final CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.ipr != null) {
                FrsNewAreaFragment.this.ipr.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.hTh) {
                FrsNewAreaFragment.this.hTh = true;
                FrsNewAreaFragment.this.ipr.cnu();
            }
            if (i == 0) {
                s.cbY().nm(true);
                com.baidu.tieba.s.c.dvJ().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.hTT += i2;
            if (FrsNewAreaFragment.this.hTT >= FrsNewAreaFragment.this.dhi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener eCw = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
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
    private ab hUG = new ab() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bv)) {
                bw bwVar = ((bv) qVar).dUW;
                if (bwVar.bfE() == null || bwVar.bfE().getGroup_id() == 0 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bwVar.bfr() != 1 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.QX(bwVar.getId())) {
                            readThreadHistory.QW(bwVar.getId());
                            if (FrsNewAreaFragment.this.ipr != null) {
                                FrsNewAreaFragment.this.ipr.cnf();
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
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bwVar, FrsNewAreaFragment.this.hSN, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.hSt != null && FrsNewAreaFragment.this.hSt.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.iqZ = FrsNewAreaFragment.this.hSt.needLog == 1;
                            bVar.irb = FrsNewAreaFragment.this.hSt.getForum().getId();
                            bVar.ira = FrsNewAreaFragment.this.ipq.crX();
                            if (com.baidu.tieba.frs.d.d.icR != null) {
                                bVar.irc = com.baidu.tieba.frs.d.d.icR.irc;
                                bVar.ird = com.baidu.tieba.frs.d.d.icR.ird;
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
            this.ipq.am(bwVar);
            this.ipr.clA();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.hSt = frsViewData;
            hideLoadingView(this.ipr.bZc());
            if (this.ipr != null) {
                this.ipr.kh(false);
                this.ipr.a(null, this.mPn, this.hSt, this.gRm);
            }
        }
    }

    private void showLoadingView() {
        this.ipr.oF(false);
        showLoadingView(this.ipr.bZc(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.ipr.oF(true);
        hideLoadingView(this.ipr.bZc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.ipr.oF(false);
        this.ipr.oE(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.ipr.bGU();
        this.ipr.getListView().getData().clear();
        this.ipr.cnf();
        if (this.hZi == null) {
            this.hZi = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hZi.setTitle(null);
            this.hZi.setButtonText(null);
            this.hZi.showRefreshButton();
            this.hZi.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hZi.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hZi.setSubText(null);
        }
        this.hZi.onChangeSkinType();
        this.hZi.attachView(this.ipr.bZc(), true);
        registerListener(this.hWx);
    }

    private void bFX() {
        this.ipr.oF(true);
        this.ipr.oE(true);
        if (this.hZi != null && this.hZi.isViewAttached()) {
            this.hZi.dettachView(this.ipr.bZc());
        }
        MessageManager.getInstance().unRegisterListener(this.hWx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(boolean z) {
        this.hpv = true;
        cms();
        bFX();
        if (!z) {
            bFX();
            showLoadingView();
        }
        this.ipq.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hvt = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.hvt = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.eRN = this.beginTime - this.hvt;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dvJ().A(getUniqueId());
        this.ipq = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.ipq.aj(arguments);
        } else if (bundle != null) {
            this.ipq.aj(bundle);
        } else {
            this.ipq.aj(null);
        }
        this.hSU = getVoiceManager();
        this.hSU.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dUF);
        registerListener(this.imZ);
        registerListener(this.hUh);
        this.imU = new FrsLoadMoreModel(this, null);
        this.imU.registerListener();
        this.imU.setPageType(3);
        this.imU.oY(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dhi = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.ipr = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.hpv) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                oW(false);
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
        this.hSU = getVoiceManager();
        this.hSU.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cri();
        if (bundle != null) {
            this.hSN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.hSN = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cri() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eCw);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ipr != null) {
            this.ipr.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hWx);
        com.baidu.tieba.s.c.dvJ().B(getUniqueId());
        s.cbY().nm(false);
        super.onDestroy();
        this.ipq.crr();
        this.hSU = getVoiceManager();
        this.hSU.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.imY);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hSN);
        bundle.putString("from", this.mFrom);
        this.ipq.onSaveInstanceState(bundle);
        this.hSU = getVoiceManager();
        if (this.hSU != null) {
            this.hSU.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bw threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.ipr.csl().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.hSt.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.nj(intent.getIntExtra("good_data", 0));
                            threadDataById.bfC();
                            oW(false);
                            return;
                        } else if (intExtra == 0) {
                            this.hSt.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.hSt.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.ipr.crn();
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
            if (this.ibS == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.hpv) {
                com.baidu.adp.lib.f.e.mS().post(this.imY);
            }
        }
        cov();
    }

    private void cov() {
        if (isPrimary()) {
            if (this.hZi != null && this.hZi.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hWx);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hWx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ipr != null) {
            this.ipr.cnf();
        }
        this.hSU = getVoiceManager();
        this.hSU.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.ipr.a(this.hUG);
        this.ipr.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ibS != 3 || this.ipr != null) {
            this.ibS = i;
            super.onChangeSkinType(i);
            if (this.ipr != null) {
                this.ipr.onChangeSkinType(i);
            }
            if (this.hZi != null && this.hZi.isViewAttached()) {
                this.hZi.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> clg() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).clg();
        }
        return null;
    }

    private void cmm() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mT().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.QR(FrsNewAreaFragment.this.hSN);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmn() {
        cms();
        try {
            if (this.hSt != null) {
                this.ipr.coF();
                this.ipr.bLt();
                this.hSN = this.hSt.getForum().getName();
                this.forumId = this.hSt.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.hSt.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hSt.getUserData().getBimg_end_time());
                cmm();
                ArrayList<q> threadList = this.hSt.getThreadList();
                if (threadList != null) {
                    this.ipr.a(threadList, this.mPn, this.hSt, this.hSt.getPage().bdu());
                    crk();
                    this.ipr.crn();
                    if (this.hSt.getIsNewUrl() == 1) {
                        this.ipr.csl().setFromCDN(true);
                    } else {
                        this.ipr.csl().setFromCDN(false);
                    }
                    this.ipr.setListViewSelection(cr(csj().getType(), this.mPn));
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
        this.hSU = getVoiceManager();
        this.hSU.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.cbY().nm(false);
        com.baidu.tieba.s.c.dvJ().b(getUniqueId(), false);
        if (this.hSt != null && this.hSt.getForum() != null) {
            com.baidu.tbadk.distribute.a.brj().b(getPageContext().getPageActivity(), "frs", this.hSt.getForum().getId(), 0L);
        }
        this.hSU = getVoiceManager();
        if (this.hSU != null) {
            this.hSU.onStop(getPageContext());
        }
    }

    public void cpe() {
        if (this.ipr != null && this.ipr.getListView() != null) {
            this.ipr.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    FrsNewAreaFragment.this.ipr.refreshView();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yi(int i) {
        ArrayList<q> threadList = this.hSt.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).dUW;
                    if (bwVar.getId() != null && bwVar.getId().equals(this.imR)) {
                        c(bwVar, i);
                        this.imR = null;
                        break;
                    }
                }
            }
            this.ipr.csl().b(threadList, this.hSt);
            this.ipr.csl().notifyDataSetChanged();
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
        if (this.hSU == null) {
            this.hSU = VoiceManager.instance();
        }
        return this.hSU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView blc() {
        if (this.ipr == null) {
            return null;
        }
        return this.ipr.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cms() {
        this.hSU = getVoiceManager();
        this.hSU.stopPlay();
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
        if (this.hSt != null && this.ipr != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.ipr.cnf();
            }
        }
    }

    private void crk() {
        HashMap<Integer, bw> cpI;
        if (this.ipr != null && this.ipr.csl() != null && (cpI = this.ipr.csl().cpI()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bw> entry : cpI.entrySet()) {
                bw value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.brp().L(arrayList);
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
            oW(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cmx() {
        return this.hSt;
    }

    public FrsNewAreaModelController csj() {
        return this.ipq;
    }

    public void IM(String str) {
        this.hSN = str;
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

    public void bFE() {
        if (!this.imU.isLoading && !this.ipq.isLoading()) {
            if (this.imU.cO(this.hSt.getThreadListIds())) {
                this.ipr.a(this.imU.crG(), this.mPn, this.hSt, 0);
                this.imU.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.hSt.getThreadListIds(), this.hSN, this.mPn, this.hSt.isBrandForum);
            } else if (this.gRm != 0) {
                this.ipr.a(this.imU.crG(), this.mPn, this.hSt, 0);
                this.mPn++;
                this.ipq.yk(this.mPn);
                this.imU.loadingDone = false;
                this.imU.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.ipr.bGU();
        } else if (!this.ipr.cno()) {
            if (!this.ipq.crv()) {
                this.ipr.bGU();
                return;
            }
            bFT();
            bFE();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bFT();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void au(ArrayList<q> arrayList) {
        ArrayList<q> a;
        bFT();
        if (arrayList != null && arrayList.size() != 0 && (a = this.imU.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.hSt.setThreadList(a);
            this.ipr.a(a, this.mPn, this.hSt, 0);
        }
    }

    public void cP(List<String> list) {
        cD(list);
        int i = 0;
        Iterator<q> it = this.hSt.getThreadList().iterator();
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
            bFE();
        }
    }

    private void cD(List<String> list) {
        if (!y.isEmpty(list)) {
            ArrayList<q> threadList = this.hSt.getThreadList();
            if (!y.isEmpty(threadList) && this.ipr.getListView() != null && this.ipr.getListView().getData() != null) {
                Iterator<q> it = threadList.iterator();
                List<q> data = this.ipr.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).dUW;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.imU.d(next);
                                this.ipr.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel crj() {
        return this.imU;
    }

    private void bFT() {
        if (this.gRm == 0 && !this.imU.cO(this.hSt.getThreadListIds())) {
            if (this.hSt.getThreadList() == null || this.hSt.getThreadList().size() == 0) {
                this.ipr.bGU();
                return;
            } else {
                this.ipr.bGT();
                return;
            }
        }
        this.ipr.bGS();
    }

    public g csk() {
        return this.ipr;
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
        com.baidu.tbadk.distribute.a.brj().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void cmr() {
        if (this.ipq != null) {
            this.ipq.cmr();
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
    public NavigationBar bJI() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hSN;
    }

    @Override // com.baidu.tieba.frs.as
    public void clA() {
        if (this.ipr != null && this.ipr.getListView() != null) {
            this.ipr.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bGR() {
        if (this.ipr != null) {
            clA();
            this.ipr.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hTv.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a rQ(int i) {
        return this.hTv.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hSt != null) {
            i = this.hSt.getSortType();
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
            com.baidu.tieba.a.d.bAB().Dj("page_frs_good");
            oW(true);
            return;
        }
        this.ipr.kh(false);
    }

    @Override // com.baidu.tieba.frs.au
    public void bkE() {
        com.baidu.tieba.s.c.dvJ().b(getUniqueId(), false);
    }
}
