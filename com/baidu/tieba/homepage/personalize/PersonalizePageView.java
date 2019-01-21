package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.e;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.FloatingAnimationView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes6.dex */
public class PersonalizePageView extends FrameLayout {
    private final CustomMessageListener aQB;
    private com.baidu.tbadk.k.f bLm;
    private PbListView bPn;
    private CustomMessageListener dMQ;
    private boolean dMi;
    private com.baidu.tieba.c.c dNq;
    private View.OnClickListener etM;
    private BdTypeRecyclerView evr;
    private BigdaySwipeRefreshLayout eye;
    private com.baidu.tieba.homepage.personalize.bigday.b eyf;
    private com.baidu.tieba.homepage.personalize.bigday.a eyg;
    private a eyh;
    private l eyi;
    private com.baidu.tieba.homepage.framework.b eyj;
    private e eyk;
    private com.baidu.tieba.homepage.personalize.a eyl;
    private com.baidu.tieba.homepage.personalize.model.e eyn;
    private long eyo;
    private FloatingAnimationView eyp;
    private boolean eyq;
    private int eyr;
    private NEGFeedBackView.a eys;
    private e.a eyt;
    j.b eyu;
    j.c eyv;
    j.a eyw;
    private Runnable eyx;
    public CustomMessageListener eyy;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes6.dex */
    public interface a {
        void a(j.a aVar);

        void a(j.b bVar);

        void a(j.c cVar);
    }

    static /* synthetic */ int l(PersonalizePageView personalizePageView) {
        int i = personalizePageView.eyr + 1;
        personalizePageView.eyr = i;
        return i;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.eyk != null) {
            this.eyk.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.eyl != null) {
            this.eyl.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.eye != null) {
            this.eye.pl();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eyi != null) {
            this.eyi.setPageUniqueId(bdUniqueId);
        }
        if (this.eyk != null) {
            this.eyk.j(bdUniqueId);
        }
        if (this.eyn != null) {
            this.eyn.m(bdUniqueId);
        }
        if (this.eyg != null) {
            this.eyg.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.yf().setTag(bdUniqueId);
        if (this.aQB != null) {
            this.aQB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aQB);
        }
        if (this.eyl != null) {
            this.eyl.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        m mVar = new m();
        mVar.vZ(String.valueOf(floatInfo.activity_id));
        mVar.dP(floatInfo.dynamic_url);
        mVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        mVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        mVar.vY(floatInfo.float_url);
        mVar.vX(floatInfo.jump_url);
        mVar.setType(floatInfo.show_type.intValue());
        return mVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.eyo = 0L;
        this.mSkinType = 3;
        this.dMi = false;
        this.eyq = false;
        this.eyr = 0;
        this.eys = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new am("c11693").aB("obj_locate", "1").aB(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aB("tid", ahVar.getTid()).aB("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").aB(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aB("tid", ahVar.getTid()).aB("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ah ahVar) {
                if (arrayList != null && ahVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        sb.append(arrayList.get(i)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new am("c11693").aB("obj_locate", sb.toString()).aB(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aB("tid", ahVar.getTid()).aB("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.eyt = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.eyj == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aLn = PersonalizePageView.this.aLn();
                PersonalizePageView.this.abx();
                if (aLn) {
                    PersonalizePageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                PersonalizePageView.this.eyj.G(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void s(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.eyj != null) {
                    PersonalizePageView.this.eyj.r(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.eye.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.eye.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.abx();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.eyk.aMA());
                PersonalizePageView.this.ct(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dNq != null) {
                    PersonalizePageView.this.dNq.a(a2);
                }
            }
        };
        this.eyu = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                com.baidu.tieba.a.d.Wk().ka("page_recommend");
                PersonalizePageView.this.eyk.update();
            }
        };
        this.eyv = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bJ(boolean z) {
                if (PersonalizePageView.this.eyk != null) {
                    if (PersonalizePageView.this.eyk.aCJ() != null) {
                        PersonalizePageView.this.eyk.aCJ().aNK();
                    }
                    PersonalizePageView.this.eyk.hV(false);
                }
            }
        };
        this.eyw = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.eyk != null) {
                    PersonalizePageView.this.eyk.hV(true);
                    PersonalizePageView.this.eyk.aMt();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.yf().cA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.eyx = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aQB = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aMo();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.etM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aaA();
            }
        };
        this.dMQ = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dMi = true;
                    }
                }
            }
        };
        this.eyy = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.eye != null && !PersonalizePageView.this.eye.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.eyg == null) {
                            PersonalizePageView.this.eyg = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.eyg.ey(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.eyh = PersonalizePageView.this.eyg;
                            PersonalizePageView.this.aMm();
                        } else if (PersonalizePageView.this.eyh != PersonalizePageView.this.eyg) {
                            PersonalizePageView.this.eyh = PersonalizePageView.this.eyg;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.eyg.setEnable(true);
                        PersonalizePageView.this.eye.setProgressView(PersonalizePageView.this.eyg);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.eye.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.eyf == null) {
                        PersonalizePageView.this.eyf = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.eyh = PersonalizePageView.this.eyf;
                        PersonalizePageView.this.aMm();
                    } else if (PersonalizePageView.this.eyh != PersonalizePageView.this.eyf || !aVar.equals(PersonalizePageView.this.eyf.aMK())) {
                        PersonalizePageView.this.eyh = PersonalizePageView.this.eyf;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.eyf.setEnable(true);
                    PersonalizePageView.this.eye.setProgressView(PersonalizePageView.this.eyf);
                    PersonalizePageView.this.eyf.a(aVar);
                    PersonalizePageView.this.eye.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0210e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eyo = 0L;
        this.mSkinType = 3;
        this.dMi = false;
        this.eyq = false;
        this.eyr = 0;
        this.eys = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new am("c11693").aB("obj_locate", "1").aB(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aB("tid", ahVar.getTid()).aB("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").aB(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aB("tid", ahVar.getTid()).aB("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ah ahVar) {
                if (arrayList != null && ahVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        sb.append(arrayList.get(i)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new am("c11693").aB("obj_locate", sb.toString()).aB(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aB("tid", ahVar.getTid()).aB("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.eyt = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.eyj == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aLn = PersonalizePageView.this.aLn();
                PersonalizePageView.this.abx();
                if (aLn) {
                    PersonalizePageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                PersonalizePageView.this.eyj.G(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void s(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.eyj != null) {
                    PersonalizePageView.this.eyj.r(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.eye.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.eye.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.abx();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.eyk.aMA());
                PersonalizePageView.this.ct(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dNq != null) {
                    PersonalizePageView.this.dNq.a(a2);
                }
            }
        };
        this.eyu = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                com.baidu.tieba.a.d.Wk().ka("page_recommend");
                PersonalizePageView.this.eyk.update();
            }
        };
        this.eyv = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bJ(boolean z) {
                if (PersonalizePageView.this.eyk != null) {
                    if (PersonalizePageView.this.eyk.aCJ() != null) {
                        PersonalizePageView.this.eyk.aCJ().aNK();
                    }
                    PersonalizePageView.this.eyk.hV(false);
                }
            }
        };
        this.eyw = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.eyk != null) {
                    PersonalizePageView.this.eyk.hV(true);
                    PersonalizePageView.this.eyk.aMt();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.yf().cA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.eyx = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aQB = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aMo();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.etM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aaA();
            }
        };
        this.dMQ = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dMi = true;
                    }
                }
            }
        };
        this.eyy = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.eye != null && !PersonalizePageView.this.eye.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.eyg == null) {
                            PersonalizePageView.this.eyg = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.eyg.ey(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.eyh = PersonalizePageView.this.eyg;
                            PersonalizePageView.this.aMm();
                        } else if (PersonalizePageView.this.eyh != PersonalizePageView.this.eyg) {
                            PersonalizePageView.this.eyh = PersonalizePageView.this.eyg;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.eyg.setEnable(true);
                        PersonalizePageView.this.eye.setProgressView(PersonalizePageView.this.eyg);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.eye.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.eyf == null) {
                        PersonalizePageView.this.eyf = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.eyh = PersonalizePageView.this.eyf;
                        PersonalizePageView.this.aMm();
                    } else if (PersonalizePageView.this.eyh != PersonalizePageView.this.eyf || !aVar.equals(PersonalizePageView.this.eyf.aMK())) {
                        PersonalizePageView.this.eyh = PersonalizePageView.this.eyf;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.eyf.setEnable(true);
                    PersonalizePageView.this.eye.setProgressView(PersonalizePageView.this.eyf);
                    PersonalizePageView.this.eyf.a(aVar);
                    PersonalizePageView.this.eye.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0210e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eyo = 0L;
        this.mSkinType = 3;
        this.dMi = false;
        this.eyq = false;
        this.eyr = 0;
        this.eys = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new am("c11693").aB("obj_locate", "1").aB(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aB("tid", ahVar.getTid()).aB("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").aB(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aB("tid", ahVar.getTid()).aB("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ah ahVar) {
                if (arrayList != null && ahVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new am("c11693").aB("obj_locate", sb.toString()).aB(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aB("tid", ahVar.getTid()).aB("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.eyt = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i2, int i22, int i3) {
                if (PersonalizePageView.this.eyj == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aLn = PersonalizePageView.this.aLn();
                PersonalizePageView.this.abx();
                if (aLn) {
                    PersonalizePageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                PersonalizePageView.this.eyj.G(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void s(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.eyj != null) {
                    PersonalizePageView.this.eyj.r(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.eye.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.eye.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.abx();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.eyk.aMA());
                PersonalizePageView.this.ct(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dNq != null) {
                    PersonalizePageView.this.dNq.a(a2);
                }
            }
        };
        this.eyu = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                com.baidu.tieba.a.d.Wk().ka("page_recommend");
                PersonalizePageView.this.eyk.update();
            }
        };
        this.eyv = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bJ(boolean z) {
                if (PersonalizePageView.this.eyk != null) {
                    if (PersonalizePageView.this.eyk.aCJ() != null) {
                        PersonalizePageView.this.eyk.aCJ().aNK();
                    }
                    PersonalizePageView.this.eyk.hV(false);
                }
            }
        };
        this.eyw = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.eyk != null) {
                    PersonalizePageView.this.eyk.hV(true);
                    PersonalizePageView.this.eyk.aMt();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.yf().cA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.eyx = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aQB = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aMo();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.etM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aaA();
            }
        };
        this.dMQ = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dMi = true;
                    }
                }
            }
        };
        this.eyy = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.eye != null && !PersonalizePageView.this.eye.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.eyg == null) {
                            PersonalizePageView.this.eyg = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.eyg.ey(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.eyh = PersonalizePageView.this.eyg;
                            PersonalizePageView.this.aMm();
                        } else if (PersonalizePageView.this.eyh != PersonalizePageView.this.eyg) {
                            PersonalizePageView.this.eyh = PersonalizePageView.this.eyg;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.eyg.setEnable(true);
                        PersonalizePageView.this.eye.setProgressView(PersonalizePageView.this.eyg);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.eye.setCustomDistances(i2, i2, i2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.eyf == null) {
                        PersonalizePageView.this.eyf = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.eyh = PersonalizePageView.this.eyf;
                        PersonalizePageView.this.aMm();
                    } else if (PersonalizePageView.this.eyh != PersonalizePageView.this.eyf || !aVar.equals(PersonalizePageView.this.eyf.aMK())) {
                        PersonalizePageView.this.eyh = PersonalizePageView.this.eyf;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.eyf.setEnable(true);
                    PersonalizePageView.this.eye.setProgressView(PersonalizePageView.this.eyf);
                    PersonalizePageView.this.eyf.a(aVar);
                    PersonalizePageView.this.eye.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0210e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.evr = new BdTypeRecyclerView(context);
        this.evr.setLayoutManager(new LinearLayoutManager(this.evr.getContext()));
        this.evr.setFadingEdgeLength(0);
        this.evr.setOverScrollMode(2);
        this.eye = new BigdaySwipeRefreshLayout(context);
        this.eye.addView(this.evr);
        this.bPn = new PbListView(context);
        this.bPn.getView();
        this.bPn.ex(e.d.cp_bg_line_e);
        this.bPn.Fm();
        this.bPn.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bPn.setTextSize(e.C0210e.tbfontsize33);
        this.bPn.ew(e.d.cp_cont_e);
        this.bPn.setHeight(com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds182));
        this.bPn.setOnClickListener(this.etM);
        this.evr.setNextPage(this.bPn);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        MessageManager.getInstance().registerListener(this.eyy);
        com.baidu.tbadk.core.bigday.b.yf().aY(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.yf().cA(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.eye);
        ((FrameLayout.LayoutParams) this.eye.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eyn = new com.baidu.tieba.homepage.personalize.model.e();
        this.eyi = new l(context, this.evr);
        this.eyi.b(this.eyn);
        this.eyk = new e(this.pageContext, this.evr, this.eyi, this.eye);
        this.eyl = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dMQ);
        this.eyr = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(Context context) {
        if (this.eyp == null) {
            this.eyp = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds200), com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds200);
            addView(this.eyp, layoutParams);
            this.eyp.setVisibility(8);
            this.eyp.setPageId(this.pageContext.getUniqueId());
            this.dNq = new com.baidu.tieba.c.c(this.pageContext, this.eyp, 1);
        }
    }

    public void aMm() {
        if (this.eyh != null) {
            this.eyh.a(this.eyu);
            this.eyh.a(this.eyv);
            this.eyh.a(this.eyw);
        }
    }

    public void aGi() {
        this.eyi.a(this.eys);
        this.eyk.a(this.eyt);
        this.eyl.a(this);
        aMm();
        this.evr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aaA();
            }
        });
        this.evr.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.eyo >= 5000) {
                    PersonalizePageView.this.eyk.ba(i, i2);
                }
            }
        }, 1L);
        this.evr.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.eyk != null && PersonalizePageView.this.eyk.aCJ() != null) {
                        PersonalizePageView.this.eyk.aCJ().bm(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).arr().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.eyj = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bPn != null) {
            this.bPn.Fq();
            this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eyk.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.eyk != null) {
            this.eyk.hS(!z);
        }
        this.eyq = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.eyq;
    }

    public void g(Long l) {
        this.eyk.g(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.eye != null && this.eye.getLayoutParams() != null) {
            if (this.eyk != null) {
                this.eyk.setHeaderViewHeight(i);
            }
            if (this.eyl != null) {
                this.eyl.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(v vVar) {
        if (this.eyk != null) {
            this.eyk.setRecommendFrsNavigationAnimDispatcher(vVar);
        }
    }

    public void showFloatingView() {
        if (this.eyk != null) {
            this.eyk.showFloatingView();
        }
    }

    public void aMn() {
        if (this.eyk != null) {
            this.eyk.aMn();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bLm != null) {
                this.bLm.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            al.j(this.eye, e.d.cp_bg_line_e);
            if (this.eyg != null) {
                this.eyg.ey(i);
            }
            if (this.bPn != null) {
                this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bPn.ey(i);
            }
            this.eyi.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void ah(String str, int i) {
        if (this.bPn != null) {
            this.bPn.Fq();
            this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eyk.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.eyk != null) {
                        PersonalizePageView.this.eyk.update();
                    }
                }
            });
        }
        this.refreshView.ge(getContext().getResources().getDimensionPixelSize(e.C0210e.ds280));
        this.refreshView.iC(str);
        this.refreshView.attachView(view, z);
        this.refreshView.Od();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abx() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.bLm != null) {
            this.bLm.dettachView(this);
            this.bLm = null;
            this.evr.setNextPage(this.bPn);
        }
        if (this.eye != null) {
            this.eye.setVisibility(0);
        }
        if (this.eyj != null) {
            this.eyj.aLP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aLn() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.bLm == null) {
            if (i < 0) {
                this.bLm = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.bLm = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.bLm.onChangeSkinType();
        }
        this.bLm.attachView(this, z);
        this.evr.setNextPage(null);
        if (this.eye != null) {
            this.eye.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.eyk != null) {
            this.eyk.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.dNq != null) {
            this.dNq.asu();
        }
        setViewForeground(false);
        if (this.eyk != null) {
            this.eyk.gJ(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.eyr < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.eyx, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.eyk != null) {
            this.eyk.hM(z);
        }
    }

    public void aLX() {
        if (this.eyk != null) {
            i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
            this.eyk.update();
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.yf().yh();
            com.baidu.tbadk.core.bigday.b.yf().yg();
        }
    }

    public void reload() {
        if (this.evr != null && this.eye != null) {
            showFloatingView();
            this.evr.setSelection(0);
            if (!this.eye.isRefreshing()) {
                if (this.eyk != null && this.eyk.aCJ() != null) {
                    this.eyk.aCJ().aNK();
                    this.eyk.hV(false);
                }
                this.eye.setRefreshing(true);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dMQ);
        MessageManager.getInstance().unRegisterListener(this.eyy);
        this.eyk.onDestroy();
        this.eyi.a((NEGFeedBackView.a) null);
        this.eyk.a((e.a) null);
        if (this.eyf != null) {
            this.eyf.a((j.b) null);
            this.eyf.a((j.c) null);
            this.eyf.a((j.a) null);
            this.eyf.release();
        }
        if (this.eyg != null) {
            this.eyg.a((j.b) null);
            this.eyg.a((j.c) null);
            this.eyg.a((j.a) null);
            this.eyg.release();
        }
        this.evr.setOnSrollToBottomListener(null);
        if (this.bLm != null) {
            this.bLm.release();
        }
        this.evr.setRecyclerListener(null);
        if (this.eyl != null) {
            this.eyl.onDestroy();
        }
        if (this.dNq != null) {
            this.dNq.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.yf().destroy();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eyx);
    }

    public void onPause() {
        this.eyk.onPause();
    }

    public void onResume() {
        if (this.dMi) {
            reload();
            this.dMi = false;
        }
        if (this.eye != null) {
            this.eye.resume();
        }
    }

    public void aMo() {
        if (this.eyi != null) {
            this.eyi.notifyDataSetChanged();
        }
    }

    public void aLp() {
        if (this.eyk != null) {
            this.eyk.gJ(true);
        }
        com.baidu.tieba.card.v.aqP().dT(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eyx);
    }

    public void aMj() {
        this.eyk.aMz();
    }

    public void aMp() {
        this.eyk.aMp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaA() {
        com.baidu.tieba.homepage.framework.a.aLO().k(System.currentTimeMillis(), 1);
        if (this.bPn != null && !this.bPn.Fv()) {
            this.bPn.Fp();
            this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eyk.aaA();
    }
}
