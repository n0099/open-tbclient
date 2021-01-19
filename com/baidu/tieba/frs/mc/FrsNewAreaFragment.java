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
    private VoiceManager jaA;
    private com.baidu.tbadk.l.c jgO;
    private boolean jjD;
    private String jxC;
    private FrsLoadMoreModel jxF;
    private FrsNewAreaModelController jzZ;
    private String jat = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData jaa = new FrsViewData();
    public long iDg = -1;
    public long fHa = 0;
    public long fHj = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected g jAa = null;
    private int hSE = -1;
    private int jjB = 3;
    private boolean ixq = false;
    private boolean jxI = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jba = new SparseArray<>();
    private int dTc = 0;
    private int jby = 0;
    private CustomMessageListener jee = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.jgO != null && FrsNewAreaFragment.this.jgO.isViewAttached()) {
                FrsNewAreaFragment.this.jgO.rh(num.intValue());
            }
        }
    };
    private Runnable jxJ = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.ixq) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.rg(false);
            }
        }
    };
    private CustomMessageListener jxK = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bz)) {
                bz bzVar = (bz) customResponsedMessage.getData();
                FrsNewAreaFragment.this.jxC = bzVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.jxC) && bzVar.bni() != null) {
                    FrsNewAreaFragment.this.zL(bzVar.bni().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener jbN = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.getListView() != null) {
                        FrsNewAreaFragment.this.getListView().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.jgO != null && FrsNewAreaFragment.this.jgO.isViewAttached()) {
                        FrsNewAreaFragment.this.rg(false);
                    } else if (FrsNewAreaFragment.this.jAa != null) {
                        FrsNewAreaFragment.this.jAa.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s jcg = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long jxN = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void yq(int i) {
            if (!FrsNewAreaFragment.this.jxI) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.jAa.cCv();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.jAa.lQ(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<com.baidu.adp.widget.ListView.n> a2;
            if (FrsNewAreaFragment.this.jxI) {
                if (FrsNewAreaFragment.this.cIE().cHO() == null) {
                    FrsNewAreaFragment.this.jxI = false;
                    return;
                } else if (FrsNewAreaFragment.this.cIE().cHO().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.jxI = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jxN = 1L;
            } else if (fVar.isSuccess) {
                this.jxN = 0L;
            } else {
                this.jxN = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.jxF.resetData();
            }
            FrsNewAreaFragment.this.jAa.lQ(false);
            if (FrsNewAreaFragment.this.cIE().cHO() != null) {
                FrsNewAreaFragment.this.jaa = FrsNewAreaFragment.this.cIE().cHO();
            }
            FrsNewAreaFragment.this.hSE = FrsNewAreaFragment.this.jaa.getPage().bmm();
            if (FrsNewAreaFragment.this.hSE == 0 && (FrsNewAreaFragment.this.jaa.getThreadListIds() == null || FrsNewAreaFragment.this.jaa.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.jaa.getThreadList() == null || FrsNewAreaFragment.this.jaa.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.jAa.bRO();
                } else {
                    FrsNewAreaFragment.this.jAa.Vp();
                }
            } else {
                FrsNewAreaFragment.this.jAa.Vo();
            }
            if (i == 4) {
                ArrayList<com.baidu.adp.widget.ListView.n> a3 = FrsNewAreaFragment.this.jxF.a(false, false, false, FrsNewAreaFragment.this.jaa.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsNewAreaFragment.this.jaa.setThreadList(a3);
                    FrsNewAreaFragment.this.jAa.a(a3, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.jaa, FrsNewAreaFragment.this.hSE);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.jAa.cCv();
                    break;
                case 2:
                    FrsNewAreaFragment.this.jAa.cCv();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.jaa.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.jxN != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                FrsNewAreaFragment.this.Vq();
                if (FrsNewAreaFragment.this.jaa != null) {
                    FrsNewAreaFragment.this.jat = FrsNewAreaFragment.this.jaa.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.jaa.getForum().getId();
                    FrsNewAreaFragment.this.jAa.b(FrsNewAreaFragment.this.jaa.getForum(), FrsNewAreaFragment.this.jaa.getUserData());
                }
                if (FrsNewAreaFragment.this.jaa != null) {
                    FrsNewAreaFragment.this.jaa.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.jaa == null || FrsNewAreaFragment.this.jaa.getThreadList() == null || FrsNewAreaFragment.this.jaa.getThreadList().size() != 0 || FrsNewAreaFragment.this.cIE().getType() != 4) {
                    if (FrsNewAreaFragment.this.jaa != null && (a2 = FrsNewAreaFragment.this.jxF.a(false, false, true, FrsNewAreaFragment.this.jaa.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsNewAreaFragment.this.jaa.setThreadList(a2);
                    }
                    FrsNewAreaFragment.this.cBC();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.l(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.iDg > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.iDg, FrsNewAreaFragment.this.cIE().cvr() - FrsNewAreaFragment.this.iDg, FrsNewAreaFragment.this.cIE().cvp(), FrsNewAreaFragment.this.cIE().cvq(), currentTimeMillis2 - FrsNewAreaFragment.this.cIE().cvo());
                        FrsNewAreaFragment.this.iDg = -1L;
                    }
                    FrsNewAreaFragment.this.fHj = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.iDg > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.iDg, FrsNewAreaFragment.this.cIE().cvr() - FrsNewAreaFragment.this.iDg, FrsNewAreaFragment.this.cIE().cvp(), FrsNewAreaFragment.this.cIE().cvq(), currentTimeMillis3 - FrsNewAreaFragment.this.cIE().cvo());
                FrsNewAreaFragment.this.iDg = -1L;
            }
            FrsNewAreaFragment.this.fHj = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cBw() {
        }
    };
    private final CustomMessageListener eHt = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.jAa != null) {
                FrsNewAreaFragment.this.jAa.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                com.baidu.tieba.card.s.crj().pr(true);
                com.baidu.tieba.s.c.dKg().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.jby += i2;
            if (FrsNewAreaFragment.this.jby >= FrsNewAreaFragment.this.dTc * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener fqC = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
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
    private w jcn = new w() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && nVar != null && (nVar instanceof by)) {
                bz bzVar = ((by) nVar).eHK;
                if (bzVar.boz() == null || bzVar.boz().getGroup_id() == 0 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bzVar.bok() != 1 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.SD(bzVar.getId())) {
                            readThreadHistory.SC(bzVar.getId());
                            if (FrsNewAreaFragment.this.jAa != null) {
                                FrsNewAreaFragment.this.jAa.cCv();
                            }
                        }
                        boolean z = false;
                        final String bnD = bzVar.bnD();
                        if (bnD != null && !bnD.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    z zVar = new z(bnD);
                                    zVar.brX().bsG().mIsNeedAddCommenParam = false;
                                    zVar.brX().bsG().mIsUseCurrentBDUSS = false;
                                    zVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bzVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bzVar.bns() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.bsB().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bzVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bzVar, FrsNewAreaFragment.this.jat, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bzVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.jaa != null && FrsNewAreaFragment.this.jaa.getForum() != null) {
                            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
                            bVar.jBG = FrsNewAreaFragment.this.jaa.needLog == 1;
                            bVar.jBI = FrsNewAreaFragment.this.jaa.getForum().getId();
                            bVar.jBH = FrsNewAreaFragment.this.jzZ.cIs();
                            if (com.baidu.tieba.frs.b.d.jkJ != null) {
                                bVar.jBJ = com.baidu.tieba.frs.b.d.jkJ.jBJ;
                                bVar.jBK = com.baidu.tieba.frs.b.d.jkJ.jBK;
                            }
                            com.baidu.tieba.frs.b.a.a(bzVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar, FrsNewAreaFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };

    static /* synthetic */ int l(FrsNewAreaFragment frsNewAreaFragment) {
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
            this.jzZ.ap(bzVar);
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.jaa = frsViewData;
            hideLoadingView(this.jAa.cmp());
            if (this.jAa != null) {
                this.jAa.lQ(false);
                this.jAa.a(null, this.mPn, this.jaa, this.hSE);
            }
        }
    }

    private void showLoadingView() {
        this.jAa.qL(false);
        showLoadingView(this.jAa.cmp(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jAa.qL(true);
        hideLoadingView(this.jAa.cmp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.jAa.qL(false);
        this.jAa.qK(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jAa.bRO();
        this.jAa.getListView().getData().clear();
        this.jAa.cCv();
        if (this.jgO == null) {
            this.jgO = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jgO.setTitle(null);
            this.jgO.setButtonText(null);
            this.jgO.showRefreshButton();
            this.jgO.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.jgO.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.jgO.setSubText(null);
        }
        this.jgO.onChangeSkinType();
        this.jgO.attachView(this.jAa.cmp(), true);
        registerListener(this.jee);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq() {
        this.jAa.qL(true);
        this.jAa.qK(true);
        if (this.jgO != null && this.jgO.isViewAttached()) {
            this.jgO.dettachView(this.jAa.cmp());
        }
        MessageManager.getInstance().unRegisterListener(this.jee);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rg(boolean z) {
        this.ixq = true;
        cBI();
        Vq();
        if (!z) {
            Vq();
            showLoadingView();
        }
        this.jzZ.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iDg = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.iDg = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
            this.jjD = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
        }
        this.beginTime = System.currentTimeMillis();
        this.fHa = this.beginTime - this.iDg;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dKg().z(getUniqueId());
        this.jzZ = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.jzZ.aj(arguments);
        } else if (bundle != null) {
            this.jzZ.aj(bundle);
        } else {
            this.jzZ.aj(null);
        }
        this.jaA = getVoiceManager();
        this.jaA.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eHt);
        registerListener(this.jxK);
        registerListener(this.jbN);
        this.jxF = new FrsLoadMoreModel(this, null);
        this.jxF.registerListener();
        this.jxF.setPageType(3);
        this.jxF.ri(true);
        this.jxF.setFunAdController(com.baidu.tieba.funad.a.rC(this.jjD));
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dTc = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jAa = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.ixq) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                rg(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bsu();
    }

    private void bsu() {
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13008");
        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dW("fid", this.forumId);
        aqVar.an("obj_type", 6);
        aqVar.an("obj_locate", 2);
        aqVar.bsu();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.jaA = getVoiceManager();
        this.jaA.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cHD();
        if (bundle != null) {
            this.jat = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.jat = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cHD() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fqC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.jAa != null) {
            this.jAa.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jee);
        com.baidu.tieba.s.c.dKg().A(getUniqueId());
        com.baidu.tieba.card.s.crj().pr(false);
        super.onDestroy();
        this.jzZ.cHM();
        this.jaA = getVoiceManager();
        this.jaA.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jxJ);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jat);
        bundle.putString("from", this.mFrom);
        this.jzZ.onSaveInstanceState(bundle);
        this.jaA = getVoiceManager();
        if (this.jaA != null) {
            this.jaA.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bz threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jAa.cIG().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.jaa.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.nk(intent.getIntExtra("good_data", 0));
                            threadDataById.box();
                            rg(false);
                            return;
                        } else if (intExtra == 0) {
                            this.jaa.removeThreadData(threadDataById);
                            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jaa.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jAa.cHI();
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
            if (this.jjB == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.ixq) {
                com.baidu.adp.lib.f.e.mB().post(this.jxJ);
            }
        }
        cDM();
    }

    private void cDM() {
        if (isPrimary()) {
            if (this.jgO != null && this.jgO.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jee);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jee);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jAa != null) {
            this.jAa.cCv();
        }
        this.jaA = getVoiceManager();
        this.jaA.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jAa.a(this.jcn);
        this.jAa.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jjB != 3 || this.jAa != null) {
            this.jjB = i;
            super.onChangeSkinType(i);
            if (this.jAa != null) {
                this.jAa.onChangeSkinType(i);
            }
            if (this.jgO != null && this.jgO.isViewAttached()) {
                this.jgO.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cAu() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cAu();
        }
        return null;
    }

    private void cBB() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mC().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Sx(FrsNewAreaFragment.this.jat);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBC() {
        cBI();
        try {
            if (this.jaa != null) {
                this.jAa.cDW();
                this.jAa.bXh();
                this.jat = this.jaa.getForum().getName();
                this.forumId = this.jaa.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.jaa.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jaa.getUserData().getBimg_end_time());
                cBB();
                ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jaa.getThreadList();
                if (threadList != null) {
                    this.jAa.a(threadList, this.mPn, this.jaa, this.jaa.getPage().bmm());
                    cHF();
                    this.jAa.cHI();
                    if (this.jaa.getIsNewUrl() == 1) {
                        this.jAa.cIG().setFromCDN(true);
                    } else {
                        this.jAa.cIG().setFromCDN(false);
                    }
                    this.jAa.setListViewSelection(cA(cIE().getType(), this.mPn));
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
        this.jaA = getVoiceManager();
        this.jaA.onPause(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.crj().pr(false);
        com.baidu.tieba.s.c.dKg().b(getUniqueId(), false);
        if (this.jaa != null && this.jaa.getForum() != null) {
            com.baidu.tbadk.distribute.a.bAC().b(getPageContext().getPageActivity(), "frs", this.jaa.getForum().getId(), 0L);
        }
        this.jaA = getVoiceManager();
        if (this.jaA != null) {
            this.jaA.onStop(getPageContext());
        }
    }

    public void cEu() {
        if (this.jAa != null && this.jAa.getListView() != null) {
            this.jAa.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsNewAreaFragment.this.jAa != null && FrsNewAreaFragment.this.jAa.getListView() != null && !FrsNewAreaFragment.this.jAa.getListView().isComputingLayout()) {
                        FrsNewAreaFragment.this.jAa.refreshView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zL(int i) {
        ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jaa.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof by) {
                    bz bzVar = ((by) next).eHK;
                    if (bzVar.getId() != null && bzVar.getId().equals(this.jxC)) {
                        c(bzVar, i);
                        this.jxC = null;
                        break;
                    }
                }
            }
            this.jAa.cIG().b(threadList, this.jaa);
            this.jAa.cIG().notifyDataSetChanged();
        }
    }

    private void c(bz bzVar, int i) {
        if (i == 1) {
            PraiseData bni = bzVar.bni();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bni == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bzVar.a(praiseData);
                    return;
                }
                bzVar.bni().getUser().add(0, metaData);
                bzVar.bni().setNum(bzVar.bni().getNum() + 1);
                bzVar.bni().setIsLike(i);
            }
        } else if (bzVar.bni() != null) {
            bzVar.bni().setIsLike(i);
            bzVar.bni().setNum(bzVar.bni().getNum() - 1);
            ArrayList<MetaData> user = bzVar.bni().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bzVar.bni().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jaA == null) {
            this.jaA = VoiceManager.instance();
        }
        return this.jaA;
    }

    public BdTypeRecyclerView getListView() {
        if (this.jAa == null) {
            return null;
        }
        return this.jAa.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cBI() {
        this.jaA = getVoiceManager();
        this.jaA.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> bus() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bus();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.jaa != null && this.jAa != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jAa.cCv();
            }
        }
    }

    private void cHF() {
        HashMap<Integer, bz> cFf;
        if (this.jAa != null && this.jAa.cIG() != null && (cFf = this.jAa.cIG().cFf()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bz> entry : cFf.entrySet()) {
                bz value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bAI().G(arrayList);
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
            rg(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cBN() {
        return this.jaa;
    }

    public FrsNewAreaModelController cIE() {
        return this.jzZ;
    }

    public void Kk(String str) {
        this.jat = str;
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

    public void bQy() {
        if (!this.jxF.isLoading && !this.jzZ.isLoading()) {
            if (this.jxF.dF(this.jaa.getThreadListIds())) {
                this.jAa.a(this.jxF.cIb(), this.mPn, this.jaa, 0);
                this.jxF.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.jaa.getThreadListIds(), this.jat, this.mPn, this.jaa.isBrandForum);
            } else if (this.hSE != 0) {
                this.jAa.a(this.jxF.cIb(), this.mPn, this.jaa, 0);
                this.mPn++;
                this.jzZ.zN(this.mPn);
                this.jxF.loadingDone = false;
                this.jxF.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.jAa.bRO();
        } else if (!this.jAa.cCE()) {
            if (!this.jzZ.cHQ()) {
                this.jAa.bRO();
                return;
            }
            bQN();
            bQy();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bQN();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void au(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        bQN();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jxF.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.jaa.setThreadList(a2);
                this.jAa.a(a2, this.mPn, this.jaa, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jaa.getForum()));
        }
    }

    public void dG(List<String> list) {
        m34do(list);
        int i = 0;
        Iterator<com.baidu.adp.widget.ListView.n> it = this.jaa.getThreadList().iterator();
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
            bQy();
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m34do(List<String> list) {
        if (!x.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jaa.getThreadList();
            if (!x.isEmpty(threadList) && this.jAa.getListView() != null && this.jAa.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jAa.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.n next = it.next();
                    if (next instanceof by) {
                        bz bzVar = ((by) next).eHK;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!at.equals(list.get(i2), bzVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jxF.d(next);
                                this.jAa.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cHE() {
        return this.jxF;
    }

    private void bQN() {
        if (this.hSE == 0 && !this.jxF.dF(this.jaa.getThreadListIds())) {
            if (this.jaa.getThreadList() == null || this.jaa.getThreadList().size() == 0) {
                this.jAa.bRO();
                return;
            } else {
                this.jAa.Vp();
                return;
            }
        }
        this.jAa.Vo();
    }

    public g cIF() {
        return this.jAa;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.l.a.a.InterfaceC0148a
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
        com.baidu.tbadk.distribute.a.bAC().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.p
    public void cBH() {
        if (this.jzZ != null) {
            this.jzZ.cBH();
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
    public NavigationBar bUz() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jat;
    }

    @Override // com.baidu.tieba.frs.ao
    public void cAO() {
        if (this.jAa != null && this.jAa.getListView() != null) {
            this.jAa.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bRN() {
        if (this.jAa != null) {
            cAO();
            this.jAa.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jba.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sH(int i) {
        return this.jba.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.jaa != null) {
            i = this.jaa.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.d.j.Al(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.aq
    public void btS() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bKv().DZ("page_frs_good");
            rg(true);
            return;
        }
        this.jAa.lQ(false);
    }

    @Override // com.baidu.tieba.frs.aq
    public void btT() {
        com.baidu.tieba.s.c.dKg().b(getUniqueId(), false);
    }
}
