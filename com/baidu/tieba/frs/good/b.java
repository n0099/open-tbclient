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
import com.baidu.adp.lib.g.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.b.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.k.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.s;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends BaseFragment implements BdListView.e, a.InterfaceC0036a, UserIconBox.b, VoiceManager.c, al, am, com.baidu.tieba.frs.loadmore.a, o {
    private static boolean isNeedRefreshOnResume = false;
    private VoiceManager dBC;
    private String dOD;
    private FrsGoodModelController dOF;
    private FrsLoadMoreModel dOG;
    private com.baidu.tieba.frs.gametab.b dOJ;
    private String dBw = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dOE = false;
    private String forumId = null;
    private l dBi = new l();
    public long dmS = -1;
    public long byx = 0;
    public long byF = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dBI = false;
    private d dBJ = null;
    protected c dOH = null;
    private int cDr = -1;
    private int mTabId = 0;
    private int dOI = 3;
    private boolean dOK = false;
    private CustomMessageListener bcf = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                bd bdVar = (bd) customResponsedMessage.getData();
                b.this.dOD = bdVar.getId();
                if (!TextUtils.isEmpty(b.this.dOD) && bdVar.yI() != null) {
                    b.this.nC(bdVar.yI().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dCo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (b.this.Ee() != null) {
                        b.this.Ee().setSelection(0);
                    }
                    if (b.this.dOK) {
                        b.this.gd(false);
                    } else if (b.this.dOH != null) {
                        b.this.dOH.startPullRefresh();
                    }
                }
            }
        }
    };
    public final n dCz = new n() { // from class: com.baidu.tieba.frs.good.b.4
        private long dOO = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void mT(int i) {
            switch (i) {
                case 1:
                case 2:
                    b.this.dOH.auM();
                    return;
                case 3:
                    b.this.dOH.cM(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<i> a;
            if (aVar == null) {
                this.dOO = 1L;
            } else if (aVar.isSuccess) {
                this.dOO = 0L;
            } else {
                this.dOO = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                b.this.dOG.resetData();
            }
            b.this.dOH.cM(false);
            if (b.this.axO().axV() != null) {
                b.this.dBi = b.this.axO().axV();
            }
            b.this.cDr = b.this.dBi.xZ().xV();
            if (b.this.cDr == 0 && (b.this.dBi.btK() == null || b.this.dBi.btK().size() == 0)) {
                if (b.this.dBi.getThreadList() == null || b.this.dBi.getThreadList().size() == 0) {
                    b.this.dOH.alU();
                } else {
                    b.this.dOH.auY();
                }
            } else {
                b.this.dOH.auX();
            }
            if (i == 4) {
                ArrayList<i> a2 = b.this.dOG.a(false, false, false, b.this.dBi.getThreadList(), null);
                if (a2 != null) {
                    b.this.dBi.at(a2);
                    b.this.dOH.a(a2, b.this.mPn, b.this.dBi, b.this.cDr);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    b.this.dOH.auM();
                    break;
                case 2:
                    b.this.dOH.auM();
                    break;
            }
            b.this.Vd();
            if (this.dOO != 0) {
                b.this.c(aVar);
            } else {
                if (b.this.dBi != null) {
                    b.this.dBw = b.this.dBi.aYJ().getName();
                    b.this.forumId = b.this.dBi.aYJ().getId();
                    b.this.dOH.b(b.this.dBi.aYJ(), b.this.dBi.getUserData());
                }
                if (b.this.dBi != null) {
                    b.this.dBi.buv();
                }
                b.this.dOH.c(b.this.dBi);
                if (b.this.dBi == null || b.this.dBi.getThreadList() == null || b.this.dBi.getThreadList().size() != 0 || b.this.axO().getType() != 4) {
                    if (b.this.dBi != null && (a = b.this.dOG.a(false, false, true, b.this.dBi.getThreadList(), null)) != null && a.size() > 0) {
                        b.this.dBi.at(a);
                    }
                    b.this.aup();
                } else {
                    b.this.showToast(b.this.getPageContext().getString(d.j.no_more_to_load));
                    if (b.this.mPn > 1) {
                        b.h(b.this);
                    }
                    if (b.this.dmS > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - b.this.dmS, b.this.axO().aqb() - b.this.dmS, b.this.axO().apZ(), b.this.axO().aqa(), currentTimeMillis2 - b.this.axO().apY());
                        b.this.dmS = -1L;
                    }
                    b.this.byF = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (b.this.dmS > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - b.this.dmS, b.this.axO().aqb() - b.this.dmS, b.this.axO().apZ(), b.this.axO().aqa(), currentTimeMillis3 - b.this.axO().apY());
                b.this.dmS = -1L;
            }
            b.this.byF = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
        }
    };
    private final CustomMessageListener aIi = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dOH != null) {
                b.this.dOH.startPullRefresh();
            }
        }
    };
    private final j.b dOL = new j.b() { // from class: com.baidu.tieba.frs.good.b.8
        @Override // com.baidu.tbadk.core.view.j.b
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(b.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.oJ()) {
                b.this.gd(true);
            } else {
                b.this.dOH.cM(false);
            }
        }
    };
    private final RecyclerView.OnScrollListener Si = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.b.9
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !b.this.dBI) {
                b.this.dBI = true;
                b.this.dOH.auW();
            }
            if (b.this.dBJ == null) {
                b.this.dBJ = new com.baidu.tbadk.k.d();
                b.this.dBJ.im(1000);
            }
            b.this.dBJ.Nx();
            if (i == 0) {
                s.akK().eI(true);
            }
        }
    };
    private final CustomMessageListener dCG = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.b.10
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                b.this.d(customResponsedMessage);
            }
        }
    };
    private com.baidu.adp.widget.ListView.o dCH = new com.baidu.adp.widget.ListView.o() { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Multi-variable search result rejected for r2v22, resolved type: com.baidu.tieba.frs.good.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.o
        public void a(View view, i iVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && iVar != null && (iVar instanceof bd)) {
                bd bdVar = (bd) iVar;
                if (bdVar.zE() == null || bdVar.zE().getGroup_id() == 0 || ax.bb(b.this.getActivity())) {
                    if ((bdVar.zx() != 1 && bdVar.zx() != 2) || ax.bb(b.this.getActivity())) {
                        e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.sP(bdVar.getId())) {
                            readThreadHistory.sO(bdVar.getId());
                            if (b.this.dOH != null) {
                                b.this.dOH.auM();
                            }
                        }
                        boolean z = false;
                        final String zb = bdVar.zb();
                        if (zb != null && !zb.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.b.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(zb);
                                    xVar.Cg().Dc().mIsNeedAddCommenParam = false;
                                    xVar.Cg().Dc().mIsUseCurrentBDUSS = false;
                                    xVar.BJ();
                                }
                            }).start();
                        }
                        String tid = bdVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bdVar.yO() == 2 && !tid.startsWith("pb:")) {
                            av.Da().c(b.this.getPageContext(), new String[]{tid, "", null});
                        } else if (bdVar.getThreadType() == 33 || (bdVar instanceof as)) {
                            TiebaStatic.log(new ak(bdVar.getThreadType() == 33 ? "c10245" : "c10180").aa(ImageViewerConfig.FORUM_ID, b.this.forumId));
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(b.this.getPageContext().getPageActivity(), bdVar.getTid()).cG("from_frs").eC(18003).wQ()));
                        } else {
                            if (tid.startsWith("pb:")) {
                                bdVar.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(b.this.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, b.this.dBw, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        }
                    }
                }
            }
        }
    };

    static /* synthetic */ int h(b bVar) {
        int i = bVar.mPn;
        bVar.mPn = i - 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    private void Vc() {
        this.dOH.ge(false);
        showLoadingView(this.dOH.axT(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vd() {
        this.dOH.ge(true);
        hideLoadingView(this.dOH.axT());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dOH.ge(true);
        this.dOH.axU().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.dOH.alU();
        this.dOH.getListView().getData().clear();
        this.dOH.auM();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Ml();
            this.mRefreshView.ic(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.Mj().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.gN(getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.gN(null);
        }
        this.mRefreshView.onChangeSkinType();
        if (!this.dOK) {
            this.dOH.getListView().addHeaderView(this.mRefreshView.Mj(), 0);
        }
        this.dOK = true;
    }

    private void WG() {
        this.dOH.ge(true);
        this.dOH.axU().setEnabled(true);
        if (this.mRefreshView != null) {
            this.dOH.getListView().removeHeaderView(this.mRefreshView.Mj());
            this.dOH.auM();
        }
        this.dOK = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd(boolean z) {
        aus();
        if (this.dOK) {
            WG();
        }
        if (!z) {
            WG();
            Vc();
        }
        this.dOF.my(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dmS = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.dmS = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.byx = this.beginTime - this.dmS;
        super.onCreate(bundle);
        this.dOF = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dOF.k(arguments);
            this.dOE = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dOF.k(bundle);
            this.dOE = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dOF.k(null);
        }
        this.dBC = getVoiceManager();
        this.dBC.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.aIi);
        registerListener(this.bcf);
        registerListener(this.dCo);
        this.dOG = new FrsLoadMoreModel(this, null);
        this.dOG.registerListener();
        this.dOG.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_good_activity, (ViewGroup) null);
        this.dOH = new c(this, inflate, this.dOE);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (com.baidu.adp.lib.util.j.oJ()) {
            gd(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dBC = getVoiceManager();
        this.dBC.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        axM();
        if (bundle != null) {
            this.dBw = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dBw = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void axM() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dCG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dOH != null) {
            this.dOH.onDestroy();
        }
        s.akK().eI(false);
        super.onDestroy();
        try {
            if (this.dBJ != null) {
                this.dBJ.onDestroy();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dOF.onActivityDestroy();
        this.dBC = getVoiceManager();
        this.dBC.onDestory(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dBw);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dOE);
        this.dOF.onSaveInstanceState(bundle);
        this.dBC = getVoiceManager();
        if (this.dBC != null) {
            this.dBC.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bd sx;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dOH.axS().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (sx = this.dBi.sx(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            sx.eS(intent.getIntExtra("good_data", 0));
                            sx.zC();
                            gd(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dBi.ag(sx);
                            ArrayList<i> threadList = this.dBi.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.dOH.axQ();
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
        if (isAdded() && isPrimary() && this.dOI == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.dOH.startPullRefresh();
            return;
        }
        if (this.dOH != null) {
            this.dOH.auM();
        }
        this.dBC = getVoiceManager();
        this.dBC.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dOJ = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dOH.setOnAdapterItemClickListener(this.dCH);
        this.dOH.setOnScrollListener(this.Si);
        this.dOH.a(this.dOL);
        this.dOH.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.b.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (b.this.dOJ != null) {
                    b.this.dOJ.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dOI != 3 || this.dOH != null) {
            this.dOI = i;
            super.onChangeSkinType(i);
            if (this.dOH != null) {
                this.dOH.onChangeSkinType(i);
            }
        }
    }

    private void auo() {
        switch (this.mFlag) {
            case 1:
                h.nt().e(new Runnable() { // from class: com.baidu.tieba.frs.good.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sJ(b.this.dBw);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aup() {
        aus();
        try {
            if (this.dBi != null) {
                this.dOH.WP();
                this.dBw = this.dBi.aYJ().getName();
                this.forumId = this.dBi.aYJ().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dBi.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dBi.getUserData().getBimg_end_time());
                auo();
                if (!this.dOH.axS().k(bd.aNf)) {
                    this.dBi.bux();
                }
                ArrayList<i> threadList = this.dBi.getThreadList();
                if (threadList != null) {
                    this.dOH.a(threadList, this.mPn, this.dBi, this.dBi.xZ().xV());
                    axN();
                    this.dOH.axQ();
                    if (this.dBi.aYY() == 1) {
                        this.dOH.axS().setFromCDN(true);
                    } else {
                        this.dOH.axS().setFromCDN(false);
                    }
                    this.dOH.setListViewSelection(bH(axO().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int bH(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dBC = getVoiceManager();
        this.dBC.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.akK().eI(false);
        if (this.dBi != null && this.dBi.aYJ() != null) {
            com.baidu.tbadk.distribute.a.Kg().a(getPageContext().getPageActivity(), "frs", this.dBi.aYJ().getId(), 0L);
        }
        this.dBC = getVoiceManager();
        if (this.dBC != null) {
            this.dBC.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nC(int i) {
        ArrayList<i> threadList = this.dBi.getThreadList();
        if (threadList != null) {
            Iterator<i> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar.getId() != null && bdVar.getId().equals(this.dOD)) {
                        c(bdVar, i);
                        this.dOD = null;
                        break;
                    }
                }
            }
            this.dOH.axS().b(threadList, this.dBi);
            this.dOH.axS().notifyDataSetChanged();
        }
    }

    private void c(bd bdVar, int i) {
        if (i == 1) {
            PraiseData yI = bdVar.yI();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (yI == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bdVar.a(praiseData);
                    return;
                }
                bdVar.yI().getUser().add(0, metaData);
                bdVar.yI().setNum(bdVar.yI().getNum() + 1);
                bdVar.yI().setIsLike(i);
            }
        } else if (bdVar.yI() != null) {
            bdVar.yI().setIsLike(i);
            bdVar.yI().setNum(bdVar.yI().getNum() - 1);
            ArrayList<MetaData> user = bdVar.yI().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bdVar.yI().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dBC == null) {
            this.dBC = VoiceManager.instance();
        }
        return this.dBC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Ee() {
        if (this.dOH == null) {
            return null;
        }
        return this.dOH.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aus() {
        this.dBC = getVoiceManager();
        this.dBC.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Ef() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).Ef();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.dBi != null && this.dOH != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dOH.auM();
            }
        }
    }

    private void axN() {
        HashMap<Integer, bd> awo;
        if (this.dOH != null && this.dOH.axS() != null && (awo = this.dOH.axS().awo()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bd> entry : awo.entrySet()) {
                bd value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.Kl().p(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (Ee() == null) {
            return null;
        }
        return Ee().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.oJ()) {
            gd(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l auv() {
        return this.dBi;
    }

    public FrsGoodModelController axO() {
        return this.dOF;
    }

    public void lU(String str) {
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
        if (!com.baidu.adp.lib.util.l.pa()) {
            this.dOH.alU();
        } else if (!this.dOF.axX()) {
            this.dOH.alU();
        } else {
            Wl();
            if (!this.dOG.isLoading && !this.dOF.DR()) {
                if (this.dOG.bt(this.dBi.btK())) {
                    this.dOH.a(this.dOG.ayg(), this.mPn, this.dBi, 0);
                    this.dOG.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.dBi.btK(), this.dBw, this.mPn);
                } else if (this.cDr != 0) {
                    this.dOH.a(this.dOG.ayg(), this.mPn, this.dBi, 0);
                    this.mPn++;
                    this.dOF.nE(this.mPn);
                    this.dOG.loadingDone = false;
                    this.dOG.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ln(String str) {
        Wl();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<i> arrayList) {
        ArrayList<i> a;
        Wl();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dOG.a(false, false, false, arrayList, null)) != null) {
            this.dBi.at(a);
            this.dOH.a(a, this.mPn, this.dBi, 0);
        }
    }

    private void Wl() {
        if (this.cDr == 0 && !this.dOG.bt(this.dBi.btK())) {
            if (this.dBi.getThreadList() == null || this.dBi.getThreadList().size() == 0) {
                this.dOH.alU();
                return;
            } else {
                this.dOH.auY();
                return;
            }
        }
        this.dOH.auX();
    }

    @Override // android.support.v4.app.Fragment, com.baidu.b.a.a.InterfaceC0036a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aU(getActivity().getApplicationContext())) {
                ai.c(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> akf() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Kg().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.o
    public void aur() {
        if (this.dOF != null) {
            this.dOF.aur();
        }
    }

    @Override // com.baidu.tieba.recapp.o
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.o
    public int getPageNum() {
        return this.mPn;
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar auu() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dBw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nD(int i) {
        this.mTabId = i;
        if (com.baidu.adp.lib.util.j.oJ()) {
            gd(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void atP() {
        if (this.dOH != null && this.dOH.getListView() != null) {
            this.dOH.getListView().scrollToPosition(0);
        }
    }
}
