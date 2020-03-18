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
import com.baidu.adp.widget.ListView.p;
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
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ai, aj, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.recapp.n, FrsCommonImageLayout.c {
    private String gGq;
    private FrsLoadMoreModel gGt;
    private FrsNewAreaModelController gIT;
    private VoiceManager gpi;
    private com.baidu.tbadk.k.c gtT;
    private String gpb = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData goJ = new FrsViewData();
    public long fWb = -1;
    public long dDX = 0;
    public long dEh = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean gpt = false;
    protected g gIU = null;
    private int fsO = -1;
    private int gwA = 3;
    private boolean fQm = false;
    private boolean gGw = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gpG = new SparseArray<>();
    private int cdH = 0;
    private int gqe = 0;
    private CustomMessageListener gsd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.gtT != null && FrsNewAreaFragment.this.gtT.isViewAttached()) {
                FrsNewAreaFragment.this.gtT.mF(num.intValue());
            }
        }
    };
    private Runnable gGx = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.fQm) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.ma(false);
            }
        }
    };
    private CustomMessageListener gGy = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                FrsNewAreaFragment.this.gGq = bjVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.gGq) && bjVar.aCc() != null) {
                    FrsNewAreaFragment.this.tN(bjVar.aCc().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener gqh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.aIm() != null) {
                        FrsNewAreaFragment.this.aIm().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.gtT != null && FrsNewAreaFragment.this.gtT.isViewAttached()) {
                        FrsNewAreaFragment.this.ma(false);
                    } else if (FrsNewAreaFragment.this.gIU != null) {
                        FrsNewAreaFragment.this.gIU.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final q gqw = new q() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long gGB = 1;

        @Override // com.baidu.tieba.tbadkCore.q
        public void sI(int i) {
            if (!FrsNewAreaFragment.this.gGw) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.gIU.bFe();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.gIU.hv(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (FrsNewAreaFragment.this.gGw) {
                if (FrsNewAreaFragment.this.bJK().bIZ() == null) {
                    FrsNewAreaFragment.this.gGw = false;
                    return;
                } else if (FrsNewAreaFragment.this.bJK().bIZ().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.gGw = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.gGB = 1L;
            } else if (fVar.isSuccess) {
                this.gGB = 0L;
            } else {
                this.gGB = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.gGt.resetData();
            }
            FrsNewAreaFragment.this.gIU.hv(false);
            if (FrsNewAreaFragment.this.bJK().bIZ() != null) {
                FrsNewAreaFragment.this.goJ = FrsNewAreaFragment.this.bJK().bIZ();
            }
            FrsNewAreaFragment.this.fsO = FrsNewAreaFragment.this.goJ.getPage().aBn();
            if (FrsNewAreaFragment.this.fsO == 0 && (FrsNewAreaFragment.this.goJ.getThreadListIds() == null || FrsNewAreaFragment.this.goJ.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.goJ.getThreadList() == null || FrsNewAreaFragment.this.goJ.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.gIU.bdz();
                } else {
                    FrsNewAreaFragment.this.gIU.bdy();
                }
            } else {
                FrsNewAreaFragment.this.gIU.bdx();
            }
            if (i == 4) {
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsNewAreaFragment.this.gGt.a(false, false, false, FrsNewAreaFragment.this.goJ.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.goJ.setThreadList(a2);
                    FrsNewAreaFragment.this.gIU.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.goJ, FrsNewAreaFragment.this.fsO);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.gIU.bFe();
                    break;
                case 2:
                    FrsNewAreaFragment.this.gIU.bFe();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.goJ.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.gGB != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.goJ != null) {
                    FrsNewAreaFragment.this.gpb = FrsNewAreaFragment.this.goJ.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.goJ.getForum().getId();
                    FrsNewAreaFragment.this.gIU.b(FrsNewAreaFragment.this.goJ.getForum(), FrsNewAreaFragment.this.goJ.getUserData());
                }
                if (FrsNewAreaFragment.this.goJ != null) {
                    FrsNewAreaFragment.this.goJ.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.goJ == null || FrsNewAreaFragment.this.goJ.getThreadList() == null || FrsNewAreaFragment.this.goJ.getThreadList().size() != 0 || FrsNewAreaFragment.this.bJK().getType() != 4) {
                    if (FrsNewAreaFragment.this.goJ != null && (a = FrsNewAreaFragment.this.gGt.a(false, false, true, FrsNewAreaFragment.this.goJ.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.goJ.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bEr();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.fWb > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.fWb, FrsNewAreaFragment.this.bJK().byW() - FrsNewAreaFragment.this.fWb, FrsNewAreaFragment.this.bJK().byU(), FrsNewAreaFragment.this.bJK().byV(), currentTimeMillis2 - FrsNewAreaFragment.this.bJK().byT());
                        FrsNewAreaFragment.this.fWb = -1L;
                    }
                    FrsNewAreaFragment.this.dEh = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.fWb > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.fWb, FrsNewAreaFragment.this.bJK().byW() - FrsNewAreaFragment.this.fWb, FrsNewAreaFragment.this.bJK().byU(), FrsNewAreaFragment.this.bJK().byV(), currentTimeMillis3 - FrsNewAreaFragment.this.bJK().byT());
                FrsNewAreaFragment.this.fWb = -1L;
            }
            FrsNewAreaFragment.this.dEh = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }
    };
    private final CustomMessageListener cLS = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.gIU != null) {
                FrsNewAreaFragment.this.gIU.startPullRefresh();
            }
        }
    };
    private final g.c esD = new g.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.tieba.a.d.aXK().wO("page_frs_good");
                FrsNewAreaFragment.this.ma(true);
                return;
            }
            FrsNewAreaFragment.this.gIU.hv(false);
        }
    };
    private final g.b dhj = new g.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.s.c.cKv().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.gpt) {
                FrsNewAreaFragment.this.gpt = true;
                FrsNewAreaFragment.this.gIU.bFs();
            }
            if (i == 0) {
                r.bvm().ku(true);
                com.baidu.tieba.s.c.cKv().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.gqe += i2;
            if (FrsNewAreaFragment.this.gqe >= FrsNewAreaFragment.this.cdH * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener doS = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
    private s gqC = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bi)) {
                bj bjVar = ((bi) mVar).cRt;
                if (bjVar.aDo() == null || bjVar.aDo().getGroup_id() == 0 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bjVar.aDb() != 1 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Jo(bjVar.getId())) {
                            readThreadHistory.Jn(bjVar.getId());
                            if (FrsNewAreaFragment.this.gIU != null) {
                                FrsNewAreaFragment.this.gIU.bFe();
                            }
                        }
                        boolean z = false;
                        final String aCy = bjVar.aCy();
                        if (aCy != null && !aCy.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aCy);
                                    xVar.aGk().aGL().mIsNeedAddCommenParam = false;
                                    xVar.aGk().aGL().mIsUseCurrentBDUSS = false;
                                    xVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bjVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bjVar.aCm() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aGK().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bjVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, FrsNewAreaFragment.this.gpb, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.goJ != null && FrsNewAreaFragment.this.goJ.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.gKD = FrsNewAreaFragment.this.goJ.needLog == 1;
                            bVar.gKF = FrsNewAreaFragment.this.goJ.getForum().getId();
                            bVar.gKE = FrsNewAreaFragment.this.gIT.bJD();
                            if (com.baidu.tieba.frs.d.d.gxl != null) {
                                bVar.gKG = com.baidu.tieba.frs.d.d.gxl.gKG;
                                bVar.gKH = com.baidu.tieba.frs.d.d.gxl.gKH;
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

    public void am(bj bjVar) {
        if (bjVar != null) {
            this.gIT.am(bjVar);
            this.gIU.scrollToTop();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.goJ = frsViewData;
            hideLoadingView(this.gIU.bsL());
            if (this.gIU != null) {
                this.gIU.hv(false);
                this.gIU.a(null, this.mPn, this.goJ, this.fsO);
            }
        }
    }

    private void showLoadingView() {
        this.gIU.lK(false);
        showLoadingView(this.gIU.bsL(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gIU.lK(true);
        hideLoadingView(this.gIU.bsL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.gIU.lK(false);
        this.gIU.bGs().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gIU.bdz();
        this.gIU.getListView().getData().clear();
        this.gIU.bFe();
        if (this.gtT == null) {
            this.gtT = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.gtT.setTitle(null);
            this.gtT.setButtonText(null);
            this.gtT.showRefreshButton();
            this.gtT.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.gtT.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.gtT.setSubText(null);
        }
        this.gtT.onChangeSkinType();
        this.gtT.attachView(this.gIU.bsL(), true);
        registerListener(this.gsd);
    }

    private void bcC() {
        this.gIU.lK(true);
        this.gIU.bGs().setEnabled(true);
        if (this.gtT != null && this.gtT.isViewAttached()) {
            this.gtT.dettachView(this.gIU.bsL());
        }
        MessageManager.getInstance().unRegisterListener(this.gsd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma(boolean z) {
        this.fQm = true;
        bEu();
        bcC();
        if (!z) {
            bcC();
            showLoadingView();
        }
        this.gIT.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fWb = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.fWb = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.dDX = this.beginTime - this.fWb;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cKv().w(getUniqueId());
        this.gIT = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.gIT.ad(arguments);
        } else if (bundle != null) {
            this.gIT.ad(bundle);
        } else {
            this.gIT.ad(null);
        }
        this.gpi = getVoiceManager();
        this.gpi.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.cLS);
        registerListener(this.gGy);
        registerListener(this.gqh);
        this.gGt = new FrsLoadMoreModel(this, null);
        this.gGt.registerListener();
        this.gGt.setPageType(3);
        this.gGt.mc(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cdH = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.gIU = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.fQm) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                ma(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        aGD();
    }

    private void aGD() {
        an anVar = new an("c13008");
        anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cx("fid", this.forumId);
        anVar.X("obj_type", 6);
        anVar.X("obj_locate", 2);
        anVar.aGD();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.gpi = getVoiceManager();
        this.gpi.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bIP();
        if (bundle != null) {
            this.gpb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.gpb = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bIP() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.doS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gIU != null) {
            this.gIU.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gsd);
        com.baidu.tieba.s.c.cKv().x(getUniqueId());
        r.bvm().ku(false);
        super.onDestroy();
        this.gIT.aiL();
        this.gpi = getVoiceManager();
        this.gpi.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gGx);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.gpb);
        bundle.putString("from", this.mFrom);
        this.gIT.onSaveInstanceState(bundle);
        this.gpi = getVoiceManager();
        if (this.gpi != null) {
            this.gpi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bj threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.gIU.bJM().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.goJ.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.jM(intent.getIntExtra("good_data", 0));
                            threadDataById.aDm();
                            ma(false);
                            return;
                        } else if (intExtra == 0) {
                            this.goJ.removeThreadData(threadDataById);
                            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.goJ.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new o());
                            }
                            this.gIU.bIU();
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
            if (this.gwA == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.fQm) {
                com.baidu.adp.lib.f.e.gx().post(this.gGx);
            }
        }
        bGh();
    }

    private void bGh() {
        if (isPrimary()) {
            if (this.gtT != null && this.gtT.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.gsd);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.gsd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gIU != null) {
            this.gIU.bFe();
        }
        this.gpi = getVoiceManager();
        this.gpi.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.gIU.a(this.gqC);
        this.gIU.setOnScrollListener(this.mScrollListener);
        this.gIU.setListPullRefreshListener(this.esD);
        this.gIU.a(this.dhj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gwA != 3 || this.gIU != null) {
            this.gwA = i;
            super.onChangeSkinType(i);
            if (this.gIU != null) {
                this.gIU.onChangeSkinType(i);
            }
            if (this.gtT != null && this.gtT.isViewAttached()) {
                this.gtT.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bDr() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bDr();
        }
        return null;
    }

    private void bEq() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Ji(FrsNewAreaFragment.this.gpb);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEr() {
        bEu();
        try {
            if (this.goJ != null) {
                this.gIU.bGr();
                this.gIU.bgE();
                this.gpb = this.goJ.getForum().getName();
                this.forumId = this.goJ.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.goJ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.goJ.getUserData().getBimg_end_time());
                bEq();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.goJ.getThreadList();
                if (threadList != null) {
                    this.gIU.a(threadList, this.mPn, this.goJ, this.goJ.getPage().aBn());
                    bIR();
                    this.gIU.bIU();
                    if (this.goJ.getIsNewUrl() == 1) {
                        this.gIU.bJM().setFromCDN(true);
                    } else {
                        this.gIU.bJM().setFromCDN(false);
                    }
                    this.gIU.setListViewSelection(bP(bJK().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int bP(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gpi = getVoiceManager();
        this.gpi.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        r.bvm().ku(false);
        com.baidu.tieba.s.c.cKv().b(getUniqueId(), false);
        if (this.goJ != null && this.goJ.getForum() != null) {
            com.baidu.tbadk.distribute.a.aOm().a(getPageContext().getPageActivity(), "frs", this.goJ.getForum().getId(), 0L);
        }
        this.gpi = getVoiceManager();
        if (this.gpi != null) {
            this.gpi.onStop(getPageContext());
        }
    }

    public void bGP() {
        if (this.gIU != null) {
            this.gIU.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tN(int i) {
        ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.goJ.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).cRt;
                    if (bjVar.getId() != null && bjVar.getId().equals(this.gGq)) {
                        c(bjVar, i);
                        this.gGq = null;
                        break;
                    }
                }
            }
            this.gIU.bJM().b(threadList, this.goJ);
            this.gIU.bJM().notifyDataSetChanged();
        }
    }

    private void c(bj bjVar, int i) {
        if (i == 1) {
            PraiseData aCc = bjVar.aCc();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aCc == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bjVar.a(praiseData);
                    return;
                }
                bjVar.aCc().getUser().add(0, metaData);
                bjVar.aCc().setNum(bjVar.aCc().getNum() + 1);
                bjVar.aCc().setIsLike(i);
            }
        } else if (bjVar.aCc() != null) {
            bjVar.aCc().setIsLike(i);
            bjVar.aCc().setNum(bjVar.aCc().getNum() - 1);
            ArrayList<MetaData> user = bjVar.aCc().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bjVar.aCc().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gpi == null) {
            this.gpi = VoiceManager.instance();
        }
        return this.gpi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aIm() {
        if (this.gIU == null) {
            return null;
        }
        return this.gIU.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bEu() {
        this.gpi = getVoiceManager();
        this.gpi.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aIn() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aIn();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.goJ != null && this.gIU != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.gIU.bFe();
            }
        }
    }

    private void bIR() {
        HashMap<Integer, bj> bHq;
        if (this.gIU != null && this.gIU.bJM() != null && (bHq = this.gIU.bJM().bHq()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bj> entry : bHq.entrySet()) {
                bj value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.aOs().E(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        if (aIm() == null) {
            return null;
        }
        return aIm().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            ma(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bEz() {
        return this.goJ;
    }

    public FrsNewAreaModelController bJK() {
        return this.gIT;
    }

    public void Bz(String str) {
        this.gpb = str;
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

    public void bck() {
        if (!this.gGt.isLoading && !this.gIT.isLoading()) {
            if (this.gGt.cn(this.goJ.getThreadListIds())) {
                this.gIU.a(this.gGt.bJm(), this.mPn, this.goJ, 0);
                this.gGt.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.goJ.getThreadListIds(), this.gpb, this.mPn, this.goJ.isBrandForum);
            } else if (this.fsO != 0) {
                this.gIU.a(this.gGt.bJm(), this.mPn, this.goJ, 0);
                this.mPn++;
                this.gIT.tP(this.mPn);
                this.gGt.loadingDone = false;
                this.gGt.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.gIU.bdz();
        } else if (!this.gIU.bFm()) {
            if (!this.gIT.bJb()) {
                this.gIU.bdz();
                return;
            }
            bcz();
            bck();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bcz();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void al(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.m> a;
        bcz();
        if (arrayList != null && arrayList.size() != 0 && (a = this.gGt.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.goJ.setThreadList(a);
            this.gIU.a(a, this.mPn, this.goJ, 0);
        }
    }

    public void co(List<String> list) {
        cd(list);
        int i = 0;
        Iterator<com.baidu.adp.widget.ListView.m> it = this.goJ.getThreadList().iterator();
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
            bck();
        }
    }

    private void cd(List<String> list) {
        if (!v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.goJ.getThreadList();
            if (!v.isEmpty(threadList) && this.gIU.getListView() != null && this.gIU.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.gIU.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).cRt;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.gGt.d(next);
                                this.gIU.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel bIQ() {
        return this.gGt;
    }

    private void bcz() {
        if (this.fsO == 0 && !this.gGt.cn(this.goJ.getThreadListIds())) {
            if (this.goJ.getThreadList() == null || this.goJ.getThreadList().size() == 0) {
                this.gIU.bdz();
                return;
            } else {
                this.gIU.bdy();
                return;
            }
        }
        this.gIU.bdx();
    }

    public g bJL() {
        return this.gIU;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.k.a.a.InterfaceC0078a
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
        com.baidu.tbadk.distribute.a.aOm().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bEt() {
        if (this.gIT != null) {
            this.gIT.bEt();
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

    @Override // com.baidu.tieba.frs.aj
    public NavigationBar beR() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.gpb;
    }

    @Override // com.baidu.tieba.frs.ai
    public void scrollToTop() {
        if (this.gIU != null && this.gIU.getListView() != null) {
            this.gIU.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void bdw() {
        if (this.gIU != null) {
            scrollToTop();
            this.gIU.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.gpG.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nU(int i) {
        return this.gpG.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.goJ != null) {
            i = this.goJ.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.un(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }
}
