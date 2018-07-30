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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
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
    private FrsGoodModelController dCe;
    private FrsLoadMoreModel dCf;
    private com.baidu.tieba.frs.gametab.b dCh;
    private VoiceManager dmp;
    private String dsN;
    private String dmi = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dCd = false;
    private String forumId = null;
    private l dlS = new l();
    public long cSN = -1;
    public long aTL = 0;
    public long aTT = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dmy = false;
    protected b dCg = null;
    private int cjR = -1;
    private int mTabId = 0;
    private int dsJ = 3;
    private boolean cHM = false;
    public boolean dCi = false;
    private Runnable dCj = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (!j.jE() || FrsGoodFragment.this.cHM) {
                FrsGoodFragment.this.c((d.a) null);
            } else {
                FrsGoodFragment.this.fY(false);
            }
        }
    };
    private CustomMessageListener axI = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                bb bbVar = (bb) customResponsedMessage.getData();
                FrsGoodFragment.this.dsN = bbVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.dsN) && bbVar.uX() != null) {
                    FrsGoodFragment.this.kO(bbVar.uX().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dnk = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.AS() != null) {
                            FrsGoodFragment.this.AS().setSelection(0);
                        }
                        if (FrsGoodFragment.this.mRefreshView != null && FrsGoodFragment.this.mRefreshView.Jc()) {
                            FrsGoodFragment.this.fY(false);
                        } else if (FrsGoodFragment.this.dCg != null) {
                            FrsGoodFragment.this.dCg.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dnx = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        private long dCm = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void ku(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsGoodFragment.this.dCg.avk();
                    return;
                case 3:
                    FrsGoodFragment.this.dCg.cp(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<h> a;
            if (aVar == null) {
                this.dCm = 1L;
            } else if (aVar.isSuccess) {
                this.dCm = 0L;
            } else {
                this.dCm = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.dCf.resetData();
            }
            FrsGoodFragment.this.dCg.cp(false);
            if (FrsGoodFragment.this.ayZ().azf() != null) {
                FrsGoodFragment.this.dlS = FrsGoodFragment.this.ayZ().azf();
            }
            FrsGoodFragment.this.cjR = FrsGoodFragment.this.dlS.uw().us();
            if (FrsGoodFragment.this.cjR == 0 && (FrsGoodFragment.this.dlS.buk() == null || FrsGoodFragment.this.dlS.buk().size() == 0)) {
                if (FrsGoodFragment.this.dlS.getThreadList() == null || FrsGoodFragment.this.dlS.getThreadList().size() == 0) {
                    FrsGoodFragment.this.dCg.Un();
                } else {
                    FrsGoodFragment.this.dCg.Um();
                }
            } else {
                FrsGoodFragment.this.dCg.Ul();
            }
            if (i == 4) {
                ArrayList<h> a2 = FrsGoodFragment.this.dCf.a(false, false, false, FrsGoodFragment.this.dlS.getThreadList(), (e) null);
                if (a2 != null) {
                    FrsGoodFragment.this.dlS.ax(a2);
                    FrsGoodFragment.this.dCg.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.dlS, FrsGoodFragment.this.cjR);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.dCg.avk();
                    break;
                case 2:
                    FrsGoodFragment.this.dCg.avk();
                    break;
                case 3:
                    if (FrsGoodFragment.this.dlS.buB()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.dCm != 0) {
                FrsGoodFragment.this.c(aVar);
            } else {
                if (FrsGoodFragment.this.dlS != null) {
                    FrsGoodFragment.this.dmi = FrsGoodFragment.this.dlS.aZl().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.dlS.aZl().getId();
                    FrsGoodFragment.this.dCg.b(FrsGoodFragment.this.dlS.aZl(), FrsGoodFragment.this.dlS.getUserData());
                }
                if (FrsGoodFragment.this.dlS != null) {
                    FrsGoodFragment.this.dlS.buV();
                }
                FrsGoodFragment.this.dCg.d(FrsGoodFragment.this.dlS);
                if (FrsGoodFragment.this.dlS == null || FrsGoodFragment.this.dlS.getThreadList() == null || FrsGoodFragment.this.dlS.getThreadList().size() != 0 || FrsGoodFragment.this.ayZ().getType() != 4) {
                    if (FrsGoodFragment.this.dlS != null && (a = FrsGoodFragment.this.dCf.a(false, false, true, FrsGoodFragment.this.dlS.getThreadList(), (e) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.dlS.ax(a);
                    }
                    FrsGoodFragment.this.auy();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(d.j.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.cSN > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.cSN, FrsGoodFragment.this.ayZ().apf() - FrsGoodFragment.this.cSN, FrsGoodFragment.this.ayZ().apd(), FrsGoodFragment.this.ayZ().ape(), currentTimeMillis2 - FrsGoodFragment.this.ayZ().apc());
                        FrsGoodFragment.this.cSN = -1L;
                    }
                    FrsGoodFragment.this.aTT = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.cSN > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.cSN, FrsGoodFragment.this.ayZ().apf() - FrsGoodFragment.this.cSN, FrsGoodFragment.this.ayZ().apd(), FrsGoodFragment.this.ayZ().ape(), currentTimeMillis3 - FrsGoodFragment.this.ayZ().apc());
                FrsGoodFragment.this.cSN = -1L;
            }
            FrsGoodFragment.this.aTT = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private final CustomMessageListener acq = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.dCg != null) {
                FrsGoodFragment.this.dCg.startPullRefresh();
            }
        }
    };
    private final g.b byt = new g.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        @Override // com.baidu.tbadk.core.view.g.b
        public void aS(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.jE()) {
                com.baidu.tieba.a.d.QI().iz("page_frs_good");
                FrsGoodFragment.this.fY(true);
                return;
            }
            FrsGoodFragment.this.dCg.cp(false);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.dmy) {
                FrsGoodFragment.this.dmy = true;
                FrsGoodFragment.this.dCg.avw();
            }
            if (i == 0) {
                v.aiY().ey(true);
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
    private com.baidu.adp.widget.ListView.n dnD = new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bb)) {
                bb bbVar = (bb) hVar;
                if (bbVar.vU() == null || bbVar.vU().getGroup_id() == 0 || ba.aV(FrsGoodFragment.this.getActivity())) {
                    if (bbVar.vN() != 1 || ba.aV(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.tY(bbVar.getId())) {
                            readThreadHistory.tX(bbVar.getId());
                            if (FrsGoodFragment.this.dCg != null) {
                                FrsGoodFragment.this.dCg.avk();
                            }
                        }
                        boolean z = false;
                        final String vs = bbVar.vs();
                        if (vs != null && !vs.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    y yVar = new y(vs);
                                    yVar.yO().zM().mIsNeedAddCommenParam = false;
                                    yVar.yO().zM().mIsUseCurrentBDUSS = false;
                                    yVar.yr();
                                }
                            }).start();
                        }
                        String tid = bbVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bbVar.vf() == 2 && !tid.startsWith("pb:")) {
                            ay.zK().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bbVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, FrsGoodFragment.this.dmi, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.dCi ? 15 : 3);
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
        this.dCg.fR(false);
        showLoadingView(this.dCg.awc(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dCg.fR(true);
        hideLoadingView(this.dCg.awc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dCg.fR(false);
        this.dCg.awd().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dCg.Un();
        this.dCg.getListView().getData().clear();
        this.dCg.avk();
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Jk();
            this.mRefreshView.fg(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.Ji().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.hk(getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.hk(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.c(this.dCg.awc(), true);
    }

    private void Uk() {
        this.dCg.fR(true);
        this.dCg.awd().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Jc()) {
            this.mRefreshView.Q(this.dCg.awc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fY(boolean z) {
        this.cHM = true;
        auB();
        Uk();
        if (!z) {
            Uk();
            showLoadingView();
        }
        this.dCe.gT(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cSN = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.cSN = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.aTL = this.beginTime - this.cSN;
        super.onCreate(bundle);
        this.dCe = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dCe.i(arguments);
            this.dCd = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dCe.i(bundle);
            this.dCd = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dCe.i(null);
        }
        this.dmp = getVoiceManager();
        this.dmp.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.acq);
        registerListener(this.axI);
        registerListener(this.dnk);
        this.dCf = new FrsLoadMoreModel(this, null);
        this.dCf.registerListener();
        this.dCf.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_good_activity, (ViewGroup) null);
        this.dCg = new b(this, inflate, this.dCd);
        this.dCg.azd().gj(this.dCi);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.cHM) {
            if (j.jE()) {
                fY(false);
            } else {
                c((d.a) null);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dmp = getVoiceManager();
        this.dmp.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        ayX();
        if (bundle != null) {
            this.dmi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dCi = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dmi = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.dCi = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void ayX() {
        registerListener(2001118, this.aDX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dCg != null) {
            this.dCg.onDestroy();
        }
        v.aiY().ey(false);
        super.onDestroy();
        this.dCe.onActivityDestroy();
        this.dmp = getVoiceManager();
        this.dmp.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.dCj);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dmi);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dCd);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.dCi);
        this.dCe.onSaveInstanceState(bundle);
        this.dmp = getVoiceManager();
        if (this.dmp != null) {
            this.dmp.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bb mC;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dCg.azd().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (mC = this.dlS.mC(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            mC.bW(intent.getIntExtra("good_data", 0));
                            mC.vS();
                            fY(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dlS.aa(mC);
                            ArrayList<h> threadList = this.dlS.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.dCg.azb();
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
            if (this.dsJ == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.cHM) {
                com.baidu.adp.lib.g.e.in().post(this.dCj);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dCg != null) {
            this.dCg.avk();
        }
        this.dmp = getVoiceManager();
        this.dmp.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dCh = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dCg.setOnAdapterItemClickListener(this.dnD);
        this.dCg.setOnScrollListener(this.mScrollListener);
        this.dCg.a(this.byt);
        this.dCg.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.dCh != null) {
                    FrsGoodFragment.this.dCh.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dsJ != 3 || this.dCg != null) {
            this.dsJ = i;
            super.onChangeSkinType(i);
            if (this.dCg != null) {
                this.dCg.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> atM() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).atM();
        }
        return null;
    }

    private void aux() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.io().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.tS(FrsGoodFragment.this.dmi);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auy() {
        auB();
        try {
            if (this.dlS != null) {
                this.dCg.agN();
                this.dmi = this.dlS.aZl().getName();
                this.forumId = this.dlS.aZl().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dlS.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dlS.getUserData().getBimg_end_time());
                aux();
                if (!this.dCg.azd().k(bb.ahB)) {
                    this.dlS.buX();
                }
                ArrayList<h> threadList = this.dlS.getThreadList();
                if (threadList != null) {
                    this.dCg.a(threadList, this.mPn, this.dlS, this.dlS.uw().us());
                    ayY();
                    this.dCg.azb();
                    if (this.dlS.aZA() == 1) {
                        this.dCg.azd().setFromCDN(true);
                    } else {
                        this.dCg.azd().setFromCDN(false);
                    }
                    this.dCg.setListViewSelection(aE(ayZ().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aE(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dmp = getVoiceManager();
        this.dmp.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        v.aiY().ey(false);
        if (this.dlS != null && this.dlS.aZl() != null) {
            com.baidu.tbadk.distribute.a.Hf().a(getPageContext().getPageActivity(), "frs", this.dlS.aZl().getId(), 0L);
        }
        this.dmp = getVoiceManager();
        if (this.dmp != null) {
            this.dmp.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kO(int i) {
        ArrayList<h> threadList = this.dlS.getThreadList();
        if (threadList != null) {
            Iterator<h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar.getId() != null && bbVar.getId().equals(this.dsN)) {
                        a(bbVar, i);
                        this.dsN = null;
                        break;
                    }
                }
            }
            this.dCg.azd().b(threadList, this.dlS);
            this.dCg.azd().notifyDataSetChanged();
        }
    }

    private void a(bb bbVar, int i) {
        if (i == 1) {
            PraiseData uX = bbVar.uX();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (uX == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bbVar.a(praiseData);
                    return;
                }
                bbVar.uX().getUser().add(0, metaData);
                bbVar.uX().setNum(bbVar.uX().getNum() + 1);
                bbVar.uX().setIsLike(i);
            }
        } else if (bbVar.uX() != null) {
            bbVar.uX().setIsLike(i);
            bbVar.uX().setNum(bbVar.uX().getNum() - 1);
            ArrayList<MetaData> user = bbVar.uX().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bbVar.uX().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmp == null) {
            this.dmp = VoiceManager.instance();
        }
        return this.dmp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView AS() {
        if (this.dCg == null) {
            return null;
        }
        return this.dCg.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void auB() {
        this.dmp = getVoiceManager();
        this.dmp.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AT() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).AT();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.dlS != null && this.dCg != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dCg.avk();
            }
        }
    }

    private void ayY() {
        HashMap<Integer, bb> awZ;
        if (this.dCg != null && this.dCg.azd() != null && (awZ = this.dCg.azd().awZ()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bb> entry : awZ.entrySet()) {
                bb value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.Hk().s(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public k onGetPreLoadListView() {
        if (AS() == null) {
            return null;
        }
        return AS().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jE()) {
            fY(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l auD() {
        return this.dlS;
    }

    public FrsGoodModelController ayZ() {
        return this.dCe;
    }

    public void mR(String str) {
        this.dmi = str;
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
        if (!com.baidu.adp.lib.util.l.jV()) {
            this.dCg.Un();
        } else if (!this.dCe.azh()) {
            this.dCg.Un();
        } else {
            TB();
            if (!this.dCf.isLoading && !this.dCe.AE()) {
                if (this.dCf.bx(this.dlS.buk())) {
                    this.dCg.a(this.dCf.azv(), this.mPn, this.dlS, 0);
                    this.dCf.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.dlS.buk(), this.dmi, this.mPn, this.dlS.isBrandForum);
                } else if (this.cjR != 0) {
                    this.dCg.a(this.dCf.azv(), this.mPn, this.dlS, 0);
                    this.mPn++;
                    this.dCe.lp(this.mPn);
                    this.dCf.loadingDone = false;
                    this.dCf.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void mb(String str) {
        TB();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<h> arrayList) {
        ArrayList<h> a;
        TB();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dCf.a(false, false, false, arrayList, (e) null)) != null) {
            this.dlS.ax(a);
            this.dCg.a(a, this.mPn, this.dlS, 0);
        }
    }

    private void TB() {
        if (this.cjR == 0 && !this.dCf.bx(this.dlS.buk())) {
            if (this.dlS.getThreadList() == null || this.dlS.getThreadList().size() == 0) {
                this.dCg.Un();
                return;
            } else {
                this.dCg.Um();
                return;
            }
        }
        this.dCg.Ul();
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ac.aO(getActivity().getApplicationContext())) {
                al.b(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> aiy() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Hf().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void auA() {
        if (this.dCe != null) {
            this.dCe.auA();
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
    public NavigationBar Vf() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dmi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lo(int i) {
        this.mTabId = i;
        if (j.jE()) {
            fY(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void atY() {
        if (this.dCg != null && this.dCg.getListView() != null) {
            this.dCg.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ui() {
        if (this.dCg != null) {
            atY();
            this.dCg.startPullRefresh();
        }
    }
}
