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
    private com.baidu.tbadk.m.c fAl;
    private String fMw;
    private FrsLoadMoreModel fMz;
    private FrsNewAreaModelController fOU;
    private VoiceManager fvn;
    private String fvg = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData fuR = new FrsViewData();
    public long fbN = -1;
    public long cLZ = 0;
    public long cMh = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean fvz = false;
    protected g fOV = null;
    private int evJ = -1;
    private int fDb = 3;
    private boolean eVV = false;
    public boolean fMC = false;
    private boolean fMD = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fvM = new SparseArray<>();
    private CustomMessageListener fyo = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.fAl != null && FrsNewAreaFragment.this.fAl.isViewAttached()) {
                FrsNewAreaFragment.this.fAl.jZ(num.intValue());
            }
        }
    };
    private Runnable fME = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.eVV) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.kv(false);
            }
        }
    };
    private CustomMessageListener fMF = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                bh bhVar = (bh) customResponsedMessage.getData();
                FrsNewAreaFragment.this.fMw = bhVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.fMw) && bhVar.ais() != null) {
                    FrsNewAreaFragment.this.rs(bhVar.ais().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener fws = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.aof() != null) {
                        FrsNewAreaFragment.this.aof().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.fAl != null && FrsNewAreaFragment.this.fAl.isViewAttached()) {
                        FrsNewAreaFragment.this.kv(false);
                    } else if (FrsNewAreaFragment.this.fOV != null) {
                        FrsNewAreaFragment.this.fOV.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final p fwI = new p() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long fMI = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void qq(int i) {
            if (!FrsNewAreaFragment.this.fMD) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.fOV.bkS();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.fOV.fU(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.fMD) {
                if (FrsNewAreaFragment.this.bpw().boM() == null) {
                    FrsNewAreaFragment.this.fMD = false;
                    return;
                } else if (FrsNewAreaFragment.this.bpw().boM().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.fMD = false;
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
                FrsNewAreaFragment.this.fMz.resetData();
            }
            FrsNewAreaFragment.this.fOV.fU(false);
            if (FrsNewAreaFragment.this.bpw().boM() != null) {
                FrsNewAreaFragment.this.fuR = FrsNewAreaFragment.this.bpw().boM();
            }
            FrsNewAreaFragment.this.evJ = FrsNewAreaFragment.this.fuR.getPage().ahA();
            if (FrsNewAreaFragment.this.evJ == 0 && (FrsNewAreaFragment.this.fuR.getThreadListIds() == null || FrsNewAreaFragment.this.fuR.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.fuR.getThreadList() == null || FrsNewAreaFragment.this.fuR.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.fOV.aKk();
                } else {
                    FrsNewAreaFragment.this.fOV.aKj();
                }
            } else {
                FrsNewAreaFragment.this.fOV.aKi();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.fMz.a(false, false, false, FrsNewAreaFragment.this.fuR.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.fuR.setThreadList(a2);
                    FrsNewAreaFragment.this.fOV.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.fuR, FrsNewAreaFragment.this.evJ);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.fOV.bkS();
                    break;
                case 2:
                    FrsNewAreaFragment.this.fOV.bkS();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.fuR.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.fMI != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.fuR != null) {
                    FrsNewAreaFragment.this.fvg = FrsNewAreaFragment.this.fuR.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.fuR.getForum().getId();
                    FrsNewAreaFragment.this.fOV.b(FrsNewAreaFragment.this.fuR.getForum(), FrsNewAreaFragment.this.fuR.getUserData());
                }
                if (FrsNewAreaFragment.this.fuR != null) {
                    FrsNewAreaFragment.this.fuR.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.fuR == null || FrsNewAreaFragment.this.fuR.getThreadList() == null || FrsNewAreaFragment.this.fuR.getThreadList().size() != 0 || FrsNewAreaFragment.this.bpw().getType() != 4) {
                    if (FrsNewAreaFragment.this.fuR != null && (a = FrsNewAreaFragment.this.fMz.a(false, false, true, FrsNewAreaFragment.this.fuR.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.fuR.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bkh();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.fbN > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.fbN, FrsNewAreaFragment.this.bpw().beO() - FrsNewAreaFragment.this.fbN, FrsNewAreaFragment.this.bpw().beM(), FrsNewAreaFragment.this.bpw().beN(), currentTimeMillis2 - FrsNewAreaFragment.this.bpw().beL());
                        FrsNewAreaFragment.this.fbN = -1L;
                    }
                    FrsNewAreaFragment.this.cMh = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.fbN > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.fbN, FrsNewAreaFragment.this.bpw().beO() - FrsNewAreaFragment.this.fbN, FrsNewAreaFragment.this.bpw().beM(), FrsNewAreaFragment.this.bpw().beN(), currentTimeMillis3 - FrsNewAreaFragment.this.bpw().beL());
                FrsNewAreaFragment.this.fbN = -1L;
            }
            FrsNewAreaFragment.this.cMh = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
        }
    };
    private final CustomMessageListener bVR = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.fOV != null) {
                FrsNewAreaFragment.this.fOV.startPullRefresh();
            }
        }
    };
    private final h.c dCB = new h.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.tieba.a.d.aDe().rg("page_frs_good");
                FrsNewAreaFragment.this.kv(true);
                return;
            }
            FrsNewAreaFragment.this.fOV.fU(false);
        }
    };
    private final h.b cpT = new h.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.h.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.q.c.cnk().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.fvz) {
                FrsNewAreaFragment.this.fvz = true;
                FrsNewAreaFragment.this.fOV.blg();
            }
            if (i == 0) {
                t.baw().iK(true);
                com.baidu.tieba.q.c.cnk().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener cwZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
    private s fwO = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bg)) {
                bh bhVar = ((bg) mVar).cbq;
                if (bhVar.ajy() == null || bhVar.ajy().getGroup_id() == 0 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bhVar.ajq() != 1 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Ec(bhVar.getId())) {
                            readThreadHistory.Eb(bhVar.getId());
                            if (FrsNewAreaFragment.this.fOV != null) {
                                FrsNewAreaFragment.this.fOV.bkS();
                            }
                        }
                        boolean z = false;
                        final String aiN = bhVar.aiN();
                        if (aiN != null && !aiN.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5.1
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
                            ba.amQ().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bhVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bhVar, FrsNewAreaFragment.this.fvg, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bhVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsNewAreaFragment.this.fMC ? 15 : 3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.fuR != null && FrsNewAreaFragment.this.fuR.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.fQB = FrsNewAreaFragment.this.fuR.needLog == 1;
                            bVar.fQD = FrsNewAreaFragment.this.fuR.getForum().getId();
                            bVar.fQC = FrsNewAreaFragment.this.fOU.bpp();
                            if (com.baidu.tieba.frs.d.d.fDZ != null) {
                                bVar.fQE = com.baidu.tieba.frs.d.d.fDZ.fQE;
                                bVar.fQF = com.baidu.tieba.frs.d.d.fDZ.fQF;
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
            this.fOU.ac(bhVar);
            this.fOV.bjy();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.fuR = frsViewData;
            hideLoadingView(this.fOV.aYd());
            if (this.fOV != null) {
                this.fOV.fU(false);
                this.fOV.a(null, this.mPn, this.fuR, this.evJ);
            }
        }
    }

    private void showLoadingView() {
        this.fOV.kf(false);
        showLoadingView(this.fOV.aYd(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fOV.kf(true);
        hideLoadingView(this.fOV.aYd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.fOV.kf(false);
        this.fOV.bme().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.fOV.aKk();
        this.fOV.getListView().getData().clear();
        this.fOV.bkS();
        if (this.fAl == null) {
            this.fAl = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
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
        this.fAl.attachView(this.fOV.aYd(), true);
        registerListener(this.fyo);
    }

    private void aJo() {
        this.fOV.kf(true);
        this.fOV.bme().setEnabled(true);
        if (this.fAl != null && this.fAl.isViewAttached()) {
            this.fAl.dettachView(this.fOV.aYd());
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
        this.fOU.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fbN = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.fbN = System.currentTimeMillis();
        }
        this.forumId = arguments.getString("forum_id", "");
        this.beginTime = System.currentTimeMillis();
        this.cLZ = this.beginTime - this.fbN;
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cnk().v(getUniqueId());
        this.fOU = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.fOU.K(arguments);
        } else if (bundle != null) {
            this.fOU.K(bundle);
        } else {
            this.fOU.K(null);
        }
        this.fvn = getVoiceManager();
        this.fvn.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.bVR);
        registerListener(this.fMF);
        registerListener(this.fws);
        this.fMz = new FrsLoadMoreModel(this, null);
        this.fMz.registerListener();
        this.fMz.setPageType(3);
        this.fMz.ky(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.fOV = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.eVV) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                kv(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        amK();
    }

    private void amK() {
        an anVar = new an("c13008");
        anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bS("fid", this.forumId);
        anVar.O("obj_type", 6);
        anVar.O("obj_locate", 2);
        anVar.amK();
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
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.fvg = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void boC() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cwZ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.fOV != null) {
            this.fOV.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fyo);
        com.baidu.tieba.q.c.cnk().w(getUniqueId());
        t.baw().iK(false);
        super.onDestroy();
        this.fOU.aGH();
        this.fvn = getVoiceManager();
        this.fvn.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fME);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.fvg);
        bundle.putString("from", this.mFrom);
        this.fOU.onSaveInstanceState(bundle);
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
                    this.fOV.bpy().notifyDataSetChanged();
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
                            this.fOV.boH();
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
        if (this.fOV != null) {
            this.fOV.bkS();
        }
        this.fvn = getVoiceManager();
        this.fvn.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.fOV.a(this.fwO);
        this.fOV.setOnScrollListener(this.mScrollListener);
        this.fOV.setListPullRefreshListener(this.dCB);
        this.fOV.a(this.cpT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fDb != 3 || this.fOV != null) {
            this.fDb = i;
            super.onChangeSkinType(i);
            if (this.fOV != null) {
                this.fOV.onChangeSkinType(i);
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
                com.baidu.adp.lib.g.h.ga().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.DW(FrsNewAreaFragment.this.fvg);
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
                this.fOV.aMq();
                this.fvg = this.fuR.getForum().getName();
                this.forumId = this.fuR.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.fuR.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fuR.getUserData().getBimg_end_time());
                bkg();
                ArrayList<m> threadList = this.fuR.getThreadList();
                if (threadList != null) {
                    this.fOV.a(threadList, this.mPn, this.fuR, this.fuR.getPage().ahA());
                    boE();
                    this.fOV.boH();
                    if (this.fuR.getIsNewUrl() == 1) {
                        this.fOV.bpy().setFromCDN(true);
                    } else {
                        this.fOV.bpy().setFromCDN(false);
                    }
                    this.fOV.setListViewSelection(by(bpw().getType(), this.mPn));
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

    public void bmC() {
        if (this.fOV != null) {
            this.fOV.refreshView();
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
            this.fOV.bpy().b(threadList, this.fuR);
            this.fOV.bpy().notifyDataSetChanged();
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
        if (this.fOV == null) {
            return null;
        }
        return this.fOV.getListView();
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
        if (this.fuR != null && this.fOV != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.fOV.bkS();
            }
        }
    }

    private void boE() {
        HashMap<Integer, bh> bmY;
        if (this.fOV != null && this.fOV.bpy() != null && (bmY = this.fOV.bpy().bmY()) != null) {
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
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            kv(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bkp() {
        return this.fuR;
    }

    public FrsNewAreaModelController bpw() {
        return this.fOU;
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

    public void aIW() {
        if (!this.fMz.isLoading && !this.fOU.isLoading()) {
            if (this.fMz.cv(this.fuR.getThreadListIds())) {
                this.fOV.a(this.fMz.boZ(), this.mPn, this.fuR, 0);
                this.fMz.a(com.baidu.adp.lib.g.b.toLong(this.forumId, 0L), this.fuR.getThreadListIds(), this.fvg, this.mPn, this.fuR.isBrandForum);
            } else if (this.evJ != 0) {
                this.fOV.a(this.fMz.boZ(), this.mPn, this.fuR, 0);
                this.mPn++;
                this.fOU.ru(this.mPn);
                this.fMz.loadingDone = false;
                this.fMz.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.fOV.aKk();
        } else if (!this.fOV.bla()) {
            if (!this.fOU.boO()) {
                this.fOV.aKk();
                return;
            }
            aJl();
            aIW();
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.fMz.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.fuR.setThreadList(a);
            this.fOV.a(a, this.mPn, this.fuR, 0);
        }
    }

    public void cw(List<String> list) {
        cl(list);
        int i = 0;
        Iterator<m> it = this.fuR.getThreadList().iterator();
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
            aIW();
        }
    }

    private void cl(List<String> list) {
        if (!v.isEmpty(list)) {
            ArrayList<m> threadList = this.fuR.getThreadList();
            if (!v.isEmpty(threadList) && this.fOV.getListView() != null && this.fOV.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.fOV.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    m next = it.next();
                    if (next instanceof bg) {
                        bh bhVar = ((bg) next).cbq;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!aq.equals(list.get(i2), bhVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.fMz.d(next);
                                this.fOV.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel boD() {
        return this.fMz;
    }

    private void aJl() {
        if (this.evJ == 0 && !this.fMz.cv(this.fuR.getThreadListIds())) {
            if (this.fuR.getThreadList() == null || this.fuR.getThreadList().size() == 0) {
                this.fOV.aKk();
                return;
            } else {
                this.fOV.aKj();
                return;
            }
        }
        this.fOV.aKi();
    }

    public g bpx() {
        return this.fOV;
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
        if (this.fOU != null) {
            this.fOU.bkj();
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

    @Override // com.baidu.tieba.frs.ag
    public void bjy() {
        if (this.fOV != null && this.fOV.getListView() != null) {
            this.fOV.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKh() {
        if (this.fOV != null) {
            bjy();
            this.fOV.startPullRefresh();
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
