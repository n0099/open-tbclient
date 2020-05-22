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
    private String hEC;
    private FrsGoodModelController hEE;
    private FrsLoadMoreModel hEF;
    private com.baidu.tieba.frs.gametab.b hEH;
    private VoiceManager hnh;
    private c hrY;
    private String mForumId;
    private String hna = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean hED = false;
    private String forumId = null;
    private FrsViewData hmG = new FrsViewData();
    public long gPK = -1;
    public long erW = 0;
    public long esg = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean hns = false;
    protected a hEG = null;
    private int gmi = -1;
    private int mTabId = 0;
    private int huF = 3;
    private boolean gJK = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hnF = new SparseArray<>();
    private boolean hEI = false;
    private int cOy = 0;
    private int hod = 0;
    private CustomMessageListener hqj = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.hrY != null && FrsGoodFragment.this.hrY.isViewAttached()) {
                FrsGoodFragment.this.hrY.ns(num.intValue());
            }
        }
    };
    private Runnable hEJ = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.gJK) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.nz(false);
            }
        }
    };
    private CustomMessageListener hEK = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk)) {
                bk bkVar = (bk) customResponsedMessage.getData();
                FrsGoodFragment.this.hEC = bkVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.hEC) && bkVar.aQi() != null) {
                    FrsGoodFragment.this.uQ(bkVar.aQi().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener hoi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.aWN() != null) {
                        FrsGoodFragment.this.aWN().setSelection(0);
                    }
                    if (FrsGoodFragment.this.hrY != null && FrsGoodFragment.this.hrY.isViewAttached()) {
                        FrsGoodFragment.this.nz(false);
                    } else if (FrsGoodFragment.this.hEG != null) {
                        FrsGoodFragment.this.hEG.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final q hox = new q() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long hEN = 1;

        @Override // com.baidu.tieba.tbadkCore.q
        public void tK(int i) {
            if (!FrsGoodFragment.this.hEI) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.hEG.bVZ();
                        return;
                    case 3:
                        FrsGoodFragment.this.hEG.iQ(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void a(int i, boolean z, f fVar) {
            ArrayList<o> a;
            if (FrsGoodFragment.this.hEI) {
                if (FrsGoodFragment.this.bZJ().bZR() == null) {
                    FrsGoodFragment.this.hEI = false;
                    return;
                } else if (FrsGoodFragment.this.bZJ().bZR().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.hEI = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.hEN = 1L;
            } else if (fVar.isSuccess) {
                this.hEN = 0L;
            } else {
                this.hEN = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.hEF.resetData();
            }
            FrsGoodFragment.this.hEG.iQ(false);
            if (FrsGoodFragment.this.bZJ().bZR() != null) {
                FrsGoodFragment.this.hmG = FrsGoodFragment.this.bZJ().bZR();
            }
            FrsGoodFragment.this.gmi = FrsGoodFragment.this.hmG.getPage().aPt();
            if (FrsGoodFragment.this.gmi == 0 && (FrsGoodFragment.this.hmG.getThreadListIds() == null || FrsGoodFragment.this.hmG.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.hmG.getThreadList() == null || FrsGoodFragment.this.hmG.getThreadList().size() == 0) {
                    FrsGoodFragment.this.hEG.brM();
                } else {
                    FrsGoodFragment.this.hEG.brL();
                }
            } else {
                FrsGoodFragment.this.hEG.brK();
            }
            if (i == 4) {
                ArrayList<o> a2 = FrsGoodFragment.this.hEF.a(false, false, false, FrsGoodFragment.this.hmG.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.hmG.setThreadList(a2);
                    FrsGoodFragment.this.hEG.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.hmG, FrsGoodFragment.this.gmi);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.hEG.bVZ();
                    break;
                case 2:
                    FrsGoodFragment.this.hEG.bVZ();
                    break;
                case 3:
                    if (FrsGoodFragment.this.hmG.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.hEN != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.hmG != null) {
                    FrsGoodFragment.this.hna = FrsGoodFragment.this.hmG.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.hmG.getForum().getId();
                    FrsGoodFragment.this.hEG.b(FrsGoodFragment.this.hmG.getForum(), FrsGoodFragment.this.hmG.getUserData());
                }
                if (FrsGoodFragment.this.hmG != null) {
                    FrsGoodFragment.this.hmG.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.hEG.c(FrsGoodFragment.this.hmG);
                if (FrsGoodFragment.this.hmG == null || FrsGoodFragment.this.hmG.getThreadList() == null || FrsGoodFragment.this.hmG.getThreadList().size() != 0 || FrsGoodFragment.this.bZJ().getType() != 4) {
                    if (FrsGoodFragment.this.hmG != null && (a = FrsGoodFragment.this.hEF.a(false, false, true, FrsGoodFragment.this.hmG.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.hmG.setThreadList(a);
                    }
                    FrsGoodFragment.this.bVk();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.gPK > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.gPK, FrsGoodFragment.this.bZJ().bPq() - FrsGoodFragment.this.gPK, FrsGoodFragment.this.bZJ().bPo(), FrsGoodFragment.this.bZJ().bPp(), currentTimeMillis2 - FrsGoodFragment.this.bZJ().bPn());
                        FrsGoodFragment.this.gPK = -1L;
                    }
                    FrsGoodFragment.this.esg = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.gPK > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.gPK, FrsGoodFragment.this.bZJ().bPq() - FrsGoodFragment.this.gPK, FrsGoodFragment.this.bZJ().bPo(), FrsGoodFragment.this.bZJ().bPp(), currentTimeMillis3 - FrsGoodFragment.this.bZJ().bPn());
                FrsGoodFragment.this.gPK = -1L;
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
            if (customResponsedMessage != null && FrsGoodFragment.this.hEG != null) {
                FrsGoodFragment.this.hEG.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.hns) {
                FrsGoodFragment.this.hns = true;
                FrsGoodFragment.this.hEG.bWo();
            }
            if (i == 0) {
                s.bLq().lT(true);
                com.baidu.tieba.s.c.dct().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.hod += i2;
            if (FrsGoodFragment.this.hod >= FrsGoodFragment.this.cOy * 2 && i2 < 0) {
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
    private x hoE = new x() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.x
        public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && oVar != null && (oVar instanceof bj)) {
                bk bkVar = ((bj) oVar).dEA;
                if (bkVar.aRy() == null || bkVar.aRy().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bkVar.aRl() != 1 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.MO(bkVar.getId())) {
                            readThreadHistory.MN(bkVar.getId());
                            if (FrsGoodFragment.this.hEG != null) {
                                FrsGoodFragment.this.hEG.bVZ();
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
                                    xVar.aUA().aVa().mIsNeedAddCommenParam = false;
                                    xVar.aUA().aVa().mIsUseCurrentBDUSS = false;
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
                            ba.aUZ().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3) {
                            bkVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bkVar, FrsGoodFragment.this.hna, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bkVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.hmG != null && FrsGoodFragment.this.hmG.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.hIN = FrsGoodFragment.this.hmG.needLog == 1;
                            bVar.hIP = FrsGoodFragment.this.hmG.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.hvA != null) {
                                bVar.hIQ = com.baidu.tieba.frs.d.d.hvA.hIQ;
                                bVar.hIR = com.baidu.tieba.frs.d.d.hvA.hIR;
                            }
                            com.baidu.tieba.frs.d.a.a(bkVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hoI = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.hEG != null) {
                FrsGoodFragment.this.hEG.ya();
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
        this.hEG.nj(false);
        showLoadingView(this.hEG.bIL(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.hEG.nj(true);
        hideLoadingView(this.hEG.bIL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.hEG.nj(false);
        this.hEG.ni(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hEG.brM();
        this.hEG.getListView().getData().clear();
        this.hEG.bVZ();
        if (this.hrY == null) {
            this.hrY = new c(getPageContext().getContext(), getNetRefreshListener());
            this.hrY.setTitle(null);
            this.hrY.setButtonText(null);
            this.hrY.showRefreshButton();
            this.hrY.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hrY.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hrY.setSubText(null);
        }
        this.hrY.onChangeSkinType();
        this.hrY.attachView(this.hEG.bIL(), true);
        registerListener(this.hqj);
    }

    private void bqO() {
        this.hEG.nj(true);
        this.hEG.ni(true);
        if (this.hrY != null && this.hrY.isViewAttached()) {
            this.hrY.dettachView(this.hEG.bIL());
        }
        MessageManager.getInstance().unRegisterListener(this.hqj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(boolean z) {
        this.gJK = true;
        bVn();
        bqO();
        if (!z) {
            bqO();
            showLoadingView();
        }
        this.hEE.pB(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gPK = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.gPK = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.erW = this.beginTime - this.gPK;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dct().z(getUniqueId());
        this.hEE = new FrsGoodModelController(this);
        if (arguments != null) {
            this.hEE.aj(arguments);
            this.hED = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.hEE.aj(bundle);
            this.hED = bundle.getBoolean("is_game_frs", false);
        } else {
            this.hEE.aj(null);
        }
        this.hnh = getVoiceManager();
        this.hnh.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dzd);
        registerListener(this.hEK);
        registerListener(this.hoi);
        registerListener(this.hoI);
        this.hEF = new FrsLoadMoreModel(this, null);
        this.hEF.registerListener();
        this.hEF.setPageType(2);
        this.hEF.nB(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cOy = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.hEG = new a(this, inflate, this.hED);
        this.hEG.bZN().bZU();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.gJK) {
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
        this.hnh = getVoiceManager();
        this.hnh.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bZG();
        if (bundle != null) {
            this.hna = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.hna = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bZG() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.edg);
    }

    public FrsLoadMoreModel bZH() {
        return this.hEF;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hEG != null) {
            this.hEG.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hqj);
        com.baidu.tieba.s.c.dct().A(getUniqueId());
        s.bLq().lT(false);
        super.onDestroy();
        this.hEE.bZP();
        this.hnh = getVoiceManager();
        this.hnh.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hEJ);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hna);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.hED);
        this.hEE.onSaveInstanceState(bundle);
        this.hnh = getVoiceManager();
        if (this.hnh != null) {
            this.hnh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bk threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.hEG.bZN().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.hmG.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.kt(intent.getIntExtra("good_data", 0));
                            threadDataById.aRw();
                            nz(false);
                            return;
                        } else if (intExtra == 0) {
                            this.hmG.removeThreadData(threadDataById);
                            ArrayList<o> threadList = this.hmG.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new p());
                            }
                            this.hEG.bZL();
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
            if (this.huF == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.gJK) {
                com.baidu.adp.lib.f.e.ld().post(this.hEJ);
            }
        }
        bXe();
    }

    private void bXe() {
        if (isPrimary()) {
            if (this.hrY != null && this.hrY.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hqj);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hqj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hEG != null) {
            this.hEG.bVZ();
        }
        this.hnh = getVoiceManager();
        this.hnh.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.hEH = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.hEG.a(this.hoE);
        this.hEG.setOnScrollListener(this.mScrollListener);
        this.hEG.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.hEH != null) {
                    FrsGoodFragment.this.hEH.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.huF != 3 || this.hEG != null) {
            this.huF = i;
            super.onChangeSkinType(i);
            if (this.hEG != null) {
                this.hEG.onChangeSkinType(i);
            }
            if (this.hrY != null && this.hrY.isViewAttached()) {
                this.hrY.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bUj() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bUj();
        }
        return null;
    }

    private void bVj() {
        switch (this.mFlag) {
            case 1:
                h.le().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.MI(FrsGoodFragment.this.hna);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVk() {
        bVn();
        try {
            if (this.hmG != null) {
                this.hEG.bXo();
                this.hEG.bvM();
                this.hna = this.hmG.getForum().getName();
                this.forumId = this.hmG.getForum().getId();
                if (this.hmG != null && this.hmG.getForum() != null) {
                    this.hEG.a(this.hmG.getForum().getThemeColorInfo());
                    this.hEG.c(this.hmG);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.hmG.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hmG.getUserData().getBimg_end_time());
                bVj();
                if (!this.hEG.bZN().r(bk.dEW)) {
                    this.hmG.removeAlaLiveThreadData();
                }
                ArrayList<o> threadList = this.hmG.getThreadList();
                if (threadList != null) {
                    this.hEG.a(threadList, this.mPn, this.hmG, this.hmG.getPage().aPt());
                    bZI();
                    this.hEG.bZL();
                    if (this.hmG.getIsNewUrl() == 1) {
                        this.hEG.bZN().setFromCDN(true);
                    } else {
                        this.hEG.bZN().setFromCDN(false);
                    }
                    this.hEG.setListViewSelection(ca(bZJ().getType(), this.mPn));
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
        this.hnh = getVoiceManager();
        this.hnh.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.bLq().lT(false);
        com.baidu.tieba.s.c.dct().b(getUniqueId(), false);
        if (this.hmG != null && this.hmG.getForum() != null) {
            com.baidu.tbadk.distribute.a.bcK().b(getPageContext().getPageActivity(), "frs", this.hmG.getForum().getId(), 0L);
        }
        this.hnh = getVoiceManager();
        if (this.hnh != null) {
            this.hnh.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ(int i) {
        ArrayList<o> threadList = this.hmG.getThreadList();
        if (threadList != null) {
            Iterator<o> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next instanceof bj) {
                    bk bkVar = ((bj) next).dEA;
                    if (bkVar.getId() != null && bkVar.getId().equals(this.hEC)) {
                        c(bkVar, i);
                        this.hEC = null;
                        break;
                    }
                }
            }
            this.hEG.bZN().b(threadList, this.hmG);
            this.hEG.bZN().notifyDataSetChanged();
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
        if (this.hnh == null) {
            this.hnh = VoiceManager.instance();
        }
        return this.hnh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aWN() {
        if (this.hEG == null) {
            return null;
        }
        return this.hEG.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bVn() {
        this.hnh = getVoiceManager();
        this.hnh.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aWO() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aWO();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.hmG != null && this.hEG != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.hEG.bVZ();
            }
        }
    }

    private void bZI() {
        HashMap<Integer, bk> bYm;
        if (this.hEG != null && this.hEG.bZN() != null && (bYm = this.hEG.bZN().bYm()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bk> entry : bYm.entrySet()) {
                bk value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bcQ().E(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public r onGetPreLoadListView() {
        if (aWN() == null) {
            return null;
        }
        return aWN().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            nz(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bVs() {
        return this.hmG;
    }

    public FrsGoodModelController bZJ() {
        return this.hEE;
    }

    public void EW(String str) {
        this.hna = str;
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
            this.hEG.brM();
        } else if (!this.hEE.bZT()) {
            this.hEG.brM();
        } else {
            bqK();
            if (!this.hEF.isLoading && !this.hEE.isLoading()) {
                if (this.hEF.cw(this.hmG.getThreadListIds())) {
                    this.hEG.a(this.hEF.cae(), this.mPn, this.hmG, 0);
                    this.hEF.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.hmG.getThreadListIds(), this.hna, this.mPn, this.hmG.isBrandForum);
                } else if (this.gmi != 0) {
                    this.hEG.a(this.hEF.cae(), this.mPn, this.hmG, 0);
                    this.mPn++;
                    this.hEE.uS(this.mPn);
                    this.hEF.loadingDone = false;
                    this.hEF.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bqK();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void an(ArrayList<o> arrayList) {
        ArrayList<o> a;
        bqK();
        if (arrayList != null && arrayList.size() != 0 && (a = this.hEF.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.hmG.setThreadList(a);
            this.hEG.a(a, this.mPn, this.hmG, 0);
        }
    }

    private void bqK() {
        if (this.gmi == 0 && !this.hEF.cw(this.hmG.getThreadListIds())) {
            if (this.hmG.getThreadList() == null || this.hmG.getThreadList().size() == 0) {
                this.hEG.brM();
                return;
            } else {
                this.hEG.brL();
                return;
            }
        }
        this.hEG.brK();
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
        com.baidu.tbadk.distribute.a.bcK().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.m
    public void bVm() {
        if (this.hEE != null) {
            this.hEE.bVm();
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
    public NavigationBar btY() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hna;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hmG != null) {
            i = this.hmG.getSortType();
        }
        tbPageTag.sortType = g.vq(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uR(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            nz(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bUy() {
        if (this.hEG != null && this.hEG.getListView() != null) {
            this.hEG.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void brJ() {
        if (this.hEG != null) {
            bUy();
            this.hEG.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hnF.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oM(int i) {
        return this.hnF.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.an
    public void aWo() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.blZ().zK("page_frs_good");
            nz(true);
            return;
        }
        this.hEG.iQ(false);
    }

    @Override // com.baidu.tieba.frs.an
    public void aWp() {
        com.baidu.tieba.s.c.dct().b(getUniqueId(), false);
    }
}
