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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.au;
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
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.recapp.p;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes22.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ar, as, at, com.baidu.tieba.frs.loadmore.a, p, FrsCommonImageLayout.c {
    private VoiceManager iSU;
    private com.baidu.tbadk.l.c iZg;
    private String jpJ;
    private FrsLoadMoreModel jpM;
    private FrsNewAreaModelController jsi;
    private String iSN = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData iSt = new FrsViewData();
    public long ivy = -1;
    public long fCb = 0;
    public long fCl = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected g jsj = null;
    private int hKX = -1;
    private int jbR = 3;
    private boolean ipB = false;
    private boolean jpP = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iTu = new SparseArray<>();
    private int dOW = 0;
    private int iTS = 0;
    private CustomMessageListener iWx = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.iZg != null && FrsNewAreaFragment.this.iZg.isViewAttached()) {
                FrsNewAreaFragment.this.iZg.sB(num.intValue());
            }
        }
    };
    private Runnable jpQ = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.ipB) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.qM(false);
            }
        }
    };
    private CustomMessageListener jpR = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof by)) {
                by byVar = (by) customResponsedMessage.getData();
                FrsNewAreaFragment.this.jpJ = byVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.jpJ) && byVar.boA() != null) {
                    FrsNewAreaFragment.this.Bf(byVar.boA().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener iUh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.bvQ() != null) {
                        FrsNewAreaFragment.this.bvQ().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.iZg != null && FrsNewAreaFragment.this.iZg.isViewAttached()) {
                        FrsNewAreaFragment.this.qM(false);
                    } else if (FrsNewAreaFragment.this.jsj != null) {
                        FrsNewAreaFragment.this.jsj.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s iUz = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long jpU = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void zJ(int i) {
            if (!FrsNewAreaFragment.this.jpP) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.jsj.cDr();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.jsj.lx(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<q> a2;
            if (FrsNewAreaFragment.this.jpP) {
                if (FrsNewAreaFragment.this.cJu().cIE() == null) {
                    FrsNewAreaFragment.this.jpP = false;
                    return;
                } else if (FrsNewAreaFragment.this.cJu().cIE().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.jpP = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jpU = 1L;
            } else if (fVar.isSuccess) {
                this.jpU = 0L;
            } else {
                this.jpU = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.jpM.resetData();
            }
            FrsNewAreaFragment.this.jsj.lx(false);
            if (FrsNewAreaFragment.this.cJu().cIE() != null) {
                FrsNewAreaFragment.this.iSt = FrsNewAreaFragment.this.cJu().cIE();
            }
            FrsNewAreaFragment.this.hKX = FrsNewAreaFragment.this.iSt.getPage().bnF();
            if (FrsNewAreaFragment.this.hKX == 0 && (FrsNewAreaFragment.this.iSt.getThreadListIds() == null || FrsNewAreaFragment.this.iSt.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.iSt.getThreadList() == null || FrsNewAreaFragment.this.iSt.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.jsj.bTa();
                } else {
                    FrsNewAreaFragment.this.jsj.Ya();
                }
            } else {
                FrsNewAreaFragment.this.jsj.XZ();
            }
            if (i == 4) {
                ArrayList<q> a3 = FrsNewAreaFragment.this.jpM.a(false, false, false, FrsNewAreaFragment.this.iSt.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsNewAreaFragment.this.iSt.setThreadList(a3);
                    FrsNewAreaFragment.this.jsj.a(a3, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.iSt, FrsNewAreaFragment.this.hKX);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.jsj.cDr();
                    break;
                case 2:
                    FrsNewAreaFragment.this.jsj.cDr();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.iSt.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.jpU != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.iSt != null) {
                    FrsNewAreaFragment.this.iSN = FrsNewAreaFragment.this.iSt.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.iSt.getForum().getId();
                    FrsNewAreaFragment.this.jsj.b(FrsNewAreaFragment.this.iSt.getForum(), FrsNewAreaFragment.this.iSt.getUserData());
                }
                if (FrsNewAreaFragment.this.iSt != null) {
                    FrsNewAreaFragment.this.iSt.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.iSt == null || FrsNewAreaFragment.this.iSt.getThreadList() == null || FrsNewAreaFragment.this.iSt.getThreadList().size() != 0 || FrsNewAreaFragment.this.cJu().getType() != 4) {
                    if (FrsNewAreaFragment.this.iSt != null && (a2 = FrsNewAreaFragment.this.jpM.a(false, false, true, FrsNewAreaFragment.this.iSt.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsNewAreaFragment.this.iSt.setThreadList(a2);
                    }
                    FrsNewAreaFragment.this.cCy();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.ivy > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.ivy, FrsNewAreaFragment.this.cJu().cwo() - FrsNewAreaFragment.this.ivy, FrsNewAreaFragment.this.cJu().cwm(), FrsNewAreaFragment.this.cJu().cwn(), currentTimeMillis2 - FrsNewAreaFragment.this.cJu().cwl());
                        FrsNewAreaFragment.this.ivy = -1L;
                    }
                    FrsNewAreaFragment.this.fCl = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.ivy > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.ivy, FrsNewAreaFragment.this.cJu().cwo() - FrsNewAreaFragment.this.ivy, FrsNewAreaFragment.this.cJu().cwm(), FrsNewAreaFragment.this.cJu().cwn(), currentTimeMillis3 - FrsNewAreaFragment.this.cJu().cwl());
                FrsNewAreaFragment.this.ivy = -1L;
            }
            FrsNewAreaFragment.this.fCl = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCs() {
        }
    };
    private final CustomMessageListener eCA = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.jsj != null) {
                FrsNewAreaFragment.this.jsj.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                t.csg().oX(true);
                com.baidu.tieba.t.c.dOe().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.iTS += i2;
            if (FrsNewAreaFragment.this.iTS >= FrsNewAreaFragment.this.dOW * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener flC = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
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
    private ab iUG = new ab() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bx)) {
                by byVar = ((bx) qVar).eCR;
                if (byVar.bpR() == null || byVar.bpR().getGroup_id() == 0 || bh.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (byVar.bpC() != 1 || bh.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Ub(byVar.getId())) {
                            readThreadHistory.Ua(byVar.getId());
                            if (FrsNewAreaFragment.this.jsj != null) {
                                FrsNewAreaFragment.this.jsj.cDr();
                            }
                        }
                        boolean z = false;
                        final String boV = byVar.boV();
                        if (boV != null && !boV.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(boV);
                                    aaVar.btv().bue().mIsNeedAddCommenParam = false;
                                    aaVar.btv().bue().mIsUseCurrentBDUSS = false;
                                    aaVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = byVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (byVar.boK() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bf.bua().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            byVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(byVar, FrsNewAreaFragment.this.iSN, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(byVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.iSt != null && FrsNewAreaFragment.this.iSt.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.jtP = FrsNewAreaFragment.this.iSt.needLog == 1;
                            bVar.jtR = FrsNewAreaFragment.this.iSt.getForum().getId();
                            bVar.jtQ = FrsNewAreaFragment.this.jsi.cJi();
                            if (com.baidu.tieba.frs.d.d.jcS != null) {
                                bVar.jtS = com.baidu.tieba.frs.d.d.jcS.jtS;
                                bVar.jtT = com.baidu.tieba.frs.d.d.jcS.jtT;
                            }
                            com.baidu.tieba.frs.d.a.a(byVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar, FrsNewAreaFragment.this.getTbPageTag());
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

    public void ap(by byVar) {
        if (byVar != null) {
            this.jsi.ap(byVar);
            this.jsj.cBL();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.iSt = frsViewData;
            hideLoadingView(this.jsj.cnn());
            if (this.jsj != null) {
                this.jsj.lx(false);
                this.jsj.a(null, this.mPn, this.iSt, this.hKX);
            }
        }
    }

    private void showLoadingView() {
        this.jsj.qr(false);
        showLoadingView(this.jsj.cnn(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jsj.qr(true);
        hideLoadingView(this.jsj.cnn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.jsj.qr(false);
        this.jsj.qq(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jsj.bTa();
        this.jsj.getListView().getData().clear();
        this.jsj.cDr();
        if (this.iZg == null) {
            this.iZg = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.iZg.setTitle(null);
            this.iZg.setButtonText(null);
            this.iZg.showRefreshButton();
            this.iZg.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.iZg.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.iZg.setSubText(null);
        }
        this.iZg.onChangeSkinType();
        this.iZg.attachView(this.jsj.cnn(), true);
        registerListener(this.iWx);
    }

    private void Yb() {
        this.jsj.qr(true);
        this.jsj.qq(true);
        if (this.iZg != null && this.iZg.isViewAttached()) {
            this.iZg.dettachView(this.jsj.cnn());
        }
        MessageManager.getInstance().unRegisterListener(this.iWx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(boolean z) {
        this.ipB = true;
        cCE();
        Yb();
        if (!z) {
            Yb();
            showLoadingView();
        }
        this.jsi.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ivy = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.ivy = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.fCb = this.beginTime - this.ivy;
        super.onCreate(bundle);
        com.baidu.tieba.t.c.dOe().z(getUniqueId());
        this.jsi = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.jsi.aj(arguments);
        } else if (bundle != null) {
            this.jsi.aj(bundle);
        } else {
            this.jsi.aj(null);
        }
        this.iSU = getVoiceManager();
        this.iSU.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eCA);
        registerListener(this.jpR);
        registerListener(this.iUh);
        this.jpM = new FrsLoadMoreModel(this, null);
        this.jpM.registerListener();
        this.jpM.setPageType(3);
        this.jpM.qO(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dOW = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jsj = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.ipB) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                qM(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        btT();
    }

    private void btT() {
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13008");
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dY("fid", this.forumId);
        arVar.al("obj_type", 6);
        arVar.al("obj_locate", 2);
        arVar.btT();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.iSU = getVoiceManager();
        this.iSU.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cIt();
        if (bundle != null) {
            this.iSN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.iSN = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cIt() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.flC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jsj != null) {
            this.jsj.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iWx);
        com.baidu.tieba.t.c.dOe().A(getUniqueId());
        t.csg().oX(false);
        super.onDestroy();
        this.jsi.cIC();
        this.iSU = getVoiceManager();
        this.iSU.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jpQ);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iSN);
        bundle.putString("from", this.mFrom);
        this.jsi.onSaveInstanceState(bundle);
        this.iSU = getVoiceManager();
        if (this.iSU != null) {
            this.iSU.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        by threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jsj.cJw().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.iSt.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.oG(intent.getIntExtra("good_data", 0));
                            threadDataById.bpP();
                            qM(false);
                            return;
                        } else if (intExtra == 0) {
                            this.iSt.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.iSt.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jsj.cIy();
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
            if (this.jbR == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.ipB) {
                com.baidu.adp.lib.f.e.mY().post(this.jpQ);
            }
        }
        cEH();
    }

    private void cEH() {
        if (isPrimary()) {
            if (this.iZg != null && this.iZg.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iWx);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iWx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jsj != null) {
            this.jsj.cDr();
        }
        this.iSU = getVoiceManager();
        this.iSU.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jsj.a(this.iUG);
        this.jsj.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jbR != 3 || this.jsj != null) {
            this.jbR = i;
            super.onChangeSkinType(i);
            if (this.jsj != null) {
                this.jsj.onChangeSkinType(i);
            }
            if (this.iZg != null && this.iZg.isViewAttached()) {
                this.iZg.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBr() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cBr();
        }
        return null;
    }

    private void cCx() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TV(FrsNewAreaFragment.this.iSN);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCy() {
        cCE();
        try {
            if (this.iSt != null) {
                this.jsj.cER();
                this.jsj.bYs();
                this.iSN = this.iSt.getForum().getName();
                this.forumId = this.iSt.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.iSt.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iSt.getUserData().getBimg_end_time());
                cCx();
                ArrayList<q> threadList = this.iSt.getThreadList();
                if (threadList != null) {
                    this.jsj.a(threadList, this.mPn, this.iSt, this.iSt.getPage().bnF());
                    cIv();
                    this.jsj.cIy();
                    if (this.iSt.getIsNewUrl() == 1) {
                        this.jsj.cJw().setFromCDN(true);
                    } else {
                        this.jsj.cJw().setFromCDN(false);
                    }
                    this.jsj.setListViewSelection(cD(cJu().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cD(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.iSU = getVoiceManager();
        this.iSU.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.csg().oX(false);
        com.baidu.tieba.t.c.dOe().b(getUniqueId(), false);
        if (this.iSt != null && this.iSt.getForum() != null) {
            com.baidu.tbadk.distribute.a.bCa().b(getPageContext().getPageActivity(), "frs", this.iSt.getForum().getId(), 0L);
        }
        this.iSU = getVoiceManager();
        if (this.iSU != null) {
            this.iSU.onStop(getPageContext());
        }
    }

    public void cFp() {
        if (this.jsj != null && this.jsj.getListView() != null) {
            this.jsj.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsNewAreaFragment.this.jsj != null && FrsNewAreaFragment.this.jsj.getListView() != null && !FrsNewAreaFragment.this.jsj.getListView().isComputingLayout()) {
                        FrsNewAreaFragment.this.jsj.refreshView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bf(int i) {
        ArrayList<q> threadList = this.iSt.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bx) {
                    by byVar = ((bx) next).eCR;
                    if (byVar.getId() != null && byVar.getId().equals(this.jpJ)) {
                        c(byVar, i);
                        this.jpJ = null;
                        break;
                    }
                }
            }
            this.jsj.cJw().b(threadList, this.iSt);
            this.jsj.cJw().notifyDataSetChanged();
        }
    }

    private void c(by byVar, int i) {
        if (i == 1) {
            PraiseData boA = byVar.boA();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (boA == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    byVar.a(praiseData);
                    return;
                }
                byVar.boA().getUser().add(0, metaData);
                byVar.boA().setNum(byVar.boA().getNum() + 1);
                byVar.boA().setIsLike(i);
            }
        } else if (byVar.boA() != null) {
            byVar.boA().setIsLike(i);
            byVar.boA().setNum(byVar.boA().getNum() - 1);
            ArrayList<MetaData> user = byVar.boA().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        byVar.boA().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iSU == null) {
            this.iSU = VoiceManager.instance();
        }
        return this.iSU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView bvQ() {
        if (this.jsj == null) {
            return null;
        }
        return this.jsj.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cCE() {
        this.iSU = getVoiceManager();
        this.iSU.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bvR() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bvR();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.iSt != null && this.jsj != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jsj.cDr();
            }
        }
    }

    private void cIv() {
        HashMap<Integer, by> cFW;
        if (this.jsj != null && this.jsj.cJw() != null && (cFW = this.jsj.cJw().cFW()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, by> entry : cFW.entrySet()) {
                by value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bCg().L(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        if (bvQ() == null) {
            return null;
        }
        return bvQ().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            qM(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cCJ() {
        return this.iSt;
    }

    public FrsNewAreaModelController cJu() {
        return this.jsi;
    }

    public void Lv(String str) {
        this.iSN = str;
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

    public void bRM() {
        if (!this.jpM.isLoading && !this.jsi.isLoading()) {
            if (this.jpM.dx(this.iSt.getThreadListIds())) {
                this.jsj.a(this.jpM.cIR(), this.mPn, this.iSt, 0);
                this.jpM.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.iSt.getThreadListIds(), this.iSN, this.mPn, this.iSt.isBrandForum);
            } else if (this.hKX != 0) {
                this.jsj.a(this.jpM.cIR(), this.mPn, this.iSt, 0);
                this.mPn++;
                this.jsi.Bh(this.mPn);
                this.jpM.loadingDone = false;
                this.jpM.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.jsj.bTa();
        } else if (!this.jsj.cDA()) {
            if (!this.jsi.cIG()) {
                this.jsj.bTa();
                return;
            }
            bSb();
            bRM();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bSb();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void az(ArrayList<q> arrayList) {
        bSb();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<q> a2 = this.jpM.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.iSt.setThreadList(a2);
                this.jsj.a(a2, this.mPn, this.iSt, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iSt.getForum()));
        }
    }

    public void dy(List<String> list) {
        dh(list);
        int i = 0;
        Iterator<q> it = this.iSt.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bx ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            bRM();
        }
    }

    private void dh(List<String> list) {
        if (!y.isEmpty(list)) {
            ArrayList<q> threadList = this.iSt.getThreadList();
            if (!y.isEmpty(threadList) && this.jsj.getListView() != null && this.jsj.getListView().getData() != null) {
                Iterator<q> it = threadList.iterator();
                List<q> data = this.jsj.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bx) {
                        by byVar = ((bx) next).eCR;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!au.equals(list.get(i2), byVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jpM.d(next);
                                this.jsj.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cIu() {
        return this.jpM;
    }

    private void bSb() {
        if (this.hKX == 0 && !this.jpM.dx(this.iSt.getThreadListIds())) {
            if (this.iSt.getThreadList() == null || this.iSt.getThreadList().size() == 0) {
                this.jsj.bTa();
                return;
            } else {
                this.jsj.Ya();
                return;
            }
        }
        this.jsj.XZ();
    }

    public g cJv() {
        return this.jsj;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.n.a.a.InterfaceC0276a
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

    @Override // com.baidu.tieba.recapp.p
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.p
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bCa().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.p
    public void cCD() {
        if (this.jsi != null) {
            this.jsi.cCD();
        }
    }

    @Override // com.baidu.tieba.recapp.p
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.p
    public int getPageNum() {
        return this.mPn;
    }

    @Override // com.baidu.tieba.frs.as
    public NavigationBar bVK() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iSN;
    }

    @Override // com.baidu.tieba.frs.ar
    public void cBL() {
        if (this.jsj != null && this.jsj.getListView() != null) {
            this.jsj.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bSZ() {
        if (this.jsj != null) {
            cBL();
            this.jsj.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iTu.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ub(int i) {
        return this.iTu.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.iSt != null) {
            i = this.iSt.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.j.BF(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.at
    public void bvq() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bLT().Fn("page_frs_good");
            qM(true);
            return;
        }
        this.jsj.lx(false);
    }

    @Override // com.baidu.tieba.frs.at
    public void bvr() {
        com.baidu.tieba.t.c.dOe().b(getUniqueId(), false);
    }
}
