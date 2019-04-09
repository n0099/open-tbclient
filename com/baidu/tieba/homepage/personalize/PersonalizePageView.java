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
    private final CustomMessageListener bZf;
    private LinearLayoutManager biT;
    private g cXq;
    private int dbC;
    private PbListView dbs;
    private k eHf;
    private CustomMessageListener eHg;
    private boolean eZt;
    private View.OnClickListener fFX;
    private BdTypeRecyclerView fHB;
    private FloatingAnimationView fKA;
    private boolean fKB;
    private int fKC;
    private int fKD;
    private boolean fKE;
    private int fKF;
    private NEGFeedBackView.a fKG;
    private ScrollFragmentTabHost fKH;
    ScrollFragmentTabHost.a fKI;
    private e.a fKJ;
    h.c fKK;
    h.d fKL;
    h.a fKM;
    h.b fKN;
    private Runnable fKO;
    public CustomMessageListener fKP;
    private BigdaySwipeRefreshLayout fKq;
    private com.baidu.tieba.homepage.personalize.bigday.b fKr;
    private com.baidu.tieba.homepage.personalize.bigday.a fKs;
    private a fKt;
    private v fKu;
    private com.baidu.tieba.homepage.framework.b fKv;
    private e fKw;
    private com.baidu.tieba.homepage.personalize.a fKx;
    private com.baidu.tieba.homepage.personalize.model.e fKy;
    private long fKz;
    private com.baidu.tieba.c.c faJ;
    private CustomMessageListener fad;
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
        int i = personalizePageView.fKC + 1;
        personalizePageView.fKC = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fKH = scrollFragmentTabHost;
        if (this.fKH != null) {
            this.fKH.b(this.fKI);
            this.fKH.a(this.fKI);
        }
        if (this.fKw != null) {
            this.fKw.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.fKx != null) {
            this.fKx.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.fKq != null) {
            this.fKq.pE();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fKu != null) {
            this.fKu.setPageUniqueId(bdUniqueId);
        }
        if (this.fKw != null) {
            this.fKw.k(bdUniqueId);
        }
        if (this.fKy != null) {
            this.fKy.n(bdUniqueId);
        }
        if (this.fKs != null) {
            this.fKs.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.WJ().setTag(bdUniqueId);
        if (this.bZf != null) {
            this.bZf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bZf);
        }
        if (this.fKx != null) {
            this.fKx.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        n nVar = new n();
        nVar.CB(String.valueOf(floatInfo.activity_id));
        nVar.dS(floatInfo.dynamic_url);
        nVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        nVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        nVar.CA(floatInfo.float_url);
        nVar.Cz(floatInfo.jump_url);
        nVar.setType(floatInfo.show_type.intValue());
        return nVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.fKz = 0L;
        this.mSkinType = 3;
        this.eZt = false;
        this.fKB = false;
        this.fKC = 0;
        this.fKD = 0;
        this.fKE = false;
        this.fKF = 1;
        this.eHg = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eHf == null) {
                            PersonalizePageView.this.eHf = new k(new i());
                        }
                        PersonalizePageView.this.eHf.a(PersonalizePageView.this.fHB, 2);
                    } else if (PersonalizePageView.this.eHf != null) {
                        PersonalizePageView.this.eHf.pg();
                    }
                }
            }
        };
        this.fKG = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.fKu != null) {
                        PersonalizePageView.this.fKu.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("obj_param1", ajVar.weight).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bJ(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bJ("obj_type", sb.toString()).bJ("obj_name", str).T("obj_param2", i));
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            private int dcM = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dcM != i && PersonalizePageView.this.fKH != null) {
                    this.dcM = i;
                    if (this.dcM == 1) {
                        PersonalizePageView.this.fKH.aBB();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fKH.aBC();
                    } else {
                        PersonalizePageView.this.fKH.aBB();
                    }
                }
            }
        };
        this.fKI = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bmh() {
                if (PersonalizePageView.this.fKH != null) {
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fHB)) {
                        PersonalizePageView.this.fKH.aBC();
                    } else {
                        PersonalizePageView.this.fKH.aBB();
                    }
                }
            }
        };
        this.fKJ = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void K(int i, int i2, int i3) {
                if (PersonalizePageView.this.fKv == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aXp = PersonalizePageView.this.aXp();
                PersonalizePageView.this.aBq();
                if (aXp) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.fKv.J(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.fKv != null) {
                    PersonalizePageView.this.fKv.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.fKq.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.kY()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.fKq.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aBq();
                n a2 = PersonalizePageView.this.a(PersonalizePageView.this.fKw.bmD());
                PersonalizePageView.this.dO(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.faJ != null) {
                    PersonalizePageView.this.faJ.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bmr() {
                if (PersonalizePageView.this.dbs != null) {
                    PersonalizePageView.this.dbs.setText(PersonalizePageView.this.getContext().getString(d.j.recommend_no_more_data));
                    PersonalizePageView.this.dbs.aeA();
                    PersonalizePageView.this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.fKK = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                com.baidu.tieba.a.d.awh().qL("page_recommend");
                PersonalizePageView.this.fKw.update();
                PersonalizePageView.this.fKw.kp(false);
                PersonalizePageView.this.fKE = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.fKL = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void dS(boolean z) {
                if (PersonalizePageView.this.fKw != null && PersonalizePageView.this.fKw.bdm() != null) {
                    PersonalizePageView.this.fKw.bdm().bol();
                }
            }
        };
        this.fKM = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void aeQ() {
                if (PersonalizePageView.this.fKE) {
                    PersonalizePageView.this.fKD = 0;
                    PersonalizePageView.this.fKF = 1;
                    PersonalizePageView.this.fKE = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.fKN = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.fKw != null) {
                    PersonalizePageView.this.fKw.kp(true);
                    PersonalizePageView.this.fKw.bmw();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.WJ().gb(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.fKO = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.u(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.bZf = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bmp();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fFX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aAZ();
            }
        };
        this.fad = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.eZt = true;
                    }
                }
            }
        };
        this.fKP = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fKq != null && !PersonalizePageView.this.fKq.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.fKs == null) {
                            PersonalizePageView.this.fKs = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.fKs.ib(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.fKt = PersonalizePageView.this.fKs;
                            PersonalizePageView.this.bmn();
                        } else if (PersonalizePageView.this.fKt != PersonalizePageView.this.fKs) {
                            PersonalizePageView.this.fKt = PersonalizePageView.this.fKs;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.fKs.setEnable(true);
                        PersonalizePageView.this.fKq.setProgressView(PersonalizePageView.this.fKs);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fKq.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.fKr == null) {
                        PersonalizePageView.this.fKr = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.fKt = PersonalizePageView.this.fKr;
                        PersonalizePageView.this.bmn();
                    } else if (PersonalizePageView.this.fKt != PersonalizePageView.this.fKr || !aVar.equals(PersonalizePageView.this.fKr.bmQ())) {
                        PersonalizePageView.this.fKt = PersonalizePageView.this.fKr;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.fKr.setEnable(true);
                    PersonalizePageView.this.fKq.setProgressView(PersonalizePageView.this.fKr);
                    PersonalizePageView.this.fKr.a(aVar);
                    PersonalizePageView.this.fKq.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fKz = 0L;
        this.mSkinType = 3;
        this.eZt = false;
        this.fKB = false;
        this.fKC = 0;
        this.fKD = 0;
        this.fKE = false;
        this.fKF = 1;
        this.eHg = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eHf == null) {
                            PersonalizePageView.this.eHf = new k(new i());
                        }
                        PersonalizePageView.this.eHf.a(PersonalizePageView.this.fHB, 2);
                    } else if (PersonalizePageView.this.eHf != null) {
                        PersonalizePageView.this.eHf.pg();
                    }
                }
            }
        };
        this.fKG = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.fKu != null) {
                        PersonalizePageView.this.fKu.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("obj_param1", ajVar.weight).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bJ(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bJ("obj_type", sb.toString()).bJ("obj_name", str).T("obj_param2", i));
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            private int dcM = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dcM != i && PersonalizePageView.this.fKH != null) {
                    this.dcM = i;
                    if (this.dcM == 1) {
                        PersonalizePageView.this.fKH.aBB();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fKH.aBC();
                    } else {
                        PersonalizePageView.this.fKH.aBB();
                    }
                }
            }
        };
        this.fKI = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bmh() {
                if (PersonalizePageView.this.fKH != null) {
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fHB)) {
                        PersonalizePageView.this.fKH.aBC();
                    } else {
                        PersonalizePageView.this.fKH.aBB();
                    }
                }
            }
        };
        this.fKJ = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void K(int i, int i2, int i3) {
                if (PersonalizePageView.this.fKv == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aXp = PersonalizePageView.this.aXp();
                PersonalizePageView.this.aBq();
                if (aXp) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.fKv.J(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.fKv != null) {
                    PersonalizePageView.this.fKv.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.fKq.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.kY()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.fKq.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aBq();
                n a2 = PersonalizePageView.this.a(PersonalizePageView.this.fKw.bmD());
                PersonalizePageView.this.dO(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.faJ != null) {
                    PersonalizePageView.this.faJ.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bmr() {
                if (PersonalizePageView.this.dbs != null) {
                    PersonalizePageView.this.dbs.setText(PersonalizePageView.this.getContext().getString(d.j.recommend_no_more_data));
                    PersonalizePageView.this.dbs.aeA();
                    PersonalizePageView.this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.fKK = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                com.baidu.tieba.a.d.awh().qL("page_recommend");
                PersonalizePageView.this.fKw.update();
                PersonalizePageView.this.fKw.kp(false);
                PersonalizePageView.this.fKE = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.fKL = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void dS(boolean z) {
                if (PersonalizePageView.this.fKw != null && PersonalizePageView.this.fKw.bdm() != null) {
                    PersonalizePageView.this.fKw.bdm().bol();
                }
            }
        };
        this.fKM = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void aeQ() {
                if (PersonalizePageView.this.fKE) {
                    PersonalizePageView.this.fKD = 0;
                    PersonalizePageView.this.fKF = 1;
                    PersonalizePageView.this.fKE = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.fKN = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.fKw != null) {
                    PersonalizePageView.this.fKw.kp(true);
                    PersonalizePageView.this.fKw.bmw();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.WJ().gb(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.fKO = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.u(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.bZf = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bmp();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fFX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aAZ();
            }
        };
        this.fad = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.eZt = true;
                    }
                }
            }
        };
        this.fKP = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fKq != null && !PersonalizePageView.this.fKq.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.fKs == null) {
                            PersonalizePageView.this.fKs = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.fKs.ib(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.fKt = PersonalizePageView.this.fKs;
                            PersonalizePageView.this.bmn();
                        } else if (PersonalizePageView.this.fKt != PersonalizePageView.this.fKs) {
                            PersonalizePageView.this.fKt = PersonalizePageView.this.fKs;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.fKs.setEnable(true);
                        PersonalizePageView.this.fKq.setProgressView(PersonalizePageView.this.fKs);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fKq.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.fKr == null) {
                        PersonalizePageView.this.fKr = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.fKt = PersonalizePageView.this.fKr;
                        PersonalizePageView.this.bmn();
                    } else if (PersonalizePageView.this.fKt != PersonalizePageView.this.fKr || !aVar.equals(PersonalizePageView.this.fKr.bmQ())) {
                        PersonalizePageView.this.fKt = PersonalizePageView.this.fKr;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.fKr.setEnable(true);
                    PersonalizePageView.this.fKq.setProgressView(PersonalizePageView.this.fKr);
                    PersonalizePageView.this.fKr.a(aVar);
                    PersonalizePageView.this.fKq.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fKz = 0L;
        this.mSkinType = 3;
        this.eZt = false;
        this.fKB = false;
        this.fKC = 0;
        this.fKD = 0;
        this.fKE = false;
        this.fKF = 1;
        this.eHg = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eHf == null) {
                            PersonalizePageView.this.eHf = new k(new i());
                        }
                        PersonalizePageView.this.eHf.a(PersonalizePageView.this.fHB, 2);
                    } else if (PersonalizePageView.this.eHf != null) {
                        PersonalizePageView.this.eHf.pg();
                    }
                }
            }
        };
        this.fKG = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.fKu != null) {
                        PersonalizePageView.this.fKu.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("obj_param1", ajVar.weight).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bJ(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bJ("obj_type", sb.toString()).bJ("obj_name", str).T("obj_param2", i2));
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            private int dcM = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (this.dcM != i2 && PersonalizePageView.this.fKH != null) {
                    this.dcM = i2;
                    if (this.dcM == 1) {
                        PersonalizePageView.this.fKH.aBB();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fKH.aBC();
                    } else {
                        PersonalizePageView.this.fKH.aBB();
                    }
                }
            }
        };
        this.fKI = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bmh() {
                if (PersonalizePageView.this.fKH != null) {
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fHB)) {
                        PersonalizePageView.this.fKH.aBC();
                    } else {
                        PersonalizePageView.this.fKH.aBB();
                    }
                }
            }
        };
        this.fKJ = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void K(int i2, int i22, int i3) {
                if (PersonalizePageView.this.fKv == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aXp = PersonalizePageView.this.aXp();
                PersonalizePageView.this.aBq();
                if (aXp) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.fKv.J(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.fKv != null) {
                    PersonalizePageView.this.fKv.u(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.fKq.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.kY()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.fKq.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aBq();
                n a2 = PersonalizePageView.this.a(PersonalizePageView.this.fKw.bmD());
                PersonalizePageView.this.dO(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.faJ != null) {
                    PersonalizePageView.this.faJ.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bmr() {
                if (PersonalizePageView.this.dbs != null) {
                    PersonalizePageView.this.dbs.setText(PersonalizePageView.this.getContext().getString(d.j.recommend_no_more_data));
                    PersonalizePageView.this.dbs.aeA();
                    PersonalizePageView.this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.fKK = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                com.baidu.tieba.a.d.awh().qL("page_recommend");
                PersonalizePageView.this.fKw.update();
                PersonalizePageView.this.fKw.kp(false);
                PersonalizePageView.this.fKE = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.fKL = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void dS(boolean z) {
                if (PersonalizePageView.this.fKw != null && PersonalizePageView.this.fKw.bdm() != null) {
                    PersonalizePageView.this.fKw.bdm().bol();
                }
            }
        };
        this.fKM = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void aeQ() {
                if (PersonalizePageView.this.fKE) {
                    PersonalizePageView.this.fKD = 0;
                    PersonalizePageView.this.fKF = 1;
                    PersonalizePageView.this.fKE = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.fKN = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.fKw != null) {
                    PersonalizePageView.this.fKw.kp(true);
                    PersonalizePageView.this.fKw.bmw();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.WJ().gb(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.fKO = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.u(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.bZf = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bmp();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fFX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aAZ();
            }
        };
        this.fad = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.eZt = true;
                    }
                }
            }
        };
        this.fKP = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fKq != null && !PersonalizePageView.this.fKq.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.fKs == null) {
                            PersonalizePageView.this.fKs = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.fKs.ib(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.fKt = PersonalizePageView.this.fKs;
                            PersonalizePageView.this.bmn();
                        } else if (PersonalizePageView.this.fKt != PersonalizePageView.this.fKs) {
                            PersonalizePageView.this.fKt = PersonalizePageView.this.fKs;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.fKs.setEnable(true);
                        PersonalizePageView.this.fKq.setProgressView(PersonalizePageView.this.fKs);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fKq.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.fKr == null) {
                        PersonalizePageView.this.fKr = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.fKt = PersonalizePageView.this.fKr;
                        PersonalizePageView.this.bmn();
                    } else if (PersonalizePageView.this.fKt != PersonalizePageView.this.fKr || !aVar.equals(PersonalizePageView.this.fKr.bmQ())) {
                        PersonalizePageView.this.fKt = PersonalizePageView.this.fKr;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.fKr.setEnable(true);
                    PersonalizePageView.this.fKq.setProgressView(PersonalizePageView.this.fKr);
                    PersonalizePageView.this.fKr.a(aVar);
                    PersonalizePageView.this.fKq.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fHB = new BdTypeRecyclerView(context);
        this.biT = new LinearLayoutManager(this.fHB.getContext());
        this.fHB.setLayoutManager(this.biT);
        this.fHB.setFadingEdgeLength(0);
        this.fHB.setOverScrollMode(2);
        this.fHB.addOnScrollListener(this.mOnScrollListener);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.eHf = new k(new i());
            this.eHf.a(this.fHB, 2);
        }
        MessageManager.getInstance().registerListener(this.eHg);
        this.fKq = new BigdaySwipeRefreshLayout(context);
        this.fKq.addView(this.fHB);
        this.dbs = new PbListView(context);
        this.dbs.getView();
        this.dbs.ia(d.C0277d.cp_bg_line_e);
        this.dbs.aew();
        this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbs.setTextSize(d.e.tbfontsize33);
        this.dbs.hZ(d.C0277d.cp_cont_e);
        this.dbs.setHeight(l.h(context, d.e.tbds182));
        this.dbs.setOnClickListener(this.fFX);
        this.fHB.setNextPage(this.dbs);
        com.baidu.adp.base.e<?> aK = com.baidu.adp.base.i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        MessageManager.getInstance().registerListener(this.fKP);
        com.baidu.tbadk.core.bigday.b.WJ().dh(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.WJ().gb(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.fKq);
        ((FrameLayout.LayoutParams) this.fKq.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.fKy = new com.baidu.tieba.homepage.personalize.model.e();
        this.fKu = new v(context, this.fHB);
        this.fKu.b(this.fKy);
        this.fKw = new e(this.pageContext, this.fHB, this.fKu, this.fKq);
        this.fKx = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.fad);
        this.fKC = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO(Context context) {
        if (this.fKA == null) {
            this.fKA = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, d.e.tbds200), l.h(context, d.e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.h(context, d.e.tbds200);
            addView(this.fKA, layoutParams);
            this.fKA.setVisibility(8);
            this.fKA.setPageId(this.pageContext.getUniqueId());
            this.faJ = new com.baidu.tieba.c.c(this.pageContext, this.fKA, 1);
        }
    }

    public void bmn() {
        if (this.fKt != null) {
            this.fKt.setListPullRefreshListener(this.fKK);
            this.fKt.a(this.fKL);
            this.fKt.a(this.fKM);
            this.fKt.a(this.fKN);
        }
    }

    public void bgy() {
        this.fKu.b(this.fKG);
        this.fKw.a(this.fKJ);
        this.fKx.a(this);
        bmn();
        this.fHB.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                PersonalizePageView.this.fKD += i2;
                if (PersonalizePageView.this.fKD < height * 3 || PersonalizePageView.this.fKF != 1) {
                    if (PersonalizePageView.this.fKD < height * 3 && PersonalizePageView.this.fKF == 2) {
                        PersonalizePageView.this.fKF = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        return;
                    }
                    return;
                }
                PersonalizePageView.this.fKF = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.fKF)));
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.biT != null && i == 0 && PersonalizePageView.this.biT.getItemCount() - PersonalizePageView.this.biT.findLastVisibleItemPosition() <= 3) {
                    PersonalizePageView.this.aAZ();
                }
            }
        });
        this.fHB.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aAZ();
            }
        });
        this.fHB.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.fKz >= 5000) {
                    PersonalizePageView.this.fKw.bv(i, i2);
                }
            }
        }, 1L);
        this.fHB.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.fKw != null && PersonalizePageView.this.fKw.bdm() != null) {
                        PersonalizePageView.this.fKw.bdm().cb(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).aRg().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.fKv = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.dbs != null) {
            this.dbs.setText(getContext().getString(d.j.pb_load_more));
            this.dbs.aeA();
            this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fKw.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.fKw != null) {
            this.fKw.km(!z);
        }
        this.fKB = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.fKB;
    }

    public void f(Long l) {
        this.fKw.f(l);
    }

    public void setHeaderViewHeight(int i) {
        this.dbC = i;
        if (this.fKq != null && this.fKq.getLayoutParams() != null) {
            if (this.fKw != null) {
                this.fKw.setHeaderViewHeight(i);
            }
            if (this.fKx != null) {
                this.fKx.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.fKw != null) {
            this.fKw.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void showFloatingView() {
        if (this.fKw != null) {
            this.fKw.showFloatingView();
        }
    }

    public void bmo() {
        if (this.fKw != null) {
            this.fKw.bmo();
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
            al.l(this.fKq, d.C0277d.cp_bg_line_e);
            if (this.fKs != null) {
                this.fKs.ib(i);
            }
            if (this.dbs != null) {
                this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_d));
                this.dbs.ib(i);
            }
            this.fKu.onChangeSkinType(i);
            if (this.fKw != null) {
                this.fKw.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aC(String str, int i) {
        if (this.dbs != null) {
            this.dbs.setText(getContext().getString(d.j.pb_load_more));
            this.dbs.aeA();
            this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fKw.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.fKw != null) {
                        PersonalizePageView.this.fKw.update();
                    }
                }
            });
        }
        this.refreshView.jR(this.dbC);
        this.refreshView.pp(str);
        this.refreshView.attachView(view, z);
        this.refreshView.any();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBq() {
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
            this.fHB.setNextPage(this.dbs);
            this.dbs.setText(getContext().getString(d.j.pb_load_more));
            this.dbs.aeA();
            this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        if (this.fKq != null) {
            this.fKq.setVisibility(0);
        }
        if (this.fKv != null) {
            this.fKv.blO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXp() {
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
        this.fHB.setNextPage(null);
        if (this.fKq != null) {
            this.fKq.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.fKw != null) {
            this.fKw.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.faJ != null) {
            this.faJ.aSk();
        }
        setViewForeground(false);
        if (this.fKw != null) {
            this.fKw.ji(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.fKC < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.fKO, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.fKw != null) {
            this.fKw.kg(z);
        }
    }

    public void blW() {
        if (this.fKw != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.fKw.update();
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.WJ().WL();
            com.baidu.tbadk.core.bigday.b.WJ().WK();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.fKw != null) {
            this.fKw.update();
        } else if (this.fHB != null && this.fKq != null) {
            showFloatingView();
            this.fHB.setSelection(0);
            if (!this.fKq.isRefreshing()) {
                if (this.fKw != null && this.fKw.bdm() != null) {
                    this.fKw.bdm().bol();
                    this.fKw.kp(false);
                }
                this.fKq.setRefreshing(true);
            }
            if (this.fKI != null) {
                this.fKI.bmh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eHg);
        MessageManager.getInstance().unRegisterListener(this.fad);
        MessageManager.getInstance().unRegisterListener(this.fKP);
        this.fKw.onDestroy();
        this.fKu.b((NEGFeedBackView.a) null);
        this.fKu.onDestroy();
        this.fKw.a((e.a) null);
        if (this.fKr != null) {
            this.fKr.setListPullRefreshListener(null);
            this.fKr.a((h.d) null);
            this.fKr.a((h.a) null);
            this.fKr.a((h.b) null);
            this.fKr.release();
        }
        if (this.fKs != null) {
            this.fKs.setListPullRefreshListener(null);
            this.fKs.a((h.d) null);
            this.fKs.a((h.a) null);
            this.fKs.a((h.b) null);
            this.fKs.release();
        }
        this.fHB.setOnSrollToBottomListener(null);
        this.fHB.removeOnScrollListener(this.mOnScrollListener);
        if (this.fKH != null) {
            this.fKH.b(this.fKI);
        }
        if (this.cXq != null) {
            this.cXq.release();
        }
        this.fHB.setRecyclerListener(null);
        if (this.fKx != null) {
            this.fKx.onDestroy();
        }
        if (this.faJ != null) {
            this.faJ.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.WJ().destroy();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fKO);
    }

    public void onPause() {
        this.fKw.onPause();
        if (this.fKu != null) {
            this.fKu.onPause();
        }
    }

    public void onResume() {
        if (this.eZt) {
            reload();
            this.eZt = false;
        }
        if (this.fKq != null) {
            this.fKq.resume();
        }
        if (this.fKu != null) {
            this.fKu.onResume();
        }
    }

    public void bmp() {
        if (this.fKu != null) {
            this.fKu.notifyDataSetChanged();
        }
    }

    public void blq() {
        if (this.fKw != null) {
            this.fKw.ji(true);
        }
        t.aQD().go(false);
        com.baidu.tieba.a.d.awh().bA("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fKO);
    }

    public void bmk() {
        this.fKw.bmC();
    }

    public void bmq() {
        this.fKw.bmq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAZ() {
        com.baidu.tieba.homepage.framework.a.blN().p(System.currentTimeMillis(), 1);
        if (this.dbs != null && !this.dbs.qz()) {
            this.dbs.aez();
            this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fKw.aAZ();
    }
}
