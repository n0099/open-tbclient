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
    private final CustomMessageListener ciq;
    private g djN;
    private PbListView dnN;
    private int dpw;
    private k fcQ;
    private CustomMessageListener fcS;
    private CustomMessageListener fvP;
    private boolean fvc;
    private com.baidu.tieba.c.c fwv;
    private BdTypeRecyclerView gcK;
    private ScrollFragmentTabHost gcQ;
    ScrollFragmentTabHost.a gcR;
    private BigdaySwipeRefreshLayout gcS;
    private View.OnClickListener gcU;
    private NEGFeedBackView.a ghI;
    private com.baidu.tieba.homepage.personalize.bigday.b giI;
    private com.baidu.tieba.homepage.personalize.bigday.a giJ;
    private a giK;
    private w giL;
    private com.baidu.tieba.homepage.framework.b giM;
    private e giN;
    private com.baidu.tieba.homepage.personalize.a giO;
    private com.baidu.tieba.homepage.personalize.model.e giP;
    private long giQ;
    private FloatingAnimationView giR;
    private boolean giS;
    private int giT;
    private int giU;
    private boolean giV;
    private int giW;
    private e.a giX;
    h.c giY;
    h.a giZ;
    h.d gik;
    h.b gil;
    private Runnable gja;
    public CustomMessageListener gjb;
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
        int i = personalizePageView.giT + 1;
        personalizePageView.giT = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gcQ = scrollFragmentTabHost;
        if (this.gcQ != null) {
            this.gcQ.b(this.gcR);
            this.gcQ.a(this.gcR);
        }
        if (this.giN != null) {
            this.giN.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.giO != null) {
            this.giO.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.gcS != null) {
            this.gcS.oU();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.giL != null) {
            this.giL.setPageUniqueId(bdUniqueId);
        }
        if (this.giN != null) {
            this.giN.l(bdUniqueId);
        }
        if (this.giP != null) {
            this.giP.h(bdUniqueId);
        }
        if (this.giJ != null) {
            this.giJ.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.aco().setTag(bdUniqueId);
        if (this.ciq != null) {
            this.ciq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ciq);
        }
        if (this.giO != null) {
            this.giO.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        o oVar = new o();
        oVar.EN(String.valueOf(floatInfo.activity_id));
        oVar.ed(floatInfo.dynamic_url);
        oVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        oVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        oVar.EM(floatInfo.float_url);
        oVar.EL(floatInfo.jump_url);
        oVar.setType(floatInfo.show_type.intValue());
        return oVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.giQ = 0L;
        this.mSkinType = 3;
        this.fvc = false;
        this.giS = false;
        this.giT = 0;
        this.giU = 0;
        this.giV = false;
        this.giW = 1;
        this.fcS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fcQ == null) {
                            PersonalizePageView.this.fcQ = new k(new i());
                        }
                        PersonalizePageView.this.fcQ.a(PersonalizePageView.this.gcK, 2);
                    } else if (PersonalizePageView.this.fcQ != null) {
                        PersonalizePageView.this.fcQ.ow();
                    }
                }
            }
        };
        this.ghI = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.giL != null) {
                        PersonalizePageView.this.giL.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
                }
            }
        };
        this.dpw = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dpw != i && PersonalizePageView.this.gcQ != null) {
                    PersonalizePageView.this.dpw = i;
                    if (PersonalizePageView.this.dpw == 1) {
                        PersonalizePageView.this.gcQ.aJw();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gcQ.aJx();
                    } else {
                        PersonalizePageView.this.gcQ.aJw();
                    }
                }
            }
        };
        this.gcR = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvY() {
                if (PersonalizePageView.this.gcQ != null) {
                    PersonalizePageView.this.dpw = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gcK)) {
                        PersonalizePageView.this.gcQ.aJx();
                    } else {
                        PersonalizePageView.this.gcQ.aJw();
                    }
                }
            }
        };
        this.giX = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fjZ = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("key_first_install", true);

            private void bwP() {
                if (this.fjZ) {
                    this.fjZ = false;
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i, int i2, int i3) {
                if (PersonalizePageView.this.giM == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bgM = PersonalizePageView.this.bgM();
                PersonalizePageView.this.aJj();
                if (bgM) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.giM.L(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void w(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.giM != null) {
                    PersonalizePageView.this.giM.v(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.kc()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bwP();
                } else if (!this.fjZ) {
                    PersonalizePageView.this.gcS.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bwP();
                    PersonalizePageView.this.bvN();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bwP();
                PersonalizePageView.this.gcS.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJj();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.giN.bxc());
                PersonalizePageView.this.dG(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fwv != null) {
                    PersonalizePageView.this.fwv.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bwQ() {
                if (PersonalizePageView.this.dnN != null) {
                    PersonalizePageView.this.dnN.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dnN.akG();
                }
            }
        };
        this.giY = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                com.baidu.tieba.a.d.aCH().sl("page_recommend");
                PersonalizePageView.this.giN.update();
                PersonalizePageView.this.giN.lm(false);
                PersonalizePageView.this.giV = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gik = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void es(boolean z) {
                if (PersonalizePageView.this.giN != null && PersonalizePageView.this.giN.bmT() != null) {
                    PersonalizePageView.this.giN.bmT().bwz();
                }
            }
        };
        this.giZ = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void akW() {
                if (PersonalizePageView.this.giV) {
                    PersonalizePageView.this.giU = 0;
                    PersonalizePageView.this.giW = 1;
                    PersonalizePageView.this.giV = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gil = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.giN != null) {
                    PersonalizePageView.this.giN.lm(true);
                    PersonalizePageView.this.giN.bwV();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aco().gR(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gja = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.ciq = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bvf();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gcU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aIS();
            }
        };
        this.fvP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fvc = true;
                    }
                }
            }
        };
        this.gjb = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gcS != null && !PersonalizePageView.this.gcS.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.giJ == null) {
                            PersonalizePageView.this.giJ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.giJ.iV(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.giK = PersonalizePageView.this.giJ;
                            PersonalizePageView.this.bwM();
                        } else if (PersonalizePageView.this.giK != PersonalizePageView.this.giJ) {
                            PersonalizePageView.this.giK = PersonalizePageView.this.giJ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.giJ.setEnable(true);
                        PersonalizePageView.this.gcS.setProgressView(PersonalizePageView.this.giJ);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gcS.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.giI == null) {
                        PersonalizePageView.this.giI = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.giK = PersonalizePageView.this.giI;
                        PersonalizePageView.this.bwM();
                    } else if (PersonalizePageView.this.giK != PersonalizePageView.this.giI || !aVar.equals(PersonalizePageView.this.giI.bxo())) {
                        PersonalizePageView.this.giK = PersonalizePageView.this.giI;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.giI.setEnable(true);
                    PersonalizePageView.this.gcS.setProgressView(PersonalizePageView.this.giI);
                    PersonalizePageView.this.giI.a(aVar);
                    PersonalizePageView.this.gcS.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.giQ = 0L;
        this.mSkinType = 3;
        this.fvc = false;
        this.giS = false;
        this.giT = 0;
        this.giU = 0;
        this.giV = false;
        this.giW = 1;
        this.fcS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fcQ == null) {
                            PersonalizePageView.this.fcQ = new k(new i());
                        }
                        PersonalizePageView.this.fcQ.a(PersonalizePageView.this.gcK, 2);
                    } else if (PersonalizePageView.this.fcQ != null) {
                        PersonalizePageView.this.fcQ.ow();
                    }
                }
            }
        };
        this.ghI = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.giL != null) {
                        PersonalizePageView.this.giL.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
                }
            }
        };
        this.dpw = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dpw != i && PersonalizePageView.this.gcQ != null) {
                    PersonalizePageView.this.dpw = i;
                    if (PersonalizePageView.this.dpw == 1) {
                        PersonalizePageView.this.gcQ.aJw();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gcQ.aJx();
                    } else {
                        PersonalizePageView.this.gcQ.aJw();
                    }
                }
            }
        };
        this.gcR = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvY() {
                if (PersonalizePageView.this.gcQ != null) {
                    PersonalizePageView.this.dpw = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gcK)) {
                        PersonalizePageView.this.gcQ.aJx();
                    } else {
                        PersonalizePageView.this.gcQ.aJw();
                    }
                }
            }
        };
        this.giX = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fjZ = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("key_first_install", true);

            private void bwP() {
                if (this.fjZ) {
                    this.fjZ = false;
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i, int i2, int i3) {
                if (PersonalizePageView.this.giM == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bgM = PersonalizePageView.this.bgM();
                PersonalizePageView.this.aJj();
                if (bgM) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.giM.L(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void w(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.giM != null) {
                    PersonalizePageView.this.giM.v(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.kc()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bwP();
                } else if (!this.fjZ) {
                    PersonalizePageView.this.gcS.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bwP();
                    PersonalizePageView.this.bvN();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bwP();
                PersonalizePageView.this.gcS.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJj();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.giN.bxc());
                PersonalizePageView.this.dG(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fwv != null) {
                    PersonalizePageView.this.fwv.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bwQ() {
                if (PersonalizePageView.this.dnN != null) {
                    PersonalizePageView.this.dnN.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dnN.akG();
                }
            }
        };
        this.giY = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                com.baidu.tieba.a.d.aCH().sl("page_recommend");
                PersonalizePageView.this.giN.update();
                PersonalizePageView.this.giN.lm(false);
                PersonalizePageView.this.giV = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gik = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void es(boolean z) {
                if (PersonalizePageView.this.giN != null && PersonalizePageView.this.giN.bmT() != null) {
                    PersonalizePageView.this.giN.bmT().bwz();
                }
            }
        };
        this.giZ = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void akW() {
                if (PersonalizePageView.this.giV) {
                    PersonalizePageView.this.giU = 0;
                    PersonalizePageView.this.giW = 1;
                    PersonalizePageView.this.giV = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gil = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.giN != null) {
                    PersonalizePageView.this.giN.lm(true);
                    PersonalizePageView.this.giN.bwV();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aco().gR(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gja = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.ciq = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bvf();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gcU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aIS();
            }
        };
        this.fvP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fvc = true;
                    }
                }
            }
        };
        this.gjb = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gcS != null && !PersonalizePageView.this.gcS.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.giJ == null) {
                            PersonalizePageView.this.giJ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.giJ.iV(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.giK = PersonalizePageView.this.giJ;
                            PersonalizePageView.this.bwM();
                        } else if (PersonalizePageView.this.giK != PersonalizePageView.this.giJ) {
                            PersonalizePageView.this.giK = PersonalizePageView.this.giJ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.giJ.setEnable(true);
                        PersonalizePageView.this.gcS.setProgressView(PersonalizePageView.this.giJ);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gcS.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.giI == null) {
                        PersonalizePageView.this.giI = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.giK = PersonalizePageView.this.giI;
                        PersonalizePageView.this.bwM();
                    } else if (PersonalizePageView.this.giK != PersonalizePageView.this.giI || !aVar.equals(PersonalizePageView.this.giI.bxo())) {
                        PersonalizePageView.this.giK = PersonalizePageView.this.giI;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.giI.setEnable(true);
                    PersonalizePageView.this.gcS.setProgressView(PersonalizePageView.this.giI);
                    PersonalizePageView.this.giI.a(aVar);
                    PersonalizePageView.this.gcS.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.giQ = 0L;
        this.mSkinType = 3;
        this.fvc = false;
        this.giS = false;
        this.giT = 0;
        this.giU = 0;
        this.giV = false;
        this.giW = 1;
        this.fcS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fcQ == null) {
                            PersonalizePageView.this.fcQ = new k(new i());
                        }
                        PersonalizePageView.this.fcQ.a(PersonalizePageView.this.gcK, 2);
                    } else if (PersonalizePageView.this.fcQ != null) {
                        PersonalizePageView.this.fcQ.ow();
                    }
                }
            }
        };
        this.ghI = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.giL != null) {
                        PersonalizePageView.this.giL.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i2));
                }
            }
        };
        this.dpw = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.dpw != i2 && PersonalizePageView.this.gcQ != null) {
                    PersonalizePageView.this.dpw = i2;
                    if (PersonalizePageView.this.dpw == 1) {
                        PersonalizePageView.this.gcQ.aJw();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gcQ.aJx();
                    } else {
                        PersonalizePageView.this.gcQ.aJw();
                    }
                }
            }
        };
        this.gcR = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvY() {
                if (PersonalizePageView.this.gcQ != null) {
                    PersonalizePageView.this.dpw = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gcK)) {
                        PersonalizePageView.this.gcQ.aJx();
                    } else {
                        PersonalizePageView.this.gcQ.aJw();
                    }
                }
            }
        };
        this.giX = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fjZ = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("key_first_install", true);

            private void bwP() {
                if (this.fjZ) {
                    this.fjZ = false;
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i2, int i22, int i3) {
                if (PersonalizePageView.this.giM == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bgM = PersonalizePageView.this.bgM();
                PersonalizePageView.this.aJj();
                if (bgM) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.giM.L(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void w(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.giM != null) {
                    PersonalizePageView.this.giM.v(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.kc()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bwP();
                } else if (!this.fjZ) {
                    PersonalizePageView.this.gcS.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bwP();
                    PersonalizePageView.this.bvN();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bwP();
                PersonalizePageView.this.gcS.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJj();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.giN.bxc());
                PersonalizePageView.this.dG(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fwv != null) {
                    PersonalizePageView.this.fwv.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bwQ() {
                if (PersonalizePageView.this.dnN != null) {
                    PersonalizePageView.this.dnN.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dnN.akG();
                }
            }
        };
        this.giY = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                com.baidu.tieba.a.d.aCH().sl("page_recommend");
                PersonalizePageView.this.giN.update();
                PersonalizePageView.this.giN.lm(false);
                PersonalizePageView.this.giV = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gik = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void es(boolean z) {
                if (PersonalizePageView.this.giN != null && PersonalizePageView.this.giN.bmT() != null) {
                    PersonalizePageView.this.giN.bmT().bwz();
                }
            }
        };
        this.giZ = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void akW() {
                if (PersonalizePageView.this.giV) {
                    PersonalizePageView.this.giU = 0;
                    PersonalizePageView.this.giW = 1;
                    PersonalizePageView.this.giV = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gil = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.giN != null) {
                    PersonalizePageView.this.giN.lm(true);
                    PersonalizePageView.this.giN.bwV();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aco().gR(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gja = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("show_is_uninterest_tag", PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.ciq = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bvf();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gcU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aIS();
            }
        };
        this.fvP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fvc = true;
                    }
                }
            }
        };
        this.gjb = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gcS != null && !PersonalizePageView.this.gcS.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.giJ == null) {
                            PersonalizePageView.this.giJ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.giJ.iV(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.giK = PersonalizePageView.this.giJ;
                            PersonalizePageView.this.bwM();
                        } else if (PersonalizePageView.this.giK != PersonalizePageView.this.giJ) {
                            PersonalizePageView.this.giK = PersonalizePageView.this.giJ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.giJ.setEnable(true);
                        PersonalizePageView.this.gcS.setProgressView(PersonalizePageView.this.giJ);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gcS.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.giI == null) {
                        PersonalizePageView.this.giI = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.giK = PersonalizePageView.this.giI;
                        PersonalizePageView.this.bwM();
                    } else if (PersonalizePageView.this.giK != PersonalizePageView.this.giI || !aVar.equals(PersonalizePageView.this.giI.bxo())) {
                        PersonalizePageView.this.giK = PersonalizePageView.this.giI;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.giI.setEnable(true);
                    PersonalizePageView.this.gcS.setProgressView(PersonalizePageView.this.giI);
                    PersonalizePageView.this.giI.a(aVar);
                    PersonalizePageView.this.gcS.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gcK = new BdTypeRecyclerView(context);
        this.bpJ = new LinearLayoutManager(this.gcK.getContext());
        this.gcK.setLayoutManager(this.bpJ);
        this.gcK.setFadingEdgeLength(0);
        this.gcK.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fcQ = new k(new i());
            this.fcQ.a(this.gcK, 2);
        }
        MessageManager.getInstance().registerListener(this.fcS);
        this.gcS = new BigdaySwipeRefreshLayout(context);
        this.gcS.addView(this.gcK);
        this.dnN = new PbListView(context);
        this.dnN.getView();
        this.dnN.iU(R.color.cp_bg_line_e);
        this.dnN.akC();
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnN.setTextSize(R.dimen.tbfontsize33);
        this.dnN.iT(R.color.cp_cont_e);
        this.dnN.setHeight(l.g(context, R.dimen.tbds182));
        this.dnN.setOnClickListener(this.gcU);
        this.dnN.akJ();
        this.gcK.setNextPage(this.dnN);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.gjb);
        com.baidu.tbadk.core.bigday.b.aco().dG(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.aco().gR(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.gcS);
        ((FrameLayout.LayoutParams) this.gcS.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.giP = new com.baidu.tieba.homepage.personalize.model.e();
        this.giL = new w(context, this.gcK);
        this.giL.b(this.giP);
        this.giN = new e(this.pageContext, this.gcK, this.giL, this.gcS);
        this.giO = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.fvP);
        this.giT = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dG(Context context) {
        if (this.giR == null) {
            this.giR = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.g(context, R.dimen.tbds200);
            addView(this.giR, layoutParams);
            this.giR.setVisibility(8);
            this.giR.setPageId(this.pageContext.getUniqueId());
            this.fwv = new com.baidu.tieba.c.c(this.pageContext, this.giR, 1);
        }
    }

    public void bwM() {
        if (this.giK != null) {
            this.giK.setListPullRefreshListener(this.giY);
            this.giK.a(this.gik);
            this.giK.a(this.giZ);
            this.giK.a(this.gil);
        }
    }

    public void bqg() {
        this.giL.b(this.ghI);
        this.giN.a(this.giX);
        this.giO.a(this);
        bwM();
        this.gcK.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                PersonalizePageView.this.giU += i2;
                if (PersonalizePageView.this.giU < height * 3 || PersonalizePageView.this.giW != 1) {
                    if (PersonalizePageView.this.giU < height * 3 && PersonalizePageView.this.giW == 2) {
                        PersonalizePageView.this.giW = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        return;
                    }
                    return;
                }
                PersonalizePageView.this.giW = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.giW)));
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.bpJ != null && i == 0 && PersonalizePageView.this.bpJ.getItemCount() - PersonalizePageView.this.bpJ.findLastVisibleItemPosition() <= 3) {
                    PersonalizePageView.this.aIS();
                }
            }
        });
        this.gcK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aIS();
            }
        });
        this.gcK.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.giQ >= 5000) {
                    PersonalizePageView.this.giN.bI(i, i2);
                }
            }
        }, 1L);
        this.gcK.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.giN != null && PersonalizePageView.this.giN.bmT() != null) {
                        PersonalizePageView.this.giN.bmT().cn(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).bat().stopPlay();
                    }
                }
            }
        });
        this.gcK.removeOnScrollListener(this.mOnScrollListener);
        this.gcK.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.giM = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.dnN != null) {
            this.dnN.setText(getContext().getString(R.string.pb_load_more));
            this.dnN.akG();
        }
        this.giN.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.giN != null) {
            this.giN.lq(!z);
        }
        this.giS = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.giS;
    }

    public void d(Long l) {
        this.giN.d(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.giN != null) {
            this.giN.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void showFloatingView() {
        if (this.giN != null) {
            this.giN.showFloatingView();
        }
    }

    public void bwN() {
        if (this.giN != null) {
            this.giN.bwN();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.djN != null) {
                this.djN.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.l(this.gcS, R.color.cp_bg_line_e);
            if (this.giJ != null) {
                this.giJ.iV(i);
            }
            if (this.dnN != null) {
                this.dnN.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dnN.iV(i);
            }
            this.giL.onChangeSkinType(i);
            if (this.giN != null) {
                this.giN.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void az(String str, int i) {
        if (this.dnN != null) {
            this.dnN.setText(getContext().getString(R.string.pb_load_more));
            this.dnN.akG();
        }
        this.giN.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.giN != null) {
                        PersonalizePageView.this.giN.update();
                    }
                }
            });
        }
        this.refreshView.qN(str);
        this.refreshView.attachView(view, z);
        this.refreshView.atK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJj() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.djN != null) {
            this.djN.dettachView(this);
            this.djN = null;
            this.gcK.setNextPage(this.dnN);
            this.dnN.setText(getContext().getString(R.string.pb_load_more));
            this.dnN.akG();
        }
        if (this.gcS != null) {
            this.gcS.setVisibility(0);
        }
        if (this.giM != null) {
            this.giM.bvD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgM() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.djN == null) {
            if (i < 0) {
                this.djN = new g(getContext());
            } else {
                this.djN = new g(getContext(), i);
            }
            this.djN.onChangeSkinType();
        }
        this.djN.attachView(this, z);
        this.gcK.setNextPage(null);
        if (this.gcS != null) {
            this.gcS.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.giN != null) {
            this.giN.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.fwv != null) {
            this.fwv.aGS();
        }
        setViewForeground(false);
        if (this.giN != null) {
            this.giN.kc(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.giT < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.gja, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.giN != null) {
            this.giN.lg(z);
        }
        if (this.gcQ != null) {
            this.gcQ.b(this.gcR);
            this.gcQ.a(this.gcR);
            this.gcR.bvY();
        }
    }

    public void bvN() {
        if (this.giN != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.giN.update();
        }
        if (com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.aco().acq();
            com.baidu.tbadk.core.bigday.b.aco().acp();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.giN != null) {
            this.giN.update();
        } else if (this.gcK != null && this.gcS != null) {
            showFloatingView();
            this.gcK.setSelection(0);
            if (!this.gcS.isRefreshing()) {
                if (this.giN != null && this.giN.bmT() != null) {
                    this.giN.bmT().bwz();
                    this.giN.lm(false);
                }
                this.gcS.setRefreshing(true);
            }
            if (this.gcR != null) {
                this.gcR.bvY();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fcS);
        MessageManager.getInstance().unRegisterListener(this.fvP);
        MessageManager.getInstance().unRegisterListener(this.gjb);
        this.giN.onDestroy();
        this.giL.b((NEGFeedBackView.a) null);
        this.giL.onDestroy();
        this.giN.a((e.a) null);
        if (this.giI != null) {
            this.giI.setListPullRefreshListener(null);
            this.giI.a((h.d) null);
            this.giI.a((h.a) null);
            this.giI.a((h.b) null);
            this.giI.release();
        }
        if (this.giJ != null) {
            this.giJ.setListPullRefreshListener(null);
            this.giJ.a((h.d) null);
            this.giJ.a((h.a) null);
            this.giJ.a((h.b) null);
            this.giJ.release();
        }
        this.gcK.setOnSrollToBottomListener(null);
        if (this.gcQ != null) {
            this.gcQ.b(this.gcR);
        }
        this.gcK.removeOnScrollListener(this.mOnScrollListener);
        if (this.djN != null) {
            this.djN.release();
        }
        this.gcK.setRecyclerListener(null);
        if (this.giO != null) {
            this.giO.onDestroy();
        }
        if (this.fwv != null) {
            this.fwv.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.aco().destroy();
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gja);
    }

    public void onPause() {
        this.giN.onPause();
        if (this.giL != null) {
            this.giL.onPause();
        }
    }

    public void onResume() {
        if (this.fvc) {
            reload();
            this.fvc = false;
        }
        if (this.gcS != null) {
            this.gcS.resume();
        }
        if (this.giL != null) {
            this.giL.onResume();
        }
    }

    public void bvf() {
        if (this.giL != null) {
            this.giL.notifyDataSetChanged();
        }
    }

    public void bvg() {
        if (this.giN != null) {
            this.giN.kc(true);
        }
        t.aZP().gS(false);
        com.baidu.tieba.a.d.aCH().bJ("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gja);
    }

    public void bwJ() {
        this.giN.bxb();
    }

    public void bwO() {
        this.giN.bwO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIS() {
        com.baidu.tieba.homepage.framework.a.bvC().n(System.currentTimeMillis(), 1);
        if (this.dnN != null && !this.dnN.pP()) {
            this.dnN.akF();
            this.dnN.iW(0);
        }
        this.giN.aIS();
    }
}
