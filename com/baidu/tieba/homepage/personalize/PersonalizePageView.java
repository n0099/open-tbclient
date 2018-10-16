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
    private View.OnClickListener ehY;
    private BdTypeRecyclerView ejD;
    private e.a emA;
    j.b emB;
    j.c emC;
    j.a emD;
    private Runnable emE;
    public CustomMessageListener emF;
    private BigdaySwipeRefreshLayout emm;
    private com.baidu.tieba.homepage.personalize.bigday.b emn;
    private com.baidu.tieba.homepage.personalize.bigday.a emo;
    private a emp;
    private l emq;
    private com.baidu.tieba.homepage.framework.b emr;
    private e ems;
    private com.baidu.tieba.homepage.personalize.a emt;
    private com.baidu.tieba.homepage.personalize.model.e emu;
    private long emv;
    private FloatingAnimationView emw;
    private boolean emx;
    private int emy;
    private NEGFeedBackView.a emz;
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
        int i = personalizePageView.emy + 1;
        personalizePageView.emy = i;
        return i;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ems != null) {
            this.ems.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.emt != null) {
            this.emt.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.emm != null) {
            this.emm.pk();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.emq != null) {
            this.emq.setPageUniqueId(bdUniqueId);
        }
        if (this.ems != null) {
            this.ems.j(bdUniqueId);
        }
        if (this.emu != null) {
            this.emu.m(bdUniqueId);
        }
        if (this.emo != null) {
            this.emo.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.wG().setTag(bdUniqueId);
        if (this.aLF != null) {
            this.aLF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aLF);
        }
        if (this.emt != null) {
            this.emt.setBdUniqueId(bdUniqueId);
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
        this.emv = 0L;
        this.mSkinType = 3;
        this.dAU = false;
        this.emx = false;
        this.emy = 0;
        this.emz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.emA = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aY(int i, int i2) {
                if (PersonalizePageView.this.emr == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aIL = PersonalizePageView.this.aIL();
                PersonalizePageView.this.ZH();
                if (aIL) {
                    PersonalizePageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
                }
                PersonalizePageView.this.emr.aX(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.emr != null) {
                    PersonalizePageView.this.emr.G(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.emm.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kX()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.emm.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.ZH();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.ems.aJX());
                PersonalizePageView.this.cu(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dCc != null) {
                    PersonalizePageView.this.dCc.a(a2);
                }
            }
        };
        this.emB = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                com.baidu.tieba.a.d.Ux().jp("page_recommend");
                PersonalizePageView.this.ems.update();
            }
        };
        this.emC = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bq(boolean z) {
                if (PersonalizePageView.this.ems != null) {
                    if (PersonalizePageView.this.ems.aAp() != null) {
                        PersonalizePageView.this.ems.aAp().aLh();
                    }
                    PersonalizePageView.this.ems.hF(false);
                }
            }
        };
        this.emD = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.ems != null) {
                    PersonalizePageView.this.ems.hF(true);
                    PersonalizePageView.this.ems.aJQ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.wG().bX(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.emE = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
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
        this.ehY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.YK();
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
        this.emF = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.emm != null && !PersonalizePageView.this.emm.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.emo == null) {
                            PersonalizePageView.this.emo = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.emo.dW(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.emp = PersonalizePageView.this.emo;
                            PersonalizePageView.this.aJJ();
                        } else if (PersonalizePageView.this.emp != PersonalizePageView.this.emo) {
                            PersonalizePageView.this.emp = PersonalizePageView.this.emo;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.emo.setEnable(true);
                        PersonalizePageView.this.emm.setProgressView(PersonalizePageView.this.emo);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.emm.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.emn == null) {
                        PersonalizePageView.this.emn = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.emp = PersonalizePageView.this.emn;
                        PersonalizePageView.this.aJJ();
                    } else if (PersonalizePageView.this.emp != PersonalizePageView.this.emn || !aVar.equals(PersonalizePageView.this.emn.aKh())) {
                        PersonalizePageView.this.emp = PersonalizePageView.this.emn;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.emn.setEnable(true);
                    PersonalizePageView.this.emm.setProgressView(PersonalizePageView.this.emn);
                    PersonalizePageView.this.emn.a(aVar);
                    PersonalizePageView.this.emm.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0175e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.emv = 0L;
        this.mSkinType = 3;
        this.dAU = false;
        this.emx = false;
        this.emy = 0;
        this.emz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.emA = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aY(int i, int i2) {
                if (PersonalizePageView.this.emr == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aIL = PersonalizePageView.this.aIL();
                PersonalizePageView.this.ZH();
                if (aIL) {
                    PersonalizePageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
                }
                PersonalizePageView.this.emr.aX(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i, int i2, int i3) {
                if (PersonalizePageView.this.emr != null) {
                    PersonalizePageView.this.emr.G(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.emm.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kX()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.emm.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.ZH();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.ems.aJX());
                PersonalizePageView.this.cu(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dCc != null) {
                    PersonalizePageView.this.dCc.a(a2);
                }
            }
        };
        this.emB = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                com.baidu.tieba.a.d.Ux().jp("page_recommend");
                PersonalizePageView.this.ems.update();
            }
        };
        this.emC = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bq(boolean z) {
                if (PersonalizePageView.this.ems != null) {
                    if (PersonalizePageView.this.ems.aAp() != null) {
                        PersonalizePageView.this.ems.aAp().aLh();
                    }
                    PersonalizePageView.this.ems.hF(false);
                }
            }
        };
        this.emD = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.ems != null) {
                    PersonalizePageView.this.ems.hF(true);
                    PersonalizePageView.this.ems.aJQ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.wG().bX(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.emE = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
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
        this.ehY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.YK();
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
        this.emF = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.emm != null && !PersonalizePageView.this.emm.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.emo == null) {
                            PersonalizePageView.this.emo = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.emo.dW(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.emp = PersonalizePageView.this.emo;
                            PersonalizePageView.this.aJJ();
                        } else if (PersonalizePageView.this.emp != PersonalizePageView.this.emo) {
                            PersonalizePageView.this.emp = PersonalizePageView.this.emo;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.emo.setEnable(true);
                        PersonalizePageView.this.emm.setProgressView(PersonalizePageView.this.emo);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.emm.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.emn == null) {
                        PersonalizePageView.this.emn = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.emp = PersonalizePageView.this.emn;
                        PersonalizePageView.this.aJJ();
                    } else if (PersonalizePageView.this.emp != PersonalizePageView.this.emn || !aVar.equals(PersonalizePageView.this.emn.aKh())) {
                        PersonalizePageView.this.emp = PersonalizePageView.this.emn;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.emn.setEnable(true);
                    PersonalizePageView.this.emm.setProgressView(PersonalizePageView.this.emn);
                    PersonalizePageView.this.emn.a(aVar);
                    PersonalizePageView.this.emm.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0175e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.emv = 0L;
        this.mSkinType = 3;
        this.dAU = false;
        this.emx = false;
        this.emy = 0;
        this.emz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
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
        this.emA = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void aY(int i2, int i22) {
                if (PersonalizePageView.this.emr == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aIL = PersonalizePageView.this.aIL();
                PersonalizePageView.this.ZH();
                if (aIL) {
                    PersonalizePageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
                }
                PersonalizePageView.this.emr.aX(i2, i22);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void H(int i2, int i22, int i3) {
                if (PersonalizePageView.this.emr != null) {
                    PersonalizePageView.this.emr.G(i2, i22, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.emm.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kX()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                PersonalizePageView.this.emm.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.ZH();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.ems.aJX());
                PersonalizePageView.this.cu(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dCc != null) {
                    PersonalizePageView.this.dCc.a(a2);
                }
            }
        };
        this.emB = new j.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                com.baidu.tieba.a.d.Ux().jp("page_recommend");
                PersonalizePageView.this.ems.update();
            }
        };
        this.emC = new j.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.j.c
            public void bq(boolean z) {
                if (PersonalizePageView.this.ems != null) {
                    if (PersonalizePageView.this.ems.aAp() != null) {
                        PersonalizePageView.this.ems.aAp().aLh();
                    }
                    PersonalizePageView.this.ems.hF(false);
                }
            }
        };
        this.emD = new j.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (PersonalizePageView.this.ems != null) {
                    PersonalizePageView.this.ems.hF(true);
                    PersonalizePageView.this.ems.aJQ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.wG().bX(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.emE = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
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
        this.ehY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.YK();
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
        this.emF = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.emm != null && !PersonalizePageView.this.emm.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.emo == null) {
                            PersonalizePageView.this.emo = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.emo.dW(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.emp = PersonalizePageView.this.emo;
                            PersonalizePageView.this.aJJ();
                        } else if (PersonalizePageView.this.emp != PersonalizePageView.this.emo) {
                            PersonalizePageView.this.emp = PersonalizePageView.this.emo;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.emo.setEnable(true);
                        PersonalizePageView.this.emm.setProgressView(PersonalizePageView.this.emo);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.emm.setCustomDistances(i2, i2, i2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.emn == null) {
                        PersonalizePageView.this.emn = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.emp = PersonalizePageView.this.emn;
                        PersonalizePageView.this.aJJ();
                    } else if (PersonalizePageView.this.emp != PersonalizePageView.this.emn || !aVar.equals(PersonalizePageView.this.emn.aKh())) {
                        PersonalizePageView.this.emp = PersonalizePageView.this.emn;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.emn.setEnable(true);
                    PersonalizePageView.this.emm.setProgressView(PersonalizePageView.this.emn);
                    PersonalizePageView.this.emn.a(aVar);
                    PersonalizePageView.this.emm.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(e.C0175e.tbds236), (int) (com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aQ(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ejD = new BdTypeRecyclerView(context);
        this.ejD.setLayoutManager(new LinearLayoutManager(this.ejD.getContext()));
        this.ejD.setFadingEdgeLength(0);
        this.ejD.setOverScrollMode(2);
        this.emm = new BigdaySwipeRefreshLayout(context);
        this.emm.addView(this.ejD);
        this.bJY = new PbListView(context);
        this.bJY.getView();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.DL();
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.dU(e.d.cp_cont_e);
        this.bJY.setHeight(com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds182));
        this.bJY.setOnClickListener(this.ehY);
        this.ejD.setNextPage(this.bJY);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        MessageManager.getInstance().registerListener(this.emF);
        com.baidu.tbadk.core.bigday.b.wG().aG(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.wG().bX(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.emm);
        ((FrameLayout.LayoutParams) this.emm.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.emu = new com.baidu.tieba.homepage.personalize.model.e();
        this.emq = new l(context, this.ejD);
        this.emq.b(this.emu);
        this.ems = new e(this.pageContext, this.ejD, this.emq, this.emm);
        this.emt = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dBC);
        this.emy = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(Context context) {
        if (this.emw == null) {
            this.emw = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds200), com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds200);
            addView(this.emw, layoutParams);
            this.emw.setVisibility(8);
            this.emw.setPageId(this.pageContext.getUniqueId());
            this.dCc = new com.baidu.tieba.c.c(this.pageContext, this.emw, 1);
        }
    }

    public void aJJ() {
        if (this.emp != null) {
            this.emp.a(this.emB);
            this.emp.a(this.emC);
            this.emp.a(this.emD);
        }
    }

    public void aDP() {
        this.emq.a(this.emz);
        this.ems.a(this.emA);
        this.emt.a(this);
        aJJ();
        this.ejD.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.YK();
            }
        });
        this.ejD.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.emv >= 5000) {
                    PersonalizePageView.this.ems.aZ(i, i2);
                }
            }
        }, 1L);
        this.ejD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.ems != null && PersonalizePageView.this.ems.aAp() != null) {
                        PersonalizePageView.this.ems.aAp().bh(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).aoP().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.emr = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bJY != null) {
            this.bJY.DP();
            this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ems.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.ems != null) {
            this.ems.hD(!z);
        }
        this.emx = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.emx;
    }

    public void f(Long l) {
        this.ems.f(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.emm != null && this.emm.getLayoutParams() != null) {
            if (this.ems != null) {
                this.ems.setHeaderViewHeight(i);
            }
            if (this.emt != null) {
                this.emt.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.ems != null) {
            this.ems.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    public void showFloatingView() {
        if (this.ems != null) {
            this.ems.showFloatingView();
        }
    }

    public void aJK() {
        if (this.ems != null) {
            this.ems.aJK();
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
            al.j(this.emm, e.d.cp_bg_line_e);
            if (this.emo != null) {
                this.emo.dW(i);
            }
            if (this.bJY != null) {
                this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bJY.dW(i);
            }
            this.emq.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void af(String str, int i) {
        if (this.bJY != null) {
            this.bJY.DP();
            this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ems.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.ems != null) {
                        PersonalizePageView.this.ems.update();
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
    public void ZH() {
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
            this.ejD.setNextPage(this.bJY);
        }
        if (this.emm != null) {
            this.emm.setVisibility(0);
        }
        if (this.emr != null) {
            this.emr.aJn();
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
        this.ejD.setNextPage(null);
        if (this.emm != null) {
            this.emm.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.ems != null) {
            this.ems.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.dCc != null) {
            this.dCc.apT();
        }
        setViewForeground(false);
        if (this.ems != null) {
            this.ems.gs(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        if (this.emy < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.jI().postDelayed(this.emE, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.ems != null) {
            this.ems.hx(z);
        }
    }

    public void aJv() {
        if (this.ems != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
            this.ems.update();
        }
        if (com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.wG().wI();
            com.baidu.tbadk.core.bigday.b.wG().wH();
        }
    }

    public void reload() {
        if (this.ejD != null && this.emm != null) {
            showFloatingView();
            this.ejD.setSelection(0);
            if (!this.emm.isRefreshing()) {
                if (this.ems != null && this.ems.aAp() != null) {
                    this.ems.aAp().aLh();
                    this.ems.hF(false);
                }
                this.emm.setRefreshing(true);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dBC);
        MessageManager.getInstance().unRegisterListener(this.emF);
        this.ems.onDestroy();
        this.emq.a((NEGFeedBackView.a) null);
        this.ems.a((e.a) null);
        if (this.emn != null) {
            this.emn.a((j.b) null);
            this.emn.a((j.c) null);
            this.emn.a((j.a) null);
            this.emn.release();
        }
        if (this.emo != null) {
            this.emo.a((j.b) null);
            this.emo.a((j.c) null);
            this.emo.a((j.a) null);
            this.emo.release();
        }
        this.ejD.setOnSrollToBottomListener(null);
        if (this.bFV != null) {
            this.bFV.release();
        }
        this.ejD.setRecyclerListener(null);
        if (this.emt != null) {
            this.emt.onDestroy();
        }
        if (this.dCc != null) {
            this.dCc.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.wG().destroy();
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.emE);
    }

    public void onPause() {
        this.ems.onPause();
    }

    public void onResume() {
        if (this.dAU) {
            reload();
            this.dAU = false;
        }
        if (this.emm != null) {
            this.emm.resume();
        }
    }

    public void aJL() {
        if (this.emq != null) {
            this.emq.notifyDataSetChanged();
        }
    }

    public void aIN() {
        if (this.ems != null) {
            this.ems.gs(true);
        }
        v.aoo().dy(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.emE);
    }

    public void aJH() {
        this.ems.aJW();
    }

    public void aJM() {
        this.ems.aJM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YK() {
        com.baidu.tieba.homepage.framework.a.aJm().k(System.currentTimeMillis(), 1);
        if (this.bJY != null && !this.bJY.DU()) {
            this.bJY.DO();
            this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ems.YK();
    }
}
