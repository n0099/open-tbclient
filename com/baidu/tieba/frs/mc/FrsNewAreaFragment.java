package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.t;
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
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes22.dex */
public class FrsNewAreaFragment extends BaseFragment implements ActivityCompat.OnRequestPermissionsResultCallback, BdListView.e, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, as, at, au, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.recapp.n, FrsCommonImageLayout.c {
    private String iJb;
    private FrsLoadMoreModel iJe;
    private FrsNewAreaModelController iLz;
    private VoiceManager ioV;
    private com.baidu.tbadk.k.c ivj;
    private String ioO = null;
    private String mFrom = null;
    private int mFlag = 0;
    private int mPn = 1;
    private String forumId = null;
    private FrsViewData iou = new FrsViewData();
    public long hRt = -1;
    public long fgM = 0;
    public long fgW = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean ipi = false;
    protected g iLA = null;
    private int hjS = -1;
    private int ixT = 3;
    private boolean hLu = false;
    private boolean iJh = false;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> ipw = new SparseArray<>();
    private int dvr = 0;
    private int ipU = 0;
    private CustomMessageListener isy = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsNewAreaFragment.this.ivj != null && FrsNewAreaFragment.this.ivj.isViewAttached()) {
                FrsNewAreaFragment.this.ivj.rh(num.intValue());
            }
        }
    };
    private Runnable iJi = new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || FrsNewAreaFragment.this.hLu) {
                FrsNewAreaFragment.this.c((com.baidu.tieba.tbadkCore.f) null);
            } else {
                FrsNewAreaFragment.this.pH(false);
            }
        }
    };
    private CustomMessageListener iJj = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw)) {
                bw bwVar = (bw) customResponsedMessage.getData();
                FrsNewAreaFragment.this.iJb = bwVar.getId();
                if (!TextUtils.isEmpty(FrsNewAreaFragment.this.iJb) && bwVar.bhS() != null) {
                    FrsNewAreaFragment.this.zn(bwVar.bhS().getIsLike());
                }
            }
        }
    };
    private CustomMessageListener iqi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                    if (FrsNewAreaFragment.this.boH() != null) {
                        FrsNewAreaFragment.this.boH().setSelection(0);
                    }
                    if (FrsNewAreaFragment.this.ivj != null && FrsNewAreaFragment.this.ivj.isViewAttached()) {
                        FrsNewAreaFragment.this.pH(false);
                    } else if (FrsNewAreaFragment.this.iLA != null) {
                        FrsNewAreaFragment.this.iLA.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    public final r iqA = new r() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.8
        private long iJm = 1;

        @Override // com.baidu.tieba.tbadkCore.r
        public void ya(int i) {
            if (!FrsNewAreaFragment.this.iJh) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsNewAreaFragment.this.iLA.ctP();
                        return;
                    case 3:
                        FrsNewAreaFragment.this.iLA.kG(true);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            ArrayList<q> a2;
            if (FrsNewAreaFragment.this.iJh) {
                if (FrsNewAreaFragment.this.cyV().cyf() == null) {
                    FrsNewAreaFragment.this.iJh = false;
                    return;
                } else if (FrsNewAreaFragment.this.cyV().cyf().getThreadList().size() >= 10) {
                    FrsNewAreaFragment.this.iJh = false;
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
                FrsNewAreaFragment.this.iJe.resetData();
            }
            FrsNewAreaFragment.this.iLA.kG(false);
            if (FrsNewAreaFragment.this.cyV().cyf() != null) {
                FrsNewAreaFragment.this.iou = FrsNewAreaFragment.this.cyV().cyf();
            }
            FrsNewAreaFragment.this.hjS = FrsNewAreaFragment.this.iou.getPage().bgX();
            if (FrsNewAreaFragment.this.hjS == 0 && (FrsNewAreaFragment.this.iou.getThreadListIds() == null || FrsNewAreaFragment.this.iou.getThreadListIds().size() == 0)) {
                if (FrsNewAreaFragment.this.iou.getThreadList() == null || FrsNewAreaFragment.this.iou.getThreadList().size() == 0) {
                    FrsNewAreaFragment.this.iLA.bKU();
                } else {
                    FrsNewAreaFragment.this.iLA.SJ();
                }
            } else {
                FrsNewAreaFragment.this.iLA.SI();
            }
            if (i == 4) {
                ArrayList<q> a3 = FrsNewAreaFragment.this.iJe.a(false, false, false, FrsNewAreaFragment.this.iou.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null);
                if (a3 != null) {
                    FrsNewAreaFragment.this.iou.setThreadList(a3);
                    FrsNewAreaFragment.this.iLA.a(a3, FrsNewAreaFragment.this.mPn, FrsNewAreaFragment.this.iou, FrsNewAreaFragment.this.hjS);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsNewAreaFragment.this.iLA.ctP();
                    break;
                case 2:
                    FrsNewAreaFragment.this.iLA.ctP();
                    break;
                case 3:
                    if (FrsNewAreaFragment.this.iou.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, true));
                        break;
                    }
                    break;
            }
            FrsNewAreaFragment.this.hideLoadingView();
            if (this.iJm != 0) {
                FrsNewAreaFragment.this.c(fVar);
            } else {
                if (FrsNewAreaFragment.this.iou != null) {
                    FrsNewAreaFragment.this.ioO = FrsNewAreaFragment.this.iou.getForum().getName();
                    FrsNewAreaFragment.this.forumId = FrsNewAreaFragment.this.iou.getForum().getId();
                    FrsNewAreaFragment.this.iLA.b(FrsNewAreaFragment.this.iou.getForum(), FrsNewAreaFragment.this.iou.getUserData());
                }
                if (FrsNewAreaFragment.this.iou != null) {
                    FrsNewAreaFragment.this.iou.addNoticeThreadToThreadList();
                }
                if (FrsNewAreaFragment.this.iou == null || FrsNewAreaFragment.this.iou.getThreadList() == null || FrsNewAreaFragment.this.iou.getThreadList().size() != 0 || FrsNewAreaFragment.this.cyV().getType() != 4) {
                    if (FrsNewAreaFragment.this.iou != null && (a2 = FrsNewAreaFragment.this.iJe.a(false, false, true, FrsNewAreaFragment.this.iou.getThreadList(), (com.baidu.tieba.tbadkCore.data.f) null)) != null && a2.size() > 0) {
                        FrsNewAreaFragment.this.iou.setThreadList(a2);
                    }
                    FrsNewAreaFragment.this.csX();
                } else {
                    FrsNewAreaFragment.this.showToast(FrsNewAreaFragment.this.getPageContext().getString(R.string.no_more_to_load));
                    if (FrsNewAreaFragment.this.mPn > 1) {
                        FrsNewAreaFragment.k(FrsNewAreaFragment.this);
                    }
                    if (FrsNewAreaFragment.this.hRt > -1) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis2 - FrsNewAreaFragment.this.hRt, FrsNewAreaFragment.this.cyV().cmO() - FrsNewAreaFragment.this.hRt, FrsNewAreaFragment.this.cyV().cmM(), FrsNewAreaFragment.this.cyV().cmN(), currentTimeMillis2 - FrsNewAreaFragment.this.cyV().cmL());
                        FrsNewAreaFragment.this.hRt = -1L;
                    }
                    FrsNewAreaFragment.this.fgW = System.currentTimeMillis() - currentTimeMillis;
                    return;
                }
            }
            if (FrsNewAreaFragment.this.hRt > -1) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis3 - FrsNewAreaFragment.this.hRt, FrsNewAreaFragment.this.cyV().cmO() - FrsNewAreaFragment.this.hRt, FrsNewAreaFragment.this.cyV().cmM(), FrsNewAreaFragment.this.cyV().cmN(), currentTimeMillis3 - FrsNewAreaFragment.this.cyV().cmL());
                FrsNewAreaFragment.this.hRt = -1L;
            }
            FrsNewAreaFragment.this.fgW = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void csR() {
        }
    };
    private final CustomMessageListener eiR = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsNewAreaFragment.this.iLA != null) {
                FrsNewAreaFragment.this.iLA.startPullRefresh();
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.11
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 2 || i == 1) && !FrsNewAreaFragment.this.ipi) {
                FrsNewAreaFragment.this.ipi = true;
                FrsNewAreaFragment.this.iLA.cue();
            }
            if (i == 0) {
                s.ciJ().nX(true);
                com.baidu.tieba.s.c.dDn().b(FrsNewAreaFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsNewAreaFragment.this.ipU += i2;
            if (FrsNewAreaFragment.this.ipU >= FrsNewAreaFragment.this.dvr * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private final CustomMessageListener eQI = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.3
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                FrsNewAreaFragment.this.f(customResponsedMessage);
            }
        }
    };
    private ab iqH = new ab() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4
        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && qVar != null && (qVar instanceof bv)) {
                bw bwVar = ((bv) qVar).eji;
                if (bwVar.bjh() == null || bwVar.bjh().getGroup_id() == 0 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                    if (bwVar.biU() != 1 || bg.checkUpIsLogin(FrsNewAreaFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.Sl(bwVar.getId())) {
                            readThreadHistory.Sk(bwVar.getId());
                            if (FrsNewAreaFragment.this.iLA != null) {
                                FrsNewAreaFragment.this.iLA.ctP();
                            }
                        }
                        boolean z = false;
                        final String bin = bwVar.bin();
                        if (bin != null && !bin.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aa aaVar = new aa(bin);
                                    aaVar.bmu().bna().mIsNeedAddCommenParam = false;
                                    aaVar.bmu().bna().mIsUseCurrentBDUSS = false;
                                    aaVar.getNetData();
                                }
                            }).start();
                        }
                        String tid = bwVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bwVar.bic() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            be.bmY().b(FrsNewAreaFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                            bwVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsNewAreaFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bwVar, FrsNewAreaFragment.this.ioO, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsNewAreaFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                        if (FrsNewAreaFragment.this.iou != null && FrsNewAreaFragment.this.iou.getForum() != null) {
                            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                            bVar.iNi = FrsNewAreaFragment.this.iou.needLog == 1;
                            bVar.iNk = FrsNewAreaFragment.this.iou.getForum().getId();
                            bVar.iNj = FrsNewAreaFragment.this.iLz.cyJ();
                            if (com.baidu.tieba.frs.d.d.iyS != null) {
                                bVar.iNl = com.baidu.tieba.frs.d.d.iyS.iNl;
                                bVar.iNm = com.baidu.tieba.frs.d.d.iyS.iNm;
                            }
                            com.baidu.tieba.frs.d.a.a(bwVar, 1, FrsNewAreaFragment.this.getUniqueId(), bVar, FrsNewAreaFragment.this.getTbPageTag());
                        }
                    }
                }
            }
        }
    };

    static /* synthetic */ int k(FrsNewAreaFragment frsNewAreaFragment) {
        int i = frsNewAreaFragment.mPn;
        frsNewAreaFragment.mPn = i - 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public void an(bw bwVar) {
        if (bwVar != null) {
            this.iLz.an(bwVar);
            this.iLA.csk();
        }
    }

    public void e(FrsViewData frsViewData) {
        if (frsViewData != null) {
            this.iou = frsViewData;
            hideLoadingView(this.iLA.cew());
            if (this.iLA != null) {
                this.iLA.kG(false);
                this.iLA.a(null, this.mPn, this.iou, this.hjS);
            }
        }
    }

    private void showLoadingView() {
        this.iLA.pq(false);
        showLoadingView(this.iLA.cew(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.iLA.pq(true);
        hideLoadingView(this.iLA.cew());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.f fVar) {
        this.iLA.pq(false);
        this.iLA.pp(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.iLA.bKU();
        this.iLA.getListView().getData().clear();
        this.iLA.ctP();
        if (this.ivj == null) {
            this.ivj = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
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
        this.ivj.attachView(this.iLA.cew(), true);
        registerListener(this.isy);
    }

    private void SK() {
        this.iLA.pq(true);
        this.iLA.pp(true);
        if (this.ivj != null && this.ivj.isViewAttached()) {
            this.ivj.dettachView(this.iLA.cew());
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
        this.iLz.loadData();
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
            this.forumId = arguments.getString("forum_id", "");
        }
        this.beginTime = System.currentTimeMillis();
        this.fgM = this.beginTime - this.hRt;
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dDn().z(getUniqueId());
        this.iLz = new FrsNewAreaModelController(this);
        if (arguments != null) {
            this.iLz.aj(arguments);
        } else if (bundle != null) {
            this.iLz.aj(bundle);
        } else {
            this.iLz.aj(null);
        }
        this.ioV = getVoiceManager();
        this.ioV.onCreate(getPageContext());
        initData(bundle);
        registerListener(this.eiR);
        registerListener(this.iJj);
        registerListener(this.iqi);
        this.iJe = new FrsLoadMoreModel(this, null);
        this.iJe.registerListener();
        this.iJe.setPageType(3);
        this.iJe.pJ(true);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dvr = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
        this.iLA = new g(this, inflate);
        initUI();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (!this.hLu) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                pH(false);
            } else {
                c((com.baidu.tieba.tbadkCore.f) null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bmR();
    }

    private void bmR() {
        aq aqVar = new aq("c13008");
        aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dK("fid", this.forumId);
        aqVar.aj("obj_type", 6);
        aqVar.aj("obj_locate", 2);
        aqVar.bmR();
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

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.iLA != null) {
            this.iLA.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.isy);
        com.baidu.tieba.s.c.dDn().A(getUniqueId());
        s.ciJ().nX(false);
        super.onDestroy();
        this.iLz.cyd();
        this.ioV = getVoiceManager();
        this.ioV.onDestory(getPageContext());
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iJi);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.ioO);
        bundle.putString("from", this.mFrom);
        this.iLz.onSaveInstanceState(bundle);
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
                    this.iLA.cyX().notifyDataSetChanged();
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
                            this.iLA.cxZ();
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
        if (this.iLA != null) {
            this.iLA.ctP();
        }
        this.ioV = getVoiceManager();
        this.ioV.onResume(getPageContext());
    }

    private void initUI() {
        if (this.mFlag != 0) {
            this.mFlag = 1;
        }
        this.iLA.a(this.iqH);
        this.iLA.setOnScrollListener(this.mScrollListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ixT != 3 || this.iLA != null) {
            this.ixT = i;
            super.onChangeSkinType(i);
            if (this.iLA != null) {
                this.iLA.onChangeSkinType(i);
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
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Sf(FrsNewAreaFragment.this.ioO);
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
                this.iLA.cvq();
                this.iLA.bPU();
                this.ioO = this.iou.getForum().getName();
                this.forumId = this.iou.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.iou.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iou.getUserData().getBimg_end_time());
                csW();
                ArrayList<q> threadList = this.iou.getThreadList();
                if (threadList != null) {
                    this.iLA.a(threadList, this.mPn, this.iou, this.iou.getPage().bgX());
                    cxW();
                    this.iLA.cxZ();
                    if (this.iou.getIsNewUrl() == 1) {
                        this.iLA.cyX().setFromCDN(true);
                    } else {
                        this.iLA.cyX().setFromCDN(false);
                    }
                    this.iLA.setListViewSelection(cu(cyV().getType(), this.mPn));
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

    public void cvO() {
        if (this.iLA != null && this.iLA.getListView() != null) {
            this.iLA.getListView().post(new Runnable() { // from class: com.baidu.tieba.frs.mc.FrsNewAreaFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsNewAreaFragment.this.iLA != null && FrsNewAreaFragment.this.iLA.getListView() != null && !FrsNewAreaFragment.this.iLA.getListView().isComputingLayout()) {
                        FrsNewAreaFragment.this.iLA.refreshView();
                    }
                }
            });
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
            this.iLA.cyX().b(threadList, this.iou);
            this.iLA.cyX().notifyDataSetChanged();
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
        if (this.iLA == null) {
            return null;
        }
        return this.iLA.getListView();
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
        if (this.iou != null && this.iLA != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.iLA.ctP();
            }
        }
    }

    private void cxW() {
        HashMap<Integer, bw> cws;
        if (this.iLA != null && this.iLA.cyX() != null && (cws = this.iLA.cyX().cws()) != null) {
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
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            pH(false);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cth() {
        return this.iou;
    }

    public FrsNewAreaModelController cyV() {
        return this.iLz;
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

    public void bJG() {
        if (!this.iJe.isLoading && !this.iLz.isLoading()) {
            if (this.iJe.cX(this.iou.getThreadListIds())) {
                this.iLA.a(this.iJe.cys(), this.mPn, this.iou, 0);
                this.iJe.a(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L), this.iou.getThreadListIds(), this.ioO, this.mPn, this.iou.isBrandForum);
            } else if (this.hjS != 0) {
                this.iLA.a(this.iJe.cys(), this.mPn, this.iou, 0);
                this.mPn++;
                this.iLz.zp(this.mPn);
                this.iJe.loadingDone = false;
                this.iJe.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.iLA.bKU();
        } else if (!this.iLA.ctY()) {
            if (!this.iLz.cyh()) {
                this.iLA.bKU();
                return;
            }
            bJV();
            bJG();
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
                this.iLA.a(a2, this.mPn, this.iou, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iou.getForum()));
        }
    }

    public void cY(List<String> list) {
        cM(list);
        int i = 0;
        Iterator<q> it = this.iou.getThreadList().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                i = i2;
                break;
            }
            i = it.next() instanceof bv ? i2 + 1 : i2;
            if (i >= 6) {
                break;
            }
        }
        if (i < 6) {
            bJG();
        }
    }

    private void cM(List<String> list) {
        if (!y.isEmpty(list)) {
            ArrayList<q> threadList = this.iou.getThreadList();
            if (!y.isEmpty(threadList) && this.iLA.getListView() != null && this.iLA.getListView().getData() != null) {
                Iterator<q> it = threadList.iterator();
                List<q> data = this.iLA.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).eji;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iJe.d(next);
                                this.iLA.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public FrsLoadMoreModel cxV() {
        return this.iJe;
    }

    private void bJV() {
        if (this.hjS == 0 && !this.iJe.cX(this.iou.getThreadListIds())) {
            if (this.iou.getThreadList() == null || this.iou.getThreadList().size() == 0) {
                this.iLA.bKU();
                return;
            } else {
                this.iLA.SJ();
                return;
            }
        }
        this.iLA.SI();
    }

    public g cyW() {
        return this.iLA;
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
        if (this.iLz != null) {
            this.iLz.ctb();
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

    @Override // com.baidu.tieba.frs.as
    public void csk() {
        if (this.iLA != null && this.iLA.getListView() != null) {
            this.iLA.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bKT() {
        if (this.iLA != null) {
            csk();
            this.iLA.startPullRefresh();
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.iou != null) {
            i = this.iou.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.i.zN(i);
        tbPageTag.locatePage = "a071";
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.au
    public void boi() {
        if (getPageContext() != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        }
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.tieba.a.d.bEz().Er("page_frs_good");
            pH(true);
            return;
        }
        this.iLA.kG(false);
    }

    @Override // com.baidu.tieba.frs.au
    public void boj() {
        com.baidu.tieba.s.c.dDn().b(getUniqueId(), false);
    }
}
