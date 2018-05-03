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
    private VoiceManager cXg;
    private String dcs;
    private FrsGoodModelController dlJ;
    private FrsLoadMoreModel dlK;
    private com.baidu.tieba.frs.gametab.b dlM;
    private String cXa = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dlI = false;
    private String forumId = null;
    private l cWL = new l();
    public long cHO = -1;
    public long aKN = 0;
    public long aKV = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean cXm = false;
    private d cXn = null;
    protected b dlL = null;
    private int bXg = -1;
    private int mTabId = 0;
    private int dcn = 3;
    private CustomMessageListener apd = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                bd bdVar = (bd) customResponsedMessage.getData();
                FrsGoodFragment.this.dcs = bdVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.dcs) && bdVar.rF() != null) {
                    FrsGoodFragment.this.ks(bdVar.rF().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener cXW = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
                    } else if (FrsGoodFragment.this.dlL != null) {
                        FrsGoodFragment.this.dlL.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n cYh = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        private long dlP = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kd(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsGoodFragment.this.dlL.aqk();
                    return;
                case 3:
                    FrsGoodFragment.this.dlL.ch(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<h> a;
            if (aVar == null) {
                this.dlP = 1L;
            } else if (aVar.isSuccess) {
                this.dlP = 0L;
            } else {
                this.dlP = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.dlK.resetData();
            }
            FrsGoodFragment.this.dlL.ch(false);
            if (FrsGoodFragment.this.atD().atJ() != null) {
                FrsGoodFragment.this.cWL = FrsGoodFragment.this.atD().atJ();
            }
            FrsGoodFragment.this.bXg = FrsGoodFragment.this.cWL.rg().rc();
            if (FrsGoodFragment.this.bXg == 0 && (FrsGoodFragment.this.cWL.bqh() == null || FrsGoodFragment.this.cWL.bqh().size() == 0)) {
                if (FrsGoodFragment.this.cWL.getThreadList() == null || FrsGoodFragment.this.cWL.getThreadList().size() == 0) {
                    FrsGoodFragment.this.dlL.Qq();
                } else {
                    FrsGoodFragment.this.dlL.Qp();
                }
            } else {
                FrsGoodFragment.this.dlL.Qo();
            }
            if (i == 4) {
                ArrayList<h> a2 = FrsGoodFragment.this.dlK.a(false, false, false, FrsGoodFragment.this.cWL.getThreadList(), null);
                if (a2 != null) {
                    FrsGoodFragment.this.cWL.av(a2);
                    FrsGoodFragment.this.dlL.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.cWL, FrsGoodFragment.this.bXg);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.dlL.aqk();
                    break;
                case 2:
                    FrsGoodFragment.this.dlL.aqk();
                    break;
                case 3:
                    if (FrsGoodFragment.this.cWL.bqz()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.Ou();
            if (this.dlP != 0) {
                FrsGoodFragment.this.c(aVar);
            } else {
                if (FrsGoodFragment.this.cWL != null) {
                    FrsGoodFragment.this.cXa = FrsGoodFragment.this.cWL.aVq().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.cWL.aVq().getId();
                    FrsGoodFragment.this.dlL.b(FrsGoodFragment.this.cWL.aVq(), FrsGoodFragment.this.cWL.getUserData());
                }
                if (FrsGoodFragment.this.cWL != null) {
                    FrsGoodFragment.this.cWL.bqR();
                }
                FrsGoodFragment.this.dlL.c(FrsGoodFragment.this.cWL);
                if (FrsGoodFragment.this.cWL == null || FrsGoodFragment.this.cWL.getThreadList() == null || FrsGoodFragment.this.cWL.getThreadList().size() != 0 || FrsGoodFragment.this.atD().getType() != 4) {
                    if (FrsGoodFragment.this.cWL != null && (a = FrsGoodFragment.this.dlK.a(false, false, true, FrsGoodFragment.this.cWL.getThreadList(), null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.cWL.av(a);
                    }
                    FrsGoodFragment.this.apz();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(d.k.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.i(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.cHO > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - FrsGoodFragment.this.cHO, FrsGoodFragment.this.atD().alf() - FrsGoodFragment.this.cHO, FrsGoodFragment.this.atD().ald(), FrsGoodFragment.this.atD().ale(), currentTimeMillis2 - FrsGoodFragment.this.atD().alc());
                        FrsGoodFragment.this.cHO = -1L;
                    }
                    FrsGoodFragment.this.aKV = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.cHO > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - FrsGoodFragment.this.cHO, FrsGoodFragment.this.atD().alf() - FrsGoodFragment.this.cHO, FrsGoodFragment.this.atD().ald(), FrsGoodFragment.this.atD().ale(), currentTimeMillis3 - FrsGoodFragment.this.atD().alc());
                FrsGoodFragment.this.cHO = -1L;
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
            if (customResponsedMessage != null && FrsGoodFragment.this.dlL != null) {
                FrsGoodFragment.this.dlL.startPullRefresh();
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
            FrsGoodFragment.this.dlL.ch(false);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.cXm) {
                FrsGoodFragment.this.cXm = true;
                FrsGoodFragment.this.dlL.aqv();
            }
            if (FrsGoodFragment.this.cXn == null) {
                FrsGoodFragment.this.cXn = new com.baidu.tbadk.k.d();
                FrsGoodFragment.this.cXn.fi(1000);
            }
            FrsGoodFragment.this.cXn.GF();
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
    private com.baidu.adp.widget.ListView.n cYo = new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
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
                            if (FrsGoodFragment.this.dlL != null) {
                                FrsGoodFragment.this.dlL.aqk();
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
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, FrsGoodFragment.this.cXa, "frs_page", 18003, true, false, z);
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
        this.dlL.fI(false);
        showLoadingView(this.dlL.arm(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ou() {
        this.dlL.fI(true);
        hideLoadingView(this.dlL.arm());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dlL.fI(false);
        this.dlL.arn().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dlL.Qq();
        this.dlL.getListView().getData().clear();
        this.dlL.aqk();
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
        this.mRefreshView.d(this.dlL.arm(), true);
    }

    private void Qn() {
        this.dlL.fI(true);
        this.dlL.arn().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Fm()) {
            this.mRefreshView.P(this.dlL.arm());
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
        this.dlJ.gM(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cHO = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.cHO = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.aKN = this.beginTime - this.cHO;
        super.onCreate(bundle);
        this.dlJ = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dlJ.i(arguments);
            this.dlI = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dlJ.i(bundle);
            this.dlI = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dlJ.i(null);
        }
        this.cXg = getVoiceManager();
        this.cXg.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.UN);
        registerListener(this.apd);
        registerListener(this.cXW);
        this.dlK = new FrsLoadMoreModel(this, null);
        this.dlK.registerListener();
        this.dlK.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_good_activity, (ViewGroup) null);
        this.dlL = new b(this, inflate, this.dlI);
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
        this.cXg = getVoiceManager();
        this.cXg.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        atB();
        if (bundle != null) {
            this.cXa = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.cXa = arguments.getString("name");
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
        if (this.dlL != null) {
            this.dlL.onDestroy();
        }
        v.afy().et(false);
        super.onDestroy();
        try {
            if (this.cXn != null) {
                this.cXn.onDestroy();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dlJ.onActivityDestroy();
        this.cXg = getVoiceManager();
        this.cXg.onDestory(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cXa);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dlI);
        this.dlJ.onSaveInstanceState(bundle);
        this.cXg = getVoiceManager();
        if (this.cXg != null) {
            this.cXg.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bd lT;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dlL.atH().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (lT = this.cWL.lT(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            lT.bQ(intent.getIntExtra("good_data", 0));
                            lT.sx();
                            fH(false);
                            return;
                        } else if (intExtra == 0) {
                            this.cWL.al(lT);
                            ArrayList<h> threadList = this.cWL.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new k());
                            }
                            this.dlL.atF();
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
        if (isAdded() && isPrimary() && this.dcn == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dlL != null) {
            this.dlL.aqk();
        }
        this.cXg = getVoiceManager();
        this.cXg.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dlM = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dlL.setOnAdapterItemClickListener(this.cYo);
        this.dlL.setOnScrollListener(this.mScrollListener);
        this.dlL.a(this.bnX);
        this.dlL.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.dlM != null) {
                    FrsGoodFragment.this.dlM.d(view2, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dcn != 3 || this.dlL != null) {
            this.dcn = i;
            super.onChangeSkinType(i);
            if (this.dlL != null) {
                this.dlL.onChangeSkinType(i);
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
                        com.baidu.tieba.tbadkCore.util.a.sX(FrsGoodFragment.this.cXa);
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
            if (this.cWL != null) {
                this.dlL.showListView();
                this.cXa = this.cWL.aVq().getName();
                this.forumId = this.cWL.aVq().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.cWL.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cWL.getUserData().getBimg_end_time());
                apy();
                if (!this.dlL.atH().k(bd.ZL)) {
                    this.cWL.bqT();
                }
                ArrayList<h> threadList = this.cWL.getThreadList();
                if (threadList != null) {
                    this.dlL.a(threadList, this.mPn, this.cWL, this.cWL.rg().rc());
                    atC();
                    this.dlL.atF();
                    if (this.cWL.aVF() == 1) {
                        this.dlL.atH().setFromCDN(true);
                    } else {
                        this.dlL.atH().setFromCDN(false);
                    }
                    this.dlL.setListViewSelection(aA(atD().getType(), this.mPn));
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
        this.cXg = getVoiceManager();
        this.cXg.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        v.afy().et(false);
        if (this.cWL != null && this.cWL.aVq() != null) {
            com.baidu.tbadk.distribute.a.Dq().a(getPageContext().getPageActivity(), "frs", this.cWL.aVq().getId(), 0L);
        }
        this.cXg = getVoiceManager();
        if (this.cXg != null) {
            this.cXg.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ks(int i) {
        ArrayList<h> threadList = this.cWL.getThreadList();
        if (threadList != null) {
            Iterator<h> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar.getId() != null && bdVar.getId().equals(this.dcs)) {
                        a(bdVar, i);
                        this.dcs = null;
                        break;
                    }
                }
            }
            this.dlL.atH().b(threadList, this.cWL);
            this.dlL.atH().notifyDataSetChanged();
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
        if (this.cXg == null) {
            this.cXg = VoiceManager.instance();
        }
        return this.cXg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView xj() {
        if (this.dlL == null) {
            return null;
        }
        return this.dlL.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void apC() {
        this.cXg = getVoiceManager();
        this.cXg.stopPlay();
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
        if (this.cWL != null && this.dlL != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dlL.aqk();
            }
        }
    }

    private void atC() {
        HashMap<Integer, bd> arM;
        if (this.dlL != null && this.dlL.atH() != null && (arM = this.dlL.atH().arM()) != null) {
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
        return this.cWL;
    }

    public FrsGoodModelController atD() {
        return this.dlJ;
    }

    public void mh(String str) {
        this.cXa = str;
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
            this.dlL.Qq();
        } else if (!this.dlJ.atL()) {
            this.dlL.Qq();
        } else {
            PC();
            if (!this.dlK.isLoading && !this.dlJ.wX()) {
                if (this.dlK.bo(this.cWL.bqh())) {
                    this.dlL.a(this.dlK.atX(), this.mPn, this.cWL, 0);
                    this.dlK.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.cWL.bqh(), this.cXa, this.mPn);
                } else if (this.bXg != 0) {
                    this.dlL.a(this.dlK.atX(), this.mPn, this.cWL, 0);
                    this.mPn++;
                    this.dlJ.kR(this.mPn);
                    this.dlK.loadingDone = false;
                    this.dlK.loadIndex = 0;
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.dlK.a(false, false, false, arrayList, null)) != null) {
            this.cWL.av(a);
            this.dlL.a(a, this.mPn, this.cWL, 0);
        }
    }

    private void PC() {
        if (this.bXg == 0 && !this.dlK.bo(this.cWL.bqh())) {
            if (this.cWL.getThreadList() == null || this.cWL.getThreadList().size() == 0) {
                this.dlL.Qq();
                return;
            } else {
                this.dlL.Qp();
                return;
            }
        }
        this.dlL.Qo();
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
        if (this.dlJ != null) {
            this.dlJ.apB();
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
        return this.cXa;
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
        if (this.dlL != null && this.dlL.getListView() != null) {
            this.dlL.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Ql() {
        if (this.dlL != null) {
            aoY();
            this.dlL.startPullRefresh();
        }
    }
}
