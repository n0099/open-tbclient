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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, ai, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String gFe;
    private FrsLoadMoreModel gFh;
    private FrsNewAreaModelController gHE;
    private VoiceManager goj;
    private com.baidu.tbadk.k.c gta;
    private String goc = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData gnK = new FrsViewData();
    public long fVe = -1;
    public long dDv = 0;
    public long dDD = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean gou = false;
    protected g gHF = null;
    private int fsb = -1;
    private int gvF = 3;
    private boolean fPp = false;
    private boolean gFk = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> goH = new SparseArray<>();
    private int cdu = 0;
    private int gpf = 0;
    private CustomMessageListener gre = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.gta != null && FrsNewAreaFragment.this.gta.isViewAttached()) {
                FrsNewAreaFragment.this.gta.mD(num.intValue());
            }
        }
    };
    private Runnable gFl = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.fPp) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.lV(false);
            }
        }
    };
    private CustomMessageListener gFm = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                FrsNewAreaFragment.this.gFe = bjVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.gFe) && bjVar.aBX() != null) {
                    FrsNewAreaFragment.this.tI(bjVar.aBX().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener gpi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.aIf() != null) {
                        FrsNewAreaFragment.this.aIf().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.gta != null && FrsNewAreaFragment.this.gta.isViewAttached()) {
                        FrsNewAreaFragment.this.lV(false);
                    } else if (FrsNewAreaFragment.this.gHF != null) {
                        FrsNewAreaFragment.this.gHF.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final p gpx = new p() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long gFp = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void sG(int i) {
            if (!FrsNewAreaFragment.this.gFk) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.gHF.bER();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.gHF.hu(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.gFk) {
                if (FrsNewAreaFragment.this.bJu().bIK() == null) {
                    FrsNewAreaFragment.this.gFk = false;
                    return;
                } else if (FrsNewAreaFragment.this.bJu().bIK().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.gFk = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.gFp = 1L;
            } else if (bVar.isSuccess) {
                this.gFp = 0L;
            } else {
                this.gFp = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.gFh.resetData();
            }
            FrsNewAreaFragment.this.gHF.hu(false);
            if (FrsNewAreaFragment.this.bJu().bIK() != null) {
                FrsNewAreaFragment.this.gnK = FrsNewAreaFragment.this.bJu().bIK();
            }
            FrsNewAreaFragment.this.fsb = FrsNewAreaFragment.this.gnK.getPage().aBi();
            if (FrsNewAreaFragment.this.fsb == 0 && (FrsNewAreaFragment.this.gnK.getThreadListIds() == null || FrsNewAreaFragment.this.gnK.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.gnK.getThreadList() == null || FrsNewAreaFragment.this.gnK.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.gHF.bdr();
                } else {
                    FrsNewAreaFragment.this.gHF.bdq();
                }
            } else {
                FrsNewAreaFragment.this.gHF.bdp();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.gFh.a(false, false, false, FrsNewAreaFragment.this.gnK.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.gnK.setThreadList(a2);
                    FrsNewAreaFragment.this.gHF.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.gnK, FrsNewAreaFragment.this.fsb);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.gHF.bER();
                    break;
                case 2:
                    FrsNewAreaFragment.this.gHF.bER();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.gnK.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.gFp != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.gnK != null) {
                    FrsNewAreaFragment.this.goc = FrsNewAreaFragment.this.gnK.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.gnK.getForum().getId();
                    FrsNewAreaFragment.this.gHF.b(FrsNewAreaFragment.this.gnK.getForum(), FrsNewAreaFragment.this.gnK.getUserData());
                }
                if (FrsNewAreaFragment.this.gnK != null) {
                    FrsNewAreaFragment.this.gnK.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.gnK == null || FrsNewAreaFragment.this.gnK.getThreadList() == null || FrsNewAreaFragment.this.gnK.getThreadList().size() != 0 || FrsNewAreaFragment.this.bJu().getType() != 4) {
                    if (FrsNewAreaFragment.this.gnK != null && (a = FrsNewAreaFragment.this.gFh.a(false, false, true, FrsNewAreaFragment.this.gnK.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.gnK.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bEf();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.fVe > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.fVe, FrsNewAreaFragment.this.bJu().byN() - FrsNewAreaFragment.this.fVe, FrsNewAreaFragment.this.bJu().byL(), FrsNewAreaFragment.this.bJu().byM(), currentTimeMillis2 - FrsNewAreaFragment.this.bJu().byK());
                        FrsNewAreaFragment.this.fVe = -1L;
                    }
                    FrsNewAreaFragment.this.dDD = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.fVe > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.fVe, FrsNewAreaFragment.this.bJu().byN() - FrsNewAreaFragment.this.fVe, FrsNewAreaFragment.this.bJu().byL(), FrsNewAreaFragment.this.bJu().byM(), currentTimeMillis3 - FrsNewAreaFragment.this.bJu().byK());
                FrsNewAreaFragment.this.fVe = -1L;
            }
            FrsNewAreaFragment.this.dDD = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
        }
    };
    private final CustomMessageListener cLF = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.gHF != null) {
                FrsNewAreaFragment.this.gHF.startPullRefresh();
            }
        }
    };
    private final g.c erT = new g.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.tieba.a.d.aXD().wN("page_frs_good");
                FrsNewAreaFragment.this.lV(true);
                return;
            }
            FrsNewAreaFragment.this.gHF.hu(false);
        }
    };
    private final g.b dgI = new g.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.s.c.cJY().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.gou) {
                FrsNewAreaFragment.this.gou = true;
                FrsNewAreaFragment.this.gHF.bFf();
            }
            if (i == 0) {
                r.bve().kp(true);
                com.baidu.tieba.s.c.cJY().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.gpf += i2;
            if (FrsNewAreaFragment.this.gpf >= FrsNewAreaFragment.this.cdu * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener doq = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
    private s gpD = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bi)) {
                bj bjVar = ((bi) mVar).cRe;
                if (bjVar.aDj() == null || bjVar.aDj().getGroup_id() == 0 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bjVar.aCW() != 1 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Jo(bjVar.getId())) {
                            readThreadHistory.Jn(bjVar.getId());
                            if (FrsNewAreaFragment.this.gHF != null) {
                                FrsNewAreaFragment.this.gHF.bER();
                            }
                        }
                        boolean z = false;
                        final String aCt = bjVar.aCt();
                        if (aCt != null && !aCt.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aCt);
                                    xVar.aGe().aGF().mIsNeedAddCommenParam = false;
                                    xVar.aGe().aGF().mIsUseCurrentBDUSS = false;
                                    xVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bjVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bjVar.aCh() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aGE().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bjVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, FrsNewAreaFragment.this.goc, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.gnK != null && FrsNewAreaFragment.this.gnK.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.gJk = FrsNewAreaFragment.this.gnK.needLog == 1;
                            bVar.gJm = FrsNewAreaFragment.this.gnK.getForum().getId();
                            bVar.gJl = FrsNewAreaFragment.this.gHE.bJn();
                            if (com.baidu.tieba.frs.d.d.gwo != null) {
                                bVar.gJn = com.baidu.tieba.frs.d.d.gwo.gJn;
                                bVar.gJo = com.baidu.tieba.frs.d.d.gwo.gJo;
                            }
                            com.baidu.tieba.frs.d.a.a(bjVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar, FrsNewAreaFragment.this.getTbPageTag());
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

    public void al(bj bjVar) {
        if (bjVar != null) {
            this.gHE.al(bjVar);
            this.gHF.scrollToTop();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.gnK = frsViewData;
            hideLoadingView(this.gHF.bsC());
            if (this.gHF != null) {
                this.gHF.hu(false);
                this.gHF.a(null, this.mPn, this.gnK, this.fsb);
            }
        }
    }

    private void showLoadingView() {
        this.gHF.lF(false);
        showLoadingView(this.gHF.bsC(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gHF.lF(true);
        hideLoadingView(this.gHF.bsC());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.gHF.lF(false);
        this.gHF.bGd().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gHF.bdr();
        this.gHF.getListView().getData().clear();
        this.gHF.bER();
        if (this.gta == null) {
            this.gta = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.gta.setTitle(null);
            this.gta.setButtonText(null);
            this.gta.showRefreshButton();
            this.gta.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.gta.setSubText(getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.gta.setSubText(null);
        }
        this.gta.onChangeSkinType();
        this.gta.attachView(this.gHF.bsC(), true);
        registerListener(this.gre);
    }

    private void bcv() {
        this.gHF.lF(true);
        this.gHF.bGd().setEnabled(true);
        if (this.gta != null && this.gta.isViewAttached()) {
            this.gta.dettachView(this.gHF.bsC());
        }
        MessageManager.getInstance().unRegisterListener(this.gre);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV(boolean z) {
        this.fPp = true;
        bEi();
        bcv();
        if (!z) {
            bcv();
            showLoadingView();
        }
        this.gHE.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fVe = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.fVe = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.dDv = this.beginTime - this.fVe;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cJY().w(getUniqueId());
        this.gHE = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.gHE.ad(arguments);
        } else if (bundle != null) {
            this.gHE.ad(bundle);
        } else {
            this.gHE.ad(null);
        }
        this.goj = getVoiceManager();
        this.goj.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.cLF);
        registerListener(this.gFm);
        registerListener(this.gpi);
        this.gFh = new FrsLoadMoreModel(this, null);
        this.gFh.registerListener();
        this.gFh.setPageType(3);
        this.gFh.lX(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cdu = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.gHF = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.fPp) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                lV(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        aGx();
    }

    private void aGx() {
        an anVar = new an("c13008");
        anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cy("fid", this.forumId);
        anVar.X("obj_type", 6);
        anVar.X("obj_locate", 2);
        anVar.aGx();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.goj = getVoiceManager();
        this.goj.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bIA();
        if (bundle != null) {
            this.goc = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.goc = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bIA() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.doq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gHF != null) {
            this.gHF.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gre);
        com.baidu.tieba.s.c.cJY().x(getUniqueId());
        r.bve().kp(false);
        super.onDestroy();
        this.gHE.aiG();
        this.goj = getVoiceManager();
        this.goj.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gFl);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.goc);
        bundle.putString("from", this.mFrom);
        this.gHE.onSaveInstanceState(bundle);
        this.goj = getVoiceManager();
        if (this.goj != null) {
            this.goj.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bj threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.gHF.bJw().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.gnK.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.jM(intent.getIntExtra("good_data", 0));
                            threadDataById.aDh();
                            lV(false);
                            return;
                        } else if (intExtra == 0) {
                            this.gnK.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.gnK.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.n());
                            }
                            this.gHF.bIF();
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
            if (this.gvF == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.fPp) {
                com.baidu.adp.lib.f.e.gx().post(this.gFl);
            }
        }
        bFT();
    }

    private void bFT() {
        if (isPrimary()) {
            if (this.gta != null && this.gta.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.gre);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.gre);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gHF != null) {
            this.gHF.bER();
        }
        this.goj = getVoiceManager();
        this.goj.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.gHF.a(this.gpD);
        this.gHF.setOnScrollListener(this.mScrollListener);
        this.gHF.setListPullRefreshListener(this.erT);
        this.gHF.a(this.dgI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gvF != 3 || this.gHF != null) {
            this.gvF = i;
            super.onChangeSkinType(i);
            if (this.gHF != null) {
                this.gHF.onChangeSkinType(i);
            }
            if (this.gta != null && this.gta.isViewAttached()) {
                this.gta.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bDg() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bDg();
        }
        return null;
    }

    private void bEe() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Ji(FrsNewAreaFragment.this.goc);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEf() {
        bEi();
        try {
            if (this.gnK != null) {
                this.gHF.bgw();
                this.goc = this.gnK.getForum().getName();
                this.forumId = this.gnK.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.gnK.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.gnK.getUserData().getBimg_end_time());
                bEe();
                ArrayList<m> threadList = this.gnK.getThreadList();
                if (threadList != null) {
                    this.gHF.a(threadList, this.mPn, this.gnK, this.gnK.getPage().aBi());
                    bIC();
                    this.gHF.bIF();
                    if (this.gnK.getIsNewUrl() == 1) {
                        this.gHF.bJw().setFromCDN(true);
                    } else {
                        this.gHF.bJw().setFromCDN(false);
                    }
                    this.gHF.setListViewSelection(bO(bJu().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int bO(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.goj = getVoiceManager();
        this.goj.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        r.bve().kp(false);
        com.baidu.tieba.s.c.cJY().b(getUniqueId(), false);
        if (this.gnK != null && this.gnK.getForum() != null) {
            com.baidu.tbadk.distribute.a.aOf().a(getPageContext().getPageActivity(), "frs", this.gnK.getForum().getId(), 0L);
        }
        this.goj = getVoiceManager();
        if (this.goj != null) {
            this.goj.onStop(getPageContext());
        }
    }

    public void bGA() {
        if (this.gHF != null) {
            this.gHF.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(int i) {
        ArrayList<m> threadList = this.gnK.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).cRe;
                    if (bjVar.getId() != null && bjVar.getId().equals(this.gFe)) {
                        c(bjVar, i);
                        this.gFe = null;
                        break;
                    }
                }
            }
            this.gHF.bJw().b(threadList, this.gnK);
            this.gHF.bJw().notifyDataSetChanged();
        }
    }

    private void c(bj bjVar, int i) {
        if (i == 1) {
            PraiseData aBX = bjVar.aBX();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aBX == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bjVar.a(praiseData);
                    return;
                }
                bjVar.aBX().getUser().add(0, metaData);
                bjVar.aBX().setNum(bjVar.aBX().getNum() + 1);
                bjVar.aBX().setIsLike(i);
            }
        } else if (bjVar.aBX() != null) {
            bjVar.aBX().setIsLike(i);
            bjVar.aBX().setNum(bjVar.aBX().getNum() - 1);
            ArrayList<MetaData> user = bjVar.aBX().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bjVar.aBX().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.goj == null) {
            this.goj = VoiceManager.instance();
        }
        return this.goj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aIf() {
        if (this.gHF == null) {
            return null;
        }
        return this.gHF.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bEi() {
        this.goj = getVoiceManager();
        this.goj.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aIg() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aIg();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.gnK != null && this.gHF != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.gHF.bER();
            }
        }
    }

    private void bIC() {
        HashMap<Integer, bj> bGY;
        if (this.gHF != null && this.gHF.bJw() != null && (bGY = this.gHF.bJw().bGY()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bj> entry : bGY.entrySet()) {
                bj value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.aOl().E(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (aIf() == null) {
            return null;
        }
        return aIf().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            lV(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bEn() {
        return this.gnK;
    }

    public FrsNewAreaModelController bJu() {
        return this.gHE;
    }

    public void Bz(String str) {
        this.goc = str;
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

    public void bcd() {
        if (!this.gFh.isLoading && !this.gHE.isLoading()) {
            if (this.gFh.cn(this.gnK.getThreadListIds())) {
                this.gHF.a(this.gFh.bIX(), this.mPn, this.gnK, 0);
                this.gFh.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.gnK.getThreadListIds(), this.goc, this.mPn, this.gnK.isBrandForum);
            } else if (this.fsb != 0) {
                this.gHF.a(this.gFh.bIX(), this.mPn, this.gnK, 0);
                this.mPn++;
                this.gHE.tK(this.mPn);
                this.gFh.loadingDone = false;
                this.gFh.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.gHF.bdr();
        } else if (!this.gHF.bEZ()) {
            if (!this.gHE.bIM()) {
                this.gHF.bdr();
                return;
            }
            bcs();
            bcd();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bcs();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void al(ArrayList<m> arrayList) {
        ArrayList<m> a;
        bcs();
        if (arrayList != null && arrayList.size() != 0 && (a = this.gFh.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.gnK.setThreadList(a);
            this.gHF.a(a, this.mPn, this.gnK, 0);
        }
    }

    public void co(List<String> list) {
        cd(list);
        int i = 0;
        Iterator<m> it = this.gnK.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bi ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            bcd();
        }
    }

    private void cd(List<String> list) {
        if (!v.isEmpty(list)) {
            ArrayList<m> threadList = this.gnK.getThreadList();
            if (!v.isEmpty(threadList) && this.gHF.getListView() != null && this.gHF.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.gHF.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).cRe;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.gFh.d(next);
                                this.gHF.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel bIB() {
        return this.gFh;
    }

    private void bcs() {
        if (this.fsb == 0 && !this.gFh.cn(this.gnK.getThreadListIds())) {
            if (this.gnK.getThreadList() == null || this.gnK.getThreadList().size() == 0) {
                this.gHF.bdr();
                return;
            } else {
                this.gHF.bdq();
                return;
            }
        }
        this.gHF.bdp();
    }

    public g bJv() {
        return this.gHF;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.k.a.a.InterfaceC0078a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.checkCamera(getActivity().getApplicationContext())) {
                al.e(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
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
        com.baidu.tbadk.distribute.a.aOf().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bEh() {
        if (this.gHE != null) {
            this.gHE.bEh();
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

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar beJ() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.goc;
    }

    @Override // com.baidu.tieba.frs.ah
    public void scrollToTop() {
        if (this.gHF != null && this.gHF.getListView() != null) {
            this.gHF.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void bdo() {
        if (this.gHF != null) {
            scrollToTop();
            this.gHF.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.goH.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nS(int i) {
        return this.goH.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.gnK != null) {
            i = this.gnK.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.uh(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }
}
