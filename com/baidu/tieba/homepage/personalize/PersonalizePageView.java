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
    private final CustomMessageListener bZc;
    private LinearLayoutManager biP;
    private g cXm;
    private PbListView dbn;
    private int dbx;
    private k eHs;
    private CustomMessageListener eHt;
    private boolean eZG;
    private View.OnClickListener fGj;
    private BdTypeRecyclerView fHN;
    private BigdaySwipeRefreshLayout fKC;
    private com.baidu.tieba.homepage.personalize.bigday.b fKD;
    private com.baidu.tieba.homepage.personalize.bigday.a fKE;
    private a fKF;
    private v fKG;
    private com.baidu.tieba.homepage.framework.b fKH;
    private e fKI;
    private com.baidu.tieba.homepage.personalize.a fKJ;
    private com.baidu.tieba.homepage.personalize.model.e fKK;
    private long fKL;
    private FloatingAnimationView fKM;
    private boolean fKN;
    private int fKO;
    private int fKP;
    private boolean fKQ;
    private int fKR;
    private NEGFeedBackView.a fKS;
    private ScrollFragmentTabHost fKT;
    ScrollFragmentTabHost.a fKU;
    private e.a fKV;
    h.c fKW;
    h.d fKX;
    h.a fKY;
    h.b fKZ;
    private Runnable fLa;
    public CustomMessageListener fLb;
    private com.baidu.tieba.c.c faW;
    private CustomMessageListener faq;
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
        int i = personalizePageView.fKO + 1;
        personalizePageView.fKO = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fKT = scrollFragmentTabHost;
        if (this.fKT != null) {
            this.fKT.b(this.fKU);
            this.fKT.a(this.fKU);
        }
        if (this.fKI != null) {
            this.fKI.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.fKJ != null) {
            this.fKJ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.fKC != null) {
            this.fKC.pE();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fKG != null) {
            this.fKG.setPageUniqueId(bdUniqueId);
        }
        if (this.fKI != null) {
            this.fKI.k(bdUniqueId);
        }
        if (this.fKK != null) {
            this.fKK.n(bdUniqueId);
        }
        if (this.fKE != null) {
            this.fKE.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.WM().setTag(bdUniqueId);
        if (this.bZc != null) {
            this.bZc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bZc);
        }
        if (this.fKJ != null) {
            this.fKJ.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        n nVar = new n();
        nVar.CC(String.valueOf(floatInfo.activity_id));
        nVar.dV(floatInfo.dynamic_url);
        nVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        nVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        nVar.CB(floatInfo.float_url);
        nVar.CA(floatInfo.jump_url);
        nVar.setType(floatInfo.show_type.intValue());
        return nVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.fKL = 0L;
        this.mSkinType = 3;
        this.eZG = false;
        this.fKN = false;
        this.fKO = 0;
        this.fKP = 0;
        this.fKQ = false;
        this.fKR = 1;
        this.eHt = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eHs == null) {
                            PersonalizePageView.this.eHs = new k(new i());
                        }
                        PersonalizePageView.this.eHs.a(PersonalizePageView.this.fHN, 2);
                    } else if (PersonalizePageView.this.eHs != null) {
                        PersonalizePageView.this.eHs.pg();
                    }
                }
            }
        };
        this.fKS = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.fKG != null) {
                        PersonalizePageView.this.fKG.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("obj_param1", ajVar.weight).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bJ(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bJ("obj_type", sb.toString()).bJ("obj_name", str).T("obj_param2", i));
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            private int dcH = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dcH != i && PersonalizePageView.this.fKT != null) {
                    this.dcH = i;
                    if (this.dcH == 1) {
                        PersonalizePageView.this.fKT.aBE();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fKT.aBF();
                    } else {
                        PersonalizePageView.this.fKT.aBE();
                    }
                }
            }
        };
        this.fKU = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bmk() {
                if (PersonalizePageView.this.fKT != null) {
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fHN)) {
                        PersonalizePageView.this.fKT.aBF();
                    } else {
                        PersonalizePageView.this.fKT.aBE();
                    }
                }
            }
        };
        this.fKV = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void K(int i, int i2, int i3) {
                if (PersonalizePageView.this.fKH == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aXr = PersonalizePageView.this.aXr();
                PersonalizePageView.this.aBt();
                if (aXr) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.fKH.J(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.fKH != null) {
                    PersonalizePageView.this.fKH.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.fKC.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.kY()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.fKC.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aBt();
                n a2 = PersonalizePageView.this.a(PersonalizePageView.this.fKI.bmG());
                PersonalizePageView.this.dO(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.faW != null) {
                    PersonalizePageView.this.faW.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bmu() {
                if (PersonalizePageView.this.dbn != null) {
                    PersonalizePageView.this.dbn.setText(PersonalizePageView.this.getContext().getString(d.j.recommend_no_more_data));
                    PersonalizePageView.this.dbn.aeD();
                    PersonalizePageView.this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.fKW = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                com.baidu.tieba.a.d.awk().qK("page_recommend");
                PersonalizePageView.this.fKI.update();
                PersonalizePageView.this.fKI.kp(false);
                PersonalizePageView.this.fKQ = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.fKX = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void dS(boolean z) {
                if (PersonalizePageView.this.fKI != null && PersonalizePageView.this.fKI.bdo() != null) {
                    PersonalizePageView.this.fKI.bdo().boo();
                }
            }
        };
        this.fKY = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void aeT() {
                if (PersonalizePageView.this.fKQ) {
                    PersonalizePageView.this.fKP = 0;
                    PersonalizePageView.this.fKR = 1;
                    PersonalizePageView.this.fKQ = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.fKZ = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.fKI != null) {
                    PersonalizePageView.this.fKI.kp(true);
                    PersonalizePageView.this.fKI.bmz();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.WM().gc(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.fLa = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.u(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.bZc = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bms();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fGj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aBc();
            }
        };
        this.faq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.eZG = true;
                    }
                }
            }
        };
        this.fLb = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fKC != null && !PersonalizePageView.this.fKC.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.fKE == null) {
                            PersonalizePageView.this.fKE = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.fKE.ic(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.fKF = PersonalizePageView.this.fKE;
                            PersonalizePageView.this.bmq();
                        } else if (PersonalizePageView.this.fKF != PersonalizePageView.this.fKE) {
                            PersonalizePageView.this.fKF = PersonalizePageView.this.fKE;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.fKE.setEnable(true);
                        PersonalizePageView.this.fKC.setProgressView(PersonalizePageView.this.fKE);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fKC.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.fKD == null) {
                        PersonalizePageView.this.fKD = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.fKF = PersonalizePageView.this.fKD;
                        PersonalizePageView.this.bmq();
                    } else if (PersonalizePageView.this.fKF != PersonalizePageView.this.fKD || !aVar.equals(PersonalizePageView.this.fKD.bmT())) {
                        PersonalizePageView.this.fKF = PersonalizePageView.this.fKD;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.fKD.setEnable(true);
                    PersonalizePageView.this.fKC.setProgressView(PersonalizePageView.this.fKD);
                    PersonalizePageView.this.fKD.a(aVar);
                    PersonalizePageView.this.fKC.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fKL = 0L;
        this.mSkinType = 3;
        this.eZG = false;
        this.fKN = false;
        this.fKO = 0;
        this.fKP = 0;
        this.fKQ = false;
        this.fKR = 1;
        this.eHt = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eHs == null) {
                            PersonalizePageView.this.eHs = new k(new i());
                        }
                        PersonalizePageView.this.eHs.a(PersonalizePageView.this.fHN, 2);
                    } else if (PersonalizePageView.this.eHs != null) {
                        PersonalizePageView.this.eHs.pg();
                    }
                }
            }
        };
        this.fKS = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.fKG != null) {
                        PersonalizePageView.this.fKG.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("obj_param1", ajVar.weight).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bJ(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bJ("obj_type", sb.toString()).bJ("obj_name", str).T("obj_param2", i));
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            private int dcH = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dcH != i && PersonalizePageView.this.fKT != null) {
                    this.dcH = i;
                    if (this.dcH == 1) {
                        PersonalizePageView.this.fKT.aBE();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fKT.aBF();
                    } else {
                        PersonalizePageView.this.fKT.aBE();
                    }
                }
            }
        };
        this.fKU = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bmk() {
                if (PersonalizePageView.this.fKT != null) {
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fHN)) {
                        PersonalizePageView.this.fKT.aBF();
                    } else {
                        PersonalizePageView.this.fKT.aBE();
                    }
                }
            }
        };
        this.fKV = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void K(int i, int i2, int i3) {
                if (PersonalizePageView.this.fKH == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aXr = PersonalizePageView.this.aXr();
                PersonalizePageView.this.aBt();
                if (aXr) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.fKH.J(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.fKH != null) {
                    PersonalizePageView.this.fKH.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.fKC.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.kY()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.fKC.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aBt();
                n a2 = PersonalizePageView.this.a(PersonalizePageView.this.fKI.bmG());
                PersonalizePageView.this.dO(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.faW != null) {
                    PersonalizePageView.this.faW.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bmu() {
                if (PersonalizePageView.this.dbn != null) {
                    PersonalizePageView.this.dbn.setText(PersonalizePageView.this.getContext().getString(d.j.recommend_no_more_data));
                    PersonalizePageView.this.dbn.aeD();
                    PersonalizePageView.this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.fKW = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                com.baidu.tieba.a.d.awk().qK("page_recommend");
                PersonalizePageView.this.fKI.update();
                PersonalizePageView.this.fKI.kp(false);
                PersonalizePageView.this.fKQ = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.fKX = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void dS(boolean z) {
                if (PersonalizePageView.this.fKI != null && PersonalizePageView.this.fKI.bdo() != null) {
                    PersonalizePageView.this.fKI.bdo().boo();
                }
            }
        };
        this.fKY = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void aeT() {
                if (PersonalizePageView.this.fKQ) {
                    PersonalizePageView.this.fKP = 0;
                    PersonalizePageView.this.fKR = 1;
                    PersonalizePageView.this.fKQ = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.fKZ = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.fKI != null) {
                    PersonalizePageView.this.fKI.kp(true);
                    PersonalizePageView.this.fKI.bmz();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.WM().gc(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.fLa = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.u(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.bZc = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bms();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fGj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aBc();
            }
        };
        this.faq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.eZG = true;
                    }
                }
            }
        };
        this.fLb = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fKC != null && !PersonalizePageView.this.fKC.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.fKE == null) {
                            PersonalizePageView.this.fKE = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.fKE.ic(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.fKF = PersonalizePageView.this.fKE;
                            PersonalizePageView.this.bmq();
                        } else if (PersonalizePageView.this.fKF != PersonalizePageView.this.fKE) {
                            PersonalizePageView.this.fKF = PersonalizePageView.this.fKE;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.fKE.setEnable(true);
                        PersonalizePageView.this.fKC.setProgressView(PersonalizePageView.this.fKE);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fKC.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.fKD == null) {
                        PersonalizePageView.this.fKD = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.fKF = PersonalizePageView.this.fKD;
                        PersonalizePageView.this.bmq();
                    } else if (PersonalizePageView.this.fKF != PersonalizePageView.this.fKD || !aVar.equals(PersonalizePageView.this.fKD.bmT())) {
                        PersonalizePageView.this.fKF = PersonalizePageView.this.fKD;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.fKD.setEnable(true);
                    PersonalizePageView.this.fKC.setProgressView(PersonalizePageView.this.fKD);
                    PersonalizePageView.this.fKD.a(aVar);
                    PersonalizePageView.this.fKC.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fKL = 0L;
        this.mSkinType = 3;
        this.eZG = false;
        this.fKN = false;
        this.fKO = 0;
        this.fKP = 0;
        this.fKQ = false;
        this.fKR = 1;
        this.eHt = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eHs == null) {
                            PersonalizePageView.this.eHs = new k(new i());
                        }
                        PersonalizePageView.this.eHs.a(PersonalizePageView.this.fHN, 2);
                    } else if (PersonalizePageView.this.eHs != null) {
                        PersonalizePageView.this.eHs.pg();
                    }
                }
            }
        };
        this.fKS = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.fKG != null) {
                        PersonalizePageView.this.fKG.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("obj_param1", ajVar.weight).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bJ(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bJ("obj_type", sb.toString()).bJ("obj_name", str).T("obj_param2", i2));
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            private int dcH = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (this.dcH != i2 && PersonalizePageView.this.fKT != null) {
                    this.dcH = i2;
                    if (this.dcH == 1) {
                        PersonalizePageView.this.fKT.aBE();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fKT.aBF();
                    } else {
                        PersonalizePageView.this.fKT.aBE();
                    }
                }
            }
        };
        this.fKU = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bmk() {
                if (PersonalizePageView.this.fKT != null) {
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fHN)) {
                        PersonalizePageView.this.fKT.aBF();
                    } else {
                        PersonalizePageView.this.fKT.aBE();
                    }
                }
            }
        };
        this.fKV = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void K(int i2, int i22, int i3) {
                if (PersonalizePageView.this.fKH == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aXr = PersonalizePageView.this.aXr();
                PersonalizePageView.this.aBt();
                if (aXr) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.fKH.J(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.fKH != null) {
                    PersonalizePageView.this.fKH.u(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.fKC.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.kY()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.fKC.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aBt();
                n a2 = PersonalizePageView.this.a(PersonalizePageView.this.fKI.bmG());
                PersonalizePageView.this.dO(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.faW != null) {
                    PersonalizePageView.this.faW.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bmu() {
                if (PersonalizePageView.this.dbn != null) {
                    PersonalizePageView.this.dbn.setText(PersonalizePageView.this.getContext().getString(d.j.recommend_no_more_data));
                    PersonalizePageView.this.dbn.aeD();
                    PersonalizePageView.this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.fKW = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                com.baidu.tieba.a.d.awk().qK("page_recommend");
                PersonalizePageView.this.fKI.update();
                PersonalizePageView.this.fKI.kp(false);
                PersonalizePageView.this.fKQ = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.fKX = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void dS(boolean z) {
                if (PersonalizePageView.this.fKI != null && PersonalizePageView.this.fKI.bdo() != null) {
                    PersonalizePageView.this.fKI.bdo().boo();
                }
            }
        };
        this.fKY = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void aeT() {
                if (PersonalizePageView.this.fKQ) {
                    PersonalizePageView.this.fKP = 0;
                    PersonalizePageView.this.fKR = 1;
                    PersonalizePageView.this.fKQ = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.fKZ = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.fKI != null) {
                    PersonalizePageView.this.fKI.kp(true);
                    PersonalizePageView.this.fKI.bmz();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.WM().gc(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.fLa = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.u(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.bZc = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bms();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fGj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aBc();
            }
        };
        this.faq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.eZG = true;
                    }
                }
            }
        };
        this.fLb = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fKC != null && !PersonalizePageView.this.fKC.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.fKE == null) {
                            PersonalizePageView.this.fKE = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.fKE.ic(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.fKF = PersonalizePageView.this.fKE;
                            PersonalizePageView.this.bmq();
                        } else if (PersonalizePageView.this.fKF != PersonalizePageView.this.fKE) {
                            PersonalizePageView.this.fKF = PersonalizePageView.this.fKE;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.fKE.setEnable(true);
                        PersonalizePageView.this.fKC.setProgressView(PersonalizePageView.this.fKE);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fKC.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.fKD == null) {
                        PersonalizePageView.this.fKD = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.fKF = PersonalizePageView.this.fKD;
                        PersonalizePageView.this.bmq();
                    } else if (PersonalizePageView.this.fKF != PersonalizePageView.this.fKD || !aVar.equals(PersonalizePageView.this.fKD.bmT())) {
                        PersonalizePageView.this.fKF = PersonalizePageView.this.fKD;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.fKD.setEnable(true);
                    PersonalizePageView.this.fKC.setProgressView(PersonalizePageView.this.fKD);
                    PersonalizePageView.this.fKD.a(aVar);
                    PersonalizePageView.this.fKC.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fHN = new BdTypeRecyclerView(context);
        this.biP = new LinearLayoutManager(this.fHN.getContext());
        this.fHN.setLayoutManager(this.biP);
        this.fHN.setFadingEdgeLength(0);
        this.fHN.setOverScrollMode(2);
        this.fHN.addOnScrollListener(this.mOnScrollListener);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.eHs = new k(new i());
            this.eHs.a(this.fHN, 2);
        }
        MessageManager.getInstance().registerListener(this.eHt);
        this.fKC = new BigdaySwipeRefreshLayout(context);
        this.fKC.addView(this.fHN);
        this.dbn = new PbListView(context);
        this.dbn.getView();
        this.dbn.ib(d.C0277d.cp_bg_line_e);
        this.dbn.aez();
        this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbn.setTextSize(d.e.tbfontsize33);
        this.dbn.ia(d.C0277d.cp_cont_e);
        this.dbn.setHeight(l.h(context, d.e.tbds182));
        this.dbn.setOnClickListener(this.fGj);
        this.fHN.setNextPage(this.dbn);
        com.baidu.adp.base.e<?> aK = com.baidu.adp.base.i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        MessageManager.getInstance().registerListener(this.fLb);
        com.baidu.tbadk.core.bigday.b.WM().dh(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.WM().gc(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.fKC);
        ((FrameLayout.LayoutParams) this.fKC.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.fKK = new com.baidu.tieba.homepage.personalize.model.e();
        this.fKG = new v(context, this.fHN);
        this.fKG.b(this.fKK);
        this.fKI = new e(this.pageContext, this.fHN, this.fKG, this.fKC);
        this.fKJ = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.faq);
        this.fKO = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO(Context context) {
        if (this.fKM == null) {
            this.fKM = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.h(context, d.e.tbds200), l.h(context, d.e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.h(context, d.e.tbds200);
            addView(this.fKM, layoutParams);
            this.fKM.setVisibility(8);
            this.fKM.setPageId(this.pageContext.getUniqueId());
            this.faW = new com.baidu.tieba.c.c(this.pageContext, this.fKM, 1);
        }
    }

    public void bmq() {
        if (this.fKF != null) {
            this.fKF.setListPullRefreshListener(this.fKW);
            this.fKF.a(this.fKX);
            this.fKF.a(this.fKY);
            this.fKF.a(this.fKZ);
        }
    }

    public void bgA() {
        this.fKG.b(this.fKS);
        this.fKI.a(this.fKV);
        this.fKJ.a(this);
        bmq();
        this.fHN.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                PersonalizePageView.this.fKP += i2;
                if (PersonalizePageView.this.fKP < height * 3 || PersonalizePageView.this.fKR != 1) {
                    if (PersonalizePageView.this.fKP < height * 3 && PersonalizePageView.this.fKR == 2) {
                        PersonalizePageView.this.fKR = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        return;
                    }
                    return;
                }
                PersonalizePageView.this.fKR = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.fKR)));
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.biP != null && i == 0 && PersonalizePageView.this.biP.getItemCount() - PersonalizePageView.this.biP.findLastVisibleItemPosition() <= 3) {
                    PersonalizePageView.this.aBc();
                }
            }
        });
        this.fHN.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aBc();
            }
        });
        this.fHN.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.fKL >= 5000) {
                    PersonalizePageView.this.fKI.bv(i, i2);
                }
            }
        }, 1L);
        this.fHN.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.fKI != null && PersonalizePageView.this.fKI.bdo() != null) {
                        PersonalizePageView.this.fKI.bdo().cb(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).aRi().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.fKH = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.dbn != null) {
            this.dbn.setText(getContext().getString(d.j.pb_load_more));
            this.dbn.aeD();
            this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fKI.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.fKI != null) {
            this.fKI.km(!z);
        }
        this.fKN = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.fKN;
    }

    public void f(Long l) {
        this.fKI.f(l);
    }

    public void setHeaderViewHeight(int i) {
        this.dbx = i;
        if (this.fKC != null && this.fKC.getLayoutParams() != null) {
            if (this.fKI != null) {
                this.fKI.setHeaderViewHeight(i);
            }
            if (this.fKJ != null) {
                this.fKJ.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.fKI != null) {
            this.fKI.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void showFloatingView() {
        if (this.fKI != null) {
            this.fKI.showFloatingView();
        }
    }

    public void bmr() {
        if (this.fKI != null) {
            this.fKI.bmr();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cXm != null) {
                this.cXm.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            al.l(this.fKC, d.C0277d.cp_bg_line_e);
            if (this.fKE != null) {
                this.fKE.ic(i);
            }
            if (this.dbn != null) {
                this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_d));
                this.dbn.ic(i);
            }
            this.fKG.onChangeSkinType(i);
            if (this.fKI != null) {
                this.fKI.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aC(String str, int i) {
        if (this.dbn != null) {
            this.dbn.setText(getContext().getString(d.j.pb_load_more));
            this.dbn.aeD();
            this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fKI.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.fKI != null) {
                        PersonalizePageView.this.fKI.update();
                    }
                }
            });
        }
        this.refreshView.jS(this.dbx);
        this.refreshView.po(str);
        this.refreshView.attachView(view, z);
        this.refreshView.anB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBt() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.cXm != null) {
            this.cXm.dettachView(this);
            this.cXm = null;
            this.fHN.setNextPage(this.dbn);
            this.dbn.setText(getContext().getString(d.j.pb_load_more));
            this.dbn.aeD();
            this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        if (this.fKC != null) {
            this.fKC.setVisibility(0);
        }
        if (this.fKH != null) {
            this.fKH.blR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXr() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.cXm == null) {
            if (i < 0) {
                this.cXm = new g(getContext());
            } else {
                this.cXm = new g(getContext(), i);
            }
            this.cXm.onChangeSkinType();
        }
        this.cXm.attachView(this, z);
        this.fHN.setNextPage(null);
        if (this.fKC != null) {
            this.fKC.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.fKI != null) {
            this.fKI.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.faW != null) {
            this.faW.aSm();
        }
        setViewForeground(false);
        if (this.fKI != null) {
            this.fKI.ji(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.fKO < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.fLa, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.fKI != null) {
            this.fKI.kg(z);
        }
    }

    public void blZ() {
        if (this.fKI != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.fKI.update();
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.WM().WO();
            com.baidu.tbadk.core.bigday.b.WM().WN();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.fKI != null) {
            this.fKI.update();
        } else if (this.fHN != null && this.fKC != null) {
            showFloatingView();
            this.fHN.setSelection(0);
            if (!this.fKC.isRefreshing()) {
                if (this.fKI != null && this.fKI.bdo() != null) {
                    this.fKI.bdo().boo();
                    this.fKI.kp(false);
                }
                this.fKC.setRefreshing(true);
            }
            if (this.fKU != null) {
                this.fKU.bmk();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eHt);
        MessageManager.getInstance().unRegisterListener(this.faq);
        MessageManager.getInstance().unRegisterListener(this.fLb);
        this.fKI.onDestroy();
        this.fKG.b((NEGFeedBackView.a) null);
        this.fKG.onDestroy();
        this.fKI.a((e.a) null);
        if (this.fKD != null) {
            this.fKD.setListPullRefreshListener(null);
            this.fKD.a((h.d) null);
            this.fKD.a((h.a) null);
            this.fKD.a((h.b) null);
            this.fKD.release();
        }
        if (this.fKE != null) {
            this.fKE.setListPullRefreshListener(null);
            this.fKE.a((h.d) null);
            this.fKE.a((h.a) null);
            this.fKE.a((h.b) null);
            this.fKE.release();
        }
        this.fHN.setOnSrollToBottomListener(null);
        this.fHN.removeOnScrollListener(this.mOnScrollListener);
        if (this.fKT != null) {
            this.fKT.b(this.fKU);
        }
        if (this.cXm != null) {
            this.cXm.release();
        }
        this.fHN.setRecyclerListener(null);
        if (this.fKJ != null) {
            this.fKJ.onDestroy();
        }
        if (this.faW != null) {
            this.faW.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.WM().destroy();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fLa);
    }

    public void onPause() {
        this.fKI.onPause();
        if (this.fKG != null) {
            this.fKG.onPause();
        }
    }

    public void onResume() {
        if (this.eZG) {
            reload();
            this.eZG = false;
        }
        if (this.fKC != null) {
            this.fKC.resume();
        }
        if (this.fKG != null) {
            this.fKG.onResume();
        }
    }

    public void bms() {
        if (this.fKG != null) {
            this.fKG.notifyDataSetChanged();
        }
    }

    public void blt() {
        if (this.fKI != null) {
            this.fKI.ji(true);
        }
        t.aQF().go(false);
        com.baidu.tieba.a.d.awk().bA("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fLa);
    }

    public void bmn() {
        this.fKI.bmF();
    }

    public void bmt() {
        this.fKI.bmt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBc() {
        com.baidu.tieba.homepage.framework.a.blQ().p(System.currentTimeMillis(), 1);
        if (this.dbn != null && !this.dbn.qz()) {
            this.dbn.aeC();
            this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fKI.aBc();
    }
}
