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
    private VoiceManager iSW;
    private com.baidu.tbadk.l.c iZi;
    private String jpL;
    private FrsLoadMoreModel jpO;
    private FrsNewAreaModelController jsk;
    private String iSP = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData iSv = new FrsViewData();
    public long ivA = -1;
    public long fCb = 0;
    public long fCl = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected g jsl = null;
    private int hKZ = -1;
    private int jbT = 3;
    private boolean ipD = false;
    private boolean jpR = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iTw = new SparseArray<>();
    private int dOW = 0;
    private int iTU = 0;
    private CustomMessageListener iWz = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.iZi != null && FrsNewAreaFragment.this.iZi.isViewAttached()) {
                FrsNewAreaFragment.this.iZi.sB(num.intValue());
            }
        }
    };
    private Runnable jpS = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.ipD) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.qM(false);
            }
        }
    };
    private CustomMessageListener jpT = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof by)) {
                by byVar = (by) customResponsedMessage.getData();
                FrsNewAreaFragment.this.jpL = byVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.jpL) && byVar.boA() != null) {
                    FrsNewAreaFragment.this.Bf(byVar.boA().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener iUj = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.bvQ() != null) {
                        FrsNewAreaFragment.this.bvQ().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.iZi != null && FrsNewAreaFragment.this.iZi.isViewAttached()) {
                        FrsNewAreaFragment.this.qM(false);
                    } else if (FrsNewAreaFragment.this.jsl != null) {
                        FrsNewAreaFragment.this.jsl.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s iUB = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long jpW = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void zJ(int i) {
            if (!FrsNewAreaFragment.this.jpR) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.jsl.cDs();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.jsl.lx(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<q> a2;
            if (FrsNewAreaFragment.this.jpR) {
                if (FrsNewAreaFragment.this.cJv().cIF() == null) {
                    FrsNewAreaFragment.this.jpR = false;
                    return;
                } else if (FrsNewAreaFragment.this.cJv().cIF().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.jpR = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jpW = 1L;
            } else if (fVar.isSuccess) {
                this.jpW = 0L;
            } else {
                this.jpW = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.jpO.resetData();
            }
            FrsNewAreaFragment.this.jsl.lx(false);
            if (FrsNewAreaFragment.this.cJv().cIF() != null) {
                FrsNewAreaFragment.this.iSv = FrsNewAreaFragment.this.cJv().cIF();
            }
            FrsNewAreaFragment.this.hKZ = FrsNewAreaFragment.this.iSv.getPage().bnF();
            if (FrsNewAreaFragment.this.hKZ == 0 && (FrsNewAreaFragment.this.iSv.getThreadListIds() == null || FrsNewAreaFragment.this.iSv.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.iSv.getThreadList() == null || FrsNewAreaFragment.this.iSv.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.jsl.bTb();
                } else {
                    FrsNewAreaFragment.this.jsl.Ya();
                }
            } else {
                FrsNewAreaFragment.this.jsl.XZ();
            }
            if (i == 4) {
                ArrayList<q> a3 = FrsNewAreaFragment.this.jpO.a(false, false, false, FrsNewAreaFragment.this.iSv.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsNewAreaFragment.this.iSv.setThreadList(a3);
                    FrsNewAreaFragment.this.jsl.a(a3, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.iSv, FrsNewAreaFragment.this.hKZ);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.jsl.cDs();
                    break;
                case 2:
                    FrsNewAreaFragment.this.jsl.cDs();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.iSv.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.jpW != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.iSv != null) {
                    FrsNewAreaFragment.this.iSP = FrsNewAreaFragment.this.iSv.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.iSv.getForum().getId();
                    FrsNewAreaFragment.this.jsl.b(FrsNewAreaFragment.this.iSv.getForum(), FrsNewAreaFragment.this.iSv.getUserData());
                }
                if (FrsNewAreaFragment.this.iSv != null) {
                    FrsNewAreaFragment.this.iSv.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.iSv == null || FrsNewAreaFragment.this.iSv.getThreadList() == null || FrsNewAreaFragment.this.iSv.getThreadList().size() != 0 || FrsNewAreaFragment.this.cJv().getType() != 4) {
                    if (FrsNewAreaFragment.this.iSv != null && (a2 = FrsNewAreaFragment.this.jpO.a(false, false, true, FrsNewAreaFragment.this.iSv.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsNewAreaFragment.this.iSv.setThreadList(a2);
                    }
                    FrsNewAreaFragment.this.cCz();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.ivA > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.ivA, FrsNewAreaFragment.this.cJv().cwp() - FrsNewAreaFragment.this.ivA, FrsNewAreaFragment.this.cJv().cwn(), FrsNewAreaFragment.this.cJv().cwo(), currentTimeMillis2 - FrsNewAreaFragment.this.cJv().cwm());
                        FrsNewAreaFragment.this.ivA = -1L;
                    }
                    FrsNewAreaFragment.this.fCl = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.ivA > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.ivA, FrsNewAreaFragment.this.cJv().cwp() - FrsNewAreaFragment.this.ivA, FrsNewAreaFragment.this.cJv().cwn(), FrsNewAreaFragment.this.cJv().cwo(), currentTimeMillis3 - FrsNewAreaFragment.this.cJv().cwm());
                FrsNewAreaFragment.this.ivA = -1L;
            }
            FrsNewAreaFragment.this.fCl = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCt() {
        }
    };
    private final CustomMessageListener eCA = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.jsl != null) {
                FrsNewAreaFragment.this.jsl.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                t.csh().oX(true);
                com.baidu.tieba.t.c.dOf().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.iTU += i2;
            if (FrsNewAreaFragment.this.iTU >= FrsNewAreaFragment.this.dOW * 2 && i2 < 0) {
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
    private ab iUI = new ab() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
                            if (FrsNewAreaFragment.this.jsl != null) {
                                FrsNewAreaFragment.this.jsl.cDs();
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
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(byVar, FrsNewAreaFragment.this.iSP, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(byVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.iSv != null && FrsNewAreaFragment.this.iSv.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.jtR = FrsNewAreaFragment.this.iSv.needLog == 1;
                            bVar.jtT = FrsNewAreaFragment.this.iSv.getForum().getId();
                            bVar.jtS = FrsNewAreaFragment.this.jsk.cJj();
                            if (com.baidu.tieba.frs.d.d.jcU != null) {
                                bVar.jtU = com.baidu.tieba.frs.d.d.jcU.jtU;
                                bVar.jtV = com.baidu.tieba.frs.d.d.jcU.jtV;
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
            this.jsk.ap(byVar);
            this.jsl.cBM();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.iSv = frsViewData;
            hideLoadingView(this.jsl.cno());
            if (this.jsl != null) {
                this.jsl.lx(false);
                this.jsl.a(null, this.mPn, this.iSv, this.hKZ);
            }
        }
    }

    private void showLoadingView() {
        this.jsl.qr(false);
        showLoadingView(this.jsl.cno(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jsl.qr(true);
        hideLoadingView(this.jsl.cno());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.jsl.qr(false);
        this.jsl.qq(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jsl.bTb();
        this.jsl.getListView().getData().clear();
        this.jsl.cDs();
        if (this.iZi == null) {
            this.iZi = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.iZi.setTitle(null);
            this.iZi.setButtonText(null);
            this.iZi.showRefreshButton();
            this.iZi.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.iZi.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.iZi.setSubText(null);
        }
        this.iZi.onChangeSkinType();
        this.iZi.attachView(this.jsl.cno(), true);
        registerListener(this.iWz);
    }

    private void Yb() {
        this.jsl.qr(true);
        this.jsl.qq(true);
        if (this.iZi != null && this.iZi.isViewAttached()) {
            this.iZi.dettachView(this.jsl.cno());
        }
        MessageManager.getInstance().unRegisterListener(this.iWz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(boolean z) {
        this.ipD = true;
        cCF();
        Yb();
        if (!z) {
            Yb();
            showLoadingView();
        }
        this.jsk.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ivA = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.ivA = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.fCb = this.beginTime - this.ivA;
        super.onCreate(bundle);
        com.baidu.tieba.t.c.dOf().z(getUniqueId());
        this.jsk = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.jsk.aj(arguments);
        } else if (bundle != null) {
            this.jsk.aj(bundle);
        } else {
            this.jsk.aj(null);
        }
        this.iSW = getVoiceManager();
        this.iSW.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eCA);
        registerListener(this.jpT);
        registerListener(this.iUj);
        this.jpO = new FrsLoadMoreModel(this, null);
        this.jpO.registerListener();
        this.jpO.setPageType(3);
        this.jpO.qO(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dOW = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jsl = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.ipD) {
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
        this.iSW = getVoiceManager();
        this.iSW.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cIu();
        if (bundle != null) {
            this.iSP = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.iSP = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cIu() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.flC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jsl != null) {
            this.jsl.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iWz);
        com.baidu.tieba.t.c.dOf().A(getUniqueId());
        t.csh().oX(false);
        super.onDestroy();
        this.jsk.cID();
        this.iSW = getVoiceManager();
        this.iSW.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jpS);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iSP);
        bundle.putString("from", this.mFrom);
        this.jsk.onSaveInstanceState(bundle);
        this.iSW = getVoiceManager();
        if (this.iSW != null) {
            this.iSW.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        by threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jsl.cJx().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.iSv.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.oG(intent.getIntExtra("good_data", 0));
                            threadDataById.bpP();
                            qM(false);
                            return;
                        } else if (intExtra == 0) {
                            this.iSv.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.iSv.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jsl.cIz();
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
            if (this.jbT == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.ipD) {
                com.baidu.adp.lib.f.e.mY().post(this.jpS);
            }
        }
        cEI();
    }

    private void cEI() {
        if (isPrimary()) {
            if (this.iZi != null && this.iZi.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iWz);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iWz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jsl != null) {
            this.jsl.cDs();
        }
        this.iSW = getVoiceManager();
        this.iSW.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jsl.a(this.iUI);
        this.jsl.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jbT != 3 || this.jsl != null) {
            this.jbT = i;
            super.onChangeSkinType(i);
            if (this.jsl != null) {
                this.jsl.onChangeSkinType(i);
            }
            if (this.iZi != null && this.iZi.isViewAttached()) {
                this.iZi.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBs() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cBs();
        }
        return null;
    }

    private void cCy() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TV(FrsNewAreaFragment.this.iSP);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCz() {
        cCF();
        try {
            if (this.iSv != null) {
                this.jsl.cES();
                this.jsl.bYt();
                this.iSP = this.iSv.getForum().getName();
                this.forumId = this.iSv.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.iSv.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iSv.getUserData().getBimg_end_time());
                cCy();
                ArrayList<q> threadList = this.iSv.getThreadList();
                if (threadList != null) {
                    this.jsl.a(threadList, this.mPn, this.iSv, this.iSv.getPage().bnF());
                    cIw();
                    this.jsl.cIz();
                    if (this.iSv.getIsNewUrl() == 1) {
                        this.jsl.cJx().setFromCDN(true);
                    } else {
                        this.jsl.cJx().setFromCDN(false);
                    }
                    this.jsl.setListViewSelection(cD(cJv().getType(), this.mPn));
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
        this.iSW = getVoiceManager();
        this.iSW.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.csh().oX(false);
        com.baidu.tieba.t.c.dOf().b(getUniqueId(), false);
        if (this.iSv != null && this.iSv.getForum() != null) {
            com.baidu.tbadk.distribute.a.bCa().b(getPageContext().getPageActivity(), "frs", this.iSv.getForum().getId(), 0L);
        }
        this.iSW = getVoiceManager();
        if (this.iSW != null) {
            this.iSW.onStop(getPageContext());
        }
    }

    public void cFq() {
        if (this.jsl != null && this.jsl.getListView() != null) {
            this.jsl.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsNewAreaFragment.this.jsl != null && FrsNewAreaFragment.this.jsl.getListView() != null && !FrsNewAreaFragment.this.jsl.getListView().isComputingLayout()) {
                        FrsNewAreaFragment.this.jsl.refreshView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bf(int i) {
        ArrayList<q> threadList = this.iSv.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bx) {
                    by byVar = ((bx) next).eCR;
                    if (byVar.getId() != null && byVar.getId().equals(this.jpL)) {
                        c(byVar, i);
                        this.jpL = null;
                        break;
                    }
                }
            }
            this.jsl.cJx().b(threadList, this.iSv);
            this.jsl.cJx().notifyDataSetChanged();
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
        if (this.iSW == null) {
            this.iSW = VoiceManager.instance();
        }
        return this.iSW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView bvQ() {
        if (this.jsl == null) {
            return null;
        }
        return this.jsl.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cCF() {
        this.iSW = getVoiceManager();
        this.iSW.stopPlay();
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
        if (this.iSv != null && this.jsl != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jsl.cDs();
            }
        }
    }

    private void cIw() {
        HashMap<Integer, by> cFX;
        if (this.jsl != null && this.jsl.cJx() != null && (cFX = this.jsl.cJx().cFX()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, by> entry : cFX.entrySet()) {
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
    public FrsViewData cCK() {
        return this.iSv;
    }

    public FrsNewAreaModelController cJv() {
        return this.jsk;
    }

    public void Lv(String str) {
        this.iSP = str;
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

    public void bRN() {
        if (!this.jpO.isLoading && !this.jsk.isLoading()) {
            if (this.jpO.dx(this.iSv.getThreadListIds())) {
                this.jsl.a(this.jpO.cIS(), this.mPn, this.iSv, 0);
                this.jpO.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.iSv.getThreadListIds(), this.iSP, this.mPn, this.iSv.isBrandForum);
            } else if (this.hKZ != 0) {
                this.jsl.a(this.jpO.cIS(), this.mPn, this.iSv, 0);
                this.mPn++;
                this.jsk.Bh(this.mPn);
                this.jpO.loadingDone = false;
                this.jpO.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.jsl.bTb();
        } else if (!this.jsl.cDB()) {
            if (!this.jsk.cIH()) {
                this.jsl.bTb();
                return;
            }
            bSc();
            bRN();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bSc();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void az(ArrayList<q> arrayList) {
        bSc();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<q> a2 = this.jpO.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.iSv.setThreadList(a2);
                this.jsl.a(a2, this.mPn, this.iSv, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iSv.getForum()));
        }
    }

    public void dy(List<String> list) {
        dh(list);
        int i = 0;
        Iterator<q> it = this.iSv.getThreadList().iterator();
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
            bRN();
        }
    }

    private void dh(List<String> list) {
        if (!y.isEmpty(list)) {
            ArrayList<q> threadList = this.iSv.getThreadList();
            if (!y.isEmpty(threadList) && this.jsl.getListView() != null && this.jsl.getListView().getData() != null) {
                Iterator<q> it = threadList.iterator();
                List<q> data = this.jsl.getListView().getData();
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
                                this.jpO.d(next);
                                this.jsl.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cIv() {
        return this.jpO;
    }

    private void bSc() {
        if (this.hKZ == 0 && !this.jpO.dx(this.iSv.getThreadListIds())) {
            if (this.iSv.getThreadList() == null || this.iSv.getThreadList().size() == 0) {
                this.jsl.bTb();
                return;
            } else {
                this.jsl.Ya();
                return;
            }
        }
        this.jsl.XZ();
    }

    public g cJw() {
        return this.jsl;
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
    public void cCE() {
        if (this.jsk != null) {
            this.jsk.cCE();
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
    public NavigationBar bVL() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iSP;
    }

    @Override // com.baidu.tieba.frs.ar
    public void cBM() {
        if (this.jsl != null && this.jsl.getListView() != null) {
            this.jsl.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bTa() {
        if (this.jsl != null) {
            cBM();
            this.jsl.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iTw.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ub(int i) {
        return this.iTw.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.iSv != null) {
            i = this.iSv.getSortType();
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
            com.baidu.tieba.a.d.bLU().Fn("page_frs_good");
            qM(true);
            return;
        }
        this.jsl.lx(false);
    }

    @Override // com.baidu.tieba.frs.at
    public void bvr() {
        com.baidu.tieba.t.c.dOf().b(getUniqueId(), false);
    }
}
