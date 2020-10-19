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
/* loaded from: classes22.dex */
public class FrsGoodFragment extends BaseFragment implements BdListView.e, a.InterfaceC0224a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, as, at, au, com.baidu.tieba.frs.loadmore.a, n, FrsCommonImageLayout.c {
    private String iJb;
    private FrsGoodModelController iJd;
    private FrsLoadMoreModel iJe;
    private com.baidu.tieba.frs.gametab.b iJg;
    private VoiceManager ioV;
    private c ivj;
    private String mForumId;
    private String ioO = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private boolean iJc = false;
    private String forumId = null;
    private FrsViewData iou = new FrsViewData();
    public long hRt = -1;
    public long fgM = 0;
    public long fgW = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean ipi = false;
    protected a iJf = null;
    private int hjS = -1;
    private int mTabId = 0;
    private int ixT = 3;
    private boolean hLu = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> ipw = new SparseArray<>();
    private boolean iJh = false;
    private int dvr = 0;
    private int ipU = 0;
    private CustomMessageListener isy = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsGoodFragment.this.ivj != null && FrsGoodFragment.this.ivj.isViewAttached()) {
                FrsGoodFragment.this.ivj.rh(num.intValue());
            }
        }
    };
    private Runnable iJi = new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.6
        @Override // java.lang.Runnable
        public void run() {
            if (!j.isNetWorkAvailable() || FrsGoodFragment.this.hLu) {
                FrsGoodFragment.this.c((f) null);
            } else {
                FrsGoodFragment.this.pH(false);
            }
        }
    };
    private CustomMessageListener iJj = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                bw bwVar = (bw) customResponsedMessage.getData();
                FrsGoodFragment.this.iJb = bwVar.getId();
                if (!TextUtils.isEmpty(FrsGoodFragment.this.iJb) && bwVar.bhS() != null) {
                    FrsGoodFragment.this.zn(bwVar.bhS().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener iqi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                    if (FrsGoodFragment.this.boH() != null) {
                        FrsGoodFragment.this.boH().setSelection(0);
                    }
                    if (FrsGoodFragment.this.ivj != null && FrsGoodFragment.this.ivj.isViewAttached()) {
                        FrsGoodFragment.this.pH(false);
                    } else if (FrsGoodFragment.this.iJf != null) {
                        FrsGoodFragment.this.iJf.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final r iqA = new r() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.9
        private long iJm = 1;

        @Override // com.baidu.tieba.tbadkCore.r
        public void ya(int i) {
            if (!FrsGoodFragment.this.iJh) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsGoodFragment.this.iJf.ctP();
                        return;
                    case 3:
                        FrsGoodFragment.this.iJf.kG(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, f fVar) {
            ArrayList<q> a2;
            if (FrsGoodFragment.this.iJh) {
                if (FrsGoodFragment.this.cxX().cyf() == null) {
                    FrsGoodFragment.this.iJh = false;
                    return;
                } else if (FrsGoodFragment.this.cxX().cyf().getThreadList().size() >= 10) {
                    FrsGoodFragment.this.iJh = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384));
                    return;
                }
            }
            if (fVar == null) {
                this.iJm = 1L;
            } else if (fVar.isSuccess) {
                this.iJm = 0L;
            } else {
                this.iJm = 1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 3) {
                FrsGoodFragment.this.iJe.resetData();
            }
            FrsGoodFragment.this.iJf.kG(false);
            if (FrsGoodFragment.this.cxX().cyf() != null) {
                FrsGoodFragment.this.iou = FrsGoodFragment.this.cxX().cyf();
            }
            FrsGoodFragment.this.hjS = FrsGoodFragment.this.iou.getPage().bgX();
            if (FrsGoodFragment.this.hjS != 0 || (FrsGoodFragment.this.iou.getThreadListIds() != null && FrsGoodFragment.this.iou.getThreadListIds().size() != 0)) {
                if (y.getCount(FrsGoodFragment.this.iou.getThreadList()) > 3) {
                    FrsGoodFragment.this.iJf.SI();
                } else {
                    FrsGoodFragment.this.iJf.cuf();
                }
            } else if (FrsGoodFragment.this.iou.getThreadList() == null || FrsGoodFragment.this.iou.getThreadList().size() == 0) {
                FrsGoodFragment.this.iJf.bKU();
            } else {
                FrsGoodFragment.this.iJf.SJ();
            }
            if (i == 4) {
                ArrayList<q> a3 = FrsGoodFragment.this.iJe.a(false, false, false, FrsGoodFragment.this.iou.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsGoodFragment.this.iou.setThreadList(a3);
                    FrsGoodFragment.this.iJf.a(a3, FrsGoodFragment.this.mPn, FrsGoodFragment.this.iou, FrsGoodFragment.this.hjS);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsGoodFragment.this.iJf.ctP();
                    break;
                case 2:
                    FrsGoodFragment.this.iJf.ctP();
                    break;
                case 3:
                    if (FrsGoodFragment.this.iou.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsGoodFragment.this.hideLoadingView();
            if (this.iJm != 0) {
                FrsGoodFragment.this.c(fVar);
            } else {
                if (FrsGoodFragment.this.iou != null) {
                    FrsGoodFragment.this.ioO = FrsGoodFragment.this.iou.getForum().getName();
                    FrsGoodFragment.this.forumId = FrsGoodFragment.this.iou.getForum().getId();
                    FrsGoodFragment.this.iJf.b(FrsGoodFragment.this.iou.getForum(), FrsGoodFragment.this.iou.getUserData());
                }
                if (FrsGoodFragment.this.iou != null) {
                    FrsGoodFragment.this.iou.addNoticeThreadToThreadList();
                }
                FrsGoodFragment.this.iJf.c(FrsGoodFragment.this.iou);
                if (FrsGoodFragment.this.iou == null || FrsGoodFragment.this.iou.getThreadList() == null || FrsGoodFragment.this.iou.getThreadList().size() != 0 || FrsGoodFragment.this.cxX().getType() != 4) {
                    if (FrsGoodFragment.this.iou != null && (a2 = FrsGoodFragment.this.iJe.a(false, false, true, FrsGoodFragment.this.iou.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsGoodFragment.this.iou.setThreadList(a2);
                    }
                    FrsGoodFragment.this.csX();
                } else {
                    FrsGoodFragment.this.showToast(FrsGoodFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsGoodFragment.this.mPn > 1) {
                        FrsGoodFragment.j(FrsGoodFragment.this);
                    }
                    if (FrsGoodFragment.this.hRt > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsGoodFragment.this.hRt, FrsGoodFragment.this.cxX().cmO() - FrsGoodFragment.this.hRt, FrsGoodFragment.this.cxX().cmM(), FrsGoodFragment.this.cxX().cmN(), currentTimeMillis2 - FrsGoodFragment.this.cxX().cmL());
                        FrsGoodFragment.this.hRt = -1L;
                    }
                    FrsGoodFragment.this.fgW = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsGoodFragment.this.hRt > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsGoodFragment.this.hRt, FrsGoodFragment.this.cxX().cmO() - FrsGoodFragment.this.hRt, FrsGoodFragment.this.cxX().cmM(), FrsGoodFragment.this.cxX().cmN(), currentTimeMillis3 - FrsGoodFragment.this.cxX().cmL());
                FrsGoodFragment.this.hRt = -1L;
            }
            FrsGoodFragment.this.fgW = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void csR() {
        }
    };
    private final CustomMessageListener eiR = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsGoodFragment.this.iJf != null) {
                FrsGoodFragment.this.iJf.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsGoodFragment.this.ipi) {
                FrsGoodFragment.this.ipi = true;
                FrsGoodFragment.this.iJf.cue();
            }
            if (i == 0) {
                s.ciJ().nX(true);
                com.baidu.tieba.s.c.dDn().b(FrsGoodFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsGoodFragment.this.ipU += i2;
            if (FrsGoodFragment.this.ipU >= FrsGoodFragment.this.dvr * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener eQI = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.3
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
    private ab iqH = new ab() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bv)) {
                bw bwVar = ((bv) qVar).eji;
                if (bwVar.bjh() == null || bwVar.bjh().getGroup_id() == 0 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                    if (bwVar.biU() != 1 || bg.checkUpIsLogin(FrsGoodFragment.this.getActivity())) {
                        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Sl(bwVar.getId())) {
                            readThreadHistory.Sk(bwVar.getId());
                            if (FrsGoodFragment.this.iJf != null) {
                                FrsGoodFragment.this.iJf.ctP();
                            }
                        }
                        boolean z = false;
                        final String bin = bwVar.bin();
                        if (bin != null && !bin.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(bin);
                                    aaVar.bmu().bna().mIsNeedAddCommenParam = false;
                                    aaVar.bmu().bna().mIsUseCurrentBDUSS = false;
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
                        if (bwVar.bic() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.bmY().b(FrsGoodFragment.this.getPageContext(), new String[]{str, "", null});
                            return;
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3 && str.length() > 3) {
                            bwVar.setId(str.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGoodFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bwVar, FrsGoodFragment.this.ioO, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsGoodFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsGoodFragment.this.iou != null && FrsGoodFragment.this.iou.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.iNi = FrsGoodFragment.this.iou.needLog == 1;
                            bVar.iNk = FrsGoodFragment.this.iou.getForum().getId();
                            if (com.baidu.tieba.frs.d.d.iyS != null) {
                                bVar.iNl = com.baidu.tieba.frs.d.d.iyS.iNl;
                                bVar.iNm = com.baidu.tieba.frs.d.d.iyS.iNm;
                            }
                            com.baidu.tieba.frs.d.a.a(bwVar, 1, FrsGoodFragment.this.getUniqueId(), bVar, FrsGoodFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener iqL = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsGoodFragment.this.iJf != null) {
                FrsGoodFragment.this.iJf.FS();
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

    public void cvO() {
        if (this.iJf != null) {
            this.iJf.refreshView();
        }
    }

    private void showLoadingView() {
        this.iJf.pq(false);
        showLoadingView(this.iJf.cew(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.iJf.pq(true);
        hideLoadingView(this.iJf.cew());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        this.iJf.pq(false);
        this.iJf.pp(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.iJf.bKU();
        this.iJf.getListView().getData().clear();
        this.iJf.ctP();
        if (this.ivj == null) {
            this.ivj = new c(getPageContext().getContext(), getNetRefreshListener());
            this.ivj.setTitle(null);
            this.ivj.setButtonText(null);
            this.ivj.showRefreshButton();
            this.ivj.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.ivj.setSubText(getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
        } else {
            this.ivj.setSubText(null);
        }
        this.ivj.onChangeSkinType();
        this.ivj.attachView(this.iJf.cew(), true);
        registerListener(this.isy);
    }

    private void SK() {
        this.iJf.pq(true);
        this.iJf.pp(true);
        if (this.ivj != null && this.ivj.isViewAttached()) {
            this.ivj.dettachView(this.iJf.cew());
        }
        MessageManager.getInstance().unRegisterListener(this.isy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pH(boolean z) {
        this.hLu = true;
        ctc();
        SK();
        if (!z) {
            SK();
            showLoadingView();
        }
        this.iJd.tt(this.mTabId);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hRt = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.hRt = System.currentTimeMillis();
        }
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.fgM = this.beginTime - this.hRt;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dDn().z(getUniqueId());
        this.iJd = new FrsGoodModelController(this);
        if (arguments != null) {
            this.iJd.aj(arguments);
            this.iJc = arguments.getBoolean("is_game_frs", false);
        } else if (bundle != null) {
            this.iJd.aj(bundle);
            this.iJc = bundle.getBoolean("is_game_frs", false);
        } else {
            this.iJd.aj(null);
        }
        this.ioV = getVoiceManager();
        this.ioV.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eiR);
        registerListener(this.iJj);
        registerListener(this.iqi);
        registerListener(this.iqL);
        this.iJe = new FrsLoadMoreModel(this, null);
        this.iJe.registerListener();
        this.iJe.setPageType(2);
        this.iJe.pJ(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dvr = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.iJf = new a(this, inflate, this.iJc);
        this.iJf.cyb().cyi();
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.hLu) {
            if (j.isNetWorkAvailable()) {
                pH(false);
            } else {
                c((f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new aq("c13008").dK("fid", this.mForumId).dK("obj_type", "7").aj("obj_locate", 2).dK("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.ioV = getVoiceManager();
        this.ioV.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        cxU();
        if (bundle != null) {
            this.ioO = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.ioO = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.mFlag = arguments.getInt(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void cxU() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eQI);
    }

    public FrsLoadMoreModel cxV() {
        return this.iJe;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.iJf != null) {
            this.iJf.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.isy);
        com.baidu.tieba.s.c.dDn().A(getUniqueId());
        s.ciJ().nX(false);
        super.onDestroy();
        this.iJd.cyd();
        this.ioV = getVoiceManager();
        this.ioV.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iJi);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.ioO);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean("is_game_frs", this.iJc);
        this.iJd.onSaveInstanceState(bundle);
        this.ioV = getVoiceManager();
        if (this.ioV != null) {
            this.ioV.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bw threadDataById;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    this.iJf.cyb().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (threadDataById = this.iou.getThreadDataById(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            threadDataById.nR(intent.getIntExtra("good_data", 0));
                            threadDataById.bjf();
                            pH(false);
                            return;
                        } else if (intExtra == 0) {
                            this.iou.removeThreadData(threadDataById);
                            ArrayList<q> threadList = this.iou.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new com.baidu.tieba.frs.s());
                            }
                            this.iJf.cxZ();
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
            if (this.ixT == 3) {
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (!this.hLu) {
                com.baidu.adp.lib.f.e.mY().post(this.iJi);
            }
        }
        cvg();
    }

    private void cvg() {
        if (isPrimary()) {
            if (this.ivj != null && this.ivj.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.isy);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.isy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iJf != null) {
            this.iJf.ctP();
        }
        this.ioV = getVoiceManager();
        this.ioV.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.iJg = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
        this.iJf.a(this.iqH);
        this.iJf.setOnScrollListener(this.mScrollListener);
        this.iJf.getListView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FrsGoodFragment.this.iJg != null) {
                    FrsGoodFragment.this.iJg.b(view, motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ixT != 3 || this.iJf != null) {
            this.ixT = i;
            super.onChangeSkinType(i);
            if (this.iJf != null) {
                this.iJf.onChangeSkinType(i);
            }
            if (this.ivj != null && this.ivj.isViewAttached()) {
                this.ivj.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> crR() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).crR();
        }
        return null;
    }

    private void csW() {
        switch (this.mFlag) {
            case 1:
                h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.good.FrsGoodFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Sf(FrsGoodFragment.this.ioO);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csX() {
        ctc();
        try {
            if (this.iou != null) {
                this.iJf.cvq();
                this.iJf.bPU();
                this.ioO = this.iou.getForum().getName();
                this.forumId = this.iou.getForum().getId();
                if (this.iou != null && this.iou.getForum() != null) {
                    this.iJf.a(this.iou.getForum().getThemeColorInfo());
                    this.iJf.c(this.iou);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.iou.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iou.getUserData().getBimg_end_time());
                csW();
                if (!this.iJf.cyb().r(bw.epI)) {
                    this.iou.removeAlaLiveThreadData();
                }
                ArrayList<q> threadList = this.iou.getThreadList();
                if (threadList != null) {
                    this.iJf.a(threadList, this.mPn, this.iou, this.iou.getPage().bgX());
                    cxW();
                    this.iJf.cxZ();
                    if (this.iou.getIsNewUrl() == 1) {
                        this.iJf.cyb().setFromCDN(true);
                    } else {
                        this.iJf.cyb().setFromCDN(false);
                    }
                    this.iJf.setListViewSelection(cu(cxX().getType(), this.mPn));
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
        this.ioV = getVoiceManager();
        this.ioV.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.ciJ().nX(false);
        com.baidu.tieba.s.c.dDn().b(getUniqueId(), false);
        if (this.iou != null && this.iou.getForum() != null) {
            com.baidu.tbadk.distribute.a.buS().b(getPageContext().getPageActivity(), "frs", this.iou.getForum().getId(), 0L);
        }
        this.ioV = getVoiceManager();
        if (this.ioV != null) {
            this.ioV.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zn(int i) {
        ArrayList<q> threadList = this.iou.getThreadList();
        if (threadList != null) {
            Iterator<q> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next instanceof bv) {
                    bw bwVar = ((bv) next).eji;
                    if (bwVar.getId() != null && bwVar.getId().equals(this.iJb)) {
                        c(bwVar, i);
                        this.iJb = null;
                        break;
                    }
                }
            }
            this.iJf.cyb().b(threadList, this.iou);
            this.iJf.cyb().notifyDataSetChanged();
        }
    }

    private void c(bw bwVar, int i) {
        if (i == 1) {
            PraiseData bhS = bwVar.bhS();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (bhS == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bwVar.a(praiseData);
                    return;
                }
                bwVar.bhS().getUser().add(0, metaData);
                bwVar.bhS().setNum(bwVar.bhS().getNum() + 1);
                bwVar.bhS().setIsLike(i);
            }
        } else if (bwVar.bhS() != null) {
            bwVar.bhS().setIsLike(i);
            bwVar.bhS().setNum(bwVar.bhS().getNum() - 1);
            ArrayList<MetaData> user = bwVar.bhS().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bwVar.bhS().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ioV == null) {
            this.ioV = VoiceManager.instance();
        }
        return this.ioV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView boH() {
        if (this.iJf == null) {
            return null;
        }
        return this.iJf.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ctc() {
        this.ioV = getVoiceManager();
        this.ioV.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> boI() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).boI();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.iou != null && this.iJf != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.iJf.ctP();
            }
        }
    }

    private void cxW() {
        HashMap<Integer, bw> cws;
        if (this.iJf != null && this.iJf.cyb() != null && (cws = this.iJf.cyb().cws()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, bw> entry : cws.entrySet()) {
                bw value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            com.baidu.tbadk.download.b.buY().L(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        if (boH() == null) {
            return null;
        }
        return boH().getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            pH(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cth() {
        return this.iou;
    }

    public FrsGoodModelController cxX() {
        return this.iJd;
    }

    public void JX(String str) {
        this.ioO = str;
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
            this.iJf.bKU();
        } else if (!this.iJd.cyh()) {
            this.iJf.bKU();
        } else {
            bJV();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (!this.iJe.isLoading && !this.iJd.isLoading()) {
                if (this.iJe.cX(this.iou.getThreadListIds())) {
                    this.iJf.a(this.iJe.cys(), this.mPn, this.iou, 0);
                    this.iJe.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.iou.getThreadListIds(), this.ioO, this.mPn, this.iou.isBrandForum);
                } else if (this.hjS != 0) {
                    this.iJf.a(this.iJe.cys(), this.mPn, this.iou, 0);
                    this.mPn++;
                    this.iJd.zp(this.mPn);
                    this.iJe.loadingDone = false;
                    this.iJe.loadIndex = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bJV();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void aw(ArrayList<q> arrayList) {
        bJV();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<q> a2 = this.iJe.a(false, false, false, arrayList, (com.baidu.tieba.tbadkCore.data.f) null);
            if (a2 != null) {
                this.iou.setThreadList(a2);
                this.iJf.a(a2, this.mPn, this.iou, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iou.getForum()));
        }
    }

    private void bJV() {
        if (this.hjS == 0 && !this.iJe.cX(this.iou.getThreadListIds())) {
            if (this.iou.getThreadList() == null || this.iou.getThreadList().size() == 0) {
                this.iJf.bKU();
            } else {
                this.iJf.SJ();
            }
        } else if (y.getCount(this.iou.getThreadList()) > 3) {
            this.iJf.SI();
        } else {
            this.iJf.cuf();
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0224a
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
        com.baidu.tbadk.distribute.a.buS().a(advertAppInfo, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.n
    public void ctb() {
        if (this.iJd != null) {
            this.iJd.ctb();
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
    public NavigationBar bNC() {
        return null;
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.ioO;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.iou != null) {
            i = this.iou.getSortType();
        }
        tbPageTag.sortType = i.zN(i);
        tbPageTag.locatePage = "a072";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zo(int i) {
        this.mTabId = i;
        if (j.isNetWorkAvailable()) {
            pH(false);
        } else {
            c((f) null);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void csk() {
        if (this.iJf != null && this.iJf.getListView() != null) {
            this.iJf.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bKT() {
        if (this.iJf != null) {
            csk();
            this.iJf.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.ipw.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sF(int i) {
        return this.ipw.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
    }

    @Override // com.baidu.tieba.frs.au
    public void boi() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bEz().Er("page_frs_good");
            pH(true);
            return;
        }
        this.iJf.kG(false);
    }

    @Override // com.baidu.tieba.frs.au
    public void boj() {
        com.baidu.tieba.s.c.dDn().b(getUniqueId(), false);
    }

    public void a(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null && cth() != null && cth().getThreadList() != null) {
            if (y.isEmpty(cth().getThreadList())) {
                cth().getThreadList().add(asVar);
            } else {
                if (cth().getThreadList().size() == 1 && (cth().getThreadList().get(0) instanceof com.baidu.tieba.frs.s)) {
                    cth().getThreadList().remove(0);
                }
                cth().getThreadList().add(0, asVar);
            }
            this.iJf.a(this.iou.getThreadList(), this.mPn, this.iou, this.iou.getPage().bgX());
            this.iJf.cxZ();
            this.iJf.setListViewSelection(0);
        }
    }
}
