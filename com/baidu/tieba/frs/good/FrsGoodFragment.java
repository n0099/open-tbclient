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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.x;
import com.baidu.h.a.a;
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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.c;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.f;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.tbadkCore.util.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0125a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, al, am, an, com.baidu.tieba.frs.loadmore.a, m, FrsCommonImageLayout.c {
    private String hFp;
    private FrsGoodModelController hFr;
    private FrsLoadMoreModel hFs;
    private com.baidu.tieba.frs.gametab.b hFu;
    private VoiceManager hns;
    private c hsj;
    private String mForumId;
    private String hnl = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean hFq = false;
    private String forumId = null;
    private FrsViewData hmR = new FrsViewData();
    public long gPV = -1;
    public long erW = 0;
    public long esg = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean hnD = false;
    protected a hFt = null;
    private int gmt = -1;
    private int mTabId = 0;
    private int huQ = 3;
    private boolean gJV = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hnQ = new SparseArray<>();
    private boolean hFv = false;
    private int cOy = 0;
    private int hoo = 0;
    private CustomMessageListener hqu = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.hsj != null && FrsGoodFragment.this.hsj.isViewAttached()) {
                FrsGoodFragment.this.hsj.nu(num.intValue());
            }
        }
    };
    private Runnable hFw = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.gJV) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.nz(false);
            }
        }
    };
    private CustomMessageListener hFx = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk)) {
                bk bkVar = (bk) customResponsedMessage.getData();
                FrsGoodFragment.this.hFp = bkVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.hFp) && bkVar.aQi() != null) {
                    FrsGoodFragment.this.uS(bkVar.aQi().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener hot = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.aWO() != null) {
                        FrsGoodFragment.this.aWO().setSelection(0);
                    }
                    if (FrsGoodFragment.this.hsj != null && FrsGoodFragment.this.hsj.isViewAttached()) {
                        FrsGoodFragment.this.nz(false);
                    } else if (FrsGoodFragment.this.hFt != null) {
                        FrsGoodFragment.this.hFt.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final q hoI = new q() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long hFA = 1;

        @Override // com.baidu.tieba.tbadkCore.q
        public void tM(int i) {
            if (!FrsGoodFragment.this.hFv) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.hFt.bWb();
                        return;
                    case 3:
                        FrsGoodFragment.this.hFt.iQ(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void a(int i, boolean z, f fVar) {
            ArrayList<o> a;
            if (FrsGoodFragment.this.hFv) {
                if (FrsGoodFragment.this.bZR().bZZ() == null) {
                    FrsGoodFragment.this.hFv = false;
                    return;
                } else if (FrsGoodFragment.this.bZR().bZZ().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.hFv = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.hFA = 1L;
            } else if (fVar.isSuccess) {
                this.hFA = 0L;
            } else {
                this.hFA = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.hFs.resetData();
            }
            FrsGoodFragment.this.hFt.iQ(false);
            if (FrsGoodFragment.this.bZR().bZZ() != null) {
                FrsGoodFragment.this.hmR = FrsGoodFragment.this.bZR().bZZ();
            }
            FrsGoodFragment.this.gmt = FrsGoodFragment.this.hmR.getPage().aPt();
            if (FrsGoodFragment.this.gmt == 0 && (FrsGoodFragment.this.hmR.getThreadListIds() == null || FrsGoodFragment.this.hmR.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.hmR.getThreadList() == null || FrsGoodFragment.this.hmR.getThreadList().size() == 0) {
                    FrsGoodFragment.this.hFt.brO();
                } else {
                    FrsGoodFragment.this.hFt.brN();
                }
            } else {
                FrsGoodFragment.this.hFt.brM();
            }
            if (i == 4) {
                ArrayList<o> a2 = FrsGoodFragment.this.hFs.a(false, false, false, FrsGoodFragment.this.hmR.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.hmR.setThreadList(a2);
                    FrsGoodFragment.this.hFt.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.hmR, FrsGoodFragment.this.gmt);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.hFt.bWb();
                    break;
                case 2:
                    FrsGoodFragment.this.hFt.bWb();
                    break;
                case 3:
                    if (FrsGoodFragment.this.hmR.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.hFA != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.hmR != null) {
                    FrsGoodFragment.this.hnl = FrsGoodFragment.this.hmR.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.hmR.getForum().getId();
                    FrsGoodFragment.this.hFt.b(FrsGoodFragment.this.hmR.getForum(), FrsGoodFragment.this.hmR.getUserData());
                }
                if (FrsGoodFragment.this.hmR != null) {
                    FrsGoodFragment.this.hmR.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.hFt.c(FrsGoodFragment.this.hmR);
                if (FrsGoodFragment.this.hmR == null || FrsGoodFragment.this.hmR.getThreadList() == null || FrsGoodFragment.this.hmR.getThreadList().size() != 0 || FrsGoodFragment.this.bZR().getType() != 4) {
                    if (FrsGoodFragment.this.hmR != null && (a = FrsGoodFragment.this.hFs.a(false, false, true, FrsGoodFragment.this.hmR.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.hmR.setThreadList(a);
                    }
                    FrsGoodFragment.this.bVm();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.gPV > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.gPV, FrsGoodFragment.this.bZR().bPs() - FrsGoodFragment.this.gPV, FrsGoodFragment.this.bZR().bPq(), FrsGoodFragment.this.bZR().bPr(), currentTimeMillis2 - FrsGoodFragment.this.bZR().bPp());
                        FrsGoodFragment.this.gPV = -1L;
                    }
                    FrsGoodFragment.this.esg = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.gPV > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.gPV, FrsGoodFragment.this.bZR().bPs() - FrsGoodFragment.this.gPV, FrsGoodFragment.this.bZR().bPq(), FrsGoodFragment.this.bZR().bPr(), currentTimeMillis3 - FrsGoodFragment.this.bZR().bPp());
                FrsGoodFragment.this.gPV = -1L;
            }
            FrsGoodFragment.this.esg = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }
    };
    private final CustomMessageListener dzd = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.hFt != null) {
                FrsGoodFragment.this.hFt.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.hnD) {
                FrsGoodFragment.this.hnD = true;
                FrsGoodFragment.this.hFt.bWq();
            }
            if (i == 0) {
                s.bLs().lT(true);
                com.baidu.tieba.s.c.dcI().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.hoo += i2;
            if (FrsGoodFragment.this.hoo >= FrsGoodFragment.this.cOy * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener edg = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private x hoP = new x() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.x
        public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && oVar != null && (oVar instanceof bj)) {
                bk bkVar = ((bj) oVar).dEA;
                if (bkVar.aRy() == null || bkVar.aRy().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bkVar.aRl() != 1 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.MP(bkVar.getId())) {
                            readThreadHistory.MO(bkVar.getId());
                            if (FrsGoodFragment.this.hFt != null) {
                                FrsGoodFragment.this.hFt.bWb();
                            }
                        }
                        boolean z = false;
                        final String aQE = bkVar.aQE();
                        if (aQE != null && !aQE.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aQE);
                                    xVar.aUA().aVb().mIsNeedAddCommenParam = false;
                                    xVar.aUA().aVb().mIsUseCurrentBDUSS = false;
                                    xVar.getNetData();
                                }
                            }).start();
                        }
                        String str = null;
                        if (bkVar != null) {
                            str = bkVar.getTid();
                        }
                        if (str == null) {
                            str = "";
                        }
                        if (bkVar.aQs() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aVa().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3) {
                            bkVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bkVar, FrsGoodFragment.this.hnl, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bkVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.hmR != null && FrsGoodFragment.this.hmR.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.hJA = FrsGoodFragment.this.hmR.needLog == 1;
                            bVar.hJC = FrsGoodFragment.this.hmR.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.hvL != null) {
                                bVar.hJD = com.baidu.tieba.frs.d.d.hvL.hJD;
                                bVar.hJE = com.baidu.tieba.frs.d.d.hvL.hJE;
                            }
                            com.baidu.tieba.frs.d.a.a(bkVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hoT = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.hFt != null) {
                FrsGoodFragment.this.hFt.ya();
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
        this.hFt.nj(false);
        showLoadingView(this.hFt.bIN(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.hFt.nj(true);
        hideLoadingView(this.hFt.bIN());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.hFt.nj(false);
        this.hFt.ni(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hFt.brO();
        this.hFt.getListView().getData().clear();
        this.hFt.bWb();
        if (this.hsj == null) {
            this.hsj = new c(getPageContext().getContext(), getNetRefreshListener());
            this.hsj.setTitle(null);
            this.hsj.setButtonText(null);
            this.hsj.showRefreshButton();
            this.hsj.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hsj.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hsj.setSubText(null);
        }
        this.hsj.onChangeSkinType();
        this.hsj.attachView(this.hFt.bIN(), true);
        registerListener(this.hqu);
    }

    private void bqQ() {
        this.hFt.nj(true);
        this.hFt.ni(true);
        if (this.hsj != null && this.hsj.isViewAttached()) {
            this.hsj.dettachView(this.hFt.bIN());
        }
        MessageManager.getInstance().unRegisterListener(this.hqu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(boolean z) {
        this.gJV = true;
        bVp();
        bqQ();
        if (!z) {
            bqQ();
            showLoadingView();
        }
        this.hFr.pD(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gPV = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.gPV = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.erW = this.beginTime - this.gPV;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dcI().z(getUniqueId());
        this.hFr = new FrsGoodModelController(this);
        if (arguments != null) {
            this.hFr.aj(arguments);
            this.hFq = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.hFr.aj(bundle);
            this.hFq = bundle.getBoolean("is_game_frs", false);
        } else {
            this.hFr.aj(null);
        }
        this.hns = getVoiceManager();
        this.hns.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dzd);
        registerListener(this.hFx);
        registerListener(this.hot);
        registerListener(this.hoT);
        this.hFs = new FrsLoadMoreModel(this, null);
        this.hFs.registerListener();
        this.hFs.setPageType(2);
        this.hFs.nB(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cOy = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.hFt = new a(this, inflate, this.hFq);
        this.hFt.bZV().cac();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.gJV) {
            if (j.isNetWorkAvailable()) {
                nz(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").dh("fid", this.mForumId).dh("obj_type", "7").ag("obj_locate", 2).dh("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hns = getVoiceManager();
        this.hns.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bZO();
        if (bundle != null) {
            this.hnl = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.hnl = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bZO() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.edg);
    }

    public FrsLoadMoreModel bZP() {
        return this.hFs;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hFt != null) {
            this.hFt.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hqu);
        com.baidu.tieba.s.c.dcI().A(getUniqueId());
        s.bLs().lT(false);
        super.onDestroy();
        this.hFr.bZX();
        this.hns = getVoiceManager();
        this.hns.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hFw);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hnl);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.hFq);
        this.hFr.onSaveInstanceState(bundle);
        this.hns = getVoiceManager();
        if (this.hns != null) {
            this.hns.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bk threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.hFt.bZV().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.hmR.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.kv(intent.getIntExtra("good_data", 0));
                            threadDataById.aRw();
                            nz(false);
                            return;
                        } else if (intExtra == 0) {
                            this.hmR.removeThreadData(threadDataById);
                            ArrayList<o> threadList = this.hmR.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new p());
                            }
                            this.hFt.bZT();
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
            if (this.huQ == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.gJV) {
                com.baidu.adp.lib.f.e.ld().post(this.hFw);
            }
        }
        bXg();
    }

    private void bXg() {
        if (isPrimary()) {
            if (this.hsj != null && this.hsj.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hqu);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hqu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hFt != null) {
            this.hFt.bWb();
        }
        this.hns = getVoiceManager();
        this.hns.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.hFu = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.hFt.a(this.hoP);
        this.hFt.setOnScrollListener(this.mScrollListener);
        this.hFt.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.hFu != null) {
                    FrsGoodFragment.this.hFu.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.huQ != 3 || this.hFt != null) {
            this.huQ = i;
            super.onChangeSkinType(i);
            if (this.hFt != null) {
                this.hFt.onChangeSkinType(i);
            }
            if (this.hsj != null && this.hsj.isViewAttached()) {
                this.hsj.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bUl() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bUl();
        }
        return null;
    }

    private void bVl() {
        switch (this.mFlag) {
            case 1:
                h.le().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.MJ(FrsGoodFragment.this.hnl);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVm() {
        bVp();
        try {
            if (this.hmR != null) {
                this.hFt.bXq();
                this.hFt.bvO();
                this.hnl = this.hmR.getForum().getName();
                this.forumId = this.hmR.getForum().getId();
                if (this.hmR != null && this.hmR.getForum() != null) {
                    this.hFt.a(this.hmR.getForum().getThemeColorInfo());
                    this.hFt.c(this.hmR);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.hmR.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hmR.getUserData().getBimg_end_time());
                bVl();
                if (!this.hFt.bZV().r(bk.dEW)) {
                    this.hmR.removeAlaLiveThreadData();
                }
                ArrayList<o> threadList = this.hmR.getThreadList();
                if (threadList != null) {
                    this.hFt.a(threadList, this.mPn, this.hmR, this.hmR.getPage().aPt());
                    bZQ();
                    this.hFt.bZT();
                    if (this.hmR.getIsNewUrl() == 1) {
                        this.hFt.bZV().setFromCDN(true);
                    } else {
                        this.hFt.bZV().setFromCDN(false);
                    }
                    this.hFt.setListViewSelection(ca(bZR().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int ca(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hns = getVoiceManager();
        this.hns.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.bLs().lT(false);
        com.baidu.tieba.s.c.dcI().b(getUniqueId(), false);
        if (this.hmR != null && this.hmR.getForum() != null) {
            com.baidu.tbadk.distribute.a.bcL().b(getPageContext().getPageActivity(), "frs", this.hmR.getForum().getId(), 0L);
        }
        this.hns = getVoiceManager();
        if (this.hns != null) {
            this.hns.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(int i) {
        ArrayList<o> threadList = this.hmR.getThreadList();
        if (threadList != null) {
            Iterator<o> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next instanceof bj) {
                    bk bkVar = ((bj) next).dEA;
                    if (bkVar.getId() != null && bkVar.getId().equals(this.hFp)) {
                        c(bkVar, i);
                        this.hFp = null;
                        break;
                    }
                }
            }
            this.hFt.bZV().b(threadList, this.hmR);
            this.hFt.bZV().notifyDataSetChanged();
        }
    }

    private void c(bk bkVar, int i) {
        if (i == 1) {
            PraiseData aQi = bkVar.aQi();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aQi == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bkVar.a(praiseData);
                    return;
                }
                bkVar.aQi().getUser().add(0, metaData);
                bkVar.aQi().setNum(bkVar.aQi().getNum() + 1);
                bkVar.aQi().setIsLike(i);
            }
        } else if (bkVar.aQi() != null) {
            bkVar.aQi().setIsLike(i);
            bkVar.aQi().setNum(bkVar.aQi().getNum() - 1);
            ArrayList<MetaData> user = bkVar.aQi().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bkVar.aQi().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hns == null) {
            this.hns = VoiceManager.instance();
        }
        return this.hns;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aWO() {
        if (this.hFt == null) {
            return null;
        }
        return this.hFt.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bVp() {
        this.hns = getVoiceManager();
        this.hns.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aWP() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aWP();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.hmR != null && this.hFt != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.hFt.bWb();
            }
        }
    }

    private void bZQ() {
        HashMap<Integer, bk> bYp;
        if (this.hFt != null && this.hFt.bZV() != null && (bYp = this.hFt.bZV().bYp()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bk> entry : bYp.entrySet()) {
                bk value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bcR().E(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public r onGetPreLoadListView() {
        if (aWO() == null) {
            return null;
        }
        return aWO().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            nz(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bVu() {
        return this.hmR;
    }

    public FrsGoodModelController bZR() {
        return this.hFr;
    }

    public void EW(String str) {
        this.hnl = str;
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
            this.hFt.brO();
        } else if (!this.hFr.cab()) {
            this.hFt.brO();
        } else {
            bqM();
            if (!this.hFs.isLoading && !this.hFr.isLoading()) {
                if (this.hFs.cx(this.hmR.getThreadListIds())) {
                    this.hFt.a(this.hFs.cam(), this.mPn, this.hmR, 0);
                    this.hFs.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.hmR.getThreadListIds(), this.hnl, this.mPn, this.hmR.isBrandForum);
                } else if (this.gmt != 0) {
                    this.hFt.a(this.hFs.cam(), this.mPn, this.hmR, 0);
                    this.mPn++;
                    this.hFr.uU(this.mPn);
                    this.hFs.loadingDone = false;
                    this.hFs.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bqM();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void an(ArrayList<o> arrayList) {
        ArrayList<o> a;
        bqM();
        if (arrayList != null && arrayList.size() != 0 && (a = this.hFs.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.hmR.setThreadList(a);
            this.hFt.a(a, this.mPn, this.hmR, 0);
        }
    }

    private void bqM() {
        if (this.gmt == 0 && !this.hFs.cx(this.hmR.getThreadListIds())) {
            if (this.hmR.getThreadList() == null || this.hmR.getThreadList().size() == 0) {
                this.hFt.brO();
                return;
            } else {
                this.hFt.brN();
                return;
            }
        }
        this.hFt.brM();
    }

    @Override // android.support.v4.app.Fragment, com.baidu.h.a.a.InterfaceC0125a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.checkCamera(getActivity().getApplicationContext())) {
                com.baidu.tbadk.core.util.al.d(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.m
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bcL().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.m
    public void bVo() {
        if (this.hFr != null) {
            this.hFr.bVo();
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.m
    public int getPageNum() {
        return this.mPn;
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar bua() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hnl;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hmR != null) {
            i = this.hmR.getSortType();
        }
        tbPageTag.sortType = g.vs(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uT(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            nz(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bUA() {
        if (this.hFt != null && this.hFt.getListView() != null) {
            this.hFt.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void brL() {
        if (this.hFt != null) {
            bUA();
            this.hFt.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hnQ.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oO(int i) {
        return this.hnQ.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.an
    public void aWp() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bmb().zK("page_frs_good");
            nz(true);
            return;
        }
        this.hFt.iQ(false);
    }

    @Override // com.baidu.tieba.frs.an
    public void aWq() {
        com.baidu.tieba.s.c.dcI().b(getUniqueId(), false);
    }
}
