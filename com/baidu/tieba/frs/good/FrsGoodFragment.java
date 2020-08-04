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
import com.baidu.i.a.a;
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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
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
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.f;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.tbadkCore.util.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes16.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0153a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aq, ar, as, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private VoiceManager hFy;
    private c hKX;
    private String hYD;
    private FrsGoodModelController hYF;
    private FrsLoadMoreModel hYG;
    private com.baidu.tieba.frs.gametab.b hYI;
    private String mForumId;
    private String hFr = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean hYE = false;
    private String forumId = null;
    private FrsViewData hEX = new FrsViewData();
    public long hio = -1;
    public long eHd = 0;
    public long eHn = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean hFL = false;
    protected a hYH = null;
    private int gEI = -1;
    private int mTabId = 0;
    private int hNH = 3;
    private boolean hcA = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hFZ = new SparseArray<>();
    private boolean hYJ = false;
    private int cXV = 0;
    private int hGx = 0;
    private CustomMessageListener hJb = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.hKX != null && FrsGoodFragment.this.hKX.isViewAttached()) {
                FrsGoodFragment.this.hKX.oh(num.intValue());
            }
        }
    };
    private Runnable hYK = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.hcA) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.oq(false);
            }
        }
    };
    private CustomMessageListener hYL = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bv)) {
                bv bvVar = (bv) customResponsedMessage.getData();
                FrsGoodFragment.this.hYD = bvVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.hYD) && bvVar.aVW() != null) {
                    FrsGoodFragment.this.vP(bvVar.aVW().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener hGL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.bcE() != null) {
                        FrsGoodFragment.this.bcE().setSelection(0);
                    }
                    if (FrsGoodFragment.this.hKX != null && FrsGoodFragment.this.hKX.isViewAttached()) {
                        FrsGoodFragment.this.oq(false);
                    } else if (FrsGoodFragment.this.hYH != null) {
                        FrsGoodFragment.this.hYH.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final q hHd = new q() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long hYO = 1;

        @Override // com.baidu.tieba.tbadkCore.q
        public void uG(int i) {
            if (!FrsGoodFragment.this.hYJ) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.hYH.ccH();
                        return;
                    case 3:
                        FrsGoodFragment.this.hYH.jH(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void a(int i, boolean z, f fVar) {
            ArrayList<com.baidu.adp.widget.ListView.q> a;
            if (FrsGoodFragment.this.hYJ) {
                if (FrsGoodFragment.this.cgF().cgN() == null) {
                    FrsGoodFragment.this.hYJ = false;
                    return;
                } else if (FrsGoodFragment.this.cgF().cgN().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.hYJ = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.hYO = 1L;
            } else if (fVar.isSuccess) {
                this.hYO = 0L;
            } else {
                this.hYO = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.hYG.resetData();
            }
            FrsGoodFragment.this.hYH.jH(false);
            if (FrsGoodFragment.this.cgF().cgN() != null) {
                FrsGoodFragment.this.hEX = FrsGoodFragment.this.cgF().cgN();
            }
            FrsGoodFragment.this.gEI = FrsGoodFragment.this.hEX.getPage().aVb();
            if (FrsGoodFragment.this.gEI != 0 || (FrsGoodFragment.this.hEX.getThreadListIds() != null && FrsGoodFragment.this.hEX.getThreadListIds().size() != 0)) {
                if (x.getCount(FrsGoodFragment.this.hEX.getThreadList()) > 3) {
                    FrsGoodFragment.this.hYH.bxS();
                } else {
                    FrsGoodFragment.this.hYH.ccX();
                }
            } else if (FrsGoodFragment.this.hEX.getThreadList() == null || FrsGoodFragment.this.hEX.getThreadList().size() == 0) {
                FrsGoodFragment.this.hYH.bxU();
            } else {
                FrsGoodFragment.this.hYH.bxT();
            }
            if (i == 4) {
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsGoodFragment.this.hYG.a(false, false, false, FrsGoodFragment.this.hEX.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.hEX.setThreadList(a2);
                    FrsGoodFragment.this.hYH.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.hEX, FrsGoodFragment.this.gEI);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.hYH.ccH();
                    break;
                case 2:
                    FrsGoodFragment.this.hYH.ccH();
                    break;
                case 3:
                    if (FrsGoodFragment.this.hEX.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.hYO != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.hEX != null) {
                    FrsGoodFragment.this.hFr = FrsGoodFragment.this.hEX.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.hEX.getForum().getId();
                    FrsGoodFragment.this.hYH.b(FrsGoodFragment.this.hEX.getForum(), FrsGoodFragment.this.hEX.getUserData());
                }
                if (FrsGoodFragment.this.hEX != null) {
                    FrsGoodFragment.this.hEX.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.hYH.c(FrsGoodFragment.this.hEX);
                if (FrsGoodFragment.this.hEX == null || FrsGoodFragment.this.hEX.getThreadList() == null || FrsGoodFragment.this.hEX.getThreadList().size() != 0 || FrsGoodFragment.this.cgF().getType() != 4) {
                    if (FrsGoodFragment.this.hEX != null && (a = FrsGoodFragment.this.hYG.a(false, false, true, FrsGoodFragment.this.hEX.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.hEX.setThreadList(a);
                    }
                    FrsGoodFragment.this.cbP();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.hio > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.hio, FrsGoodFragment.this.cgF().bVN() - FrsGoodFragment.this.hio, FrsGoodFragment.this.cgF().bVL(), FrsGoodFragment.this.cgF().bVM(), currentTimeMillis2 - FrsGoodFragment.this.cgF().bVK());
                        FrsGoodFragment.this.hio = -1L;
                    }
                    FrsGoodFragment.this.eHn = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.hio > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.hio, FrsGoodFragment.this.cgF().bVN() - FrsGoodFragment.this.hio, FrsGoodFragment.this.cgF().bVL(), FrsGoodFragment.this.cgF().bVM(), currentTimeMillis3 - FrsGoodFragment.this.cgF().bVK());
                FrsGoodFragment.this.hio = -1L;
            }
            FrsGoodFragment.this.eHn = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void cbJ() {
        }
    };
    private final CustomMessageListener dLt = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.hYH != null) {
                FrsGoodFragment.this.hYH.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.hFL) {
                FrsGoodFragment.this.hFL = true;
                FrsGoodFragment.this.hYH.ccW();
            }
            if (i == 0) {
                s.bRL().mH(true);
                com.baidu.tieba.s.c.dkh().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.hGx += i2;
            if (FrsGoodFragment.this.hGx >= FrsGoodFragment.this.cXV * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener erZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private z hHk = new z() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.z
        public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bu)) {
                bv bvVar = ((bu) qVar).dLK;
                if (bvVar.aXl() == null || bvVar.aXl().getGroup_id() == 0 || bf.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bvVar.aWY() != 1 || bf.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.NZ(bvVar.getId())) {
                            readThreadHistory.NY(bvVar.getId());
                            if (FrsGoodFragment.this.hYH != null) {
                                FrsGoodFragment.this.hYH.ccH();
                            }
                        }
                        boolean z = false;
                        final String aWr = bvVar.aWr();
                        if (aWr != null && !aWr.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(aWr);
                                    zVar.bav().baW().mIsNeedAddCommenParam = false;
                                    zVar.bav().baW().mIsUseCurrentBDUSS = false;
                                    zVar.getNetData();
                                }
                            }).start();
                        }
                        String str = null;
                        if (bvVar != null) {
                            str = bvVar.getTid();
                        }
                        if (str == null) {
                            str = "";
                        }
                        if (bvVar.aWg() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bd.baV().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3 && str.length() > 3) {
                            bvVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bvVar, FrsGoodFragment.this.hFr, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bvVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.hEX != null && FrsGoodFragment.this.hEX.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.icM = FrsGoodFragment.this.hEX.needLog == 1;
                            bVar.icO = FrsGoodFragment.this.hEX.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.hOG != null) {
                                bVar.icP = com.baidu.tieba.frs.d.d.hOG.icP;
                                bVar.icQ = com.baidu.tieba.frs.d.d.hOG.icQ;
                            }
                            com.baidu.tieba.frs.d.a.a(bvVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hHo = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.hYH != null) {
                FrsGoodFragment.this.hYH.zc();
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

    public void cez() {
        if (this.hYH != null) {
            this.hYH.refreshView();
        }
    }

    private void showLoadingView() {
        this.hYH.nZ(false);
        showLoadingView(this.hYH.bPb(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.hYH.nZ(true);
        hideLoadingView(this.hYH.bPb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.hYH.nZ(false);
        this.hYH.nY(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hYH.bxU();
        this.hYH.getListView().getData().clear();
        this.hYH.ccH();
        if (this.hKX == null) {
            this.hKX = new c(getPageContext().getContext(), getNetRefreshListener());
            this.hKX.setTitle(null);
            this.hKX.setButtonText(null);
            this.hKX.showRefreshButton();
            this.hKX.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hKX.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hKX.setSubText(null);
        }
        this.hKX.onChangeSkinType();
        this.hKX.attachView(this.hYH.bPb(), true);
        registerListener(this.hJb);
    }

    private void bwX() {
        this.hYH.nZ(true);
        this.hYH.nY(true);
        if (this.hKX != null && this.hKX.isViewAttached()) {
            this.hKX.dettachView(this.hYH.bPb());
        }
        MessageManager.getInstance().unRegisterListener(this.hJb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oq(boolean z) {
        this.hcA = true;
        cbU();
        bwX();
        if (!z) {
            bwX();
            showLoadingView();
        }
        this.hYF.qr(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hio = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.hio = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.eHd = this.beginTime - this.hio;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dkh().A(getUniqueId());
        this.hYF = new FrsGoodModelController(this);
        if (arguments != null) {
            this.hYF.ak(arguments);
            this.hYE = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.hYF.ak(bundle);
            this.hYE = bundle.getBoolean("is_game_frs", false);
        } else {
            this.hYF.ak(null);
        }
        this.hFy = getVoiceManager();
        this.hFy.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dLt);
        registerListener(this.hYL);
        registerListener(this.hGL);
        registerListener(this.hHo);
        this.hYG = new FrsLoadMoreModel(this, null);
        this.hYG.registerListener();
        this.hYG.setPageType(2);
        this.hYG.os(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cXV = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.hYH = new a(this, inflate, this.hYE);
        this.hYH.cgJ().cgQ();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.hcA) {
            if (j.isNetWorkAvailable()) {
                oq(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new ap("c13008").dn("fid", this.mForumId).dn("obj_type", "7").ah("obj_locate", 2).dn("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hFy = getVoiceManager();
        this.hFy.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cgC();
        if (bundle != null) {
            this.hFr = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.hFr = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cgC() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.erZ);
    }

    public FrsLoadMoreModel cgD() {
        return this.hYG;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.hYH != null) {
            this.hYH.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hJb);
        com.baidu.tieba.s.c.dkh().B(getUniqueId());
        s.bRL().mH(false);
        super.onDestroy();
        this.hYF.cgL();
        this.hFy = getVoiceManager();
        this.hFy.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.hYK);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hFr);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.hYE);
        this.hYF.onSaveInstanceState(bundle);
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bv threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.hYH.cgJ().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.hEX.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.ld(intent.getIntExtra("good_data", 0));
                            threadDataById.aXj();
                            oq(false);
                            return;
                        } else if (intExtra == 0) {
                            this.hEX.removeThreadData(threadDataById);
                            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hEX.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new r());
                            }
                            this.hYH.cgH();
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
            if (this.hNH == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.hcA) {
                com.baidu.adp.lib.f.e.lt().post(this.hYK);
            }
        }
        cdQ();
    }

    private void cdQ() {
        if (isPrimary()) {
            if (this.hKX != null && this.hKX.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hJb);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hJb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hYH != null) {
            this.hYH.ccH();
        }
        this.hFy = getVoiceManager();
        this.hFy.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.hYI = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.hYH.a(this.hHk);
        this.hYH.setOnScrollListener(this.mScrollListener);
        this.hYH.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.hYI != null) {
                    FrsGoodFragment.this.hYI.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hNH != 3 || this.hYH != null) {
            this.hNH = i;
            super.onChangeSkinType(i);
            if (this.hYH != null) {
                this.hYH.onChangeSkinType(i);
            }
            if (this.hKX != null && this.hKX.isViewAttached()) {
                this.hKX.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> caJ() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).caJ();
        }
        return null;
    }

    private void cbO() {
        switch (this.mFlag) {
            case 1:
                h.lu().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.NT(FrsGoodFragment.this.hFr);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbP() {
        cbU();
        try {
            if (this.hEX != null) {
                this.hYH.cea();
                this.hYH.bBY();
                this.hFr = this.hEX.getForum().getName();
                this.forumId = this.hEX.getForum().getId();
                if (this.hEX != null && this.hEX.getForum() != null) {
                    this.hYH.a(this.hEX.getForum().getThemeColorInfo());
                    this.hYH.c(this.hEX);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.hEX.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hEX.getUserData().getBimg_end_time());
                cbO();
                if (!this.hYH.cgJ().s(bv.dRT)) {
                    this.hEX.removeAlaLiveThreadData();
                }
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hEX.getThreadList();
                if (threadList != null) {
                    this.hYH.a(threadList, this.mPn, this.hEX, this.hEX.getPage().aVb());
                    cgE();
                    this.hYH.cgH();
                    if (this.hEX.getIsNewUrl() == 1) {
                        this.hYH.cgJ().setFromCDN(true);
                    } else {
                        this.hYH.cgJ().setFromCDN(false);
                    }
                    this.hYH.setListViewSelection(cj(cgF().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cj(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hFy = getVoiceManager();
        this.hFy.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.bRL().mH(false);
        com.baidu.tieba.s.c.dkh().b(getUniqueId(), false);
        if (this.hEX != null && this.hEX.getForum() != null) {
            com.baidu.tbadk.distribute.a.biw().b(getPageContext().getPageActivity(), "frs", this.hEX.getForum().getId(), 0L);
        }
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vP(int i) {
        ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hEX.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q next = it.next();
                if (next instanceof bu) {
                    bv bvVar = ((bu) next).dLK;
                    if (bvVar.getId() != null && bvVar.getId().equals(this.hYD)) {
                        c(bvVar, i);
                        this.hYD = null;
                        break;
                    }
                }
            }
            this.hYH.cgJ().b(threadList, this.hEX);
            this.hYH.cgJ().notifyDataSetChanged();
        }
    }

    private void c(bv bvVar, int i) {
        if (i == 1) {
            PraiseData aVW = bvVar.aVW();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (aVW == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bvVar.a(praiseData);
                    return;
                }
                bvVar.aVW().getUser().add(0, metaData);
                bvVar.aVW().setNum(bvVar.aVW().getNum() + 1);
                bvVar.aVW().setIsLike(i);
            }
        } else if (bvVar.aVW() != null) {
            bvVar.aVW().setIsLike(i);
            bvVar.aVW().setNum(bvVar.aVW().getNum() - 1);
            ArrayList<MetaData> user = bvVar.aVW().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bvVar.aVW().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hFy == null) {
            this.hFy = VoiceManager.instance();
        }
        return this.hFy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView bcE() {
        if (this.hYH == null) {
            return null;
        }
        return this.hYH.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cbU() {
        this.hFy = getVoiceManager();
        this.hFy.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bcF() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bcF();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.hEX != null && this.hYH != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.hYH.ccH();
            }
        }
    }

    private void cgE() {
        HashMap<Integer, bv> cfc;
        if (this.hYH != null && this.hYH.cgJ() != null && (cfc = this.hYH.cgJ().cfc()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bv> entry : cfc.entrySet()) {
                bv value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.biC().F(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        if (bcE() == null) {
            return null;
        }
        return bcE().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            oq(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cbZ() {
        return this.hEX;
    }

    public FrsGoodModelController cgF() {
        return this.hYF;
    }

    public void Gj(String str) {
        this.hFr = str;
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
            this.hYH.bxU();
        } else if (!this.hYF.cgP()) {
            this.hYH.bxU();
        } else {
            bwT();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.hYG.isLoading && !this.hYF.isLoading()) {
                if (this.hYG.cM(this.hEX.getThreadListIds())) {
                    this.hYH.a(this.hYG.cha(), this.mPn, this.hEX, 0);
                    this.hYG.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.hEX.getThreadListIds(), this.hFr, this.mPn, this.hEX.isBrandForum);
                } else if (this.gEI != 0) {
                    this.hYH.a(this.hYG.cha(), this.mPn, this.hEX, 0);
                    this.mPn++;
                    this.hYF.vR(this.mPn);
                    this.hYG.loadingDone = false;
                    this.hYG.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bwT();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ao(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.q> a;
        bwT();
        if (arrayList != null && arrayList.size() != 0 && (a = this.hYG.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.hEX.setThreadList(a);
            this.hYH.a(a, this.mPn, this.hEX, 0);
        }
    }

    private void bwT() {
        if (this.gEI == 0 && !this.hYG.cM(this.hEX.getThreadListIds())) {
            if (this.hEX.getThreadList() == null || this.hEX.getThreadList().size() == 0) {
                this.hYH.bxU();
            } else {
                this.hYH.bxT();
            }
        } else if (x.getCount(this.hEX.getThreadList()) > 3) {
            this.hYH.bxS();
        } else {
            this.hYH.ccX();
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.i.a.a.InterfaceC0153a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ad.checkCamera(getActivity().getApplicationContext())) {
                an.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ad.transformPermissionResult(strArr, iArr);
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
        com.baidu.tbadk.distribute.a.biw().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void cbT() {
        if (this.hYF != null) {
            this.hYF.cbT();
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

    @Override // com.baidu.tieba.frs.ar
    public NavigationBar bAm() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hFr;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hEX != null) {
            i = this.hEX.getSortType();
        }
        tbPageTag.sortType = g.wp(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vQ(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            oq(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void cbd() {
        if (this.hYH != null && this.hYH.getListView() != null) {
            this.hYH.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxR() {
        if (this.hYH != null) {
            cbd();
            this.hYH.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hFZ.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a pE(int i) {
        return this.hFZ.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.as
    public void bcg() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.brD().AO("page_frs_good");
            oq(true);
            return;
        }
        this.hYH.jH(false);
    }

    @Override // com.baidu.tieba.frs.as
    public void bch() {
        com.baidu.tieba.s.c.dkh().b(getUniqueId(), false);
    }

    public void a(com.baidu.tbadk.core.data.ar arVar) {
        if (arVar != null && cbZ() != null && cbZ().getThreadList() != null) {
            if (x.isEmpty(cbZ().getThreadList())) {
                cbZ().getThreadList().add(arVar);
            } else {
                if (cbZ().getThreadList().size() == 1 && (cbZ().getThreadList().get(0) instanceof r)) {
                    cbZ().getThreadList().remove(0);
                }
                cbZ().getThreadList().add(0, arVar);
            }
            this.hYH.a(this.hEX.getThreadList(), this.mPn, this.hEX, this.hEX.getPage().aVb());
            this.hYH.cgH();
            this.hYH.setListViewSelection(0);
        }
    }
}
