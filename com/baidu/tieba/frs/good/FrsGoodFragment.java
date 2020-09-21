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
import com.baidu.tieba.frs.f.i;
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
/* loaded from: classes21.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0209a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, as, at, au, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private VoiceManager hZU;
    private c igm;
    private String iui;
    private FrsGoodModelController iuk;
    private FrsLoadMoreModel iul;
    private com.baidu.tieba.frs.gametab.b iun;
    private String mForumId;
    private String hZN = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean iuj = false;
    private String forumId = null;
    private FrsViewData hZt = new FrsViewData();
    public long hCy = -1;
    public long eUE = 0;
    public long eUN = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean iah = false;
    protected a ium = null;
    private int gUU = -1;
    private int mTabId = 0;
    private int iiW = 3;
    private boolean hwz = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iav = new SparseArray<>();
    private boolean iuo = false;
    private int djl = 0;
    private int iaT = 0;
    private CustomMessageListener idB = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.igm != null && FrsGoodFragment.this.igm.isViewAttached()) {
                FrsGoodFragment.this.igm.qJ(num.intValue());
            }
        }
    };
    private Runnable iup = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.hwz) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.pc(false);
            }
        }
    };
    private CustomMessageListener iuq = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                bw bwVar = (bw) customResponsedMessage.getData();
                FrsGoodFragment.this.iui = bwVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.iui) && bwVar.bfj() != null) {
                    FrsGoodFragment.this.yH(bwVar.bfj().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener ibh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.blX() != null) {
                        FrsGoodFragment.this.blX().setSelection(0);
                    }
                    if (FrsGoodFragment.this.igm != null && FrsGoodFragment.this.igm.isViewAttached()) {
                        FrsGoodFragment.this.pc(false);
                    } else if (FrsGoodFragment.this.ium != null) {
                        FrsGoodFragment.this.ium.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final r ibz = new r() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long iut = 1;

        @Override // com.baidu.tieba.tbadkCore.r
        public void xu(int i) {
            if (!FrsGoodFragment.this.iuo) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.ium.cqr();
                        return;
                    case 3:
                        FrsGoodFragment.this.ium.ki(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, f fVar) {
            ArrayList<q> a;
            if (FrsGoodFragment.this.iuo) {
                if (FrsGoodFragment.this.cuA().cuI() == null) {
                    FrsGoodFragment.this.iuo = false;
                    return;
                } else if (FrsGoodFragment.this.cuA().cuI().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.iuo = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.iut = 1L;
            } else if (fVar.isSuccess) {
                this.iut = 0L;
            } else {
                this.iut = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.iul.resetData();
            }
            FrsGoodFragment.this.ium.ki(false);
            if (FrsGoodFragment.this.cuA().cuI() != null) {
                FrsGoodFragment.this.hZt = FrsGoodFragment.this.cuA().cuI();
            }
            FrsGoodFragment.this.gUU = FrsGoodFragment.this.hZt.getPage().beo();
            if (FrsGoodFragment.this.gUU != 0 || (FrsGoodFragment.this.hZt.getThreadListIds() != null && FrsGoodFragment.this.hZt.getThreadListIds().size() != 0)) {
                if (y.getCount(FrsGoodFragment.this.hZt.getThreadList()) > 3) {
                    FrsGoodFragment.this.ium.bIi();
                } else {
                    FrsGoodFragment.this.ium.cqH();
                }
            } else if (FrsGoodFragment.this.hZt.getThreadList() == null || FrsGoodFragment.this.hZt.getThreadList().size() == 0) {
                FrsGoodFragment.this.ium.bIk();
            } else {
                FrsGoodFragment.this.ium.bIj();
            }
            if (i == 4) {
                ArrayList<q> a2 = FrsGoodFragment.this.iul.a(false, false, false, FrsGoodFragment.this.hZt.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.hZt.setThreadList(a2);
                    FrsGoodFragment.this.ium.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.hZt, FrsGoodFragment.this.gUU);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.ium.cqr();
                    break;
                case 2:
                    FrsGoodFragment.this.ium.cqr();
                    break;
                case 3:
                    if (FrsGoodFragment.this.hZt.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.iut != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.hZt != null) {
                    FrsGoodFragment.this.hZN = FrsGoodFragment.this.hZt.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.hZt.getForum().getId();
                    FrsGoodFragment.this.ium.b(FrsGoodFragment.this.hZt.getForum(), FrsGoodFragment.this.hZt.getUserData());
                }
                if (FrsGoodFragment.this.hZt != null) {
                    FrsGoodFragment.this.hZt.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.ium.c(FrsGoodFragment.this.hZt);
                if (FrsGoodFragment.this.hZt == null || FrsGoodFragment.this.hZt.getThreadList() == null || FrsGoodFragment.this.hZt.getThreadList().size() != 0 || FrsGoodFragment.this.cuA().getType() != 4) {
                    if (FrsGoodFragment.this.hZt != null && (a = FrsGoodFragment.this.iul.a(false, false, true, FrsGoodFragment.this.hZt.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.hZt.setThreadList(a);
                    }
                    FrsGoodFragment.this.cpz();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.hCy > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.hCy, FrsGoodFragment.this.cuA().cjs() - FrsGoodFragment.this.hCy, FrsGoodFragment.this.cuA().cjq(), FrsGoodFragment.this.cuA().cjr(), currentTimeMillis2 - FrsGoodFragment.this.cuA().cjp());
                        FrsGoodFragment.this.hCy = -1L;
                    }
                    FrsGoodFragment.this.eUN = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.hCy > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.hCy, FrsGoodFragment.this.cuA().cjs() - FrsGoodFragment.this.hCy, FrsGoodFragment.this.cuA().cjq(), FrsGoodFragment.this.cuA().cjr(), currentTimeMillis3 - FrsGoodFragment.this.cuA().cjp());
                FrsGoodFragment.this.hCy = -1L;
            }
            FrsGoodFragment.this.eUN = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cpt() {
        }
    };
    private final CustomMessageListener dWP = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.ium != null) {
                FrsGoodFragment.this.ium.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.iah) {
                FrsGoodFragment.this.iah = true;
                FrsGoodFragment.this.ium.cqG();
            }
            if (i == 0) {
                s.cfn().ns(true);
                com.baidu.tieba.s.c.dzC().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.iaT += i2;
            if (FrsGoodFragment.this.iaT >= FrsGoodFragment.this.djl * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener eEB = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private ab ibG = new ab() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bv)) {
                bw bwVar = ((bv) qVar).dXg;
                if (bwVar.bgy() == null || bwVar.bgy().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bwVar.bgl() != 1 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Rx(bwVar.getId())) {
                            readThreadHistory.Rw(bwVar.getId());
                            if (FrsGoodFragment.this.ium != null) {
                                FrsGoodFragment.this.ium.cqr();
                            }
                        }
                        boolean z = false;
                        final String bfE = bwVar.bfE();
                        if (bfE != null && !bfE.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(bfE);
                                    aaVar.bjL().bkq().mIsNeedAddCommenParam = false;
                                    aaVar.bjL().bkq().mIsUseCurrentBDUSS = false;
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
                        if (bwVar.bft() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.bkp().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3 && str.length() > 3) {
                            bwVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bwVar, FrsGoodFragment.this.hZN, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.hZt != null && FrsGoodFragment.this.hZt.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.iyp = FrsGoodFragment.this.hZt.needLog == 1;
                            bVar.iyr = FrsGoodFragment.this.hZt.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.ijV != null) {
                                bVar.iys = com.baidu.tieba.frs.d.d.ijV.iys;
                                bVar.iyt = com.baidu.tieba.frs.d.d.ijV.iyt;
                            }
                            com.baidu.tieba.frs.d.a.a(bwVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener ibK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.ium != null) {
                FrsGoodFragment.this.ium.EW();
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

    public void csr() {
        if (this.ium != null) {
            this.ium.refreshView();
        }
    }

    private void showLoadingView() {
        this.ium.oL(false);
        showLoadingView(this.ium.caY(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.ium.oL(true);
        hideLoadingView(this.ium.caY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.ium.oL(false);
        this.ium.oK(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.ium.bIk();
        this.ium.getListView().getData().clear();
        this.ium.cqr();
        if (this.igm == null) {
            this.igm = new c(getPageContext().getContext(), getNetRefreshListener());
            this.igm.setTitle(null);
            this.igm.setButtonText(null);
            this.igm.showRefreshButton();
            this.igm.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.igm.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.igm.setSubText(null);
        }
        this.igm.onChangeSkinType();
        this.igm.attachView(this.ium.caY(), true);
        registerListener(this.idB);
    }

    private void bHn() {
        this.ium.oL(true);
        this.ium.oK(true);
        if (this.igm != null && this.igm.isViewAttached()) {
            this.igm.dettachView(this.ium.caY());
        }
        MessageManager.getInstance().unRegisterListener(this.idB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pc(boolean z) {
        this.hwz = true;
        cpE();
        bHn();
        if (!z) {
            bHn();
            showLoadingView();
        }
        this.iuk.sV(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hCy = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.hCy = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.eUE = this.beginTime - this.hCy;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dzC().z(getUniqueId());
        this.iuk = new FrsGoodModelController(this);
        if (arguments != null) {
            this.iuk.aj(arguments);
            this.iuj = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.iuk.aj(bundle);
            this.iuj = bundle.getBoolean("is_game_frs", false);
        } else {
            this.iuk.aj(null);
        }
        this.hZU = getVoiceManager();
        this.hZU.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dWP);
        registerListener(this.iuq);
        registerListener(this.ibh);
        registerListener(this.ibK);
        this.iul = new FrsLoadMoreModel(this, null);
        this.iul.registerListener();
        this.iul.setPageType(2);
        this.iul.pe(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.djl = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.ium = new a(this, inflate, this.iuj);
        this.ium.cuE().cuL();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.hwz) {
            if (j.isNetWorkAvailable()) {
                pc(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new aq("c13008").dF("fid", this.mForumId).dF("obj_type", "7").ai("obj_locate", 2).dF("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hZU = getVoiceManager();
        this.hZU.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cux();
        if (bundle != null) {
            this.hZN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.hZN = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cux() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eEB);
    }

    public FrsLoadMoreModel cuy() {
        return this.iul;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ium != null) {
            this.ium.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.idB);
        com.baidu.tieba.s.c.dzC().A(getUniqueId());
        s.cfn().ns(false);
        super.onDestroy();
        this.iuk.cuG();
        this.hZU = getVoiceManager();
        this.hZU.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iup);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hZN);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.iuj);
        this.iuk.onSaveInstanceState(bundle);
        this.hZU = getVoiceManager();
        if (this.hZU != null) {
            this.hZU.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bw threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.ium.cuE().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.hZt.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.nu(intent.getIntExtra("good_data", 0));
                            threadDataById.bgw();
                            pc(false);
                            return;
                        } else if (intExtra == 0) {
                            this.hZt.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.hZt.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.ium.cuC();
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
            if (this.iiW == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.hwz) {
                com.baidu.adp.lib.f.e.mX().post(this.iup);
            }
        }
        crI();
    }

    private void crI() {
        if (isPrimary()) {
            if (this.igm != null && this.igm.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.idB);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.idB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ium != null) {
            this.ium.cqr();
        }
        this.hZU = getVoiceManager();
        this.hZU.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.iun = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.ium.a(this.ibG);
        this.ium.setOnScrollListener(this.mScrollListener);
        this.ium.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.iun != null) {
                    FrsGoodFragment.this.iun.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iiW != 3 || this.ium != null) {
            this.iiW = i;
            super.onChangeSkinType(i);
            if (this.ium != null) {
                this.ium.onChangeSkinType(i);
            }
            if (this.igm != null && this.igm.isViewAttached()) {
                this.igm.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cot() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).cot();
        }
        return null;
    }

    private void cpy() {
        switch (this.mFlag) {
            case 1:
                h.mY().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Rr(FrsGoodFragment.this.hZN);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpz() {
        cpE();
        try {
            if (this.hZt != null) {
                this.ium.crS();
                this.ium.bMD();
                this.hZN = this.hZt.getForum().getName();
                this.forumId = this.hZt.getForum().getId();
                if (this.hZt != null && this.hZt.getForum() != null) {
                    this.ium.a(this.hZt.getForum().getThemeColorInfo());
                    this.ium.c(this.hZt);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.hZt.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hZt.getUserData().getBimg_end_time());
                cpy();
                if (!this.ium.cuE().r(bw.edD)) {
                    this.hZt.removeAlaLiveThreadData();
                }
                ArrayList<q> threadList = this.hZt.getThreadList();
                if (threadList != null) {
                    this.ium.a(threadList, this.mPn, this.hZt, this.hZt.getPage().beo());
                    cuz();
                    this.ium.cuC();
                    if (this.hZt.getIsNewUrl() == 1) {
                        this.ium.cuE().setFromCDN(true);
                    } else {
                        this.ium.cuE().setFromCDN(false);
                    }
                    this.ium.setListViewSelection(cu(cuA().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int cu(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hZU = getVoiceManager();
        this.hZU.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.cfn().ns(false);
        com.baidu.tieba.s.c.dzC().b(getUniqueId(), false);
        if (this.hZt != null && this.hZt.getForum() != null) {
            com.baidu.tbadk.distribute.a.bsi().b(getPageContext().getPageActivity(), "frs", this.hZt.getForum().getId(), 0L);
        }
        this.hZU = getVoiceManager();
        if (this.hZU != null) {
            this.hZU.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH(int i) {
        ArrayList<q> threadList = this.hZt.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).dXg;
                    if (bwVar.getId() != null && bwVar.getId().equals(this.iui)) {
                        c(bwVar, i);
                        this.iui = null;
                        break;
                    }
                }
            }
            this.ium.cuE().b(threadList, this.hZt);
            this.ium.cuE().notifyDataSetChanged();
        }
    }

    private void c(bw bwVar, int i) {
        if (i == 1) {
            PraiseData bfj = bwVar.bfj();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bfj == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bwVar.a(praiseData);
                    return;
                }
                bwVar.bfj().getUser().add(0, metaData);
                bwVar.bfj().setNum(bwVar.bfj().getNum() + 1);
                bwVar.bfj().setIsLike(i);
            }
        } else if (bwVar.bfj() != null) {
            bwVar.bfj().setIsLike(i);
            bwVar.bfj().setNum(bwVar.bfj().getNum() - 1);
            ArrayList<MetaData> user = bwVar.bfj().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bwVar.bfj().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hZU == null) {
            this.hZU = VoiceManager.instance();
        }
        return this.hZU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView blX() {
        if (this.ium == null) {
            return null;
        }
        return this.ium.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cpE() {
        this.hZU = getVoiceManager();
        this.hZU.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> blY() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).blY();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.hZt != null && this.ium != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.ium.cqr();
            }
        }
    }

    private void cuz() {
        HashMap<Integer, bw> csV;
        if (this.ium != null && this.ium.cuE() != null && (csV = this.ium.cuE().csV()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bw> entry : csV.entrySet()) {
                bw value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.bso().L(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        if (blX() == null) {
            return null;
        }
        return blX().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            pc(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cpJ() {
        return this.hZt;
    }

    public FrsGoodModelController cuA() {
        return this.iuk;
    }

    public void Jk(String str) {
        this.hZN = str;
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
            this.ium.bIk();
        } else if (!this.iuk.cuK()) {
            this.ium.bIk();
        } else {
            bHj();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.iul.isLoading && !this.iuk.isLoading()) {
                if (this.iul.cU(this.hZt.getThreadListIds())) {
                    this.ium.a(this.iul.cuV(), this.mPn, this.hZt, 0);
                    this.iul.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.hZt.getThreadListIds(), this.hZN, this.mPn, this.hZt.isBrandForum);
                } else if (this.gUU != 0) {
                    this.ium.a(this.iul.cuV(), this.mPn, this.hZt, 0);
                    this.mPn++;
                    this.iuk.yJ(this.mPn);
                    this.iul.loadingDone = false;
                    this.iul.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bHj();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void aw(ArrayList<q> arrayList) {
        bHj();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<q> a = this.iul.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a != null) {
                this.hZt.setThreadList(a);
                this.ium.a(a, this.mPn, this.hZt, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.hZt.getForum()));
        }
    }

    private void bHj() {
        if (this.gUU == 0 && !this.iul.cU(this.hZt.getThreadListIds())) {
            if (this.hZt.getThreadList() == null || this.hZt.getThreadList().size() == 0) {
                this.ium.bIk();
            } else {
                this.ium.bIj();
            }
        } else if (y.getCount(this.hZt.getThreadList()) > 3) {
            this.ium.bIi();
        } else {
            this.ium.cqH();
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0209a
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
        com.baidu.tbadk.distribute.a.bsi().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void cpD() {
        if (this.iuk != null) {
            this.iuk.cpD();
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
    public NavigationBar bKS() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hZN;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hZt != null) {
            i = this.hZt.getSortType();
        }
        tbPageTag.sortType = i.zh(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yI(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            pc(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void coM() {
        if (this.ium != null && this.ium.getListView() != null) {
            this.ium.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bIh() {
        if (this.ium != null) {
            coM();
            this.ium.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iav.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sh(int i) {
        return this.iav.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.au
    public void bly() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bBN().DG("page_frs_good");
            pc(true);
            return;
        }
        this.ium.ki(false);
    }

    @Override // com.baidu.tieba.frs.au
    public void blz() {
        com.baidu.tieba.s.c.dzC().b(getUniqueId(), false);
    }

    public void a(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null && cpJ() != null && cpJ().getThreadList() != null) {
            if (y.isEmpty(cpJ().getThreadList())) {
                cpJ().getThreadList().add(asVar);
            } else {
                if (cpJ().getThreadList().size() == 1 && (cpJ().getThreadList().get(0) instanceof com.baidu.tieba.frs.s)) {
                    cpJ().getThreadList().remove(0);
                }
                cpJ().getThreadList().add(0, asVar);
            }
            this.ium.a(this.hZt.getThreadList(), this.mPn, this.hZt, this.hZt.getPage().beo());
            this.ium.cuC();
            this.ium.setListViewSelection(0);
        }
    }
}
