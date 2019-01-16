package com.baidu.tieba.frs.good;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.k;
import com.baidu.e.a.a;
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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.q.c;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0073a, UserIconBox.b, VoiceManager.c, aj, ak, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private VoiceManager dLz;
    private String ebQ;
    private FrsGoodModelController ebS;
    private FrsLoadMoreModel ebT;
    private com.baidu.tieba.frs.gametab.b ebV;
    private String dLs = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean ebR = false;
    private String forumId = null;
    private l dLc = new l();
    public long dsd = -1;
    public long bgB = 0;
    public long bgJ = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dLH = false;
    protected b ebU = null;
    private int cEV = -1;
    private int mTabId = 0;
    private int dSm = 3;
    private boolean dhl = false;
    public boolean ebW = false;
    private Runnable ebX = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (!j.kV() || FrsGoodFragment.this.dhl) {
                FrsGoodFragment.this.c((d.a) null);
            } else {
                FrsGoodFragment.this.hp(false);
            }
        }
    };
    private CustomMessageListener ebY = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                bb bbVar = (bb) customResponsedMessage.getData();
                FrsGoodFragment.this.ebQ = bbVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.ebQ) && bbVar.zG() != null) {
                    FrsGoodFragment.this.nj(bbVar.zG().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dMu = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.FI() != null) {
                            FrsGoodFragment.this.FI().setSelection(0);
                        }
                        if (FrsGoodFragment.this.mRefreshView != null && FrsGoodFragment.this.mRefreshView.isViewAttached()) {
                            FrsGoodFragment.this.hp(false);
                        } else if (FrsGoodFragment.this.ebU != null) {
                            FrsGoodFragment.this.ebU.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dMH = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        private long ecb = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void mm(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsGoodFragment.this.ebU.aCR();
                    return;
                case 3:
                    FrsGoodFragment.this.ebU.dl(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<h> a;
            if (aVar == null) {
                this.ecb = 1L;
            } else if (aVar.isSuccess) {
                this.ecb = 0L;
            } else {
                this.ecb = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.ebT.resetData();
            }
            FrsGoodFragment.this.ebU.dl(false);
            if (FrsGoodFragment.this.aGR().aGY() != null) {
                FrsGoodFragment.this.dLc = FrsGoodFragment.this.aGR().aGY();
            }
            FrsGoodFragment.this.cEV = FrsGoodFragment.this.dLc.zf().zc();
            if (FrsGoodFragment.this.cEV == 0 && (FrsGoodFragment.this.dLc.bCW() == null || FrsGoodFragment.this.dLc.bCW().size() == 0)) {
                if (FrsGoodFragment.this.dLc.getThreadList() == null || FrsGoodFragment.this.dLc.getThreadList().size() == 0) {
                    FrsGoodFragment.this.ebU.abA();
                } else {
                    FrsGoodFragment.this.ebU.abz();
                }
            } else {
                FrsGoodFragment.this.ebU.aby();
            }
            if (i == 4) {
                ArrayList<h> a2 = FrsGoodFragment.this.ebT.a(false, false, false, FrsGoodFragment.this.dLc.getThreadList(), (e) null);
                if (a2 != null) {
                    FrsGoodFragment.this.dLc.ay(a2);
                    FrsGoodFragment.this.ebU.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.dLc, FrsGoodFragment.this.cEV);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.ebU.aCR();
                    break;
                case 2:
                    FrsGoodFragment.this.ebU.aCR();
                    break;
                case 3:
                    if (FrsGoodFragment.this.dLc.bDn()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.ecb != 0) {
                FrsGoodFragment.this.c(aVar);
            } else {
                if (FrsGoodFragment.this.dLc != null) {
                    FrsGoodFragment.this.dLs = FrsGoodFragment.this.dLc.bhx().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.dLc.bhx().getId();
                    FrsGoodFragment.this.ebU.b(FrsGoodFragment.this.dLc.bhx(), FrsGoodFragment.this.dLc.getUserData());
                }
                if (FrsGoodFragment.this.dLc != null) {
                    FrsGoodFragment.this.dLc.bDH();
                }
                FrsGoodFragment.this.ebU.e(FrsGoodFragment.this.dLc);
                if (FrsGoodFragment.this.dLc == null || FrsGoodFragment.this.dLc.getThreadList() == null || FrsGoodFragment.this.dLc.getThreadList().size() != 0 || FrsGoodFragment.this.aGR().getType() != 4) {
                    if (FrsGoodFragment.this.dLc != null && (a = FrsGoodFragment.this.ebT.a(false, false, true, FrsGoodFragment.this.dLc.getThreadList(), (e) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.dLc.ay(a);
                    }
                    FrsGoodFragment.this.aCg();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(e.j.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.dsd > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.dsd, FrsGoodFragment.this.aGR().awM() - FrsGoodFragment.this.dsd, FrsGoodFragment.this.aGR().awK(), FrsGoodFragment.this.aGR().awL(), currentTimeMillis2 - FrsGoodFragment.this.aGR().awJ());
                        FrsGoodFragment.this.dsd = -1L;
                    }
                    FrsGoodFragment.this.bgJ = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.dsd > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.dsd, FrsGoodFragment.this.aGR().awM() - FrsGoodFragment.this.dsd, FrsGoodFragment.this.aGR().awK(), FrsGoodFragment.this.aGR().awL(), currentTimeMillis3 - FrsGoodFragment.this.aGR().awJ());
                FrsGoodFragment.this.dsd = -1L;
            }
            FrsGoodFragment.this.bgJ = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private final CustomMessageListener aoH = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.ebU != null) {
                FrsGoodFragment.this.ebU.startPullRefresh();
            }
        }
    };
    private final j.b bSe = new j.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        @Override // com.baidu.tbadk.core.view.j.b
        public void bI(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.kV()) {
                com.baidu.tieba.a.d.Wk().ka("page_frs_good");
                FrsGoodFragment.this.hp(true);
                return;
            }
            FrsGoodFragment.this.ebU.dl(false);
        }
    };
    private final j.a aJi = new j.a() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
        @Override // com.baidu.tbadk.core.view.j.a
        public void b(View view, boolean z) {
            if (z) {
                c.bCC().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.dLH) {
                FrsGoodFragment.this.dLH = true;
                FrsGoodFragment.this.ebU.aDe();
            }
            if (i == 0) {
                v.aqP().fy(true);
                c.bCC().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener aQA = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                FrsGoodFragment.this.e(customResponsedMessage);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n dMN = new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bb)) {
                bb bbVar = (bb) hVar;
                if (bbVar.AF() == null || bbVar.AF().getGroup_id() == 0 || ba.bJ(FrsGoodFragment.this.getActivity())) {
                    if (bbVar.Ax() != 1 || ba.bJ(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.wk(bbVar.getId())) {
                            readThreadHistory.wj(bbVar.getId());
                            if (FrsGoodFragment.this.ebU != null) {
                                FrsGoodFragment.this.ebU.aCR();
                            }
                        }
                        boolean z = false;
                        final String Ab = bbVar.Ab();
                        if (Ab != null && !Ab.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(Ab);
                                    xVar.Dw().Eu().mIsNeedAddCommenParam = false;
                                    xVar.Dw().Eu().mIsUseCurrentBDUSS = false;
                                    xVar.CZ();
                                }
                            }).start();
                        }
                        String tid = bbVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bbVar.zO() == 2 && !tid.startsWith("pb:")) {
                            ay.Es().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bbVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, FrsGoodFragment.this.dLs, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.ebW ? 15 : 3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    }
                }
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
        this.ebU.gX(false);
        showLoadingView(this.ebU.aDc(), true, getResources().getDimensionPixelSize(e.C0210e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.ebU.gX(true);
        hideLoadingView(this.ebU.aDc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.ebU.gX(false);
        this.ebU.aEb().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.ebU.abA();
        this.ebU.getListView().getData().clear();
        this.ebU.aCR();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Od();
            this.mRefreshView.gd(getResources().getDimensionPixelSize(e.C0210e.ds_102));
            this.mRefreshView.Ob().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.iC(getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.iC(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.ebU.aDc(), true);
    }

    private void abx() {
        this.ebU.gX(true);
        this.ebU.aEb().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached()) {
            this.mRefreshView.dettachView(this.ebU.aDc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hp(boolean z) {
        this.dhl = true;
        aCj();
        abx();
        if (!z) {
            abx();
            showLoadingView();
        }
        this.ebS.is(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dsd = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.dsd = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.bgB = this.beginTime - this.dsd;
        super.onCreate(bundle);
        c.bCC().r(getUniqueId());
        this.ebS = new FrsGoodModelController(this);
        if (arguments != null) {
            this.ebS.p(arguments);
            this.ebR = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.ebS.p(bundle);
            this.ebR = bundle.getBoolean("is_game_frs", false);
        } else {
            this.ebS.p(null);
        }
        this.dLz = getVoiceManager();
        this.dLz.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.aoH);
        registerListener(this.ebY);
        registerListener(this.dMu);
        this.ebT = new FrsLoadMoreModel(this, null);
        this.ebT.registerListener();
        this.ebT.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_good_activity, (ViewGroup) null);
        this.ebU = new b(this, inflate, this.ebR);
        this.ebU.aGV().ho(this.ebW);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.dhl) {
            if (com.baidu.adp.lib.util.j.kV()) {
                hp(false);
            } else {
                c((d.a) null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dLz = getVoiceManager();
        this.dLz.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        aGP();
        if (bundle != null) {
            this.dLs = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.ebW = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dLs = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.ebW = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void aGP() {
        registerListener(2001118, this.aQA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ebU != null) {
            this.ebU.onDestroy();
        }
        c.bCC().s(getUniqueId());
        v.aqP().fy(false);
        super.onDestroy();
        this.ebS.onActivityDestroy();
        this.dLz = getVoiceManager();
        this.dLz.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ebX);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dLs);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.ebR);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.ebW);
        this.ebS.onSaveInstanceState(bundle);
        this.dLz = getVoiceManager();
        if (this.dLz != null) {
            this.dLz.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bb vO;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.ebU.aGV().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (vO = this.dLc.vO(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            vO.cS(intent.getIntExtra("good_data", 0));
                            vO.AD();
                            hp(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dLc.ab(vO);
                            ArrayList<h> threadList = this.dLc.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.ebU.aGT();
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
            if (this.dSm == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.dhl) {
                com.baidu.adp.lib.g.e.jG().post(this.ebX);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ebU != null) {
            this.ebU.aCR();
        }
        this.dLz = getVoiceManager();
        this.dLz.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.ebV = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.ebU.setOnAdapterItemClickListener(this.dMN);
        this.ebU.setOnScrollListener(this.mScrollListener);
        this.ebU.a(this.bSe);
        this.ebU.a(this.aJi);
        this.ebU.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.ebV != null) {
                    FrsGoodFragment.this.ebV.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dSm != 3 || this.ebU != null) {
            this.dSm = i;
            super.onChangeSkinType(i);
            if (this.ebU != null) {
                this.ebU.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aBs() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aBs();
        }
        return null;
    }

    private void aCf() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.we(FrsGoodFragment.this.dLs);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCg() {
        aCj();
        try {
            if (this.dLc != null) {
                this.ebU.anM();
                this.dLs = this.dLc.bhx().getName();
                this.forumId = this.dLc.bhx().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dLc.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dLc.getUserData().getBimg_end_time());
                aCf();
                if (!this.ebU.aGV().k(bb.atM)) {
                    this.dLc.bDJ();
                }
                ArrayList<h> threadList = this.dLc.getThreadList();
                if (threadList != null) {
                    this.ebU.a(threadList, this.mPn, this.dLc, this.dLc.zf().zc());
                    aGQ();
                    this.ebU.aGT();
                    if (this.dLc.bhM() == 1) {
                        this.ebU.aGV().setFromCDN(true);
                    } else {
                        this.ebU.aGV().setFromCDN(false);
                    }
                    this.ebU.setListViewSelection(aV(aGR().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aV(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dLz = getVoiceManager();
        this.dLz.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        v.aqP().fy(false);
        c.bCC().b(getUniqueId(), false);
        if (this.dLc != null && this.dLc.bhx() != null) {
            com.baidu.tbadk.distribute.a.Mc().a(getPageContext().getPageActivity(), "frs", this.dLc.bhx().getId(), 0L);
        }
        this.dLz = getVoiceManager();
        if (this.dLz != null) {
            this.dLz.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj(int i) {
        ArrayList<h> threadList = this.dLc.getThreadList();
        if (threadList != null) {
            Iterator<h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar.getId() != null && bbVar.getId().equals(this.ebQ)) {
                        b(bbVar, i);
                        this.ebQ = null;
                        break;
                    }
                }
            }
            this.ebU.aGV().b(threadList, this.dLc);
            this.ebU.aGV().notifyDataSetChanged();
        }
    }

    private void b(bb bbVar, int i) {
        if (i == 1) {
            PraiseData zG = bbVar.zG();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (zG == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bbVar.a(praiseData);
                    return;
                }
                bbVar.zG().getUser().add(0, metaData);
                bbVar.zG().setNum(bbVar.zG().getNum() + 1);
                bbVar.zG().setIsLike(i);
            }
        } else if (bbVar.zG() != null) {
            bbVar.zG().setIsLike(i);
            bbVar.zG().setNum(bbVar.zG().getNum() - 1);
            ArrayList<MetaData> user = bbVar.zG().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bbVar.zG().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dLz == null) {
            this.dLz = VoiceManager.instance();
        }
        return this.dLz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView FI() {
        if (this.ebU == null) {
            return null;
        }
        return this.ebU.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aCj() {
        this.dLz = getVoiceManager();
        this.dLz.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> FJ() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).FJ();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.dLc != null && this.ebU != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.ebU.aCR();
            }
        }
    }

    private void aGQ() {
        HashMap<Integer, bb> aEY;
        if (this.ebU != null && this.ebU.aGV() != null && (aEY = this.ebU.aGV().aEY()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bb> entry : aEY.entrySet()) {
                bb value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.Mh().s(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public k onGetPreLoadListView() {
        if (FI() == null) {
            return null;
        }
        return FI().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            hp(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l aCl() {
        return this.dLc;
    }

    public FrsGoodModelController aGR() {
        return this.ebS;
    }

    public void oT(String str) {
        this.dLs = str;
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
        if (!com.baidu.adp.lib.util.l.ll()) {
            this.ebU.abA();
        } else if (!this.ebS.aHa()) {
            this.ebU.abA();
        } else {
            aaO();
            if (!this.ebT.isLoading && !this.ebS.Fv()) {
                if (this.ebT.bQ(this.dLc.bCW())) {
                    this.ebU.a(this.ebT.aHo(), this.mPn, this.dLc, 0);
                    this.ebT.a(com.baidu.adp.lib.g.b.d(this.forumId, 0L), this.dLc.bCW(), this.dLs, this.mPn, this.dLc.isBrandForum);
                } else if (this.cEV != 0) {
                    this.ebU.a(this.ebT.aHo(), this.mPn, this.dLc, 0);
                    this.mPn++;
                    this.ebS.nl(this.mPn);
                    this.ebT.loadingDone = false;
                    this.ebT.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void oa(String str) {
        aaO();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<h> arrayList) {
        ArrayList<h> a;
        aaO();
        if (arrayList != null && arrayList.size() != 0 && (a = this.ebT.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.e) null)) != null) {
            this.dLc.ay(a);
            this.ebU.a(a, this.mPn, this.dLc, 0);
        }
    }

    private void aaO() {
        if (this.cEV == 0 && !this.ebT.bQ(this.dLc.bCW())) {
            if (this.dLc.getThreadList() == null || this.dLc.getThreadList().size() == 0) {
                this.ebU.abA();
                return;
            } else {
                this.ebU.abz();
                return;
            }
        }
        this.ebU.aby();
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aX(getActivity().getApplicationContext())) {
                com.baidu.tbadk.core.util.ak.b(getPageContext());
            } else {
                showToast(e.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(e.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Mc().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void aCi() {
        if (this.ebS != null) {
            this.ebS.aCi();
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

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar act() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dLs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nk(int i) {
        this.mTabId = i;
        if (com.baidu.adp.lib.util.j.kV()) {
            hp(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aBE() {
        if (this.ebU != null && this.ebU.getListView() != null) {
            this.ebU.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void abv() {
        if (this.ebU != null) {
            aBE();
            this.ebU.startPullRefresh();
        }
    }
}
