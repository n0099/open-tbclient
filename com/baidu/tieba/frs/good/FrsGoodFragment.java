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
import com.baidu.adp.widget.ListView.q;
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
import com.baidu.tieba.recapp.p;
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
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0148a, UserIconBox.a, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ao, ap, aq, com.baidu.tieba.frs.loadmore.a, p, FrsCommonImageLayout.c {
    private String jDi;
    private FrsGoodModelController jDk;
    private FrsLoadMoreModel jDl;
    private com.baidu.tieba.frs.gametab.b jDn;
    private VoiceManager jgg;
    private c jmw;
    private boolean jpk;
    private String mForumId;
    private String jfZ = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean jDj = false;
    private String forumId = null;
    private FrsViewData jfG = new FrsViewData();
    public long iIQ = -1;
    public long fJl = 0;
    public long fJu = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected a jDm = null;
    private int hWZ = -1;
    private int mTabId = 0;
    private int jpi = 3;
    private boolean iDa = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jgG = new SparseArray<>();
    private boolean jDo = false;
    private int dVi = 0;
    private int jhe = 0;
    private CustomMessageListener jjL = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.jmw != null && FrsGoodFragment.this.jmw.isViewAttached()) {
                FrsGoodFragment.this.jmw.rm(num.intValue());
            }
        }
    };
    private Runnable jDp = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.iDa) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.rq(false);
            }
        }
    };
    private CustomMessageListener jDq = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof cb)) {
                cb cbVar = (cb) customResponsedMessage.getData();
                FrsGoodFragment.this.jDi = cbVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.jDi) && cbVar.bnB() != null) {
                    FrsGoodFragment.this.zV(cbVar.bnB().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener jht = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.getListView() != null) {
                        FrsGoodFragment.this.getListView().setSelection(0);
                    }
                    if (FrsGoodFragment.this.jmw != null && FrsGoodFragment.this.jmw.isViewAttached()) {
                        FrsGoodFragment.this.rq(false);
                    } else if (FrsGoodFragment.this.jDm != null) {
                        FrsGoodFragment.this.jDm.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s jhM = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long jDt = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void yA(int i) {
            if (!FrsGoodFragment.this.jDo) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.jDm.cDH();
                        return;
                    case 3:
                        FrsGoodFragment.this.jDm.lU(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, f fVar) {
            ArrayList<n> a2;
            if (FrsGoodFragment.this.jDo) {
                if (FrsGoodFragment.this.cIT().cJb() == null) {
                    FrsGoodFragment.this.jDo = false;
                    return;
                } else if (FrsGoodFragment.this.cIT().cJb().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.jDo = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jDt = 1L;
            } else if (fVar.isSuccess) {
                this.jDt = 0L;
            } else {
                this.jDt = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.jDl.resetData();
            }
            FrsGoodFragment.this.jDm.lU(false);
            if (FrsGoodFragment.this.cIT().cJb() != null) {
                FrsGoodFragment.this.jfG = FrsGoodFragment.this.cIT().cJb();
            }
            FrsGoodFragment.this.hWZ = FrsGoodFragment.this.jfG.getPage().bmF();
            if (FrsGoodFragment.this.hWZ != 0 || (FrsGoodFragment.this.jfG.getThreadListIds() != null && FrsGoodFragment.this.jfG.getThreadListIds().size() != 0)) {
                if (y.getCount(FrsGoodFragment.this.jfG.getThreadList()) > 3) {
                    FrsGoodFragment.this.jDm.WX();
                } else {
                    FrsGoodFragment.this.jDm.cDW();
                }
            } else if (FrsGoodFragment.this.jfG.getThreadList() == null || FrsGoodFragment.this.jfG.getThreadList().size() == 0) {
                FrsGoodFragment.this.jDm.bSr();
            } else {
                FrsGoodFragment.this.jDm.WY();
            }
            if (i == 4) {
                ArrayList<n> a3 = FrsGoodFragment.this.jDl.a(false, false, false, FrsGoodFragment.this.jfG.getThreadList(), null);
                if (a3 != null) {
                    FrsGoodFragment.this.jfG.setThreadList(a3);
                    FrsGoodFragment.this.jDm.a(a3, FrsGoodFragment.this.mPn, FrsGoodFragment.this.jfG, FrsGoodFragment.this.hWZ);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.jDm.cDH();
                    break;
                case 2:
                    FrsGoodFragment.this.jDm.cDH();
                    break;
                case 3:
                    if (FrsGoodFragment.this.jfG.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.jDt != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.jfG != null) {
                    FrsGoodFragment.this.jfZ = FrsGoodFragment.this.jfG.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.jfG.getForum().getId();
                    FrsGoodFragment.this.jDm.b(FrsGoodFragment.this.jfG.getForum(), FrsGoodFragment.this.jfG.getUserData());
                }
                if (FrsGoodFragment.this.jfG != null) {
                    FrsGoodFragment.this.jfG.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.jDm.c(FrsGoodFragment.this.jfG);
                if (FrsGoodFragment.this.jfG == null || FrsGoodFragment.this.jfG.getThreadList() == null || FrsGoodFragment.this.jfG.getThreadList().size() != 0 || FrsGoodFragment.this.cIT().getType() != 4) {
                    if (FrsGoodFragment.this.jfG != null && (a2 = FrsGoodFragment.this.jDl.a(false, false, true, FrsGoodFragment.this.jfG.getThreadList(), null)) != null && a2.size() > 0) {
                        FrsGoodFragment.this.jfG.setThreadList(a2);
                    }
                    FrsGoodFragment.this.cCO();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.iIQ > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.iIQ, FrsGoodFragment.this.cIT().cwD() - FrsGoodFragment.this.iIQ, FrsGoodFragment.this.cIT().cwB(), FrsGoodFragment.this.cIT().cwC(), currentTimeMillis2 - FrsGoodFragment.this.cIT().cwA());
                        FrsGoodFragment.this.iIQ = -1L;
                    }
                    FrsGoodFragment.this.fJu = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.iIQ > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.iIQ, FrsGoodFragment.this.cIT().cwD() - FrsGoodFragment.this.iIQ, FrsGoodFragment.this.cIT().cwB(), FrsGoodFragment.this.cIT().cwC(), currentTimeMillis3 - FrsGoodFragment.this.cIT().cwA());
                FrsGoodFragment.this.iIQ = -1L;
            }
            FrsGoodFragment.this.fJu = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCI() {
        }
    };
    private final CustomMessageListener eJz = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.jDm != null) {
                FrsGoodFragment.this.jDm.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                t.csu().pB(true);
                com.baidu.tieba.s.c.dMr().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.jhe += i2;
            if (FrsGoodFragment.this.jhe >= FrsGoodFragment.this.dVi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener fsV = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private w jhT = new w() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && nVar != null && (nVar instanceof ca)) {
                cb cbVar = ((ca) nVar).eJQ;
                if (cbVar.boR() == null || cbVar.boR().getGroup_id() == 0 || bh.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (cbVar.boC() != 1 || bh.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.TA(cbVar.getId())) {
                            readThreadHistory.Tz(cbVar.getId());
                            if (FrsGoodFragment.this.jDm != null) {
                                FrsGoodFragment.this.jDm.cDH();
                            }
                        }
                        boolean z = false;
                        final String bnW = cbVar.bnW();
                        if (bnW != null && !bnW.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(bnW);
                                    aaVar.bsr().bta().mIsNeedAddCommenParam = false;
                                    aaVar.bsr().bta().mIsUseCurrentBDUSS = false;
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
                        if (cbVar.bnL() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            bf.bsV().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3 && str.length() > 3) {
                            cbVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(cbVar, FrsGoodFragment.this.jfZ, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(cbVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.jfG != null && FrsGoodFragment.this.jfG.getForum() != null) {
                            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
                            bVar.jHk = FrsGoodFragment.this.jfG.needLog == 1;
                            bVar.jHm = FrsGoodFragment.this.jfG.getForum().getId();
                            if (com.baidu.tieba.frs.b.d.jqq != null) {
                                bVar.jHn = com.baidu.tieba.frs.b.d.jqq.jHn;
                                bVar.jHo = com.baidu.tieba.frs.b.d.jqq.jHo;
                            }
                            com.baidu.tieba.frs.b.a.a(cbVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jhX = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.jDm != null) {
                FrsGoodFragment.this.jDm.EK();
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

    public void cFH() {
        if (this.jDm != null) {
            this.jDm.refreshView();
        }
    }

    private void showLoadingView() {
        this.jDm.qV(false);
        showLoadingView(this.jDm.cnn(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jDm.qV(true);
        hideLoadingView(this.jDm.cnn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.jDm.qV(false);
        this.jDm.qU(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jDm.bSr();
        this.jDm.getListView().getData().clear();
        this.jDm.cDH();
        if (this.jmw == null) {
            this.jmw = new c(getPageContext().getContext(), getNetRefreshListener());
            this.jmw.setTitle(null);
            this.jmw.setButtonText(null);
            this.jmw.showRefreshButton();
            this.jmw.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.jmw.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.jmw.setSubText(null);
        }
        this.jmw.onChangeSkinType();
        this.jmw.attachView(this.jDm.cnn(), true);
        registerListener(this.jjL);
    }

    private void WZ() {
        this.jDm.qV(true);
        this.jDm.qU(true);
        if (this.jmw != null && this.jmw.isViewAttached()) {
            this.jmw.dettachView(this.jDm.cnn());
        }
        MessageManager.getInstance().unRegisterListener(this.jjL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(boolean z) {
        this.iDa = true;
        cCU();
        WZ();
        if (!z) {
            WZ();
            showLoadingView();
        }
        this.jDk.loadData(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iIQ = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.iIQ = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
            this.jpk = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
        }
        this.beginTime = System.currentTimeMillis();
        this.fJl = this.beginTime - this.iIQ;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMr().A(getUniqueId());
        this.jDk = new FrsGoodModelController(this);
        if (arguments != null) {
            this.jDk.aj(arguments);
            this.jDj = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.jDk.aj(bundle);
            this.jDj = bundle.getBoolean("is_game_frs", false);
        } else {
            this.jDk.aj(null);
        }
        this.jgg = getVoiceManager();
        this.jgg.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eJz);
        registerListener(this.jDq);
        registerListener(this.jht);
        registerListener(this.jhX);
        this.jDl = new FrsLoadMoreModel(this, null);
        this.jDl.registerListener();
        this.jDl.setPageType(2);
        this.jDl.rs(true);
        this.jDl.setFunAdController(com.baidu.tieba.funad.a.rM(this.jpk));
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dVi = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jDm = new a(this, inflate, this.jDj);
        this.jDm.cIX().cJe();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.iDa) {
            if (j.isNetWorkAvailable()) {
                rq(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new ar("c13008").dR("fid", this.mForumId).dR("obj_type", "7").ap("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.jgg = getVoiceManager();
        this.jgg.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cIQ();
        if (bundle != null) {
            this.jfZ = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.jfZ = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cIQ() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fsV);
    }

    public FrsLoadMoreModel cIR() {
        return this.jDl;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.jDm != null) {
            this.jDm.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jjL);
        com.baidu.tieba.s.c.dMr().B(getUniqueId());
        t.csu().pB(false);
        super.onDestroy();
        this.jDk.cIZ();
        this.jgg = getVoiceManager();
        this.jgg.onDestory(getPageContext());
        e.mA().removeCallbacks(this.jDp);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jfZ);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.jDj);
        this.jDk.onSaveInstanceState(bundle);
        this.jgg = getVoiceManager();
        if (this.jgg != null) {
            this.jgg.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        cb threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jDm.cIX().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.jfG.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.nn(intent.getIntExtra("good_data", 0));
                            threadDataById.boP();
                            rq(false);
                            return;
                        } else if (intExtra == 0) {
                            this.jfG.removeThreadData(threadDataById);
                            ArrayList<n> threadList = this.jfG.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jDm.cIV();
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
            if (this.jpi == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.iDa) {
                e.mA().post(this.jDp);
            }
        }
        cEY();
    }

    private void cEY() {
        if (isPrimary()) {
            if (this.jmw != null && this.jmw.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jjL);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jjL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jDm != null) {
            this.jDm.cDH();
        }
        this.jgg = getVoiceManager();
        this.jgg.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jDn = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.jDm.a(this.jhT);
        this.jDm.setOnScrollListener(this.mScrollListener);
        this.jDm.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.jDn != null) {
                    FrsGoodFragment.this.jDn.i(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jpi != 3 || this.jDm != null) {
            this.jpi = i;
            super.onChangeSkinType(i);
            if (this.jDm != null) {
                this.jDm.onChangeSkinType(i);
            }
            if (this.jmw != null && this.jmw.isViewAttached()) {
                this.jmw.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBF() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cBF();
        }
        return null;
    }

    private void cCN() {
        switch (this.mFlag) {
            case 1:
                h.mB().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Tu(FrsGoodFragment.this.jfZ);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCO() {
        cCU();
        try {
            if (this.jfG != null) {
                this.jDm.cFi();
                this.jDm.bYh();
                this.jfZ = this.jfG.getForum().getName();
                this.forumId = this.jfG.getForum().getId();
                if (this.jfG != null && this.jfG.getForum() != null) {
                    this.jDm.a(this.jfG.getForum().getThemeColorInfo());
                    this.jDm.c(this.jfG);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.jfG.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jfG.getUserData().getBimg_end_time());
                cCN();
                if (!this.jDm.cIX().r(cb.eQL)) {
                    this.jfG.removeAlaLiveThreadData();
                }
                ArrayList<n> threadList = this.jfG.getThreadList();
                if (threadList != null) {
                    this.jDm.a(threadList, this.mPn, this.jfG, this.jfG.getPage().bmF());
                    cIS();
                    this.jDm.cIV();
                    if (this.jfG.getIsNewUrl() == 1) {
                        this.jDm.cIX().setFromCDN(true);
                    } else {
                        this.jDm.cIX().setFromCDN(false);
                    }
                    this.jDm.setListViewSelection(cx(cIT().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cx(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.jgg = getVoiceManager();
        this.jgg.onPause(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        t.csu().pB(false);
        com.baidu.tieba.s.c.dMr().b(getUniqueId(), false);
        if (this.jfG != null && this.jfG.getForum() != null) {
            com.baidu.tbadk.distribute.a.bAU().b(getPageContext().getPageActivity(), "frs", this.jfG.getForum().getId(), 0L);
        }
        this.jgg = getVoiceManager();
        if (this.jgg != null) {
            this.jgg.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(int i) {
        ArrayList<n> threadList = this.jfG.getThreadList();
        if (threadList != null) {
            Iterator<n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (next instanceof ca) {
                    cb cbVar = ((ca) next).eJQ;
                    if (cbVar.getId() != null && cbVar.getId().equals(this.jDi)) {
                        c(cbVar, i);
                        this.jDi = null;
                        break;
                    }
                }
            }
            this.jDm.cIX().b(threadList, this.jfG);
            this.jDm.cIX().notifyDataSetChanged();
        }
    }

    private void c(cb cbVar, int i) {
        if (i == 1) {
            PraiseData bnB = cbVar.bnB();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bnB == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    cbVar.a(praiseData);
                    return;
                }
                cbVar.bnB().getUser().add(0, metaData);
                cbVar.bnB().setNum(cbVar.bnB().getNum() + 1);
                cbVar.bnB().setIsLike(i);
            }
        } else if (cbVar.bnB() != null) {
            cbVar.bnB().setIsLike(i);
            cbVar.bnB().setNum(cbVar.bnB().getNum() - 1);
            ArrayList<MetaData> user = cbVar.bnB().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        cbVar.bnB().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jgg == null) {
            this.jgg = VoiceManager.instance();
        }
        return this.jgg;
    }

    public BdTypeRecyclerView getListView() {
        if (this.jDm == null) {
            return null;
        }
        return this.jDm.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cCU() {
        this.jgg = getVoiceManager();
        this.jgg.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buM() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).buM();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.jfG != null && this.jDm != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jDm.cDH();
            }
        }
    }

    private void cIS() {
        HashMap<Integer, cb> cGs;
        if (this.jDm != null && this.jDm.cIX() != null && (cGs = this.jDm.cIX().cGs()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, cb> entry : cGs.entrySet()) {
                cb value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bBa().G(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
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
    public FrsViewData cCZ() {
        return this.jfG;
    }

    public FrsGoodModelController cIT() {
        return this.jDk;
    }

    public void KV(String str) {
        this.jfZ = str;
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
            this.jDm.bSr();
        } else if (!this.jDk.cJd()) {
            this.jDm.bSr();
        } else {
            bRr();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.jDl.isLoading && !this.jDk.isLoading()) {
                if (this.jDl.dA(this.jfG.getThreadListIds())) {
                    String y = com.baidu.tieba.recapp.a.y(this.jfG != null ? this.jfG.getThreadList() : null, false);
                    this.jDm.a(this.jDl.cJo(), this.mPn, this.jfG, 0);
                    this.jDl.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.jfG.getThreadListIds(), this.jfZ, this.mPn, this.jfG.isBrandForum, y);
                } else if (this.hWZ != 0) {
                    String y2 = com.baidu.tieba.recapp.a.y(this.jfG != null ? this.jfG.getThreadList() : null, false);
                    this.jDm.a(this.jDl.cJo(), this.mPn, this.jfG, 0);
                    this.mPn++;
                    this.jDk.bB(this.mPn, y2);
                    this.jDl.loadingDone = false;
                    this.jDl.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bRr();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void at(ArrayList<n> arrayList) {
        bRr();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<n> a2 = this.jDl.a(false, false, false, arrayList, null);
            if (a2 != null) {
                this.jfG.setThreadList(a2);
                this.jDm.a(a2, this.mPn, this.jfG, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jfG.getForum()));
        }
    }

    private void bRr() {
        if (this.hWZ == 0 && !this.jDl.dA(this.jfG.getThreadListIds())) {
            if (this.jfG.getThreadList() == null || this.jfG.getThreadList().size() == 0) {
                this.jDm.bSr();
            } else {
                this.jDm.WY();
            }
        } else if (y.getCount(this.jfG.getThreadList()) > 3) {
            this.jDm.WX();
        } else {
            this.jDm.cDW();
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.l.a.a.InterfaceC0148a
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

    @Override // com.baidu.tieba.recapp.p
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.p
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bAU().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.p
    public void cCT() {
        if (this.jDk != null) {
            this.jDk.cCT();
        }
    }

    @Override // com.baidu.tieba.recapp.p
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.p
    public int getPageNum() {
        return this.mPn;
    }

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bVd() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jfZ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.jfG != null) {
            i = this.jfG.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.d.j.Av(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zW(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            rq(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void cBZ() {
        if (this.jDm != null && this.jDm.getListView() != null) {
            this.jDm.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSq() {
        if (this.jDm != null) {
            cBZ();
            this.jDm.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jgG.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sM(int i) {
        return this.jgG.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bum() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bKP().Ex("page_frs_good");
            rq(true);
            return;
        }
        this.jDm.lU(false);
    }

    @Override // com.baidu.tieba.frs.aq
    public void bun() {
        com.baidu.tieba.s.c.dMr().b(getUniqueId(), false);
    }

    public void a(aw awVar) {
        if (awVar != null && cCZ() != null && cCZ().getThreadList() != null) {
            if (y.isEmpty(cCZ().getThreadList())) {
                cCZ().getThreadList().add(awVar);
            } else {
                if (cCZ().getThreadList().size() == 1 && (cCZ().getThreadList().get(0) instanceof com.baidu.tieba.frs.s)) {
                    cCZ().getThreadList().remove(0);
                }
                cCZ().getThreadList().add(0, awVar);
            }
            this.jDm.a(this.jfG.getThreadList(), this.mPn, this.jfG, this.jfG.getPage().bmF());
            this.jDm.cIV();
            this.jDm.setListViewSelection(0);
        }
    }
}
