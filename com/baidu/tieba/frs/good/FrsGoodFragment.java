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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.m.a.a;
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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.c;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.f.i;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.f;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes22.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0250a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, as, at, au, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private VoiceManager iHo;
    private c iNC;
    private String jbu;
    private FrsGoodModelController jbw;
    private FrsLoadMoreModel jbx;
    private com.baidu.tieba.frs.gametab.b jbz;
    private String mForumId;
    private String iHh = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean jbv = false;
    private String forumId = null;
    private FrsViewData iGN = new FrsViewData();
    public long ijR = -1;
    public long fvg = 0;
    public long fvq = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean iHB = false;
    protected a jby = null;
    private int hBL = -1;
    private int mTabId = 0;
    private int iQm = 3;
    private boolean idS = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iHP = new SparseArray<>();
    private boolean jbA = false;
    private int dJG = 0;
    private int iIn = 0;
    private CustomMessageListener iKR = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.iNC != null && FrsGoodFragment.this.iNC.isViewAttached()) {
                FrsGoodFragment.this.iNC.rC(num.intValue());
            }
        }
    };
    private Runnable jbB = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.idS) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.qi(false);
            }
        }
    };
    private CustomMessageListener jbC = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                bw bwVar = (bw) customResponsedMessage.getData();
                FrsGoodFragment.this.jbu = bwVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.jbu) && bwVar.bml() != null) {
                    FrsGoodFragment.this.zT(bwVar.bml().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener iIB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.bta() != null) {
                        FrsGoodFragment.this.bta().setSelection(0);
                    }
                    if (FrsGoodFragment.this.iNC != null && FrsGoodFragment.this.iNC.isViewAttached()) {
                        FrsGoodFragment.this.qi(false);
                    } else if (FrsGoodFragment.this.jby != null) {
                        FrsGoodFragment.this.jby.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final r iIT = new r() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long jbF = 1;

        @Override // com.baidu.tieba.tbadkCore.r
        public void yG(int i) {
            if (!FrsGoodFragment.this.jbA) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.jby.czx();
                        return;
                    case 3:
                        FrsGoodFragment.this.jby.lc(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, f fVar) {
            ArrayList<q> a2;
            if (FrsGoodFragment.this.jbA) {
                if (FrsGoodFragment.this.cDF().cDN() == null) {
                    FrsGoodFragment.this.jbA = false;
                    return;
                } else if (FrsGoodFragment.this.cDF().cDN().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.jbA = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jbF = 1L;
            } else if (fVar.isSuccess) {
                this.jbF = 0L;
            } else {
                this.jbF = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.jbx.resetData();
            }
            FrsGoodFragment.this.jby.lc(false);
            if (FrsGoodFragment.this.cDF().cDN() != null) {
                FrsGoodFragment.this.iGN = FrsGoodFragment.this.cDF().cDN();
            }
            FrsGoodFragment.this.hBL = FrsGoodFragment.this.iGN.getPage().blq();
            if (FrsGoodFragment.this.hBL != 0 || (FrsGoodFragment.this.iGN.getThreadListIds() != null && FrsGoodFragment.this.iGN.getThreadListIds().size() != 0)) {
                if (y.getCount(FrsGoodFragment.this.iGN.getThreadList()) > 3) {
                    FrsGoodFragment.this.jby.Wi();
                } else {
                    FrsGoodFragment.this.jby.czN();
                }
            } else if (FrsGoodFragment.this.iGN.getThreadList() == null || FrsGoodFragment.this.iGN.getThreadList().size() == 0) {
                FrsGoodFragment.this.jby.bPW();
            } else {
                FrsGoodFragment.this.jby.Wj();
            }
            if (i == 4) {
                ArrayList<q> a3 = FrsGoodFragment.this.jbx.a(false, false, false, FrsGoodFragment.this.iGN.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsGoodFragment.this.iGN.setThreadList(a3);
                    FrsGoodFragment.this.jby.a(a3, FrsGoodFragment.this.mPn, FrsGoodFragment.this.iGN, FrsGoodFragment.this.hBL);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.jby.czx();
                    break;
                case 2:
                    FrsGoodFragment.this.jby.czx();
                    break;
                case 3:
                    if (FrsGoodFragment.this.iGN.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.jbF != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.iGN != null) {
                    FrsGoodFragment.this.iHh = FrsGoodFragment.this.iGN.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.iGN.getForum().getId();
                    FrsGoodFragment.this.jby.b(FrsGoodFragment.this.iGN.getForum(), FrsGoodFragment.this.iGN.getUserData());
                }
                if (FrsGoodFragment.this.iGN != null) {
                    FrsGoodFragment.this.iGN.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.jby.c(FrsGoodFragment.this.iGN);
                if (FrsGoodFragment.this.iGN == null || FrsGoodFragment.this.iGN.getThreadList() == null || FrsGoodFragment.this.iGN.getThreadList().size() != 0 || FrsGoodFragment.this.cDF().getType() != 4) {
                    if (FrsGoodFragment.this.iGN != null && (a2 = FrsGoodFragment.this.jbx.a(false, false, true, FrsGoodFragment.this.iGN.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsGoodFragment.this.iGN.setThreadList(a2);
                    }
                    FrsGoodFragment.this.cyF();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.ijR > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.ijR, FrsGoodFragment.this.cDF().csw() - FrsGoodFragment.this.ijR, FrsGoodFragment.this.cDF().csu(), FrsGoodFragment.this.cDF().csv(), currentTimeMillis2 - FrsGoodFragment.this.cDF().cst());
                        FrsGoodFragment.this.ijR = -1L;
                    }
                    FrsGoodFragment.this.fvq = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.ijR > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.ijR, FrsGoodFragment.this.cDF().csw() - FrsGoodFragment.this.ijR, FrsGoodFragment.this.cDF().csu(), FrsGoodFragment.this.cDF().csv(), currentTimeMillis3 - FrsGoodFragment.this.cDF().cst());
                FrsGoodFragment.this.ijR = -1L;
            }
            FrsGoodFragment.this.fvq = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cyz() {
        }
    };
    private final CustomMessageListener exi = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.jby != null) {
                FrsGoodFragment.this.jby.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.iHB) {
                FrsGoodFragment.this.iHB = true;
                FrsGoodFragment.this.jby.czM();
            }
            if (i == 0) {
                t.cor().oy(true);
                com.baidu.tieba.s.c.dIX().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.iIn += i2;
            if (FrsGoodFragment.this.iIn >= FrsGoodFragment.this.dJG * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener feV = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private ab iJa = new ab() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bv)) {
                bw bwVar = ((bv) qVar).exA;
                if (bwVar.bnA() == null || bwVar.bnA().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bwVar.bnn() != 1 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Tb(bwVar.getId())) {
                            readThreadHistory.Ta(bwVar.getId());
                            if (FrsGoodFragment.this.jby != null) {
                                FrsGoodFragment.this.jby.czx();
                            }
                        }
                        boolean z = false;
                        final String bmG = bwVar.bmG();
                        if (bmG != null && !bmG.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(bmG);
                                    aaVar.bqN().brt().mIsNeedAddCommenParam = false;
                                    aaVar.bqN().brt().mIsUseCurrentBDUSS = false;
                                    aaVar.getNetData();
                                }
                            }).start();
                        }
                        String str = null;
                        if (bwVar != null) {
                            str = bwVar.getTid();
                        }
                        if (str == null) {
                            str = "";
                        }
                        if (bwVar.bmv() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.brr().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3 && str.length() > 3) {
                            bwVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bwVar, FrsGoodFragment.this.iHh, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.iGN != null && FrsGoodFragment.this.iGN.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.jfB = FrsGoodFragment.this.iGN.needLog == 1;
                            bVar.jfD = FrsGoodFragment.this.iGN.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.iRl != null) {
                                bVar.jfE = com.baidu.tieba.frs.d.d.iRl.jfE;
                                bVar.jfF = com.baidu.tieba.frs.d.d.iRl.jfF;
                            }
                            com.baidu.tieba.frs.d.a.a(bwVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener iJe = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.jby != null) {
                FrsGoodFragment.this.jby.GI();
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

    public void cBw() {
        if (this.jby != null) {
            this.jby.refreshView();
        }
    }

    private void showLoadingView() {
        this.jby.pR(false);
        showLoadingView(this.jby.cka(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jby.pR(true);
        hideLoadingView(this.jby.cka());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.jby.pR(false);
        this.jby.pQ(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jby.bPW();
        this.jby.getListView().getData().clear();
        this.jby.czx();
        if (this.iNC == null) {
            this.iNC = new c(getPageContext().getContext(), getNetRefreshListener());
            this.iNC.setTitle(null);
            this.iNC.setButtonText(null);
            this.iNC.showRefreshButton();
            this.iNC.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.iNC.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.iNC.setSubText(null);
        }
        this.iNC.onChangeSkinType();
        this.iNC.attachView(this.jby.cka(), true);
        registerListener(this.iKR);
    }

    private void Wk() {
        this.jby.pR(true);
        this.jby.pQ(true);
        if (this.iNC != null && this.iNC.isViewAttached()) {
            this.iNC.dettachView(this.jby.cka());
        }
        MessageManager.getInstance().unRegisterListener(this.iKR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(boolean z) {
        this.idS = true;
        cyK();
        Wk();
        if (!z) {
            Wk();
            showLoadingView();
        }
        this.jbw.tW(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ijR = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.ijR = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.fvg = this.beginTime - this.ijR;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dIX().z(getUniqueId());
        this.jbw = new FrsGoodModelController(this);
        if (arguments != null) {
            this.jbw.aj(arguments);
            this.jbv = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.jbw.aj(bundle);
            this.jbv = bundle.getBoolean("is_game_frs", false);
        } else {
            this.jbw.aj(null);
        }
        this.iHo = getVoiceManager();
        this.iHo.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.exi);
        registerListener(this.jbC);
        registerListener(this.iIB);
        registerListener(this.iJe);
        this.jbx = new FrsLoadMoreModel(this, null);
        this.jbx.registerListener();
        this.jbx.setPageType(2);
        this.jbx.qk(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dJG = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jby = new a(this, inflate, this.jbv);
        this.jby.cDJ().cDQ();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.idS) {
            if (j.isNetWorkAvailable()) {
                qi(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new aq("c13008").dR("fid", this.mForumId).dR("obj_type", "7").al("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.iHo = getVoiceManager();
        this.iHo.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cDC();
        if (bundle != null) {
            this.iHh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.iHh = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cDC() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.feV);
    }

    public FrsLoadMoreModel cDD() {
        return this.jbx;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jby != null) {
            this.jby.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iKR);
        com.baidu.tieba.s.c.dIX().A(getUniqueId());
        t.cor().oy(false);
        super.onDestroy();
        this.jbw.cDL();
        this.iHo = getVoiceManager();
        this.iHo.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jbB);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iHh);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.jbv);
        this.jbw.onSaveInstanceState(bundle);
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bw threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jby.cDJ().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.iGN.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.om(intent.getIntExtra("good_data", 0));
                            threadDataById.bny();
                            qi(false);
                            return;
                        } else if (intExtra == 0) {
                            this.iGN.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.iGN.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new s());
                            }
                            this.jby.cDH();
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
            if (this.iQm == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.idS) {
                com.baidu.adp.lib.f.e.mY().post(this.jbB);
            }
        }
        cAO();
    }

    private void cAO() {
        if (isPrimary()) {
            if (this.iNC != null && this.iNC.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iKR);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iKR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jby != null) {
            this.jby.czx();
        }
        this.iHo = getVoiceManager();
        this.iHo.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jbz = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.jby.a(this.iJa);
        this.jby.setOnScrollListener(this.mScrollListener);
        this.jby.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.jbz != null) {
                    FrsGoodFragment.this.jbz.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iQm != 3 || this.jby != null) {
            this.iQm = i;
            super.onChangeSkinType(i);
            if (this.jby != null) {
                this.jby.onChangeSkinType(i);
            }
            if (this.iNC != null && this.iNC.isViewAttached()) {
                this.iNC.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cxz() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cxz();
        }
        return null;
    }

    private void cyE() {
        switch (this.mFlag) {
            case 1:
                h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.SV(FrsGoodFragment.this.iHh);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyF() {
        cyK();
        try {
            if (this.iGN != null) {
                this.jby.cAY();
                this.jby.bVq();
                this.iHh = this.iGN.getForum().getName();
                this.forumId = this.iGN.getForum().getId();
                if (this.iGN != null && this.iGN.getForum() != null) {
                    this.jby.a(this.iGN.getForum().getThemeColorInfo());
                    this.jby.c(this.iGN);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.iGN.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iGN.getUserData().getBimg_end_time());
                cyE();
                if (!this.jby.cDJ().r(bw.eDX)) {
                    this.iGN.removeAlaLiveThreadData();
                }
                ArrayList<q> threadList = this.iGN.getThreadList();
                if (threadList != null) {
                    this.jby.a(threadList, this.mPn, this.iGN, this.iGN.getPage().blq());
                    cDE();
                    this.jby.cDH();
                    if (this.iGN.getIsNewUrl() == 1) {
                        this.jby.cDJ().setFromCDN(true);
                    } else {
                        this.jby.cDJ().setFromCDN(false);
                    }
                    this.jby.setListViewSelection(cy(cDF().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cy(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.iHo = getVoiceManager();
        this.iHo.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.cor().oy(false);
        com.baidu.tieba.s.c.dIX().b(getUniqueId(), false);
        if (this.iGN != null && this.iGN.getForum() != null) {
            com.baidu.tbadk.distribute.a.bzk().b(getPageContext().getPageActivity(), "frs", this.iGN.getForum().getId(), 0L);
        }
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT(int i) {
        ArrayList<q> threadList = this.iGN.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).exA;
                    if (bwVar.getId() != null && bwVar.getId().equals(this.jbu)) {
                        c(bwVar, i);
                        this.jbu = null;
                        break;
                    }
                }
            }
            this.jby.cDJ().b(threadList, this.iGN);
            this.jby.cDJ().notifyDataSetChanged();
        }
    }

    private void c(bw bwVar, int i) {
        if (i == 1) {
            PraiseData bml = bwVar.bml();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bml == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bwVar.a(praiseData);
                    return;
                }
                bwVar.bml().getUser().add(0, metaData);
                bwVar.bml().setNum(bwVar.bml().getNum() + 1);
                bwVar.bml().setIsLike(i);
            }
        } else if (bwVar.bml() != null) {
            bwVar.bml().setIsLike(i);
            bwVar.bml().setNum(bwVar.bml().getNum() - 1);
            ArrayList<MetaData> user = bwVar.bml().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bwVar.bml().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iHo == null) {
            this.iHo = VoiceManager.instance();
        }
        return this.iHo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView bta() {
        if (this.jby == null) {
            return null;
        }
        return this.jby.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cyK() {
        this.iHo = getVoiceManager();
        this.iHo.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> btb() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).btb();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.iGN != null && this.jby != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jby.czx();
            }
        }
    }

    private void cDE() {
        HashMap<Integer, bw> cCa;
        if (this.jby != null && this.jby.cDJ() != null && (cCa = this.jby.cDJ().cCa()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bw> entry : cCa.entrySet()) {
                bw value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bzq().L(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        if (bta() == null) {
            return null;
        }
        return bta().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            qi(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cyP() {
        return this.iGN;
    }

    public FrsGoodModelController cDF() {
        return this.jbw;
    }

    public void KN(String str) {
        this.iHh = str;
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
            this.jby.bPW();
        } else if (!this.jbw.cDP()) {
            this.jby.bPW();
        } else {
            bOX();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.jbx.isLoading && !this.jbw.isLoading()) {
                if (this.jbx.m40do(this.iGN.getThreadListIds())) {
                    this.jby.a(this.jbx.cEa(), this.mPn, this.iGN, 0);
                    this.jbx.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.iGN.getThreadListIds(), this.iHh, this.mPn, this.iGN.isBrandForum);
                } else if (this.hBL != 0) {
                    this.jby.a(this.jbx.cEa(), this.mPn, this.iGN, 0);
                    this.mPn++;
                    this.jbw.zV(this.mPn);
                    this.jbx.loadingDone = false;
                    this.jbx.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bOX();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ax(ArrayList<q> arrayList) {
        bOX();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<q> a2 = this.jbx.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.iGN.setThreadList(a2);
                this.jby.a(a2, this.mPn, this.iGN, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iGN.getForum()));
        }
    }

    private void bOX() {
        if (this.hBL == 0 && !this.jbx.m40do(this.iGN.getThreadListIds())) {
            if (this.iGN.getThreadList() == null || this.iGN.getThreadList().size() == 0) {
                this.jby.bPW();
            } else {
                this.jby.Wj();
            }
        } else if (y.getCount(this.iGN.getThreadList()) > 3) {
            this.jby.Wi();
        } else {
            this.jby.czN();
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0250a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ae.checkCamera(getActivity().getApplicationContext())) {
                ao.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
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
        com.baidu.tbadk.distribute.a.bzk().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void cyJ() {
        if (this.jbw != null) {
            this.jbw.cyJ();
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

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bSH() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iHh;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.iGN != null) {
            i = this.iGN.getSortType();
        }
        tbPageTag.sortType = i.At(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zU(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            qi(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void cxS() {
        if (this.jby != null && this.jby.getListView() != null) {
            this.jby.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bPV() {
        if (this.jby != null) {
            cxS();
            this.jby.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iHP.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ta(int i) {
        return this.iHP.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.au
    public void bsB() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bIR().EY("page_frs_good");
            qi(true);
            return;
        }
        this.jby.lc(false);
    }

    @Override // com.baidu.tieba.frs.au
    public void bsC() {
        com.baidu.tieba.s.c.dIX().b(getUniqueId(), false);
    }

    public void a(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null && cyP() != null && cyP().getThreadList() != null) {
            if (y.isEmpty(cyP().getThreadList())) {
                cyP().getThreadList().add(asVar);
            } else {
                if (cyP().getThreadList().size() == 1 && (cyP().getThreadList().get(0) instanceof s)) {
                    cyP().getThreadList().remove(0);
                }
                cyP().getThreadList().add(0, asVar);
            }
            this.jby.a(this.iGN.getThreadList(), this.mPn, this.iGN, this.iGN.getPage().blq());
            this.jby.cDH();
            this.jby.setListViewSelection(0);
        }
    }
}
