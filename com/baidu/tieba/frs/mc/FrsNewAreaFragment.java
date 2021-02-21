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
    private String jDw;
    private FrsLoadMoreModel jDz;
    private FrsNewAreaModelController jFR;
    private VoiceManager jgu;
    private com.baidu.tbadk.l.c jmK;
    private boolean jpy;
    private String jgn = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData jfU = new FrsViewData();
    public long iJe = -1;
    public long fJl = 0;
    public long fJu = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected g jFS = null;
    private int hXn = -1;
    private int jpw = 3;
    private boolean iDo = false;
    private boolean jDC = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jgU = new SparseArray<>();
    private int dVi = 0;
    private int jhs = 0;
    private CustomMessageListener jjZ = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.jmK != null && FrsNewAreaFragment.this.jmK.isViewAttached()) {
                FrsNewAreaFragment.this.jmK.rm(num.intValue());
            }
        }
    };
    private Runnable jDD = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.iDo) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.rq(false);
            }
        }
    };
    private CustomMessageListener jDE = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof cb)) {
                cb cbVar = (cb) customResponsedMessage.getData();
                FrsNewAreaFragment.this.jDw = cbVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.jDw) && cbVar.bnB() != null) {
                    FrsNewAreaFragment.this.zV(cbVar.bnB().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener jhH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.getListView() != null) {
                        FrsNewAreaFragment.this.getListView().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.jmK != null && FrsNewAreaFragment.this.jmK.isViewAttached()) {
                        FrsNewAreaFragment.this.rq(false);
                    } else if (FrsNewAreaFragment.this.jFS != null) {
                        FrsNewAreaFragment.this.jFS.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s jia = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long jDH = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void yA(int i) {
            if (!FrsNewAreaFragment.this.jDC) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.jFS.cDO();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.jFS.lU(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<com.baidu.adp.widget.ListView.n> a2;
            if (FrsNewAreaFragment.this.jDC) {
                if (FrsNewAreaFragment.this.cJY().cJi() == null) {
                    FrsNewAreaFragment.this.jDC = false;
                    return;
                } else if (FrsNewAreaFragment.this.cJY().cJi().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.jDC = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jDH = 1L;
            } else if (fVar.isSuccess) {
                this.jDH = 0L;
            } else {
                this.jDH = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.jDz.resetData();
            }
            FrsNewAreaFragment.this.jFS.lU(false);
            if (FrsNewAreaFragment.this.cJY().cJi() != null) {
                FrsNewAreaFragment.this.jfU = FrsNewAreaFragment.this.cJY().cJi();
            }
            FrsNewAreaFragment.this.hXn = FrsNewAreaFragment.this.jfU.getPage().bmF();
            if (FrsNewAreaFragment.this.hXn == 0 && (FrsNewAreaFragment.this.jfU.getThreadListIds() == null || FrsNewAreaFragment.this.jfU.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.jfU.getThreadList() == null || FrsNewAreaFragment.this.jfU.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.jFS.bSy();
                } else {
                    FrsNewAreaFragment.this.jFS.WY();
                }
            } else {
                FrsNewAreaFragment.this.jFS.WX();
            }
            if (i == 4) {
                ArrayList<com.baidu.adp.widget.ListView.n> a3 = FrsNewAreaFragment.this.jDz.a(false, false, false, FrsNewAreaFragment.this.jfU.getThreadList(), null);
                if (a3 != null) {
                    FrsNewAreaFragment.this.jfU.setThreadList(a3);
                    FrsNewAreaFragment.this.jFS.a(a3, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.jfU, FrsNewAreaFragment.this.hXn);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.jFS.cDO();
                    break;
                case 2:
                    FrsNewAreaFragment.this.jFS.cDO();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.jfU.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.jDH != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                FrsNewAreaFragment.this.WZ();
                if (FrsNewAreaFragment.this.jfU != null) {
                    FrsNewAreaFragment.this.jgn = FrsNewAreaFragment.this.jfU.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.jfU.getForum().getId();
                    FrsNewAreaFragment.this.jFS.b(FrsNewAreaFragment.this.jfU.getForum(), FrsNewAreaFragment.this.jfU.getUserData());
                }
                if (FrsNewAreaFragment.this.jfU != null) {
                    FrsNewAreaFragment.this.jfU.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.jfU == null || FrsNewAreaFragment.this.jfU.getThreadList() == null || FrsNewAreaFragment.this.jfU.getThreadList().size() != 0 || FrsNewAreaFragment.this.cJY().getType() != 4) {
                    if (FrsNewAreaFragment.this.jfU != null && (a2 = FrsNewAreaFragment.this.jDz.a(false, false, true, FrsNewAreaFragment.this.jfU.getThreadList(), null)) != null && a2.size() > 0) {
                        FrsNewAreaFragment.this.jfU.setThreadList(a2);
                    }
                    FrsNewAreaFragment.this.cCV();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.l(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.iJe > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.iJe, FrsNewAreaFragment.this.cJY().cwK() - FrsNewAreaFragment.this.iJe, FrsNewAreaFragment.this.cJY().cwI(), FrsNewAreaFragment.this.cJY().cwJ(), currentTimeMillis2 - FrsNewAreaFragment.this.cJY().cwH());
                        FrsNewAreaFragment.this.iJe = -1L;
                    }
                    FrsNewAreaFragment.this.fJu = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.iJe > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.iJe, FrsNewAreaFragment.this.cJY().cwK() - FrsNewAreaFragment.this.iJe, FrsNewAreaFragment.this.cJY().cwI(), FrsNewAreaFragment.this.cJY().cwJ(), currentTimeMillis3 - FrsNewAreaFragment.this.cJY().cwH());
                FrsNewAreaFragment.this.iJe = -1L;
            }
            FrsNewAreaFragment.this.fJu = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCP() {
        }
    };
    private final CustomMessageListener eJz = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.jFS != null) {
                FrsNewAreaFragment.this.jFS.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                t.csB().pB(true);
                com.baidu.tieba.s.c.dMz().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.jhs += i2;
            if (FrsNewAreaFragment.this.jhs >= FrsNewAreaFragment.this.dVi * 2 && i2 < 0) {
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
    private w jii = new w() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && nVar != null && (nVar instanceof ca)) {
                cb cbVar = ((ca) nVar).eJQ;
                if (cbVar.boR() == null || cbVar.boR().getGroup_id() == 0 || bh.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (cbVar.boC() != 1 || bh.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.TM(cbVar.getId())) {
                            readThreadHistory.TL(cbVar.getId());
                            if (FrsNewAreaFragment.this.jFS != null) {
                                FrsNewAreaFragment.this.jFS.cDO();
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
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(cbVar, FrsNewAreaFragment.this.jgn, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(cbVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.jfU != null && FrsNewAreaFragment.this.jfU.getForum() != null) {
                            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
                            bVar.jHy = FrsNewAreaFragment.this.jfU.needLog == 1;
                            bVar.jHA = FrsNewAreaFragment.this.jfU.getForum().getId();
                            bVar.jHz = FrsNewAreaFragment.this.jFR.cJM();
                            if (com.baidu.tieba.frs.b.d.jqE != null) {
                                bVar.jHB = com.baidu.tieba.frs.b.d.jqE.jHB;
                                bVar.jHC = com.baidu.tieba.frs.b.d.jqE.jHC;
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
            this.jFR.aq(cbVar);
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.jfU = frsViewData;
            hideLoadingView(this.jFS.cnu());
            if (this.jFS != null) {
                this.jFS.lU(false);
                this.jFS.a(null, this.mPn, this.jfU, this.hXn);
            }
        }
    }

    private void showLoadingView() {
        this.jFS.qV(false);
        showLoadingView(this.jFS.cnu(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jFS.qV(true);
        hideLoadingView(this.jFS.cnu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.jFS.qV(false);
        this.jFS.qU(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jFS.bSy();
        this.jFS.getListView().getData().clear();
        this.jFS.cDO();
        if (this.jmK == null) {
            this.jmK = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jmK.setTitle(null);
            this.jmK.setButtonText(null);
            this.jmK.showRefreshButton();
            this.jmK.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.jmK.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.jmK.setSubText(null);
        }
        this.jmK.onChangeSkinType();
        this.jmK.attachView(this.jFS.cnu(), true);
        registerListener(this.jjZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        this.jFS.qV(true);
        this.jFS.qU(true);
        if (this.jmK != null && this.jmK.isViewAttached()) {
            this.jmK.dettachView(this.jFS.cnu());
        }
        MessageManager.getInstance().unRegisterListener(this.jjZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(boolean z) {
        this.iDo = true;
        cDb();
        WZ();
        if (!z) {
            WZ();
            showLoadingView();
        }
        this.jFR.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iJe = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.iJe = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
            this.jpy = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
        }
        this.beginTime = System.currentTimeMillis();
        this.fJl = this.beginTime - this.iJe;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMz().A(getUniqueId());
        this.jFR = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.jFR.aj(arguments);
        } else if (bundle != null) {
            this.jFR.aj(bundle);
        } else {
            this.jFR.aj(null);
        }
        this.jgu = getVoiceManager();
        this.jgu.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eJz);
        registerListener(this.jDE);
        registerListener(this.jhH);
        this.jDz = new FrsLoadMoreModel(this, null);
        this.jDz.registerListener();
        this.jDz.setPageType(3);
        this.jDz.rs(true);
        this.jDz.setFunAdController(com.baidu.tieba.funad.a.rM(this.jpy));
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dVi = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jFS = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.iDo) {
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
        this.jgu = getVoiceManager();
        this.jgu.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cIX();
        if (bundle != null) {
            this.jgn = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.jgn = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cIX() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fsV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.jFS != null) {
            this.jFS.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jjZ);
        com.baidu.tieba.s.c.dMz().B(getUniqueId());
        t.csB().pB(false);
        super.onDestroy();
        this.jFR.cJg();
        this.jgu = getVoiceManager();
        this.jgu.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jDD);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jgn);
        bundle.putString("from", this.mFrom);
        this.jFR.onSaveInstanceState(bundle);
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        cb threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jFS.cKa().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.jfU.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.nn(intent.getIntExtra("good_data", 0));
                            threadDataById.boP();
                            rq(false);
                            return;
                        } else if (intExtra == 0) {
                            this.jfU.removeThreadData(threadDataById);
                            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfU.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jFS.cJc();
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
            if (this.jpw == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.iDo) {
                com.baidu.adp.lib.f.e.mA().post(this.jDD);
            }
        }
        cFf();
    }

    private void cFf() {
        if (isPrimary()) {
            if (this.jmK != null && this.jmK.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jjZ);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jjZ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jFS != null) {
            this.jFS.cDO();
        }
        this.jgu = getVoiceManager();
        this.jgu.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jFS.a(this.jii);
        this.jFS.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jpw != 3 || this.jFS != null) {
            this.jpw = i;
            super.onChangeSkinType(i);
            if (this.jFS != null) {
                this.jFS.onChangeSkinType(i);
            }
            if (this.jmK != null && this.jmK.isViewAttached()) {
                this.jmK.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBM() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cBM();
        }
        return null;
    }

    private void cCU() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TG(FrsNewAreaFragment.this.jgn);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCV() {
        cDb();
        try {
            if (this.jfU != null) {
                this.jFS.cFp();
                this.jFS.bYo();
                this.jgn = this.jfU.getForum().getName();
                this.forumId = this.jfU.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.jfU.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jfU.getUserData().getBimg_end_time());
                cCU();
                ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfU.getThreadList();
                if (threadList != null) {
                    this.jFS.a(threadList, this.mPn, this.jfU, this.jfU.getPage().bmF());
                    cIZ();
                    this.jFS.cJc();
                    if (this.jfU.getIsNewUrl() == 1) {
                        this.jFS.cKa().setFromCDN(true);
                    } else {
                        this.jFS.cKa().setFromCDN(false);
                    }
                    this.jFS.setListViewSelection(cy(cJY().getType(), this.mPn));
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
        this.jgu = getVoiceManager();
        this.jgu.onPause(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        t.csB().pB(false);
        com.baidu.tieba.s.c.dMz().b(getUniqueId(), false);
        if (this.jfU != null && this.jfU.getForum() != null) {
            com.baidu.tbadk.distribute.a.bAU().b(getPageContext().getPageActivity(), "frs", this.jfU.getForum().getId(), 0L);
        }
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onStop(getPageContext());
        }
    }

    public void cFO() {
        if (this.jFS != null && this.jFS.getListView() != null) {
            this.jFS.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsNewAreaFragment.this.jFS != null && FrsNewAreaFragment.this.jFS.getListView() != null && !FrsNewAreaFragment.this.jFS.getListView().isComputingLayout()) {
                        FrsNewAreaFragment.this.jFS.refreshView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(int i) {
        ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfU.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n next = it.next();
                if (next instanceof ca) {
                    cb cbVar = ((ca) next).eJQ;
                    if (cbVar.getId() != null && cbVar.getId().equals(this.jDw)) {
                        c(cbVar, i);
                        this.jDw = null;
                        break;
                    }
                }
            }
            this.jFS.cKa().b(threadList, this.jfU);
            this.jFS.cKa().notifyDataSetChanged();
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
        if (this.jgu == null) {
            this.jgu = VoiceManager.instance();
        }
        return this.jgu;
    }

    public BdTypeRecyclerView getListView() {
        if (this.jFS == null) {
            return null;
        }
        return this.jFS.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cDb() {
        this.jgu = getVoiceManager();
        this.jgu.stopPlay();
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
        if (this.jfU != null && this.jFS != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jFS.cDO();
            }
        }
    }

    private void cIZ() {
        HashMap<Integer, cb> cGz;
        if (this.jFS != null && this.jFS.cKa() != null && (cGz = this.jFS.cKa().cGz()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, cb> entry : cGz.entrySet()) {
                cb value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bBa().G(arrayList);
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
    public FrsViewData cDg() {
        return this.jfU;
    }

    public FrsNewAreaModelController cJY() {
        return this.jFR;
    }

    public void KW(String str) {
        this.jgn = str;
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

    public void bRj() {
        if (!this.jDz.isLoading && !this.jFR.isLoading()) {
            if (this.jDz.dA(this.jfU.getThreadListIds())) {
                String str = "";
                if (this.jFR.cJi() != null) {
                    str = com.baidu.tieba.recapp.a.y(this.jFR.cJi().getThreadList(), false);
                }
                this.jFS.a(this.jDz.cJv(), this.mPn, this.jfU, 0);
                this.jDz.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.jfU.getThreadListIds(), this.jgn, this.mPn, this.jfU.isBrandForum, str);
            } else if (this.hXn != 0) {
                this.jFS.a(this.jDz.cJv(), this.mPn, this.jfU, 0);
                this.mPn++;
                this.jFR.Ab(this.mPn);
                this.jDz.loadingDone = false;
                this.jDz.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.jFS.bSy();
        } else if (!this.jFS.cDX()) {
            if (!this.jFR.cJk()) {
                this.jFS.bSy();
                return;
            }
            bRy();
            bRj();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bRy();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void at(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        bRy();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jDz.a(false, false, false, arrayList, null);
            if (a2 != null) {
                this.jfU.setThreadList(a2);
                this.jFS.a(a2, this.mPn, this.jfU, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jfU.getForum()));
        }
    }

    public void dB(List<String> list) {
        dj(list);
        int i = 0;
        Iterator<com.baidu.adp.widget.ListView.n> it = this.jfU.getThreadList().iterator();
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
            bRj();
        }
    }

    private void dj(List<String> list) {
        if (!y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfU.getThreadList();
            if (!y.isEmpty(threadList) && this.jFS.getListView() != null && this.jFS.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jFS.getListView().getData();
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
                                this.jDz.d(next);
                                this.jFS.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cIY() {
        return this.jDz;
    }

    private void bRy() {
        if (this.hXn == 0 && !this.jDz.dA(this.jfU.getThreadListIds())) {
            if (this.jfU.getThreadList() == null || this.jfU.getThreadList().size() == 0) {
                this.jFS.bSy();
                return;
            } else {
                this.jFS.WY();
                return;
            }
        }
        this.jFS.WX();
    }

    public g cJZ() {
        return this.jFS;
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

    @Override // com.baidu.tieba.recapp.q
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.q
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bAU().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.q
    public void cDa() {
        if (this.jFR != null) {
            this.jFR.cDa();
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
    public NavigationBar bVk() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jgn;
    }

    @Override // com.baidu.tieba.frs.ao
    public void cCg() {
        if (this.jFS != null && this.jFS.getListView() != null) {
            this.jFS.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSx() {
        if (this.jFS != null) {
            cCg();
            this.jFS.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jgU.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sM(int i) {
        return this.jgU.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.jfU != null) {
            i = this.jfU.getSortType();
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
            com.baidu.tieba.a.d.bKU().Ev("page_frs_good");
            rq(true);
            return;
        }
        this.jFS.lU(false);
    }

    @Override // com.baidu.tieba.frs.aq
    public void bun() {
        com.baidu.tieba.s.c.dMz().b(getUniqueId(), false);
    }
}
