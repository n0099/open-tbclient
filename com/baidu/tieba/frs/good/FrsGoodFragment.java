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
import com.baidu.n.a.a;
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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.l.c;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.recapp.p;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.f;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.util.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes22.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0276a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ar, as, at, com.baidu.tieba.frs.loadmore.a, p, FrsCommonImageLayout.c {
    private VoiceManager iSU;
    private c iZg;
    private String jpJ;
    private FrsGoodModelController jpL;
    private FrsLoadMoreModel jpM;
    private com.baidu.tieba.frs.gametab.b jpO;
    private String mForumId;
    private String iSN = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean jpK = false;
    private String forumId = null;
    private FrsViewData iSt = new FrsViewData();
    public long ivy = -1;
    public long fCb = 0;
    public long fCl = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected a jpN = null;
    private int hKX = -1;
    private int mTabId = 0;
    private int jbR = 3;
    private boolean ipB = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iTu = new SparseArray<>();
    private boolean jpP = false;
    private int dOW = 0;
    private int iTS = 0;
    private CustomMessageListener iWx = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.iZg != null && FrsGoodFragment.this.iZg.isViewAttached()) {
                FrsGoodFragment.this.iZg.sB(num.intValue());
            }
        }
    };
    private Runnable jpQ = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.ipB) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.qM(false);
            }
        }
    };
    private CustomMessageListener jpR = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof by)) {
                by byVar = (by) customResponsedMessage.getData();
                FrsGoodFragment.this.jpJ = byVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.jpJ) && byVar.boA() != null) {
                    FrsGoodFragment.this.Bf(byVar.boA().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener iUh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.bvQ() != null) {
                        FrsGoodFragment.this.bvQ().setSelection(0);
                    }
                    if (FrsGoodFragment.this.iZg != null && FrsGoodFragment.this.iZg.isViewAttached()) {
                        FrsGoodFragment.this.qM(false);
                    } else if (FrsGoodFragment.this.jpN != null) {
                        FrsGoodFragment.this.jpN.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s iUz = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long jpU = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void zJ(int i) {
            if (!FrsGoodFragment.this.jpP) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.jpN.cDr();
                        return;
                    case 3:
                        FrsGoodFragment.this.jpN.lx(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, f fVar) {
            ArrayList<q> a2;
            if (FrsGoodFragment.this.jpP) {
                if (FrsGoodFragment.this.cIw().cIE() == null) {
                    FrsGoodFragment.this.jpP = false;
                    return;
                } else if (FrsGoodFragment.this.cIw().cIE().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.jpP = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jpU = 1L;
            } else if (fVar.isSuccess) {
                this.jpU = 0L;
            } else {
                this.jpU = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.jpM.resetData();
            }
            FrsGoodFragment.this.jpN.lx(false);
            if (FrsGoodFragment.this.cIw().cIE() != null) {
                FrsGoodFragment.this.iSt = FrsGoodFragment.this.cIw().cIE();
            }
            FrsGoodFragment.this.hKX = FrsGoodFragment.this.iSt.getPage().bnF();
            if (FrsGoodFragment.this.hKX != 0 || (FrsGoodFragment.this.iSt.getThreadListIds() != null && FrsGoodFragment.this.iSt.getThreadListIds().size() != 0)) {
                if (y.getCount(FrsGoodFragment.this.iSt.getThreadList()) > 3) {
                    FrsGoodFragment.this.jpN.XZ();
                } else {
                    FrsGoodFragment.this.jpN.cDG();
                }
            } else if (FrsGoodFragment.this.iSt.getThreadList() == null || FrsGoodFragment.this.iSt.getThreadList().size() == 0) {
                FrsGoodFragment.this.jpN.bTa();
            } else {
                FrsGoodFragment.this.jpN.Ya();
            }
            if (i == 4) {
                ArrayList<q> a3 = FrsGoodFragment.this.jpM.a(false, false, false, FrsGoodFragment.this.iSt.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsGoodFragment.this.iSt.setThreadList(a3);
                    FrsGoodFragment.this.jpN.a(a3, FrsGoodFragment.this.mPn, FrsGoodFragment.this.iSt, FrsGoodFragment.this.hKX);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.jpN.cDr();
                    break;
                case 2:
                    FrsGoodFragment.this.jpN.cDr();
                    break;
                case 3:
                    if (FrsGoodFragment.this.iSt.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.jpU != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.iSt != null) {
                    FrsGoodFragment.this.iSN = FrsGoodFragment.this.iSt.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.iSt.getForum().getId();
                    FrsGoodFragment.this.jpN.b(FrsGoodFragment.this.iSt.getForum(), FrsGoodFragment.this.iSt.getUserData());
                }
                if (FrsGoodFragment.this.iSt != null) {
                    FrsGoodFragment.this.iSt.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.jpN.c(FrsGoodFragment.this.iSt);
                if (FrsGoodFragment.this.iSt == null || FrsGoodFragment.this.iSt.getThreadList() == null || FrsGoodFragment.this.iSt.getThreadList().size() != 0 || FrsGoodFragment.this.cIw().getType() != 4) {
                    if (FrsGoodFragment.this.iSt != null && (a2 = FrsGoodFragment.this.jpM.a(false, false, true, FrsGoodFragment.this.iSt.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsGoodFragment.this.iSt.setThreadList(a2);
                    }
                    FrsGoodFragment.this.cCy();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.ivy > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.ivy, FrsGoodFragment.this.cIw().cwo() - FrsGoodFragment.this.ivy, FrsGoodFragment.this.cIw().cwm(), FrsGoodFragment.this.cIw().cwn(), currentTimeMillis2 - FrsGoodFragment.this.cIw().cwl());
                        FrsGoodFragment.this.ivy = -1L;
                    }
                    FrsGoodFragment.this.fCl = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.ivy > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.ivy, FrsGoodFragment.this.cIw().cwo() - FrsGoodFragment.this.ivy, FrsGoodFragment.this.cIw().cwm(), FrsGoodFragment.this.cIw().cwn(), currentTimeMillis3 - FrsGoodFragment.this.cIw().cwl());
                FrsGoodFragment.this.ivy = -1L;
            }
            FrsGoodFragment.this.fCl = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCs() {
        }
    };
    private final CustomMessageListener eCA = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.jpN != null) {
                FrsGoodFragment.this.jpN.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                t.csg().oX(true);
                com.baidu.tieba.t.c.dOe().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.iTS += i2;
            if (FrsGoodFragment.this.iTS >= FrsGoodFragment.this.dOW * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener flC = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private ab iUG = new ab() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bx)) {
                by byVar = ((bx) qVar).eCR;
                if (byVar.bpR() == null || byVar.bpR().getGroup_id() == 0 || bh.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (byVar.bpC() != 1 || bh.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Ub(byVar.getId())) {
                            readThreadHistory.Ua(byVar.getId());
                            if (FrsGoodFragment.this.jpN != null) {
                                FrsGoodFragment.this.jpN.cDr();
                            }
                        }
                        boolean z = false;
                        final String boV = byVar.boV();
                        if (boV != null && !boV.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(boV);
                                    aaVar.btv().bue().mIsNeedAddCommenParam = false;
                                    aaVar.btv().bue().mIsUseCurrentBDUSS = false;
                                    aaVar.getNetData();
                                }
                            }).start();
                        }
                        String str = null;
                        if (byVar != null) {
                            str = byVar.getTid();
                        }
                        if (str == null) {
                            str = "";
                        }
                        if (byVar.boK() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bf.bua().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3 && str.length() > 3) {
                            byVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(byVar, FrsGoodFragment.this.iSN, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(byVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.iSt != null && FrsGoodFragment.this.iSt.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.jtP = FrsGoodFragment.this.iSt.needLog == 1;
                            bVar.jtR = FrsGoodFragment.this.iSt.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.jcS != null) {
                                bVar.jtS = com.baidu.tieba.frs.d.d.jcS.jtS;
                                bVar.jtT = com.baidu.tieba.frs.d.d.jcS.jtT;
                            }
                            com.baidu.tieba.frs.d.a.a(byVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener iUK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.jpN != null) {
                FrsGoodFragment.this.jpN.HO();
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

    public void cFp() {
        if (this.jpN != null) {
            this.jpN.refreshView();
        }
    }

    private void showLoadingView() {
        this.jpN.qr(false);
        showLoadingView(this.jpN.cnn(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jpN.qr(true);
        hideLoadingView(this.jpN.cnn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.jpN.qr(false);
        this.jpN.qq(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jpN.bTa();
        this.jpN.getListView().getData().clear();
        this.jpN.cDr();
        if (this.iZg == null) {
            this.iZg = new c(getPageContext().getContext(), getNetRefreshListener());
            this.iZg.setTitle(null);
            this.iZg.setButtonText(null);
            this.iZg.showRefreshButton();
            this.iZg.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.iZg.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.iZg.setSubText(null);
        }
        this.iZg.onChangeSkinType();
        this.iZg.attachView(this.jpN.cnn(), true);
        registerListener(this.iWx);
    }

    private void Yb() {
        this.jpN.qr(true);
        this.jpN.qq(true);
        if (this.iZg != null && this.iZg.isViewAttached()) {
            this.iZg.dettachView(this.jpN.cnn());
        }
        MessageManager.getInstance().unRegisterListener(this.iWx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(boolean z) {
        this.ipB = true;
        cCE();
        Yb();
        if (!z) {
            Yb();
            showLoadingView();
        }
        this.jpL.uY(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ivy = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.ivy = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.fCb = this.beginTime - this.ivy;
        super.onCreate(bundle);
        com.baidu.tieba.t.c.dOe().z(getUniqueId());
        this.jpL = new FrsGoodModelController(this);
        if (arguments != null) {
            this.jpL.aj(arguments);
            this.jpK = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.jpL.aj(bundle);
            this.jpK = bundle.getBoolean("is_game_frs", false);
        } else {
            this.jpL.aj(null);
        }
        this.iSU = getVoiceManager();
        this.iSU.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eCA);
        registerListener(this.jpR);
        registerListener(this.iUh);
        registerListener(this.iUK);
        this.jpM = new FrsLoadMoreModel(this, null);
        this.jpM.registerListener();
        this.jpM.setPageType(2);
        this.jpM.qO(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dOW = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jpN = new a(this, inflate, this.jpK);
        this.jpN.cIA().cIH();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.ipB) {
            if (j.isNetWorkAvailable()) {
                qM(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13008").dY("fid", this.mForumId).dY("obj_type", "7").al("obj_locate", 2).dY("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.iSU = getVoiceManager();
        this.iSU.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cIt();
        if (bundle != null) {
            this.iSN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.iSN = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cIt() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.flC);
    }

    public FrsLoadMoreModel cIu() {
        return this.jpM;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jpN != null) {
            this.jpN.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iWx);
        com.baidu.tieba.t.c.dOe().A(getUniqueId());
        t.csg().oX(false);
        super.onDestroy();
        this.jpL.cIC();
        this.iSU = getVoiceManager();
        this.iSU.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jpQ);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iSN);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.jpK);
        this.jpL.onSaveInstanceState(bundle);
        this.iSU = getVoiceManager();
        if (this.iSU != null) {
            this.iSU.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        by threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jpN.cIA().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.iSt.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.oG(intent.getIntExtra("good_data", 0));
                            threadDataById.bpP();
                            qM(false);
                            return;
                        } else if (intExtra == 0) {
                            this.iSt.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.iSt.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jpN.cIy();
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
            if (this.jbR == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.ipB) {
                com.baidu.adp.lib.f.e.mY().post(this.jpQ);
            }
        }
        cEH();
    }

    private void cEH() {
        if (isPrimary()) {
            if (this.iZg != null && this.iZg.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iWx);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iWx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jpN != null) {
            this.jpN.cDr();
        }
        this.iSU = getVoiceManager();
        this.iSU.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jpO = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.jpN.a(this.iUG);
        this.jpN.setOnScrollListener(this.mScrollListener);
        this.jpN.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.jpO != null) {
                    FrsGoodFragment.this.jpO.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jbR != 3 || this.jpN != null) {
            this.jbR = i;
            super.onChangeSkinType(i);
            if (this.jpN != null) {
                this.jpN.onChangeSkinType(i);
            }
            if (this.iZg != null && this.iZg.isViewAttached()) {
                this.iZg.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBr() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cBr();
        }
        return null;
    }

    private void cCx() {
        switch (this.mFlag) {
            case 1:
                h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TV(FrsGoodFragment.this.iSN);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCy() {
        cCE();
        try {
            if (this.iSt != null) {
                this.jpN.cER();
                this.jpN.bYs();
                this.iSN = this.iSt.getForum().getName();
                this.forumId = this.iSt.getForum().getId();
                if (this.iSt != null && this.iSt.getForum() != null) {
                    this.jpN.a(this.iSt.getForum().getThemeColorInfo());
                    this.jpN.c(this.iSt);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.iSt.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iSt.getUserData().getBimg_end_time());
                cCx();
                if (!this.jpN.cIA().r(by.eJr)) {
                    this.iSt.removeAlaLiveThreadData();
                }
                ArrayList<q> threadList = this.iSt.getThreadList();
                if (threadList != null) {
                    this.jpN.a(threadList, this.mPn, this.iSt, this.iSt.getPage().bnF());
                    cIv();
                    this.jpN.cIy();
                    if (this.iSt.getIsNewUrl() == 1) {
                        this.jpN.cIA().setFromCDN(true);
                    } else {
                        this.jpN.cIA().setFromCDN(false);
                    }
                    this.jpN.setListViewSelection(cD(cIw().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cD(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.iSU = getVoiceManager();
        this.iSU.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.csg().oX(false);
        com.baidu.tieba.t.c.dOe().b(getUniqueId(), false);
        if (this.iSt != null && this.iSt.getForum() != null) {
            com.baidu.tbadk.distribute.a.bCa().b(getPageContext().getPageActivity(), "frs", this.iSt.getForum().getId(), 0L);
        }
        this.iSU = getVoiceManager();
        if (this.iSU != null) {
            this.iSU.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bf(int i) {
        ArrayList<q> threadList = this.iSt.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bx) {
                    by byVar = ((bx) next).eCR;
                    if (byVar.getId() != null && byVar.getId().equals(this.jpJ)) {
                        c(byVar, i);
                        this.jpJ = null;
                        break;
                    }
                }
            }
            this.jpN.cIA().b(threadList, this.iSt);
            this.jpN.cIA().notifyDataSetChanged();
        }
    }

    private void c(by byVar, int i) {
        if (i == 1) {
            PraiseData boA = byVar.boA();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (boA == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    byVar.a(praiseData);
                    return;
                }
                byVar.boA().getUser().add(0, metaData);
                byVar.boA().setNum(byVar.boA().getNum() + 1);
                byVar.boA().setIsLike(i);
            }
        } else if (byVar.boA() != null) {
            byVar.boA().setIsLike(i);
            byVar.boA().setNum(byVar.boA().getNum() - 1);
            ArrayList<MetaData> user = byVar.boA().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        byVar.boA().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iSU == null) {
            this.iSU = VoiceManager.instance();
        }
        return this.iSU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView bvQ() {
        if (this.jpN == null) {
            return null;
        }
        return this.jpN.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cCE() {
        this.iSU = getVoiceManager();
        this.iSU.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bvR() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bvR();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.iSt != null && this.jpN != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jpN.cDr();
            }
        }
    }

    private void cIv() {
        HashMap<Integer, by> cFW;
        if (this.jpN != null && this.jpN.cIA() != null && (cFW = this.jpN.cIA().cFW()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, by> entry : cFW.entrySet()) {
                by value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bCg().L(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        if (bvQ() == null) {
            return null;
        }
        return bvQ().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            qM(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cCJ() {
        return this.iSt;
    }

    public FrsGoodModelController cIw() {
        return this.jpL;
    }

    public void Lv(String str) {
        this.iSN = str;
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
            this.jpN.bTa();
        } else if (!this.jpL.cIG()) {
            this.jpN.bTa();
        } else {
            bSb();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.jpM.isLoading && !this.jpL.isLoading()) {
                if (this.jpM.dx(this.iSt.getThreadListIds())) {
                    this.jpN.a(this.jpM.cIR(), this.mPn, this.iSt, 0);
                    this.jpM.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.iSt.getThreadListIds(), this.iSN, this.mPn, this.iSt.isBrandForum);
                } else if (this.hKX != 0) {
                    this.jpN.a(this.jpM.cIR(), this.mPn, this.iSt, 0);
                    this.mPn++;
                    this.jpL.Bh(this.mPn);
                    this.jpM.loadingDone = false;
                    this.jpM.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bSb();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void az(ArrayList<q> arrayList) {
        bSb();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<q> a2 = this.jpM.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.iSt.setThreadList(a2);
                this.jpN.a(a2, this.mPn, this.iSt, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iSt.getForum()));
        }
    }

    private void bSb() {
        if (this.hKX == 0 && !this.jpM.dx(this.iSt.getThreadListIds())) {
            if (this.iSt.getThreadList() == null || this.iSt.getThreadList().size() == 0) {
                this.jpN.bTa();
            } else {
                this.jpN.Ya();
            }
        } else if (y.getCount(this.iSt.getThreadList()) > 3) {
            this.jpN.XZ();
        } else {
            this.jpN.cDG();
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.n.a.a.InterfaceC0276a
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

    @Override // com.baidu.tieba.recapp.p
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.p
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bCa().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.p
    public void cCD() {
        if (this.jpL != null) {
            this.jpL.cCD();
        }
    }

    @Override // com.baidu.tieba.recapp.p
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.p
    public int getPageNum() {
        return this.mPn;
    }

    @Override // com.baidu.tieba.frs.as
    public NavigationBar bVK() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iSN;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.iSt != null) {
            i = this.iSt.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.j.BF(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bg(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            qM(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void cBL() {
        if (this.jpN != null && this.jpN.getListView() != null) {
            this.jpN.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bSZ() {
        if (this.jpN != null) {
            cBL();
            this.jpN.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iTu.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ub(int i) {
        return this.iTu.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.at
    public void bvq() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bLT().Fn("page_frs_good");
            qM(true);
            return;
        }
        this.jpN.lx(false);
    }

    @Override // com.baidu.tieba.frs.at
    public void bvr() {
        com.baidu.tieba.t.c.dOe().b(getUniqueId(), false);
    }

    public void a(au auVar) {
        if (auVar != null && cCJ() != null && cCJ().getThreadList() != null) {
            if (y.isEmpty(cCJ().getThreadList())) {
                cCJ().getThreadList().add(auVar);
            } else {
                if (cCJ().getThreadList().size() == 1 && (cCJ().getThreadList().get(0) instanceof com.baidu.tieba.frs.s)) {
                    cCJ().getThreadList().remove(0);
                }
                cCJ().getThreadList().add(0, auVar);
            }
            this.jpN.a(this.iSt.getThreadList(), this.mPn, this.iSt, this.iSt.getPage().bnF());
            this.jpN.cIy();
            this.jpN.setListViewSelection(0);
        }
    }
}
