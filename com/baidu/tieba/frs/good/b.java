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
import com.baidu.adp.widget.ListView.o;
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
import com.baidu.tieba.frs.m;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends BaseFragment implements BdListView.e, a.InterfaceC0056a, UserIconBox.b, VoiceManager.c, al, am, com.baidu.tieba.frs.loadmore.a, n {
    private static boolean isNeedRefreshOnResume = false;
    private VoiceManager dEk;
    private com.baidu.tieba.frs.gametab.b dRB;
    private String dRv;
    private FrsGoodModelController dRx;
    private FrsLoadMoreModel dRy;
    private String dEe = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dRw = false;
    private String forumId = null;
    private l dDP = new l();
    public long dpx = -1;
    public long bAo = 0;
    public long bAw = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dEq = false;
    private d dEr = null;
    protected c dRz = null;
    private int cGY = -1;
    private int mTabId = 0;
    private int dRA = 3;
    private CustomMessageListener bdJ = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                bd bdVar = (bd) customResponsedMessage.getData();
                b.this.dRv = bdVar.getId();
                if (!TextUtils.isEmpty(b.this.dRv) && bdVar.zc() != null) {
                    b.this.nB(bdVar.zc().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dFa = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (b.this.Ey() != null) {
                        b.this.Ey().setSelection(0);
                    }
                    if (b.this.mRefreshView != null && b.this.mRefreshView.MI()) {
                        b.this.gl(false);
                    } else if (b.this.dRz != null) {
                        b.this.dRz.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dFl = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.b.4
        private long dRE = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void mQ(int i) {
            switch (i) {
                case 1:
                case 2:
                    b.this.dRz.avM();
                    return;
                case 3:
                    b.this.dRz.cQ(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<i> a;
            if (aVar == null) {
                this.dRE = 1L;
            } else if (aVar.isSuccess) {
                this.dRE = 0L;
            } else {
                this.dRE = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                b.this.dRy.resetData();
            }
            b.this.dRz.cQ(false);
            if (b.this.ayM().ayU() != null) {
                b.this.dDP = b.this.ayM().ayU();
            }
            b.this.cGY = b.this.dDP.yA().yw();
            if (b.this.cGY == 0 && (b.this.dDP.buY() == null || b.this.dDP.buY().size() == 0)) {
                if (b.this.dDP.getThreadList() == null || b.this.dDP.getThreadList().size() == 0) {
                    b.this.dRz.XP();
                } else {
                    b.this.dRz.XO();
                }
            } else {
                b.this.dRz.XN();
            }
            if (i == 4) {
                ArrayList<i> a2 = b.this.dRy.a(false, false, false, b.this.dDP.getThreadList(), null);
                if (a2 != null) {
                    b.this.dDP.au(a2);
                    b.this.dRz.a(a2, b.this.mPn, b.this.dDP, b.this.cGY);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    b.this.dRz.avM();
                    break;
                case 2:
                    b.this.dRz.avM();
                    break;
            }
            b.this.VU();
            if (this.dRE != 0) {
                b.this.c(aVar);
            } else {
                if (b.this.dDP != null) {
                    b.this.dEe = b.this.dDP.bar().getName();
                    b.this.forumId = b.this.dDP.bar().getId();
                    b.this.dRz.b(b.this.dDP.bar(), b.this.dDP.getUserData());
                }
                if (b.this.dDP != null) {
                    b.this.dDP.bvJ();
                }
                b.this.dRz.c(b.this.dDP);
                if (b.this.dDP == null || b.this.dDP.getThreadList() == null || b.this.dDP.getThreadList().size() != 0 || b.this.ayM().getType() != 4) {
                    if (b.this.dDP != null && (a = b.this.dRy.a(false, false, true, b.this.dDP.getThreadList(), null)) != null && a.size() > 0) {
                        b.this.dDP.au(a);
                    }
                    b.this.ave();
                } else {
                    b.this.showToast(b.this.getPageContext().getString(d.j.no_more_to_load));
                    if (b.this.mPn > 1) {
                        b.i(b.this);
                    }
                    if (b.this.dpx > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - b.this.dpx, b.this.ayM().aqQ() - b.this.dpx, b.this.ayM().aqO(), b.this.ayM().aqP(), currentTimeMillis2 - b.this.ayM().aqN());
                        b.this.dpx = -1L;
                    }
                    b.this.bAw = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (b.this.dpx > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - b.this.dpx, b.this.ayM().aqQ() - b.this.dpx, b.this.ayM().aqO(), b.this.ayM().aqP(), currentTimeMillis3 - b.this.ayM().aqN());
                b.this.dpx = -1L;
            }
            b.this.bAw = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
        }
    };
    private final CustomMessageListener aJr = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dRz != null) {
                b.this.dRz.startPullRefresh();
            }
        }
    };
    private final j.b cdV = new j.b() { // from class: com.baidu.tieba.frs.good.b.8
        @Override // com.baidu.tbadk.core.view.j.b
        public void bw(boolean z) {
            TiebaStatic.eventStat(b.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.oJ()) {
                b.this.dRz.ayQ().setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
                b.this.gl(true);
                return;
            }
            b.this.dRz.cQ(false);
        }
    };
    private final RecyclerView.OnScrollListener Sb = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.b.9
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !b.this.dEq) {
                b.this.dEq = true;
                b.this.dRz.avX();
            }
            if (b.this.dEr == null) {
                b.this.dEr = new com.baidu.tbadk.k.d();
                b.this.dEr.ij(1000);
            }
            b.this.dEr.Oc();
            if (i == 0) {
                r.als().eO(true);
            }
        }
    };
    private final CustomMessageListener bjk = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.b.10
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
    private o dFs = new o() { // from class: com.baidu.tieba.frs.good.b.2
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
                            if (b.this.dRz != null) {
                                b.this.dRz.avM();
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
                                    xVar.Cy().Dv().mIsNeedAddCommenParam = false;
                                    xVar.Cy().Dv().mIsUseCurrentBDUSS = false;
                                    xVar.Cb();
                                }
                            }).start();
                        }
                        String tid = bdVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bdVar.zi() == 2 && !tid.startsWith("pb:")) {
                            aw.Dt().c(b.this.getPageContext(), new String[]{tid, "", null});
                        } else if (bdVar.getThreadType() == 33 || (bdVar instanceof as)) {
                            TiebaStatic.log(new ak(bdVar.getThreadType() == 33 ? "c10245" : "c10180").ab(ImageViewerConfig.FORUM_ID, b.this.forumId));
                            b.this.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(b.this.getPageContext().getPageActivity(), bdVar.getTid()).cR("from_frs").eC(18003).xD()));
                        } else {
                            if (tid.startsWith("pb:")) {
                                bdVar.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(b.this.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, b.this.dEe, "frs_page", 18003, true, false, z);
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

    private void VT() {
        this.dRz.gm(false);
        showLoadingView(this.dRz.ayR(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VU() {
        this.dRz.gm(true);
        hideLoadingView(this.dRz.ayR());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dRz.gm(false);
        this.dRz.ayS().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dRz.XP();
        this.dRz.getListView().getData().clear();
        this.dRz.avM();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.MQ();
            this.mRefreshView.ia(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.MO().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.gW(getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.gW(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.j(this.dRz.ayR(), true);
    }

    private void XM() {
        this.dRz.gm(true);
        this.dRz.ayS().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.MI()) {
            this.mRefreshView.bk(this.dRz.ayR());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl(boolean z) {
        avh();
        XM();
        if (!z) {
            XM();
            VT();
        }
        this.dRx.jI(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dpx = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.dpx = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.bAo = this.beginTime - this.dpx;
        super.onCreate(bundle);
        this.dRx = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dRx.l(arguments);
            this.dRw = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dRx.l(bundle);
            this.dRw = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dRx.l(null);
        }
        this.dEk = getVoiceManager();
        this.dEk.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.aJr);
        registerListener(this.bdJ);
        registerListener(this.dFa);
        this.dRy = new FrsLoadMoreModel(this, null);
        this.dRy.registerListener();
        this.dRy.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_good_activity, (ViewGroup) null);
        this.dRz = new c(this, inflate, this.dRw);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (com.baidu.adp.lib.util.j.oJ()) {
            gl(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dEk = getVoiceManager();
        this.dEk.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        ayK();
        if (bundle != null) {
            this.dEe = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dEe = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void ayK() {
        registerListener(2001118, this.bjk);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dRz != null) {
            this.dRz.onDestroy();
        }
        r.als().eO(false);
        super.onDestroy();
        try {
            if (this.dEr != null) {
                this.dEr.onDestroy();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dRx.onActivityDestroy();
        this.dEk = getVoiceManager();
        this.dEk.onDestory(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dEe);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dRw);
        this.dRx.onSaveInstanceState(bundle);
        this.dEk = getVoiceManager();
        if (this.dEk != null) {
            this.dEk.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bd sE;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dRz.ayQ().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (sE = this.dDP.sE(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            sE.eS(intent.getIntExtra("good_data", 0));
                            sE.zW();
                            gl(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dDP.aj(sE);
                            ArrayList<i> threadList = this.dDP.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.dRz.ayO();
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
        if (isAdded() && isPrimary() && this.dRA == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.dRz.startPullRefresh();
            return;
        }
        if (this.dRz != null) {
            this.dRz.avM();
        }
        this.dEk = getVoiceManager();
        this.dEk.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dRB = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dRz.setOnAdapterItemClickListener(this.dFs);
        this.dRz.setOnScrollListener(this.Sb);
        this.dRz.a(this.cdV);
        this.dRz.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.b.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (b.this.dRB != null) {
                    b.this.dRB.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dRA != 3 || this.dRz != null) {
            this.dRA = i;
            super.onChangeSkinType(i);
            if (this.dRz != null) {
                this.dRz.onChangeSkinType(i);
            }
        }
    }

    private void avd() {
        switch (this.mFlag) {
            case 1:
                h.nt().e(new Runnable() { // from class: com.baidu.tieba.frs.good.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sQ(b.this.dEe);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ave() {
        avh();
        try {
            if (this.dDP != null) {
                this.dRz.aij();
                this.dEe = this.dDP.bar().getName();
                this.forumId = this.dDP.bar().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dDP.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dDP.getUserData().getBimg_end_time());
                avd();
                if (!this.dRz.ayQ().k(bd.aOn)) {
                    this.dDP.bvL();
                }
                ArrayList<i> threadList = this.dDP.getThreadList();
                if (threadList != null) {
                    this.dRz.a(threadList, this.mPn, this.dDP, this.dDP.yA().yw());
                    ayL();
                    this.dRz.ayO();
                    if (this.dDP.baG() == 1) {
                        this.dRz.ayQ().setFromCDN(true);
                    } else {
                        this.dRz.ayQ().setFromCDN(false);
                    }
                    this.dRz.setListViewSelection(bF(ayM().getType(), this.mPn));
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
        this.dEk = getVoiceManager();
        this.dEk.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        r.als().eO(false);
        if (this.dDP != null && this.dDP.bar() != null) {
            com.baidu.tbadk.distribute.a.KL().a(getPageContext().getPageActivity(), "frs", this.dDP.bar().getId(), 0L);
        }
        this.dEk = getVoiceManager();
        if (this.dEk != null) {
            this.dEk.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nB(int i) {
        ArrayList<i> threadList = this.dDP.getThreadList();
        if (threadList != null) {
            Iterator<i> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar.getId() != null && bdVar.getId().equals(this.dRv)) {
                        c(bdVar, i);
                        this.dRv = null;
                        break;
                    }
                }
            }
            this.dRz.ayQ().b(threadList, this.dDP);
            this.dRz.ayQ().notifyDataSetChanged();
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
        if (this.dEk == null) {
            this.dEk = VoiceManager.instance();
        }
        return this.dEk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Ey() {
        if (this.dRz == null) {
            return null;
        }
        return this.dRz.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void avh() {
        this.dEk = getVoiceManager();
        this.dEk.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Ez() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).Ez();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.dDP != null && this.dRz != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dRz.avM();
            }
        }
    }

    private void ayL() {
        HashMap<Integer, bd> axm;
        if (this.dRz != null && this.dRz.ayQ() != null && (axm = this.dRz.ayQ().axm()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bd> entry : axm.entrySet()) {
                bd value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.KQ().p(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (Ey() == null) {
            return null;
        }
        return Ey().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.oJ()) {
            gl(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l avk() {
        return this.dDP;
    }

    public FrsGoodModelController ayM() {
        return this.dRx;
    }

    public void mf(String str) {
        this.dEe = str;
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
            this.dRz.XP();
        } else if (!this.dRx.ayW()) {
            this.dRz.XP();
        } else {
            Xb();
            if (!this.dRy.isLoading && !this.dRx.Ek()) {
                if (this.dRy.bv(this.dDP.buY())) {
                    this.dRz.a(this.dRy.azh(), this.mPn, this.dDP, 0);
                    this.dRy.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.dDP.buY(), this.dEe, this.mPn);
                } else if (this.cGY != 0) {
                    this.dRz.a(this.dRy.azh(), this.mPn, this.dDP, 0);
                    this.mPn++;
                    this.dRx.nD(this.mPn);
                    this.dRy.loadingDone = false;
                    this.dRy.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void lu(String str) {
        Xb();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<i> arrayList) {
        ArrayList<i> a;
        Xb();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dRy.a(false, false, false, arrayList, null)) != null) {
            this.dDP.au(a);
            this.dRz.a(a, this.mPn, this.dDP, 0);
        }
    }

    private void Xb() {
        if (this.cGY == 0 && !this.dRy.bv(this.dDP.buY())) {
            if (this.dDP.getThreadList() == null || this.dDP.getThreadList().size() == 0) {
                this.dRz.XP();
                return;
            } else {
                this.dRz.XO();
                return;
            }
        }
        this.dRz.XN();
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
    public TbPageContext<?> akN() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.KL().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void avg() {
        if (this.dRx != null) {
            this.dRx.avg();
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
    public NavigationBar avj() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dEe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nC(int i) {
        this.mTabId = i;
        if (com.baidu.adp.lib.util.j.oJ()) {
            gl(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void auE() {
        if (this.dRz != null && this.dRz.getListView() != null) {
            this.dRz.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void XK() {
        if (this.dRz != null) {
            auE();
            this.dRz.startPullRefresh();
        }
    }
}
