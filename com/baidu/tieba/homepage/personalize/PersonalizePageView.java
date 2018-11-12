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
    private final CustomMessageListener aMv;
    private com.baidu.tbadk.k.f bGG;
    private PbListView bKJ;
    private CustomMessageListener dCT;
    private boolean dCl;
    private com.baidu.tieba.c.c dDt;
    private View.OnClickListener ejt;
    private BdTypeRecyclerView ekY;
    private BigdaySwipeRefreshLayout enH;
    private com.baidu.tieba.homepage.personalize.bigday.b enI;
    private com.baidu.tieba.homepage.personalize.bigday.a enJ;
    private a enK;
    private l enL;
    private com.baidu.tieba.homepage.framework.b enM;
    private e enN;
    private com.baidu.tieba.homepage.personalize.a enO;
    private com.baidu.tieba.homepage.personalize.model.e enP;
    private long enQ;
    private FloatingAnimationView enR;
    private boolean enS;
    private int enT;
    private NEGFeedBackView.a enU;
    private e.a enV;
    j.b enW;
    j.c enX;
    j.a enY;
    private Runnable enZ;
    public CustomMessageListener eoa;
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
        int i = personalizePageView.enT + 1;
        personalizePageView.enT = i;
        return i;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.enN != null) {
            this.enN.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.enO != null) {
            this.enO.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.enH != null) {
            this.enH.pi();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.enL != null) {
            this.enL.setPageUniqueId(bdUniqueId);
        }
        if (this.enN != null) {
            this.enN.j(bdUniqueId);
        }
        if (this.enP != null) {
            this.enP.m(bdUniqueId);
        }
        if (this.enJ != null) {
            this.enJ.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.wO().setTag(bdUniqueId);
        if (this.aMv != null) {
            this.aMv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aMv);
        }
        if (this.enO != null) {
            this.enO.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        m mVar = new m();
        mVar.vf(String.valueOf(floatInfo.activity_id));
        mVar.dJ(floatInfo.dynamic_url);
        mVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        mVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        mVar.ve(floatInfo.float_url);
        mVar.vd(floatInfo.jump_url);
        mVar.setType(floatInfo.show_type.intValue());
        return mVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.enQ = 0L;
        this.mSkinType = 3;
        this.dCl = false;
        this.enS = false;
        this.enT = 0;
        this.enU = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new am("c11693").ax("obj_locate", "1").ax(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ax("tid", ahVar.getTid()).ax("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").ax(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ax("tid", ahVar.getTid()).ax("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11693").ax("obj_locate", sb.toString()).ax(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ax("tid", ahVar.getTid()).ax("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.enV = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void ba(int i, int i2) {
                if (PersonalizePageView.this.enM == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aIj = PersonalizePageView.this.aIj();
                PersonalizePageView.this.ZS();
                if (aIj) {
                    PersonalizePageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds520));
                }
                PersonalizePageView.this.enM.aZ(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.enM != null) {
                    PersonalizePageView.this.enM.G(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.enH.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.enH.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.ZS();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.enN.aJv());
                PersonalizePageView.this.cp(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dDt != null) {
                    PersonalizePageView.this.dDt.a(a2);
                }
            }
        };
        this.enW = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                com.baidu.tieba.a.d.UG().jr("page_recommend");
                PersonalizePageView.this.enN.update();
            }
        };
        this.enX = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bH(boolean z) {
                if (PersonalizePageView.this.enN != null) {
                    if (PersonalizePageView.this.enN.azN() != null) {
                        PersonalizePageView.this.enN.azN().aKF();
                    }
                    PersonalizePageView.this.enN.hP(false);
                }
            }
        };
        this.enY = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.enN != null) {
                    PersonalizePageView.this.enN.hP(true);
                    PersonalizePageView.this.enN.aJo();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.wO().cm(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.enZ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aMv = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.aJj();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.ejt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.YV();
            }
        };
        this.dCT = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dCl = true;
                    }
                }
            }
        };
        this.eoa = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.enH != null && !PersonalizePageView.this.enH.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.enJ == null) {
                            PersonalizePageView.this.enJ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.enJ.ek(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.enK = PersonalizePageView.this.enJ;
                            PersonalizePageView.this.aJh();
                        } else if (PersonalizePageView.this.enK != PersonalizePageView.this.enJ) {
                            PersonalizePageView.this.enK = PersonalizePageView.this.enJ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.enJ.setEnable(true);
                        PersonalizePageView.this.enH.setProgressView(PersonalizePageView.this.enJ);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.enH.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.enI == null) {
                        PersonalizePageView.this.enI = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.enK = PersonalizePageView.this.enI;
                        PersonalizePageView.this.aJh();
                    } else if (PersonalizePageView.this.enK != PersonalizePageView.this.enI || !aVar.equals(PersonalizePageView.this.enI.aJF())) {
                        PersonalizePageView.this.enK = PersonalizePageView.this.enI;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.enI.setEnable(true);
                    PersonalizePageView.this.enH.setProgressView(PersonalizePageView.this.enI);
                    PersonalizePageView.this.enI.a(aVar);
                    PersonalizePageView.this.enH.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0200e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enQ = 0L;
        this.mSkinType = 3;
        this.dCl = false;
        this.enS = false;
        this.enT = 0;
        this.enU = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new am("c11693").ax("obj_locate", "1").ax(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ax("tid", ahVar.getTid()).ax("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").ax(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ax("tid", ahVar.getTid()).ax("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11693").ax("obj_locate", sb.toString()).ax(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ax("tid", ahVar.getTid()).ax("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.enV = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void ba(int i, int i2) {
                if (PersonalizePageView.this.enM == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aIj = PersonalizePageView.this.aIj();
                PersonalizePageView.this.ZS();
                if (aIj) {
                    PersonalizePageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds520));
                }
                PersonalizePageView.this.enM.aZ(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.enM != null) {
                    PersonalizePageView.this.enM.G(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.enH.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.enH.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.ZS();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.enN.aJv());
                PersonalizePageView.this.cp(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dDt != null) {
                    PersonalizePageView.this.dDt.a(a2);
                }
            }
        };
        this.enW = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                com.baidu.tieba.a.d.UG().jr("page_recommend");
                PersonalizePageView.this.enN.update();
            }
        };
        this.enX = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bH(boolean z) {
                if (PersonalizePageView.this.enN != null) {
                    if (PersonalizePageView.this.enN.azN() != null) {
                        PersonalizePageView.this.enN.azN().aKF();
                    }
                    PersonalizePageView.this.enN.hP(false);
                }
            }
        };
        this.enY = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.enN != null) {
                    PersonalizePageView.this.enN.hP(true);
                    PersonalizePageView.this.enN.aJo();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.wO().cm(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.enZ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aMv = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.aJj();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.ejt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.YV();
            }
        };
        this.dCT = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dCl = true;
                    }
                }
            }
        };
        this.eoa = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.enH != null && !PersonalizePageView.this.enH.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.enJ == null) {
                            PersonalizePageView.this.enJ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.enJ.ek(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.enK = PersonalizePageView.this.enJ;
                            PersonalizePageView.this.aJh();
                        } else if (PersonalizePageView.this.enK != PersonalizePageView.this.enJ) {
                            PersonalizePageView.this.enK = PersonalizePageView.this.enJ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.enJ.setEnable(true);
                        PersonalizePageView.this.enH.setProgressView(PersonalizePageView.this.enJ);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.enH.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.enI == null) {
                        PersonalizePageView.this.enI = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.enK = PersonalizePageView.this.enI;
                        PersonalizePageView.this.aJh();
                    } else if (PersonalizePageView.this.enK != PersonalizePageView.this.enI || !aVar.equals(PersonalizePageView.this.enI.aJF())) {
                        PersonalizePageView.this.enK = PersonalizePageView.this.enI;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.enI.setEnable(true);
                    PersonalizePageView.this.enH.setProgressView(PersonalizePageView.this.enI);
                    PersonalizePageView.this.enI.a(aVar);
                    PersonalizePageView.this.enH.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0200e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.enQ = 0L;
        this.mSkinType = 3;
        this.dCl = false;
        this.enS = false;
        this.enT = 0;
        this.enU = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ah ahVar) {
                if (ahVar != null) {
                    TiebaStatic.log(new am("c11693").ax("obj_locate", "1").ax(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ax("tid", ahVar.getTid()).ax("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").ax(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ax("tid", ahVar.getTid()).ax("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11693").ax("obj_locate", sb.toString()).ax(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ax("tid", ahVar.getTid()).ax("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.enV = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void ba(int i2, int i22) {
                if (PersonalizePageView.this.enM == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aIj = PersonalizePageView.this.aIj();
                PersonalizePageView.this.ZS();
                if (aIj) {
                    PersonalizePageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds520));
                }
                PersonalizePageView.this.enM.aZ(i2, i22);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i2, int i22, int i3) {
                if (PersonalizePageView.this.enM != null) {
                    PersonalizePageView.this.enM.G(i2, i22, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.enH.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kV()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.enH.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.ZS();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.enN.aJv());
                PersonalizePageView.this.cp(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dDt != null) {
                    PersonalizePageView.this.dDt.a(a2);
                }
            }
        };
        this.enW = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                com.baidu.tieba.a.d.UG().jr("page_recommend");
                PersonalizePageView.this.enN.update();
            }
        };
        this.enX = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bH(boolean z) {
                if (PersonalizePageView.this.enN != null) {
                    if (PersonalizePageView.this.enN.azN() != null) {
                        PersonalizePageView.this.enN.azN().aKF();
                    }
                    PersonalizePageView.this.enN.hP(false);
                }
            }
        };
        this.enY = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.enN != null) {
                    PersonalizePageView.this.enN.hP(true);
                    PersonalizePageView.this.enN.aJo();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.wO().cm(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.enZ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aMv = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                                PersonalizePageView.this.aJj();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.ejt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.YV();
            }
        };
        this.dCT = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dCl = true;
                    }
                }
            }
        };
        this.eoa = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.enH != null && !PersonalizePageView.this.enH.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.enJ == null) {
                            PersonalizePageView.this.enJ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.enJ.ek(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.enK = PersonalizePageView.this.enJ;
                            PersonalizePageView.this.aJh();
                        } else if (PersonalizePageView.this.enK != PersonalizePageView.this.enJ) {
                            PersonalizePageView.this.enK = PersonalizePageView.this.enJ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.enJ.setEnable(true);
                        PersonalizePageView.this.enH.setProgressView(PersonalizePageView.this.enJ);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.enH.setCustomDistances(i2, i2, i2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.enI == null) {
                        PersonalizePageView.this.enI = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.enK = PersonalizePageView.this.enI;
                        PersonalizePageView.this.aJh();
                    } else if (PersonalizePageView.this.enK != PersonalizePageView.this.enI || !aVar.equals(PersonalizePageView.this.enI.aJF())) {
                        PersonalizePageView.this.enK = PersonalizePageView.this.enI;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.enI.setEnable(true);
                    PersonalizePageView.this.enH.setProgressView(PersonalizePageView.this.enI);
                    PersonalizePageView.this.enI.a(aVar);
                    PersonalizePageView.this.enH.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0200e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ekY = new BdTypeRecyclerView(context);
        this.ekY.setLayoutManager(new LinearLayoutManager(this.ekY.getContext()));
        this.ekY.setFadingEdgeLength(0);
        this.ekY.setOverScrollMode(2);
        this.enH = new BigdaySwipeRefreshLayout(context);
        this.enH.addView(this.ekY);
        this.bKJ = new PbListView(context);
        this.bKJ.getView();
        this.bKJ.ej(e.d.cp_bg_line_e);
        this.bKJ.DV();
        this.bKJ.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bKJ.setTextSize(e.C0200e.tbfontsize33);
        this.bKJ.ei(e.d.cp_cont_e);
        this.bKJ.setHeight(com.baidu.adp.lib.util.l.h(context, e.C0200e.tbds182));
        this.bKJ.setOnClickListener(this.ejt);
        this.ekY.setNextPage(this.bKJ);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        MessageManager.getInstance().registerListener(this.eoa);
        com.baidu.tbadk.core.bigday.b.wO().aW(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.wO().cm(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.enH);
        ((FrameLayout.LayoutParams) this.enH.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.enP = new com.baidu.tieba.homepage.personalize.model.e();
        this.enL = new l(context, this.ekY);
        this.enL.b(this.enP);
        this.enN = new e(this.pageContext, this.ekY, this.enL, this.enH);
        this.enO = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dCT);
        this.enT = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(Context context) {
        if (this.enR == null) {
            this.enR = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.h(context, e.C0200e.tbds200), com.baidu.adp.lib.util.l.h(context, e.C0200e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(context, e.C0200e.tbds200);
            addView(this.enR, layoutParams);
            this.enR.setVisibility(8);
            this.enR.setPageId(this.pageContext.getUniqueId());
            this.dDt = new com.baidu.tieba.c.c(this.pageContext, this.enR, 1);
        }
    }

    public void aJh() {
        if (this.enK != null) {
            this.enK.a(this.enW);
            this.enK.a(this.enX);
            this.enK.a(this.enY);
        }
    }

    public void aDk() {
        this.enL.a(this.enU);
        this.enN.a(this.enV);
        this.enO.a(this);
        aJh();
        this.ekY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.YV();
            }
        });
        this.ekY.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.enQ >= 5000) {
                    PersonalizePageView.this.enN.bb(i, i2);
                }
            }
        }, 1L);
        this.ekY.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.enN != null && PersonalizePageView.this.enN.azN() != null) {
                        PersonalizePageView.this.enN.azN().bj(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).aor().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.enM = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bKJ != null) {
            this.bKJ.DZ();
            this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.enN.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.enN != null) {
            this.enN.hN(!z);
        }
        this.enS = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.enS;
    }

    public void g(Long l) {
        this.enN.g(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.enH != null && this.enH.getLayoutParams() != null) {
            if (this.enN != null) {
                this.enN.setHeaderViewHeight(i);
            }
            if (this.enO != null) {
                this.enO.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.enN != null) {
            this.enN.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    public void showFloatingView() {
        if (this.enN != null) {
            this.enN.showFloatingView();
        }
    }

    public void aJi() {
        if (this.enN != null) {
            this.enN.aJi();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bGG != null) {
                this.bGG.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            al.j(this.enH, e.d.cp_bg_line_e);
            if (this.enJ != null) {
                this.enJ.ek(i);
            }
            if (this.bKJ != null) {
                this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bKJ.ek(i);
            }
            this.enL.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void af(String str, int i) {
        if (this.bKJ != null) {
            this.bKJ.DZ();
            this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.enN.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.enN != null) {
                        PersonalizePageView.this.enN.update();
                    }
                }
            });
        }
        this.refreshView.fP(getContext().getResources().getDimensionPixelSize(e.C0200e.ds280));
        this.refreshView.hV(str);
        this.refreshView.attachView(view, z);
        this.refreshView.MH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZS() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.bGG != null) {
            this.bGG.dettachView(this);
            this.bGG = null;
            this.ekY.setNextPage(this.bKJ);
        }
        if (this.enH != null) {
            this.enH.setVisibility(0);
        }
        if (this.enM != null) {
            this.enM.aIL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aIj() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.bGG == null) {
            if (i < 0) {
                this.bGG = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.bGG = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.bGG.onChangeSkinType();
        }
        this.bGG.attachView(this, z);
        this.ekY.setNextPage(null);
        if (this.enH != null) {
            this.enH.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.enN != null) {
            this.enN.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.dDt != null) {
            this.dDt.apv();
        }
        setViewForeground(false);
        if (this.enN != null) {
            this.enN.gC(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.enT < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.enZ, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.enN != null) {
            this.enN.hH(z);
        }
    }

    public void aIT() {
        if (this.enN != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds520));
            this.enN.update();
        }
        if (com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.wO().wQ();
            com.baidu.tbadk.core.bigday.b.wO().wP();
        }
    }

    public void reload() {
        if (this.ekY != null && this.enH != null) {
            showFloatingView();
            this.ekY.setSelection(0);
            if (!this.enH.isRefreshing()) {
                if (this.enN != null && this.enN.azN() != null) {
                    this.enN.azN().aKF();
                    this.enN.hP(false);
                }
                this.enH.setRefreshing(true);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dCT);
        MessageManager.getInstance().unRegisterListener(this.eoa);
        this.enN.onDestroy();
        this.enL.a((NEGFeedBackView.a) null);
        this.enN.a((e.a) null);
        if (this.enI != null) {
            this.enI.a((j.b) null);
            this.enI.a((j.c) null);
            this.enI.a((j.a) null);
            this.enI.release();
        }
        if (this.enJ != null) {
            this.enJ.a((j.b) null);
            this.enJ.a((j.c) null);
            this.enJ.a((j.a) null);
            this.enJ.release();
        }
        this.ekY.setOnSrollToBottomListener(null);
        if (this.bGG != null) {
            this.bGG.release();
        }
        this.ekY.setRecyclerListener(null);
        if (this.enO != null) {
            this.enO.onDestroy();
        }
        if (this.dDt != null) {
            this.dDt.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.wO().destroy();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.enZ);
    }

    public void onPause() {
        this.enN.onPause();
    }

    public void onResume() {
        if (this.dCl) {
            reload();
            this.dCl = false;
        }
        if (this.enH != null) {
            this.enH.resume();
        }
    }

    public void aJj() {
        if (this.enL != null) {
            this.enL.notifyDataSetChanged();
        }
    }

    public void aIl() {
        if (this.enN != null) {
            this.enN.gC(true);
        }
        v.anQ().dP(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.enZ);
    }

    public void aJf() {
        this.enN.aJu();
    }

    public void aJk() {
        this.enN.aJk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YV() {
        com.baidu.tieba.homepage.framework.a.aIK().k(System.currentTimeMillis(), 1);
        if (this.bKJ != null && !this.bKJ.Ee()) {
            this.bKJ.DY();
            this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.enN.YV();
    }
}
