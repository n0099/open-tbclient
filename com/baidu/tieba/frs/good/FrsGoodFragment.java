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
import com.baidu.d.a.a;
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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
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
    private VoiceManager djz;
    private String dqa;
    private FrsGoodModelController dzs;
    private FrsLoadMoreModel dzt;
    private com.baidu.tieba.frs.gametab.b dzv;
    private String djs = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dzr = false;
    private String forumId = null;
    private l djc = new l();
    public long cQb = -1;
    public long aTK = 0;
    public long aTS = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean djI = false;
    protected b dzu = null;
    private int cik = -1;
    private int mTabId = 0;
    private int dpW = 3;
    private boolean cFf = false;
    public boolean dzw = false;
    private Runnable dzx = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (!j.jD() || FrsGoodFragment.this.cFf) {
                FrsGoodFragment.this.c((d.a) null);
            } else {
                FrsGoodFragment.this.fW(false);
            }
        }
    };
    private CustomMessageListener ayc = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bc)) {
                bc bcVar = (bc) customResponsedMessage.getData();
                FrsGoodFragment.this.dqa = bcVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.dqa) && bcVar.vj() != null) {
                    FrsGoodFragment.this.kD(bcVar.vj().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dku = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.Bb() != null) {
                            FrsGoodFragment.this.Bb().setSelection(0);
                        }
                        if (FrsGoodFragment.this.mRefreshView != null && FrsGoodFragment.this.mRefreshView.Jh()) {
                            FrsGoodFragment.this.fW(false);
                        } else if (FrsGoodFragment.this.dzu != null) {
                            FrsGoodFragment.this.dzu.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dkH = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        private long dzA = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kj(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsGoodFragment.this.dzu.auG();
                    return;
                case 3:
                    FrsGoodFragment.this.dzu.cp(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<h> a;
            if (aVar == null) {
                this.dzA = 1L;
            } else if (aVar.isSuccess) {
                this.dzA = 0L;
            } else {
                this.dzA = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.dzt.resetData();
            }
            FrsGoodFragment.this.dzu.cp(false);
            if (FrsGoodFragment.this.ayu().ayA() != null) {
                FrsGoodFragment.this.djc = FrsGoodFragment.this.ayu().ayA();
            }
            FrsGoodFragment.this.cik = FrsGoodFragment.this.djc.uJ().uF();
            if (FrsGoodFragment.this.cik == 0 && (FrsGoodFragment.this.djc.bvG() == null || FrsGoodFragment.this.djc.bvG().size() == 0)) {
                if (FrsGoodFragment.this.djc.getThreadList() == null || FrsGoodFragment.this.djc.getThreadList().size() == 0) {
                    FrsGoodFragment.this.dzu.Uf();
                } else {
                    FrsGoodFragment.this.dzu.Ue();
                }
            } else {
                FrsGoodFragment.this.dzu.Ud();
            }
            if (i == 4) {
                ArrayList<h> a2 = FrsGoodFragment.this.dzt.a(false, false, false, FrsGoodFragment.this.djc.getThreadList(), (e) null);
                if (a2 != null) {
                    FrsGoodFragment.this.djc.az(a2);
                    FrsGoodFragment.this.dzu.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.djc, FrsGoodFragment.this.cik);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.dzu.auG();
                    break;
                case 2:
                    FrsGoodFragment.this.dzu.auG();
                    break;
                case 3:
                    if (FrsGoodFragment.this.djc.bvX()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.dzA != 0) {
                FrsGoodFragment.this.c(aVar);
            } else {
                if (FrsGoodFragment.this.djc != null) {
                    FrsGoodFragment.this.djs = FrsGoodFragment.this.djc.baT().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.djc.baT().getId();
                    FrsGoodFragment.this.dzu.b(FrsGoodFragment.this.djc.baT(), FrsGoodFragment.this.djc.getUserData());
                }
                if (FrsGoodFragment.this.djc != null) {
                    FrsGoodFragment.this.djc.bwr();
                }
                FrsGoodFragment.this.dzu.d(FrsGoodFragment.this.djc);
                if (FrsGoodFragment.this.djc == null || FrsGoodFragment.this.djc.getThreadList() == null || FrsGoodFragment.this.djc.getThreadList().size() != 0 || FrsGoodFragment.this.ayu().getType() != 4) {
                    if (FrsGoodFragment.this.djc != null && (a = FrsGoodFragment.this.dzt.a(false, false, true, FrsGoodFragment.this.djc.getThreadList(), (e) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.djc.az(a);
                    }
                    FrsGoodFragment.this.atU();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(d.k.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.cQb > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.cQb, FrsGoodFragment.this.ayu().aoF() - FrsGoodFragment.this.cQb, FrsGoodFragment.this.ayu().aoD(), FrsGoodFragment.this.ayu().aoE(), currentTimeMillis2 - FrsGoodFragment.this.ayu().aoC());
                        FrsGoodFragment.this.cQb = -1L;
                    }
                    FrsGoodFragment.this.aTS = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.cQb > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.cQb, FrsGoodFragment.this.ayu().aoF() - FrsGoodFragment.this.cQb, FrsGoodFragment.this.ayu().aoD(), FrsGoodFragment.this.ayu().aoE(), currentTimeMillis3 - FrsGoodFragment.this.ayu().aoC());
                FrsGoodFragment.this.cQb = -1L;
            }
            FrsGoodFragment.this.aTS = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private final CustomMessageListener acM = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.dzu != null) {
                FrsGoodFragment.this.dzu.startPullRefresh();
            }
        }
    };
    private final g.b bxO = new g.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        @Override // com.baidu.tbadk.core.view.g.b
        public void aU(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.jD()) {
                com.baidu.tieba.a.d.QB().iC("page_frs_good");
                FrsGoodFragment.this.fW(true);
                return;
            }
            FrsGoodFragment.this.dzu.cp(false);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.djI) {
                FrsGoodFragment.this.djI = true;
                FrsGoodFragment.this.dzu.auS();
            }
            if (i == 0) {
                v.aiz().ex(true);
            }
        }
    };
    private final CustomMessageListener aDX = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
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
    private com.baidu.adp.widget.ListView.n dkN = new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bc)) {
                bc bcVar = (bc) hVar;
                if (bcVar.wf() == null || bcVar.wf().getGroup_id() == 0 || bb.aU(FrsGoodFragment.this.getActivity())) {
                    if (bcVar.vY() != 1 || bb.aU(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.ua(bcVar.getId())) {
                            readThreadHistory.tZ(bcVar.getId());
                            if (FrsGoodFragment.this.dzu != null) {
                                FrsGoodFragment.this.dzu.auG();
                            }
                        }
                        boolean z = false;
                        final String vD = bcVar.vD();
                        if (vD != null && !vD.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    y yVar = new y(vD);
                                    yVar.yX().zX().mIsNeedAddCommenParam = false;
                                    yVar.yX().zX().mIsUseCurrentBDUSS = false;
                                    yVar.yA();
                                }
                            }).start();
                        }
                        String tid = bcVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bcVar.vr() == 2 && !tid.startsWith("pb:")) {
                            az.zV().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bcVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bcVar, FrsGoodFragment.this.djs, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bcVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.dzw ? 15 : 3);
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
        this.dzu.fP(false);
        showLoadingView(this.dzu.avx(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dzu.fP(true);
        hideLoadingView(this.dzu.avx());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dzu.fP(false);
        this.dzu.avy().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dzu.Uf();
        this.dzu.getListView().getData().clear();
        this.dzu.auG();
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.j.g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Jp();
            this.mRefreshView.ff(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.Jn().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.setSubText(getPageContext().getResources().getString(d.k.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.setSubText(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.d(this.dzu.avx(), true);
    }

    private void Uc() {
        this.dzu.fP(true);
        this.dzu.avy().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Jh()) {
            this.mRefreshView.Q(this.dzu.avx());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(boolean z) {
        this.cFf = true;
        atX();
        Uc();
        if (!z) {
            Uc();
            showLoadingView();
        }
        this.dzs.gN(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cQb = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.cQb = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.aTK = this.beginTime - this.cQb;
        super.onCreate(bundle);
        this.dzs = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dzs.i(arguments);
            this.dzr = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dzs.i(bundle);
            this.dzr = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dzs.i(null);
        }
        this.djz = getVoiceManager();
        this.djz.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.acM);
        registerListener(this.ayc);
        registerListener(this.dku);
        this.dzt = new FrsLoadMoreModel(this, null);
        this.dzt.registerListener();
        this.dzt.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_good_activity, (ViewGroup) null);
        this.dzu = new b(this, inflate, this.dzr);
        this.dzu.ayy().gh(this.dzw);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.cFf) {
            if (j.jD()) {
                fW(false);
            } else {
                c((d.a) null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.djz = getVoiceManager();
        this.djz.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        ays();
        if (bundle != null) {
            this.djs = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dzw = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.djs = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.dzw = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void ays() {
        registerListener(2001118, this.aDX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dzu != null) {
            this.dzu.onDestroy();
        }
        v.aiz().ex(false);
        super.onDestroy();
        this.dzs.onActivityDestroy();
        this.djz = getVoiceManager();
        this.djz.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.dzx);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.djs);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dzr);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.dzw);
        this.dzs.onSaveInstanceState(bundle);
        this.djz = getVoiceManager();
        if (this.djz != null) {
            this.djz.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bc mD;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dzu.ayy().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (mD = this.djc.mD(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            mD.bU(intent.getIntExtra("good_data", 0));
                            mD.wd();
                            fW(false);
                            return;
                        } else if (intExtra == 0) {
                            this.djc.Y(mD);
                            ArrayList<h> threadList = this.djc.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.dzu.ayw();
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
            if (this.dpW == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.cFf) {
                com.baidu.adp.lib.g.e.im().post(this.dzx);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dzu != null) {
            this.dzu.auG();
        }
        this.djz = getVoiceManager();
        this.djz.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dzv = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dzu.setOnAdapterItemClickListener(this.dkN);
        this.dzu.setOnScrollListener(this.mScrollListener);
        this.dzu.a(this.bxO);
        this.dzu.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.dzv != null) {
                    FrsGoodFragment.this.dzv.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dpW != 3 || this.dzu != null) {
            this.dpW = i;
            super.onChangeSkinType(i);
            if (this.dzu != null) {
                this.dzu.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> ati() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).ati();
        }
        return null;
    }

    private void atT() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.in().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.tU(FrsGoodFragment.this.djs);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atU() {
        atX();
        try {
            if (this.djc != null) {
                this.dzu.showListView();
                this.djs = this.djc.baT().getName();
                this.forumId = this.djc.baT().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.djc.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.djc.getUserData().getBimg_end_time());
                atT();
                if (!this.dzu.ayy().k(bc.aif)) {
                    this.djc.bwt();
                }
                ArrayList<h> threadList = this.djc.getThreadList();
                if (threadList != null) {
                    this.dzu.a(threadList, this.mPn, this.djc, this.djc.uJ().uF());
                    ayt();
                    this.dzu.ayw();
                    if (this.djc.bbi() == 1) {
                        this.dzu.ayy().setFromCDN(true);
                    } else {
                        this.dzu.ayy().setFromCDN(false);
                    }
                    this.dzu.setListViewSelection(aB(ayu().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aB(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.djz = getVoiceManager();
        this.djz.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        v.aiz().ex(false);
        if (this.djc != null && this.djc.baT() != null) {
            com.baidu.tbadk.distribute.a.Hj().a(getPageContext().getPageActivity(), "frs", this.djc.baT().getId(), 0L);
        }
        this.djz = getVoiceManager();
        if (this.djz != null) {
            this.djz.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kD(int i) {
        ArrayList<h> threadList = this.djc.getThreadList();
        if (threadList != null) {
            Iterator<h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bc) {
                    bc bcVar = (bc) next;
                    if (bcVar.getId() != null && bcVar.getId().equals(this.dqa)) {
                        a(bcVar, i);
                        this.dqa = null;
                        break;
                    }
                }
            }
            this.dzu.ayy().b(threadList, this.djc);
            this.dzu.ayy().notifyDataSetChanged();
        }
    }

    private void a(bc bcVar, int i) {
        if (i == 1) {
            PraiseData vj = bcVar.vj();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (vj == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bcVar.a(praiseData);
                    return;
                }
                bcVar.vj().getUser().add(0, metaData);
                bcVar.vj().setNum(bcVar.vj().getNum() + 1);
                bcVar.vj().setIsLike(i);
            }
        } else if (bcVar.vj() != null) {
            bcVar.vj().setIsLike(i);
            bcVar.vj().setNum(bcVar.vj().getNum() - 1);
            ArrayList<MetaData> user = bcVar.vj().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bcVar.vj().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.djz == null) {
            this.djz = VoiceManager.instance();
        }
        return this.djz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Bb() {
        if (this.dzu == null) {
            return null;
        }
        return this.dzu.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void atX() {
        this.djz = getVoiceManager();
        this.djz.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Bc() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).Bc();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.djc != null && this.dzu != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dzu.auG();
            }
        }
    }

    private void ayt() {
        HashMap<Integer, bc> awu;
        if (this.dzu != null && this.dzu.ayy() != null && (awu = this.dzu.ayy().awu()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bc> entry : awu.entrySet()) {
                bc value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.Ho().s(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public k onGetPreLoadListView() {
        if (Bb() == null) {
            return null;
        }
        return Bb().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jD()) {
            fW(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l atZ() {
        return this.djc;
    }

    public FrsGoodModelController ayu() {
        return this.dzs;
    }

    public void mS(String str) {
        this.djs = str;
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
        if (!com.baidu.adp.lib.util.l.jU()) {
            this.dzu.Uf();
        } else if (!this.dzs.ayC()) {
            this.dzu.Uf();
        } else {
            Tt();
            if (!this.dzt.isLoading && !this.dzs.AO()) {
                if (this.dzt.by(this.djc.bvG())) {
                    this.dzu.a(this.dzt.ayP(), this.mPn, this.djc, 0);
                    this.dzt.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.djc.bvG(), this.djs, this.mPn, this.djc.isBrandForum);
                } else if (this.cik != 0) {
                    this.dzu.a(this.dzt.ayP(), this.mPn, this.djc, 0);
                    this.mPn++;
                    this.dzs.le(this.mPn);
                    this.dzt.loadingDone = false;
                    this.dzt.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void mc(String str) {
        Tt();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<h> arrayList) {
        ArrayList<h> a;
        Tt();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dzt.a(false, false, false, arrayList, (e) null)) != null) {
            this.djc.az(a);
            this.dzu.a(a, this.mPn, this.djc, 0);
        }
    }

    private void Tt() {
        if (this.cik == 0 && !this.dzt.by(this.djc.bvG())) {
            if (this.djc.getThreadList() == null || this.djc.getThreadList().size() == 0) {
                this.dzu.Uf();
                return;
            } else {
                this.dzu.Ue();
                return;
            }
        }
        this.dzu.Ud();
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ac.aN(getActivity().getApplicationContext())) {
                al.b(getPageContext());
            } else {
                showToast(d.k.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> ahZ() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Hj().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void atW() {
        if (this.dzs != null) {
            this.dzs.atW();
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
    public NavigationBar UW() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.djs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ld(int i) {
        this.mTabId = i;
        if (j.jD()) {
            fW(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void atu() {
        if (this.dzu != null && this.dzu.getListView() != null) {
            this.dzu.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ua() {
        if (this.dzu != null) {
            atu();
            this.dzu.startPullRefresh();
        }
    }
}
