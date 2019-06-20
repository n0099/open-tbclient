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
    private final CustomMessageListener chd;
    private g dhY;
    private PbListView dlY;
    private int dnp;
    private k eXp;
    private CustomMessageListener eXr;
    private BdTypeRecyclerView fWX;
    private ScrollFragmentTabHost fXd;
    ScrollFragmentTabHost.a fXe;
    private BigdaySwipeRefreshLayout fXf;
    private View.OnClickListener fXh;
    private boolean fpF;
    private com.baidu.tieba.c.c fqY;
    private CustomMessageListener fqs;
    private com.baidu.tieba.homepage.personalize.bigday.b gbC;
    private com.baidu.tieba.homepage.personalize.bigday.a gbD;
    private a gbE;
    private w gbF;
    private com.baidu.tieba.homepage.framework.b gbG;
    private e gbH;
    private com.baidu.tieba.homepage.personalize.a gbI;
    private com.baidu.tieba.homepage.personalize.model.e gbJ;
    private long gbK;
    private FloatingAnimationView gbL;
    private boolean gbM;
    private int gbN;
    private int gbO;
    private boolean gbP;
    private int gbQ;
    private NEGFeedBackView.a gbR;
    private e.a gbS;
    h.c gbT;
    h.d gbU;
    h.a gbV;
    h.b gbW;
    private Runnable gbX;
    public CustomMessageListener gbY;
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
        int i = personalizePageView.gbN + 1;
        personalizePageView.gbN = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fXd = scrollFragmentTabHost;
        if (this.fXd != null) {
            this.fXd.b(this.fXe);
            this.fXd.a(this.fXe);
        }
        if (this.gbH != null) {
            this.gbH.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gbI != null) {
            this.gbI.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.fXf != null) {
            this.fXf.oz();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gbF != null) {
            this.gbF.setPageUniqueId(bdUniqueId);
        }
        if (this.gbH != null) {
            this.gbH.k(bdUniqueId);
        }
        if (this.gbJ != null) {
            this.gbJ.o(bdUniqueId);
        }
        if (this.gbD != null) {
            this.gbD.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.abp().setTag(bdUniqueId);
        if (this.chd != null) {
            this.chd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.chd);
        }
        if (this.gbI != null) {
            this.gbI.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        o oVar = new o();
        oVar.DZ(String.valueOf(floatInfo.activity_id));
        oVar.ec(floatInfo.dynamic_url);
        oVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        oVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        oVar.DY(floatInfo.float_url);
        oVar.DX(floatInfo.jump_url);
        oVar.setType(floatInfo.show_type.intValue());
        return oVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.gbK = 0L;
        this.mSkinType = 3;
        this.fpF = false;
        this.gbM = false;
        this.gbN = 0;
        this.gbO = 0;
        this.gbP = false;
        this.gbQ = 1;
        this.eXr = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eXp == null) {
                            PersonalizePageView.this.eXp = new k(new i());
                        }
                        PersonalizePageView.this.eXp.a(PersonalizePageView.this.fWX, 2);
                    } else if (PersonalizePageView.this.eXp != null) {
                        PersonalizePageView.this.eXp.oa();
                    }
                }
            }
        };
        this.gbR = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.gbF != null) {
                        PersonalizePageView.this.gbF.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
                }
            }
        };
        this.dnp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dnp != i && PersonalizePageView.this.fXd != null) {
                    PersonalizePageView.this.dnp = i;
                    if (PersonalizePageView.this.dnp == 1) {
                        PersonalizePageView.this.fXd.aHU();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fXd.aHV();
                    } else {
                        PersonalizePageView.this.fXd.aHU();
                    }
                }
            }
        };
        this.fXe = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btI() {
                if (PersonalizePageView.this.fXd != null) {
                    PersonalizePageView.this.dnp = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fWX)) {
                        PersonalizePageView.this.fXd.aHV();
                    } else {
                        PersonalizePageView.this.fXd.aHU();
                    }
                }
            }
        };
        this.gbS = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fex = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_first_install", true);

            private void btW() {
                if (this.fex) {
                    this.fex = false;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void L(int i, int i2, int i3) {
                if (PersonalizePageView.this.gbG == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean beG = PersonalizePageView.this.beG();
                PersonalizePageView.this.aHK();
                if (beG) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gbG.K(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gbG != null) {
                    PersonalizePageView.this.gbG.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.jS()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    btW();
                } else if (!this.fex) {
                    PersonalizePageView.this.fXf.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    btW();
                    PersonalizePageView.this.btx();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                btW();
                PersonalizePageView.this.fXf.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aHK();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gbH.buj());
                PersonalizePageView.this.dE(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fqY != null) {
                    PersonalizePageView.this.fqY.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void btX() {
                if (PersonalizePageView.this.dlY != null) {
                    PersonalizePageView.this.dlY.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dlY.ajz();
                }
            }
        };
        this.gbT = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                com.baidu.tieba.a.d.aBq().rT("page_recommend");
                PersonalizePageView.this.gbH.update();
                PersonalizePageView.this.gbH.lg(false);
                PersonalizePageView.this.gbP = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gbU = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void eo(boolean z) {
                if (PersonalizePageView.this.gbH != null && PersonalizePageView.this.gbH.bkH() != null) {
                    PersonalizePageView.this.gbH.bkH().bvS();
                }
            }
        };
        this.gbV = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void ajP() {
                if (PersonalizePageView.this.gbP) {
                    PersonalizePageView.this.gbO = 0;
                    PersonalizePageView.this.gbQ = 1;
                    PersonalizePageView.this.gbP = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gbW = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.gbH != null) {
                    PersonalizePageView.this.gbH.lg(true);
                    PersonalizePageView.this.gbH.buc();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.abp().gN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gbX = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.chd = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bsR();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fXh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
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
        this.gbY = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fXf != null && !PersonalizePageView.this.fXf.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gbD == null) {
                            PersonalizePageView.this.gbD = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gbD.iP(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gbE = PersonalizePageView.this.gbD;
                            PersonalizePageView.this.btT();
                        } else if (PersonalizePageView.this.gbE != PersonalizePageView.this.gbD) {
                            PersonalizePageView.this.gbE = PersonalizePageView.this.gbD;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gbD.setEnable(true);
                        PersonalizePageView.this.fXf.setProgressView(PersonalizePageView.this.gbD);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fXf.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gbC == null) {
                        PersonalizePageView.this.gbC = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gbE = PersonalizePageView.this.gbC;
                        PersonalizePageView.this.btT();
                    } else if (PersonalizePageView.this.gbE != PersonalizePageView.this.gbC || !aVar.equals(PersonalizePageView.this.gbC.buw())) {
                        PersonalizePageView.this.gbE = PersonalizePageView.this.gbC;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gbC.setEnable(true);
                    PersonalizePageView.this.fXf.setProgressView(PersonalizePageView.this.gbC);
                    PersonalizePageView.this.gbC.a(aVar);
                    PersonalizePageView.this.fXf.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbK = 0L;
        this.mSkinType = 3;
        this.fpF = false;
        this.gbM = false;
        this.gbN = 0;
        this.gbO = 0;
        this.gbP = false;
        this.gbQ = 1;
        this.eXr = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eXp == null) {
                            PersonalizePageView.this.eXp = new k(new i());
                        }
                        PersonalizePageView.this.eXp.a(PersonalizePageView.this.fWX, 2);
                    } else if (PersonalizePageView.this.eXp != null) {
                        PersonalizePageView.this.eXp.oa();
                    }
                }
            }
        };
        this.gbR = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.gbF != null) {
                        PersonalizePageView.this.gbF.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
                }
            }
        };
        this.dnp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dnp != i && PersonalizePageView.this.fXd != null) {
                    PersonalizePageView.this.dnp = i;
                    if (PersonalizePageView.this.dnp == 1) {
                        PersonalizePageView.this.fXd.aHU();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fXd.aHV();
                    } else {
                        PersonalizePageView.this.fXd.aHU();
                    }
                }
            }
        };
        this.fXe = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btI() {
                if (PersonalizePageView.this.fXd != null) {
                    PersonalizePageView.this.dnp = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fWX)) {
                        PersonalizePageView.this.fXd.aHV();
                    } else {
                        PersonalizePageView.this.fXd.aHU();
                    }
                }
            }
        };
        this.gbS = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fex = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_first_install", true);

            private void btW() {
                if (this.fex) {
                    this.fex = false;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void L(int i, int i2, int i3) {
                if (PersonalizePageView.this.gbG == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean beG = PersonalizePageView.this.beG();
                PersonalizePageView.this.aHK();
                if (beG) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gbG.K(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gbG != null) {
                    PersonalizePageView.this.gbG.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.jS()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    btW();
                } else if (!this.fex) {
                    PersonalizePageView.this.fXf.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    btW();
                    PersonalizePageView.this.btx();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                btW();
                PersonalizePageView.this.fXf.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aHK();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gbH.buj());
                PersonalizePageView.this.dE(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fqY != null) {
                    PersonalizePageView.this.fqY.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void btX() {
                if (PersonalizePageView.this.dlY != null) {
                    PersonalizePageView.this.dlY.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dlY.ajz();
                }
            }
        };
        this.gbT = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                com.baidu.tieba.a.d.aBq().rT("page_recommend");
                PersonalizePageView.this.gbH.update();
                PersonalizePageView.this.gbH.lg(false);
                PersonalizePageView.this.gbP = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gbU = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void eo(boolean z) {
                if (PersonalizePageView.this.gbH != null && PersonalizePageView.this.gbH.bkH() != null) {
                    PersonalizePageView.this.gbH.bkH().bvS();
                }
            }
        };
        this.gbV = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void ajP() {
                if (PersonalizePageView.this.gbP) {
                    PersonalizePageView.this.gbO = 0;
                    PersonalizePageView.this.gbQ = 1;
                    PersonalizePageView.this.gbP = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gbW = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.gbH != null) {
                    PersonalizePageView.this.gbH.lg(true);
                    PersonalizePageView.this.gbH.buc();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.abp().gN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gbX = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.chd = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bsR();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fXh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
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
        this.gbY = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fXf != null && !PersonalizePageView.this.fXf.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gbD == null) {
                            PersonalizePageView.this.gbD = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gbD.iP(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gbE = PersonalizePageView.this.gbD;
                            PersonalizePageView.this.btT();
                        } else if (PersonalizePageView.this.gbE != PersonalizePageView.this.gbD) {
                            PersonalizePageView.this.gbE = PersonalizePageView.this.gbD;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gbD.setEnable(true);
                        PersonalizePageView.this.fXf.setProgressView(PersonalizePageView.this.gbD);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fXf.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gbC == null) {
                        PersonalizePageView.this.gbC = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gbE = PersonalizePageView.this.gbC;
                        PersonalizePageView.this.btT();
                    } else if (PersonalizePageView.this.gbE != PersonalizePageView.this.gbC || !aVar.equals(PersonalizePageView.this.gbC.buw())) {
                        PersonalizePageView.this.gbE = PersonalizePageView.this.gbC;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gbC.setEnable(true);
                    PersonalizePageView.this.fXf.setProgressView(PersonalizePageView.this.gbC);
                    PersonalizePageView.this.gbC.a(aVar);
                    PersonalizePageView.this.fXf.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbK = 0L;
        this.mSkinType = 3;
        this.fpF = false;
        this.gbM = false;
        this.gbN = 0;
        this.gbO = 0;
        this.gbP = false;
        this.gbQ = 1;
        this.eXr = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eXp == null) {
                            PersonalizePageView.this.eXp = new k(new i());
                        }
                        PersonalizePageView.this.eXp.a(PersonalizePageView.this.fWX, 2);
                    } else if (PersonalizePageView.this.eXp != null) {
                        PersonalizePageView.this.eXp.oa();
                    }
                }
            }
        };
        this.gbR = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.gbF != null) {
                        PersonalizePageView.this.gbF.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i2));
                }
            }
        };
        this.dnp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.dnp != i2 && PersonalizePageView.this.fXd != null) {
                    PersonalizePageView.this.dnp = i2;
                    if (PersonalizePageView.this.dnp == 1) {
                        PersonalizePageView.this.fXd.aHU();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fXd.aHV();
                    } else {
                        PersonalizePageView.this.fXd.aHU();
                    }
                }
            }
        };
        this.fXe = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btI() {
                if (PersonalizePageView.this.fXd != null) {
                    PersonalizePageView.this.dnp = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fWX)) {
                        PersonalizePageView.this.fXd.aHV();
                    } else {
                        PersonalizePageView.this.fXd.aHU();
                    }
                }
            }
        };
        this.gbS = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fex = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_first_install", true);

            private void btW() {
                if (this.fex) {
                    this.fex = false;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void L(int i2, int i22, int i3) {
                if (PersonalizePageView.this.gbG == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean beG = PersonalizePageView.this.beG();
                PersonalizePageView.this.aHK();
                if (beG) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gbG.K(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.gbG != null) {
                    PersonalizePageView.this.gbG.u(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.jS()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    btW();
                } else if (!this.fex) {
                    PersonalizePageView.this.fXf.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    btW();
                    PersonalizePageView.this.btx();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                btW();
                PersonalizePageView.this.fXf.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aHK();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gbH.buj());
                PersonalizePageView.this.dE(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fqY != null) {
                    PersonalizePageView.this.fqY.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void btX() {
                if (PersonalizePageView.this.dlY != null) {
                    PersonalizePageView.this.dlY.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dlY.ajz();
                }
            }
        };
        this.gbT = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                com.baidu.tieba.a.d.aBq().rT("page_recommend");
                PersonalizePageView.this.gbH.update();
                PersonalizePageView.this.gbH.lg(false);
                PersonalizePageView.this.gbP = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gbU = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void eo(boolean z) {
                if (PersonalizePageView.this.gbH != null && PersonalizePageView.this.gbH.bkH() != null) {
                    PersonalizePageView.this.gbH.bkH().bvS();
                }
            }
        };
        this.gbV = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void ajP() {
                if (PersonalizePageView.this.gbP) {
                    PersonalizePageView.this.gbO = 0;
                    PersonalizePageView.this.gbQ = 1;
                    PersonalizePageView.this.gbP = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gbW = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.gbH != null) {
                    PersonalizePageView.this.gbH.lg(true);
                    PersonalizePageView.this.gbH.buc();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.abp().gN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gbX = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.chd = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bsR();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fXh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
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
        this.gbY = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fXf != null && !PersonalizePageView.this.fXf.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gbD == null) {
                            PersonalizePageView.this.gbD = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gbD.iP(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gbE = PersonalizePageView.this.gbD;
                            PersonalizePageView.this.btT();
                        } else if (PersonalizePageView.this.gbE != PersonalizePageView.this.gbD) {
                            PersonalizePageView.this.gbE = PersonalizePageView.this.gbD;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gbD.setEnable(true);
                        PersonalizePageView.this.fXf.setProgressView(PersonalizePageView.this.gbD);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fXf.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gbC == null) {
                        PersonalizePageView.this.gbC = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gbE = PersonalizePageView.this.gbC;
                        PersonalizePageView.this.btT();
                    } else if (PersonalizePageView.this.gbE != PersonalizePageView.this.gbC || !aVar.equals(PersonalizePageView.this.gbC.buw())) {
                        PersonalizePageView.this.gbE = PersonalizePageView.this.gbC;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gbC.setEnable(true);
                    PersonalizePageView.this.fXf.setProgressView(PersonalizePageView.this.gbC);
                    PersonalizePageView.this.gbC.a(aVar);
                    PersonalizePageView.this.fXf.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fWX = new BdTypeRecyclerView(context);
        this.boW = new LinearLayoutManager(this.fWX.getContext());
        this.fWX.setLayoutManager(this.boW);
        this.fWX.setFadingEdgeLength(0);
        this.fWX.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.eXp = new k(new i());
            this.eXp.a(this.fWX, 2);
        }
        MessageManager.getInstance().registerListener(this.eXr);
        this.fXf = new BigdaySwipeRefreshLayout(context);
        this.fXf.addView(this.fWX);
        this.dlY = new PbListView(context);
        this.dlY.getView();
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.ajv();
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.iN(R.color.cp_cont_e);
        this.dlY.setHeight(l.g(context, R.dimen.tbds182));
        this.dlY.setOnClickListener(this.fXh);
        this.dlY.ajC();
        this.fWX.setNextPage(this.dlY);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.gbY);
        com.baidu.tbadk.core.bigday.b.abp().dC(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.abp().gN(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.fXf);
        ((FrameLayout.LayoutParams) this.fXf.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.gbJ = new com.baidu.tieba.homepage.personalize.model.e();
        this.gbF = new w(context, this.fWX);
        this.gbF.b(this.gbJ);
        this.gbH = new e(this.pageContext, this.fWX, this.gbF, this.fXf);
        this.gbI = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.fqs);
        this.gbN = com.baidu.tbadk.core.sharedPref.b.agM().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(Context context) {
        if (this.gbL == null) {
            this.gbL = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.g(context, R.dimen.tbds200);
            addView(this.gbL, layoutParams);
            this.gbL.setVisibility(8);
            this.gbL.setPageId(this.pageContext.getUniqueId());
            this.fqY = new com.baidu.tieba.c.c(this.pageContext, this.gbL, 1);
        }
    }

    public void btT() {
        if (this.gbE != null) {
            this.gbE.setListPullRefreshListener(this.gbT);
            this.gbE.a(this.gbU);
            this.gbE.a(this.gbV);
            this.gbE.a(this.gbW);
        }
    }

    public void bnS() {
        this.gbF.b(this.gbR);
        this.gbH.a(this.gbS);
        this.gbI.a(this);
        btT();
        this.fWX.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                PersonalizePageView.this.gbO += i2;
                if (PersonalizePageView.this.gbO < height * 3 || PersonalizePageView.this.gbQ != 1) {
                    if (PersonalizePageView.this.gbO < height * 3 && PersonalizePageView.this.gbQ == 2) {
                        PersonalizePageView.this.gbQ = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        return;
                    }
                    return;
                }
                PersonalizePageView.this.gbQ = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.gbQ)));
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.boW != null && i == 0 && PersonalizePageView.this.boW.getItemCount() - PersonalizePageView.this.boW.findLastVisibleItemPosition() <= 3) {
                    PersonalizePageView.this.aHt();
                }
            }
        });
        this.fWX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aHt();
            }
        });
        this.fWX.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.gbK >= 5000) {
                    PersonalizePageView.this.gbH.bC(i, i2);
                }
            }
        }, 1L);
        this.fWX.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.gbH != null && PersonalizePageView.this.gbH.bkH() != null) {
                        PersonalizePageView.this.gbH.bkH().cj(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).aYs().stopPlay();
                    }
                }
            }
        });
        this.fWX.removeOnScrollListener(this.mOnScrollListener);
        this.fWX.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gbG = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.dlY != null) {
            this.dlY.setText(getContext().getString(R.string.pb_load_more));
            this.dlY.ajz();
        }
        this.gbH.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.gbH != null) {
            this.gbH.ld(!z);
        }
        this.gbM = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.gbM;
    }

    public void d(Long l) {
        this.gbH.d(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.gbH != null) {
            this.gbH.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void showFloatingView() {
        if (this.gbH != null) {
            this.gbH.showFloatingView();
        }
    }

    public void btU() {
        if (this.gbH != null) {
            this.gbH.btU();
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
            al.l(this.fXf, R.color.cp_bg_line_e);
            if (this.gbD != null) {
                this.gbD.iP(i);
            }
            if (this.dlY != null) {
                this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
                this.dlY.iP(i);
            }
            this.gbF.onChangeSkinType(i);
            if (this.gbH != null) {
                this.gbH.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void ay(String str, int i) {
        if (this.dlY != null) {
            this.dlY.setText(getContext().getString(R.string.pb_load_more));
            this.dlY.ajz();
        }
        this.gbH.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.gbH != null) {
                        PersonalizePageView.this.gbH.update();
                    }
                }
            });
        }
        this.refreshView.qw(str);
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
            this.fWX.setNextPage(this.dlY);
            this.dlY.setText(getContext().getString(R.string.pb_load_more));
            this.dlY.ajz();
        }
        if (this.fXf != null) {
            this.fXf.setVisibility(0);
        }
        if (this.gbG != null) {
            this.gbG.bto();
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
        this.fWX.setNextPage(null);
        if (this.fXf != null) {
            this.fXf.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.gbH != null) {
            this.gbH.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.fqY != null) {
            this.fqY.aFu();
        }
        setViewForeground(false);
        if (this.gbH != null) {
            this.gbH.jS(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.gbN < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.gbX, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gbH != null) {
            this.gbH.kW(z);
        }
        if (this.fXd != null) {
            this.fXd.b(this.fXe);
            this.fXd.a(this.fXe);
            this.fXe.btI();
        }
    }

    public void btx() {
        if (this.gbH != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.gbH.update();
        }
        if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.abp().abr();
            com.baidu.tbadk.core.bigday.b.abp().abq();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.gbH != null) {
            this.gbH.update();
        } else if (this.fWX != null && this.fXf != null) {
            showFloatingView();
            this.fWX.setSelection(0);
            if (!this.fXf.isRefreshing()) {
                if (this.gbH != null && this.gbH.bkH() != null) {
                    this.gbH.bkH().bvS();
                    this.gbH.lg(false);
                }
                this.fXf.setRefreshing(true);
            }
            if (this.fXe != null) {
                this.fXe.btI();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eXr);
        MessageManager.getInstance().unRegisterListener(this.fqs);
        MessageManager.getInstance().unRegisterListener(this.gbY);
        this.gbH.onDestroy();
        this.gbF.b((NEGFeedBackView.a) null);
        this.gbF.onDestroy();
        this.gbH.a((e.a) null);
        if (this.gbC != null) {
            this.gbC.setListPullRefreshListener(null);
            this.gbC.a((h.d) null);
            this.gbC.a((h.a) null);
            this.gbC.a((h.b) null);
            this.gbC.release();
        }
        if (this.gbD != null) {
            this.gbD.setListPullRefreshListener(null);
            this.gbD.a((h.d) null);
            this.gbD.a((h.a) null);
            this.gbD.a((h.b) null);
            this.gbD.release();
        }
        this.fWX.setOnSrollToBottomListener(null);
        if (this.fXd != null) {
            this.fXd.b(this.fXe);
        }
        this.fWX.removeOnScrollListener(this.mOnScrollListener);
        if (this.dhY != null) {
            this.dhY.release();
        }
        this.fWX.setRecyclerListener(null);
        if (this.gbI != null) {
            this.gbI.onDestroy();
        }
        if (this.fqY != null) {
            this.fqY.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.abp().destroy();
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gbX);
    }

    public void onPause() {
        this.gbH.onPause();
        if (this.gbF != null) {
            this.gbF.onPause();
        }
    }

    public void onResume() {
        if (this.fpF) {
            reload();
            this.fpF = false;
        }
        if (this.fXf != null) {
            this.fXf.resume();
        }
        if (this.gbF != null) {
            this.gbF.onResume();
        }
    }

    public void bsR() {
        if (this.gbF != null) {
            this.gbF.notifyDataSetChanged();
        }
    }

    public void bsS() {
        if (this.gbH != null) {
            this.gbH.jS(true);
        }
        t.aXP().gM(false);
        com.baidu.tieba.a.d.aBq().bJ("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gbX);
    }

    public void btQ() {
        this.gbH.bui();
    }

    public void btV() {
        this.gbH.btV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHt() {
        com.baidu.tieba.homepage.framework.a.btn().n(System.currentTimeMillis(), 1);
        if (this.dlY != null && !this.dlY.pu()) {
            this.dlY.ajy();
            this.dlY.iQ(0);
        }
        this.gbH.aHt();
    }
}
