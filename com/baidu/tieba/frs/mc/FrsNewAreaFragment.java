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
/* loaded from: classes6.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, ai, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private FrsNewAreaModelController gCq;
    private VoiceManager giZ;
    private com.baidu.tbadk.k.c gnQ;
    private String gzU;
    private FrsLoadMoreModel gzX;
    private String giS = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData giA = new FrsViewData();
    public long fPB = -1;
    public long dzl = 0;
    public long dzt = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean gjj = false;
    protected g gCr = null;
    private int fmo = -1;
    private int gqv = 3;
    private boolean fJL = false;
    public boolean gAa = false;
    private boolean gAb = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gjw = new SparseArray<>();
    private int bZc = 0;
    private int gjV = 0;
    private CustomMessageListener glU = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.gnQ != null && FrsNewAreaFragment.this.gnQ.isViewAttached()) {
                FrsNewAreaFragment.this.gnQ.ml(num.intValue());
            }
        }
    };
    private Runnable gAc = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.fJL) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.lH(false);
            }
        }
    };
    private CustomMessageListener gAd = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                FrsNewAreaFragment.this.gzU = bjVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.gzU) && bjVar.azp() != null) {
                    FrsNewAreaFragment.this.tx(bjVar.azp().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener gjY = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.aFx() != null) {
                        FrsNewAreaFragment.this.aFx().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.gnQ != null && FrsNewAreaFragment.this.gnQ.isViewAttached()) {
                        FrsNewAreaFragment.this.lH(false);
                    } else if (FrsNewAreaFragment.this.gCr != null) {
                        FrsNewAreaFragment.this.gCr.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final p gkn = new p() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long gAg = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void sv(int i) {
            if (!FrsNewAreaFragment.this.gAb) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.gCr.bCm();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.gCr.hi(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.gAb) {
                if (FrsNewAreaFragment.this.bGQ().bGh() == null) {
                    FrsNewAreaFragment.this.gAb = false;
                    return;
                } else if (FrsNewAreaFragment.this.bGQ().bGh().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.gAb = false;
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
                FrsNewAreaFragment.this.gzX.resetData();
            }
            FrsNewAreaFragment.this.gCr.hi(false);
            if (FrsNewAreaFragment.this.bGQ().bGh() != null) {
                FrsNewAreaFragment.this.giA = FrsNewAreaFragment.this.bGQ().bGh();
            }
            FrsNewAreaFragment.this.fmo = FrsNewAreaFragment.this.giA.getPage().ayy();
            if (FrsNewAreaFragment.this.fmo == 0 && (FrsNewAreaFragment.this.giA.getThreadListIds() == null || FrsNewAreaFragment.this.giA.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.giA.getThreadList() == null || FrsNewAreaFragment.this.giA.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.gCr.baH();
                } else {
                    FrsNewAreaFragment.this.gCr.baG();
                }
            } else {
                FrsNewAreaFragment.this.gCr.baF();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.gzX.a(false, false, false, FrsNewAreaFragment.this.giA.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.giA.setThreadList(a2);
                    FrsNewAreaFragment.this.gCr.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.giA, FrsNewAreaFragment.this.fmo);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.gCr.bCm();
                    break;
                case 2:
                    FrsNewAreaFragment.this.gCr.bCm();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.giA.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.gAg != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.giA != null) {
                    FrsNewAreaFragment.this.giS = FrsNewAreaFragment.this.giA.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.giA.getForum().getId();
                    FrsNewAreaFragment.this.gCr.b(FrsNewAreaFragment.this.giA.getForum(), FrsNewAreaFragment.this.giA.getUserData());
                }
                if (FrsNewAreaFragment.this.giA != null) {
                    FrsNewAreaFragment.this.giA.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.giA == null || FrsNewAreaFragment.this.giA.getThreadList() == null || FrsNewAreaFragment.this.giA.getThreadList().size() != 0 || FrsNewAreaFragment.this.bGQ().getType() != 4) {
                    if (FrsNewAreaFragment.this.giA != null && (a = FrsNewAreaFragment.this.gzX.a(false, false, true, FrsNewAreaFragment.this.giA.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.giA.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bBA();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.fPB > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.fPB, FrsNewAreaFragment.this.bGQ().bwg() - FrsNewAreaFragment.this.fPB, FrsNewAreaFragment.this.bGQ().bwe(), FrsNewAreaFragment.this.bGQ().bwf(), currentTimeMillis2 - FrsNewAreaFragment.this.bGQ().bwd());
                        FrsNewAreaFragment.this.fPB = -1L;
                    }
                    FrsNewAreaFragment.this.dzt = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.fPB > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.fPB, FrsNewAreaFragment.this.bGQ().bwg() - FrsNewAreaFragment.this.fPB, FrsNewAreaFragment.this.bGQ().bwe(), FrsNewAreaFragment.this.bGQ().bwf(), currentTimeMillis3 - FrsNewAreaFragment.this.bGQ().bwd());
                FrsNewAreaFragment.this.fPB = -1L;
            }
            FrsNewAreaFragment.this.dzt = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
        }
    };
    private final CustomMessageListener cHq = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.gCr != null) {
                FrsNewAreaFragment.this.gCr.startPullRefresh();
            }
        }
    };
    private final g.c emI = new g.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.tieba.a.d.aUV().wp("page_frs_good");
                FrsNewAreaFragment.this.lH(true);
                return;
            }
            FrsNewAreaFragment.this.gCr.hi(false);
        }
    };
    private final g.b dcs = new g.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.r.c.cHo().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.gjj) {
                FrsNewAreaFragment.this.gjj = true;
                FrsNewAreaFragment.this.gCr.bCA();
            }
            if (i == 0) {
                r.bsy().kc(true);
                com.baidu.tieba.r.c.cHo().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.gjV += i2;
            if (FrsNewAreaFragment.this.gjV >= FrsNewAreaFragment.this.bZc * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener djU = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
    private s gkt = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v15, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bi)) {
                bj bjVar = ((bi) mVar).cMR;
                if (bjVar.aAC() == null || bjVar.aAC().getGroup_id() == 0 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bjVar.aAo() != 1 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.IR(bjVar.getId())) {
                            readThreadHistory.IQ(bjVar.getId());
                            if (FrsNewAreaFragment.this.gCr != null) {
                                FrsNewAreaFragment.this.gCr.bCm();
                            }
                        }
                        boolean z = false;
                        final String azL = bjVar.azL();
                        if (azL != null && !azL.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(azL);
                                    xVar.aDB().aEb().mIsNeedAddCommenParam = false;
                                    xVar.aDB().aEb().mIsUseCurrentBDUSS = false;
                                    xVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bjVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bjVar.azz() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aEa().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bjVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, FrsNewAreaFragment.this.giS, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsNewAreaFragment.this.gAa ? 15 : 3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.giA != null && FrsNewAreaFragment.this.giA.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.gDW = FrsNewAreaFragment.this.giA.needLog == 1;
                            bVar.gDY = FrsNewAreaFragment.this.giA.getForum().getId();
                            bVar.gDX = FrsNewAreaFragment.this.gCq.bGJ();
                            if (com.baidu.tieba.frs.d.d.gre != null) {
                                bVar.gDZ = com.baidu.tieba.frs.d.d.gre.gDZ;
                                bVar.gEa = com.baidu.tieba.frs.d.d.gre.gEa;
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

    public void aj(bj bjVar) {
        if (bjVar != null) {
            this.gCq.aj(bjVar);
            this.gCr.scrollToTop();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.giA = frsViewData;
            hideLoadingView(this.gCr.bpX());
            if (this.gCr != null) {
                this.gCr.hi(false);
                this.gCr.a(null, this.mPn, this.giA, this.fmo);
            }
        }
    }

    private void showLoadingView() {
        this.gCr.lr(false);
        showLoadingView(this.gCr.bpX(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gCr.lr(true);
        hideLoadingView(this.gCr.bpX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.gCr.lr(false);
        this.gCr.bDz().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gCr.baH();
        this.gCr.getListView().getData().clear();
        this.gCr.bCm();
        if (this.gnQ == null) {
            this.gnQ = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
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
        this.gnQ.attachView(this.gCr.bpX(), true);
        registerListener(this.glU);
    }

    private void aZK() {
        this.gCr.lr(true);
        this.gCr.bDz().setEnabled(true);
        if (this.gnQ != null && this.gnQ.isViewAttached()) {
            this.gnQ.dettachView(this.gCr.bpX());
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
        this.gCq.loadData();
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
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.dzl = this.beginTime - this.fPB;
        super.onCreate(bundle);
        com.baidu.tieba.r.c.cHo().w(getUniqueId());
        this.gCq = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.gCq.ad(arguments);
        } else if (bundle != null) {
            this.gCq.ad(bundle);
        } else {
            this.gCq.ad(null);
        }
        this.giZ = getVoiceManager();
        this.giZ.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.cHq);
        registerListener(this.gAd);
        registerListener(this.gjY);
        this.gzX = new FrsLoadMoreModel(this, null);
        this.gzX.registerListener();
        this.gzX.setPageType(3);
        this.gzX.lK(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.bZc = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.gCr = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.fJL) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                lH(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        aDT();
    }

    private void aDT() {
        an anVar = new an("c13008");
        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cp("fid", this.forumId);
        anVar.Z("obj_type", 6);
        anVar.Z("obj_locate", 2);
        anVar.aDT();
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
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.giS = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bFX() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.djU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gCr != null) {
            this.gCr.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.glU);
        com.baidu.tieba.r.c.cHo().x(getUniqueId());
        r.bsy().kc(false);
        super.onDestroy();
        this.gCq.afZ();
        this.giZ = getVoiceManager();
        this.giZ.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.gAc);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.giS);
        bundle.putString("from", this.mFrom);
        this.gCq.onSaveInstanceState(bundle);
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
                    this.gCr.bGS().notifyDataSetChanged();
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
                            this.gCr.bGc();
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
        if (this.gCr != null) {
            this.gCr.bCm();
        }
        this.giZ = getVoiceManager();
        this.giZ.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.gCr.a(this.gkt);
        this.gCr.setOnScrollListener(this.mScrollListener);
        this.gCr.setListPullRefreshListener(this.emI);
        this.gCr.a(this.dcs);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gqv != 3 || this.gCr != null) {
            this.gqv = i;
            super.onChangeSkinType(i);
            if (this.gCr != null) {
                this.gCr.onChangeSkinType(i);
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
                com.baidu.adp.lib.f.h.gz().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.IL(FrsNewAreaFragment.this.giS);
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
                this.gCr.bdR();
                this.giS = this.giA.getForum().getName();
                this.forumId = this.giA.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.giA.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.giA.getUserData().getBimg_end_time());
                bBz();
                ArrayList<m> threadList = this.giA.getThreadList();
                if (threadList != null) {
                    this.gCr.a(threadList, this.mPn, this.giA, this.giA.getPage().ayy());
                    bFZ();
                    this.gCr.bGc();
                    if (this.giA.getIsNewUrl() == 1) {
                        this.gCr.bGS().setFromCDN(true);
                    } else {
                        this.gCr.bGS().setFromCDN(false);
                    }
                    this.gCr.setListViewSelection(bO(bGQ().getType(), this.mPn));
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

    public void bDW() {
        if (this.gCr != null) {
            this.gCr.refreshView();
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
            this.gCr.bGS().b(threadList, this.giA);
            this.gCr.bGS().notifyDataSetChanged();
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
        if (this.gCr == null) {
            return null;
        }
        return this.gCr.getListView();
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
        if (this.giA != null && this.gCr != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.gCr.bCm();
            }
        }
    }

    private void bFZ() {
        HashMap<Integer, bj> bEu;
        if (this.gCr != null && this.gCr.bGS() != null && (bEu = this.gCr.bGS().bEu()) != null) {
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
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            lH(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bBI() {
        return this.giA;
    }

    public FrsNewAreaModelController bGQ() {
        return this.gCq;
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

    public void aZs() {
        if (!this.gzX.isLoading && !this.gCq.isLoading()) {
            if (this.gzX.cr(this.giA.getThreadListIds())) {
                this.gCr.a(this.gzX.bGt(), this.mPn, this.giA, 0);
                this.gzX.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.giA.getThreadListIds(), this.giS, this.mPn, this.giA.isBrandForum);
            } else if (this.fmo != 0) {
                this.gCr.a(this.gzX.bGt(), this.mPn, this.giA, 0);
                this.mPn++;
                this.gCq.tz(this.mPn);
                this.gzX.loadingDone = false;
                this.gzX.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.gCr.baH();
        } else if (!this.gCr.bCu()) {
            if (!this.gCq.bGj()) {
                this.gCr.baH();
                return;
            }
            aZH();
            aZs();
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.gzX.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.giA.setThreadList(a);
            this.gCr.a(a, this.mPn, this.giA, 0);
        }
    }

    public void cs(List<String> list) {
        ch(list);
        int i = 0;
        Iterator<m> it = this.giA.getThreadList().iterator();
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
            aZs();
        }
    }

    private void ch(List<String> list) {
        if (!v.isEmpty(list)) {
            ArrayList<m> threadList = this.giA.getThreadList();
            if (!v.isEmpty(threadList) && this.gCr.getListView() != null && this.gCr.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.gCr.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).cMR;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.gzX.d(next);
                                this.gCr.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel bFY() {
        return this.gzX;
    }

    private void aZH() {
        if (this.fmo == 0 && !this.gzX.cr(this.giA.getThreadListIds())) {
            if (this.giA.getThreadList() == null || this.giA.getThreadList().size() == 0) {
                this.gCr.baH();
                return;
            } else {
                this.gCr.baG();
                return;
            }
        }
        this.gCr.baF();
    }

    public g bGR() {
        return this.gCr;
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
        if (this.gCq != null) {
            this.gCq.bBC();
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

    @Override // com.baidu.tieba.frs.ah
    public void scrollToTop() {
        if (this.gCr != null && this.gCr.getListView() != null) {
            this.gCr.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void baE() {
        if (this.gCr != null) {
            scrollToTop();
            this.gCr.startPullRefresh();
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.giA != null) {
            i = this.giA.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.tW(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }
}
