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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.n.a.a;
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
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0277a, UserIconBox.a, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ao, ap, aq, com.baidu.tieba.frs.loadmore.a, p, FrsCommonImageLayout.c {
    private String jCi;
    private FrsGoodModelController jCk;
    private FrsLoadMoreModel jCl;
    private com.baidu.tieba.frs.gametab.b jCn;
    private VoiceManager jfh;
    private c jlv;
    private boolean jok;
    private String mForumId;
    private String jfa = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean jCj = false;
    private String forumId = null;
    private FrsViewData jeH = new FrsViewData();
    public long iHN = -1;
    public long fLH = 0;
    public long fLQ = 0;
    public long createTime = 0;
    public long beginTime = -1;
    protected a jCm = null;
    private int hXl = -1;
    private int mTabId = 0;
    private int joi = 3;
    private boolean iBX = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jfH = new SparseArray<>();
    private boolean jCo = false;
    private int dXO = 0;
    private int jgf = 0;
    private CustomMessageListener jiM = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.jlv != null && FrsGoodFragment.this.jlv.isViewAttached()) {
                FrsGoodFragment.this.jlv.sN(num.intValue());
            }
        }
    };
    private Runnable jCp = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.iBX) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.rk(false);
            }
        }
    };
    private CustomMessageListener jCq = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bz)) {
                bz bzVar = (bz) customResponsedMessage.getData();
                FrsGoodFragment.this.jCi = bzVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.jCi) && bzVar.brb() != null) {
                    FrsGoodFragment.this.Br(bzVar.brb().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener jgu = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.getListView() != null) {
                        FrsGoodFragment.this.getListView().setSelection(0);
                    }
                    if (FrsGoodFragment.this.jlv != null && FrsGoodFragment.this.jlv.isViewAttached()) {
                        FrsGoodFragment.this.rk(false);
                    } else if (FrsGoodFragment.this.jCm != null) {
                        FrsGoodFragment.this.jCm.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final s jgN = new s() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long jCt = 1;

        @Override // com.baidu.tieba.tbadkCore.s
        public void zW(int i) {
            if (!FrsGoodFragment.this.jCo) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.jCm.cGm();
                        return;
                    case 3:
                        FrsGoodFragment.this.jCm.lU(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, f fVar) {
            ArrayList<n> a2;
            if (FrsGoodFragment.this.jCo) {
                if (FrsGoodFragment.this.cLx().cLF() == null) {
                    FrsGoodFragment.this.jCo = false;
                    return;
                } else if (FrsGoodFragment.this.cLx().cLF().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.jCo = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.jCt = 1L;
            } else if (fVar.isSuccess) {
                this.jCt = 0L;
            } else {
                this.jCt = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.jCl.resetData();
            }
            FrsGoodFragment.this.jCm.lU(false);
            if (FrsGoodFragment.this.cLx().cLF() != null) {
                FrsGoodFragment.this.jeH = FrsGoodFragment.this.cLx().cLF();
            }
            FrsGoodFragment.this.hXl = FrsGoodFragment.this.jeH.getPage().bqf();
            if (FrsGoodFragment.this.hXl != 0 || (FrsGoodFragment.this.jeH.getThreadListIds() != null && FrsGoodFragment.this.jeH.getThreadListIds().size() != 0)) {
                if (x.getCount(FrsGoodFragment.this.jeH.getThreadList()) > 3) {
                    FrsGoodFragment.this.jCm.Zg();
                } else {
                    FrsGoodFragment.this.jCm.cGB();
                }
            } else if (FrsGoodFragment.this.jeH.getThreadList() == null || FrsGoodFragment.this.jeH.getThreadList().size() == 0) {
                FrsGoodFragment.this.jCm.bVF();
            } else {
                FrsGoodFragment.this.jCm.Zh();
            }
            if (i == 4) {
                ArrayList<n> a3 = FrsGoodFragment.this.jCl.a(false, false, false, FrsGoodFragment.this.jeH.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsGoodFragment.this.jeH.setThreadList(a3);
                    FrsGoodFragment.this.jCm.a(a3, FrsGoodFragment.this.mPn, FrsGoodFragment.this.jeH, FrsGoodFragment.this.hXl);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.jCm.cGm();
                    break;
                case 2:
                    FrsGoodFragment.this.jCm.cGm();
                    break;
                case 3:
                    if (FrsGoodFragment.this.jeH.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.jCt != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.jeH != null) {
                    FrsGoodFragment.this.jfa = FrsGoodFragment.this.jeH.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.jeH.getForum().getId();
                    FrsGoodFragment.this.jCm.b(FrsGoodFragment.this.jeH.getForum(), FrsGoodFragment.this.jeH.getUserData());
                }
                if (FrsGoodFragment.this.jeH != null) {
                    FrsGoodFragment.this.jeH.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.jCm.c(FrsGoodFragment.this.jeH);
                if (FrsGoodFragment.this.jeH == null || FrsGoodFragment.this.jeH.getThreadList() == null || FrsGoodFragment.this.jeH.getThreadList().size() != 0 || FrsGoodFragment.this.cLx().getType() != 4) {
                    if (FrsGoodFragment.this.jeH != null && (a2 = FrsGoodFragment.this.jCl.a(false, false, true, FrsGoodFragment.this.jeH.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsGoodFragment.this.jeH.setThreadList(a2);
                    }
                    FrsGoodFragment.this.cFt();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.iHN > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.iHN, FrsGoodFragment.this.cLx().czi() - FrsGoodFragment.this.iHN, FrsGoodFragment.this.cLx().czg(), FrsGoodFragment.this.cLx().czh(), currentTimeMillis2 - FrsGoodFragment.this.cLx().czf());
                        FrsGoodFragment.this.iHN = -1L;
                    }
                    FrsGoodFragment.this.fLQ = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.iHN > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.iHN, FrsGoodFragment.this.cLx().czi() - FrsGoodFragment.this.iHN, FrsGoodFragment.this.cLx().czg(), FrsGoodFragment.this.cLx().czh(), currentTimeMillis3 - FrsGoodFragment.this.cLx().czf());
                FrsGoodFragment.this.iHN = -1L;
            }
            FrsGoodFragment.this.fLQ = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cFn() {
        }
    };
    private final CustomMessageListener eMe = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.jCm != null) {
                FrsGoodFragment.this.jCm.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                com.baidu.tieba.card.s.cva().pv(true);
                com.baidu.tieba.s.c.dNX().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.jgf += i2;
            if (FrsGoodFragment.this.jgf >= FrsGoodFragment.this.dXO * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener fvn = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private w jgU = new w() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && nVar != null && (nVar instanceof by)) {
                bz bzVar = ((by) nVar).eMv;
                if (bzVar.bss() == null || bzVar.bss().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bzVar.bsd() != 1 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.TL(bzVar.getId())) {
                            readThreadHistory.TK(bzVar.getId());
                            if (FrsGoodFragment.this.jCm != null) {
                                FrsGoodFragment.this.jCm.cGm();
                            }
                        }
                        boolean z = false;
                        final String brw = bzVar.brw();
                        if (brw != null && !brw.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    z zVar = new z(brw);
                                    zVar.bvQ().bwz().mIsNeedAddCommenParam = false;
                                    zVar.bvQ().bwz().mIsUseCurrentBDUSS = false;
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
                        if (bzVar.brl() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.bwu().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3 && str.length() > 3) {
                            bzVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bzVar, FrsGoodFragment.this.jfa, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bzVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.jeH != null && FrsGoodFragment.this.jeH.getForum() != null) {
                            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
                            bVar.jGm = FrsGoodFragment.this.jeH.needLog == 1;
                            bVar.jGo = FrsGoodFragment.this.jeH.getForum().getId();
                            if (com.baidu.tieba.frs.b.d.jpq != null) {
                                bVar.jGp = com.baidu.tieba.frs.b.d.jpq.jGp;
                                bVar.jGq = com.baidu.tieba.frs.b.d.jpq.jGq;
                            }
                            com.baidu.tieba.frs.b.a.a(bzVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jgY = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.jCm != null) {
                FrsGoodFragment.this.jCm.Hp();
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

    public void cIl() {
        if (this.jCm != null) {
            this.jCm.refreshView();
        }
    }

    private void showLoadingView() {
        this.jCm.qP(false);
        showLoadingView(this.jCm.cqg(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jCm.qP(true);
        hideLoadingView(this.jCm.cqg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.jCm.qP(false);
        this.jCm.qO(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jCm.bVF();
        this.jCm.getListView().getData().clear();
        this.jCm.cGm();
        if (this.jlv == null) {
            this.jlv = new c(getPageContext().getContext(), getNetRefreshListener());
            this.jlv.setTitle(null);
            this.jlv.setButtonText(null);
            this.jlv.showRefreshButton();
            this.jlv.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.jlv.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.jlv.setSubText(null);
        }
        this.jlv.onChangeSkinType();
        this.jlv.attachView(this.jCm.cqg(), true);
        registerListener(this.jiM);
    }

    private void Zi() {
        this.jCm.qP(true);
        this.jCm.qO(true);
        if (this.jlv != null && this.jlv.isViewAttached()) {
            this.jlv.dettachView(this.jCm.cqg());
        }
        MessageManager.getInstance().unRegisterListener(this.jiM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(boolean z) {
        this.iBX = true;
        cFz();
        Zi();
        if (!z) {
            Zi();
            showLoadingView();
        }
        this.jCk.loadData(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iHN = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.iHN = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
            this.jok = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
        }
        this.beginTime = System.currentTimeMillis();
        this.fLH = this.beginTime - this.iHN;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dNX().z(getUniqueId());
        this.jCk = new FrsGoodModelController(this);
        if (arguments != null) {
            this.jCk.aj(arguments);
            this.jCj = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.jCk.aj(bundle);
            this.jCj = bundle.getBoolean("is_game_frs", false);
        } else {
            this.jCk.aj(null);
        }
        this.jfh = getVoiceManager();
        this.jfh.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eMe);
        registerListener(this.jCq);
        registerListener(this.jgu);
        registerListener(this.jgY);
        this.jCl = new FrsLoadMoreModel(this, null);
        this.jCl.registerListener();
        this.jCl.setPageType(2);
        this.jCl.rm(true);
        this.jCl.setFunAdController(com.baidu.tieba.funad.a.rG(this.jok));
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dXO = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.jCm = new a(this, inflate, this.jCj);
        this.jCm.cLB().cLI();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.iBX) {
            if (j.isNetWorkAvailable()) {
                rk(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dX("fid", this.mForumId).dX("obj_type", "7").an("obj_locate", 2).dX("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.jfh = getVoiceManager();
        this.jfh.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cLu();
        if (bundle != null) {
            this.jfa = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.jfa = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cLu() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fvn);
    }

    public FrsLoadMoreModel cLv() {
        return this.jCl;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.jCm != null) {
            this.jCm.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jiM);
        com.baidu.tieba.s.c.dNX().A(getUniqueId());
        com.baidu.tieba.card.s.cva().pv(false);
        super.onDestroy();
        this.jCk.cLD();
        this.jfh = getVoiceManager();
        this.jfh.onDestory(getPageContext());
        e.mB().removeCallbacks(this.jCp);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jfa);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.jCj);
        this.jCk.onSaveInstanceState(bundle);
        this.jfh = getVoiceManager();
        if (this.jfh != null) {
            this.jfh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bz threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.jCm.cLB().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.jeH.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.oQ(intent.getIntExtra("good_data", 0));
                            threadDataById.bsq();
                            rk(false);
                            return;
                        } else if (intExtra == 0) {
                            this.jeH.removeThreadData(threadDataById);
                            ArrayList<n> threadList = this.jeH.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.jCm.cLz();
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
            if (this.joi == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.iBX) {
                e.mB().post(this.jCp);
            }
        }
        cHD();
    }

    private void cHD() {
        if (isPrimary()) {
            if (this.jlv != null && this.jlv.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jiM);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jiM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jCm != null) {
            this.jCm.cGm();
        }
        this.jfh = getVoiceManager();
        this.jfh.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.jCn = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.jCm.a(this.jgU);
        this.jCm.setOnScrollListener(this.mScrollListener);
        this.jCm.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.jCn != null) {
                    FrsGoodFragment.this.jCn.i(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.joi != 3 || this.jCm != null) {
            this.joi = i;
            super.onChangeSkinType(i);
            if (this.jCm != null) {
                this.jCm.onChangeSkinType(i);
            }
            if (this.jlv != null && this.jlv.isViewAttached()) {
                this.jlv.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cEl() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cEl();
        }
        return null;
    }

    private void cFs() {
        switch (this.mFlag) {
            case 1:
                h.mC().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TF(FrsGoodFragment.this.jfa);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFt() {
        cFz();
        try {
            if (this.jeH != null) {
                this.jCm.cHN();
                this.jCm.caY();
                this.jfa = this.jeH.getForum().getName();
                this.forumId = this.jeH.getForum().getId();
                if (this.jeH != null && this.jeH.getForum() != null) {
                    this.jCm.a(this.jeH.getForum().getThemeColorInfo());
                    this.jCm.c(this.jeH);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.jeH.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jeH.getUserData().getBimg_end_time());
                cFs();
                if (!this.jCm.cLB().r(bz.eTk)) {
                    this.jeH.removeAlaLiveThreadData();
                }
                ArrayList<n> threadList = this.jeH.getThreadList();
                if (threadList != null) {
                    this.jCm.a(threadList, this.mPn, this.jeH, this.jeH.getPage().bqf());
                    cLw();
                    this.jCm.cLz();
                    if (this.jeH.getIsNewUrl() == 1) {
                        this.jCm.cLB().setFromCDN(true);
                    } else {
                        this.jCm.cLB().setFromCDN(false);
                    }
                    this.jCm.setListViewSelection(cA(cLx().getType(), this.mPn));
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
        this.jfh = getVoiceManager();
        this.jfh.onPause(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.cva().pv(false);
        com.baidu.tieba.s.c.dNX().b(getUniqueId(), false);
        if (this.jeH != null && this.jeH.getForum() != null) {
            com.baidu.tbadk.distribute.a.bEv().b(getPageContext().getPageActivity(), "frs", this.jeH.getForum().getId(), 0L);
        }
        this.jfh = getVoiceManager();
        if (this.jfh != null) {
            this.jfh.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Br(int i) {
        ArrayList<n> threadList = this.jeH.getThreadList();
        if (threadList != null) {
            Iterator<n> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (next instanceof by) {
                    bz bzVar = ((by) next).eMv;
                    if (bzVar.getId() != null && bzVar.getId().equals(this.jCi)) {
                        c(bzVar, i);
                        this.jCi = null;
                        break;
                    }
                }
            }
            this.jCm.cLB().b(threadList, this.jeH);
            this.jCm.cLB().notifyDataSetChanged();
        }
    }

    private void c(bz bzVar, int i) {
        if (i == 1) {
            PraiseData brb = bzVar.brb();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (brb == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bzVar.a(praiseData);
                    return;
                }
                bzVar.brb().getUser().add(0, metaData);
                bzVar.brb().setNum(bzVar.brb().getNum() + 1);
                bzVar.brb().setIsLike(i);
            }
        } else if (bzVar.brb() != null) {
            bzVar.brb().setIsLike(i);
            bzVar.brb().setNum(bzVar.brb().getNum() - 1);
            ArrayList<MetaData> user = bzVar.brb().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bzVar.brb().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jfh == null) {
            this.jfh = VoiceManager.instance();
        }
        return this.jfh;
    }

    public BdTypeRecyclerView getListView() {
        if (this.jCm == null) {
            return null;
        }
        return this.jCm.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cFz() {
        this.jfh = getVoiceManager();
        this.jfh.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> byl() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).byl();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.jeH != null && this.jCm != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.jCm.cGm();
            }
        }
    }

    private void cLw() {
        HashMap<Integer, bz> cIW;
        if (this.jCm != null && this.jCm.cLB() != null && (cIW = this.jCm.cLB().cIW()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bz> entry : cIW.entrySet()) {
                bz value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bEB().L(arrayList);
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
            rk(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cFE() {
        return this.jeH;
    }

    public FrsGoodModelController cLx() {
        return this.jCk;
    }

    public void Lv(String str) {
        this.jfa = str;
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
            this.jCm.bVF();
        } else if (!this.jCk.cLH()) {
            this.jCm.bVF();
        } else {
            bUE();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.jCl.isLoading && !this.jCk.isLoading()) {
                if (this.jCl.dF(this.jeH.getThreadListIds())) {
                    this.jCm.a(this.jCl.cLS(), this.mPn, this.jeH, 0);
                    this.jCl.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.jeH.getThreadListIds(), this.jfa, this.mPn, this.jeH.isBrandForum);
                } else if (this.hXl != 0) {
                    this.jCm.a(this.jCl.cLS(), this.mPn, this.jeH, 0);
                    this.mPn++;
                    this.jCk.Bt(this.mPn);
                    this.jCl.loadingDone = false;
                    this.jCl.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bUE();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void az(ArrayList<n> arrayList) {
        bUE();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<n> a2 = this.jCl.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.jeH.setThreadList(a2);
                this.jCm.a(a2, this.mPn, this.jeH, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jeH.getForum()));
        }
    }

    private void bUE() {
        if (this.hXl == 0 && !this.jCl.dF(this.jeH.getThreadListIds())) {
            if (this.jeH.getThreadList() == null || this.jeH.getThreadList().size() == 0) {
                this.jCm.bVF();
            } else {
                this.jCm.Zh();
            }
        } else if (x.getCount(this.jeH.getThreadList()) > 3) {
            this.jCm.Zg();
        } else {
            this.jCm.cGB();
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.n.a.a.InterfaceC0277a
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
        com.baidu.tbadk.distribute.a.bEv().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.p
    public void cFy() {
        if (this.jCk != null) {
            this.jCk.cFy();
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
    public NavigationBar bYq() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jfa;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.jeH != null) {
            i = this.jeH.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.d.j.BR(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bs(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            rk(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void cEF() {
        if (this.jCm != null && this.jCm.getListView() != null) {
            this.jCm.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bVE() {
        if (this.jCm != null) {
            cEF();
            this.jCm.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jfH.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a un(int i) {
        return this.jfH.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxL() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bOm().Fl("page_frs_good");
            rk(true);
            return;
        }
        this.jCm.lU(false);
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxM() {
        com.baidu.tieba.s.c.dNX().b(getUniqueId(), false);
    }

    public void a(au auVar) {
        if (auVar != null && cFE() != null && cFE().getThreadList() != null) {
            if (x.isEmpty(cFE().getThreadList())) {
                cFE().getThreadList().add(auVar);
            } else {
                if (cFE().getThreadList().size() == 1 && (cFE().getThreadList().get(0) instanceof com.baidu.tieba.frs.s)) {
                    cFE().getThreadList().remove(0);
                }
                cFE().getThreadList().add(0, auVar);
            }
            this.jCm.a(this.jeH.getThreadList(), this.mPn, this.jeH, this.jeH.getPage().bqf());
            this.jCm.cLz();
            this.jCm.setListViewSelection(0);
        }
    }
}
