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
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.t;
import com.baidu.adp.widget.ListView.z;
import com.baidu.h.a.a;
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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.c;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.f;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.tbadkCore.util.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0127a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aq, ar, as, com.baidu.tieba.frs.loadmore.a, m, FrsCommonImageLayout.c {
    private c hEZ;
    private String hSC;
    private FrsGoodModelController hSE;
    private FrsLoadMoreModel hSF;
    private com.baidu.tieba.frs.gametab.b hSH;
    private VoiceManager hzJ;
    private String mForumId;
    private String hzC = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean hSD = false;
    private String forumId = null;
    private FrsViewData hzi = new FrsViewData();
    public long hcE = -1;
    public long eAO = 0;
    public long eAY = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean hzW = false;
    protected a hSG = null;
    private int gzh = -1;
    private int mTabId = 0;
    private int hHG = 3;
    private boolean gWV = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hAj = new SparseArray<>();
    private boolean hSI = false;
    private int cTi = 0;
    private int hAH = 0;
    private CustomMessageListener hDd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.hEZ != null && FrsGoodFragment.this.hEZ.isViewAttached()) {
                FrsGoodFragment.this.hEZ.nP(num.intValue());
            }
        }
    };
    private Runnable hSJ = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.gWV) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.nL(false);
            }
        }
    };
    private CustomMessageListener hSK = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bu)) {
                bu buVar = (bu) customResponsedMessage.getData();
                FrsGoodFragment.this.hSC = buVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.hSC) && buVar.aSa() != null) {
                    FrsGoodFragment.this.vx(buVar.aSa().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener hAR = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.aYH() != null) {
                        FrsGoodFragment.this.aYH().setSelection(0);
                    }
                    if (FrsGoodFragment.this.hEZ != null && FrsGoodFragment.this.hEZ.isViewAttached()) {
                        FrsGoodFragment.this.nL(false);
                    } else if (FrsGoodFragment.this.hSG != null) {
                        FrsGoodFragment.this.hSG.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final q hBi = new q() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long hSN = 1;

        @Override // com.baidu.tieba.tbadkCore.q
        public void uo(int i) {
            if (!FrsGoodFragment.this.hSI) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.hSG.bZk();
                        return;
                    case 3:
                        FrsGoodFragment.this.hSG.jc(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void a(int i, boolean z, f fVar) {
            ArrayList<com.baidu.adp.widget.ListView.q> a;
            if (FrsGoodFragment.this.hSI) {
                if (FrsGoodFragment.this.cdg().cdo() == null) {
                    FrsGoodFragment.this.hSI = false;
                    return;
                } else if (FrsGoodFragment.this.cdg().cdo().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.hSI = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.hSN = 1L;
            } else if (fVar.isSuccess) {
                this.hSN = 0L;
            } else {
                this.hSN = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.hSF.resetData();
            }
            FrsGoodFragment.this.hSG.jc(false);
            if (FrsGoodFragment.this.cdg().cdo() != null) {
                FrsGoodFragment.this.hzi = FrsGoodFragment.this.cdg().cdo();
            }
            FrsGoodFragment.this.gzh = FrsGoodFragment.this.hzi.getPage().aRf();
            if (FrsGoodFragment.this.gzh == 0 && (FrsGoodFragment.this.hzi.getThreadListIds() == null || FrsGoodFragment.this.hzi.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.hzi.getThreadList() == null || FrsGoodFragment.this.hzi.getThreadList().size() == 0) {
                    FrsGoodFragment.this.hSG.buL();
                } else {
                    FrsGoodFragment.this.hSG.buK();
                }
            } else {
                FrsGoodFragment.this.hSG.buJ();
            }
            if (i == 4) {
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsGoodFragment.this.hSF.a(false, false, false, FrsGoodFragment.this.hzi.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.hzi.setThreadList(a2);
                    FrsGoodFragment.this.hSG.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.hzi, FrsGoodFragment.this.gzh);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.hSG.bZk();
                    break;
                case 2:
                    FrsGoodFragment.this.hSG.bZk();
                    break;
                case 3:
                    if (FrsGoodFragment.this.hzi.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.hSN != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.hzi != null) {
                    FrsGoodFragment.this.hzC = FrsGoodFragment.this.hzi.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.hzi.getForum().getId();
                    FrsGoodFragment.this.hSG.b(FrsGoodFragment.this.hzi.getForum(), FrsGoodFragment.this.hzi.getUserData());
                }
                if (FrsGoodFragment.this.hzi != null) {
                    FrsGoodFragment.this.hzi.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.hSG.c(FrsGoodFragment.this.hzi);
                if (FrsGoodFragment.this.hzi == null || FrsGoodFragment.this.hzi.getThreadList() == null || FrsGoodFragment.this.hzi.getThreadList().size() != 0 || FrsGoodFragment.this.cdg().getType() != 4) {
                    if (FrsGoodFragment.this.hzi != null && (a = FrsGoodFragment.this.hSF.a(false, false, true, FrsGoodFragment.this.hzi.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.hzi.setThreadList(a);
                    }
                    FrsGoodFragment.this.bYu();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.hcE > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.hcE, FrsGoodFragment.this.cdg().bSw() - FrsGoodFragment.this.hcE, FrsGoodFragment.this.cdg().bSu(), FrsGoodFragment.this.cdg().bSv(), currentTimeMillis2 - FrsGoodFragment.this.cdg().bSt());
                        FrsGoodFragment.this.hcE = -1L;
                    }
                    FrsGoodFragment.this.eAY = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.hcE > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.hcE, FrsGoodFragment.this.cdg().bSw() - FrsGoodFragment.this.hcE, FrsGoodFragment.this.cdg().bSu(), FrsGoodFragment.this.cdg().bSv(), currentTimeMillis3 - FrsGoodFragment.this.cdg().bSt());
                FrsGoodFragment.this.hcE = -1L;
            }
            FrsGoodFragment.this.eAY = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void bYo() {
        }
    };
    private final CustomMessageListener dFw = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.hSG != null) {
                FrsGoodFragment.this.hSG.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.hzW) {
                FrsGoodFragment.this.hzW = true;
                FrsGoodFragment.this.hSG.bZz();
            }
            if (i == 0) {
                s.bOB().mc(true);
                com.baidu.tieba.s.c.dgY().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.hAH += i2;
            if (FrsGoodFragment.this.hAH >= FrsGoodFragment.this.cTi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener elO = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private z hBp = new z() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.z
        public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bt)) {
                bu buVar = ((bt) qVar).dLi;
                if (buVar.aTp() == null || buVar.aTp().getGroup_id() == 0 || be.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (buVar.aTc() != 1 || be.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Nr(buVar.getId())) {
                            readThreadHistory.Nq(buVar.getId());
                            if (FrsGoodFragment.this.hSG != null) {
                                FrsGoodFragment.this.hSG.bZk();
                            }
                        }
                        boolean z = false;
                        final String aSv = buVar.aSv();
                        if (aSv != null && !aSv.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    y yVar = new y(aSv);
                                    yVar.aWu().aWV().mIsNeedAddCommenParam = false;
                                    yVar.aWu().aWV().mIsUseCurrentBDUSS = false;
                                    yVar.getNetData();
                                }
                            }).start();
                        }
                        String str = null;
                        if (buVar != null) {
                            str = buVar.getTid();
                        }
                        if (str == null) {
                            str = "";
                        }
                        if (buVar.aSk() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bc.aWU().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3 && str.length() > 3) {
                            buVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(buVar, FrsGoodFragment.this.hzC, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(buVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.hzi != null && FrsGoodFragment.this.hzi.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.hWM = FrsGoodFragment.this.hzi.needLog == 1;
                            bVar.hWO = FrsGoodFragment.this.hzi.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.hIE != null) {
                                bVar.hWP = com.baidu.tieba.frs.d.d.hIE.hWP;
                                bVar.hWQ = com.baidu.tieba.frs.d.d.hIE.hWQ;
                            }
                            com.baidu.tieba.frs.d.a.a(buVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hBt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.hSG != null) {
                FrsGoodFragment.this.hSG.yA();
            }
        }
    };

    static /* synthetic */ int j(FrsGoodFragment frsGoodFragment) {
        int i = frsGoodFragment.mPn;
        frsGoodFragment.mPn = i - 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ e getPageContext() {
        return super.getPageContext();
    }

    public void cbb() {
        if (this.hSG != null) {
            this.hSG.refreshView();
        }
    }

    private void showLoadingView() {
        this.hSG.nu(false);
        showLoadingView(this.hSG.bLT(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.hSG.nu(true);
        hideLoadingView(this.hSG.bLT());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.hSG.nu(false);
        this.hSG.nt(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hSG.buL();
        this.hSG.getListView().getData().clear();
        this.hSG.bZk();
        if (this.hEZ == null) {
            this.hEZ = new c(getPageContext().getContext(), getNetRefreshListener());
            this.hEZ.setTitle(null);
            this.hEZ.setButtonText(null);
            this.hEZ.showRefreshButton();
            this.hEZ.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hEZ.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hEZ.setSubText(null);
        }
        this.hEZ.onChangeSkinType();
        this.hEZ.attachView(this.hSG.bLT(), true);
        registerListener(this.hDd);
    }

    private void btO() {
        this.hSG.nu(true);
        this.hSG.nt(true);
        if (this.hEZ != null && this.hEZ.isViewAttached()) {
            this.hEZ.dettachView(this.hSG.bLT());
        }
        MessageManager.getInstance().unRegisterListener(this.hDd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nL(boolean z) {
        this.gWV = true;
        bYx();
        btO();
        if (!z) {
            btO();
            showLoadingView();
        }
        this.hSE.qc(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hcE = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.hcE = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.eAO = this.beginTime - this.hcE;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dgY().z(getUniqueId());
        this.hSE = new FrsGoodModelController(this);
        if (arguments != null) {
            this.hSE.aj(arguments);
            this.hSD = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.hSE.aj(bundle);
            this.hSD = bundle.getBoolean("is_game_frs", false);
        } else {
            this.hSE.aj(null);
        }
        this.hzJ = getVoiceManager();
        this.hzJ.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dFw);
        registerListener(this.hSK);
        registerListener(this.hAR);
        registerListener(this.hBt);
        this.hSF = new FrsLoadMoreModel(this, null);
        this.hSF.registerListener();
        this.hSF.setPageType(2);
        this.hSF.nN(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cTi = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.hSG = new a(this, inflate, this.hSD);
        this.hSG.cdk().cdr();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.gWV) {
            if (j.isNetWorkAvailable()) {
                nL(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new ao("c13008").dk("fid", this.mForumId).dk("obj_type", "7").ag("obj_locate", 2).dk("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hzJ = getVoiceManager();
        this.hzJ.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cdd();
        if (bundle != null) {
            this.hzC = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.hzC = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cdd() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.elO);
    }

    public FrsLoadMoreModel cde() {
        return this.hSF;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hSG != null) {
            this.hSG.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hDd);
        com.baidu.tieba.s.c.dgY().A(getUniqueId());
        s.bOB().mc(false);
        super.onDestroy();
        this.hSE.cdm();
        this.hzJ = getVoiceManager();
        this.hzJ.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.hSJ);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hzC);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.hSD);
        this.hSE.onSaveInstanceState(bundle);
        this.hzJ = getVoiceManager();
        if (this.hzJ != null) {
            this.hzJ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bu threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.hSG.cdk().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.hzi.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.kJ(intent.getIntExtra("good_data", 0));
                            threadDataById.aTn();
                            nL(false);
                            return;
                        } else if (intExtra == 0) {
                            this.hzi.removeThreadData(threadDataById);
                            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hzi.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new r());
                            }
                            this.hSG.cdi();
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
            if (this.hHG == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.gWV) {
                com.baidu.adp.lib.f.e.lt().post(this.hSJ);
            }
        }
        cas();
    }

    private void cas() {
        if (isPrimary()) {
            if (this.hEZ != null && this.hEZ.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hDd);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hDd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hSG != null) {
            this.hSG.bZk();
        }
        this.hzJ = getVoiceManager();
        this.hzJ.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.hSH = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.hSG.a(this.hBp);
        this.hSG.setOnScrollListener(this.mScrollListener);
        this.hSG.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.hSH != null) {
                    FrsGoodFragment.this.hSH.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hHG != 3 || this.hSG != null) {
            this.hHG = i;
            super.onChangeSkinType(i);
            if (this.hSG != null) {
                this.hSG.onChangeSkinType(i);
            }
            if (this.hEZ != null && this.hEZ.isViewAttached()) {
                this.hEZ.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bXo() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bXo();
        }
        return null;
    }

    private void bYt() {
        switch (this.mFlag) {
            case 1:
                h.lu().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Nl(FrsGoodFragment.this.hzC);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYu() {
        bYx();
        try {
            if (this.hzi != null) {
                this.hSG.caC();
                this.hSG.byK();
                this.hzC = this.hzi.getForum().getName();
                this.forumId = this.hzi.getForum().getId();
                if (this.hzi != null && this.hzi.getForum() != null) {
                    this.hSG.a(this.hzi.getForum().getThemeColorInfo());
                    this.hSG.c(this.hzi);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.hzi.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hzi.getUserData().getBimg_end_time());
                bYt();
                if (!this.hSG.cdk().r(bu.dLI)) {
                    this.hzi.removeAlaLiveThreadData();
                }
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hzi.getThreadList();
                if (threadList != null) {
                    this.hSG.a(threadList, this.mPn, this.hzi, this.hzi.getPage().aRf());
                    cdf();
                    this.hSG.cdi();
                    if (this.hzi.getIsNewUrl() == 1) {
                        this.hSG.cdk().setFromCDN(true);
                    } else {
                        this.hSG.cdk().setFromCDN(false);
                    }
                    this.hSG.setListViewSelection(cg(cdg().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cg(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hzJ = getVoiceManager();
        this.hzJ.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.bOB().mc(false);
        com.baidu.tieba.s.c.dgY().b(getUniqueId(), false);
        if (this.hzi != null && this.hzi.getForum() != null) {
            com.baidu.tbadk.distribute.a.beN().b(getPageContext().getPageActivity(), "frs", this.hzi.getForum().getId(), 0L);
        }
        this.hzJ = getVoiceManager();
        if (this.hzJ != null) {
            this.hzJ.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vx(int i) {
        ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hzi.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q next = it.next();
                if (next instanceof bt) {
                    bu buVar = ((bt) next).dLi;
                    if (buVar.getId() != null && buVar.getId().equals(this.hSC)) {
                        c(buVar, i);
                        this.hSC = null;
                        break;
                    }
                }
            }
            this.hSG.cdk().b(threadList, this.hzi);
            this.hSG.cdk().notifyDataSetChanged();
        }
    }

    private void c(bu buVar, int i) {
        if (i == 1) {
            PraiseData aSa = buVar.aSa();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aSa == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    buVar.a(praiseData);
                    return;
                }
                buVar.aSa().getUser().add(0, metaData);
                buVar.aSa().setNum(buVar.aSa().getNum() + 1);
                buVar.aSa().setIsLike(i);
            }
        } else if (buVar.aSa() != null) {
            buVar.aSa().setIsLike(i);
            buVar.aSa().setNum(buVar.aSa().getNum() - 1);
            ArrayList<MetaData> user = buVar.aSa().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        buVar.aSa().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hzJ == null) {
            this.hzJ = VoiceManager.instance();
        }
        return this.hzJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView aYH() {
        if (this.hSG == null) {
            return null;
        }
        return this.hSG.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bYx() {
        this.hzJ = getVoiceManager();
        this.hzJ.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aYI() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aYI();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.hzi != null && this.hSG != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.hSG.bZk();
            }
        }
    }

    private void cdf() {
        HashMap<Integer, bu> cbE;
        if (this.hSG != null && this.hSG.cdk() != null && (cbE = this.hSG.cdk().cbE()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bu> entry : cbE.entrySet()) {
                bu value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.beT().E(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        if (aYH() == null) {
            return null;
        }
        return aYH().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            nL(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bYC() {
        return this.hzi;
    }

    public FrsGoodModelController cdg() {
        return this.hSE;
    }

    public void Fx(String str) {
        this.hzC = str;
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
        if (!l.isNetOk()) {
            this.hSG.buL();
        } else if (!this.hSE.cdq()) {
            this.hSG.buL();
        } else {
            btK();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.hSF.isLoading && !this.hSE.isLoading()) {
                if (this.hSF.cH(this.hzi.getThreadListIds())) {
                    this.hSG.a(this.hSF.cdB(), this.mPn, this.hzi, 0);
                    this.hSF.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.hzi.getThreadListIds(), this.hzC, this.mPn, this.hzi.isBrandForum);
                } else if (this.gzh != 0) {
                    this.hSG.a(this.hSF.cdB(), this.mPn, this.hzi, 0);
                    this.mPn++;
                    this.hSE.vz(this.mPn);
                    this.hSF.loadingDone = false;
                    this.hSF.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        btK();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void an(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.q> a;
        btK();
        if (arrayList != null && arrayList.size() != 0 && (a = this.hSF.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.hzi.setThreadList(a);
            this.hSG.a(a, this.mPn, this.hzi, 0);
        }
    }

    private void btK() {
        if (this.gzh == 0 && !this.hSF.cH(this.hzi.getThreadListIds())) {
            if (this.hzi.getThreadList() == null || this.hzi.getThreadList().size() == 0) {
                this.hSG.buL();
                return;
            } else {
                this.hSG.buK();
                return;
            }
        }
        this.hSG.buJ();
    }

    @Override // android.support.v4.app.Fragment, com.baidu.h.a.a.InterfaceC0127a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ac.checkCamera(getActivity().getApplicationContext())) {
                am.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ac.transformPermissionResult(strArr, iArr);
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
        com.baidu.tbadk.distribute.a.beN().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.m
    public void bYw() {
        if (this.hSE != null) {
            this.hSE.bYw();
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

    @Override // com.baidu.tieba.frs.ar
    public NavigationBar bwW() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hzC;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hzi != null) {
            i = this.hzi.getSortType();
        }
        tbPageTag.sortType = g.vX(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vy(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            nL(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bXH() {
        if (this.hSG != null && this.hSG.getListView() != null) {
            this.hSG.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void buI() {
        if (this.hSG != null) {
            bXH();
            this.hSG.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hAj.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a pm(int i) {
        return this.hAj.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.as
    public void aYg() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.boB().Ad("page_frs_good");
            nL(true);
            return;
        }
        this.hSG.jc(false);
    }

    @Override // com.baidu.tieba.frs.as
    public void aYh() {
        com.baidu.tieba.s.c.dgY().b(getUniqueId(), false);
    }

    public void a(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null && bYC() != null && bYC().getThreadList() != null) {
            if (w.isEmpty(bYC().getThreadList())) {
                bYC().getThreadList().add(aqVar);
            } else {
                if (bYC().getThreadList().size() == 1 && (bYC().getThreadList().get(0) instanceof r)) {
                    bYC().getThreadList().remove(0);
                }
                bYC().getThreadList().add(0, aqVar);
            }
            this.hSG.a(this.hzi.getThreadList(), this.mPn, this.hzi, this.hzi.getPage().aRf());
            this.hSG.cdi();
            this.hSG.setListViewSelection(0);
        }
    }
}
