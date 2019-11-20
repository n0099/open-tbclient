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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ag, ah, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String fLF;
    private FrsLoadMoreModel fLI;
    private FrsNewAreaModelController fOd;
    private VoiceManager fuw;
    private com.baidu.tbadk.m.c fzu;
    private String fup = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData fua = new FrsViewData();
    public long faW = -1;
    public long cLi = 0;
    public long cLq = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fuI = false;
    protected g fOe = null;
    private int euS = -1;
    private int fCk = 3;
    private boolean eVe = false;
    public boolean fLL = false;
    private boolean fLM = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fuV = new SparseArray<>();
    private CustomMessageListener fxx = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.fzu != null && FrsNewAreaFragment.this.fzu.isViewAttached()) {
                FrsNewAreaFragment.this.fzu.jY(num.intValue());
            }
        }
    };
    private Runnable fLN = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.eVe) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.kv(false);
            }
        }
    };
    private CustomMessageListener fLO = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                bh bhVar = (bh) customResponsedMessage.getData();
                FrsNewAreaFragment.this.fLF = bhVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.fLF) && bhVar.aiq() != null) {
                    FrsNewAreaFragment.this.rr(bhVar.aiq().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fvB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.aod() != null) {
                        FrsNewAreaFragment.this.aod().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.fzu != null && FrsNewAreaFragment.this.fzu.isViewAttached()) {
                        FrsNewAreaFragment.this.kv(false);
                    } else if (FrsNewAreaFragment.this.fOe != null) {
                        FrsNewAreaFragment.this.fOe.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final p fvR = new p() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long fLR = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void qp(int i) {
            if (!FrsNewAreaFragment.this.fLM) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.fOe.bkQ();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.fOe.fU(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.fLM) {
                if (FrsNewAreaFragment.this.bpu().boK() == null) {
                    FrsNewAreaFragment.this.fLM = false;
                    return;
                } else if (FrsNewAreaFragment.this.bpu().boK().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.fLM = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.fLR = 1L;
            } else if (bVar.isSuccess) {
                this.fLR = 0L;
            } else {
                this.fLR = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.fLI.resetData();
            }
            FrsNewAreaFragment.this.fOe.fU(false);
            if (FrsNewAreaFragment.this.bpu().boK() != null) {
                FrsNewAreaFragment.this.fua = FrsNewAreaFragment.this.bpu().boK();
            }
            FrsNewAreaFragment.this.euS = FrsNewAreaFragment.this.fua.getPage().ahy();
            if (FrsNewAreaFragment.this.euS == 0 && (FrsNewAreaFragment.this.fua.getThreadListIds() == null || FrsNewAreaFragment.this.fua.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.fua.getThreadList() == null || FrsNewAreaFragment.this.fua.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.fOe.aKi();
                } else {
                    FrsNewAreaFragment.this.fOe.aKh();
                }
            } else {
                FrsNewAreaFragment.this.fOe.aKg();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.fLI.a(false, false, false, FrsNewAreaFragment.this.fua.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.fua.setThreadList(a2);
                    FrsNewAreaFragment.this.fOe.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.fua, FrsNewAreaFragment.this.euS);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.fOe.bkQ();
                    break;
                case 2:
                    FrsNewAreaFragment.this.fOe.bkQ();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.fua.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.fLR != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.fua != null) {
                    FrsNewAreaFragment.this.fup = FrsNewAreaFragment.this.fua.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.fua.getForum().getId();
                    FrsNewAreaFragment.this.fOe.b(FrsNewAreaFragment.this.fua.getForum(), FrsNewAreaFragment.this.fua.getUserData());
                }
                if (FrsNewAreaFragment.this.fua != null) {
                    FrsNewAreaFragment.this.fua.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.fua == null || FrsNewAreaFragment.this.fua.getThreadList() == null || FrsNewAreaFragment.this.fua.getThreadList().size() != 0 || FrsNewAreaFragment.this.bpu().getType() != 4) {
                    if (FrsNewAreaFragment.this.fua != null && (a = FrsNewAreaFragment.this.fLI.a(false, false, true, FrsNewAreaFragment.this.fua.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.fua.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bkf();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.faW > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.faW, FrsNewAreaFragment.this.bpu().beM() - FrsNewAreaFragment.this.faW, FrsNewAreaFragment.this.bpu().beK(), FrsNewAreaFragment.this.bpu().beL(), currentTimeMillis2 - FrsNewAreaFragment.this.bpu().beJ());
                        FrsNewAreaFragment.this.faW = -1L;
                    }
                    FrsNewAreaFragment.this.cLq = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.faW > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.faW, FrsNewAreaFragment.this.bpu().beM() - FrsNewAreaFragment.this.faW, FrsNewAreaFragment.this.bpu().beK(), FrsNewAreaFragment.this.bpu().beL(), currentTimeMillis3 - FrsNewAreaFragment.this.bpu().beJ());
                FrsNewAreaFragment.this.faW = -1L;
            }
            FrsNewAreaFragment.this.cLq = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
        }
    };
    private final CustomMessageListener bVa = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.fOe != null) {
                FrsNewAreaFragment.this.fOe.startPullRefresh();
            }
        }
    };
    private final h.c dBK = new h.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.tieba.a.d.aDc().rg("page_frs_good");
                FrsNewAreaFragment.this.kv(true);
                return;
            }
            FrsNewAreaFragment.this.fOe.fU(false);
        }
    };
    private final h.b cpb = new h.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.h.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.cni().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.fuI) {
                FrsNewAreaFragment.this.fuI = true;
                FrsNewAreaFragment.this.fOe.ble();
            }
            if (i == 0) {
                t.bau().iK(true);
                com.baidu.tieba.q.c.cni().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener cwi = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
    private s fvX = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bg)) {
                bh bhVar = ((bg) mVar).caz;
                if (bhVar.ajw() == null || bhVar.ajw().getGroup_id() == 0 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bhVar.ajo() != 1 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Ec(bhVar.getId())) {
                            readThreadHistory.Eb(bhVar.getId());
                            if (FrsNewAreaFragment.this.fOe != null) {
                                FrsNewAreaFragment.this.fOe.bkQ();
                            }
                        }
                        boolean z = false;
                        final String aiL = bhVar.aiL();
                        if (aiL != null && !aiL.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aiL);
                                    xVar.amp().amP().mIsNeedAddCommenParam = false;
                                    xVar.amp().amP().mIsUseCurrentBDUSS = false;
                                    xVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bhVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bhVar.aiz() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.amO().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bhVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bhVar, FrsNewAreaFragment.this.fup, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsNewAreaFragment.this.fLL ? 15 : 3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.fua != null && FrsNewAreaFragment.this.fua.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fPK = FrsNewAreaFragment.this.fua.needLog == 1;
                            bVar.fPM = FrsNewAreaFragment.this.fua.getForum().getId();
                            bVar.fPL = FrsNewAreaFragment.this.fOd.bpn();
                            if (com.baidu.tieba.frs.d.d.fDi != null) {
                                bVar.fPN = com.baidu.tieba.frs.d.d.fDi.fPN;
                                bVar.fPO = com.baidu.tieba.frs.d.d.fDi.fPO;
                            }
                            com.baidu.tieba.frs.d.a.a(bhVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar);
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

    public void ac(bh bhVar) {
        if (bhVar != null) {
            this.fOd.ac(bhVar);
            this.fOe.bjw();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.fua = frsViewData;
            hideLoadingView(this.fOe.aYb());
            if (this.fOe != null) {
                this.fOe.fU(false);
                this.fOe.a(null, this.mPn, this.fua, this.euS);
            }
        }
    }

    private void showLoadingView() {
        this.fOe.kf(false);
        showLoadingView(this.fOe.aYb(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fOe.kf(true);
        hideLoadingView(this.fOe.aYb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fOe.kf(false);
        this.fOe.bmc().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.fOe.aKi();
        this.fOe.getListView().getData().clear();
        this.fOe.bkQ();
        if (this.fzu == null) {
            this.fzu = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fzu.setTitle(null);
            this.fzu.setButtonText(null);
            this.fzu.showRefreshButton();
            this.fzu.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.fzu.setSubText(getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.fzu.setSubText(null);
        }
        this.fzu.onChangeSkinType();
        this.fzu.attachView(this.fOe.aYb(), true);
        registerListener(this.fxx);
    }

    private void aJm() {
        this.fOe.kf(true);
        this.fOe.bmc().setEnabled(true);
        if (this.fzu != null && this.fzu.isViewAttached()) {
            this.fzu.dettachView(this.fOe.aYb());
        }
        MessageManager.getInstance().unRegisterListener(this.fxx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kv(boolean z) {
        this.eVe = true;
        bki();
        aJm();
        if (!z) {
            aJm();
            showLoadingView();
        }
        this.fOd.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.faW = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.faW = System.currentTimeMillis();
        }
        this.forumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.cLi = this.beginTime - this.faW;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cni().v(getUniqueId());
        this.fOd = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.fOd.K(arguments);
        } else if (bundle != null) {
            this.fOd.K(bundle);
        } else {
            this.fOd.K(null);
        }
        this.fuw = getVoiceManager();
        this.fuw.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bVa);
        registerListener(this.fLO);
        registerListener(this.fvB);
        this.fLI = new FrsLoadMoreModel(this, null);
        this.fLI.registerListener();
        this.fLI.setPageType(3);
        this.fLI.ky(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fOe = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eVe) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                kv(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        amI();
    }

    private void amI() {
        an anVar = new an("c13008");
        anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bS("fid", this.forumId);
        anVar.O("obj_type", 6);
        anVar.O("obj_locate", 2);
        anVar.amI();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fuw = getVoiceManager();
        this.fuw.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        boA();
        if (bundle != null) {
            this.fup = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.fup = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void boA() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cwi);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fOe != null) {
            this.fOe.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fxx);
        com.baidu.tieba.q.c.cni().w(getUniqueId());
        t.bau().iK(false);
        super.onDestroy();
        this.fOd.aGF();
        this.fuw = getVoiceManager();
        this.fuw.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fLN);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.fup);
        bundle.putString("from", this.mFrom);
        this.fOd.onSaveInstanceState(bundle);
        this.fuw = getVoiceManager();
        if (this.fuw != null) {
            this.fuw.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bh threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.fOe.bpw().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.fua.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.hK(intent.getIntExtra("good_data", 0));
                            threadDataById.aju();
                            kv(false);
                            return;
                        } else if (intExtra == 0) {
                            this.fua.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.fua.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.m());
                            }
                            this.fOe.boF();
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
            if (this.fCk == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.eVe) {
                com.baidu.adp.lib.g.e.fZ().post(this.fLN);
            }
        }
        blS();
    }

    private void blS() {
        if (isPrimary()) {
            if (this.fzu != null && this.fzu.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fxx);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fxx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fOe != null) {
            this.fOe.bkQ();
        }
        this.fuw = getVoiceManager();
        this.fuw.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fOe.a(this.fvX);
        this.fOe.setOnScrollListener(this.mScrollListener);
        this.fOe.setListPullRefreshListener(this.dBK);
        this.fOe.a(this.cpb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fCk != 3 || this.fOe != null) {
            this.fCk = i;
            super.onChangeSkinType(i);
            if (this.fOe != null) {
                this.fOe.onChangeSkinType(i);
            }
            if (this.fzu != null && this.fzu.isViewAttached()) {
                this.fzu.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bji() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bji();
        }
        return null;
    }

    private void bke() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.ga().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.DW(FrsNewAreaFragment.this.fup);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkf() {
        bki();
        try {
            if (this.fua != null) {
                this.fOe.aMo();
                this.fup = this.fua.getForum().getName();
                this.forumId = this.fua.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.fua.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fua.getUserData().getBimg_end_time());
                bke();
                ArrayList<m> threadList = this.fua.getThreadList();
                if (threadList != null) {
                    this.fOe.a(threadList, this.mPn, this.fua, this.fua.getPage().ahy());
                    boC();
                    this.fOe.boF();
                    if (this.fua.getIsNewUrl() == 1) {
                        this.fOe.bpw().setFromCDN(true);
                    } else {
                        this.fOe.bpw().setFromCDN(false);
                    }
                    this.fOe.setListViewSelection(bw(bpu().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int bw(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fuw = getVoiceManager();
        this.fuw.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.bau().iK(false);
        com.baidu.tieba.q.c.cni().b(getUniqueId(), false);
        if (this.fua != null && this.fua.getForum() != null) {
            com.baidu.tbadk.distribute.a.atL().a(getPageContext().getPageActivity(), "frs", this.fua.getForum().getId(), 0L);
        }
        this.fuw = getVoiceManager();
        if (this.fuw != null) {
            this.fuw.onStop(getPageContext());
        }
    }

    public void bmA() {
        if (this.fOe != null) {
            this.fOe.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rr(int i) {
        ArrayList<m> threadList = this.fua.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bg) {
                    bh bhVar = ((bg) next).caz;
                    if (bhVar.getId() != null && bhVar.getId().equals(this.fLF)) {
                        c(bhVar, i);
                        this.fLF = null;
                        break;
                    }
                }
            }
            this.fOe.bpw().b(threadList, this.fua);
            this.fOe.bpw().notifyDataSetChanged();
        }
    }

    private void c(bh bhVar, int i) {
        if (i == 1) {
            PraiseData aiq = bhVar.aiq();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aiq == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bhVar.a(praiseData);
                    return;
                }
                bhVar.aiq().getUser().add(0, metaData);
                bhVar.aiq().setNum(bhVar.aiq().getNum() + 1);
                bhVar.aiq().setIsLike(i);
            }
        } else if (bhVar.aiq() != null) {
            bhVar.aiq().setIsLike(i);
            bhVar.aiq().setNum(bhVar.aiq().getNum() - 1);
            ArrayList<MetaData> user = bhVar.aiq().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bhVar.aiq().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fuw == null) {
            this.fuw = VoiceManager.instance();
        }
        return this.fuw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aod() {
        if (this.fOe == null) {
            return null;
        }
        return this.fOe.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bki() {
        this.fuw = getVoiceManager();
        this.fuw.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> aoe() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aoe();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.fua != null && this.fOe != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fOe.bkQ();
            }
        }
    }

    private void boC() {
        HashMap<Integer, bh> bmW;
        if (this.fOe != null && this.fOe.bpw() != null && (bmW = this.fOe.bpw().bmW()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bh> entry : bmW.entrySet()) {
                bh value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.atR().z(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (aod() == null) {
            return null;
        }
        return aod().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            kv(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bkn() {
        return this.fua;
    }

    public FrsNewAreaModelController bpu() {
        return this.fOd;
    }

    public void wk(String str) {
        this.fup = str;
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

    public void aIU() {
        if (!this.fLI.isLoading && !this.fOd.isLoading()) {
            if (this.fLI.cv(this.fua.getThreadListIds())) {
                this.fOe.a(this.fLI.boX(), this.mPn, this.fua, 0);
                this.fLI.a(com.baidu.adp.lib.g.b.toLong(this.forumId, 0L), this.fua.getThreadListIds(), this.fup, this.mPn, this.fua.isBrandForum);
            } else if (this.euS != 0) {
                this.fOe.a(this.fLI.boX(), this.mPn, this.fua, 0);
                this.mPn++;
                this.fOd.rt(this.mPn);
                this.fLI.loadingDone = false;
                this.fLI.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.fOe.aKi();
        } else if (!this.fOe.bkY()) {
            if (!this.fOd.boM()) {
                this.fOe.aKi();
                return;
            }
            aJj();
            aIU();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        aJj();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void aa(ArrayList<m> arrayList) {
        ArrayList<m> a;
        aJj();
        if (arrayList != null && arrayList.size() != 0 && (a = this.fLI.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.fua.setThreadList(a);
            this.fOe.a(a, this.mPn, this.fua, 0);
        }
    }

    public void cw(List<String> list) {
        cl(list);
        int i = 0;
        Iterator<m> it = this.fua.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bg ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            aIU();
        }
    }

    private void cl(List<String> list) {
        if (!v.isEmpty(list)) {
            ArrayList<m> threadList = this.fua.getThreadList();
            if (!v.isEmpty(threadList) && this.fOe.getListView() != null && this.fOe.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.fOe.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    m next = it.next();
                    if (next instanceof bg) {
                        bh bhVar = ((bg) next).caz;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!aq.equals(list.get(i2), bhVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.fLI.d(next);
                                this.fOe.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel boB() {
        return this.fLI;
    }

    private void aJj() {
        if (this.euS == 0 && !this.fLI.cv(this.fua.getThreadListIds())) {
            if (this.fua.getThreadList() == null || this.fua.getThreadList().size() == 0) {
                this.fOe.aKi();
                return;
            } else {
                this.fOe.aKh();
                return;
            }
        }
        this.fOe.aKg();
    }

    public g bpv() {
        return this.fOe;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0055a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.checkCamera(getActivity().getApplicationContext())) {
                al.c(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
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
        com.baidu.tbadk.distribute.a.atL().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bkh() {
        if (this.fOd != null) {
            this.fOd.bkh();
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

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aKP() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.fup;
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjw() {
        if (this.fOe != null && this.fOe.getListView() != null) {
            this.fOe.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKf() {
        if (this.fOe != null) {
            bjw();
            this.fOe.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.fuV.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ln(int i) {
        return this.fuV.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }
}
