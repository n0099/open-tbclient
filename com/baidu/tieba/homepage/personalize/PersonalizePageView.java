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
/* loaded from: classes2.dex */
public class PersonalizePageView extends FrameLayout {
    private final CustomMessageListener aHc;
    private PbListView bBr;
    private com.baidu.tbadk.k.f bxm;
    private boolean dsT;
    private CustomMessageListener dtB;
    private com.baidu.tieba.c.c dub;
    private View.OnClickListener eaf;
    private BdTypeRecyclerView ebK;
    private e eeA;
    private com.baidu.tieba.homepage.personalize.a eeB;
    private com.baidu.tieba.homepage.personalize.model.e eeC;
    private long eeD;
    private FloatingAnimationView eeE;
    private boolean eeF;
    private int eeG;
    private NEGFeedBackView.a eeH;
    private e.a eeI;
    j.b eeJ;
    j.c eeK;
    j.a eeL;
    private Runnable eeM;
    public CustomMessageListener eeN;
    private BigdaySwipeRefreshLayout eeu;
    private com.baidu.tieba.homepage.personalize.bigday.b eev;
    private com.baidu.tieba.homepage.personalize.bigday.a eew;
    private a eex;
    private l eey;
    private com.baidu.tieba.homepage.framework.b eez;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void a(j.a aVar);

        void a(j.b bVar);

        void a(j.c cVar);
    }

    static /* synthetic */ int l(PersonalizePageView personalizePageView) {
        int i = personalizePageView.eeG + 1;
        personalizePageView.eeG = i;
        return i;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.eeA != null) {
            this.eeA.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.eeB != null) {
            this.eeB.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.eeu != null) {
            this.eeu.pc();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eey != null) {
            this.eey.setPageUniqueId(bdUniqueId);
        }
        if (this.eeA != null) {
            this.eeA.j(bdUniqueId);
        }
        if (this.eeC != null) {
            this.eeC.m(bdUniqueId);
        }
        if (this.eew != null) {
            this.eew.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.ux().setTag(bdUniqueId);
        if (this.aHc != null) {
            this.aHc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aHc);
        }
        if (this.eeB != null) {
            this.eeB.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        m mVar = new m();
        mVar.uy(String.valueOf(floatInfo.activity_id));
        mVar.dx(floatInfo.dynamic_url);
        mVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        mVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        mVar.ux(floatInfo.float_url);
        mVar.uw(floatInfo.jump_url);
        mVar.setType(floatInfo.show_type.intValue());
        return mVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.eeD = 0L;
        this.mSkinType = 3;
        this.dsT = false;
        this.eeF = false;
        this.eeG = 0;
        this.eeH = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new am("c11693").al("obj_locate", "1").al(ImageViewerConfig.FORUM_ID, ahVar.getFid()).al("tid", ahVar.getTid()).al("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").al(ImageViewerConfig.FORUM_ID, ahVar.getFid()).al("tid", ahVar.getTid()).al("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11693").al("obj_locate", sb.toString()).al(ImageViewerConfig.FORUM_ID, ahVar.getFid()).al("tid", ahVar.getTid()).al("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.eeI = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aV(int i, int i2) {
                if (PersonalizePageView.this.eez == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aFt = PersonalizePageView.this.aFt();
                PersonalizePageView.this.Wa();
                if (aFt) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds520));
                }
                PersonalizePageView.this.eez.aU(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.eez != null) {
                    PersonalizePageView.this.eez.G(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.eeu.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kK()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.eeu.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Wa();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.eeA.aGF());
                PersonalizePageView.this.ch(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dub != null) {
                    PersonalizePageView.this.dub.a(a2);
                }
            }
        };
        this.eeJ = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                com.baidu.tieba.a.d.SB().jc("page_recommend");
                PersonalizePageView.this.eeA.update();
            }
        };
        this.eeK = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bg(boolean z) {
                if (PersonalizePageView.this.eeA != null) {
                    if (PersonalizePageView.this.eeA.awU() != null) {
                        PersonalizePageView.this.eeA.awU().aHP();
                    }
                    PersonalizePageView.this.eeA.hn(false);
                }
            }
        };
        this.eeL = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.eeA != null) {
                    PersonalizePageView.this.eeA.hn(true);
                    PersonalizePageView.this.eeA.aGy();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iB().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.ux().bM(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.eeM = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aHc = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aGt();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.eaf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.Vd();
            }
        };
        this.dtB = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dsT = true;
                    }
                }
            }
        };
        this.eeN = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.eeu != null && !PersonalizePageView.this.eeu.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.eew == null) {
                            PersonalizePageView.this.eew = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.eew.dM(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.eex = PersonalizePageView.this.eew;
                            PersonalizePageView.this.aGr();
                        } else if (PersonalizePageView.this.eex != PersonalizePageView.this.eew) {
                            PersonalizePageView.this.eex = PersonalizePageView.this.eew;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.eew.setEnable(true);
                        PersonalizePageView.this.eeu.setProgressView(PersonalizePageView.this.eew);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.eeu.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.eev == null) {
                        PersonalizePageView.this.eev = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.eex = PersonalizePageView.this.eev;
                        PersonalizePageView.this.aGr();
                    } else if (PersonalizePageView.this.eex != PersonalizePageView.this.eev || !aVar.equals(PersonalizePageView.this.eev.aGP())) {
                        PersonalizePageView.this.eex = PersonalizePageView.this.eev;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.eev.setEnable(true);
                    PersonalizePageView.this.eeu.setProgressView(PersonalizePageView.this.eev);
                    PersonalizePageView.this.eev.a(aVar);
                    PersonalizePageView.this.eeu.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0141e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eeD = 0L;
        this.mSkinType = 3;
        this.dsT = false;
        this.eeF = false;
        this.eeG = 0;
        this.eeH = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new am("c11693").al("obj_locate", "1").al(ImageViewerConfig.FORUM_ID, ahVar.getFid()).al("tid", ahVar.getTid()).al("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").al(ImageViewerConfig.FORUM_ID, ahVar.getFid()).al("tid", ahVar.getTid()).al("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11693").al("obj_locate", sb.toString()).al(ImageViewerConfig.FORUM_ID, ahVar.getFid()).al("tid", ahVar.getTid()).al("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.eeI = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aV(int i, int i2) {
                if (PersonalizePageView.this.eez == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aFt = PersonalizePageView.this.aFt();
                PersonalizePageView.this.Wa();
                if (aFt) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds520));
                }
                PersonalizePageView.this.eez.aU(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.eez != null) {
                    PersonalizePageView.this.eez.G(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.eeu.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kK()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.eeu.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Wa();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.eeA.aGF());
                PersonalizePageView.this.ch(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dub != null) {
                    PersonalizePageView.this.dub.a(a2);
                }
            }
        };
        this.eeJ = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                com.baidu.tieba.a.d.SB().jc("page_recommend");
                PersonalizePageView.this.eeA.update();
            }
        };
        this.eeK = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bg(boolean z) {
                if (PersonalizePageView.this.eeA != null) {
                    if (PersonalizePageView.this.eeA.awU() != null) {
                        PersonalizePageView.this.eeA.awU().aHP();
                    }
                    PersonalizePageView.this.eeA.hn(false);
                }
            }
        };
        this.eeL = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.eeA != null) {
                    PersonalizePageView.this.eeA.hn(true);
                    PersonalizePageView.this.eeA.aGy();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iB().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.ux().bM(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.eeM = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aHc = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aGt();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.eaf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.Vd();
            }
        };
        this.dtB = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dsT = true;
                    }
                }
            }
        };
        this.eeN = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.eeu != null && !PersonalizePageView.this.eeu.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.eew == null) {
                            PersonalizePageView.this.eew = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.eew.dM(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.eex = PersonalizePageView.this.eew;
                            PersonalizePageView.this.aGr();
                        } else if (PersonalizePageView.this.eex != PersonalizePageView.this.eew) {
                            PersonalizePageView.this.eex = PersonalizePageView.this.eew;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.eew.setEnable(true);
                        PersonalizePageView.this.eeu.setProgressView(PersonalizePageView.this.eew);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.eeu.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.eev == null) {
                        PersonalizePageView.this.eev = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.eex = PersonalizePageView.this.eev;
                        PersonalizePageView.this.aGr();
                    } else if (PersonalizePageView.this.eex != PersonalizePageView.this.eev || !aVar.equals(PersonalizePageView.this.eev.aGP())) {
                        PersonalizePageView.this.eex = PersonalizePageView.this.eev;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.eev.setEnable(true);
                    PersonalizePageView.this.eeu.setProgressView(PersonalizePageView.this.eev);
                    PersonalizePageView.this.eev.a(aVar);
                    PersonalizePageView.this.eeu.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0141e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eeD = 0L;
        this.mSkinType = 3;
        this.dsT = false;
        this.eeF = false;
        this.eeG = 0;
        this.eeH = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new am("c11693").al("obj_locate", "1").al(ImageViewerConfig.FORUM_ID, ahVar.getFid()).al("tid", ahVar.getTid()).al("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").al(ImageViewerConfig.FORUM_ID, ahVar.getFid()).al("tid", ahVar.getTid()).al("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11693").al("obj_locate", sb.toString()).al(ImageViewerConfig.FORUM_ID, ahVar.getFid()).al("tid", ahVar.getTid()).al("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.eeI = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aV(int i2, int i22) {
                if (PersonalizePageView.this.eez == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aFt = PersonalizePageView.this.aFt();
                PersonalizePageView.this.Wa();
                if (aFt) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds520));
                }
                PersonalizePageView.this.eez.aU(i2, i22);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i2, int i22, int i3) {
                if (PersonalizePageView.this.eez != null) {
                    PersonalizePageView.this.eez.G(i2, i22, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.eeu.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kK()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.eeu.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Wa();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.eeA.aGF());
                PersonalizePageView.this.ch(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dub != null) {
                    PersonalizePageView.this.dub.a(a2);
                }
            }
        };
        this.eeJ = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                com.baidu.tieba.a.d.SB().jc("page_recommend");
                PersonalizePageView.this.eeA.update();
            }
        };
        this.eeK = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bg(boolean z) {
                if (PersonalizePageView.this.eeA != null) {
                    if (PersonalizePageView.this.eeA.awU() != null) {
                        PersonalizePageView.this.eeA.awU().aHP();
                    }
                    PersonalizePageView.this.eeA.hn(false);
                }
            }
        };
        this.eeL = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.eeA != null) {
                    PersonalizePageView.this.eeA.hn(true);
                    PersonalizePageView.this.eeA.aGy();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iB().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.ux().bM(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.eeM = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aHc = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aGt();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.eaf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.Vd();
            }
        };
        this.dtB = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dsT = true;
                    }
                }
            }
        };
        this.eeN = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.eeu != null && !PersonalizePageView.this.eeu.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.eew == null) {
                            PersonalizePageView.this.eew = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.eew.dM(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.eex = PersonalizePageView.this.eew;
                            PersonalizePageView.this.aGr();
                        } else if (PersonalizePageView.this.eex != PersonalizePageView.this.eew) {
                            PersonalizePageView.this.eex = PersonalizePageView.this.eew;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.eew.setEnable(true);
                        PersonalizePageView.this.eeu.setProgressView(PersonalizePageView.this.eew);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.eeu.setCustomDistances(i2, i2, i2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.eev == null) {
                        PersonalizePageView.this.eev = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.eex = PersonalizePageView.this.eev;
                        PersonalizePageView.this.aGr();
                    } else if (PersonalizePageView.this.eex != PersonalizePageView.this.eev || !aVar.equals(PersonalizePageView.this.eev.aGP())) {
                        PersonalizePageView.this.eex = PersonalizePageView.this.eev;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.eev.setEnable(true);
                    PersonalizePageView.this.eeu.setProgressView(PersonalizePageView.this.eev);
                    PersonalizePageView.this.eev.a(aVar);
                    PersonalizePageView.this.eeu.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0141e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ebK = new BdTypeRecyclerView(context);
        this.ebK.setLayoutManager(new LinearLayoutManager(this.ebK.getContext()));
        this.ebK.setFadingEdgeLength(0);
        this.ebK.setOverScrollMode(2);
        this.eeu = new BigdaySwipeRefreshLayout(context);
        this.eeu.addView(this.ebK);
        this.bBr = new PbListView(context);
        this.bBr.getView();
        this.bBr.dL(e.d.cp_bg_line_e);
        this.bBr.BF();
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bBr.setTextSize(e.C0141e.tbfontsize33);
        this.bBr.dK(e.d.cp_cont_e);
        this.bBr.setHeight(com.baidu.adp.lib.util.l.h(context, e.C0141e.tbds182));
        this.bBr.setOnClickListener(this.eaf);
        this.ebK.setNextPage(this.bBr);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        MessageManager.getInstance().registerListener(this.eeN);
        com.baidu.tbadk.core.bigday.b.ux().aw(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.iB().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.ux().bM(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.eeu);
        ((FrameLayout.LayoutParams) this.eeu.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eeC = new com.baidu.tieba.homepage.personalize.model.e();
        this.eey = new l(context, this.ebK);
        this.eey.b(this.eeC);
        this.eeA = new e(this.pageContext, this.ebK, this.eey, this.eeu);
        this.eeB = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dtB);
        this.eeG = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(Context context) {
        if (this.eeE == null) {
            this.eeE = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.h(context, e.C0141e.tbds200), com.baidu.adp.lib.util.l.h(context, e.C0141e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(context, e.C0141e.tbds200);
            addView(this.eeE, layoutParams);
            this.eeE.setVisibility(8);
            this.eeE.setPageId(this.pageContext.getUniqueId());
            this.dub = new com.baidu.tieba.c.c(this.pageContext, this.eeE, 1);
        }
    }

    public void aGr() {
        if (this.eex != null) {
            this.eex.a(this.eeJ);
            this.eex.a(this.eeK);
            this.eex.a(this.eeL);
        }
    }

    public void aAw() {
        this.eey.a(this.eeH);
        this.eeA.a(this.eeI);
        this.eeB.a(this);
        aGr();
        this.ebK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.Vd();
            }
        });
        this.ebK.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.eeD >= 5000) {
                    PersonalizePageView.this.eeA.aW(i, i2);
                }
            }
        }, 1L);
        this.ebK.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.eeA != null && PersonalizePageView.this.eeA.awU() != null) {
                        PersonalizePageView.this.eeA.awU().bh(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).aln().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.eez = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bBr != null) {
            this.bBr.BJ();
            this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eeA.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.eeA != null) {
            this.eeA.hl(!z);
        }
        this.eeF = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.eeF;
    }

    public void f(Long l) {
        this.eeA.f(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.eeu != null && this.eeu.getLayoutParams() != null) {
            if (this.eeA != null) {
                this.eeA.setHeaderViewHeight(i);
            }
            if (this.eeB != null) {
                this.eeB.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.eeA != null) {
            this.eeA.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    public void showFloatingView() {
        if (this.eeA != null) {
            this.eeA.showFloatingView();
        }
    }

    public void aGs() {
        if (this.eeA != null) {
            this.eeA.aGs();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bxm != null) {
                this.bxm.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            al.j(this.eeu, e.d.cp_bg_line_e);
            if (this.eew != null) {
                this.eew.dM(i);
            }
            if (this.bBr != null) {
                this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bBr.dM(i);
            }
            this.eey.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void ab(String str, int i) {
        if (this.bBr != null) {
            this.bBr.BJ();
            this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eeA.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.eeA != null) {
                        PersonalizePageView.this.eeA.update();
                    }
                }
            });
        }
        this.refreshView.fs(getContext().getResources().getDimensionPixelSize(e.C0141e.ds280));
        this.refreshView.hG(str);
        this.refreshView.c(view, z);
        this.refreshView.KA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wa() {
        if (this.refreshView != null) {
            this.refreshView.ad(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.bxm != null) {
            this.bxm.ad(this);
            this.bxm = null;
            this.ebK.setNextPage(this.bBr);
        }
        if (this.eeu != null) {
            this.eeu.setVisibility(0);
        }
        if (this.eez != null) {
            this.eez.aFV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFt() {
        if (this.refreshView != null) {
            return this.refreshView.Ks();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bxm == null) {
            if (i < 0) {
                this.bxm = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.bxm = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.bxm.onChangeSkinType();
        }
        this.bxm.c(this, z);
        this.ebK.setNextPage(null);
        if (this.eeu != null) {
            this.eeu.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.eeA != null) {
            this.eeA.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.dub != null) {
            this.dub.amu();
        }
        setViewForeground(false);
        if (this.eeA != null) {
            this.eeA.ga(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.eeG < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.jt().postDelayed(this.eeM, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.eeA != null) {
            this.eeA.hf(z);
        }
    }

    public void aGd() {
        if (this.eeA != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds520));
            this.eeA.update();
        }
        if (com.baidu.adp.lib.b.d.iB().aO("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.ux().uz();
            com.baidu.tbadk.core.bigday.b.ux().uy();
        }
    }

    public void reload() {
        if (this.ebK != null && this.eeu != null) {
            showFloatingView();
            this.ebK.setSelection(0);
            if (!this.eeu.isRefreshing()) {
                if (this.eeA != null && this.eeA.awU() != null) {
                    this.eeA.awU().aHP();
                    this.eeA.hn(false);
                }
                this.eeu.setRefreshing(true);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dtB);
        MessageManager.getInstance().unRegisterListener(this.eeN);
        this.eeA.onDestroy();
        this.eey.a((NEGFeedBackView.a) null);
        this.eeA.a((e.a) null);
        if (this.eev != null) {
            this.eev.a((j.b) null);
            this.eev.a((j.c) null);
            this.eev.a((j.a) null);
            this.eev.release();
        }
        if (this.eew != null) {
            this.eew.a((j.b) null);
            this.eew.a((j.c) null);
            this.eew.a((j.a) null);
            this.eew.release();
        }
        this.ebK.setOnSrollToBottomListener(null);
        if (this.bxm != null) {
            this.bxm.release();
        }
        this.ebK.setRecyclerListener(null);
        if (this.eeB != null) {
            this.eeB.onDestroy();
        }
        if (this.dub != null) {
            this.dub.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.ux().destroy();
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eeM);
    }

    public void onPause() {
        this.eeA.onPause();
    }

    public void onResume() {
        if (this.dsT) {
            reload();
            this.dsT = false;
        }
        if (this.eeu != null) {
            this.eeu.resume();
        }
    }

    public void aGt() {
        if (this.eey != null) {
            this.eey.notifyDataSetChanged();
        }
    }

    public void aFv() {
        if (this.eeA != null) {
            this.eeA.ga(true);
        }
        v.akM().dc(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eeM);
    }

    public void aGp() {
        this.eeA.aGE();
    }

    public void aGu() {
        this.eeA.aGu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vd() {
        com.baidu.tieba.homepage.framework.a.aFU().k(System.currentTimeMillis(), 1);
        if (this.bBr != null && !this.bBr.BO()) {
            this.bBr.BI();
            this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eeA.Vd();
    }
}
