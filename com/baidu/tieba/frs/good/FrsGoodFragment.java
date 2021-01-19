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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.l.c;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
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
    private VoiceManager jaA;
    private c jgO;
    private boolean jjD;
    private String jxC;
    private FrsGoodModelController jxE;
    private FrsLoadMoreModel jxF;
    private com.baidu.tieba.frs.gametab.b jxH;
    private String mForumId;
    private String jat = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean jxD = false;
    private String forumId = null;
    private FrsViewData jaa = new FrsViewData();
    public long iDg = -1;
    public long fHa = 0;
    public long fHj = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected a jxG = null;
    private int hSE = -1;
    private int mTabId = 0;
    private int jjB = 3;
    private boolean ixq = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jba = new SparseArray<>();
    private boolean jxI = false;
    private int dTc = 0;
    private int jby = 0;
    private CustomMessageListener jee = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.jgO != null && FrsGoodFragment.this.jgO.isViewAttached()) {
                FrsGoodFragment.this.jgO.rh(num.intValue());
            }
        }
    };
    private Runnable jxJ = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.ixq) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.rg(false);
            }
        }
    };
    private CustomMessageListener jxK = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bz)) {
                bz bzVar = (bz) customResponsedMessage.getData();
                FrsGoodFragment.this.jxC = bzVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.jxC) && bzVar.bni() != null) {
                    FrsGoodFragment.this.zL(bzVar.bni().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener jbN = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.getListView() != null) {
                        FrsGoodFragment.this.getListView().setSelection(0);
                    }
                    if (FrsGoodFragment.this.jgO != null && FrsGoodFragment.this.jgO.isViewAttached()) {
                        FrsGoodFragment.this.rg(false);
                    } else if (FrsGoodFragment.this.jxG != null) {
                        FrsGoodFragment.this.jxG.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s jcg = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long jxN = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void yq(int i) {
            if (!FrsGoodFragment.this.jxI) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.jxG.cCv();
                        return;
                    case 3:
                        FrsGoodFragment.this.jxG.lQ(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, f fVar) {
            ArrayList<n> a2;
            if (FrsGoodFragment.this.jxI) {
                if (FrsGoodFragment.this.cHG().cHO() == null) {
                    FrsGoodFragment.this.jxI = false;
                    return;
                } else if (FrsGoodFragment.this.cHG().cHO().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.jxI = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jxN = 1L;
            } else if (fVar.isSuccess) {
                this.jxN = 0L;
            } else {
                this.jxN = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.jxF.resetData();
            }
            FrsGoodFragment.this.jxG.lQ(false);
            if (FrsGoodFragment.this.cHG().cHO() != null) {
                FrsGoodFragment.this.jaa = FrsGoodFragment.this.cHG().cHO();
            }
            FrsGoodFragment.this.hSE = FrsGoodFragment.this.jaa.getPage().bmm();
            if (FrsGoodFragment.this.hSE != 0 || (FrsGoodFragment.this.jaa.getThreadListIds() != null && FrsGoodFragment.this.jaa.getThreadListIds().size() != 0)) {
                if (x.getCount(FrsGoodFragment.this.jaa.getThreadList()) > 3) {
                    FrsGoodFragment.this.jxG.Vo();
                } else {
                    FrsGoodFragment.this.jxG.cCK();
                }
            } else if (FrsGoodFragment.this.jaa.getThreadList() == null || FrsGoodFragment.this.jaa.getThreadList().size() == 0) {
                FrsGoodFragment.this.jxG.bRO();
            } else {
                FrsGoodFragment.this.jxG.Vp();
            }
            if (i == 4) {
                ArrayList<n> a3 = FrsGoodFragment.this.jxF.a(false, false, false, FrsGoodFragment.this.jaa.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsGoodFragment.this.jaa.setThreadList(a3);
                    FrsGoodFragment.this.jxG.a(a3, FrsGoodFragment.this.mPn, FrsGoodFragment.this.jaa, FrsGoodFragment.this.hSE);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.jxG.cCv();
                    break;
                case 2:
                    FrsGoodFragment.this.jxG.cCv();
                    break;
                case 3:
                    if (FrsGoodFragment.this.jaa.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.jxN != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.jaa != null) {
                    FrsGoodFragment.this.jat = FrsGoodFragment.this.jaa.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.jaa.getForum().getId();
                    FrsGoodFragment.this.jxG.b(FrsGoodFragment.this.jaa.getForum(), FrsGoodFragment.this.jaa.getUserData());
                }
                if (FrsGoodFragment.this.jaa != null) {
                    FrsGoodFragment.this.jaa.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.jxG.c(FrsGoodFragment.this.jaa);
                if (FrsGoodFragment.this.jaa == null || FrsGoodFragment.this.jaa.getThreadList() == null || FrsGoodFragment.this.jaa.getThreadList().size() != 0 || FrsGoodFragment.this.cHG().getType() != 4) {
                    if (FrsGoodFragment.this.jaa != null && (a2 = FrsGoodFragment.this.jxF.a(false, false, true, FrsGoodFragment.this.jaa.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsGoodFragment.this.jaa.setThreadList(a2);
                    }
                    FrsGoodFragment.this.cBC();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.iDg > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.iDg, FrsGoodFragment.this.cHG().cvr() - FrsGoodFragment.this.iDg, FrsGoodFragment.this.cHG().cvp(), FrsGoodFragment.this.cHG().cvq(), currentTimeMillis2 - FrsGoodFragment.this.cHG().cvo());
                        FrsGoodFragment.this.iDg = -1L;
                    }
                    FrsGoodFragment.this.fHj = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.iDg > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.iDg, FrsGoodFragment.this.cHG().cvr() - FrsGoodFragment.this.iDg, FrsGoodFragment.this.cHG().cvp(), FrsGoodFragment.this.cHG().cvq(), currentTimeMillis3 - FrsGoodFragment.this.cHG().cvo());
                FrsGoodFragment.this.iDg = -1L;
            }
            FrsGoodFragment.this.fHj = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cBw() {
        }
    };
    private final CustomMessageListener eHt = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.jxG != null) {
                FrsGoodFragment.this.jxG.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                com.baidu.tieba.card.s.crj().pr(true);
                com.baidu.tieba.s.c.dKg().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.jby += i2;
            if (FrsGoodFragment.this.jby >= FrsGoodFragment.this.dTc * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener fqC = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private w jcn = new w() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && nVar != null && (nVar instanceof by)) {
                bz bzVar = ((by) nVar).eHK;
                if (bzVar.boz() == null || bzVar.boz().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bzVar.bok() != 1 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.SD(bzVar.getId())) {
                            readThreadHistory.SC(bzVar.getId());
                            if (FrsGoodFragment.this.jxG != null) {
                                FrsGoodFragment.this.jxG.cCv();
                            }
                        }
                        boolean z = false;
                        final String bnD = bzVar.bnD();
                        if (bnD != null && !bnD.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    z zVar = new z(bnD);
                                    zVar.brX().bsG().mIsNeedAddCommenParam = false;
                                    zVar.brX().bsG().mIsUseCurrentBDUSS = false;
                                    zVar.getNetData();
                                }
                            }).start();
                        }
                        String str = null;
                        if (bzVar != null) {
                            str = bzVar.getTid();
                        }
                        if (str == null) {
                            str = "";
                        }
                        if (bzVar.bns() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.bsB().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3 && str.length() > 3) {
                            bzVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bzVar, FrsGoodFragment.this.jat, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bzVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.jaa != null && FrsGoodFragment.this.jaa.getForum() != null) {
                            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
                            bVar.jBG = FrsGoodFragment.this.jaa.needLog == 1;
                            bVar.jBI = FrsGoodFragment.this.jaa.getForum().getId();
                            if (com.baidu.tieba.frs.b.d.jkJ != null) {
                                bVar.jBJ = com.baidu.tieba.frs.b.d.jkJ.jBJ;
                                bVar.jBK = com.baidu.tieba.frs.b.d.jkJ.jBK;
                            }
                            com.baidu.tieba.frs.b.a.a(bzVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jcr = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.jxG != null) {
                FrsGoodFragment.this.jxG.Du();
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

    public void cEu() {
        if (this.jxG != null) {
            this.jxG.refreshView();
        }
    }

    private void showLoadingView() {
        this.jxG.qL(false);
        showLoadingView(this.jxG.cmp(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jxG.qL(true);
        hideLoadingView(this.jxG.cmp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.jxG.qL(false);
        this.jxG.qK(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jxG.bRO();
        this.jxG.getListView().getData().clear();
        this.jxG.cCv();
        if (this.jgO == null) {
            this.jgO = new c(getPageContext().getContext(), getNetRefreshListener());
            this.jgO.setTitle(null);
            this.jgO.setButtonText(null);
            this.jgO.showRefreshButton();
            this.jgO.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.jgO.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.jgO.setSubText(null);
        }
        this.jgO.onChangeSkinType();
        this.jgO.attachView(this.jxG.cmp(), true);
        registerListener(this.jee);
    }

    private void Vq() {
        this.jxG.qL(true);
        this.jxG.qK(true);
        if (this.jgO != null && this.jgO.isViewAttached()) {
            this.jgO.dettachView(this.jxG.cmp());
        }
        MessageManager.getInstance().unRegisterListener(this.jee);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rg(boolean z) {
        this.ixq = true;
        cBI();
        Vq();
        if (!z) {
            Vq();
            showLoadingView();
        }
        this.jxE.loadData(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iDg = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.iDg = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
            this.jjD = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
        }
        this.beginTime = System.currentTimeMillis();
        this.fHa = this.beginTime - this.iDg;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dKg().z(getUniqueId());
        this.jxE = new FrsGoodModelController(this);
        if (arguments != null) {
            this.jxE.aj(arguments);
            this.jxD = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.jxE.aj(bundle);
            this.jxD = bundle.getBoolean("is_game_frs", false);
        } else {
            this.jxE.aj(null);
        }
        this.jaA = getVoiceManager();
        this.jaA.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eHt);
        registerListener(this.jxK);
        registerListener(this.jbN);
        registerListener(this.jcr);
        this.jxF = new FrsLoadMoreModel(this, null);
        this.jxF.registerListener();
        this.jxF.setPageType(2);
        this.jxF.ri(true);
        this.jxF.setFunAdController(com.baidu.tieba.funad.a.rC(this.jjD));
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dTc = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jxG = new a(this, inflate, this.jxD);
        this.jxG.cHK().cHR();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.ixq) {
            if (j.isNetWorkAvailable()) {
                rg(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dW("fid", this.mForumId).dW("obj_type", "7").an("obj_locate", 2).dW("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.jaA = getVoiceManager();
        this.jaA.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cHD();
        if (bundle != null) {
            this.jat = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.jat = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cHD() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fqC);
    }

    public FrsLoadMoreModel cHE() {
        return this.jxF;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.jxG != null) {
            this.jxG.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jee);
        com.baidu.tieba.s.c.dKg().A(getUniqueId());
        com.baidu.tieba.card.s.crj().pr(false);
        super.onDestroy();
        this.jxE.cHM();
        this.jaA = getVoiceManager();
        this.jaA.onDestory(getPageContext());
        e.mB().removeCallbacks(this.jxJ);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jat);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.jxD);
        this.jxE.onSaveInstanceState(bundle);
        this.jaA = getVoiceManager();
        if (this.jaA != null) {
            this.jaA.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bz threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jxG.cHK().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.jaa.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.nk(intent.getIntExtra("good_data", 0));
                            threadDataById.box();
                            rg(false);
                            return;
                        } else if (intExtra == 0) {
                            this.jaa.removeThreadData(threadDataById);
                            ArrayList<n> threadList = this.jaa.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jxG.cHI();
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
            if (this.jjB == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.ixq) {
                e.mB().post(this.jxJ);
            }
        }
        cDM();
    }

    private void cDM() {
        if (isPrimary()) {
            if (this.jgO != null && this.jgO.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jee);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jee);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jxG != null) {
            this.jxG.cCv();
        }
        this.jaA = getVoiceManager();
        this.jaA.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jxH = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.jxG.a(this.jcn);
        this.jxG.setOnScrollListener(this.mScrollListener);
        this.jxG.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.jxH != null) {
                    FrsGoodFragment.this.jxH.i(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jjB != 3 || this.jxG != null) {
            this.jjB = i;
            super.onChangeSkinType(i);
            if (this.jxG != null) {
                this.jxG.onChangeSkinType(i);
            }
            if (this.jgO != null && this.jgO.isViewAttached()) {
                this.jgO.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cAu() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cAu();
        }
        return null;
    }

    private void cBB() {
        switch (this.mFlag) {
            case 1:
                h.mC().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Sx(FrsGoodFragment.this.jat);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBC() {
        cBI();
        try {
            if (this.jaa != null) {
                this.jxG.cDW();
                this.jxG.bXh();
                this.jat = this.jaa.getForum().getName();
                this.forumId = this.jaa.getForum().getId();
                if (this.jaa != null && this.jaa.getForum() != null) {
                    this.jxG.a(this.jaa.getForum().getThemeColorInfo());
                    this.jxG.c(this.jaa);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.jaa.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jaa.getUserData().getBimg_end_time());
                cBB();
                if (!this.jxG.cHK().r(bz.eOz)) {
                    this.jaa.removeAlaLiveThreadData();
                }
                ArrayList<n> threadList = this.jaa.getThreadList();
                if (threadList != null) {
                    this.jxG.a(threadList, this.mPn, this.jaa, this.jaa.getPage().bmm());
                    cHF();
                    this.jxG.cHI();
                    if (this.jaa.getIsNewUrl() == 1) {
                        this.jxG.cHK().setFromCDN(true);
                    } else {
                        this.jxG.cHK().setFromCDN(false);
                    }
                    this.jxG.setListViewSelection(cA(cHG().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cA(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.jaA = getVoiceManager();
        this.jaA.onPause(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.crj().pr(false);
        com.baidu.tieba.s.c.dKg().b(getUniqueId(), false);
        if (this.jaa != null && this.jaa.getForum() != null) {
            com.baidu.tbadk.distribute.a.bAC().b(getPageContext().getPageActivity(), "frs", this.jaa.getForum().getId(), 0L);
        }
        this.jaA = getVoiceManager();
        if (this.jaA != null) {
            this.jaA.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zL(int i) {
        ArrayList<n> threadList = this.jaa.getThreadList();
        if (threadList != null) {
            Iterator<n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (next instanceof by) {
                    bz bzVar = ((by) next).eHK;
                    if (bzVar.getId() != null && bzVar.getId().equals(this.jxC)) {
                        c(bzVar, i);
                        this.jxC = null;
                        break;
                    }
                }
            }
            this.jxG.cHK().b(threadList, this.jaa);
            this.jxG.cHK().notifyDataSetChanged();
        }
    }

    private void c(bz bzVar, int i) {
        if (i == 1) {
            PraiseData bni = bzVar.bni();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bni == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bzVar.a(praiseData);
                    return;
                }
                bzVar.bni().getUser().add(0, metaData);
                bzVar.bni().setNum(bzVar.bni().getNum() + 1);
                bzVar.bni().setIsLike(i);
            }
        } else if (bzVar.bni() != null) {
            bzVar.bni().setIsLike(i);
            bzVar.bni().setNum(bzVar.bni().getNum() - 1);
            ArrayList<MetaData> user = bzVar.bni().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bzVar.bni().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jaA == null) {
            this.jaA = VoiceManager.instance();
        }
        return this.jaA;
    }

    public BdTypeRecyclerView getListView() {
        if (this.jxG == null) {
            return null;
        }
        return this.jxG.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cBI() {
        this.jaA = getVoiceManager();
        this.jaA.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> bus() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).bus();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.jaa != null && this.jxG != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jxG.cCv();
            }
        }
    }

    private void cHF() {
        HashMap<Integer, bz> cFf;
        if (this.jxG != null && this.jxG.cHK() != null && (cFf = this.jxG.cHK().cFf()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bz> entry : cFf.entrySet()) {
                bz value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bAI().G(arrayList);
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
            rg(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cBN() {
        return this.jaa;
    }

    public FrsGoodModelController cHG() {
        return this.jxE;
    }

    public void Kk(String str) {
        this.jat = str;
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
            this.jxG.bRO();
        } else if (!this.jxE.cHQ()) {
            this.jxG.bRO();
        } else {
            bQN();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.jxF.isLoading && !this.jxE.isLoading()) {
                if (this.jxF.dF(this.jaa.getThreadListIds())) {
                    this.jxG.a(this.jxF.cIb(), this.mPn, this.jaa, 0);
                    this.jxF.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.jaa.getThreadListIds(), this.jat, this.mPn, this.jaa.isBrandForum);
                } else if (this.hSE != 0) {
                    this.jxG.a(this.jxF.cIb(), this.mPn, this.jaa, 0);
                    this.mPn++;
                    this.jxE.zN(this.mPn);
                    this.jxF.loadingDone = false;
                    this.jxF.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bQN();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void au(ArrayList<n> arrayList) {
        bQN();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<n> a2 = this.jxF.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.jaa.setThreadList(a2);
                this.jxG.a(a2, this.mPn, this.jaa, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jaa.getForum()));
        }
    }

    private void bQN() {
        if (this.hSE == 0 && !this.jxF.dF(this.jaa.getThreadListIds())) {
            if (this.jaa.getThreadList() == null || this.jaa.getThreadList().size() == 0) {
                this.jxG.bRO();
            } else {
                this.jxG.Vp();
            }
        } else if (x.getCount(this.jaa.getThreadList()) > 3) {
            this.jxG.Vo();
        } else {
            this.jxG.cCK();
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.l.a.a.InterfaceC0148a
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

    @Override // com.baidu.tieba.recapp.p
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.p
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bAC().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.p
    public void cBH() {
        if (this.jxE != null) {
            this.jxE.cBH();
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
    public NavigationBar bUz() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jat;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.jaa != null) {
            i = this.jaa.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.d.j.Al(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zM(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            rg(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void cAO() {
        if (this.jxG != null && this.jxG.getListView() != null) {
            this.jxG.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bRN() {
        if (this.jxG != null) {
            cAO();
            this.jxG.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jba.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sH(int i) {
        return this.jba.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void btS() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bKv().DZ("page_frs_good");
            rg(true);
            return;
        }
        this.jxG.lQ(false);
    }

    @Override // com.baidu.tieba.frs.aq
    public void btT() {
        com.baidu.tieba.s.c.dKg().b(getUniqueId(), false);
    }

    public void a(au auVar) {
        if (auVar != null && cBN() != null && cBN().getThreadList() != null) {
            if (x.isEmpty(cBN().getThreadList())) {
                cBN().getThreadList().add(auVar);
            } else {
                if (cBN().getThreadList().size() == 1 && (cBN().getThreadList().get(0) instanceof com.baidu.tieba.frs.s)) {
                    cBN().getThreadList().remove(0);
                }
                cBN().getThreadList().add(0, auVar);
            }
            this.jxG.a(this.jaa.getThreadList(), this.mPn, this.jaa, this.jaa.getPage().bmm());
            this.jxG.cHI();
            this.jxG.setListViewSelection(0);
        }
    }
}
