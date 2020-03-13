package com.baidu.tieba.frs.good;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
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
import com.baidu.adp.lib.f.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.k.a.a;
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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.c;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a.d;
import com.baidu.tieba.card.r;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.data.f;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0078a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, ai, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String gFs;
    private FrsGoodModelController gFu;
    private FrsLoadMoreModel gFv;
    private com.baidu.tieba.frs.gametab.b gFx;
    private VoiceManager goy;
    private c gtp;
    private String mForumId;
    private String gor = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean gFt = false;
    private String forumId = null;
    private FrsViewData gnZ = new FrsViewData();
    public long fVt = -1;
    public long dDJ = 0;
    public long dDR = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean goJ = false;
    protected a gFw = null;
    private int fsp = -1;
    private int mTabId = 0;
    private int gvT = 3;
    private boolean fPE = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> goW = new SparseArray<>();
    private boolean gFy = false;
    private int cdw = 0;
    private int gpu = 0;
    private CustomMessageListener grt = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.gtp != null && FrsGoodFragment.this.gtp.isViewAttached()) {
                FrsGoodFragment.this.gtp.mD(num.intValue());
            }
        }
    };
    private Runnable gFz = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.fPE) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.lV(false);
            }
        }
    };
    private CustomMessageListener gFA = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                FrsGoodFragment.this.gFs = bjVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.gFs) && bjVar.aBZ() != null) {
                    FrsGoodFragment.this.tI(bjVar.aBZ().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener gpx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.aIi() != null) {
                        FrsGoodFragment.this.aIi().setSelection(0);
                    }
                    if (FrsGoodFragment.this.gtp != null && FrsGoodFragment.this.gtp.isViewAttached()) {
                        FrsGoodFragment.this.lV(false);
                    } else if (FrsGoodFragment.this.gFw != null) {
                        FrsGoodFragment.this.gFw.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final p gpM = new p() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        private long gFD = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void sG(int i) {
            if (!FrsGoodFragment.this.gFy) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.gFw.bEU();
                        return;
                    case 3:
                        FrsGoodFragment.this.gFw.hu(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.gFy) {
                if (FrsGoodFragment.this.bIG().bIN() == null) {
                    FrsGoodFragment.this.gFy = false;
                    return;
                } else if (FrsGoodFragment.this.bIG().bIN().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.gFy = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (bVar == null) {
                this.gFD = 1L;
            } else if (bVar.isSuccess) {
                this.gFD = 0L;
            } else {
                this.gFD = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.gFv.resetData();
            }
            FrsGoodFragment.this.gFw.hu(false);
            if (FrsGoodFragment.this.bIG().bIN() != null) {
                FrsGoodFragment.this.gnZ = FrsGoodFragment.this.bIG().bIN();
            }
            FrsGoodFragment.this.fsp = FrsGoodFragment.this.gnZ.getPage().aBk();
            if (FrsGoodFragment.this.fsp == 0 && (FrsGoodFragment.this.gnZ.getThreadListIds() == null || FrsGoodFragment.this.gnZ.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.gnZ.getThreadList() == null || FrsGoodFragment.this.gnZ.getThreadList().size() == 0) {
                    FrsGoodFragment.this.gFw.bdu();
                } else {
                    FrsGoodFragment.this.gFw.bdt();
                }
            } else {
                FrsGoodFragment.this.gFw.bds();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.gFv.a(false, false, false, FrsGoodFragment.this.gnZ.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.gnZ.setThreadList(a2);
                    FrsGoodFragment.this.gFw.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.gnZ, FrsGoodFragment.this.fsp);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.gFw.bEU();
                    break;
                case 2:
                    FrsGoodFragment.this.gFw.bEU();
                    break;
                case 3:
                    if (FrsGoodFragment.this.gnZ.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.gFD != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.gnZ != null) {
                    FrsGoodFragment.this.gor = FrsGoodFragment.this.gnZ.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.gnZ.getForum().getId();
                    FrsGoodFragment.this.gFw.b(FrsGoodFragment.this.gnZ.getForum(), FrsGoodFragment.this.gnZ.getUserData());
                }
                if (FrsGoodFragment.this.gnZ != null) {
                    FrsGoodFragment.this.gnZ.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.gFw.c(FrsGoodFragment.this.gnZ);
                if (FrsGoodFragment.this.gnZ == null || FrsGoodFragment.this.gnZ.getThreadList() == null || FrsGoodFragment.this.gnZ.getThreadList().size() != 0 || FrsGoodFragment.this.bIG().getType() != 4) {
                    if (FrsGoodFragment.this.gnZ != null && (a = FrsGoodFragment.this.gFv.a(false, false, true, FrsGoodFragment.this.gnZ.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.gnZ.setThreadList(a);
                    }
                    FrsGoodFragment.this.bEi();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.fVt > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.fVt, FrsGoodFragment.this.bIG().byQ() - FrsGoodFragment.this.fVt, FrsGoodFragment.this.bIG().byO(), FrsGoodFragment.this.bIG().byP(), currentTimeMillis2 - FrsGoodFragment.this.bIG().byN());
                        FrsGoodFragment.this.fVt = -1L;
                    }
                    FrsGoodFragment.this.dDR = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.fVt > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.fVt, FrsGoodFragment.this.bIG().byQ() - FrsGoodFragment.this.fVt, FrsGoodFragment.this.bIG().byO(), FrsGoodFragment.this.bIG().byP(), currentTimeMillis3 - FrsGoodFragment.this.bIG().byN());
                FrsGoodFragment.this.fVt = -1L;
            }
            FrsGoodFragment.this.dDR = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(l lVar) {
        }
    };
    private final CustomMessageListener cLH = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.gFw != null) {
                FrsGoodFragment.this.gFw.startPullRefresh();
            }
        }
    };
    private final g.c esh = new g.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.isNetWorkAvailable()) {
                d.aXG().wO("page_frs_good");
                FrsGoodFragment.this.lV(true);
                return;
            }
            FrsGoodFragment.this.gFw.hu(false);
        }
    };
    private final g.b dgW = new g.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.s.c.cKb().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.goJ) {
                FrsGoodFragment.this.goJ = true;
                FrsGoodFragment.this.gFw.bFi();
            }
            if (i == 0) {
                r.bvh().kp(true);
                com.baidu.tieba.s.c.cKb().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.gpu += i2;
            if (FrsGoodFragment.this.gpu >= FrsGoodFragment.this.cdw * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener doF = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                FrsGoodFragment.this.f(customResponsedMessage);
            }
        }
    };
    private s gpS = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bi)) {
                bj bjVar = ((bi) mVar).cRg;
                if (bjVar.aDl() == null || bjVar.aDl().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bjVar.aCY() != 1 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Jp(bjVar.getId())) {
                            readThreadHistory.Jo(bjVar.getId());
                            if (FrsGoodFragment.this.gFw != null) {
                                FrsGoodFragment.this.gFw.bEU();
                            }
                        }
                        boolean z = false;
                        final String aCv = bjVar.aCv();
                        if (aCv != null && !aCv.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aCv);
                                    xVar.aGg().aGH().mIsNeedAddCommenParam = false;
                                    xVar.aGg().aGH().mIsUseCurrentBDUSS = false;
                                    xVar.getNetData();
                                }
                            }).start();
                        }
                        String str = null;
                        if (bjVar != null) {
                            str = bjVar.getTid();
                        }
                        if (str == null) {
                            str = "";
                        }
                        if (bjVar.aCj() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aGG().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3) {
                            bjVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, FrsGoodFragment.this.gor, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.gnZ != null && FrsGoodFragment.this.gnZ.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.gJy = FrsGoodFragment.this.gnZ.needLog == 1;
                            bVar.gJA = FrsGoodFragment.this.gnZ.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.gwC != null) {
                                bVar.gJB = com.baidu.tieba.frs.d.d.gwC.gJB;
                                bVar.gJC = com.baidu.tieba.frs.d.d.gwC.gJC;
                            }
                            com.baidu.tieba.frs.d.a.a(bjVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gpW = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.gFw != null) {
                FrsGoodFragment.this.gFw.sm();
            }
        }
    };

    static /* synthetic */ int j(FrsGoodFragment frsGoodFragment) {
        int i = frsGoodFragment.mPn;
        frsGoodFragment.mPn = i - 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    private void showLoadingView() {
        this.gFw.lF(false);
        showLoadingView(this.gFw.bsF(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gFw.lF(true);
        hideLoadingView(this.gFw.bsF());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.gFw.lF(false);
        this.gFw.bGg().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gFw.bdu();
        this.gFw.getListView().getData().clear();
        this.gFw.bEU();
        if (this.gtp == null) {
            this.gtp = new c(getPageContext().getContext(), getNetRefreshListener());
            this.gtp.setTitle(null);
            this.gtp.setButtonText(null);
            this.gtp.showRefreshButton();
            this.gtp.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bVar != null) {
            this.gtp.setSubText(getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
        } else {
            this.gtp.setSubText(null);
        }
        this.gtp.onChangeSkinType();
        this.gtp.attachView(this.gFw.bsF(), true);
        registerListener(this.grt);
    }

    private void bcy() {
        this.gFw.lF(true);
        this.gFw.bGg().setEnabled(true);
        if (this.gtp != null && this.gtp.isViewAttached()) {
            this.gtp.dettachView(this.gFw.bsF());
        }
        MessageManager.getInstance().unRegisterListener(this.grt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV(boolean z) {
        this.fPE = true;
        bEl();
        bcy();
        if (!z) {
            bcy();
            showLoadingView();
        }
        this.gFu.oF(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fVt = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.fVt = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.dDJ = this.beginTime - this.fVt;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cKb().w(getUniqueId());
        this.gFu = new FrsGoodModelController(this);
        if (arguments != null) {
            this.gFu.ad(arguments);
            this.gFt = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.gFu.ad(bundle);
            this.gFt = bundle.getBoolean("is_game_frs", false);
        } else {
            this.gFu.ad(null);
        }
        this.goy = getVoiceManager();
        this.goy.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.cLH);
        registerListener(this.gFA);
        registerListener(this.gpx);
        registerListener(this.gpW);
        this.gFv = new FrsLoadMoreModel(this, null);
        this.gFv.registerListener();
        this.gFv.setPageType(2);
        this.gFv.lX(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cdw = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.gFw = new a(this, inflate, this.gFt);
        this.gFw.bIK().bIQ();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.fPE) {
            if (j.isNetWorkAvailable()) {
                lV(false);
            } else {
                c((e.b) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").cy("fid", this.mForumId).cy("obj_type", "7").X("obj_locate", 2).cy("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.goy = getVoiceManager();
        this.goy.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bID();
        if (bundle != null) {
            this.gor = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.gor = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bID() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.doF);
    }

    public FrsLoadMoreModel bIE() {
        return this.gFv;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gFw != null) {
            this.gFw.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.grt);
        com.baidu.tieba.s.c.cKb().x(getUniqueId());
        r.bvh().kp(false);
        super.onDestroy();
        this.gFu.aiI();
        this.goy = getVoiceManager();
        this.goy.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gFz);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.gor);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.gFt);
        this.gFu.onSaveInstanceState(bundle);
        this.goy = getVoiceManager();
        if (this.goy != null) {
            this.goy.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bj threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.gFw.bIK().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.gnZ.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.jM(intent.getIntExtra("good_data", 0));
                            threadDataById.aDj();
                            lV(false);
                            return;
                        } else if (intExtra == 0) {
                            this.gnZ.removeThreadData(threadDataById);
                            ArrayList<m> threadList = this.gnZ.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.n());
                            }
                            this.gFw.bII();
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
            if (this.gvT == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.fPE) {
                com.baidu.adp.lib.f.e.gx().post(this.gFz);
            }
        }
        bFW();
    }

    private void bFW() {
        if (isPrimary()) {
            if (this.gtp != null && this.gtp.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.grt);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.grt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gFw != null) {
            this.gFw.bEU();
        }
        this.goy = getVoiceManager();
        this.goy.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.gFx = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.gFw.a(this.gpS);
        this.gFw.setOnScrollListener(this.mScrollListener);
        this.gFw.setListPullRefreshListener(this.esh);
        this.gFw.a(this.dgW);
        this.gFw.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.gFx != null) {
                    FrsGoodFragment.this.gFx.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gvT != 3 || this.gFw != null) {
            this.gvT = i;
            super.onChangeSkinType(i);
            if (this.gFw != null) {
                this.gFw.onChangeSkinType(i);
            }
            if (this.gtp != null && this.gtp.isViewAttached()) {
                this.gtp.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bDj() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bDj();
        }
        return null;
    }

    private void bEh() {
        switch (this.mFlag) {
            case 1:
                h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Jj(FrsGoodFragment.this.gor);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEi() {
        bEl();
        try {
            if (this.gnZ != null) {
                this.gFw.bgz();
                this.gor = this.gnZ.getForum().getName();
                this.forumId = this.gnZ.getForum().getId();
                if (this.gnZ != null && this.gnZ.getForum() != null) {
                    this.gFw.a(this.gnZ.getForum().getThemeColorInfo());
                    this.gFw.c(this.gnZ);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.gnZ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.gnZ.getUserData().getBimg_end_time());
                bEh();
                if (!this.gFw.bIK().p(bj.cRB)) {
                    this.gnZ.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.gnZ.getThreadList();
                if (threadList != null) {
                    this.gFw.a(threadList, this.mPn, this.gnZ, this.gnZ.getPage().aBk());
                    bIF();
                    this.gFw.bII();
                    if (this.gnZ.getIsNewUrl() == 1) {
                        this.gFw.bIK().setFromCDN(true);
                    } else {
                        this.gFw.bIK().setFromCDN(false);
                    }
                    this.gFw.setListViewSelection(bO(bIG().getType(), this.mPn));
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
        this.goy = getVoiceManager();
        this.goy.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        r.bvh().kp(false);
        com.baidu.tieba.s.c.cKb().b(getUniqueId(), false);
        if (this.gnZ != null && this.gnZ.getForum() != null) {
            com.baidu.tbadk.distribute.a.aOi().a(getPageContext().getPageActivity(), "frs", this.gnZ.getForum().getId(), 0L);
        }
        this.goy = getVoiceManager();
        if (this.goy != null) {
            this.goy.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(int i) {
        ArrayList<m> threadList = this.gnZ.getThreadList();
        if (threadList != null) {
            Iterator<m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).cRg;
                    if (bjVar.getId() != null && bjVar.getId().equals(this.gFs)) {
                        c(bjVar, i);
                        this.gFs = null;
                        break;
                    }
                }
            }
            this.gFw.bIK().b(threadList, this.gnZ);
            this.gFw.bIK().notifyDataSetChanged();
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
        if (this.goy == null) {
            this.goy = VoiceManager.instance();
        }
        return this.goy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aIi() {
        if (this.gFw == null) {
            return null;
        }
        return this.gFw.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bEl() {
        this.goy = getVoiceManager();
        this.goy.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aIj() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aIj();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.gnZ != null && this.gFw != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.gFw.bEU();
            }
        }
    }

    private void bIF() {
        HashMap<Integer, bj> bHb;
        if (this.gFw != null && this.gFw.bIK() != null && (bHb = this.gFw.bIK().bHb()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bj> entry : bHb.entrySet()) {
                bj value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.aOo().E(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (aIi() == null) {
            return null;
        }
        return aIi().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            lV(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bEq() {
        return this.gnZ;
    }

    public FrsGoodModelController bIG() {
        return this.gFu;
    }

    public void BA(String str) {
        this.gor = str;
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
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.gFw.bdu();
        } else if (!this.gFu.bIP()) {
            this.gFw.bdu();
        } else {
            bcv();
            if (!this.gFv.isLoading && !this.gFu.isLoading()) {
                if (this.gFv.cn(this.gnZ.getThreadListIds())) {
                    this.gFw.a(this.gFv.bJa(), this.mPn, this.gnZ, 0);
                    this.gFv.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.gnZ.getThreadListIds(), this.gor, this.mPn, this.gnZ.isBrandForum);
                } else if (this.fsp != 0) {
                    this.gFw.a(this.gFv.bJa(), this.mPn, this.gnZ, 0);
                    this.mPn++;
                    this.gFu.tK(this.mPn);
                    this.gFv.loadingDone = false;
                    this.gFv.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bcv();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void al(ArrayList<m> arrayList) {
        ArrayList<m> a;
        bcv();
        if (arrayList != null && arrayList.size() != 0 && (a = this.gFv.a(false, false, false, arrayList, (f) null)) != null) {
            this.gnZ.setThreadList(a);
            this.gFw.a(a, this.mPn, this.gnZ, 0);
        }
    }

    private void bcv() {
        if (this.fsp == 0 && !this.gFv.cn(this.gnZ.getThreadListIds())) {
            if (this.gnZ.getThreadList() == null || this.gnZ.getThreadList().size() == 0) {
                this.gFw.bdu();
                return;
            } else {
                this.gFw.bdt();
                return;
            }
        }
        this.gFw.bds();
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
        com.baidu.tbadk.distribute.a.aOi().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void bEk() {
        if (this.gFu != null) {
            this.gFu.bEk();
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
    public NavigationBar beM() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.gor;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.gnZ != null) {
            i = this.gnZ.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.uh(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tJ(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            lV(false);
        } else {
            c((e.b) null);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void scrollToTop() {
        if (this.gFw != null && this.gFw.getListView() != null) {
            this.gFw.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void bdr() {
        if (this.gFw != null) {
            scrollToTop();
            this.gFw.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.goW.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nS(int i) {
        return this.goW.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }
}
