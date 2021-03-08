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
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.a, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ao, ap, aq, com.baidu.tieba.frs.loadmore.a, q, FrsCommonImageLayout.c {
    private String jFf;
    private FrsLoadMoreModel jFi;
    private FrsNewAreaModelController jHA;
    private VoiceManager jie;
    private com.baidu.tbadk.l.c jot;
    private boolean jrh;
    private String jhW = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData jhD = new FrsViewData();
    public long iKN = -1;
    public long fKL = 0;
    public long fKU = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected g jHB = null;
    private int hYW = -1;
    private int jrf = 3;
    private boolean iEX = false;
    private boolean jFl = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jiE = new SparseArray<>();
    private int dWJ = 0;
    private int jjc = 0;
    private CustomMessageListener jlI = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.jot != null && FrsNewAreaFragment.this.jot.isViewAttached()) {
                FrsNewAreaFragment.this.jot.rn(num.intValue());
            }
        }
    };
    private Runnable jFm = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.iEX) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.rq(false);
            }
        }
    };
    private CustomMessageListener jFn = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof cb)) {
                cb cbVar = (cb) customResponsedMessage.getData();
                FrsNewAreaFragment.this.jFf = cbVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.jFf) && cbVar.bnD() != null) {
                    FrsNewAreaFragment.this.zW(cbVar.bnD().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener jjr = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.getListView() != null) {
                        FrsNewAreaFragment.this.getListView().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.jot != null && FrsNewAreaFragment.this.jot.isViewAttached()) {
                        FrsNewAreaFragment.this.rq(false);
                    } else if (FrsNewAreaFragment.this.jHB != null) {
                        FrsNewAreaFragment.this.jHB.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s jjK = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long jFq = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void yB(int i) {
            if (!FrsNewAreaFragment.this.jFl) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.jHB.cDU();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.jHB.lU(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<com.baidu.adp.widget.ListView.n> a2;
            if (FrsNewAreaFragment.this.jFl) {
                if (FrsNewAreaFragment.this.cKe().cJo() == null) {
                    FrsNewAreaFragment.this.jFl = false;
                    return;
                } else if (FrsNewAreaFragment.this.cKe().cJo().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.jFl = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jFq = 1L;
            } else if (fVar.isSuccess) {
                this.jFq = 0L;
            } else {
                this.jFq = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.jFi.resetData();
            }
            FrsNewAreaFragment.this.jHB.lU(false);
            if (FrsNewAreaFragment.this.cKe().cJo() != null) {
                FrsNewAreaFragment.this.jhD = FrsNewAreaFragment.this.cKe().cJo();
            }
            FrsNewAreaFragment.this.hYW = FrsNewAreaFragment.this.jhD.getPage().bmH();
            if (FrsNewAreaFragment.this.hYW == 0 && (FrsNewAreaFragment.this.jhD.getThreadListIds() == null || FrsNewAreaFragment.this.jhD.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.jhD.getThreadList() == null || FrsNewAreaFragment.this.jhD.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.jHB.bSE();
                } else {
                    FrsNewAreaFragment.this.jHB.Xb();
                }
            } else {
                FrsNewAreaFragment.this.jHB.Xa();
            }
            if (i == 4) {
                ArrayList<com.baidu.adp.widget.ListView.n> a3 = FrsNewAreaFragment.this.jFi.a(false, false, false, FrsNewAreaFragment.this.jhD.getThreadList(), null);
                if (a3 != null) {
                    FrsNewAreaFragment.this.jhD.setThreadList(a3);
                    FrsNewAreaFragment.this.jHB.a(a3, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.jhD, FrsNewAreaFragment.this.hYW);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.jHB.cDU();
                    break;
                case 2:
                    FrsNewAreaFragment.this.jHB.cDU();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.jhD.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.jFq != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                FrsNewAreaFragment.this.Xc();
                if (FrsNewAreaFragment.this.jhD != null) {
                    FrsNewAreaFragment.this.jhW = FrsNewAreaFragment.this.jhD.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.jhD.getForum().getId();
                    FrsNewAreaFragment.this.jHB.b(FrsNewAreaFragment.this.jhD.getForum(), FrsNewAreaFragment.this.jhD.getUserData());
                }
                if (FrsNewAreaFragment.this.jhD != null) {
                    FrsNewAreaFragment.this.jhD.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.jhD == null || FrsNewAreaFragment.this.jhD.getThreadList() == null || FrsNewAreaFragment.this.jhD.getThreadList().size() != 0 || FrsNewAreaFragment.this.cKe().getType() != 4) {
                    if (FrsNewAreaFragment.this.jhD != null && (a2 = FrsNewAreaFragment.this.jFi.a(false, false, true, FrsNewAreaFragment.this.jhD.getThreadList(), null)) != null && a2.size() > 0) {
                        FrsNewAreaFragment.this.jhD.setThreadList(a2);
                    }
                    FrsNewAreaFragment.this.cDb();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.l(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.iKN > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.iKN, FrsNewAreaFragment.this.cKe().cwQ() - FrsNewAreaFragment.this.iKN, FrsNewAreaFragment.this.cKe().cwO(), FrsNewAreaFragment.this.cKe().cwP(), currentTimeMillis2 - FrsNewAreaFragment.this.cKe().cwN());
                        FrsNewAreaFragment.this.iKN = -1L;
                    }
                    FrsNewAreaFragment.this.fKU = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.iKN > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.iKN, FrsNewAreaFragment.this.cKe().cwQ() - FrsNewAreaFragment.this.iKN, FrsNewAreaFragment.this.cKe().cwO(), FrsNewAreaFragment.this.cKe().cwP(), currentTimeMillis3 - FrsNewAreaFragment.this.cKe().cwN());
                FrsNewAreaFragment.this.iKN = -1L;
            }
            FrsNewAreaFragment.this.fKU = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCV() {
        }
    };
    private final CustomMessageListener eLa = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.jHB != null) {
                FrsNewAreaFragment.this.jHB.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                t.csH().pB(true);
                com.baidu.tieba.s.c.dMH().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.jjc += i2;
            if (FrsNewAreaFragment.this.jjc >= FrsNewAreaFragment.this.dWJ * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener fuv = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
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
    private w jjR = new w() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && nVar != null && (nVar instanceof ca)) {
                cb cbVar = ((ca) nVar).eLr;
                if (cbVar.boT() == null || cbVar.boT().getGroup_id() == 0 || bh.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (cbVar.boE() != 1 || bh.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.TT(cbVar.getId())) {
                            readThreadHistory.TS(cbVar.getId());
                            if (FrsNewAreaFragment.this.jHB != null) {
                                FrsNewAreaFragment.this.jHB.cDU();
                            }
                        }
                        boolean z = false;
                        final String bnY = cbVar.bnY();
                        if (bnY != null && !bnY.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(bnY);
                                    aaVar.bsu().btd().mIsNeedAddCommenParam = false;
                                    aaVar.bsu().btd().mIsUseCurrentBDUSS = false;
                                    aaVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = cbVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (cbVar.bnN() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bf.bsY().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            cbVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(cbVar, FrsNewAreaFragment.this.jhW, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(cbVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.jhD != null && FrsNewAreaFragment.this.jhD.getForum() != null) {
                            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
                            bVar.jJh = FrsNewAreaFragment.this.jhD.needLog == 1;
                            bVar.jJj = FrsNewAreaFragment.this.jhD.getForum().getId();
                            bVar.jJi = FrsNewAreaFragment.this.jHA.cJS();
                            if (com.baidu.tieba.frs.b.d.jsn != null) {
                                bVar.jJk = com.baidu.tieba.frs.b.d.jsn.jJk;
                                bVar.jJl = com.baidu.tieba.frs.b.d.jsn.jJl;
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
            this.jHA.aq(cbVar);
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.jhD = frsViewData;
            hideLoadingView(this.jHB.cnA());
            if (this.jHB != null) {
                this.jHB.lU(false);
                this.jHB.a(null, this.mPn, this.jhD, this.hYW);
            }
        }
    }

    private void showLoadingView() {
        this.jHB.qV(false);
        showLoadingView(this.jHB.cnA(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jHB.qV(true);
        hideLoadingView(this.jHB.cnA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.jHB.qV(false);
        this.jHB.qU(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jHB.bSE();
        this.jHB.getListView().getData().clear();
        this.jHB.cDU();
        if (this.jot == null) {
            this.jot = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jot.setTitle(null);
            this.jot.setButtonText(null);
            this.jot.showRefreshButton();
            this.jot.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.jot.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.jot.setSubText(null);
        }
        this.jot.onChangeSkinType();
        this.jot.attachView(this.jHB.cnA(), true);
        registerListener(this.jlI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc() {
        this.jHB.qV(true);
        this.jHB.qU(true);
        if (this.jot != null && this.jot.isViewAttached()) {
            this.jot.dettachView(this.jHB.cnA());
        }
        MessageManager.getInstance().unRegisterListener(this.jlI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(boolean z) {
        this.iEX = true;
        cDh();
        Xc();
        if (!z) {
            Xc();
            showLoadingView();
        }
        this.jHA.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iKN = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.iKN = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
            this.jrh = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
        }
        this.beginTime = System.currentTimeMillis();
        this.fKL = this.beginTime - this.iKN;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMH().B(getUniqueId());
        this.jHA = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.jHA.aj(arguments);
        } else if (bundle != null) {
            this.jHA.aj(bundle);
        } else {
            this.jHA.aj(null);
        }
        this.jie = getVoiceManager();
        this.jie.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eLa);
        registerListener(this.jFn);
        registerListener(this.jjr);
        this.jFi = new FrsLoadMoreModel(this, null);
        this.jFi.registerListener();
        this.jFi.setPageType(3);
        this.jFi.rs(true);
        this.jFi.setFunAdController(com.baidu.tieba.funad.a.rM(this.jrh));
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dWJ = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jHB = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.iEX) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                rq(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bsR();
    }

    private void bsR() {
        ar arVar = new ar("c13008");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("fid", this.forumId);
        arVar.aq("obj_type", 6);
        arVar.aq("obj_locate", 2);
        arVar.bsR();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.jie = getVoiceManager();
        this.jie.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cJd();
        if (bundle != null) {
            this.jhW = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.jhW = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cJd() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fuv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.jHB != null) {
            this.jHB.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jlI);
        com.baidu.tieba.s.c.dMH().C(getUniqueId());
        t.csH().pB(false);
        super.onDestroy();
        this.jHA.cJm();
        this.jie = getVoiceManager();
        this.jie.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jFm);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jhW);
        bundle.putString("from", this.mFrom);
        this.jHA.onSaveInstanceState(bundle);
        this.jie = getVoiceManager();
        if (this.jie != null) {
            this.jie.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        cb threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jHB.cKg().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.jhD.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.no(intent.getIntExtra("good_data", 0));
                            threadDataById.boR();
                            rq(false);
                            return;
                        } else if (intExtra == 0) {
                            this.jhD.removeThreadData(threadDataById);
                            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jhD.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jHB.cJi();
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
            if (this.jrf == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.iEX) {
                com.baidu.adp.lib.f.e.mA().post(this.jFm);
            }
        }
        cFl();
    }

    private void cFl() {
        if (isPrimary()) {
            if (this.jot != null && this.jot.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jlI);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jlI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jHB != null) {
            this.jHB.cDU();
        }
        this.jie = getVoiceManager();
        this.jie.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jHB.a(this.jjR);
        this.jHB.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jrf != 3 || this.jHB != null) {
            this.jrf = i;
            super.onChangeSkinType(i);
            if (this.jHB != null) {
                this.jHB.onChangeSkinType(i);
            }
            if (this.jot != null && this.jot.isViewAttached()) {
                this.jot.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBS() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cBS();
        }
        return null;
    }

    private void cDa() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TN(FrsNewAreaFragment.this.jhW);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDb() {
        cDh();
        try {
            if (this.jhD != null) {
                this.jHB.cFv();
                this.jHB.bYu();
                this.jhW = this.jhD.getForum().getName();
                this.forumId = this.jhD.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.jhD.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jhD.getUserData().getBimg_end_time());
                cDa();
                ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jhD.getThreadList();
                if (threadList != null) {
                    this.jHB.a(threadList, this.mPn, this.jhD, this.jhD.getPage().bmH());
                    cJf();
                    this.jHB.cJi();
                    if (this.jhD.getIsNewUrl() == 1) {
                        this.jHB.cKg().setFromCDN(true);
                    } else {
                        this.jHB.cKg().setFromCDN(false);
                    }
                    this.jHB.setListViewSelection(cy(cKe().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cy(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.jie = getVoiceManager();
        this.jie.onPause(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        t.csH().pB(false);
        com.baidu.tieba.s.c.dMH().b(getUniqueId(), false);
        if (this.jhD != null && this.jhD.getForum() != null) {
            com.baidu.tbadk.distribute.a.bAX().b(getPageContext().getPageActivity(), "frs", this.jhD.getForum().getId(), 0L);
        }
        this.jie = getVoiceManager();
        if (this.jie != null) {
            this.jie.onStop(getPageContext());
        }
    }

    public void cFU() {
        if (this.jHB != null && this.jHB.getListView() != null) {
            this.jHB.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsNewAreaFragment.this.jHB != null && FrsNewAreaFragment.this.jHB.getListView() != null && !FrsNewAreaFragment.this.jHB.getListView().isComputingLayout()) {
                        FrsNewAreaFragment.this.jHB.refreshView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zW(int i) {
        ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jhD.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof ca) {
                    cb cbVar = ((ca) next).eLr;
                    if (cbVar.getId() != null && cbVar.getId().equals(this.jFf)) {
                        c(cbVar, i);
                        this.jFf = null;
                        break;
                    }
                }
            }
            this.jHB.cKg().b(threadList, this.jhD);
            this.jHB.cKg().notifyDataSetChanged();
        }
    }

    private void c(cb cbVar, int i) {
        if (i == 1) {
            PraiseData bnD = cbVar.bnD();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bnD == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    cbVar.a(praiseData);
                    return;
                }
                cbVar.bnD().getUser().add(0, metaData);
                cbVar.bnD().setNum(cbVar.bnD().getNum() + 1);
                cbVar.bnD().setIsLike(i);
            }
        } else if (cbVar.bnD() != null) {
            cbVar.bnD().setIsLike(i);
            cbVar.bnD().setNum(cbVar.bnD().getNum() - 1);
            ArrayList<MetaData> user = cbVar.bnD().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        cbVar.bnD().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jie == null) {
            this.jie = VoiceManager.instance();
        }
        return this.jie;
    }

    public BdTypeRecyclerView getListView() {
        if (this.jHB == null) {
            return null;
        }
        return this.jHB.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cDh() {
        this.jie = getVoiceManager();
        this.jie.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buP() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).buP();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.jhD != null && this.jHB != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jHB.cDU();
            }
        }
    }

    private void cJf() {
        HashMap<Integer, cb> cGF;
        if (this.jHB != null && this.jHB.cKg() != null && (cGF = this.jHB.cKg().cGF()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, cb> entry : cGF.entrySet()) {
                cb value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bBd().G(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.q onGetPreLoadListView() {
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
    public FrsViewData cDm() {
        return this.jhD;
    }

    public FrsNewAreaModelController cKe() {
        return this.jHA;
    }

    public void Lf(String str) {
        this.jhW = str;
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

    public void bRp() {
        if (!this.jFi.isLoading && !this.jHA.isLoading()) {
            if (this.jFi.dA(this.jhD.getThreadListIds())) {
                String str = "";
                if (this.jHA.cJo() != null) {
                    str = com.baidu.tieba.recapp.a.y(this.jHA.cJo().getThreadList(), false);
                }
                this.jHB.a(this.jFi.cJB(), this.mPn, this.jhD, 0);
                this.jFi.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.jhD.getThreadListIds(), this.jhW, this.mPn, this.jhD.isBrandForum, str);
            } else if (this.hYW != 0) {
                this.jHB.a(this.jFi.cJB(), this.mPn, this.jhD, 0);
                this.mPn++;
                this.jHA.Ac(this.mPn);
                this.jFi.loadingDone = false;
                this.jFi.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.jHB.bSE();
        } else if (!this.jHB.cEd()) {
            if (!this.jHA.cJq()) {
                this.jHB.bSE();
                return;
            }
            bRE();
            bRp();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bRE();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void at(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        bRE();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jFi.a(false, false, false, arrayList, null);
            if (a2 != null) {
                this.jhD.setThreadList(a2);
                this.jHB.a(a2, this.mPn, this.jhD, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jhD.getForum()));
        }
    }

    public void dB(List<String> list) {
        dj(list);
        int i = 0;
        Iterator<com.baidu.adp.widget.ListView.n> it = this.jhD.getThreadList().iterator();
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
            bRp();
        }
    }

    private void dj(List<String> list) {
        if (!y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jhD.getThreadList();
            if (!y.isEmpty(threadList) && this.jHB.getListView() != null && this.jHB.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jHB.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.n next = it.next();
                    if (next instanceof ca) {
                        cb cbVar = ((ca) next).eLr;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!au.equals(list.get(i2), cbVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jFi.d(next);
                                this.jHB.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cJe() {
        return this.jFi;
    }

    private void bRE() {
        if (this.hYW == 0 && !this.jFi.dA(this.jhD.getThreadListIds())) {
            if (this.jhD.getThreadList() == null || this.jhD.getThreadList().size() == 0) {
                this.jHB.bSE();
                return;
            } else {
                this.jHB.Xb();
                return;
            }
        }
        this.jHB.Xa();
    }

    public g cKf() {
        return this.jHB;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.l.a.a.InterfaceC0154a
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

    @Override // com.baidu.tieba.recapp.q
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.q
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bAX().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.q
    public void cDg() {
        if (this.jHA != null) {
            this.jHA.cDg();
        }
    }

    @Override // com.baidu.tieba.recapp.q
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.q
    public int getPageNum() {
        return this.mPn;
    }

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bVq() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jhW;
    }

    @Override // com.baidu.tieba.frs.ao
    public void cCm() {
        if (this.jHB != null && this.jHB.getListView() != null) {
            this.jHB.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSD() {
        if (this.jHB != null) {
            cCm();
            this.jHB.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jiE.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sO(int i) {
        return this.jiE.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.jhD != null) {
            i = this.jhD.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.d.j.Aw(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.aq
    public void bup() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bKY().EC("page_frs_good");
            rq(true);
            return;
        }
        this.jHB.lU(false);
    }

    @Override // com.baidu.tieba.frs.aq
    public void buq() {
        com.baidu.tieba.s.c.dMH().b(getUniqueId(), false);
    }
}
