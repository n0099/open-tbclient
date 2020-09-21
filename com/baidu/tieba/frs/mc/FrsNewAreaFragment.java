package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.t;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes21.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, as, at, au, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.recapp.n, FrsCommonImageLayout.c {
    private VoiceManager hZU;
    private com.baidu.tbadk.k.c igm;
    private String iui;
    private FrsLoadMoreModel iul;
    private FrsNewAreaModelController iwG;
    private String hZN = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData hZt = new FrsViewData();
    public long hCy = -1;
    public long eUE = 0;
    public long eUN = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean iah = false;
    protected g iwH = null;
    private int gUU = -1;
    private int iiW = 3;
    private boolean hwz = false;
    private boolean iuo = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iav = new SparseArray<>();
    private int djl = 0;
    private int iaT = 0;
    private CustomMessageListener idB = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.igm != null && FrsNewAreaFragment.this.igm.isViewAttached()) {
                FrsNewAreaFragment.this.igm.qJ(num.intValue());
            }
        }
    };
    private Runnable iup = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.hwz) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.pc(false);
            }
        }
    };
    private CustomMessageListener iuq = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                bw bwVar = (bw) customResponsedMessage.getData();
                FrsNewAreaFragment.this.iui = bwVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.iui) && bwVar.bfj() != null) {
                    FrsNewAreaFragment.this.yH(bwVar.bfj().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener ibh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.blX() != null) {
                        FrsNewAreaFragment.this.blX().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.igm != null && FrsNewAreaFragment.this.igm.isViewAttached()) {
                        FrsNewAreaFragment.this.pc(false);
                    } else if (FrsNewAreaFragment.this.iwH != null) {
                        FrsNewAreaFragment.this.iwH.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final r ibz = new r() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long iut = 1;

        @Override // com.baidu.tieba.tbadkCore.r
        public void xu(int i) {
            if (!FrsNewAreaFragment.this.iuo) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.iwH.cqr();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.iwH.ki(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<q> a;
            if (FrsNewAreaFragment.this.iuo) {
                if (FrsNewAreaFragment.this.cvy().cuI() == null) {
                    FrsNewAreaFragment.this.iuo = false;
                    return;
                } else if (FrsNewAreaFragment.this.cvy().cuI().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.iuo = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.iut = 1L;
            } else if (fVar.isSuccess) {
                this.iut = 0L;
            } else {
                this.iut = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.iul.resetData();
            }
            FrsNewAreaFragment.this.iwH.ki(false);
            if (FrsNewAreaFragment.this.cvy().cuI() != null) {
                FrsNewAreaFragment.this.hZt = FrsNewAreaFragment.this.cvy().cuI();
            }
            FrsNewAreaFragment.this.gUU = FrsNewAreaFragment.this.hZt.getPage().beo();
            if (FrsNewAreaFragment.this.gUU == 0 && (FrsNewAreaFragment.this.hZt.getThreadListIds() == null || FrsNewAreaFragment.this.hZt.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.hZt.getThreadList() == null || FrsNewAreaFragment.this.hZt.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.iwH.bIk();
                } else {
                    FrsNewAreaFragment.this.iwH.bIj();
                }
            } else {
                FrsNewAreaFragment.this.iwH.bIi();
            }
            if (i == 4) {
                ArrayList<q> a2 = FrsNewAreaFragment.this.iul.a(false, false, false, FrsNewAreaFragment.this.hZt.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.hZt.setThreadList(a2);
                    FrsNewAreaFragment.this.iwH.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.hZt, FrsNewAreaFragment.this.gUU);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.iwH.cqr();
                    break;
                case 2:
                    FrsNewAreaFragment.this.iwH.cqr();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.hZt.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.iut != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.hZt != null) {
                    FrsNewAreaFragment.this.hZN = FrsNewAreaFragment.this.hZt.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.hZt.getForum().getId();
                    FrsNewAreaFragment.this.iwH.b(FrsNewAreaFragment.this.hZt.getForum(), FrsNewAreaFragment.this.hZt.getUserData());
                }
                if (FrsNewAreaFragment.this.hZt != null) {
                    FrsNewAreaFragment.this.hZt.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.hZt == null || FrsNewAreaFragment.this.hZt.getThreadList() == null || FrsNewAreaFragment.this.hZt.getThreadList().size() != 0 || FrsNewAreaFragment.this.cvy().getType() != 4) {
                    if (FrsNewAreaFragment.this.hZt != null && (a = FrsNewAreaFragment.this.iul.a(false, false, true, FrsNewAreaFragment.this.hZt.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.hZt.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.cpz();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.hCy > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.hCy, FrsNewAreaFragment.this.cvy().cjs() - FrsNewAreaFragment.this.hCy, FrsNewAreaFragment.this.cvy().cjq(), FrsNewAreaFragment.this.cvy().cjr(), currentTimeMillis2 - FrsNewAreaFragment.this.cvy().cjp());
                        FrsNewAreaFragment.this.hCy = -1L;
                    }
                    FrsNewAreaFragment.this.eUN = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.hCy > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.hCy, FrsNewAreaFragment.this.cvy().cjs() - FrsNewAreaFragment.this.hCy, FrsNewAreaFragment.this.cvy().cjq(), FrsNewAreaFragment.this.cvy().cjr(), currentTimeMillis3 - FrsNewAreaFragment.this.cvy().cjp());
                FrsNewAreaFragment.this.hCy = -1L;
            }
            FrsNewAreaFragment.this.eUN = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cpt() {
        }
    };
    private final CustomMessageListener dWP = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.iwH != null) {
                FrsNewAreaFragment.this.iwH.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.iah) {
                FrsNewAreaFragment.this.iah = true;
                FrsNewAreaFragment.this.iwH.cqG();
            }
            if (i == 0) {
                s.cfn().ns(true);
                com.baidu.tieba.s.c.dzC().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.iaT += i2;
            if (FrsNewAreaFragment.this.iaT >= FrsNewAreaFragment.this.djl * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener eEB = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                FrsNewAreaFragment.this.f(customResponsedMessage);
            }
        }
    };
    private ab ibG = new ab() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bv)) {
                bw bwVar = ((bv) qVar).dXg;
                if (bwVar.bgy() == null || bwVar.bgy().getGroup_id() == 0 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bwVar.bgl() != 1 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Rx(bwVar.getId())) {
                            readThreadHistory.Rw(bwVar.getId());
                            if (FrsNewAreaFragment.this.iwH != null) {
                                FrsNewAreaFragment.this.iwH.cqr();
                            }
                        }
                        boolean z = false;
                        final String bfE = bwVar.bfE();
                        if (bfE != null && !bfE.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(bfE);
                                    aaVar.bjL().bkq().mIsNeedAddCommenParam = false;
                                    aaVar.bjL().bkq().mIsUseCurrentBDUSS = false;
                                    aaVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bwVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bwVar.bft() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.bkp().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bwVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bwVar, FrsNewAreaFragment.this.hZN, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.hZt != null && FrsNewAreaFragment.this.hZt.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.iyp = FrsNewAreaFragment.this.hZt.needLog == 1;
                            bVar.iyr = FrsNewAreaFragment.this.hZt.getForum().getId();
                            bVar.iyq = FrsNewAreaFragment.this.iwG.cvm();
                            if (com.baidu.tieba.frs.d.d.ijV != null) {
                                bVar.iys = com.baidu.tieba.frs.d.d.ijV.iys;
                                bVar.iyt = com.baidu.tieba.frs.d.d.ijV.iyt;
                            }
                            com.baidu.tieba.frs.d.a.a(bwVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar, FrsNewAreaFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };

    static /* synthetic */ int k(FrsNewAreaFragment frsNewAreaFragment) {
        int i = frsNewAreaFragment.mPn;
        frsNewAreaFragment.mPn = i - 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public void an(bw bwVar) {
        if (bwVar != null) {
            this.iwG.an(bwVar);
            this.iwH.coM();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.hZt = frsViewData;
            hideLoadingView(this.iwH.caY());
            if (this.iwH != null) {
                this.iwH.ki(false);
                this.iwH.a(null, this.mPn, this.hZt, this.gUU);
            }
        }
    }

    private void showLoadingView() {
        this.iwH.oL(false);
        showLoadingView(this.iwH.caY(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.iwH.oL(true);
        hideLoadingView(this.iwH.caY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.iwH.oL(false);
        this.iwH.oK(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.iwH.bIk();
        this.iwH.getListView().getData().clear();
        this.iwH.cqr();
        if (this.igm == null) {
            this.igm = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.igm.setTitle(null);
            this.igm.setButtonText(null);
            this.igm.showRefreshButton();
            this.igm.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.igm.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.igm.setSubText(null);
        }
        this.igm.onChangeSkinType();
        this.igm.attachView(this.iwH.caY(), true);
        registerListener(this.idB);
    }

    private void bHn() {
        this.iwH.oL(true);
        this.iwH.oK(true);
        if (this.igm != null && this.igm.isViewAttached()) {
            this.igm.dettachView(this.iwH.caY());
        }
        MessageManager.getInstance().unRegisterListener(this.idB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pc(boolean z) {
        this.hwz = true;
        cpE();
        bHn();
        if (!z) {
            bHn();
            showLoadingView();
        }
        this.iwG.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hCy = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.hCy = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.eUE = this.beginTime - this.hCy;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dzC().z(getUniqueId());
        this.iwG = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.iwG.aj(arguments);
        } else if (bundle != null) {
            this.iwG.aj(bundle);
        } else {
            this.iwG.aj(null);
        }
        this.hZU = getVoiceManager();
        this.hZU.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dWP);
        registerListener(this.iuq);
        registerListener(this.ibh);
        this.iul = new FrsLoadMoreModel(this, null);
        this.iul.registerListener();
        this.iul.setPageType(3);
        this.iul.pe(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.djl = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.iwH = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.hwz) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                pc(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bki();
    }

    private void bki() {
        aq aqVar = new aq("c13008");
        aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dF("fid", this.forumId);
        aqVar.ai("obj_type", 6);
        aqVar.ai("obj_locate", 2);
        aqVar.bki();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hZU = getVoiceManager();
        this.hZU.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cux();
        if (bundle != null) {
            this.hZN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.hZN = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cux() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eEB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.iwH != null) {
            this.iwH.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.idB);
        com.baidu.tieba.s.c.dzC().A(getUniqueId());
        s.cfn().ns(false);
        super.onDestroy();
        this.iwG.cuG();
        this.hZU = getVoiceManager();
        this.hZU.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iup);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hZN);
        bundle.putString("from", this.mFrom);
        this.iwG.onSaveInstanceState(bundle);
        this.hZU = getVoiceManager();
        if (this.hZU != null) {
            this.hZU.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bw threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.iwH.cvA().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.hZt.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.nu(intent.getIntExtra("good_data", 0));
                            threadDataById.bgw();
                            pc(false);
                            return;
                        } else if (intExtra == 0) {
                            this.hZt.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.hZt.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.iwH.cuC();
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
        if (isAdded() && isPrimary()) {
            if (this.iiW == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.hwz) {
                com.baidu.adp.lib.f.e.mX().post(this.iup);
            }
        }
        crI();
    }

    private void crI() {
        if (isPrimary()) {
            if (this.igm != null && this.igm.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.idB);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.idB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iwH != null) {
            this.iwH.cqr();
        }
        this.hZU = getVoiceManager();
        this.hZU.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.iwH.a(this.ibG);
        this.iwH.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iiW != 3 || this.iwH != null) {
            this.iiW = i;
            super.onChangeSkinType(i);
            if (this.iwH != null) {
                this.iwH.onChangeSkinType(i);
            }
            if (this.igm != null && this.igm.isViewAttached()) {
                this.igm.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cot() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cot();
        }
        return null;
    }

    private void cpy() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mY().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Rr(FrsNewAreaFragment.this.hZN);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpz() {
        cpE();
        try {
            if (this.hZt != null) {
                this.iwH.crS();
                this.iwH.bMD();
                this.hZN = this.hZt.getForum().getName();
                this.forumId = this.hZt.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.hZt.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hZt.getUserData().getBimg_end_time());
                cpy();
                ArrayList<q> threadList = this.hZt.getThreadList();
                if (threadList != null) {
                    this.iwH.a(threadList, this.mPn, this.hZt, this.hZt.getPage().beo());
                    cuz();
                    this.iwH.cuC();
                    if (this.hZt.getIsNewUrl() == 1) {
                        this.iwH.cvA().setFromCDN(true);
                    } else {
                        this.iwH.cvA().setFromCDN(false);
                    }
                    this.iwH.setListViewSelection(cu(cvy().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cu(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hZU = getVoiceManager();
        this.hZU.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.cfn().ns(false);
        com.baidu.tieba.s.c.dzC().b(getUniqueId(), false);
        if (this.hZt != null && this.hZt.getForum() != null) {
            com.baidu.tbadk.distribute.a.bsi().b(getPageContext().getPageActivity(), "frs", this.hZt.getForum().getId(), 0L);
        }
        this.hZU = getVoiceManager();
        if (this.hZU != null) {
            this.hZU.onStop(getPageContext());
        }
    }

    public void csr() {
        if (this.iwH != null && this.iwH.getListView() != null) {
            this.iwH.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    FrsNewAreaFragment.this.iwH.refreshView();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH(int i) {
        ArrayList<q> threadList = this.hZt.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).dXg;
                    if (bwVar.getId() != null && bwVar.getId().equals(this.iui)) {
                        c(bwVar, i);
                        this.iui = null;
                        break;
                    }
                }
            }
            this.iwH.cvA().b(threadList, this.hZt);
            this.iwH.cvA().notifyDataSetChanged();
        }
    }

    private void c(bw bwVar, int i) {
        if (i == 1) {
            PraiseData bfj = bwVar.bfj();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bfj == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bwVar.a(praiseData);
                    return;
                }
                bwVar.bfj().getUser().add(0, metaData);
                bwVar.bfj().setNum(bwVar.bfj().getNum() + 1);
                bwVar.bfj().setIsLike(i);
            }
        } else if (bwVar.bfj() != null) {
            bwVar.bfj().setIsLike(i);
            bwVar.bfj().setNum(bwVar.bfj().getNum() - 1);
            ArrayList<MetaData> user = bwVar.bfj().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bwVar.bfj().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hZU == null) {
            this.hZU = VoiceManager.instance();
        }
        return this.hZU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView blX() {
        if (this.iwH == null) {
            return null;
        }
        return this.iwH.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cpE() {
        this.hZU = getVoiceManager();
        this.hZU.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> blY() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).blY();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.hZt != null && this.iwH != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.iwH.cqr();
            }
        }
    }

    private void cuz() {
        HashMap<Integer, bw> csV;
        if (this.iwH != null && this.iwH.cvA() != null && (csV = this.iwH.cvA().csV()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bw> entry : csV.entrySet()) {
                bw value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bso().L(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        if (blX() == null) {
            return null;
        }
        return blX().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            pc(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cpJ() {
        return this.hZt;
    }

    public FrsNewAreaModelController cvy() {
        return this.iwG;
    }

    public void Jk(String str) {
        this.hZN = str;
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

    public void bGU() {
        if (!this.iul.isLoading && !this.iwG.isLoading()) {
            if (this.iul.cU(this.hZt.getThreadListIds())) {
                this.iwH.a(this.iul.cuV(), this.mPn, this.hZt, 0);
                this.iul.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.hZt.getThreadListIds(), this.hZN, this.mPn, this.hZt.isBrandForum);
            } else if (this.gUU != 0) {
                this.iwH.a(this.iul.cuV(), this.mPn, this.hZt, 0);
                this.mPn++;
                this.iwG.yJ(this.mPn);
                this.iul.loadingDone = false;
                this.iul.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.iwH.bIk();
        } else if (!this.iwH.cqA()) {
            if (!this.iwG.cuK()) {
                this.iwH.bIk();
                return;
            }
            bHj();
            bGU();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bHj();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void aw(ArrayList<q> arrayList) {
        bHj();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<q> a = this.iul.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a != null) {
                this.hZt.setThreadList(a);
                this.iwH.a(a, this.mPn, this.hZt, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.hZt.getForum()));
        }
    }

    public void cV(List<String> list) {
        cJ(list);
        int i = 0;
        Iterator<q> it = this.hZt.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bv ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            bGU();
        }
    }

    private void cJ(List<String> list) {
        if (!y.isEmpty(list)) {
            ArrayList<q> threadList = this.hZt.getThreadList();
            if (!y.isEmpty(threadList) && this.iwH.getListView() != null && this.iwH.getListView().getData() != null) {
                Iterator<q> it = threadList.iterator();
                List<q> data = this.iwH.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).dXg;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iul.d(next);
                                this.iwH.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cuy() {
        return this.iul;
    }

    private void bHj() {
        if (this.gUU == 0 && !this.iul.cU(this.hZt.getThreadListIds())) {
            if (this.hZt.getThreadList() == null || this.hZt.getThreadList().size() == 0) {
                this.iwH.bIk();
                return;
            } else {
                this.iwH.bIj();
                return;
            }
        }
        this.iwH.bIi();
    }

    public g cvz() {
        return this.iwH;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0209a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ae.checkCamera(getActivity().getApplicationContext())) {
                ao.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bsi().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void cpD() {
        if (this.iwG != null) {
            this.iwG.cpD();
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

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bKS() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hZN;
    }

    @Override // com.baidu.tieba.frs.as
    public void coM() {
        if (this.iwH != null && this.iwH.getListView() != null) {
            this.iwH.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bIh() {
        if (this.iwH != null) {
            coM();
            this.iwH.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iav.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sh(int i) {
        return this.iav.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hZt != null) {
            i = this.hZt.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.i.zh(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.au
    public void bly() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bBN().DG("page_frs_good");
            pc(true);
            return;
        }
        this.iwH.ki(false);
    }

    @Override // com.baidu.tieba.frs.au
    public void blz() {
        com.baidu.tieba.s.c.dzC().b(getUniqueId(), false);
    }
}
