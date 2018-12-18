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
    private final CustomMessageListener aPU;
    private com.baidu.tbadk.k.f bKv;
    private PbListView bOy;
    private boolean dIK;
    private com.baidu.tieba.c.c dJS;
    private CustomMessageListener dJs;
    private View.OnClickListener eqn;
    private BdTypeRecyclerView erT;
    private BigdaySwipeRefreshLayout euC;
    private com.baidu.tieba.homepage.personalize.bigday.b euD;
    private com.baidu.tieba.homepage.personalize.bigday.a euE;
    private a euF;
    private l euG;
    private com.baidu.tieba.homepage.framework.b euH;
    private e euI;
    private com.baidu.tieba.homepage.personalize.a euJ;
    private com.baidu.tieba.homepage.personalize.model.e euK;
    private long euL;
    private FloatingAnimationView euM;
    private boolean euN;
    private int euO;
    private NEGFeedBackView.a euP;
    private e.a euQ;
    j.b euR;
    j.c euS;
    j.a euT;
    private Runnable euU;
    public CustomMessageListener euV;
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
        int i = personalizePageView.euO + 1;
        personalizePageView.euO = i;
        return i;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.euI != null) {
            this.euI.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.euJ != null) {
            this.euJ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.euC != null) {
            this.euC.ph();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.euG != null) {
            this.euG.setPageUniqueId(bdUniqueId);
        }
        if (this.euI != null) {
            this.euI.j(bdUniqueId);
        }
        if (this.euK != null) {
            this.euK.m(bdUniqueId);
        }
        if (this.euE != null) {
            this.euE.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.xS().setTag(bdUniqueId);
        if (this.aPU != null) {
            this.aPU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aPU);
        }
        if (this.euJ != null) {
            this.euJ.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        m mVar = new m();
        mVar.vG(String.valueOf(floatInfo.activity_id));
        mVar.dN(floatInfo.dynamic_url);
        mVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        mVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        mVar.vF(floatInfo.float_url);
        mVar.vE(floatInfo.jump_url);
        mVar.setType(floatInfo.show_type.intValue());
        return mVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.euL = 0L;
        this.mSkinType = 3;
        this.dIK = false;
        this.euN = false;
        this.euO = 0;
        this.euP = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.euQ = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.euH == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aKa = PersonalizePageView.this.aKa();
                PersonalizePageView.this.aaY();
                if (aKa) {
                    PersonalizePageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                PersonalizePageView.this.euH.G(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void s(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.euH != null) {
                    PersonalizePageView.this.euH.r(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.euC.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.euC.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aaY();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.euI.aLm());
                PersonalizePageView.this.ct(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dJS != null) {
                    PersonalizePageView.this.dJS.a(a2);
                }
            }
        };
        this.euR = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                com.baidu.tieba.a.d.VM().jJ("page_recommend");
                PersonalizePageView.this.euI.update();
            }
        };
        this.euS = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bI(boolean z) {
                if (PersonalizePageView.this.euI != null) {
                    if (PersonalizePageView.this.euI.aBx() != null) {
                        PersonalizePageView.this.euI.aBx().aMw();
                    }
                    PersonalizePageView.this.euI.hS(false);
                }
            }
        };
        this.euT = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.euI != null) {
                    PersonalizePageView.this.euI.hS(true);
                    PersonalizePageView.this.euI.aLf();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.xS().cA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.euU = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aPU = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.aLa();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.eqn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aab();
            }
        };
        this.dJs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dIK = true;
                    }
                }
            }
        };
        this.euV = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.euC != null && !PersonalizePageView.this.euC.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.euE == null) {
                            PersonalizePageView.this.euE = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.euE.ey(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.euF = PersonalizePageView.this.euE;
                            PersonalizePageView.this.aKY();
                        } else if (PersonalizePageView.this.euF != PersonalizePageView.this.euE) {
                            PersonalizePageView.this.euF = PersonalizePageView.this.euE;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.euE.setEnable(true);
                        PersonalizePageView.this.euC.setProgressView(PersonalizePageView.this.euE);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.euC.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.euD == null) {
                        PersonalizePageView.this.euD = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.euF = PersonalizePageView.this.euD;
                        PersonalizePageView.this.aKY();
                    } else if (PersonalizePageView.this.euF != PersonalizePageView.this.euD || !aVar.equals(PersonalizePageView.this.euD.aLw())) {
                        PersonalizePageView.this.euF = PersonalizePageView.this.euD;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.euD.setEnable(true);
                    PersonalizePageView.this.euC.setProgressView(PersonalizePageView.this.euD);
                    PersonalizePageView.this.euD.a(aVar);
                    PersonalizePageView.this.euC.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0210e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.euL = 0L;
        this.mSkinType = 3;
        this.dIK = false;
        this.euN = false;
        this.euO = 0;
        this.euP = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.euQ = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.euH == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aKa = PersonalizePageView.this.aKa();
                PersonalizePageView.this.aaY();
                if (aKa) {
                    PersonalizePageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                PersonalizePageView.this.euH.G(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void s(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.euH != null) {
                    PersonalizePageView.this.euH.r(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.euC.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.euC.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aaY();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.euI.aLm());
                PersonalizePageView.this.ct(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dJS != null) {
                    PersonalizePageView.this.dJS.a(a2);
                }
            }
        };
        this.euR = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                com.baidu.tieba.a.d.VM().jJ("page_recommend");
                PersonalizePageView.this.euI.update();
            }
        };
        this.euS = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bI(boolean z) {
                if (PersonalizePageView.this.euI != null) {
                    if (PersonalizePageView.this.euI.aBx() != null) {
                        PersonalizePageView.this.euI.aBx().aMw();
                    }
                    PersonalizePageView.this.euI.hS(false);
                }
            }
        };
        this.euT = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.euI != null) {
                    PersonalizePageView.this.euI.hS(true);
                    PersonalizePageView.this.euI.aLf();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.xS().cA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.euU = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aPU = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.aLa();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.eqn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aab();
            }
        };
        this.dJs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dIK = true;
                    }
                }
            }
        };
        this.euV = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.euC != null && !PersonalizePageView.this.euC.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.euE == null) {
                            PersonalizePageView.this.euE = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.euE.ey(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.euF = PersonalizePageView.this.euE;
                            PersonalizePageView.this.aKY();
                        } else if (PersonalizePageView.this.euF != PersonalizePageView.this.euE) {
                            PersonalizePageView.this.euF = PersonalizePageView.this.euE;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.euE.setEnable(true);
                        PersonalizePageView.this.euC.setProgressView(PersonalizePageView.this.euE);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.euC.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.euD == null) {
                        PersonalizePageView.this.euD = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.euF = PersonalizePageView.this.euD;
                        PersonalizePageView.this.aKY();
                    } else if (PersonalizePageView.this.euF != PersonalizePageView.this.euD || !aVar.equals(PersonalizePageView.this.euD.aLw())) {
                        PersonalizePageView.this.euF = PersonalizePageView.this.euD;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.euD.setEnable(true);
                    PersonalizePageView.this.euC.setProgressView(PersonalizePageView.this.euD);
                    PersonalizePageView.this.euD.a(aVar);
                    PersonalizePageView.this.euC.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0210e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.euL = 0L;
        this.mSkinType = 3;
        this.dIK = false;
        this.euN = false;
        this.euO = 0;
        this.euP = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.euQ = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i2, int i22, int i3) {
                if (PersonalizePageView.this.euH == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aKa = PersonalizePageView.this.aKa();
                PersonalizePageView.this.aaY();
                if (aKa) {
                    PersonalizePageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                PersonalizePageView.this.euH.G(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void s(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.euH != null) {
                    PersonalizePageView.this.euH.r(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.euC.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.euC.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aaY();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.euI.aLm());
                PersonalizePageView.this.ct(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dJS != null) {
                    PersonalizePageView.this.dJS.a(a2);
                }
            }
        };
        this.euR = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                com.baidu.tieba.a.d.VM().jJ("page_recommend");
                PersonalizePageView.this.euI.update();
            }
        };
        this.euS = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bI(boolean z) {
                if (PersonalizePageView.this.euI != null) {
                    if (PersonalizePageView.this.euI.aBx() != null) {
                        PersonalizePageView.this.euI.aBx().aMw();
                    }
                    PersonalizePageView.this.euI.hS(false);
                }
            }
        };
        this.euT = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.euI != null) {
                    PersonalizePageView.this.euI.hS(true);
                    PersonalizePageView.this.euI.aLf();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.xS().cA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.euU = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aPU = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.aLa();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.eqn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aab();
            }
        };
        this.dJs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dIK = true;
                    }
                }
            }
        };
        this.euV = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.euC != null && !PersonalizePageView.this.euC.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.euE == null) {
                            PersonalizePageView.this.euE = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.euE.ey(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.euF = PersonalizePageView.this.euE;
                            PersonalizePageView.this.aKY();
                        } else if (PersonalizePageView.this.euF != PersonalizePageView.this.euE) {
                            PersonalizePageView.this.euF = PersonalizePageView.this.euE;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.euE.setEnable(true);
                        PersonalizePageView.this.euC.setProgressView(PersonalizePageView.this.euE);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.euC.setCustomDistances(i2, i2, i2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.euD == null) {
                        PersonalizePageView.this.euD = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.euF = PersonalizePageView.this.euD;
                        PersonalizePageView.this.aKY();
                    } else if (PersonalizePageView.this.euF != PersonalizePageView.this.euD || !aVar.equals(PersonalizePageView.this.euD.aLw())) {
                        PersonalizePageView.this.euF = PersonalizePageView.this.euD;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.euD.setEnable(true);
                    PersonalizePageView.this.euC.setProgressView(PersonalizePageView.this.euD);
                    PersonalizePageView.this.euD.a(aVar);
                    PersonalizePageView.this.euC.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0210e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.erT = new BdTypeRecyclerView(context);
        this.erT.setLayoutManager(new LinearLayoutManager(this.erT.getContext()));
        this.erT.setFadingEdgeLength(0);
        this.erT.setOverScrollMode(2);
        this.euC = new BigdaySwipeRefreshLayout(context);
        this.euC.addView(this.erT);
        this.bOy = new PbListView(context);
        this.bOy.getView();
        this.bOy.ex(e.d.cp_bg_line_e);
        this.bOy.EZ();
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOy.setTextSize(e.C0210e.tbfontsize33);
        this.bOy.ew(e.d.cp_cont_e);
        this.bOy.setHeight(com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds182));
        this.bOy.setOnClickListener(this.eqn);
        this.erT.setNextPage(this.bOy);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        MessageManager.getInstance().registerListener(this.euV);
        com.baidu.tbadk.core.bigday.b.xS().aX(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.xS().cA(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.euC);
        ((FrameLayout.LayoutParams) this.euC.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.euK = new com.baidu.tieba.homepage.personalize.model.e();
        this.euG = new l(context, this.erT);
        this.euG.b(this.euK);
        this.euI = new e(this.pageContext, this.erT, this.euG, this.euC);
        this.euJ = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dJs);
        this.euO = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(Context context) {
        if (this.euM == null) {
            this.euM = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds200), com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds200);
            addView(this.euM, layoutParams);
            this.euM.setVisibility(8);
            this.euM.setPageId(this.pageContext.getUniqueId());
            this.dJS = new com.baidu.tieba.c.c(this.pageContext, this.euM, 1);
        }
    }

    public void aKY() {
        if (this.euF != null) {
            this.euF.a(this.euR);
            this.euF.a(this.euS);
            this.euF.a(this.euT);
        }
    }

    public void aEW() {
        this.euG.a(this.euP);
        this.euI.a(this.euQ);
        this.euJ.a(this);
        aKY();
        this.erT.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aab();
            }
        });
        this.erT.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.euL >= 5000) {
                    PersonalizePageView.this.euI.aZ(i, i2);
                }
            }
        }, 1L);
        this.erT.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.euI != null && PersonalizePageView.this.euI.aBx() != null) {
                        PersonalizePageView.this.euI.aBx().bj(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).aqe().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.euH = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bOy != null) {
            this.bOy.Fd();
            this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.euI.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.euI != null) {
            this.euI.hP(!z);
        }
        this.euN = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.euN;
    }

    public void g(Long l) {
        this.euI.g(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.euC != null && this.euC.getLayoutParams() != null) {
            if (this.euI != null) {
                this.euI.setHeaderViewHeight(i);
            }
            if (this.euJ != null) {
                this.euJ.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.euI != null) {
            this.euI.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    public void showFloatingView() {
        if (this.euI != null) {
            this.euI.showFloatingView();
        }
    }

    public void aKZ() {
        if (this.euI != null) {
            this.euI.aKZ();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bKv != null) {
                this.bKv.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            al.j(this.euC, e.d.cp_bg_line_e);
            if (this.euE != null) {
                this.euE.ey(i);
            }
            if (this.bOy != null) {
                this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bOy.ey(i);
            }
            this.euG.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void ag(String str, int i) {
        if (this.bOy != null) {
            this.bOy.Fd();
            this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.euI.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.euI != null) {
                        PersonalizePageView.this.euI.update();
                    }
                }
            });
        }
        this.refreshView.gd(getContext().getResources().getDimensionPixelSize(e.C0210e.ds280));
        this.refreshView.in(str);
        this.refreshView.attachView(view, z);
        this.refreshView.NL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaY() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.bKv != null) {
            this.bKv.dettachView(this);
            this.bKv = null;
            this.erT.setNextPage(this.bOy);
        }
        if (this.euC != null) {
            this.euC.setVisibility(0);
        }
        if (this.euH != null) {
            this.euH.aKC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aKa() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.bKv == null) {
            if (i < 0) {
                this.bKv = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.bKv = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.bKv.onChangeSkinType();
        }
        this.bKv.attachView(this, z);
        this.erT.setNextPage(null);
        if (this.euC != null) {
            this.euC.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.euI != null) {
            this.euI.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.dJS != null) {
            this.dJS.arh();
        }
        setViewForeground(false);
        if (this.euI != null) {
            this.euI.gD(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.euO < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.euU, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.euI != null) {
            this.euI.hJ(z);
        }
    }

    public void aKK() {
        if (this.euI != null) {
            i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
            this.euI.update();
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.xS().xU();
            com.baidu.tbadk.core.bigday.b.xS().xT();
        }
    }

    public void reload() {
        if (this.erT != null && this.euC != null) {
            showFloatingView();
            this.erT.setSelection(0);
            if (!this.euC.isRefreshing()) {
                if (this.euI != null && this.euI.aBx() != null) {
                    this.euI.aBx().aMw();
                    this.euI.hS(false);
                }
                this.euC.setRefreshing(true);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dJs);
        MessageManager.getInstance().unRegisterListener(this.euV);
        this.euI.onDestroy();
        this.euG.a((NEGFeedBackView.a) null);
        this.euI.a((e.a) null);
        if (this.euD != null) {
            this.euD.a((j.b) null);
            this.euD.a((j.c) null);
            this.euD.a((j.a) null);
            this.euD.release();
        }
        if (this.euE != null) {
            this.euE.a((j.b) null);
            this.euE.a((j.c) null);
            this.euE.a((j.a) null);
            this.euE.release();
        }
        this.erT.setOnSrollToBottomListener(null);
        if (this.bKv != null) {
            this.bKv.release();
        }
        this.erT.setRecyclerListener(null);
        if (this.euJ != null) {
            this.euJ.onDestroy();
        }
        if (this.dJS != null) {
            this.dJS.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.xS().destroy();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.euU);
    }

    public void onPause() {
        this.euI.onPause();
    }

    public void onResume() {
        if (this.dIK) {
            reload();
            this.dIK = false;
        }
        if (this.euC != null) {
            this.euC.resume();
        }
    }

    public void aLa() {
        if (this.euG != null) {
            this.euG.notifyDataSetChanged();
        }
    }

    public void aKc() {
        if (this.euI != null) {
            this.euI.gD(true);
        }
        v.apD().dQ(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.euU);
    }

    public void aKV() {
        this.euI.aLl();
    }

    public void aLb() {
        this.euI.aLb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        com.baidu.tieba.homepage.framework.a.aKB().k(System.currentTimeMillis(), 1);
        if (this.bOy != null && !this.bOy.Fi()) {
            this.bOy.Fc();
            this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.euI.aab();
    }
}
