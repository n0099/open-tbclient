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
    private VoiceManager dEw;
    private String dRH;
    private FrsGoodModelController dRJ;
    private FrsLoadMoreModel dRK;
    private com.baidu.tieba.frs.gametab.b dRN;
    private String dEq = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dRI = false;
    private String forumId = null;
    private l dEb = new l();
    public long dpJ = -1;
    public long bAB = 0;
    public long bAJ = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dEC = false;
    private d dED = null;
    protected c dRL = null;
    private int cHk = -1;
    private int mTabId = 0;
    private int dRM = 3;
    private CustomMessageListener bdV = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.good.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                bd bdVar = (bd) customResponsedMessage.getData();
                b.this.dRH = bdVar.getId();
                if (!TextUtils.isEmpty(b.this.dRH) && bdVar.zc() != null) {
                    b.this.nB(bdVar.zc().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dFm = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.good.b.3
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
                        b.this.gl(false);
                    } else if (b.this.dRL != null) {
                        b.this.dRL.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dFx = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.good.b.4
        private long dRQ = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void mQ(int i) {
            switch (i) {
                case 1:
                case 2:
                    b.this.dRL.avN();
                    return;
                case 3:
                    b.this.dRL.cQ(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<i> a;
            if (aVar == null) {
                this.dRQ = 1L;
            } else if (aVar.isSuccess) {
                this.dRQ = 0L;
            } else {
                this.dRQ = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                b.this.dRK.resetData();
            }
            b.this.dRL.cQ(false);
            if (b.this.ayN().ayV() != null) {
                b.this.dEb = b.this.ayN().ayV();
            }
            b.this.cHk = b.this.dEb.yA().yw();
            if (b.this.cHk == 0 && (b.this.dEb.buZ() == null || b.this.dEb.buZ().size() == 0)) {
                if (b.this.dEb.getThreadList() == null || b.this.dEb.getThreadList().size() == 0) {
                    b.this.dRL.XQ();
                } else {
                    b.this.dRL.XP();
                }
            } else {
                b.this.dRL.XO();
            }
            if (i == 4) {
                ArrayList<i> a2 = b.this.dRK.a(false, false, false, b.this.dEb.getThreadList(), null);
                if (a2 != null) {
                    b.this.dEb.au(a2);
                    b.this.dRL.a(a2, b.this.mPn, b.this.dEb, b.this.cHk);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    b.this.dRL.avN();
                    break;
                case 2:
                    b.this.dRL.avN();
                    break;
            }
            b.this.VV();
            if (this.dRQ != 0) {
                b.this.c(aVar);
            } else {
                if (b.this.dEb != null) {
                    b.this.dEq = b.this.dEb.bas().getName();
                    b.this.forumId = b.this.dEb.bas().getId();
                    b.this.dRL.b(b.this.dEb.bas(), b.this.dEb.getUserData());
                }
                if (b.this.dEb != null) {
                    b.this.dEb.bvK();
                }
                b.this.dRL.c(b.this.dEb);
                if (b.this.dEb == null || b.this.dEb.getThreadList() == null || b.this.dEb.getThreadList().size() != 0 || b.this.ayN().getType() != 4) {
                    if (b.this.dEb != null && (a = b.this.dRK.a(false, false, true, b.this.dEb.getThreadList(), null)) != null && a.size() > 0) {
                        b.this.dEb.au(a);
                    }
                    b.this.avf();
                } else {
                    b.this.showToast(b.this.getPageContext().getString(d.j.no_more_to_load));
                    if (b.this.mPn > 1) {
                        b.i(b.this);
                    }
                    if (b.this.dpJ > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - b.this.dpJ, b.this.ayN().aqR() - b.this.dpJ, b.this.ayN().aqP(), b.this.ayN().aqQ(), currentTimeMillis2 - b.this.ayN().aqO());
                        b.this.dpJ = -1L;
                    }
                    b.this.bAJ = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (b.this.dpJ > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - b.this.dpJ, b.this.ayN().aqR() - b.this.dpJ, b.this.ayN().aqP(), b.this.ayN().aqQ(), currentTimeMillis3 - b.this.ayN().aqO());
                b.this.dpJ = -1L;
            }
            b.this.bAJ = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
        }
    };
    private final CustomMessageListener aJC = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.good.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dRL != null) {
                b.this.dRL.startPullRefresh();
            }
        }
    };
    private final j.b ceh = new j.b() { // from class: com.baidu.tieba.frs.good.b.8
        @Override // com.baidu.tbadk.core.view.j.b
        public void bw(boolean z) {
            TiebaStatic.eventStat(b.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.oJ()) {
                b.this.dRL.ayR().setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
                b.this.gl(true);
                return;
            }
            b.this.dRL.cQ(false);
        }
    };
    private final RecyclerView.OnScrollListener Sh = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.b.9
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !b.this.dEC) {
                b.this.dEC = true;
                b.this.dRL.avY();
            }
            if (b.this.dED == null) {
                b.this.dED = new com.baidu.tbadk.k.d();
                b.this.dED.ij(1000);
            }
            b.this.dED.Od();
            if (i == 0) {
                r.alt().eO(true);
            }
        }
    };
    private final CustomMessageListener bjx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.b.10
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
    private o dFE = new o() { // from class: com.baidu.tieba.frs.good.b.2
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
                            if (b.this.dRL != null) {
                                b.this.dRL.avN();
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
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(b.this.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, b.this.dEq, "frs_page", 18003, true, false, z);
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
        this.dRL.gm(false);
        showLoadingView(this.dRL.ayS(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VV() {
        this.dRL.gm(true);
        hideLoadingView(this.dRL.ayS());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dRL.gm(false);
        this.dRL.ayT().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dRL.XQ();
        this.dRL.getListView().getData().clear();
        this.dRL.avN();
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
        this.mRefreshView.j(this.dRL.ayS(), true);
    }

    private void XN() {
        this.dRL.gm(true);
        this.dRL.ayT().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.MJ()) {
            this.mRefreshView.bk(this.dRL.ayS());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl(boolean z) {
        avi();
        XN();
        if (!z) {
            XN();
            VU();
        }
        this.dRJ.jI(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dpJ = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.dpJ = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.bAB = this.beginTime - this.dpJ;
        super.onCreate(bundle);
        this.dRJ = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dRJ.l(arguments);
            this.dRI = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dRJ.l(bundle);
            this.dRI = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dRJ.l(null);
        }
        this.dEw = getVoiceManager();
        this.dEw.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.aJC);
        registerListener(this.bdV);
        registerListener(this.dFm);
        this.dRK = new FrsLoadMoreModel(this, null);
        this.dRK.registerListener();
        this.dRK.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_good_activity, (ViewGroup) null);
        this.dRL = new c(this, inflate, this.dRI);
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
        this.dEw = getVoiceManager();
        this.dEw.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        ayL();
        if (bundle != null) {
            this.dEq = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dEq = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void ayL() {
        registerListener(2001118, this.bjx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dRL != null) {
            this.dRL.onDestroy();
        }
        r.alt().eO(false);
        super.onDestroy();
        try {
            if (this.dED != null) {
                this.dED.onDestroy();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dRJ.onActivityDestroy();
        this.dEw = getVoiceManager();
        this.dEw.onDestory(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dEq);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dRI);
        this.dRJ.onSaveInstanceState(bundle);
        this.dEw = getVoiceManager();
        if (this.dEw != null) {
            this.dEw.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bd sE;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dRL.ayR().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (sE = this.dEb.sE(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            sE.eS(intent.getIntExtra("good_data", 0));
                            sE.zW();
                            gl(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dEb.aj(sE);
                            ArrayList<i> threadList = this.dEb.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.dRL.ayP();
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
        if (isAdded() && isPrimary() && this.dRM == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.dRL.startPullRefresh();
            return;
        }
        if (this.dRL != null) {
            this.dRL.avN();
        }
        this.dEw = getVoiceManager();
        this.dEw.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dRN = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dRL.setOnAdapterItemClickListener(this.dFE);
        this.dRL.setOnScrollListener(this.Sh);
        this.dRL.a(this.ceh);
        this.dRL.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.b.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (b.this.dRN != null) {
                    b.this.dRN.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dRM != 3 || this.dRL != null) {
            this.dRM = i;
            super.onChangeSkinType(i);
            if (this.dRL != null) {
                this.dRL.onChangeSkinType(i);
            }
        }
    }

    private void ave() {
        switch (this.mFlag) {
            case 1:
                h.nt().e(new Runnable() { // from class: com.baidu.tieba.frs.good.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sQ(b.this.dEq);
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
            if (this.dEb != null) {
                this.dRL.aik();
                this.dEq = this.dEb.bas().getName();
                this.forumId = this.dEb.bas().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dEb.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dEb.getUserData().getBimg_end_time());
                ave();
                if (!this.dRL.ayR().k(bd.aOy)) {
                    this.dEb.bvM();
                }
                ArrayList<i> threadList = this.dEb.getThreadList();
                if (threadList != null) {
                    this.dRL.a(threadList, this.mPn, this.dEb, this.dEb.yA().yw());
                    ayM();
                    this.dRL.ayP();
                    if (this.dEb.baH() == 1) {
                        this.dRL.ayR().setFromCDN(true);
                    } else {
                        this.dRL.ayR().setFromCDN(false);
                    }
                    this.dRL.setListViewSelection(bF(ayN().getType(), this.mPn));
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
        this.dEw = getVoiceManager();
        this.dEw.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        r.alt().eO(false);
        if (this.dEb != null && this.dEb.bas() != null) {
            com.baidu.tbadk.distribute.a.KM().a(getPageContext().getPageActivity(), "frs", this.dEb.bas().getId(), 0L);
        }
        this.dEw = getVoiceManager();
        if (this.dEw != null) {
            this.dEw.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nB(int i) {
        ArrayList<i> threadList = this.dEb.getThreadList();
        if (threadList != null) {
            Iterator<i> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar.getId() != null && bdVar.getId().equals(this.dRH)) {
                        c(bdVar, i);
                        this.dRH = null;
                        break;
                    }
                }
            }
            this.dRL.ayR().b(threadList, this.dEb);
            this.dRL.ayR().notifyDataSetChanged();
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
        if (this.dEw == null) {
            this.dEw = VoiceManager.instance();
        }
        return this.dEw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Ez() {
        if (this.dRL == null) {
            return null;
        }
        return this.dRL.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void avi() {
        this.dEw = getVoiceManager();
        this.dEw.stopPlay();
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
        if (this.dEb != null && this.dRL != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dRL.avN();
            }
        }
    }

    private void ayM() {
        HashMap<Integer, bd> axn;
        if (this.dRL != null && this.dRL.ayR() != null && (axn = this.dRL.ayR().axn()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bd> entry : axn.entrySet()) {
                bd value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.KR().p(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (Ez() == null) {
            return null;
        }
        return Ez().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.oJ()) {
            gl(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l avl() {
        return this.dEb;
    }

    public FrsGoodModelController ayN() {
        return this.dRJ;
    }

    public void mf(String str) {
        this.dEq = str;
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
            this.dRL.XQ();
        } else if (!this.dRJ.ayX()) {
            this.dRL.XQ();
        } else {
            Xc();
            if (!this.dRK.isLoading && !this.dRJ.El()) {
                if (this.dRK.bv(this.dEb.buZ())) {
                    this.dRL.a(this.dRK.azi(), this.mPn, this.dEb, 0);
                    this.dRK.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.dEb.buZ(), this.dEq, this.mPn);
                } else if (this.cHk != 0) {
                    this.dRL.a(this.dRK.azi(), this.mPn, this.dEb, 0);
                    this.mPn++;
                    this.dRJ.nD(this.mPn);
                    this.dRK.loadingDone = false;
                    this.dRK.loadIndex = 0;
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.dRK.a(false, false, false, arrayList, null)) != null) {
            this.dEb.au(a);
            this.dRL.a(a, this.mPn, this.dEb, 0);
        }
    }

    private void Xc() {
        if (this.cHk == 0 && !this.dRK.bv(this.dEb.buZ())) {
            if (this.dEb.getThreadList() == null || this.dEb.getThreadList().size() == 0) {
                this.dRL.XQ();
                return;
            } else {
                this.dRL.XP();
                return;
            }
        }
        this.dRL.XO();
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
        if (this.dRJ != null) {
            this.dRJ.avh();
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
        return this.dEq;
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
    public void auF() {
        if (this.dRL != null && this.dRL.getListView() != null) {
            this.dRL.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void XL() {
        if (this.dRL != null) {
            auF();
            this.dRL.startPullRefresh();
        }
    }
}
