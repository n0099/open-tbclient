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
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.p;
import com.baidu.adp.widget.ListView.s;
import com.baidu.k.a.a;
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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.c;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a.d;
import com.baidu.tieba.card.r;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.f;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0078a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ai, aj, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String gGq;
    private FrsGoodModelController gGs;
    private FrsLoadMoreModel gGt;
    private com.baidu.tieba.frs.gametab.b gGv;
    private VoiceManager gpi;
    private c gtT;
    private String mForumId;
    private String gpb = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean gGr = false;
    private String forumId = null;
    private FrsViewData goJ = new FrsViewData();
    public long fWb = -1;
    public long dDX = 0;
    public long dEh = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean gpt = false;
    protected a gGu = null;
    private int fsO = -1;
    private int mTabId = 0;
    private int gwA = 3;
    private boolean fQm = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gpG = new SparseArray<>();
    private boolean gGw = false;
    private int cdH = 0;
    private int gqe = 0;
    private CustomMessageListener gsd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.gtT != null && FrsGoodFragment.this.gtT.isViewAttached()) {
                FrsGoodFragment.this.gtT.mF(num.intValue());
            }
        }
    };
    private Runnable gGx = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.fQm) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.ma(false);
            }
        }
    };
    private CustomMessageListener gGy = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                FrsGoodFragment.this.gGq = bjVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.gGq) && bjVar.aCc() != null) {
                    FrsGoodFragment.this.tN(bjVar.aCc().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener gqh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.aIm() != null) {
                        FrsGoodFragment.this.aIm().setSelection(0);
                    }
                    if (FrsGoodFragment.this.gtT != null && FrsGoodFragment.this.gtT.isViewAttached()) {
                        FrsGoodFragment.this.ma(false);
                    } else if (FrsGoodFragment.this.gGu != null) {
                        FrsGoodFragment.this.gGu.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final q gqw = new q() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        private long gGB = 1;

        @Override // com.baidu.tieba.tbadkCore.q
        public void sI(int i) {
            if (!FrsGoodFragment.this.gGw) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.gGu.bFe();
                        return;
                    case 3:
                        FrsGoodFragment.this.gGu.hv(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void a(int i, boolean z, f fVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.gGw) {
                if (FrsGoodFragment.this.bIS().bIZ() == null) {
                    FrsGoodFragment.this.gGw = false;
                    return;
                } else if (FrsGoodFragment.this.bIS().bIZ().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.gGw = false;
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
                FrsGoodFragment.this.gGt.resetData();
            }
            FrsGoodFragment.this.gGu.hv(false);
            if (FrsGoodFragment.this.bIS().bIZ() != null) {
                FrsGoodFragment.this.goJ = FrsGoodFragment.this.bIS().bIZ();
            }
            FrsGoodFragment.this.fsO = FrsGoodFragment.this.goJ.getPage().aBn();
            if (FrsGoodFragment.this.fsO == 0 && (FrsGoodFragment.this.goJ.getThreadListIds() == null || FrsGoodFragment.this.goJ.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.goJ.getThreadList() == null || FrsGoodFragment.this.goJ.getThreadList().size() == 0) {
                    FrsGoodFragment.this.gGu.bdz();
                } else {
                    FrsGoodFragment.this.gGu.bdy();
                }
            } else {
                FrsGoodFragment.this.gGu.bdx();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.gGt.a(false, false, false, FrsGoodFragment.this.goJ.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.goJ.setThreadList(a2);
                    FrsGoodFragment.this.gGu.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.goJ, FrsGoodFragment.this.fsO);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.gGu.bFe();
                    break;
                case 2:
                    FrsGoodFragment.this.gGu.bFe();
                    break;
                case 3:
                    if (FrsGoodFragment.this.goJ.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.gGB != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.goJ != null) {
                    FrsGoodFragment.this.gpb = FrsGoodFragment.this.goJ.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.goJ.getForum().getId();
                    FrsGoodFragment.this.gGu.b(FrsGoodFragment.this.goJ.getForum(), FrsGoodFragment.this.goJ.getUserData());
                }
                if (FrsGoodFragment.this.goJ != null) {
                    FrsGoodFragment.this.goJ.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.gGu.c(FrsGoodFragment.this.goJ);
                if (FrsGoodFragment.this.goJ == null || FrsGoodFragment.this.goJ.getThreadList() == null || FrsGoodFragment.this.goJ.getThreadList().size() != 0 || FrsGoodFragment.this.bIS().getType() != 4) {
                    if (FrsGoodFragment.this.goJ != null && (a = FrsGoodFragment.this.gGt.a(false, false, true, FrsGoodFragment.this.goJ.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.goJ.setThreadList(a);
                    }
                    FrsGoodFragment.this.bEr();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.fWb > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.fWb, FrsGoodFragment.this.bIS().byW() - FrsGoodFragment.this.fWb, FrsGoodFragment.this.bIS().byU(), FrsGoodFragment.this.bIS().byV(), currentTimeMillis2 - FrsGoodFragment.this.bIS().byT());
                        FrsGoodFragment.this.fWb = -1L;
                    }
                    FrsGoodFragment.this.dEh = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.fWb > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.fWb, FrsGoodFragment.this.bIS().byW() - FrsGoodFragment.this.fWb, FrsGoodFragment.this.bIS().byU(), FrsGoodFragment.this.bIS().byV(), currentTimeMillis3 - FrsGoodFragment.this.bIS().byT());
                FrsGoodFragment.this.fWb = -1L;
            }
            FrsGoodFragment.this.dEh = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }
    };
    private final CustomMessageListener cLS = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.gGu != null) {
                FrsGoodFragment.this.gGu.startPullRefresh();
            }
        }
    };
    private final g.c esD = new g.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.isNetWorkAvailable()) {
                d.aXK().wP("page_frs_good");
                FrsGoodFragment.this.ma(true);
                return;
            }
            FrsGoodFragment.this.gGu.hv(false);
        }
    };
    private final g.b dhj = new g.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.s.c.cKv().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.gpt) {
                FrsGoodFragment.this.gpt = true;
                FrsGoodFragment.this.gGu.bFs();
            }
            if (i == 0) {
                r.bvm().ku(true);
                com.baidu.tieba.s.c.cKv().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.gqe += i2;
            if (FrsGoodFragment.this.gqe >= FrsGoodFragment.this.cdH * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener doS = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
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
    private s gqC = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bi)) {
                bj bjVar = ((bi) mVar).cRt;
                if (bjVar.aDo() == null || bjVar.aDo().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bjVar.aDb() != 1 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Jp(bjVar.getId())) {
                            readThreadHistory.Jo(bjVar.getId());
                            if (FrsGoodFragment.this.gGu != null) {
                                FrsGoodFragment.this.gGu.bFe();
                            }
                        }
                        boolean z = false;
                        final String aCy = bjVar.aCy();
                        if (aCy != null && !aCy.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aCy);
                                    xVar.aGk().aGL().mIsNeedAddCommenParam = false;
                                    xVar.aGk().aGL().mIsUseCurrentBDUSS = false;
                                    xVar.getNetData();
                                }
                            }).start();
                        }
                        String str = null;
                        if (bjVar != null) {
                            str = bjVar.getTid();
                        }
                        if (str == null) {
                            str = "";
                        }
                        if (bjVar.aCm() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aGK().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3) {
                            bjVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, FrsGoodFragment.this.gpb, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.goJ != null && FrsGoodFragment.this.goJ.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.gKD = FrsGoodFragment.this.goJ.needLog == 1;
                            bVar.gKF = FrsGoodFragment.this.goJ.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.gxl != null) {
                                bVar.gKG = com.baidu.tieba.frs.d.d.gxl.gKG;
                                bVar.gKH = com.baidu.tieba.frs.d.d.gxl.gKH;
                            }
                            com.baidu.tieba.frs.d.a.a(bjVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gqG = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.gGu != null) {
                FrsGoodFragment.this.gGu.sr();
            }
        }
    };

    static /* synthetic */ int j(FrsGoodFragment frsGoodFragment) {
        int i = frsGoodFragment.mPn;
        frsGoodFragment.mPn = i - 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ e getPageContext() {
        return super.getPageContext();
    }

    private void showLoadingView() {
        this.gGu.lK(false);
        showLoadingView(this.gGu.bsL(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gGu.lK(true);
        hideLoadingView(this.gGu.bsL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.gGu.lK(false);
        this.gGu.bGs().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gGu.bdz();
        this.gGu.getListView().getData().clear();
        this.gGu.bFe();
        if (this.gtT == null) {
            this.gtT = new c(getPageContext().getContext(), getNetRefreshListener());
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
        this.gtT.attachView(this.gGu.bsL(), true);
        registerListener(this.gsd);
    }

    private void bcC() {
        this.gGu.lK(true);
        this.gGu.bGs().setEnabled(true);
        if (this.gtT != null && this.gtT.isViewAttached()) {
            this.gtT.dettachView(this.gGu.bsL());
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
        this.gGs.oH(this.mTabId);
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
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.dDX = this.beginTime - this.fWb;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cKv().w(getUniqueId());
        this.gGs = new FrsGoodModelController(this);
        if (arguments != null) {
            this.gGs.ad(arguments);
            this.gGr = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.gGs.ad(bundle);
            this.gGr = bundle.getBoolean("is_game_frs", false);
        } else {
            this.gGs.ad(null);
        }
        this.gpi = getVoiceManager();
        this.gpi.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.cLS);
        registerListener(this.gGy);
        registerListener(this.gqh);
        registerListener(this.gqG);
        this.gGt = new FrsLoadMoreModel(this, null);
        this.gGt.registerListener();
        this.gGt.setPageType(2);
        this.gGt.mc(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cdH = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.gGu = new a(this, inflate, this.gGr);
        this.gGu.bIW().bJc();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.fQm) {
            if (j.isNetWorkAvailable()) {
                ma(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").cx("fid", this.mForumId).cx("obj_type", "7").X("obj_locate", 2).cx("uid", TbadkCoreApplication.getCurrentAccount()));
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

    public FrsLoadMoreModel bIQ() {
        return this.gGt;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gGu != null) {
            this.gGu.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gsd);
        com.baidu.tieba.s.c.cKv().x(getUniqueId());
        r.bvm().ku(false);
        super.onDestroy();
        this.gGs.aiL();
        this.gpi = getVoiceManager();
        this.gpi.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gGx);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.gpb);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.gGr);
        this.gGs.onSaveInstanceState(bundle);
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
                    this.gGu.bIW().notifyDataSetChanged();
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
                            ArrayList<m> threadList = this.goJ.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new o());
                            }
                            this.gGu.bIU();
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
        if (this.gGu != null) {
            this.gGu.bFe();
        }
        this.gpi = getVoiceManager();
        this.gpi.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.gGv = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.gGu.a(this.gqC);
        this.gGu.setOnScrollListener(this.mScrollListener);
        this.gGu.setListPullRefreshListener(this.esD);
        this.gGu.a(this.dhj);
        this.gGu.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.gGv != null) {
                    FrsGoodFragment.this.gGv.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gwA != 3 || this.gGu != null) {
            this.gwA = i;
            super.onChangeSkinType(i);
            if (this.gGu != null) {
                this.gGu.onChangeSkinType(i);
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
                h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Jj(FrsGoodFragment.this.gpb);
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
                this.gGu.bGr();
                this.gGu.bgE();
                this.gpb = this.goJ.getForum().getName();
                this.forumId = this.goJ.getForum().getId();
                if (this.goJ != null && this.goJ.getForum() != null) {
                    this.gGu.a(this.goJ.getForum().getThemeColorInfo());
                    this.gGu.c(this.goJ);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.goJ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.goJ.getUserData().getBimg_end_time());
                bEq();
                if (!this.gGu.bIW().p(bj.cRO)) {
                    this.goJ.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.goJ.getThreadList();
                if (threadList != null) {
                    this.gGu.a(threadList, this.mPn, this.goJ, this.goJ.getPage().aBn());
                    bIR();
                    this.gGu.bIU();
                    if (this.goJ.getIsNewUrl() == 1) {
                        this.gGu.bIW().setFromCDN(true);
                    } else {
                        this.gGu.bIW().setFromCDN(false);
                    }
                    this.gGu.setListViewSelection(bP(bIS().getType(), this.mPn));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void tN(int i) {
        ArrayList<m> threadList = this.goJ.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).cRt;
                    if (bjVar.getId() != null && bjVar.getId().equals(this.gGq)) {
                        c(bjVar, i);
                        this.gGq = null;
                        break;
                    }
                }
            }
            this.gGu.bIW().b(threadList, this.goJ);
            this.gGu.bIW().notifyDataSetChanged();
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
        if (this.gGu == null) {
            return null;
        }
        return this.gGu.getListView();
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
        if (this.goJ != null && this.gGu != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.gGu.bFe();
            }
        }
    }

    private void bIR() {
        HashMap<Integer, bj> bHq;
        if (this.gGu != null && this.gGu.bIW() != null && (bHq = this.gGu.bIW().bHq()) != null) {
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
        if (j.isNetWorkAvailable()) {
            ma(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bEz() {
        return this.goJ;
    }

    public FrsGoodModelController bIS() {
        return this.gGs;
    }

    public void BA(String str) {
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

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!l.isNetOk()) {
            this.gGu.bdz();
        } else if (!this.gGs.bJb()) {
            this.gGu.bdz();
        } else {
            bcz();
            if (!this.gGt.isLoading && !this.gGs.isLoading()) {
                if (this.gGt.cn(this.goJ.getThreadListIds())) {
                    this.gGu.a(this.gGt.bJm(), this.mPn, this.goJ, 0);
                    this.gGt.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.goJ.getThreadListIds(), this.gpb, this.mPn, this.goJ.isBrandForum);
                } else if (this.fsO != 0) {
                    this.gGu.a(this.gGt.bJm(), this.mPn, this.goJ, 0);
                    this.mPn++;
                    this.gGs.tP(this.mPn);
                    this.gGt.loadingDone = false;
                    this.gGt.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bcz();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void al(ArrayList<m> arrayList) {
        ArrayList<m> a;
        bcz();
        if (arrayList != null && arrayList.size() != 0 && (a = this.gGt.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.goJ.setThreadList(a);
            this.gGu.a(a, this.mPn, this.goJ, 0);
        }
    }

    private void bcz() {
        if (this.fsO == 0 && !this.gGt.cn(this.goJ.getThreadListIds())) {
            if (this.goJ.getThreadList() == null || this.goJ.getThreadList().size() == 0) {
                this.gGu.bdz();
                return;
            } else {
                this.gGu.bdy();
                return;
            }
        }
        this.gGu.bdx();
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
        if (this.gGs != null) {
            this.gGs.bEt();
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.goJ != null) {
            i = this.goJ.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.un(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tO(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            ma(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void scrollToTop() {
        if (this.gGu != null && this.gGu.getListView() != null) {
            this.gGu.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void bdw() {
        if (this.gGu != null) {
            scrollToTop();
            this.gGu.startPullRefresh();
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
}
