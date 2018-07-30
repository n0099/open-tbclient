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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.d;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.FloatingAnimationView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes2.dex */
public class PersonalizePageView extends FrameLayout {
    private final CustomMessageListener aDX;
    private f brt;
    private PbListView bvA;
    private View.OnClickListener dST;
    private BdTypeRecyclerView dUw;
    private BigdaySwipeRefreshLayout dXd;
    private com.baidu.tieba.homepage.personalize.bigday.b dXe;
    private com.baidu.tieba.homepage.personalize.bigday.a dXf;
    private a dXg;
    private l dXh;
    private com.baidu.tieba.homepage.framework.b dXi;
    private d dXj;
    private com.baidu.tieba.homepage.personalize.a dXk;
    private com.baidu.tieba.homepage.personalize.model.e dXl;
    private long dXm;
    private FloatingAnimationView dXn;
    private boolean dXo;
    private int dXp;
    private NEGFeedBackView.a dXq;
    private d.a dXr;
    g.b dXs;
    g.c dXt;
    g.a dXu;
    private Runnable dXv;
    public CustomMessageListener dXw;
    private boolean dmY;
    private CustomMessageListener dnF;
    private com.baidu.tieba.c.c dog;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.k.g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void a(g.a aVar);

        void a(g.b bVar);

        void a(g.c cVar);
    }

    static /* synthetic */ int l(PersonalizePageView personalizePageView) {
        int i = personalizePageView.dXp + 1;
        personalizePageView.dXp = i;
        return i;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dXj != null) {
            this.dXj.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.dXk != null) {
            this.dXk.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.dXd != null) {
            this.dXd.nZ();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dXh != null) {
            this.dXh.setPageUniqueId(bdUniqueId);
        }
        if (this.dXj != null) {
            this.dXj.j(bdUniqueId);
        }
        if (this.dXl != null) {
            this.dXl.m(bdUniqueId);
        }
        if (this.dXf != null) {
            this.dXf.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.tv().setTag(bdUniqueId);
        if (this.aDX != null) {
            this.aDX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aDX);
        }
        if (this.dXk != null) {
            this.dXk.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        m mVar = new m();
        mVar.tN(String.valueOf(floatInfo.activity_id));
        mVar.dw(floatInfo.dynamic_url);
        mVar.cT(floatInfo.end_time.longValue() * 1000);
        mVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        mVar.tM(floatInfo.float_url);
        mVar.tL(floatInfo.jump_url);
        mVar.setType(floatInfo.show_type.intValue());
        return mVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.dXm = 0L;
        this.mSkinType = 3;
        this.dmY = false;
        this.dXo = false;
        this.dXp = 0;
        this.dXq = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new an("c11693").af("obj_locate", "1").af(ImageViewerConfig.FORUM_ID, ahVar.getFid()).af("tid", ahVar.getTid()).af("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").af(ImageViewerConfig.FORUM_ID, ahVar.getFid()).af("tid", ahVar.getTid()).af("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11693").af("obj_locate", sb.toString()).af(ImageViewerConfig.FORUM_ID, ahVar.getFid()).af("tid", ahVar.getTid()).af("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dXr = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aR(int i, int i2) {
                if (PersonalizePageView.this.dXi == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aDj = PersonalizePageView.this.aDj();
                PersonalizePageView.this.Uk();
                if (aDj) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dXi.aQ(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dXi != null) {
                    PersonalizePageView.this.dXi.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.dXd.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.jE()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dXd.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Uk();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.dXj.aEt());
                PersonalizePageView.this.bA(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dog != null) {
                    PersonalizePageView.this.dog.a(a2);
                }
            }
        };
        this.dXs = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                com.baidu.tieba.a.d.QI().iz("page_recommend");
                PersonalizePageView.this.dXj.update();
            }
        };
        this.dXt = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.g.c
            public void aT(boolean z) {
                if (PersonalizePageView.this.dXj != null) {
                    if (PersonalizePageView.this.dXj.avc() != null) {
                        PersonalizePageView.this.dXj.avc().aFD();
                    }
                    PersonalizePageView.this.dXj.gP(false);
                }
            }
        };
        this.dXu = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.dXj != null) {
                    PersonalizePageView.this.dXj.gP(true);
                    PersonalizePageView.this.dXj.aEm();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hv().ax("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.tv().bD(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.dXv = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aDX = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aEi();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dST = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.Tn();
            }
        };
        this.dnF = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dmY = true;
                    }
                }
            }
        };
        this.dXw = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.dXd != null && !PersonalizePageView.this.dXd.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.dXf == null) {
                            PersonalizePageView.this.dXf = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.dXf.dC(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.dXg = PersonalizePageView.this.dXf;
                            PersonalizePageView.this.aEg();
                        } else if (PersonalizePageView.this.dXg != PersonalizePageView.this.dXf) {
                            PersonalizePageView.this.dXg = PersonalizePageView.this.dXf;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.dXf.setEnable(true);
                        PersonalizePageView.this.dXd.setProgressView(PersonalizePageView.this.dXf);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.dXd.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.dXe == null) {
                        PersonalizePageView.this.dXe = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.dXg = PersonalizePageView.this.dXe;
                        PersonalizePageView.this.aEg();
                    } else if (PersonalizePageView.this.dXg != PersonalizePageView.this.dXe || !aVar.equals(PersonalizePageView.this.dXe.aED())) {
                        PersonalizePageView.this.dXg = PersonalizePageView.this.dXe;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.dXe.setEnable(true);
                    PersonalizePageView.this.dXd.setProgressView(PersonalizePageView.this.dXe);
                    PersonalizePageView.this.dXe.a(aVar);
                    PersonalizePageView.this.dXd.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXm = 0L;
        this.mSkinType = 3;
        this.dmY = false;
        this.dXo = false;
        this.dXp = 0;
        this.dXq = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new an("c11693").af("obj_locate", "1").af(ImageViewerConfig.FORUM_ID, ahVar.getFid()).af("tid", ahVar.getTid()).af("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").af(ImageViewerConfig.FORUM_ID, ahVar.getFid()).af("tid", ahVar.getTid()).af("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11693").af("obj_locate", sb.toString()).af(ImageViewerConfig.FORUM_ID, ahVar.getFid()).af("tid", ahVar.getTid()).af("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dXr = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aR(int i, int i2) {
                if (PersonalizePageView.this.dXi == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aDj = PersonalizePageView.this.aDj();
                PersonalizePageView.this.Uk();
                if (aDj) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dXi.aQ(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dXi != null) {
                    PersonalizePageView.this.dXi.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.dXd.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.jE()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dXd.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Uk();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.dXj.aEt());
                PersonalizePageView.this.bA(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dog != null) {
                    PersonalizePageView.this.dog.a(a2);
                }
            }
        };
        this.dXs = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                com.baidu.tieba.a.d.QI().iz("page_recommend");
                PersonalizePageView.this.dXj.update();
            }
        };
        this.dXt = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.g.c
            public void aT(boolean z) {
                if (PersonalizePageView.this.dXj != null) {
                    if (PersonalizePageView.this.dXj.avc() != null) {
                        PersonalizePageView.this.dXj.avc().aFD();
                    }
                    PersonalizePageView.this.dXj.gP(false);
                }
            }
        };
        this.dXu = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.dXj != null) {
                    PersonalizePageView.this.dXj.gP(true);
                    PersonalizePageView.this.dXj.aEm();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hv().ax("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.tv().bD(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.dXv = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aDX = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aEi();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dST = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.Tn();
            }
        };
        this.dnF = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dmY = true;
                    }
                }
            }
        };
        this.dXw = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.dXd != null && !PersonalizePageView.this.dXd.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.dXf == null) {
                            PersonalizePageView.this.dXf = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.dXf.dC(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.dXg = PersonalizePageView.this.dXf;
                            PersonalizePageView.this.aEg();
                        } else if (PersonalizePageView.this.dXg != PersonalizePageView.this.dXf) {
                            PersonalizePageView.this.dXg = PersonalizePageView.this.dXf;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.dXf.setEnable(true);
                        PersonalizePageView.this.dXd.setProgressView(PersonalizePageView.this.dXf);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.dXd.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.dXe == null) {
                        PersonalizePageView.this.dXe = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.dXg = PersonalizePageView.this.dXe;
                        PersonalizePageView.this.aEg();
                    } else if (PersonalizePageView.this.dXg != PersonalizePageView.this.dXe || !aVar.equals(PersonalizePageView.this.dXe.aED())) {
                        PersonalizePageView.this.dXg = PersonalizePageView.this.dXe;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.dXe.setEnable(true);
                    PersonalizePageView.this.dXd.setProgressView(PersonalizePageView.this.dXe);
                    PersonalizePageView.this.dXe.a(aVar);
                    PersonalizePageView.this.dXd.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dXm = 0L;
        this.mSkinType = 3;
        this.dmY = false;
        this.dXo = false;
        this.dXp = 0;
        this.dXq = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new an("c11693").af("obj_locate", "1").af(ImageViewerConfig.FORUM_ID, ahVar.getFid()).af("tid", ahVar.getTid()).af("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").af(ImageViewerConfig.FORUM_ID, ahVar.getFid()).af("tid", ahVar.getTid()).af("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11693").af("obj_locate", sb.toString()).af(ImageViewerConfig.FORUM_ID, ahVar.getFid()).af("tid", ahVar.getTid()).af("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dXr = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aR(int i2, int i22) {
                if (PersonalizePageView.this.dXi == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aDj = PersonalizePageView.this.aDj();
                PersonalizePageView.this.Uk();
                if (aDj) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dXi.aQ(i2, i22);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i2, int i22, int i3) {
                if (PersonalizePageView.this.dXi != null) {
                    PersonalizePageView.this.dXi.B(i2, i22, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.dXd.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.jE()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dXd.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Uk();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.dXj.aEt());
                PersonalizePageView.this.bA(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dog != null) {
                    PersonalizePageView.this.dog.a(a2);
                }
            }
        };
        this.dXs = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                com.baidu.tieba.a.d.QI().iz("page_recommend");
                PersonalizePageView.this.dXj.update();
            }
        };
        this.dXt = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.g.c
            public void aT(boolean z) {
                if (PersonalizePageView.this.dXj != null) {
                    if (PersonalizePageView.this.dXj.avc() != null) {
                        PersonalizePageView.this.dXj.avc().aFD();
                    }
                    PersonalizePageView.this.dXj.gP(false);
                }
            }
        };
        this.dXu = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.dXj != null) {
                    PersonalizePageView.this.dXj.gP(true);
                    PersonalizePageView.this.dXj.aEm();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hv().ax("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.tv().bD(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.dXv = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aDX = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aEi();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dST = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.Tn();
            }
        };
        this.dnF = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dmY = true;
                    }
                }
            }
        };
        this.dXw = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.dXd != null && !PersonalizePageView.this.dXd.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.dXf == null) {
                            PersonalizePageView.this.dXf = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.dXf.dC(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.dXg = PersonalizePageView.this.dXf;
                            PersonalizePageView.this.aEg();
                        } else if (PersonalizePageView.this.dXg != PersonalizePageView.this.dXf) {
                            PersonalizePageView.this.dXg = PersonalizePageView.this.dXf;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.dXf.setEnable(true);
                        PersonalizePageView.this.dXd.setProgressView(PersonalizePageView.this.dXf);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.dXd.setCustomDistances(i2, i2, i2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.dXe == null) {
                        PersonalizePageView.this.dXe = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.dXg = PersonalizePageView.this.dXe;
                        PersonalizePageView.this.aEg();
                    } else if (PersonalizePageView.this.dXg != PersonalizePageView.this.dXe || !aVar.equals(PersonalizePageView.this.dXe.aED())) {
                        PersonalizePageView.this.dXg = PersonalizePageView.this.dXe;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.dXe.setEnable(true);
                    PersonalizePageView.this.dXd.setProgressView(PersonalizePageView.this.dXe);
                    PersonalizePageView.this.dXe.a(aVar);
                    PersonalizePageView.this.dXd.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dUw = new BdTypeRecyclerView(context);
        this.dUw.setLayoutManager(new LinearLayoutManager(this.dUw.getContext()));
        this.dUw.setFadingEdgeLength(0);
        this.dUw.setOverScrollMode(2);
        this.dXd = new BigdaySwipeRefreshLayout(context);
        this.dXd.addView(this.dUw);
        this.bvA = new PbListView(context);
        this.bvA.getView();
        this.bvA.dB(d.C0140d.cp_bg_line_e);
        this.bvA.Au();
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_j));
        this.bvA.setTextSize(d.e.tbfontsize33);
        this.bvA.dA(d.C0140d.cp_cont_e);
        this.bvA.setHeight(com.baidu.adp.lib.util.l.f(context, d.e.tbds182));
        this.bvA.setOnClickListener(this.dST);
        this.dUw.setNextPage(this.bvA);
        com.baidu.adp.base.e<?> ad = i.ad(context);
        if (ad instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ad;
        }
        MessageManager.getInstance().registerListener(this.dXw);
        com.baidu.tbadk.core.bigday.b.tv().am(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.hv().ax("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.tv().bD(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.dXd);
        ((FrameLayout.LayoutParams) this.dXd.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.dXl = new com.baidu.tieba.homepage.personalize.model.e();
        this.dXh = new l(context, this.dUw);
        this.dXh.b(this.dXl);
        this.dXj = new d(this.pageContext, this.dUw, this.dXh, this.dXd);
        this.dXk = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dnF);
        this.dXp = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(Context context) {
        if (this.dXn == null) {
            this.dXn = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.f(context, d.e.tbds200), com.baidu.adp.lib.util.l.f(context, d.e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.f(context, d.e.tbds200);
            addView(this.dXn, layoutParams);
            this.dXn.setVisibility(8);
            this.dXn.setPageId(this.pageContext.getUniqueId());
            this.dog = new com.baidu.tieba.c.c(this.pageContext, this.dXn, 1);
        }
    }

    public void aEg() {
        if (this.dXg != null) {
            this.dXg.a(this.dXs);
            this.dXg.a(this.dXt);
            this.dXg.a(this.dXu);
        }
    }

    public void ayj() {
        this.dXh.a(this.dXq);
        this.dXj.a(this.dXr);
        this.dXk.a(this);
        aEg();
        this.dUw.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.Tn();
            }
        });
        this.dUw.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.dXm >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    PersonalizePageView.this.dXj.aS(i, i2);
                }
            }
        }, 1L);
        this.dUw.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.dXj != null && PersonalizePageView.this.dXj.avc() != null) {
                        PersonalizePageView.this.dXj.avc().aT(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).ajz().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dXi = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bvA != null) {
            this.bvA.Ay();
            this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dXj.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.dXj != null) {
            this.dXj.gN(!z);
        }
        this.dXo = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.dXo;
    }

    public void e(Long l) {
        this.dXj.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.dXd != null && this.dXd.getLayoutParams() != null) {
            if (this.dXj != null) {
                this.dXj.setHeaderViewHeight(i);
            }
            if (this.dXk != null) {
                this.dXk.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dXj != null) {
            this.dXj.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.dXj != null) {
            this.dXj.showFloatingView();
        }
    }

    public void aEh() {
        if (this.dXj != null) {
            this.dXj.aEh();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.brt != null) {
                this.brt.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.j(this.dXd, d.C0140d.cp_bg_line_e);
            if (this.dXf != null) {
                this.dXf.dC(i);
            }
            if (this.bvA != null) {
                this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
                this.bvA.dC(i);
            }
            this.dXh.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void W(String str, int i) {
        if (this.bvA != null) {
            this.bvA.Ay();
            this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dXj.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.dXj != null) {
                        PersonalizePageView.this.dXj.update();
                    }
                }
            });
        }
        this.refreshView.fh(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.hk(str);
        this.refreshView.c(view, z);
        this.refreshView.Jk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uk() {
        if (this.refreshView != null) {
            this.refreshView.Q(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.brt != null) {
            this.brt.Q(this);
            this.brt = null;
            this.dUw.setNextPage(this.bvA);
        }
        if (this.dXd != null) {
            this.dXd.setVisibility(0);
        }
        if (this.dXi != null) {
            this.dXi.aDL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDj() {
        if (this.refreshView != null) {
            return this.refreshView.Jc();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.brt == null) {
            if (i < 0) {
                this.brt = new f(getContext());
            } else {
                this.brt = new f(getContext(), i);
            }
            this.brt.onChangeSkinType();
        }
        this.brt.c(this, z);
        this.dUw.setNextPage(null);
        if (this.dXd != null) {
            this.dXd.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dXj != null) {
            this.dXj.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.dog != null) {
            this.dog.akH();
        }
        setViewForeground(false);
        if (this.dXj != null) {
            this.dXj.fJ(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.dXp < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.in().postDelayed(this.dXv, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dXj != null) {
            this.dXj.gH(z);
        }
    }

    public void aDT() {
        if (this.dXj != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dXj.update();
        }
        if (com.baidu.adp.lib.b.d.hv().ax("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.tv().tx();
            com.baidu.tbadk.core.bigday.b.tv().tw();
        }
    }

    public void reload() {
        if (this.dUw != null && this.dXd != null) {
            showFloatingView();
            this.dUw.setSelection(0);
            if (!this.dXd.isRefreshing()) {
                if (this.dXj != null && this.dXj.avc() != null) {
                    this.dXj.avc().aFD();
                    this.dXj.gP(false);
                }
                this.dXd.setRefreshing(true);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dnF);
        MessageManager.getInstance().unRegisterListener(this.dXw);
        this.dXj.onDestroy();
        this.dXh.a((NEGFeedBackView.a) null);
        this.dXj.a((d.a) null);
        if (this.dXe != null) {
            this.dXe.a((g.b) null);
            this.dXe.a((g.c) null);
            this.dXe.a((g.a) null);
            this.dXe.release();
        }
        if (this.dXf != null) {
            this.dXf.a((g.b) null);
            this.dXf.a((g.c) null);
            this.dXf.a((g.a) null);
            this.dXf.release();
        }
        this.dUw.setOnSrollToBottomListener(null);
        if (this.brt != null) {
            this.brt.release();
        }
        this.dUw.setRecyclerListener(null);
        if (this.dXk != null) {
            this.dXk.onDestroy();
        }
        if (this.dog != null) {
            this.dog.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.tv().destroy();
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.dXv);
    }

    public void onPause() {
        this.dXj.onPause();
    }

    public void onResume() {
        if (this.dmY) {
            reload();
            this.dmY = false;
        }
        if (this.dXd != null) {
            this.dXd.resume();
        }
    }

    public void aEi() {
        if (this.dXh != null) {
            this.dXh.notifyDataSetChanged();
        }
    }

    public void aDl() {
        if (this.dXj != null) {
            this.dXj.fJ(true);
        }
        v.aiY().cK(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.dXv);
    }

    public void aEe() {
        this.dXj.aEs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tn() {
        com.baidu.tieba.homepage.framework.a.aDK().h(System.currentTimeMillis(), 1);
        if (this.bvA != null && !this.bvA.AE()) {
            this.bvA.Ax();
            this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dXj.Tn();
    }
}
