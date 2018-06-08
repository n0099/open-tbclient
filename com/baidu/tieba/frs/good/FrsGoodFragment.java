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
import com.baidu.adp.base.e;
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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0061a, UserIconBox.b, VoiceManager.c, ah, ai, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private VoiceManager dhB;
    private String dmP;
    private FrsGoodModelController dwi;
    private FrsLoadMoreModel dwj;
    private com.baidu.tieba.frs.gametab.b dwl;
    private String dhv = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dwh = false;
    private String forumId = null;
    private l dhf = new l();
    public long cSd = -1;
    public long aSO = 0;
    public long aSW = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dhK = false;
    protected b dwk = null;
    private int cfZ = -1;
    private int mTabId = 0;
    private int dmK = 3;
    private CustomMessageListener axl = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                bd bdVar = (bd) customResponsedMessage.getData();
                FrsGoodFragment.this.dmP = bdVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.dmP) && bdVar.va() != null) {
                    FrsGoodFragment.this.kw(bdVar.va().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener diu = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.AJ() != null) {
                        FrsGoodFragment.this.AJ().setSelection(0);
                    }
                    if (FrsGoodFragment.this.mRefreshView != null && FrsGoodFragment.this.mRefreshView.IP()) {
                        FrsGoodFragment.this.fN(false);
                    } else if (FrsGoodFragment.this.dwk != null) {
                        FrsGoodFragment.this.dwk.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n diG = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        private long dwo = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kf(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsGoodFragment.this.dwk.auo();
                    return;
                case 3:
                    FrsGoodFragment.this.dwk.cm(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<h> a;
            if (aVar == null) {
                this.dwo = 1L;
            } else if (aVar.isSuccess) {
                this.dwo = 0L;
            } else {
                this.dwo = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.dwj.resetData();
            }
            FrsGoodFragment.this.dwk.cm(false);
            if (FrsGoodFragment.this.axP().axV() != null) {
                FrsGoodFragment.this.dhf = FrsGoodFragment.this.axP().axV();
            }
            FrsGoodFragment.this.cfZ = FrsGoodFragment.this.dhf.uB().ux();
            if (FrsGoodFragment.this.cfZ == 0 && (FrsGoodFragment.this.dhf.bvg() == null || FrsGoodFragment.this.dhf.bvg().size() == 0)) {
                if (FrsGoodFragment.this.dhf.getThreadList() == null || FrsGoodFragment.this.dhf.getThreadList().size() == 0) {
                    FrsGoodFragment.this.dwk.TL();
                } else {
                    FrsGoodFragment.this.dwk.TK();
                }
            } else {
                FrsGoodFragment.this.dwk.TJ();
            }
            if (i == 4) {
                ArrayList<h> a2 = FrsGoodFragment.this.dwj.a(false, false, false, FrsGoodFragment.this.dhf.getThreadList(), null);
                if (a2 != null) {
                    FrsGoodFragment.this.dhf.av(a2);
                    FrsGoodFragment.this.dwk.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.dhf, FrsGoodFragment.this.cfZ);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.dwk.auo();
                    break;
                case 2:
                    FrsGoodFragment.this.dwk.auo();
                    break;
                case 3:
                    if (FrsGoodFragment.this.dhf.bvx()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.dwo != 0) {
                FrsGoodFragment.this.c(aVar);
            } else {
                if (FrsGoodFragment.this.dhf != null) {
                    FrsGoodFragment.this.dhv = FrsGoodFragment.this.dhf.bam().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.dhf.bam().getId();
                    FrsGoodFragment.this.dwk.b(FrsGoodFragment.this.dhf.bam(), FrsGoodFragment.this.dhf.getUserData());
                }
                if (FrsGoodFragment.this.dhf != null) {
                    FrsGoodFragment.this.dhf.bvR();
                }
                FrsGoodFragment.this.dwk.d(FrsGoodFragment.this.dhf);
                if (FrsGoodFragment.this.dhf == null || FrsGoodFragment.this.dhf.getThreadList() == null || FrsGoodFragment.this.dhf.getThreadList().size() != 0 || FrsGoodFragment.this.axP().getType() != 4) {
                    if (FrsGoodFragment.this.dhf != null && (a = FrsGoodFragment.this.dwj.a(false, false, true, FrsGoodFragment.this.dhf.getThreadList(), null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.dhf.av(a);
                    }
                    FrsGoodFragment.this.atD();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(d.k.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.i(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.cSd > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.cSd, FrsGoodFragment.this.axP().apl() - FrsGoodFragment.this.cSd, FrsGoodFragment.this.axP().apj(), FrsGoodFragment.this.axP().apk(), currentTimeMillis2 - FrsGoodFragment.this.axP().aph());
                        FrsGoodFragment.this.cSd = -1L;
                    }
                    FrsGoodFragment.this.aSW = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.cSd > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.cSd, FrsGoodFragment.this.axP().apl() - FrsGoodFragment.this.cSd, FrsGoodFragment.this.axP().apj(), FrsGoodFragment.this.axP().apk(), currentTimeMillis3 - FrsGoodFragment.this.axP().aph());
                FrsGoodFragment.this.cSd = -1L;
            }
            FrsGoodFragment.this.aSW = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private final CustomMessageListener acJ = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.dwk != null) {
                FrsGoodFragment.this.dwk.startPullRefresh();
            }
        }
    };
    private final f.b bws = new f.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // com.baidu.tbadk.core.view.f.b
        public void aS(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.jD()) {
                com.baidu.tieba.a.d.Qe().ix("page_frs_good");
                FrsGoodFragment.this.fN(true);
                return;
            }
            FrsGoodFragment.this.dwk.cm(false);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.dhK) {
                FrsGoodFragment.this.dhK = true;
                FrsGoodFragment.this.dwk.auz();
            }
            if (i == 0) {
                v.ajh().ey(true);
            }
        }
    };
    private final CustomMessageListener aDd = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
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
    private com.baidu.adp.widget.ListView.n diM = new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bd)) {
                bd bdVar = (bd) hVar;
                if (bdVar.vV() == null || bdVar.vV().getGroup_id() == 0 || ba.aU(FrsGoodFragment.this.getActivity())) {
                    if (bdVar.vO() != 1 || ba.aU(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.ua(bdVar.getId())) {
                            readThreadHistory.tZ(bdVar.getId());
                            if (FrsGoodFragment.this.dwk != null) {
                                FrsGoodFragment.this.dwk.auo();
                            }
                        }
                        boolean z = false;
                        final String vt = bdVar.vt();
                        if (vt != null && !vt.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    y yVar = new y(vt);
                                    yVar.yJ().zI().mIsNeedAddCommenParam = false;
                                    yVar.yJ().zI().mIsUseCurrentBDUSS = false;
                                    yVar.ym();
                                }
                            }).start();
                        }
                        String tid = bdVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bdVar.vh() == 2 && !tid.startsWith("pb:")) {
                            ay.zG().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bdVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, FrsGoodFragment.this.dhv, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    }
                }
            }
        }
    };

    static /* synthetic */ int i(FrsGoodFragment frsGoodFragment) {
        int i = frsGoodFragment.mPn;
        frsGoodFragment.mPn = i - 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ e getPageContext() {
        return super.getPageContext();
    }

    private void showLoadingView() {
        this.dwk.fO(false);
        showLoadingView(this.dwk.avq(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dwk.fO(true);
        hideLoadingView(this.dwk.avq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dwk.fO(false);
        this.dwk.avr().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dwk.TL();
        this.dwk.getListView().getData().clear();
        this.dwk.auo();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.IX();
            this.mRefreshView.fe(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.IV().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.setSubText(getPageContext().getResources().getString(d.k.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.setSubText(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.d(this.dwk.avq(), true);
    }

    private void TI() {
        this.dwk.fO(true);
        this.dwk.avr().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.IP()) {
            this.mRefreshView.P(this.dwk.avq());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(boolean z) {
        atG();
        TI();
        if (!z) {
            TI();
            showLoadingView();
        }
        this.dwi.gO(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cSd = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.cSd = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.aSO = this.beginTime - this.cSd;
        super.onCreate(bundle);
        this.dwi = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dwi.i(arguments);
            this.dwh = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dwi.i(bundle);
            this.dwh = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dwi.i(null);
        }
        this.dhB = getVoiceManager();
        this.dhB.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.acJ);
        registerListener(this.axl);
        registerListener(this.diu);
        this.dwj = new FrsLoadMoreModel(this, null);
        this.dwj.registerListener();
        this.dwj.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_good_activity, (ViewGroup) null);
        this.dwk = new b(this, inflate, this.dwh);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.jD()) {
            fN(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dhB = getVoiceManager();
        this.dhB.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        axN();
        if (bundle != null) {
            this.dhv = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dhv = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void axN() {
        registerListener(2001118, this.aDd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dwk != null) {
            this.dwk.onDestroy();
        }
        v.ajh().ey(false);
        super.onDestroy();
        this.dwi.onActivityDestroy();
        this.dhB = getVoiceManager();
        this.dhB.onDestory(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dhv);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dwh);
        this.dwi.onSaveInstanceState(bundle);
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bd mD;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dwk.axT().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (mD = this.dhf.mD(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            mD.bT(intent.getIntExtra("good_data", 0));
                            mD.vT();
                            fN(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dhf.an(mD);
                            ArrayList<h> threadList = this.dhf.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new k());
                            }
                            this.dwk.axR();
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
        if (isAdded() && isPrimary() && this.dmK == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dwk != null) {
            this.dwk.auo();
        }
        this.dhB = getVoiceManager();
        this.dhB.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dwl = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dwk.setOnAdapterItemClickListener(this.diM);
        this.dwk.setOnScrollListener(this.mScrollListener);
        this.dwk.a(this.bws);
        this.dwk.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.dwl != null) {
                    FrsGoodFragment.this.dwl.d(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dmK != 3 || this.dwk != null) {
            this.dmK = i;
            super.onChangeSkinType(i);
            if (this.dwk != null) {
                this.dwk.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> asR() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).asR();
        }
        return null;
    }

    private void atC() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.in().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.tU(FrsGoodFragment.this.dhv);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atD() {
        atG();
        try {
            if (this.dhf != null) {
                this.dwk.showListView();
                this.dhv = this.dhf.bam().getName();
                this.forumId = this.dhf.bam().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dhf.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dhf.getUserData().getBimg_end_time());
                atC();
                if (!this.dwk.axT().k(bd.ahN)) {
                    this.dhf.bvT();
                }
                ArrayList<h> threadList = this.dhf.getThreadList();
                if (threadList != null) {
                    this.dwk.a(threadList, this.mPn, this.dhf, this.dhf.uB().ux());
                    axO();
                    this.dwk.axR();
                    if (this.dhf.baB() == 1) {
                        this.dwk.axT().setFromCDN(true);
                    } else {
                        this.dwk.axT().setFromCDN(false);
                    }
                    this.dwk.setListViewSelection(aC(axP().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aC(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dhB = getVoiceManager();
        this.dhB.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        v.ajh().ey(false);
        if (this.dhf != null && this.dhf.bam() != null) {
            com.baidu.tbadk.distribute.a.GR().a(getPageContext().getPageActivity(), "frs", this.dhf.bam().getId(), 0L);
        }
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw(int i) {
        ArrayList<h> threadList = this.dhf.getThreadList();
        if (threadList != null) {
            Iterator<h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar.getId() != null && bdVar.getId().equals(this.dmP)) {
                        a(bdVar, i);
                        this.dmP = null;
                        break;
                    }
                }
            }
            this.dwk.axT().b(threadList, this.dhf);
            this.dwk.axT().notifyDataSetChanged();
        }
    }

    private void a(bd bdVar, int i) {
        if (i == 1) {
            PraiseData va = bdVar.va();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (va == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bdVar.a(praiseData);
                    return;
                }
                bdVar.va().getUser().add(0, metaData);
                bdVar.va().setNum(bdVar.va().getNum() + 1);
                bdVar.va().setIsLike(i);
            }
        } else if (bdVar.va() != null) {
            bdVar.va().setIsLike(i);
            bdVar.va().setNum(bdVar.va().getNum() - 1);
            ArrayList<MetaData> user = bdVar.va().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bdVar.va().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dhB == null) {
            this.dhB = VoiceManager.instance();
        }
        return this.dhB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView AJ() {
        if (this.dwk == null) {
            return null;
        }
        return this.dwk.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void atG() {
        this.dhB = getVoiceManager();
        this.dhB.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AK() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).AK();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.dhf != null && this.dwk != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dwk.auo();
            }
        }
    }

    private void axO() {
        HashMap<Integer, bd> avQ;
        if (this.dwk != null && this.dwk.axT() != null && (avQ = this.dwk.axT().avQ()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bd> entry : avQ.entrySet()) {
                bd value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.GW().o(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (AJ() == null) {
            return null;
        }
        return AJ().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jD()) {
            fN(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l atI() {
        return this.dhf;
    }

    public FrsGoodModelController axP() {
        return this.dwi;
    }

    public void mS(String str) {
        this.dhv = str;
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
            this.dwk.TL();
        } else if (!this.dwi.axX()) {
            this.dwk.TL();
        } else {
            SX();
            if (!this.dwj.isLoading && !this.dwi.Ax()) {
                if (this.dwj.bu(this.dhf.bvg())) {
                    this.dwk.a(this.dwj.ayj(), this.mPn, this.dhf, 0);
                    this.dwj.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.dhf.bvg(), this.dhv, this.mPn);
                } else if (this.cfZ != 0) {
                    this.dwk.a(this.dwj.ayj(), this.mPn, this.dhf, 0);
                    this.mPn++;
                    this.dwi.kX(this.mPn);
                    this.dwj.loadingDone = false;
                    this.dwj.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void mg(String str) {
        SX();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void I(ArrayList<h> arrayList) {
        ArrayList<h> a;
        SX();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dwj.a(false, false, false, arrayList, null)) != null) {
            this.dhf.av(a);
            this.dwk.a(a, this.mPn, this.dhf, 0);
        }
    }

    private void SX() {
        if (this.cfZ == 0 && !this.dwj.bu(this.dhf.bvg())) {
            if (this.dhf.getThreadList() == null || this.dhf.getThreadList().size() == 0) {
                this.dwk.TL();
                return;
            } else {
                this.dwk.TK();
                return;
            }
        }
        this.dwk.TJ();
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ac.aN(getActivity().getApplicationContext())) {
                ak.b(getPageContext());
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
    public TbPageContext<?> aiH() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.GR().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void atF() {
        if (this.dwi != null) {
            this.dwi.atF();
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

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar UB() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dhv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kW(int i) {
        this.mTabId = i;
        if (j.jD()) {
            fN(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void atd() {
        if (this.dwk != null && this.dwk.getListView() != null) {
            this.dwk.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void TG() {
        if (this.dwk != null) {
            atd();
            this.dwk.startPullRefresh();
        }
    }
}
