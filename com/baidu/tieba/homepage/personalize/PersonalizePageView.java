package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.v;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.e;
import com.baidu.tieba.tbadkCore.data.n;
import com.baidu.tieba.view.FloatingAnimationView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes4.dex */
public class PersonalizePageView extends FrameLayout {
    private final CustomMessageListener bZb;
    private LinearLayoutManager biO;
    private g cXq;
    private int dbB;
    private PbListView dbr;
    private k eHw;
    private CustomMessageListener eHx;
    private boolean eZH;
    private View.OnClickListener fGk;
    private BdTypeRecyclerView fHO;
    private BigdaySwipeRefreshLayout fKD;
    private com.baidu.tieba.homepage.personalize.bigday.b fKE;
    private com.baidu.tieba.homepage.personalize.bigday.a fKF;
    private a fKG;
    private v fKH;
    private com.baidu.tieba.homepage.framework.b fKI;
    private e fKJ;
    private com.baidu.tieba.homepage.personalize.a fKK;
    private com.baidu.tieba.homepage.personalize.model.e fKL;
    private long fKM;
    private FloatingAnimationView fKN;
    private boolean fKO;
    private int fKP;
    private int fKQ;
    private boolean fKR;
    private int fKS;
    private NEGFeedBackView.a fKT;
    private ScrollFragmentTabHost fKU;
    ScrollFragmentTabHost.a fKV;
    private e.a fKW;
    h.c fKX;
    h.d fKY;
    h.a fKZ;
    h.b fLa;
    private Runnable fLb;
    public CustomMessageListener fLc;
    private com.baidu.tieba.c.c faX;
    private CustomMessageListener far;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.m.h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void a(h.a aVar);

        void a(h.b bVar);

        void a(h.d dVar);

        void setListPullRefreshListener(h.c cVar);
    }

    static /* synthetic */ int u(PersonalizePageView personalizePageView) {
        int i = personalizePageView.fKP + 1;
        personalizePageView.fKP = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fKU = scrollFragmentTabHost;
        if (this.fKU != null) {
            this.fKU.b(this.fKV);
            this.fKU.a(this.fKV);
        }
        if (this.fKJ != null) {
            this.fKJ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.fKK != null) {
            this.fKK.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.fKD != null) {
            this.fKD.pE();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fKH != null) {
            this.fKH.setPageUniqueId(bdUniqueId);
        }
        if (this.fKJ != null) {
            this.fKJ.k(bdUniqueId);
        }
        if (this.fKL != null) {
            this.fKL.n(bdUniqueId);
        }
        if (this.fKF != null) {
            this.fKF.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.WM().setTag(bdUniqueId);
        if (this.bZb != null) {
            this.bZb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bZb);
        }
        if (this.fKK != null) {
            this.fKK.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        n nVar = new n();
        nVar.CE(String.valueOf(floatInfo.activity_id));
        nVar.dV(floatInfo.dynamic_url);
        nVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        nVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        nVar.CD(floatInfo.float_url);
        nVar.CC(floatInfo.jump_url);
        nVar.setType(floatInfo.show_type.intValue());
        return nVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.fKM = 0L;
        this.mSkinType = 3;
        this.eZH = false;
        this.fKO = false;
        this.fKP = 0;
        this.fKQ = 0;
        this.fKR = false;
        this.fKS = 1;
        this.eHx = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eHw == null) {
                            PersonalizePageView.this.eHw = new k(new i());
                        }
                        PersonalizePageView.this.eHw.a(PersonalizePageView.this.fHO, 2);
                    } else if (PersonalizePageView.this.eHw != null) {
                        PersonalizePageView.this.eHw.pg();
                    }
                }
            }
        };
        this.fKT = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                if (ajVar != null) {
                    TiebaStatic.log(new am("c11693").bJ("obj_locate", "1").bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
                int i = 0;
                if (arrayList != null && ajVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (ajVar.threadType == 0) {
                        i = 1;
                    } else if (ajVar.threadType == 40) {
                        i = 2;
                    } else if (ajVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.fKH != null) {
                        PersonalizePageView.this.fKH.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("obj_param1", ajVar.weight).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bJ(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bJ("obj_type", sb.toString()).bJ("obj_name", str).T("obj_param2", i));
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            private int dcL = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dcL != i && PersonalizePageView.this.fKU != null) {
                    this.dcL = i;
                    if (this.dcL == 1) {
                        PersonalizePageView.this.fKU.aBF();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fKU.aBG();
                    } else {
                        PersonalizePageView.this.fKU.aBF();
                    }
                }
            }
        };
        this.fKV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bml() {
                if (PersonalizePageView.this.fKU != null) {
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fHO)) {
                        PersonalizePageView.this.fKU.aBG();
                    } else {
                        PersonalizePageView.this.fKU.aBF();
                    }
                }
            }
        };
        this.fKW = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void K(int i, int i2, int i3) {
                if (PersonalizePageView.this.fKI == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aXs = PersonalizePageView.this.aXs();
                PersonalizePageView.this.aBu();
                if (aXs) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.fKI.J(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.fKI != null) {
                    PersonalizePageView.this.fKI.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.fKD.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.kY()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.fKD.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aBu();
                n a2 = PersonalizePageView.this.a(PersonalizePageView.this.fKJ.bmH());
                PersonalizePageView.this.dP(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.faX != null) {
                    PersonalizePageView.this.faX.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bmv() {
                if (PersonalizePageView.this.dbr != null) {
                    PersonalizePageView.this.dbr.setText(PersonalizePageView.this.getContext().getString(d.j.recommend_no_more_data));
                    PersonalizePageView.this.dbr.aeD();
                    PersonalizePageView.this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.fKX = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                com.baidu.tieba.a.d.awl().qM("page_recommend");
                PersonalizePageView.this.fKJ.update();
                PersonalizePageView.this.fKJ.kp(false);
                PersonalizePageView.this.fKR = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.fKY = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void dS(boolean z) {
                if (PersonalizePageView.this.fKJ != null && PersonalizePageView.this.fKJ.bdp() != null) {
                    PersonalizePageView.this.fKJ.bdp().bop();
                }
            }
        };
        this.fKZ = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void aeT() {
                if (PersonalizePageView.this.fKR) {
                    PersonalizePageView.this.fKQ = 0;
                    PersonalizePageView.this.fKS = 1;
                    PersonalizePageView.this.fKR = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.fLa = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.fKJ != null) {
                    PersonalizePageView.this.fKJ.kp(true);
                    PersonalizePageView.this.fKJ.bmA();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.WM().gc(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.fLb = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.u(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.bZb = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bmt();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fGk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aBd();
            }
        };
        this.far = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.eZH = true;
                    }
                }
            }
        };
        this.fLc = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fKD != null && !PersonalizePageView.this.fKD.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.fKF == null) {
                            PersonalizePageView.this.fKF = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.fKF.ic(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.fKG = PersonalizePageView.this.fKF;
                            PersonalizePageView.this.bmr();
                        } else if (PersonalizePageView.this.fKG != PersonalizePageView.this.fKF) {
                            PersonalizePageView.this.fKG = PersonalizePageView.this.fKF;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.fKF.setEnable(true);
                        PersonalizePageView.this.fKD.setProgressView(PersonalizePageView.this.fKF);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fKD.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.fKE == null) {
                        PersonalizePageView.this.fKE = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.fKG = PersonalizePageView.this.fKE;
                        PersonalizePageView.this.bmr();
                    } else if (PersonalizePageView.this.fKG != PersonalizePageView.this.fKE || !aVar.equals(PersonalizePageView.this.fKE.bmU())) {
                        PersonalizePageView.this.fKG = PersonalizePageView.this.fKE;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.fKE.setEnable(true);
                    PersonalizePageView.this.fKD.setProgressView(PersonalizePageView.this.fKE);
                    PersonalizePageView.this.fKE.a(aVar);
                    PersonalizePageView.this.fKD.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fKM = 0L;
        this.mSkinType = 3;
        this.eZH = false;
        this.fKO = false;
        this.fKP = 0;
        this.fKQ = 0;
        this.fKR = false;
        this.fKS = 1;
        this.eHx = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eHw == null) {
                            PersonalizePageView.this.eHw = new k(new i());
                        }
                        PersonalizePageView.this.eHw.a(PersonalizePageView.this.fHO, 2);
                    } else if (PersonalizePageView.this.eHw != null) {
                        PersonalizePageView.this.eHw.pg();
                    }
                }
            }
        };
        this.fKT = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                if (ajVar != null) {
                    TiebaStatic.log(new am("c11693").bJ("obj_locate", "1").bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
                int i = 0;
                if (arrayList != null && ajVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (ajVar.threadType == 0) {
                        i = 1;
                    } else if (ajVar.threadType == 40) {
                        i = 2;
                    } else if (ajVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.fKH != null) {
                        PersonalizePageView.this.fKH.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("obj_param1", ajVar.weight).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bJ(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bJ("obj_type", sb.toString()).bJ("obj_name", str).T("obj_param2", i));
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            private int dcL = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dcL != i && PersonalizePageView.this.fKU != null) {
                    this.dcL = i;
                    if (this.dcL == 1) {
                        PersonalizePageView.this.fKU.aBF();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fKU.aBG();
                    } else {
                        PersonalizePageView.this.fKU.aBF();
                    }
                }
            }
        };
        this.fKV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bml() {
                if (PersonalizePageView.this.fKU != null) {
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fHO)) {
                        PersonalizePageView.this.fKU.aBG();
                    } else {
                        PersonalizePageView.this.fKU.aBF();
                    }
                }
            }
        };
        this.fKW = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void K(int i, int i2, int i3) {
                if (PersonalizePageView.this.fKI == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aXs = PersonalizePageView.this.aXs();
                PersonalizePageView.this.aBu();
                if (aXs) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.fKI.J(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.fKI != null) {
                    PersonalizePageView.this.fKI.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.fKD.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.kY()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.fKD.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aBu();
                n a2 = PersonalizePageView.this.a(PersonalizePageView.this.fKJ.bmH());
                PersonalizePageView.this.dP(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.faX != null) {
                    PersonalizePageView.this.faX.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bmv() {
                if (PersonalizePageView.this.dbr != null) {
                    PersonalizePageView.this.dbr.setText(PersonalizePageView.this.getContext().getString(d.j.recommend_no_more_data));
                    PersonalizePageView.this.dbr.aeD();
                    PersonalizePageView.this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.fKX = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                com.baidu.tieba.a.d.awl().qM("page_recommend");
                PersonalizePageView.this.fKJ.update();
                PersonalizePageView.this.fKJ.kp(false);
                PersonalizePageView.this.fKR = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.fKY = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void dS(boolean z) {
                if (PersonalizePageView.this.fKJ != null && PersonalizePageView.this.fKJ.bdp() != null) {
                    PersonalizePageView.this.fKJ.bdp().bop();
                }
            }
        };
        this.fKZ = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void aeT() {
                if (PersonalizePageView.this.fKR) {
                    PersonalizePageView.this.fKQ = 0;
                    PersonalizePageView.this.fKS = 1;
                    PersonalizePageView.this.fKR = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.fLa = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.fKJ != null) {
                    PersonalizePageView.this.fKJ.kp(true);
                    PersonalizePageView.this.fKJ.bmA();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.WM().gc(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.fLb = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.u(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.bZb = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bmt();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fGk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aBd();
            }
        };
        this.far = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.eZH = true;
                    }
                }
            }
        };
        this.fLc = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fKD != null && !PersonalizePageView.this.fKD.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.fKF == null) {
                            PersonalizePageView.this.fKF = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.fKF.ic(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.fKG = PersonalizePageView.this.fKF;
                            PersonalizePageView.this.bmr();
                        } else if (PersonalizePageView.this.fKG != PersonalizePageView.this.fKF) {
                            PersonalizePageView.this.fKG = PersonalizePageView.this.fKF;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.fKF.setEnable(true);
                        PersonalizePageView.this.fKD.setProgressView(PersonalizePageView.this.fKF);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fKD.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.fKE == null) {
                        PersonalizePageView.this.fKE = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.fKG = PersonalizePageView.this.fKE;
                        PersonalizePageView.this.bmr();
                    } else if (PersonalizePageView.this.fKG != PersonalizePageView.this.fKE || !aVar.equals(PersonalizePageView.this.fKE.bmU())) {
                        PersonalizePageView.this.fKG = PersonalizePageView.this.fKE;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.fKE.setEnable(true);
                    PersonalizePageView.this.fKD.setProgressView(PersonalizePageView.this.fKE);
                    PersonalizePageView.this.fKE.a(aVar);
                    PersonalizePageView.this.fKD.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fKM = 0L;
        this.mSkinType = 3;
        this.eZH = false;
        this.fKO = false;
        this.fKP = 0;
        this.fKQ = 0;
        this.fKR = false;
        this.fKS = 1;
        this.eHx = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eHw == null) {
                            PersonalizePageView.this.eHw = new k(new i());
                        }
                        PersonalizePageView.this.eHw.a(PersonalizePageView.this.fHO, 2);
                    } else if (PersonalizePageView.this.eHw != null) {
                        PersonalizePageView.this.eHw.pg();
                    }
                }
            }
        };
        this.fKT = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                if (ajVar != null) {
                    TiebaStatic.log(new am("c11693").bJ("obj_locate", "1").bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
                int i2 = 0;
                if (arrayList != null && ajVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        sb.append(arrayList.get(i22)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (ajVar.threadType == 0) {
                        i2 = 1;
                    } else if (ajVar.threadType == 40) {
                        i2 = 2;
                    } else if (ajVar.threadType == 49) {
                        i2 = 3;
                    }
                    if (PersonalizePageView.this.fKH != null) {
                        PersonalizePageView.this.fKH.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("obj_param1", ajVar.weight).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bJ(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bJ("obj_type", sb.toString()).bJ("obj_name", str).T("obj_param2", i2));
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            private int dcL = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (this.dcL != i2 && PersonalizePageView.this.fKU != null) {
                    this.dcL = i2;
                    if (this.dcL == 1) {
                        PersonalizePageView.this.fKU.aBF();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fKU.aBG();
                    } else {
                        PersonalizePageView.this.fKU.aBF();
                    }
                }
            }
        };
        this.fKV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bml() {
                if (PersonalizePageView.this.fKU != null) {
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fHO)) {
                        PersonalizePageView.this.fKU.aBG();
                    } else {
                        PersonalizePageView.this.fKU.aBF();
                    }
                }
            }
        };
        this.fKW = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void K(int i2, int i22, int i3) {
                if (PersonalizePageView.this.fKI == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aXs = PersonalizePageView.this.aXs();
                PersonalizePageView.this.aBu();
                if (aXs) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.fKI.J(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.fKI != null) {
                    PersonalizePageView.this.fKI.u(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.fKD.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.kY()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.fKD.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aBu();
                n a2 = PersonalizePageView.this.a(PersonalizePageView.this.fKJ.bmH());
                PersonalizePageView.this.dP(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.faX != null) {
                    PersonalizePageView.this.faX.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bmv() {
                if (PersonalizePageView.this.dbr != null) {
                    PersonalizePageView.this.dbr.setText(PersonalizePageView.this.getContext().getString(d.j.recommend_no_more_data));
                    PersonalizePageView.this.dbr.aeD();
                    PersonalizePageView.this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.fKX = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                com.baidu.tieba.a.d.awl().qM("page_recommend");
                PersonalizePageView.this.fKJ.update();
                PersonalizePageView.this.fKJ.kp(false);
                PersonalizePageView.this.fKR = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.fKY = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void dS(boolean z) {
                if (PersonalizePageView.this.fKJ != null && PersonalizePageView.this.fKJ.bdp() != null) {
                    PersonalizePageView.this.fKJ.bdp().bop();
                }
            }
        };
        this.fKZ = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void aeT() {
                if (PersonalizePageView.this.fKR) {
                    PersonalizePageView.this.fKQ = 0;
                    PersonalizePageView.this.fKS = 1;
                    PersonalizePageView.this.fKR = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.fLa = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.fKJ != null) {
                    PersonalizePageView.this.fKJ.kp(true);
                    PersonalizePageView.this.fKJ.bmA();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.WM().gc(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.fLb = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.u(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.bZb = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bmt();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fGk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aBd();
            }
        };
        this.far = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.eZH = true;
                    }
                }
            }
        };
        this.fLc = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fKD != null && !PersonalizePageView.this.fKD.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.fKF == null) {
                            PersonalizePageView.this.fKF = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.fKF.ic(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.fKG = PersonalizePageView.this.fKF;
                            PersonalizePageView.this.bmr();
                        } else if (PersonalizePageView.this.fKG != PersonalizePageView.this.fKF) {
                            PersonalizePageView.this.fKG = PersonalizePageView.this.fKF;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.fKF.setEnable(true);
                        PersonalizePageView.this.fKD.setProgressView(PersonalizePageView.this.fKF);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fKD.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.fKE == null) {
                        PersonalizePageView.this.fKE = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.fKG = PersonalizePageView.this.fKE;
                        PersonalizePageView.this.bmr();
                    } else if (PersonalizePageView.this.fKG != PersonalizePageView.this.fKE || !aVar.equals(PersonalizePageView.this.fKE.bmU())) {
                        PersonalizePageView.this.fKG = PersonalizePageView.this.fKE;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.fKE.setEnable(true);
                    PersonalizePageView.this.fKD.setProgressView(PersonalizePageView.this.fKE);
                    PersonalizePageView.this.fKE.a(aVar);
                    PersonalizePageView.this.fKD.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fHO = new BdTypeRecyclerView(context);
        this.biO = new LinearLayoutManager(this.fHO.getContext());
        this.fHO.setLayoutManager(this.biO);
        this.fHO.setFadingEdgeLength(0);
        this.fHO.setOverScrollMode(2);
        this.fHO.addOnScrollListener(this.mOnScrollListener);
        if (TbSingleton.getInstance().isSlideAnimLocalSwitchOn()) {
            this.eHw = new k(new i());
            this.eHw.a(this.fHO, 2);
        }
        MessageManager.getInstance().registerListener(this.eHx);
        this.fKD = new BigdaySwipeRefreshLayout(context);
        this.fKD.addView(this.fHO);
        this.dbr = new PbListView(context);
        this.dbr.getView();
        this.dbr.ib(d.C0236d.cp_bg_line_e);
        this.dbr.aez();
        this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_j));
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.ia(d.C0236d.cp_cont_e);
        this.dbr.setHeight(l.h(context, d.e.tbds182));
        this.dbr.setOnClickListener(this.fGk);
        this.fHO.setNextPage(this.dbr);
        com.baidu.adp.base.e<?> aK = com.baidu.adp.base.i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        MessageManager.getInstance().registerListener(this.fLc);
        com.baidu.tbadk.core.bigday.b.WM().dh(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.WM().gc(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.fKD);
        ((FrameLayout.LayoutParams) this.fKD.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.fKL = new com.baidu.tieba.homepage.personalize.model.e();
        this.fKH = new v(context, this.fHO);
        this.fKH.b(this.fKL);
        this.fKJ = new e(this.pageContext, this.fHO, this.fKH, this.fKD);
        this.fKK = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.far);
        this.fKP = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dP(Context context) {
        if (this.fKN == null) {
            this.fKN = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, d.e.tbds200), l.h(context, d.e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.h(context, d.e.tbds200);
            addView(this.fKN, layoutParams);
            this.fKN.setVisibility(8);
            this.fKN.setPageId(this.pageContext.getUniqueId());
            this.faX = new com.baidu.tieba.c.c(this.pageContext, this.fKN, 1);
        }
    }

    public void bmr() {
        if (this.fKG != null) {
            this.fKG.setListPullRefreshListener(this.fKX);
            this.fKG.a(this.fKY);
            this.fKG.a(this.fKZ);
            this.fKG.a(this.fLa);
        }
    }

    public void bgB() {
        this.fKH.b(this.fKT);
        this.fKJ.a(this.fKW);
        this.fKK.a(this);
        bmr();
        this.fHO.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                PersonalizePageView.this.fKQ += i2;
                if (PersonalizePageView.this.fKQ < height * 3 || PersonalizePageView.this.fKS != 1) {
                    if (PersonalizePageView.this.fKQ < height * 3 && PersonalizePageView.this.fKS == 2) {
                        PersonalizePageView.this.fKS = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        return;
                    }
                    return;
                }
                PersonalizePageView.this.fKS = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.fKS)));
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.biO != null && i == 0 && PersonalizePageView.this.biO.getItemCount() - PersonalizePageView.this.biO.findLastVisibleItemPosition() <= 3) {
                    PersonalizePageView.this.aBd();
                }
            }
        });
        this.fHO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aBd();
            }
        });
        this.fHO.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.fKM >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    PersonalizePageView.this.fKJ.bv(i, i2);
                }
            }
        }, 1L);
        this.fHO.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.fKJ != null && PersonalizePageView.this.fKJ.bdp() != null) {
                        PersonalizePageView.this.fKJ.bdp().cb(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).aRj().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.fKI = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.dbr != null) {
            this.dbr.setText(getContext().getString(d.j.pb_load_more));
            this.dbr.aeD();
            this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fKJ.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.fKJ != null) {
            this.fKJ.km(!z);
        }
        this.fKO = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.fKO;
    }

    public void f(Long l) {
        this.fKJ.f(l);
    }

    public void setHeaderViewHeight(int i) {
        this.dbB = i;
        if (this.fKD != null && this.fKD.getLayoutParams() != null) {
            if (this.fKJ != null) {
                this.fKJ.setHeaderViewHeight(i);
            }
            if (this.fKK != null) {
                this.fKK.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.fKJ != null) {
            this.fKJ.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void showFloatingView() {
        if (this.fKJ != null) {
            this.fKJ.showFloatingView();
        }
    }

    public void bms() {
        if (this.fKJ != null) {
            this.fKJ.bms();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cXq != null) {
                this.cXq.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            al.l(this.fKD, d.C0236d.cp_bg_line_e);
            if (this.fKF != null) {
                this.fKF.ic(i);
            }
            if (this.dbr != null) {
                this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_d));
                this.dbr.ic(i);
            }
            this.fKH.onChangeSkinType(i);
            if (this.fKJ != null) {
                this.fKJ.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aC(String str, int i) {
        if (this.dbr != null) {
            this.dbr.setText(getContext().getString(d.j.pb_load_more));
            this.dbr.aeD();
            this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fKJ.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.fKJ != null) {
                        PersonalizePageView.this.fKJ.update();
                    }
                }
            });
        }
        this.refreshView.jS(this.dbB);
        this.refreshView.po(str);
        this.refreshView.attachView(view, z);
        this.refreshView.anC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBu() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.cXq != null) {
            this.cXq.dettachView(this);
            this.cXq = null;
            this.fHO.setNextPage(this.dbr);
            this.dbr.setText(getContext().getString(d.j.pb_load_more));
            this.dbr.aeD();
            this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        if (this.fKD != null) {
            this.fKD.setVisibility(0);
        }
        if (this.fKI != null) {
            this.fKI.blS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXs() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.cXq == null) {
            if (i < 0) {
                this.cXq = new g(getContext());
            } else {
                this.cXq = new g(getContext(), i);
            }
            this.cXq.onChangeSkinType();
        }
        this.cXq.attachView(this, z);
        this.fHO.setNextPage(null);
        if (this.fKD != null) {
            this.fKD.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.fKJ != null) {
            this.fKJ.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.faX != null) {
            this.faX.aSn();
        }
        setViewForeground(false);
        if (this.fKJ != null) {
            this.fKJ.ji(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.fKP < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.fLb, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.fKJ != null) {
            this.fKJ.kg(z);
        }
    }

    public void bma() {
        if (this.fKJ != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.fKJ.update();
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.WM().WO();
            com.baidu.tbadk.core.bigday.b.WM().WN();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.fKJ != null) {
            this.fKJ.update();
        } else if (this.fHO != null && this.fKD != null) {
            showFloatingView();
            this.fHO.setSelection(0);
            if (!this.fKD.isRefreshing()) {
                if (this.fKJ != null && this.fKJ.bdp() != null) {
                    this.fKJ.bdp().bop();
                    this.fKJ.kp(false);
                }
                this.fKD.setRefreshing(true);
            }
            if (this.fKV != null) {
                this.fKV.bml();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eHx);
        MessageManager.getInstance().unRegisterListener(this.far);
        MessageManager.getInstance().unRegisterListener(this.fLc);
        this.fKJ.onDestroy();
        this.fKH.b((NEGFeedBackView.a) null);
        this.fKH.onDestroy();
        this.fKJ.a((e.a) null);
        if (this.fKE != null) {
            this.fKE.setListPullRefreshListener(null);
            this.fKE.a((h.d) null);
            this.fKE.a((h.a) null);
            this.fKE.a((h.b) null);
            this.fKE.release();
        }
        if (this.fKF != null) {
            this.fKF.setListPullRefreshListener(null);
            this.fKF.a((h.d) null);
            this.fKF.a((h.a) null);
            this.fKF.a((h.b) null);
            this.fKF.release();
        }
        this.fHO.setOnSrollToBottomListener(null);
        this.fHO.removeOnScrollListener(this.mOnScrollListener);
        if (this.fKU != null) {
            this.fKU.b(this.fKV);
        }
        if (this.cXq != null) {
            this.cXq.release();
        }
        this.fHO.setRecyclerListener(null);
        if (this.fKK != null) {
            this.fKK.onDestroy();
        }
        if (this.faX != null) {
            this.faX.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.WM().destroy();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fLb);
    }

    public void onPause() {
        this.fKJ.onPause();
        if (this.fKH != null) {
            this.fKH.onPause();
        }
    }

    public void onResume() {
        if (this.eZH) {
            reload();
            this.eZH = false;
        }
        if (this.fKD != null) {
            this.fKD.resume();
        }
        if (this.fKH != null) {
            this.fKH.onResume();
        }
    }

    public void bmt() {
        if (this.fKH != null) {
            this.fKH.notifyDataSetChanged();
        }
    }

    public void blu() {
        if (this.fKJ != null) {
            this.fKJ.ji(true);
        }
        t.aQG().go(false);
        com.baidu.tieba.a.d.awl().bA("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fLb);
    }

    public void bmo() {
        this.fKJ.bmG();
    }

    public void bmu() {
        this.fKJ.bmu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBd() {
        com.baidu.tieba.homepage.framework.a.blR().p(System.currentTimeMillis(), 1);
        if (this.dbr != null && !this.dbr.qz()) {
            this.dbr.aeC();
            this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fKJ.aBd();
    }
}
