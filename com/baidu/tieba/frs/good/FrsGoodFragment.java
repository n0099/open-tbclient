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
/* loaded from: classes2.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0062a, UserIconBox.b, VoiceManager.c, aj, ak, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private FrsGoodModelController dIR;
    private FrsLoadMoreModel dIS;
    private com.baidu.tieba.frs.gametab.b dIU;
    private VoiceManager dsk;
    private String dzp;
    private String dsd = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dIQ = false;
    private String forumId = null;
    private l drN = new l();
    public long cYB = -1;
    public long aXa = 0;
    public long aXi = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dst = false;
    protected b dIT = null;
    private int cpG = -1;
    private int mTabId = 0;
    private int dyV = 3;
    private boolean cNA = false;
    public boolean dIV = false;
    private Runnable dIW = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (!j.kK() || FrsGoodFragment.this.cNA) {
                FrsGoodFragment.this.c((d.a) null);
            } else {
                FrsGoodFragment.this.gw(false);
            }
        }
    };
    private CustomMessageListener dzq = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                bb bbVar = (bb) customResponsedMessage.getData();
                FrsGoodFragment.this.dzp = bbVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.dzp) && bbVar.vZ() != null) {
                    FrsGoodFragment.this.lq(bbVar.vZ().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dtg = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.Cb() != null) {
                            FrsGoodFragment.this.Cb().setSelection(0);
                        }
                        if (FrsGoodFragment.this.mRefreshView != null && FrsGoodFragment.this.mRefreshView.Ks()) {
                            FrsGoodFragment.this.gw(false);
                        } else if (FrsGoodFragment.this.dIT != null) {
                            FrsGoodFragment.this.dIT.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dtt = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        private long dIZ = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kS(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsGoodFragment.this.dIT.axc();
                    return;
                case 3:
                    FrsGoodFragment.this.dIT.cH(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<h> a;
            if (aVar == null) {
                this.dIZ = 1L;
            } else if (aVar.isSuccess) {
                this.dIZ = 0L;
            } else {
                this.dIZ = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.dIS.resetData();
            }
            FrsGoodFragment.this.dIT.cH(false);
            if (FrsGoodFragment.this.aBf().aBl() != null) {
                FrsGoodFragment.this.drN = FrsGoodFragment.this.aBf().aBl();
            }
            FrsGoodFragment.this.cpG = FrsGoodFragment.this.drN.vy().vu();
            if (FrsGoodFragment.this.cpG == 0 && (FrsGoodFragment.this.drN.bwR() == null || FrsGoodFragment.this.drN.bwR().size() == 0)) {
                if (FrsGoodFragment.this.drN.getThreadList() == null || FrsGoodFragment.this.drN.getThreadList().size() == 0) {
                    FrsGoodFragment.this.dIT.Wd();
                } else {
                    FrsGoodFragment.this.dIT.Wc();
                }
            } else {
                FrsGoodFragment.this.dIT.Wb();
            }
            if (i == 4) {
                ArrayList<h> a2 = FrsGoodFragment.this.dIS.a(false, false, false, FrsGoodFragment.this.drN.getThreadList(), (e) null);
                if (a2 != null) {
                    FrsGoodFragment.this.drN.ay(a2);
                    FrsGoodFragment.this.dIT.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.drN, FrsGoodFragment.this.cpG);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.dIT.axc();
                    break;
                case 2:
                    FrsGoodFragment.this.dIT.axc();
                    break;
                case 3:
                    if (FrsGoodFragment.this.drN.bxi()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.dIZ != 0) {
                FrsGoodFragment.this.c(aVar);
            } else {
                if (FrsGoodFragment.this.drN != null) {
                    FrsGoodFragment.this.dsd = FrsGoodFragment.this.drN.bbH().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.drN.bbH().getId();
                    FrsGoodFragment.this.dIT.b(FrsGoodFragment.this.drN.bbH(), FrsGoodFragment.this.drN.getUserData());
                }
                if (FrsGoodFragment.this.drN != null) {
                    FrsGoodFragment.this.drN.bxC();
                }
                FrsGoodFragment.this.dIT.d(FrsGoodFragment.this.drN);
                if (FrsGoodFragment.this.drN == null || FrsGoodFragment.this.drN.getThreadList() == null || FrsGoodFragment.this.drN.getThreadList().size() != 0 || FrsGoodFragment.this.aBf().getType() != 4) {
                    if (FrsGoodFragment.this.drN != null && (a = FrsGoodFragment.this.dIS.a(false, false, true, FrsGoodFragment.this.drN.getThreadList(), (e) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.drN.ay(a);
                    }
                    FrsGoodFragment.this.awq();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(e.j.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.cYB > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.cYB, FrsGoodFragment.this.aBf().aqU() - FrsGoodFragment.this.cYB, FrsGoodFragment.this.aBf().aqS(), FrsGoodFragment.this.aBf().aqT(), currentTimeMillis2 - FrsGoodFragment.this.aBf().aqR());
                        FrsGoodFragment.this.cYB = -1L;
                    }
                    FrsGoodFragment.this.aXi = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.cYB > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.cYB, FrsGoodFragment.this.aBf().aqU() - FrsGoodFragment.this.cYB, FrsGoodFragment.this.aBf().aqS(), FrsGoodFragment.this.aBf().aqT(), currentTimeMillis3 - FrsGoodFragment.this.aBf().aqR());
                FrsGoodFragment.this.cYB = -1L;
            }
            FrsGoodFragment.this.aXi = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private final CustomMessageListener aeT = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.dIT != null) {
                FrsGoodFragment.this.dIT.startPullRefresh();
            }
        }
    };
    private final j.b bEk = new j.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        @Override // com.baidu.tbadk.core.view.j.b
        public void bf(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.kK()) {
                com.baidu.tieba.a.d.SB().jc("page_frs_good");
                FrsGoodFragment.this.gw(true);
                return;
            }
            FrsGoodFragment.this.dIT.cH(false);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.dst) {
                FrsGoodFragment.this.dst = true;
                FrsGoodFragment.this.dIT.axp();
            }
            if (i == 0) {
                v.akM().eP(true);
            }
        }
    };
    private final CustomMessageListener aHc = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
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
    private com.baidu.adp.widget.ListView.n dtz = new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bb)) {
                bb bbVar = (bb) hVar;
                if (bbVar.wY() == null || bbVar.wY().getGroup_id() == 0 || ba.bA(FrsGoodFragment.this.getActivity())) {
                    if (bbVar.wQ() != 1 || ba.bA(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.uJ(bbVar.getId())) {
                            readThreadHistory.uI(bbVar.getId());
                            if (FrsGoodFragment.this.dIT != null) {
                                FrsGoodFragment.this.dIT.axc();
                            }
                        }
                        boolean z = false;
                        final String wu = bbVar.wu();
                        if (wu != null && !wu.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(wu);
                                    xVar.zR().AP().mIsNeedAddCommenParam = false;
                                    xVar.zR().AP().mIsUseCurrentBDUSS = false;
                                    xVar.zu();
                                }
                            }).start();
                        }
                        String tid = bbVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bbVar.wh() == 2 && !tid.startsWith("pb:")) {
                            ay.AN().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bbVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, FrsGoodFragment.this.dsd, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.dIV ? 15 : 3);
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
        this.dIT.go(false);
        showLoadingView(this.dIT.axn(), true, getResources().getDimensionPixelSize(e.C0141e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dIT.go(true);
        hideLoadingView(this.dIT.axn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dIT.go(false);
        this.dIT.aym().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dIT.Wd();
        this.dIT.getListView().getData().clear();
        this.dIT.axc();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.KA();
            this.mRefreshView.fr(getResources().getDimensionPixelSize(e.C0141e.ds_102));
            this.mRefreshView.Ky().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.hG(getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.hG(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.c(this.dIT.axn(), true);
    }

    private void Wa() {
        this.dIT.go(true);
        this.dIT.aym().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Ks()) {
            this.mRefreshView.ad(this.dIT.axn());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(boolean z) {
        this.cNA = true;
        awt();
        Wa();
        if (!z) {
            Wa();
            showLoadingView();
        }
        this.dIR.hs(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cYB = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.cYB = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.aXa = this.beginTime - this.cYB;
        super.onCreate(bundle);
        this.dIR = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dIR.i(arguments);
            this.dIQ = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dIR.i(bundle);
            this.dIQ = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dIR.i(null);
        }
        this.dsk = getVoiceManager();
        this.dsk.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.aeT);
        registerListener(this.dzq);
        registerListener(this.dtg);
        this.dIS = new FrsLoadMoreModel(this, null);
        this.dIS.registerListener();
        this.dIS.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_good_activity, (ViewGroup) null);
        this.dIT = new b(this, inflate, this.dIQ);
        this.dIT.aBj().gF(this.dIV);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.cNA) {
            if (com.baidu.adp.lib.util.j.kK()) {
                gw(false);
            } else {
                c((d.a) null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dsk = getVoiceManager();
        this.dsk.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        aBd();
        if (bundle != null) {
            this.dsd = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dIV = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dsd = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.dIV = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void aBd() {
        registerListener(2001118, this.aHc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dIT != null) {
            this.dIT.onDestroy();
        }
        v.akM().eP(false);
        super.onDestroy();
        this.dIR.onActivityDestroy();
        this.dsk = getVoiceManager();
        this.dsk.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.dIW);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dsd);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dIQ);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.dIV);
        this.dIR.onSaveInstanceState(bundle);
        this.dsk = getVoiceManager();
        if (this.dsk != null) {
            this.dsk.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bb nh;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dIT.aBj().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (nh = this.drN.nh(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            nh.cf(intent.getIntExtra("good_data", 0));
                            nh.wW();
                            gw(false);
                            return;
                        } else if (intExtra == 0) {
                            this.drN.ab(nh);
                            ArrayList<h> threadList = this.drN.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.dIT.aBh();
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
            if (this.dyV == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.cNA) {
                com.baidu.adp.lib.g.e.jt().post(this.dIW);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dIT != null) {
            this.dIT.axc();
        }
        this.dsk = getVoiceManager();
        this.dsk.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dIU = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dIT.setOnAdapterItemClickListener(this.dtz);
        this.dIT.setOnScrollListener(this.mScrollListener);
        this.dIT.a(this.bEk);
        this.dIT.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.dIU != null) {
                    FrsGoodFragment.this.dIU.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dyV != 3 || this.dIT != null) {
            this.dyV = i;
            super.onChangeSkinType(i);
            if (this.dIT != null) {
                this.dIT.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> avC() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).avC();
        }
        return null;
    }

    private void awp() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.ju().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.uD(FrsGoodFragment.this.dsd);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awq() {
        awt();
        try {
            if (this.drN != null) {
                this.dIT.aiB();
                this.dsd = this.drN.bbH().getName();
                this.forumId = this.drN.bbH().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.drN.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.drN.getUserData().getBimg_end_time());
                awp();
                if (!this.dIT.aBj().k(bb.akb)) {
                    this.drN.bxE();
                }
                ArrayList<h> threadList = this.drN.getThreadList();
                if (threadList != null) {
                    this.dIT.a(threadList, this.mPn, this.drN, this.drN.vy().vu());
                    aBe();
                    this.dIT.aBh();
                    if (this.drN.bbW() == 1) {
                        this.dIT.aBj().setFromCDN(true);
                    } else {
                        this.dIT.aBj().setFromCDN(false);
                    }
                    this.dIT.setListViewSelection(aI(aBf().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aI(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dsk = getVoiceManager();
        this.dsk.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        v.akM().eP(false);
        if (this.drN != null && this.drN.bbH() != null) {
            com.baidu.tbadk.distribute.a.Iv().a(getPageContext().getPageActivity(), "frs", this.drN.bbH().getId(), 0L);
        }
        this.dsk = getVoiceManager();
        if (this.dsk != null) {
            this.dsk.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq(int i) {
        ArrayList<h> threadList = this.drN.getThreadList();
        if (threadList != null) {
            Iterator<h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar.getId() != null && bbVar.getId().equals(this.dzp)) {
                        a(bbVar, i);
                        this.dzp = null;
                        break;
                    }
                }
            }
            this.dIT.aBj().b(threadList, this.drN);
            this.dIT.aBj().notifyDataSetChanged();
        }
    }

    private void a(bb bbVar, int i) {
        if (i == 1) {
            PraiseData vZ = bbVar.vZ();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (vZ == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bbVar.a(praiseData);
                    return;
                }
                bbVar.vZ().getUser().add(0, metaData);
                bbVar.vZ().setNum(bbVar.vZ().getNum() + 1);
                bbVar.vZ().setIsLike(i);
            }
        } else if (bbVar.vZ() != null) {
            bbVar.vZ().setIsLike(i);
            bbVar.vZ().setNum(bbVar.vZ().getNum() - 1);
            ArrayList<MetaData> user = bbVar.vZ().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bbVar.vZ().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dsk == null) {
            this.dsk = VoiceManager.instance();
        }
        return this.dsk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Cb() {
        if (this.dIT == null) {
            return null;
        }
        return this.dIT.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void awt() {
        this.dsk = getVoiceManager();
        this.dsk.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Cc() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).Cc();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.drN != null && this.dIT != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dIT.axc();
            }
        }
    }

    private void aBe() {
        HashMap<Integer, bb> azm;
        if (this.dIT != null && this.dIT.aBj() != null && (azm = this.dIT.aBj().azm()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bb> entry : azm.entrySet()) {
                bb value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.IA().s(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public k onGetPreLoadListView() {
        if (Cb() == null) {
            return null;
        }
        return Cb().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kK()) {
            gw(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l awv() {
        return this.drN;
    }

    public FrsGoodModelController aBf() {
        return this.dIR;
    }

    public void nw(String str) {
        this.dsd = str;
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
        if (!com.baidu.adp.lib.util.l.lb()) {
            this.dIT.Wd();
        } else if (!this.dIR.aBn()) {
            this.dIT.Wd();
        } else {
            Vr();
            if (!this.dIS.isLoading && !this.dIR.BO()) {
                if (this.dIS.by(this.drN.bwR())) {
                    this.dIT.a(this.dIS.aBB(), this.mPn, this.drN, 0);
                    this.dIS.a(com.baidu.adp.lib.g.b.d(this.forumId, 0L), this.drN.bwR(), this.dsd, this.mPn, this.drN.isBrandForum);
                } else if (this.cpG != 0) {
                    this.dIT.a(this.dIS.aBB(), this.mPn, this.drN, 0);
                    this.mPn++;
                    this.dIR.lR(this.mPn);
                    this.dIS.loadingDone = false;
                    this.dIS.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void mF(String str) {
        Vr();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<h> arrayList) {
        ArrayList<h> a;
        Vr();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dIS.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.e) null)) != null) {
            this.drN.ay(a);
            this.dIT.a(a, this.mPn, this.drN, 0);
        }
    }

    private void Vr() {
        if (this.cpG == 0 && !this.dIS.by(this.drN.bwR())) {
            if (this.drN.getThreadList() == null || this.drN.getThreadList().size() == 0) {
                this.dIT.Wd();
                return;
            } else {
                this.dIT.Wc();
                return;
            }
        }
        this.dIT.Wb();
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.bt(getActivity().getApplicationContext())) {
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
        com.baidu.tbadk.distribute.a.Iv().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void aws() {
        if (this.dIR != null) {
            this.dIR.aws();
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
    public NavigationBar WW() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dsd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lQ(int i) {
        this.mTabId = i;
        if (com.baidu.adp.lib.util.j.kK()) {
            gw(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void avO() {
        if (this.dIT != null && this.dIT.getListView() != null) {
            this.dIT.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void VY() {
        if (this.dIT != null) {
            avO();
            this.dIT.startPullRefresh();
        }
    }
}
