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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ai;
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
/* loaded from: classes7.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, ai, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String gDe;
    private FrsLoadMoreModel gDh;
    private FrsNewAreaModelController gFF;
    private VoiceManager gmi;
    private com.baidu.tbadk.k.c gqZ;
    private String gmb = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData glJ = new FrsViewData();
    public long fSK = -1;
    public long dzt = 0;
    public long dzB = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean gmt = false;
    protected g gFG = null;
    private int fpy = -1;
    private int gtE = 3;
    private boolean fMU = false;
    public boolean gDk = false;
    private boolean gDl = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gmG = new SparseArray<>();
    private int bZo = 0;
    private int gne = 0;
    private CustomMessageListener gpd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.gqZ != null && FrsNewAreaFragment.this.gqZ.isViewAttached()) {
                FrsNewAreaFragment.this.gqZ.ml(num.intValue());
            }
        }
    };
    private Runnable gDm = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.fMU) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.lS(false);
            }
        }
    };
    private CustomMessageListener gDn = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                FrsNewAreaFragment.this.gDe = bjVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.gDe) && bjVar.azI() != null) {
                    FrsNewAreaFragment.this.tC(bjVar.azI().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener gnh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.aFQ() != null) {
                        FrsNewAreaFragment.this.aFQ().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.gqZ != null && FrsNewAreaFragment.this.gqZ.isViewAttached()) {
                        FrsNewAreaFragment.this.lS(false);
                    } else if (FrsNewAreaFragment.this.gFG != null) {
                        FrsNewAreaFragment.this.gFG.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final p gnw = new p() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long gDq = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void sA(int i) {
            if (!FrsNewAreaFragment.this.gDl) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.gFG.bDo();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.gFG.hn(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.gDl) {
                if (FrsNewAreaFragment.this.bHS().bHj() == null) {
                    FrsNewAreaFragment.this.gDl = false;
                    return;
                } else if (FrsNewAreaFragment.this.bHS().bHj().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.gDl = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.gDq = 1L;
            } else if (bVar.isSuccess) {
                this.gDq = 0L;
            } else {
                this.gDq = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.gDh.resetData();
            }
            FrsNewAreaFragment.this.gFG.hn(false);
            if (FrsNewAreaFragment.this.bHS().bHj() != null) {
                FrsNewAreaFragment.this.glJ = FrsNewAreaFragment.this.bHS().bHj();
            }
            FrsNewAreaFragment.this.fpy = FrsNewAreaFragment.this.glJ.getPage().ayR();
            if (FrsNewAreaFragment.this.fpy == 0 && (FrsNewAreaFragment.this.glJ.getThreadListIds() == null || FrsNewAreaFragment.this.glJ.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.glJ.getThreadList() == null || FrsNewAreaFragment.this.glJ.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.gFG.bbc();
                } else {
                    FrsNewAreaFragment.this.gFG.bbb();
                }
            } else {
                FrsNewAreaFragment.this.gFG.bba();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.gDh.a(false, false, false, FrsNewAreaFragment.this.glJ.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.glJ.setThreadList(a2);
                    FrsNewAreaFragment.this.gFG.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.glJ, FrsNewAreaFragment.this.fpy);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.gFG.bDo();
                    break;
                case 2:
                    FrsNewAreaFragment.this.gFG.bDo();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.glJ.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.gDq != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.glJ != null) {
                    FrsNewAreaFragment.this.gmb = FrsNewAreaFragment.this.glJ.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.glJ.getForum().getId();
                    FrsNewAreaFragment.this.gFG.b(FrsNewAreaFragment.this.glJ.getForum(), FrsNewAreaFragment.this.glJ.getUserData());
                }
                if (FrsNewAreaFragment.this.glJ != null) {
                    FrsNewAreaFragment.this.glJ.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.glJ == null || FrsNewAreaFragment.this.glJ.getThreadList() == null || FrsNewAreaFragment.this.glJ.getThreadList().size() != 0 || FrsNewAreaFragment.this.bHS().getType() != 4) {
                    if (FrsNewAreaFragment.this.glJ != null && (a = FrsNewAreaFragment.this.gDh.a(false, false, true, FrsNewAreaFragment.this.glJ.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.glJ.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bCC();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.fSK > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.fSK, FrsNewAreaFragment.this.bHS().bxi() - FrsNewAreaFragment.this.fSK, FrsNewAreaFragment.this.bHS().bxg(), FrsNewAreaFragment.this.bHS().bxh(), currentTimeMillis2 - FrsNewAreaFragment.this.bHS().bxf());
                        FrsNewAreaFragment.this.fSK = -1L;
                    }
                    FrsNewAreaFragment.this.dzB = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.fSK > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.fSK, FrsNewAreaFragment.this.bHS().bxi() - FrsNewAreaFragment.this.fSK, FrsNewAreaFragment.this.bHS().bxg(), FrsNewAreaFragment.this.bHS().bxh(), currentTimeMillis3 - FrsNewAreaFragment.this.bHS().bxf());
                FrsNewAreaFragment.this.fSK = -1L;
            }
            FrsNewAreaFragment.this.dzB = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
        }
    };
    private final CustomMessageListener cHC = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.gFG != null) {
                FrsNewAreaFragment.this.gFG.startPullRefresh();
            }
        }
    };
    private final g.c enH = new g.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.tieba.a.d.aVo().wt("page_frs_good");
                FrsNewAreaFragment.this.lS(true);
                return;
            }
            FrsNewAreaFragment.this.gFG.hn(false);
        }
    };
    private final g.b dcD = new g.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.r.c.cIu().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.gmt) {
                FrsNewAreaFragment.this.gmt = true;
                FrsNewAreaFragment.this.gFG.bDC();
            }
            if (i == 0) {
                r.btA().kn(true);
                com.baidu.tieba.r.c.cIu().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.gne += i2;
            if (FrsNewAreaFragment.this.gne >= FrsNewAreaFragment.this.bZo * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener dkk = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
    private s gnC = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v15, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bi)) {
                bj bjVar = ((bi) mVar).cNb;
                if (bjVar.aAV() == null || bjVar.aAV().getGroup_id() == 0 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bjVar.aAH() != 1 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Jb(bjVar.getId())) {
                            readThreadHistory.Ja(bjVar.getId());
                            if (FrsNewAreaFragment.this.gFG != null) {
                                FrsNewAreaFragment.this.gFG.bDo();
                            }
                        }
                        boolean z = false;
                        final String aAe = bjVar.aAe();
                        if (aAe != null && !aAe.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aAe);
                                    xVar.aDU().aEu().mIsNeedAddCommenParam = false;
                                    xVar.aDU().aEu().mIsUseCurrentBDUSS = false;
                                    xVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bjVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bjVar.azS() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aEt().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bjVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, FrsNewAreaFragment.this.gmb, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsNewAreaFragment.this.gDk ? 15 : 3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.glJ != null && FrsNewAreaFragment.this.glJ.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.gHl = FrsNewAreaFragment.this.glJ.needLog == 1;
                            bVar.gHn = FrsNewAreaFragment.this.glJ.getForum().getId();
                            bVar.gHm = FrsNewAreaFragment.this.gFF.bHL();
                            if (com.baidu.tieba.frs.d.d.gun != null) {
                                bVar.gHo = com.baidu.tieba.frs.d.d.gun.gHo;
                                bVar.gHp = com.baidu.tieba.frs.d.d.gun.gHp;
                            }
                            com.baidu.tieba.frs.d.a.a(bjVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar, FrsNewAreaFragment.this.getTbPageTag());
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

    public void ak(bj bjVar) {
        if (bjVar != null) {
            this.gFF.ak(bjVar);
            this.gFG.scrollToTop();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.glJ = frsViewData;
            hideLoadingView(this.gFG.bqY());
            if (this.gFG != null) {
                this.gFG.hn(false);
                this.gFG.a(null, this.mPn, this.glJ, this.fpy);
            }
        }
    }

    private void showLoadingView() {
        this.gFG.lC(false);
        showLoadingView(this.gFG.bqY(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gFG.lC(true);
        hideLoadingView(this.gFG.bqY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.gFG.lC(false);
        this.gFG.bEB().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gFG.bbc();
        this.gFG.getListView().getData().clear();
        this.gFG.bDo();
        if (this.gqZ == null) {
            this.gqZ = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.gqZ.setTitle(null);
            this.gqZ.setButtonText(null);
            this.gqZ.showRefreshButton();
            this.gqZ.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.gqZ.setSubText(getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.gqZ.setSubText(null);
        }
        this.gqZ.onChangeSkinType();
        this.gqZ.attachView(this.gFG.bqY(), true);
        registerListener(this.gpd);
    }

    private void baf() {
        this.gFG.lC(true);
        this.gFG.bEB().setEnabled(true);
        if (this.gqZ != null && this.gqZ.isViewAttached()) {
            this.gqZ.dettachView(this.gFG.bqY());
        }
        MessageManager.getInstance().unRegisterListener(this.gpd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lS(boolean z) {
        this.fMU = true;
        bCF();
        baf();
        if (!z) {
            baf();
            showLoadingView();
        }
        this.gFF.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fSK = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.fSK = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.dzt = this.beginTime - this.fSK;
        super.onCreate(bundle);
        com.baidu.tieba.r.c.cIu().w(getUniqueId());
        this.gFF = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.gFF.ad(arguments);
        } else if (bundle != null) {
            this.gFF.ad(bundle);
        } else {
            this.gFF.ad(null);
        }
        this.gmi = getVoiceManager();
        this.gmi.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.cHC);
        registerListener(this.gDn);
        registerListener(this.gnh);
        this.gDh = new FrsLoadMoreModel(this, null);
        this.gDh.registerListener();
        this.gDh.setPageType(3);
        this.gDh.lV(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.bZo = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.gFG = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.fMU) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                lS(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        aEm();
    }

    private void aEm() {
        an anVar = new an("c13008");
        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cp("fid", this.forumId);
        anVar.Z("obj_type", 6);
        anVar.Z("obj_locate", 2);
        anVar.aEm();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.gmi = getVoiceManager();
        this.gmi.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bGZ();
        if (bundle != null) {
            this.gmb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.gmb = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bGZ() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dkk);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gFG != null) {
            this.gFG.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gpd);
        com.baidu.tieba.r.c.cIu().x(getUniqueId());
        r.btA().kn(false);
        super.onDestroy();
        this.gFF.ags();
        this.gmi = getVoiceManager();
        this.gmi.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gDm);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.gmb);
        bundle.putString("from", this.mFrom);
        this.gFF.onSaveInstanceState(bundle);
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bj threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.gFG.bHU().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.glJ.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.jv(intent.getIntExtra("good_data", 0));
                            threadDataById.aAT();
                            lS(false);
                            return;
                        } else if (intExtra == 0) {
                            this.glJ.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.glJ.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.n());
                            }
                            this.gFG.bHe();
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
            if (this.gtE == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.fMU) {
                com.baidu.adp.lib.f.e.gx().post(this.gDm);
            }
        }
        bEr();
    }

    private void bEr() {
        if (isPrimary()) {
            if (this.gqZ != null && this.gqZ.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.gpd);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.gpd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gFG != null) {
            this.gFG.bDo();
        }
        this.gmi = getVoiceManager();
        this.gmi.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.gFG.a(this.gnC);
        this.gFG.setOnScrollListener(this.mScrollListener);
        this.gFG.setListPullRefreshListener(this.enH);
        this.gFG.a(this.dcD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gtE != 3 || this.gFG != null) {
            this.gtE = i;
            super.onChangeSkinType(i);
            if (this.gFG != null) {
                this.gFG.onChangeSkinType(i);
            }
            if (this.gqZ != null && this.gqZ.isViewAttached()) {
                this.gqZ.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bBE() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bBE();
        }
        return null;
    }

    private void bCB() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.IV(FrsNewAreaFragment.this.gmb);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCC() {
        bCF();
        try {
            if (this.glJ != null) {
                this.gFG.bem();
                this.gmb = this.glJ.getForum().getName();
                this.forumId = this.glJ.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.glJ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.glJ.getUserData().getBimg_end_time());
                bCB();
                ArrayList<m> threadList = this.glJ.getThreadList();
                if (threadList != null) {
                    this.gFG.a(threadList, this.mPn, this.glJ, this.glJ.getPage().ayR());
                    bHb();
                    this.gFG.bHe();
                    if (this.glJ.getIsNewUrl() == 1) {
                        this.gFG.bHU().setFromCDN(true);
                    } else {
                        this.gFG.bHU().setFromCDN(false);
                    }
                    this.gFG.setListViewSelection(bN(bHS().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int bN(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gmi = getVoiceManager();
        this.gmi.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        r.btA().kn(false);
        com.baidu.tieba.r.c.cIu().b(getUniqueId(), false);
        if (this.glJ != null && this.glJ.getForum() != null) {
            com.baidu.tbadk.distribute.a.aLJ().a(getPageContext().getPageActivity(), "frs", this.glJ.getForum().getId(), 0L);
        }
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onStop(getPageContext());
        }
    }

    public void bEY() {
        if (this.gFG != null) {
            this.gFG.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tC(int i) {
        ArrayList<m> threadList = this.glJ.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).cNb;
                    if (bjVar.getId() != null && bjVar.getId().equals(this.gDe)) {
                        c(bjVar, i);
                        this.gDe = null;
                        break;
                    }
                }
            }
            this.gFG.bHU().b(threadList, this.glJ);
            this.gFG.bHU().notifyDataSetChanged();
        }
    }

    private void c(bj bjVar, int i) {
        if (i == 1) {
            PraiseData azI = bjVar.azI();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (azI == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bjVar.a(praiseData);
                    return;
                }
                bjVar.azI().getUser().add(0, metaData);
                bjVar.azI().setNum(bjVar.azI().getNum() + 1);
                bjVar.azI().setIsLike(i);
            }
        } else if (bjVar.azI() != null) {
            bjVar.azI().setIsLike(i);
            bjVar.azI().setNum(bjVar.azI().getNum() - 1);
            ArrayList<MetaData> user = bjVar.azI().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bjVar.azI().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gmi == null) {
            this.gmi = VoiceManager.instance();
        }
        return this.gmi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aFQ() {
        if (this.gFG == null) {
            return null;
        }
        return this.gFG.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bCF() {
        this.gmi = getVoiceManager();
        this.gmi.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aFR() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aFR();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.glJ != null && this.gFG != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.gFG.bDo();
            }
        }
    }

    private void bHb() {
        HashMap<Integer, bj> bFw;
        if (this.gFG != null && this.gFG.bHU() != null && (bFw = this.gFG.bHU().bFw()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bj> entry : bFw.entrySet()) {
                bj value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.aLP().C(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (aFQ() == null) {
            return null;
        }
        return aFQ().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            lS(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bCK() {
        return this.glJ;
    }

    public FrsNewAreaModelController bHS() {
        return this.gFF;
    }

    public void Bj(String str) {
        this.gmb = str;
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

    public void aZN() {
        if (!this.gDh.isLoading && !this.gFF.isLoading()) {
            if (this.gDh.cr(this.glJ.getThreadListIds())) {
                this.gFG.a(this.gDh.bHv(), this.mPn, this.glJ, 0);
                this.gDh.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.glJ.getThreadListIds(), this.gmb, this.mPn, this.glJ.isBrandForum);
            } else if (this.fpy != 0) {
                this.gFG.a(this.gDh.bHv(), this.mPn, this.glJ, 0);
                this.mPn++;
                this.gFF.tE(this.mPn);
                this.gDh.loadingDone = false;
                this.gDh.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.gFG.bbc();
        } else if (!this.gFG.bDw()) {
            if (!this.gFF.bHl()) {
                this.gFG.bbc();
                return;
            }
            bac();
            aZN();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bac();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void al(ArrayList<m> arrayList) {
        ArrayList<m> a;
        bac();
        if (arrayList != null && arrayList.size() != 0 && (a = this.gDh.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.glJ.setThreadList(a);
            this.gFG.a(a, this.mPn, this.glJ, 0);
        }
    }

    public void cs(List<String> list) {
        ch(list);
        int i = 0;
        Iterator<m> it = this.glJ.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bi ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            aZN();
        }
    }

    private void ch(List<String> list) {
        if (!v.isEmpty(list)) {
            ArrayList<m> threadList = this.glJ.getThreadList();
            if (!v.isEmpty(threadList) && this.gFG.getListView() != null && this.gFG.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.gFG.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).cNb;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.gDh.d(next);
                                this.gFG.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel bHa() {
        return this.gDh;
    }

    private void bac() {
        if (this.fpy == 0 && !this.gDh.cr(this.glJ.getThreadListIds())) {
            if (this.glJ.getThreadList() == null || this.glJ.getThreadList().size() == 0) {
                this.gFG.bbc();
                return;
            } else {
                this.gFG.bbb();
                return;
            }
        }
        this.gFG.bba();
    }

    public g bHT() {
        return this.gFG;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.k.a.a.InterfaceC0072a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.checkCamera(getActivity().getApplicationContext())) {
                al.e(getPageContext());
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
        com.baidu.tbadk.distribute.a.aLJ().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bCE() {
        if (this.gFF != null) {
            this.gFF.bCE();
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

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar bcw() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.gmb;
    }

    @Override // com.baidu.tieba.frs.ah
    public void scrollToTop() {
        if (this.gFG != null && this.gFG.getListView() != null) {
            this.gFG.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void baZ() {
        if (this.gFG != null) {
            scrollToTop();
            this.gFG.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.gmG.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nB(int i) {
        return this.gmG.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.glJ != null) {
            i = this.glJ.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.ub(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }
}
