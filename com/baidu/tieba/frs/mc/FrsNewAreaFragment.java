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
import com.baidu.adp.widget.ListView.v;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, al, am, an, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.recapp.m, FrsCommonImageLayout.c {
    private VoiceManager gYp;
    private com.baidu.tbadk.k.c hde;
    private String hpI;
    private FrsLoadMoreModel hpL;
    private FrsNewAreaModelController hsj;
    private String gYi = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData gXO = new FrsViewData();
    public long gAV = -1;
    public long edE = 0;
    public long edO = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean gYA = false;
    protected g hsk = null;
    private int fXj = -1;
    private int hfL = 3;
    private boolean guT = false;
    private boolean hpO = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gYN = new SparseArray<>();
    private int cCF = 0;
    private int gZl = 0;
    private CustomMessageListener hbp = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.hde != null && FrsNewAreaFragment.this.hde.isViewAttached()) {
                FrsNewAreaFragment.this.hde.mQ(num.intValue());
            }
        }
    };
    private Runnable hpP = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.guT) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.ne(false);
            }
        }
    };
    private CustomMessageListener hpQ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                FrsNewAreaFragment.this.hpI = bjVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.hpI) && bjVar.aKp() != null) {
                    FrsNewAreaFragment.this.ul(bjVar.aKp().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener gZo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.aQI() != null) {
                        FrsNewAreaFragment.this.aQI().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.hde != null && FrsNewAreaFragment.this.hde.isViewAttached()) {
                        FrsNewAreaFragment.this.ne(false);
                    } else if (FrsNewAreaFragment.this.hsk != null) {
                        FrsNewAreaFragment.this.hsk.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final q gZD = new q() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        private long hpT = 1;

        @Override // com.baidu.tieba.tbadkCore.q
        public void tf(int i) {
            if (!FrsNewAreaFragment.this.hpO) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.hsk.bPE();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.hsk.it(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (FrsNewAreaFragment.this.hpO) {
                if (FrsNewAreaFragment.this.bUh().bTw() == null) {
                    FrsNewAreaFragment.this.hpO = false;
                    return;
                } else if (FrsNewAreaFragment.this.bUh().bTw().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.hpO = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.hpT = 1L;
            } else if (fVar.isSuccess) {
                this.hpT = 0L;
            } else {
                this.hpT = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsNewAreaFragment.this.hpL.resetData();
            }
            FrsNewAreaFragment.this.hsk.it(false);
            if (FrsNewAreaFragment.this.bUh().bTw() != null) {
                FrsNewAreaFragment.this.gXO = FrsNewAreaFragment.this.bUh().bTw();
            }
            FrsNewAreaFragment.this.fXj = FrsNewAreaFragment.this.gXO.getPage().aJA();
            if (FrsNewAreaFragment.this.fXj == 0 && (FrsNewAreaFragment.this.gXO.getThreadListIds() == null || FrsNewAreaFragment.this.gXO.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.gXO.getThreadList() == null || FrsNewAreaFragment.this.gXO.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.hsk.bmq();
                } else {
                    FrsNewAreaFragment.this.hsk.bmp();
                }
            } else {
                FrsNewAreaFragment.this.hsk.bmo();
            }
            if (i == 4) {
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsNewAreaFragment.this.hpL.a(false, false, false, FrsNewAreaFragment.this.gXO.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsNewAreaFragment.this.gXO.setThreadList(a2);
                    FrsNewAreaFragment.this.hsk.a(a2, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.gXO, FrsNewAreaFragment.this.fXj);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.hsk.bPE();
                    break;
                case 2:
                    FrsNewAreaFragment.this.hsk.bPE();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.gXO.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.hpT != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.gXO != null) {
                    FrsNewAreaFragment.this.gYi = FrsNewAreaFragment.this.gXO.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.gXO.getForum().getId();
                    FrsNewAreaFragment.this.hsk.b(FrsNewAreaFragment.this.gXO.getForum(), FrsNewAreaFragment.this.gXO.getUserData());
                }
                if (FrsNewAreaFragment.this.gXO != null) {
                    FrsNewAreaFragment.this.gXO.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.gXO == null || FrsNewAreaFragment.this.gXO.getThreadList() == null || FrsNewAreaFragment.this.gXO.getThreadList().size() != 0 || FrsNewAreaFragment.this.bUh().getType() != 4) {
                    if (FrsNewAreaFragment.this.gXO != null && (a = FrsNewAreaFragment.this.hpL.a(false, false, true, FrsNewAreaFragment.this.gXO.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsNewAreaFragment.this.gXO.setThreadList(a);
                    }
                    FrsNewAreaFragment.this.bOQ();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.gAV > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.gAV, FrsNewAreaFragment.this.bUh().bIY() - FrsNewAreaFragment.this.gAV, FrsNewAreaFragment.this.bUh().bIW(), FrsNewAreaFragment.this.bUh().bIX(), currentTimeMillis2 - FrsNewAreaFragment.this.bUh().bIV());
                        FrsNewAreaFragment.this.gAV = -1L;
                    }
                    FrsNewAreaFragment.this.edO = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.gAV > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.gAV, FrsNewAreaFragment.this.bUh().bIY() - FrsNewAreaFragment.this.gAV, FrsNewAreaFragment.this.bUh().bIW(), FrsNewAreaFragment.this.bUh().bIX(), currentTimeMillis3 - FrsNewAreaFragment.this.bUh().bIV());
                FrsNewAreaFragment.this.gAV = -1L;
            }
            FrsNewAreaFragment.this.edO = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }
    };
    private final CustomMessageListener dkZ = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.hsk != null) {
                FrsNewAreaFragment.this.hsk.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.gYA) {
                FrsNewAreaFragment.this.gYA = true;
                FrsNewAreaFragment.this.hsk.bPT();
            }
            if (i == 0) {
                r.bEY().lx(true);
                com.baidu.tieba.s.c.cVr().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.gZl += i2;
            if (FrsNewAreaFragment.this.gZl >= FrsNewAreaFragment.this.cCF * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener dOK = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
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
    private v gZK = new v() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.v
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bi)) {
                bj bjVar = ((bi) mVar).dqA;
                if (bjVar.aLB() == null || bjVar.aLB().getGroup_id() == 0 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bjVar.aLo() != 1 || bc.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.KY(bjVar.getId())) {
                            readThreadHistory.KX(bjVar.getId());
                            if (FrsNewAreaFragment.this.hsk != null) {
                                FrsNewAreaFragment.this.hsk.bPE();
                            }
                        }
                        boolean z = false;
                        final String aKL = bjVar.aKL();
                        if (aKL != null && !aKL.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aKL);
                                    xVar.aOy().aOZ().mIsNeedAddCommenParam = false;
                                    xVar.aOy().aOZ().mIsUseCurrentBDUSS = false;
                                    xVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bjVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bjVar.aKz() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aOY().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bjVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, FrsNewAreaFragment.this.gYi, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.gXO != null && FrsNewAreaFragment.this.gXO.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.htU = FrsNewAreaFragment.this.gXO.needLog == 1;
                            bVar.htW = FrsNewAreaFragment.this.gXO.getForum().getId();
                            bVar.htV = FrsNewAreaFragment.this.hsj.bUa();
                            if (com.baidu.tieba.frs.d.d.hgG != null) {
                                bVar.htX = com.baidu.tieba.frs.d.d.hgG.htX;
                                bVar.htY = com.baidu.tieba.frs.d.d.hgG.htY;
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

    public void ao(bj bjVar) {
        if (bjVar != null) {
            this.hsj.ao(bjVar);
            this.hsk.bOe();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.gXO = frsViewData;
            hideLoadingView(this.hsk.bCt());
            if (this.hsk != null) {
                this.hsk.it(false);
                this.hsk.a(null, this.mPn, this.gXO, this.fXj);
            }
        }
    }

    private void showLoadingView() {
        this.hsk.mO(false);
        showLoadingView(this.hsk.bCt(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.hsk.mO(true);
        hideLoadingView(this.hsk.bCt());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.hsk.mO(false);
        this.hsk.mN(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hsk.bmq();
        this.hsk.getListView().getData().clear();
        this.hsk.bPE();
        if (this.hde == null) {
            this.hde = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hde.setTitle(null);
            this.hde.setButtonText(null);
            this.hde.showRefreshButton();
            this.hde.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hde.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hde.setSubText(null);
        }
        this.hde.onChangeSkinType();
        this.hde.attachView(this.hsk.bCt(), true);
        registerListener(this.hbp);
    }

    private void blt() {
        this.hsk.mO(true);
        this.hsk.mN(true);
        if (this.hde != null && this.hde.isViewAttached()) {
            this.hde.dettachView(this.hsk.bCt());
        }
        MessageManager.getInstance().unRegisterListener(this.hbp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(boolean z) {
        this.guT = true;
        bOT();
        blt();
        if (!z) {
            blt();
            showLoadingView();
        }
        this.hsj.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gAV = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.gAV = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.edE = this.beginTime - this.gAV;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cVr().w(getUniqueId());
        this.hsj = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.hsj.ad(arguments);
        } else if (bundle != null) {
            this.hsj.ad(bundle);
        } else {
            this.hsj.ad(null);
        }
        this.gYp = getVoiceManager();
        this.gYp.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dkZ);
        registerListener(this.hpQ);
        registerListener(this.gZo);
        this.hpL = new FrsLoadMoreModel(this, null);
        this.hpL.registerListener();
        this.hpL.setPageType(3);
        this.hpL.ng(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cCF = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.hsk = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.guT) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                ne(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        aOR();
    }

    private void aOR() {
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13008");
        anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cI("fid", this.forumId);
        anVar.af("obj_type", 6);
        anVar.af("obj_locate", 2);
        anVar.aOR();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.gYp = getVoiceManager();
        this.gYp.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        bTm();
        if (bundle != null) {
            this.gYi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.gYi = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void bTm() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dOK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hsk != null) {
            this.hsk.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hbp);
        com.baidu.tieba.s.c.cVr().x(getUniqueId());
        r.bEY().lx(false);
        super.onDestroy();
        this.hsj.aqT();
        this.gYp = getVoiceManager();
        this.gYp.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hpP);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.gYi);
        bundle.putString("from", this.mFrom);
        this.hsj.onSaveInstanceState(bundle);
        this.gYp = getVoiceManager();
        if (this.gYp != null) {
            this.gYp.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bj threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.hsk.bUj().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.gXO.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.jT(intent.getIntExtra("good_data", 0));
                            threadDataById.aLz();
                            ne(false);
                            return;
                        } else if (intExtra == 0) {
                            this.gXO.removeThreadData(threadDataById);
                            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXO.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new p());
                            }
                            this.hsk.bTr();
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
            if (this.hfL == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.guT) {
                com.baidu.adp.lib.f.e.lb().post(this.hpP);
            }
        }
        bQJ();
    }

    private void bQJ() {
        if (isPrimary()) {
            if (this.hde != null && this.hde.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hbp);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hbp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hsk != null) {
            this.hsk.bPE();
        }
        this.gYp = getVoiceManager();
        this.gYp.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.hsk.a(this.gZK);
        this.hsk.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hfL != 3 || this.hsk != null) {
            this.hfL = i;
            super.onChangeSkinType(i);
            if (this.hsk != null) {
                this.hsk.onChangeSkinType(i);
            }
            if (this.hde != null && this.hde.isViewAttached()) {
                this.hde.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bNP() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bNP();
        }
        return null;
    }

    private void bOP() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.lc().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.KS(FrsNewAreaFragment.this.gYi);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOQ() {
        bOT();
        try {
            if (this.gXO != null) {
                this.hsk.bQT();
                this.hsk.bpV();
                this.gYi = this.gXO.getForum().getName();
                this.forumId = this.gXO.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.gXO.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.gXO.getUserData().getBimg_end_time());
                bOP();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXO.getThreadList();
                if (threadList != null) {
                    this.hsk.a(threadList, this.mPn, this.gXO, this.gXO.getPage().aJA());
                    bTo();
                    this.hsk.bTr();
                    if (this.gXO.getIsNewUrl() == 1) {
                        this.hsk.bUj().setFromCDN(true);
                    } else {
                        this.hsk.bUj().setFromCDN(false);
                    }
                    this.hsk.setListViewSelection(bV(bUh().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int bV(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gYp = getVoiceManager();
        this.gYp.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        r.bEY().lx(false);
        com.baidu.tieba.s.c.cVr().b(getUniqueId(), false);
        if (this.gXO != null && this.gXO.getForum() != null) {
            com.baidu.tbadk.distribute.a.aWD().a(getPageContext().getPageActivity(), "frs", this.gXO.getForum().getId(), 0L);
        }
        this.gYp = getVoiceManager();
        if (this.gYp != null) {
            this.gYp.onStop(getPageContext());
        }
    }

    public void bRq() {
        if (this.hsk != null) {
            this.hsk.refreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul(int i) {
        ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXO.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof bi) {
                    bj bjVar = ((bi) next).dqA;
                    if (bjVar.getId() != null && bjVar.getId().equals(this.hpI)) {
                        c(bjVar, i);
                        this.hpI = null;
                        break;
                    }
                }
            }
            this.hsk.bUj().b(threadList, this.gXO);
            this.hsk.bUj().notifyDataSetChanged();
        }
    }

    private void c(bj bjVar, int i) {
        if (i == 1) {
            PraiseData aKp = bjVar.aKp();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aKp == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bjVar.a(praiseData);
                    return;
                }
                bjVar.aKp().getUser().add(0, metaData);
                bjVar.aKp().setNum(bjVar.aKp().getNum() + 1);
                bjVar.aKp().setIsLike(i);
            }
        } else if (bjVar.aKp() != null) {
            bjVar.aKp().setIsLike(i);
            bjVar.aKp().setNum(bjVar.aKp().getNum() - 1);
            ArrayList<MetaData> user = bjVar.aKp().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bjVar.aKp().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gYp == null) {
            this.gYp = VoiceManager.instance();
        }
        return this.gYp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aQI() {
        if (this.hsk == null) {
            return null;
        }
        return this.hsk.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bOT() {
        this.gYp = getVoiceManager();
        this.gYp.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aQJ() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aQJ();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.gXO != null && this.hsk != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.hsk.bPE();
            }
        }
    }

    private void bTo() {
        HashMap<Integer, bj> bRR;
        if (this.hsk != null && this.hsk.bUj() != null && (bRR = this.hsk.bUj().bRR()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bj> entry : bRR.entrySet()) {
                bj value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.aWJ().E(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (aQI() == null) {
            return null;
        }
        return aQI().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            ne(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bOY() {
        return this.gXO;
    }

    public FrsNewAreaModelController bUh() {
        return this.hsj;
    }

    public void Dk(String str) {
        this.gYi = str;
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

    public void blb() {
        if (!this.hpL.isLoading && !this.hsj.isLoading()) {
            if (this.hpL.cz(this.gXO.getThreadListIds())) {
                this.hsk.a(this.hpL.bTJ(), this.mPn, this.gXO, 0);
                this.hpL.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.gXO.getThreadListIds(), this.gYi, this.mPn, this.gXO.isBrandForum);
            } else if (this.fXj != 0) {
                this.hsk.a(this.hpL.bTJ(), this.mPn, this.gXO, 0);
                this.mPn++;
                this.hsj.un(this.mPn);
                this.hpL.loadingDone = false;
                this.hpL.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.hsk.bmq();
        } else if (!this.hsk.bPN()) {
            if (!this.hsj.bTy()) {
                this.hsk.bmq();
                return;
            }
            blq();
            blb();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        blq();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void an(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.m> a;
        blq();
        if (arrayList != null && arrayList.size() != 0 && (a = this.hpL.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.gXO.setThreadList(a);
            this.hsk.a(a, this.mPn, this.gXO, 0);
        }
    }

    public void cA(List<String> list) {
        cp(list);
        int i = 0;
        Iterator<com.baidu.adp.widget.ListView.m> it = this.gXO.getThreadList().iterator();
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
            blb();
        }
    }

    private void cp(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXO.getThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(threadList) && this.hsk.getListView() != null && this.hsk.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.hsk.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).dqA;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hpL.d(next);
                                this.hsk.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel bTn() {
        return this.hpL;
    }

    private void blq() {
        if (this.fXj == 0 && !this.hpL.cz(this.gXO.getThreadListIds())) {
            if (this.gXO.getThreadList() == null || this.gXO.getThreadList().size() == 0) {
                this.hsk.bmq();
                return;
            } else {
                this.hsk.bmp();
                return;
            }
        }
        this.hsk.bmo();
    }

    public g bUi() {
        return this.hsk;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.h.a.a.InterfaceC0100a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.checkCamera(getActivity().getApplicationContext())) {
                com.baidu.tbadk.core.util.al.e(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.m
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.aWD().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.m
    public void bOS() {
        if (this.hsj != null) {
            this.hsj.bOS();
        }
    }

    @Override // com.baidu.tieba.recapp.m
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.m
    public int getPageNum() {
        return this.mPn;
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar boh() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.gYi;
    }

    @Override // com.baidu.tieba.frs.al
    public void bOe() {
        if (this.hsk != null && this.hsk.getListView() != null) {
            this.hsk.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bmn() {
        if (this.hsk != null) {
            bOe();
            this.hsk.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.gYN.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oh(int i) {
        return this.gYN.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.gXO != null) {
            i = this.gXO.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.uK(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.an
    public void aQn() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bfP().yb("page_frs_good");
            ne(true);
            return;
        }
        this.hsk.it(false);
    }

    @Override // com.baidu.tieba.frs.an
    public void aQo() {
        com.baidu.tieba.s.c.cVr().b(getUniqueId(), false);
    }
}
