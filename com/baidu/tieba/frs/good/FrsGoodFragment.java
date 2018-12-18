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
    private VoiceManager dIc;
    private String dYt;
    private FrsGoodModelController dYv;
    private FrsLoadMoreModel dYw;
    private com.baidu.tieba.frs.gametab.b dYy;
    private String dHV = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dYu = false;
    private String forumId = null;
    private l dHF = new l();
    public long doE = -1;
    public long bfN = 0;
    public long bfV = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dIk = false;
    protected b dYx = null;
    private int cDk = -1;
    private int mTabId = 0;
    private int dOP = 3;
    private boolean ddI = false;
    public boolean dYz = false;
    private Runnable dYA = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (!j.kV() || FrsGoodFragment.this.ddI) {
                FrsGoodFragment.this.c((d.a) null);
            } else {
                FrsGoodFragment.this.hj(false);
            }
        }
    };
    private CustomMessageListener dYB = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                bb bbVar = (bb) customResponsedMessage.getData();
                FrsGoodFragment.this.dYt = bbVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.dYt) && bbVar.zt() != null) {
                    FrsGoodFragment.this.mV(bbVar.zt().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dIX = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.Fu() != null) {
                            FrsGoodFragment.this.Fu().setSelection(0);
                        }
                        if (FrsGoodFragment.this.mRefreshView != null && FrsGoodFragment.this.mRefreshView.isViewAttached()) {
                            FrsGoodFragment.this.hj(false);
                        } else if (FrsGoodFragment.this.dYx != null) {
                            FrsGoodFragment.this.dYx.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dJk = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        private long dYE = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void lY(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsGoodFragment.this.dYx.aBF();
                    return;
                case 3:
                    FrsGoodFragment.this.dYx.di(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<h> a;
            if (aVar == null) {
                this.dYE = 1L;
            } else if (aVar.isSuccess) {
                this.dYE = 0L;
            } else {
                this.dYE = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.dYw.resetData();
            }
            FrsGoodFragment.this.dYx.di(false);
            if (FrsGoodFragment.this.aFF().aFM() != null) {
                FrsGoodFragment.this.dHF = FrsGoodFragment.this.aFF().aFM();
            }
            FrsGoodFragment.this.cDk = FrsGoodFragment.this.dHF.yS().yP();
            if (FrsGoodFragment.this.cDk == 0 && (FrsGoodFragment.this.dHF.bBv() == null || FrsGoodFragment.this.dHF.bBv().size() == 0)) {
                if (FrsGoodFragment.this.dHF.getThreadList() == null || FrsGoodFragment.this.dHF.getThreadList().size() == 0) {
                    FrsGoodFragment.this.dYx.abb();
                } else {
                    FrsGoodFragment.this.dYx.aba();
                }
            } else {
                FrsGoodFragment.this.dYx.aaZ();
            }
            if (i == 4) {
                ArrayList<h> a2 = FrsGoodFragment.this.dYw.a(false, false, false, FrsGoodFragment.this.dHF.getThreadList(), (e) null);
                if (a2 != null) {
                    FrsGoodFragment.this.dHF.ax(a2);
                    FrsGoodFragment.this.dYx.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.dHF, FrsGoodFragment.this.cDk);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.dYx.aBF();
                    break;
                case 2:
                    FrsGoodFragment.this.dYx.aBF();
                    break;
                case 3:
                    if (FrsGoodFragment.this.dHF.bBM()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.dYE != 0) {
                FrsGoodFragment.this.c(aVar);
            } else {
                if (FrsGoodFragment.this.dHF != null) {
                    FrsGoodFragment.this.dHV = FrsGoodFragment.this.dHF.bgh().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.dHF.bgh().getId();
                    FrsGoodFragment.this.dYx.b(FrsGoodFragment.this.dHF.bgh(), FrsGoodFragment.this.dHF.getUserData());
                }
                if (FrsGoodFragment.this.dHF != null) {
                    FrsGoodFragment.this.dHF.bCg();
                }
                FrsGoodFragment.this.dYx.e(FrsGoodFragment.this.dHF);
                if (FrsGoodFragment.this.dHF == null || FrsGoodFragment.this.dHF.getThreadList() == null || FrsGoodFragment.this.dHF.getThreadList().size() != 0 || FrsGoodFragment.this.aFF().getType() != 4) {
                    if (FrsGoodFragment.this.dHF != null && (a = FrsGoodFragment.this.dYw.a(false, false, true, FrsGoodFragment.this.dHF.getThreadList(), (e) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.dHF.ax(a);
                    }
                    FrsGoodFragment.this.aAU();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(e.j.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.doE > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.doE, FrsGoodFragment.this.aFF().avA() - FrsGoodFragment.this.doE, FrsGoodFragment.this.aFF().avy(), FrsGoodFragment.this.aFF().avz(), currentTimeMillis2 - FrsGoodFragment.this.aFF().avx());
                        FrsGoodFragment.this.doE = -1L;
                    }
                    FrsGoodFragment.this.bfV = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.doE > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.doE, FrsGoodFragment.this.aFF().avA() - FrsGoodFragment.this.doE, FrsGoodFragment.this.aFF().avy(), FrsGoodFragment.this.aFF().avz(), currentTimeMillis3 - FrsGoodFragment.this.aFF().avx());
                FrsGoodFragment.this.doE = -1L;
            }
            FrsGoodFragment.this.bfV = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private final CustomMessageListener aof = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.dYx != null) {
                FrsGoodFragment.this.dYx.startPullRefresh();
            }
        }
    };
    private final j.b bRq = new j.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        @Override // com.baidu.tbadk.core.view.j.b
        public void bH(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.kV()) {
                com.baidu.tieba.a.d.VM().jJ("page_frs_good");
                FrsGoodFragment.this.hj(true);
                return;
            }
            FrsGoodFragment.this.dYx.di(false);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.dIk) {
                FrsGoodFragment.this.dIk = true;
                FrsGoodFragment.this.dYx.aBS();
            }
            if (i == 0) {
                v.apD().ft(true);
            }
        }
    };
    private final CustomMessageListener aPU = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
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
    private com.baidu.adp.widget.ListView.n dJq = new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bb)) {
                bb bbVar = (bb) hVar;
                if (bbVar.As() == null || bbVar.As().getGroup_id() == 0 || ba.bJ(FrsGoodFragment.this.getActivity())) {
                    if (bbVar.Ak() != 1 || ba.bJ(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.vR(bbVar.getId())) {
                            readThreadHistory.vQ(bbVar.getId());
                            if (FrsGoodFragment.this.dYx != null) {
                                FrsGoodFragment.this.dYx.aBF();
                            }
                        }
                        boolean z = false;
                        final String zO = bbVar.zO();
                        if (zO != null && !zO.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(zO);
                                    xVar.Dj().Eh().mIsNeedAddCommenParam = false;
                                    xVar.Dj().Eh().mIsUseCurrentBDUSS = false;
                                    xVar.CM();
                                }
                            }).start();
                        }
                        String tid = bbVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bbVar.zB() == 2 && !tid.startsWith("pb:")) {
                            ay.Ef().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bbVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, FrsGoodFragment.this.dHV, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.dYz ? 15 : 3);
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
        this.dYx.gR(false);
        showLoadingView(this.dYx.aBQ(), true, getResources().getDimensionPixelSize(e.C0210e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dYx.gR(true);
        hideLoadingView(this.dYx.aBQ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dYx.gR(false);
        this.dYx.aCP().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dYx.abb();
        this.dYx.getListView().getData().clear();
        this.dYx.aBF();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.NL();
            this.mRefreshView.gc(getResources().getDimensionPixelSize(e.C0210e.ds_102));
            this.mRefreshView.NJ().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.in(getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.in(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.dYx.aBQ(), true);
    }

    private void aaY() {
        this.dYx.gR(true);
        this.dYx.aCP().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached()) {
            this.mRefreshView.dettachView(this.dYx.aBQ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj(boolean z) {
        this.ddI = true;
        aAX();
        aaY();
        if (!z) {
            aaY();
            showLoadingView();
        }
        this.dYv.ir(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.doE = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.doE = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.bfN = this.beginTime - this.doE;
        super.onCreate(bundle);
        this.dYv = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dYv.p(arguments);
            this.dYu = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dYv.p(bundle);
            this.dYu = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dYv.p(null);
        }
        this.dIc = getVoiceManager();
        this.dIc.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.aof);
        registerListener(this.dYB);
        registerListener(this.dIX);
        this.dYw = new FrsLoadMoreModel(this, null);
        this.dYw.registerListener();
        this.dYw.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_good_activity, (ViewGroup) null);
        this.dYx = new b(this, inflate, this.dYu);
        this.dYx.aFJ().hi(this.dYz);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.ddI) {
            if (com.baidu.adp.lib.util.j.kV()) {
                hj(false);
            } else {
                c((d.a) null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dIc = getVoiceManager();
        this.dIc.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        aFD();
        if (bundle != null) {
            this.dHV = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dYz = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dHV = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.dYz = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void aFD() {
        registerListener(2001118, this.aPU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dYx != null) {
            this.dYx.onDestroy();
        }
        v.apD().ft(false);
        super.onDestroy();
        this.dYv.onActivityDestroy();
        this.dIc = getVoiceManager();
        this.dIc.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dYA);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dHV);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dYu);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.dYz);
        this.dYv.onSaveInstanceState(bundle);
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bb vv;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dYx.aFJ().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (vv = this.dHF.vv(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            vv.cS(intent.getIntExtra("good_data", 0));
                            vv.Aq();
                            hj(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dHF.ab(vv);
                            ArrayList<h> threadList = this.dHF.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.dYx.aFH();
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
            if (this.dOP == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.ddI) {
                com.baidu.adp.lib.g.e.jG().post(this.dYA);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dYx != null) {
            this.dYx.aBF();
        }
        this.dIc = getVoiceManager();
        this.dIc.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dYy = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dYx.setOnAdapterItemClickListener(this.dJq);
        this.dYx.setOnScrollListener(this.mScrollListener);
        this.dYx.a(this.bRq);
        this.dYx.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.dYy != null) {
                    FrsGoodFragment.this.dYy.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dOP != 3 || this.dYx != null) {
            this.dOP = i;
            super.onChangeSkinType(i);
            if (this.dYx != null) {
                this.dYx.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aAg() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aAg();
        }
        return null;
    }

    private void aAT() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.vL(FrsGoodFragment.this.dHV);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAU() {
        aAX();
        try {
            if (this.dHF != null) {
                this.dYx.amN();
                this.dHV = this.dHF.bgh().getName();
                this.forumId = this.dHF.bgh().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dHF.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dHF.getUserData().getBimg_end_time());
                aAT();
                if (!this.dYx.aFJ().k(bb.atk)) {
                    this.dHF.bCi();
                }
                ArrayList<h> threadList = this.dHF.getThreadList();
                if (threadList != null) {
                    this.dYx.a(threadList, this.mPn, this.dHF, this.dHF.yS().yP());
                    aFE();
                    this.dYx.aFH();
                    if (this.dHF.bgw() == 1) {
                        this.dYx.aFJ().setFromCDN(true);
                    } else {
                        this.dYx.aFJ().setFromCDN(false);
                    }
                    this.dYx.setListViewSelection(aU(aFF().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aU(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dIc = getVoiceManager();
        this.dIc.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        v.apD().ft(false);
        if (this.dHF != null && this.dHF.bgh() != null) {
            com.baidu.tbadk.distribute.a.LK().a(getPageContext().getPageActivity(), "frs", this.dHF.bgh().getId(), 0L);
        }
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mV(int i) {
        ArrayList<h> threadList = this.dHF.getThreadList();
        if (threadList != null) {
            Iterator<h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar.getId() != null && bbVar.getId().equals(this.dYt)) {
                        a(bbVar, i);
                        this.dYt = null;
                        break;
                    }
                }
            }
            this.dYx.aFJ().b(threadList, this.dHF);
            this.dYx.aFJ().notifyDataSetChanged();
        }
    }

    private void a(bb bbVar, int i) {
        if (i == 1) {
            PraiseData zt = bbVar.zt();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (zt == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bbVar.a(praiseData);
                    return;
                }
                bbVar.zt().getUser().add(0, metaData);
                bbVar.zt().setNum(bbVar.zt().getNum() + 1);
                bbVar.zt().setIsLike(i);
            }
        } else if (bbVar.zt() != null) {
            bbVar.zt().setIsLike(i);
            bbVar.zt().setNum(bbVar.zt().getNum() - 1);
            ArrayList<MetaData> user = bbVar.zt().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bbVar.zt().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dIc == null) {
            this.dIc = VoiceManager.instance();
        }
        return this.dIc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Fu() {
        if (this.dYx == null) {
            return null;
        }
        return this.dYx.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aAX() {
        this.dIc = getVoiceManager();
        this.dIc.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Fv() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).Fv();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.dHF != null && this.dYx != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dYx.aBF();
            }
        }
    }

    private void aFE() {
        HashMap<Integer, bb> aDM;
        if (this.dYx != null && this.dYx.aFJ() != null && (aDM = this.dYx.aFJ().aDM()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bb> entry : aDM.entrySet()) {
                bb value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.LP().s(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public k onGetPreLoadListView() {
        if (Fu() == null) {
            return null;
        }
        return Fu().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            hj(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l aAZ() {
        return this.dHF;
    }

    public FrsGoodModelController aFF() {
        return this.dYv;
    }

    public void oA(String str) {
        this.dHV = str;
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
            this.dYx.abb();
        } else if (!this.dYv.aFO()) {
            this.dYx.abb();
        } else {
            aap();
            if (!this.dYw.isLoading && !this.dYv.Fi()) {
                if (this.dYw.bO(this.dHF.bBv())) {
                    this.dYx.a(this.dYw.aGc(), this.mPn, this.dHF, 0);
                    this.dYw.a(com.baidu.adp.lib.g.b.d(this.forumId, 0L), this.dHF.bBv(), this.dHV, this.mPn, this.dHF.isBrandForum);
                } else if (this.cDk != 0) {
                    this.dYx.a(this.dYw.aGc(), this.mPn, this.dHF, 0);
                    this.mPn++;
                    this.dYv.mX(this.mPn);
                    this.dYw.loadingDone = false;
                    this.dYw.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void nH(String str) {
        aap();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<h> arrayList) {
        ArrayList<h> a;
        aap();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dYw.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.e) null)) != null) {
            this.dHF.ax(a);
            this.dYx.a(a, this.mPn, this.dHF, 0);
        }
    }

    private void aap() {
        if (this.cDk == 0 && !this.dYw.bO(this.dHF.bBv())) {
            if (this.dHF.getThreadList() == null || this.dHF.getThreadList().size() == 0) {
                this.dYx.abb();
                return;
            } else {
                this.dYx.aba();
                return;
            }
        }
        this.dYx.aaZ();
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
        com.baidu.tbadk.distribute.a.LK().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void aAW() {
        if (this.dYv != null) {
            this.dYv.aAW();
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
    public NavigationBar abU() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dHV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mW(int i) {
        this.mTabId = i;
        if (com.baidu.adp.lib.util.j.kV()) {
            hj(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aAs() {
        if (this.dYx != null && this.dYx.getListView() != null) {
            this.dYx.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aaW() {
        if (this.dYx != null) {
            aAs();
            this.dYx.startPullRefresh();
        }
    }
}
