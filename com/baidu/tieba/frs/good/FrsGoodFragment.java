package com.baidu.tieba.frs.good;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.e.a.a;
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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.m.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a.d;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.data.f;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0055a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ag, ah, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String fLF;
    private FrsGoodModelController fLH;
    private FrsLoadMoreModel fLI;
    private com.baidu.tieba.frs.gametab.b fLK;
    private VoiceManager fuw;
    private c fzu;
    private String mForumId;
    private String fup = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean fLG = false;
    private String forumId = null;
    private FrsViewData fua = new FrsViewData();
    public long faW = -1;
    public long cLi = 0;
    public long cLq = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fuI = false;
    protected a fLJ = null;
    private int euS = -1;
    private int mTabId = 0;
    private int fCk = 3;
    private boolean eVe = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fuV = new SparseArray<>();
    public boolean fLL = false;
    private boolean fLM = false;
    private CustomMessageListener fxx = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.fzu != null && FrsGoodFragment.this.fzu.isViewAttached()) {
                FrsGoodFragment.this.fzu.jY(num.intValue());
            }
        }
    };
    private Runnable fLN = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.eVe) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.kv(false);
            }
        }
    };
    private CustomMessageListener fLO = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                bh bhVar = (bh) customResponsedMessage.getData();
                FrsGoodFragment.this.fLF = bhVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.fLF) && bhVar.aiq() != null) {
                    FrsGoodFragment.this.rr(bhVar.aiq().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fvB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.aod() != null) {
                            FrsGoodFragment.this.aod().setSelection(0);
                        }
                        if (FrsGoodFragment.this.fzu != null && FrsGoodFragment.this.fzu.isViewAttached()) {
                            FrsGoodFragment.this.kv(false);
                        } else if (FrsGoodFragment.this.fLJ != null) {
                            FrsGoodFragment.this.fLJ.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                        }
                    }
                }
            }
        }
    };
    public final p fvR = new p() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        private long fLR = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void qp(int i) {
            if (!FrsGoodFragment.this.fLM) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.fLJ.bkQ();
                        return;
                    case 3:
                        FrsGoodFragment.this.fLJ.fU(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.fLM) {
                if (FrsGoodFragment.this.boD().boK() == null) {
                    FrsGoodFragment.this.fLM = false;
                    return;
                } else if (FrsGoodFragment.this.boD().boK().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.fLM = false;
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
                FrsGoodFragment.this.fLI.resetData();
            }
            FrsGoodFragment.this.fLJ.fU(false);
            if (FrsGoodFragment.this.boD().boK() != null) {
                FrsGoodFragment.this.fua = FrsGoodFragment.this.boD().boK();
            }
            FrsGoodFragment.this.euS = FrsGoodFragment.this.fua.getPage().ahy();
            if (FrsGoodFragment.this.euS == 0 && (FrsGoodFragment.this.fua.getThreadListIds() == null || FrsGoodFragment.this.fua.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.fua.getThreadList() == null || FrsGoodFragment.this.fua.getThreadList().size() == 0) {
                    FrsGoodFragment.this.fLJ.aKi();
                } else {
                    FrsGoodFragment.this.fLJ.aKh();
                }
            } else {
                FrsGoodFragment.this.fLJ.aKg();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.fLI.a(false, false, false, FrsGoodFragment.this.fua.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.fua.setThreadList(a2);
                    FrsGoodFragment.this.fLJ.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.fua, FrsGoodFragment.this.euS);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.fLJ.bkQ();
                    break;
                case 2:
                    FrsGoodFragment.this.fLJ.bkQ();
                    break;
                case 3:
                    if (FrsGoodFragment.this.fua.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.fLR != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.fua != null) {
                    FrsGoodFragment.this.fup = FrsGoodFragment.this.fua.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.fua.getForum().getId();
                    FrsGoodFragment.this.fLJ.b(FrsGoodFragment.this.fua.getForum(), FrsGoodFragment.this.fua.getUserData());
                }
                if (FrsGoodFragment.this.fua != null) {
                    FrsGoodFragment.this.fua.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.fLJ.c(FrsGoodFragment.this.fua);
                if (FrsGoodFragment.this.fua == null || FrsGoodFragment.this.fua.getThreadList() == null || FrsGoodFragment.this.fua.getThreadList().size() != 0 || FrsGoodFragment.this.boD().getType() != 4) {
                    if (FrsGoodFragment.this.fua != null && (a = FrsGoodFragment.this.fLI.a(false, false, true, FrsGoodFragment.this.fua.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.fua.setThreadList(a);
                    }
                    FrsGoodFragment.this.bkf();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.faW > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.faW, FrsGoodFragment.this.boD().beM() - FrsGoodFragment.this.faW, FrsGoodFragment.this.boD().beK(), FrsGoodFragment.this.boD().beL(), currentTimeMillis2 - FrsGoodFragment.this.boD().beJ());
                        FrsGoodFragment.this.faW = -1L;
                    }
                    FrsGoodFragment.this.cLq = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.faW > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.faW, FrsGoodFragment.this.boD().beM() - FrsGoodFragment.this.faW, FrsGoodFragment.this.boD().beK(), FrsGoodFragment.this.boD().beL(), currentTimeMillis3 - FrsGoodFragment.this.boD().beJ());
                FrsGoodFragment.this.faW = -1L;
            }
            FrsGoodFragment.this.cLq = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(l lVar) {
        }
    };
    private final CustomMessageListener bVa = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.fLJ != null) {
                FrsGoodFragment.this.fLJ.startPullRefresh();
            }
        }
    };
    private final h.c dBK = new h.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.isNetWorkAvailable()) {
                d.aDc().rg("page_frs_good");
                FrsGoodFragment.this.kv(true);
                return;
            }
            FrsGoodFragment.this.fLJ.fU(false);
        }
    };
    private final h.b cpb = new h.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.h.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.cni().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.fuI) {
                FrsGoodFragment.this.fuI = true;
                FrsGoodFragment.this.fLJ.ble();
            }
            if (i == 0) {
                t.bau().iK(true);
                com.baidu.tieba.q.c.cni().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener cwi = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                FrsGoodFragment.this.f(customResponsedMessage);
            }
        }
    };
    private s fvX = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bg)) {
                bh bhVar = ((bg) mVar).caz;
                if (bhVar.ajw() == null || bhVar.ajw().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bhVar.ajo() != 1 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Ec(bhVar.getId())) {
                            readThreadHistory.Eb(bhVar.getId());
                            if (FrsGoodFragment.this.fLJ != null) {
                                FrsGoodFragment.this.fLJ.bkQ();
                            }
                        }
                        boolean z = false;
                        final String aiL = bhVar.aiL();
                        if (aiL != null && !aiL.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6.1
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
                            ba.amO().b(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bhVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bhVar, FrsGoodFragment.this.fup, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.fLL ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.fua != null && FrsGoodFragment.this.fua.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fPK = FrsGoodFragment.this.fua.needLog == 1;
                            bVar.fPM = FrsGoodFragment.this.fua.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.fDi != null) {
                                bVar.fPN = com.baidu.tieba.frs.d.d.fDi.fPN;
                                bVar.fPO = com.baidu.tieba.frs.d.d.fDi.fPO;
                            }
                            com.baidu.tieba.frs.d.a.a(bhVar, 1, FrsGoodFragment.this.getUniqueId(), bVar);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fwb = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.fLJ != null) {
                FrsGoodFragment.this.fLJ.pC();
            }
        }
    };

    static /* synthetic */ int j(FrsGoodFragment frsGoodFragment) {
        int i = frsGoodFragment.mPn;
        frsGoodFragment.mPn = i - 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    private void showLoadingView() {
        this.fLJ.kf(false);
        showLoadingView(this.fLJ.aYb(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fLJ.kf(true);
        hideLoadingView(this.fLJ.aYb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fLJ.kf(false);
        this.fLJ.bmc().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.fLJ.aKi();
        this.fLJ.getListView().getData().clear();
        this.fLJ.bkQ();
        if (this.fzu == null) {
            this.fzu = new c(getPageContext().getContext(), getNetRefreshListener());
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
        this.fzu.attachView(this.fLJ.aYb(), true);
        registerListener(this.fxx);
    }

    private void aJm() {
        this.fLJ.kf(true);
        this.fLJ.bmc().setEnabled(true);
        if (this.fzu != null && this.fzu.isViewAttached()) {
            this.fzu.dettachView(this.fLJ.aYb());
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
        this.fLH.mf(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.faW = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.faW = System.currentTimeMillis();
        }
        this.mForumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.cLi = this.beginTime - this.faW;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cni().v(getUniqueId());
        this.fLH = new FrsGoodModelController(this);
        if (arguments != null) {
            this.fLH.K(arguments);
            this.fLG = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.fLH.K(bundle);
            this.fLG = bundle.getBoolean("is_game_frs", false);
        } else {
            this.fLH.K(null);
        }
        this.fuw = getVoiceManager();
        this.fuw.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bVa);
        registerListener(this.fLO);
        registerListener(this.fvB);
        registerListener(this.fwb);
        this.fLI = new FrsLoadMoreModel(this, null);
        this.fLI.registerListener();
        this.fLI.setPageType(2);
        this.fLI.ky(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fLJ = new a(this, inflate, this.fLG);
        this.fLJ.boH().kx(this.fLL);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eVe) {
            if (j.isNetWorkAvailable()) {
                kv(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").bS("fid", this.mForumId).bS("obj_type", "7").O("obj_locate", 2).bS("uid", TbadkCoreApplication.getCurrentAccount()));
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
            this.fLL = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.fup = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.fLL = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void boA() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cwi);
    }

    public FrsLoadMoreModel boB() {
        return this.fLI;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fLJ != null) {
            this.fLJ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fxx);
        com.baidu.tieba.q.c.cni().w(getUniqueId());
        t.bau().iK(false);
        super.onDestroy();
        this.fLH.aGF();
        this.fuw = getVoiceManager();
        this.fuw.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fLN);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.fup);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.fLG);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fLL);
        this.fLH.onSaveInstanceState(bundle);
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
                    this.fLJ.boH().notifyDataSetChanged();
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
                            this.fLJ.boF();
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
        if (this.fLJ != null) {
            this.fLJ.bkQ();
        }
        this.fuw = getVoiceManager();
        this.fuw.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fLK = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.fLJ.a(this.fvX);
        this.fLJ.setOnScrollListener(this.mScrollListener);
        this.fLJ.setListPullRefreshListener(this.dBK);
        this.fLJ.a(this.cpb);
        this.fLJ.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.fLK != null) {
                    FrsGoodFragment.this.fLK.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fCk != 3 || this.fLJ != null) {
            this.fCk = i;
            super.onChangeSkinType(i);
            if (this.fLJ != null) {
                this.fLJ.onChangeSkinType(i);
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
                com.baidu.adp.lib.g.h.ga().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.DW(FrsGoodFragment.this.fup);
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
                this.fLJ.aMo();
                this.fup = this.fua.getForum().getName();
                this.forumId = this.fua.getForum().getId();
                if (this.fua != null && this.fua.getForum() != null) {
                    this.fLJ.a(this.fua.getForum().getThemeColorInfo());
                    this.fLJ.c(this.fua);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.fua.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fua.getUserData().getBimg_end_time());
                bke();
                if (!this.fLJ.boH().o(bh.caS)) {
                    this.fua.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.fua.getThreadList();
                if (threadList != null) {
                    this.fLJ.a(threadList, this.mPn, this.fua, this.fua.getPage().ahy());
                    boC();
                    this.fLJ.boF();
                    if (this.fua.getIsNewUrl() == 1) {
                        this.fLJ.boH().setFromCDN(true);
                    } else {
                        this.fLJ.boH().setFromCDN(false);
                    }
                    this.fLJ.setListViewSelection(bw(boD().getType(), this.mPn));
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
            this.fLJ.boH().b(threadList, this.fua);
            this.fLJ.boH().notifyDataSetChanged();
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
        if (this.fLJ == null) {
            return null;
        }
        return this.fLJ.getListView();
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
        if (this.fua != null && this.fLJ != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fLJ.bkQ();
            }
        }
    }

    private void boC() {
        HashMap<Integer, bh> bmW;
        if (this.fLJ != null && this.fLJ.boH() != null && (bmW = this.fLJ.boH().bmW()) != null) {
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
        if (j.isNetWorkAvailable()) {
            kv(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bkn() {
        return this.fua;
    }

    public FrsGoodModelController boD() {
        return this.fLH;
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

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.fLJ.aKi();
        } else if (!this.fLH.boM()) {
            this.fLJ.aKi();
        } else {
            aJj();
            if (!this.fLI.isLoading && !this.fLH.isLoading()) {
                if (this.fLI.cv(this.fua.getThreadListIds())) {
                    this.fLJ.a(this.fLI.boX(), this.mPn, this.fua, 0);
                    this.fLI.a(com.baidu.adp.lib.g.b.toLong(this.forumId, 0L), this.fua.getThreadListIds(), this.fup, this.mPn, this.fua.isBrandForum);
                } else if (this.euS != 0) {
                    this.fLJ.a(this.fLI.boX(), this.mPn, this.fua, 0);
                    this.mPn++;
                    this.fLH.rt(this.mPn);
                    this.fLI.loadingDone = false;
                    this.fLI.loadIndex = 0;
                }
            }
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.fLI.a(false, false, false, arrayList, (f) null)) != null) {
            this.fua.setThreadList(a);
            this.fLJ.a(a, this.mPn, this.fua, 0);
        }
    }

    private void aJj() {
        if (this.euS == 0 && !this.fLI.cv(this.fua.getThreadListIds())) {
            if (this.fua.getThreadList() == null || this.fua.getThreadList().size() == 0) {
                this.fLJ.aKi();
                return;
            } else {
                this.fLJ.aKh();
                return;
            }
        }
        this.fLJ.aKg();
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
        if (this.fLH != null) {
            this.fLH.bkh();
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void rs(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            kv(false);
        } else {
            c((e.b) null);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjw() {
        if (this.fLJ != null && this.fLJ.getListView() != null) {
            this.fLJ.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKf() {
        if (this.fLJ != null) {
            bjw();
            this.fLJ.startPullRefresh();
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
