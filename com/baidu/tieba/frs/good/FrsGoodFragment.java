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
    private c fAl;
    private com.baidu.tieba.frs.gametab.b fMB;
    private String fMw;
    private FrsGoodModelController fMy;
    private FrsLoadMoreModel fMz;
    private VoiceManager fvn;
    private String mForumId;
    private String fvg = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean fMx = false;
    private String forumId = null;
    private FrsViewData fuR = new FrsViewData();
    public long fbN = -1;
    public long cLZ = 0;
    public long cMh = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fvz = false;
    protected a fMA = null;
    private int evJ = -1;
    private int mTabId = 0;
    private int fDb = 3;
    private boolean eVV = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fvM = new SparseArray<>();
    public boolean fMC = false;
    private boolean fMD = false;
    private CustomMessageListener fyo = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.fAl != null && FrsGoodFragment.this.fAl.isViewAttached()) {
                FrsGoodFragment.this.fAl.jZ(num.intValue());
            }
        }
    };
    private Runnable fME = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.eVV) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.kv(false);
            }
        }
    };
    private CustomMessageListener fMF = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                bh bhVar = (bh) customResponsedMessage.getData();
                FrsGoodFragment.this.fMw = bhVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.fMw) && bhVar.ais() != null) {
                    FrsGoodFragment.this.rs(bhVar.ais().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fws = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.aof() != null) {
                            FrsGoodFragment.this.aof().setSelection(0);
                        }
                        if (FrsGoodFragment.this.fAl != null && FrsGoodFragment.this.fAl.isViewAttached()) {
                            FrsGoodFragment.this.kv(false);
                        } else if (FrsGoodFragment.this.fMA != null) {
                            FrsGoodFragment.this.fMA.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                        }
                    }
                }
            }
        }
    };
    public final p fwI = new p() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        private long fMI = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void qq(int i) {
            if (!FrsGoodFragment.this.fMD) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.fMA.bkS();
                        return;
                    case 3:
                        FrsGoodFragment.this.fMA.fU(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.fMD) {
                if (FrsGoodFragment.this.boF().boM() == null) {
                    FrsGoodFragment.this.fMD = false;
                    return;
                } else if (FrsGoodFragment.this.boF().boM().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.fMD = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.fMI = 1L;
            } else if (bVar.isSuccess) {
                this.fMI = 0L;
            } else {
                this.fMI = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.fMz.resetData();
            }
            FrsGoodFragment.this.fMA.fU(false);
            if (FrsGoodFragment.this.boF().boM() != null) {
                FrsGoodFragment.this.fuR = FrsGoodFragment.this.boF().boM();
            }
            FrsGoodFragment.this.evJ = FrsGoodFragment.this.fuR.getPage().ahA();
            if (FrsGoodFragment.this.evJ == 0 && (FrsGoodFragment.this.fuR.getThreadListIds() == null || FrsGoodFragment.this.fuR.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.fuR.getThreadList() == null || FrsGoodFragment.this.fuR.getThreadList().size() == 0) {
                    FrsGoodFragment.this.fMA.aKk();
                } else {
                    FrsGoodFragment.this.fMA.aKj();
                }
            } else {
                FrsGoodFragment.this.fMA.aKi();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.fMz.a(false, false, false, FrsGoodFragment.this.fuR.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.fuR.setThreadList(a2);
                    FrsGoodFragment.this.fMA.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.fuR, FrsGoodFragment.this.evJ);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.fMA.bkS();
                    break;
                case 2:
                    FrsGoodFragment.this.fMA.bkS();
                    break;
                case 3:
                    if (FrsGoodFragment.this.fuR.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.fMI != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.fuR != null) {
                    FrsGoodFragment.this.fvg = FrsGoodFragment.this.fuR.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.fuR.getForum().getId();
                    FrsGoodFragment.this.fMA.b(FrsGoodFragment.this.fuR.getForum(), FrsGoodFragment.this.fuR.getUserData());
                }
                if (FrsGoodFragment.this.fuR != null) {
                    FrsGoodFragment.this.fuR.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.fMA.c(FrsGoodFragment.this.fuR);
                if (FrsGoodFragment.this.fuR == null || FrsGoodFragment.this.fuR.getThreadList() == null || FrsGoodFragment.this.fuR.getThreadList().size() != 0 || FrsGoodFragment.this.boF().getType() != 4) {
                    if (FrsGoodFragment.this.fuR != null && (a = FrsGoodFragment.this.fMz.a(false, false, true, FrsGoodFragment.this.fuR.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.fuR.setThreadList(a);
                    }
                    FrsGoodFragment.this.bkh();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.fbN > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.fbN, FrsGoodFragment.this.boF().beO() - FrsGoodFragment.this.fbN, FrsGoodFragment.this.boF().beM(), FrsGoodFragment.this.boF().beN(), currentTimeMillis2 - FrsGoodFragment.this.boF().beL());
                        FrsGoodFragment.this.fbN = -1L;
                    }
                    FrsGoodFragment.this.cMh = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.fbN > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.fbN, FrsGoodFragment.this.boF().beO() - FrsGoodFragment.this.fbN, FrsGoodFragment.this.boF().beM(), FrsGoodFragment.this.boF().beN(), currentTimeMillis3 - FrsGoodFragment.this.boF().beL());
                FrsGoodFragment.this.fbN = -1L;
            }
            FrsGoodFragment.this.cMh = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(l lVar) {
        }
    };
    private final CustomMessageListener bVR = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.fMA != null) {
                FrsGoodFragment.this.fMA.startPullRefresh();
            }
        }
    };
    private final h.c dCB = new h.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.isNetWorkAvailable()) {
                d.aDe().rg("page_frs_good");
                FrsGoodFragment.this.kv(true);
                return;
            }
            FrsGoodFragment.this.fMA.fU(false);
        }
    };
    private final h.b cpT = new h.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.h.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.cnk().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.fvz) {
                FrsGoodFragment.this.fvz = true;
                FrsGoodFragment.this.fMA.blg();
            }
            if (i == 0) {
                t.baw().iK(true);
                com.baidu.tieba.q.c.cnk().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener cwZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
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
    private s fwO = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bg)) {
                bh bhVar = ((bg) mVar).cbq;
                if (bhVar.ajy() == null || bhVar.ajy().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bhVar.ajq() != 1 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Ec(bhVar.getId())) {
                            readThreadHistory.Eb(bhVar.getId());
                            if (FrsGoodFragment.this.fMA != null) {
                                FrsGoodFragment.this.fMA.bkS();
                            }
                        }
                        boolean z = false;
                        final String aiN = bhVar.aiN();
                        if (aiN != null && !aiN.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aiN);
                                    xVar.amr().amR().mIsNeedAddCommenParam = false;
                                    xVar.amr().amR().mIsUseCurrentBDUSS = false;
                                    xVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bhVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bhVar.aiB() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.amQ().b(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bhVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bhVar, FrsGoodFragment.this.fvg, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.fMC ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.fuR != null && FrsGoodFragment.this.fuR.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fQB = FrsGoodFragment.this.fuR.needLog == 1;
                            bVar.fQD = FrsGoodFragment.this.fuR.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.fDZ != null) {
                                bVar.fQE = com.baidu.tieba.frs.d.d.fDZ.fQE;
                                bVar.fQF = com.baidu.tieba.frs.d.d.fDZ.fQF;
                            }
                            com.baidu.tieba.frs.d.a.a(bhVar, 1, FrsGoodFragment.this.getUniqueId(), bVar);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fwS = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.fMA != null) {
                FrsGoodFragment.this.fMA.pC();
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
        this.fMA.kf(false);
        showLoadingView(this.fMA.aYd(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fMA.kf(true);
        hideLoadingView(this.fMA.aYd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fMA.kf(false);
        this.fMA.bme().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.fMA.aKk();
        this.fMA.getListView().getData().clear();
        this.fMA.bkS();
        if (this.fAl == null) {
            this.fAl = new c(getPageContext().getContext(), getNetRefreshListener());
            this.fAl.setTitle(null);
            this.fAl.setButtonText(null);
            this.fAl.showRefreshButton();
            this.fAl.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.fAl.setSubText(getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.fAl.setSubText(null);
        }
        this.fAl.onChangeSkinType();
        this.fAl.attachView(this.fMA.aYd(), true);
        registerListener(this.fyo);
    }

    private void aJo() {
        this.fMA.kf(true);
        this.fMA.bme().setEnabled(true);
        if (this.fAl != null && this.fAl.isViewAttached()) {
            this.fAl.dettachView(this.fMA.aYd());
        }
        MessageManager.getInstance().unRegisterListener(this.fyo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kv(boolean z) {
        this.eVV = true;
        bkk();
        aJo();
        if (!z) {
            aJo();
            showLoadingView();
        }
        this.fMy.mg(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fbN = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.fbN = System.currentTimeMillis();
        }
        this.mForumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.cLZ = this.beginTime - this.fbN;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cnk().v(getUniqueId());
        this.fMy = new FrsGoodModelController(this);
        if (arguments != null) {
            this.fMy.K(arguments);
            this.fMx = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.fMy.K(bundle);
            this.fMx = bundle.getBoolean("is_game_frs", false);
        } else {
            this.fMy.K(null);
        }
        this.fvn = getVoiceManager();
        this.fvn.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bVR);
        registerListener(this.fMF);
        registerListener(this.fws);
        registerListener(this.fwS);
        this.fMz = new FrsLoadMoreModel(this, null);
        this.fMz.registerListener();
        this.fMz.setPageType(2);
        this.fMz.ky(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fMA = new a(this, inflate, this.fMx);
        this.fMA.boJ().kx(this.fMC);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eVV) {
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
        this.fvn = getVoiceManager();
        this.fvn.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        boC();
        if (bundle != null) {
            this.fvg = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fMC = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.fvg = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.fMC = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void boC() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cwZ);
    }

    public FrsLoadMoreModel boD() {
        return this.fMz;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fMA != null) {
            this.fMA.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fyo);
        com.baidu.tieba.q.c.cnk().w(getUniqueId());
        t.baw().iK(false);
        super.onDestroy();
        this.fMy.aGH();
        this.fvn = getVoiceManager();
        this.fvn.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fME);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.fvg);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.fMx);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fMC);
        this.fMy.onSaveInstanceState(bundle);
        this.fvn = getVoiceManager();
        if (this.fvn != null) {
            this.fvn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bh threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.fMA.boJ().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.fuR.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.hL(intent.getIntExtra("good_data", 0));
                            threadDataById.ajw();
                            kv(false);
                            return;
                        } else if (intExtra == 0) {
                            this.fuR.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.fuR.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.m());
                            }
                            this.fMA.boH();
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
            if (this.fDb == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.eVV) {
                com.baidu.adp.lib.g.e.fZ().post(this.fME);
            }
        }
        blU();
    }

    private void blU() {
        if (isPrimary()) {
            if (this.fAl != null && this.fAl.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fyo);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fyo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fMA != null) {
            this.fMA.bkS();
        }
        this.fvn = getVoiceManager();
        this.fvn.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fMB = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.fMA.a(this.fwO);
        this.fMA.setOnScrollListener(this.mScrollListener);
        this.fMA.setListPullRefreshListener(this.dCB);
        this.fMA.a(this.cpT);
        this.fMA.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.fMB != null) {
                    FrsGoodFragment.this.fMB.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fDb != 3 || this.fMA != null) {
            this.fDb = i;
            super.onChangeSkinType(i);
            if (this.fMA != null) {
                this.fMA.onChangeSkinType(i);
            }
            if (this.fAl != null && this.fAl.isViewAttached()) {
                this.fAl.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bjk() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bjk();
        }
        return null;
    }

    private void bkg() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.ga().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.DW(FrsGoodFragment.this.fvg);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkh() {
        bkk();
        try {
            if (this.fuR != null) {
                this.fMA.aMq();
                this.fvg = this.fuR.getForum().getName();
                this.forumId = this.fuR.getForum().getId();
                if (this.fuR != null && this.fuR.getForum() != null) {
                    this.fMA.a(this.fuR.getForum().getThemeColorInfo());
                    this.fMA.c(this.fuR);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.fuR.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fuR.getUserData().getBimg_end_time());
                bkg();
                if (!this.fMA.boJ().o(bh.cbJ)) {
                    this.fuR.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.fuR.getThreadList();
                if (threadList != null) {
                    this.fMA.a(threadList, this.mPn, this.fuR, this.fuR.getPage().ahA());
                    boE();
                    this.fMA.boH();
                    if (this.fuR.getIsNewUrl() == 1) {
                        this.fMA.boJ().setFromCDN(true);
                    } else {
                        this.fMA.boJ().setFromCDN(false);
                    }
                    this.fMA.setListViewSelection(by(boF().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int by(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fvn = getVoiceManager();
        this.fvn.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.baw().iK(false);
        com.baidu.tieba.q.c.cnk().b(getUniqueId(), false);
        if (this.fuR != null && this.fuR.getForum() != null) {
            com.baidu.tbadk.distribute.a.atN().a(getPageContext().getPageActivity(), "frs", this.fuR.getForum().getId(), 0L);
        }
        this.fvn = getVoiceManager();
        if (this.fvn != null) {
            this.fvn.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs(int i) {
        ArrayList<m> threadList = this.fuR.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bg) {
                    bh bhVar = ((bg) next).cbq;
                    if (bhVar.getId() != null && bhVar.getId().equals(this.fMw)) {
                        c(bhVar, i);
                        this.fMw = null;
                        break;
                    }
                }
            }
            this.fMA.boJ().b(threadList, this.fuR);
            this.fMA.boJ().notifyDataSetChanged();
        }
    }

    private void c(bh bhVar, int i) {
        if (i == 1) {
            PraiseData ais = bhVar.ais();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (ais == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bhVar.a(praiseData);
                    return;
                }
                bhVar.ais().getUser().add(0, metaData);
                bhVar.ais().setNum(bhVar.ais().getNum() + 1);
                bhVar.ais().setIsLike(i);
            }
        } else if (bhVar.ais() != null) {
            bhVar.ais().setIsLike(i);
            bhVar.ais().setNum(bhVar.ais().getNum() - 1);
            ArrayList<MetaData> user = bhVar.ais().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bhVar.ais().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fvn == null) {
            this.fvn = VoiceManager.instance();
        }
        return this.fvn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aof() {
        if (this.fMA == null) {
            return null;
        }
        return this.fMA.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bkk() {
        this.fvn = getVoiceManager();
        this.fvn.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> aog() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aog();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.fuR != null && this.fMA != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fMA.bkS();
            }
        }
    }

    private void boE() {
        HashMap<Integer, bh> bmY;
        if (this.fMA != null && this.fMA.boJ() != null && (bmY = this.fMA.boJ().bmY()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bh> entry : bmY.entrySet()) {
                bh value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.atT().z(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (aof() == null) {
            return null;
        }
        return aof().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            kv(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bkp() {
        return this.fuR;
    }

    public FrsGoodModelController boF() {
        return this.fMy;
    }

    public void wk(String str) {
        this.fvg = str;
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
            this.fMA.aKk();
        } else if (!this.fMy.boO()) {
            this.fMA.aKk();
        } else {
            aJl();
            if (!this.fMz.isLoading && !this.fMy.isLoading()) {
                if (this.fMz.cv(this.fuR.getThreadListIds())) {
                    this.fMA.a(this.fMz.boZ(), this.mPn, this.fuR, 0);
                    this.fMz.a(com.baidu.adp.lib.g.b.toLong(this.forumId, 0L), this.fuR.getThreadListIds(), this.fvg, this.mPn, this.fuR.isBrandForum);
                } else if (this.evJ != 0) {
                    this.fMA.a(this.fMz.boZ(), this.mPn, this.fuR, 0);
                    this.mPn++;
                    this.fMy.ru(this.mPn);
                    this.fMz.loadingDone = false;
                    this.fMz.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        aJl();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void aa(ArrayList<m> arrayList) {
        ArrayList<m> a;
        aJl();
        if (arrayList != null && arrayList.size() != 0 && (a = this.fMz.a(false, false, false, arrayList, (f) null)) != null) {
            this.fuR.setThreadList(a);
            this.fMA.a(a, this.mPn, this.fuR, 0);
        }
    }

    private void aJl() {
        if (this.evJ == 0 && !this.fMz.cv(this.fuR.getThreadListIds())) {
            if (this.fuR.getThreadList() == null || this.fuR.getThreadList().size() == 0) {
                this.fMA.aKk();
                return;
            } else {
                this.fMA.aKj();
                return;
            }
        }
        this.fMA.aKi();
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
        com.baidu.tbadk.distribute.a.atN().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bkj() {
        if (this.fMy != null) {
            this.fMy.bkj();
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
    public NavigationBar aKR() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.fvg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rt(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            kv(false);
        } else {
            c((e.b) null);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjy() {
        if (this.fMA != null && this.fMA.getListView() != null) {
            this.fMA.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKh() {
        if (this.fMA != null) {
            bjy();
            this.fMA.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.fvM.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a lo(int i) {
        return this.fvM.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }
}
