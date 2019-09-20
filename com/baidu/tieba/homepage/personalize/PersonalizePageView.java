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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.m.g;
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
    private LinearLayoutManager bqh;
    private final CustomMessageListener cjl;
    private g dly;
    private PbListView dpz;
    private int drh;
    private k feD;
    private CustomMessageListener feF;
    private boolean fwP;
    private CustomMessageListener fxC;
    private com.baidu.tieba.c.c fyi;
    private BdTypeRecyclerView geC;
    private ScrollFragmentTabHost geI;
    ScrollFragmentTabHost.a geJ;
    private BigdaySwipeRefreshLayout geK;
    private View.OnClickListener geM;
    private NEGFeedBackView.a gjB;
    private com.baidu.tieba.homepage.personalize.bigday.b gkA;
    private com.baidu.tieba.homepage.personalize.bigday.a gkB;
    private a gkC;
    private w gkD;
    private com.baidu.tieba.homepage.framework.b gkE;
    private e gkF;
    private com.baidu.tieba.homepage.personalize.a gkG;
    private com.baidu.tieba.homepage.personalize.model.e gkH;
    private long gkI;
    private FloatingAnimationView gkJ;
    private boolean gkK;
    private int gkL;
    private int gkM;
    private boolean gkN;
    private int gkO;
    private e.a gkP;
    h.c gkQ;
    h.a gkR;
    private Runnable gkS;
    public CustomMessageListener gkT;
    h.d gkc;
    h.b gkd;
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
        int i = personalizePageView.gkL + 1;
        personalizePageView.gkL = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.geI = scrollFragmentTabHost;
        if (this.geI != null) {
            this.geI.b(this.geJ);
            this.geI.a(this.geJ);
        }
        if (this.gkF != null) {
            this.gkF.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gkG != null) {
            this.gkG.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.geK != null) {
            this.geK.oV();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gkD != null) {
            this.gkD.setPageUniqueId(bdUniqueId);
        }
        if (this.gkF != null) {
            this.gkF.l(bdUniqueId);
        }
        if (this.gkH != null) {
            this.gkH.h(bdUniqueId);
        }
        if (this.gkB != null) {
            this.gkB.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.acs().setTag(bdUniqueId);
        if (this.cjl != null) {
            this.cjl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cjl);
        }
        if (this.gkG != null) {
            this.gkG.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        o oVar = new o();
        oVar.Fn(String.valueOf(floatInfo.activity_id));
        oVar.ed(floatInfo.dynamic_url);
        oVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        oVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        oVar.Fm(floatInfo.float_url);
        oVar.Fl(floatInfo.jump_url);
        oVar.setType(floatInfo.show_type.intValue());
        return oVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.gkI = 0L;
        this.mSkinType = 3;
        this.fwP = false;
        this.gkK = false;
        this.gkL = 0;
        this.gkM = 0;
        this.gkN = false;
        this.gkO = 1;
        this.feF = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.feD == null) {
                            PersonalizePageView.this.feD = new k(new i());
                        }
                        PersonalizePageView.this.feD.a(PersonalizePageView.this.geC, 2);
                    } else if (PersonalizePageView.this.feD != null) {
                        PersonalizePageView.this.feD.ox();
                    }
                }
            }
        };
        this.gjB = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                if (ajVar != null) {
                    TiebaStatic.log(new an("c11693").bT("obj_locate", "1").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.gkD != null) {
                        PersonalizePageView.this.gkD.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
                }
            }
        };
        this.drh = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.drh != i && PersonalizePageView.this.geI != null) {
                    PersonalizePageView.this.drh = i;
                    if (PersonalizePageView.this.drh == 1) {
                        PersonalizePageView.this.geI.aKa();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.geI.aKb();
                    } else {
                        PersonalizePageView.this.geI.aKa();
                    }
                }
            }
        };
        this.geJ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bwM() {
                if (PersonalizePageView.this.geI != null) {
                    PersonalizePageView.this.drh = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.geC)) {
                        PersonalizePageView.this.geI.aKb();
                    } else {
                        PersonalizePageView.this.geI.aKa();
                    }
                }
            }
        };
        this.gkP = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean flM = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("key_first_install", true);

            private void bxD() {
                if (this.flM) {
                    this.flM = false;
                    com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i, int i2, int i3) {
                if (PersonalizePageView.this.gkE == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bhs = PersonalizePageView.this.bhs();
                PersonalizePageView.this.aJN();
                if (bhs) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gkE.M(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gkE != null) {
                    PersonalizePageView.this.gkE.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.kc()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bxD();
                } else if (!this.flM) {
                    PersonalizePageView.this.geK.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bxD();
                    PersonalizePageView.this.bwB();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bxD();
                PersonalizePageView.this.geK.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJN();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gkF.bxQ());
                PersonalizePageView.this.dH(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fyi != null) {
                    PersonalizePageView.this.fyi.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bxE() {
                if (PersonalizePageView.this.dpz != null) {
                    PersonalizePageView.this.dpz.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dpz.akS();
                }
            }
        };
        this.gkQ = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                com.baidu.tieba.a.d.aCV().sx("page_recommend");
                PersonalizePageView.this.gkF.update();
                PersonalizePageView.this.gkF.lp(false);
                PersonalizePageView.this.gkN = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gkc = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void ev(boolean z) {
                if (PersonalizePageView.this.gkF != null && PersonalizePageView.this.gkF.bnE() != null) {
                    PersonalizePageView.this.gkF.bnE().bxn();
                }
            }
        };
        this.gkR = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void ali() {
                if (PersonalizePageView.this.gkN) {
                    PersonalizePageView.this.gkM = 0;
                    PersonalizePageView.this.gkO = 1;
                    PersonalizePageView.this.gkN = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gkd = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.gkF != null) {
                    PersonalizePageView.this.gkF.lp(true);
                    PersonalizePageView.this.gkF.bxJ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahU().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.acs().gS(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gkS = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.ahU().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.cjl = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bvT();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.geM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aJw();
            }
        };
        this.fxC = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fwP = true;
                    }
                }
            }
        };
        this.gkT = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.geK != null && !PersonalizePageView.this.geK.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gkB == null) {
                            PersonalizePageView.this.gkB = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gkB.iY(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gkC = PersonalizePageView.this.gkB;
                            PersonalizePageView.this.bxA();
                        } else if (PersonalizePageView.this.gkC != PersonalizePageView.this.gkB) {
                            PersonalizePageView.this.gkC = PersonalizePageView.this.gkB;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gkB.setEnable(true);
                        PersonalizePageView.this.geK.setProgressView(PersonalizePageView.this.gkB);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.geK.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gkA == null) {
                        PersonalizePageView.this.gkA = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gkC = PersonalizePageView.this.gkA;
                        PersonalizePageView.this.bxA();
                    } else if (PersonalizePageView.this.gkC != PersonalizePageView.this.gkA || !aVar.equals(PersonalizePageView.this.gkA.byc())) {
                        PersonalizePageView.this.gkC = PersonalizePageView.this.gkA;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gkA.setEnable(true);
                    PersonalizePageView.this.geK.setProgressView(PersonalizePageView.this.gkA);
                    PersonalizePageView.this.gkA.a(aVar);
                    PersonalizePageView.this.geK.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gkI = 0L;
        this.mSkinType = 3;
        this.fwP = false;
        this.gkK = false;
        this.gkL = 0;
        this.gkM = 0;
        this.gkN = false;
        this.gkO = 1;
        this.feF = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.feD == null) {
                            PersonalizePageView.this.feD = new k(new i());
                        }
                        PersonalizePageView.this.feD.a(PersonalizePageView.this.geC, 2);
                    } else if (PersonalizePageView.this.feD != null) {
                        PersonalizePageView.this.feD.ox();
                    }
                }
            }
        };
        this.gjB = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                if (ajVar != null) {
                    TiebaStatic.log(new an("c11693").bT("obj_locate", "1").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.gkD != null) {
                        PersonalizePageView.this.gkD.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
                }
            }
        };
        this.drh = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.drh != i && PersonalizePageView.this.geI != null) {
                    PersonalizePageView.this.drh = i;
                    if (PersonalizePageView.this.drh == 1) {
                        PersonalizePageView.this.geI.aKa();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.geI.aKb();
                    } else {
                        PersonalizePageView.this.geI.aKa();
                    }
                }
            }
        };
        this.geJ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bwM() {
                if (PersonalizePageView.this.geI != null) {
                    PersonalizePageView.this.drh = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.geC)) {
                        PersonalizePageView.this.geI.aKb();
                    } else {
                        PersonalizePageView.this.geI.aKa();
                    }
                }
            }
        };
        this.gkP = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean flM = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("key_first_install", true);

            private void bxD() {
                if (this.flM) {
                    this.flM = false;
                    com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i, int i2, int i3) {
                if (PersonalizePageView.this.gkE == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bhs = PersonalizePageView.this.bhs();
                PersonalizePageView.this.aJN();
                if (bhs) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gkE.M(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gkE != null) {
                    PersonalizePageView.this.gkE.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.kc()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bxD();
                } else if (!this.flM) {
                    PersonalizePageView.this.geK.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bxD();
                    PersonalizePageView.this.bwB();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bxD();
                PersonalizePageView.this.geK.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJN();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gkF.bxQ());
                PersonalizePageView.this.dH(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fyi != null) {
                    PersonalizePageView.this.fyi.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bxE() {
                if (PersonalizePageView.this.dpz != null) {
                    PersonalizePageView.this.dpz.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dpz.akS();
                }
            }
        };
        this.gkQ = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                com.baidu.tieba.a.d.aCV().sx("page_recommend");
                PersonalizePageView.this.gkF.update();
                PersonalizePageView.this.gkF.lp(false);
                PersonalizePageView.this.gkN = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gkc = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void ev(boolean z) {
                if (PersonalizePageView.this.gkF != null && PersonalizePageView.this.gkF.bnE() != null) {
                    PersonalizePageView.this.gkF.bnE().bxn();
                }
            }
        };
        this.gkR = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void ali() {
                if (PersonalizePageView.this.gkN) {
                    PersonalizePageView.this.gkM = 0;
                    PersonalizePageView.this.gkO = 1;
                    PersonalizePageView.this.gkN = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gkd = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.gkF != null) {
                    PersonalizePageView.this.gkF.lp(true);
                    PersonalizePageView.this.gkF.bxJ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahU().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.acs().gS(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gkS = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.ahU().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.cjl = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bvT();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.geM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aJw();
            }
        };
        this.fxC = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fwP = true;
                    }
                }
            }
        };
        this.gkT = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.geK != null && !PersonalizePageView.this.geK.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gkB == null) {
                            PersonalizePageView.this.gkB = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gkB.iY(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gkC = PersonalizePageView.this.gkB;
                            PersonalizePageView.this.bxA();
                        } else if (PersonalizePageView.this.gkC != PersonalizePageView.this.gkB) {
                            PersonalizePageView.this.gkC = PersonalizePageView.this.gkB;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gkB.setEnable(true);
                        PersonalizePageView.this.geK.setProgressView(PersonalizePageView.this.gkB);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.geK.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gkA == null) {
                        PersonalizePageView.this.gkA = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gkC = PersonalizePageView.this.gkA;
                        PersonalizePageView.this.bxA();
                    } else if (PersonalizePageView.this.gkC != PersonalizePageView.this.gkA || !aVar.equals(PersonalizePageView.this.gkA.byc())) {
                        PersonalizePageView.this.gkC = PersonalizePageView.this.gkA;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gkA.setEnable(true);
                    PersonalizePageView.this.geK.setProgressView(PersonalizePageView.this.gkA);
                    PersonalizePageView.this.gkA.a(aVar);
                    PersonalizePageView.this.geK.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gkI = 0L;
        this.mSkinType = 3;
        this.fwP = false;
        this.gkK = false;
        this.gkL = 0;
        this.gkM = 0;
        this.gkN = false;
        this.gkO = 1;
        this.feF = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.feD == null) {
                            PersonalizePageView.this.feD = new k(new i());
                        }
                        PersonalizePageView.this.feD.a(PersonalizePageView.this.geC, 2);
                    } else if (PersonalizePageView.this.feD != null) {
                        PersonalizePageView.this.feD.ox();
                    }
                }
            }
        };
        this.gjB = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                if (ajVar != null) {
                    TiebaStatic.log(new an("c11693").bT("obj_locate", "1").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.gkD != null) {
                        PersonalizePageView.this.gkD.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i2));
                }
            }
        };
        this.drh = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.drh != i2 && PersonalizePageView.this.geI != null) {
                    PersonalizePageView.this.drh = i2;
                    if (PersonalizePageView.this.drh == 1) {
                        PersonalizePageView.this.geI.aKa();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.geI.aKb();
                    } else {
                        PersonalizePageView.this.geI.aKa();
                    }
                }
            }
        };
        this.geJ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bwM() {
                if (PersonalizePageView.this.geI != null) {
                    PersonalizePageView.this.drh = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.geC)) {
                        PersonalizePageView.this.geI.aKb();
                    } else {
                        PersonalizePageView.this.geI.aKa();
                    }
                }
            }
        };
        this.gkP = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean flM = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("key_first_install", true);

            private void bxD() {
                if (this.flM) {
                    this.flM = false;
                    com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i2, int i22, int i3) {
                if (PersonalizePageView.this.gkE == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bhs = PersonalizePageView.this.bhs();
                PersonalizePageView.this.aJN();
                if (bhs) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gkE.M(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.gkE != null) {
                    PersonalizePageView.this.gkE.y(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.kc()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bxD();
                } else if (!this.flM) {
                    PersonalizePageView.this.geK.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bxD();
                    PersonalizePageView.this.bwB();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bxD();
                PersonalizePageView.this.geK.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJN();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gkF.bxQ());
                PersonalizePageView.this.dH(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fyi != null) {
                    PersonalizePageView.this.fyi.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bxE() {
                if (PersonalizePageView.this.dpz != null) {
                    PersonalizePageView.this.dpz.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dpz.akS();
                }
            }
        };
        this.gkQ = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                com.baidu.tieba.a.d.aCV().sx("page_recommend");
                PersonalizePageView.this.gkF.update();
                PersonalizePageView.this.gkF.lp(false);
                PersonalizePageView.this.gkN = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gkc = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void ev(boolean z) {
                if (PersonalizePageView.this.gkF != null && PersonalizePageView.this.gkF.bnE() != null) {
                    PersonalizePageView.this.gkF.bnE().bxn();
                }
            }
        };
        this.gkR = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void ali() {
                if (PersonalizePageView.this.gkN) {
                    PersonalizePageView.this.gkM = 0;
                    PersonalizePageView.this.gkO = 1;
                    PersonalizePageView.this.gkN = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gkd = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.gkF != null) {
                    PersonalizePageView.this.gkF.lp(true);
                    PersonalizePageView.this.gkF.bxJ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahU().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.acs().gS(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gkS = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.ahU().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.cjl = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bvT();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.geM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aJw();
            }
        };
        this.fxC = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fwP = true;
                    }
                }
            }
        };
        this.gkT = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.geK != null && !PersonalizePageView.this.geK.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gkB == null) {
                            PersonalizePageView.this.gkB = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gkB.iY(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gkC = PersonalizePageView.this.gkB;
                            PersonalizePageView.this.bxA();
                        } else if (PersonalizePageView.this.gkC != PersonalizePageView.this.gkB) {
                            PersonalizePageView.this.gkC = PersonalizePageView.this.gkB;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gkB.setEnable(true);
                        PersonalizePageView.this.geK.setProgressView(PersonalizePageView.this.gkB);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.geK.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gkA == null) {
                        PersonalizePageView.this.gkA = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gkC = PersonalizePageView.this.gkA;
                        PersonalizePageView.this.bxA();
                    } else if (PersonalizePageView.this.gkC != PersonalizePageView.this.gkA || !aVar.equals(PersonalizePageView.this.gkA.byc())) {
                        PersonalizePageView.this.gkC = PersonalizePageView.this.gkA;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gkA.setEnable(true);
                    PersonalizePageView.this.geK.setProgressView(PersonalizePageView.this.gkA);
                    PersonalizePageView.this.gkA.a(aVar);
                    PersonalizePageView.this.geK.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.geC = new BdTypeRecyclerView(context);
        this.bqh = new LinearLayoutManager(this.geC.getContext());
        this.geC.setLayoutManager(this.bqh);
        this.geC.setFadingEdgeLength(0);
        this.geC.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.feD = new k(new i());
            this.feD.a(this.geC, 2);
        }
        MessageManager.getInstance().registerListener(this.feF);
        this.geK = new BigdaySwipeRefreshLayout(context);
        this.geK.addView(this.geC);
        this.dpz = new PbListView(context);
        this.dpz.getView();
        this.dpz.iX(R.color.cp_bg_line_e);
        this.dpz.akO();
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dpz.setTextSize(R.dimen.tbfontsize33);
        this.dpz.iW(R.color.cp_cont_e);
        this.dpz.setHeight(l.g(context, R.dimen.tbds182));
        this.dpz.setOnClickListener(this.geM);
        this.dpz.akV();
        this.geC.setNextPage(this.dpz);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.gkT);
        com.baidu.tbadk.core.bigday.b.acs().dG(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahU().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.acs().gS(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.geK);
        ((FrameLayout.LayoutParams) this.geK.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.gkH = new com.baidu.tieba.homepage.personalize.model.e();
        this.gkD = new w(context, this.geC);
        this.gkD.b(this.gkH);
        this.gkF = new e(this.pageContext, this.geC, this.gkD, this.geK);
        this.gkG = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.fxC);
        this.gkL = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(Context context) {
        if (this.gkJ == null) {
            this.gkJ = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.g(context, R.dimen.tbds200);
            addView(this.gkJ, layoutParams);
            this.gkJ.setVisibility(8);
            this.gkJ.setPageId(this.pageContext.getUniqueId());
            this.fyi = new com.baidu.tieba.c.c(this.pageContext, this.gkJ, 1);
        }
    }

    public void bxA() {
        if (this.gkC != null) {
            this.gkC.setListPullRefreshListener(this.gkQ);
            this.gkC.a(this.gkc);
            this.gkC.a(this.gkR);
            this.gkC.a(this.gkd);
        }
    }

    public void bqS() {
        this.gkD.b(this.gjB);
        this.gkF.a(this.gkP);
        this.gkG.a(this);
        bxA();
        this.geC.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                PersonalizePageView.this.gkM += i2;
                if (PersonalizePageView.this.gkM < height * 3 || PersonalizePageView.this.gkO != 1) {
                    if (PersonalizePageView.this.gkM < height * 3 && PersonalizePageView.this.gkO == 2) {
                        PersonalizePageView.this.gkO = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        return;
                    }
                    return;
                }
                PersonalizePageView.this.gkO = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.gkO)));
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.bqh != null && i == 0 && PersonalizePageView.this.bqh.getItemCount() - PersonalizePageView.this.bqh.findLastVisibleItemPosition() <= 3) {
                    PersonalizePageView.this.aJw();
                }
            }
        });
        this.geC.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aJw();
            }
        });
        this.geC.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.gkI >= 5000) {
                    PersonalizePageView.this.gkF.bI(i, i2);
                }
            }
        }, 1L);
        this.geC.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.gkF != null && PersonalizePageView.this.gkF.bnE() != null) {
                        PersonalizePageView.this.gkF.bnE().cn(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).baX().stopPlay();
                    }
                }
            }
        });
        this.geC.removeOnScrollListener(this.mOnScrollListener);
        this.geC.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gkE = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.dpz != null) {
            this.dpz.setText(getContext().getString(R.string.pb_load_more));
            this.dpz.akS();
        }
        this.gkF.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.gkF != null) {
            this.gkF.lt(!z);
        }
        this.gkK = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.gkK;
    }

    public void d(Long l) {
        this.gkF.d(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.w wVar) {
        if (this.gkF != null) {
            this.gkF.setRecommendFrsNavigationAnimDispatcher(wVar);
        }
    }

    public void showFloatingView() {
        if (this.gkF != null) {
            this.gkF.showFloatingView();
        }
    }

    public void bxB() {
        if (this.gkF != null) {
            this.gkF.bxB();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dly != null) {
                this.dly.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.l(this.geK, R.color.cp_bg_line_e);
            if (this.gkB != null) {
                this.gkB.iY(i);
            }
            if (this.dpz != null) {
                this.dpz.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dpz.iY(i);
            }
            this.gkD.onChangeSkinType(i);
            if (this.gkF != null) {
                this.gkF.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aB(String str, int i) {
        if (this.dpz != null) {
            this.dpz.setText(getContext().getString(R.string.pb_load_more));
            this.dpz.akS();
        }
        this.gkF.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.gkF != null) {
                        PersonalizePageView.this.gkF.update();
                    }
                }
            });
        }
        this.refreshView.qY(str);
        this.refreshView.attachView(view, z);
        this.refreshView.atW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJN() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.dly != null) {
            this.dly.dettachView(this);
            this.dly = null;
            this.geC.setNextPage(this.dpz);
            this.dpz.setText(getContext().getString(R.string.pb_load_more));
            this.dpz.akS();
        }
        if (this.geK != null) {
            this.geK.setVisibility(0);
        }
        if (this.gkE != null) {
            this.gkE.bwr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhs() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.dly == null) {
            if (i < 0) {
                this.dly = new g(getContext());
            } else {
                this.dly = new g(getContext(), i);
            }
            this.dly.onChangeSkinType();
        }
        this.dly.attachView(this, z);
        this.geC.setNextPage(null);
        if (this.geK != null) {
            this.geK.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.gkF != null) {
            this.gkF.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.fyi != null) {
            this.fyi.aHw();
        }
        setViewForeground(false);
        if (this.gkF != null) {
            this.gkF.kf(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.gkL < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.gkS, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gkF != null) {
            this.gkF.lj(z);
        }
        if (this.geI != null) {
            this.geI.b(this.geJ);
            this.geI.a(this.geJ);
            this.geJ.bwM();
        }
    }

    public void bwB() {
        if (this.gkF != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.gkF.update();
        }
        if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.acs().acu();
            com.baidu.tbadk.core.bigday.b.acs().act();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.gkF != null) {
            this.gkF.update();
        } else if (this.geC != null && this.geK != null) {
            showFloatingView();
            this.geC.setSelection(0);
            if (!this.geK.isRefreshing()) {
                if (this.gkF != null && this.gkF.bnE() != null) {
                    this.gkF.bnE().bxn();
                    this.gkF.lp(false);
                }
                this.geK.setRefreshing(true);
            }
            if (this.geJ != null) {
                this.geJ.bwM();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.feF);
        MessageManager.getInstance().unRegisterListener(this.fxC);
        MessageManager.getInstance().unRegisterListener(this.gkT);
        this.gkF.onDestroy();
        this.gkD.b((NEGFeedBackView.a) null);
        this.gkD.onDestroy();
        this.gkF.a((e.a) null);
        if (this.gkA != null) {
            this.gkA.setListPullRefreshListener(null);
            this.gkA.a((h.d) null);
            this.gkA.a((h.a) null);
            this.gkA.a((h.b) null);
            this.gkA.release();
        }
        if (this.gkB != null) {
            this.gkB.setListPullRefreshListener(null);
            this.gkB.a((h.d) null);
            this.gkB.a((h.a) null);
            this.gkB.a((h.b) null);
            this.gkB.release();
        }
        this.geC.setOnSrollToBottomListener(null);
        if (this.geI != null) {
            this.geI.b(this.geJ);
        }
        this.geC.removeOnScrollListener(this.mOnScrollListener);
        if (this.dly != null) {
            this.dly.release();
        }
        this.geC.setRecyclerListener(null);
        if (this.gkG != null) {
            this.gkG.onDestroy();
        }
        if (this.fyi != null) {
            this.fyi.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.acs().destroy();
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gkS);
    }

    public void onPause() {
        this.gkF.onPause();
        if (this.gkD != null) {
            this.gkD.onPause();
        }
    }

    public void onResume() {
        if (this.fwP) {
            reload();
            this.fwP = false;
        }
        if (this.geK != null) {
            this.geK.resume();
        }
        if (this.gkD != null) {
            this.gkD.onResume();
        }
    }

    public void bvT() {
        if (this.gkD != null) {
            this.gkD.notifyDataSetChanged();
        }
    }

    public void bvU() {
        if (this.gkF != null) {
            this.gkF.kf(true);
        }
        t.bat().gV(false);
        com.baidu.tieba.a.d.aCV().bJ("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gkS);
    }

    public void bxx() {
        this.gkF.bxP();
    }

    public void bxC() {
        this.gkF.bxC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJw() {
        com.baidu.tieba.homepage.framework.a.bwq().n(System.currentTimeMillis(), 1);
        if (this.dpz != null && !this.dpz.pQ()) {
            this.dpz.akR();
            this.dpz.iZ(0);
        }
        this.gkF.aJw();
    }
}
