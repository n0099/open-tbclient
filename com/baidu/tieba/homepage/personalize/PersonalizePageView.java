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
import com.baidu.tbadk.util.x;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.w;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.e;
import com.baidu.tieba.tbadkCore.data.o;
import com.baidu.tieba.view.FloatingAnimationView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes4.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager boW;
    private final CustomMessageListener chc;
    private g dhY;
    private PbListView dlY;
    private int dnp;
    private k eXp;
    private CustomMessageListener eXr;
    private BdTypeRecyclerView fWV;
    private ScrollFragmentTabHost fXb;
    ScrollFragmentTabHost.a fXc;
    private BigdaySwipeRefreshLayout fXd;
    private View.OnClickListener fXf;
    private boolean fpF;
    private com.baidu.tieba.c.c fqY;
    private CustomMessageListener fqs;
    private com.baidu.tieba.homepage.personalize.bigday.b gbA;
    private com.baidu.tieba.homepage.personalize.bigday.a gbB;
    private a gbC;
    private w gbD;
    private com.baidu.tieba.homepage.framework.b gbE;
    private e gbF;
    private com.baidu.tieba.homepage.personalize.a gbG;
    private com.baidu.tieba.homepage.personalize.model.e gbH;
    private long gbI;
    private FloatingAnimationView gbJ;
    private boolean gbK;
    private int gbL;
    private int gbM;
    private boolean gbN;
    private int gbO;
    private NEGFeedBackView.a gbP;
    private e.a gbQ;
    h.c gbR;
    h.d gbS;
    h.a gbT;
    h.b gbU;
    private Runnable gbV;
    public CustomMessageListener gbW;
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

    static /* synthetic */ int v(PersonalizePageView personalizePageView) {
        int i = personalizePageView.gbL + 1;
        personalizePageView.gbL = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fXb = scrollFragmentTabHost;
        if (this.fXb != null) {
            this.fXb.b(this.fXc);
            this.fXb.a(this.fXc);
        }
        if (this.gbF != null) {
            this.gbF.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gbG != null) {
            this.gbG.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.fXd != null) {
            this.fXd.oz();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gbD != null) {
            this.gbD.setPageUniqueId(bdUniqueId);
        }
        if (this.gbF != null) {
            this.gbF.k(bdUniqueId);
        }
        if (this.gbH != null) {
            this.gbH.o(bdUniqueId);
        }
        if (this.gbB != null) {
            this.gbB.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.abp().setTag(bdUniqueId);
        if (this.chc != null) {
            this.chc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.chc);
        }
        if (this.gbG != null) {
            this.gbG.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        o oVar = new o();
        oVar.DX(String.valueOf(floatInfo.activity_id));
        oVar.ec(floatInfo.dynamic_url);
        oVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        oVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        oVar.DW(floatInfo.float_url);
        oVar.DV(floatInfo.jump_url);
        oVar.setType(floatInfo.show_type.intValue());
        return oVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.gbI = 0L;
        this.mSkinType = 3;
        this.fpF = false;
        this.gbK = false;
        this.gbL = 0;
        this.gbM = 0;
        this.gbN = false;
        this.gbO = 1;
        this.eXr = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eXp == null) {
                            PersonalizePageView.this.eXp = new k(new i());
                        }
                        PersonalizePageView.this.eXp.a(PersonalizePageView.this.fWV, 2);
                    } else if (PersonalizePageView.this.eXp != null) {
                        PersonalizePageView.this.eXp.oa();
                    }
                }
            }
        };
        this.gbP = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                if (ajVar != null) {
                    TiebaStatic.log(new am("c11693").bT("obj_locate", "1").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.gbD != null) {
                        PersonalizePageView.this.gbD.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
                }
            }
        };
        this.dnp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dnp != i && PersonalizePageView.this.fXb != null) {
                    PersonalizePageView.this.dnp = i;
                    if (PersonalizePageView.this.dnp == 1) {
                        PersonalizePageView.this.fXb.aHU();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fXb.aHV();
                    } else {
                        PersonalizePageView.this.fXb.aHU();
                    }
                }
            }
        };
        this.fXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btH() {
                if (PersonalizePageView.this.fXb != null) {
                    PersonalizePageView.this.dnp = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fWV)) {
                        PersonalizePageView.this.fXb.aHV();
                    } else {
                        PersonalizePageView.this.fXb.aHU();
                    }
                }
            }
        };
        this.gbQ = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fex = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_first_install", true);

            private void btV() {
                if (this.fex) {
                    this.fex = false;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void L(int i, int i2, int i3) {
                if (PersonalizePageView.this.gbE == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean beG = PersonalizePageView.this.beG();
                PersonalizePageView.this.aHK();
                if (beG) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gbE.K(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gbE != null) {
                    PersonalizePageView.this.gbE.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.jS()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    btV();
                } else if (!this.fex) {
                    PersonalizePageView.this.fXd.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    btV();
                    PersonalizePageView.this.btw();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                btV();
                PersonalizePageView.this.fXd.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aHK();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gbF.bui());
                PersonalizePageView.this.dE(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fqY != null) {
                    PersonalizePageView.this.fqY.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void btW() {
                if (PersonalizePageView.this.dlY != null) {
                    PersonalizePageView.this.dlY.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dlY.ajz();
                }
            }
        };
        this.gbR = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                com.baidu.tieba.a.d.aBq().rU("page_recommend");
                PersonalizePageView.this.gbF.update();
                PersonalizePageView.this.gbF.lf(false);
                PersonalizePageView.this.gbN = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gbS = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void eo(boolean z) {
                if (PersonalizePageView.this.gbF != null && PersonalizePageView.this.gbF.bkH() != null) {
                    PersonalizePageView.this.gbF.bkH().bvR();
                }
            }
        };
        this.gbT = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void ajP() {
                if (PersonalizePageView.this.gbN) {
                    PersonalizePageView.this.gbM = 0;
                    PersonalizePageView.this.gbO = 1;
                    PersonalizePageView.this.gbN = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gbU = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.gbF != null) {
                    PersonalizePageView.this.gbF.lf(true);
                    PersonalizePageView.this.gbF.bub();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.abp().gN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gbV = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.chc = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bsP();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fXf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aHt();
            }
        };
        this.fqs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fpF = true;
                    }
                }
            }
        };
        this.gbW = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fXd != null && !PersonalizePageView.this.fXd.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gbB == null) {
                            PersonalizePageView.this.gbB = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gbB.iP(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gbC = PersonalizePageView.this.gbB;
                            PersonalizePageView.this.btS();
                        } else if (PersonalizePageView.this.gbC != PersonalizePageView.this.gbB) {
                            PersonalizePageView.this.gbC = PersonalizePageView.this.gbB;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gbB.setEnable(true);
                        PersonalizePageView.this.fXd.setProgressView(PersonalizePageView.this.gbB);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fXd.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gbA == null) {
                        PersonalizePageView.this.gbA = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gbC = PersonalizePageView.this.gbA;
                        PersonalizePageView.this.btS();
                    } else if (PersonalizePageView.this.gbC != PersonalizePageView.this.gbA || !aVar.equals(PersonalizePageView.this.gbA.buv())) {
                        PersonalizePageView.this.gbC = PersonalizePageView.this.gbA;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gbA.setEnable(true);
                    PersonalizePageView.this.fXd.setProgressView(PersonalizePageView.this.gbA);
                    PersonalizePageView.this.gbA.a(aVar);
                    PersonalizePageView.this.fXd.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbI = 0L;
        this.mSkinType = 3;
        this.fpF = false;
        this.gbK = false;
        this.gbL = 0;
        this.gbM = 0;
        this.gbN = false;
        this.gbO = 1;
        this.eXr = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eXp == null) {
                            PersonalizePageView.this.eXp = new k(new i());
                        }
                        PersonalizePageView.this.eXp.a(PersonalizePageView.this.fWV, 2);
                    } else if (PersonalizePageView.this.eXp != null) {
                        PersonalizePageView.this.eXp.oa();
                    }
                }
            }
        };
        this.gbP = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                if (ajVar != null) {
                    TiebaStatic.log(new am("c11693").bT("obj_locate", "1").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.gbD != null) {
                        PersonalizePageView.this.gbD.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
                }
            }
        };
        this.dnp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dnp != i && PersonalizePageView.this.fXb != null) {
                    PersonalizePageView.this.dnp = i;
                    if (PersonalizePageView.this.dnp == 1) {
                        PersonalizePageView.this.fXb.aHU();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fXb.aHV();
                    } else {
                        PersonalizePageView.this.fXb.aHU();
                    }
                }
            }
        };
        this.fXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btH() {
                if (PersonalizePageView.this.fXb != null) {
                    PersonalizePageView.this.dnp = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fWV)) {
                        PersonalizePageView.this.fXb.aHV();
                    } else {
                        PersonalizePageView.this.fXb.aHU();
                    }
                }
            }
        };
        this.gbQ = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fex = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_first_install", true);

            private void btV() {
                if (this.fex) {
                    this.fex = false;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void L(int i, int i2, int i3) {
                if (PersonalizePageView.this.gbE == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean beG = PersonalizePageView.this.beG();
                PersonalizePageView.this.aHK();
                if (beG) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gbE.K(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gbE != null) {
                    PersonalizePageView.this.gbE.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.jS()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    btV();
                } else if (!this.fex) {
                    PersonalizePageView.this.fXd.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    btV();
                    PersonalizePageView.this.btw();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                btV();
                PersonalizePageView.this.fXd.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aHK();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gbF.bui());
                PersonalizePageView.this.dE(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fqY != null) {
                    PersonalizePageView.this.fqY.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void btW() {
                if (PersonalizePageView.this.dlY != null) {
                    PersonalizePageView.this.dlY.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dlY.ajz();
                }
            }
        };
        this.gbR = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                com.baidu.tieba.a.d.aBq().rU("page_recommend");
                PersonalizePageView.this.gbF.update();
                PersonalizePageView.this.gbF.lf(false);
                PersonalizePageView.this.gbN = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gbS = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void eo(boolean z) {
                if (PersonalizePageView.this.gbF != null && PersonalizePageView.this.gbF.bkH() != null) {
                    PersonalizePageView.this.gbF.bkH().bvR();
                }
            }
        };
        this.gbT = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void ajP() {
                if (PersonalizePageView.this.gbN) {
                    PersonalizePageView.this.gbM = 0;
                    PersonalizePageView.this.gbO = 1;
                    PersonalizePageView.this.gbN = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gbU = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.gbF != null) {
                    PersonalizePageView.this.gbF.lf(true);
                    PersonalizePageView.this.gbF.bub();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.abp().gN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gbV = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.chc = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bsP();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fXf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aHt();
            }
        };
        this.fqs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fpF = true;
                    }
                }
            }
        };
        this.gbW = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fXd != null && !PersonalizePageView.this.fXd.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gbB == null) {
                            PersonalizePageView.this.gbB = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gbB.iP(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gbC = PersonalizePageView.this.gbB;
                            PersonalizePageView.this.btS();
                        } else if (PersonalizePageView.this.gbC != PersonalizePageView.this.gbB) {
                            PersonalizePageView.this.gbC = PersonalizePageView.this.gbB;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gbB.setEnable(true);
                        PersonalizePageView.this.fXd.setProgressView(PersonalizePageView.this.gbB);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fXd.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gbA == null) {
                        PersonalizePageView.this.gbA = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gbC = PersonalizePageView.this.gbA;
                        PersonalizePageView.this.btS();
                    } else if (PersonalizePageView.this.gbC != PersonalizePageView.this.gbA || !aVar.equals(PersonalizePageView.this.gbA.buv())) {
                        PersonalizePageView.this.gbC = PersonalizePageView.this.gbA;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gbA.setEnable(true);
                    PersonalizePageView.this.fXd.setProgressView(PersonalizePageView.this.gbA);
                    PersonalizePageView.this.gbA.a(aVar);
                    PersonalizePageView.this.fXd.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbI = 0L;
        this.mSkinType = 3;
        this.fpF = false;
        this.gbK = false;
        this.gbL = 0;
        this.gbM = 0;
        this.gbN = false;
        this.gbO = 1;
        this.eXr = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eXp == null) {
                            PersonalizePageView.this.eXp = new k(new i());
                        }
                        PersonalizePageView.this.eXp.a(PersonalizePageView.this.fWV, 2);
                    } else if (PersonalizePageView.this.eXp != null) {
                        PersonalizePageView.this.eXp.oa();
                    }
                }
            }
        };
        this.gbP = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                if (ajVar != null) {
                    TiebaStatic.log(new am("c11693").bT("obj_locate", "1").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.gbD != null) {
                        PersonalizePageView.this.gbD.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i2));
                }
            }
        };
        this.dnp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.dnp != i2 && PersonalizePageView.this.fXb != null) {
                    PersonalizePageView.this.dnp = i2;
                    if (PersonalizePageView.this.dnp == 1) {
                        PersonalizePageView.this.fXb.aHU();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fXb.aHV();
                    } else {
                        PersonalizePageView.this.fXb.aHU();
                    }
                }
            }
        };
        this.fXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btH() {
                if (PersonalizePageView.this.fXb != null) {
                    PersonalizePageView.this.dnp = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fWV)) {
                        PersonalizePageView.this.fXb.aHV();
                    } else {
                        PersonalizePageView.this.fXb.aHU();
                    }
                }
            }
        };
        this.gbQ = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fex = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_first_install", true);

            private void btV() {
                if (this.fex) {
                    this.fex = false;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void L(int i2, int i22, int i3) {
                if (PersonalizePageView.this.gbE == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean beG = PersonalizePageView.this.beG();
                PersonalizePageView.this.aHK();
                if (beG) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gbE.K(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.gbE != null) {
                    PersonalizePageView.this.gbE.u(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.jS()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    btV();
                } else if (!this.fex) {
                    PersonalizePageView.this.fXd.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    btV();
                    PersonalizePageView.this.btw();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                btV();
                PersonalizePageView.this.fXd.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aHK();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gbF.bui());
                PersonalizePageView.this.dE(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fqY != null) {
                    PersonalizePageView.this.fqY.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void btW() {
                if (PersonalizePageView.this.dlY != null) {
                    PersonalizePageView.this.dlY.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dlY.ajz();
                }
            }
        };
        this.gbR = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                com.baidu.tieba.a.d.aBq().rU("page_recommend");
                PersonalizePageView.this.gbF.update();
                PersonalizePageView.this.gbF.lf(false);
                PersonalizePageView.this.gbN = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gbS = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void eo(boolean z) {
                if (PersonalizePageView.this.gbF != null && PersonalizePageView.this.gbF.bkH() != null) {
                    PersonalizePageView.this.gbF.bkH().bvR();
                }
            }
        };
        this.gbT = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void ajP() {
                if (PersonalizePageView.this.gbN) {
                    PersonalizePageView.this.gbM = 0;
                    PersonalizePageView.this.gbO = 1;
                    PersonalizePageView.this.gbN = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gbU = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.gbF != null) {
                    PersonalizePageView.this.gbF.lf(true);
                    PersonalizePageView.this.gbF.bub();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.abp().gN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gbV = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.chc = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bsP();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fXf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aHt();
            }
        };
        this.fqs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fpF = true;
                    }
                }
            }
        };
        this.gbW = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fXd != null && !PersonalizePageView.this.fXd.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gbB == null) {
                            PersonalizePageView.this.gbB = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gbB.iP(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gbC = PersonalizePageView.this.gbB;
                            PersonalizePageView.this.btS();
                        } else if (PersonalizePageView.this.gbC != PersonalizePageView.this.gbB) {
                            PersonalizePageView.this.gbC = PersonalizePageView.this.gbB;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gbB.setEnable(true);
                        PersonalizePageView.this.fXd.setProgressView(PersonalizePageView.this.gbB);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fXd.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gbA == null) {
                        PersonalizePageView.this.gbA = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gbC = PersonalizePageView.this.gbA;
                        PersonalizePageView.this.btS();
                    } else if (PersonalizePageView.this.gbC != PersonalizePageView.this.gbA || !aVar.equals(PersonalizePageView.this.gbA.buv())) {
                        PersonalizePageView.this.gbC = PersonalizePageView.this.gbA;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gbA.setEnable(true);
                    PersonalizePageView.this.fXd.setProgressView(PersonalizePageView.this.gbA);
                    PersonalizePageView.this.gbA.a(aVar);
                    PersonalizePageView.this.fXd.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fWV = new BdTypeRecyclerView(context);
        this.boW = new LinearLayoutManager(this.fWV.getContext());
        this.fWV.setLayoutManager(this.boW);
        this.fWV.setFadingEdgeLength(0);
        this.fWV.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.eXp = new k(new i());
            this.eXp.a(this.fWV, 2);
        }
        MessageManager.getInstance().registerListener(this.eXr);
        this.fXd = new BigdaySwipeRefreshLayout(context);
        this.fXd.addView(this.fWV);
        this.dlY = new PbListView(context);
        this.dlY.getView();
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.ajv();
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.iN(R.color.cp_cont_e);
        this.dlY.setHeight(l.g(context, R.dimen.tbds182));
        this.dlY.setOnClickListener(this.fXf);
        this.dlY.ajC();
        this.fWV.setNextPage(this.dlY);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.gbW);
        com.baidu.tbadk.core.bigday.b.abp().dC(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.abp().gN(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.fXd);
        ((FrameLayout.LayoutParams) this.fXd.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.gbH = new com.baidu.tieba.homepage.personalize.model.e();
        this.gbD = new w(context, this.fWV);
        this.gbD.b(this.gbH);
        this.gbF = new e(this.pageContext, this.fWV, this.gbD, this.fXd);
        this.gbG = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.fqs);
        this.gbL = com.baidu.tbadk.core.sharedPref.b.agM().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(Context context) {
        if (this.gbJ == null) {
            this.gbJ = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.g(context, R.dimen.tbds200);
            addView(this.gbJ, layoutParams);
            this.gbJ.setVisibility(8);
            this.gbJ.setPageId(this.pageContext.getUniqueId());
            this.fqY = new com.baidu.tieba.c.c(this.pageContext, this.gbJ, 1);
        }
    }

    public void btS() {
        if (this.gbC != null) {
            this.gbC.setListPullRefreshListener(this.gbR);
            this.gbC.a(this.gbS);
            this.gbC.a(this.gbT);
            this.gbC.a(this.gbU);
        }
    }

    public void bnS() {
        this.gbD.b(this.gbP);
        this.gbF.a(this.gbQ);
        this.gbG.a(this);
        btS();
        this.fWV.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                PersonalizePageView.this.gbM += i2;
                if (PersonalizePageView.this.gbM < height * 3 || PersonalizePageView.this.gbO != 1) {
                    if (PersonalizePageView.this.gbM < height * 3 && PersonalizePageView.this.gbO == 2) {
                        PersonalizePageView.this.gbO = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        return;
                    }
                    return;
                }
                PersonalizePageView.this.gbO = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.gbO)));
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.boW != null && i == 0 && PersonalizePageView.this.boW.getItemCount() - PersonalizePageView.this.boW.findLastVisibleItemPosition() <= 3) {
                    PersonalizePageView.this.aHt();
                }
            }
        });
        this.fWV.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aHt();
            }
        });
        this.fWV.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.gbI >= 5000) {
                    PersonalizePageView.this.gbF.bC(i, i2);
                }
            }
        }, 1L);
        this.fWV.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.gbF != null && PersonalizePageView.this.gbF.bkH() != null) {
                        PersonalizePageView.this.gbF.bkH().cj(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).aYs().stopPlay();
                    }
                }
            }
        });
        this.fWV.removeOnScrollListener(this.mOnScrollListener);
        this.fWV.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gbE = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.dlY != null) {
            this.dlY.setText(getContext().getString(R.string.pb_load_more));
            this.dlY.ajz();
        }
        this.gbF.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.gbF != null) {
            this.gbF.lc(!z);
        }
        this.gbK = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.gbK;
    }

    public void d(Long l) {
        this.gbF.d(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.gbF != null) {
            this.gbF.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void showFloatingView() {
        if (this.gbF != null) {
            this.gbF.showFloatingView();
        }
    }

    public void btT() {
        if (this.gbF != null) {
            this.gbF.btT();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dhY != null) {
                this.dhY.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            al.l(this.fXd, R.color.cp_bg_line_e);
            if (this.gbB != null) {
                this.gbB.iP(i);
            }
            if (this.dlY != null) {
                this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
                this.dlY.iP(i);
            }
            this.gbD.onChangeSkinType(i);
            if (this.gbF != null) {
                this.gbF.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void ay(String str, int i) {
        if (this.dlY != null) {
            this.dlY.setText(getContext().getString(R.string.pb_load_more));
            this.dlY.ajz();
        }
        this.gbF.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.gbF != null) {
                        PersonalizePageView.this.gbF.update();
                    }
                }
            });
        }
        this.refreshView.qx(str);
        this.refreshView.attachView(view, z);
        this.refreshView.asB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.dhY != null) {
            this.dhY.dettachView(this);
            this.dhY = null;
            this.fWV.setNextPage(this.dlY);
            this.dlY.setText(getContext().getString(R.string.pb_load_more));
            this.dlY.ajz();
        }
        if (this.fXd != null) {
            this.fXd.setVisibility(0);
        }
        if (this.gbE != null) {
            this.gbE.btn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean beG() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.dhY == null) {
            if (i < 0) {
                this.dhY = new g(getContext());
            } else {
                this.dhY = new g(getContext(), i);
            }
            this.dhY.onChangeSkinType();
        }
        this.dhY.attachView(this, z);
        this.fWV.setNextPage(null);
        if (this.fXd != null) {
            this.fXd.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.gbF != null) {
            this.gbF.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.fqY != null) {
            this.fqY.aFu();
        }
        setViewForeground(false);
        if (this.gbF != null) {
            this.gbF.jS(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.gbL < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.gbV, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gbF != null) {
            this.gbF.kV(z);
        }
        if (this.fXb != null) {
            this.fXb.b(this.fXc);
            this.fXb.a(this.fXc);
            this.fXc.btH();
        }
    }

    public void btw() {
        if (this.gbF != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.gbF.update();
        }
        if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.abp().abr();
            com.baidu.tbadk.core.bigday.b.abp().abq();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.gbF != null) {
            this.gbF.update();
        } else if (this.fWV != null && this.fXd != null) {
            showFloatingView();
            this.fWV.setSelection(0);
            if (!this.fXd.isRefreshing()) {
                if (this.gbF != null && this.gbF.bkH() != null) {
                    this.gbF.bkH().bvR();
                    this.gbF.lf(false);
                }
                this.fXd.setRefreshing(true);
            }
            if (this.fXc != null) {
                this.fXc.btH();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eXr);
        MessageManager.getInstance().unRegisterListener(this.fqs);
        MessageManager.getInstance().unRegisterListener(this.gbW);
        this.gbF.onDestroy();
        this.gbD.b((NEGFeedBackView.a) null);
        this.gbD.onDestroy();
        this.gbF.a((e.a) null);
        if (this.gbA != null) {
            this.gbA.setListPullRefreshListener(null);
            this.gbA.a((h.d) null);
            this.gbA.a((h.a) null);
            this.gbA.a((h.b) null);
            this.gbA.release();
        }
        if (this.gbB != null) {
            this.gbB.setListPullRefreshListener(null);
            this.gbB.a((h.d) null);
            this.gbB.a((h.a) null);
            this.gbB.a((h.b) null);
            this.gbB.release();
        }
        this.fWV.setOnSrollToBottomListener(null);
        if (this.fXb != null) {
            this.fXb.b(this.fXc);
        }
        this.fWV.removeOnScrollListener(this.mOnScrollListener);
        if (this.dhY != null) {
            this.dhY.release();
        }
        this.fWV.setRecyclerListener(null);
        if (this.gbG != null) {
            this.gbG.onDestroy();
        }
        if (this.fqY != null) {
            this.fqY.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.abp().destroy();
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gbV);
    }

    public void onPause() {
        this.gbF.onPause();
        if (this.gbD != null) {
            this.gbD.onPause();
        }
    }

    public void onResume() {
        if (this.fpF) {
            reload();
            this.fpF = false;
        }
        if (this.fXd != null) {
            this.fXd.resume();
        }
        if (this.gbD != null) {
            this.gbD.onResume();
        }
    }

    public void bsP() {
        if (this.gbD != null) {
            this.gbD.notifyDataSetChanged();
        }
    }

    public void bsQ() {
        if (this.gbF != null) {
            this.gbF.jS(true);
        }
        t.aXP().gM(false);
        com.baidu.tieba.a.d.aBq().bJ("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gbV);
    }

    public void btP() {
        this.gbF.buh();
    }

    public void btU() {
        this.gbF.btU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHt() {
        com.baidu.tieba.homepage.framework.a.btm().n(System.currentTimeMillis(), 1);
        if (this.dlY != null && !this.dlY.pu()) {
            this.dlY.ajy();
            this.dlY.iQ(0);
        }
        this.gbF.aHt();
    }
}
