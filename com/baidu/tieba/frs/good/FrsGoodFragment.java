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
    private VoiceManager dBD;
    private String dRR;
    private FrsGoodModelController dRT;
    private FrsLoadMoreModel dRU;
    private com.baidu.tieba.frs.gametab.b dRW;
    private String dBw = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dRS = false;
    private String forumId = null;
    private l dBg = new l();
    public long dhW = -1;
    public long bcn = 0;
    public long bcv = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dBL = false;
    protected b dRV = null;
    private int czs = -1;
    private int mTabId = 0;
    private int dIq = 3;
    private boolean cWX = false;
    public boolean dRX = false;
    private Runnable dRY = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (!j.kV() || FrsGoodFragment.this.cWX) {
                FrsGoodFragment.this.c((d.a) null);
            } else {
                FrsGoodFragment.this.hh(false);
            }
        }
    };
    private CustomMessageListener dRZ = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                bb bbVar = (bb) customResponsedMessage.getData();
                FrsGoodFragment.this.dRR = bbVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.dRR) && bbVar.yp() != null) {
                    FrsGoodFragment.this.mF(bbVar.yp().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dCy = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.Eq() != null) {
                            FrsGoodFragment.this.Eq().setSelection(0);
                        }
                        if (FrsGoodFragment.this.mRefreshView != null && FrsGoodFragment.this.mRefreshView.isViewAttached()) {
                            FrsGoodFragment.this.hh(false);
                        } else if (FrsGoodFragment.this.dRV != null) {
                            FrsGoodFragment.this.dRV.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dCL = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        private long dSc = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void lI(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsGoodFragment.this.dRV.azV();
                    return;
                case 3:
                    FrsGoodFragment.this.dRV.dh(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<h> a;
            if (aVar == null) {
                this.dSc = 1L;
            } else if (aVar.isSuccess) {
                this.dSc = 0L;
            } else {
                this.dSc = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.dRU.resetData();
            }
            FrsGoodFragment.this.dRV.dh(false);
            if (FrsGoodFragment.this.aDT().aEa() != null) {
                FrsGoodFragment.this.dBg = FrsGoodFragment.this.aDT().aEa();
            }
            FrsGoodFragment.this.czs = FrsGoodFragment.this.dBg.xO().xL();
            if (FrsGoodFragment.this.czs == 0 && (FrsGoodFragment.this.dBg.bzC() == null || FrsGoodFragment.this.dBg.bzC().size() == 0)) {
                if (FrsGoodFragment.this.dBg.getThreadList() == null || FrsGoodFragment.this.dBg.getThreadList().size() == 0) {
                    FrsGoodFragment.this.dRV.ZV();
                } else {
                    FrsGoodFragment.this.dRV.ZU();
                }
            } else {
                FrsGoodFragment.this.dRV.ZT();
            }
            if (i == 4) {
                ArrayList<h> a2 = FrsGoodFragment.this.dRU.a(false, false, false, FrsGoodFragment.this.dBg.getThreadList(), (e) null);
                if (a2 != null) {
                    FrsGoodFragment.this.dBg.ax(a2);
                    FrsGoodFragment.this.dRV.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.dBg, FrsGoodFragment.this.czs);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.dRV.azV();
                    break;
                case 2:
                    FrsGoodFragment.this.dRV.azV();
                    break;
                case 3:
                    if (FrsGoodFragment.this.dBg.bzT()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.dSc != 0) {
                FrsGoodFragment.this.c(aVar);
            } else {
                if (FrsGoodFragment.this.dBg != null) {
                    FrsGoodFragment.this.dBw = FrsGoodFragment.this.dBg.ber().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.dBg.ber().getId();
                    FrsGoodFragment.this.dRV.b(FrsGoodFragment.this.dBg.ber(), FrsGoodFragment.this.dBg.getUserData());
                }
                if (FrsGoodFragment.this.dBg != null) {
                    FrsGoodFragment.this.dBg.bAn();
                }
                FrsGoodFragment.this.dRV.d(FrsGoodFragment.this.dBg);
                if (FrsGoodFragment.this.dBg == null || FrsGoodFragment.this.dBg.getThreadList() == null || FrsGoodFragment.this.dBg.getThreadList().size() != 0 || FrsGoodFragment.this.aDT().getType() != 4) {
                    if (FrsGoodFragment.this.dBg != null && (a = FrsGoodFragment.this.dRU.a(false, false, true, FrsGoodFragment.this.dBg.getThreadList(), (e) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.dBg.ax(a);
                    }
                    FrsGoodFragment.this.azk();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(e.j.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.dhW > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.dhW, FrsGoodFragment.this.aDT().atP() - FrsGoodFragment.this.dhW, FrsGoodFragment.this.aDT().atN(), FrsGoodFragment.this.aDT().atO(), currentTimeMillis2 - FrsGoodFragment.this.aDT().atM());
                        FrsGoodFragment.this.dhW = -1L;
                    }
                    FrsGoodFragment.this.bcv = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.dhW > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.dhW, FrsGoodFragment.this.aDT().atP() - FrsGoodFragment.this.dhW, FrsGoodFragment.this.aDT().atN(), FrsGoodFragment.this.aDT().atO(), currentTimeMillis3 - FrsGoodFragment.this.aDT().atM());
                FrsGoodFragment.this.dhW = -1L;
            }
            FrsGoodFragment.this.bcv = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private final CustomMessageListener akD = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.dRV != null) {
                FrsGoodFragment.this.dRV.startPullRefresh();
            }
        }
    };
    private final j.b bNz = new j.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        @Override // com.baidu.tbadk.core.view.j.b
        public void bG(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.kV()) {
                com.baidu.tieba.a.d.UG().jr("page_frs_good");
                FrsGoodFragment.this.hh(true);
                return;
            }
            FrsGoodFragment.this.dRV.dh(false);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.dBL) {
                FrsGoodFragment.this.dBL = true;
                FrsGoodFragment.this.dRV.aAi();
            }
            if (i == 0) {
                v.anQ().fs(true);
            }
        }
    };
    private final CustomMessageListener aMv = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
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
    private com.baidu.adp.widget.ListView.n dCR = new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bb)) {
                bb bbVar = (bb) hVar;
                if (bbVar.zo() == null || bbVar.zo().getGroup_id() == 0 || ba.bG(FrsGoodFragment.this.getActivity())) {
                    if (bbVar.zg() != 1 || ba.bG(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.vq(bbVar.getId())) {
                            readThreadHistory.vp(bbVar.getId());
                            if (FrsGoodFragment.this.dRV != null) {
                                FrsGoodFragment.this.dRV.azV();
                            }
                        }
                        boolean z = false;
                        final String yK = bbVar.yK();
                        if (yK != null && !yK.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(yK);
                                    xVar.Cf().Dd().mIsNeedAddCommenParam = false;
                                    xVar.Cf().Dd().mIsUseCurrentBDUSS = false;
                                    xVar.BI();
                                }
                            }).start();
                        }
                        String tid = bbVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bbVar.yx() == 2 && !tid.startsWith("pb:")) {
                            ay.Db().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bbVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, FrsGoodFragment.this.dBw, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.dRX ? 15 : 3);
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
        this.dRV.gQ(false);
        showLoadingView(this.dRV.aAg(), true, getResources().getDimensionPixelSize(e.C0200e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dRV.gQ(true);
        hideLoadingView(this.dRV.aAg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dRV.gQ(false);
        this.dRV.aBf().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dRV.ZV();
        this.dRV.getListView().getData().clear();
        this.dRV.azV();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.MH();
            this.mRefreshView.fO(getResources().getDimensionPixelSize(e.C0200e.ds_102));
            this.mRefreshView.MF().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.hV(getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.hV(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.dRV.aAg(), true);
    }

    private void ZS() {
        this.dRV.gQ(true);
        this.dRV.aBf().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached()) {
            this.mRefreshView.dettachView(this.dRV.aAg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hh(boolean z) {
        this.cWX = true;
        azn();
        ZS();
        if (!z) {
            ZS();
            showLoadingView();
        }
        this.dRT.id(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dhW = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.dhW = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.bcn = this.beginTime - this.dhW;
        super.onCreate(bundle);
        this.dRT = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dRT.m(arguments);
            this.dRS = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dRT.m(bundle);
            this.dRS = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dRT.m(null);
        }
        this.dBD = getVoiceManager();
        this.dBD.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.akD);
        registerListener(this.dRZ);
        registerListener(this.dCy);
        this.dRU = new FrsLoadMoreModel(this, null);
        this.dRU.registerListener();
        this.dRU.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_good_activity, (ViewGroup) null);
        this.dRV = new b(this, inflate, this.dRS);
        this.dRV.aDX().hg(this.dRX);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.cWX) {
            if (com.baidu.adp.lib.util.j.kV()) {
                hh(false);
            } else {
                c((d.a) null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dBD = getVoiceManager();
        this.dBD.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        aDR();
        if (bundle != null) {
            this.dBw = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dRX = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dBw = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.dRX = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void aDR() {
        registerListener(2001118, this.aMv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dRV != null) {
            this.dRV.onDestroy();
        }
        v.anQ().fs(false);
        super.onDestroy();
        this.dRT.onActivityDestroy();
        this.dBD = getVoiceManager();
        this.dBD.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dRY);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dBw);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dRS);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.dRX);
        this.dRT.onSaveInstanceState(bundle);
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bb uU;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dRV.aDX().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (uU = this.dBg.uU(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            uU.cE(intent.getIntExtra("good_data", 0));
                            uU.zm();
                            hh(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dBg.ab(uU);
                            ArrayList<h> threadList = this.dBg.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.dRV.aDV();
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
            if (this.dIq == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.cWX) {
                com.baidu.adp.lib.g.e.jG().post(this.dRY);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dRV != null) {
            this.dRV.azV();
        }
        this.dBD = getVoiceManager();
        this.dBD.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dRW = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dRV.setOnAdapterItemClickListener(this.dCR);
        this.dRV.setOnScrollListener(this.mScrollListener);
        this.dRV.a(this.bNz);
        this.dRV.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.dRW != null) {
                    FrsGoodFragment.this.dRW.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dIq != 3 || this.dRV != null) {
            this.dIq = i;
            super.onChangeSkinType(i);
            if (this.dRV != null) {
                this.dRV.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> ayw() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).ayw();
        }
        return null;
    }

    private void azj() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.vk(FrsGoodFragment.this.dBw);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azk() {
        azn();
        try {
            if (this.dBg != null) {
                this.dRV.alG();
                this.dBw = this.dBg.ber().getName();
                this.forumId = this.dBg.ber().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dBg.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dBg.getUserData().getBimg_end_time());
                azj();
                if (!this.dRV.aDX().k(bb.apK)) {
                    this.dBg.bAp();
                }
                ArrayList<h> threadList = this.dBg.getThreadList();
                if (threadList != null) {
                    this.dRV.a(threadList, this.mPn, this.dBg, this.dBg.xO().xL());
                    aDS();
                    this.dRV.aDV();
                    if (this.dBg.beG() == 1) {
                        this.dRV.aDX().setFromCDN(true);
                    } else {
                        this.dRV.aDX().setFromCDN(false);
                    }
                    this.dRV.setListViewSelection(aU(aDT().getType(), this.mPn));
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
        this.dBD = getVoiceManager();
        this.dBD.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        v.anQ().fs(false);
        if (this.dBg != null && this.dBg.ber() != null) {
            com.baidu.tbadk.distribute.a.KG().a(getPageContext().getPageActivity(), "frs", this.dBg.ber().getId(), 0L);
        }
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF(int i) {
        ArrayList<h> threadList = this.dBg.getThreadList();
        if (threadList != null) {
            Iterator<h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar.getId() != null && bbVar.getId().equals(this.dRR)) {
                        a(bbVar, i);
                        this.dRR = null;
                        break;
                    }
                }
            }
            this.dRV.aDX().b(threadList, this.dBg);
            this.dRV.aDX().notifyDataSetChanged();
        }
    }

    private void a(bb bbVar, int i) {
        if (i == 1) {
            PraiseData yp = bbVar.yp();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (yp == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bbVar.a(praiseData);
                    return;
                }
                bbVar.yp().getUser().add(0, metaData);
                bbVar.yp().setNum(bbVar.yp().getNum() + 1);
                bbVar.yp().setIsLike(i);
            }
        } else if (bbVar.yp() != null) {
            bbVar.yp().setIsLike(i);
            bbVar.yp().setNum(bbVar.yp().getNum() - 1);
            ArrayList<MetaData> user = bbVar.yp().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bbVar.yp().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dBD == null) {
            this.dBD = VoiceManager.instance();
        }
        return this.dBD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Eq() {
        if (this.dRV == null) {
            return null;
        }
        return this.dRV.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void azn() {
        this.dBD = getVoiceManager();
        this.dBD.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Er() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).Er();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.dBg != null && this.dRV != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dRV.azV();
            }
        }
    }

    private void aDS() {
        HashMap<Integer, bb> aCa;
        if (this.dRV != null && this.dRV.aDX() != null && (aCa = this.dRV.aDX().aCa()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bb> entry : aCa.entrySet()) {
                bb value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.KL().s(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public k onGetPreLoadListView() {
        if (Eq() == null) {
            return null;
        }
        return Eq().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            hh(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l azp() {
        return this.dBg;
    }

    public FrsGoodModelController aDT() {
        return this.dRT;
    }

    public void nZ(String str) {
        this.dBw = str;
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
        if (!com.baidu.adp.lib.util.l.lm()) {
            this.dRV.ZV();
        } else if (!this.dRT.aEc()) {
            this.dRV.ZV();
        } else {
            Zj();
            if (!this.dRU.isLoading && !this.dRT.Ee()) {
                if (this.dRU.bM(this.dBg.bzC())) {
                    this.dRV.a(this.dRU.aEq(), this.mPn, this.dBg, 0);
                    this.dRU.a(com.baidu.adp.lib.g.b.d(this.forumId, 0L), this.dBg.bzC(), this.dBw, this.mPn, this.dBg.isBrandForum);
                } else if (this.czs != 0) {
                    this.dRV.a(this.dRU.aEq(), this.mPn, this.dBg, 0);
                    this.mPn++;
                    this.dRT.mH(this.mPn);
                    this.dRU.loadingDone = false;
                    this.dRU.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ni(String str) {
        Zj();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<h> arrayList) {
        ArrayList<h> a;
        Zj();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dRU.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.e) null)) != null) {
            this.dBg.ax(a);
            this.dRV.a(a, this.mPn, this.dBg, 0);
        }
    }

    private void Zj() {
        if (this.czs == 0 && !this.dRU.bM(this.dBg.bzC())) {
            if (this.dBg.getThreadList() == null || this.dBg.getThreadList().size() == 0) {
                this.dRV.ZV();
                return;
            } else {
                this.dRV.ZU();
                return;
            }
        }
        this.dRV.ZT();
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
        com.baidu.tbadk.distribute.a.KG().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void azm() {
        if (this.dRT != null) {
            this.dRT.azm();
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
    public NavigationBar aaO() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dBw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mG(int i) {
        this.mTabId = i;
        if (com.baidu.adp.lib.util.j.kV()) {
            hh(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void ayI() {
        if (this.dRV != null && this.dRV.getListView() != null) {
            this.dRV.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void ZQ() {
        if (this.dRV != null) {
            ayI();
            this.dRV.startPullRefresh();
        }
    }
}
