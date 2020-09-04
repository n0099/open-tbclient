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
    private VoiceManager hSU;
    private c hZi;
    private String imR;
    private FrsGoodModelController imT;
    private FrsLoadMoreModel imU;
    private com.baidu.tieba.frs.gametab.b imW;
    private String mForumId;
    private String hSN = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean imS = false;
    private String forumId = null;
    private FrsViewData hSt = new FrsViewData();
    public long hvt = -1;
    public long eRN = 0;
    public long eRX = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean hTh = false;
    protected a imV = null;
    private int gRm = -1;
    private int mTabId = 0;
    private int ibS = 3;
    private boolean hpv = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hTv = new SparseArray<>();
    private boolean imX = false;
    private int dhi = 0;
    private int hTT = 0;
    private CustomMessageListener hWx = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.hZi != null && FrsGoodFragment.this.hZi.isViewAttached()) {
                FrsGoodFragment.this.hZi.qs(num.intValue());
            }
        }
    };
    private Runnable imY = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.hpv) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.oW(false);
            }
        }
    };
    private CustomMessageListener imZ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                bw bwVar = (bw) customResponsedMessage.getData();
                FrsGoodFragment.this.imR = bwVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.imR) && bwVar.bep() != null) {
                    FrsGoodFragment.this.yi(bwVar.bep().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener hUh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.blc() != null) {
                        FrsGoodFragment.this.blc().setSelection(0);
                    }
                    if (FrsGoodFragment.this.hZi != null && FrsGoodFragment.this.hZi.isViewAttached()) {
                        FrsGoodFragment.this.oW(false);
                    } else if (FrsGoodFragment.this.imV != null) {
                        FrsGoodFragment.this.imV.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final r hUz = new r() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long inc = 1;

        @Override // com.baidu.tieba.tbadkCore.r
        public void wV(int i) {
            if (!FrsGoodFragment.this.imX) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.imV.cnf();
                        return;
                    case 3:
                        FrsGoodFragment.this.imV.kh(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, f fVar) {
            ArrayList<q> a;
            if (FrsGoodFragment.this.imX) {
                if (FrsGoodFragment.this.crl().crt() == null) {
                    FrsGoodFragment.this.imX = false;
                    return;
                } else if (FrsGoodFragment.this.crl().crt().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.imX = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.inc = 1L;
            } else if (fVar.isSuccess) {
                this.inc = 0L;
            } else {
                this.inc = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.imU.resetData();
            }
            FrsGoodFragment.this.imV.kh(false);
            if (FrsGoodFragment.this.crl().crt() != null) {
                FrsGoodFragment.this.hSt = FrsGoodFragment.this.crl().crt();
            }
            FrsGoodFragment.this.gRm = FrsGoodFragment.this.hSt.getPage().bdu();
            if (FrsGoodFragment.this.gRm != 0 || (FrsGoodFragment.this.hSt.getThreadListIds() != null && FrsGoodFragment.this.hSt.getThreadListIds().size() != 0)) {
                if (y.getCount(FrsGoodFragment.this.hSt.getThreadList()) > 3) {
                    FrsGoodFragment.this.imV.bGS();
                } else {
                    FrsGoodFragment.this.imV.cnv();
                }
            } else if (FrsGoodFragment.this.hSt.getThreadList() == null || FrsGoodFragment.this.hSt.getThreadList().size() == 0) {
                FrsGoodFragment.this.imV.bGU();
            } else {
                FrsGoodFragment.this.imV.bGT();
            }
            if (i == 4) {
                ArrayList<q> a2 = FrsGoodFragment.this.imU.a(false, false, false, FrsGoodFragment.this.hSt.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a2 != null) {
                    FrsGoodFragment.this.hSt.setThreadList(a2);
                    FrsGoodFragment.this.imV.a(a2, FrsGoodFragment.this.mPn, FrsGoodFragment.this.hSt, FrsGoodFragment.this.gRm);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.imV.cnf();
                    break;
                case 2:
                    FrsGoodFragment.this.imV.cnf();
                    break;
                case 3:
                    if (FrsGoodFragment.this.hSt.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.inc != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.hSt != null) {
                    FrsGoodFragment.this.hSN = FrsGoodFragment.this.hSt.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.hSt.getForum().getId();
                    FrsGoodFragment.this.imV.b(FrsGoodFragment.this.hSt.getForum(), FrsGoodFragment.this.hSt.getUserData());
                }
                if (FrsGoodFragment.this.hSt != null) {
                    FrsGoodFragment.this.hSt.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.imV.c(FrsGoodFragment.this.hSt);
                if (FrsGoodFragment.this.hSt == null || FrsGoodFragment.this.hSt.getThreadList() == null || FrsGoodFragment.this.hSt.getThreadList().size() != 0 || FrsGoodFragment.this.crl().getType() != 4) {
                    if (FrsGoodFragment.this.hSt != null && (a = FrsGoodFragment.this.imU.a(false, false, true, FrsGoodFragment.this.hSt.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a.size() > 0) {
                        FrsGoodFragment.this.hSt.setThreadList(a);
                    }
                    FrsGoodFragment.this.cmn();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.hvt > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.hvt, FrsGoodFragment.this.crl().cgb() - FrsGoodFragment.this.hvt, FrsGoodFragment.this.crl().cfZ(), FrsGoodFragment.this.crl().cga(), currentTimeMillis2 - FrsGoodFragment.this.crl().cfY());
                        FrsGoodFragment.this.hvt = -1L;
                    }
                    FrsGoodFragment.this.eRX = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.hvt > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.hvt, FrsGoodFragment.this.crl().cgb() - FrsGoodFragment.this.hvt, FrsGoodFragment.this.crl().cfZ(), FrsGoodFragment.this.crl().cga(), currentTimeMillis3 - FrsGoodFragment.this.crl().cfY());
                FrsGoodFragment.this.hvt = -1L;
            }
            FrsGoodFragment.this.eRX = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cmh() {
        }
    };
    private final CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.imV != null) {
                FrsGoodFragment.this.imV.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.hTh) {
                FrsGoodFragment.this.hTh = true;
                FrsGoodFragment.this.imV.cnu();
            }
            if (i == 0) {
                s.cbY().nm(true);
                com.baidu.tieba.s.c.dvJ().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.hTT += i2;
            if (FrsGoodFragment.this.hTT >= FrsGoodFragment.this.dhi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener eCw = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private ab hUG = new ab() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bv)) {
                bw bwVar = ((bv) qVar).dUW;
                if (bwVar.bfE() == null || bwVar.bfE().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bwVar.bfr() != 1 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.QX(bwVar.getId())) {
                            readThreadHistory.QW(bwVar.getId());
                            if (FrsGoodFragment.this.imV != null) {
                                FrsGoodFragment.this.imV.cnf();
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
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bwVar, FrsGoodFragment.this.hSN, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.hSt != null && FrsGoodFragment.this.hSt.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.iqZ = FrsGoodFragment.this.hSt.needLog == 1;
                            bVar.irb = FrsGoodFragment.this.hSt.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.icR != null) {
                                bVar.irc = com.baidu.tieba.frs.d.d.icR.irc;
                                bVar.ird = com.baidu.tieba.frs.d.d.icR.ird;
                            }
                            com.baidu.tieba.frs.d.a.a(bwVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hUK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.imV != null) {
                FrsGoodFragment.this.imV.EF();
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

    public void cpe() {
        if (this.imV != null) {
            this.imV.refreshView();
        }
    }

    private void showLoadingView() {
        this.imV.oF(false);
        showLoadingView(this.imV.bZc(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.imV.oF(true);
        hideLoadingView(this.imV.bZc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.imV.oF(false);
        this.imV.oE(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.imV.bGU();
        this.imV.getListView().getData().clear();
        this.imV.cnf();
        if (this.hZi == null) {
            this.hZi = new c(getPageContext().getContext(), getNetRefreshListener());
            this.hZi.setTitle(null);
            this.hZi.setButtonText(null);
            this.hZi.showRefreshButton();
            this.hZi.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.hZi.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.hZi.setSubText(null);
        }
        this.hZi.onChangeSkinType();
        this.hZi.attachView(this.imV.bZc(), true);
        registerListener(this.hWx);
    }

    private void bFX() {
        this.imV.oF(true);
        this.imV.oE(true);
        if (this.hZi != null && this.hZi.isViewAttached()) {
            this.hZi.dettachView(this.imV.bZc());
        }
        MessageManager.getInstance().unRegisterListener(this.hWx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(boolean z) {
        this.hpv = true;
        cms();
        bFX();
        if (!z) {
            bFX();
            showLoadingView();
        }
        this.imT.sD(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hvt = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.hvt = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.eRN = this.beginTime - this.hvt;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dvJ().A(getUniqueId());
        this.imT = new FrsGoodModelController(this);
        if (arguments != null) {
            this.imT.aj(arguments);
            this.imS = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.imT.aj(bundle);
            this.imS = bundle.getBoolean("is_game_frs", false);
        } else {
            this.imT.aj(null);
        }
        this.hSU = getVoiceManager();
        this.hSU.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.dUF);
        registerListener(this.imZ);
        registerListener(this.hUh);
        registerListener(this.hUK);
        this.imU = new FrsLoadMoreModel(this, null);
        this.imU.registerListener();
        this.imU.setPageType(2);
        this.imU.oY(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dhi = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.imV = new a(this, inflate, this.imS);
        this.imV.crp().crw();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.hpv) {
            if (j.isNetWorkAvailable()) {
                oW(false);
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
        this.hSU = getVoiceManager();
        this.hSU.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cri();
        if (bundle != null) {
            this.hSN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.hSN = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cri() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eCw);
    }

    public FrsLoadMoreModel crj() {
        return this.imU;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.imV != null) {
            this.imV.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hWx);
        com.baidu.tieba.s.c.dvJ().B(getUniqueId());
        s.cbY().nm(false);
        super.onDestroy();
        this.imT.crr();
        this.hSU = getVoiceManager();
        this.hSU.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.imY);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hSN);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.imS);
        this.imT.onSaveInstanceState(bundle);
        this.hSU = getVoiceManager();
        if (this.hSU != null) {
            this.hSU.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bw threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.imV.crp().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.hSt.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.nj(intent.getIntExtra("good_data", 0));
                            threadDataById.bfC();
                            oW(false);
                            return;
                        } else if (intExtra == 0) {
                            this.hSt.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.hSt.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.imV.crn();
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
            if (this.ibS == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.hpv) {
                com.baidu.adp.lib.f.e.mS().post(this.imY);
            }
        }
        cov();
    }

    private void cov() {
        if (isPrimary()) {
            if (this.hZi != null && this.hZi.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hWx);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hWx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.imV != null) {
            this.imV.cnf();
        }
        this.hSU = getVoiceManager();
        this.hSU.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.imW = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.imV.a(this.hUG);
        this.imV.setOnScrollListener(this.mScrollListener);
        this.imV.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.imW != null) {
                    FrsGoodFragment.this.imW.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ibS != 3 || this.imV != null) {
            this.ibS = i;
            super.onChangeSkinType(i);
            if (this.imV != null) {
                this.imV.onChangeSkinType(i);
            }
            if (this.hZi != null && this.hZi.isViewAttached()) {
                this.hZi.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> clg() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).clg();
        }
        return null;
    }

    private void cmm() {
        switch (this.mFlag) {
            case 1:
                h.mT().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.QR(FrsGoodFragment.this.hSN);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmn() {
        cms();
        try {
            if (this.hSt != null) {
                this.imV.coF();
                this.imV.bLt();
                this.hSN = this.hSt.getForum().getName();
                this.forumId = this.hSt.getForum().getId();
                if (this.hSt != null && this.hSt.getForum() != null) {
                    this.imV.a(this.hSt.getForum().getThemeColorInfo());
                    this.imV.c(this.hSt);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.hSt.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hSt.getUserData().getBimg_end_time());
                cmm();
                if (!this.imV.crp().s(bw.ebt)) {
                    this.hSt.removeAlaLiveThreadData();
                }
                ArrayList<q> threadList = this.hSt.getThreadList();
                if (threadList != null) {
                    this.imV.a(threadList, this.mPn, this.hSt, this.hSt.getPage().bdu());
                    crk();
                    this.imV.crn();
                    if (this.hSt.getIsNewUrl() == 1) {
                        this.imV.crp().setFromCDN(true);
                    } else {
                        this.imV.crp().setFromCDN(false);
                    }
                    this.imV.setListViewSelection(cr(crl().getType(), this.mPn));
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
        this.hSU = getVoiceManager();
        this.hSU.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.cbY().nm(false);
        com.baidu.tieba.s.c.dvJ().b(getUniqueId(), false);
        if (this.hSt != null && this.hSt.getForum() != null) {
            com.baidu.tbadk.distribute.a.brj().b(getPageContext().getPageActivity(), "frs", this.hSt.getForum().getId(), 0L);
        }
        this.hSU = getVoiceManager();
        if (this.hSU != null) {
            this.hSU.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yi(int i) {
        ArrayList<q> threadList = this.hSt.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).dUW;
                    if (bwVar.getId() != null && bwVar.getId().equals(this.imR)) {
                        c(bwVar, i);
                        this.imR = null;
                        break;
                    }
                }
            }
            this.imV.crp().b(threadList, this.hSt);
            this.imV.crp().notifyDataSetChanged();
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
        if (this.hSU == null) {
            this.hSU = VoiceManager.instance();
        }
        return this.hSU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView blc() {
        if (this.imV == null) {
            return null;
        }
        return this.imV.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cms() {
        this.hSU = getVoiceManager();
        this.hSU.stopPlay();
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
        if (this.hSt != null && this.imV != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.imV.cnf();
            }
        }
    }

    private void crk() {
        HashMap<Integer, bw> cpI;
        if (this.imV != null && this.imV.crp() != null && (cpI = this.imV.crp().cpI()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bw> entry : cpI.entrySet()) {
                bw value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.brp().L(arrayList);
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
            oW(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cmx() {
        return this.hSt;
    }

    public FrsGoodModelController crl() {
        return this.imT;
    }

    public void IM(String str) {
        this.hSN = str;
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
            this.imV.bGU();
        } else if (!this.imT.crv()) {
            this.imV.bGU();
        } else {
            bFT();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.imU.isLoading && !this.imT.isLoading()) {
                if (this.imU.cO(this.hSt.getThreadListIds())) {
                    this.imV.a(this.imU.crG(), this.mPn, this.hSt, 0);
                    this.imU.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.hSt.getThreadListIds(), this.hSN, this.mPn, this.hSt.isBrandForum);
                } else if (this.gRm != 0) {
                    this.imV.a(this.imU.crG(), this.mPn, this.hSt, 0);
                    this.mPn++;
                    this.imT.yk(this.mPn);
                    this.imU.loadingDone = false;
                    this.imU.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bFT();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void au(ArrayList<q> arrayList) {
        ArrayList<q> a;
        bFT();
        if (arrayList != null && arrayList.size() != 0 && (a = this.imU.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null)) != null) {
            this.hSt.setThreadList(a);
            this.imV.a(a, this.mPn, this.hSt, 0);
        }
    }

    private void bFT() {
        if (this.gRm == 0 && !this.imU.cO(this.hSt.getThreadListIds())) {
            if (this.hSt.getThreadList() == null || this.hSt.getThreadList().size() == 0) {
                this.imV.bGU();
            } else {
                this.imV.bGT();
            }
        } else if (y.getCount(this.hSt.getThreadList()) > 3) {
            this.imV.bGS();
        } else {
            this.imV.cnv();
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
        com.baidu.tbadk.distribute.a.brj().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void cmr() {
        if (this.imT != null) {
            this.imT.cmr();
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
    public NavigationBar bJI() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hSN;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hSt != null) {
            i = this.hSt.getSortType();
        }
        tbPageTag.sortType = g.yI(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yj(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            oW(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void clA() {
        if (this.imV != null && this.imV.getListView() != null) {
            this.imV.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bGR() {
        if (this.imV != null) {
            clA();
            this.imV.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hTv.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a rQ(int i) {
        return this.hTv.get(i);
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
            com.baidu.tieba.a.d.bAB().Dj("page_frs_good");
            oW(true);
            return;
        }
        this.imV.kh(false);
    }

    @Override // com.baidu.tieba.frs.au
    public void bkE() {
        com.baidu.tieba.s.c.dvJ().b(getUniqueId(), false);
    }

    public void a(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null && cmx() != null && cmx().getThreadList() != null) {
            if (y.isEmpty(cmx().getThreadList())) {
                cmx().getThreadList().add(asVar);
            } else {
                if (cmx().getThreadList().size() == 1 && (cmx().getThreadList().get(0) instanceof com.baidu.tieba.frs.s)) {
                    cmx().getThreadList().remove(0);
                }
                cmx().getThreadList().add(0, asVar);
            }
            this.imV.a(this.hSt.getThreadList(), this.mPn, this.hSt, this.hSt.getPage().bdu());
            this.imV.crn();
            this.imV.setListViewSelection(0);
        }
    }
}
