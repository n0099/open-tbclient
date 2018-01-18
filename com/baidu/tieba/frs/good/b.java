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
    private VoiceManager dBh;
    private String dOi;
    private FrsGoodModelController dOk;
    private FrsLoadMoreModel dOl;
    private com.baidu.tieba.frs.gametab.b dOo;
    private String dBb = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean dOj = false;
    private String forumId = null;
    private l dAN = new l();
    public long dmx = -1;
    public long byo = 0;
    public long byw = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dBn = false;
    private d dBo = null;
    protected c dOm = null;
    private int cDe = -1;
    private int mTabId = 0;
    private int dOn = 3;
    private boolean dOp = false;
    private CustomMessageListener bbX = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                bd bdVar = (bd) customResponsedMessage.getData();
                b.this.dOi = bdVar.getId();
                if (!TextUtils.isEmpty(b.this.dOi) && bdVar.yH() != null) {
                    b.this.nC(bdVar.yH().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener dBT = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (b.this.Ec() != null) {
                        b.this.Ec().setSelection(0);
                    }
                    if (b.this.dOp) {
                        b.this.ga(false);
                    } else if (b.this.dOm != null) {
                        b.this.dOm.startPullRefresh();
                    }
                }
            }
        }
    };
    public final n dCe = new n() { // from class: com.baidu.tieba.frs.good.b.4
        private long dOt = 1;

        @Override // com.baidu.tieba.tbadkCore.n
        public void mT(int i) {
            switch (i) {
                case 1:
                case 2:
                    b.this.dOm.auH();
                    return;
                case 3:
                    b.this.dOm.cL(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            ArrayList<i> a;
            if (aVar == null) {
                this.dOt = 1L;
            } else if (aVar.isSuccess) {
                this.dOt = 0L;
            } else {
                this.dOt = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                b.this.dOl.resetData();
            }
            b.this.dOm.cL(false);
            if (b.this.axJ().axQ() != null) {
                b.this.dAN = b.this.axJ().axQ();
            }
            b.this.cDe = b.this.dAN.xY().xU();
            if (b.this.cDe == 0 && (b.this.dAN.btI() == null || b.this.dAN.btI().size() == 0)) {
                if (b.this.dAN.getThreadList() == null || b.this.dAN.getThreadList().size() == 0) {
                    b.this.dOm.alP();
                } else {
                    b.this.dOm.auT();
                }
            } else {
                b.this.dOm.auS();
            }
            if (i == 4) {
                ArrayList<i> a2 = b.this.dOl.a(false, false, false, b.this.dAN.getThreadList(), null);
                if (a2 != null) {
                    b.this.dAN.at(a2);
                    b.this.dOm.a(a2, b.this.mPn, b.this.dAN, b.this.cDe);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    b.this.dOm.auH();
                    break;
                case 2:
                    b.this.dOm.auH();
                    break;
            }
            b.this.Vb();
            if (this.dOt != 0) {
                b.this.c(aVar);
            } else {
                if (b.this.dAN != null) {
                    b.this.dBb = b.this.dAN.aYE().getName();
                    b.this.forumId = b.this.dAN.aYE().getId();
                    b.this.dOm.b(b.this.dAN.aYE(), b.this.dAN.getUserData());
                }
                if (b.this.dAN != null) {
                    b.this.dAN.but();
                }
                b.this.dOm.c(b.this.dAN);
                if (b.this.dAN == null || b.this.dAN.getThreadList() == null || b.this.dAN.getThreadList().size() != 0 || b.this.axJ().getType() != 4) {
                    if (b.this.dAN != null && (a = b.this.dOl.a(false, false, true, b.this.dAN.getThreadList(), null)) != null && a.size() > 0) {
                        b.this.dAN.at(a);
                    }
                    b.this.auk();
                } else {
                    b.this.showToast(b.this.getPageContext().getString(d.j.no_more_to_load));
                    if (b.this.mPn > 1) {
                        b.h(b.this);
                    }
                    if (b.this.dmx > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - b.this.dmx, b.this.axJ().apW() - b.this.dmx, b.this.axJ().apU(), b.this.axJ().apV(), currentTimeMillis2 - b.this.axJ().apT());
                        b.this.dmx = -1L;
                    }
                    b.this.byw = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (b.this.dmx > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - b.this.dmx, b.this.axJ().apW() - b.this.dmx, b.this.axJ().apU(), b.this.axJ().apV(), currentTimeMillis3 - b.this.axJ().apT());
                b.this.dmx = -1L;
            }
            b.this.byw = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
        }
    };
    private final CustomMessageListener aIf = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && b.this.dOm != null) {
                b.this.dOm.startPullRefresh();
            }
        }
    };
    private final j.b dOq = new j.b() { // from class: com.baidu.tieba.frs.good.b.8
        @Override // com.baidu.tbadk.core.view.j.b
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(b.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.oI()) {
                b.this.ga(true);
            } else {
                b.this.dOm.cL(false);
            }
        }
    };
    private final RecyclerView.OnScrollListener Si = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.b.9
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !b.this.dBn) {
                b.this.dBn = true;
                b.this.dOm.auR();
            }
            if (b.this.dBo == null) {
                b.this.dBo = new com.baidu.tbadk.k.d();
                b.this.dBo.im(1000);
            }
            b.this.dBo.Nv();
            if (i == 0) {
                s.akF().eF(true);
            }
        }
    };
    private final CustomMessageListener dCl = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.b.10
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
    private com.baidu.adp.widget.ListView.o dCm = new com.baidu.adp.widget.ListView.o() { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Multi-variable search result rejected for r2v22, resolved type: com.baidu.tieba.frs.good.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.o
        public void a(View view, i iVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && iVar != null && (iVar instanceof bd)) {
                bd bdVar = (bd) iVar;
                if (bdVar.zD() == null || bdVar.zD().getGroup_id() == 0 || ax.be(b.this.getActivity())) {
                    if ((bdVar.zw() != 1 && bdVar.zw() != 2) || ax.be(b.this.getActivity())) {
                        e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.sH(bdVar.getId())) {
                            readThreadHistory.sG(bdVar.getId());
                            if (b.this.dOm != null) {
                                b.this.dOm.auH();
                            }
                        }
                        boolean z = false;
                        final String za = bdVar.za();
                        if (za != null && !za.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.b.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(za);
                                    xVar.Cf().Db().mIsNeedAddCommenParam = false;
                                    xVar.Cf().Db().mIsUseCurrentBDUSS = false;
                                    xVar.BI();
                                }
                            }).start();
                        }
                        String tid = bdVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bdVar.yN() == 2 && !tid.startsWith("pb:")) {
                            av.CZ().c(b.this.getPageContext(), new String[]{tid, "", null});
                        } else if (bdVar.getThreadType() == 33 || (bdVar instanceof as)) {
                            TiebaStatic.log(new ak(bdVar.getThreadType() == 33 ? "c10245" : "c10180").ab(ImageViewerConfig.FORUM_ID, b.this.forumId));
                            b.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(b.this.getPageContext().getPageActivity(), bdVar.getTid()).cG("from_frs").eC(18003).wP()));
                        } else {
                            if (tid.startsWith("pb:")) {
                                bdVar.setId(tid.substring(3));
                            }
                            PbActivityConfig createFromThreadCfg = new PbActivityConfig(b.this.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, b.this.dBb, "frs_page", 18003, true, false, z);
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

    private void Va() {
        this.dOm.gb(false);
        showLoadingView(this.dOm.axO(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vb() {
        this.dOm.gb(true);
        hideLoadingView(this.dOm.axO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dOm.gb(true);
        this.dOm.axP().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.dOm.alP();
        this.dOm.getListView().getData().clear();
        this.dOm.auH();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Mj();
            this.mRefreshView.ic(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.Mh().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.gF(getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.gF(null);
        }
        this.mRefreshView.onChangeSkinType();
        if (!this.dOp) {
            this.dOm.getListView().addHeaderView(this.mRefreshView.Mh(), 0);
        }
        this.dOp = true;
    }

    private void WE() {
        this.dOm.gb(true);
        this.dOm.axP().setEnabled(true);
        if (this.mRefreshView != null) {
            this.dOm.getListView().removeHeaderView(this.mRefreshView.Mh());
            this.dOm.auH();
        }
        this.dOp = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(boolean z) {
        aun();
        if (this.dOp) {
            WE();
        }
        if (!z) {
            WE();
            Va();
        }
        this.dOk.my(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dmx = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.dmx = System.currentTimeMillis();
        }
        this.beginTime = System.currentTimeMillis();
        this.byo = this.beginTime - this.dmx;
        super.onCreate(bundle);
        this.dOk = new FrsGoodModelController(this);
        if (arguments != null) {
            this.dOk.k(arguments);
            this.dOj = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.dOk.k(bundle);
            this.dOj = bundle.getBoolean("is_game_frs", false);
        } else {
            this.dOk.k(null);
        }
        this.dBh = getVoiceManager();
        this.dBh.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.aIf);
        registerListener(this.bbX);
        registerListener(this.dBT);
        this.dOl = new FrsLoadMoreModel(this, null);
        this.dOl.registerListener();
        this.dOl.setPageType(2);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_good_activity, (ViewGroup) null);
        this.dOm = new c(this, inflate, this.dOj);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (com.baidu.adp.lib.util.j.oI()) {
            ga(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dBh = getVoiceManager();
        this.dBh.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        axH();
        if (bundle != null) {
            this.dBb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dBb = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void axH() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dCl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dOm != null) {
            this.dOm.onDestroy();
        }
        s.akF().eF(false);
        super.onDestroy();
        try {
            if (this.dBo != null) {
                this.dBo.onDestroy();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dOk.onActivityDestroy();
        this.dBh = getVoiceManager();
        this.dBh.onDestory(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dBb);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.dOj);
        this.dOk.onSaveInstanceState(bundle);
        this.dBh = getVoiceManager();
        if (this.dBh != null) {
            this.dBh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bd so;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dOm.axN().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (so = this.dAN.so(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            so.eS(intent.getIntExtra("good_data", 0));
                            so.zB();
                            ga(false);
                            return;
                        } else if (intExtra == 0) {
                            this.dAN.ag(so);
                            ArrayList<i> threadList = this.dAN.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new m());
                            }
                            this.dOm.axL();
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
        if (isAdded() && isPrimary() && this.dOn == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.dOm.startPullRefresh();
            return;
        }
        if (this.dOm != null) {
            this.dOm.auH();
        }
        this.dBh = getVoiceManager();
        this.dBh.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.dOo = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.dOm.setOnAdapterItemClickListener(this.dCm);
        this.dOm.setOnScrollListener(this.Si);
        this.dOm.a(this.dOq);
        this.dOm.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.b.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (b.this.dOo != null) {
                    b.this.dOo.f(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dOn != 3 || this.dOm != null) {
            this.dOn = i;
            super.onChangeSkinType(i);
            if (this.dOm != null) {
                this.dOm.onChangeSkinType(i);
            }
        }
    }

    private void auj() {
        switch (this.mFlag) {
            case 1:
                h.ns().e(new Runnable() { // from class: com.baidu.tieba.frs.good.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sB(b.this.dBb);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auk() {
        aun();
        try {
            if (this.dAN != null) {
                this.dOm.WN();
                this.dBb = this.dAN.aYE().getName();
                this.forumId = this.dAN.aYE().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.dAN.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dAN.getUserData().getBimg_end_time());
                auj();
                if (!this.dOm.axN().k(bd.aNc)) {
                    this.dAN.buv();
                }
                ArrayList<i> threadList = this.dAN.getThreadList();
                if (threadList != null) {
                    this.dOm.a(threadList, this.mPn, this.dAN, this.dAN.xY().xU());
                    axI();
                    this.dOm.axL();
                    if (this.dAN.aYT() == 1) {
                        this.dOm.axN().setFromCDN(true);
                    } else {
                        this.dOm.axN().setFromCDN(false);
                    }
                    this.dOm.setListViewSelection(bH(axJ().getType(), this.mPn));
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
        this.dBh = getVoiceManager();
        this.dBh.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.akF().eF(false);
        if (this.dAN != null && this.dAN.aYE() != null) {
            com.baidu.tbadk.distribute.a.Ke().a(getPageContext().getPageActivity(), "frs", this.dAN.aYE().getId(), 0L);
        }
        this.dBh = getVoiceManager();
        if (this.dBh != null) {
            this.dBh.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nC(int i) {
        ArrayList<i> threadList = this.dAN.getThreadList();
        if (threadList != null) {
            Iterator<i> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar.getId() != null && bdVar.getId().equals(this.dOi)) {
                        c(bdVar, i);
                        this.dOi = null;
                        break;
                    }
                }
            }
            this.dOm.axN().b(threadList, this.dAN);
            this.dOm.axN().notifyDataSetChanged();
        }
    }

    private void c(bd bdVar, int i) {
        if (i == 1) {
            PraiseData yH = bdVar.yH();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (yH == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bdVar.a(praiseData);
                    return;
                }
                bdVar.yH().getUser().add(0, metaData);
                bdVar.yH().setNum(bdVar.yH().getNum() + 1);
                bdVar.yH().setIsLike(i);
            }
        } else if (bdVar.yH() != null) {
            bdVar.yH().setIsLike(i);
            bdVar.yH().setNum(bdVar.yH().getNum() - 1);
            ArrayList<MetaData> user = bdVar.yH().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bdVar.yH().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dBh == null) {
            this.dBh = VoiceManager.instance();
        }
        return this.dBh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Ec() {
        if (this.dOm == null) {
            return null;
        }
        return this.dOm.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aun() {
        this.dBh = getVoiceManager();
        this.dBh.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Ed() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).Ed();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.dAN != null && this.dOm != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.dOm.auH();
            }
        }
    }

    private void axI() {
        HashMap<Integer, bd> awj;
        if (this.dOm != null && this.dOm.axN() != null && (awj = this.dOm.axN().awj()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bd> entry : awj.entrySet()) {
                bd value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.Kj().p(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (Ec() == null) {
            return null;
        }
        return Ec().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.oI()) {
            ga(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public l auq() {
        return this.dAN;
    }

    public FrsGoodModelController axJ() {
        return this.dOk;
    }

    public void lM(String str) {
        this.dBb = str;
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
            this.dOm.alP();
        } else if (!this.dOk.axS()) {
            this.dOm.alP();
        } else {
            Wj();
            if (!this.dOl.isLoading && !this.dOk.DP()) {
                if (this.dOl.bt(this.dAN.btI())) {
                    this.dOm.a(this.dOl.ayb(), this.mPn, this.dAN, 0);
                    this.dOl.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.dAN.btI(), this.dBb, this.mPn);
                } else if (this.cDe != 0) {
                    this.dOm.a(this.dOl.ayb(), this.mPn, this.dAN, 0);
                    this.mPn++;
                    this.dOk.nE(this.mPn);
                    this.dOl.loadingDone = false;
                    this.dOl.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void lf(String str) {
        Wj();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<i> arrayList) {
        ArrayList<i> a;
        Wj();
        if (arrayList != null && arrayList.size() != 0 && (a = this.dOl.a(false, false, false, arrayList, null)) != null) {
            this.dAN.at(a);
            this.dOm.a(a, this.mPn, this.dAN, 0);
        }
    }

    private void Wj() {
        if (this.cDe == 0 && !this.dOl.bt(this.dAN.btI())) {
            if (this.dAN.getThreadList() == null || this.dAN.getThreadList().size() == 0) {
                this.dOm.alP();
                return;
            } else {
                this.dOm.auT();
                return;
            }
        }
        this.dOm.auS();
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
    public TbPageContext<?> aka() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Ke().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.o
    public void aum() {
        if (this.dOk != null) {
            this.dOk.aum();
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
    public NavigationBar aup() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dBb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nD(int i) {
        this.mTabId = i;
        if (com.baidu.adp.lib.util.j.oI()) {
            ga(false);
        } else {
            c((d.a) null);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void atK() {
        if (this.dOm != null && this.dOm.getListView() != null) {
            this.dOm.getListView().scrollToPosition(0);
        }
    }
}
