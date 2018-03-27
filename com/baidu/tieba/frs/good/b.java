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
import com.baidu.adp.widget.ListView.l;
import com.baidu.d.a.a;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
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
import com.baidu.tieba.card.r;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.j;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.o;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends BaseFragment implements BdListView.e, a.InterfaceC0056a, UserIconBox.b, VoiceManager.c, al, am, com.baidu.tieba.frs.loadmore.a, n {
    private static boolean isNeedRefreshOnResume = false;
    private VoiceManager dEn;
    private String dRA;
    private FrsGoodModelController dRC;
    private FrsLoadMoreModel dRD;
    private com.baidu.tieba.frs.gametab.b dRG;
    private String dEh = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dRB = false;
    private String forumId = null;
    private m dDS = new m();
    public long dpA = -1;
    public long bAr = 0;
    public long bAz = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dEt = false;
    private d dEu = null;
    protected c dRE = null;
    private int cHb = -1;
    private int mTabId = 0;
    private int dRF = 3;
    private CustomMessageListener bdM = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                bd bdVar = (bd) customResponsedMessage.getData();
                b.this.dRA = bdVar.getId();
                if (!TextUtils.isEmpty(b.this.dRA) && bdVar.zc() != null) {
                    b.this.nB(bdVar.zc().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dFd = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (b.this.Ez() != null) {
                        b.this.Ez().setSelection(0);
                    }
                    if (b.this.mRefreshView != null && b.this.mRefreshView.MJ()) {
                        b.this.gm(false);
                    } else if (b.this.dRE != null) {
                        b.this.dRE.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final o dFp = new o() { // from class: com.baidu.tieba.frs.good.b.4
        private long dRJ = 1;

        @Override // com.baidu.tieba.tbadkCore.o
        public void mQ(int i) {
            switch (i) {
                case 1:
                case 2:
                    b.this.dRE.avO();
                    return;
                case 3:
                    b.this.dRE.cQ(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.o
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<i> a;
            if (aVar == null) {
                this.dRJ = 1L;
            } else if (aVar.isSuccess) {
                this.dRJ = 0L;
            } else {
                this.dRJ = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                b.this.dRD.resetData();
            }
            b.this.dRE.cQ(false);
            if (b.this.ayO().ayW() != null) {
                b.this.dDS = b.this.ayO().ayW();
            }
            b.this.cHb = b.this.dDS.yA().yw();
            if (b.this.cHb == 0 && (b.this.dDS.bvb() == null || b.this.dDS.bvb().size() == 0)) {
                if (b.this.dDS.getThreadList() == null || b.this.dDS.getThreadList().size() == 0) {
                    b.this.dRE.XQ();
                } else {
                    b.this.dRE.XP();
                }
            } else {
                b.this.dRE.XO();
            }
            if (i == 4) {
                ArrayList<i> a2 = b.this.dRD.a(false, false, false, b.this.dDS.getThreadList(), null);
                if (a2 != null) {
                    b.this.dDS.au(a2);
                    b.this.dRE.a(a2, b.this.mPn, b.this.dDS, b.this.cHb);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    b.this.dRE.avO();
                    break;
                case 2:
                    b.this.dRE.avO();
                    break;
            }
            b.this.VV();
            if (this.dRJ != 0) {
                b.this.c(aVar);
            } else {
                if (b.this.dDS != null) {
                    b.this.dEh = b.this.dDS.bas().getName();
                    b.this.forumId = b.this.dDS.bas().getId();
                    b.this.dRE.b(b.this.dDS.bas(), b.this.dDS.getUserData());
                }
                if (b.this.dDS != null) {
                    b.this.dDS.bvO();
                }
                b.this.dRE.c(b.this.dDS);
                if (b.this.dDS == null || b.this.dDS.getThreadList() == null || b.this.dDS.getThreadList().size() != 0 || b.this.ayO().getType() != 4) {
                    if (b.this.dDS != null && (a = b.this.dRD.a(false, false, true, b.this.dDS.getThreadList(), null)) != null && a.size() > 0) {
                        b.this.dDS.au(a);
                    }
                    b.this.avf();
                } else {
                    b.this.showToast(b.this.getPageContext().getString(d.j.no_more_to_load));
                    if (b.this.mPn > 1) {
                        b.i(b.this);
                    }
                    if (b.this.dpA > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - b.this.dpA, b.this.ayO().aqR() - b.this.dpA, b.this.ayO().aqP(), b.this.ayO().aqQ(), currentTimeMillis2 - b.this.ayO().aqO());
                        b.this.dpA = -1L;
                    }
                    b.this.bAz = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (b.this.dpA > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - b.this.dpA, b.this.ayO().aqR() - b.this.dpA, b.this.ayO().aqP(), b.this.ayO().aqQ(), currentTimeMillis3 - b.this.ayO().aqO());
                b.this.dpA = -1L;
            }
            b.this.bAz = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.o
        public void b(j jVar) {
        }
    };
    private final CustomMessageListener aJs = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dRE != null) {
                b.this.dRE.startPullRefresh();
            }
        }
    };
    private final j.b cdY = new j.b() { // from class: com.baidu.tieba.frs.good.b.8
        @Override // com.baidu.tbadk.core.view.j.b
        public void bw(boolean z) {
            TiebaStatic.eventStat(b.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.oJ()) {
                b.this.dRE.ayS().setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
                b.this.gm(true);
                return;
            }
            b.this.dRE.cQ(false);
        }
    };
    private final RecyclerView.OnScrollListener Sb = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.b.9
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !b.this.dEt) {
                b.this.dEt = true;
                b.this.dRE.avZ();
            }
            if (b.this.dEu == null) {
                b.this.dEu = new com.baidu.tbadk.k.d();
                b.this.dEu.ij(1000);
            }
            b.this.dEu.Od();
            if (i == 0) {
                r.alt().eO(true);
            }
        }
    };
    private final CustomMessageListener bjn = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.b.10
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                b.this.e(customResponsedMessage);
            }
        }
    };
    private com.baidu.adp.widget.ListView.o dFw = new com.baidu.adp.widget.ListView.o() { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Multi-variable search result rejected for r2v22, resolved type: com.baidu.tieba.frs.good.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.o
        public void a(View view, i iVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && iVar != null && (iVar instanceof bd)) {
                bd bdVar = (bd) iVar;
                if (bdVar.zY() == null || bdVar.zY().getGroup_id() == 0 || ay.ba(b.this.getActivity())) {
                    if (bdVar.zR() != 1 || ay.ba(b.this.getActivity())) {
                        e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.sW(bdVar.getId())) {
                            readThreadHistory.sV(bdVar.getId());
                            if (b.this.dRE != null) {
                                b.this.dRE.avO();
                            }
                        }
                        boolean z = false;
                        final String zv = bdVar.zv();
                        if (zv != null && !zv.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.b.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(zv);
                                    xVar.Cz().Dw().mIsNeedAddCommenParam = false;
                                    xVar.Cz().Dw().mIsUseCurrentBDUSS = false;
                                    xVar.Cc();
                                }
                            }).start();
                        }
                        String tid = bdVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bdVar.zi() == 2 && !tid.startsWith("pb:")) {
                            aw.Du().c(b.this.getPageContext(), new String[]{tid, "", null});
                        } else if (bdVar.getThreadType() == 33 || (bdVar instanceof as)) {
                            TiebaStatic.log(new ak(bdVar.getThreadType() == 33 ? "c10245" : "c10180").ab(ImageViewerConfig.FORUM_ID, b.this.forumId));
                            b.this.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(b.this.getPageContext().getPageActivity(), bdVar.getTid()).cR("from_frs").eC(18003).xD()));
                        } else {
                            if (tid.startsWith("pb:")) {
                                bdVar.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(b.this.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, b.this.dEh, "frs_page", 18003, true, false, z);
                            createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
                            createFromThreadCfg.setStartFrom(3);
                            b.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                        }
                    }
                }
            }
        }
    };

    static /* synthetic */ int i(b bVar) {
        int i = bVar.mPn;
        bVar.mPn = i - 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    private void VU() {
        this.dRE.gn(false);
        showLoadingView(this.dRE.ayT(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VV() {
        this.dRE.gn(true);
        hideLoadingView(this.dRE.ayT());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dRE.gn(false);
        this.dRE.ayU().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dRE.XQ();
        this.dRE.getListView().getData().clear();
        this.dRE.avO();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.MR();
            this.mRefreshView.ia(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.MP().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.gW(getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.gW(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.j(this.dRE.ayT(), true);
    }

    private void XN() {
        this.dRE.gn(true);
        this.dRE.ayU().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.MJ()) {
            this.mRefreshView.bk(this.dRE.ayT());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gm(boolean z) {
        avi();
        XN();
        if (!z) {
            XN();
            VU();
        }
        this.dRC.jI(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dpA = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.dpA = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.bAr = this.beginTime - this.dpA;
        super.onCreate(bundle);
        this.dRC = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dRC.l(arguments);
            this.dRB = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dRC.l(bundle);
            this.dRB = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dRC.l(null);
        }
        this.dEn = getVoiceManager();
        this.dEn.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.aJs);
        registerListener(this.bdM);
        registerListener(this.dFd);
        this.dRD = new FrsLoadMoreModel(this, null);
        this.dRD.registerListener();
        this.dRD.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_good_activity, (ViewGroup) null);
        this.dRE = new c(this, inflate, this.dRB);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (com.baidu.adp.lib.util.j.oJ()) {
            gm(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dEn = getVoiceManager();
        this.dEn.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        ayM();
        if (bundle != null) {
            this.dEh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dEh = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void ayM() {
        registerListener(2001118, this.bjn);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dRE != null) {
            this.dRE.onDestroy();
        }
        r.alt().eO(false);
        super.onDestroy();
        try {
            if (this.dEu != null) {
                this.dEu.onDestroy();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dRC.onActivityDestroy();
        this.dEn = getVoiceManager();
        this.dEn.onDestory(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dEh);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dRB);
        this.dRC.onSaveInstanceState(bundle);
        this.dEn = getVoiceManager();
        if (this.dEn != null) {
            this.dEn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bd sE;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dRE.ayS().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (sE = this.dDS.sE(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            sE.eS(intent.getIntExtra("good_data", 0));
                            sE.zW();
                            gm(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dDS.aj(sE);
                            ArrayList<i> threadList = this.dDS.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.m());
                            }
                            this.dRE.ayQ();
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
        if (isAdded() && isPrimary() && this.dRF == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.dRE.startPullRefresh();
            return;
        }
        if (this.dRE != null) {
            this.dRE.avO();
        }
        this.dEn = getVoiceManager();
        this.dEn.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dRG = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dRE.setOnAdapterItemClickListener(this.dFw);
        this.dRE.setOnScrollListener(this.Sb);
        this.dRE.a(this.cdY);
        this.dRE.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.b.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (b.this.dRG != null) {
                    b.this.dRG.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dRF != 3 || this.dRE != null) {
            this.dRF = i;
            super.onChangeSkinType(i);
            if (this.dRE != null) {
                this.dRE.onChangeSkinType(i);
            }
        }
    }

    private void ave() {
        switch (this.mFlag) {
            case 1:
                h.nt().e(new Runnable() { // from class: com.baidu.tieba.frs.good.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sQ(b.this.dEh);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avf() {
        avi();
        try {
            if (this.dDS != null) {
                this.dRE.aik();
                this.dEh = this.dDS.bas().getName();
                this.forumId = this.dDS.bas().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dDS.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dDS.getUserData().getBimg_end_time());
                ave();
                if (!this.dRE.ayS().k(bd.aOo)) {
                    this.dDS.bvQ();
                }
                ArrayList<i> threadList = this.dDS.getThreadList();
                if (threadList != null) {
                    this.dRE.a(threadList, this.mPn, this.dDS, this.dDS.yA().yw());
                    ayN();
                    this.dRE.ayQ();
                    if (this.dDS.baH() == 1) {
                        this.dRE.ayS().setFromCDN(true);
                    } else {
                        this.dRE.ayS().setFromCDN(false);
                    }
                    this.dRE.setListViewSelection(bF(ayO().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int bF(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dEn = getVoiceManager();
        this.dEn.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        r.alt().eO(false);
        if (this.dDS != null && this.dDS.bas() != null) {
            com.baidu.tbadk.distribute.a.KM().a(getPageContext().getPageActivity(), "frs", this.dDS.bas().getId(), 0L);
        }
        this.dEn = getVoiceManager();
        if (this.dEn != null) {
            this.dEn.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nB(int i) {
        ArrayList<i> threadList = this.dDS.getThreadList();
        if (threadList != null) {
            Iterator<i> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar.getId() != null && bdVar.getId().equals(this.dRA)) {
                        c(bdVar, i);
                        this.dRA = null;
                        break;
                    }
                }
            }
            this.dRE.ayS().b(threadList, this.dDS);
            this.dRE.ayS().notifyDataSetChanged();
        }
    }

    private void c(bd bdVar, int i) {
        if (i == 1) {
            PraiseData zc = bdVar.zc();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (zc == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bdVar.a(praiseData);
                    return;
                }
                bdVar.zc().getUser().add(0, metaData);
                bdVar.zc().setNum(bdVar.zc().getNum() + 1);
                bdVar.zc().setIsLike(i);
            }
        } else if (bdVar.zc() != null) {
            bdVar.zc().setIsLike(i);
            bdVar.zc().setNum(bdVar.zc().getNum() - 1);
            ArrayList<MetaData> user = bdVar.zc().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bdVar.zc().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dEn == null) {
            this.dEn = VoiceManager.instance();
        }
        return this.dEn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Ez() {
        if (this.dRE == null) {
            return null;
        }
        return this.dRE.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void avi() {
        this.dEn = getVoiceManager();
        this.dEn.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> EA() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).EA();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.dDS != null && this.dRE != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dRE.avO();
            }
        }
    }

    private void ayN() {
        HashMap<Integer, bd> axo;
        if (this.dRE != null && this.dRE.ayS() != null && (axo = this.dRE.ayS().axo()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bd> entry : axo.entrySet()) {
                bd value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.KR().p(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public l onGetPreLoadListView() {
        if (Ez() == null) {
            return null;
        }
        return Ez().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.oJ()) {
            gm(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public m avl() {
        return this.dDS;
    }

    public FrsGoodModelController ayO() {
        return this.dRC;
    }

    public void mf(String str) {
        this.dEh = str;
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
            this.dRE.XQ();
        } else if (!this.dRC.ayY()) {
            this.dRE.XQ();
        } else {
            Xc();
            if (!this.dRD.isLoading && !this.dRC.El()) {
                if (this.dRD.bv(this.dDS.bvb())) {
                    this.dRE.a(this.dRD.azj(), this.mPn, this.dDS, 0);
                    this.dRD.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.dDS.bvb(), this.dEh, this.mPn);
                } else if (this.cHb != 0) {
                    this.dRE.a(this.dRD.azj(), this.mPn, this.dDS, 0);
                    this.mPn++;
                    this.dRC.nD(this.mPn);
                    this.dRD.loadingDone = false;
                    this.dRD.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void lu(String str) {
        Xc();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<i> arrayList) {
        ArrayList<i> a;
        Xc();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dRD.a(false, false, false, arrayList, null)) != null) {
            this.dDS.au(a);
            this.dRE.a(a, this.mPn, this.dDS, 0);
        }
    }

    private void Xc() {
        if (this.cHb == 0 && !this.dRD.bv(this.dDS.bvb())) {
            if (this.dDS.getThreadList() == null || this.dDS.getThreadList().size() == 0) {
                this.dRE.XQ();
                return;
            } else {
                this.dRE.XP();
                return;
            }
        }
        this.dRE.XO();
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aT(getActivity().getApplicationContext())) {
                ai.b(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> akO() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.KM().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void avh() {
        if (this.dRC != null) {
            this.dRC.avh();
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

    @Override // com.baidu.tieba.frs.am
    public NavigationBar avk() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dEh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nC(int i) {
        this.mTabId = i;
        if (com.baidu.adp.lib.util.j.oJ()) {
            gm(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void auF() {
        if (this.dRE != null && this.dRE.getListView() != null) {
            this.dRE.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void XL() {
        if (this.dRE != null) {
            auF();
            this.dRE.startPullRefresh();
        }
    }
}
