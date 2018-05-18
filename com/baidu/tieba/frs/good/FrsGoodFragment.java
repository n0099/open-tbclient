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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.k.d;
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
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0045a, UserIconBox.b, VoiceManager.c, ah, ai, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private VoiceManager cYn;
    private String ddB;
    private FrsGoodModelController dmQ;
    private FrsLoadMoreModel dmR;
    private com.baidu.tieba.frs.gametab.b dmT;
    private String cYh = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dmP = false;
    private String forumId = null;
    private l cXS = new l();
    public long cIX = -1;
    public long aKO = 0;
    public long aKW = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean cYt = false;
    private d cYu = null;
    protected b dmS = null;
    private int bXW = -1;
    private int mTabId = 0;
    private int ddw = 3;
    private CustomMessageListener apd = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                bd bdVar = (bd) customResponsedMessage.getData();
                FrsGoodFragment.this.ddB = bdVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.ddB) && bdVar.rE() != null) {
                    FrsGoodFragment.this.kr(bdVar.rE().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener cZd = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.xi() != null) {
                        FrsGoodFragment.this.xi().setSelection(0);
                    }
                    if (FrsGoodFragment.this.mRefreshView != null && FrsGoodFragment.this.mRefreshView.Fk()) {
                        FrsGoodFragment.this.fI(false);
                    } else if (FrsGoodFragment.this.dmS != null) {
                        FrsGoodFragment.this.dmS.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n cZo = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        private long dmW = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kc(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsGoodFragment.this.dmS.aqj();
                    return;
                case 3:
                    FrsGoodFragment.this.dmS.ch(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<h> a;
            if (aVar == null) {
                this.dmW = 1L;
            } else if (aVar.isSuccess) {
                this.dmW = 0L;
            } else {
                this.dmW = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.dmR.resetData();
            }
            FrsGoodFragment.this.dmS.ch(false);
            if (FrsGoodFragment.this.atC().atI() != null) {
                FrsGoodFragment.this.cXS = FrsGoodFragment.this.atC().atI();
            }
            FrsGoodFragment.this.bXW = FrsGoodFragment.this.cXS.rf().rb();
            if (FrsGoodFragment.this.bXW == 0 && (FrsGoodFragment.this.cXS.bqf() == null || FrsGoodFragment.this.cXS.bqf().size() == 0)) {
                if (FrsGoodFragment.this.cXS.getThreadList() == null || FrsGoodFragment.this.cXS.getThreadList().size() == 0) {
                    FrsGoodFragment.this.dmS.Qn();
                } else {
                    FrsGoodFragment.this.dmS.Qm();
                }
            } else {
                FrsGoodFragment.this.dmS.Ql();
            }
            if (i == 4) {
                ArrayList<h> a2 = FrsGoodFragment.this.dmR.a(false, false, false, FrsGoodFragment.this.cXS.getThreadList(), null);
                if (a2 != null) {
                    FrsGoodFragment.this.cXS.av(a2);
                    FrsGoodFragment.this.dmS.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.cXS, FrsGoodFragment.this.bXW);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.dmS.aqj();
                    break;
                case 2:
                    FrsGoodFragment.this.dmS.aqj();
                    break;
                case 3:
                    if (FrsGoodFragment.this.cXS.bqx()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.Os();
            if (this.dmW != 0) {
                FrsGoodFragment.this.c(aVar);
            } else {
                if (FrsGoodFragment.this.cXS != null) {
                    FrsGoodFragment.this.cYh = FrsGoodFragment.this.cXS.aVq().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.cXS.aVq().getId();
                    FrsGoodFragment.this.dmS.b(FrsGoodFragment.this.cXS.aVq(), FrsGoodFragment.this.cXS.getUserData());
                }
                if (FrsGoodFragment.this.cXS != null) {
                    FrsGoodFragment.this.cXS.bqP();
                }
                FrsGoodFragment.this.dmS.c(FrsGoodFragment.this.cXS);
                if (FrsGoodFragment.this.cXS == null || FrsGoodFragment.this.cXS.getThreadList() == null || FrsGoodFragment.this.cXS.getThreadList().size() != 0 || FrsGoodFragment.this.atC().getType() != 4) {
                    if (FrsGoodFragment.this.cXS != null && (a = FrsGoodFragment.this.dmR.a(false, false, true, FrsGoodFragment.this.cXS.getThreadList(), null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.cXS.av(a);
                    }
                    FrsGoodFragment.this.apy();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(d.k.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.i(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.cIX > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.cIX, FrsGoodFragment.this.atC().alf() - FrsGoodFragment.this.cIX, FrsGoodFragment.this.atC().ald(), FrsGoodFragment.this.atC().ale(), currentTimeMillis2 - FrsGoodFragment.this.atC().alc());
                        FrsGoodFragment.this.cIX = -1L;
                    }
                    FrsGoodFragment.this.aKW = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.cIX > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.cIX, FrsGoodFragment.this.atC().alf() - FrsGoodFragment.this.cIX, FrsGoodFragment.this.atC().ald(), FrsGoodFragment.this.atC().ale(), currentTimeMillis3 - FrsGoodFragment.this.atC().alc());
                FrsGoodFragment.this.cIX = -1L;
            }
            FrsGoodFragment.this.aKW = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private final CustomMessageListener UJ = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.dmS != null) {
                FrsGoodFragment.this.dmS.startPullRefresh();
            }
        }
    };
    private final e.b bom = new e.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // com.baidu.tbadk.core.view.e.b
        public void aO(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.gP()) {
                com.baidu.tieba.a.d.MF().hY("page_frs_good");
                FrsGoodFragment.this.fI(true);
                return;
            }
            FrsGoodFragment.this.dmS.ch(false);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.cYt) {
                FrsGoodFragment.this.cYt = true;
                FrsGoodFragment.this.dmS.aqu();
            }
            if (FrsGoodFragment.this.cYu == null) {
                FrsGoodFragment.this.cYu = new com.baidu.tbadk.k.d();
                FrsGoodFragment.this.cYu.fj(1000);
            }
            FrsGoodFragment.this.cYu.GD();
            if (i == 0) {
                v.afy().eu(true);
            }
        }
    };
    private final CustomMessageListener auS = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
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
    private com.baidu.adp.widget.ListView.n cZv = new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view2, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bd)) {
                bd bdVar = (bd) hVar;
                if (bdVar.sy() == null || bdVar.sy().getGroup_id() == 0 || az.aK(FrsGoodFragment.this.getActivity())) {
                    if (bdVar.sr() != 1 || az.aK(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.tg(bdVar.getId())) {
                            readThreadHistory.tf(bdVar.getId());
                            if (FrsGoodFragment.this.dmS != null) {
                                FrsGoodFragment.this.dmS.aqj();
                            }
                        }
                        boolean z = false;
                        final String rW = bdVar.rW();
                        if (rW != null && !rW.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(rW);
                                    xVar.vi().wh().mIsNeedAddCommenParam = false;
                                    xVar.vi().wh().mIsUseCurrentBDUSS = false;
                                    xVar.uL();
                                }
                            }).start();
                        }
                        String tid = bdVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bdVar.rK() == 2 && !tid.startsWith("pb:")) {
                            ax.wf().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bdVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, FrsGoodFragment.this.cYh, "frs_page", 18003, true, false, z);
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
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    private void showLoadingView() {
        this.dmS.fJ(false);
        showLoadingView(this.dmS.arl(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os() {
        this.dmS.fJ(true);
        hideLoadingView(this.dmS.arl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dmS.fJ(false);
        this.dmS.arm().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dmS.Qn();
        this.dmS.getListView().getData().clear();
        this.dmS.aqj();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Fs();
            this.mRefreshView.fa(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.Fq().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.setSubText(getPageContext().getResources().getString(d.k.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.setSubText(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.d(this.dmS.arl(), true);
    }

    private void Qk() {
        this.dmS.fJ(true);
        this.dmS.arm().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Fk()) {
            this.mRefreshView.P(this.dmS.arl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI(boolean z) {
        apB();
        Qk();
        if (!z) {
            Qk();
            showLoadingView();
        }
        this.dmQ.gN(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cIX = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.cIX = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.aKO = this.beginTime - this.cIX;
        super.onCreate(bundle);
        this.dmQ = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dmQ.i(arguments);
            this.dmP = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dmQ.i(bundle);
            this.dmP = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dmQ.i(null);
        }
        this.cYn = getVoiceManager();
        this.cYn.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.UJ);
        registerListener(this.apd);
        registerListener(this.cZd);
        this.dmR = new FrsLoadMoreModel(this, null);
        this.dmR.registerListener();
        this.dmR.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_good_activity, (ViewGroup) null);
        this.dmS = new b(this, inflate, this.dmP);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.gP()) {
            fI(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cYn = getVoiceManager();
        this.cYn.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        atA();
        if (bundle != null) {
            this.cYh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.cYh = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void atA() {
        registerListener(2001118, this.auS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dmS != null) {
            this.dmS.onDestroy();
        }
        v.afy().eu(false);
        super.onDestroy();
        try {
            if (this.cYu != null) {
                this.cYu.onDestroy();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dmQ.onActivityDestroy();
        this.cYn = getVoiceManager();
        this.cYn.onDestory(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cYh);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dmP);
        this.dmQ.onSaveInstanceState(bundle);
        this.cYn = getVoiceManager();
        if (this.cYn != null) {
            this.cYn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bd lW;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dmS.atG().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (lW = this.cXS.lW(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            lW.bR(intent.getIntExtra("good_data", 0));
                            lW.sw();
                            fI(false);
                            return;
                        } else if (intExtra == 0) {
                            this.cXS.al(lW);
                            ArrayList<h> threadList = this.cXS.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new k());
                            }
                            this.dmS.atE();
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
        if (isAdded() && isPrimary() && this.ddw == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dmS != null) {
            this.dmS.aqj();
        }
        this.cYn = getVoiceManager();
        this.cYn.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dmT = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dmS.setOnAdapterItemClickListener(this.cZv);
        this.dmS.setOnScrollListener(this.mScrollListener);
        this.dmS.a(this.bom);
        this.dmS.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.dmT != null) {
                    FrsGoodFragment.this.dmT.d(view2, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ddw != 3 || this.dmS != null) {
            this.ddw = i;
            super.onChangeSkinType(i);
            if (this.dmS != null) {
                this.dmS.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aoL() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aoL();
        }
        return null;
    }

    private void apx() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fx().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.ta(FrsGoodFragment.this.cYh);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apy() {
        apB();
        try {
            if (this.cXS != null) {
                this.dmS.showListView();
                this.cYh = this.cXS.aVq().getName();
                this.forumId = this.cXS.aVq().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.cXS.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cXS.getUserData().getBimg_end_time());
                apx();
                if (!this.dmS.atG().k(bd.ZL)) {
                    this.cXS.bqR();
                }
                ArrayList<h> threadList = this.cXS.getThreadList();
                if (threadList != null) {
                    this.dmS.a(threadList, this.mPn, this.cXS, this.cXS.rf().rb());
                    atB();
                    this.dmS.atE();
                    if (this.cXS.aVF() == 1) {
                        this.dmS.atG().setFromCDN(true);
                    } else {
                        this.dmS.atG().setFromCDN(false);
                    }
                    this.dmS.setListViewSelection(aA(atC().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aA(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cYn = getVoiceManager();
        this.cYn.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        v.afy().eu(false);
        if (this.cXS != null && this.cXS.aVq() != null) {
            com.baidu.tbadk.distribute.a.Do().a(getPageContext().getPageActivity(), "frs", this.cXS.aVq().getId(), 0L);
        }
        this.cYn = getVoiceManager();
        if (this.cYn != null) {
            this.cYn.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(int i) {
        ArrayList<h> threadList = this.cXS.getThreadList();
        if (threadList != null) {
            Iterator<h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar.getId() != null && bdVar.getId().equals(this.ddB)) {
                        a(bdVar, i);
                        this.ddB = null;
                        break;
                    }
                }
            }
            this.dmS.atG().b(threadList, this.cXS);
            this.dmS.atG().notifyDataSetChanged();
        }
    }

    private void a(bd bdVar, int i) {
        if (i == 1) {
            PraiseData rE = bdVar.rE();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (rE == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bdVar.a(praiseData);
                    return;
                }
                bdVar.rE().getUser().add(0, metaData);
                bdVar.rE().setNum(bdVar.rE().getNum() + 1);
                bdVar.rE().setIsLike(i);
            }
        } else if (bdVar.rE() != null) {
            bdVar.rE().setIsLike(i);
            bdVar.rE().setNum(bdVar.rE().getNum() - 1);
            ArrayList<MetaData> user = bdVar.rE().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bdVar.rE().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cYn == null) {
            this.cYn = VoiceManager.instance();
        }
        return this.cYn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView xi() {
        if (this.dmS == null) {
            return null;
        }
        return this.dmS.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void apB() {
        this.cYn = getVoiceManager();
        this.cYn.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xj() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).xj();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.cXS != null && this.dmS != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dmS.aqj();
            }
        }
    }

    private void atB() {
        HashMap<Integer, bd> arL;
        if (this.dmS != null && this.dmS.atG() != null && (arL = this.dmS.atG().arL()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bd> entry : arL.entrySet()) {
                bd value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.Dt().o(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (xi() == null) {
            return null;
        }
        return xi().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.gP()) {
            fI(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l apD() {
        return this.cXS;
    }

    public FrsGoodModelController atC() {
        return this.dmQ;
    }

    public void mk(String str) {
        this.cYh = str;
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
        if (!com.baidu.adp.lib.util.l.hg()) {
            this.dmS.Qn();
        } else if (!this.dmQ.atK()) {
            this.dmS.Qn();
        } else {
            Pz();
            if (!this.dmR.isLoading && !this.dmQ.wW()) {
                if (this.dmR.br(this.cXS.bqf())) {
                    this.dmS.a(this.dmR.atW(), this.mPn, this.cXS, 0);
                    this.dmR.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.cXS.bqf(), this.cYh, this.mPn);
                } else if (this.bXW != 0) {
                    this.dmS.a(this.dmR.atW(), this.mPn, this.cXS, 0);
                    this.mPn++;
                    this.dmQ.kQ(this.mPn);
                    this.dmR.loadingDone = false;
                    this.dmR.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void lA(String str) {
        Pz();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<h> arrayList) {
        ArrayList<h> a;
        Pz();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dmR.a(false, false, false, arrayList, null)) != null) {
            this.cXS.av(a);
            this.dmS.a(a, this.mPn, this.cXS, 0);
        }
    }

    private void Pz() {
        if (this.bXW == 0 && !this.dmR.br(this.cXS.bqf())) {
            if (this.cXS.getThreadList() == null || this.cXS.getThreadList().size() == 0) {
                this.dmS.Qn();
                return;
            } else {
                this.dmS.Qm();
                return;
            }
        }
        this.dmS.Ql();
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aD(getActivity().getApplicationContext())) {
                aj.b(getPageContext());
            } else {
                showToast(d.k.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> aeY() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Do().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void apA() {
        if (this.dmQ != null) {
            this.dmQ.apA();
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
    public NavigationBar Rd() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.cYh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kP(int i) {
        this.mTabId = i;
        if (j.gP()) {
            fI(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aoX() {
        if (this.dmS != null && this.dmS.getListView() != null) {
            this.dmS.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Qi() {
        if (this.dmS != null) {
            aoX();
            this.dmS.startPullRefresh();
        }
    }
}
