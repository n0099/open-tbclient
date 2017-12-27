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
import com.baidu.adp.lib.util.j;
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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.be;
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
import com.baidu.tbadk.core.view.i;
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
    private String dJG;
    private FrsGoodModelController dJI;
    private FrsLoadMoreModel dJJ;
    private com.baidu.tieba.frs.gametab.b dJM;
    private VoiceManager dwG;
    private String dwA = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dJH = false;
    private String forumId = null;
    private l dwm = new l();
    public long dhW = -1;
    public long byf = 0;
    public long byn = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dwM = false;
    private d dwN = null;
    protected c dJK = null;
    private int cCU = -1;
    private int mTabId = 0;
    private int dJL = 3;
    private boolean dJN = false;
    private CustomMessageListener bbX = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof be)) {
                be beVar = (be) customResponsedMessage.getData();
                b.this.dJG = beVar.getId();
                if (!TextUtils.isEmpty(b.this.dJG) && beVar.yM() != null) {
                    b.this.nz(beVar.yM().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dxs = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (b.this.El() != null) {
                        b.this.El().setSelection(0);
                    }
                    if (b.this.dJN) {
                        b.this.fW(false);
                    } else if (b.this.dJK != null) {
                        b.this.dJK.startPullRefresh();
                    }
                }
            }
        }
    };
    public final n dxD = new n() { // from class: com.baidu.tieba.frs.good.b.4
        private long dJR = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void mQ(int i) {
            switch (i) {
                case 1:
                case 2:
                    b.this.dJK.atE();
                    return;
                case 3:
                    b.this.dJK.cN(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<i> a;
            if (aVar == null) {
                this.dJR = 1L;
            } else if (aVar.isSuccess) {
                this.dJR = 0L;
            } else {
                this.dJR = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                b.this.dJJ.resetData();
            }
            b.this.dJK.cN(false);
            if (b.this.awG().awN() != null) {
                b.this.dwm = b.this.awG().awN();
            }
            b.this.cCU = b.this.dwm.yb().xX();
            if (b.this.cCU == 0 && (b.this.dwm.bAm() == null || b.this.dwm.bAm().size() == 0)) {
                if (b.this.dwm.getThreadList() == null || b.this.dwm.getThreadList().size() == 0) {
                    b.this.dJK.akM();
                } else {
                    b.this.dJK.atQ();
                }
            } else {
                b.this.dJK.atP();
            }
            if (i == 4) {
                ArrayList<i> a2 = b.this.dJJ.a(false, false, false, b.this.dwm.getThreadList(), null);
                if (a2 != null) {
                    b.this.dwm.az(a2);
                    b.this.dJK.a(a2, b.this.mPn, b.this.dwm, b.this.cCU);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    b.this.dJK.atE();
                    break;
                case 2:
                    b.this.dJK.atE();
                    break;
            }
            b.this.Vn();
            if (this.dJR != 0) {
                b.this.c(aVar);
            } else {
                if (b.this.dwm != null) {
                    b.this.dwA = b.this.dwm.aYy().getName();
                    b.this.forumId = b.this.dwm.aYy().getId();
                    b.this.dJK.b(b.this.dwm.aYy(), b.this.dwm.getUserData());
                }
                if (b.this.dwm != null) {
                    b.this.dwm.bAX();
                }
                b.this.dJK.c(b.this.dwm);
                if (b.this.dwm == null || b.this.dwm.getThreadList() == null || b.this.dwm.getThreadList().size() != 0 || b.this.awG().getType() != 4) {
                    if (b.this.dwm != null && (a = b.this.dJJ.a(false, false, true, b.this.dwm.getThreadList(), null)) != null && a.size() > 0) {
                        b.this.dwm.az(a);
                    }
                    b.this.ath();
                } else {
                    b.this.showToast(b.this.getPageContext().getString(d.j.no_more_to_load));
                    if (b.this.mPn > 1) {
                        b.h(b.this);
                    }
                    if (b.this.dhW > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - b.this.dhW, b.this.awG().aoT() - b.this.dhW, b.this.awG().aoR(), b.this.awG().aoS(), currentTimeMillis2 - b.this.awG().aoQ());
                        b.this.dhW = -1L;
                    }
                    b.this.byn = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (b.this.dhW > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - b.this.dhW, b.this.awG().aoT() - b.this.dhW, b.this.awG().aoR(), b.this.awG().aoS(), currentTimeMillis3 - b.this.awG().aoQ());
                b.this.dhW = -1L;
            }
            b.this.byn = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
        }
    };
    private final CustomMessageListener aIh = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dJK != null) {
                b.this.dJK.startPullRefresh();
            }
        }
    };
    private final i.b dJO = new i.b() { // from class: com.baidu.tieba.frs.good.b.8
        @Override // com.baidu.tbadk.core.view.i.b
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(b.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.oI()) {
                b.this.fW(true);
            } else {
                b.this.dJK.cN(false);
            }
        }
    };
    private final RecyclerView.OnScrollListener Si = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.b.9
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !b.this.dwM) {
                b.this.dwM = true;
                b.this.dJK.atO();
            }
            if (b.this.dwN == null) {
                b.this.dwN = new com.baidu.tbadk.k.d();
                b.this.dwN.iq(1000);
            }
            b.this.dwN.NH();
            if (i == 0) {
                s.ajC().eB(true);
            }
        }
    };
    private final CustomMessageListener dxK = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.b.10
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
    private com.baidu.adp.widget.ListView.o dxL = new com.baidu.adp.widget.ListView.o() { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Multi-variable search result rejected for r2v22, resolved type: com.baidu.tieba.frs.good.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.o
        public void a(View view, com.baidu.adp.widget.ListView.i iVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && iVar != null && (iVar instanceof be)) {
                be beVar = (be) iVar;
                if (beVar.zI() == null || beVar.zI().getGroup_id() == 0 || ax.be(b.this.getActivity())) {
                    if ((beVar.zB() != 1 && beVar.zB() != 2) || ax.be(b.this.getActivity())) {
                        e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.tn(beVar.getId())) {
                            readThreadHistory.tm(beVar.getId());
                            if (b.this.dJK != null) {
                                b.this.dJK.atE();
                            }
                        }
                        boolean z = false;
                        final String zf = beVar.zf();
                        if (zf != null && !zf.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.b.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(zf);
                                    xVar.Cn().Dk().mIsNeedAddCommenParam = false;
                                    xVar.Cn().Dk().mIsUseCurrentBDUSS = false;
                                    xVar.BQ();
                                }
                            }).start();
                        }
                        String tid = beVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (beVar.yS() == 2 && !tid.startsWith("pb:")) {
                            av.Di().c(b.this.getPageContext(), new String[]{tid, "", null});
                        } else if (beVar.getThreadType() == 33 || (beVar instanceof at)) {
                            TiebaStatic.log(new ak(beVar.getThreadType() == 33 ? "c10245" : "c10180").ab(ImageViewerConfig.FORUM_ID, b.this.forumId));
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(b.this.getPageContext().getPageActivity(), beVar.getTid()).cG("from_frs").eD(18003).wQ()));
                        } else {
                            if (tid.startsWith("pb:")) {
                                beVar.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(b.this.getPageContext().getPageActivity()).createFromThreadCfg(beVar, b.this.dwA, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(beVar.getFid()));
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

    private void Vm() {
        this.dJK.fX(false);
        showLoadingView(this.dJK.awL(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vn() {
        this.dJK.fX(true);
        hideLoadingView(this.dJK.awL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dJK.fX(true);
        this.dJK.awM().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.dJK.akM();
        this.dJK.getListView().getData().clear();
        this.dJK.atE();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Mv();
            this.mRefreshView.ig(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.Mt().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.gE(getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.gE(null);
        }
        this.mRefreshView.onChangeSkinType();
        if (!this.dJN) {
            this.dJK.getListView().addHeaderView(this.mRefreshView.Mt(), 0);
        }
        this.dJN = true;
    }

    private void WQ() {
        this.dJK.fX(true);
        this.dJK.awM().setEnabled(true);
        if (this.mRefreshView != null) {
            this.dJK.getListView().removeHeaderView(this.mRefreshView.Mt());
            this.dJK.atE();
        }
        this.dJN = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(boolean z) {
        atk();
        if (this.dJN) {
            WQ();
        }
        if (!z) {
            WQ();
            Vm();
        }
        this.dJI.mv(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dhW = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.dhW = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.byf = this.beginTime - this.dhW;
        super.onCreate(bundle);
        this.dJI = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dJI.k(arguments);
            this.dJH = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dJI.k(bundle);
            this.dJH = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dJI.k(null);
        }
        this.dwG = getVoiceManager();
        this.dwG.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.aIh);
        registerListener(this.bbX);
        registerListener(this.dxs);
        this.dJJ = new FrsLoadMoreModel(this, null);
        this.dJJ.registerListener();
        this.dJJ.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_good_activity, (ViewGroup) null);
        this.dJK = new c(this, inflate, this.dJH);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.oI()) {
            fW(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dwG = getVoiceManager();
        this.dwG.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        awE();
        if (bundle != null) {
            this.dwA = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dwA = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void awE() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dxK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dJK != null) {
            this.dJK.onDestroy();
        }
        s.ajC().eB(false);
        super.onDestroy();
        try {
            if (this.dwN != null) {
                this.dwN.onDestroy();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dJI.onActivityDestroy();
        this.dwG = getVoiceManager();
        this.dwG.onDestory(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dwA);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dJH);
        this.dJI.onSaveInstanceState(bundle);
        this.dwG = getVoiceManager();
        if (this.dwG != null) {
            this.dwG.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        be sV;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dJK.awK().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (sV = this.dwm.sV(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            sV.eT(intent.getIntExtra("good_data", 0));
                            sV.zF();
                            fW(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dwm.ag(sV);
                            ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dwm.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.dJK.awI();
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
        if (isAdded() && isPrimary() && this.dJL == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.dJK.startPullRefresh();
            return;
        }
        if (this.dJK != null) {
            this.dJK.atE();
        }
        this.dwG = getVoiceManager();
        this.dwG.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dJM = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dJK.setOnAdapterItemClickListener(this.dxL);
        this.dJK.setOnScrollListener(this.Si);
        this.dJK.a(this.dJO);
        this.dJK.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.b.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (b.this.dJM != null) {
                    b.this.dJM.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dJL != 3 || this.dJK != null) {
            this.dJL = i;
            super.onChangeSkinType(i);
            if (this.dJK != null) {
                this.dJK.onChangeSkinType(i);
            }
        }
    }

    private void atg() {
        switch (this.mFlag) {
            case 1:
                h.ns().e(new Runnable() { // from class: com.baidu.tieba.frs.good.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.th(b.this.dwA);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ath() {
        atk();
        try {
            if (this.dwm != null) {
                this.dJK.WZ();
                this.dwA = this.dwm.aYy().getName();
                this.forumId = this.dwm.aYy().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dwm.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dwm.getUserData().getBimg_end_time());
                atg();
                if (!this.dJK.awK().k(be.aNg)) {
                    this.dwm.bAZ();
                }
                ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dwm.getThreadList();
                if (threadList != null) {
                    this.dJK.a(threadList, this.mPn, this.dwm, this.dwm.yb().xX());
                    awF();
                    this.dJK.awI();
                    if (this.dwm.aYO() == 1) {
                        this.dJK.awK().setFromCDN(true);
                    } else {
                        this.dJK.awK().setFromCDN(false);
                    }
                    this.dJK.setListViewSelection(bH(awG().getType(), this.mPn));
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
        this.dwG = getVoiceManager();
        this.dwG.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.ajC().eB(false);
        if (this.dwm != null && this.dwm.aYy() != null) {
            com.baidu.tbadk.distribute.a.Kp().a(getPageContext().getPageActivity(), "frs", this.dwm.aYy().getId(), 0L);
        }
        this.dwG = getVoiceManager();
        if (this.dwG != null) {
            this.dwG.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(int i) {
        ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dwm.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next instanceof be) {
                    be beVar = (be) next;
                    if (beVar.getId() != null && beVar.getId().equals(this.dJG)) {
                        c(beVar, i);
                        this.dJG = null;
                        break;
                    }
                }
            }
            this.dJK.awK().b(threadList, this.dwm);
            this.dJK.awK().notifyDataSetChanged();
        }
    }

    private void c(be beVar, int i) {
        if (i == 1) {
            PraiseData yM = beVar.yM();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (yM == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    beVar.a(praiseData);
                    return;
                }
                beVar.yM().getUser().add(0, metaData);
                beVar.yM().setNum(beVar.yM().getNum() + 1);
                beVar.yM().setIsLike(i);
            }
        } else if (beVar.yM() != null) {
            beVar.yM().setIsLike(i);
            beVar.yM().setNum(beVar.yM().getNum() - 1);
            ArrayList<MetaData> user = beVar.yM().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        beVar.yM().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dwG == null) {
            this.dwG = VoiceManager.instance();
        }
        return this.dwG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView El() {
        if (this.dJK == null) {
            return null;
        }
        return this.dJK.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void atk() {
        this.dwG = getVoiceManager();
        this.dwG.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Em() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).Em();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.dwm != null && this.dJK != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dJK.atE();
            }
        }
    }

    private void awF() {
        HashMap<Integer, be> avg;
        if (this.dJK != null && this.dJK.awK() != null && (avg = this.dJK.awK().avg()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, be> entry : avg.entrySet()) {
                be value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.Ku().p(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (El() == null) {
            return null;
        }
        return El().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.oI()) {
            fW(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l atn() {
        return this.dwm;
    }

    public FrsGoodModelController awG() {
        return this.dJI;
    }

    public void lE(String str) {
        this.dwA = str;
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
        if (!com.baidu.adp.lib.util.l.oZ()) {
            this.dJK.akM();
        } else if (!this.dJI.awP()) {
            this.dJK.akM();
        } else {
            Wv();
            if (!this.dJJ.isLoading && !this.dJI.DY()) {
                if (this.dJJ.bv(this.dwm.bAm())) {
                    this.dJK.a(this.dJJ.awY(), this.mPn, this.dwm, 0);
                    this.dJJ.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.dwm.bAm(), this.dwA, this.mPn);
                } else if (this.cCU != 0) {
                    this.dJK.a(this.dJJ.awY(), this.mPn, this.dwm, 0);
                    this.mPn++;
                    this.dJI.nB(this.mPn);
                    this.dJJ.loadingDone = false;
                    this.dJJ.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void kX(String str) {
        Wv();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.i> a;
        Wv();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dJJ.a(false, false, false, arrayList, null)) != null) {
            this.dwm.az(a);
            this.dJK.a(a, this.mPn, this.dwm, 0);
        }
    }

    private void Wv() {
        if (this.cCU == 0 && !this.dJJ.bv(this.dwm.bAm())) {
            if (this.dwm.getThreadList() == null || this.dwm.getThreadList().size() == 0) {
                this.dJK.akM();
                return;
            } else {
                this.dJK.atQ();
                return;
            }
        }
        this.dJK.atP();
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
    public TbPageContext<?> aiX() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Kp().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.o
    public void atj() {
        if (this.dJI != null) {
            this.dJI.atj();
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
    public NavigationBar atm() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dwA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nA(int i) {
        this.mTabId = i;
        if (j.oI()) {
            fW(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void asH() {
        if (this.dJK != null && this.dJK.getListView() != null) {
            this.dJK.getListView().scrollToPosition(0);
        }
    }
}
