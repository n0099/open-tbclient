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
import com.baidu.adp.widget.ListView.t;
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
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
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
/* loaded from: classes16.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0210a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, as, at, au, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private VoiceManager hSO;
    private c hZc;
    private String imL;
    private FrsGoodModelController imN;
    private FrsLoadMoreModel imO;
    private com.baidu.tieba.frs.gametab.b imQ;
    private String mForumId;
    private String hSH = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean imM = false;
    private String forumId = null;
    private FrsViewData hSn = new FrsViewData();
    public long hvn = -1;
    public long eRJ = 0;
    public long eRT = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean hTb = false;
    protected a imP = null;
    private int gRi = -1;
    private int mTabId = 0;
    private int ibM = 3;
    private boolean hpr = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hTp = new SparseArray<>();
    private boolean imR = false;
    private int dhe = 0;
    private int hTN = 0;
    private CustomMessageListener hWr = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.hZc != null && FrsGoodFragment.this.hZc.isViewAttached()) {
                FrsGoodFragment.this.hZc.qs(num.intValue());
            }
        }
    };
    private Runnable imS = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.hpr) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.oU(false);
            }
        }
    };
    private CustomMessageListener imT = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                bw bwVar = (bw) customResponsedMessage.getData();
                FrsGoodFragment.this.imL = bwVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.imL) && bwVar.bep() != null) {
                    FrsGoodFragment.this.yi(bwVar.bep().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener hUb = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.blc() != null) {
                        FrsGoodFragment.this.blc().setSelection(0);
                    }
                    if (FrsGoodFragment.this.hZc != null && FrsGoodFragment.this.hZc.isViewAttached()) {
                        FrsGoodFragment.this.oU(false);
                    } else if (FrsGoodFragment.this.imP != null) {
                        FrsGoodFragment.this.imP.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final r hUt = new r() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long imW = 1;

        @Override // com.baidu.tieba.tbadkCore.r
        public void wV(int i) {
            if (!FrsGoodFragment.this.imR) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.imP.cne();
                        return;
                    case 3:
                        FrsGoodFragment.this.imP.kf(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, f fVar) {
            ArrayList<q> a;
            if (FrsGoodFragment.this.imR) {
                if (FrsGoodFragment.this.crk().crs() == null) {
                    FrsGoodFragment.this.imR = false;
                    return;
                } else if (FrsGoodFragment.this.crk().crs().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.imR = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.imW = 1L;
            } else if (fVar.isSuccess) {
                this.imW = 0L;
            } else {
                this.imW = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.imO.resetData();
            }
            FrsGoodFragment.this.imP.kf(false);
            if (FrsGoodFragment.this.crk().crs() != null) {
                FrsGoodFragment.this.hSn = FrsGoodFragment.this.crk().crs();
            }
            FrsGoodFragment.this.gRi = FrsGoodFragment.this.hSn.getPage().bdu();
            if (FrsGoodFragment.this.gRi != 0 || (FrsGoodFragment.this.hSn.getThreadListIds() != null && FrsGoodFragment.this.hSn.getThreadListIds().size() != 0)) {
                if (y.getCount(FrsGoodFragment.this.hSn.getThreadList()) > 3) {
                    FrsGoodFragment.this.imP.bGR();
                } else {
                    FrsGoodFragment.this.imP.cnu();
                }
            } else if (FrsGoodFragment.this.hSn.getThreadList() == null || FrsGoodFragment.this.hSn.getThreadList().size() == 0) {
                FrsGoodFragment.this.imP.bGT();
            } else {
                FrsGoodFragment.this.imP.bGS();
            }
            if (i == 4) {
                ArrayList<q> a2 = FrsGoodFragment.this.imO.a(false, false, false, FrsGoodFragment.this.hSn.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.hSn.setThreadList(a2);
                    FrsGoodFragment.this.imP.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.hSn, FrsGoodFragment.this.gRi);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.imP.cne();
                    break;
                case 2:
                    FrsGoodFragment.this.imP.cne();
                    break;
                case 3:
                    if (FrsGoodFragment.this.hSn.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.imW != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.hSn != null) {
                    FrsGoodFragment.this.hSH = FrsGoodFragment.this.hSn.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.hSn.getForum().getId();
                    FrsGoodFragment.this.imP.b(FrsGoodFragment.this.hSn.getForum(), FrsGoodFragment.this.hSn.getUserData());
                }
                if (FrsGoodFragment.this.hSn != null) {
                    FrsGoodFragment.this.hSn.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.imP.c(FrsGoodFragment.this.hSn);
                if (FrsGoodFragment.this.hSn == null || FrsGoodFragment.this.hSn.getThreadList() == null || FrsGoodFragment.this.hSn.getThreadList().size() != 0 || FrsGoodFragment.this.crk().getType() != 4) {
                    if (FrsGoodFragment.this.hSn != null && (a = FrsGoodFragment.this.imO.a(false, false, true, FrsGoodFragment.this.hSn.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.hSn.setThreadList(a);
                    }
                    FrsGoodFragment.this.cmm();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.hvn > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.hvn, FrsGoodFragment.this.crk().cga() - FrsGoodFragment.this.hvn, FrsGoodFragment.this.crk().cfY(), FrsGoodFragment.this.crk().cfZ(), currentTimeMillis2 - FrsGoodFragment.this.crk().cfX());
                        FrsGoodFragment.this.hvn = -1L;
                    }
                    FrsGoodFragment.this.eRT = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.hvn > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.hvn, FrsGoodFragment.this.crk().cga() - FrsGoodFragment.this.hvn, FrsGoodFragment.this.crk().cfY(), FrsGoodFragment.this.crk().cfZ(), currentTimeMillis3 - FrsGoodFragment.this.crk().cfX());
                FrsGoodFragment.this.hvn = -1L;
            }
            FrsGoodFragment.this.eRT = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cmg() {
        }
    };
    private final CustomMessageListener dUB = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.imP != null) {
                FrsGoodFragment.this.imP.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.hTb) {
                FrsGoodFragment.this.hTb = true;
                FrsGoodFragment.this.imP.cnt();
            }
            if (i == 0) {
                s.cbX().nk(true);
                com.baidu.tieba.s.c.dvE().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.hTN += i2;
            if (FrsGoodFragment.this.hTN >= FrsGoodFragment.this.dhe * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener eCs = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private ab hUA = new ab() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bv)) {
                bw bwVar = ((bv) qVar).dUS;
                if (bwVar.bfE() == null || bwVar.bfE().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bwVar.bfr() != 1 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.QX(bwVar.getId())) {
                            readThreadHistory.QW(bwVar.getId());
                            if (FrsGoodFragment.this.imP != null) {
                                FrsGoodFragment.this.imP.cne();
                            }
                        }
                        boolean z = false;
                        final String beK = bwVar.beK();
                        if (beK != null && !beK.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(beK);
                                    aaVar.biQ().bjv().mIsNeedAddCommenParam = false;
                                    aaVar.biQ().bjv().mIsUseCurrentBDUSS = false;
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
                        if (bwVar.bez() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.bju().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3 && str.length() > 3) {
                            bwVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bwVar, FrsGoodFragment.this.hSH, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.hSn != null && FrsGoodFragment.this.hSn.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.iqT = FrsGoodFragment.this.hSn.needLog == 1;
                            bVar.iqV = FrsGoodFragment.this.hSn.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.icL != null) {
                                bVar.iqW = com.baidu.tieba.frs.d.d.icL.iqW;
                                bVar.iqX = com.baidu.tieba.frs.d.d.icL.iqX;
                            }
                            com.baidu.tieba.frs.d.a.a(bwVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hUE = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.imP != null) {
                FrsGoodFragment.this.imP.EF();
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

    public void cpd() {
        if (this.imP != null) {
            this.imP.refreshView();
        }
    }

    private void showLoadingView() {
        this.imP.oD(false);
        showLoadingView(this.imP.bZb(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.imP.oD(true);
        hideLoadingView(this.imP.bZb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.imP.oD(false);
        this.imP.oC(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.imP.bGT();
        this.imP.getListView().getData().clear();
        this.imP.cne();
        if (this.hZc == null) {
            this.hZc = new c(getPageContext().getContext(), getNetRefreshListener());
            this.hZc.setTitle(null);
            this.hZc.setButtonText(null);
            this.hZc.showRefreshButton();
            this.hZc.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hZc.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hZc.setSubText(null);
        }
        this.hZc.onChangeSkinType();
        this.hZc.attachView(this.imP.bZb(), true);
        registerListener(this.hWr);
    }

    private void bFW() {
        this.imP.oD(true);
        this.imP.oC(true);
        if (this.hZc != null && this.hZc.isViewAttached()) {
            this.hZc.dettachView(this.imP.bZb());
        }
        MessageManager.getInstance().unRegisterListener(this.hWr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU(boolean z) {
        this.hpr = true;
        cmr();
        bFW();
        if (!z) {
            bFW();
            showLoadingView();
        }
        this.imN.sD(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hvn = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.hvn = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.eRJ = this.beginTime - this.hvn;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dvE().A(getUniqueId());
        this.imN = new FrsGoodModelController(this);
        if (arguments != null) {
            this.imN.aj(arguments);
            this.imM = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.imN.aj(bundle);
            this.imM = bundle.getBoolean("is_game_frs", false);
        } else {
            this.imN.aj(null);
        }
        this.hSO = getVoiceManager();
        this.hSO.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dUB);
        registerListener(this.imT);
        registerListener(this.hUb);
        registerListener(this.hUE);
        this.imO = new FrsLoadMoreModel(this, null);
        this.imO.registerListener();
        this.imO.setPageType(2);
        this.imO.oW(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dhe = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.imP = new a(this, inflate, this.imM);
        this.imP.cro().crv();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.hpr) {
            if (j.isNetWorkAvailable()) {
                oU(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new aq("c13008").dD("fid", this.mForumId).dD("obj_type", "7").ai("obj_locate", 2).dD("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hSO = getVoiceManager();
        this.hSO.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        crh();
        if (bundle != null) {
            this.hSH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.hSH = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void crh() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eCs);
    }

    public FrsLoadMoreModel cri() {
        return this.imO;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.imP != null) {
            this.imP.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hWr);
        com.baidu.tieba.s.c.dvE().B(getUniqueId());
        s.cbX().nk(false);
        super.onDestroy();
        this.imN.crq();
        this.hSO = getVoiceManager();
        this.hSO.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.imS);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hSH);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.imM);
        this.imN.onSaveInstanceState(bundle);
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bw threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.imP.cro().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.hSn.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.nj(intent.getIntExtra("good_data", 0));
                            threadDataById.bfC();
                            oU(false);
                            return;
                        } else if (intExtra == 0) {
                            this.hSn.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.hSn.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.imP.crm();
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
            if (this.ibM == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.hpr) {
                com.baidu.adp.lib.f.e.mS().post(this.imS);
            }
        }
        cou();
    }

    private void cou() {
        if (isPrimary()) {
            if (this.hZc != null && this.hZc.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hWr);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hWr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.imP != null) {
            this.imP.cne();
        }
        this.hSO = getVoiceManager();
        this.hSO.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.imQ = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.imP.a(this.hUA);
        this.imP.setOnScrollListener(this.mScrollListener);
        this.imP.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.imQ != null) {
                    FrsGoodFragment.this.imQ.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ibM != 3 || this.imP != null) {
            this.ibM = i;
            super.onChangeSkinType(i);
            if (this.imP != null) {
                this.imP.onChangeSkinType(i);
            }
            if (this.hZc != null && this.hZc.isViewAttached()) {
                this.hZc.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> clf() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).clf();
        }
        return null;
    }

    private void cml() {
        switch (this.mFlag) {
            case 1:
                h.mT().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.QR(FrsGoodFragment.this.hSH);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmm() {
        cmr();
        try {
            if (this.hSn != null) {
                this.imP.coE();
                this.imP.bLs();
                this.hSH = this.hSn.getForum().getName();
                this.forumId = this.hSn.getForum().getId();
                if (this.hSn != null && this.hSn.getForum() != null) {
                    this.imP.a(this.hSn.getForum().getThemeColorInfo());
                    this.imP.c(this.hSn);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.hSn.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hSn.getUserData().getBimg_end_time());
                cml();
                if (!this.imP.cro().s(bw.ebp)) {
                    this.hSn.removeAlaLiveThreadData();
                }
                ArrayList<q> threadList = this.hSn.getThreadList();
                if (threadList != null) {
                    this.imP.a(threadList, this.mPn, this.hSn, this.hSn.getPage().bdu());
                    crj();
                    this.imP.crm();
                    if (this.hSn.getIsNewUrl() == 1) {
                        this.imP.cro().setFromCDN(true);
                    } else {
                        this.imP.cro().setFromCDN(false);
                    }
                    this.imP.setListViewSelection(cr(crk().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cr(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hSO = getVoiceManager();
        this.hSO.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.cbX().nk(false);
        com.baidu.tieba.s.c.dvE().b(getUniqueId(), false);
        if (this.hSn != null && this.hSn.getForum() != null) {
            com.baidu.tbadk.distribute.a.bri().b(getPageContext().getPageActivity(), "frs", this.hSn.getForum().getId(), 0L);
        }
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yi(int i) {
        ArrayList<q> threadList = this.hSn.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).dUS;
                    if (bwVar.getId() != null && bwVar.getId().equals(this.imL)) {
                        c(bwVar, i);
                        this.imL = null;
                        break;
                    }
                }
            }
            this.imP.cro().b(threadList, this.hSn);
            this.imP.cro().notifyDataSetChanged();
        }
    }

    private void c(bw bwVar, int i) {
        if (i == 1) {
            PraiseData bep = bwVar.bep();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bep == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bwVar.a(praiseData);
                    return;
                }
                bwVar.bep().getUser().add(0, metaData);
                bwVar.bep().setNum(bwVar.bep().getNum() + 1);
                bwVar.bep().setIsLike(i);
            }
        } else if (bwVar.bep() != null) {
            bwVar.bep().setIsLike(i);
            bwVar.bep().setNum(bwVar.bep().getNum() - 1);
            ArrayList<MetaData> user = bwVar.bep().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bwVar.bep().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hSO == null) {
            this.hSO = VoiceManager.instance();
        }
        return this.hSO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView blc() {
        if (this.imP == null) {
            return null;
        }
        return this.imP.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cmr() {
        this.hSO = getVoiceManager();
        this.hSO.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bld() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bld();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.hSn != null && this.imP != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.imP.cne();
            }
        }
    }

    private void crj() {
        HashMap<Integer, bw> cpH;
        if (this.imP != null && this.imP.cro() != null && (cpH = this.imP.cro().cpH()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bw> entry : cpH.entrySet()) {
                bw value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bro().L(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        if (blc() == null) {
            return null;
        }
        return blc().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            oU(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cmw() {
        return this.hSn;
    }

    public FrsGoodModelController crk() {
        return this.imN;
    }

    public void IL(String str) {
        this.hSH = str;
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
            this.imP.bGT();
        } else if (!this.imN.cru()) {
            this.imP.bGT();
        } else {
            bFS();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.imO.isLoading && !this.imN.isLoading()) {
                if (this.imO.cO(this.hSn.getThreadListIds())) {
                    this.imP.a(this.imO.crF(), this.mPn, this.hSn, 0);
                    this.imO.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.hSn.getThreadListIds(), this.hSH, this.mPn, this.hSn.isBrandForum);
                } else if (this.gRi != 0) {
                    this.imP.a(this.imO.crF(), this.mPn, this.hSn, 0);
                    this.mPn++;
                    this.imN.yk(this.mPn);
                    this.imO.loadingDone = false;
                    this.imO.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bFS();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void au(ArrayList<q> arrayList) {
        ArrayList<q> a;
        bFS();
        if (arrayList != null && arrayList.size() != 0 && (a = this.imO.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.hSn.setThreadList(a);
            this.imP.a(a, this.mPn, this.hSn, 0);
        }
    }

    private void bFS() {
        if (this.gRi == 0 && !this.imO.cO(this.hSn.getThreadListIds())) {
            if (this.hSn.getThreadList() == null || this.hSn.getThreadList().size() == 0) {
                this.imP.bGT();
            } else {
                this.imP.bGS();
            }
        } else if (y.getCount(this.hSn.getThreadList()) > 3) {
            this.imP.bGR();
        } else {
            this.imP.cnu();
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0210a
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
        com.baidu.tbadk.distribute.a.bri().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void cmq() {
        if (this.imN != null) {
            this.imN.cmq();
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
    public NavigationBar bJH() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hSH;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hSn != null) {
            i = this.hSn.getSortType();
        }
        tbPageTag.sortType = g.yI(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yj(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            oU(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void clz() {
        if (this.imP != null && this.imP.getListView() != null) {
            this.imP.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bGQ() {
        if (this.imP != null) {
            clz();
            this.imP.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hTp.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a rQ(int i) {
        return this.hTp.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.au
    public void bkD() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bAA().Di("page_frs_good");
            oU(true);
            return;
        }
        this.imP.kf(false);
    }

    @Override // com.baidu.tieba.frs.au
    public void bkE() {
        com.baidu.tieba.s.c.dvE().b(getUniqueId(), false);
    }

    public void a(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null && cmw() != null && cmw().getThreadList() != null) {
            if (y.isEmpty(cmw().getThreadList())) {
                cmw().getThreadList().add(asVar);
            } else {
                if (cmw().getThreadList().size() == 1 && (cmw().getThreadList().get(0) instanceof com.baidu.tieba.frs.s)) {
                    cmw().getThreadList().remove(0);
                }
                cmw().getThreadList().add(0, asVar);
            }
            this.imP.a(this.hSn.getThreadList(), this.mPn, this.hSn, this.hSn.getPage().bdu());
            this.imP.crm();
            this.imP.setListViewSelection(0);
        }
    }
}
