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
    private final CustomMessageListener aLF;
    private com.baidu.tbadk.k.f bFV;
    private PbListView bJY;
    private boolean dAU;
    private CustomMessageListener dBC;
    private com.baidu.tieba.c.c dCc;
    private View.OnClickListener ehZ;
    private BdTypeRecyclerView ejE;
    private NEGFeedBackView.a emA;
    private e.a emB;
    j.b emC;
    j.c emD;
    j.a emE;
    private Runnable emF;
    public CustomMessageListener emG;
    private BigdaySwipeRefreshLayout emn;
    private com.baidu.tieba.homepage.personalize.bigday.b emo;
    private com.baidu.tieba.homepage.personalize.bigday.a emp;
    private a emq;
    private l emr;
    private com.baidu.tieba.homepage.framework.b ems;
    private e emt;
    private com.baidu.tieba.homepage.personalize.a emu;
    private com.baidu.tieba.homepage.personalize.model.e emv;
    private long emw;
    private FloatingAnimationView emx;
    private boolean emy;
    private int emz;
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
        int i = personalizePageView.emz + 1;
        personalizePageView.emz = i;
        return i;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.emt != null) {
            this.emt.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.emu != null) {
            this.emu.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.emn != null) {
            this.emn.pk();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.emr != null) {
            this.emr.setPageUniqueId(bdUniqueId);
        }
        if (this.emt != null) {
            this.emt.j(bdUniqueId);
        }
        if (this.emv != null) {
            this.emv.m(bdUniqueId);
        }
        if (this.emp != null) {
            this.emp.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.wG().setTag(bdUniqueId);
        if (this.aLF != null) {
            this.aLF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aLF);
        }
        if (this.emu != null) {
            this.emu.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        m mVar = new m();
        mVar.va(String.valueOf(floatInfo.activity_id));
        mVar.dL(floatInfo.dynamic_url);
        mVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        mVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        mVar.uZ(floatInfo.float_url);
        mVar.uY(floatInfo.jump_url);
        mVar.setType(floatInfo.show_type.intValue());
        return mVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.emw = 0L;
        this.mSkinType = 3;
        this.dAU = false;
        this.emy = false;
        this.emz = 0;
        this.emA = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.emB = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aY(int i, int i2) {
                if (PersonalizePageView.this.ems == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aIL = PersonalizePageView.this.aIL();
                PersonalizePageView.this.ZI();
                if (aIL) {
                    PersonalizePageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
                }
                PersonalizePageView.this.ems.aX(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.ems != null) {
                    PersonalizePageView.this.ems.G(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.emn.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kX()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.emn.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.ZI();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.emt.aJX());
                PersonalizePageView.this.cu(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dCc != null) {
                    PersonalizePageView.this.dCc.a(a2);
                }
            }
        };
        this.emC = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                com.baidu.tieba.a.d.Ux().jp("page_recommend");
                PersonalizePageView.this.emt.update();
            }
        };
        this.emD = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bq(boolean z) {
                if (PersonalizePageView.this.emt != null) {
                    if (PersonalizePageView.this.emt.aAq() != null) {
                        PersonalizePageView.this.emt.aAq().aLh();
                    }
                    PersonalizePageView.this.emt.hF(false);
                }
            }
        };
        this.emE = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.emt != null) {
                    PersonalizePageView.this.emt.hF(true);
                    PersonalizePageView.this.emt.aJQ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.wG().bX(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.emF = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aLF = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aJL();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.ehZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.YL();
            }
        };
        this.dBC = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dAU = true;
                    }
                }
            }
        };
        this.emG = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.emn != null && !PersonalizePageView.this.emn.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.emp == null) {
                            PersonalizePageView.this.emp = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.emp.dW(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.emq = PersonalizePageView.this.emp;
                            PersonalizePageView.this.aJJ();
                        } else if (PersonalizePageView.this.emq != PersonalizePageView.this.emp) {
                            PersonalizePageView.this.emq = PersonalizePageView.this.emp;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.emp.setEnable(true);
                        PersonalizePageView.this.emn.setProgressView(PersonalizePageView.this.emp);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.emn.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.emo == null) {
                        PersonalizePageView.this.emo = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.emq = PersonalizePageView.this.emo;
                        PersonalizePageView.this.aJJ();
                    } else if (PersonalizePageView.this.emq != PersonalizePageView.this.emo || !aVar.equals(PersonalizePageView.this.emo.aKh())) {
                        PersonalizePageView.this.emq = PersonalizePageView.this.emo;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.emo.setEnable(true);
                    PersonalizePageView.this.emn.setProgressView(PersonalizePageView.this.emo);
                    PersonalizePageView.this.emo.a(aVar);
                    PersonalizePageView.this.emn.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0175e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.emw = 0L;
        this.mSkinType = 3;
        this.dAU = false;
        this.emy = false;
        this.emz = 0;
        this.emA = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.emB = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aY(int i, int i2) {
                if (PersonalizePageView.this.ems == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aIL = PersonalizePageView.this.aIL();
                PersonalizePageView.this.ZI();
                if (aIL) {
                    PersonalizePageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
                }
                PersonalizePageView.this.ems.aX(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.ems != null) {
                    PersonalizePageView.this.ems.G(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.emn.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kX()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.emn.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.ZI();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.emt.aJX());
                PersonalizePageView.this.cu(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dCc != null) {
                    PersonalizePageView.this.dCc.a(a2);
                }
            }
        };
        this.emC = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                com.baidu.tieba.a.d.Ux().jp("page_recommend");
                PersonalizePageView.this.emt.update();
            }
        };
        this.emD = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bq(boolean z) {
                if (PersonalizePageView.this.emt != null) {
                    if (PersonalizePageView.this.emt.aAq() != null) {
                        PersonalizePageView.this.emt.aAq().aLh();
                    }
                    PersonalizePageView.this.emt.hF(false);
                }
            }
        };
        this.emE = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.emt != null) {
                    PersonalizePageView.this.emt.hF(true);
                    PersonalizePageView.this.emt.aJQ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.wG().bX(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.emF = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aLF = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aJL();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.ehZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.YL();
            }
        };
        this.dBC = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dAU = true;
                    }
                }
            }
        };
        this.emG = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.emn != null && !PersonalizePageView.this.emn.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.emp == null) {
                            PersonalizePageView.this.emp = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.emp.dW(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.emq = PersonalizePageView.this.emp;
                            PersonalizePageView.this.aJJ();
                        } else if (PersonalizePageView.this.emq != PersonalizePageView.this.emp) {
                            PersonalizePageView.this.emq = PersonalizePageView.this.emp;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.emp.setEnable(true);
                        PersonalizePageView.this.emn.setProgressView(PersonalizePageView.this.emp);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.emn.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.emo == null) {
                        PersonalizePageView.this.emo = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.emq = PersonalizePageView.this.emo;
                        PersonalizePageView.this.aJJ();
                    } else if (PersonalizePageView.this.emq != PersonalizePageView.this.emo || !aVar.equals(PersonalizePageView.this.emo.aKh())) {
                        PersonalizePageView.this.emq = PersonalizePageView.this.emo;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.emo.setEnable(true);
                    PersonalizePageView.this.emn.setProgressView(PersonalizePageView.this.emo);
                    PersonalizePageView.this.emo.a(aVar);
                    PersonalizePageView.this.emn.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0175e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.emw = 0L;
        this.mSkinType = 3;
        this.dAU = false;
        this.emy = false;
        this.emz = 0;
        this.emA = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.emB = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aY(int i2, int i22) {
                if (PersonalizePageView.this.ems == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aIL = PersonalizePageView.this.aIL();
                PersonalizePageView.this.ZI();
                if (aIL) {
                    PersonalizePageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
                }
                PersonalizePageView.this.ems.aX(i2, i22);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i2, int i22, int i3) {
                if (PersonalizePageView.this.ems != null) {
                    PersonalizePageView.this.ems.G(i2, i22, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.emn.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kX()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.emn.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.ZI();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.emt.aJX());
                PersonalizePageView.this.cu(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dCc != null) {
                    PersonalizePageView.this.dCc.a(a2);
                }
            }
        };
        this.emC = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                com.baidu.tieba.a.d.Ux().jp("page_recommend");
                PersonalizePageView.this.emt.update();
            }
        };
        this.emD = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bq(boolean z) {
                if (PersonalizePageView.this.emt != null) {
                    if (PersonalizePageView.this.emt.aAq() != null) {
                        PersonalizePageView.this.emt.aAq().aLh();
                    }
                    PersonalizePageView.this.emt.hF(false);
                }
            }
        };
        this.emE = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.emt != null) {
                    PersonalizePageView.this.emt.hF(true);
                    PersonalizePageView.this.emt.aJQ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.wG().bX(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.emF = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.l(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.aLF = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aJL();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.ehZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.YL();
            }
        };
        this.dBC = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dAU = true;
                    }
                }
            }
        };
        this.emG = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.emn != null && !PersonalizePageView.this.emn.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.emp == null) {
                            PersonalizePageView.this.emp = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.emp.dW(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.emq = PersonalizePageView.this.emp;
                            PersonalizePageView.this.aJJ();
                        } else if (PersonalizePageView.this.emq != PersonalizePageView.this.emp) {
                            PersonalizePageView.this.emq = PersonalizePageView.this.emp;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.emp.setEnable(true);
                        PersonalizePageView.this.emn.setProgressView(PersonalizePageView.this.emp);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.emn.setCustomDistances(i2, i2, i2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.emo == null) {
                        PersonalizePageView.this.emo = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.emq = PersonalizePageView.this.emo;
                        PersonalizePageView.this.aJJ();
                    } else if (PersonalizePageView.this.emq != PersonalizePageView.this.emo || !aVar.equals(PersonalizePageView.this.emo.aKh())) {
                        PersonalizePageView.this.emq = PersonalizePageView.this.emo;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.emo.setEnable(true);
                    PersonalizePageView.this.emn.setProgressView(PersonalizePageView.this.emo);
                    PersonalizePageView.this.emo.a(aVar);
                    PersonalizePageView.this.emn.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0175e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ejE = new BdTypeRecyclerView(context);
        this.ejE.setLayoutManager(new LinearLayoutManager(this.ejE.getContext()));
        this.ejE.setFadingEdgeLength(0);
        this.ejE.setOverScrollMode(2);
        this.emn = new BigdaySwipeRefreshLayout(context);
        this.emn.addView(this.ejE);
        this.bJY = new PbListView(context);
        this.bJY.getView();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.DL();
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.dU(e.d.cp_cont_e);
        this.bJY.setHeight(com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds182));
        this.bJY.setOnClickListener(this.ehZ);
        this.ejE.setNextPage(this.bJY);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        MessageManager.getInstance().registerListener(this.emG);
        com.baidu.tbadk.core.bigday.b.wG().aG(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.wG().bX(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.emn);
        ((FrameLayout.LayoutParams) this.emn.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.emv = new com.baidu.tieba.homepage.personalize.model.e();
        this.emr = new l(context, this.ejE);
        this.emr.b(this.emv);
        this.emt = new e(this.pageContext, this.ejE, this.emr, this.emn);
        this.emu = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dBC);
        this.emz = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(Context context) {
        if (this.emx == null) {
            this.emx = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds200), com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds200);
            addView(this.emx, layoutParams);
            this.emx.setVisibility(8);
            this.emx.setPageId(this.pageContext.getUniqueId());
            this.dCc = new com.baidu.tieba.c.c(this.pageContext, this.emx, 1);
        }
    }

    public void aJJ() {
        if (this.emq != null) {
            this.emq.a(this.emC);
            this.emq.a(this.emD);
            this.emq.a(this.emE);
        }
    }

    public void aDQ() {
        this.emr.a(this.emA);
        this.emt.a(this.emB);
        this.emu.a(this);
        aJJ();
        this.ejE.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.YL();
            }
        });
        this.ejE.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.emw >= 5000) {
                    PersonalizePageView.this.emt.aZ(i, i2);
                }
            }
        }, 1L);
        this.ejE.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.emt != null && PersonalizePageView.this.emt.aAq() != null) {
                        PersonalizePageView.this.emt.aAq().bh(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).aoQ().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.ems = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bJY != null) {
            this.bJY.DP();
            this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.emt.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.emt != null) {
            this.emt.hD(!z);
        }
        this.emy = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.emy;
    }

    public void f(Long l) {
        this.emt.f(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.emn != null && this.emn.getLayoutParams() != null) {
            if (this.emt != null) {
                this.emt.setHeaderViewHeight(i);
            }
            if (this.emu != null) {
                this.emu.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.emt != null) {
            this.emt.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    public void showFloatingView() {
        if (this.emt != null) {
            this.emt.showFloatingView();
        }
    }

    public void aJK() {
        if (this.emt != null) {
            this.emt.aJK();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bFV != null) {
                this.bFV.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            al.j(this.emn, e.d.cp_bg_line_e);
            if (this.emp != null) {
                this.emp.dW(i);
            }
            if (this.bJY != null) {
                this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bJY.dW(i);
            }
            this.emr.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void af(String str, int i) {
        if (this.bJY != null) {
            this.bJY.DP();
            this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.emt.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.emt != null) {
                        PersonalizePageView.this.emt.update();
                    }
                }
            });
        }
        this.refreshView.fB(getContext().getResources().getDimensionPixelSize(e.C0175e.ds280));
        this.refreshView.hU(str);
        this.refreshView.c(view, z);
        this.refreshView.My();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZI() {
        if (this.refreshView != null) {
            this.refreshView.ad(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.bFV != null) {
            this.bFV.ad(this);
            this.bFV = null;
            this.ejE.setNextPage(this.bJY);
        }
        if (this.emn != null) {
            this.emn.setVisibility(0);
        }
        if (this.ems != null) {
            this.ems.aJn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aIL() {
        if (this.refreshView != null) {
            return this.refreshView.Mq();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.bFV == null) {
            if (i < 0) {
                this.bFV = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.bFV = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.bFV.onChangeSkinType();
        }
        this.bFV.c(this, z);
        this.ejE.setNextPage(null);
        if (this.emn != null) {
            this.emn.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.emt != null) {
            this.emt.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.dCc != null) {
            this.dCc.apU();
        }
        setViewForeground(false);
        if (this.emt != null) {
            this.emt.gs(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.emz < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.jI().postDelayed(this.emF, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.emt != null) {
            this.emt.hx(z);
        }
    }

    public void aJv() {
        if (this.emt != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
            this.emt.update();
        }
        if (com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.wG().wI();
            com.baidu.tbadk.core.bigday.b.wG().wH();
        }
    }

    public void reload() {
        if (this.ejE != null && this.emn != null) {
            showFloatingView();
            this.ejE.setSelection(0);
            if (!this.emn.isRefreshing()) {
                if (this.emt != null && this.emt.aAq() != null) {
                    this.emt.aAq().aLh();
                    this.emt.hF(false);
                }
                this.emn.setRefreshing(true);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dBC);
        MessageManager.getInstance().unRegisterListener(this.emG);
        this.emt.onDestroy();
        this.emr.a((NEGFeedBackView.a) null);
        this.emt.a((e.a) null);
        if (this.emo != null) {
            this.emo.a((j.b) null);
            this.emo.a((j.c) null);
            this.emo.a((j.a) null);
            this.emo.release();
        }
        if (this.emp != null) {
            this.emp.a((j.b) null);
            this.emp.a((j.c) null);
            this.emp.a((j.a) null);
            this.emp.release();
        }
        this.ejE.setOnSrollToBottomListener(null);
        if (this.bFV != null) {
            this.bFV.release();
        }
        this.ejE.setRecyclerListener(null);
        if (this.emu != null) {
            this.emu.onDestroy();
        }
        if (this.dCc != null) {
            this.dCc.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.wG().destroy();
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.emF);
    }

    public void onPause() {
        this.emt.onPause();
    }

    public void onResume() {
        if (this.dAU) {
            reload();
            this.dAU = false;
        }
        if (this.emn != null) {
            this.emn.resume();
        }
    }

    public void aJL() {
        if (this.emr != null) {
            this.emr.notifyDataSetChanged();
        }
    }

    public void aIN() {
        if (this.emt != null) {
            this.emt.gs(true);
        }
        v.aop().dy(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.emF);
    }

    public void aJH() {
        this.emt.aJW();
    }

    public void aJM() {
        this.emt.aJM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YL() {
        com.baidu.tieba.homepage.framework.a.aJm().k(System.currentTimeMillis(), 1);
        if (this.bJY != null && !this.bJY.DU()) {
            this.bJY.DO();
            this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.emt.YL();
    }
}
