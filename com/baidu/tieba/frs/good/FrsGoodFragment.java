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
import com.baidu.adp.lib.f.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
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
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ai;
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
/* loaded from: classes7.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0072a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, ai, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String gDe;
    private FrsGoodModelController gDg;
    private FrsLoadMoreModel gDh;
    private com.baidu.tieba.frs.gametab.b gDj;
    private VoiceManager gmi;
    private c gqZ;
    private String mForumId;
    private String gmb = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean gDf = false;
    private String forumId = null;
    private FrsViewData glJ = new FrsViewData();
    public long fSK = -1;
    public long dzt = 0;
    public long dzB = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean gmt = false;
    protected a gDi = null;
    private int fpy = -1;
    private int mTabId = 0;
    private int gtE = 3;
    private boolean fMU = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gmG = new SparseArray<>();
    public boolean gDk = false;
    private boolean gDl = false;
    private int bZo = 0;
    private int gne = 0;
    private CustomMessageListener gpd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.gqZ != null && FrsGoodFragment.this.gqZ.isViewAttached()) {
                FrsGoodFragment.this.gqZ.ml(num.intValue());
            }
        }
    };
    private Runnable gDm = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.fMU) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.lS(false);
            }
        }
    };
    private CustomMessageListener gDn = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                FrsGoodFragment.this.gDe = bjVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.gDe) && bjVar.azI() != null) {
                    FrsGoodFragment.this.tC(bjVar.azI().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener gnh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.aFQ() != null) {
                            FrsGoodFragment.this.aFQ().setSelection(0);
                        }
                        if (FrsGoodFragment.this.gqZ != null && FrsGoodFragment.this.gqZ.isViewAttached()) {
                            FrsGoodFragment.this.lS(false);
                        } else if (FrsGoodFragment.this.gDi != null) {
                            FrsGoodFragment.this.gDi.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                        }
                    }
                }
            }
        }
    };
    public final p gnw = new p() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        private long gDq = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void sA(int i) {
            if (!FrsGoodFragment.this.gDl) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.gDi.bDo();
                        return;
                    case 3:
                        FrsGoodFragment.this.gDi.hn(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.gDl) {
                if (FrsGoodFragment.this.bHc().bHj() == null) {
                    FrsGoodFragment.this.gDl = false;
                    return;
                } else if (FrsGoodFragment.this.bHc().bHj().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.gDl = false;
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
                FrsGoodFragment.this.gDh.resetData();
            }
            FrsGoodFragment.this.gDi.hn(false);
            if (FrsGoodFragment.this.bHc().bHj() != null) {
                FrsGoodFragment.this.glJ = FrsGoodFragment.this.bHc().bHj();
            }
            FrsGoodFragment.this.fpy = FrsGoodFragment.this.glJ.getPage().ayR();
            if (FrsGoodFragment.this.fpy == 0 && (FrsGoodFragment.this.glJ.getThreadListIds() == null || FrsGoodFragment.this.glJ.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.glJ.getThreadList() == null || FrsGoodFragment.this.glJ.getThreadList().size() == 0) {
                    FrsGoodFragment.this.gDi.bbc();
                } else {
                    FrsGoodFragment.this.gDi.bbb();
                }
            } else {
                FrsGoodFragment.this.gDi.bba();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.gDh.a(false, false, false, FrsGoodFragment.this.glJ.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.glJ.setThreadList(a2);
                    FrsGoodFragment.this.gDi.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.glJ, FrsGoodFragment.this.fpy);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.gDi.bDo();
                    break;
                case 2:
                    FrsGoodFragment.this.gDi.bDo();
                    break;
                case 3:
                    if (FrsGoodFragment.this.glJ.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.gDq != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.glJ != null) {
                    FrsGoodFragment.this.gmb = FrsGoodFragment.this.glJ.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.glJ.getForum().getId();
                    FrsGoodFragment.this.gDi.b(FrsGoodFragment.this.glJ.getForum(), FrsGoodFragment.this.glJ.getUserData());
                }
                if (FrsGoodFragment.this.glJ != null) {
                    FrsGoodFragment.this.glJ.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.gDi.c(FrsGoodFragment.this.glJ);
                if (FrsGoodFragment.this.glJ == null || FrsGoodFragment.this.glJ.getThreadList() == null || FrsGoodFragment.this.glJ.getThreadList().size() != 0 || FrsGoodFragment.this.bHc().getType() != 4) {
                    if (FrsGoodFragment.this.glJ != null && (a = FrsGoodFragment.this.gDh.a(false, false, true, FrsGoodFragment.this.glJ.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.glJ.setThreadList(a);
                    }
                    FrsGoodFragment.this.bCC();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.fSK > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.fSK, FrsGoodFragment.this.bHc().bxi() - FrsGoodFragment.this.fSK, FrsGoodFragment.this.bHc().bxg(), FrsGoodFragment.this.bHc().bxh(), currentTimeMillis2 - FrsGoodFragment.this.bHc().bxf());
                        FrsGoodFragment.this.fSK = -1L;
                    }
                    FrsGoodFragment.this.dzB = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.fSK > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.fSK, FrsGoodFragment.this.bHc().bxi() - FrsGoodFragment.this.fSK, FrsGoodFragment.this.bHc().bxg(), FrsGoodFragment.this.bHc().bxh(), currentTimeMillis3 - FrsGoodFragment.this.bHc().bxf());
                FrsGoodFragment.this.fSK = -1L;
            }
            FrsGoodFragment.this.dzB = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(l lVar) {
        }
    };
    private final CustomMessageListener cHC = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.gDi != null) {
                FrsGoodFragment.this.gDi.startPullRefresh();
            }
        }
    };
    private final g.c enH = new g.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.isNetWorkAvailable()) {
                d.aVo().wt("page_frs_good");
                FrsGoodFragment.this.lS(true);
                return;
            }
            FrsGoodFragment.this.gDi.hn(false);
        }
    };
    private final g.b dcD = new g.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.r.c.cIu().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.gmt) {
                FrsGoodFragment.this.gmt = true;
                FrsGoodFragment.this.gDi.bDC();
            }
            if (i == 0) {
                r.btA().kn(true);
                com.baidu.tieba.r.c.cIu().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.gne += i2;
            if (FrsGoodFragment.this.gne >= FrsGoodFragment.this.bZo * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener dkk = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
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
    private s gnC = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v15, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bi)) {
                bj bjVar = ((bi) mVar).cNb;
                if (bjVar.aAV() == null || bjVar.aAV().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bjVar.aAH() != 1 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Jb(bjVar.getId())) {
                            readThreadHistory.Ja(bjVar.getId());
                            if (FrsGoodFragment.this.gDi != null) {
                                FrsGoodFragment.this.gDi.bDo();
                            }
                        }
                        boolean z = false;
                        final String aAe = bjVar.aAe();
                        if (aAe != null && !aAe.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aAe);
                                    xVar.aDU().aEu().mIsNeedAddCommenParam = false;
                                    xVar.aDU().aEu().mIsUseCurrentBDUSS = false;
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
                        if (bjVar.azS() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aEt().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3) {
                            bjVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, FrsGoodFragment.this.gmb, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.gDk ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.glJ != null && FrsGoodFragment.this.glJ.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.gHl = FrsGoodFragment.this.glJ.needLog == 1;
                            bVar.gHn = FrsGoodFragment.this.glJ.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.gun != null) {
                                bVar.gHo = com.baidu.tieba.frs.d.d.gun.gHo;
                                bVar.gHp = com.baidu.tieba.frs.d.d.gun.gHp;
                            }
                            com.baidu.tieba.frs.d.a.a(bjVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gnG = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.gDi != null) {
                FrsGoodFragment.this.gDi.rl();
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
        this.gDi.lC(false);
        showLoadingView(this.gDi.bqY(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gDi.lC(true);
        hideLoadingView(this.gDi.bqY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.gDi.lC(false);
        this.gDi.bEB().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gDi.bbc();
        this.gDi.getListView().getData().clear();
        this.gDi.bDo();
        if (this.gqZ == null) {
            this.gqZ = new c(getPageContext().getContext(), getNetRefreshListener());
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
        this.gqZ.attachView(this.gDi.bqY(), true);
        registerListener(this.gpd);
    }

    private void baf() {
        this.gDi.lC(true);
        this.gDi.bEB().setEnabled(true);
        if (this.gqZ != null && this.gqZ.isViewAttached()) {
            this.gqZ.dettachView(this.gDi.bqY());
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
        this.gDg.oo(this.mTabId);
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
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.dzt = this.beginTime - this.fSK;
        super.onCreate(bundle);
        com.baidu.tieba.r.c.cIu().w(getUniqueId());
        this.gDg = new FrsGoodModelController(this);
        if (arguments != null) {
            this.gDg.ad(arguments);
            this.gDf = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.gDg.ad(bundle);
            this.gDf = bundle.getBoolean("is_game_frs", false);
        } else {
            this.gDg.ad(null);
        }
        this.gmi = getVoiceManager();
        this.gmi.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.cHC);
        registerListener(this.gDn);
        registerListener(this.gnh);
        registerListener(this.gnG);
        this.gDh = new FrsLoadMoreModel(this, null);
        this.gDh.registerListener();
        this.gDh.setPageType(2);
        this.gDh.lV(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.bZo = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.gDi = new a(this, inflate, this.gDf);
        this.gDi.bHg().lU(this.gDk);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.fMU) {
            if (j.isNetWorkAvailable()) {
                lS(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").cp("fid", this.mForumId).cp("obj_type", "7").Z("obj_locate", 2).cp("uid", TbadkCoreApplication.getCurrentAccount()));
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
            this.gDk = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.gmb = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.gDk = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bGZ() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dkk);
    }

    public FrsLoadMoreModel bHa() {
        return this.gDh;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gDi != null) {
            this.gDi.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gpd);
        com.baidu.tieba.r.c.cIu().x(getUniqueId());
        r.btA().kn(false);
        super.onDestroy();
        this.gDg.ags();
        this.gmi = getVoiceManager();
        this.gmi.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gDm);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.gmb);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.gDf);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.gDk);
        this.gDg.onSaveInstanceState(bundle);
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
                    this.gDi.bHg().notifyDataSetChanged();
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
                            this.gDi.bHe();
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
        if (this.gDi != null) {
            this.gDi.bDo();
        }
        this.gmi = getVoiceManager();
        this.gmi.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.gDj = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.gDi.a(this.gnC);
        this.gDi.setOnScrollListener(this.mScrollListener);
        this.gDi.setListPullRefreshListener(this.enH);
        this.gDi.a(this.dcD);
        this.gDi.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.gDj != null) {
                    FrsGoodFragment.this.gDj.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gtE != 3 || this.gDi != null) {
            this.gtE = i;
            super.onChangeSkinType(i);
            if (this.gDi != null) {
                this.gDi.onChangeSkinType(i);
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
                h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.IV(FrsGoodFragment.this.gmb);
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
                this.gDi.bem();
                this.gmb = this.glJ.getForum().getName();
                this.forumId = this.glJ.getForum().getId();
                if (this.glJ != null && this.glJ.getForum() != null) {
                    this.gDi.a(this.glJ.getForum().getThemeColorInfo());
                    this.gDi.c(this.glJ);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.glJ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.glJ.getUserData().getBimg_end_time());
                bCB();
                if (!this.gDi.bHg().p(bj.cNw)) {
                    this.glJ.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.glJ.getThreadList();
                if (threadList != null) {
                    this.gDi.a(threadList, this.mPn, this.glJ, this.glJ.getPage().ayR());
                    bHb();
                    this.gDi.bHe();
                    if (this.glJ.getIsNewUrl() == 1) {
                        this.gDi.bHg().setFromCDN(true);
                    } else {
                        this.gDi.bHg().setFromCDN(false);
                    }
                    this.gDi.setListViewSelection(bN(bHc().getType(), this.mPn));
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
            this.gDi.bHg().b(threadList, this.glJ);
            this.gDi.bHg().notifyDataSetChanged();
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
        if (this.gDi == null) {
            return null;
        }
        return this.gDi.getListView();
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
        if (this.glJ != null && this.gDi != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.gDi.bDo();
            }
        }
    }

    private void bHb() {
        HashMap<Integer, bj> bFw;
        if (this.gDi != null && this.gDi.bHg() != null && (bFw = this.gDi.bHg().bFw()) != null) {
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
        if (j.isNetWorkAvailable()) {
            lS(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bCK() {
        return this.glJ;
    }

    public FrsGoodModelController bHc() {
        return this.gDg;
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

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.gDi.bbc();
        } else if (!this.gDg.bHl()) {
            this.gDi.bbc();
        } else {
            bac();
            if (!this.gDh.isLoading && !this.gDg.isLoading()) {
                if (this.gDh.cr(this.glJ.getThreadListIds())) {
                    this.gDi.a(this.gDh.bHv(), this.mPn, this.glJ, 0);
                    this.gDh.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.glJ.getThreadListIds(), this.gmb, this.mPn, this.glJ.isBrandForum);
                } else if (this.fpy != 0) {
                    this.gDi.a(this.gDh.bHv(), this.mPn, this.glJ, 0);
                    this.mPn++;
                    this.gDg.tE(this.mPn);
                    this.gDh.loadingDone = false;
                    this.gDh.loadIndex = 0;
                }
            }
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.gDh.a(false, false, false, arrayList, (f) null)) != null) {
            this.glJ.setThreadList(a);
            this.gDi.a(a, this.mPn, this.glJ, 0);
        }
    }

    private void bac() {
        if (this.fpy == 0 && !this.gDh.cr(this.glJ.getThreadListIds())) {
            if (this.glJ.getThreadList() == null || this.glJ.getThreadList().size() == 0) {
                this.gDi.bbc();
                return;
            } else {
                this.gDi.bbb();
                return;
            }
        }
        this.gDi.bba();
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
        if (this.gDg != null) {
            this.gDg.bCE();
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.glJ != null) {
            i = this.glJ.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.ub(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tD(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            lS(false);
        } else {
            c((e.b) null);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void scrollToTop() {
        if (this.gDi != null && this.gDi.getListView() != null) {
            this.gDi.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void baZ() {
        if (this.gDi != null) {
            scrollToTop();
            this.gDi.startPullRefresh();
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
}
