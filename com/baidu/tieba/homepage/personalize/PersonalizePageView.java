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
    private LinearLayoutManager bpJ;
    private final CustomMessageListener cij;
    private g djG;
    private PbListView dnG;
    private int dpp;
    private k fcq;
    private CustomMessageListener fcs;
    private boolean fuD;
    private com.baidu.tieba.c.c fvW;
    private CustomMessageListener fvq;
    private BdTypeRecyclerView gbU;
    private ScrollFragmentTabHost gca;
    ScrollFragmentTabHost.a gcb;
    private BigdaySwipeRefreshLayout gcc;
    private View.OnClickListener gce;
    private NEGFeedBackView.a ggS;
    private com.baidu.tieba.homepage.personalize.bigday.b ghR;
    private com.baidu.tieba.homepage.personalize.bigday.a ghS;
    private a ghT;
    private w ghU;
    private com.baidu.tieba.homepage.framework.b ghV;
    private e ghW;
    private com.baidu.tieba.homepage.personalize.a ghX;
    private com.baidu.tieba.homepage.personalize.model.e ghY;
    private long ghZ;
    h.d ght;
    h.b ghu;
    private FloatingAnimationView gia;
    private boolean gib;
    private int gic;
    private int gie;
    private boolean gif;
    private int gig;
    private e.a gih;
    h.c gii;
    h.a gij;
    private Runnable gik;
    public CustomMessageListener gil;
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
        int i = personalizePageView.gic + 1;
        personalizePageView.gic = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gca = scrollFragmentTabHost;
        if (this.gca != null) {
            this.gca.b(this.gcb);
            this.gca.a(this.gcb);
        }
        if (this.ghW != null) {
            this.ghW.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.ghX != null) {
            this.ghX.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.gcc != null) {
            this.gcc.oU();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ghU != null) {
            this.ghU.setPageUniqueId(bdUniqueId);
        }
        if (this.ghW != null) {
            this.ghW.l(bdUniqueId);
        }
        if (this.ghY != null) {
            this.ghY.h(bdUniqueId);
        }
        if (this.ghS != null) {
            this.ghS.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.aco().setTag(bdUniqueId);
        if (this.cij != null) {
            this.cij.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cij);
        }
        if (this.ghX != null) {
            this.ghX.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        o oVar = new o();
        oVar.EM(String.valueOf(floatInfo.activity_id));
        oVar.ee(floatInfo.dynamic_url);
        oVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        oVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        oVar.EL(floatInfo.float_url);
        oVar.EK(floatInfo.jump_url);
        oVar.setType(floatInfo.show_type.intValue());
        return oVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.ghZ = 0L;
        this.mSkinType = 3;
        this.fuD = false;
        this.gib = false;
        this.gic = 0;
        this.gie = 0;
        this.gif = false;
        this.gig = 1;
        this.fcs = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fcq == null) {
                            PersonalizePageView.this.fcq = new k(new i());
                        }
                        PersonalizePageView.this.fcq.a(PersonalizePageView.this.gbU, 2);
                    } else if (PersonalizePageView.this.fcq != null) {
                        PersonalizePageView.this.fcq.ow();
                    }
                }
            }
        };
        this.ggS = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.ghU != null) {
                        PersonalizePageView.this.ghU.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
                }
            }
        };
        this.dpp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dpp != i && PersonalizePageView.this.gca != null) {
                    PersonalizePageView.this.dpp = i;
                    if (PersonalizePageView.this.dpp == 1) {
                        PersonalizePageView.this.gca.aJu();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gca.aJv();
                    } else {
                        PersonalizePageView.this.gca.aJu();
                    }
                }
            }
        };
        this.gcb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvL() {
                if (PersonalizePageView.this.gca != null) {
                    PersonalizePageView.this.dpp = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gbU)) {
                        PersonalizePageView.this.gca.aJv();
                    } else {
                        PersonalizePageView.this.gca.aJu();
                    }
                }
            }
        };
        this.gih = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fjz = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("key_first_install", true);

            private void bwB() {
                if (this.fjz) {
                    this.fjz = false;
                    com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i, int i2, int i3) {
                if (PersonalizePageView.this.ghV == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bgJ = PersonalizePageView.this.bgJ();
                PersonalizePageView.this.aJh();
                if (bgJ) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.ghV.L(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void w(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.ghV != null) {
                    PersonalizePageView.this.ghV.v(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.kc()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bwB();
                } else if (!this.fjz) {
                    PersonalizePageView.this.gcc.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bwB();
                    PersonalizePageView.this.bvA();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bwB();
                PersonalizePageView.this.gcc.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJh();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.ghW.bwO());
                PersonalizePageView.this.dF(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fvW != null) {
                    PersonalizePageView.this.fvW.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bwC() {
                if (PersonalizePageView.this.dnG != null) {
                    PersonalizePageView.this.dnG.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dnG.akE();
                }
            }
        };
        this.gii = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                com.baidu.tieba.a.d.aCF().sl("page_recommend");
                PersonalizePageView.this.ghW.update();
                PersonalizePageView.this.ghW.lm(false);
                PersonalizePageView.this.gif = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.ght = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void es(boolean z) {
                if (PersonalizePageView.this.ghW != null && PersonalizePageView.this.ghW.bmJ() != null) {
                    PersonalizePageView.this.ghW.bmJ().bwl();
                }
            }
        };
        this.gij = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void akU() {
                if (PersonalizePageView.this.gif) {
                    PersonalizePageView.this.gie = 0;
                    PersonalizePageView.this.gig = 1;
                    PersonalizePageView.this.gif = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.ghu = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.ghW != null) {
                    PersonalizePageView.this.ghW.lm(true);
                    PersonalizePageView.this.ghW.bwH();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahO().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aco().gR(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gik = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.ahO().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.cij = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.buS();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gce = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aIQ();
            }
        };
        this.fvq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fuD = true;
                    }
                }
            }
        };
        this.gil = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gcc != null && !PersonalizePageView.this.gcc.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.ghS == null) {
                            PersonalizePageView.this.ghS = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.ghS.iV(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.ghT = PersonalizePageView.this.ghS;
                            PersonalizePageView.this.bwy();
                        } else if (PersonalizePageView.this.ghT != PersonalizePageView.this.ghS) {
                            PersonalizePageView.this.ghT = PersonalizePageView.this.ghS;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.ghS.setEnable(true);
                        PersonalizePageView.this.gcc.setProgressView(PersonalizePageView.this.ghS);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gcc.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.ghR == null) {
                        PersonalizePageView.this.ghR = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.ghT = PersonalizePageView.this.ghR;
                        PersonalizePageView.this.bwy();
                    } else if (PersonalizePageView.this.ghT != PersonalizePageView.this.ghR || !aVar.equals(PersonalizePageView.this.ghR.bxa())) {
                        PersonalizePageView.this.ghT = PersonalizePageView.this.ghR;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.ghR.setEnable(true);
                    PersonalizePageView.this.gcc.setProgressView(PersonalizePageView.this.ghR);
                    PersonalizePageView.this.ghR.a(aVar);
                    PersonalizePageView.this.gcc.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghZ = 0L;
        this.mSkinType = 3;
        this.fuD = false;
        this.gib = false;
        this.gic = 0;
        this.gie = 0;
        this.gif = false;
        this.gig = 1;
        this.fcs = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fcq == null) {
                            PersonalizePageView.this.fcq = new k(new i());
                        }
                        PersonalizePageView.this.fcq.a(PersonalizePageView.this.gbU, 2);
                    } else if (PersonalizePageView.this.fcq != null) {
                        PersonalizePageView.this.fcq.ow();
                    }
                }
            }
        };
        this.ggS = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.ghU != null) {
                        PersonalizePageView.this.ghU.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
                }
            }
        };
        this.dpp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dpp != i && PersonalizePageView.this.gca != null) {
                    PersonalizePageView.this.dpp = i;
                    if (PersonalizePageView.this.dpp == 1) {
                        PersonalizePageView.this.gca.aJu();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gca.aJv();
                    } else {
                        PersonalizePageView.this.gca.aJu();
                    }
                }
            }
        };
        this.gcb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvL() {
                if (PersonalizePageView.this.gca != null) {
                    PersonalizePageView.this.dpp = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gbU)) {
                        PersonalizePageView.this.gca.aJv();
                    } else {
                        PersonalizePageView.this.gca.aJu();
                    }
                }
            }
        };
        this.gih = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fjz = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("key_first_install", true);

            private void bwB() {
                if (this.fjz) {
                    this.fjz = false;
                    com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i, int i2, int i3) {
                if (PersonalizePageView.this.ghV == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bgJ = PersonalizePageView.this.bgJ();
                PersonalizePageView.this.aJh();
                if (bgJ) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.ghV.L(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void w(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.ghV != null) {
                    PersonalizePageView.this.ghV.v(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.kc()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bwB();
                } else if (!this.fjz) {
                    PersonalizePageView.this.gcc.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bwB();
                    PersonalizePageView.this.bvA();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bwB();
                PersonalizePageView.this.gcc.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJh();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.ghW.bwO());
                PersonalizePageView.this.dF(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fvW != null) {
                    PersonalizePageView.this.fvW.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bwC() {
                if (PersonalizePageView.this.dnG != null) {
                    PersonalizePageView.this.dnG.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dnG.akE();
                }
            }
        };
        this.gii = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                com.baidu.tieba.a.d.aCF().sl("page_recommend");
                PersonalizePageView.this.ghW.update();
                PersonalizePageView.this.ghW.lm(false);
                PersonalizePageView.this.gif = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.ght = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void es(boolean z) {
                if (PersonalizePageView.this.ghW != null && PersonalizePageView.this.ghW.bmJ() != null) {
                    PersonalizePageView.this.ghW.bmJ().bwl();
                }
            }
        };
        this.gij = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void akU() {
                if (PersonalizePageView.this.gif) {
                    PersonalizePageView.this.gie = 0;
                    PersonalizePageView.this.gig = 1;
                    PersonalizePageView.this.gif = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.ghu = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.ghW != null) {
                    PersonalizePageView.this.ghW.lm(true);
                    PersonalizePageView.this.ghW.bwH();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahO().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aco().gR(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gik = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.ahO().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.cij = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.buS();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gce = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aIQ();
            }
        };
        this.fvq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fuD = true;
                    }
                }
            }
        };
        this.gil = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gcc != null && !PersonalizePageView.this.gcc.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.ghS == null) {
                            PersonalizePageView.this.ghS = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.ghS.iV(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.ghT = PersonalizePageView.this.ghS;
                            PersonalizePageView.this.bwy();
                        } else if (PersonalizePageView.this.ghT != PersonalizePageView.this.ghS) {
                            PersonalizePageView.this.ghT = PersonalizePageView.this.ghS;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.ghS.setEnable(true);
                        PersonalizePageView.this.gcc.setProgressView(PersonalizePageView.this.ghS);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gcc.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.ghR == null) {
                        PersonalizePageView.this.ghR = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.ghT = PersonalizePageView.this.ghR;
                        PersonalizePageView.this.bwy();
                    } else if (PersonalizePageView.this.ghT != PersonalizePageView.this.ghR || !aVar.equals(PersonalizePageView.this.ghR.bxa())) {
                        PersonalizePageView.this.ghT = PersonalizePageView.this.ghR;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.ghR.setEnable(true);
                    PersonalizePageView.this.gcc.setProgressView(PersonalizePageView.this.ghR);
                    PersonalizePageView.this.ghR.a(aVar);
                    PersonalizePageView.this.gcc.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ghZ = 0L;
        this.mSkinType = 3;
        this.fuD = false;
        this.gib = false;
        this.gic = 0;
        this.gie = 0;
        this.gif = false;
        this.gig = 1;
        this.fcs = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fcq == null) {
                            PersonalizePageView.this.fcq = new k(new i());
                        }
                        PersonalizePageView.this.fcq.a(PersonalizePageView.this.gbU, 2);
                    } else if (PersonalizePageView.this.fcq != null) {
                        PersonalizePageView.this.fcq.ow();
                    }
                }
            }
        };
        this.ggS = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.ghU != null) {
                        PersonalizePageView.this.ghU.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i2));
                }
            }
        };
        this.dpp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.dpp != i2 && PersonalizePageView.this.gca != null) {
                    PersonalizePageView.this.dpp = i2;
                    if (PersonalizePageView.this.dpp == 1) {
                        PersonalizePageView.this.gca.aJu();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gca.aJv();
                    } else {
                        PersonalizePageView.this.gca.aJu();
                    }
                }
            }
        };
        this.gcb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvL() {
                if (PersonalizePageView.this.gca != null) {
                    PersonalizePageView.this.dpp = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gbU)) {
                        PersonalizePageView.this.gca.aJv();
                    } else {
                        PersonalizePageView.this.gca.aJu();
                    }
                }
            }
        };
        this.gih = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fjz = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("key_first_install", true);

            private void bwB() {
                if (this.fjz) {
                    this.fjz = false;
                    com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i2, int i22, int i3) {
                if (PersonalizePageView.this.ghV == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bgJ = PersonalizePageView.this.bgJ();
                PersonalizePageView.this.aJh();
                if (bgJ) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.ghV.L(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void w(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.ghV != null) {
                    PersonalizePageView.this.ghV.v(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.kc()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bwB();
                } else if (!this.fjz) {
                    PersonalizePageView.this.gcc.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bwB();
                    PersonalizePageView.this.bvA();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bwB();
                PersonalizePageView.this.gcc.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJh();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.ghW.bwO());
                PersonalizePageView.this.dF(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fvW != null) {
                    PersonalizePageView.this.fvW.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bwC() {
                if (PersonalizePageView.this.dnG != null) {
                    PersonalizePageView.this.dnG.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dnG.akE();
                }
            }
        };
        this.gii = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                com.baidu.tieba.a.d.aCF().sl("page_recommend");
                PersonalizePageView.this.ghW.update();
                PersonalizePageView.this.ghW.lm(false);
                PersonalizePageView.this.gif = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.ght = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void es(boolean z) {
                if (PersonalizePageView.this.ghW != null && PersonalizePageView.this.ghW.bmJ() != null) {
                    PersonalizePageView.this.ghW.bmJ().bwl();
                }
            }
        };
        this.gij = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void akU() {
                if (PersonalizePageView.this.gif) {
                    PersonalizePageView.this.gie = 0;
                    PersonalizePageView.this.gig = 1;
                    PersonalizePageView.this.gif = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.ghu = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.ghW != null) {
                    PersonalizePageView.this.ghW.lm(true);
                    PersonalizePageView.this.ghW.bwH();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahO().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aco().gR(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gik = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.ahO().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.cij = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.buS();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gce = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aIQ();
            }
        };
        this.fvq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fuD = true;
                    }
                }
            }
        };
        this.gil = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gcc != null && !PersonalizePageView.this.gcc.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.ghS == null) {
                            PersonalizePageView.this.ghS = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.ghS.iV(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.ghT = PersonalizePageView.this.ghS;
                            PersonalizePageView.this.bwy();
                        } else if (PersonalizePageView.this.ghT != PersonalizePageView.this.ghS) {
                            PersonalizePageView.this.ghT = PersonalizePageView.this.ghS;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.ghS.setEnable(true);
                        PersonalizePageView.this.gcc.setProgressView(PersonalizePageView.this.ghS);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gcc.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.ghR == null) {
                        PersonalizePageView.this.ghR = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.ghT = PersonalizePageView.this.ghR;
                        PersonalizePageView.this.bwy();
                    } else if (PersonalizePageView.this.ghT != PersonalizePageView.this.ghR || !aVar.equals(PersonalizePageView.this.ghR.bxa())) {
                        PersonalizePageView.this.ghT = PersonalizePageView.this.ghR;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.ghR.setEnable(true);
                    PersonalizePageView.this.gcc.setProgressView(PersonalizePageView.this.ghR);
                    PersonalizePageView.this.ghR.a(aVar);
                    PersonalizePageView.this.gcc.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gbU = new BdTypeRecyclerView(context);
        this.bpJ = new LinearLayoutManager(this.gbU.getContext());
        this.gbU.setLayoutManager(this.bpJ);
        this.gbU.setFadingEdgeLength(0);
        this.gbU.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fcq = new k(new i());
            this.fcq.a(this.gbU, 2);
        }
        MessageManager.getInstance().registerListener(this.fcs);
        this.gcc = new BigdaySwipeRefreshLayout(context);
        this.gcc.addView(this.gbU);
        this.dnG = new PbListView(context);
        this.dnG.getView();
        this.dnG.iU(R.color.cp_bg_line_e);
        this.dnG.akA();
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnG.setTextSize(R.dimen.tbfontsize33);
        this.dnG.iT(R.color.cp_cont_e);
        this.dnG.setHeight(l.g(context, R.dimen.tbds182));
        this.dnG.setOnClickListener(this.gce);
        this.dnG.akH();
        this.gbU.setNextPage(this.dnG);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.gil);
        com.baidu.tbadk.core.bigday.b.aco().dG(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahO().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.aco().gR(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.gcc);
        ((FrameLayout.LayoutParams) this.gcc.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.ghY = new com.baidu.tieba.homepage.personalize.model.e();
        this.ghU = new w(context, this.gbU);
        this.ghU.b(this.ghY);
        this.ghW = new e(this.pageContext, this.gbU, this.ghU, this.gcc);
        this.ghX = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.fvq);
        this.gic = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(Context context) {
        if (this.gia == null) {
            this.gia = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.g(context, R.dimen.tbds200);
            addView(this.gia, layoutParams);
            this.gia.setVisibility(8);
            this.gia.setPageId(this.pageContext.getUniqueId());
            this.fvW = new com.baidu.tieba.c.c(this.pageContext, this.gia, 1);
        }
    }

    public void bwy() {
        if (this.ghT != null) {
            this.ghT.setListPullRefreshListener(this.gii);
            this.ghT.a(this.ght);
            this.ghT.a(this.gij);
            this.ghT.a(this.ghu);
        }
    }

    public void bpT() {
        this.ghU.b(this.ggS);
        this.ghW.a(this.gih);
        this.ghX.a(this);
        bwy();
        this.gbU.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                PersonalizePageView.this.gie += i2;
                if (PersonalizePageView.this.gie < height * 3 || PersonalizePageView.this.gig != 1) {
                    if (PersonalizePageView.this.gie < height * 3 && PersonalizePageView.this.gig == 2) {
                        PersonalizePageView.this.gig = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        return;
                    }
                    return;
                }
                PersonalizePageView.this.gig = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.gig)));
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.bpJ != null && i == 0 && PersonalizePageView.this.bpJ.getItemCount() - PersonalizePageView.this.bpJ.findLastVisibleItemPosition() <= 3) {
                    PersonalizePageView.this.aIQ();
                }
            }
        });
        this.gbU.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aIQ();
            }
        });
        this.gbU.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.ghZ >= 5000) {
                    PersonalizePageView.this.ghW.bI(i, i2);
                }
            }
        }, 1L);
        this.gbU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.ghW != null && PersonalizePageView.this.ghW.bmJ() != null) {
                        PersonalizePageView.this.ghW.bmJ().cm(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).bar().stopPlay();
                    }
                }
            }
        });
        this.gbU.removeOnScrollListener(this.mOnScrollListener);
        this.gbU.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.ghV = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.dnG != null) {
            this.dnG.setText(getContext().getString(R.string.pb_load_more));
            this.dnG.akE();
        }
        this.ghW.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.ghW != null) {
            this.ghW.lq(!z);
        }
        this.gib = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.gib;
    }

    public void d(Long l) {
        this.ghW.d(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.ghW != null) {
            this.ghW.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void showFloatingView() {
        if (this.ghW != null) {
            this.ghW.showFloatingView();
        }
    }

    public void bwz() {
        if (this.ghW != null) {
            this.ghW.bwz();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.djG != null) {
                this.djG.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.l(this.gcc, R.color.cp_bg_line_e);
            if (this.ghS != null) {
                this.ghS.iV(i);
            }
            if (this.dnG != null) {
                this.dnG.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dnG.iV(i);
            }
            this.ghU.onChangeSkinType(i);
            if (this.ghW != null) {
                this.ghW.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void az(String str, int i) {
        if (this.dnG != null) {
            this.dnG.setText(getContext().getString(R.string.pb_load_more));
            this.dnG.akE();
        }
        this.ghW.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.ghW != null) {
                        PersonalizePageView.this.ghW.update();
                    }
                }
            });
        }
        this.refreshView.qN(str);
        this.refreshView.attachView(view, z);
        this.refreshView.atI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJh() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.djG != null) {
            this.djG.dettachView(this);
            this.djG = null;
            this.gbU.setNextPage(this.dnG);
            this.dnG.setText(getContext().getString(R.string.pb_load_more));
            this.dnG.akE();
        }
        if (this.gcc != null) {
            this.gcc.setVisibility(0);
        }
        if (this.ghV != null) {
            this.ghV.bvq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgJ() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.djG == null) {
            if (i < 0) {
                this.djG = new g(getContext());
            } else {
                this.djG = new g(getContext(), i);
            }
            this.djG.onChangeSkinType();
        }
        this.djG.attachView(this, z);
        this.gbU.setNextPage(null);
        if (this.gcc != null) {
            this.gcc.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.ghW != null) {
            this.ghW.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.fvW != null) {
            this.fvW.aGQ();
        }
        setViewForeground(false);
        if (this.ghW != null) {
            this.ghW.kc(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.gic < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.gik, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.ghW != null) {
            this.ghW.lg(z);
        }
        if (this.gca != null) {
            this.gca.b(this.gcb);
            this.gca.a(this.gcb);
            this.gcb.bvL();
        }
    }

    public void bvA() {
        if (this.ghW != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.ghW.update();
        }
        if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.aco().acq();
            com.baidu.tbadk.core.bigday.b.aco().acp();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.ghW != null) {
            this.ghW.update();
        } else if (this.gbU != null && this.gcc != null) {
            showFloatingView();
            this.gbU.setSelection(0);
            if (!this.gcc.isRefreshing()) {
                if (this.ghW != null && this.ghW.bmJ() != null) {
                    this.ghW.bmJ().bwl();
                    this.ghW.lm(false);
                }
                this.gcc.setRefreshing(true);
            }
            if (this.gcb != null) {
                this.gcb.bvL();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fcs);
        MessageManager.getInstance().unRegisterListener(this.fvq);
        MessageManager.getInstance().unRegisterListener(this.gil);
        this.ghW.onDestroy();
        this.ghU.b((NEGFeedBackView.a) null);
        this.ghU.onDestroy();
        this.ghW.a((e.a) null);
        if (this.ghR != null) {
            this.ghR.setListPullRefreshListener(null);
            this.ghR.a((h.d) null);
            this.ghR.a((h.a) null);
            this.ghR.a((h.b) null);
            this.ghR.release();
        }
        if (this.ghS != null) {
            this.ghS.setListPullRefreshListener(null);
            this.ghS.a((h.d) null);
            this.ghS.a((h.a) null);
            this.ghS.a((h.b) null);
            this.ghS.release();
        }
        this.gbU.setOnSrollToBottomListener(null);
        if (this.gca != null) {
            this.gca.b(this.gcb);
        }
        this.gbU.removeOnScrollListener(this.mOnScrollListener);
        if (this.djG != null) {
            this.djG.release();
        }
        this.gbU.setRecyclerListener(null);
        if (this.ghX != null) {
            this.ghX.onDestroy();
        }
        if (this.fvW != null) {
            this.fvW.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.aco().destroy();
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gik);
    }

    public void onPause() {
        this.ghW.onPause();
        if (this.ghU != null) {
            this.ghU.onPause();
        }
    }

    public void onResume() {
        if (this.fuD) {
            reload();
            this.fuD = false;
        }
        if (this.gcc != null) {
            this.gcc.resume();
        }
        if (this.ghU != null) {
            this.ghU.onResume();
        }
    }

    public void buS() {
        if (this.ghU != null) {
            this.ghU.notifyDataSetChanged();
        }
    }

    public void buT() {
        if (this.ghW != null) {
            this.ghW.kc(true);
        }
        t.aZN().gS(false);
        com.baidu.tieba.a.d.aCF().bJ("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gik);
    }

    public void bwv() {
        this.ghW.bwN();
    }

    public void bwA() {
        this.ghW.bwA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIQ() {
        com.baidu.tieba.homepage.framework.a.bvp().n(System.currentTimeMillis(), 1);
        if (this.dnG != null && !this.dnG.pP()) {
            this.dnG.akD();
            this.dnG.iW(0);
        }
        this.ghW.aIQ();
    }
}
