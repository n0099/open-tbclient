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
    private final CustomMessageListener aQA;
    private com.baidu.tbadk.k.f bLl;
    private PbListView bPm;
    private CustomMessageListener dMP;
    private boolean dMh;
    private com.baidu.tieba.c.c dNp;
    private View.OnClickListener etL;
    private BdTypeRecyclerView evq;
    private BigdaySwipeRefreshLayout eyd;
    private com.baidu.tieba.homepage.personalize.bigday.b eye;
    private com.baidu.tieba.homepage.personalize.bigday.a eyf;
    private a eyg;
    private l eyh;
    private com.baidu.tieba.homepage.framework.b eyi;
    private e eyj;
    private com.baidu.tieba.homepage.personalize.a eyk;
    private com.baidu.tieba.homepage.personalize.model.e eyl;
    private long eyn;
    private FloatingAnimationView eyo;
    private boolean eyp;
    private int eyq;
    private NEGFeedBackView.a eyr;
    private e.a eys;
    j.b eyt;
    j.c eyu;
    j.a eyv;
    private Runnable eyw;
    public CustomMessageListener eyx;
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
        int i = personalizePageView.eyq + 1;
        personalizePageView.eyq = i;
        return i;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.eyj != null) {
            this.eyj.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.eyk != null) {
            this.eyk.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.eyd != null) {
            this.eyd.pl();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eyh != null) {
            this.eyh.setPageUniqueId(bdUniqueId);
        }
        if (this.eyj != null) {
            this.eyj.j(bdUniqueId);
        }
        if (this.eyl != null) {
            this.eyl.m(bdUniqueId);
        }
        if (this.eyf != null) {
            this.eyf.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.yf().setTag(bdUniqueId);
        if (this.aQA != null) {
            this.aQA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aQA);
        }
        if (this.eyk != null) {
            this.eyk.setBdUniqueId(bdUniqueId);
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
        this.eyn = 0L;
        this.mSkinType = 3;
        this.dMh = false;
        this.eyp = false;
        this.eyq = 0;
        this.eyr = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.eys = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.eyi == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aLn = PersonalizePageView.this.aLn();
                PersonalizePageView.this.abx();
                if (aLn) {
                    PersonalizePageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                PersonalizePageView.this.eyi.G(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void s(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.eyi != null) {
                    PersonalizePageView.this.eyi.r(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.eyd.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.eyd.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.abx();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.eyj.aMA());
                PersonalizePageView.this.ct(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dNp != null) {
                    PersonalizePageView.this.dNp.a(a2);
                }
            }
        };
        this.eyt = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                com.baidu.tieba.a.d.Wk().ka("page_recommend");
                PersonalizePageView.this.eyj.update();
            }
        };
        this.eyu = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bJ(boolean z) {
                if (PersonalizePageView.this.eyj != null) {
                    if (PersonalizePageView.this.eyj.aCJ() != null) {
                        PersonalizePageView.this.eyj.aCJ().aNK();
                    }
                    PersonalizePageView.this.eyj.hV(false);
                }
            }
        };
        this.eyv = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.eyj != null) {
                    PersonalizePageView.this.eyj.hV(true);
                    PersonalizePageView.this.eyj.aMt();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.yf().cA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.eyw = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aQA = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
        this.etL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aaA();
            }
        };
        this.dMP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dMh = true;
                    }
                }
            }
        };
        this.eyx = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.eyd != null && !PersonalizePageView.this.eyd.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.eyf == null) {
                            PersonalizePageView.this.eyf = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.eyf.ey(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.eyg = PersonalizePageView.this.eyf;
                            PersonalizePageView.this.aMm();
                        } else if (PersonalizePageView.this.eyg != PersonalizePageView.this.eyf) {
                            PersonalizePageView.this.eyg = PersonalizePageView.this.eyf;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.eyf.setEnable(true);
                        PersonalizePageView.this.eyd.setProgressView(PersonalizePageView.this.eyf);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.eyd.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.eye == null) {
                        PersonalizePageView.this.eye = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.eyg = PersonalizePageView.this.eye;
                        PersonalizePageView.this.aMm();
                    } else if (PersonalizePageView.this.eyg != PersonalizePageView.this.eye || !aVar.equals(PersonalizePageView.this.eye.aMK())) {
                        PersonalizePageView.this.eyg = PersonalizePageView.this.eye;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.eye.setEnable(true);
                    PersonalizePageView.this.eyd.setProgressView(PersonalizePageView.this.eye);
                    PersonalizePageView.this.eye.a(aVar);
                    PersonalizePageView.this.eyd.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0210e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eyn = 0L;
        this.mSkinType = 3;
        this.dMh = false;
        this.eyp = false;
        this.eyq = 0;
        this.eyr = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.eys = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.eyi == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aLn = PersonalizePageView.this.aLn();
                PersonalizePageView.this.abx();
                if (aLn) {
                    PersonalizePageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                PersonalizePageView.this.eyi.G(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void s(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.eyi != null) {
                    PersonalizePageView.this.eyi.r(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.eyd.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.eyd.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.abx();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.eyj.aMA());
                PersonalizePageView.this.ct(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dNp != null) {
                    PersonalizePageView.this.dNp.a(a2);
                }
            }
        };
        this.eyt = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                com.baidu.tieba.a.d.Wk().ka("page_recommend");
                PersonalizePageView.this.eyj.update();
            }
        };
        this.eyu = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bJ(boolean z) {
                if (PersonalizePageView.this.eyj != null) {
                    if (PersonalizePageView.this.eyj.aCJ() != null) {
                        PersonalizePageView.this.eyj.aCJ().aNK();
                    }
                    PersonalizePageView.this.eyj.hV(false);
                }
            }
        };
        this.eyv = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.eyj != null) {
                    PersonalizePageView.this.eyj.hV(true);
                    PersonalizePageView.this.eyj.aMt();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.yf().cA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.eyw = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aQA = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
        this.etL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aaA();
            }
        };
        this.dMP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dMh = true;
                    }
                }
            }
        };
        this.eyx = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.eyd != null && !PersonalizePageView.this.eyd.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.eyf == null) {
                            PersonalizePageView.this.eyf = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.eyf.ey(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.eyg = PersonalizePageView.this.eyf;
                            PersonalizePageView.this.aMm();
                        } else if (PersonalizePageView.this.eyg != PersonalizePageView.this.eyf) {
                            PersonalizePageView.this.eyg = PersonalizePageView.this.eyf;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.eyf.setEnable(true);
                        PersonalizePageView.this.eyd.setProgressView(PersonalizePageView.this.eyf);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.eyd.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.eye == null) {
                        PersonalizePageView.this.eye = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.eyg = PersonalizePageView.this.eye;
                        PersonalizePageView.this.aMm();
                    } else if (PersonalizePageView.this.eyg != PersonalizePageView.this.eye || !aVar.equals(PersonalizePageView.this.eye.aMK())) {
                        PersonalizePageView.this.eyg = PersonalizePageView.this.eye;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.eye.setEnable(true);
                    PersonalizePageView.this.eyd.setProgressView(PersonalizePageView.this.eye);
                    PersonalizePageView.this.eye.a(aVar);
                    PersonalizePageView.this.eyd.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0210e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eyn = 0L;
        this.mSkinType = 3;
        this.dMh = false;
        this.eyp = false;
        this.eyq = 0;
        this.eyr = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.eys = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i2, int i22, int i3) {
                if (PersonalizePageView.this.eyi == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aLn = PersonalizePageView.this.aLn();
                PersonalizePageView.this.abx();
                if (aLn) {
                    PersonalizePageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                PersonalizePageView.this.eyi.G(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void s(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.eyi != null) {
                    PersonalizePageView.this.eyi.r(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.eyd.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.eyd.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.abx();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.eyj.aMA());
                PersonalizePageView.this.ct(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dNp != null) {
                    PersonalizePageView.this.dNp.a(a2);
                }
            }
        };
        this.eyt = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                com.baidu.tieba.a.d.Wk().ka("page_recommend");
                PersonalizePageView.this.eyj.update();
            }
        };
        this.eyu = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bJ(boolean z) {
                if (PersonalizePageView.this.eyj != null) {
                    if (PersonalizePageView.this.eyj.aCJ() != null) {
                        PersonalizePageView.this.eyj.aCJ().aNK();
                    }
                    PersonalizePageView.this.eyj.hV(false);
                }
            }
        };
        this.eyv = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.eyj != null) {
                    PersonalizePageView.this.eyj.hV(true);
                    PersonalizePageView.this.eyj.aMt();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.yf().cA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.eyw = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aQA = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
        this.etL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aaA();
            }
        };
        this.dMP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dMh = true;
                    }
                }
            }
        };
        this.eyx = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.eyd != null && !PersonalizePageView.this.eyd.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.eyf == null) {
                            PersonalizePageView.this.eyf = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.eyf.ey(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.eyg = PersonalizePageView.this.eyf;
                            PersonalizePageView.this.aMm();
                        } else if (PersonalizePageView.this.eyg != PersonalizePageView.this.eyf) {
                            PersonalizePageView.this.eyg = PersonalizePageView.this.eyf;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.eyf.setEnable(true);
                        PersonalizePageView.this.eyd.setProgressView(PersonalizePageView.this.eyf);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.eyd.setCustomDistances(i2, i2, i2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.eye == null) {
                        PersonalizePageView.this.eye = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.eyg = PersonalizePageView.this.eye;
                        PersonalizePageView.this.aMm();
                    } else if (PersonalizePageView.this.eyg != PersonalizePageView.this.eye || !aVar.equals(PersonalizePageView.this.eye.aMK())) {
                        PersonalizePageView.this.eyg = PersonalizePageView.this.eye;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.eye.setEnable(true);
                    PersonalizePageView.this.eyd.setProgressView(PersonalizePageView.this.eye);
                    PersonalizePageView.this.eye.a(aVar);
                    PersonalizePageView.this.eyd.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0210e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.evq = new BdTypeRecyclerView(context);
        this.evq.setLayoutManager(new LinearLayoutManager(this.evq.getContext()));
        this.evq.setFadingEdgeLength(0);
        this.evq.setOverScrollMode(2);
        this.eyd = new BigdaySwipeRefreshLayout(context);
        this.eyd.addView(this.evq);
        this.bPm = new PbListView(context);
        this.bPm.getView();
        this.bPm.ex(e.d.cp_bg_line_e);
        this.bPm.Fm();
        this.bPm.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bPm.setTextSize(e.C0210e.tbfontsize33);
        this.bPm.ew(e.d.cp_cont_e);
        this.bPm.setHeight(com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds182));
        this.bPm.setOnClickListener(this.etL);
        this.evq.setNextPage(this.bPm);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        MessageManager.getInstance().registerListener(this.eyx);
        com.baidu.tbadk.core.bigday.b.yf().aY(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.yf().cA(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.eyd);
        ((FrameLayout.LayoutParams) this.eyd.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eyl = new com.baidu.tieba.homepage.personalize.model.e();
        this.eyh = new l(context, this.evq);
        this.eyh.b(this.eyl);
        this.eyj = new e(this.pageContext, this.evq, this.eyh, this.eyd);
        this.eyk = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dMP);
        this.eyq = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(Context context) {
        if (this.eyo == null) {
            this.eyo = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds200), com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds200);
            addView(this.eyo, layoutParams);
            this.eyo.setVisibility(8);
            this.eyo.setPageId(this.pageContext.getUniqueId());
            this.dNp = new com.baidu.tieba.c.c(this.pageContext, this.eyo, 1);
        }
    }

    public void aMm() {
        if (this.eyg != null) {
            this.eyg.a(this.eyt);
            this.eyg.a(this.eyu);
            this.eyg.a(this.eyv);
        }
    }

    public void aGi() {
        this.eyh.a(this.eyr);
        this.eyj.a(this.eys);
        this.eyk.a(this);
        aMm();
        this.evq.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aaA();
            }
        });
        this.evq.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.eyn >= 5000) {
                    PersonalizePageView.this.eyj.ba(i, i2);
                }
            }
        }, 1L);
        this.evq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.eyj != null && PersonalizePageView.this.eyj.aCJ() != null) {
                        PersonalizePageView.this.eyj.aCJ().bm(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).arr().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.eyi = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bPm != null) {
            this.bPm.Fq();
            this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eyj.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.eyj != null) {
            this.eyj.hS(!z);
        }
        this.eyp = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.eyp;
    }

    public void g(Long l) {
        this.eyj.g(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.eyd != null && this.eyd.getLayoutParams() != null) {
            if (this.eyj != null) {
                this.eyj.setHeaderViewHeight(i);
            }
            if (this.eyk != null) {
                this.eyk.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(v vVar) {
        if (this.eyj != null) {
            this.eyj.setRecommendFrsNavigationAnimDispatcher(vVar);
        }
    }

    public void showFloatingView() {
        if (this.eyj != null) {
            this.eyj.showFloatingView();
        }
    }

    public void aMn() {
        if (this.eyj != null) {
            this.eyj.aMn();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bLl != null) {
                this.bLl.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            al.j(this.eyd, e.d.cp_bg_line_e);
            if (this.eyf != null) {
                this.eyf.ey(i);
            }
            if (this.bPm != null) {
                this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bPm.ey(i);
            }
            this.eyh.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void ah(String str, int i) {
        if (this.bPm != null) {
            this.bPm.Fq();
            this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eyj.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.eyj != null) {
                        PersonalizePageView.this.eyj.update();
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
        if (this.bLl != null) {
            this.bLl.dettachView(this);
            this.bLl = null;
            this.evq.setNextPage(this.bPm);
        }
        if (this.eyd != null) {
            this.eyd.setVisibility(0);
        }
        if (this.eyi != null) {
            this.eyi.aLP();
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
        if (this.bLl == null) {
            if (i < 0) {
                this.bLl = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.bLl = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.bLl.onChangeSkinType();
        }
        this.bLl.attachView(this, z);
        this.evq.setNextPage(null);
        if (this.eyd != null) {
            this.eyd.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.eyj != null) {
            this.eyj.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.dNp != null) {
            this.dNp.asu();
        }
        setViewForeground(false);
        if (this.eyj != null) {
            this.eyj.gJ(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.eyq < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.eyw, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.eyj != null) {
            this.eyj.hM(z);
        }
    }

    public void aLX() {
        if (this.eyj != null) {
            i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
            this.eyj.update();
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.yf().yh();
            com.baidu.tbadk.core.bigday.b.yf().yg();
        }
    }

    public void reload() {
        if (this.evq != null && this.eyd != null) {
            showFloatingView();
            this.evq.setSelection(0);
            if (!this.eyd.isRefreshing()) {
                if (this.eyj != null && this.eyj.aCJ() != null) {
                    this.eyj.aCJ().aNK();
                    this.eyj.hV(false);
                }
                this.eyd.setRefreshing(true);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dMP);
        MessageManager.getInstance().unRegisterListener(this.eyx);
        this.eyj.onDestroy();
        this.eyh.a((NEGFeedBackView.a) null);
        this.eyj.a((e.a) null);
        if (this.eye != null) {
            this.eye.a((j.b) null);
            this.eye.a((j.c) null);
            this.eye.a((j.a) null);
            this.eye.release();
        }
        if (this.eyf != null) {
            this.eyf.a((j.b) null);
            this.eyf.a((j.c) null);
            this.eyf.a((j.a) null);
            this.eyf.release();
        }
        this.evq.setOnSrollToBottomListener(null);
        if (this.bLl != null) {
            this.bLl.release();
        }
        this.evq.setRecyclerListener(null);
        if (this.eyk != null) {
            this.eyk.onDestroy();
        }
        if (this.dNp != null) {
            this.dNp.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.yf().destroy();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eyw);
    }

    public void onPause() {
        this.eyj.onPause();
    }

    public void onResume() {
        if (this.dMh) {
            reload();
            this.dMh = false;
        }
        if (this.eyd != null) {
            this.eyd.resume();
        }
    }

    public void aMo() {
        if (this.eyh != null) {
            this.eyh.notifyDataSetChanged();
        }
    }

    public void aLp() {
        if (this.eyj != null) {
            this.eyj.gJ(true);
        }
        com.baidu.tieba.card.v.aqP().dT(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eyw);
    }

    public void aMj() {
        this.eyj.aMz();
    }

    public void aMp() {
        this.eyj.aMp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaA() {
        com.baidu.tieba.homepage.framework.a.aLO().k(System.currentTimeMillis(), 1);
        if (this.bPm != null && !this.bPm.Fv()) {
            this.bPm.Fp();
            this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eyj.aaA();
    }
}
