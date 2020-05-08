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
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0121a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, al, am, an, com.baidu.tieba.frs.loadmore.a, m, FrsCommonImageLayout.c {
    private VoiceManager gYv;
    private c hdk;
    private String hpO;
    private FrsGoodModelController hpQ;
    private FrsLoadMoreModel hpR;
    private com.baidu.tieba.frs.gametab.b hpT;
    private String mForumId;
    private String gYo = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean hpP = false;
    private String forumId = null;
    private FrsViewData gXU = new FrsViewData();
    public long gBb = -1;
    public long edJ = 0;
    public long edT = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean gYG = false;
    protected a hpS = null;
    private int fXo = -1;
    private int mTabId = 0;
    private int hfR = 3;
    private boolean guZ = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gYT = new SparseArray<>();
    private boolean hpU = false;
    private int cCL = 0;
    private int gZr = 0;
    private CustomMessageListener hbv = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.hdk != null && FrsGoodFragment.this.hdk.isViewAttached()) {
                FrsGoodFragment.this.hdk.mQ(num.intValue());
            }
        }
    };
    private Runnable hpV = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.guZ) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.ne(false);
            }
        }
    };
    private CustomMessageListener hpW = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                FrsGoodFragment.this.hpO = bjVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.hpO) && bjVar.aKn() != null) {
                    FrsGoodFragment.this.ul(bjVar.aKn().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener gZu = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.aQF() != null) {
                        FrsGoodFragment.this.aQF().setSelection(0);
                    }
                    if (FrsGoodFragment.this.hdk != null && FrsGoodFragment.this.hdk.isViewAttached()) {
                        FrsGoodFragment.this.ne(false);
                    } else if (FrsGoodFragment.this.hpS != null) {
                        FrsGoodFragment.this.hpS.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final q gZJ = new q() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long hpZ = 1;

        @Override // com.baidu.tieba.tbadkCore.q
        public void tf(int i) {
            if (!FrsGoodFragment.this.hpU) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.hpS.bPC();
                        return;
                    case 3:
                        FrsGoodFragment.this.hpS.it(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void a(int i, boolean z, f fVar) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (FrsGoodFragment.this.hpU) {
                if (FrsGoodFragment.this.bTn().bTu() == null) {
                    FrsGoodFragment.this.hpU = false;
                    return;
                } else if (FrsGoodFragment.this.bTn().bTu().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.hpU = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.hpZ = 1L;
            } else if (fVar.isSuccess) {
                this.hpZ = 0L;
            } else {
                this.hpZ = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.hpR.resetData();
            }
            FrsGoodFragment.this.hpS.it(false);
            if (FrsGoodFragment.this.bTn().bTu() != null) {
                FrsGoodFragment.this.gXU = FrsGoodFragment.this.bTn().bTu();
            }
            FrsGoodFragment.this.fXo = FrsGoodFragment.this.gXU.getPage().aJy();
            if (FrsGoodFragment.this.fXo == 0 && (FrsGoodFragment.this.gXU.getThreadListIds() == null || FrsGoodFragment.this.gXU.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.gXU.getThreadList() == null || FrsGoodFragment.this.gXU.getThreadList().size() == 0) {
                    FrsGoodFragment.this.hpS.bmo();
                } else {
                    FrsGoodFragment.this.hpS.bmn();
                }
            } else {
                FrsGoodFragment.this.hpS.bmm();
            }
            if (i == 4) {
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsGoodFragment.this.hpR.a(false, false, false, FrsGoodFragment.this.gXU.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.gXU.setThreadList(a2);
                    FrsGoodFragment.this.hpS.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.gXU, FrsGoodFragment.this.fXo);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.hpS.bPC();
                    break;
                case 2:
                    FrsGoodFragment.this.hpS.bPC();
                    break;
                case 3:
                    if (FrsGoodFragment.this.gXU.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.hpZ != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.gXU != null) {
                    FrsGoodFragment.this.gYo = FrsGoodFragment.this.gXU.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.gXU.getForum().getId();
                    FrsGoodFragment.this.hpS.b(FrsGoodFragment.this.gXU.getForum(), FrsGoodFragment.this.gXU.getUserData());
                }
                if (FrsGoodFragment.this.gXU != null) {
                    FrsGoodFragment.this.gXU.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.hpS.c(FrsGoodFragment.this.gXU);
                if (FrsGoodFragment.this.gXU == null || FrsGoodFragment.this.gXU.getThreadList() == null || FrsGoodFragment.this.gXU.getThreadList().size() != 0 || FrsGoodFragment.this.bTn().getType() != 4) {
                    if (FrsGoodFragment.this.gXU != null && (a = FrsGoodFragment.this.hpR.a(false, false, true, FrsGoodFragment.this.gXU.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.gXU.setThreadList(a);
                    }
                    FrsGoodFragment.this.bOO();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.gBb > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.gBb, FrsGoodFragment.this.bTn().bIW() - FrsGoodFragment.this.gBb, FrsGoodFragment.this.bTn().bIU(), FrsGoodFragment.this.bTn().bIV(), currentTimeMillis2 - FrsGoodFragment.this.bTn().bIT());
                        FrsGoodFragment.this.gBb = -1L;
                    }
                    FrsGoodFragment.this.edT = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.gBb > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.gBb, FrsGoodFragment.this.bTn().bIW() - FrsGoodFragment.this.gBb, FrsGoodFragment.this.bTn().bIU(), FrsGoodFragment.this.bTn().bIV(), currentTimeMillis3 - FrsGoodFragment.this.bTn().bIT());
                FrsGoodFragment.this.gBb = -1L;
            }
            FrsGoodFragment.this.edT = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }
    };
    private final CustomMessageListener dld = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.hpS != null) {
                FrsGoodFragment.this.hpS.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.gYG) {
                FrsGoodFragment.this.gYG = true;
                FrsGoodFragment.this.hpS.bPR();
            }
            if (i == 0) {
                r.bEW().lx(true);
                com.baidu.tieba.s.c.cVo().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.gZr += i2;
            if (FrsGoodFragment.this.gZr >= FrsGoodFragment.this.cCL * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener dOP = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private v gZQ = new v() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.v
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bi)) {
                bj bjVar = ((bi) mVar).dqE;
                if (bjVar.aLz() == null || bjVar.aLz().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bjVar.aLm() != 1 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Lb(bjVar.getId())) {
                            readThreadHistory.La(bjVar.getId());
                            if (FrsGoodFragment.this.hpS != null) {
                                FrsGoodFragment.this.hpS.bPC();
                            }
                        }
                        boolean z = false;
                        final String aKJ = bjVar.aKJ();
                        if (aKJ != null && !aKJ.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aKJ);
                                    xVar.aOw().aOW().mIsNeedAddCommenParam = false;
                                    xVar.aOw().aOW().mIsUseCurrentBDUSS = false;
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
                        if (bjVar.aKx() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aOV().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3) {
                            bjVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, FrsGoodFragment.this.gYo, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.gXU != null && FrsGoodFragment.this.gXU.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.hua = FrsGoodFragment.this.gXU.needLog == 1;
                            bVar.huc = FrsGoodFragment.this.gXU.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.hgM != null) {
                                bVar.hud = com.baidu.tieba.frs.d.d.hgM.hud;
                                bVar.hue = com.baidu.tieba.frs.d.d.hgM.hue;
                            }
                            com.baidu.tieba.frs.d.a.a(bjVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gZU = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.hpS != null) {
                FrsGoodFragment.this.hpS.wJ();
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
        this.hpS.mO(false);
        showLoadingView(this.hpS.bCr(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.hpS.mO(true);
        hideLoadingView(this.hpS.bCr());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.hpS.mO(false);
        this.hpS.mN(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hpS.bmo();
        this.hpS.getListView().getData().clear();
        this.hpS.bPC();
        if (this.hdk == null) {
            this.hdk = new c(getPageContext().getContext(), getNetRefreshListener());
            this.hdk.setTitle(null);
            this.hdk.setButtonText(null);
            this.hdk.showRefreshButton();
            this.hdk.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hdk.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hdk.setSubText(null);
        }
        this.hdk.onChangeSkinType();
        this.hdk.attachView(this.hpS.bCr(), true);
        registerListener(this.hbv);
    }

    private void blr() {
        this.hpS.mO(true);
        this.hpS.mN(true);
        if (this.hdk != null && this.hdk.isViewAttached()) {
            this.hdk.dettachView(this.hpS.bCr());
        }
        MessageManager.getInstance().unRegisterListener(this.hbv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(boolean z) {
        this.guZ = true;
        bOR();
        blr();
        if (!z) {
            blr();
            showLoadingView();
        }
        this.hpQ.pa(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gBb = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.gBb = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.edJ = this.beginTime - this.gBb;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cVo().w(getUniqueId());
        this.hpQ = new FrsGoodModelController(this);
        if (arguments != null) {
            this.hpQ.ad(arguments);
            this.hpP = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.hpQ.ad(bundle);
            this.hpP = bundle.getBoolean("is_game_frs", false);
        } else {
            this.hpQ.ad(null);
        }
        this.gYv = getVoiceManager();
        this.gYv.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dld);
        registerListener(this.hpW);
        registerListener(this.gZu);
        registerListener(this.gZU);
        this.hpR = new FrsLoadMoreModel(this, null);
        this.hpR.registerListener();
        this.hpR.setPageType(2);
        this.hpR.ng(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cCL = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.hpS = new a(this, inflate, this.hpP);
        this.hpS.bTr().bTx();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.guZ) {
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
        this.gYv = getVoiceManager();
        this.gYv.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bTk();
        if (bundle != null) {
            this.gYo = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.gYo = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bTk() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dOP);
    }

    public FrsLoadMoreModel bTl() {
        return this.hpR;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hpS != null) {
            this.hpS.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hbv);
        com.baidu.tieba.s.c.cVo().x(getUniqueId());
        r.bEW().lx(false);
        super.onDestroy();
        this.hpQ.aqS();
        this.gYv = getVoiceManager();
        this.gYv.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hpV);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.gYo);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.hpP);
        this.hpQ.onSaveInstanceState(bundle);
        this.gYv = getVoiceManager();
        if (this.gYv != null) {
            this.gYv.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bj threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.hpS.bTr().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.gXU.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.jT(intent.getIntExtra("good_data", 0));
                            threadDataById.aLx();
                            ne(false);
                            return;
                        } else if (intExtra == 0) {
                            this.gXU.removeThreadData(threadDataById);
                            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXU.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new p());
                            }
                            this.hpS.bTp();
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
            if (this.hfR == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.guZ) {
                com.baidu.adp.lib.f.e.lb().post(this.hpV);
            }
        }
        bQH();
    }

    private void bQH() {
        if (isPrimary()) {
            if (this.hdk != null && this.hdk.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hbv);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hbv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hpS != null) {
            this.hpS.bPC();
        }
        this.gYv = getVoiceManager();
        this.gYv.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.hpT = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.hpS.a(this.gZQ);
        this.hpS.setOnScrollListener(this.mScrollListener);
        this.hpS.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.hpT != null) {
                    FrsGoodFragment.this.hpT.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hfR != 3 || this.hpS != null) {
            this.hfR = i;
            super.onChangeSkinType(i);
            if (this.hpS != null) {
                this.hpS.onChangeSkinType(i);
            }
            if (this.hdk != null && this.hdk.isViewAttached()) {
                this.hdk.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bNN() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bNN();
        }
        return null;
    }

    private void bON() {
        switch (this.mFlag) {
            case 1:
                h.lc().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.KV(FrsGoodFragment.this.gYo);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOO() {
        bOR();
        try {
            if (this.gXU != null) {
                this.hpS.bQR();
                this.hpS.bpT();
                this.gYo = this.gXU.getForum().getName();
                this.forumId = this.gXU.getForum().getId();
                if (this.gXU != null && this.gXU.getForum() != null) {
                    this.hpS.a(this.gXU.getForum().getThemeColorInfo());
                    this.hpS.c(this.gXU);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.gXU.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.gXU.getUserData().getBimg_end_time());
                bON();
                if (!this.hpS.bTr().p(bj.dra)) {
                    this.gXU.removeAlaLiveThreadData();
                }
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXU.getThreadList();
                if (threadList != null) {
                    this.hpS.a(threadList, this.mPn, this.gXU, this.gXU.getPage().aJy());
                    bTm();
                    this.hpS.bTp();
                    if (this.gXU.getIsNewUrl() == 1) {
                        this.hpS.bTr().setFromCDN(true);
                    } else {
                        this.hpS.bTr().setFromCDN(false);
                    }
                    this.hpS.setListViewSelection(bV(bTn().getType(), this.mPn));
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
        this.gYv = getVoiceManager();
        this.gYv.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        r.bEW().lx(false);
        com.baidu.tieba.s.c.cVo().b(getUniqueId(), false);
        if (this.gXU != null && this.gXU.getForum() != null) {
            com.baidu.tbadk.distribute.a.aWB().b(getPageContext().getPageActivity(), "frs", this.gXU.getForum().getId(), 0L);
        }
        this.gYv = getVoiceManager();
        if (this.gYv != null) {
            this.gYv.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul(int i) {
        ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXU.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).dqE;
                    if (bjVar.getId() != null && bjVar.getId().equals(this.hpO)) {
                        c(bjVar, i);
                        this.hpO = null;
                        break;
                    }
                }
            }
            this.hpS.bTr().b(threadList, this.gXU);
            this.hpS.bTr().notifyDataSetChanged();
        }
    }

    private void c(bj bjVar, int i) {
        if (i == 1) {
            PraiseData aKn = bjVar.aKn();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aKn == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bjVar.a(praiseData);
                    return;
                }
                bjVar.aKn().getUser().add(0, metaData);
                bjVar.aKn().setNum(bjVar.aKn().getNum() + 1);
                bjVar.aKn().setIsLike(i);
            }
        } else if (bjVar.aKn() != null) {
            bjVar.aKn().setIsLike(i);
            bjVar.aKn().setNum(bjVar.aKn().getNum() - 1);
            ArrayList<MetaData> user = bjVar.aKn().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bjVar.aKn().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gYv == null) {
            this.gYv = VoiceManager.instance();
        }
        return this.gYv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aQF() {
        if (this.hpS == null) {
            return null;
        }
        return this.hpS.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bOR() {
        this.gYv = getVoiceManager();
        this.gYv.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aQG() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aQG();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.gXU != null && this.hpS != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.hpS.bPC();
            }
        }
    }

    private void bTm() {
        HashMap<Integer, bj> bRP;
        if (this.hpS != null && this.hpS.bTr() != null && (bRP = this.hpS.bTr().bRP()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bj> entry : bRP.entrySet()) {
                bj value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.aWH().E(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (aQF() == null) {
            return null;
        }
        return aQF().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            ne(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bOW() {
        return this.gXU;
    }

    public FrsGoodModelController bTn() {
        return this.hpQ;
    }

    public void Dn(String str) {
        this.gYo = str;
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
            this.hpS.bmo();
        } else if (!this.hpQ.bTw()) {
            this.hpS.bmo();
        } else {
            blo();
            if (!this.hpR.isLoading && !this.hpQ.isLoading()) {
                if (this.hpR.cz(this.gXU.getThreadListIds())) {
                    this.hpS.a(this.hpR.bTH(), this.mPn, this.gXU, 0);
                    this.hpR.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.gXU.getThreadListIds(), this.gYo, this.mPn, this.gXU.isBrandForum);
                } else if (this.fXo != 0) {
                    this.hpS.a(this.hpR.bTH(), this.mPn, this.gXU, 0);
                    this.mPn++;
                    this.hpQ.un(this.mPn);
                    this.hpR.loadingDone = false;
                    this.hpR.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        blo();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void an(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.m> a;
        blo();
        if (arrayList != null && arrayList.size() != 0 && (a = this.hpR.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.gXU.setThreadList(a);
            this.hpS.a(a, this.mPn, this.gXU, 0);
        }
    }

    private void blo() {
        if (this.fXo == 0 && !this.hpR.cz(this.gXU.getThreadListIds())) {
            if (this.gXU.getThreadList() == null || this.gXU.getThreadList().size() == 0) {
                this.hpS.bmo();
                return;
            } else {
                this.hpS.bmn();
                return;
            }
        }
        this.hpS.bmm();
    }

    @Override // android.support.v4.app.Fragment, com.baidu.h.a.a.InterfaceC0121a
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
        com.baidu.tbadk.distribute.a.aWB().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.m
    public void bOQ() {
        if (this.hpQ != null) {
            this.hpQ.bOQ();
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
    public NavigationBar bof() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.gYo;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.gXU != null) {
            i = this.gXU.getSortType();
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
    public void bOc() {
        if (this.hpS != null && this.hpS.getListView() != null) {
            this.hpS.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bml() {
        if (this.hpS != null) {
            bOc();
            this.hpS.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.gYT.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oh(int i) {
        return this.gYT.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.an
    public void aQk() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bfN().ye("page_frs_good");
            ne(true);
            return;
        }
        this.hpS.it(false);
    }

    @Override // com.baidu.tieba.frs.an
    public void aQl() {
        com.baidu.tieba.s.c.cVo().b(getUniqueId(), false);
    }
}
