package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.w;
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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.recapp.p;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.a, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ao, ap, aq, com.baidu.tieba.frs.loadmore.a, p, FrsCommonImageLayout.c {
    private String jCi;
    private FrsLoadMoreModel jCl;
    private FrsNewAreaModelController jEF;
    private VoiceManager jfh;
    private com.baidu.tbadk.l.c jlv;
    private boolean jok;
    private String jfa = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData jeH = new FrsViewData();
    public long iHN = -1;
    public long fLH = 0;
    public long fLQ = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected g jEG = null;
    private int hXl = -1;
    private int joi = 3;
    private boolean iBX = false;
    private boolean jCo = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jfH = new SparseArray<>();
    private int dXO = 0;
    private int jgf = 0;
    private CustomMessageListener jiM = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.jlv != null && FrsNewAreaFragment.this.jlv.isViewAttached()) {
                FrsNewAreaFragment.this.jlv.sN(num.intValue());
            }
        }
    };
    private Runnable jCp = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.iBX) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.rk(false);
            }
        }
    };
    private CustomMessageListener jCq = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bz)) {
                bz bzVar = (bz) customResponsedMessage.getData();
                FrsNewAreaFragment.this.jCi = bzVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.jCi) && bzVar.brb() != null) {
                    FrsNewAreaFragment.this.Br(bzVar.brb().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener jgu = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.getListView() != null) {
                        FrsNewAreaFragment.this.getListView().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.jlv != null && FrsNewAreaFragment.this.jlv.isViewAttached()) {
                        FrsNewAreaFragment.this.rk(false);
                    } else if (FrsNewAreaFragment.this.jEG != null) {
                        FrsNewAreaFragment.this.jEG.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s jgN = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long jCt = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void zW(int i) {
            if (!FrsNewAreaFragment.this.jCo) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.jEG.cGm();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.jEG.lU(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<com.baidu.adp.widget.ListView.n> a2;
            if (FrsNewAreaFragment.this.jCo) {
                if (FrsNewAreaFragment.this.cMv().cLF() == null) {
                    FrsNewAreaFragment.this.jCo = false;
                    return;
                } else if (FrsNewAreaFragment.this.cMv().cLF().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.jCo = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jCt = 1L;
            } else if (fVar.isSuccess) {
                this.jCt = 0L;
            } else {
                this.jCt = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.jCl.resetData();
            }
            FrsNewAreaFragment.this.jEG.lU(false);
            if (FrsNewAreaFragment.this.cMv().cLF() != null) {
                FrsNewAreaFragment.this.jeH = FrsNewAreaFragment.this.cMv().cLF();
            }
            FrsNewAreaFragment.this.hXl = FrsNewAreaFragment.this.jeH.getPage().bqf();
            if (FrsNewAreaFragment.this.hXl == 0 && (FrsNewAreaFragment.this.jeH.getThreadListIds() == null || FrsNewAreaFragment.this.jeH.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.jeH.getThreadList() == null || FrsNewAreaFragment.this.jeH.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.jEG.bVF();
                } else {
                    FrsNewAreaFragment.this.jEG.Zh();
                }
            } else {
                FrsNewAreaFragment.this.jEG.Zg();
            }
            if (i == 4) {
                ArrayList<com.baidu.adp.widget.ListView.n> a3 = FrsNewAreaFragment.this.jCl.a(false, false, false, FrsNewAreaFragment.this.jeH.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsNewAreaFragment.this.jeH.setThreadList(a3);
                    FrsNewAreaFragment.this.jEG.a(a3, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.jeH, FrsNewAreaFragment.this.hXl);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.jEG.cGm();
                    break;
                case 2:
                    FrsNewAreaFragment.this.jEG.cGm();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.jeH.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.jCt != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.jeH != null) {
                    FrsNewAreaFragment.this.jfa = FrsNewAreaFragment.this.jeH.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.jeH.getForum().getId();
                    FrsNewAreaFragment.this.jEG.b(FrsNewAreaFragment.this.jeH.getForum(), FrsNewAreaFragment.this.jeH.getUserData());
                }
                if (FrsNewAreaFragment.this.jeH != null) {
                    FrsNewAreaFragment.this.jeH.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.jeH == null || FrsNewAreaFragment.this.jeH.getThreadList() == null || FrsNewAreaFragment.this.jeH.getThreadList().size() != 0 || FrsNewAreaFragment.this.cMv().getType() != 4) {
                    if (FrsNewAreaFragment.this.jeH != null && (a2 = FrsNewAreaFragment.this.jCl.a(false, false, true, FrsNewAreaFragment.this.jeH.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsNewAreaFragment.this.jeH.setThreadList(a2);
                    }
                    FrsNewAreaFragment.this.cFt();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.iHN > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.iHN, FrsNewAreaFragment.this.cMv().czi() - FrsNewAreaFragment.this.iHN, FrsNewAreaFragment.this.cMv().czg(), FrsNewAreaFragment.this.cMv().czh(), currentTimeMillis2 - FrsNewAreaFragment.this.cMv().czf());
                        FrsNewAreaFragment.this.iHN = -1L;
                    }
                    FrsNewAreaFragment.this.fLQ = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.iHN > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.iHN, FrsNewAreaFragment.this.cMv().czi() - FrsNewAreaFragment.this.iHN, FrsNewAreaFragment.this.cMv().czg(), FrsNewAreaFragment.this.cMv().czh(), currentTimeMillis3 - FrsNewAreaFragment.this.cMv().czf());
                FrsNewAreaFragment.this.iHN = -1L;
            }
            FrsNewAreaFragment.this.fLQ = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cFn() {
        }
    };
    private final CustomMessageListener eMe = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.jEG != null) {
                FrsNewAreaFragment.this.jEG.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                com.baidu.tieba.card.s.cva().pv(true);
                com.baidu.tieba.s.c.dNX().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.jgf += i2;
            if (FrsNewAreaFragment.this.jgf >= FrsNewAreaFragment.this.dXO * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener fvn = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
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
    private w jgU = new w() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && nVar != null && (nVar instanceof by)) {
                bz bzVar = ((by) nVar).eMv;
                if (bzVar.bss() == null || bzVar.bss().getGroup_id() == 0 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bzVar.bsd() != 1 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.TL(bzVar.getId())) {
                            readThreadHistory.TK(bzVar.getId());
                            if (FrsNewAreaFragment.this.jEG != null) {
                                FrsNewAreaFragment.this.jEG.cGm();
                            }
                        }
                        boolean z = false;
                        final String brw = bzVar.brw();
                        if (brw != null && !brw.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    z zVar = new z(brw);
                                    zVar.bvQ().bwz().mIsNeedAddCommenParam = false;
                                    zVar.bvQ().bwz().mIsUseCurrentBDUSS = false;
                                    zVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bzVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bzVar.brl() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.bwu().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bzVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bzVar, FrsNewAreaFragment.this.jfa, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bzVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.jeH != null && FrsNewAreaFragment.this.jeH.getForum() != null) {
                            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
                            bVar.jGm = FrsNewAreaFragment.this.jeH.needLog == 1;
                            bVar.jGo = FrsNewAreaFragment.this.jeH.getForum().getId();
                            bVar.jGn = FrsNewAreaFragment.this.jEF.cMj();
                            if (com.baidu.tieba.frs.b.d.jpq != null) {
                                bVar.jGp = com.baidu.tieba.frs.b.d.jpq.jGp;
                                bVar.jGq = com.baidu.tieba.frs.b.d.jpq.jGq;
                            }
                            com.baidu.tieba.frs.b.a.a(bzVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar, FrsNewAreaFragment.this.getTbPageTag());
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
    public /* bridge */ /* synthetic */ com.baidu.adp.base.f getPageContext() {
        return super.getPageContext();
    }

    public void ap(bz bzVar) {
        if (bzVar != null) {
            this.jEF.ap(bzVar);
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.jeH = frsViewData;
            hideLoadingView(this.jEG.cqg());
            if (this.jEG != null) {
                this.jEG.lU(false);
                this.jEG.a(null, this.mPn, this.jeH, this.hXl);
            }
        }
    }

    private void showLoadingView() {
        this.jEG.qP(false);
        showLoadingView(this.jEG.cqg(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jEG.qP(true);
        hideLoadingView(this.jEG.cqg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.jEG.qP(false);
        this.jEG.qO(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jEG.bVF();
        this.jEG.getListView().getData().clear();
        this.jEG.cGm();
        if (this.jlv == null) {
            this.jlv = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jlv.setTitle(null);
            this.jlv.setButtonText(null);
            this.jlv.showRefreshButton();
            this.jlv.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.jlv.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.jlv.setSubText(null);
        }
        this.jlv.onChangeSkinType();
        this.jlv.attachView(this.jEG.cqg(), true);
        registerListener(this.jiM);
    }

    private void Zi() {
        this.jEG.qP(true);
        this.jEG.qO(true);
        if (this.jlv != null && this.jlv.isViewAttached()) {
            this.jlv.dettachView(this.jEG.cqg());
        }
        MessageManager.getInstance().unRegisterListener(this.jiM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(boolean z) {
        this.iBX = true;
        cFz();
        Zi();
        if (!z) {
            Zi();
            showLoadingView();
        }
        this.jEF.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iHN = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.iHN = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
            this.jok = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
        }
        this.beginTime = System.currentTimeMillis();
        this.fLH = this.beginTime - this.iHN;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dNX().z(getUniqueId());
        this.jEF = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.jEF.aj(arguments);
        } else if (bundle != null) {
            this.jEF.aj(bundle);
        } else {
            this.jEF.aj(null);
        }
        this.jfh = getVoiceManager();
        this.jfh.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eMe);
        registerListener(this.jCq);
        registerListener(this.jgu);
        this.jCl = new FrsLoadMoreModel(this, null);
        this.jCl.registerListener();
        this.jCl.setPageType(3);
        this.jCl.rm(true);
        this.jCl.setFunAdController(com.baidu.tieba.funad.a.rG(this.jok));
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dXO = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jEG = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.iBX) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                rk(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bwn();
    }

    private void bwn() {
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13008");
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dX("fid", this.forumId);
        aqVar.an("obj_type", 6);
        aqVar.an("obj_locate", 2);
        aqVar.bwn();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.jfh = getVoiceManager();
        this.jfh.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cLu();
        if (bundle != null) {
            this.jfa = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.jfa = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cLu() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fvn);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.jEG != null) {
            this.jEG.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jiM);
        com.baidu.tieba.s.c.dNX().A(getUniqueId());
        com.baidu.tieba.card.s.cva().pv(false);
        super.onDestroy();
        this.jEF.cLD();
        this.jfh = getVoiceManager();
        this.jfh.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jCp);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jfa);
        bundle.putString("from", this.mFrom);
        this.jEF.onSaveInstanceState(bundle);
        this.jfh = getVoiceManager();
        if (this.jfh != null) {
            this.jfh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bz threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jEG.cMx().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.jeH.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.oQ(intent.getIntExtra("good_data", 0));
                            threadDataById.bsq();
                            rk(false);
                            return;
                        } else if (intExtra == 0) {
                            this.jeH.removeThreadData(threadDataById);
                            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jeH.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jEG.cLz();
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
            if (this.joi == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.iBX) {
                com.baidu.adp.lib.f.e.mB().post(this.jCp);
            }
        }
        cHD();
    }

    private void cHD() {
        if (isPrimary()) {
            if (this.jlv != null && this.jlv.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jiM);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jiM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jEG != null) {
            this.jEG.cGm();
        }
        this.jfh = getVoiceManager();
        this.jfh.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jEG.a(this.jgU);
        this.jEG.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.joi != 3 || this.jEG != null) {
            this.joi = i;
            super.onChangeSkinType(i);
            if (this.jEG != null) {
                this.jEG.onChangeSkinType(i);
            }
            if (this.jlv != null && this.jlv.isViewAttached()) {
                this.jlv.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cEl() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cEl();
        }
        return null;
    }

    private void cFs() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mC().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TF(FrsNewAreaFragment.this.jfa);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFt() {
        cFz();
        try {
            if (this.jeH != null) {
                this.jEG.cHN();
                this.jEG.caY();
                this.jfa = this.jeH.getForum().getName();
                this.forumId = this.jeH.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.jeH.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jeH.getUserData().getBimg_end_time());
                cFs();
                ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jeH.getThreadList();
                if (threadList != null) {
                    this.jEG.a(threadList, this.mPn, this.jeH, this.jeH.getPage().bqf());
                    cLw();
                    this.jEG.cLz();
                    if (this.jeH.getIsNewUrl() == 1) {
                        this.jEG.cMx().setFromCDN(true);
                    } else {
                        this.jEG.cMx().setFromCDN(false);
                    }
                    this.jEG.setListViewSelection(cA(cMv().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cA(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.jfh = getVoiceManager();
        this.jfh.onPause(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.cva().pv(false);
        com.baidu.tieba.s.c.dNX().b(getUniqueId(), false);
        if (this.jeH != null && this.jeH.getForum() != null) {
            com.baidu.tbadk.distribute.a.bEv().b(getPageContext().getPageActivity(), "frs", this.jeH.getForum().getId(), 0L);
        }
        this.jfh = getVoiceManager();
        if (this.jfh != null) {
            this.jfh.onStop(getPageContext());
        }
    }

    public void cIl() {
        if (this.jEG != null && this.jEG.getListView() != null) {
            this.jEG.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsNewAreaFragment.this.jEG != null && FrsNewAreaFragment.this.jEG.getListView() != null && !FrsNewAreaFragment.this.jEG.getListView().isComputingLayout()) {
                        FrsNewAreaFragment.this.jEG.refreshView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Br(int i) {
        ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jeH.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof by) {
                    bz bzVar = ((by) next).eMv;
                    if (bzVar.getId() != null && bzVar.getId().equals(this.jCi)) {
                        c(bzVar, i);
                        this.jCi = null;
                        break;
                    }
                }
            }
            this.jEG.cMx().b(threadList, this.jeH);
            this.jEG.cMx().notifyDataSetChanged();
        }
    }

    private void c(bz bzVar, int i) {
        if (i == 1) {
            PraiseData brb = bzVar.brb();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (brb == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bzVar.a(praiseData);
                    return;
                }
                bzVar.brb().getUser().add(0, metaData);
                bzVar.brb().setNum(bzVar.brb().getNum() + 1);
                bzVar.brb().setIsLike(i);
            }
        } else if (bzVar.brb() != null) {
            bzVar.brb().setIsLike(i);
            bzVar.brb().setNum(bzVar.brb().getNum() - 1);
            ArrayList<MetaData> user = bzVar.brb().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bzVar.brb().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jfh == null) {
            this.jfh = VoiceManager.instance();
        }
        return this.jfh;
    }

    public BdTypeRecyclerView getListView() {
        if (this.jEG == null) {
            return null;
        }
        return this.jEG.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cFz() {
        this.jfh = getVoiceManager();
        this.jfh.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> byl() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).byl();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.jeH != null && this.jEG != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jEG.cGm();
            }
        }
    }

    private void cLw() {
        HashMap<Integer, bz> cIW;
        if (this.jEG != null && this.jEG.cMx() != null && (cIW = this.jEG.cMx().cIW()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bz> entry : cIW.entrySet()) {
                bz value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bEB().L(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            rk(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cFE() {
        return this.jeH;
    }

    public FrsNewAreaModelController cMv() {
        return this.jEF;
    }

    public void Lv(String str) {
        this.jfa = str;
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

    public void bUp() {
        if (!this.jCl.isLoading && !this.jEF.isLoading()) {
            if (this.jCl.dF(this.jeH.getThreadListIds())) {
                this.jEG.a(this.jCl.cLS(), this.mPn, this.jeH, 0);
                this.jCl.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.jeH.getThreadListIds(), this.jfa, this.mPn, this.jeH.isBrandForum);
            } else if (this.hXl != 0) {
                this.jEG.a(this.jCl.cLS(), this.mPn, this.jeH, 0);
                this.mPn++;
                this.jEF.Bt(this.mPn);
                this.jCl.loadingDone = false;
                this.jCl.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.jEG.bVF();
        } else if (!this.jEG.cGv()) {
            if (!this.jEF.cLH()) {
                this.jEG.bVF();
                return;
            }
            bUE();
            bUp();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bUE();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void az(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        bUE();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jCl.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.jeH.setThreadList(a2);
                this.jEG.a(a2, this.mPn, this.jeH, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jeH.getForum()));
        }
    }

    public void dG(List<String> list) {
        m39do(list);
        int i = 0;
        Iterator<com.baidu.adp.widget.ListView.n> it = this.jeH.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof by ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            bUp();
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m39do(List<String> list) {
        if (!x.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jeH.getThreadList();
            if (!x.isEmpty(threadList) && this.jEG.getListView() != null && this.jEG.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jEG.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.n next = it.next();
                    if (next instanceof by) {
                        bz bzVar = ((by) next).eMv;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!at.equals(list.get(i2), bzVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jCl.d(next);
                                this.jEG.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cLv() {
        return this.jCl;
    }

    private void bUE() {
        if (this.hXl == 0 && !this.jCl.dF(this.jeH.getThreadListIds())) {
            if (this.jeH.getThreadList() == null || this.jeH.getThreadList().size() == 0) {
                this.jEG.bVF();
                return;
            } else {
                this.jEG.Zh();
                return;
            }
        }
        this.jEG.Zg();
    }

    public g cMw() {
        return this.jEG;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.n.a.a.InterfaceC0277a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ad.checkCamera(getActivity().getApplicationContext())) {
                an.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ad.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.p
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.p
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bEv().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.p
    public void cFy() {
        if (this.jEF != null) {
            this.jEF.cFy();
        }
    }

    @Override // com.baidu.tieba.recapp.p
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.p
    public int getPageNum() {
        return this.mPn;
    }

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bYq() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jfa;
    }

    @Override // com.baidu.tieba.frs.ao
    public void cEF() {
        if (this.jEG != null && this.jEG.getListView() != null) {
            this.jEG.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bVE() {
        if (this.jEG != null) {
            cEF();
            this.jEG.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jfH.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a un(int i) {
        return this.jfH.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.jeH != null) {
            i = this.jeH.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.d.j.BR(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxL() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bOm().Fl("page_frs_good");
            rk(true);
            return;
        }
        this.jEG.lU(false);
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxM() {
        com.baidu.tieba.s.c.dNX().b(getUniqueId(), false);
    }
}
