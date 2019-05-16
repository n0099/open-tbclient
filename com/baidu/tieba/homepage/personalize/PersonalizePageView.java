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
    private g dhX;
    private PbListView dlX;
    private int dno;
    private k eXo;
    private CustomMessageListener eXq;
    private BdTypeRecyclerView fWU;
    private ScrollFragmentTabHost fXa;
    ScrollFragmentTabHost.a fXb;
    private BigdaySwipeRefreshLayout fXc;
    private View.OnClickListener fXe;
    private boolean fpE;
    private com.baidu.tieba.c.c fqX;
    private CustomMessageListener fqr;
    private com.baidu.tieba.homepage.personalize.bigday.a gbA;
    private a gbB;
    private w gbC;
    private com.baidu.tieba.homepage.framework.b gbD;
    private e gbE;
    private com.baidu.tieba.homepage.personalize.a gbF;
    private com.baidu.tieba.homepage.personalize.model.e gbG;
    private long gbH;
    private FloatingAnimationView gbI;
    private boolean gbJ;
    private int gbK;
    private int gbL;
    private boolean gbM;
    private int gbN;
    private NEGFeedBackView.a gbO;
    private e.a gbP;
    h.c gbQ;
    h.d gbR;
    h.a gbS;
    h.b gbT;
    private Runnable gbU;
    public CustomMessageListener gbV;
    private com.baidu.tieba.homepage.personalize.bigday.b gbz;
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
        int i = personalizePageView.gbK + 1;
        personalizePageView.gbK = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fXa = scrollFragmentTabHost;
        if (this.fXa != null) {
            this.fXa.b(this.fXb);
            this.fXa.a(this.fXb);
        }
        if (this.gbE != null) {
            this.gbE.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gbF != null) {
            this.gbF.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.fXc != null) {
            this.fXc.oz();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gbC != null) {
            this.gbC.setPageUniqueId(bdUniqueId);
        }
        if (this.gbE != null) {
            this.gbE.k(bdUniqueId);
        }
        if (this.gbG != null) {
            this.gbG.o(bdUniqueId);
        }
        if (this.gbA != null) {
            this.gbA.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.abp().setTag(bdUniqueId);
        if (this.chc != null) {
            this.chc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.chc);
        }
        if (this.gbF != null) {
            this.gbF.setBdUniqueId(bdUniqueId);
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
        this.gbH = 0L;
        this.mSkinType = 3;
        this.fpE = false;
        this.gbJ = false;
        this.gbK = 0;
        this.gbL = 0;
        this.gbM = false;
        this.gbN = 1;
        this.eXq = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eXo == null) {
                            PersonalizePageView.this.eXo = new k(new i());
                        }
                        PersonalizePageView.this.eXo.a(PersonalizePageView.this.fWU, 2);
                    } else if (PersonalizePageView.this.eXo != null) {
                        PersonalizePageView.this.eXo.oa();
                    }
                }
            }
        };
        this.gbO = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.gbC != null) {
                        PersonalizePageView.this.gbC.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
                }
            }
        };
        this.dno = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dno != i && PersonalizePageView.this.fXa != null) {
                    PersonalizePageView.this.dno = i;
                    if (PersonalizePageView.this.dno == 1) {
                        PersonalizePageView.this.fXa.aHR();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fXa.aHS();
                    } else {
                        PersonalizePageView.this.fXa.aHR();
                    }
                }
            }
        };
        this.fXb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btE() {
                if (PersonalizePageView.this.fXa != null) {
                    PersonalizePageView.this.dno = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fWU)) {
                        PersonalizePageView.this.fXa.aHS();
                    } else {
                        PersonalizePageView.this.fXa.aHR();
                    }
                }
            }
        };
        this.gbP = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean few = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_first_install", true);

            private void btS() {
                if (this.few) {
                    this.few = false;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void L(int i, int i2, int i3) {
                if (PersonalizePageView.this.gbD == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean beD = PersonalizePageView.this.beD();
                PersonalizePageView.this.aHH();
                if (beD) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gbD.K(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gbD != null) {
                    PersonalizePageView.this.gbD.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.jS()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    btS();
                } else if (!this.few) {
                    PersonalizePageView.this.fXc.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    btS();
                    PersonalizePageView.this.btt();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                btS();
                PersonalizePageView.this.fXc.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aHH();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gbE.buf());
                PersonalizePageView.this.dE(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fqX != null) {
                    PersonalizePageView.this.fqX.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void btT() {
                if (PersonalizePageView.this.dlX != null) {
                    PersonalizePageView.this.dlX.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dlX.ajz();
                }
            }
        };
        this.gbQ = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                com.baidu.tieba.a.d.aBn().rU("page_recommend");
                PersonalizePageView.this.gbE.update();
                PersonalizePageView.this.gbE.lf(false);
                PersonalizePageView.this.gbM = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gbR = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void eo(boolean z) {
                if (PersonalizePageView.this.gbE != null && PersonalizePageView.this.gbE.bkE() != null) {
                    PersonalizePageView.this.gbE.bkE().bvO();
                }
            }
        };
        this.gbS = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void ajP() {
                if (PersonalizePageView.this.gbM) {
                    PersonalizePageView.this.gbL = 0;
                    PersonalizePageView.this.gbN = 1;
                    PersonalizePageView.this.gbM = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gbT = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.gbE != null) {
                    PersonalizePageView.this.gbE.lf(true);
                    PersonalizePageView.this.gbE.btY();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.abp().gN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gbU = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
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
                                PersonalizePageView.this.bsM();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fXe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aHq();
            }
        };
        this.fqr = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fpE = true;
                    }
                }
            }
        };
        this.gbV = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fXc != null && !PersonalizePageView.this.fXc.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gbA == null) {
                            PersonalizePageView.this.gbA = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gbA.iP(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gbB = PersonalizePageView.this.gbA;
                            PersonalizePageView.this.btP();
                        } else if (PersonalizePageView.this.gbB != PersonalizePageView.this.gbA) {
                            PersonalizePageView.this.gbB = PersonalizePageView.this.gbA;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gbA.setEnable(true);
                        PersonalizePageView.this.fXc.setProgressView(PersonalizePageView.this.gbA);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fXc.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gbz == null) {
                        PersonalizePageView.this.gbz = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gbB = PersonalizePageView.this.gbz;
                        PersonalizePageView.this.btP();
                    } else if (PersonalizePageView.this.gbB != PersonalizePageView.this.gbz || !aVar.equals(PersonalizePageView.this.gbz.bus())) {
                        PersonalizePageView.this.gbB = PersonalizePageView.this.gbz;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gbz.setEnable(true);
                    PersonalizePageView.this.fXc.setProgressView(PersonalizePageView.this.gbz);
                    PersonalizePageView.this.gbz.a(aVar);
                    PersonalizePageView.this.fXc.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbH = 0L;
        this.mSkinType = 3;
        this.fpE = false;
        this.gbJ = false;
        this.gbK = 0;
        this.gbL = 0;
        this.gbM = false;
        this.gbN = 1;
        this.eXq = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eXo == null) {
                            PersonalizePageView.this.eXo = new k(new i());
                        }
                        PersonalizePageView.this.eXo.a(PersonalizePageView.this.fWU, 2);
                    } else if (PersonalizePageView.this.eXo != null) {
                        PersonalizePageView.this.eXo.oa();
                    }
                }
            }
        };
        this.gbO = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.gbC != null) {
                        PersonalizePageView.this.gbC.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i));
                }
            }
        };
        this.dno = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dno != i && PersonalizePageView.this.fXa != null) {
                    PersonalizePageView.this.dno = i;
                    if (PersonalizePageView.this.dno == 1) {
                        PersonalizePageView.this.fXa.aHR();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fXa.aHS();
                    } else {
                        PersonalizePageView.this.fXa.aHR();
                    }
                }
            }
        };
        this.fXb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btE() {
                if (PersonalizePageView.this.fXa != null) {
                    PersonalizePageView.this.dno = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fWU)) {
                        PersonalizePageView.this.fXa.aHS();
                    } else {
                        PersonalizePageView.this.fXa.aHR();
                    }
                }
            }
        };
        this.gbP = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean few = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_first_install", true);

            private void btS() {
                if (this.few) {
                    this.few = false;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void L(int i, int i2, int i3) {
                if (PersonalizePageView.this.gbD == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean beD = PersonalizePageView.this.beD();
                PersonalizePageView.this.aHH();
                if (beD) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gbD.K(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gbD != null) {
                    PersonalizePageView.this.gbD.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.jS()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    btS();
                } else if (!this.few) {
                    PersonalizePageView.this.fXc.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    btS();
                    PersonalizePageView.this.btt();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                btS();
                PersonalizePageView.this.fXc.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aHH();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gbE.buf());
                PersonalizePageView.this.dE(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fqX != null) {
                    PersonalizePageView.this.fqX.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void btT() {
                if (PersonalizePageView.this.dlX != null) {
                    PersonalizePageView.this.dlX.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dlX.ajz();
                }
            }
        };
        this.gbQ = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                com.baidu.tieba.a.d.aBn().rU("page_recommend");
                PersonalizePageView.this.gbE.update();
                PersonalizePageView.this.gbE.lf(false);
                PersonalizePageView.this.gbM = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gbR = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void eo(boolean z) {
                if (PersonalizePageView.this.gbE != null && PersonalizePageView.this.gbE.bkE() != null) {
                    PersonalizePageView.this.gbE.bkE().bvO();
                }
            }
        };
        this.gbS = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void ajP() {
                if (PersonalizePageView.this.gbM) {
                    PersonalizePageView.this.gbL = 0;
                    PersonalizePageView.this.gbN = 1;
                    PersonalizePageView.this.gbM = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gbT = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.gbE != null) {
                    PersonalizePageView.this.gbE.lf(true);
                    PersonalizePageView.this.gbE.btY();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.abp().gN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gbU = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
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
                                PersonalizePageView.this.bsM();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fXe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aHq();
            }
        };
        this.fqr = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fpE = true;
                    }
                }
            }
        };
        this.gbV = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fXc != null && !PersonalizePageView.this.fXc.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gbA == null) {
                            PersonalizePageView.this.gbA = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gbA.iP(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gbB = PersonalizePageView.this.gbA;
                            PersonalizePageView.this.btP();
                        } else if (PersonalizePageView.this.gbB != PersonalizePageView.this.gbA) {
                            PersonalizePageView.this.gbB = PersonalizePageView.this.gbA;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gbA.setEnable(true);
                        PersonalizePageView.this.fXc.setProgressView(PersonalizePageView.this.gbA);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fXc.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gbz == null) {
                        PersonalizePageView.this.gbz = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gbB = PersonalizePageView.this.gbz;
                        PersonalizePageView.this.btP();
                    } else if (PersonalizePageView.this.gbB != PersonalizePageView.this.gbz || !aVar.equals(PersonalizePageView.this.gbz.bus())) {
                        PersonalizePageView.this.gbB = PersonalizePageView.this.gbz;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gbz.setEnable(true);
                    PersonalizePageView.this.fXc.setProgressView(PersonalizePageView.this.gbz);
                    PersonalizePageView.this.gbz.a(aVar);
                    PersonalizePageView.this.fXc.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbH = 0L;
        this.mSkinType = 3;
        this.fpE = false;
        this.gbJ = false;
        this.gbK = 0;
        this.gbL = 0;
        this.gbM = false;
        this.gbN = 1;
        this.eXq = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.eXo == null) {
                            PersonalizePageView.this.eXo = new k(new i());
                        }
                        PersonalizePageView.this.eXo.a(PersonalizePageView.this.fWU, 2);
                    } else if (PersonalizePageView.this.eXo != null) {
                        PersonalizePageView.this.eXo.oa();
                    }
                }
            }
        };
        this.gbO = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.gbC != null) {
                        PersonalizePageView.this.gbC.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new am("c11693").bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", ajVar.getFid()).bT("obj_param1", ajVar.weight).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ajVar.source).bT(VideoPlayActivityConfig.OBJ_ID, ajVar.extra).bT("obj_type", sb.toString()).bT("obj_name", str).P("obj_param2", i2));
                }
            }
        };
        this.dno = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.dno != i2 && PersonalizePageView.this.fXa != null) {
                    PersonalizePageView.this.dno = i2;
                    if (PersonalizePageView.this.dno == 1) {
                        PersonalizePageView.this.fXa.aHR();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.fXa.aHS();
                    } else {
                        PersonalizePageView.this.fXa.aHR();
                    }
                }
            }
        };
        this.fXb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btE() {
                if (PersonalizePageView.this.fXa != null) {
                    PersonalizePageView.this.dno = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.fWU)) {
                        PersonalizePageView.this.fXa.aHS();
                    } else {
                        PersonalizePageView.this.fXa.aHR();
                    }
                }
            }
        };
        this.gbP = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean few = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_first_install", true);

            private void btS() {
                if (this.few) {
                    this.few = false;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void L(int i2, int i22, int i3) {
                if (PersonalizePageView.this.gbD == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean beD = PersonalizePageView.this.beD();
                PersonalizePageView.this.aHH();
                if (beD) {
                    PersonalizePageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gbD.K(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.gbD != null) {
                    PersonalizePageView.this.gbD.u(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.jS()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    btS();
                } else if (!this.few) {
                    PersonalizePageView.this.fXc.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    btS();
                    PersonalizePageView.this.btt();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                btS();
                PersonalizePageView.this.fXc.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aHH();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gbE.buf());
                PersonalizePageView.this.dE(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fqX != null) {
                    PersonalizePageView.this.fqX.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void btT() {
                if (PersonalizePageView.this.dlX != null) {
                    PersonalizePageView.this.dlX.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dlX.ajz();
                }
            }
        };
        this.gbQ = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                com.baidu.tieba.a.d.aBn().rU("page_recommend");
                PersonalizePageView.this.gbE.update();
                PersonalizePageView.this.gbE.lf(false);
                PersonalizePageView.this.gbM = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gbR = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void eo(boolean z) {
                if (PersonalizePageView.this.gbE != null && PersonalizePageView.this.gbE.bkE() != null) {
                    PersonalizePageView.this.gbE.bkE().bvO();
                }
            }
        };
        this.gbS = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void ajP() {
                if (PersonalizePageView.this.gbM) {
                    PersonalizePageView.this.gbL = 0;
                    PersonalizePageView.this.gbN = 1;
                    PersonalizePageView.this.gbM = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gbT = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (PersonalizePageView.this.gbE != null) {
                    PersonalizePageView.this.gbE.lf(true);
                    PersonalizePageView.this.gbE.btY();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.abp().gN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gbU = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
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
                                PersonalizePageView.this.bsM();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.fXe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aHq();
            }
        };
        this.fqr = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fpE = true;
                    }
                }
            }
        };
        this.gbV = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.fXc != null && !PersonalizePageView.this.fXc.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gbA == null) {
                            PersonalizePageView.this.gbA = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gbA.iP(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gbB = PersonalizePageView.this.gbA;
                            PersonalizePageView.this.btP();
                        } else if (PersonalizePageView.this.gbB != PersonalizePageView.this.gbA) {
                            PersonalizePageView.this.gbB = PersonalizePageView.this.gbA;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gbA.setEnable(true);
                        PersonalizePageView.this.fXc.setProgressView(PersonalizePageView.this.gbA);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.fXc.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gbz == null) {
                        PersonalizePageView.this.gbz = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gbB = PersonalizePageView.this.gbz;
                        PersonalizePageView.this.btP();
                    } else if (PersonalizePageView.this.gbB != PersonalizePageView.this.gbz || !aVar.equals(PersonalizePageView.this.gbz.bus())) {
                        PersonalizePageView.this.gbB = PersonalizePageView.this.gbz;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gbz.setEnable(true);
                    PersonalizePageView.this.fXc.setProgressView(PersonalizePageView.this.gbz);
                    PersonalizePageView.this.gbz.a(aVar);
                    PersonalizePageView.this.fXc.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.ah(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.ah(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fWU = new BdTypeRecyclerView(context);
        this.boW = new LinearLayoutManager(this.fWU.getContext());
        this.fWU.setLayoutManager(this.boW);
        this.fWU.setFadingEdgeLength(0);
        this.fWU.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.eXo = new k(new i());
            this.eXo.a(this.fWU, 2);
        }
        MessageManager.getInstance().registerListener(this.eXq);
        this.fXc = new BigdaySwipeRefreshLayout(context);
        this.fXc.addView(this.fWU);
        this.dlX = new PbListView(context);
        this.dlX.getView();
        this.dlX.iO(R.color.cp_bg_line_e);
        this.dlX.ajv();
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlX.setTextSize(R.dimen.tbfontsize33);
        this.dlX.iN(R.color.cp_cont_e);
        this.dlX.setHeight(l.g(context, R.dimen.tbds182));
        this.dlX.setOnClickListener(this.fXe);
        this.dlX.ajC();
        this.fWU.setNextPage(this.dlX);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.gbV);
        com.baidu.tbadk.core.bigday.b.abp().dC(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.abp().gN(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.fXc);
        ((FrameLayout.LayoutParams) this.fXc.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.gbG = new com.baidu.tieba.homepage.personalize.model.e();
        this.gbC = new w(context, this.fWU);
        this.gbC.b(this.gbG);
        this.gbE = new e(this.pageContext, this.fWU, this.gbC, this.fXc);
        this.gbF = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.fqr);
        this.gbK = com.baidu.tbadk.core.sharedPref.b.agM().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(Context context) {
        if (this.gbI == null) {
            this.gbI = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds200), l.g(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.g(context, R.dimen.tbds200);
            addView(this.gbI, layoutParams);
            this.gbI.setVisibility(8);
            this.gbI.setPageId(this.pageContext.getUniqueId());
            this.fqX = new com.baidu.tieba.c.c(this.pageContext, this.gbI, 1);
        }
    }

    public void btP() {
        if (this.gbB != null) {
            this.gbB.setListPullRefreshListener(this.gbQ);
            this.gbB.a(this.gbR);
            this.gbB.a(this.gbS);
            this.gbB.a(this.gbT);
        }
    }

    public void bnP() {
        this.gbC.b(this.gbO);
        this.gbE.a(this.gbP);
        this.gbF.a(this);
        btP();
        this.fWU.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                PersonalizePageView.this.gbL += i2;
                if (PersonalizePageView.this.gbL < height * 3 || PersonalizePageView.this.gbN != 1) {
                    if (PersonalizePageView.this.gbL < height * 3 && PersonalizePageView.this.gbN == 2) {
                        PersonalizePageView.this.gbN = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        return;
                    }
                    return;
                }
                PersonalizePageView.this.gbN = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.gbN)));
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.boW != null && i == 0 && PersonalizePageView.this.boW.getItemCount() - PersonalizePageView.this.boW.findLastVisibleItemPosition() <= 3) {
                    PersonalizePageView.this.aHq();
                }
            }
        });
        this.fWU.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aHq();
            }
        });
        this.fWU.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.gbH >= 5000) {
                    PersonalizePageView.this.gbE.bC(i, i2);
                }
            }
        }, 1L);
        this.fWU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.gbE != null && PersonalizePageView.this.gbE.bkE() != null) {
                        PersonalizePageView.this.gbE.bkE().cj(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).aYp().stopPlay();
                    }
                }
            }
        });
        this.fWU.removeOnScrollListener(this.mOnScrollListener);
        this.fWU.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gbD = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.dlX != null) {
            this.dlX.setText(getContext().getString(R.string.pb_load_more));
            this.dlX.ajz();
        }
        this.gbE.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.gbE != null) {
            this.gbE.lc(!z);
        }
        this.gbJ = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.gbJ;
    }

    public void d(Long l) {
        this.gbE.d(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.gbE != null) {
            this.gbE.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void showFloatingView() {
        if (this.gbE != null) {
            this.gbE.showFloatingView();
        }
    }

    public void btQ() {
        if (this.gbE != null) {
            this.gbE.btQ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dhX != null) {
                this.dhX.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            al.l(this.fXc, R.color.cp_bg_line_e);
            if (this.gbA != null) {
                this.gbA.iP(i);
            }
            if (this.dlX != null) {
                this.dlX.setTextColor(al.getColor(R.color.cp_cont_d));
                this.dlX.iP(i);
            }
            this.gbC.onChangeSkinType(i);
            if (this.gbE != null) {
                this.gbE.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void ay(String str, int i) {
        if (this.dlX != null) {
            this.dlX.setText(getContext().getString(R.string.pb_load_more));
            this.dlX.ajz();
        }
        this.gbE.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.gbE != null) {
                        PersonalizePageView.this.gbE.update();
                    }
                }
            });
        }
        this.refreshView.qx(str);
        this.refreshView.attachView(view, z);
        this.refreshView.asB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHH() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.dhX != null) {
            this.dhX.dettachView(this);
            this.dhX = null;
            this.fWU.setNextPage(this.dlX);
            this.dlX.setText(getContext().getString(R.string.pb_load_more));
            this.dlX.ajz();
        }
        if (this.fXc != null) {
            this.fXc.setVisibility(0);
        }
        if (this.gbD != null) {
            this.gbD.btk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean beD() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.dhX == null) {
            if (i < 0) {
                this.dhX = new g(getContext());
            } else {
                this.dhX = new g(getContext(), i);
            }
            this.dhX.onChangeSkinType();
        }
        this.dhX.attachView(this, z);
        this.fWU.setNextPage(null);
        if (this.fXc != null) {
            this.fXc.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.gbE != null) {
            this.gbE.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.fqX != null) {
            this.fqX.aFr();
        }
        setViewForeground(false);
        if (this.gbE != null) {
            this.gbE.jS(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.gbK < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.gbU, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gbE != null) {
            this.gbE.kV(z);
        }
        if (this.fXa != null) {
            this.fXa.b(this.fXb);
            this.fXa.a(this.fXb);
            this.fXb.btE();
        }
    }

    public void btt() {
        if (this.gbE != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.gbE.update();
        }
        if (com.baidu.adp.lib.b.d.hI().ay("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.abp().abr();
            com.baidu.tbadk.core.bigday.b.abp().abq();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.gbE != null) {
            this.gbE.update();
        } else if (this.fWU != null && this.fXc != null) {
            showFloatingView();
            this.fWU.setSelection(0);
            if (!this.fXc.isRefreshing()) {
                if (this.gbE != null && this.gbE.bkE() != null) {
                    this.gbE.bkE().bvO();
                    this.gbE.lf(false);
                }
                this.fXc.setRefreshing(true);
            }
            if (this.fXb != null) {
                this.fXb.btE();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eXq);
        MessageManager.getInstance().unRegisterListener(this.fqr);
        MessageManager.getInstance().unRegisterListener(this.gbV);
        this.gbE.onDestroy();
        this.gbC.b((NEGFeedBackView.a) null);
        this.gbC.onDestroy();
        this.gbE.a((e.a) null);
        if (this.gbz != null) {
            this.gbz.setListPullRefreshListener(null);
            this.gbz.a((h.d) null);
            this.gbz.a((h.a) null);
            this.gbz.a((h.b) null);
            this.gbz.release();
        }
        if (this.gbA != null) {
            this.gbA.setListPullRefreshListener(null);
            this.gbA.a((h.d) null);
            this.gbA.a((h.a) null);
            this.gbA.a((h.b) null);
            this.gbA.release();
        }
        this.fWU.setOnSrollToBottomListener(null);
        if (this.fXa != null) {
            this.fXa.b(this.fXb);
        }
        this.fWU.removeOnScrollListener(this.mOnScrollListener);
        if (this.dhX != null) {
            this.dhX.release();
        }
        this.fWU.setRecyclerListener(null);
        if (this.gbF != null) {
            this.gbF.onDestroy();
        }
        if (this.fqX != null) {
            this.fqX.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.abp().destroy();
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gbU);
    }

    public void onPause() {
        this.gbE.onPause();
        if (this.gbC != null) {
            this.gbC.onPause();
        }
    }

    public void onResume() {
        if (this.fpE) {
            reload();
            this.fpE = false;
        }
        if (this.fXc != null) {
            this.fXc.resume();
        }
        if (this.gbC != null) {
            this.gbC.onResume();
        }
    }

    public void bsM() {
        if (this.gbC != null) {
            this.gbC.notifyDataSetChanged();
        }
    }

    public void bsN() {
        if (this.gbE != null) {
            this.gbE.jS(true);
        }
        t.aXM().gM(false);
        com.baidu.tieba.a.d.aBn().bJ("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gbU);
    }

    public void btM() {
        this.gbE.bue();
    }

    public void btR() {
        this.gbE.btR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHq() {
        com.baidu.tieba.homepage.framework.a.btj().n(System.currentTimeMillis(), 1);
        if (this.dlX != null && !this.dlX.pu()) {
            this.dlX.ajy();
            this.dlX.iQ(0);
        }
        this.gbE.aHq();
    }
}
