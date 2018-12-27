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
import com.baidu.tbadk.util.u;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.v;
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
    private final CustomMessageListener aPW;
    private com.baidu.tbadk.k.f bKy;
    private PbListView bOB;
    private boolean dLy;
    private com.baidu.tieba.c.c dMG;
    private CustomMessageListener dMg;
    private View.OnClickListener etf;
    private BdTypeRecyclerView euK;
    private com.baidu.tieba.homepage.personalize.a exA;
    private com.baidu.tieba.homepage.personalize.model.e exB;
    private long exC;
    private FloatingAnimationView exD;
    private boolean exE;
    private int exF;
    private NEGFeedBackView.a exG;
    private e.a exH;
    j.b exI;
    j.c exJ;
    j.a exK;
    private Runnable exL;
    public CustomMessageListener exM;
    private BigdaySwipeRefreshLayout exs;
    private com.baidu.tieba.homepage.personalize.bigday.b exu;
    private com.baidu.tieba.homepage.personalize.bigday.a exv;
    private a exw;
    private l exx;
    private com.baidu.tieba.homepage.framework.b exy;
    private e exz;
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
        int i = personalizePageView.exF + 1;
        personalizePageView.exF = i;
        return i;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.exz != null) {
            this.exz.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.exA != null) {
            this.exA.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.exs != null) {
            this.exs.ph();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.exx != null) {
            this.exx.setPageUniqueId(bdUniqueId);
        }
        if (this.exz != null) {
            this.exz.j(bdUniqueId);
        }
        if (this.exB != null) {
            this.exB.m(bdUniqueId);
        }
        if (this.exv != null) {
            this.exv.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.xS().setTag(bdUniqueId);
        if (this.aPW != null) {
            this.aPW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aPW);
        }
        if (this.exA != null) {
            this.exA.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        m mVar = new m();
        mVar.vJ(String.valueOf(floatInfo.activity_id));
        mVar.dO(floatInfo.dynamic_url);
        mVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        mVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        mVar.vI(floatInfo.float_url);
        mVar.vH(floatInfo.jump_url);
        mVar.setType(floatInfo.show_type.intValue());
        return mVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.exC = 0L;
        this.mSkinType = 3;
        this.dLy = false;
        this.exE = false;
        this.exF = 0;
        this.exG = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new am("c11693").aA("obj_locate", "1").aA(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aA("tid", ahVar.getTid()).aA("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").aA(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aA("tid", ahVar.getTid()).aA("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11693").aA("obj_locate", sb.toString()).aA(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aA("tid", ahVar.getTid()).aA("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.exH = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.exy == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aKP = PersonalizePageView.this.aKP();
                PersonalizePageView.this.aba();
                if (aKP) {
                    PersonalizePageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                PersonalizePageView.this.exy.G(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void s(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.exy != null) {
                    PersonalizePageView.this.exy.r(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.exs.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.exs.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aba();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.exz.aMa());
                PersonalizePageView.this.ct(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dMG != null) {
                    PersonalizePageView.this.dMG.a(a2);
                }
            }
        };
        this.exI = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                com.baidu.tieba.a.d.VO().jK("page_recommend");
                PersonalizePageView.this.exz.update();
            }
        };
        this.exJ = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bI(boolean z) {
                if (PersonalizePageView.this.exz != null) {
                    if (PersonalizePageView.this.exz.aCm() != null) {
                        PersonalizePageView.this.exz.aCm().aNk();
                    }
                    PersonalizePageView.this.exz.hV(false);
                }
            }
        };
        this.exK = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.exz != null) {
                    PersonalizePageView.this.exz.hV(true);
                    PersonalizePageView.this.exz.aLT();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.xS().cA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.exL = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aPW = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.aLO();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.etf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aad();
            }
        };
        this.dMg = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dLy = true;
                    }
                }
            }
        };
        this.exM = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.exs != null && !PersonalizePageView.this.exs.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.exv == null) {
                            PersonalizePageView.this.exv = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.exv.ey(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.exw = PersonalizePageView.this.exv;
                            PersonalizePageView.this.aLM();
                        } else if (PersonalizePageView.this.exw != PersonalizePageView.this.exv) {
                            PersonalizePageView.this.exw = PersonalizePageView.this.exv;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.exv.setEnable(true);
                        PersonalizePageView.this.exs.setProgressView(PersonalizePageView.this.exv);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.exs.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.exu == null) {
                        PersonalizePageView.this.exu = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.exw = PersonalizePageView.this.exu;
                        PersonalizePageView.this.aLM();
                    } else if (PersonalizePageView.this.exw != PersonalizePageView.this.exu || !aVar.equals(PersonalizePageView.this.exu.aMk())) {
                        PersonalizePageView.this.exw = PersonalizePageView.this.exu;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.exu.setEnable(true);
                    PersonalizePageView.this.exs.setProgressView(PersonalizePageView.this.exu);
                    PersonalizePageView.this.exu.a(aVar);
                    PersonalizePageView.this.exs.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0210e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.exC = 0L;
        this.mSkinType = 3;
        this.dLy = false;
        this.exE = false;
        this.exF = 0;
        this.exG = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new am("c11693").aA("obj_locate", "1").aA(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aA("tid", ahVar.getTid()).aA("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").aA(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aA("tid", ahVar.getTid()).aA("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11693").aA("obj_locate", sb.toString()).aA(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aA("tid", ahVar.getTid()).aA("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.exH = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.exy == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aKP = PersonalizePageView.this.aKP();
                PersonalizePageView.this.aba();
                if (aKP) {
                    PersonalizePageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                PersonalizePageView.this.exy.G(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void s(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.exy != null) {
                    PersonalizePageView.this.exy.r(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.exs.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.exs.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aba();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.exz.aMa());
                PersonalizePageView.this.ct(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dMG != null) {
                    PersonalizePageView.this.dMG.a(a2);
                }
            }
        };
        this.exI = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                com.baidu.tieba.a.d.VO().jK("page_recommend");
                PersonalizePageView.this.exz.update();
            }
        };
        this.exJ = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bI(boolean z) {
                if (PersonalizePageView.this.exz != null) {
                    if (PersonalizePageView.this.exz.aCm() != null) {
                        PersonalizePageView.this.exz.aCm().aNk();
                    }
                    PersonalizePageView.this.exz.hV(false);
                }
            }
        };
        this.exK = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.exz != null) {
                    PersonalizePageView.this.exz.hV(true);
                    PersonalizePageView.this.exz.aLT();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.xS().cA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.exL = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aPW = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.aLO();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.etf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aad();
            }
        };
        this.dMg = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dLy = true;
                    }
                }
            }
        };
        this.exM = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.exs != null && !PersonalizePageView.this.exs.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.exv == null) {
                            PersonalizePageView.this.exv = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.exv.ey(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.exw = PersonalizePageView.this.exv;
                            PersonalizePageView.this.aLM();
                        } else if (PersonalizePageView.this.exw != PersonalizePageView.this.exv) {
                            PersonalizePageView.this.exw = PersonalizePageView.this.exv;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.exv.setEnable(true);
                        PersonalizePageView.this.exs.setProgressView(PersonalizePageView.this.exv);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.exs.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.exu == null) {
                        PersonalizePageView.this.exu = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.exw = PersonalizePageView.this.exu;
                        PersonalizePageView.this.aLM();
                    } else if (PersonalizePageView.this.exw != PersonalizePageView.this.exu || !aVar.equals(PersonalizePageView.this.exu.aMk())) {
                        PersonalizePageView.this.exw = PersonalizePageView.this.exu;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.exu.setEnable(true);
                    PersonalizePageView.this.exs.setProgressView(PersonalizePageView.this.exu);
                    PersonalizePageView.this.exu.a(aVar);
                    PersonalizePageView.this.exs.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0210e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.exC = 0L;
        this.mSkinType = 3;
        this.dLy = false;
        this.exE = false;
        this.exF = 0;
        this.exG = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new am("c11693").aA("obj_locate", "1").aA(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aA("tid", ahVar.getTid()).aA("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").aA(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aA("tid", ahVar.getTid()).aA("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11693").aA("obj_locate", sb.toString()).aA(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aA("tid", ahVar.getTid()).aA("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.exH = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i2, int i22, int i3) {
                if (PersonalizePageView.this.exy == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aKP = PersonalizePageView.this.aKP();
                PersonalizePageView.this.aba();
                if (aKP) {
                    PersonalizePageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                PersonalizePageView.this.exy.G(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void s(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.exy != null) {
                    PersonalizePageView.this.exy.r(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.exs.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.exs.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aba();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.exz.aMa());
                PersonalizePageView.this.ct(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dMG != null) {
                    PersonalizePageView.this.dMG.a(a2);
                }
            }
        };
        this.exI = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                com.baidu.tieba.a.d.VO().jK("page_recommend");
                PersonalizePageView.this.exz.update();
            }
        };
        this.exJ = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bI(boolean z) {
                if (PersonalizePageView.this.exz != null) {
                    if (PersonalizePageView.this.exz.aCm() != null) {
                        PersonalizePageView.this.exz.aCm().aNk();
                    }
                    PersonalizePageView.this.exz.hV(false);
                }
            }
        };
        this.exK = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.exz != null) {
                    PersonalizePageView.this.exz.hV(true);
                    PersonalizePageView.this.exz.aLT();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.xS().cA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.exL = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aPW = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.aLO();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.etf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aad();
            }
        };
        this.dMg = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dLy = true;
                    }
                }
            }
        };
        this.exM = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.exs != null && !PersonalizePageView.this.exs.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.exv == null) {
                            PersonalizePageView.this.exv = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.exv.ey(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.exw = PersonalizePageView.this.exv;
                            PersonalizePageView.this.aLM();
                        } else if (PersonalizePageView.this.exw != PersonalizePageView.this.exv) {
                            PersonalizePageView.this.exw = PersonalizePageView.this.exv;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.exv.setEnable(true);
                        PersonalizePageView.this.exs.setProgressView(PersonalizePageView.this.exv);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.exs.setCustomDistances(i2, i2, i2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.exu == null) {
                        PersonalizePageView.this.exu = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.exw = PersonalizePageView.this.exu;
                        PersonalizePageView.this.aLM();
                    } else if (PersonalizePageView.this.exw != PersonalizePageView.this.exu || !aVar.equals(PersonalizePageView.this.exu.aMk())) {
                        PersonalizePageView.this.exw = PersonalizePageView.this.exu;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.exu.setEnable(true);
                    PersonalizePageView.this.exs.setProgressView(PersonalizePageView.this.exu);
                    PersonalizePageView.this.exu.a(aVar);
                    PersonalizePageView.this.exs.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0210e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.euK = new BdTypeRecyclerView(context);
        this.euK.setLayoutManager(new LinearLayoutManager(this.euK.getContext()));
        this.euK.setFadingEdgeLength(0);
        this.euK.setOverScrollMode(2);
        this.exs = new BigdaySwipeRefreshLayout(context);
        this.exs.addView(this.euK);
        this.bOB = new PbListView(context);
        this.bOB.getView();
        this.bOB.ex(e.d.cp_bg_line_e);
        this.bOB.EZ();
        this.bOB.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOB.setTextSize(e.C0210e.tbfontsize33);
        this.bOB.ew(e.d.cp_cont_e);
        this.bOB.setHeight(com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds182));
        this.bOB.setOnClickListener(this.etf);
        this.euK.setNextPage(this.bOB);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        MessageManager.getInstance().registerListener(this.exM);
        com.baidu.tbadk.core.bigday.b.xS().aX(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.xS().cA(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.exs);
        ((FrameLayout.LayoutParams) this.exs.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.exB = new com.baidu.tieba.homepage.personalize.model.e();
        this.exx = new l(context, this.euK);
        this.exx.b(this.exB);
        this.exz = new e(this.pageContext, this.euK, this.exx, this.exs);
        this.exA = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dMg);
        this.exF = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(Context context) {
        if (this.exD == null) {
            this.exD = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds200), com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds200);
            addView(this.exD, layoutParams);
            this.exD.setVisibility(8);
            this.exD.setPageId(this.pageContext.getUniqueId());
            this.dMG = new com.baidu.tieba.c.c(this.pageContext, this.exD, 1);
        }
    }

    public void aLM() {
        if (this.exw != null) {
            this.exw.a(this.exI);
            this.exw.a(this.exJ);
            this.exw.a(this.exK);
        }
    }

    public void aFL() {
        this.exx.a(this.exG);
        this.exz.a(this.exH);
        this.exA.a(this);
        aLM();
        this.euK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aad();
            }
        });
        this.euK.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.exC >= 5000) {
                    PersonalizePageView.this.exz.ba(i, i2);
                }
            }
        }, 1L);
        this.euK.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.exz != null && PersonalizePageView.this.exz.aCm() != null) {
                        PersonalizePageView.this.exz.aCm().bm(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).aqT().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.exy = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bOB != null) {
            this.bOB.Fd();
            this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.exz.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.exz != null) {
            this.exz.hS(!z);
        }
        this.exE = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.exE;
    }

    public void g(Long l) {
        this.exz.g(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.exs != null && this.exs.getLayoutParams() != null) {
            if (this.exz != null) {
                this.exz.setHeaderViewHeight(i);
            }
            if (this.exA != null) {
                this.exA.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.exz != null) {
            this.exz.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    public void showFloatingView() {
        if (this.exz != null) {
            this.exz.showFloatingView();
        }
    }

    public void aLN() {
        if (this.exz != null) {
            this.exz.aLN();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bKy != null) {
                this.bKy.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            al.j(this.exs, e.d.cp_bg_line_e);
            if (this.exv != null) {
                this.exv.ey(i);
            }
            if (this.bOB != null) {
                this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bOB.ey(i);
            }
            this.exx.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void ah(String str, int i) {
        if (this.bOB != null) {
            this.bOB.Fd();
            this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.exz.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.exz != null) {
                        PersonalizePageView.this.exz.update();
                    }
                }
            });
        }
        this.refreshView.ge(getContext().getResources().getDimensionPixelSize(e.C0210e.ds280));
        this.refreshView.io(str);
        this.refreshView.attachView(view, z);
        this.refreshView.NM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aba() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.bKy != null) {
            this.bKy.dettachView(this);
            this.bKy = null;
            this.euK.setNextPage(this.bOB);
        }
        if (this.exs != null) {
            this.exs.setVisibility(0);
        }
        if (this.exy != null) {
            this.exy.aLr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aKP() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.bKy == null) {
            if (i < 0) {
                this.bKy = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.bKy = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.bKy.onChangeSkinType();
        }
        this.bKy.attachView(this, z);
        this.euK.setNextPage(null);
        if (this.exs != null) {
            this.exs.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.exz != null) {
            this.exz.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.dMG != null) {
            this.dMG.arW();
        }
        setViewForeground(false);
        if (this.exz != null) {
            this.exz.gG(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.exF < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.exL, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.exz != null) {
            this.exz.hM(z);
        }
    }

    public void aLy() {
        if (this.exz != null) {
            i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
            this.exz.update();
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.xS().xU();
            com.baidu.tbadk.core.bigday.b.xS().xT();
        }
    }

    public void reload() {
        if (this.euK != null && this.exs != null) {
            showFloatingView();
            this.euK.setSelection(0);
            if (!this.exs.isRefreshing()) {
                if (this.exz != null && this.exz.aCm() != null) {
                    this.exz.aCm().aNk();
                    this.exz.hV(false);
                }
                this.exs.setRefreshing(true);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dMg);
        MessageManager.getInstance().unRegisterListener(this.exM);
        this.exz.onDestroy();
        this.exx.a((NEGFeedBackView.a) null);
        this.exz.a((e.a) null);
        if (this.exu != null) {
            this.exu.a((j.b) null);
            this.exu.a((j.c) null);
            this.exu.a((j.a) null);
            this.exu.release();
        }
        if (this.exv != null) {
            this.exv.a((j.b) null);
            this.exv.a((j.c) null);
            this.exv.a((j.a) null);
            this.exv.release();
        }
        this.euK.setOnSrollToBottomListener(null);
        if (this.bKy != null) {
            this.bKy.release();
        }
        this.euK.setRecyclerListener(null);
        if (this.exA != null) {
            this.exA.onDestroy();
        }
        if (this.dMG != null) {
            this.dMG.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.xS().destroy();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.exL);
    }

    public void onPause() {
        this.exz.onPause();
    }

    public void onResume() {
        if (this.dLy) {
            reload();
            this.dLy = false;
        }
        if (this.exs != null) {
            this.exs.resume();
        }
    }

    public void aLO() {
        if (this.exx != null) {
            this.exx.notifyDataSetChanged();
        }
    }

    public void aKR() {
        if (this.exz != null) {
            this.exz.gG(true);
        }
        v.aqs().dQ(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.exL);
    }

    public void aLJ() {
        this.exz.aLZ();
    }

    public void aLP() {
        this.exz.aLP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aad() {
        com.baidu.tieba.homepage.framework.a.aLq().k(System.currentTimeMillis(), 1);
        if (this.bOB != null && !this.bOB.Fi()) {
            this.bOB.Fc();
            this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.exz.aad();
    }
}
