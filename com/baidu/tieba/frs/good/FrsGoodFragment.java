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
    private VoiceManager iSW;
    private c iZi;
    private String jpL;
    private FrsGoodModelController jpN;
    private FrsLoadMoreModel jpO;
    private com.baidu.tieba.frs.gametab.b jpQ;
    private String mForumId;
    private String iSP = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean jpM = false;
    private String forumId = null;
    private FrsViewData iSv = new FrsViewData();
    public long ivA = -1;
    public long fCb = 0;
    public long fCl = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected a jpP = null;
    private int hKZ = -1;
    private int mTabId = 0;
    private int jbT = 3;
    private boolean ipD = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iTw = new SparseArray<>();
    private boolean jpR = false;
    private int dOW = 0;
    private int iTU = 0;
    private CustomMessageListener iWz = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.iZi != null && FrsGoodFragment.this.iZi.isViewAttached()) {
                FrsGoodFragment.this.iZi.sB(num.intValue());
            }
        }
    };
    private Runnable jpS = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.ipD) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.qM(false);
            }
        }
    };
    private CustomMessageListener jpT = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof by)) {
                by byVar = (by) customResponsedMessage.getData();
                FrsGoodFragment.this.jpL = byVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.jpL) && byVar.boA() != null) {
                    FrsGoodFragment.this.Bf(byVar.boA().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener iUj = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.bvQ() != null) {
                        FrsGoodFragment.this.bvQ().setSelection(0);
                    }
                    if (FrsGoodFragment.this.iZi != null && FrsGoodFragment.this.iZi.isViewAttached()) {
                        FrsGoodFragment.this.qM(false);
                    } else if (FrsGoodFragment.this.jpP != null) {
                        FrsGoodFragment.this.jpP.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s iUB = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long jpW = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void zJ(int i) {
            if (!FrsGoodFragment.this.jpR) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.jpP.cDs();
                        return;
                    case 3:
                        FrsGoodFragment.this.jpP.lx(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, f fVar) {
            ArrayList<q> a2;
            if (FrsGoodFragment.this.jpR) {
                if (FrsGoodFragment.this.cIx().cIF() == null) {
                    FrsGoodFragment.this.jpR = false;
                    return;
                } else if (FrsGoodFragment.this.cIx().cIF().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.jpR = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jpW = 1L;
            } else if (fVar.isSuccess) {
                this.jpW = 0L;
            } else {
                this.jpW = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.jpO.resetData();
            }
            FrsGoodFragment.this.jpP.lx(false);
            if (FrsGoodFragment.this.cIx().cIF() != null) {
                FrsGoodFragment.this.iSv = FrsGoodFragment.this.cIx().cIF();
            }
            FrsGoodFragment.this.hKZ = FrsGoodFragment.this.iSv.getPage().bnF();
            if (FrsGoodFragment.this.hKZ != 0 || (FrsGoodFragment.this.iSv.getThreadListIds() != null && FrsGoodFragment.this.iSv.getThreadListIds().size() != 0)) {
                if (y.getCount(FrsGoodFragment.this.iSv.getThreadList()) > 3) {
                    FrsGoodFragment.this.jpP.XZ();
                } else {
                    FrsGoodFragment.this.jpP.cDH();
                }
            } else if (FrsGoodFragment.this.iSv.getThreadList() == null || FrsGoodFragment.this.iSv.getThreadList().size() == 0) {
                FrsGoodFragment.this.jpP.bTb();
            } else {
                FrsGoodFragment.this.jpP.Ya();
            }
            if (i == 4) {
                ArrayList<q> a3 = FrsGoodFragment.this.jpO.a(false, false, false, FrsGoodFragment.this.iSv.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsGoodFragment.this.iSv.setThreadList(a3);
                    FrsGoodFragment.this.jpP.a(a3, FrsGoodFragment.this.mPn, FrsGoodFragment.this.iSv, FrsGoodFragment.this.hKZ);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.jpP.cDs();
                    break;
                case 2:
                    FrsGoodFragment.this.jpP.cDs();
                    break;
                case 3:
                    if (FrsGoodFragment.this.iSv.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.jpW != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.iSv != null) {
                    FrsGoodFragment.this.iSP = FrsGoodFragment.this.iSv.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.iSv.getForum().getId();
                    FrsGoodFragment.this.jpP.b(FrsGoodFragment.this.iSv.getForum(), FrsGoodFragment.this.iSv.getUserData());
                }
                if (FrsGoodFragment.this.iSv != null) {
                    FrsGoodFragment.this.iSv.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.jpP.c(FrsGoodFragment.this.iSv);
                if (FrsGoodFragment.this.iSv == null || FrsGoodFragment.this.iSv.getThreadList() == null || FrsGoodFragment.this.iSv.getThreadList().size() != 0 || FrsGoodFragment.this.cIx().getType() != 4) {
                    if (FrsGoodFragment.this.iSv != null && (a2 = FrsGoodFragment.this.jpO.a(false, false, true, FrsGoodFragment.this.iSv.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsGoodFragment.this.iSv.setThreadList(a2);
                    }
                    FrsGoodFragment.this.cCz();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.ivA > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.ivA, FrsGoodFragment.this.cIx().cwp() - FrsGoodFragment.this.ivA, FrsGoodFragment.this.cIx().cwn(), FrsGoodFragment.this.cIx().cwo(), currentTimeMillis2 - FrsGoodFragment.this.cIx().cwm());
                        FrsGoodFragment.this.ivA = -1L;
                    }
                    FrsGoodFragment.this.fCl = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.ivA > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.ivA, FrsGoodFragment.this.cIx().cwp() - FrsGoodFragment.this.ivA, FrsGoodFragment.this.cIx().cwn(), FrsGoodFragment.this.cIx().cwo(), currentTimeMillis3 - FrsGoodFragment.this.cIx().cwm());
                FrsGoodFragment.this.ivA = -1L;
            }
            FrsGoodFragment.this.fCl = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCt() {
        }
    };
    private final CustomMessageListener eCA = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.jpP != null) {
                FrsGoodFragment.this.jpP.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                t.csh().oX(true);
                com.baidu.tieba.t.c.dOf().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.iTU += i2;
            if (FrsGoodFragment.this.iTU >= FrsGoodFragment.this.dOW * 2 && i2 < 0) {
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
    private ab iUI = new ab() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
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
                            if (FrsGoodFragment.this.jpP != null) {
                                FrsGoodFragment.this.jpP.cDs();
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
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(byVar, FrsGoodFragment.this.iSP, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(byVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.iSv != null && FrsGoodFragment.this.iSv.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.jtR = FrsGoodFragment.this.iSv.needLog == 1;
                            bVar.jtT = FrsGoodFragment.this.iSv.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.jcU != null) {
                                bVar.jtU = com.baidu.tieba.frs.d.d.jcU.jtU;
                                bVar.jtV = com.baidu.tieba.frs.d.d.jcU.jtV;
                            }
                            com.baidu.tieba.frs.d.a.a(byVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener iUM = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.jpP != null) {
                FrsGoodFragment.this.jpP.HO();
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

    public void cFq() {
        if (this.jpP != null) {
            this.jpP.refreshView();
        }
    }

    private void showLoadingView() {
        this.jpP.qr(false);
        showLoadingView(this.jpP.cno(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jpP.qr(true);
        hideLoadingView(this.jpP.cno());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.jpP.qr(false);
        this.jpP.qq(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jpP.bTb();
        this.jpP.getListView().getData().clear();
        this.jpP.cDs();
        if (this.iZi == null) {
            this.iZi = new c(getPageContext().getContext(), getNetRefreshListener());
            this.iZi.setTitle(null);
            this.iZi.setButtonText(null);
            this.iZi.showRefreshButton();
            this.iZi.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.iZi.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.iZi.setSubText(null);
        }
        this.iZi.onChangeSkinType();
        this.iZi.attachView(this.jpP.cno(), true);
        registerListener(this.iWz);
    }

    private void Yb() {
        this.jpP.qr(true);
        this.jpP.qq(true);
        if (this.iZi != null && this.iZi.isViewAttached()) {
            this.iZi.dettachView(this.jpP.cno());
        }
        MessageManager.getInstance().unRegisterListener(this.iWz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(boolean z) {
        this.ipD = true;
        cCF();
        Yb();
        if (!z) {
            Yb();
            showLoadingView();
        }
        this.jpN.uY(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ivA = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.ivA = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.fCb = this.beginTime - this.ivA;
        super.onCreate(bundle);
        com.baidu.tieba.t.c.dOf().z(getUniqueId());
        this.jpN = new FrsGoodModelController(this);
        if (arguments != null) {
            this.jpN.aj(arguments);
            this.jpM = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.jpN.aj(bundle);
            this.jpM = bundle.getBoolean("is_game_frs", false);
        } else {
            this.jpN.aj(null);
        }
        this.iSW = getVoiceManager();
        this.iSW.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eCA);
        registerListener(this.jpT);
        registerListener(this.iUj);
        registerListener(this.iUM);
        this.jpO = new FrsLoadMoreModel(this, null);
        this.jpO.registerListener();
        this.jpO.setPageType(2);
        this.jpO.qO(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dOW = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jpP = new a(this, inflate, this.jpM);
        this.jpP.cIB().cII();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.ipD) {
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
        this.iSW = getVoiceManager();
        this.iSW.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cIu();
        if (bundle != null) {
            this.iSP = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.iSP = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cIu() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.flC);
    }

    public FrsLoadMoreModel cIv() {
        return this.jpO;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jpP != null) {
            this.jpP.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iWz);
        com.baidu.tieba.t.c.dOf().A(getUniqueId());
        t.csh().oX(false);
        super.onDestroy();
        this.jpN.cID();
        this.iSW = getVoiceManager();
        this.iSW.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jpS);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iSP);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.jpM);
        this.jpN.onSaveInstanceState(bundle);
        this.iSW = getVoiceManager();
        if (this.iSW != null) {
            this.iSW.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        by threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jpP.cIB().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.iSv.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.oG(intent.getIntExtra("good_data", 0));
                            threadDataById.bpP();
                            qM(false);
                            return;
                        } else if (intExtra == 0) {
                            this.iSv.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.iSv.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jpP.cIz();
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
            if (this.jbT == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.ipD) {
                com.baidu.adp.lib.f.e.mY().post(this.jpS);
            }
        }
        cEI();
    }

    private void cEI() {
        if (isPrimary()) {
            if (this.iZi != null && this.iZi.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iWz);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iWz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jpP != null) {
            this.jpP.cDs();
        }
        this.iSW = getVoiceManager();
        this.iSW.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jpQ = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.jpP.a(this.iUI);
        this.jpP.setOnScrollListener(this.mScrollListener);
        this.jpP.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.jpQ != null) {
                    FrsGoodFragment.this.jpQ.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jbT != 3 || this.jpP != null) {
            this.jbT = i;
            super.onChangeSkinType(i);
            if (this.jpP != null) {
                this.jpP.onChangeSkinType(i);
            }
            if (this.iZi != null && this.iZi.isViewAttached()) {
                this.iZi.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBs() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cBs();
        }
        return null;
    }

    private void cCy() {
        switch (this.mFlag) {
            case 1:
                h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TV(FrsGoodFragment.this.iSP);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCz() {
        cCF();
        try {
            if (this.iSv != null) {
                this.jpP.cES();
                this.jpP.bYt();
                this.iSP = this.iSv.getForum().getName();
                this.forumId = this.iSv.getForum().getId();
                if (this.iSv != null && this.iSv.getForum() != null) {
                    this.jpP.a(this.iSv.getForum().getThemeColorInfo());
                    this.jpP.c(this.iSv);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.iSv.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iSv.getUserData().getBimg_end_time());
                cCy();
                if (!this.jpP.cIB().r(by.eJr)) {
                    this.iSv.removeAlaLiveThreadData();
                }
                ArrayList<q> threadList = this.iSv.getThreadList();
                if (threadList != null) {
                    this.jpP.a(threadList, this.mPn, this.iSv, this.iSv.getPage().bnF());
                    cIw();
                    this.jpP.cIz();
                    if (this.iSv.getIsNewUrl() == 1) {
                        this.jpP.cIB().setFromCDN(true);
                    } else {
                        this.jpP.cIB().setFromCDN(false);
                    }
                    this.jpP.setListViewSelection(cD(cIx().getType(), this.mPn));
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
        this.iSW = getVoiceManager();
        this.iSW.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.csh().oX(false);
        com.baidu.tieba.t.c.dOf().b(getUniqueId(), false);
        if (this.iSv != null && this.iSv.getForum() != null) {
            com.baidu.tbadk.distribute.a.bCa().b(getPageContext().getPageActivity(), "frs", this.iSv.getForum().getId(), 0L);
        }
        this.iSW = getVoiceManager();
        if (this.iSW != null) {
            this.iSW.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bf(int i) {
        ArrayList<q> threadList = this.iSv.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bx) {
                    by byVar = ((bx) next).eCR;
                    if (byVar.getId() != null && byVar.getId().equals(this.jpL)) {
                        c(byVar, i);
                        this.jpL = null;
                        break;
                    }
                }
            }
            this.jpP.cIB().b(threadList, this.iSv);
            this.jpP.cIB().notifyDataSetChanged();
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
        if (this.iSW == null) {
            this.iSW = VoiceManager.instance();
        }
        return this.iSW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView bvQ() {
        if (this.jpP == null) {
            return null;
        }
        return this.jpP.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cCF() {
        this.iSW = getVoiceManager();
        this.iSW.stopPlay();
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
        if (this.iSv != null && this.jpP != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jpP.cDs();
            }
        }
    }

    private void cIw() {
        HashMap<Integer, by> cFX;
        if (this.jpP != null && this.jpP.cIB() != null && (cFX = this.jpP.cIB().cFX()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, by> entry : cFX.entrySet()) {
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
    public FrsViewData cCK() {
        return this.iSv;
    }

    public FrsGoodModelController cIx() {
        return this.jpN;
    }

    public void Lv(String str) {
        this.iSP = str;
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
            this.jpP.bTb();
        } else if (!this.jpN.cIH()) {
            this.jpP.bTb();
        } else {
            bSc();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.jpO.isLoading && !this.jpN.isLoading()) {
                if (this.jpO.dx(this.iSv.getThreadListIds())) {
                    this.jpP.a(this.jpO.cIS(), this.mPn, this.iSv, 0);
                    this.jpO.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.iSv.getThreadListIds(), this.iSP, this.mPn, this.iSv.isBrandForum);
                } else if (this.hKZ != 0) {
                    this.jpP.a(this.jpO.cIS(), this.mPn, this.iSv, 0);
                    this.mPn++;
                    this.jpN.Bh(this.mPn);
                    this.jpO.loadingDone = false;
                    this.jpO.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bSc();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void az(ArrayList<q> arrayList) {
        bSc();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<q> a2 = this.jpO.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.iSv.setThreadList(a2);
                this.jpP.a(a2, this.mPn, this.iSv, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iSv.getForum()));
        }
    }

    private void bSc() {
        if (this.hKZ == 0 && !this.jpO.dx(this.iSv.getThreadListIds())) {
            if (this.iSv.getThreadList() == null || this.iSv.getThreadList().size() == 0) {
                this.jpP.bTb();
            } else {
                this.jpP.Ya();
            }
        } else if (y.getCount(this.iSv.getThreadList()) > 3) {
            this.jpP.XZ();
        } else {
            this.jpP.cDH();
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
    public void cCE() {
        if (this.jpN != null) {
            this.jpN.cCE();
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
    public NavigationBar bVL() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iSP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.iSv != null) {
            i = this.iSv.getSortType();
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
    public void cBM() {
        if (this.jpP != null && this.jpP.getListView() != null) {
            this.jpP.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bTa() {
        if (this.jpP != null) {
            cBM();
            this.jpP.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iTw.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ub(int i) {
        return this.iTw.get(i);
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
            com.baidu.tieba.a.d.bLU().Fn("page_frs_good");
            qM(true);
            return;
        }
        this.jpP.lx(false);
    }

    @Override // com.baidu.tieba.frs.at
    public void bvr() {
        com.baidu.tieba.t.c.dOf().b(getUniqueId(), false);
    }

    public void a(au auVar) {
        if (auVar != null && cCK() != null && cCK().getThreadList() != null) {
            if (y.isEmpty(cCK().getThreadList())) {
                cCK().getThreadList().add(auVar);
            } else {
                if (cCK().getThreadList().size() == 1 && (cCK().getThreadList().get(0) instanceof com.baidu.tieba.frs.s)) {
                    cCK().getThreadList().remove(0);
                }
                cCK().getThreadList().add(0, auVar);
            }
            this.jpP.a(this.iSv.getThreadList(), this.mPn, this.iSv, this.iSv.getPage().bnF());
            this.jpP.cIz();
            this.jpP.setListViewSelection(0);
        }
    }
}
