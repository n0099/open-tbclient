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
    private VoiceManager cXj;
    private String dcw;
    private FrsGoodModelController dlM;
    private FrsLoadMoreModel dlN;
    private com.baidu.tieba.frs.gametab.b dlP;
    private String cXd = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dlL = false;
    private String forumId = null;
    private l cWO = new l();
    public long cHR = -1;
    public long aKN = 0;
    public long aKV = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean cXp = false;
    private d cXq = null;
    protected b dlO = null;
    private int bXj = -1;
    private int mTabId = 0;
    private int dcq = 3;
    private CustomMessageListener apd = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                bd bdVar = (bd) customResponsedMessage.getData();
                FrsGoodFragment.this.dcw = bdVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.dcw) && bdVar.rF() != null) {
                    FrsGoodFragment.this.ks(bdVar.rF().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener cXZ = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.xj() != null) {
                        FrsGoodFragment.this.xj().setSelection(0);
                    }
                    if (FrsGoodFragment.this.mRefreshView != null && FrsGoodFragment.this.mRefreshView.Fm()) {
                        FrsGoodFragment.this.fH(false);
                    } else if (FrsGoodFragment.this.dlO != null) {
                        FrsGoodFragment.this.dlO.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n cYk = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        private long dlS = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kd(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsGoodFragment.this.dlO.aqk();
                    return;
                case 3:
                    FrsGoodFragment.this.dlO.ch(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<h> a;
            if (aVar == null) {
                this.dlS = 1L;
            } else if (aVar.isSuccess) {
                this.dlS = 0L;
            } else {
                this.dlS = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.dlN.resetData();
            }
            FrsGoodFragment.this.dlO.ch(false);
            if (FrsGoodFragment.this.atD().atJ() != null) {
                FrsGoodFragment.this.cWO = FrsGoodFragment.this.atD().atJ();
            }
            FrsGoodFragment.this.bXj = FrsGoodFragment.this.cWO.rg().rc();
            if (FrsGoodFragment.this.bXj == 0 && (FrsGoodFragment.this.cWO.bqh() == null || FrsGoodFragment.this.cWO.bqh().size() == 0)) {
                if (FrsGoodFragment.this.cWO.getThreadList() == null || FrsGoodFragment.this.cWO.getThreadList().size() == 0) {
                    FrsGoodFragment.this.dlO.Qq();
                } else {
                    FrsGoodFragment.this.dlO.Qp();
                }
            } else {
                FrsGoodFragment.this.dlO.Qo();
            }
            if (i == 4) {
                ArrayList<h> a2 = FrsGoodFragment.this.dlN.a(false, false, false, FrsGoodFragment.this.cWO.getThreadList(), null);
                if (a2 != null) {
                    FrsGoodFragment.this.cWO.av(a2);
                    FrsGoodFragment.this.dlO.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.cWO, FrsGoodFragment.this.bXj);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.dlO.aqk();
                    break;
                case 2:
                    FrsGoodFragment.this.dlO.aqk();
                    break;
                case 3:
                    if (FrsGoodFragment.this.cWO.bqz()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.Ou();
            if (this.dlS != 0) {
                FrsGoodFragment.this.c(aVar);
            } else {
                if (FrsGoodFragment.this.cWO != null) {
                    FrsGoodFragment.this.cXd = FrsGoodFragment.this.cWO.aVq().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.cWO.aVq().getId();
                    FrsGoodFragment.this.dlO.b(FrsGoodFragment.this.cWO.aVq(), FrsGoodFragment.this.cWO.getUserData());
                }
                if (FrsGoodFragment.this.cWO != null) {
                    FrsGoodFragment.this.cWO.bqR();
                }
                FrsGoodFragment.this.dlO.c(FrsGoodFragment.this.cWO);
                if (FrsGoodFragment.this.cWO == null || FrsGoodFragment.this.cWO.getThreadList() == null || FrsGoodFragment.this.cWO.getThreadList().size() != 0 || FrsGoodFragment.this.atD().getType() != 4) {
                    if (FrsGoodFragment.this.cWO != null && (a = FrsGoodFragment.this.dlN.a(false, false, true, FrsGoodFragment.this.cWO.getThreadList(), null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.cWO.av(a);
                    }
                    FrsGoodFragment.this.apz();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(d.k.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.i(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.cHR > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.cHR, FrsGoodFragment.this.atD().alf() - FrsGoodFragment.this.cHR, FrsGoodFragment.this.atD().ald(), FrsGoodFragment.this.atD().ale(), currentTimeMillis2 - FrsGoodFragment.this.atD().alc());
                        FrsGoodFragment.this.cHR = -1L;
                    }
                    FrsGoodFragment.this.aKV = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.cHR > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.cHR, FrsGoodFragment.this.atD().alf() - FrsGoodFragment.this.cHR, FrsGoodFragment.this.atD().ald(), FrsGoodFragment.this.atD().ale(), currentTimeMillis3 - FrsGoodFragment.this.atD().alc());
                FrsGoodFragment.this.cHR = -1L;
            }
            FrsGoodFragment.this.aKV = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private final CustomMessageListener UN = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.dlO != null) {
                FrsGoodFragment.this.dlO.startPullRefresh();
            }
        }
    };
    private final e.b bnX = new e.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // com.baidu.tbadk.core.view.e.b
        public void aO(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.gP()) {
                com.baidu.tieba.a.d.MH().hX("page_frs_good");
                FrsGoodFragment.this.fH(true);
                return;
            }
            FrsGoodFragment.this.dlO.ch(false);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.cXp) {
                FrsGoodFragment.this.cXp = true;
                FrsGoodFragment.this.dlO.aqv();
            }
            if (FrsGoodFragment.this.cXq == null) {
                FrsGoodFragment.this.cXq = new com.baidu.tbadk.k.d();
                FrsGoodFragment.this.cXq.fi(1000);
            }
            FrsGoodFragment.this.cXq.GF();
            if (i == 0) {
                v.afy().et(true);
            }
        }
    };
    private final CustomMessageListener auR = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
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
    private com.baidu.adp.widget.ListView.n cYr = new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view2, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bd)) {
                bd bdVar = (bd) hVar;
                if (bdVar.sz() == null || bdVar.sz().getGroup_id() == 0 || az.aK(FrsGoodFragment.this.getActivity())) {
                    if (bdVar.ss() != 1 || az.aK(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.td(bdVar.getId())) {
                            readThreadHistory.tc(bdVar.getId());
                            if (FrsGoodFragment.this.dlO != null) {
                                FrsGoodFragment.this.dlO.aqk();
                            }
                        }
                        boolean z = false;
                        final String rX = bdVar.rX();
                        if (rX != null && !rX.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(rX);
                                    xVar.vj().wi().mIsNeedAddCommenParam = false;
                                    xVar.vj().wi().mIsUseCurrentBDUSS = false;
                                    xVar.uM();
                                }
                            }).start();
                        }
                        String tid = bdVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bdVar.rL() == 2 && !tid.startsWith("pb:")) {
                            ax.wg().c(FrsGoodFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bdVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, FrsGoodFragment.this.cXd, "frs_page", 18003, true, false, z);
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
        this.dlO.fI(false);
        showLoadingView(this.dlO.arm(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ou() {
        this.dlO.fI(true);
        hideLoadingView(this.dlO.arm());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dlO.fI(false);
        this.dlO.arn().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dlO.Qq();
        this.dlO.getListView().getData().clear();
        this.dlO.aqk();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Fu();
            this.mRefreshView.eZ(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.Fs().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.setSubText(getPageContext().getResources().getString(d.k.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.setSubText(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.d(this.dlO.arm(), true);
    }

    private void Qn() {
        this.dlO.fI(true);
        this.dlO.arn().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Fm()) {
            this.mRefreshView.P(this.dlO.arm());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fH(boolean z) {
        apC();
        Qn();
        if (!z) {
            Qn();
            showLoadingView();
        }
        this.dlM.gM(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cHR = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.cHR = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.aKN = this.beginTime - this.cHR;
        super.onCreate(bundle);
        this.dlM = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dlM.i(arguments);
            this.dlL = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dlM.i(bundle);
            this.dlL = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dlM.i(null);
        }
        this.cXj = getVoiceManager();
        this.cXj.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.UN);
        registerListener(this.apd);
        registerListener(this.cXZ);
        this.dlN = new FrsLoadMoreModel(this, null);
        this.dlN.registerListener();
        this.dlN.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_good_activity, (ViewGroup) null);
        this.dlO = new b(this, inflate, this.dlL);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.gP()) {
            fH(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cXj = getVoiceManager();
        this.cXj.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        atB();
        if (bundle != null) {
            this.cXd = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.cXd = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void atB() {
        registerListener(2001118, this.auR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dlO != null) {
            this.dlO.onDestroy();
        }
        v.afy().et(false);
        super.onDestroy();
        try {
            if (this.cXq != null) {
                this.cXq.onDestroy();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dlM.onActivityDestroy();
        this.cXj = getVoiceManager();
        this.cXj.onDestory(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cXd);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dlL);
        this.dlM.onSaveInstanceState(bundle);
        this.cXj = getVoiceManager();
        if (this.cXj != null) {
            this.cXj.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bd lT;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dlO.atH().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (lT = this.cWO.lT(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            lT.bQ(intent.getIntExtra("good_data", 0));
                            lT.sx();
                            fH(false);
                            return;
                        } else if (intExtra == 0) {
                            this.cWO.al(lT);
                            ArrayList<h> threadList = this.cWO.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new k());
                            }
                            this.dlO.atF();
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
        if (isAdded() && isPrimary() && this.dcq == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dlO != null) {
            this.dlO.aqk();
        }
        this.cXj = getVoiceManager();
        this.cXj.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dlP = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dlO.setOnAdapterItemClickListener(this.cYr);
        this.dlO.setOnScrollListener(this.mScrollListener);
        this.dlO.a(this.bnX);
        this.dlO.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.dlP != null) {
                    FrsGoodFragment.this.dlP.d(view2, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dcq != 3 || this.dlO != null) {
            this.dcq = i;
            super.onChangeSkinType(i);
            if (this.dlO != null) {
                this.dlO.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aoM() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aoM();
        }
        return null;
    }

    private void apy() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fx().d(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sX(FrsGoodFragment.this.cXd);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apz() {
        apC();
        try {
            if (this.cWO != null) {
                this.dlO.showListView();
                this.cXd = this.cWO.aVq().getName();
                this.forumId = this.cWO.aVq().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.cWO.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cWO.getUserData().getBimg_end_time());
                apy();
                if (!this.dlO.atH().k(bd.ZL)) {
                    this.cWO.bqT();
                }
                ArrayList<h> threadList = this.cWO.getThreadList();
                if (threadList != null) {
                    this.dlO.a(threadList, this.mPn, this.cWO, this.cWO.rg().rc());
                    atC();
                    this.dlO.atF();
                    if (this.cWO.aVF() == 1) {
                        this.dlO.atH().setFromCDN(true);
                    } else {
                        this.dlO.atH().setFromCDN(false);
                    }
                    this.dlO.setListViewSelection(aB(atD().getType(), this.mPn));
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
        this.cXj = getVoiceManager();
        this.cXj.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        v.afy().et(false);
        if (this.cWO != null && this.cWO.aVq() != null) {
            com.baidu.tbadk.distribute.a.Dq().a(getPageContext().getPageActivity(), "frs", this.cWO.aVq().getId(), 0L);
        }
        this.cXj = getVoiceManager();
        if (this.cXj != null) {
            this.cXj.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ks(int i) {
        ArrayList<h> threadList = this.cWO.getThreadList();
        if (threadList != null) {
            Iterator<h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar.getId() != null && bdVar.getId().equals(this.dcw)) {
                        a(bdVar, i);
                        this.dcw = null;
                        break;
                    }
                }
            }
            this.dlO.atH().b(threadList, this.cWO);
            this.dlO.atH().notifyDataSetChanged();
        }
    }

    private void a(bd bdVar, int i) {
        if (i == 1) {
            PraiseData rF = bdVar.rF();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (rF == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bdVar.a(praiseData);
                    return;
                }
                bdVar.rF().getUser().add(0, metaData);
                bdVar.rF().setNum(bdVar.rF().getNum() + 1);
                bdVar.rF().setIsLike(i);
            }
        } else if (bdVar.rF() != null) {
            bdVar.rF().setIsLike(i);
            bdVar.rF().setNum(bdVar.rF().getNum() - 1);
            ArrayList<MetaData> user = bdVar.rF().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bdVar.rF().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cXj == null) {
            this.cXj = VoiceManager.instance();
        }
        return this.cXj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView xj() {
        if (this.dlO == null) {
            return null;
        }
        return this.dlO.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void apC() {
        this.cXj = getVoiceManager();
        this.cXj.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xk() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).xk();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.cWO != null && this.dlO != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dlO.aqk();
            }
        }
    }

    private void atC() {
        HashMap<Integer, bd> arM;
        if (this.dlO != null && this.dlO.atH() != null && (arM = this.dlO.atH().arM()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bd> entry : arM.entrySet()) {
                bd value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.Dv().o(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (xj() == null) {
            return null;
        }
        return xj().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.gP()) {
            fH(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l apE() {
        return this.cWO;
    }

    public FrsGoodModelController atD() {
        return this.dlM;
    }

    public void mh(String str) {
        this.cXd = str;
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
            this.dlO.Qq();
        } else if (!this.dlM.atL()) {
            this.dlO.Qq();
        } else {
            PC();
            if (!this.dlN.isLoading && !this.dlM.wX()) {
                if (this.dlN.bo(this.cWO.bqh())) {
                    this.dlO.a(this.dlN.atX(), this.mPn, this.cWO, 0);
                    this.dlN.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.cWO.bqh(), this.cXd, this.mPn);
                } else if (this.bXj != 0) {
                    this.dlO.a(this.dlN.atX(), this.mPn, this.cWO, 0);
                    this.mPn++;
                    this.dlM.kR(this.mPn);
                    this.dlN.loadingDone = false;
                    this.dlN.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void lx(String str) {
        PC();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<h> arrayList) {
        ArrayList<h> a;
        PC();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dlN.a(false, false, false, arrayList, null)) != null) {
            this.cWO.av(a);
            this.dlO.a(a, this.mPn, this.cWO, 0);
        }
    }

    private void PC() {
        if (this.bXj == 0 && !this.dlN.bo(this.cWO.bqh())) {
            if (this.cWO.getThreadList() == null || this.cWO.getThreadList().size() == 0) {
                this.dlO.Qq();
                return;
            } else {
                this.dlO.Qp();
                return;
            }
        }
        this.dlO.Qo();
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
        com.baidu.tbadk.distribute.a.Dq().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void apB() {
        if (this.dlM != null) {
            this.dlM.apB();
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
    public NavigationBar Rg() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.cXd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kQ(int i) {
        this.mTabId = i;
        if (j.gP()) {
            fH(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aoY() {
        if (this.dlO != null && this.dlO.getListView() != null) {
            this.dlO.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Ql() {
        if (this.dlO != null) {
            aoY();
            this.dlO.startPullRefresh();
        }
    }
}
