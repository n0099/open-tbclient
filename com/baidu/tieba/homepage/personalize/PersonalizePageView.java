package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.BdToken.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.n.o;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.t;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.af;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.e;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.view.FollowUserButton;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes22.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager ekp;
    private int fAd;
    private final CustomMessageListener flC;
    private com.baidu.tbadk.l.g gAe;
    private PbListView gre;
    private int gtF;
    private n iDQ;
    private CustomMessageListener iDS;
    private boolean iTI;
    private int iTS;
    private CustomMessageListener iUI;
    private FollowUserButton.a jIG;
    private BdTypeRecyclerView jJH;
    private ScrollFragmentTabHost jJN;
    ScrollFragmentTabHost.a jJO;
    private BigdaySwipeRefreshLayout jJP;
    private View.OnClickListener jJR;
    private NEGFeedBackView.a jOX;
    f.b jPA;
    f.d jPz;
    private e.a jRA;
    f.c jRB;
    f.a jRC;
    private Runnable jRD;
    public CustomMessageListener jRE;
    private View.OnClickListener jRF;
    private com.baidu.tieba.homepage.personalize.bigday.b jRi;
    private com.baidu.tieba.homepage.personalize.bigday.a jRj;
    private a jRk;
    private af jRl;
    private com.baidu.tieba.homepage.framework.b jRm;
    private e jRn;
    private com.baidu.tieba.homepage.personalize.a jRo;
    private com.baidu.tieba.homepage.personalize.model.e jRp;
    private long jRq;
    private int jRr;
    private boolean jRs;
    private long jRt;
    private boolean jRu;
    private boolean jRv;
    private int jRw;
    private boolean jRx;
    private FRSRefreshButton jRy;
    private CustomMessageListener jRz;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes22.dex */
    public interface a {
        void a(f.a aVar);

        void a(f.b bVar);

        void a(f.d dVar);

        void setListPullRefreshListener(f.c cVar);
    }

    static /* synthetic */ int v(PersonalizePageView personalizePageView) {
        int i = personalizePageView.jRw + 1;
        personalizePageView.jRw = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jJN = scrollFragmentTabHost;
        if (this.jJN != null) {
            this.jJN.b(this.jJO);
            this.jJN.a(this.jJO);
        }
        if (this.jRn != null) {
            this.jRn.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jRo != null) {
            this.jRo.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.jJP != null) {
            this.jJP.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jRl != null) {
            this.jRl.setPageUniqueId(bdUniqueId);
        }
        if (this.jRn != null) {
            this.jRn.o(bdUniqueId);
        }
        if (this.jRp != null) {
            this.jRp.i(bdUniqueId);
        }
        if (this.jRj != null) {
            this.jRj.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.bmd().setTag(bdUniqueId);
        if (this.flC != null) {
            this.flC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.flC);
        }
        if (this.jRo != null) {
            this.jRo.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.jRq = 0L;
        this.mSkinType = 3;
        this.iTI = false;
        this.jRr = 0;
        this.jRs = false;
        this.jRt = -1L;
        this.jRu = false;
        this.jRv = false;
        this.jRw = 0;
        this.iTS = 0;
        this.jRx = false;
        this.fAd = 1;
        this.iDS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iDQ == null) {
                            PersonalizePageView.this.iDQ = new n(new l());
                        }
                        PersonalizePageView.this.iDQ.a(PersonalizePageView.this.jJH, 2);
                    } else if (PersonalizePageView.this.iDQ != null) {
                        PersonalizePageView.this.iDQ.rj();
                    }
                }
            }
        };
        this.jRz = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jRn != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bsb().bsc(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jOX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                if (atVar != null) {
                    TiebaStatic.log(new ar("c11693").dY("obj_locate", "1").dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("nid", atVar.getNid()));
                    TiebaStatic.log(new ar("c11989").dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
                int i = 0;
                if (arrayList != null && atVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (atVar.threadType == 0) {
                        i = 1;
                    } else if (atVar.threadType == 40) {
                        i = 2;
                    } else if (atVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.jRl != null) {
                        PersonalizePageView.this.jRl.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dY("tid", atVar.getTid()).dY("nid", atVar.getNid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", atVar.getFid()).dY("obj_param1", atVar.weight).dY("obj_source", atVar.source).dY("obj_id", atVar.extra).dY("obj_type", sb.toString()).dY("obj_name", str).al(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jIG = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof by) {
                        TiebaStatic.log(com.baidu.tieba.t.a.c("c13696", (by) tag));
                    }
                }
            }
        };
        this.gtF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gtF != i && PersonalizePageView.this.jJN != null) {
                    PersonalizePageView.this.gtF = i;
                    if (PersonalizePageView.this.gtF == 1) {
                        PersonalizePageView.this.jJN.bSu();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jJN.bSv();
                    } else {
                        PersonalizePageView.this.jJN.bSu();
                    }
                }
            }
        };
        this.jJO = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOF() {
                if (PersonalizePageView.this.jJN != null) {
                    PersonalizePageView.this.gtF = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jJH)) {
                        PersonalizePageView.this.jJN.bSv();
                    } else {
                        PersonalizePageView.this.jJN.bSu();
                    }
                }
            }
        };
        this.jRA = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iLL = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_first_install", true);

            private void cPK() {
                if (this.iLL) {
                    this.iLL = false;
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void T(int i, int i2, int i3) {
                if (PersonalizePageView.this.jRm == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqz = PersonalizePageView.this.cqz();
                PersonalizePageView.this.Yb();
                if (cqz) {
                    PersonalizePageView.this.ib(true);
                }
                PersonalizePageView.this.jRm.S(i, i2, i3);
                q.bjk().bjl();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jRm != null) {
                    PersonalizePageView.this.jRm.G(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cPK();
                } else if (!this.iLL) {
                    PersonalizePageView.this.jJP.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cPK();
                    PersonalizePageView.this.cOp();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void rD(boolean z) {
                cPK();
                PersonalizePageView.this.jJP.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Yb();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dQl().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.jRs = true;
                    PersonalizePageView.this.jRt = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cPL() {
                if (PersonalizePageView.this.gre != null) {
                    PersonalizePageView.this.gre.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gre.endLoadData();
                    PersonalizePageView.this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jRB = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bLT().Fn("page_recommend");
                PersonalizePageView.this.jRn.update();
                PersonalizePageView.this.jRn.rz(false);
                PersonalizePageView.this.jRx = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jPz = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jRn != null && PersonalizePageView.this.jRn.cDi() != null) {
                    PersonalizePageView.this.jRn.cDi().cPh();
                }
            }
        };
        this.jRC = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bvC() {
                if (PersonalizePageView.this.jRx) {
                    PersonalizePageView.this.iTS = 0;
                    PersonalizePageView.this.fAd = 1;
                    PersonalizePageView.this.jRx = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jPA = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jRn != null) {
                    PersonalizePageView.this.jRn.rz(true);
                    PersonalizePageView.this.jRn.cPQ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bmd().ok(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.jRD = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.flC = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                List<DownloadData> data;
                if (customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                    boolean z = false;
                    for (DownloadData downloadData : data) {
                        z = downloadData.getStatus() == 0 ? true : z;
                    }
                    if (z) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cNz();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jJR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRM();
            }
        };
        this.iUI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iTI = true;
                    }
                }
            }
        };
        this.jRE = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jJP != null && !PersonalizePageView.this.jJP.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jRj == null) {
                            PersonalizePageView.this.jRj = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jRj.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jRk = PersonalizePageView.this.jRj;
                            PersonalizePageView.this.cPF();
                        } else if (PersonalizePageView.this.jRk != PersonalizePageView.this.jRj) {
                            PersonalizePageView.this.jRk = PersonalizePageView.this.jRj;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jRj.setEnable(true);
                        PersonalizePageView.this.jJP.setProgressView(PersonalizePageView.this.jRj);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jJP.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jRi == null) {
                        PersonalizePageView.this.jRi = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jRk = PersonalizePageView.this.jRi;
                        PersonalizePageView.this.cPF();
                    } else if (PersonalizePageView.this.jRk != PersonalizePageView.this.jRi || !aVar.equals(PersonalizePageView.this.jRi.cQl())) {
                        PersonalizePageView.this.jRk = PersonalizePageView.this.jRi;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jRi.setEnable(true);
                    PersonalizePageView.this.jJP.setProgressView(PersonalizePageView.this.jRi);
                    PersonalizePageView.this.jRi.a(aVar);
                    PersonalizePageView.this.jJP.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jRF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jRy != null) {
                    PersonalizePageView.this.jRy.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jRq = 0L;
        this.mSkinType = 3;
        this.iTI = false;
        this.jRr = 0;
        this.jRs = false;
        this.jRt = -1L;
        this.jRu = false;
        this.jRv = false;
        this.jRw = 0;
        this.iTS = 0;
        this.jRx = false;
        this.fAd = 1;
        this.iDS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iDQ == null) {
                            PersonalizePageView.this.iDQ = new n(new l());
                        }
                        PersonalizePageView.this.iDQ.a(PersonalizePageView.this.jJH, 2);
                    } else if (PersonalizePageView.this.iDQ != null) {
                        PersonalizePageView.this.iDQ.rj();
                    }
                }
            }
        };
        this.jRz = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jRn != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bsb().bsc(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jOX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                if (atVar != null) {
                    TiebaStatic.log(new ar("c11693").dY("obj_locate", "1").dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("nid", atVar.getNid()));
                    TiebaStatic.log(new ar("c11989").dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
                int i = 0;
                if (arrayList != null && atVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (atVar.threadType == 0) {
                        i = 1;
                    } else if (atVar.threadType == 40) {
                        i = 2;
                    } else if (atVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.jRl != null) {
                        PersonalizePageView.this.jRl.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dY("tid", atVar.getTid()).dY("nid", atVar.getNid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", atVar.getFid()).dY("obj_param1", atVar.weight).dY("obj_source", atVar.source).dY("obj_id", atVar.extra).dY("obj_type", sb.toString()).dY("obj_name", str).al(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jIG = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof by) {
                        TiebaStatic.log(com.baidu.tieba.t.a.c("c13696", (by) tag));
                    }
                }
            }
        };
        this.gtF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gtF != i && PersonalizePageView.this.jJN != null) {
                    PersonalizePageView.this.gtF = i;
                    if (PersonalizePageView.this.gtF == 1) {
                        PersonalizePageView.this.jJN.bSu();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jJN.bSv();
                    } else {
                        PersonalizePageView.this.jJN.bSu();
                    }
                }
            }
        };
        this.jJO = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOF() {
                if (PersonalizePageView.this.jJN != null) {
                    PersonalizePageView.this.gtF = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jJH)) {
                        PersonalizePageView.this.jJN.bSv();
                    } else {
                        PersonalizePageView.this.jJN.bSu();
                    }
                }
            }
        };
        this.jRA = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iLL = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_first_install", true);

            private void cPK() {
                if (this.iLL) {
                    this.iLL = false;
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void T(int i, int i2, int i3) {
                if (PersonalizePageView.this.jRm == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqz = PersonalizePageView.this.cqz();
                PersonalizePageView.this.Yb();
                if (cqz) {
                    PersonalizePageView.this.ib(true);
                }
                PersonalizePageView.this.jRm.S(i, i2, i3);
                q.bjk().bjl();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jRm != null) {
                    PersonalizePageView.this.jRm.G(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cPK();
                } else if (!this.iLL) {
                    PersonalizePageView.this.jJP.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cPK();
                    PersonalizePageView.this.cOp();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void rD(boolean z) {
                cPK();
                PersonalizePageView.this.jJP.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Yb();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dQl().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.jRs = true;
                    PersonalizePageView.this.jRt = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cPL() {
                if (PersonalizePageView.this.gre != null) {
                    PersonalizePageView.this.gre.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gre.endLoadData();
                    PersonalizePageView.this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jRB = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bLT().Fn("page_recommend");
                PersonalizePageView.this.jRn.update();
                PersonalizePageView.this.jRn.rz(false);
                PersonalizePageView.this.jRx = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jPz = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jRn != null && PersonalizePageView.this.jRn.cDi() != null) {
                    PersonalizePageView.this.jRn.cDi().cPh();
                }
            }
        };
        this.jRC = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bvC() {
                if (PersonalizePageView.this.jRx) {
                    PersonalizePageView.this.iTS = 0;
                    PersonalizePageView.this.fAd = 1;
                    PersonalizePageView.this.jRx = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jPA = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jRn != null) {
                    PersonalizePageView.this.jRn.rz(true);
                    PersonalizePageView.this.jRn.cPQ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bmd().ok(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.jRD = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.flC = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                List<DownloadData> data;
                if (customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                    boolean z = false;
                    for (DownloadData downloadData : data) {
                        z = downloadData.getStatus() == 0 ? true : z;
                    }
                    if (z) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cNz();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jJR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRM();
            }
        };
        this.iUI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iTI = true;
                    }
                }
            }
        };
        this.jRE = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jJP != null && !PersonalizePageView.this.jJP.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jRj == null) {
                            PersonalizePageView.this.jRj = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jRj.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jRk = PersonalizePageView.this.jRj;
                            PersonalizePageView.this.cPF();
                        } else if (PersonalizePageView.this.jRk != PersonalizePageView.this.jRj) {
                            PersonalizePageView.this.jRk = PersonalizePageView.this.jRj;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jRj.setEnable(true);
                        PersonalizePageView.this.jJP.setProgressView(PersonalizePageView.this.jRj);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jJP.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jRi == null) {
                        PersonalizePageView.this.jRi = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jRk = PersonalizePageView.this.jRi;
                        PersonalizePageView.this.cPF();
                    } else if (PersonalizePageView.this.jRk != PersonalizePageView.this.jRi || !aVar.equals(PersonalizePageView.this.jRi.cQl())) {
                        PersonalizePageView.this.jRk = PersonalizePageView.this.jRi;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jRi.setEnable(true);
                    PersonalizePageView.this.jJP.setProgressView(PersonalizePageView.this.jRi);
                    PersonalizePageView.this.jRi.a(aVar);
                    PersonalizePageView.this.jJP.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jRF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jRy != null) {
                    PersonalizePageView.this.jRy.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jRq = 0L;
        this.mSkinType = 3;
        this.iTI = false;
        this.jRr = 0;
        this.jRs = false;
        this.jRt = -1L;
        this.jRu = false;
        this.jRv = false;
        this.jRw = 0;
        this.iTS = 0;
        this.jRx = false;
        this.fAd = 1;
        this.iDS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iDQ == null) {
                            PersonalizePageView.this.iDQ = new n(new l());
                        }
                        PersonalizePageView.this.iDQ.a(PersonalizePageView.this.jJH, 2);
                    } else if (PersonalizePageView.this.iDQ != null) {
                        PersonalizePageView.this.iDQ.rj();
                    }
                }
            }
        };
        this.jRz = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jRn != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bsb().bsc(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jOX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                if (atVar != null) {
                    TiebaStatic.log(new ar("c11693").dY("obj_locate", "1").dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("nid", atVar.getNid()));
                    TiebaStatic.log(new ar("c11989").dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
                int i2 = 0;
                if (arrayList != null && atVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        sb.append(arrayList.get(i22)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (atVar.threadType == 0) {
                        i2 = 1;
                    } else if (atVar.threadType == 40) {
                        i2 = 2;
                    } else if (atVar.threadType == 49) {
                        i2 = 3;
                    }
                    if (PersonalizePageView.this.jRl != null) {
                        PersonalizePageView.this.jRl.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dY("tid", atVar.getTid()).dY("nid", atVar.getNid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", atVar.getFid()).dY("obj_param1", atVar.weight).dY("obj_source", atVar.source).dY("obj_id", atVar.extra).dY("obj_type", sb.toString()).dY("obj_name", str).al(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.jIG = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof by) {
                        TiebaStatic.log(com.baidu.tieba.t.a.c("c13696", (by) tag));
                    }
                }
            }
        };
        this.gtF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.gtF != i2 && PersonalizePageView.this.jJN != null) {
                    PersonalizePageView.this.gtF = i2;
                    if (PersonalizePageView.this.gtF == 1) {
                        PersonalizePageView.this.jJN.bSu();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jJN.bSv();
                    } else {
                        PersonalizePageView.this.jJN.bSu();
                    }
                }
            }
        };
        this.jJO = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOF() {
                if (PersonalizePageView.this.jJN != null) {
                    PersonalizePageView.this.gtF = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jJH)) {
                        PersonalizePageView.this.jJN.bSv();
                    } else {
                        PersonalizePageView.this.jJN.bSu();
                    }
                }
            }
        };
        this.jRA = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iLL = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_first_install", true);

            private void cPK() {
                if (this.iLL) {
                    this.iLL = false;
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void T(int i2, int i22, int i3) {
                if (PersonalizePageView.this.jRm == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqz = PersonalizePageView.this.cqz();
                PersonalizePageView.this.Yb();
                if (cqz) {
                    PersonalizePageView.this.ib(true);
                }
                PersonalizePageView.this.jRm.S(i2, i22, i3);
                q.bjk().bjl();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.jRm != null) {
                    PersonalizePageView.this.jRm.G(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cPK();
                } else if (!this.iLL) {
                    PersonalizePageView.this.jJP.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cPK();
                    PersonalizePageView.this.cOp();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void rD(boolean z) {
                cPK();
                PersonalizePageView.this.jJP.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Yb();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dQl().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.jRs = true;
                    PersonalizePageView.this.jRt = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cPL() {
                if (PersonalizePageView.this.gre != null) {
                    PersonalizePageView.this.gre.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gre.endLoadData();
                    PersonalizePageView.this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jRB = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bLT().Fn("page_recommend");
                PersonalizePageView.this.jRn.update();
                PersonalizePageView.this.jRn.rz(false);
                PersonalizePageView.this.jRx = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jPz = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jRn != null && PersonalizePageView.this.jRn.cDi() != null) {
                    PersonalizePageView.this.jRn.cDi().cPh();
                }
            }
        };
        this.jRC = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bvC() {
                if (PersonalizePageView.this.jRx) {
                    PersonalizePageView.this.iTS = 0;
                    PersonalizePageView.this.fAd = 1;
                    PersonalizePageView.this.jRx = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jPA = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jRn != null) {
                    PersonalizePageView.this.jRn.rz(true);
                    PersonalizePageView.this.jRn.cPQ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bmd().ok(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.jRD = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.flC = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                List<DownloadData> data;
                if (customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                    boolean z = false;
                    for (DownloadData downloadData : data) {
                        z = downloadData.getStatus() == 0 ? true : z;
                    }
                    if (z) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cNz();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jJR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRM();
            }
        };
        this.iUI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iTI = true;
                    }
                }
            }
        };
        this.jRE = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jJP != null && !PersonalizePageView.this.jJP.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jRj == null) {
                            PersonalizePageView.this.jRj = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jRj.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jRk = PersonalizePageView.this.jRj;
                            PersonalizePageView.this.cPF();
                        } else if (PersonalizePageView.this.jRk != PersonalizePageView.this.jRj) {
                            PersonalizePageView.this.jRk = PersonalizePageView.this.jRj;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jRj.setEnable(true);
                        PersonalizePageView.this.jJP.setProgressView(PersonalizePageView.this.jRj);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jJP.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jRi == null) {
                        PersonalizePageView.this.jRi = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jRk = PersonalizePageView.this.jRi;
                        PersonalizePageView.this.cPF();
                    } else if (PersonalizePageView.this.jRk != PersonalizePageView.this.jRi || !aVar.equals(PersonalizePageView.this.jRi.cQl())) {
                        PersonalizePageView.this.jRk = PersonalizePageView.this.jRi;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jRi.setEnable(true);
                    PersonalizePageView.this.jJP.setProgressView(PersonalizePageView.this.jRi);
                    PersonalizePageView.this.jRi.a(aVar);
                    PersonalizePageView.this.jJP.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jRF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jRy != null) {
                    PersonalizePageView.this.jRy.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jJH = new BdTypeRecyclerView(context);
        this.ekp = new LinearLayoutManager(this.jJH.getContext());
        this.jJH.setLayoutManager(this.ekp);
        this.jJH.setFadingEdgeLength(0);
        this.jJH.setOverScrollMode(2);
        if (!com.baidu.tbadk.a.d.bkA()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.jJH.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        }
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iDQ = new n(new l());
            this.iDQ.a(this.jJH, 2);
        }
        MessageManager.getInstance().registerListener(this.iDS);
        MessageManager.getInstance().registerListener(this.jRz);
        this.jJP = new BigdaySwipeRefreshLayout(context);
        this.jJP.addView(this.jJH);
        this.gre = new PbListView(context);
        this.gre.getView();
        this.gre.setContainerBackgroundColorResId(R.color.transparent);
        this.gre.setLineGone();
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.gre.setOnClickListener(this.jJR);
        this.gre.bvh();
        this.jJH.setNextPage(this.gre);
        com.baidu.adp.base.e<?> J = i.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        MessageManager.getInstance().registerListener(this.jRE);
        com.baidu.tbadk.core.bigday.b.bmd().iW(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.bmd().ok(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
        addView(this.jJP);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.jRy = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.jRy, layoutParams);
            this.jRy.setOnClickListener(this.jRF);
            this.jRy.setVisibility(8);
        }
        this.jRp = new com.baidu.tieba.homepage.personalize.model.e();
        this.jRl = new af(context, this.jJH);
        this.jRl.b(this.jRp);
        this.jRn = new e(this.pageContext, this.jJH, this.jRl, this.jJP);
        this.jRo = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.iUI);
        this.jRw = com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cPF() {
        if (this.jRk != null) {
            this.jRk.setListPullRefreshListener(this.jRB);
            this.jRk.a(this.jPz);
            this.jRk.a(this.jRC);
            this.jRk.a(this.jPA);
        }
    }

    public void bZp() {
        this.jRl.b(this.jOX);
        this.jRl.a(this.jIG);
        this.jRn.a(this.jRA);
        this.jRo.a(this);
        cPF();
        this.jJH.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.iTS += i2;
                if (PersonalizePageView.this.jRy != null) {
                    com.baidu.adp.widget.ListView.q item = PersonalizePageView.this.jJH.getItem(PersonalizePageView.this.ekp.findLastVisibleItemPosition());
                    if (item instanceof k) {
                        if (((k) item).position >= 6) {
                            PersonalizePageView.this.jRy.show();
                        } else {
                            PersonalizePageView.this.jRy.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.ekp != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.iTS < height * 3 || PersonalizePageView.this.fAd != 1) {
                        if (PersonalizePageView.this.iTS < height * 3 && PersonalizePageView.this.fAd == 2) {
                            PersonalizePageView.this.fAd = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.fAd = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.fAd)));
                    }
                    if (PersonalizePageView.this.ekp.getItemCount() - PersonalizePageView.this.ekp.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bRM();
                    }
                }
            }
        });
        this.jJH.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bRM();
            }
        });
        this.jJH.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.jRq >= 5000) {
                    PersonalizePageView.this.jRn.cJ(i, i2);
                }
            }
        }, 1L);
        this.jJH.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.jRn != null && PersonalizePageView.this.jRn.cDi() != null) {
                        PersonalizePageView.this.jRn.cDi().dl(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                        ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).csM().stopPlay();
                    }
                }
            }
        });
        this.jJH.removeOnScrollListener(this.mOnScrollListener);
        this.jJH.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.jRm = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.gre != null) {
            this.gre.setText(getContext().getString(R.string.pb_load_more));
            this.gre.endLoadData();
            this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jRn.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.jRn != null) {
            this.jRn.rE(!z);
        }
        this.jRv = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.jRv;
    }

    public void h(Long l) {
        this.jRn.h(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.jRn != null) {
            this.jRn.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void showFloatingView() {
        if (this.jRn != null) {
            this.jRn.showFloatingView();
        }
    }

    public void cPG() {
        if (this.jRn != null) {
            this.jRn.cPG();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gAe != null) {
                this.gAe.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jRj != null) {
                this.jRj.changeSkin(i);
            }
            if (this.gre != null) {
                this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
                this.gre.changeSkin(i);
            }
            this.jRl.onChangeSkinType(i);
            if (this.jRn != null) {
                this.jRn.onChangeSkinType(i);
            }
            if (this.jRy != null) {
                this.jRy.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aU(String str, int i) {
        if (this.gre != null) {
            this.gre.setText(getContext().getString(R.string.pb_load_more));
            this.gre.endLoadData();
            this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jRn.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.jRn != null) {
                        PersonalizePageView.this.jRn.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yb() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this);
            this.gAe = null;
            this.jJH.setNextPage(this.gre);
            this.gre.setText(getContext().getString(R.string.pb_load_more));
            this.gre.endLoadData();
            this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.jJP != null) {
            this.jJP.setVisibility(0);
        }
        if (this.jRm != null) {
            this.jRm.cOc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqz() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ib(boolean z) {
        if (this.gAe == null) {
            this.gAe = new com.baidu.tbadk.l.g(getContext());
            this.gAe.bv(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.gAe.bDY();
            this.gAe.setWrapStyle(true);
            this.gAe.onChangeSkinType();
        }
        this.gAe.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.jJH.setNextPage(null);
        if (this.jJP != null) {
            this.jJP.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.jRn != null) {
            this.jRn.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jRn != null) {
            this.jRn.qf(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.jRw < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jRD, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jRn != null) {
            this.jRn.rq(z);
        }
        if (this.jJN != null) {
            this.jJN.b(this.jJO);
            this.jJN.a(this.jJO);
            this.jJO.cOF();
        }
    }

    public void cOp() {
        if (this.jRn != null) {
            ib(true);
            this.jRn.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.bmd().bmf();
            com.baidu.tbadk.core.bigday.b.bmd().bme();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.jRn != null) {
            this.jRn.update();
        } else if (this.jJH != null && this.jJP != null) {
            showFloatingView();
            this.jJH.setSelection(0);
            if (!this.jJP.isRefreshing()) {
                if (this.jRn != null && this.jRn.cDi() != null) {
                    this.jRn.cDi().cPh();
                    this.jRn.rz(false);
                }
                this.jJP.setRefreshing(true);
            }
            if (this.jJO != null) {
                this.jJO.cOF();
            }
        }
    }

    public void cPH() {
        if (this.refreshView != null) {
            reload();
        } else if (this.jRn != null) {
            this.jRn.update();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iDS);
        MessageManager.getInstance().unRegisterListener(this.iUI);
        MessageManager.getInstance().unRegisterListener(this.jRE);
        this.jRn.onDestroy();
        this.jRl.b((NEGFeedBackView.a) null);
        this.jRl.onDestroy();
        this.jRn.a((e.a) null);
        if (this.jRi != null) {
            this.jRi.setListPullRefreshListener(null);
            this.jRi.a((f.d) null);
            this.jRi.a((f.a) null);
            this.jRi.a((f.b) null);
            this.jRi.release();
        }
        if (this.jRj != null) {
            this.jRj.setListPullRefreshListener(null);
            this.jRj.a((f.d) null);
            this.jRj.a((f.a) null);
            this.jRj.a((f.b) null);
            this.jRj.release();
        }
        this.jJH.setOnSrollToBottomListener(null);
        if (this.jJN != null) {
            this.jJN.b(this.jJO);
        }
        this.jJH.removeOnScrollListener(this.mOnScrollListener);
        if (this.gAe != null) {
            this.gAe.release();
        }
        this.jJH.setRecyclerListener(null);
        if (this.jRo != null) {
            this.jRo.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.bmd().destroy();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jRD);
    }

    public void onPause() {
        this.jRn.onPause();
        if (this.jRl != null) {
            this.jRl.onPause();
        }
    }

    public void onResume() {
        if (this.iTI) {
            reload();
            this.iTI = false;
        }
        if (this.jJP != null) {
            this.jJP.resume();
        }
        if (this.jRl != null) {
            this.jRl.onResume();
        }
    }

    public void cNz() {
        if (this.jRl != null) {
            this.jRl.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jRs) {
            post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
                @Override // java.lang.Runnable
                public void run() {
                    PersonalizePageView.this.cPI();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPI() {
        if (!this.jRu) {
            long CD = com.baidu.tieba.homepage.framework.a.cOb().CD(1) + com.baidu.tieba.homepage.framework.a.cOb().getCreateTime();
            long CB = com.baidu.tieba.homepage.framework.a.cOb().CB(1);
            if (CB > 0) {
                CD = System.currentTimeMillis() - CB;
            }
            o oVar = new o();
            oVar.bFs();
            oVar.bFt();
            m.bFp().eE(CD);
            if (this.jRt > 0) {
                m.bFp().eI(System.currentTimeMillis() - this.jRt);
            }
            m.bFp().eF(oVar.bFu());
        }
        this.jRu = true;
    }

    public void cNA() {
        if (this.jRn != null) {
            this.jRn.qf(true);
        }
        t.csg().mj(false);
        com.baidu.tieba.a.d.bLT().dS("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jRD);
    }

    public void cPB() {
        this.jRn.cPX();
    }

    public void cPJ() {
        this.jRn.cPJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRM() {
        com.baidu.tieba.homepage.framework.a.cOb().E(System.currentTimeMillis(), 1);
        if (this.gre != null && !this.gre.isLoading()) {
            this.gre.startLoadData();
            this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jRn.bRM();
    }
}
