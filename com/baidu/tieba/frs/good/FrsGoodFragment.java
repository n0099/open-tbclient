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
/* loaded from: classes6.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0072a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, ai, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private VoiceManager giZ;
    private c gnQ;
    private String gzU;
    private FrsGoodModelController gzW;
    private FrsLoadMoreModel gzX;
    private com.baidu.tieba.frs.gametab.b gzZ;
    private String mForumId;
    private String giS = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean gzV = false;
    private String forumId = null;
    private FrsViewData giA = new FrsViewData();
    public long fPB = -1;
    public long dzl = 0;
    public long dzt = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean gjj = false;
    protected a gzY = null;
    private int fmo = -1;
    private int mTabId = 0;
    private int gqv = 3;
    private boolean fJL = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gjw = new SparseArray<>();
    public boolean gAa = false;
    private boolean gAb = false;
    private int bZc = 0;
    private int gjV = 0;
    private CustomMessageListener glU = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.gnQ != null && FrsGoodFragment.this.gnQ.isViewAttached()) {
                FrsGoodFragment.this.gnQ.ml(num.intValue());
            }
        }
    };
    private Runnable gAc = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.fJL) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.lH(false);
            }
        }
    };
    private CustomMessageListener gAd = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                FrsGoodFragment.this.gzU = bjVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.gzU) && bjVar.azp() != null) {
                    FrsGoodFragment.this.tx(bjVar.azp().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener gjY = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.aFx() != null) {
                            FrsGoodFragment.this.aFx().setSelection(0);
                        }
                        if (FrsGoodFragment.this.gnQ != null && FrsGoodFragment.this.gnQ.isViewAttached()) {
                            FrsGoodFragment.this.lH(false);
                        } else if (FrsGoodFragment.this.gzY != null) {
                            FrsGoodFragment.this.gzY.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                        }
                    }
                }
            }
        }
    };
    public final p gkn = new p() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        private long gAg = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void sv(int i) {
            if (!FrsGoodFragment.this.gAb) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.gzY.bCm();
                        return;
                    case 3:
                        FrsGoodFragment.this.gzY.hi(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.gAb) {
                if (FrsGoodFragment.this.bGa().bGh() == null) {
                    FrsGoodFragment.this.gAb = false;
                    return;
                } else if (FrsGoodFragment.this.bGa().bGh().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.gAb = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.gAg = 1L;
            } else if (bVar.isSuccess) {
                this.gAg = 0L;
            } else {
                this.gAg = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.gzX.resetData();
            }
            FrsGoodFragment.this.gzY.hi(false);
            if (FrsGoodFragment.this.bGa().bGh() != null) {
                FrsGoodFragment.this.giA = FrsGoodFragment.this.bGa().bGh();
            }
            FrsGoodFragment.this.fmo = FrsGoodFragment.this.giA.getPage().ayy();
            if (FrsGoodFragment.this.fmo == 0 && (FrsGoodFragment.this.giA.getThreadListIds() == null || FrsGoodFragment.this.giA.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.giA.getThreadList() == null || FrsGoodFragment.this.giA.getThreadList().size() == 0) {
                    FrsGoodFragment.this.gzY.baH();
                } else {
                    FrsGoodFragment.this.gzY.baG();
                }
            } else {
                FrsGoodFragment.this.gzY.baF();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.gzX.a(false, false, false, FrsGoodFragment.this.giA.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.giA.setThreadList(a2);
                    FrsGoodFragment.this.gzY.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.giA, FrsGoodFragment.this.fmo);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.gzY.bCm();
                    break;
                case 2:
                    FrsGoodFragment.this.gzY.bCm();
                    break;
                case 3:
                    if (FrsGoodFragment.this.giA.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.gAg != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.giA != null) {
                    FrsGoodFragment.this.giS = FrsGoodFragment.this.giA.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.giA.getForum().getId();
                    FrsGoodFragment.this.gzY.b(FrsGoodFragment.this.giA.getForum(), FrsGoodFragment.this.giA.getUserData());
                }
                if (FrsGoodFragment.this.giA != null) {
                    FrsGoodFragment.this.giA.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.gzY.c(FrsGoodFragment.this.giA);
                if (FrsGoodFragment.this.giA == null || FrsGoodFragment.this.giA.getThreadList() == null || FrsGoodFragment.this.giA.getThreadList().size() != 0 || FrsGoodFragment.this.bGa().getType() != 4) {
                    if (FrsGoodFragment.this.giA != null && (a = FrsGoodFragment.this.gzX.a(false, false, true, FrsGoodFragment.this.giA.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.giA.setThreadList(a);
                    }
                    FrsGoodFragment.this.bBA();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.fPB > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.fPB, FrsGoodFragment.this.bGa().bwg() - FrsGoodFragment.this.fPB, FrsGoodFragment.this.bGa().bwe(), FrsGoodFragment.this.bGa().bwf(), currentTimeMillis2 - FrsGoodFragment.this.bGa().bwd());
                        FrsGoodFragment.this.fPB = -1L;
                    }
                    FrsGoodFragment.this.dzt = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.fPB > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.fPB, FrsGoodFragment.this.bGa().bwg() - FrsGoodFragment.this.fPB, FrsGoodFragment.this.bGa().bwe(), FrsGoodFragment.this.bGa().bwf(), currentTimeMillis3 - FrsGoodFragment.this.bGa().bwd());
                FrsGoodFragment.this.fPB = -1L;
            }
            FrsGoodFragment.this.dzt = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(l lVar) {
        }
    };
    private final CustomMessageListener cHq = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.gzY != null) {
                FrsGoodFragment.this.gzY.startPullRefresh();
            }
        }
    };
    private final g.c emI = new g.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.isNetWorkAvailable()) {
                d.aUV().wp("page_frs_good");
                FrsGoodFragment.this.lH(true);
                return;
            }
            FrsGoodFragment.this.gzY.hi(false);
        }
    };
    private final g.b dcs = new g.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.r.c.cHo().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.gjj) {
                FrsGoodFragment.this.gjj = true;
                FrsGoodFragment.this.gzY.bCA();
            }
            if (i == 0) {
                r.bsy().kc(true);
                com.baidu.tieba.r.c.cHo().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.gjV += i2;
            if (FrsGoodFragment.this.gjV >= FrsGoodFragment.this.bZc * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener djU = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
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
    private s gkt = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v15, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bi)) {
                bj bjVar = ((bi) mVar).cMR;
                if (bjVar.aAC() == null || bjVar.aAC().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bjVar.aAo() != 1 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.IR(bjVar.getId())) {
                            readThreadHistory.IQ(bjVar.getId());
                            if (FrsGoodFragment.this.gzY != null) {
                                FrsGoodFragment.this.gzY.bCm();
                            }
                        }
                        boolean z = false;
                        final String azL = bjVar.azL();
                        if (azL != null && !azL.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(azL);
                                    xVar.aDB().aEb().mIsNeedAddCommenParam = false;
                                    xVar.aDB().aEb().mIsUseCurrentBDUSS = false;
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
                        if (bjVar.azz() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aEa().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3) {
                            bjVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, FrsGoodFragment.this.giS, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.gAa ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.giA != null && FrsGoodFragment.this.giA.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.gDW = FrsGoodFragment.this.giA.needLog == 1;
                            bVar.gDY = FrsGoodFragment.this.giA.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.gre != null) {
                                bVar.gDZ = com.baidu.tieba.frs.d.d.gre.gDZ;
                                bVar.gEa = com.baidu.tieba.frs.d.d.gre.gEa;
                            }
                            com.baidu.tieba.frs.d.a.a(bjVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gkx = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.gzY != null) {
                FrsGoodFragment.this.gzY.qZ();
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
        this.gzY.lr(false);
        showLoadingView(this.gzY.bpX(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gzY.lr(true);
        hideLoadingView(this.gzY.bpX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.gzY.lr(false);
        this.gzY.bDz().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gzY.baH();
        this.gzY.getListView().getData().clear();
        this.gzY.bCm();
        if (this.gnQ == null) {
            this.gnQ = new c(getPageContext().getContext(), getNetRefreshListener());
            this.gnQ.setTitle(null);
            this.gnQ.setButtonText(null);
            this.gnQ.showRefreshButton();
            this.gnQ.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.gnQ.setSubText(getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.gnQ.setSubText(null);
        }
        this.gnQ.onChangeSkinType();
        this.gnQ.attachView(this.gzY.bpX(), true);
        registerListener(this.glU);
    }

    private void aZK() {
        this.gzY.lr(true);
        this.gzY.bDz().setEnabled(true);
        if (this.gnQ != null && this.gnQ.isViewAttached()) {
            this.gnQ.dettachView(this.gzY.bpX());
        }
        MessageManager.getInstance().unRegisterListener(this.glU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH(boolean z) {
        this.fJL = true;
        bBD();
        aZK();
        if (!z) {
            aZK();
            showLoadingView();
        }
        this.gzW.oo(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fPB = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.fPB = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.dzl = this.beginTime - this.fPB;
        super.onCreate(bundle);
        com.baidu.tieba.r.c.cHo().w(getUniqueId());
        this.gzW = new FrsGoodModelController(this);
        if (arguments != null) {
            this.gzW.ad(arguments);
            this.gzV = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.gzW.ad(bundle);
            this.gzV = bundle.getBoolean("is_game_frs", false);
        } else {
            this.gzW.ad(null);
        }
        this.giZ = getVoiceManager();
        this.giZ.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.cHq);
        registerListener(this.gAd);
        registerListener(this.gjY);
        registerListener(this.gkx);
        this.gzX = new FrsLoadMoreModel(this, null);
        this.gzX.registerListener();
        this.gzX.setPageType(2);
        this.gzX.lK(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.bZc = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.gzY = new a(this, inflate, this.gzV);
        this.gzY.bGe().lJ(this.gAa);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.fJL) {
            if (j.isNetWorkAvailable()) {
                lH(false);
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
        this.giZ = getVoiceManager();
        this.giZ.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bFX();
        if (bundle != null) {
            this.giS = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.gAa = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.giS = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.gAa = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bFX() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.djU);
    }

    public FrsLoadMoreModel bFY() {
        return this.gzX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gzY != null) {
            this.gzY.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.glU);
        com.baidu.tieba.r.c.cHo().x(getUniqueId());
        r.bsy().kc(false);
        super.onDestroy();
        this.gzW.afZ();
        this.giZ = getVoiceManager();
        this.giZ.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.gAc);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.giS);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.gzV);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.gAa);
        this.gzW.onSaveInstanceState(bundle);
        this.giZ = getVoiceManager();
        if (this.giZ != null) {
            this.giZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bj threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.gzY.bGe().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.giA.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.jv(intent.getIntExtra("good_data", 0));
                            threadDataById.aAA();
                            lH(false);
                            return;
                        } else if (intExtra == 0) {
                            this.giA.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.giA.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.n());
                            }
                            this.gzY.bGc();
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
            if (this.gqv == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.fJL) {
                com.baidu.adp.lib.f.e.gy().post(this.gAc);
            }
        }
        bDp();
    }

    private void bDp() {
        if (isPrimary()) {
            if (this.gnQ != null && this.gnQ.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.glU);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.glU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gzY != null) {
            this.gzY.bCm();
        }
        this.giZ = getVoiceManager();
        this.giZ.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.gzZ = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.gzY.a(this.gkt);
        this.gzY.setOnScrollListener(this.mScrollListener);
        this.gzY.setListPullRefreshListener(this.emI);
        this.gzY.a(this.dcs);
        this.gzY.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.gzZ != null) {
                    FrsGoodFragment.this.gzZ.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gqv != 3 || this.gzY != null) {
            this.gqv = i;
            super.onChangeSkinType(i);
            if (this.gzY != null) {
                this.gzY.onChangeSkinType(i);
            }
            if (this.gnQ != null && this.gnQ.isViewAttached()) {
                this.gnQ.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bAC() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bAC();
        }
        return null;
    }

    private void bBz() {
        switch (this.mFlag) {
            case 1:
                h.gz().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.IL(FrsGoodFragment.this.giS);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBA() {
        bBD();
        try {
            if (this.giA != null) {
                this.gzY.bdR();
                this.giS = this.giA.getForum().getName();
                this.forumId = this.giA.getForum().getId();
                if (this.giA != null && this.giA.getForum() != null) {
                    this.gzY.a(this.giA.getForum().getThemeColorInfo());
                    this.gzY.c(this.giA);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.giA.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.giA.getUserData().getBimg_end_time());
                bBz();
                if (!this.gzY.bGe().p(bj.cNm)) {
                    this.giA.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.giA.getThreadList();
                if (threadList != null) {
                    this.gzY.a(threadList, this.mPn, this.giA, this.giA.getPage().ayy());
                    bFZ();
                    this.gzY.bGc();
                    if (this.giA.getIsNewUrl() == 1) {
                        this.gzY.bGe().setFromCDN(true);
                    } else {
                        this.gzY.bGe().setFromCDN(false);
                    }
                    this.gzY.setListViewSelection(bO(bGa().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int bO(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.giZ = getVoiceManager();
        this.giZ.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        r.bsy().kc(false);
        com.baidu.tieba.r.c.cHo().b(getUniqueId(), false);
        if (this.giA != null && this.giA.getForum() != null) {
            com.baidu.tbadk.distribute.a.aLq().a(getPageContext().getPageActivity(), "frs", this.giA.getForum().getId(), 0L);
        }
        this.giZ = getVoiceManager();
        if (this.giZ != null) {
            this.giZ.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tx(int i) {
        ArrayList<m> threadList = this.giA.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).cMR;
                    if (bjVar.getId() != null && bjVar.getId().equals(this.gzU)) {
                        c(bjVar, i);
                        this.gzU = null;
                        break;
                    }
                }
            }
            this.gzY.bGe().b(threadList, this.giA);
            this.gzY.bGe().notifyDataSetChanged();
        }
    }

    private void c(bj bjVar, int i) {
        if (i == 1) {
            PraiseData azp = bjVar.azp();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (azp == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bjVar.a(praiseData);
                    return;
                }
                bjVar.azp().getUser().add(0, metaData);
                bjVar.azp().setNum(bjVar.azp().getNum() + 1);
                bjVar.azp().setIsLike(i);
            }
        } else if (bjVar.azp() != null) {
            bjVar.azp().setIsLike(i);
            bjVar.azp().setNum(bjVar.azp().getNum() - 1);
            ArrayList<MetaData> user = bjVar.azp().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bjVar.azp().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.giZ == null) {
            this.giZ = VoiceManager.instance();
        }
        return this.giZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aFx() {
        if (this.gzY == null) {
            return null;
        }
        return this.gzY.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bBD() {
        this.giZ = getVoiceManager();
        this.giZ.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aFy() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aFy();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.giA != null && this.gzY != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.gzY.bCm();
            }
        }
    }

    private void bFZ() {
        HashMap<Integer, bj> bEu;
        if (this.gzY != null && this.gzY.bGe() != null && (bEu = this.gzY.bGe().bEu()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bj> entry : bEu.entrySet()) {
                bj value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.aLw().C(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (aFx() == null) {
            return null;
        }
        return aFx().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            lH(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bBI() {
        return this.giA;
    }

    public FrsGoodModelController bGa() {
        return this.gzW;
    }

    public void AZ(String str) {
        this.giS = str;
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
            this.gzY.baH();
        } else if (!this.gzW.bGj()) {
            this.gzY.baH();
        } else {
            aZH();
            if (!this.gzX.isLoading && !this.gzW.isLoading()) {
                if (this.gzX.cr(this.giA.getThreadListIds())) {
                    this.gzY.a(this.gzX.bGt(), this.mPn, this.giA, 0);
                    this.gzX.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.giA.getThreadListIds(), this.giS, this.mPn, this.giA.isBrandForum);
                } else if (this.fmo != 0) {
                    this.gzY.a(this.gzX.bGt(), this.mPn, this.giA, 0);
                    this.mPn++;
                    this.gzW.tz(this.mPn);
                    this.gzX.loadingDone = false;
                    this.gzX.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        aZH();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void al(ArrayList<m> arrayList) {
        ArrayList<m> a;
        aZH();
        if (arrayList != null && arrayList.size() != 0 && (a = this.gzX.a(false, false, false, arrayList, (f) null)) != null) {
            this.giA.setThreadList(a);
            this.gzY.a(a, this.mPn, this.giA, 0);
        }
    }

    private void aZH() {
        if (this.fmo == 0 && !this.gzX.cr(this.giA.getThreadListIds())) {
            if (this.giA.getThreadList() == null || this.giA.getThreadList().size() == 0) {
                this.gzY.baH();
                return;
            } else {
                this.gzY.baG();
                return;
            }
        }
        this.gzY.baF();
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
        com.baidu.tbadk.distribute.a.aLq().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bBC() {
        if (this.gzW != null) {
            this.gzW.bBC();
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
    public NavigationBar bcb() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.giS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.giA != null) {
            i = this.giA.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.tW(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ty(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            lH(false);
        } else {
            c((e.b) null);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void scrollToTop() {
        if (this.gzY != null && this.gzY.getListView() != null) {
            this.gzY.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void baE() {
        if (this.gzY != null) {
            scrollToTop();
            this.gzY.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.gjw.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nB(int i) {
        return this.gjw.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }
}
