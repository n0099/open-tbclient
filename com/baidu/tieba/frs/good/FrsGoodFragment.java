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
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0148a, UserIconBox.a, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ao, ap, aq, com.baidu.tieba.frs.loadmore.a, q, FrsCommonImageLayout.c {
    private com.baidu.tieba.frs.gametab.b jDB;
    private String jDw;
    private FrsGoodModelController jDy;
    private FrsLoadMoreModel jDz;
    private VoiceManager jgu;
    private c jmK;
    private boolean jpy;
    private String mForumId;
    private String jgn = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean jDx = false;
    private String forumId = null;
    private FrsViewData jfU = new FrsViewData();
    public long iJe = -1;
    public long fJl = 0;
    public long fJu = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected a jDA = null;
    private int hXn = -1;
    private int mTabId = 0;
    private int jpw = 3;
    private boolean iDo = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jgU = new SparseArray<>();
    private boolean jDC = false;
    private int dVi = 0;
    private int jhs = 0;
    private CustomMessageListener jjZ = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.jmK != null && FrsGoodFragment.this.jmK.isViewAttached()) {
                FrsGoodFragment.this.jmK.rm(num.intValue());
            }
        }
    };
    private Runnable jDD = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.iDo) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.rq(false);
            }
        }
    };
    private CustomMessageListener jDE = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof cb)) {
                cb cbVar = (cb) customResponsedMessage.getData();
                FrsGoodFragment.this.jDw = cbVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.jDw) && cbVar.bnB() != null) {
                    FrsGoodFragment.this.zV(cbVar.bnB().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener jhH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.getListView() != null) {
                        FrsGoodFragment.this.getListView().setSelection(0);
                    }
                    if (FrsGoodFragment.this.jmK != null && FrsGoodFragment.this.jmK.isViewAttached()) {
                        FrsGoodFragment.this.rq(false);
                    } else if (FrsGoodFragment.this.jDA != null) {
                        FrsGoodFragment.this.jDA.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s jia = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long jDH = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void yA(int i) {
            if (!FrsGoodFragment.this.jDC) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.jDA.cDO();
                        return;
                    case 3:
                        FrsGoodFragment.this.jDA.lU(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, f fVar) {
            ArrayList<n> a2;
            if (FrsGoodFragment.this.jDC) {
                if (FrsGoodFragment.this.cJa().cJi() == null) {
                    FrsGoodFragment.this.jDC = false;
                    return;
                } else if (FrsGoodFragment.this.cJa().cJi().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.jDC = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jDH = 1L;
            } else if (fVar.isSuccess) {
                this.jDH = 0L;
            } else {
                this.jDH = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.jDz.resetData();
            }
            FrsGoodFragment.this.jDA.lU(false);
            if (FrsGoodFragment.this.cJa().cJi() != null) {
                FrsGoodFragment.this.jfU = FrsGoodFragment.this.cJa().cJi();
            }
            FrsGoodFragment.this.hXn = FrsGoodFragment.this.jfU.getPage().bmF();
            if (FrsGoodFragment.this.hXn != 0 || (FrsGoodFragment.this.jfU.getThreadListIds() != null && FrsGoodFragment.this.jfU.getThreadListIds().size() != 0)) {
                if (y.getCount(FrsGoodFragment.this.jfU.getThreadList()) > 3) {
                    FrsGoodFragment.this.jDA.WX();
                } else {
                    FrsGoodFragment.this.jDA.cEd();
                }
            } else if (FrsGoodFragment.this.jfU.getThreadList() == null || FrsGoodFragment.this.jfU.getThreadList().size() == 0) {
                FrsGoodFragment.this.jDA.bSy();
            } else {
                FrsGoodFragment.this.jDA.WY();
            }
            if (i == 4) {
                ArrayList<n> a3 = FrsGoodFragment.this.jDz.a(false, false, false, FrsGoodFragment.this.jfU.getThreadList(), null);
                if (a3 != null) {
                    FrsGoodFragment.this.jfU.setThreadList(a3);
                    FrsGoodFragment.this.jDA.a(a3, FrsGoodFragment.this.mPn, FrsGoodFragment.this.jfU, FrsGoodFragment.this.hXn);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.jDA.cDO();
                    break;
                case 2:
                    FrsGoodFragment.this.jDA.cDO();
                    break;
                case 3:
                    if (FrsGoodFragment.this.jfU.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.jDH != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.jfU != null) {
                    FrsGoodFragment.this.jgn = FrsGoodFragment.this.jfU.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.jfU.getForum().getId();
                    FrsGoodFragment.this.jDA.b(FrsGoodFragment.this.jfU.getForum(), FrsGoodFragment.this.jfU.getUserData());
                }
                if (FrsGoodFragment.this.jfU != null) {
                    FrsGoodFragment.this.jfU.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.jDA.c(FrsGoodFragment.this.jfU);
                if (FrsGoodFragment.this.jfU == null || FrsGoodFragment.this.jfU.getThreadList() == null || FrsGoodFragment.this.jfU.getThreadList().size() != 0 || FrsGoodFragment.this.cJa().getType() != 4) {
                    if (FrsGoodFragment.this.jfU != null && (a2 = FrsGoodFragment.this.jDz.a(false, false, true, FrsGoodFragment.this.jfU.getThreadList(), null)) != null && a2.size() > 0) {
                        FrsGoodFragment.this.jfU.setThreadList(a2);
                    }
                    FrsGoodFragment.this.cCV();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.iJe > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.iJe, FrsGoodFragment.this.cJa().cwK() - FrsGoodFragment.this.iJe, FrsGoodFragment.this.cJa().cwI(), FrsGoodFragment.this.cJa().cwJ(), currentTimeMillis2 - FrsGoodFragment.this.cJa().cwH());
                        FrsGoodFragment.this.iJe = -1L;
                    }
                    FrsGoodFragment.this.fJu = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.iJe > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.iJe, FrsGoodFragment.this.cJa().cwK() - FrsGoodFragment.this.iJe, FrsGoodFragment.this.cJa().cwI(), FrsGoodFragment.this.cJa().cwJ(), currentTimeMillis3 - FrsGoodFragment.this.cJa().cwH());
                FrsGoodFragment.this.iJe = -1L;
            }
            FrsGoodFragment.this.fJu = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCP() {
        }
    };
    private final CustomMessageListener eJz = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.jDA != null) {
                FrsGoodFragment.this.jDA.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                t.csB().pB(true);
                com.baidu.tieba.s.c.dMz().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.jhs += i2;
            if (FrsGoodFragment.this.jhs >= FrsGoodFragment.this.dVi * 2 && i2 < 0) {
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
    private w jii = new w() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && nVar != null && (nVar instanceof ca)) {
                cb cbVar = ((ca) nVar).eJQ;
                if (cbVar.boR() == null || cbVar.boR().getGroup_id() == 0 || bh.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (cbVar.boC() != 1 || bh.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.TM(cbVar.getId())) {
                            readThreadHistory.TL(cbVar.getId());
                            if (FrsGoodFragment.this.jDA != null) {
                                FrsGoodFragment.this.jDA.cDO();
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
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(cbVar, FrsGoodFragment.this.jgn, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(cbVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.jfU != null && FrsGoodFragment.this.jfU.getForum() != null) {
                            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
                            bVar.jHy = FrsGoodFragment.this.jfU.needLog == 1;
                            bVar.jHA = FrsGoodFragment.this.jfU.getForum().getId();
                            if (com.baidu.tieba.frs.b.d.jqE != null) {
                                bVar.jHB = com.baidu.tieba.frs.b.d.jqE.jHB;
                                bVar.jHC = com.baidu.tieba.frs.b.d.jqE.jHC;
                            }
                            com.baidu.tieba.frs.b.a.a(cbVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jim = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.jDA != null) {
                FrsGoodFragment.this.jDA.EK();
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

    public void cFO() {
        if (this.jDA != null) {
            this.jDA.refreshView();
        }
    }

    private void showLoadingView() {
        this.jDA.qV(false);
        showLoadingView(this.jDA.cnu(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jDA.qV(true);
        hideLoadingView(this.jDA.cnu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.jDA.qV(false);
        this.jDA.qU(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jDA.bSy();
        this.jDA.getListView().getData().clear();
        this.jDA.cDO();
        if (this.jmK == null) {
            this.jmK = new c(getPageContext().getContext(), getNetRefreshListener());
            this.jmK.setTitle(null);
            this.jmK.setButtonText(null);
            this.jmK.showRefreshButton();
            this.jmK.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.jmK.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.jmK.setSubText(null);
        }
        this.jmK.onChangeSkinType();
        this.jmK.attachView(this.jDA.cnu(), true);
        registerListener(this.jjZ);
    }

    private void WZ() {
        this.jDA.qV(true);
        this.jDA.qU(true);
        if (this.jmK != null && this.jmK.isViewAttached()) {
            this.jmK.dettachView(this.jDA.cnu());
        }
        MessageManager.getInstance().unRegisterListener(this.jjZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(boolean z) {
        this.iDo = true;
        cDb();
        WZ();
        if (!z) {
            WZ();
            showLoadingView();
        }
        this.jDy.loadData(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iJe = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.iJe = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
            this.jpy = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
        }
        this.beginTime = System.currentTimeMillis();
        this.fJl = this.beginTime - this.iJe;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMz().A(getUniqueId());
        this.jDy = new FrsGoodModelController(this);
        if (arguments != null) {
            this.jDy.aj(arguments);
            this.jDx = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.jDy.aj(bundle);
            this.jDx = bundle.getBoolean("is_game_frs", false);
        } else {
            this.jDy.aj(null);
        }
        this.jgu = getVoiceManager();
        this.jgu.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eJz);
        registerListener(this.jDE);
        registerListener(this.jhH);
        registerListener(this.jim);
        this.jDz = new FrsLoadMoreModel(this, null);
        this.jDz.registerListener();
        this.jDz.setPageType(2);
        this.jDz.rs(true);
        this.jDz.setFunAdController(com.baidu.tieba.funad.a.rM(this.jpy));
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dVi = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jDA = new a(this, inflate, this.jDx);
        this.jDA.cJe().cJl();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.iDo) {
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
        this.jgu = getVoiceManager();
        this.jgu.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cIX();
        if (bundle != null) {
            this.jgn = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.jgn = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cIX() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fsV);
    }

    public FrsLoadMoreModel cIY() {
        return this.jDz;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.jDA != null) {
            this.jDA.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jjZ);
        com.baidu.tieba.s.c.dMz().B(getUniqueId());
        t.csB().pB(false);
        super.onDestroy();
        this.jDy.cJg();
        this.jgu = getVoiceManager();
        this.jgu.onDestory(getPageContext());
        e.mA().removeCallbacks(this.jDD);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jgn);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.jDx);
        this.jDy.onSaveInstanceState(bundle);
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        cb threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jDA.cJe().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.jfU.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.nn(intent.getIntExtra("good_data", 0));
                            threadDataById.boP();
                            rq(false);
                            return;
                        } else if (intExtra == 0) {
                            this.jfU.removeThreadData(threadDataById);
                            ArrayList<n> threadList = this.jfU.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jDA.cJc();
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
            if (this.jpw == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.iDo) {
                e.mA().post(this.jDD);
            }
        }
        cFf();
    }

    private void cFf() {
        if (isPrimary()) {
            if (this.jmK != null && this.jmK.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jjZ);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jjZ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jDA != null) {
            this.jDA.cDO();
        }
        this.jgu = getVoiceManager();
        this.jgu.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jDB = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.jDA.a(this.jii);
        this.jDA.setOnScrollListener(this.mScrollListener);
        this.jDA.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.jDB != null) {
                    FrsGoodFragment.this.jDB.i(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jpw != 3 || this.jDA != null) {
            this.jpw = i;
            super.onChangeSkinType(i);
            if (this.jDA != null) {
                this.jDA.onChangeSkinType(i);
            }
            if (this.jmK != null && this.jmK.isViewAttached()) {
                this.jmK.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBM() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cBM();
        }
        return null;
    }

    private void cCU() {
        switch (this.mFlag) {
            case 1:
                h.mB().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TG(FrsGoodFragment.this.jgn);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCV() {
        cDb();
        try {
            if (this.jfU != null) {
                this.jDA.cFp();
                this.jDA.bYo();
                this.jgn = this.jfU.getForum().getName();
                this.forumId = this.jfU.getForum().getId();
                if (this.jfU != null && this.jfU.getForum() != null) {
                    this.jDA.a(this.jfU.getForum().getThemeColorInfo());
                    this.jDA.c(this.jfU);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.jfU.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jfU.getUserData().getBimg_end_time());
                cCU();
                if (!this.jDA.cJe().r(cb.eQL)) {
                    this.jfU.removeAlaLiveThreadData();
                }
                ArrayList<n> threadList = this.jfU.getThreadList();
                if (threadList != null) {
                    this.jDA.a(threadList, this.mPn, this.jfU, this.jfU.getPage().bmF());
                    cIZ();
                    this.jDA.cJc();
                    if (this.jfU.getIsNewUrl() == 1) {
                        this.jDA.cJe().setFromCDN(true);
                    } else {
                        this.jDA.cJe().setFromCDN(false);
                    }
                    this.jDA.setListViewSelection(cy(cJa().getType(), this.mPn));
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
        this.jgu = getVoiceManager();
        this.jgu.onPause(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        t.csB().pB(false);
        com.baidu.tieba.s.c.dMz().b(getUniqueId(), false);
        if (this.jfU != null && this.jfU.getForum() != null) {
            com.baidu.tbadk.distribute.a.bAU().b(getPageContext().getPageActivity(), "frs", this.jfU.getForum().getId(), 0L);
        }
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(int i) {
        ArrayList<n> threadList = this.jfU.getThreadList();
        if (threadList != null) {
            Iterator<n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (next instanceof ca) {
                    cb cbVar = ((ca) next).eJQ;
                    if (cbVar.getId() != null && cbVar.getId().equals(this.jDw)) {
                        c(cbVar, i);
                        this.jDw = null;
                        break;
                    }
                }
            }
            this.jDA.cJe().b(threadList, this.jfU);
            this.jDA.cJe().notifyDataSetChanged();
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
        if (this.jgu == null) {
            this.jgu = VoiceManager.instance();
        }
        return this.jgu;
    }

    public BdTypeRecyclerView getListView() {
        if (this.jDA == null) {
            return null;
        }
        return this.jDA.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cDb() {
        this.jgu = getVoiceManager();
        this.jgu.stopPlay();
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
        if (this.jfU != null && this.jDA != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jDA.cDO();
            }
        }
    }

    private void cIZ() {
        HashMap<Integer, cb> cGz;
        if (this.jDA != null && this.jDA.cJe() != null && (cGz = this.jDA.cJe().cGz()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, cb> entry : cGz.entrySet()) {
                cb value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bBa().G(arrayList);
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
    public FrsViewData cDg() {
        return this.jfU;
    }

    public FrsGoodModelController cJa() {
        return this.jDy;
    }

    public void KW(String str) {
        this.jgn = str;
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
            this.jDA.bSy();
        } else if (!this.jDy.cJk()) {
            this.jDA.bSy();
        } else {
            bRy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.jDz.isLoading && !this.jDy.isLoading()) {
                if (this.jDz.dA(this.jfU.getThreadListIds())) {
                    String y = com.baidu.tieba.recapp.a.y(this.jfU != null ? this.jfU.getThreadList() : null, false);
                    this.jDA.a(this.jDz.cJv(), this.mPn, this.jfU, 0);
                    this.jDz.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.jfU.getThreadListIds(), this.jgn, this.mPn, this.jfU.isBrandForum, y);
                } else if (this.hXn != 0) {
                    String y2 = com.baidu.tieba.recapp.a.y(this.jfU != null ? this.jfU.getThreadList() : null, false);
                    this.jDA.a(this.jDz.cJv(), this.mPn, this.jfU, 0);
                    this.mPn++;
                    this.jDy.bB(this.mPn, y2);
                    this.jDz.loadingDone = false;
                    this.jDz.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bRy();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void at(ArrayList<n> arrayList) {
        bRy();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<n> a2 = this.jDz.a(false, false, false, arrayList, null);
            if (a2 != null) {
                this.jfU.setThreadList(a2);
                this.jDA.a(a2, this.mPn, this.jfU, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jfU.getForum()));
        }
    }

    private void bRy() {
        if (this.hXn == 0 && !this.jDz.dA(this.jfU.getThreadListIds())) {
            if (this.jfU.getThreadList() == null || this.jfU.getThreadList().size() == 0) {
                this.jDA.bSy();
            } else {
                this.jDA.WY();
            }
        } else if (y.getCount(this.jfU.getThreadList()) > 3) {
            this.jDA.WX();
        } else {
            this.jDA.cEd();
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

    @Override // com.baidu.tieba.recapp.q
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.q
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bAU().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.q
    public void cDa() {
        if (this.jDy != null) {
            this.jDy.cDa();
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
    public NavigationBar bVk() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jgn;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.jfU != null) {
            i = this.jfU.getSortType();
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
    public void cCg() {
        if (this.jDA != null && this.jDA.getListView() != null) {
            this.jDA.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSx() {
        if (this.jDA != null) {
            cCg();
            this.jDA.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jgU.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sM(int i) {
        return this.jgU.get(i);
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
            com.baidu.tieba.a.d.bKU().Ev("page_frs_good");
            rq(true);
            return;
        }
        this.jDA.lU(false);
    }

    @Override // com.baidu.tieba.frs.aq
    public void bun() {
        com.baidu.tieba.s.c.dMz().b(getUniqueId(), false);
    }

    public void a(aw awVar) {
        if (awVar != null && cDg() != null && cDg().getThreadList() != null) {
            if (y.isEmpty(cDg().getThreadList())) {
                cDg().getThreadList().add(awVar);
            } else {
                if (cDg().getThreadList().size() == 1 && (cDg().getThreadList().get(0) instanceof com.baidu.tieba.frs.s)) {
                    cDg().getThreadList().remove(0);
                }
                cDg().getThreadList().add(0, awVar);
            }
            this.jDA.a(this.jfU.getThreadList(), this.mPn, this.jfU, this.jfU.getPage().bmF());
            this.jDA.cJc();
            this.jDA.setListViewSelection(0);
        }
    }
}
