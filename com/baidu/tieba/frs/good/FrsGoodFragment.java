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
    private String gFe;
    private FrsGoodModelController gFg;
    private FrsLoadMoreModel gFh;
    private com.baidu.tieba.frs.gametab.b gFj;
    private VoiceManager goj;
    private c gta;
    private String mForumId;
    private String goc = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean gFf = false;
    private String forumId = null;
    private FrsViewData gnK = new FrsViewData();
    public long fVe = -1;
    public long dDv = 0;
    public long dDD = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean gou = false;
    protected a gFi = null;
    private int fsb = -1;
    private int mTabId = 0;
    private int gvF = 3;
    private boolean fPp = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> goH = new SparseArray<>();
    private boolean gFk = false;
    private int cdu = 0;
    private int gpf = 0;
    private CustomMessageListener gre = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.gta != null && FrsGoodFragment.this.gta.isViewAttached()) {
                FrsGoodFragment.this.gta.mD(num.intValue());
            }
        }
    };
    private Runnable gFl = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.fPp) {
                FrsGoodFragment.this.c((e.b) null);
            } else {
                FrsGoodFragment.this.lV(false);
            }
        }
    };
    private CustomMessageListener gFm = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
                bj bjVar = (bj) customResponsedMessage.getData();
                FrsGoodFragment.this.gFe = bjVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.gFe) && bjVar.aBX() != null) {
                    FrsGoodFragment.this.tI(bjVar.aBX().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener gpi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.aIf() != null) {
                        FrsGoodFragment.this.aIf().setSelection(0);
                    }
                    if (FrsGoodFragment.this.gta != null && FrsGoodFragment.this.gta.isViewAttached()) {
                        FrsGoodFragment.this.lV(false);
                    } else if (FrsGoodFragment.this.gFi != null) {
                        FrsGoodFragment.this.gFi.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final p gpx = new p() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
        private long gFp = 1;

        @Override // com.baidu.tieba.tbadkCore.p
        public void sG(int i) {
            if (!FrsGoodFragment.this.gFk) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.gFi.bER();
                        return;
                    case 3:
                        FrsGoodFragment.this.gFi.hu(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            ArrayList<m> a;
            if (FrsGoodFragment.this.gFk) {
                if (FrsGoodFragment.this.bID().bIK() == null) {
                    FrsGoodFragment.this.gFk = false;
                    return;
                } else if (FrsGoodFragment.this.bID().bIK().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.gFk = false;
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
                FrsGoodFragment.this.gFh.resetData();
            }
            FrsGoodFragment.this.gFi.hu(false);
            if (FrsGoodFragment.this.bID().bIK() != null) {
                FrsGoodFragment.this.gnK = FrsGoodFragment.this.bID().bIK();
            }
            FrsGoodFragment.this.fsb = FrsGoodFragment.this.gnK.getPage().aBi();
            if (FrsGoodFragment.this.fsb == 0 && (FrsGoodFragment.this.gnK.getThreadListIds() == null || FrsGoodFragment.this.gnK.getThreadListIds().size() == 0)) {
                if (FrsGoodFragment.this.gnK.getThreadList() == null || FrsGoodFragment.this.gnK.getThreadList().size() == 0) {
                    FrsGoodFragment.this.gFi.bdr();
                } else {
                    FrsGoodFragment.this.gFi.bdq();
                }
            } else {
                FrsGoodFragment.this.gFi.bdp();
            }
            if (i == 4) {
                ArrayList<m> a2 = FrsGoodFragment.this.gFh.a(false, false, false, FrsGoodFragment.this.gnK.getThreadList(), (f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.gnK.setThreadList(a2);
                    FrsGoodFragment.this.gFi.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.gnK, FrsGoodFragment.this.fsb);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.gFi.bER();
                    break;
                case 2:
                    FrsGoodFragment.this.gFi.bER();
                    break;
                case 3:
                    if (FrsGoodFragment.this.gnK.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.gFp != 0) {
                FrsGoodFragment.this.c(bVar);
            } else {
                if (FrsGoodFragment.this.gnK != null) {
                    FrsGoodFragment.this.goc = FrsGoodFragment.this.gnK.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.gnK.getForum().getId();
                    FrsGoodFragment.this.gFi.b(FrsGoodFragment.this.gnK.getForum(), FrsGoodFragment.this.gnK.getUserData());
                }
                if (FrsGoodFragment.this.gnK != null) {
                    FrsGoodFragment.this.gnK.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.gFi.c(FrsGoodFragment.this.gnK);
                if (FrsGoodFragment.this.gnK == null || FrsGoodFragment.this.gnK.getThreadList() == null || FrsGoodFragment.this.gnK.getThreadList().size() != 0 || FrsGoodFragment.this.bID().getType() != 4) {
                    if (FrsGoodFragment.this.gnK != null && (a = FrsGoodFragment.this.gFh.a(false, false, true, FrsGoodFragment.this.gnK.getThreadList(), (f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.gnK.setThreadList(a);
                    }
                    FrsGoodFragment.this.bEf();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.fVe > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.fVe, FrsGoodFragment.this.bID().byN() - FrsGoodFragment.this.fVe, FrsGoodFragment.this.bID().byL(), FrsGoodFragment.this.bID().byM(), currentTimeMillis2 - FrsGoodFragment.this.bID().byK());
                        FrsGoodFragment.this.fVe = -1L;
                    }
                    FrsGoodFragment.this.dDD = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.fVe > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.fVe, FrsGoodFragment.this.bID().byN() - FrsGoodFragment.this.fVe, FrsGoodFragment.this.bID().byL(), FrsGoodFragment.this.bID().byM(), currentTimeMillis3 - FrsGoodFragment.this.bID().byK());
                FrsGoodFragment.this.fVe = -1L;
            }
            FrsGoodFragment.this.dDD = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(l lVar) {
        }
    };
    private final CustomMessageListener cLF = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.gFi != null) {
                FrsGoodFragment.this.gFi.startPullRefresh();
            }
        }
    };
    private final g.c erT = new g.c() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            TiebaStatic.eventStat(FrsGoodFragment.this.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (j.isNetWorkAvailable()) {
                d.aXD().wN("page_frs_good");
                FrsGoodFragment.this.lV(true);
                return;
            }
            FrsGoodFragment.this.gFi.hu(false);
        }
    };
    private final g.b dgI = new g.b() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            if (z) {
                com.baidu.tieba.s.c.cJY().b(FrsGoodFragment.this.getUniqueId(), false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.gou) {
                FrsGoodFragment.this.gou = true;
                FrsGoodFragment.this.gFi.bFf();
            }
            if (i == 0) {
                r.bve().kp(true);
                com.baidu.tieba.s.c.cJY().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.gpf += i2;
            if (FrsGoodFragment.this.gpf >= FrsGoodFragment.this.cdu * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener doq = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
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
    private s gpD = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && mVar != null && (mVar instanceof bi)) {
                bj bjVar = ((bi) mVar).cRe;
                if (bjVar.aDj() == null || bjVar.aDj().getGroup_id() == 0 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bjVar.aCW() != 1 || bc.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Jo(bjVar.getId())) {
                            readThreadHistory.Jn(bjVar.getId());
                            if (FrsGoodFragment.this.gFi != null) {
                                FrsGoodFragment.this.gFi.bER();
                            }
                        }
                        boolean z = false;
                        final String aCt = bjVar.aCt();
                        if (aCt != null && !aCt.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(aCt);
                                    xVar.aGe().aGF().mIsNeedAddCommenParam = false;
                                    xVar.aGe().aGF().mIsUseCurrentBDUSS = false;
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
                        if (bjVar.aCh() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            ba.aGE().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3) {
                            bjVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bjVar, FrsGoodFragment.this.goc, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bjVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.gnK != null && FrsGoodFragment.this.gnK.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.gJk = FrsGoodFragment.this.gnK.needLog == 1;
                            bVar.gJm = FrsGoodFragment.this.gnK.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.gwo != null) {
                                bVar.gJn = com.baidu.tieba.frs.d.d.gwo.gJn;
                                bVar.gJo = com.baidu.tieba.frs.d.d.gwo.gJo;
                            }
                            com.baidu.tieba.frs.d.a.a(bjVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gpH = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.gFi != null) {
                FrsGoodFragment.this.gFi.sm();
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
        this.gFi.lF(false);
        showLoadingView(this.gFi.bsC(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gFi.lF(true);
        hideLoadingView(this.gFi.bsC());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        this.gFi.lF(false);
        this.gFi.bGd().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gFi.bdr();
        this.gFi.getListView().getData().clear();
        this.gFi.bER();
        if (this.gta == null) {
            this.gta = new c(getPageContext().getContext(), getNetRefreshListener());
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
        this.gta.attachView(this.gFi.bsC(), true);
        registerListener(this.gre);
    }

    private void bcv() {
        this.gFi.lF(true);
        this.gFi.bGd().setEnabled(true);
        if (this.gta != null && this.gta.isViewAttached()) {
            this.gta.dettachView(this.gFi.bsC());
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
        this.gFg.oF(this.mTabId);
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
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.dDv = this.beginTime - this.fVe;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cJY().w(getUniqueId());
        this.gFg = new FrsGoodModelController(this);
        if (arguments != null) {
            this.gFg.ad(arguments);
            this.gFf = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.gFg.ad(bundle);
            this.gFf = bundle.getBoolean("is_game_frs", false);
        } else {
            this.gFg.ad(null);
        }
        this.goj = getVoiceManager();
        this.goj.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.cLF);
        registerListener(this.gFm);
        registerListener(this.gpi);
        registerListener(this.gpH);
        this.gFh = new FrsLoadMoreModel(this, null);
        this.gFh.registerListener();
        this.gFh.setPageType(2);
        this.gFh.lX(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cdu = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.gFi = new a(this, inflate, this.gFf);
        this.gFi.bIH().bIN();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.fPp) {
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

    public FrsLoadMoreModel bIB() {
        return this.gFh;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gFi != null) {
            this.gFi.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gre);
        com.baidu.tieba.s.c.cJY().x(getUniqueId());
        r.bve().kp(false);
        super.onDestroy();
        this.gFg.aiG();
        this.goj = getVoiceManager();
        this.goj.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gFl);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.goc);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.gFf);
        this.gFg.onSaveInstanceState(bundle);
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
                    this.gFi.bIH().notifyDataSetChanged();
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
                            this.gFi.bIF();
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
        if (this.gFi != null) {
            this.gFi.bER();
        }
        this.goj = getVoiceManager();
        this.goj.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.gFj = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.gFi.a(this.gpD);
        this.gFi.setOnScrollListener(this.mScrollListener);
        this.gFi.setListPullRefreshListener(this.erT);
        this.gFi.a(this.dgI);
        this.gFi.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.gFj != null) {
                    FrsGoodFragment.this.gFj.c(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gvF != 3 || this.gFi != null) {
            this.gvF = i;
            super.onChangeSkinType(i);
            if (this.gFi != null) {
                this.gFi.onChangeSkinType(i);
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
                h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Ji(FrsGoodFragment.this.goc);
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
                this.gFi.bgw();
                this.goc = this.gnK.getForum().getName();
                this.forumId = this.gnK.getForum().getId();
                if (this.gnK != null && this.gnK.getForum() != null) {
                    this.gFi.a(this.gnK.getForum().getThemeColorInfo());
                    this.gFi.c(this.gnK);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.gnK.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.gnK.getUserData().getBimg_end_time());
                bEe();
                if (!this.gFi.bIH().p(bj.cRz)) {
                    this.gnK.removeAlaLiveThreadData();
                }
                ArrayList<m> threadList = this.gnK.getThreadList();
                if (threadList != null) {
                    this.gFi.a(threadList, this.mPn, this.gnK, this.gnK.getPage().aBi());
                    bIC();
                    this.gFi.bIF();
                    if (this.gnK.getIsNewUrl() == 1) {
                        this.gFi.bIH().setFromCDN(true);
                    } else {
                        this.gFi.bIH().setFromCDN(false);
                    }
                    this.gFi.setListViewSelection(bO(bID().getType(), this.mPn));
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
            this.gFi.bIH().b(threadList, this.gnK);
            this.gFi.bIH().notifyDataSetChanged();
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
        if (this.gFi == null) {
            return null;
        }
        return this.gFi.getListView();
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
        if (this.gnK != null && this.gFi != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.gFi.bER();
            }
        }
    }

    private void bIC() {
        HashMap<Integer, bj> bGY;
        if (this.gFi != null && this.gFi.bIH() != null && (bGY = this.gFi.bIH().bGY()) != null) {
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
        if (j.isNetWorkAvailable()) {
            lV(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bEn() {
        return this.gnK;
    }

    public FrsGoodModelController bID() {
        return this.gFg;
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

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.gFi.bdr();
        } else if (!this.gFg.bIM()) {
            this.gFi.bdr();
        } else {
            bcs();
            if (!this.gFh.isLoading && !this.gFg.isLoading()) {
                if (this.gFh.cn(this.gnK.getThreadListIds())) {
                    this.gFi.a(this.gFh.bIX(), this.mPn, this.gnK, 0);
                    this.gFh.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.gnK.getThreadListIds(), this.goc, this.mPn, this.gnK.isBrandForum);
                } else if (this.fsb != 0) {
                    this.gFi.a(this.gFh.bIX(), this.mPn, this.gnK, 0);
                    this.mPn++;
                    this.gFg.tK(this.mPn);
                    this.gFh.loadingDone = false;
                    this.gFh.loadIndex = 0;
                }
            }
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.gFh.a(false, false, false, arrayList, (f) null)) != null) {
            this.gnK.setThreadList(a);
            this.gFi.a(a, this.mPn, this.gnK, 0);
        }
    }

    private void bcs() {
        if (this.fsb == 0 && !this.gFh.cn(this.gnK.getThreadListIds())) {
            if (this.gnK.getThreadList() == null || this.gnK.getThreadList().size() == 0) {
                this.gFi.bdr();
                return;
            } else {
                this.gFi.bdq();
                return;
            }
        }
        this.gFi.bdp();
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
        if (this.gFg != null) {
            this.gFg.bEh();
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.gnK != null) {
            i = this.gnK.getSortType();
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
        if (this.gFi != null && this.gFi.getListView() != null) {
            this.gFi.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void bdo() {
        if (this.gFi != null) {
            scrollToTop();
            this.gFi.startPullRefresh();
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
}
