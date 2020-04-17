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
import com.baidu.adp.widget.ListView.v;
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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.c;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
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
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0100a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, al, am, an, com.baidu.tieba.frs.loadmore.a, m, FrsCommonImageLayout.c {
    private VoiceManager gYp;
    private c hde;
    private String hpI;
    private FrsGoodModelController hpK;
    private FrsLoadMoreModel hpL;
    private com.baidu.tieba.frs.gametab.b hpN;
    private String mForumId;
    private String gYi = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean hpJ = false;
    private String forumId = null;
    private FrsViewData gXO = new FrsViewData();
    public long gAV = -1;
    public long edE = 0;
    public long edO = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean gYA = false;
    protected a hpM = null;
    private int fXj = -1;
    private int mTabId = 0;
    private int hfL = 3;
    private boolean guT = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gYN = new SparseArray<>();
    private boolean hpO = false;
    private int cCF = 0;
    private int gZl = 0;
    private CustomMessageListener hbp = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.hde != null && FrsGoodFragment.this.hde.isViewAttached()) {
                FrsGoodFragment.this.hde.mQ(num.intValue());
            }
        }
    };
    private Runnable hpP = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.guT) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.ne(false);
            }
        }
    };
    private CustomMessageListener hpQ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                FrsGoodFragment.this.hpI = bjVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.hpI) && bjVar.aKp() != null) {
                    FrsGoodFragment.this.ul(bjVar.aKp().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener gZo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.aQI() != null) {
                        FrsGoodFragment.this.aQI().setSelection(0);
                    }
                    if (FrsGoodFragment.this.hde != null && FrsGoodFragment.this.hde.isViewAttached()) {
                        FrsGoodFragment.this.ne(false);
                    } else if (FrsGoodFragment.this.hpM != null) {
                        FrsGoodFragment.this.hpM.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final q gZD = new q() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long hpT = 1;

        @Override // com.baidu.tieba.tbadkCore.q
        public void tf(int i) {
            if (!FrsGoodFragment.this.hpO) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.hpM.bPE();
                        return;
                    case 3:
                        FrsGoodFragment.this.hpM.it(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void a(int i, boolean z, f fVar) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (FrsGoodFragment.this.hpO) {
                if (FrsGoodFragment.this.bTp().bTw() == null) {
                    FrsGoodFragment.this.hpO = false;
                    return;
                } else if (FrsGoodFragment.this.bTp().bTw().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.hpO = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.hpT = 1L;
            } else if (fVar.isSuccess) {
                this.hpT = 0L;
            } else {
                this.hpT = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.hpL.resetData();
            }
            FrsGoodFragment.this.hpM.it(false);
            if (FrsGoodFragment.this.bTp().bTw() != null) {
                FrsGoodFragment.this.gXO = FrsGoodFragment.this.bTp().bTw();
            }
            FrsGoodFragment.this.fXj = FrsGoodFragment.this.gXO.getPage().aJA();
            if (FrsGoodFragment.this.fXj == 0 && (FrsGoodFragment.this.gXO.getThreadListIds() == null || FrsGoodFragment.this.gXO.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.gXO.getThreadList() == null || FrsGoodFragment.this.gXO.getThreadList().size() == 0) {
                    FrsGoodFragment.this.hpM.bmq();
                } else {
                    FrsGoodFragment.this.hpM.bmp();
                }
            } else {
                FrsGoodFragment.this.hpM.bmo();
            }
            if (i == 4) {
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsGoodFragment.this.hpL.a(false, false, false, FrsGoodFragment.this.gXO.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.gXO.setThreadList(a2);
                    FrsGoodFragment.this.hpM.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.gXO, FrsGoodFragment.this.fXj);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.hpM.bPE();
                    break;
                case 2:
                    FrsGoodFragment.this.hpM.bPE();
                    break;
                case 3:
                    if (FrsGoodFragment.this.gXO.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.hpT != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.gXO != null) {
                    FrsGoodFragment.this.gYi = FrsGoodFragment.this.gXO.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.gXO.getForum().getId();
                    FrsGoodFragment.this.hpM.b(FrsGoodFragment.this.gXO.getForum(), FrsGoodFragment.this.gXO.getUserData());
                }
                if (FrsGoodFragment.this.gXO != null) {
                    FrsGoodFragment.this.gXO.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.hpM.c(FrsGoodFragment.this.gXO);
                if (FrsGoodFragment.this.gXO == null || FrsGoodFragment.this.gXO.getThreadList() == null || FrsGoodFragment.this.gXO.getThreadList().size() != 0 || FrsGoodFragment.this.bTp().getType() != 4) {
                    if (FrsGoodFragment.this.gXO != null && (a = FrsGoodFragment.this.hpL.a(false, false, true, FrsGoodFragment.this.gXO.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.gXO.setThreadList(a);
                    }
                    FrsGoodFragment.this.bOQ();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.gAV > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.gAV, FrsGoodFragment.this.bTp().bIY() - FrsGoodFragment.this.gAV, FrsGoodFragment.this.bTp().bIW(), FrsGoodFragment.this.bTp().bIX(), currentTimeMillis2 - FrsGoodFragment.this.bTp().bIV());
                        FrsGoodFragment.this.gAV = -1L;
                    }
                    FrsGoodFragment.this.edO = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.gAV > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.gAV, FrsGoodFragment.this.bTp().bIY() - FrsGoodFragment.this.gAV, FrsGoodFragment.this.bTp().bIW(), FrsGoodFragment.this.bTp().bIX(), currentTimeMillis3 - FrsGoodFragment.this.bTp().bIV());
                FrsGoodFragment.this.gAV = -1L;
            }
            FrsGoodFragment.this.edO = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }
    };
    private final CustomMessageListener dkZ = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.hpM != null) {
                FrsGoodFragment.this.hpM.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.gYA) {
                FrsGoodFragment.this.gYA = true;
                FrsGoodFragment.this.hpM.bPT();
            }
            if (i == 0) {
                r.bEY().lx(true);
                com.baidu.tieba.s.c.cVr().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.gZl += i2;
            if (FrsGoodFragment.this.gZl >= FrsGoodFragment.this.cCF * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener dOK = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private v gZK = new v() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.v
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bi)) {
                bj bjVar = ((bi) mVar).dqA;
                if (bjVar.aLB() == null || bjVar.aLB().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bjVar.aLo() != 1 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.KY(bjVar.getId())) {
                            readThreadHistory.KX(bjVar.getId());
                            if (FrsGoodFragment.this.hpM != null) {
                                FrsGoodFragment.this.hpM.bPE();
                            }
                        }
                        boolean z = false;
                        final String aKL = bjVar.aKL();
                        if (aKL != null && !aKL.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aKL);
                                    xVar.aOy().aOZ().mIsNeedAddCommenParam = false;
                                    xVar.aOy().aOZ().mIsUseCurrentBDUSS = false;
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
                        if (bjVar.aKz() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aOY().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3) {
                            bjVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, FrsGoodFragment.this.gYi, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.gXO != null && FrsGoodFragment.this.gXO.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.htU = FrsGoodFragment.this.gXO.needLog == 1;
                            bVar.htW = FrsGoodFragment.this.gXO.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.hgG != null) {
                                bVar.htX = com.baidu.tieba.frs.d.d.hgG.htX;
                                bVar.htY = com.baidu.tieba.frs.d.d.hgG.htY;
                            }
                            com.baidu.tieba.frs.d.a.a(bjVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gZO = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.hpM != null) {
                FrsGoodFragment.this.hpM.wK();
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
        this.hpM.mO(false);
        showLoadingView(this.hpM.bCt(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.hpM.mO(true);
        hideLoadingView(this.hpM.bCt());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.hpM.mO(false);
        this.hpM.mN(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hpM.bmq();
        this.hpM.getListView().getData().clear();
        this.hpM.bPE();
        if (this.hde == null) {
            this.hde = new c(getPageContext().getContext(), getNetRefreshListener());
            this.hde.setTitle(null);
            this.hde.setButtonText(null);
            this.hde.showRefreshButton();
            this.hde.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hde.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hde.setSubText(null);
        }
        this.hde.onChangeSkinType();
        this.hde.attachView(this.hpM.bCt(), true);
        registerListener(this.hbp);
    }

    private void blt() {
        this.hpM.mO(true);
        this.hpM.mN(true);
        if (this.hde != null && this.hde.isViewAttached()) {
            this.hde.dettachView(this.hpM.bCt());
        }
        MessageManager.getInstance().unRegisterListener(this.hbp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(boolean z) {
        this.guT = true;
        bOT();
        blt();
        if (!z) {
            blt();
            showLoadingView();
        }
        this.hpK.pa(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gAV = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.gAV = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.edE = this.beginTime - this.gAV;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cVr().w(getUniqueId());
        this.hpK = new FrsGoodModelController(this);
        if (arguments != null) {
            this.hpK.ad(arguments);
            this.hpJ = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.hpK.ad(bundle);
            this.hpJ = bundle.getBoolean("is_game_frs", false);
        } else {
            this.hpK.ad(null);
        }
        this.gYp = getVoiceManager();
        this.gYp.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dkZ);
        registerListener(this.hpQ);
        registerListener(this.gZo);
        registerListener(this.gZO);
        this.hpL = new FrsLoadMoreModel(this, null);
        this.hpL.registerListener();
        this.hpL.setPageType(2);
        this.hpL.ng(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cCF = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.hpM = new a(this, inflate, this.hpJ);
        this.hpM.bTt().bTz();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.guT) {
            if (j.isNetWorkAvailable()) {
                ne(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cI("fid", this.mForumId).cI("obj_type", "7").af("obj_locate", 2).cI("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.gYp = getVoiceManager();
        this.gYp.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bTm();
        if (bundle != null) {
            this.gYi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.gYi = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bTm() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dOK);
    }

    public FrsLoadMoreModel bTn() {
        return this.hpL;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hpM != null) {
            this.hpM.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hbp);
        com.baidu.tieba.s.c.cVr().x(getUniqueId());
        r.bEY().lx(false);
        super.onDestroy();
        this.hpK.aqT();
        this.gYp = getVoiceManager();
        this.gYp.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hpP);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.gYi);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.hpJ);
        this.hpK.onSaveInstanceState(bundle);
        this.gYp = getVoiceManager();
        if (this.gYp != null) {
            this.gYp.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bj threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.hpM.bTt().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.gXO.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.jT(intent.getIntExtra("good_data", 0));
                            threadDataById.aLz();
                            ne(false);
                            return;
                        } else if (intExtra == 0) {
                            this.gXO.removeThreadData(threadDataById);
                            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXO.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new p());
                            }
                            this.hpM.bTr();
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
            if (this.hfL == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.guT) {
                com.baidu.adp.lib.f.e.lb().post(this.hpP);
            }
        }
        bQJ();
    }

    private void bQJ() {
        if (isPrimary()) {
            if (this.hde != null && this.hde.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hbp);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hbp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hpM != null) {
            this.hpM.bPE();
        }
        this.gYp = getVoiceManager();
        this.gYp.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.hpN = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.hpM.a(this.gZK);
        this.hpM.setOnScrollListener(this.mScrollListener);
        this.hpM.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.hpN != null) {
                    FrsGoodFragment.this.hpN.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hfL != 3 || this.hpM != null) {
            this.hfL = i;
            super.onChangeSkinType(i);
            if (this.hpM != null) {
                this.hpM.onChangeSkinType(i);
            }
            if (this.hde != null && this.hde.isViewAttached()) {
                this.hde.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bNP() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bNP();
        }
        return null;
    }

    private void bOP() {
        switch (this.mFlag) {
            case 1:
                h.lc().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.KS(FrsGoodFragment.this.gYi);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOQ() {
        bOT();
        try {
            if (this.gXO != null) {
                this.hpM.bQT();
                this.hpM.bpV();
                this.gYi = this.gXO.getForum().getName();
                this.forumId = this.gXO.getForum().getId();
                if (this.gXO != null && this.gXO.getForum() != null) {
                    this.hpM.a(this.gXO.getForum().getThemeColorInfo());
                    this.hpM.c(this.gXO);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.gXO.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.gXO.getUserData().getBimg_end_time());
                bOP();
                if (!this.hpM.bTt().p(bj.dqW)) {
                    this.gXO.removeAlaLiveThreadData();
                }
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXO.getThreadList();
                if (threadList != null) {
                    this.hpM.a(threadList, this.mPn, this.gXO, this.gXO.getPage().aJA());
                    bTo();
                    this.hpM.bTr();
                    if (this.gXO.getIsNewUrl() == 1) {
                        this.hpM.bTt().setFromCDN(true);
                    } else {
                        this.hpM.bTt().setFromCDN(false);
                    }
                    this.hpM.setListViewSelection(bV(bTp().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int bV(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gYp = getVoiceManager();
        this.gYp.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        r.bEY().lx(false);
        com.baidu.tieba.s.c.cVr().b(getUniqueId(), false);
        if (this.gXO != null && this.gXO.getForum() != null) {
            com.baidu.tbadk.distribute.a.aWD().a(getPageContext().getPageActivity(), "frs", this.gXO.getForum().getId(), 0L);
        }
        this.gYp = getVoiceManager();
        if (this.gYp != null) {
            this.gYp.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul(int i) {
        ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXO.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).dqA;
                    if (bjVar.getId() != null && bjVar.getId().equals(this.hpI)) {
                        c(bjVar, i);
                        this.hpI = null;
                        break;
                    }
                }
            }
            this.hpM.bTt().b(threadList, this.gXO);
            this.hpM.bTt().notifyDataSetChanged();
        }
    }

    private void c(bj bjVar, int i) {
        if (i == 1) {
            PraiseData aKp = bjVar.aKp();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aKp == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bjVar.a(praiseData);
                    return;
                }
                bjVar.aKp().getUser().add(0, metaData);
                bjVar.aKp().setNum(bjVar.aKp().getNum() + 1);
                bjVar.aKp().setIsLike(i);
            }
        } else if (bjVar.aKp() != null) {
            bjVar.aKp().setIsLike(i);
            bjVar.aKp().setNum(bjVar.aKp().getNum() - 1);
            ArrayList<MetaData> user = bjVar.aKp().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bjVar.aKp().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gYp == null) {
            this.gYp = VoiceManager.instance();
        }
        return this.gYp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aQI() {
        if (this.hpM == null) {
            return null;
        }
        return this.hpM.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bOT() {
        this.gYp = getVoiceManager();
        this.gYp.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aQJ() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aQJ();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.gXO != null && this.hpM != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.hpM.bPE();
            }
        }
    }

    private void bTo() {
        HashMap<Integer, bj> bRR;
        if (this.hpM != null && this.hpM.bTt() != null && (bRR = this.hpM.bTt().bRR()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bj> entry : bRR.entrySet()) {
                bj value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.aWJ().E(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (aQI() == null) {
            return null;
        }
        return aQI().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            ne(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bOY() {
        return this.gXO;
    }

    public FrsGoodModelController bTp() {
        return this.hpK;
    }

    public void Dk(String str) {
        this.gYi = str;
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
            this.hpM.bmq();
        } else if (!this.hpK.bTy()) {
            this.hpM.bmq();
        } else {
            blq();
            if (!this.hpL.isLoading && !this.hpK.isLoading()) {
                if (this.hpL.cz(this.gXO.getThreadListIds())) {
                    this.hpM.a(this.hpL.bTJ(), this.mPn, this.gXO, 0);
                    this.hpL.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.gXO.getThreadListIds(), this.gYi, this.mPn, this.gXO.isBrandForum);
                } else if (this.fXj != 0) {
                    this.hpM.a(this.hpL.bTJ(), this.mPn, this.gXO, 0);
                    this.mPn++;
                    this.hpK.un(this.mPn);
                    this.hpL.loadingDone = false;
                    this.hpL.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        blq();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void an(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.m> a;
        blq();
        if (arrayList != null && arrayList.size() != 0 && (a = this.hpL.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.gXO.setThreadList(a);
            this.hpM.a(a, this.mPn, this.gXO, 0);
        }
    }

    private void blq() {
        if (this.fXj == 0 && !this.hpL.cz(this.gXO.getThreadListIds())) {
            if (this.gXO.getThreadList() == null || this.gXO.getThreadList().size() == 0) {
                this.hpM.bmq();
                return;
            } else {
                this.hpM.bmp();
                return;
            }
        }
        this.hpM.bmo();
    }

    @Override // android.support.v4.app.Fragment, com.baidu.h.a.a.InterfaceC0100a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.checkCamera(getActivity().getApplicationContext())) {
                com.baidu.tbadk.core.util.al.e(getPageContext());
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
        com.baidu.tbadk.distribute.a.aWD().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.m
    public void bOS() {
        if (this.hpK != null) {
            this.hpK.bOS();
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
    public NavigationBar boh() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.gYi;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.gXO != null) {
            i = this.gXO.getSortType();
        }
        tbPageTag.sortType = g.uK(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void um(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            ne(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bOe() {
        if (this.hpM != null && this.hpM.getListView() != null) {
            this.hpM.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bmn() {
        if (this.hpM != null) {
            bOe();
            this.hpM.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.gYN.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oh(int i) {
        return this.gYN.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.an
    public void aQn() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bfP().yb("page_frs_good");
            ne(true);
            return;
        }
        this.hpM.it(false);
    }

    @Override // com.baidu.tieba.frs.an
    public void aQo() {
        com.baidu.tieba.s.c.cVr().b(getUniqueId(), false);
    }
}
