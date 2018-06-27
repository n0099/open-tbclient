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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.t;
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
    private f bqL;
    private PbListView buU;
    private View.OnClickListener dQg;
    private d.a dTA;
    g.b dTB;
    g.c dTC;
    g.a dTD;
    public CustomMessageListener dTE;
    private BigdaySwipeRefreshLayout dTm;
    private BdTypeRecyclerView dTn;
    private com.baidu.tieba.homepage.personalize.bigday.b dTo;
    private com.baidu.tieba.homepage.personalize.bigday.a dTp;
    private a dTq;
    private l dTr;
    private com.baidu.tieba.homepage.framework.b dTs;
    private d dTt;
    private com.baidu.tieba.homepage.personalize.a dTu;
    private com.baidu.tieba.homepage.personalize.model.e dTv;
    private long dTw;
    private FloatingAnimationView dTx;
    private boolean dTy;
    private NEGFeedBackView.a dTz;
    private CustomMessageListener dkP;
    private boolean dki;
    private com.baidu.tieba.c.c dlo;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void a(g.a aVar);

        void a(g.b bVar);

        void a(g.c cVar);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dTt != null) {
            this.dTt.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.dTu != null) {
            this.dTu.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.dTm != null) {
            this.dTm.nX();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dTr != null) {
            this.dTr.setPageUniqueId(bdUniqueId);
        }
        if (this.dTt != null) {
            this.dTt.j(bdUniqueId);
        }
        if (this.dTv != null) {
            this.dTv.m(bdUniqueId);
        }
        if (this.dTp != null) {
            this.dTp.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.tJ().setTag(bdUniqueId);
        if (this.aDX != null) {
            this.aDX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aDX);
        }
        if (this.dTu != null) {
            this.dTu.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        m mVar = new m();
        mVar.tP(String.valueOf(floatInfo.activity_id));
        mVar.dA(floatInfo.dynamic_url);
        mVar.cW(floatInfo.end_time.longValue() * 1000);
        mVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        mVar.tO(floatInfo.float_url);
        mVar.tN(floatInfo.jump_url);
        mVar.setType(floatInfo.show_type.intValue());
        return mVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.dTw = 0L;
        this.mSkinType = 3;
        this.dki = false;
        this.dTy = false;
        this.dTz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar) {
                if (aiVar != null) {
                    TiebaStatic.log(new an("c11693").ah("obj_locate", "1").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ai aiVar) {
                if (arrayList != null && aiVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        sb.append(arrayList.get(i)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11693").ah("obj_locate", sb.toString()).ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dTA = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aO(int i, int i2) {
                if (PersonalizePageView.this.dTs == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aCB = PersonalizePageView.this.aCB();
                PersonalizePageView.this.Uc();
                if (aCB) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dTs.aN(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dTs != null) {
                    PersonalizePageView.this.dTs.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.dTm.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.jD()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dTm.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Uc();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.dTt.aDt());
                PersonalizePageView.this.bz(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dlo != null) {
                    PersonalizePageView.this.dlo.a(a2);
                }
            }
        };
        this.dTB = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                com.baidu.tieba.a.d.QB().iC("page_recommend");
                PersonalizePageView.this.dTt.update();
            }
        };
        this.dTC = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.g.c
            public void aV(boolean z) {
                if (PersonalizePageView.this.dTt != null) {
                    if (PersonalizePageView.this.dTt.auy() != null) {
                        PersonalizePageView.this.dTt.auy().aED();
                    }
                    PersonalizePageView.this.dTt.gM(false);
                }
            }
        };
        this.dTD = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.g.a
            public void c(View view, boolean z) {
                if (PersonalizePageView.this.dTt != null) {
                    PersonalizePageView.this.dTt.gM(true);
                    PersonalizePageView.this.dTt.aDm();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hv().aw("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.tJ().bB(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.aDX = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
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
                        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aDi();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dQg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.Tf();
            }
        };
        this.dkP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dki = true;
                    }
                }
            }
        };
        this.dTE = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.dTm != null && !PersonalizePageView.this.dTm.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.dTp == null) {
                            PersonalizePageView.this.dTp = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.dTp.dz(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.dTq = PersonalizePageView.this.dTp;
                            PersonalizePageView.this.aDg();
                        } else if (PersonalizePageView.this.dTq != PersonalizePageView.this.dTp) {
                            PersonalizePageView.this.dTq = PersonalizePageView.this.dTp;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.dTp.setEnable(true);
                        PersonalizePageView.this.dTm.setProgressView(PersonalizePageView.this.dTp);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.dTm.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.dTo == null) {
                        PersonalizePageView.this.dTo = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.dTq = PersonalizePageView.this.dTo;
                        PersonalizePageView.this.aDg();
                    } else if (PersonalizePageView.this.dTq != PersonalizePageView.this.dTo || !aVar.equals(PersonalizePageView.this.dTo.aDD())) {
                        PersonalizePageView.this.dTq = PersonalizePageView.this.dTo;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.dTo.setEnable(true);
                    PersonalizePageView.this.dTm.setProgressView(PersonalizePageView.this.dTo);
                    PersonalizePageView.this.dTo.a(aVar);
                    PersonalizePageView.this.dTm.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dTw = 0L;
        this.mSkinType = 3;
        this.dki = false;
        this.dTy = false;
        this.dTz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar) {
                if (aiVar != null) {
                    TiebaStatic.log(new an("c11693").ah("obj_locate", "1").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ai aiVar) {
                if (arrayList != null && aiVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        sb.append(arrayList.get(i)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11693").ah("obj_locate", sb.toString()).ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dTA = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aO(int i, int i2) {
                if (PersonalizePageView.this.dTs == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aCB = PersonalizePageView.this.aCB();
                PersonalizePageView.this.Uc();
                if (aCB) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dTs.aN(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dTs != null) {
                    PersonalizePageView.this.dTs.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.dTm.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.jD()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dTm.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Uc();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.dTt.aDt());
                PersonalizePageView.this.bz(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dlo != null) {
                    PersonalizePageView.this.dlo.a(a2);
                }
            }
        };
        this.dTB = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                com.baidu.tieba.a.d.QB().iC("page_recommend");
                PersonalizePageView.this.dTt.update();
            }
        };
        this.dTC = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.g.c
            public void aV(boolean z) {
                if (PersonalizePageView.this.dTt != null) {
                    if (PersonalizePageView.this.dTt.auy() != null) {
                        PersonalizePageView.this.dTt.auy().aED();
                    }
                    PersonalizePageView.this.dTt.gM(false);
                }
            }
        };
        this.dTD = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.g.a
            public void c(View view, boolean z) {
                if (PersonalizePageView.this.dTt != null) {
                    PersonalizePageView.this.dTt.gM(true);
                    PersonalizePageView.this.dTt.aDm();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hv().aw("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.tJ().bB(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.aDX = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
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
                        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aDi();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dQg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.Tf();
            }
        };
        this.dkP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dki = true;
                    }
                }
            }
        };
        this.dTE = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.dTm != null && !PersonalizePageView.this.dTm.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.dTp == null) {
                            PersonalizePageView.this.dTp = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.dTp.dz(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.dTq = PersonalizePageView.this.dTp;
                            PersonalizePageView.this.aDg();
                        } else if (PersonalizePageView.this.dTq != PersonalizePageView.this.dTp) {
                            PersonalizePageView.this.dTq = PersonalizePageView.this.dTp;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.dTp.setEnable(true);
                        PersonalizePageView.this.dTm.setProgressView(PersonalizePageView.this.dTp);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.dTm.setCustomDistances(i, i, i);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.dTo == null) {
                        PersonalizePageView.this.dTo = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.dTq = PersonalizePageView.this.dTo;
                        PersonalizePageView.this.aDg();
                    } else if (PersonalizePageView.this.dTq != PersonalizePageView.this.dTo || !aVar.equals(PersonalizePageView.this.dTo.aDD())) {
                        PersonalizePageView.this.dTq = PersonalizePageView.this.dTo;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.dTo.setEnable(true);
                    PersonalizePageView.this.dTm.setProgressView(PersonalizePageView.this.dTo);
                    PersonalizePageView.this.dTo.a(aVar);
                    PersonalizePageView.this.dTm.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dTw = 0L;
        this.mSkinType = 3;
        this.dki = false;
        this.dTy = false;
        this.dTz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar) {
                if (aiVar != null) {
                    TiebaStatic.log(new an("c11693").ah("obj_locate", "1").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ai aiVar) {
                if (arrayList != null && aiVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11693").ah("obj_locate", sb.toString()).ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dTA = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aO(int i2, int i22) {
                if (PersonalizePageView.this.dTs == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aCB = PersonalizePageView.this.aCB();
                PersonalizePageView.this.Uc();
                if (aCB) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dTs.aN(i2, i22);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i2, int i22, int i3) {
                if (PersonalizePageView.this.dTs != null) {
                    PersonalizePageView.this.dTs.B(i2, i22, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.dTm.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.jD()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dTm.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Uc();
                m a2 = PersonalizePageView.this.a(PersonalizePageView.this.dTt.aDt());
                PersonalizePageView.this.bz(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.dlo != null) {
                    PersonalizePageView.this.dlo.a(a2);
                }
            }
        };
        this.dTB = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                com.baidu.tieba.a.d.QB().iC("page_recommend");
                PersonalizePageView.this.dTt.update();
            }
        };
        this.dTC = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.g.c
            public void aV(boolean z) {
                if (PersonalizePageView.this.dTt != null) {
                    if (PersonalizePageView.this.dTt.auy() != null) {
                        PersonalizePageView.this.dTt.auy().aED();
                    }
                    PersonalizePageView.this.dTt.gM(false);
                }
            }
        };
        this.dTD = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.g.a
            public void c(View view, boolean z) {
                if (PersonalizePageView.this.dTt != null) {
                    PersonalizePageView.this.dTt.gM(true);
                    PersonalizePageView.this.dTt.aDm();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.hv().aw("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.tJ().bB(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.aDX = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
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
                        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aDi();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dQg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.Tf();
            }
        };
        this.dkP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dki = true;
                    }
                }
            }
        };
        this.dTE = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.dTm != null && !PersonalizePageView.this.dTm.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.dTp == null) {
                            PersonalizePageView.this.dTp = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.dTp.dz(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.dTq = PersonalizePageView.this.dTp;
                            PersonalizePageView.this.aDg();
                        } else if (PersonalizePageView.this.dTq != PersonalizePageView.this.dTp) {
                            PersonalizePageView.this.dTq = PersonalizePageView.this.dTp;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.dTp.setEnable(true);
                        PersonalizePageView.this.dTm.setProgressView(PersonalizePageView.this.dTp);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.dTm.setCustomDistances(i2, i2, i2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.dTo == null) {
                        PersonalizePageView.this.dTo = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.dTq = PersonalizePageView.this.dTo;
                        PersonalizePageView.this.aDg();
                    } else if (PersonalizePageView.this.dTq != PersonalizePageView.this.dTo || !aVar.equals(PersonalizePageView.this.dTo.aDD())) {
                        PersonalizePageView.this.dTq = PersonalizePageView.this.dTo;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.dTo.setEnable(true);
                    PersonalizePageView.this.dTm.setProgressView(PersonalizePageView.this.dTo);
                    PersonalizePageView.this.dTo.a(aVar);
                    PersonalizePageView.this.dTm.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(d.e.tbds236), (int) (com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.aj(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dTn = new BdTypeRecyclerView(context);
        this.dTn.setLayoutManager(new LinearLayoutManager(this.dTn.getContext()));
        this.dTn.setFadingEdgeLength(0);
        this.dTn.setOverScrollMode(2);
        this.dTm = new BigdaySwipeRefreshLayout(context);
        this.dTm.addView(this.dTn);
        this.buU = new PbListView(context);
        this.buU.getView();
        this.buU.dy(d.C0142d.cp_bg_line_e);
        this.buU.AE();
        this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_j));
        this.buU.setTextSize(d.e.tbfontsize33);
        this.buU.dx(d.C0142d.cp_cont_e);
        this.buU.setHeight(com.baidu.adp.lib.util.l.e(context, d.e.tbds182));
        this.buU.setOnClickListener(this.dQg);
        this.dTn.setNextPage(this.buU);
        com.baidu.adp.base.e<?> ad = i.ad(context);
        if (ad instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ad;
        }
        MessageManager.getInstance().registerListener(this.dTE);
        com.baidu.tbadk.core.bigday.b.tJ().aq(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.hv().aw("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.tJ().bB(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.dTm);
        ((FrameLayout.LayoutParams) this.dTm.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.dTv = new com.baidu.tieba.homepage.personalize.model.e();
        this.dTr = new l(context, this.dTn);
        this.dTr.b(this.dTv);
        this.dTt = new d(this.pageContext, this.dTn, this.dTr, this.dTm);
        this.dTu = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.dkP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(Context context) {
        if (this.dTx == null) {
            this.dTx = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.e(context, d.e.tbds200), com.baidu.adp.lib.util.l.e(context, d.e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.e(context, d.e.tbds200);
            addView(this.dTx, layoutParams);
            this.dTx.setVisibility(8);
            this.dTx.setPageId(this.pageContext.getUniqueId());
            this.dlo = new com.baidu.tieba.c.c(this.pageContext, this.dTx, 1);
        }
    }

    public void aDg() {
        if (this.dTq != null) {
            this.dTq.a(this.dTB);
            this.dTq.a(this.dTC);
            this.dTq.a(this.dTD);
        }
    }

    public void axE() {
        this.dTr.a(this.dTz);
        this.dTt.a(this.dTA);
        this.dTu.a(this);
        aDg();
        this.dTn.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.Tf();
            }
        });
        this.dTn.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.dTw >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    PersonalizePageView.this.dTt.aP(i, i2);
                }
            }
        }, 1L);
        this.dTn.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.dTt != null && PersonalizePageView.this.dTt.auy() != null) {
                        PersonalizePageView.this.dTt.auy().aQ(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).aja().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dTs = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.buU != null) {
            this.buU.AI();
            this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dTt.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.dTt != null) {
            this.dTt.gK(!z);
        }
        this.dTy = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.dTy;
    }

    public void f(Long l) {
        this.dTt.f(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.dTm != null && this.dTm.getLayoutParams() != null) {
            if (this.dTt != null) {
                this.dTt.setHeaderViewHeight(i);
            }
            if (this.dTu != null) {
                this.dTu.setHeaderViewHeight(i);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        if (this.dTt != null) {
            this.dTt.setRecommendFrsNavigationAnimDispatcher(tVar);
        }
    }

    public void showFloatingView() {
        if (this.dTt != null) {
            this.dTt.showFloatingView();
        }
    }

    public void aDh() {
        if (this.dTt != null) {
            this.dTt.aDh();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bqL != null) {
                this.bqL.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.j(this.dTm, d.C0142d.cp_bg_line_e);
            if (this.dTp != null) {
                this.dTp.dz(i);
            }
            if (this.buU != null) {
                this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
                this.buU.dz(i);
            }
            this.dTr.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void aa(String str, int i) {
        if (this.buU != null) {
            this.buU.AI();
            this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dTt.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.dTt != null) {
                        PersonalizePageView.this.dTt.update();
                    }
                }
            });
        }
        this.refreshView.fg(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(str);
        this.refreshView.d(view, z);
        this.refreshView.Jp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uc() {
        if (this.refreshView != null) {
            this.refreshView.Q(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.bqL != null) {
            this.bqL.Q(this);
            this.bqL = null;
            this.dTn.setNextPage(this.buU);
        }
        if (this.dTm != null) {
            this.dTm.setVisibility(0);
        }
        if (this.dTs != null) {
            this.dTs.aCP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCB() {
        if (this.refreshView != null) {
            return this.refreshView.Jh();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bqL == null) {
            if (i < 0) {
                this.bqL = new f(getContext());
            } else {
                this.bqL = new f(getContext(), i);
            }
            this.bqL.onChangeSkinType();
        }
        this.bqL.d(this, z);
        this.dTn.setNextPage(null);
        if (this.dTm != null) {
            this.dTm.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dTt != null) {
            this.dTt.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.dlo != null) {
            this.dlo.aki();
        }
        setViewForeground(false);
        if (this.dTt != null) {
            this.dTt.fH(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dTt != null) {
            this.dTt.gF(z);
        }
    }

    public void aCx() {
        if (this.dTt != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dTt.update();
        }
        if (com.baidu.adp.lib.b.d.hv().aw("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.tJ().tL();
            com.baidu.tbadk.core.bigday.b.tJ().tK();
        }
    }

    public void reload() {
        if (this.dTn != null && this.dTm != null) {
            showFloatingView();
            this.dTn.setSelection(0);
            if (!this.dTm.isRefreshing()) {
                if (this.dTt != null && this.dTt.auy() != null) {
                    this.dTt.auy().aED();
                    this.dTt.gM(false);
                }
                this.dTm.setRefreshing(true);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dkP);
        MessageManager.getInstance().unRegisterListener(this.dTE);
        this.dTt.onDestroy();
        this.dTr.a((NEGFeedBackView.a) null);
        this.dTt.a((d.a) null);
        if (this.dTo != null) {
            this.dTo.a((g.b) null);
            this.dTo.a((g.c) null);
            this.dTo.a((g.a) null);
            this.dTo.release();
        }
        if (this.dTp != null) {
            this.dTp.a((g.b) null);
            this.dTp.a((g.c) null);
            this.dTp.a((g.a) null);
            this.dTp.release();
        }
        this.dTn.setOnSrollToBottomListener(null);
        if (this.bqL != null) {
            this.bqL.release();
        }
        this.dTn.setRecyclerListener(null);
        if (this.dTu != null) {
            this.dTu.onDestroy();
        }
        if (this.dlo != null) {
            this.dlo.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.tJ().destroy();
    }

    public void onPause() {
        this.dTt.onPause();
    }

    public void onResume() {
        if (this.dki) {
            reload();
            this.dki = false;
        }
        if (this.dTm != null) {
            this.dTm.resume();
        }
    }

    public void aDi() {
        if (this.dTr != null) {
            this.dTr.notifyDataSetChanged();
        }
    }

    public void aCD() {
        if (this.dTt != null) {
            this.dTt.fH(true);
        }
        v.aiz().cK(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void aDe() {
        this.dTt.aDs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        com.baidu.tieba.homepage.framework.a.aCO().h(System.currentTimeMillis(), 1);
        if (this.buU != null && !this.buU.AO()) {
            this.buU.AH();
            this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dTt.Tf();
    }
}
