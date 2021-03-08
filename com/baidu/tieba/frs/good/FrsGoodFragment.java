package com.baidu.tieba.frs.good;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.f.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.l.a.a;
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
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.l.c;
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
import com.baidu.tieba.tbadkCore.f;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.util.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0154a, UserIconBox.a, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ao, ap, aq, com.baidu.tieba.frs.loadmore.a, q, FrsCommonImageLayout.c {
    private String jFf;
    private FrsGoodModelController jFh;
    private FrsLoadMoreModel jFi;
    private com.baidu.tieba.frs.gametab.b jFk;
    private VoiceManager jie;
    private c jot;
    private boolean jrh;
    private String mForumId;
    private String jhW = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean jFg = false;
    private String forumId = null;
    private FrsViewData jhD = new FrsViewData();
    public long iKN = -1;
    public long fKL = 0;
    public long fKU = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected a jFj = null;
    private int hYW = -1;
    private int mTabId = 0;
    private int jrf = 3;
    private boolean iEX = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jiE = new SparseArray<>();
    private boolean jFl = false;
    private int dWJ = 0;
    private int jjc = 0;
    private CustomMessageListener jlI = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.jot != null && FrsGoodFragment.this.jot.isViewAttached()) {
                FrsGoodFragment.this.jot.rn(num.intValue());
            }
        }
    };
    private Runnable jFm = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.iEX) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.rq(false);
            }
        }
    };
    private CustomMessageListener jFn = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof cb)) {
                cb cbVar = (cb) customResponsedMessage.getData();
                FrsGoodFragment.this.jFf = cbVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.jFf) && cbVar.bnD() != null) {
                    FrsGoodFragment.this.zW(cbVar.bnD().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener jjr = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.getListView() != null) {
                        FrsGoodFragment.this.getListView().setSelection(0);
                    }
                    if (FrsGoodFragment.this.jot != null && FrsGoodFragment.this.jot.isViewAttached()) {
                        FrsGoodFragment.this.rq(false);
                    } else if (FrsGoodFragment.this.jFj != null) {
                        FrsGoodFragment.this.jFj.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s jjK = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long jFq = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void yB(int i) {
            if (!FrsGoodFragment.this.jFl) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.jFj.cDU();
                        return;
                    case 3:
                        FrsGoodFragment.this.jFj.lU(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, f fVar) {
            ArrayList<n> a2;
            if (FrsGoodFragment.this.jFl) {
                if (FrsGoodFragment.this.cJg().cJo() == null) {
                    FrsGoodFragment.this.jFl = false;
                    return;
                } else if (FrsGoodFragment.this.cJg().cJo().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.jFl = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jFq = 1L;
            } else if (fVar.isSuccess) {
                this.jFq = 0L;
            } else {
                this.jFq = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.jFi.resetData();
            }
            FrsGoodFragment.this.jFj.lU(false);
            if (FrsGoodFragment.this.cJg().cJo() != null) {
                FrsGoodFragment.this.jhD = FrsGoodFragment.this.cJg().cJo();
            }
            FrsGoodFragment.this.hYW = FrsGoodFragment.this.jhD.getPage().bmH();
            if (FrsGoodFragment.this.hYW != 0 || (FrsGoodFragment.this.jhD.getThreadListIds() != null && FrsGoodFragment.this.jhD.getThreadListIds().size() != 0)) {
                if (y.getCount(FrsGoodFragment.this.jhD.getThreadList()) > 3) {
                    FrsGoodFragment.this.jFj.Xa();
                } else {
                    FrsGoodFragment.this.jFj.cEj();
                }
            } else if (FrsGoodFragment.this.jhD.getThreadList() == null || FrsGoodFragment.this.jhD.getThreadList().size() == 0) {
                FrsGoodFragment.this.jFj.bSE();
            } else {
                FrsGoodFragment.this.jFj.Xb();
            }
            if (i == 4) {
                ArrayList<n> a3 = FrsGoodFragment.this.jFi.a(false, false, false, FrsGoodFragment.this.jhD.getThreadList(), null);
                if (a3 != null) {
                    FrsGoodFragment.this.jhD.setThreadList(a3);
                    FrsGoodFragment.this.jFj.a(a3, FrsGoodFragment.this.mPn, FrsGoodFragment.this.jhD, FrsGoodFragment.this.hYW);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.jFj.cDU();
                    break;
                case 2:
                    FrsGoodFragment.this.jFj.cDU();
                    break;
                case 3:
                    if (FrsGoodFragment.this.jhD.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.jFq != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.jhD != null) {
                    FrsGoodFragment.this.jhW = FrsGoodFragment.this.jhD.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.jhD.getForum().getId();
                    FrsGoodFragment.this.jFj.b(FrsGoodFragment.this.jhD.getForum(), FrsGoodFragment.this.jhD.getUserData());
                }
                if (FrsGoodFragment.this.jhD != null) {
                    FrsGoodFragment.this.jhD.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.jFj.c(FrsGoodFragment.this.jhD);
                if (FrsGoodFragment.this.jhD == null || FrsGoodFragment.this.jhD.getThreadList() == null || FrsGoodFragment.this.jhD.getThreadList().size() != 0 || FrsGoodFragment.this.cJg().getType() != 4) {
                    if (FrsGoodFragment.this.jhD != null && (a2 = FrsGoodFragment.this.jFi.a(false, false, true, FrsGoodFragment.this.jhD.getThreadList(), null)) != null && a2.size() > 0) {
                        FrsGoodFragment.this.jhD.setThreadList(a2);
                    }
                    FrsGoodFragment.this.cDb();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.iKN > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.iKN, FrsGoodFragment.this.cJg().cwQ() - FrsGoodFragment.this.iKN, FrsGoodFragment.this.cJg().cwO(), FrsGoodFragment.this.cJg().cwP(), currentTimeMillis2 - FrsGoodFragment.this.cJg().cwN());
                        FrsGoodFragment.this.iKN = -1L;
                    }
                    FrsGoodFragment.this.fKU = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.iKN > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.iKN, FrsGoodFragment.this.cJg().cwQ() - FrsGoodFragment.this.iKN, FrsGoodFragment.this.cJg().cwO(), FrsGoodFragment.this.cJg().cwP(), currentTimeMillis3 - FrsGoodFragment.this.cJg().cwN());
                FrsGoodFragment.this.iKN = -1L;
            }
            FrsGoodFragment.this.fKU = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCV() {
        }
    };
    private final CustomMessageListener eLa = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.jFj != null) {
                FrsGoodFragment.this.jFj.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                t.csH().pB(true);
                com.baidu.tieba.s.c.dMH().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.jjc += i2;
            if (FrsGoodFragment.this.jjc >= FrsGoodFragment.this.dWJ * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener fuv = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private w jjR = new w() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && nVar != null && (nVar instanceof ca)) {
                cb cbVar = ((ca) nVar).eLr;
                if (cbVar.boT() == null || cbVar.boT().getGroup_id() == 0 || bh.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (cbVar.boE() != 1 || bh.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.TT(cbVar.getId())) {
                            readThreadHistory.TS(cbVar.getId());
                            if (FrsGoodFragment.this.jFj != null) {
                                FrsGoodFragment.this.jFj.cDU();
                            }
                        }
                        boolean z = false;
                        final String bnY = cbVar.bnY();
                        if (bnY != null && !bnY.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(bnY);
                                    aaVar.bsu().btd().mIsNeedAddCommenParam = false;
                                    aaVar.bsu().btd().mIsUseCurrentBDUSS = false;
                                    aaVar.getNetData();
                                }
                            }).start();
                        }
                        String str = null;
                        if (cbVar != null) {
                            str = cbVar.getTid();
                        }
                        if (str == null) {
                            str = "";
                        }
                        if (cbVar.bnN() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bf.bsY().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3 && str.length() > 3) {
                            cbVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(cbVar, FrsGoodFragment.this.jhW, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(cbVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.jhD != null && FrsGoodFragment.this.jhD.getForum() != null) {
                            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
                            bVar.jJh = FrsGoodFragment.this.jhD.needLog == 1;
                            bVar.jJj = FrsGoodFragment.this.jhD.getForum().getId();
                            if (com.baidu.tieba.frs.b.d.jsn != null) {
                                bVar.jJk = com.baidu.tieba.frs.b.d.jsn.jJk;
                                bVar.jJl = com.baidu.tieba.frs.b.d.jsn.jJl;
                            }
                            com.baidu.tieba.frs.b.a.a(cbVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jjV = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.jFj != null) {
                FrsGoodFragment.this.jFj.EN();
            }
        }
    };

    static /* synthetic */ int j(FrsGoodFragment frsGoodFragment) {
        int i = frsGoodFragment.mPn;
        frsGoodFragment.mPn = i - 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.f getPageContext() {
        return super.getPageContext();
    }

    public void cFU() {
        if (this.jFj != null) {
            this.jFj.refreshView();
        }
    }

    private void showLoadingView() {
        this.jFj.qV(false);
        showLoadingView(this.jFj.cnA(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jFj.qV(true);
        hideLoadingView(this.jFj.cnA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.jFj.qV(false);
        this.jFj.qU(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jFj.bSE();
        this.jFj.getListView().getData().clear();
        this.jFj.cDU();
        if (this.jot == null) {
            this.jot = new c(getPageContext().getContext(), getNetRefreshListener());
            this.jot.setTitle(null);
            this.jot.setButtonText(null);
            this.jot.showRefreshButton();
            this.jot.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.jot.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.jot.setSubText(null);
        }
        this.jot.onChangeSkinType();
        this.jot.attachView(this.jFj.cnA(), true);
        registerListener(this.jlI);
    }

    private void Xc() {
        this.jFj.qV(true);
        this.jFj.qU(true);
        if (this.jot != null && this.jot.isViewAttached()) {
            this.jot.dettachView(this.jFj.cnA());
        }
        MessageManager.getInstance().unRegisterListener(this.jlI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(boolean z) {
        this.iEX = true;
        cDh();
        Xc();
        if (!z) {
            Xc();
            showLoadingView();
        }
        this.jFh.loadData(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iKN = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.iKN = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
            this.jrh = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
        }
        this.beginTime = System.currentTimeMillis();
        this.fKL = this.beginTime - this.iKN;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMH().B(getUniqueId());
        this.jFh = new FrsGoodModelController(this);
        if (arguments != null) {
            this.jFh.aj(arguments);
            this.jFg = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.jFh.aj(bundle);
            this.jFg = bundle.getBoolean("is_game_frs", false);
        } else {
            this.jFh.aj(null);
        }
        this.jie = getVoiceManager();
        this.jie.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eLa);
        registerListener(this.jFn);
        registerListener(this.jjr);
        registerListener(this.jjV);
        this.jFi = new FrsLoadMoreModel(this, null);
        this.jFi.registerListener();
        this.jFi.setPageType(2);
        this.jFi.rs(true);
        this.jFi.setFunAdController(com.baidu.tieba.funad.a.rM(this.jrh));
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dWJ = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jFj = new a(this, inflate, this.jFg);
        this.jFj.cJk().cJr();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.iEX) {
            if (j.isNetWorkAvailable()) {
                rq(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new ar("c13008").dR("fid", this.mForumId).dR("obj_type", "7").aq("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.jie = getVoiceManager();
        this.jie.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cJd();
        if (bundle != null) {
            this.jhW = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.jhW = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cJd() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fuv);
    }

    public FrsLoadMoreModel cJe() {
        return this.jFi;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.jFj != null) {
            this.jFj.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jlI);
        com.baidu.tieba.s.c.dMH().C(getUniqueId());
        t.csH().pB(false);
        super.onDestroy();
        this.jFh.cJm();
        this.jie = getVoiceManager();
        this.jie.onDestory(getPageContext());
        e.mA().removeCallbacks(this.jFm);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jhW);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.jFg);
        this.jFh.onSaveInstanceState(bundle);
        this.jie = getVoiceManager();
        if (this.jie != null) {
            this.jie.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        cb threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jFj.cJk().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.jhD.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.no(intent.getIntExtra("good_data", 0));
                            threadDataById.boR();
                            rq(false);
                            return;
                        } else if (intExtra == 0) {
                            this.jhD.removeThreadData(threadDataById);
                            ArrayList<n> threadList = this.jhD.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jFj.cJi();
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
            if (this.jrf == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.iEX) {
                e.mA().post(this.jFm);
            }
        }
        cFl();
    }

    private void cFl() {
        if (isPrimary()) {
            if (this.jot != null && this.jot.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jlI);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jlI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jFj != null) {
            this.jFj.cDU();
        }
        this.jie = getVoiceManager();
        this.jie.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jFk = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.jFj.a(this.jjR);
        this.jFj.setOnScrollListener(this.mScrollListener);
        this.jFj.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.jFk != null) {
                    FrsGoodFragment.this.jFk.i(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jrf != 3 || this.jFj != null) {
            this.jrf = i;
            super.onChangeSkinType(i);
            if (this.jFj != null) {
                this.jFj.onChangeSkinType(i);
            }
            if (this.jot != null && this.jot.isViewAttached()) {
                this.jot.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBS() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cBS();
        }
        return null;
    }

    private void cDa() {
        switch (this.mFlag) {
            case 1:
                h.mB().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TN(FrsGoodFragment.this.jhW);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDb() {
        cDh();
        try {
            if (this.jhD != null) {
                this.jFj.cFv();
                this.jFj.bYu();
                this.jhW = this.jhD.getForum().getName();
                this.forumId = this.jhD.getForum().getId();
                if (this.jhD != null && this.jhD.getForum() != null) {
                    this.jFj.a(this.jhD.getForum().getThemeColorInfo());
                    this.jFj.c(this.jhD);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.jhD.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jhD.getUserData().getBimg_end_time());
                cDa();
                if (!this.jFj.cJk().r(cb.eSm)) {
                    this.jhD.removeAlaLiveThreadData();
                }
                ArrayList<n> threadList = this.jhD.getThreadList();
                if (threadList != null) {
                    this.jFj.a(threadList, this.mPn, this.jhD, this.jhD.getPage().bmH());
                    cJf();
                    this.jFj.cJi();
                    if (this.jhD.getIsNewUrl() == 1) {
                        this.jFj.cJk().setFromCDN(true);
                    } else {
                        this.jFj.cJk().setFromCDN(false);
                    }
                    this.jFj.setListViewSelection(cy(cJg().getType(), this.mPn));
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
        this.jie = getVoiceManager();
        this.jie.onPause(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        t.csH().pB(false);
        com.baidu.tieba.s.c.dMH().b(getUniqueId(), false);
        if (this.jhD != null && this.jhD.getForum() != null) {
            com.baidu.tbadk.distribute.a.bAX().b(getPageContext().getPageActivity(), "frs", this.jhD.getForum().getId(), 0L);
        }
        this.jie = getVoiceManager();
        if (this.jie != null) {
            this.jie.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zW(int i) {
        ArrayList<n> threadList = this.jhD.getThreadList();
        if (threadList != null) {
            Iterator<n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (next instanceof ca) {
                    cb cbVar = ((ca) next).eLr;
                    if (cbVar.getId() != null && cbVar.getId().equals(this.jFf)) {
                        c(cbVar, i);
                        this.jFf = null;
                        break;
                    }
                }
            }
            this.jFj.cJk().b(threadList, this.jhD);
            this.jFj.cJk().notifyDataSetChanged();
        }
    }

    private void c(cb cbVar, int i) {
        if (i == 1) {
            PraiseData bnD = cbVar.bnD();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bnD == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    cbVar.a(praiseData);
                    return;
                }
                cbVar.bnD().getUser().add(0, metaData);
                cbVar.bnD().setNum(cbVar.bnD().getNum() + 1);
                cbVar.bnD().setIsLike(i);
            }
        } else if (cbVar.bnD() != null) {
            cbVar.bnD().setIsLike(i);
            cbVar.bnD().setNum(cbVar.bnD().getNum() - 1);
            ArrayList<MetaData> user = cbVar.bnD().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        cbVar.bnD().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jie == null) {
            this.jie = VoiceManager.instance();
        }
        return this.jie;
    }

    public BdTypeRecyclerView getListView() {
        if (this.jFj == null) {
            return null;
        }
        return this.jFj.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cDh() {
        this.jie = getVoiceManager();
        this.jie.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buP() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).buP();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.jhD != null && this.jFj != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jFj.cDU();
            }
        }
    }

    private void cJf() {
        HashMap<Integer, cb> cGF;
        if (this.jFj != null && this.jFj.cJk() != null && (cGF = this.jFj.cJk().cGF()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, cb> entry : cGF.entrySet()) {
                cb value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bBd().G(arrayList);
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
        if (j.isNetWorkAvailable()) {
            rq(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cDm() {
        return this.jhD;
    }

    public FrsGoodModelController cJg() {
        return this.jFh;
    }

    public void Lf(String str) {
        this.jhW = str;
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
            this.jFj.bSE();
        } else if (!this.jFh.cJq()) {
            this.jFj.bSE();
        } else {
            bRE();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.jFi.isLoading && !this.jFh.isLoading()) {
                if (this.jFi.dA(this.jhD.getThreadListIds())) {
                    String y = com.baidu.tieba.recapp.a.y(this.jhD != null ? this.jhD.getThreadList() : null, false);
                    this.jFj.a(this.jFi.cJB(), this.mPn, this.jhD, 0);
                    this.jFi.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.jhD.getThreadListIds(), this.jhW, this.mPn, this.jhD.isBrandForum, y);
                } else if (this.hYW != 0) {
                    String y2 = com.baidu.tieba.recapp.a.y(this.jhD != null ? this.jhD.getThreadList() : null, false);
                    this.jFj.a(this.jFi.cJB(), this.mPn, this.jhD, 0);
                    this.mPn++;
                    this.jFh.bB(this.mPn, y2);
                    this.jFi.loadingDone = false;
                    this.jFi.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bRE();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void at(ArrayList<n> arrayList) {
        bRE();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<n> a2 = this.jFi.a(false, false, false, arrayList, null);
            if (a2 != null) {
                this.jhD.setThreadList(a2);
                this.jFj.a(a2, this.mPn, this.jhD, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jhD.getForum()));
        }
    }

    private void bRE() {
        if (this.hYW == 0 && !this.jFi.dA(this.jhD.getThreadListIds())) {
            if (this.jhD.getThreadList() == null || this.jhD.getThreadList().size() == 0) {
                this.jFj.bSE();
            } else {
                this.jFj.Xb();
            }
        } else if (y.getCount(this.jhD.getThreadList()) > 3) {
            this.jFj.Xa();
        } else {
            this.jFj.cEj();
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.l.a.a.InterfaceC0154a
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
        com.baidu.tbadk.distribute.a.bAX().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.q
    public void cDg() {
        if (this.jFh != null) {
            this.jFh.cDg();
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
    public NavigationBar bVq() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jhW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.jhD != null) {
            i = this.jhD.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.d.j.Aw(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zX(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            rq(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void cCm() {
        if (this.jFj != null && this.jFj.getListView() != null) {
            this.jFj.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSD() {
        if (this.jFj != null) {
            cCm();
            this.jFj.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jiE.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sO(int i) {
        return this.jiE.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bup() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bKY().EC("page_frs_good");
            rq(true);
            return;
        }
        this.jFj.lU(false);
    }

    @Override // com.baidu.tieba.frs.aq
    public void buq() {
        com.baidu.tieba.s.c.dMH().b(getUniqueId(), false);
    }

    public void a(aw awVar) {
        if (awVar != null && cDm() != null && cDm().getThreadList() != null) {
            if (y.isEmpty(cDm().getThreadList())) {
                cDm().getThreadList().add(awVar);
            } else {
                if (cDm().getThreadList().size() == 1 && (cDm().getThreadList().get(0) instanceof com.baidu.tieba.frs.s)) {
                    cDm().getThreadList().remove(0);
                }
                cDm().getThreadList().add(0, awVar);
            }
            this.jFj.a(this.jhD.getThreadList(), this.mPn, this.jhD, this.jhD.getPage().bmH());
            this.jFj.cJi();
            this.jFj.setListViewSelection(0);
        }
    }
}
