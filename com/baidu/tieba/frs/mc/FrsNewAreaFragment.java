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
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
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
    private String jDi;
    private FrsLoadMoreModel jDl;
    private FrsNewAreaModelController jFD;
    private VoiceManager jgg;
    private com.baidu.tbadk.l.c jmw;
    private boolean jpk;
    private String jfZ = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData jfG = new FrsViewData();
    public long iIQ = -1;
    public long fJl = 0;
    public long fJu = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected g jFE = null;
    private int hWZ = -1;
    private int jpi = 3;
    private boolean iDa = false;
    private boolean jDo = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jgG = new SparseArray<>();
    private int dVi = 0;
    private int jhe = 0;
    private CustomMessageListener jjL = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.jmw != null && FrsNewAreaFragment.this.jmw.isViewAttached()) {
                FrsNewAreaFragment.this.jmw.rm(num.intValue());
            }
        }
    };
    private Runnable jDp = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.iDa) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.rq(false);
            }
        }
    };
    private CustomMessageListener jDq = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof cb)) {
                cb cbVar = (cb) customResponsedMessage.getData();
                FrsNewAreaFragment.this.jDi = cbVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.jDi) && cbVar.bnB() != null) {
                    FrsNewAreaFragment.this.zV(cbVar.bnB().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener jht = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.getListView() != null) {
                        FrsNewAreaFragment.this.getListView().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.jmw != null && FrsNewAreaFragment.this.jmw.isViewAttached()) {
                        FrsNewAreaFragment.this.rq(false);
                    } else if (FrsNewAreaFragment.this.jFE != null) {
                        FrsNewAreaFragment.this.jFE.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s jhM = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long jDt = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void yA(int i) {
            if (!FrsNewAreaFragment.this.jDo) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.jFE.cDH();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.jFE.lU(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<com.baidu.adp.widget.ListView.n> a2;
            if (FrsNewAreaFragment.this.jDo) {
                if (FrsNewAreaFragment.this.cJR().cJb() == null) {
                    FrsNewAreaFragment.this.jDo = false;
                    return;
                } else if (FrsNewAreaFragment.this.cJR().cJb().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.jDo = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jDt = 1L;
            } else if (fVar.isSuccess) {
                this.jDt = 0L;
            } else {
                this.jDt = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.jDl.resetData();
            }
            FrsNewAreaFragment.this.jFE.lU(false);
            if (FrsNewAreaFragment.this.cJR().cJb() != null) {
                FrsNewAreaFragment.this.jfG = FrsNewAreaFragment.this.cJR().cJb();
            }
            FrsNewAreaFragment.this.hWZ = FrsNewAreaFragment.this.jfG.getPage().bmF();
            if (FrsNewAreaFragment.this.hWZ == 0 && (FrsNewAreaFragment.this.jfG.getThreadListIds() == null || FrsNewAreaFragment.this.jfG.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.jfG.getThreadList() == null || FrsNewAreaFragment.this.jfG.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.jFE.bSr();
                } else {
                    FrsNewAreaFragment.this.jFE.WY();
                }
            } else {
                FrsNewAreaFragment.this.jFE.WX();
            }
            if (i == 4) {
                ArrayList<com.baidu.adp.widget.ListView.n> a3 = FrsNewAreaFragment.this.jDl.a(false, false, false, FrsNewAreaFragment.this.jfG.getThreadList(), null);
                if (a3 != null) {
                    FrsNewAreaFragment.this.jfG.setThreadList(a3);
                    FrsNewAreaFragment.this.jFE.a(a3, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.jfG, FrsNewAreaFragment.this.hWZ);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.jFE.cDH();
                    break;
                case 2:
                    FrsNewAreaFragment.this.jFE.cDH();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.jfG.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.jDt != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                FrsNewAreaFragment.this.WZ();
                if (FrsNewAreaFragment.this.jfG != null) {
                    FrsNewAreaFragment.this.jfZ = FrsNewAreaFragment.this.jfG.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.jfG.getForum().getId();
                    FrsNewAreaFragment.this.jFE.b(FrsNewAreaFragment.this.jfG.getForum(), FrsNewAreaFragment.this.jfG.getUserData());
                }
                if (FrsNewAreaFragment.this.jfG != null) {
                    FrsNewAreaFragment.this.jfG.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.jfG == null || FrsNewAreaFragment.this.jfG.getThreadList() == null || FrsNewAreaFragment.this.jfG.getThreadList().size() != 0 || FrsNewAreaFragment.this.cJR().getType() != 4) {
                    if (FrsNewAreaFragment.this.jfG != null && (a2 = FrsNewAreaFragment.this.jDl.a(false, false, true, FrsNewAreaFragment.this.jfG.getThreadList(), null)) != null && a2.size() > 0) {
                        FrsNewAreaFragment.this.jfG.setThreadList(a2);
                    }
                    FrsNewAreaFragment.this.cCO();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.l(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.iIQ > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.iIQ, FrsNewAreaFragment.this.cJR().cwD() - FrsNewAreaFragment.this.iIQ, FrsNewAreaFragment.this.cJR().cwB(), FrsNewAreaFragment.this.cJR().cwC(), currentTimeMillis2 - FrsNewAreaFragment.this.cJR().cwA());
                        FrsNewAreaFragment.this.iIQ = -1L;
                    }
                    FrsNewAreaFragment.this.fJu = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.iIQ > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.iIQ, FrsNewAreaFragment.this.cJR().cwD() - FrsNewAreaFragment.this.iIQ, FrsNewAreaFragment.this.cJR().cwB(), FrsNewAreaFragment.this.cJR().cwC(), currentTimeMillis3 - FrsNewAreaFragment.this.cJR().cwA());
                FrsNewAreaFragment.this.iIQ = -1L;
            }
            FrsNewAreaFragment.this.fJu = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCI() {
        }
    };
    private final CustomMessageListener eJz = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.jFE != null) {
                FrsNewAreaFragment.this.jFE.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                t.csu().pB(true);
                com.baidu.tieba.s.c.dMr().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.jhe += i2;
            if (FrsNewAreaFragment.this.jhe >= FrsNewAreaFragment.this.dVi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener fsV = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
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
    private w jhT = new w() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && nVar != null && (nVar instanceof ca)) {
                cb cbVar = ((ca) nVar).eJQ;
                if (cbVar.boR() == null || cbVar.boR().getGroup_id() == 0 || bh.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (cbVar.boC() != 1 || bh.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.TA(cbVar.getId())) {
                            readThreadHistory.Tz(cbVar.getId());
                            if (FrsNewAreaFragment.this.jFE != null) {
                                FrsNewAreaFragment.this.jFE.cDH();
                            }
                        }
                        boolean z = false;
                        final String bnW = cbVar.bnW();
                        if (bnW != null && !bnW.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(bnW);
                                    aaVar.bsr().bta().mIsNeedAddCommenParam = false;
                                    aaVar.bsr().bta().mIsUseCurrentBDUSS = false;
                                    aaVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = cbVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (cbVar.bnL() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bf.bsV().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            cbVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(cbVar, FrsNewAreaFragment.this.jfZ, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(cbVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.jfG != null && FrsNewAreaFragment.this.jfG.getForum() != null) {
                            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
                            bVar.jHk = FrsNewAreaFragment.this.jfG.needLog == 1;
                            bVar.jHm = FrsNewAreaFragment.this.jfG.getForum().getId();
                            bVar.jHl = FrsNewAreaFragment.this.jFD.cJF();
                            if (com.baidu.tieba.frs.b.d.jqq != null) {
                                bVar.jHn = com.baidu.tieba.frs.b.d.jqq.jHn;
                                bVar.jHo = com.baidu.tieba.frs.b.d.jqq.jHo;
                            }
                            com.baidu.tieba.frs.b.a.a(cbVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar, FrsNewAreaFragment.this.getTbPageTag());
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

    public void aq(cb cbVar) {
        if (cbVar != null) {
            this.jFD.aq(cbVar);
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.jfG = frsViewData;
            hideLoadingView(this.jFE.cnn());
            if (this.jFE != null) {
                this.jFE.lU(false);
                this.jFE.a(null, this.mPn, this.jfG, this.hWZ);
            }
        }
    }

    private void showLoadingView() {
        this.jFE.qV(false);
        showLoadingView(this.jFE.cnn(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jFE.qV(true);
        hideLoadingView(this.jFE.cnn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.jFE.qV(false);
        this.jFE.qU(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jFE.bSr();
        this.jFE.getListView().getData().clear();
        this.jFE.cDH();
        if (this.jmw == null) {
            this.jmw = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jmw.setTitle(null);
            this.jmw.setButtonText(null);
            this.jmw.showRefreshButton();
            this.jmw.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.jmw.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.jmw.setSubText(null);
        }
        this.jmw.onChangeSkinType();
        this.jmw.attachView(this.jFE.cnn(), true);
        registerListener(this.jjL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        this.jFE.qV(true);
        this.jFE.qU(true);
        if (this.jmw != null && this.jmw.isViewAttached()) {
            this.jmw.dettachView(this.jFE.cnn());
        }
        MessageManager.getInstance().unRegisterListener(this.jjL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(boolean z) {
        this.iDa = true;
        cCU();
        WZ();
        if (!z) {
            WZ();
            showLoadingView();
        }
        this.jFD.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iIQ = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.iIQ = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
            this.jpk = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
        }
        this.beginTime = System.currentTimeMillis();
        this.fJl = this.beginTime - this.iIQ;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMr().A(getUniqueId());
        this.jFD = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.jFD.aj(arguments);
        } else if (bundle != null) {
            this.jFD.aj(bundle);
        } else {
            this.jFD.aj(null);
        }
        this.jgg = getVoiceManager();
        this.jgg.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eJz);
        registerListener(this.jDq);
        registerListener(this.jht);
        this.jDl = new FrsLoadMoreModel(this, null);
        this.jDl.registerListener();
        this.jDl.setPageType(3);
        this.jDl.rs(true);
        this.jDl.setFunAdController(com.baidu.tieba.funad.a.rM(this.jpk));
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dVi = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jFE = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.iDa) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                rq(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bsO();
    }

    private void bsO() {
        ar arVar = new ar("c13008");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("fid", this.forumId);
        arVar.ap("obj_type", 6);
        arVar.ap("obj_locate", 2);
        arVar.bsO();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.jgg = getVoiceManager();
        this.jgg.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cIQ();
        if (bundle != null) {
            this.jfZ = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.jfZ = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cIQ() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fsV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.jFE != null) {
            this.jFE.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jjL);
        com.baidu.tieba.s.c.dMr().B(getUniqueId());
        t.csu().pB(false);
        super.onDestroy();
        this.jFD.cIZ();
        this.jgg = getVoiceManager();
        this.jgg.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jDp);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jfZ);
        bundle.putString("from", this.mFrom);
        this.jFD.onSaveInstanceState(bundle);
        this.jgg = getVoiceManager();
        if (this.jgg != null) {
            this.jgg.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        cb threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jFE.cJT().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.jfG.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.nn(intent.getIntExtra("good_data", 0));
                            threadDataById.boP();
                            rq(false);
                            return;
                        } else if (intExtra == 0) {
                            this.jfG.removeThreadData(threadDataById);
                            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfG.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jFE.cIV();
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
            if (this.jpi == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.iDa) {
                com.baidu.adp.lib.f.e.mA().post(this.jDp);
            }
        }
        cEY();
    }

    private void cEY() {
        if (isPrimary()) {
            if (this.jmw != null && this.jmw.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jjL);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jjL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jFE != null) {
            this.jFE.cDH();
        }
        this.jgg = getVoiceManager();
        this.jgg.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jFE.a(this.jhT);
        this.jFE.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jpi != 3 || this.jFE != null) {
            this.jpi = i;
            super.onChangeSkinType(i);
            if (this.jFE != null) {
                this.jFE.onChangeSkinType(i);
            }
            if (this.jmw != null && this.jmw.isViewAttached()) {
                this.jmw.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBF() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cBF();
        }
        return null;
    }

    private void cCN() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Tu(FrsNewAreaFragment.this.jfZ);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCO() {
        cCU();
        try {
            if (this.jfG != null) {
                this.jFE.cFi();
                this.jFE.bYh();
                this.jfZ = this.jfG.getForum().getName();
                this.forumId = this.jfG.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.jfG.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jfG.getUserData().getBimg_end_time());
                cCN();
                ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfG.getThreadList();
                if (threadList != null) {
                    this.jFE.a(threadList, this.mPn, this.jfG, this.jfG.getPage().bmF());
                    cIS();
                    this.jFE.cIV();
                    if (this.jfG.getIsNewUrl() == 1) {
                        this.jFE.cJT().setFromCDN(true);
                    } else {
                        this.jFE.cJT().setFromCDN(false);
                    }
                    this.jFE.setListViewSelection(cx(cJR().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cx(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.jgg = getVoiceManager();
        this.jgg.onPause(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        t.csu().pB(false);
        com.baidu.tieba.s.c.dMr().b(getUniqueId(), false);
        if (this.jfG != null && this.jfG.getForum() != null) {
            com.baidu.tbadk.distribute.a.bAU().b(getPageContext().getPageActivity(), "frs", this.jfG.getForum().getId(), 0L);
        }
        this.jgg = getVoiceManager();
        if (this.jgg != null) {
            this.jgg.onStop(getPageContext());
        }
    }

    public void cFH() {
        if (this.jFE != null && this.jFE.getListView() != null) {
            this.jFE.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsNewAreaFragment.this.jFE != null && FrsNewAreaFragment.this.jFE.getListView() != null && !FrsNewAreaFragment.this.jFE.getListView().isComputingLayout()) {
                        FrsNewAreaFragment.this.jFE.refreshView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(int i) {
        ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfG.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof ca) {
                    cb cbVar = ((ca) next).eJQ;
                    if (cbVar.getId() != null && cbVar.getId().equals(this.jDi)) {
                        c(cbVar, i);
                        this.jDi = null;
                        break;
                    }
                }
            }
            this.jFE.cJT().b(threadList, this.jfG);
            this.jFE.cJT().notifyDataSetChanged();
        }
    }

    private void c(cb cbVar, int i) {
        if (i == 1) {
            PraiseData bnB = cbVar.bnB();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bnB == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    cbVar.a(praiseData);
                    return;
                }
                cbVar.bnB().getUser().add(0, metaData);
                cbVar.bnB().setNum(cbVar.bnB().getNum() + 1);
                cbVar.bnB().setIsLike(i);
            }
        } else if (cbVar.bnB() != null) {
            cbVar.bnB().setIsLike(i);
            cbVar.bnB().setNum(cbVar.bnB().getNum() - 1);
            ArrayList<MetaData> user = cbVar.bnB().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        cbVar.bnB().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jgg == null) {
            this.jgg = VoiceManager.instance();
        }
        return this.jgg;
    }

    public BdTypeRecyclerView getListView() {
        if (this.jFE == null) {
            return null;
        }
        return this.jFE.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cCU() {
        this.jgg = getVoiceManager();
        this.jgg.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buM() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).buM();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.jfG != null && this.jFE != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jFE.cDH();
            }
        }
    }

    private void cIS() {
        HashMap<Integer, cb> cGs;
        if (this.jFE != null && this.jFE.cJT() != null && (cGs = this.jFE.cJT().cGs()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, cb> entry : cGs.entrySet()) {
                cb value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bBa().G(arrayList);
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
            rq(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cCZ() {
        return this.jfG;
    }

    public FrsNewAreaModelController cJR() {
        return this.jFD;
    }

    public void KV(String str) {
        this.jfZ = str;
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

    public void bRc() {
        if (!this.jDl.isLoading && !this.jFD.isLoading()) {
            if (this.jDl.dA(this.jfG.getThreadListIds())) {
                String str = "";
                if (this.jFD.cJb() != null) {
                    str = com.baidu.tieba.recapp.a.y(this.jFD.cJb().getThreadList(), false);
                }
                this.jFE.a(this.jDl.cJo(), this.mPn, this.jfG, 0);
                this.jDl.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.jfG.getThreadListIds(), this.jfZ, this.mPn, this.jfG.isBrandForum, str);
            } else if (this.hWZ != 0) {
                this.jFE.a(this.jDl.cJo(), this.mPn, this.jfG, 0);
                this.mPn++;
                this.jFD.Ab(this.mPn);
                this.jDl.loadingDone = false;
                this.jDl.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.jFE.bSr();
        } else if (!this.jFE.cDQ()) {
            if (!this.jFD.cJd()) {
                this.jFE.bSr();
                return;
            }
            bRr();
            bRc();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bRr();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void at(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        bRr();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jDl.a(false, false, false, arrayList, null);
            if (a2 != null) {
                this.jfG.setThreadList(a2);
                this.jFE.a(a2, this.mPn, this.jfG, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jfG.getForum()));
        }
    }

    public void dB(List<String> list) {
        dj(list);
        int i = 0;
        Iterator<com.baidu.adp.widget.ListView.n> it = this.jfG.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof ca ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            bRc();
        }
    }

    private void dj(List<String> list) {
        if (!y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfG.getThreadList();
            if (!y.isEmpty(threadList) && this.jFE.getListView() != null && this.jFE.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jFE.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.n next = it.next();
                    if (next instanceof ca) {
                        cb cbVar = ((ca) next).eJQ;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!au.equals(list.get(i2), cbVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jDl.d(next);
                                this.jFE.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cIR() {
        return this.jDl;
    }

    private void bRr() {
        if (this.hWZ == 0 && !this.jDl.dA(this.jfG.getThreadListIds())) {
            if (this.jfG.getThreadList() == null || this.jfG.getThreadList().size() == 0) {
                this.jFE.bSr();
                return;
            } else {
                this.jFE.WY();
                return;
            }
        }
        this.jFE.WX();
    }

    public g cJS() {
        return this.jFE;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.l.a.a.InterfaceC0148a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ae.checkCamera(getActivity().getApplicationContext())) {
                com.baidu.tbadk.core.util.ao.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
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
        com.baidu.tbadk.distribute.a.bAU().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.p
    public void cCT() {
        if (this.jFD != null) {
            this.jFD.cCT();
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
    public NavigationBar bVd() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jfZ;
    }

    @Override // com.baidu.tieba.frs.ao
    public void cBZ() {
        if (this.jFE != null && this.jFE.getListView() != null) {
            this.jFE.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSq() {
        if (this.jFE != null) {
            cBZ();
            this.jFE.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jgG.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sM(int i) {
        return this.jgG.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.jfG != null) {
            i = this.jfG.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.d.j.Av(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.aq
    public void bum() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bKP().Ex("page_frs_good");
            rq(true);
            return;
        }
        this.jFE.lU(false);
    }

    @Override // com.baidu.tieba.frs.aq
    public void bun() {
        com.baidu.tieba.s.c.dMr().b(getUniqueId(), false);
    }
}
