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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.f;
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
    private FrsGoodModelController dCb;
    private FrsLoadMoreModel dCc;
    private com.baidu.tieba.frs.gametab.b dCe;
    private VoiceManager dmn;
    private String dsK;
    private String dmg = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dCa = false;
    private String forumId = null;
    private l dlQ = new l();
    public long cSK = -1;
    public long aTL = 0;
    public long aTT = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dmw = false;
    protected b dCd = null;
    private int cjO = -1;
    private int mTabId = 0;
    private int dsG = 3;
    private boolean cHJ = false;
    public boolean dCf = false;
    private Runnable dCg = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (!j.jE() || FrsGoodFragment.this.cHJ) {
                FrsGoodFragment.this.c((d.a) null);
            } else {
                FrsGoodFragment.this.fY(false);
            }
        }
    };
    private CustomMessageListener axF = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                bb bbVar = (bb) customResponsedMessage.getData();
                FrsGoodFragment.this.dsK = bbVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.dsK) && bbVar.uW() != null) {
                    FrsGoodFragment.this.kN(bbVar.uW().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dni = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int parseInt = Integer.parseInt(data.toString());
                    if (parseInt == 301 || parseInt == 303) {
                        if (FrsGoodFragment.this.AP() != null) {
                            FrsGoodFragment.this.AP().setSelection(0);
                        }
                        if (FrsGoodFragment.this.mRefreshView != null && FrsGoodFragment.this.mRefreshView.Jc()) {
                            FrsGoodFragment.this.fY(false);
                        } else if (FrsGoodFragment.this.dCd != null) {
                            FrsGoodFragment.this.dCd.startPullRefresh();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        }
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dnv = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        private long dCj = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kt(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsGoodFragment.this.dCd.avj();
                    return;
                case 3:
                    FrsGoodFragment.this.dCd.cq(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<h> a;
            if (aVar == null) {
                this.dCj = 1L;
            } else if (aVar.isSuccess) {
                this.dCj = 0L;
            } else {
                this.dCj = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.dCc.resetData();
            }
            FrsGoodFragment.this.dCd.cq(false);
            if (FrsGoodFragment.this.ayX().azd() != null) {
                FrsGoodFragment.this.dlQ = FrsGoodFragment.this.ayX().azd();
            }
            FrsGoodFragment.this.cjO = FrsGoodFragment.this.dlQ.uv().ur();
            if (FrsGoodFragment.this.cjO == 0 && (FrsGoodFragment.this.dlQ.bul() == null || FrsGoodFragment.this.dlQ.bul().size() == 0)) {
                if (FrsGoodFragment.this.dlQ.getThreadList() == null || FrsGoodFragment.this.dlQ.getThreadList().size() == 0) {
                    FrsGoodFragment.this.dCd.Uq();
                } else {
                    FrsGoodFragment.this.dCd.Up();
                }
            } else {
                FrsGoodFragment.this.dCd.Uo();
            }
            if (i == 4) {
                ArrayList<h> a2 = FrsGoodFragment.this.dCc.a(false, false, false, FrsGoodFragment.this.dlQ.getThreadList(), (e) null);
                if (a2 != null) {
                    FrsGoodFragment.this.dlQ.ax(a2);
                    FrsGoodFragment.this.dCd.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.dlQ, FrsGoodFragment.this.cjO);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.dCd.avj();
                    break;
                case 2:
                    FrsGoodFragment.this.dCd.avj();
                    break;
                case 3:
                    if (FrsGoodFragment.this.dlQ.buC()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.dCj != 0) {
                FrsGoodFragment.this.c(aVar);
            } else {
                if (FrsGoodFragment.this.dlQ != null) {
                    FrsGoodFragment.this.dmg = FrsGoodFragment.this.dlQ.aZg().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.dlQ.aZg().getId();
                    FrsGoodFragment.this.dCd.b(FrsGoodFragment.this.dlQ.aZg(), FrsGoodFragment.this.dlQ.getUserData());
                }
                if (FrsGoodFragment.this.dlQ != null) {
                    FrsGoodFragment.this.dlQ.buW();
                }
                FrsGoodFragment.this.dCd.d(FrsGoodFragment.this.dlQ);
                if (FrsGoodFragment.this.dlQ == null || FrsGoodFragment.this.dlQ.getThreadList() == null || FrsGoodFragment.this.dlQ.getThreadList().size() != 0 || FrsGoodFragment.this.ayX().getType() != 4) {
                    if (FrsGoodFragment.this.dlQ != null && (a = FrsGoodFragment.this.dCc.a(false, false, true, FrsGoodFragment.this.dlQ.getThreadList(), (e) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.dlQ.ax(a);
                    }
                    FrsGoodFragment.this.aux();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(f.j.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.cSK > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.cSK, FrsGoodFragment.this.ayX().apf() - FrsGoodFragment.this.cSK, FrsGoodFragment.this.ayX().apd(), FrsGoodFragment.this.ayX().ape(), currentTimeMillis2 - FrsGoodFragment.this.ayX().apc());
                        FrsGoodFragment.this.cSK = -1L;
                    }
                    FrsGoodFragment.this.aTT = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.cSK > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.cSK, FrsGoodFragment.this.ayX().apf() - FrsGoodFragment.this.cSK, FrsGoodFragment.this.ayX().apd(), FrsGoodFragment.this.ayX().ape(), currentTimeMillis3 - FrsGoodFragment.this.ayX().apc());
                FrsGoodFragment.this.cSK = -1L;
            }
            FrsGoodFragment.this.aTT = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private final CustomMessageListener acr = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.dCd != null) {
                FrsGoodFragment.this.dCd.startPullRefresh();
            }
        }
    };
    private final g.b byv = new g.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        @Override // com.baidu.tbadk.core.view.g.b
        public void aT(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.jE()) {
                com.baidu.tieba.a.d.QN().iA("page_frs_good");
                FrsGoodFragment.this.fY(true);
                return;
            }
            FrsGoodFragment.this.dCd.cq(false);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.dmw) {
                FrsGoodFragment.this.dmw = true;
                FrsGoodFragment.this.dCd.avv();
            }
            if (i == 0) {
                v.ajb().ey(true);
            }
        }
    };
    private final CustomMessageListener aDW = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
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
    private com.baidu.adp.widget.ListView.n dnB = new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bb)) {
                bb bbVar = (bb) hVar;
                if (bbVar.vT() == null || bbVar.vT().getGroup_id() == 0 || com.baidu.tbadk.core.util.bb.aU(FrsGoodFragment.this.getActivity())) {
                    if (bbVar.vM() != 1 || com.baidu.tbadk.core.util.bb.aU(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.uc(bbVar.getId())) {
                            readThreadHistory.ub(bbVar.getId());
                            if (FrsGoodFragment.this.dCd != null) {
                                FrsGoodFragment.this.dCd.avj();
                            }
                        }
                        boolean z = false;
                        final String vr = bbVar.vr();
                        if (vr != null && !vr.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    y yVar = new y(vr);
                                    yVar.yM().zK().mIsNeedAddCommenParam = false;
                                    yVar.yM().zK().mIsUseCurrentBDUSS = false;
                                    yVar.yp();
                                }
                            }).start();
                        }
                        String tid = bbVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bbVar.ve() == 2 && !tid.startsWith("pb:")) {
                            az.zI().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bbVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, FrsGoodFragment.this.dmg, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
                        createFromThreadCfg.setStartFrom(FrsGoodFragment.this.dCf ? 15 : 3);
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
        this.dCd.fR(false);
        showLoadingView(this.dCd.awb(), true, getResources().getDimensionPixelSize(f.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dCd.fR(true);
        hideLoadingView(this.dCd.awb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dCd.fR(false);
        this.dCd.awc().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dCd.Uq();
        this.dCd.getListView().getData().clear();
        this.dCd.avj();
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Jk();
            this.mRefreshView.ff(getResources().getDimensionPixelSize(f.e.ds_102));
            this.mRefreshView.Ji().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.hk(getPageContext().getResources().getString(f.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.hk(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.c(this.dCd.awb(), true);
    }

    private void Un() {
        this.dCd.fR(true);
        this.dCd.awc().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Jc()) {
            this.mRefreshView.Q(this.dCd.awb());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fY(boolean z) {
        this.cHJ = true;
        auA();
        Un();
        if (!z) {
            Un();
            showLoadingView();
        }
        this.dCb.gS(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cSK = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.cSK = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.aTL = this.beginTime - this.cSK;
        super.onCreate(bundle);
        this.dCb = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dCb.i(arguments);
            this.dCa = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dCb.i(bundle);
            this.dCa = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dCb.i(null);
        }
        this.dmn = getVoiceManager();
        this.dmn.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.acr);
        registerListener(this.axF);
        registerListener(this.dni);
        this.dCc = new FrsLoadMoreModel(this, null);
        this.dCc.registerListener();
        this.dCc.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(f.h.frs_good_activity, (ViewGroup) null);
        this.dCd = new b(this, inflate, this.dCa);
        this.dCd.azb().gj(this.dCf);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.cHJ) {
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
        this.dmn = getVoiceManager();
        this.dmn.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        ayV();
        if (bundle != null) {
            this.dmg = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dCf = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dmg = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
                this.dCf = arguments.getBoolean(FrsActivityConfig.IS_SELECTION, false);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void ayV() {
        registerListener(2001118, this.aDW);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dCd != null) {
            this.dCd.onDestroy();
        }
        v.ajb().ey(false);
        super.onDestroy();
        this.dCb.onActivityDestroy();
        this.dmn = getVoiceManager();
        this.dmn.onDestory(getPageContext());
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.dCg);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dmg);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dCa);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.dCf);
        this.dCb.onSaveInstanceState(bundle);
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bb mE;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dCd.azb().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (mE = this.dlQ.mE(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            mE.bW(intent.getIntExtra("good_data", 0));
                            mE.vR();
                            fY(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dlQ.aa(mE);
                            ArrayList<h> threadList = this.dlQ.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.dCd.ayZ();
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
            if (this.dsG == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.cHJ) {
                com.baidu.adp.lib.g.e.in().post(this.dCg);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dCd != null) {
            this.dCd.avj();
        }
        this.dmn = getVoiceManager();
        this.dmn.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dCe = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dCd.setOnAdapterItemClickListener(this.dnB);
        this.dCd.setOnScrollListener(this.mScrollListener);
        this.dCd.a(this.byv);
        this.dCd.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.dCe != null) {
                    FrsGoodFragment.this.dCe.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dsG != 3 || this.dCd != null) {
            this.dsG = i;
            super.onChangeSkinType(i);
            if (this.dCd != null) {
                this.dCd.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> atL() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).atL();
        }
        return null;
    }

    private void auw() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.io().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.tW(FrsGoodFragment.this.dmg);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aux() {
        auA();
        try {
            if (this.dlQ != null) {
                this.dCd.agP();
                this.dmg = this.dlQ.aZg().getName();
                this.forumId = this.dlQ.aZg().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dlQ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dlQ.getUserData().getBimg_end_time());
                auw();
                if (!this.dCd.azb().k(bb.ahB)) {
                    this.dlQ.buY();
                }
                ArrayList<h> threadList = this.dlQ.getThreadList();
                if (threadList != null) {
                    this.dCd.a(threadList, this.mPn, this.dlQ, this.dlQ.uv().ur());
                    ayW();
                    this.dCd.ayZ();
                    if (this.dlQ.aZv() == 1) {
                        this.dCd.azb().setFromCDN(true);
                    } else {
                        this.dCd.azb().setFromCDN(false);
                    }
                    this.dCd.setListViewSelection(aE(ayX().getType(), this.mPn));
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
        this.dmn = getVoiceManager();
        this.dmn.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        v.ajb().ey(false);
        if (this.dlQ != null && this.dlQ.aZg() != null) {
            com.baidu.tbadk.distribute.a.Hf().a(getPageContext().getPageActivity(), "frs", this.dlQ.aZg().getId(), 0L);
        }
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kN(int i) {
        ArrayList<h> threadList = this.dlQ.getThreadList();
        if (threadList != null) {
            Iterator<h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar.getId() != null && bbVar.getId().equals(this.dsK)) {
                        a(bbVar, i);
                        this.dsK = null;
                        break;
                    }
                }
            }
            this.dCd.azb().b(threadList, this.dlQ);
            this.dCd.azb().notifyDataSetChanged();
        }
    }

    private void a(bb bbVar, int i) {
        if (i == 1) {
            PraiseData uW = bbVar.uW();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (uW == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bbVar.a(praiseData);
                    return;
                }
                bbVar.uW().getUser().add(0, metaData);
                bbVar.uW().setNum(bbVar.uW().getNum() + 1);
                bbVar.uW().setIsLike(i);
            }
        } else if (bbVar.uW() != null) {
            bbVar.uW().setIsLike(i);
            bbVar.uW().setNum(bbVar.uW().getNum() - 1);
            ArrayList<MetaData> user = bbVar.uW().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bbVar.uW().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmn == null) {
            this.dmn = VoiceManager.instance();
        }
        return this.dmn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView AP() {
        if (this.dCd == null) {
            return null;
        }
        return this.dCd.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void auA() {
        this.dmn = getVoiceManager();
        this.dmn.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AQ() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).AQ();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.dlQ != null && this.dCd != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dCd.avj();
            }
        }
    }

    private void ayW() {
        HashMap<Integer, bb> awY;
        if (this.dCd != null && this.dCd.azb() != null && (awY = this.dCd.azb().awY()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bb> entry : awY.entrySet()) {
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
        if (AP() == null) {
            return null;
        }
        return AP().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jE()) {
            fY(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l auC() {
        return this.dlQ;
    }

    public FrsGoodModelController ayX() {
        return this.dCb;
    }

    public void mT(String str) {
        this.dmg = str;
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
            this.dCd.Uq();
        } else if (!this.dCb.azf()) {
            this.dCd.Uq();
        } else {
            TE();
            if (!this.dCc.isLoading && !this.dCb.AB()) {
                if (this.dCc.bx(this.dlQ.bul())) {
                    this.dCd.a(this.dCc.azt(), this.mPn, this.dlQ, 0);
                    this.dCc.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.dlQ.bul(), this.dmg, this.mPn, this.dlQ.isBrandForum);
                } else if (this.cjO != 0) {
                    this.dCd.a(this.dCc.azt(), this.mPn, this.dlQ, 0);
                    this.mPn++;
                    this.dCb.lp(this.mPn);
                    this.dCc.loadingDone = false;
                    this.dCc.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void md(String str) {
        TE();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<h> arrayList) {
        ArrayList<h> a;
        TE();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dCc.a(false, false, false, arrayList, (e) null)) != null) {
            this.dlQ.ax(a);
            this.dCd.a(a, this.mPn, this.dlQ, 0);
        }
    }

    private void TE() {
        if (this.cjO == 0 && !this.dCc.bx(this.dlQ.bul())) {
            if (this.dlQ.getThreadList() == null || this.dlQ.getThreadList().size() == 0) {
                this.dCd.Uq();
                return;
            } else {
                this.dCd.Up();
                return;
            }
        }
        this.dCd.Uo();
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ac.aN(getActivity().getApplicationContext())) {
                al.b(getPageContext());
            } else {
                showToast(f.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(f.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> aiB() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Hf().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void auz() {
        if (this.dCb != null) {
            this.dCb.auz();
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
    public NavigationBar Vj() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dmg;
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
    public void atX() {
        if (this.dCd != null && this.dCd.getListView() != null) {
            this.dCd.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ul() {
        if (this.dCd != null) {
            atX();
            this.dCd.startPullRefresh();
        }
    }
}
