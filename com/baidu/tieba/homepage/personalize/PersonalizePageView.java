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
import com.baidu.tieba.f;
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
    private final CustomMessageListener aDW;
    private f brv;
    private PbListView bvC;
    private View.OnClickListener dSO;
    private BdTypeRecyclerView dUr;
    private BigdaySwipeRefreshLayout dXa;
    private com.baidu.tieba.homepage.personalize.bigday.b dXb;
    private com.baidu.tieba.homepage.personalize.bigday.a dXc;
    private a dXd;
    private l dXe;
    private com.baidu.tieba.homepage.framework.b dXf;
    private d dXg;
    private com.baidu.tieba.homepage.personalize.a dXh;
    private com.baidu.tieba.homepage.personalize.model.e dXi;
    private long dXj;
    private FloatingAnimationView dXk;
    private boolean dXl;
    private int dXm;
    private NEGFeedBackView.a dXn;
    private d.a dXo;
    g.b dXp;
    g.c dXq;
    g.a dXr;
    private Runnable dXs;
    public CustomMessageListener dXt;
    private boolean dmW;
    private CustomMessageListener dnD;
    private com.baidu.tieba.c.c doe;
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
        int i = personalizePageView.dXm + 1;
        personalizePageView.dXm = i;
        return i;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dXg != null) {
            this.dXg.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.dXh != null) {
            this.dXh.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.dXa != null) {
            this.dXa.nW();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dXe != null) {
            this.dXe.setPageUniqueId(bdUniqueId);
        }
        if (this.dXg != null) {
            this.dXg.j(bdUniqueId);
        }
        if (this.dXi != null) {
            this.dXi.m(bdUniqueId);
        }
        if (this.dXc != null) {
            this.dXc.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.tu().setTag(bdUniqueId);
        if (this.aDW != null) {
            this.aDW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aDW);
        }
        if (this.dXh != null) {
            this.dXh.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        m mVar = new m();
        mVar.tR(String.valueOf(floatInfo.activity_id));
        mVar.dw(floatInfo.dynamic_url);
        mVar.cT(floatInfo.end_time.longValue() * 1000);
        mVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        mVar.tQ(floatInfo.float_url);
        mVar.tP(floatInfo.jump_url);
        mVar.setType(floatInfo.show_type.intValue());
        return mVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.dXj = 0L;
        this.mSkinType = 3;
        this.dmW = false;
        this.dXl = false;
        this.dXm = 0;
        this.dXn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new an("c11693").ae("obj_locate", "1").ae(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ae("tid", ahVar.getTid()).ae("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").ae(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ae("tid", ahVar.getTid()).ae("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11693").ae("obj_locate", sb.toString()).ae(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ae("tid", ahVar.getTid()).ae("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dXo = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aR(int i, int i2) {
                if (PersonalizePageView.this.dXf == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(f.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aDg = PersonalizePageView.this.aDg();
                PersonalizePageView.this.Un();
                if (aDg) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds520));
                }
                PersonalizePageView.this.dXf.aQ(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dXf != null) {
                    PersonalizePageView.this.dXf.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.dXa.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.jE()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dXa.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Un();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.dXg.aEq());
                PersonalizePageView.this.bA(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.doe != null) {
                    PersonalizePageView.this.doe.a(a2);
                }
            }
        };
        this.dXp = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                com.baidu.tieba.a.d.QN().iA("page_recommend");
                PersonalizePageView.this.dXg.update();
            }
        };
        this.dXq = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.g.c
            public void aU(boolean z) {
                if (PersonalizePageView.this.dXg != null) {
                    if (PersonalizePageView.this.dXg.avb() != null) {
                        PersonalizePageView.this.dXg.avb().aFA();
                    }
                    PersonalizePageView.this.dXg.gP(false);
                }
            }
        };
        this.dXr = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.dXg != null) {
                    PersonalizePageView.this.dXg.gP(true);
                    PersonalizePageView.this.dXg.aEj();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hv().ax("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.tu().bD(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.dXs = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aDW = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.aEf();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dSO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.Tq();
            }
        };
        this.dnD = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dmW = true;
                    }
                }
            }
        };
        this.dXt = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.dXa != null && !PersonalizePageView.this.dXa.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.dXc == null) {
                            PersonalizePageView.this.dXc = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.dXc.dB(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.dXd = PersonalizePageView.this.dXc;
                            PersonalizePageView.this.aEd();
                        } else if (PersonalizePageView.this.dXd != PersonalizePageView.this.dXc) {
                            PersonalizePageView.this.dXd = PersonalizePageView.this.dXc;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.dXc.setEnable(true);
                        PersonalizePageView.this.dXa.setProgressView(PersonalizePageView.this.dXc);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.dXa.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.dXb == null) {
                        PersonalizePageView.this.dXb = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.dXd = PersonalizePageView.this.dXb;
                        PersonalizePageView.this.aEd();
                    } else if (PersonalizePageView.this.dXd != PersonalizePageView.this.dXb || !aVar.equals(PersonalizePageView.this.dXb.aEA())) {
                        PersonalizePageView.this.dXd = PersonalizePageView.this.dXb;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.dXb.setEnable(true);
                    PersonalizePageView.this.dXa.setProgressView(PersonalizePageView.this.dXb);
                    PersonalizePageView.this.dXb.a(aVar);
                    PersonalizePageView.this.dXa.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(f.e.tbds236), (int) (com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXj = 0L;
        this.mSkinType = 3;
        this.dmW = false;
        this.dXl = false;
        this.dXm = 0;
        this.dXn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new an("c11693").ae("obj_locate", "1").ae(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ae("tid", ahVar.getTid()).ae("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").ae(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ae("tid", ahVar.getTid()).ae("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11693").ae("obj_locate", sb.toString()).ae(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ae("tid", ahVar.getTid()).ae("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dXo = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aR(int i, int i2) {
                if (PersonalizePageView.this.dXf == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(f.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aDg = PersonalizePageView.this.aDg();
                PersonalizePageView.this.Un();
                if (aDg) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds520));
                }
                PersonalizePageView.this.dXf.aQ(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dXf != null) {
                    PersonalizePageView.this.dXf.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.dXa.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.jE()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dXa.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Un();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.dXg.aEq());
                PersonalizePageView.this.bA(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.doe != null) {
                    PersonalizePageView.this.doe.a(a2);
                }
            }
        };
        this.dXp = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                com.baidu.tieba.a.d.QN().iA("page_recommend");
                PersonalizePageView.this.dXg.update();
            }
        };
        this.dXq = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.g.c
            public void aU(boolean z) {
                if (PersonalizePageView.this.dXg != null) {
                    if (PersonalizePageView.this.dXg.avb() != null) {
                        PersonalizePageView.this.dXg.avb().aFA();
                    }
                    PersonalizePageView.this.dXg.gP(false);
                }
            }
        };
        this.dXr = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.dXg != null) {
                    PersonalizePageView.this.dXg.gP(true);
                    PersonalizePageView.this.dXg.aEj();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hv().ax("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.tu().bD(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.dXs = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aDW = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.aEf();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dSO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.Tq();
            }
        };
        this.dnD = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dmW = true;
                    }
                }
            }
        };
        this.dXt = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.dXa != null && !PersonalizePageView.this.dXa.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.dXc == null) {
                            PersonalizePageView.this.dXc = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.dXc.dB(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.dXd = PersonalizePageView.this.dXc;
                            PersonalizePageView.this.aEd();
                        } else if (PersonalizePageView.this.dXd != PersonalizePageView.this.dXc) {
                            PersonalizePageView.this.dXd = PersonalizePageView.this.dXc;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.dXc.setEnable(true);
                        PersonalizePageView.this.dXa.setProgressView(PersonalizePageView.this.dXc);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.dXa.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.dXb == null) {
                        PersonalizePageView.this.dXb = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.dXd = PersonalizePageView.this.dXb;
                        PersonalizePageView.this.aEd();
                    } else if (PersonalizePageView.this.dXd != PersonalizePageView.this.dXb || !aVar.equals(PersonalizePageView.this.dXb.aEA())) {
                        PersonalizePageView.this.dXd = PersonalizePageView.this.dXb;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.dXb.setEnable(true);
                    PersonalizePageView.this.dXa.setProgressView(PersonalizePageView.this.dXb);
                    PersonalizePageView.this.dXb.a(aVar);
                    PersonalizePageView.this.dXa.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(f.e.tbds236), (int) (com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dXj = 0L;
        this.mSkinType = 3;
        this.dmW = false;
        this.dXl = false;
        this.dXm = 0;
        this.dXn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new an("c11693").ae("obj_locate", "1").ae(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ae("tid", ahVar.getTid()).ae("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").ae(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ae("tid", ahVar.getTid()).ae("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11693").ae("obj_locate", sb.toString()).ae(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ae("tid", ahVar.getTid()).ae("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dXo = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aR(int i2, int i22) {
                if (PersonalizePageView.this.dXf == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(f.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aDg = PersonalizePageView.this.aDg();
                PersonalizePageView.this.Un();
                if (aDg) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds520));
                }
                PersonalizePageView.this.dXf.aQ(i2, i22);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i2, int i22, int i3) {
                if (PersonalizePageView.this.dXf != null) {
                    PersonalizePageView.this.dXf.B(i2, i22, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.dXa.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.jE()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dXa.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Un();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.dXg.aEq());
                PersonalizePageView.this.bA(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.doe != null) {
                    PersonalizePageView.this.doe.a(a2);
                }
            }
        };
        this.dXp = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                com.baidu.tieba.a.d.QN().iA("page_recommend");
                PersonalizePageView.this.dXg.update();
            }
        };
        this.dXq = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.g.c
            public void aU(boolean z) {
                if (PersonalizePageView.this.dXg != null) {
                    if (PersonalizePageView.this.dXg.avb() != null) {
                        PersonalizePageView.this.dXg.avb().aFA();
                    }
                    PersonalizePageView.this.dXg.gP(false);
                }
            }
        };
        this.dXr = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.dXg != null) {
                    PersonalizePageView.this.dXg.gP(true);
                    PersonalizePageView.this.dXg.aEj();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hv().ax("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.tu().bD(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.dXs = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aDW = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.aEf();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dSO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.Tq();
            }
        };
        this.dnD = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dmW = true;
                    }
                }
            }
        };
        this.dXt = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.dXa != null && !PersonalizePageView.this.dXa.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.dXc == null) {
                            PersonalizePageView.this.dXc = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.dXc.dB(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.dXd = PersonalizePageView.this.dXc;
                            PersonalizePageView.this.aEd();
                        } else if (PersonalizePageView.this.dXd != PersonalizePageView.this.dXc) {
                            PersonalizePageView.this.dXd = PersonalizePageView.this.dXc;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.dXc.setEnable(true);
                        PersonalizePageView.this.dXa.setProgressView(PersonalizePageView.this.dXc);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.dXa.setCustomDistances(i2, i2, i2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.dXb == null) {
                        PersonalizePageView.this.dXb = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.dXd = PersonalizePageView.this.dXb;
                        PersonalizePageView.this.aEd();
                    } else if (PersonalizePageView.this.dXd != PersonalizePageView.this.dXb || !aVar.equals(PersonalizePageView.this.dXb.aEA())) {
                        PersonalizePageView.this.dXd = PersonalizePageView.this.dXb;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.dXb.setEnable(true);
                    PersonalizePageView.this.dXa.setProgressView(PersonalizePageView.this.dXb);
                    PersonalizePageView.this.dXb.a(aVar);
                    PersonalizePageView.this.dXa.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(f.e.tbds236), (int) (com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dUr = new BdTypeRecyclerView(context);
        this.dUr.setLayoutManager(new LinearLayoutManager(this.dUr.getContext()));
        this.dUr.setFadingEdgeLength(0);
        this.dUr.setOverScrollMode(2);
        this.dXa = new BigdaySwipeRefreshLayout(context);
        this.dXa.addView(this.dUr);
        this.bvC = new PbListView(context);
        this.bvC.getView();
        this.bvC.dA(f.d.cp_bg_line_e);
        this.bvC.As();
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_j));
        this.bvC.setTextSize(f.e.tbfontsize33);
        this.bvC.dz(f.d.cp_cont_e);
        this.bvC.setHeight(com.baidu.adp.lib.util.l.f(context, f.e.tbds182));
        this.bvC.setOnClickListener(this.dSO);
        this.dUr.setNextPage(this.bvC);
        com.baidu.adp.base.e<?> ad = i.ad(context);
        if (ad instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ad;
        }
        MessageManager.getInstance().registerListener(this.dXt);
        com.baidu.tbadk.core.bigday.b.tu().an(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.hv().ax("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.tu().bD(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.dXa);
        ((FrameLayout.LayoutParams) this.dXa.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.dXi = new com.baidu.tieba.homepage.personalize.model.e();
        this.dXe = new l(context, this.dUr);
        this.dXe.b(this.dXi);
        this.dXg = new d(this.pageContext, this.dUr, this.dXe, this.dXa);
        this.dXh = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dnD);
        this.dXm = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(Context context) {
        if (this.dXk == null) {
            this.dXk = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.f(context, f.e.tbds200), com.baidu.adp.lib.util.l.f(context, f.e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.f(context, f.e.tbds200);
            addView(this.dXk, layoutParams);
            this.dXk.setVisibility(8);
            this.dXk.setPageId(this.pageContext.getUniqueId());
            this.doe = new com.baidu.tieba.c.c(this.pageContext, this.dXk, 1);
        }
    }

    public void aEd() {
        if (this.dXd != null) {
            this.dXd.a(this.dXp);
            this.dXd.a(this.dXq);
            this.dXd.a(this.dXr);
        }
    }

    public void ayh() {
        this.dXe.a(this.dXn);
        this.dXg.a(this.dXo);
        this.dXh.a(this);
        aEd();
        this.dUr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.Tq();
            }
        });
        this.dUr.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.dXj >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    PersonalizePageView.this.dXg.aS(i, i2);
                }
            }
        }, 1L);
        this.dUr.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.dXg != null && PersonalizePageView.this.dXg.avb() != null) {
                        PersonalizePageView.this.dXg.avb().aT(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).ajC().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dXf = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bvC != null) {
            this.bvC.Aw();
            this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dXg.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.dXg != null) {
            this.dXg.gN(!z);
        }
        this.dXl = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.dXl;
    }

    public void e(Long l) {
        this.dXg.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.dXa != null && this.dXa.getLayoutParams() != null) {
            if (this.dXg != null) {
                this.dXg.setHeaderViewHeight(i);
            }
            if (this.dXh != null) {
                this.dXh.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dXg != null) {
            this.dXg.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.dXg != null) {
            this.dXg.showFloatingView();
        }
    }

    public void aEe() {
        if (this.dXg != null) {
            this.dXg.aEe();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.brv != null) {
                this.brv.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.j(this.dXa, f.d.cp_bg_line_e);
            if (this.dXc != null) {
                this.dXc.dB(i);
            }
            if (this.bvC != null) {
                this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
                this.bvC.dB(i);
            }
            this.dXe.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void W(String str, int i) {
        if (this.bvC != null) {
            this.bvC.Aw();
            this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dXg.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.dXg != null) {
                        PersonalizePageView.this.dXg.update();
                    }
                }
            });
        }
        this.refreshView.fg(getContext().getResources().getDimensionPixelSize(f.e.ds280));
        this.refreshView.hk(str);
        this.refreshView.c(view, z);
        this.refreshView.Jk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Un() {
        if (this.refreshView != null) {
            this.refreshView.Q(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.brv != null) {
            this.brv.Q(this);
            this.brv = null;
            this.dUr.setNextPage(this.bvC);
        }
        if (this.dXa != null) {
            this.dXa.setVisibility(0);
        }
        if (this.dXf != null) {
            this.dXf.aDI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDg() {
        if (this.refreshView != null) {
            return this.refreshView.Jc();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.brv == null) {
            if (i < 0) {
                this.brv = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.brv = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.brv.onChangeSkinType();
        }
        this.brv.c(this, z);
        this.dUr.setNextPage(null);
        if (this.dXa != null) {
            this.dXa.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dXg != null) {
            this.dXg.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.doe != null) {
            this.doe.akJ();
        }
        setViewForeground(false);
        if (this.dXg != null) {
            this.dXg.fJ(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.dXm < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.in().postDelayed(this.dXs, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dXg != null) {
            this.dXg.gH(z);
        }
    }

    public void aDQ() {
        if (this.dXg != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds520));
            this.dXg.update();
        }
        if (com.baidu.adp.lib.b.d.hv().ax("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.tu().tw();
            com.baidu.tbadk.core.bigday.b.tu().tv();
        }
    }

    public void reload() {
        if (this.dUr != null && this.dXa != null) {
            showFloatingView();
            this.dUr.setSelection(0);
            if (!this.dXa.isRefreshing()) {
                if (this.dXg != null && this.dXg.avb() != null) {
                    this.dXg.avb().aFA();
                    this.dXg.gP(false);
                }
                this.dXa.setRefreshing(true);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dnD);
        MessageManager.getInstance().unRegisterListener(this.dXt);
        this.dXg.onDestroy();
        this.dXe.a((NEGFeedBackView.a) null);
        this.dXg.a((d.a) null);
        if (this.dXb != null) {
            this.dXb.a((g.b) null);
            this.dXb.a((g.c) null);
            this.dXb.a((g.a) null);
            this.dXb.release();
        }
        if (this.dXc != null) {
            this.dXc.a((g.b) null);
            this.dXc.a((g.c) null);
            this.dXc.a((g.a) null);
            this.dXc.release();
        }
        this.dUr.setOnSrollToBottomListener(null);
        if (this.brv != null) {
            this.brv.release();
        }
        this.dUr.setRecyclerListener(null);
        if (this.dXh != null) {
            this.dXh.onDestroy();
        }
        if (this.doe != null) {
            this.doe.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.tu().destroy();
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.dXs);
    }

    public void onPause() {
        this.dXg.onPause();
    }

    public void onResume() {
        if (this.dmW) {
            reload();
            this.dmW = false;
        }
        if (this.dXa != null) {
            this.dXa.resume();
        }
    }

    public void aEf() {
        if (this.dXe != null) {
            this.dXe.notifyDataSetChanged();
        }
    }

    public void aDi() {
        if (this.dXg != null) {
            this.dXg.fJ(true);
        }
        v.ajb().cL(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.dXs);
    }

    public void aEb() {
        this.dXg.aEp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tq() {
        com.baidu.tieba.homepage.framework.a.aDH().h(System.currentTimeMillis(), 1);
        if (this.bvC != null && !this.bvC.AB()) {
            this.bvC.Av();
            this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dXg.Tq();
    }
}
