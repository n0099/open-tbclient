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
    private com.baidu.tbadk.l.g gAg;
    private PbListView grg;
    private int gtH;
    private n iDS;
    private CustomMessageListener iDU;
    private boolean iTK;
    private int iTU;
    private CustomMessageListener iUK;
    private FollowUserButton.a jII;
    private BdTypeRecyclerView jJJ;
    private ScrollFragmentTabHost jJP;
    ScrollFragmentTabHost.a jJQ;
    private BigdaySwipeRefreshLayout jJR;
    private View.OnClickListener jJT;
    private NEGFeedBackView.a jOZ;
    f.d jPB;
    f.b jPC;
    private FRSRefreshButton jRA;
    private CustomMessageListener jRB;
    private e.a jRC;
    f.c jRD;
    f.a jRE;
    private Runnable jRF;
    public CustomMessageListener jRG;
    private View.OnClickListener jRH;
    private com.baidu.tieba.homepage.personalize.bigday.b jRk;
    private com.baidu.tieba.homepage.personalize.bigday.a jRl;
    private a jRm;
    private af jRn;
    private com.baidu.tieba.homepage.framework.b jRo;
    private e jRp;
    private com.baidu.tieba.homepage.personalize.a jRq;
    private com.baidu.tieba.homepage.personalize.model.e jRr;
    private long jRs;
    private int jRt;
    private boolean jRu;
    private long jRv;
    private boolean jRw;
    private boolean jRx;
    private int jRy;
    private boolean jRz;
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
        int i = personalizePageView.jRy + 1;
        personalizePageView.jRy = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jJP = scrollFragmentTabHost;
        if (this.jJP != null) {
            this.jJP.b(this.jJQ);
            this.jJP.a(this.jJQ);
        }
        if (this.jRp != null) {
            this.jRp.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jRq != null) {
            this.jRq.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.jJR != null) {
            this.jJR.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jRn != null) {
            this.jRn.setPageUniqueId(bdUniqueId);
        }
        if (this.jRp != null) {
            this.jRp.o(bdUniqueId);
        }
        if (this.jRr != null) {
            this.jRr.i(bdUniqueId);
        }
        if (this.jRl != null) {
            this.jRl.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.bmd().setTag(bdUniqueId);
        if (this.flC != null) {
            this.flC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.flC);
        }
        if (this.jRq != null) {
            this.jRq.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.jRs = 0L;
        this.mSkinType = 3;
        this.iTK = false;
        this.jRt = 0;
        this.jRu = false;
        this.jRv = -1L;
        this.jRw = false;
        this.jRx = false;
        this.jRy = 0;
        this.iTU = 0;
        this.jRz = false;
        this.fAd = 1;
        this.iDU = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iDS == null) {
                            PersonalizePageView.this.iDS = new n(new l());
                        }
                        PersonalizePageView.this.iDS.a(PersonalizePageView.this.jJJ, 2);
                    } else if (PersonalizePageView.this.iDS != null) {
                        PersonalizePageView.this.iDS.rj();
                    }
                }
            }
        };
        this.jRB = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jRp != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bsb().bsc(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jOZ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
                    if (PersonalizePageView.this.jRn != null) {
                        PersonalizePageView.this.jRn.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dY("tid", atVar.getTid()).dY("nid", atVar.getNid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", atVar.getFid()).dY("obj_param1", atVar.weight).dY("obj_source", atVar.source).dY("obj_id", atVar.extra).dY("obj_type", sb.toString()).dY("obj_name", str).al(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jII = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
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
        this.gtH = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gtH != i && PersonalizePageView.this.jJP != null) {
                    PersonalizePageView.this.gtH = i;
                    if (PersonalizePageView.this.gtH == 1) {
                        PersonalizePageView.this.jJP.bSv();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jJP.bSw();
                    } else {
                        PersonalizePageView.this.jJP.bSv();
                    }
                }
            }
        };
        this.jJQ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOG() {
                if (PersonalizePageView.this.jJP != null) {
                    PersonalizePageView.this.gtH = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jJJ)) {
                        PersonalizePageView.this.jJP.bSw();
                    } else {
                        PersonalizePageView.this.jJP.bSv();
                    }
                }
            }
        };
        this.jRC = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iLN = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_first_install", true);

            private void cPL() {
                if (this.iLN) {
                    this.iLN = false;
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void T(int i, int i2, int i3) {
                if (PersonalizePageView.this.jRo == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqA = PersonalizePageView.this.cqA();
                PersonalizePageView.this.Yb();
                if (cqA) {
                    PersonalizePageView.this.ib(true);
                }
                PersonalizePageView.this.jRo.S(i, i2, i3);
                q.bjk().bjl();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jRo != null) {
                    PersonalizePageView.this.jRo.G(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cPL();
                } else if (!this.iLN) {
                    PersonalizePageView.this.jJR.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cPL();
                    PersonalizePageView.this.cOq();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void rD(boolean z) {
                cPL();
                PersonalizePageView.this.jJR.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Yb();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dQm().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.jRu = true;
                    PersonalizePageView.this.jRv = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cPM() {
                if (PersonalizePageView.this.grg != null) {
                    PersonalizePageView.this.grg.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.grg.endLoadData();
                    PersonalizePageView.this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jRD = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bLU().Fn("page_recommend");
                PersonalizePageView.this.jRp.update();
                PersonalizePageView.this.jRp.rz(false);
                PersonalizePageView.this.jRz = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jPB = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jRp != null && PersonalizePageView.this.jRp.cDj() != null) {
                    PersonalizePageView.this.jRp.cDj().cPi();
                }
            }
        };
        this.jRE = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bvC() {
                if (PersonalizePageView.this.jRz) {
                    PersonalizePageView.this.iTU = 0;
                    PersonalizePageView.this.fAd = 1;
                    PersonalizePageView.this.jRz = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jPC = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jRp != null) {
                    PersonalizePageView.this.jRp.rz(true);
                    PersonalizePageView.this.jRp.cPR();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bmd().ok(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.jRF = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
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
                                PersonalizePageView.this.cNA();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jJT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRN();
            }
        };
        this.iUK = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iTK = true;
                    }
                }
            }
        };
        this.jRG = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jJR != null && !PersonalizePageView.this.jJR.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jRl == null) {
                            PersonalizePageView.this.jRl = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jRl.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jRm = PersonalizePageView.this.jRl;
                            PersonalizePageView.this.cPG();
                        } else if (PersonalizePageView.this.jRm != PersonalizePageView.this.jRl) {
                            PersonalizePageView.this.jRm = PersonalizePageView.this.jRl;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jRl.setEnable(true);
                        PersonalizePageView.this.jJR.setProgressView(PersonalizePageView.this.jRl);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jJR.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jRk == null) {
                        PersonalizePageView.this.jRk = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jRm = PersonalizePageView.this.jRk;
                        PersonalizePageView.this.cPG();
                    } else if (PersonalizePageView.this.jRm != PersonalizePageView.this.jRk || !aVar.equals(PersonalizePageView.this.jRk.cQm())) {
                        PersonalizePageView.this.jRm = PersonalizePageView.this.jRk;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jRk.setEnable(true);
                    PersonalizePageView.this.jJR.setProgressView(PersonalizePageView.this.jRk);
                    PersonalizePageView.this.jRk.a(aVar);
                    PersonalizePageView.this.jJR.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jRH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jRA != null) {
                    PersonalizePageView.this.jRA.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jRs = 0L;
        this.mSkinType = 3;
        this.iTK = false;
        this.jRt = 0;
        this.jRu = false;
        this.jRv = -1L;
        this.jRw = false;
        this.jRx = false;
        this.jRy = 0;
        this.iTU = 0;
        this.jRz = false;
        this.fAd = 1;
        this.iDU = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iDS == null) {
                            PersonalizePageView.this.iDS = new n(new l());
                        }
                        PersonalizePageView.this.iDS.a(PersonalizePageView.this.jJJ, 2);
                    } else if (PersonalizePageView.this.iDS != null) {
                        PersonalizePageView.this.iDS.rj();
                    }
                }
            }
        };
        this.jRB = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jRp != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bsb().bsc(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jOZ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
                    if (PersonalizePageView.this.jRn != null) {
                        PersonalizePageView.this.jRn.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dY("tid", atVar.getTid()).dY("nid", atVar.getNid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", atVar.getFid()).dY("obj_param1", atVar.weight).dY("obj_source", atVar.source).dY("obj_id", atVar.extra).dY("obj_type", sb.toString()).dY("obj_name", str).al(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jII = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
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
        this.gtH = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.gtH != i && PersonalizePageView.this.jJP != null) {
                    PersonalizePageView.this.gtH = i;
                    if (PersonalizePageView.this.gtH == 1) {
                        PersonalizePageView.this.jJP.bSv();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jJP.bSw();
                    } else {
                        PersonalizePageView.this.jJP.bSv();
                    }
                }
            }
        };
        this.jJQ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOG() {
                if (PersonalizePageView.this.jJP != null) {
                    PersonalizePageView.this.gtH = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jJJ)) {
                        PersonalizePageView.this.jJP.bSw();
                    } else {
                        PersonalizePageView.this.jJP.bSv();
                    }
                }
            }
        };
        this.jRC = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iLN = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_first_install", true);

            private void cPL() {
                if (this.iLN) {
                    this.iLN = false;
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void T(int i, int i2, int i3) {
                if (PersonalizePageView.this.jRo == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqA = PersonalizePageView.this.cqA();
                PersonalizePageView.this.Yb();
                if (cqA) {
                    PersonalizePageView.this.ib(true);
                }
                PersonalizePageView.this.jRo.S(i, i2, i3);
                q.bjk().bjl();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jRo != null) {
                    PersonalizePageView.this.jRo.G(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cPL();
                } else if (!this.iLN) {
                    PersonalizePageView.this.jJR.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cPL();
                    PersonalizePageView.this.cOq();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void rD(boolean z) {
                cPL();
                PersonalizePageView.this.jJR.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Yb();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dQm().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.jRu = true;
                    PersonalizePageView.this.jRv = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cPM() {
                if (PersonalizePageView.this.grg != null) {
                    PersonalizePageView.this.grg.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.grg.endLoadData();
                    PersonalizePageView.this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jRD = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bLU().Fn("page_recommend");
                PersonalizePageView.this.jRp.update();
                PersonalizePageView.this.jRp.rz(false);
                PersonalizePageView.this.jRz = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jPB = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jRp != null && PersonalizePageView.this.jRp.cDj() != null) {
                    PersonalizePageView.this.jRp.cDj().cPi();
                }
            }
        };
        this.jRE = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bvC() {
                if (PersonalizePageView.this.jRz) {
                    PersonalizePageView.this.iTU = 0;
                    PersonalizePageView.this.fAd = 1;
                    PersonalizePageView.this.jRz = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jPC = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jRp != null) {
                    PersonalizePageView.this.jRp.rz(true);
                    PersonalizePageView.this.jRp.cPR();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bmd().ok(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.jRF = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
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
                                PersonalizePageView.this.cNA();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jJT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRN();
            }
        };
        this.iUK = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iTK = true;
                    }
                }
            }
        };
        this.jRG = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jJR != null && !PersonalizePageView.this.jJR.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jRl == null) {
                            PersonalizePageView.this.jRl = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jRl.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jRm = PersonalizePageView.this.jRl;
                            PersonalizePageView.this.cPG();
                        } else if (PersonalizePageView.this.jRm != PersonalizePageView.this.jRl) {
                            PersonalizePageView.this.jRm = PersonalizePageView.this.jRl;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jRl.setEnable(true);
                        PersonalizePageView.this.jJR.setProgressView(PersonalizePageView.this.jRl);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jJR.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jRk == null) {
                        PersonalizePageView.this.jRk = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jRm = PersonalizePageView.this.jRk;
                        PersonalizePageView.this.cPG();
                    } else if (PersonalizePageView.this.jRm != PersonalizePageView.this.jRk || !aVar.equals(PersonalizePageView.this.jRk.cQm())) {
                        PersonalizePageView.this.jRm = PersonalizePageView.this.jRk;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jRk.setEnable(true);
                    PersonalizePageView.this.jJR.setProgressView(PersonalizePageView.this.jRk);
                    PersonalizePageView.this.jRk.a(aVar);
                    PersonalizePageView.this.jJR.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jRH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jRA != null) {
                    PersonalizePageView.this.jRA.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jRs = 0L;
        this.mSkinType = 3;
        this.iTK = false;
        this.jRt = 0;
        this.jRu = false;
        this.jRv = -1L;
        this.jRw = false;
        this.jRx = false;
        this.jRy = 0;
        this.iTU = 0;
        this.jRz = false;
        this.fAd = 1;
        this.iDU = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.iDS == null) {
                            PersonalizePageView.this.iDS = new n(new l());
                        }
                        PersonalizePageView.this.iDS.a(PersonalizePageView.this.jJJ, 2);
                    } else if (PersonalizePageView.this.iDS != null) {
                        PersonalizePageView.this.iDS.rj();
                    }
                }
            }
        };
        this.jRB = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jRp != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bsb().bsc(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jOZ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
                    if (PersonalizePageView.this.jRn != null) {
                        PersonalizePageView.this.jRn.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dY("tid", atVar.getTid()).dY("nid", atVar.getNid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", atVar.getFid()).dY("obj_param1", atVar.weight).dY("obj_source", atVar.source).dY("obj_id", atVar.extra).dY("obj_type", sb.toString()).dY("obj_name", str).al(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.jII = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
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
        this.gtH = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.gtH != i2 && PersonalizePageView.this.jJP != null) {
                    PersonalizePageView.this.gtH = i2;
                    if (PersonalizePageView.this.gtH == 1) {
                        PersonalizePageView.this.jJP.bSv();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jJP.bSw();
                    } else {
                        PersonalizePageView.this.jJP.bSv();
                    }
                }
            }
        };
        this.jJQ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOG() {
                if (PersonalizePageView.this.jJP != null) {
                    PersonalizePageView.this.gtH = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jJJ)) {
                        PersonalizePageView.this.jJP.bSw();
                    } else {
                        PersonalizePageView.this.jJP.bSv();
                    }
                }
            }
        };
        this.jRC = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iLN = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_first_install", true);

            private void cPL() {
                if (this.iLN) {
                    this.iLN = false;
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void T(int i2, int i22, int i3) {
                if (PersonalizePageView.this.jRo == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cqA = PersonalizePageView.this.cqA();
                PersonalizePageView.this.Yb();
                if (cqA) {
                    PersonalizePageView.this.ib(true);
                }
                PersonalizePageView.this.jRo.S(i2, i22, i3);
                q.bjk().bjl();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.jRo != null) {
                    PersonalizePageView.this.jRo.G(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cPL();
                } else if (!this.iLN) {
                    PersonalizePageView.this.jJR.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cPL();
                    PersonalizePageView.this.cOq();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void rD(boolean z) {
                cPL();
                PersonalizePageView.this.jJR.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Yb();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dQm().startLoad();
                }
                if (z) {
                    PersonalizePageView.this.jRu = true;
                    PersonalizePageView.this.jRv = System.currentTimeMillis();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cPM() {
                if (PersonalizePageView.this.grg != null) {
                    PersonalizePageView.this.grg.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.grg.endLoadData();
                    PersonalizePageView.this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jRD = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bLU().Fn("page_recommend");
                PersonalizePageView.this.jRp.update();
                PersonalizePageView.this.jRp.rz(false);
                PersonalizePageView.this.jRz = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jPB = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jRp != null && PersonalizePageView.this.jRp.cDj() != null) {
                    PersonalizePageView.this.jRp.cDj().cPi();
                }
            }
        };
        this.jRE = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bvC() {
                if (PersonalizePageView.this.jRz) {
                    PersonalizePageView.this.iTU = 0;
                    PersonalizePageView.this.fAd = 1;
                    PersonalizePageView.this.jRz = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jPC = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jRp != null) {
                    PersonalizePageView.this.jRp.rz(true);
                    PersonalizePageView.this.jRp.cPR();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bmd().ok(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.jRF = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
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
                                PersonalizePageView.this.cNA();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jJT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bRN();
            }
        };
        this.iUK = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iTK = true;
                    }
                }
            }
        };
        this.jRG = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jJR != null && !PersonalizePageView.this.jJR.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jRl == null) {
                            PersonalizePageView.this.jRl = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jRl.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jRm = PersonalizePageView.this.jRl;
                            PersonalizePageView.this.cPG();
                        } else if (PersonalizePageView.this.jRm != PersonalizePageView.this.jRl) {
                            PersonalizePageView.this.jRm = PersonalizePageView.this.jRl;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jRl.setEnable(true);
                        PersonalizePageView.this.jJR.setProgressView(PersonalizePageView.this.jRl);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jJR.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jRk == null) {
                        PersonalizePageView.this.jRk = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jRm = PersonalizePageView.this.jRk;
                        PersonalizePageView.this.cPG();
                    } else if (PersonalizePageView.this.jRm != PersonalizePageView.this.jRk || !aVar.equals(PersonalizePageView.this.jRk.cQm())) {
                        PersonalizePageView.this.jRm = PersonalizePageView.this.jRk;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jRk.setEnable(true);
                    PersonalizePageView.this.jJR.setProgressView(PersonalizePageView.this.jRk);
                    PersonalizePageView.this.jRk.a(aVar);
                    PersonalizePageView.this.jJR.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jRH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jRA != null) {
                    PersonalizePageView.this.jRA.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jJJ = new BdTypeRecyclerView(context);
        this.ekp = new LinearLayoutManager(this.jJJ.getContext());
        this.jJJ.setLayoutManager(this.ekp);
        this.jJJ.setFadingEdgeLength(0);
        this.jJJ.setOverScrollMode(2);
        if (!com.baidu.tbadk.a.d.bkA()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.jJJ.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        }
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iDS = new n(new l());
            this.iDS.a(this.jJJ, 2);
        }
        MessageManager.getInstance().registerListener(this.iDU);
        MessageManager.getInstance().registerListener(this.jRB);
        this.jJR = new BigdaySwipeRefreshLayout(context);
        this.jJR.addView(this.jJJ);
        this.grg = new PbListView(context);
        this.grg.getView();
        this.grg.setContainerBackgroundColorResId(R.color.transparent);
        this.grg.setLineGone();
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.grg.setOnClickListener(this.jJT);
        this.grg.bvh();
        this.jJJ.setNextPage(this.grg);
        com.baidu.adp.base.e<?> J = i.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        MessageManager.getInstance().registerListener(this.jRG);
        com.baidu.tbadk.core.bigday.b.bmd().iW(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.bmd().ok(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
        addView(this.jJR);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.jRA = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.jRA, layoutParams);
            this.jRA.setOnClickListener(this.jRH);
            this.jRA.setVisibility(8);
        }
        this.jRr = new com.baidu.tieba.homepage.personalize.model.e();
        this.jRn = new af(context, this.jJJ);
        this.jRn.b(this.jRr);
        this.jRp = new e(this.pageContext, this.jJJ, this.jRn, this.jJR);
        this.jRq = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.iUK);
        this.jRy = com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cPG() {
        if (this.jRm != null) {
            this.jRm.setListPullRefreshListener(this.jRD);
            this.jRm.a(this.jPB);
            this.jRm.a(this.jRE);
            this.jRm.a(this.jPC);
        }
    }

    public void bZq() {
        this.jRn.b(this.jOZ);
        this.jRn.a(this.jII);
        this.jRp.a(this.jRC);
        this.jRq.a(this);
        cPG();
        this.jJJ.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.iTU += i2;
                if (PersonalizePageView.this.jRA != null) {
                    com.baidu.adp.widget.ListView.q item = PersonalizePageView.this.jJJ.getItem(PersonalizePageView.this.ekp.findLastVisibleItemPosition());
                    if (item instanceof k) {
                        if (((k) item).position >= 6) {
                            PersonalizePageView.this.jRA.show();
                        } else {
                            PersonalizePageView.this.jRA.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.ekp != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.iTU < height * 3 || PersonalizePageView.this.fAd != 1) {
                        if (PersonalizePageView.this.iTU < height * 3 && PersonalizePageView.this.fAd == 2) {
                            PersonalizePageView.this.fAd = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.fAd = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.fAd)));
                    }
                    if (PersonalizePageView.this.ekp.getItemCount() - PersonalizePageView.this.ekp.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bRN();
                    }
                }
            }
        });
        this.jJJ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bRN();
            }
        });
        this.jJJ.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.jRs >= 5000) {
                    PersonalizePageView.this.jRp.cJ(i, i2);
                }
            }
        }, 1L);
        this.jJJ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.jRp != null && PersonalizePageView.this.jRp.cDj() != null) {
                        PersonalizePageView.this.jRp.cDj().dl(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                        ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).csN().stopPlay();
                    }
                }
            }
        });
        this.jJJ.removeOnScrollListener(this.mOnScrollListener);
        this.jJJ.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.jRo = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.grg != null) {
            this.grg.setText(getContext().getString(R.string.pb_load_more));
            this.grg.endLoadData();
            this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jRp.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.jRp != null) {
            this.jRp.rE(!z);
        }
        this.jRx = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.jRx;
    }

    public void h(Long l) {
        this.jRp.h(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.jRp != null) {
            this.jRp.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void showFloatingView() {
        if (this.jRp != null) {
            this.jRp.showFloatingView();
        }
    }

    public void cPH() {
        if (this.jRp != null) {
            this.jRp.cPH();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gAg != null) {
                this.gAg.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jRl != null) {
                this.jRl.changeSkin(i);
            }
            if (this.grg != null) {
                this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
                this.grg.changeSkin(i);
            }
            this.jRn.onChangeSkinType(i);
            if (this.jRp != null) {
                this.jRp.onChangeSkinType(i);
            }
            if (this.jRA != null) {
                this.jRA.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aU(String str, int i) {
        if (this.grg != null) {
            this.grg.setText(getContext().getString(R.string.pb_load_more));
            this.grg.endLoadData();
            this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jRp.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.jRp != null) {
                        PersonalizePageView.this.jRp.update();
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
        if (this.gAg != null) {
            this.gAg.dettachView(this);
            this.gAg = null;
            this.jJJ.setNextPage(this.grg);
            this.grg.setText(getContext().getString(R.string.pb_load_more));
            this.grg.endLoadData();
            this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.jJR != null) {
            this.jJR.setVisibility(0);
        }
        if (this.jRo != null) {
            this.jRo.cOd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqA() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ib(boolean z) {
        if (this.gAg == null) {
            this.gAg = new com.baidu.tbadk.l.g(getContext());
            this.gAg.bv(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.gAg.bDY();
            this.gAg.setWrapStyle(true);
            this.gAg.onChangeSkinType();
        }
        this.gAg.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.jJJ.setNextPage(null);
        if (this.jJR != null) {
            this.jJR.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.jRp != null) {
            this.jRp.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jRp != null) {
            this.jRp.qf(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.jRy < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jRF, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jRp != null) {
            this.jRp.rq(z);
        }
        if (this.jJP != null) {
            this.jJP.b(this.jJQ);
            this.jJP.a(this.jJQ);
            this.jJQ.cOG();
        }
    }

    public void cOq() {
        if (this.jRp != null) {
            ib(true);
            this.jRp.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.bmd().bmf();
            com.baidu.tbadk.core.bigday.b.bmd().bme();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.jRp != null) {
            this.jRp.update();
        } else if (this.jJJ != null && this.jJR != null) {
            showFloatingView();
            this.jJJ.setSelection(0);
            if (!this.jJR.isRefreshing()) {
                if (this.jRp != null && this.jRp.cDj() != null) {
                    this.jRp.cDj().cPi();
                    this.jRp.rz(false);
                }
                this.jJR.setRefreshing(true);
            }
            if (this.jJQ != null) {
                this.jJQ.cOG();
            }
        }
    }

    public void cPI() {
        if (this.refreshView != null) {
            reload();
        } else if (this.jRp != null) {
            this.jRp.update();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iDU);
        MessageManager.getInstance().unRegisterListener(this.iUK);
        MessageManager.getInstance().unRegisterListener(this.jRG);
        this.jRp.onDestroy();
        this.jRn.b((NEGFeedBackView.a) null);
        this.jRn.onDestroy();
        this.jRp.a((e.a) null);
        if (this.jRk != null) {
            this.jRk.setListPullRefreshListener(null);
            this.jRk.a((f.d) null);
            this.jRk.a((f.a) null);
            this.jRk.a((f.b) null);
            this.jRk.release();
        }
        if (this.jRl != null) {
            this.jRl.setListPullRefreshListener(null);
            this.jRl.a((f.d) null);
            this.jRl.a((f.a) null);
            this.jRl.a((f.b) null);
            this.jRl.release();
        }
        this.jJJ.setOnSrollToBottomListener(null);
        if (this.jJP != null) {
            this.jJP.b(this.jJQ);
        }
        this.jJJ.removeOnScrollListener(this.mOnScrollListener);
        if (this.gAg != null) {
            this.gAg.release();
        }
        this.jJJ.setRecyclerListener(null);
        if (this.jRq != null) {
            this.jRq.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.bmd().destroy();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jRF);
    }

    public void onPause() {
        this.jRp.onPause();
        if (this.jRn != null) {
            this.jRn.onPause();
        }
    }

    public void onResume() {
        if (this.iTK) {
            reload();
            this.iTK = false;
        }
        if (this.jJR != null) {
            this.jJR.resume();
        }
        if (this.jRn != null) {
            this.jRn.onResume();
        }
    }

    public void cNA() {
        if (this.jRn != null) {
            this.jRn.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jRu) {
            post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
                @Override // java.lang.Runnable
                public void run() {
                    PersonalizePageView.this.cPJ();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPJ() {
        if (!this.jRw) {
            long CD = com.baidu.tieba.homepage.framework.a.cOc().CD(1) + com.baidu.tieba.homepage.framework.a.cOc().getCreateTime();
            long CB = com.baidu.tieba.homepage.framework.a.cOc().CB(1);
            if (CB > 0) {
                CD = System.currentTimeMillis() - CB;
            }
            o oVar = new o();
            oVar.bFs();
            oVar.bFt();
            m.bFp().eE(CD);
            if (this.jRv > 0) {
                m.bFp().eI(System.currentTimeMillis() - this.jRv);
            }
            m.bFp().eF(oVar.bFu());
        }
        this.jRw = true;
    }

    public void cNB() {
        if (this.jRp != null) {
            this.jRp.qf(true);
        }
        t.csh().mj(false);
        com.baidu.tieba.a.d.bLU().dS("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jRF);
    }

    public void cPC() {
        this.jRp.cPY();
    }

    public void cPK() {
        this.jRp.cPK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRN() {
        com.baidu.tieba.homepage.framework.a.cOc().E(System.currentTimeMillis(), 1);
        if (this.grg != null && !this.grg.isLoading()) {
            this.grg.startLoadData();
            this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jRp.bRN();
    }
}
