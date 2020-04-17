package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.k;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.ad;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.e;
import com.baidu.tieba.tbadkCore.data.o;
import com.baidu.tieba.view.FloatingAnimationView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes9.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager cWO;
    private final CustomMessageListener dOK;
    private PbListView ePm;
    private int eRD;
    private g eYb;
    private int ebH;
    private k gJn;
    private CustomMessageListener gJp;
    private CustomMessageListener gZM;
    private boolean gZb;
    private int gZl;
    private BdTypeRecyclerView hHY;
    private ScrollFragmentTabHost hIe;
    ScrollFragmentTabHost.a hIf;
    private BigdaySwipeRefreshLayout hIg;
    private View.OnClickListener hIi;
    g.d hML;
    g.b hMM;
    private NEGFeedBackView.a hMj;
    private Runnable hNA;
    public CustomMessageListener hNB;
    private View.OnClickListener hNC;
    private com.baidu.tieba.homepage.personalize.bigday.b hNj;
    private com.baidu.tieba.homepage.personalize.bigday.a hNk;
    private a hNl;
    private ad hNm;
    private com.baidu.tieba.homepage.framework.b hNn;
    private e hNo;
    private com.baidu.tieba.homepage.personalize.a hNp;
    private com.baidu.tieba.homepage.personalize.model.e hNq;
    private long hNr;
    private FloatingAnimationView hNs;
    private boolean hNt;
    private int hNu;
    private boolean hNv;
    private FRSRefreshButton hNw;
    private e.a hNx;
    g.c hNy;
    g.a hNz;
    private com.baidu.tieba.c.c hay;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes9.dex */
    public interface a {
        void a(g.a aVar);

        void a(g.b bVar);

        void a(g.d dVar);

        void setListPullRefreshListener(g.c cVar);
    }

    static /* synthetic */ int w(PersonalizePageView personalizePageView) {
        int i = personalizePageView.hNu + 1;
        personalizePageView.hNu = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hIe = scrollFragmentTabHost;
        if (this.hIe != null) {
            this.hIe.b(this.hIf);
            this.hIe.a(this.hIf);
        }
        if (this.hNo != null) {
            this.hNo.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hNp != null) {
            this.hNp.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.hIg != null) {
            this.hIg.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hNm != null) {
            this.hNm.setPageUniqueId(bdUniqueId);
        }
        if (this.hNo != null) {
            this.hNo.m(bdUniqueId);
        }
        if (this.hNq != null) {
            this.hNq.h(bdUniqueId);
        }
        if (this.hNk != null) {
            this.hNk.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.aIm().setTag(bdUniqueId);
        if (this.dOK != null) {
            this.dOK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dOK);
        }
        if (this.hNp != null) {
            this.hNp.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        o oVar = new o();
        oVar.bR(String.valueOf(floatInfo.activity_id));
        oVar.et(floatInfo.dynamic_url);
        oVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        oVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        oVar.KN(floatInfo.float_url);
        oVar.KM(floatInfo.jump_url);
        oVar.setType(floatInfo.show_type.intValue());
        return oVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.hNr = 0L;
        this.mSkinType = 3;
        this.gZb = false;
        this.hNt = false;
        this.hNu = 0;
        this.gZl = 0;
        this.hNv = false;
        this.ebH = 1;
        this.gJp = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gJn == null) {
                            PersonalizePageView.this.gJn = new k(new i());
                        }
                        PersonalizePageView.this.gJn.a(PersonalizePageView.this.hHY, 2);
                    } else if (PersonalizePageView.this.gJn != null) {
                        PersonalizePageView.this.gJn.pf();
                    }
                }
            }
        };
        this.hMj = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cI("obj_locate", "1").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, al alVar) {
                int i = 0;
                if (arrayList != null && alVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (alVar.threadType == 0) {
                        i = 1;
                    } else if (alVar.threadType == 40) {
                        i = 2;
                    } else if (alVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.hNm != null) {
                        PersonalizePageView.this.hNm.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fid", alVar.getFid()).cI("obj_param1", alVar.weight).cI("obj_source", alVar.source).cI("obj_id", alVar.extra).cI("obj_type", sb.toString()).cI("obj_name", str).af(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.eRD = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.eRD != i && PersonalizePageView.this.hIe != null) {
                    PersonalizePageView.this.eRD = i;
                    if (PersonalizePageView.this.eRD == 1) {
                        PersonalizePageView.this.hIe.blI();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.hIe.blJ();
                    } else {
                        PersonalizePageView.this.hIe.blI();
                    }
                }
            }
        };
        this.hIf = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bYD() {
                if (PersonalizePageView.this.hIe != null) {
                    PersonalizePageView.this.eRD = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.hHY)) {
                        PersonalizePageView.this.hIe.blJ();
                    } else {
                        PersonalizePageView.this.hIe.blI();
                    }
                }
            }
        };
        this.hNx = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gRq = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("key_first_install", true);

            private void bZv() {
                if (this.gRq) {
                    this.gRq = false;
                    com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.hNn == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bJu = PersonalizePageView.this.bJu();
                PersonalizePageView.this.blt();
                if (bJu) {
                    PersonalizePageView.this.fK(true);
                }
                PersonalizePageView.this.hNn.P(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hNn != null) {
                    PersonalizePageView.this.hNn.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bZv();
                } else if (!this.gRq) {
                    PersonalizePageView.this.hIg.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bZv();
                    PersonalizePageView.this.bYs();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bZv();
                PersonalizePageView.this.hIg.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.blt();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hNo.bZI());
                PersonalizePageView.this.eI(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.hay != null) {
                    PersonalizePageView.this.hay.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bZw() {
                if (PersonalizePageView.this.ePm != null) {
                    PersonalizePageView.this.ePm.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.ePm.endLoadData();
                    PersonalizePageView.this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hNy = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bfP().yb("page_recommend");
                PersonalizePageView.this.hNo.update();
                PersonalizePageView.this.hNo.nN(false);
                PersonalizePageView.this.hNv = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hML = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hNo != null && PersonalizePageView.this.hNo.bPv() != null) {
                    PersonalizePageView.this.hNo.bPv().bZf();
                }
            }
        };
        this.hNz = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aQy() {
                if (PersonalizePageView.this.hNv) {
                    PersonalizePageView.this.gZl = 0;
                    PersonalizePageView.this.ebH = 1;
                    PersonalizePageView.this.hNv = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hMM = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hNo != null) {
                    PersonalizePageView.this.hNo.nN(true);
                    PersonalizePageView.this.hNo.bZB();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aNV().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aIm().jA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hNA = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aNV().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.dOK = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bXU();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.hIi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.blb();
            }
        };
        this.gZM = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gZb = true;
                    }
                }
            }
        };
        this.hNB = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.hIg != null && !PersonalizePageView.this.hIg.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hNk == null) {
                            PersonalizePageView.this.hNk = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hNk.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hNl = PersonalizePageView.this.hNk;
                            PersonalizePageView.this.bZs();
                        } else if (PersonalizePageView.this.hNl != PersonalizePageView.this.hNk) {
                            PersonalizePageView.this.hNl = PersonalizePageView.this.hNk;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hNk.setEnable(true);
                        PersonalizePageView.this.hIg.setProgressView(PersonalizePageView.this.hNk);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.hIg.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hNj == null) {
                        PersonalizePageView.this.hNj = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hNl = PersonalizePageView.this.hNj;
                        PersonalizePageView.this.bZs();
                    } else if (PersonalizePageView.this.hNl != PersonalizePageView.this.hNj || !aVar.equals(PersonalizePageView.this.hNj.bZU())) {
                        PersonalizePageView.this.hNl = PersonalizePageView.this.hNj;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hNj.setEnable(true);
                    PersonalizePageView.this.hIg.setProgressView(PersonalizePageView.this.hNj);
                    PersonalizePageView.this.hNj.a(aVar);
                    PersonalizePageView.this.hIg.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hNC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hNw != null) {
                    PersonalizePageView.this.hNw.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hNr = 0L;
        this.mSkinType = 3;
        this.gZb = false;
        this.hNt = false;
        this.hNu = 0;
        this.gZl = 0;
        this.hNv = false;
        this.ebH = 1;
        this.gJp = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gJn == null) {
                            PersonalizePageView.this.gJn = new k(new i());
                        }
                        PersonalizePageView.this.gJn.a(PersonalizePageView.this.hHY, 2);
                    } else if (PersonalizePageView.this.gJn != null) {
                        PersonalizePageView.this.gJn.pf();
                    }
                }
            }
        };
        this.hMj = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cI("obj_locate", "1").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, al alVar) {
                int i = 0;
                if (arrayList != null && alVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (alVar.threadType == 0) {
                        i = 1;
                    } else if (alVar.threadType == 40) {
                        i = 2;
                    } else if (alVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.hNm != null) {
                        PersonalizePageView.this.hNm.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fid", alVar.getFid()).cI("obj_param1", alVar.weight).cI("obj_source", alVar.source).cI("obj_id", alVar.extra).cI("obj_type", sb.toString()).cI("obj_name", str).af(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.eRD = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.eRD != i && PersonalizePageView.this.hIe != null) {
                    PersonalizePageView.this.eRD = i;
                    if (PersonalizePageView.this.eRD == 1) {
                        PersonalizePageView.this.hIe.blI();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.hIe.blJ();
                    } else {
                        PersonalizePageView.this.hIe.blI();
                    }
                }
            }
        };
        this.hIf = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bYD() {
                if (PersonalizePageView.this.hIe != null) {
                    PersonalizePageView.this.eRD = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.hHY)) {
                        PersonalizePageView.this.hIe.blJ();
                    } else {
                        PersonalizePageView.this.hIe.blI();
                    }
                }
            }
        };
        this.hNx = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gRq = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("key_first_install", true);

            private void bZv() {
                if (this.gRq) {
                    this.gRq = false;
                    com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.hNn == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bJu = PersonalizePageView.this.bJu();
                PersonalizePageView.this.blt();
                if (bJu) {
                    PersonalizePageView.this.fK(true);
                }
                PersonalizePageView.this.hNn.P(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hNn != null) {
                    PersonalizePageView.this.hNn.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bZv();
                } else if (!this.gRq) {
                    PersonalizePageView.this.hIg.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bZv();
                    PersonalizePageView.this.bYs();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bZv();
                PersonalizePageView.this.hIg.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.blt();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hNo.bZI());
                PersonalizePageView.this.eI(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.hay != null) {
                    PersonalizePageView.this.hay.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bZw() {
                if (PersonalizePageView.this.ePm != null) {
                    PersonalizePageView.this.ePm.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.ePm.endLoadData();
                    PersonalizePageView.this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hNy = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bfP().yb("page_recommend");
                PersonalizePageView.this.hNo.update();
                PersonalizePageView.this.hNo.nN(false);
                PersonalizePageView.this.hNv = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hML = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hNo != null && PersonalizePageView.this.hNo.bPv() != null) {
                    PersonalizePageView.this.hNo.bPv().bZf();
                }
            }
        };
        this.hNz = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aQy() {
                if (PersonalizePageView.this.hNv) {
                    PersonalizePageView.this.gZl = 0;
                    PersonalizePageView.this.ebH = 1;
                    PersonalizePageView.this.hNv = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hMM = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hNo != null) {
                    PersonalizePageView.this.hNo.nN(true);
                    PersonalizePageView.this.hNo.bZB();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aNV().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aIm().jA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hNA = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aNV().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.dOK = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bXU();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.hIi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.blb();
            }
        };
        this.gZM = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gZb = true;
                    }
                }
            }
        };
        this.hNB = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.hIg != null && !PersonalizePageView.this.hIg.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hNk == null) {
                            PersonalizePageView.this.hNk = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hNk.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hNl = PersonalizePageView.this.hNk;
                            PersonalizePageView.this.bZs();
                        } else if (PersonalizePageView.this.hNl != PersonalizePageView.this.hNk) {
                            PersonalizePageView.this.hNl = PersonalizePageView.this.hNk;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hNk.setEnable(true);
                        PersonalizePageView.this.hIg.setProgressView(PersonalizePageView.this.hNk);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.hIg.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hNj == null) {
                        PersonalizePageView.this.hNj = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hNl = PersonalizePageView.this.hNj;
                        PersonalizePageView.this.bZs();
                    } else if (PersonalizePageView.this.hNl != PersonalizePageView.this.hNj || !aVar.equals(PersonalizePageView.this.hNj.bZU())) {
                        PersonalizePageView.this.hNl = PersonalizePageView.this.hNj;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hNj.setEnable(true);
                    PersonalizePageView.this.hIg.setProgressView(PersonalizePageView.this.hNj);
                    PersonalizePageView.this.hNj.a(aVar);
                    PersonalizePageView.this.hIg.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hNC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hNw != null) {
                    PersonalizePageView.this.hNw.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNr = 0L;
        this.mSkinType = 3;
        this.gZb = false;
        this.hNt = false;
        this.hNu = 0;
        this.gZl = 0;
        this.hNv = false;
        this.ebH = 1;
        this.gJp = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gJn == null) {
                            PersonalizePageView.this.gJn = new k(new i());
                        }
                        PersonalizePageView.this.gJn.a(PersonalizePageView.this.hHY, 2);
                    } else if (PersonalizePageView.this.gJn != null) {
                        PersonalizePageView.this.gJn.pf();
                    }
                }
            }
        };
        this.hMj = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cI("obj_locate", "1").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, al alVar) {
                int i2 = 0;
                if (arrayList != null && alVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        sb.append(arrayList.get(i22)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (alVar.threadType == 0) {
                        i2 = 1;
                    } else if (alVar.threadType == 40) {
                        i2 = 2;
                    } else if (alVar.threadType == 49) {
                        i2 = 3;
                    }
                    if (PersonalizePageView.this.hNm != null) {
                        PersonalizePageView.this.hNm.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fid", alVar.getFid()).cI("obj_param1", alVar.weight).cI("obj_source", alVar.source).cI("obj_id", alVar.extra).cI("obj_type", sb.toString()).cI("obj_name", str).af(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.eRD = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.eRD != i2 && PersonalizePageView.this.hIe != null) {
                    PersonalizePageView.this.eRD = i2;
                    if (PersonalizePageView.this.eRD == 1) {
                        PersonalizePageView.this.hIe.blI();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.hIe.blJ();
                    } else {
                        PersonalizePageView.this.hIe.blI();
                    }
                }
            }
        };
        this.hIf = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bYD() {
                if (PersonalizePageView.this.hIe != null) {
                    PersonalizePageView.this.eRD = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.hHY)) {
                        PersonalizePageView.this.hIe.blJ();
                    } else {
                        PersonalizePageView.this.hIe.blI();
                    }
                }
            }
        };
        this.hNx = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gRq = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("key_first_install", true);

            private void bZv() {
                if (this.gRq) {
                    this.gRq = false;
                    com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i2, int i22, int i3) {
                if (PersonalizePageView.this.hNn == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bJu = PersonalizePageView.this.bJu();
                PersonalizePageView.this.blt();
                if (bJu) {
                    PersonalizePageView.this.fK(true);
                }
                PersonalizePageView.this.hNn.P(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.hNn != null) {
                    PersonalizePageView.this.hNn.y(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bZv();
                } else if (!this.gRq) {
                    PersonalizePageView.this.hIg.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bZv();
                    PersonalizePageView.this.bYs();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bZv();
                PersonalizePageView.this.hIg.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.blt();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hNo.bZI());
                PersonalizePageView.this.eI(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.hay != null) {
                    PersonalizePageView.this.hay.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bZw() {
                if (PersonalizePageView.this.ePm != null) {
                    PersonalizePageView.this.ePm.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.ePm.endLoadData();
                    PersonalizePageView.this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hNy = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bfP().yb("page_recommend");
                PersonalizePageView.this.hNo.update();
                PersonalizePageView.this.hNo.nN(false);
                PersonalizePageView.this.hNv = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hML = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hNo != null && PersonalizePageView.this.hNo.bPv() != null) {
                    PersonalizePageView.this.hNo.bPv().bZf();
                }
            }
        };
        this.hNz = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aQy() {
                if (PersonalizePageView.this.hNv) {
                    PersonalizePageView.this.gZl = 0;
                    PersonalizePageView.this.ebH = 1;
                    PersonalizePageView.this.hNv = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hMM = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hNo != null) {
                    PersonalizePageView.this.hNo.nN(true);
                    PersonalizePageView.this.hNo.bZB();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aNV().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aIm().jA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hNA = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aNV().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.dOK = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bXU();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.hIi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.blb();
            }
        };
        this.gZM = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gZb = true;
                    }
                }
            }
        };
        this.hNB = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.hIg != null && !PersonalizePageView.this.hIg.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hNk == null) {
                            PersonalizePageView.this.hNk = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hNk.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hNl = PersonalizePageView.this.hNk;
                            PersonalizePageView.this.bZs();
                        } else if (PersonalizePageView.this.hNl != PersonalizePageView.this.hNk) {
                            PersonalizePageView.this.hNl = PersonalizePageView.this.hNk;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hNk.setEnable(true);
                        PersonalizePageView.this.hIg.setProgressView(PersonalizePageView.this.hNk);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.hIg.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hNj == null) {
                        PersonalizePageView.this.hNj = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hNl = PersonalizePageView.this.hNj;
                        PersonalizePageView.this.bZs();
                    } else if (PersonalizePageView.this.hNl != PersonalizePageView.this.hNj || !aVar.equals(PersonalizePageView.this.hNj.bZU())) {
                        PersonalizePageView.this.hNl = PersonalizePageView.this.hNj;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hNj.setEnable(true);
                    PersonalizePageView.this.hIg.setProgressView(PersonalizePageView.this.hNj);
                    PersonalizePageView.this.hNj.a(aVar);
                    PersonalizePageView.this.hIg.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hNC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hNw != null) {
                    PersonalizePageView.this.hNw.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hHY = new BdTypeRecyclerView(context);
        this.cWO = new LinearLayoutManager(this.hHY.getContext());
        this.hHY.setLayoutManager(this.cWO);
        this.hHY.setFadingEdgeLength(0);
        this.hHY.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gJn = new k(new i());
            this.gJn.a(this.hHY, 2);
        }
        MessageManager.getInstance().registerListener(this.gJp);
        this.hIg = new BigdaySwipeRefreshLayout(context);
        this.hIg.addView(this.hHY);
        this.ePm = new PbListView(context);
        this.ePm.getView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setLineGone();
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePm.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.ePm.setOnClickListener(this.hIi);
        this.ePm.aQd();
        this.hHY.setNextPage(this.ePm);
        com.baidu.adp.base.e<?> T = com.baidu.adp.base.i.T(context);
        if (T instanceof TbPageContext) {
            this.pageContext = (TbPageContext) T;
        }
        MessageManager.getInstance().registerListener(this.hNB);
        com.baidu.tbadk.core.bigday.b.aIm().gr(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aNV().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.aIm().jA(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.hIg);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.hNw = new FRSRefreshButton(context);
            int dimens = l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds180);
            addView(this.hNw, layoutParams);
            this.hNw.setOnClickListener(this.hNC);
            this.hNw.setVisibility(8);
        }
        this.hNq = new com.baidu.tieba.homepage.personalize.model.e();
        this.hNm = new ad(context, this.hHY);
        this.hNm.b(this.hNq);
        this.hNo = new e(this.pageContext, this.hHY, this.hNm, this.hIg);
        this.hNp = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.gZM);
        this.hNu = com.baidu.tbadk.core.sharedPref.b.aNV().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(Context context) {
        if (this.hNs == null) {
            this.hNs = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds200);
            addView(this.hNs, layoutParams);
            this.hNs.setVisibility(8);
            this.hNs.setPageId(this.pageContext.getUniqueId());
            this.hay = new com.baidu.tieba.c.c(this.pageContext, this.hNs, 1);
        }
    }

    public void bZs() {
        if (this.hNl != null) {
            this.hNl.setListPullRefreshListener(this.hNy);
            this.hNl.a(this.hML);
            this.hNl.a(this.hNz);
            this.hNl.a(this.hMM);
        }
    }

    public void bqK() {
        this.hNm.b(this.hMj);
        this.hNo.a(this.hNx);
        this.hNp.a(this);
        bZs();
        this.hHY.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.gZl += i2;
                if (PersonalizePageView.this.hNw != null) {
                    m item = PersonalizePageView.this.hHY.getItem(PersonalizePageView.this.cWO.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.k) {
                        if (((com.baidu.tieba.card.data.k) item).position >= 6) {
                            PersonalizePageView.this.hNw.show();
                        } else {
                            PersonalizePageView.this.hNw.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.cWO != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.gZl < height * 3 || PersonalizePageView.this.ebH != 1) {
                        if (PersonalizePageView.this.gZl < height * 3 && PersonalizePageView.this.ebH == 2) {
                            PersonalizePageView.this.ebH = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.ebH = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.ebH)));
                    }
                    if (PersonalizePageView.this.cWO.getItemCount() - PersonalizePageView.this.cWO.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.blb();
                    }
                }
            }
        });
        this.hHY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.blb();
            }
        });
        this.hHY.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.hNr >= 5000) {
                    PersonalizePageView.this.hNo.cb(i, i2);
                }
            }
        }, 1L);
        this.hHY.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.hNo != null && PersonalizePageView.this.hNo.bPv() != null) {
                        PersonalizePageView.this.hNo.bPv().ct(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                        ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bFB().stopPlay();
                    }
                }
            }
        });
        this.hHY.removeOnScrollListener(this.mOnScrollListener);
        this.hHY.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.hNn = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.ePm != null) {
            this.ePm.setText(getContext().getString(R.string.pb_load_more));
            this.ePm.endLoadData();
            this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hNo.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.hNo != null) {
            this.hNo.nR(!z);
        }
        this.hNt = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.hNt;
    }

    public void e(Long l) {
        this.hNo.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.hNo != null) {
            this.hNo.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void showFloatingView() {
        if (this.hNo != null) {
            this.hNo.showFloatingView();
        }
    }

    public void bZt() {
        if (this.hNo != null) {
            this.hNo.bZt();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.eYb != null) {
                this.eYb.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.hNk != null) {
                this.hNk.changeSkin(i);
            }
            if (this.ePm != null) {
                this.ePm.setTextColor(am.getColor(R.color.cp_cont_d));
                this.ePm.changeSkin(i);
            }
            this.hNm.onChangeSkinType(i);
            if (this.hNo != null) {
                this.hNo.onChangeSkinType(i);
            }
            if (this.hNw != null) {
                this.hNw.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aO(String str, int i) {
        if (this.ePm != null) {
            this.ePm.setText(getContext().getString(R.string.pb_load_more));
            this.ePm.endLoadData();
            this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hNo.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.hNo != null) {
                        PersonalizePageView.this.hNo.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blt() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.eYb != null) {
            this.eYb.dettachView(this);
            this.eYb = null;
            this.hHY.setNextPage(this.ePm);
            this.ePm.setText(getContext().getString(R.string.pb_load_more));
            this.ePm.endLoadData();
            this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.hIg != null) {
            this.hIg.setVisibility(0);
        }
        if (this.hNn != null) {
            this.hNn.bYj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJu() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(boolean z) {
        if (this.eYb == null) {
            this.eYb = new com.baidu.tbadk.k.g(getContext());
            this.eYb.aZ(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
            this.eYb.aYp();
            this.eYb.setWrapStyle(true);
            this.eYb.onChangeSkinType();
        }
        this.eYb.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.hHY.setNextPage(null);
        if (this.hIg != null) {
            this.hIg.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.hNo != null) {
            this.hNo.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.hay != null) {
            this.hay.biK();
        }
        setViewForeground(false);
        if (this.hNo != null) {
            this.hNo.mC(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.hNu < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.hNA, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.hNo != null) {
            this.hNo.nH(z);
        }
        if (this.hIe != null) {
            this.hIe.b(this.hIf);
            this.hIe.a(this.hIf);
            this.hIf.bYD();
        }
    }

    public void bYs() {
        if (this.hNo != null) {
            fK(true);
            this.hNo.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.aIm().aIo();
            com.baidu.tbadk.core.bigday.b.aIm().aIn();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.hNo != null) {
            this.hNo.update();
        } else if (this.hHY != null && this.hIg != null) {
            showFloatingView();
            this.hHY.setSelection(0);
            if (!this.hIg.isRefreshing()) {
                if (this.hNo != null && this.hNo.bPv() != null) {
                    this.hNo.bPv().bZf();
                    this.hNo.nN(false);
                }
                this.hIg.setRefreshing(true);
            }
            if (this.hIf != null) {
                this.hIf.bYD();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gJp);
        MessageManager.getInstance().unRegisterListener(this.gZM);
        MessageManager.getInstance().unRegisterListener(this.hNB);
        this.hNo.onDestroy();
        this.hNm.b((NEGFeedBackView.a) null);
        this.hNm.onDestroy();
        this.hNo.a((e.a) null);
        if (this.hNj != null) {
            this.hNj.setListPullRefreshListener(null);
            this.hNj.a((g.d) null);
            this.hNj.a((g.a) null);
            this.hNj.a((g.b) null);
            this.hNj.release();
        }
        if (this.hNk != null) {
            this.hNk.setListPullRefreshListener(null);
            this.hNk.a((g.d) null);
            this.hNk.a((g.a) null);
            this.hNk.a((g.b) null);
            this.hNk.release();
        }
        this.hHY.setOnSrollToBottomListener(null);
        if (this.hIe != null) {
            this.hIe.b(this.hIf);
        }
        this.hHY.removeOnScrollListener(this.mOnScrollListener);
        if (this.eYb != null) {
            this.eYb.release();
        }
        this.hHY.setRecyclerListener(null);
        if (this.hNp != null) {
            this.hNp.onDestroy();
        }
        if (this.hay != null) {
            this.hay.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.aIm().destroy();
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hNA);
    }

    public void onPause() {
        this.hNo.onPause();
        if (this.hNm != null) {
            this.hNm.onPause();
        }
    }

    public void onResume() {
        if (this.gZb) {
            reload();
            this.gZb = false;
        }
        if (this.hIg != null) {
            this.hIg.resume();
        }
        if (this.hNm != null) {
            this.hNm.onResume();
        }
    }

    public void bXU() {
        if (this.hNm != null) {
            this.hNm.notifyDataSetChanged();
        }
    }

    public void bXV() {
        if (this.hNo != null) {
            this.hNo.mC(true);
        }
        r.bEY().jd(false);
        com.baidu.tieba.a.d.bfP().cF("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hNA);
    }

    public void bZp() {
        this.hNo.bZH();
    }

    public void bZu() {
        this.hNo.bZu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blb() {
        com.baidu.tieba.homepage.framework.a.bYi().q(System.currentTimeMillis(), 1);
        if (this.ePm != null && !this.ePm.isLoading()) {
            this.ePm.startLoadData();
            this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hNo.blb();
    }
}
