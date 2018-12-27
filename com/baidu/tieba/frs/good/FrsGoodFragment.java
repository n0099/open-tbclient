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
    private VoiceManager dKQ;
    private String ebk;
    private FrsGoodModelController ebm;
    private FrsLoadMoreModel ebn;
    private com.baidu.tieba.frs.gametab.b ebp;
    private String dKJ = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean ebl = false;
    private String forumId = null;
    private l dKt = new l();
    public long dru = -1;
    public long bfQ = 0;
    public long bfY = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dKY = false;
    protected b ebo = null;
    private int cEk = -1;
    private int mTabId = 0;
    private int dRD = 3;
    private boolean dgz = false;
    public boolean ebq = false;
    private Runnable ebr = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (!j.kV() || FrsGoodFragment.this.dgz) {
                FrsGoodFragment.this.c((d.a) null);
            } else {
                FrsGoodFragment.this.hm(false);
            }
        }
    };
    private CustomMessageListener ebs = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                bb bbVar = (bb) customResponsedMessage.getData();
                FrsGoodFragment.this.ebk = bbVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.ebk) && bbVar.zt() != null) {
                    FrsGoodFragment.this.ni(bbVar.zt().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dLL = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.Fv() != null) {
                            FrsGoodFragment.this.Fv().setSelection(0);
                        }
                        if (FrsGoodFragment.this.mRefreshView != null && FrsGoodFragment.this.mRefreshView.isViewAttached()) {
                            FrsGoodFragment.this.hm(false);
                        } else if (FrsGoodFragment.this.ebo != null) {
                            FrsGoodFragment.this.ebo.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dLY = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        private long ebv = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void ml(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsGoodFragment.this.ebo.aCu();
                    return;
                case 3:
                    FrsGoodFragment.this.ebo.di(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<h> a;
            if (aVar == null) {
                this.ebv = 1L;
            } else if (aVar.isSuccess) {
                this.ebv = 0L;
            } else {
                this.ebv = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.ebn.resetData();
            }
            FrsGoodFragment.this.ebo.di(false);
            if (FrsGoodFragment.this.aGu().aGB() != null) {
                FrsGoodFragment.this.dKt = FrsGoodFragment.this.aGu().aGB();
            }
            FrsGoodFragment.this.cEk = FrsGoodFragment.this.dKt.yS().yP();
            if (FrsGoodFragment.this.cEk == 0 && (FrsGoodFragment.this.dKt.bCn() == null || FrsGoodFragment.this.dKt.bCn().size() == 0)) {
                if (FrsGoodFragment.this.dKt.getThreadList() == null || FrsGoodFragment.this.dKt.getThreadList().size() == 0) {
                    FrsGoodFragment.this.ebo.abd();
                } else {
                    FrsGoodFragment.this.ebo.abc();
                }
            } else {
                FrsGoodFragment.this.ebo.abb();
            }
            if (i == 4) {
                ArrayList<h> a2 = FrsGoodFragment.this.ebn.a(false, false, false, FrsGoodFragment.this.dKt.getThreadList(), (e) null);
                if (a2 != null) {
                    FrsGoodFragment.this.dKt.ay(a2);
                    FrsGoodFragment.this.ebo.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.dKt, FrsGoodFragment.this.cEk);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.ebo.aCu();
                    break;
                case 2:
                    FrsGoodFragment.this.ebo.aCu();
                    break;
                case 3:
                    if (FrsGoodFragment.this.dKt.bCE()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.ebv != 0) {
                FrsGoodFragment.this.c(aVar);
            } else {
                if (FrsGoodFragment.this.dKt != null) {
                    FrsGoodFragment.this.dKJ = FrsGoodFragment.this.dKt.bgT().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.dKt.bgT().getId();
                    FrsGoodFragment.this.ebo.b(FrsGoodFragment.this.dKt.bgT(), FrsGoodFragment.this.dKt.getUserData());
                }
                if (FrsGoodFragment.this.dKt != null) {
                    FrsGoodFragment.this.dKt.bCY();
                }
                FrsGoodFragment.this.ebo.e(FrsGoodFragment.this.dKt);
                if (FrsGoodFragment.this.dKt == null || FrsGoodFragment.this.dKt.getThreadList() == null || FrsGoodFragment.this.dKt.getThreadList().size() != 0 || FrsGoodFragment.this.aGu().getType() != 4) {
                    if (FrsGoodFragment.this.dKt != null && (a = FrsGoodFragment.this.ebn.a(false, false, true, FrsGoodFragment.this.dKt.getThreadList(), (e) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.dKt.ay(a);
                    }
                    FrsGoodFragment.this.aBJ();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(e.j.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.dru > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.dru, FrsGoodFragment.this.aGu().awp() - FrsGoodFragment.this.dru, FrsGoodFragment.this.aGu().awn(), FrsGoodFragment.this.aGu().awo(), currentTimeMillis2 - FrsGoodFragment.this.aGu().awm());
                        FrsGoodFragment.this.dru = -1L;
                    }
                    FrsGoodFragment.this.bfY = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.dru > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.dru, FrsGoodFragment.this.aGu().awp() - FrsGoodFragment.this.dru, FrsGoodFragment.this.aGu().awn(), FrsGoodFragment.this.aGu().awo(), currentTimeMillis3 - FrsGoodFragment.this.aGu().awm());
                FrsGoodFragment.this.dru = -1L;
            }
            FrsGoodFragment.this.bfY = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private final CustomMessageListener aof = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.ebo != null) {
                FrsGoodFragment.this.ebo.startPullRefresh();
            }
        }
    };
    private final j.b bRt = new j.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        @Override // com.baidu.tbadk.core.view.j.b
        public void bH(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.kV()) {
                com.baidu.tieba.a.d.VO().jK("page_frs_good");
                FrsGoodFragment.this.hm(true);
                return;
            }
            FrsGoodFragment.this.ebo.di(false);
        }
    };
    private final j.a aIG = new j.a() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
        @Override // com.baidu.tbadk.core.view.j.a
        public void b(View view, boolean z) {
            if (z) {
                c.bBT().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.dKY) {
                FrsGoodFragment.this.dKY = true;
                FrsGoodFragment.this.ebo.aCH();
            }
            if (i == 0) {
                v.aqs().fv(true);
                c.bBT().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }
    };
    private final CustomMessageListener aPW = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private com.baidu.adp.widget.ListView.n dMe = new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bb)) {
                bb bbVar = (bb) hVar;
                if (bbVar.As() == null || bbVar.As().getGroup_id() == 0 || ba.bJ(FrsGoodFragment.this.getActivity())) {
                    if (bbVar.Ak() != 1 || ba.bJ(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.vU(bbVar.getId())) {
                            readThreadHistory.vT(bbVar.getId());
                            if (FrsGoodFragment.this.ebo != null) {
                                FrsGoodFragment.this.ebo.aCu();
                            }
                        }
                        boolean z = false;
                        final String zO = bbVar.zO();
                        if (zO != null && !zO.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
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
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, FrsGoodFragment.this.dKJ, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.ebq ? 15 : 3);
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
        this.ebo.gU(false);
        showLoadingView(this.ebo.aCF(), true, getResources().getDimensionPixelSize(e.C0210e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.ebo.gU(true);
        hideLoadingView(this.ebo.aCF());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.ebo.gU(false);
        this.ebo.aDE().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.ebo.abd();
        this.ebo.getListView().getData().clear();
        this.ebo.aCu();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.NM();
            this.mRefreshView.gd(getResources().getDimensionPixelSize(e.C0210e.ds_102));
            this.mRefreshView.NK().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.io(getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.io(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.ebo.aCF(), true);
    }

    private void aba() {
        this.ebo.gU(true);
        this.ebo.aDE().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached()) {
            this.mRefreshView.dettachView(this.ebo.aCF());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hm(boolean z) {
        this.dgz = true;
        aBM();
        aba();
        if (!z) {
            aba();
            showLoadingView();
        }
        this.ebm.is(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dru = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.dru = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.bfQ = this.beginTime - this.dru;
        super.onCreate(bundle);
        c.bBT().r(getUniqueId());
        this.ebm = new FrsGoodModelController(this);
        if (arguments != null) {
            this.ebm.p(arguments);
            this.ebl = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.ebm.p(bundle);
            this.ebl = bundle.getBoolean("is_game_frs", false);
        } else {
            this.ebm.p(null);
        }
        this.dKQ = getVoiceManager();
        this.dKQ.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.aof);
        registerListener(this.ebs);
        registerListener(this.dLL);
        this.ebn = new FrsLoadMoreModel(this, null);
        this.ebn.registerListener();
        this.ebn.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_good_activity, (ViewGroup) null);
        this.ebo = new b(this, inflate, this.ebl);
        this.ebo.aGy().hl(this.ebq);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.dgz) {
            if (com.baidu.adp.lib.util.j.kV()) {
                hm(false);
            } else {
                c((d.a) null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dKQ = getVoiceManager();
        this.dKQ.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        aGs();
        if (bundle != null) {
            this.dKJ = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.ebq = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dKJ = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.ebq = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void aGs() {
        registerListener(2001118, this.aPW);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ebo != null) {
            this.ebo.onDestroy();
        }
        c.bBT().s(getUniqueId());
        v.aqs().fv(false);
        super.onDestroy();
        this.ebm.onActivityDestroy();
        this.dKQ = getVoiceManager();
        this.dKQ.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ebr);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dKJ);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.ebl);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.ebq);
        this.ebm.onSaveInstanceState(bundle);
        this.dKQ = getVoiceManager();
        if (this.dKQ != null) {
            this.dKQ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bb vy;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.ebo.aGy().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (vy = this.dKt.vy(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            vy.cS(intent.getIntExtra("good_data", 0));
                            vy.Aq();
                            hm(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dKt.ab(vy);
                            ArrayList<h> threadList = this.dKt.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.ebo.aGw();
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
            if (this.dRD == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.dgz) {
                com.baidu.adp.lib.g.e.jG().post(this.ebr);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ebo != null) {
            this.ebo.aCu();
        }
        this.dKQ = getVoiceManager();
        this.dKQ.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.ebp = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.ebo.setOnAdapterItemClickListener(this.dMe);
        this.ebo.setOnScrollListener(this.mScrollListener);
        this.ebo.a(this.bRt);
        this.ebo.a(this.aIG);
        this.ebo.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.ebp != null) {
                    FrsGoodFragment.this.ebp.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dRD != 3 || this.ebo != null) {
            this.dRD = i;
            super.onChangeSkinType(i);
            if (this.ebo != null) {
                this.ebo.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aAV() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aAV();
        }
        return null;
    }

    private void aBI() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.vO(FrsGoodFragment.this.dKJ);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBJ() {
        aBM();
        try {
            if (this.dKt != null) {
                this.ebo.anp();
                this.dKJ = this.dKt.bgT().getName();
                this.forumId = this.dKt.bgT().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dKt.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dKt.getUserData().getBimg_end_time());
                aBI();
                if (!this.ebo.aGy().k(bb.atk)) {
                    this.dKt.bDa();
                }
                ArrayList<h> threadList = this.dKt.getThreadList();
                if (threadList != null) {
                    this.ebo.a(threadList, this.mPn, this.dKt, this.dKt.yS().yP());
                    aGt();
                    this.ebo.aGw();
                    if (this.dKt.bhi() == 1) {
                        this.ebo.aGy().setFromCDN(true);
                    } else {
                        this.ebo.aGy().setFromCDN(false);
                    }
                    this.ebo.setListViewSelection(aV(aGu().getType(), this.mPn));
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
        this.dKQ = getVoiceManager();
        this.dKQ.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        v.aqs().fv(false);
        c.bBT().b(getUniqueId(), false);
        if (this.dKt != null && this.dKt.bgT() != null) {
            com.baidu.tbadk.distribute.a.LL().a(getPageContext().getPageActivity(), "frs", this.dKt.bgT().getId(), 0L);
        }
        this.dKQ = getVoiceManager();
        if (this.dKQ != null) {
            this.dKQ.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(int i) {
        ArrayList<h> threadList = this.dKt.getThreadList();
        if (threadList != null) {
            Iterator<h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar.getId() != null && bbVar.getId().equals(this.ebk)) {
                        a(bbVar, i);
                        this.ebk = null;
                        break;
                    }
                }
            }
            this.ebo.aGy().b(threadList, this.dKt);
            this.ebo.aGy().notifyDataSetChanged();
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
        if (this.dKQ == null) {
            this.dKQ = VoiceManager.instance();
        }
        return this.dKQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Fv() {
        if (this.ebo == null) {
            return null;
        }
        return this.ebo.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aBM() {
        this.dKQ = getVoiceManager();
        this.dKQ.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Fw() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).Fw();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.dKt != null && this.ebo != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.ebo.aCu();
            }
        }
    }

    private void aGt() {
        HashMap<Integer, bb> aEB;
        if (this.ebo != null && this.ebo.aGy() != null && (aEB = this.ebo.aGy().aEB()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bb> entry : aEB.entrySet()) {
                bb value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.LQ().s(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public k onGetPreLoadListView() {
        if (Fv() == null) {
            return null;
        }
        return Fv().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            hm(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l aBO() {
        return this.dKt;
    }

    public FrsGoodModelController aGu() {
        return this.ebm;
    }

    public void oD(String str) {
        this.dKJ = str;
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
            this.ebo.abd();
        } else if (!this.ebm.aGD()) {
            this.ebo.abd();
        } else {
            aar();
            if (!this.ebn.isLoading && !this.ebm.Fi()) {
                if (this.ebn.bP(this.dKt.bCn())) {
                    this.ebo.a(this.ebn.aGR(), this.mPn, this.dKt, 0);
                    this.ebn.a(com.baidu.adp.lib.g.b.d(this.forumId, 0L), this.dKt.bCn(), this.dKJ, this.mPn, this.dKt.isBrandForum);
                } else if (this.cEk != 0) {
                    this.ebo.a(this.ebn.aGR(), this.mPn, this.dKt, 0);
                    this.mPn++;
                    this.ebm.nk(this.mPn);
                    this.ebn.loadingDone = false;
                    this.ebn.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void nK(String str) {
        aar();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<h> arrayList) {
        ArrayList<h> a;
        aar();
        if (arrayList != null && arrayList.size() != 0 && (a = this.ebn.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.e) null)) != null) {
            this.dKt.ay(a);
            this.ebo.a(a, this.mPn, this.dKt, 0);
        }
    }

    private void aar() {
        if (this.cEk == 0 && !this.ebn.bP(this.dKt.bCn())) {
            if (this.dKt.getThreadList() == null || this.dKt.getThreadList().size() == 0) {
                this.ebo.abd();
                return;
            } else {
                this.ebo.abc();
                return;
            }
        }
        this.ebo.abb();
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
        com.baidu.tbadk.distribute.a.LL().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void aBL() {
        if (this.ebm != null) {
            this.ebm.aBL();
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
    public NavigationBar abW() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dKJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nj(int i) {
        this.mTabId = i;
        if (com.baidu.adp.lib.util.j.kV()) {
            hm(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aBh() {
        if (this.ebo != null && this.ebo.getListView() != null) {
            this.ebo.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aaY() {
        if (this.ebo != null) {
            aBh();
            this.ebo.startPullRefresh();
        }
    }
}
