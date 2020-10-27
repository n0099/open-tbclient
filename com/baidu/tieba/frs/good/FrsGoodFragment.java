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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.m.a.a;
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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
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
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.f.i;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.f;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes22.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0238a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, as, at, au, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private VoiceManager iBr;
    private c iHF;
    private FrsLoadMoreModel iVA;
    private com.baidu.tieba.frs.gametab.b iVC;
    private String iVx;
    private FrsGoodModelController iVz;
    private String mForumId;
    private String iBk = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean iVy = false;
    private String forumId = null;
    private FrsViewData iAQ = new FrsViewData();
    public long idU = -1;
    public long fpl = 0;
    public long fpw = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean iBE = false;
    protected a iVB = null;
    private int hvO = -1;
    private int mTabId = 0;
    private int iKp = 3;
    private boolean hXR = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iBS = new SparseArray<>();
    private boolean iVD = false;
    private int dDO = 0;
    private int iCq = 0;
    private CustomMessageListener iEU = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.iHF != null && FrsGoodFragment.this.iHF.isViewAttached()) {
                FrsGoodFragment.this.iHF.rs(num.intValue());
            }
        }
    };
    private Runnable iVE = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.hXR) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.pZ(false);
            }
        }
    };
    private CustomMessageListener iVF = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                bw bwVar = (bw) customResponsedMessage.getData();
                FrsGoodFragment.this.iVx = bwVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.iVx) && bwVar.bjL() != null) {
                    FrsGoodFragment.this.zG(bwVar.bjL().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener iCE = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.bqA() != null) {
                        FrsGoodFragment.this.bqA().setSelection(0);
                    }
                    if (FrsGoodFragment.this.iHF != null && FrsGoodFragment.this.iHF.isViewAttached()) {
                        FrsGoodFragment.this.pZ(false);
                    } else if (FrsGoodFragment.this.iVB != null) {
                        FrsGoodFragment.this.iVB.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final r iCW = new r() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long iVI = 1;

        @Override // com.baidu.tieba.tbadkCore.r
        public void yt(int i) {
            if (!FrsGoodFragment.this.iVD) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.iVB.cwW();
                        return;
                    case 3:
                        FrsGoodFragment.this.iVB.kT(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, f fVar) {
            ArrayList<q> a2;
            if (FrsGoodFragment.this.iVD) {
                if (FrsGoodFragment.this.cBe().cBm() == null) {
                    FrsGoodFragment.this.iVD = false;
                    return;
                } else if (FrsGoodFragment.this.cBe().cBm().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.iVD = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.iVI = 1L;
            } else if (fVar.isSuccess) {
                this.iVI = 0L;
            } else {
                this.iVI = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.iVA.resetData();
            }
            FrsGoodFragment.this.iVB.kT(false);
            if (FrsGoodFragment.this.cBe().cBm() != null) {
                FrsGoodFragment.this.iAQ = FrsGoodFragment.this.cBe().cBm();
            }
            FrsGoodFragment.this.hvO = FrsGoodFragment.this.iAQ.getPage().biQ();
            if (FrsGoodFragment.this.hvO != 0 || (FrsGoodFragment.this.iAQ.getThreadListIds() != null && FrsGoodFragment.this.iAQ.getThreadListIds().size() != 0)) {
                if (y.getCount(FrsGoodFragment.this.iAQ.getThreadList()) > 3) {
                    FrsGoodFragment.this.iVB.TI();
                } else {
                    FrsGoodFragment.this.iVB.cxm();
                }
            } else if (FrsGoodFragment.this.iAQ.getThreadList() == null || FrsGoodFragment.this.iAQ.getThreadList().size() == 0) {
                FrsGoodFragment.this.iVB.bNw();
            } else {
                FrsGoodFragment.this.iVB.TJ();
            }
            if (i == 4) {
                ArrayList<q> a3 = FrsGoodFragment.this.iVA.a(false, false, false, FrsGoodFragment.this.iAQ.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsGoodFragment.this.iAQ.setThreadList(a3);
                    FrsGoodFragment.this.iVB.a(a3, FrsGoodFragment.this.mPn, FrsGoodFragment.this.iAQ, FrsGoodFragment.this.hvO);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.iVB.cwW();
                    break;
                case 2:
                    FrsGoodFragment.this.iVB.cwW();
                    break;
                case 3:
                    if (FrsGoodFragment.this.iAQ.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.iVI != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.iAQ != null) {
                    FrsGoodFragment.this.iBk = FrsGoodFragment.this.iAQ.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.iAQ.getForum().getId();
                    FrsGoodFragment.this.iVB.b(FrsGoodFragment.this.iAQ.getForum(), FrsGoodFragment.this.iAQ.getUserData());
                }
                if (FrsGoodFragment.this.iAQ != null) {
                    FrsGoodFragment.this.iAQ.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.iVB.c(FrsGoodFragment.this.iAQ);
                if (FrsGoodFragment.this.iAQ == null || FrsGoodFragment.this.iAQ.getThreadList() == null || FrsGoodFragment.this.iAQ.getThreadList().size() != 0 || FrsGoodFragment.this.cBe().getType() != 4) {
                    if (FrsGoodFragment.this.iAQ != null && (a2 = FrsGoodFragment.this.iVA.a(false, false, true, FrsGoodFragment.this.iAQ.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsGoodFragment.this.iAQ.setThreadList(a2);
                    }
                    FrsGoodFragment.this.cwe();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.idU > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.idU, FrsGoodFragment.this.cBe().cpV() - FrsGoodFragment.this.idU, FrsGoodFragment.this.cBe().cpT(), FrsGoodFragment.this.cBe().cpU(), currentTimeMillis2 - FrsGoodFragment.this.cBe().cpS());
                        FrsGoodFragment.this.idU = -1L;
                    }
                    FrsGoodFragment.this.fpw = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.idU > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.idU, FrsGoodFragment.this.cBe().cpV() - FrsGoodFragment.this.idU, FrsGoodFragment.this.cBe().cpT(), FrsGoodFragment.this.cBe().cpU(), currentTimeMillis3 - FrsGoodFragment.this.cBe().cpS());
                FrsGoodFragment.this.idU = -1L;
            }
            FrsGoodFragment.this.fpw = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cvY() {
        }
    };
    private final CustomMessageListener erp = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.iVB != null) {
                FrsGoodFragment.this.iVB.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.iBE) {
                FrsGoodFragment.this.iBE = true;
                FrsGoodFragment.this.iVB.cxl();
            }
            if (i == 0) {
                t.clQ().op(true);
                com.baidu.tieba.s.c.dGv().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.iCq += i2;
            if (FrsGoodFragment.this.iCq >= FrsGoodFragment.this.dDO * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener eZe = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private ab iDd = new ab() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bv)) {
                bw bwVar = ((bv) qVar).erH;
                if (bwVar.bla() == null || bwVar.bla().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bwVar.bkN() != 1 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.SK(bwVar.getId())) {
                            readThreadHistory.SJ(bwVar.getId());
                            if (FrsGoodFragment.this.iVB != null) {
                                FrsGoodFragment.this.iVB.cwW();
                            }
                        }
                        boolean z = false;
                        final String bkg = bwVar.bkg();
                        if (bkg != null && !bkg.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(bkg);
                                    aaVar.bon().boT().mIsNeedAddCommenParam = false;
                                    aaVar.bon().boT().mIsUseCurrentBDUSS = false;
                                    aaVar.getNetData();
                                }
                            }).start();
                        }
                        String str = null;
                        if (bwVar != null) {
                            str = bwVar.getTid();
                        }
                        if (str == null) {
                            str = "";
                        }
                        if (bwVar.bjV() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.boR().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3 && str.length() > 3) {
                            bwVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bwVar, FrsGoodFragment.this.iBk, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.iAQ != null && FrsGoodFragment.this.iAQ.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.iZE = FrsGoodFragment.this.iAQ.needLog == 1;
                            bVar.iZG = FrsGoodFragment.this.iAQ.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.iLo != null) {
                                bVar.iZH = com.baidu.tieba.frs.d.d.iLo.iZH;
                                bVar.iZI = com.baidu.tieba.frs.d.d.iLo.iZI;
                            }
                            com.baidu.tieba.frs.d.a.a(bwVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener iDh = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.iVB != null) {
                FrsGoodFragment.this.iVB.Gh();
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

    public void cyV() {
        if (this.iVB != null) {
            this.iVB.refreshView();
        }
    }

    private void showLoadingView() {
        this.iVB.pI(false);
        showLoadingView(this.iVB.chy(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.iVB.pI(true);
        hideLoadingView(this.iVB.chy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.iVB.pI(false);
        this.iVB.pH(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.iVB.bNw();
        this.iVB.getListView().getData().clear();
        this.iVB.cwW();
        if (this.iHF == null) {
            this.iHF = new c(getPageContext().getContext(), getNetRefreshListener());
            this.iHF.setTitle(null);
            this.iHF.setButtonText(null);
            this.iHF.showRefreshButton();
            this.iHF.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.iHF.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.iHF.setSubText(null);
        }
        this.iHF.onChangeSkinType();
        this.iHF.attachView(this.iVB.chy(), true);
        registerListener(this.iEU);
    }

    private void TK() {
        this.iVB.pI(true);
        this.iVB.pH(true);
        if (this.iHF != null && this.iHF.isViewAttached()) {
            this.iHF.dettachView(this.iVB.chy());
        }
        MessageManager.getInstance().unRegisterListener(this.iEU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ(boolean z) {
        this.hXR = true;
        cwj();
        TK();
        if (!z) {
            TK();
            showLoadingView();
        }
        this.iVz.tM(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.idU = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.idU = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.fpl = this.beginTime - this.idU;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dGv().z(getUniqueId());
        this.iVz = new FrsGoodModelController(this);
        if (arguments != null) {
            this.iVz.aj(arguments);
            this.iVy = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.iVz.aj(bundle);
            this.iVy = bundle.getBoolean("is_game_frs", false);
        } else {
            this.iVz.aj(null);
        }
        this.iBr = getVoiceManager();
        this.iBr.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.erp);
        registerListener(this.iVF);
        registerListener(this.iCE);
        registerListener(this.iDh);
        this.iVA = new FrsLoadMoreModel(this, null);
        this.iVA.registerListener();
        this.iVA.setPageType(2);
        this.iVA.qb(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dDO = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.iVB = new a(this, inflate, this.iVy);
        this.iVB.cBi().cBp();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.hXR) {
            if (j.isNetWorkAvailable()) {
                pZ(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new aq("c13008").dR("fid", this.mForumId).dR("obj_type", "7").aj("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.iBr = getVoiceManager();
        this.iBr.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cBb();
        if (bundle != null) {
            this.iBk = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.iBk = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cBb() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eZe);
    }

    public FrsLoadMoreModel cBc() {
        return this.iVA;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.iVB != null) {
            this.iVB.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iEU);
        com.baidu.tieba.s.c.dGv().A(getUniqueId());
        t.clQ().op(false);
        super.onDestroy();
        this.iVz.cBk();
        this.iBr = getVoiceManager();
        this.iBr.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iVE);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iBk);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.iVy);
        this.iVz.onSaveInstanceState(bundle);
        this.iBr = getVoiceManager();
        if (this.iBr != null) {
            this.iBr.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bw threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.iVB.cBi().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.iAQ.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.oc(intent.getIntExtra("good_data", 0));
                            threadDataById.bkY();
                            pZ(false);
                            return;
                        } else if (intExtra == 0) {
                            this.iAQ.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.iAQ.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new s());
                            }
                            this.iVB.cBg();
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
            if (this.iKp == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.hXR) {
                com.baidu.adp.lib.f.e.mY().post(this.iVE);
            }
        }
        cyn();
    }

    private void cyn() {
        if (isPrimary()) {
            if (this.iHF != null && this.iHF.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iEU);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iEU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iVB != null) {
            this.iVB.cwW();
        }
        this.iBr = getVoiceManager();
        this.iBr.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.iVC = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.iVB.a(this.iDd);
        this.iVB.setOnScrollListener(this.mScrollListener);
        this.iVB.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.iVC != null) {
                    FrsGoodFragment.this.iVC.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iKp != 3 || this.iVB != null) {
            this.iKp = i;
            super.onChangeSkinType(i);
            if (this.iVB != null) {
                this.iVB.onChangeSkinType(i);
            }
            if (this.iHF != null && this.iHF.isViewAttached()) {
                this.iHF.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cuY() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cuY();
        }
        return null;
    }

    private void cwd() {
        switch (this.mFlag) {
            case 1:
                h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.SE(FrsGoodFragment.this.iBk);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwe() {
        cwj();
        try {
            if (this.iAQ != null) {
                this.iVB.cyx();
                this.iVB.bSR();
                this.iBk = this.iAQ.getForum().getName();
                this.forumId = this.iAQ.getForum().getId();
                if (this.iAQ != null && this.iAQ.getForum() != null) {
                    this.iVB.a(this.iAQ.getForum().getThemeColorInfo());
                    this.iVB.c(this.iAQ);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.iAQ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iAQ.getUserData().getBimg_end_time());
                cwd();
                if (!this.iVB.cBi().r(bw.eyh)) {
                    this.iAQ.removeAlaLiveThreadData();
                }
                ArrayList<q> threadList = this.iAQ.getThreadList();
                if (threadList != null) {
                    this.iVB.a(threadList, this.mPn, this.iAQ, this.iAQ.getPage().biQ());
                    cBd();
                    this.iVB.cBg();
                    if (this.iAQ.getIsNewUrl() == 1) {
                        this.iVB.cBi().setFromCDN(true);
                    } else {
                        this.iVB.cBi().setFromCDN(false);
                    }
                    this.iVB.setListViewSelection(cw(cBe().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cw(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.iBr = getVoiceManager();
        this.iBr.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.clQ().op(false);
        com.baidu.tieba.s.c.dGv().b(getUniqueId(), false);
        if (this.iAQ != null && this.iAQ.getForum() != null) {
            com.baidu.tbadk.distribute.a.bwL().b(getPageContext().getPageActivity(), "frs", this.iAQ.getForum().getId(), 0L);
        }
        this.iBr = getVoiceManager();
        if (this.iBr != null) {
            this.iBr.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zG(int i) {
        ArrayList<q> threadList = this.iAQ.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).erH;
                    if (bwVar.getId() != null && bwVar.getId().equals(this.iVx)) {
                        c(bwVar, i);
                        this.iVx = null;
                        break;
                    }
                }
            }
            this.iVB.cBi().b(threadList, this.iAQ);
            this.iVB.cBi().notifyDataSetChanged();
        }
    }

    private void c(bw bwVar, int i) {
        if (i == 1) {
            PraiseData bjL = bwVar.bjL();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bjL == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bwVar.a(praiseData);
                    return;
                }
                bwVar.bjL().getUser().add(0, metaData);
                bwVar.bjL().setNum(bwVar.bjL().getNum() + 1);
                bwVar.bjL().setIsLike(i);
            }
        } else if (bwVar.bjL() != null) {
            bwVar.bjL().setIsLike(i);
            bwVar.bjL().setNum(bwVar.bjL().getNum() - 1);
            ArrayList<MetaData> user = bwVar.bjL().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bwVar.bjL().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iBr == null) {
            this.iBr = VoiceManager.instance();
        }
        return this.iBr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView bqA() {
        if (this.iVB == null) {
            return null;
        }
        return this.iVB.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cwj() {
        this.iBr = getVoiceManager();
        this.iBr.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bqB() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bqB();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.iAQ != null && this.iVB != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.iVB.cwW();
            }
        }
    }

    private void cBd() {
        HashMap<Integer, bw> czz;
        if (this.iVB != null && this.iVB.cBi() != null && (czz = this.iVB.cBi().czz()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bw> entry : czz.entrySet()) {
                bw value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bwR().L(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        if (bqA() == null) {
            return null;
        }
        return bqA().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            pZ(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cwo() {
        return this.iAQ;
    }

    public FrsGoodModelController cBe() {
        return this.iVz;
    }

    public void Kw(String str) {
        this.iBk = str;
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
            this.iVB.bNw();
        } else if (!this.iVz.cBo()) {
            this.iVB.bNw();
        } else {
            bMx();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.iVA.isLoading && !this.iVz.isLoading()) {
                if (this.iVA.dg(this.iAQ.getThreadListIds())) {
                    this.iVB.a(this.iVA.cBz(), this.mPn, this.iAQ, 0);
                    this.iVA.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.iAQ.getThreadListIds(), this.iBk, this.mPn, this.iAQ.isBrandForum);
                } else if (this.hvO != 0) {
                    this.iVB.a(this.iVA.cBz(), this.mPn, this.iAQ, 0);
                    this.mPn++;
                    this.iVz.zI(this.mPn);
                    this.iVA.loadingDone = false;
                    this.iVA.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bMx();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ax(ArrayList<q> arrayList) {
        bMx();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<q> a2 = this.iVA.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.iAQ.setThreadList(a2);
                this.iVB.a(a2, this.mPn, this.iAQ, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iAQ.getForum()));
        }
    }

    private void bMx() {
        if (this.hvO == 0 && !this.iVA.dg(this.iAQ.getThreadListIds())) {
            if (this.iAQ.getThreadList() == null || this.iAQ.getThreadList().size() == 0) {
                this.iVB.bNw();
            } else {
                this.iVB.TJ();
            }
        } else if (y.getCount(this.iAQ.getThreadList()) > 3) {
            this.iVB.TI();
        } else {
            this.iVB.cxm();
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0238a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ae.checkCamera(getActivity().getApplicationContext())) {
                ao.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
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
        com.baidu.tbadk.distribute.a.bwL().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void cwi() {
        if (this.iVz != null) {
            this.iVz.cwi();
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

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bQh() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iBk;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.iAQ != null) {
            i = this.iAQ.getSortType();
        }
        tbPageTag.sortType = i.Ag(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zH(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            pZ(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void cvr() {
        if (this.iVB != null && this.iVB.getListView() != null) {
            this.iVB.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bNv() {
        if (this.iVB != null) {
            cvr();
            this.iVB.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iBS.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sQ(int i) {
        return this.iBS.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.au
    public void bqb() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bGs().EK("page_frs_good");
            pZ(true);
            return;
        }
        this.iVB.kT(false);
    }

    @Override // com.baidu.tieba.frs.au
    public void bqc() {
        com.baidu.tieba.s.c.dGv().b(getUniqueId(), false);
    }

    public void a(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null && cwo() != null && cwo().getThreadList() != null) {
            if (y.isEmpty(cwo().getThreadList())) {
                cwo().getThreadList().add(asVar);
            } else {
                if (cwo().getThreadList().size() == 1 && (cwo().getThreadList().get(0) instanceof s)) {
                    cwo().getThreadList().remove(0);
                }
                cwo().getThreadList().add(0, asVar);
            }
            this.iVB.a(this.iAQ.getThreadList(), this.mPn, this.iAQ, this.iAQ.getPage().biQ());
            this.iVB.cBg();
            this.iVB.setListViewSelection(0);
        }
    }
}
