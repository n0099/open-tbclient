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
    private String gFg;
    private FrsLoadMoreModel gFj;
    private FrsNewAreaModelController gHG;
    private VoiceManager gol;
    private com.baidu.tbadk.k.c gtc;
    private String goe = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData gnM = new FrsViewData();
    public long fVg = -1;
    public long dDw = 0;
    public long dDE = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean gow = false;
    protected g gHH = null;
    private int fsc = -1;
    private int gvH = 3;
    private boolean fPr = false;
    private boolean gFm = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> goJ = new SparseArray<>();
    private int cdv = 0;
    private int gph = 0;
    private CustomMessageListener grg = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.gtc != null && FrsNewAreaFragment.this.gtc.isViewAttached()) {
                FrsNewAreaFragment.this.gtc.mD(num.intValue());
            }
        }
    };
    private Runnable gFn = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.fPr) {
                FrsNewAreaFragment.this.c((e.b) null);
            } else {
                FrsNewAreaFragment.this.lV(false);
            }
        }
    };
    private CustomMessageListener gFo = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                FrsNewAreaFragment.this.gFg = bjVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.gFg) && bjVar.aBZ() != null) {
                    FrsNewAreaFragment.this.tI(bjVar.aBZ().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener gpk = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.aIh() != null) {
                        FrsNewAreaFragment.this.aIh().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.gtc != null && FrsNewAreaFragment.this.gtc.isViewAttached()) {
                        FrsNewAreaFragment.this.lV(false);
                    } else if (FrsNewAreaFragment.this.gHH != null) {
                        FrsNewAreaFragment.this.gHH.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final p gpz = new p() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        private long gFr = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void sG(int i) {
            if (!FrsNewAreaFragment.this.gFm) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.gHH.bET();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.gHH.hu(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsNewAreaFragment.this.gFm) {
                if (FrsNewAreaFragment.this.bJw().bIM() == null) {
                    FrsNewAreaFragment.this.gFm = false;
                    return;
                } else if (FrsNewAreaFragment.this.bJw().bIM().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.gFm = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.gFr = 1L;
            } else if (bVar.isSuccess) {
                this.gFr = 0L;
            } else {
                this.gFr = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.gFj.resetData();
            }
            FrsNewAreaFragment.this.gHH.hu(false);
            if (FrsNewAreaFragment.this.bJw().bIM() != null) {
                FrsNewAreaFragment.this.gnM = FrsNewAreaFragment.this.bJw().bIM();
            }
            FrsNewAreaFragment.this.fsc = FrsNewAreaFragment.this.gnM.getPage().aBk();
            if (FrsNewAreaFragment.this.fsc == 0 && (FrsNewAreaFragment.this.gnM.getThreadListIds() == null || FrsNewAreaFragment.this.gnM.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.gnM.getThreadList() == null || FrsNewAreaFragment.this.gnM.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.gHH.bdt();
                } else {
                    FrsNewAreaFragment.this.gHH.bds();
                }
            } else {
                FrsNewAreaFragment.this.gHH.bdr();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsNewAreaFragment.this.gFj.a(false, false, false, FrsNewAreaFragment.this.gnM.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.gnM.setThreadList(a2);
                    FrsNewAreaFragment.this.gHH.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.gnM, FrsNewAreaFragment.this.fsc);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.gHH.bET();
                    break;
                case 2:
                    FrsNewAreaFragment.this.gHH.bET();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.gnM.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.gFr != 0) {
                FrsNewAreaFragment.this.c(bVar);
            } else {
                if (FrsNewAreaFragment.this.gnM != null) {
                    FrsNewAreaFragment.this.goe = FrsNewAreaFragment.this.gnM.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.gnM.getForum().getId();
                    FrsNewAreaFragment.this.gHH.b(FrsNewAreaFragment.this.gnM.getForum(), FrsNewAreaFragment.this.gnM.getUserData());
                }
                if (FrsNewAreaFragment.this.gnM != null) {
                    FrsNewAreaFragment.this.gnM.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.gnM == null || FrsNewAreaFragment.this.gnM.getThreadList() == null || FrsNewAreaFragment.this.gnM.getThreadList().size() != 0 || FrsNewAreaFragment.this.bJw().getType() != 4) {
                    if (FrsNewAreaFragment.this.gnM != null && (a = FrsNewAreaFragment.this.gFj.a(false, false, true, FrsNewAreaFragment.this.gnM.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.gnM.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bEh();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.fVg > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.fVg, FrsNewAreaFragment.this.bJw().byP() - FrsNewAreaFragment.this.fVg, FrsNewAreaFragment.this.bJw().byN(), FrsNewAreaFragment.this.bJw().byO(), currentTimeMillis2 - FrsNewAreaFragment.this.bJw().byM());
                        FrsNewAreaFragment.this.fVg = -1L;
                    }
                    FrsNewAreaFragment.this.dDE = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.fVg > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.fVg, FrsNewAreaFragment.this.bJw().byP() - FrsNewAreaFragment.this.fVg, FrsNewAreaFragment.this.bJw().byN(), FrsNewAreaFragment.this.bJw().byO(), currentTimeMillis3 - FrsNewAreaFragment.this.bJw().byM());
                FrsNewAreaFragment.this.fVg = -1L;
            }
            FrsNewAreaFragment.this.dDE = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
        }
    };
    private final CustomMessageListener cLG = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.gHH != null) {
                FrsNewAreaFragment.this.gHH.startPullRefresh();
            }
        }
    };
    private final g.c erU = new g.c() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.12
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsNewAreaFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                com.baidu.tieba.a.d.aXF().wN("page_frs_good");
                FrsNewAreaFragment.this.lV(true);
                return;
            }
            FrsNewAreaFragment.this.gHH.hu(false);
        }
    };
    private final g.b dgJ = new g.b() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.s.c.cKa().b(FrsNewAreaFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.gow) {
                FrsNewAreaFragment.this.gow = true;
                FrsNewAreaFragment.this.gHH.bFh();
            }
            if (i == 0) {
                r.bvg().kp(true);
                com.baidu.tieba.s.c.cKa().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.gph += i2;
            if (FrsNewAreaFragment.this.gph >= FrsNewAreaFragment.this.cdv * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener dor = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
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
    private s gpF = new s() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bi)) {
                bj bjVar = ((bi) mVar).cRf;
                if (bjVar.aDl() == null || bjVar.aDl().getGroup_id() == 0 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bjVar.aCY() != 1 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Jo(bjVar.getId())) {
                            readThreadHistory.Jn(bjVar.getId());
                            if (FrsNewAreaFragment.this.gHH != null) {
                                FrsNewAreaFragment.this.gHH.bET();
                            }
                        }
                        boolean z = false;
                        final String aCv = bjVar.aCv();
                        if (aCv != null && !aCv.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aCv);
                                    xVar.aGg().aGH().mIsNeedAddCommenParam = false;
                                    xVar.aGg().aGH().mIsUseCurrentBDUSS = false;
                                    xVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bjVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bjVar.aCj() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aGG().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bjVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, FrsNewAreaFragment.this.goe, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.gnM != null && FrsNewAreaFragment.this.gnM.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.gJm = FrsNewAreaFragment.this.gnM.needLog == 1;
                            bVar.gJo = FrsNewAreaFragment.this.gnM.getForum().getId();
                            bVar.gJn = FrsNewAreaFragment.this.gHG.bJp();
                            if (com.baidu.tieba.frs.d.d.gwq != null) {
                                bVar.gJp = com.baidu.tieba.frs.d.d.gwq.gJp;
                                bVar.gJq = com.baidu.tieba.frs.d.d.gwq.gJq;
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
            this.gHG.al(bjVar);
            this.gHH.scrollToTop();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.gnM = frsViewData;
            hideLoadingView(this.gHH.bsE());
            if (this.gHH != null) {
                this.gHH.hu(false);
                this.gHH.a(null, this.mPn, this.gnM, this.fsc);
            }
        }
    }

    private void showLoadingView() {
        this.gHH.lF(false);
        showLoadingView(this.gHH.bsE(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gHH.lF(true);
        hideLoadingView(this.gHH.bsE());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.gHH.lF(false);
        this.gHH.bGf().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gHH.bdt();
        this.gHH.getListView().getData().clear();
        this.gHH.bET();
        if (this.gtc == null) {
            this.gtc = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.gtc.setTitle(null);
            this.gtc.setButtonText(null);
            this.gtc.showRefreshButton();
            this.gtc.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.gtc.setSubText(getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.gtc.setSubText(null);
        }
        this.gtc.onChangeSkinType();
        this.gtc.attachView(this.gHH.bsE(), true);
        registerListener(this.grg);
    }

    private void bcx() {
        this.gHH.lF(true);
        this.gHH.bGf().setEnabled(true);
        if (this.gtc != null && this.gtc.isViewAttached()) {
            this.gtc.dettachView(this.gHH.bsE());
        }
        MessageManager.getInstance().unRegisterListener(this.grg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV(boolean z) {
        this.fPr = true;
        bEk();
        bcx();
        if (!z) {
            bcx();
            showLoadingView();
        }
        this.gHG.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fVg = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.fVg = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.dDw = this.beginTime - this.fVg;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cKa().w(getUniqueId());
        this.gHG = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.gHG.ad(arguments);
        } else if (bundle != null) {
            this.gHG.ad(bundle);
        } else {
            this.gHG.ad(null);
        }
        this.gol = getVoiceManager();
        this.gol.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.cLG);
        registerListener(this.gFo);
        registerListener(this.gpk);
        this.gFj = new FrsLoadMoreModel(this, null);
        this.gFj.registerListener();
        this.gFj.setPageType(3);
        this.gFj.lX(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cdv = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.gHH = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.fPr) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                lV(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        aGz();
    }

    private void aGz() {
        an anVar = new an("c13008");
        anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cy("fid", this.forumId);
        anVar.X("obj_type", 6);
        anVar.X("obj_locate", 2);
        anVar.aGz();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.gol = getVoiceManager();
        this.gol.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bIC();
        if (bundle != null) {
            this.goe = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.goe = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bIC() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dor);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gHH != null) {
            this.gHH.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.grg);
        com.baidu.tieba.s.c.cKa().x(getUniqueId());
        r.bvg().kp(false);
        super.onDestroy();
        this.gHG.aiI();
        this.gol = getVoiceManager();
        this.gol.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gFn);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.goe);
        bundle.putString("from", this.mFrom);
        this.gHG.onSaveInstanceState(bundle);
        this.gol = getVoiceManager();
        if (this.gol != null) {
            this.gol.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bj threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.gHH.bJy().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.gnM.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.jM(intent.getIntExtra("good_data", 0));
                            threadDataById.aDj();
                            lV(false);
                            return;
                        } else if (intExtra == 0) {
                            this.gnM.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.gnM.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.n());
                            }
                            this.gHH.bIH();
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
            if (this.gvH == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.fPr) {
                com.baidu.adp.lib.f.e.gx().post(this.gFn);
            }
        }
        bFV();
    }

    private void bFV() {
        if (isPrimary()) {
            if (this.gtc != null && this.gtc.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.grg);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.grg);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gHH != null) {
            this.gHH.bET();
        }
        this.gol = getVoiceManager();
        this.gol.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.gHH.a(this.gpF);
        this.gHH.setOnScrollListener(this.mScrollListener);
        this.gHH.setListPullRefreshListener(this.erU);
        this.gHH.a(this.dgJ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gvH != 3 || this.gHH != null) {
            this.gvH = i;
            super.onChangeSkinType(i);
            if (this.gHH != null) {
                this.gHH.onChangeSkinType(i);
            }
            if (this.gtc != null && this.gtc.isViewAttached()) {
                this.gtc.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bDi() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bDi();
        }
        return null;
    }

    private void bEg() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Ji(FrsNewAreaFragment.this.goe);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEh() {
        bEk();
        try {
            if (this.gnM != null) {
                this.gHH.bgy();
                this.goe = this.gnM.getForum().getName();
                this.forumId = this.gnM.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.gnM.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.gnM.getUserData().getBimg_end_time());
                bEg();
                ArrayList<m> threadList = this.gnM.getThreadList();
                if (threadList != null) {
                    this.gHH.a(threadList, this.mPn, this.gnM, this.gnM.getPage().aBk());
                    bIE();
                    this.gHH.bIH();
                    if (this.gnM.getIsNewUrl() == 1) {
                        this.gHH.bJy().setFromCDN(true);
                    } else {
                        this.gHH.bJy().setFromCDN(false);
                    }
                    this.gHH.setListViewSelection(bO(bJw().getType(), this.mPn));
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
        this.gol = getVoiceManager();
        this.gol.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        r.bvg().kp(false);
        com.baidu.tieba.s.c.cKa().b(getUniqueId(), false);
        if (this.gnM != null && this.gnM.getForum() != null) {
            com.baidu.tbadk.distribute.a.aOh().a(getPageContext().getPageActivity(), "frs", this.gnM.getForum().getId(), 0L);
        }
        this.gol = getVoiceManager();
        if (this.gol != null) {
            this.gol.onStop(getPageContext());
        }
    }

    public void bGC() {
        if (this.gHH != null) {
            this.gHH.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(int i) {
        ArrayList<m> threadList = this.gnM.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).cRf;
                    if (bjVar.getId() != null && bjVar.getId().equals(this.gFg)) {
                        c(bjVar, i);
                        this.gFg = null;
                        break;
                    }
                }
            }
            this.gHH.bJy().b(threadList, this.gnM);
            this.gHH.bJy().notifyDataSetChanged();
        }
    }

    private void c(bj bjVar, int i) {
        if (i == 1) {
            PraiseData aBZ = bjVar.aBZ();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aBZ == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bjVar.a(praiseData);
                    return;
                }
                bjVar.aBZ().getUser().add(0, metaData);
                bjVar.aBZ().setNum(bjVar.aBZ().getNum() + 1);
                bjVar.aBZ().setIsLike(i);
            }
        } else if (bjVar.aBZ() != null) {
            bjVar.aBZ().setIsLike(i);
            bjVar.aBZ().setNum(bjVar.aBZ().getNum() - 1);
            ArrayList<MetaData> user = bjVar.aBZ().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bjVar.aBZ().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gol == null) {
            this.gol = VoiceManager.instance();
        }
        return this.gol;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aIh() {
        if (this.gHH == null) {
            return null;
        }
        return this.gHH.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bEk() {
        this.gol = getVoiceManager();
        this.gol.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aIi() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aIi();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.gnM != null && this.gHH != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.gHH.bET();
            }
        }
    }

    private void bIE() {
        HashMap<Integer, bj> bHa;
        if (this.gHH != null && this.gHH.bJy() != null && (bHa = this.gHH.bJy().bHa()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bj> entry : bHa.entrySet()) {
                bj value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.aOn().E(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (aIh() == null) {
            return null;
        }
        return aIh().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            lV(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bEp() {
        return this.gnM;
    }

    public FrsNewAreaModelController bJw() {
        return this.gHG;
    }

    public void Bz(String str) {
        this.goe = str;
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

    public void bcf() {
        if (!this.gFj.isLoading && !this.gHG.isLoading()) {
            if (this.gFj.cn(this.gnM.getThreadListIds())) {
                this.gHH.a(this.gFj.bIZ(), this.mPn, this.gnM, 0);
                this.gFj.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.gnM.getThreadListIds(), this.goe, this.mPn, this.gnM.isBrandForum);
            } else if (this.fsc != 0) {
                this.gHH.a(this.gFj.bIZ(), this.mPn, this.gnM, 0);
                this.mPn++;
                this.gHG.tK(this.mPn);
                this.gFj.loadingDone = false;
                this.gFj.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.gHH.bdt();
        } else if (!this.gHH.bFb()) {
            if (!this.gHG.bIO()) {
                this.gHH.bdt();
                return;
            }
            bcu();
            bcf();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bcu();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void al(ArrayList<m> arrayList) {
        ArrayList<m> a;
        bcu();
        if (arrayList != null && arrayList.size() != 0 && (a = this.gFj.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.gnM.setThreadList(a);
            this.gHH.a(a, this.mPn, this.gnM, 0);
        }
    }

    public void co(List<String> list) {
        cd(list);
        int i = 0;
        Iterator<m> it = this.gnM.getThreadList().iterator();
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
            bcf();
        }
    }

    private void cd(List<String> list) {
        if (!v.isEmpty(list)) {
            ArrayList<m> threadList = this.gnM.getThreadList();
            if (!v.isEmpty(threadList) && this.gHH.getListView() != null && this.gHH.getListView().getData() != null) {
                Iterator<m> it = threadList.iterator();
                List<m> data = this.gHH.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).cRf;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.gFj.d(next);
                                this.gHH.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel bID() {
        return this.gFj;
    }

    private void bcu() {
        if (this.fsc == 0 && !this.gFj.cn(this.gnM.getThreadListIds())) {
            if (this.gnM.getThreadList() == null || this.gnM.getThreadList().size() == 0) {
                this.gHH.bdt();
                return;
            } else {
                this.gHH.bds();
                return;
            }
        }
        this.gHH.bdr();
    }

    public g bJx() {
        return this.gHH;
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
        com.baidu.tbadk.distribute.a.aOh().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bEj() {
        if (this.gHG != null) {
            this.gHG.bEj();
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
    public NavigationBar beL() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.goe;
    }

    @Override // com.baidu.tieba.frs.ah
    public void scrollToTop() {
        if (this.gHH != null && this.gHH.getListView() != null) {
            this.gHH.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void bdq() {
        if (this.gHH != null) {
            scrollToTop();
            this.gHH.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.goJ.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nS(int i) {
        return this.goJ.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.gnM != null) {
            i = this.gnM.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.uh(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }
}
