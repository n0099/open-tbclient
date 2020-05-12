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
    private LinearLayoutManager cWT;
    private final CustomMessageListener dOP;
    private PbListView ePr;
    private int eRI;
    private g eYg;
    private int ebM;
    private k gJt;
    private CustomMessageListener gJv;
    private CustomMessageListener gZS;
    private boolean gZh;
    private int gZr;
    private BdTypeRecyclerView hIe;
    private ScrollFragmentTabHost hIk;
    ScrollFragmentTabHost.a hIl;
    private BigdaySwipeRefreshLayout hIm;
    private View.OnClickListener hIo;
    g.d hMR;
    g.b hMS;
    private NEGFeedBackView.a hMp;
    private int hNA;
    private boolean hNB;
    private FRSRefreshButton hNC;
    private e.a hND;
    g.c hNE;
    g.a hNF;
    private Runnable hNG;
    public CustomMessageListener hNH;
    private View.OnClickListener hNI;
    private com.baidu.tieba.homepage.personalize.bigday.b hNp;
    private com.baidu.tieba.homepage.personalize.bigday.a hNq;
    private a hNr;
    private ad hNs;
    private com.baidu.tieba.homepage.framework.b hNt;
    private e hNu;
    private com.baidu.tieba.homepage.personalize.a hNv;
    private com.baidu.tieba.homepage.personalize.model.e hNw;
    private long hNx;
    private FloatingAnimationView hNy;
    private boolean hNz;
    private com.baidu.tieba.c.c haE;
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
        int i = personalizePageView.hNA + 1;
        personalizePageView.hNA = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hIk = scrollFragmentTabHost;
        if (this.hIk != null) {
            this.hIk.b(this.hIl);
            this.hIk.a(this.hIl);
        }
        if (this.hNu != null) {
            this.hNu.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hNv != null) {
            this.hNv.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.hIm != null) {
            this.hIm.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hNs != null) {
            this.hNs.setPageUniqueId(bdUniqueId);
        }
        if (this.hNu != null) {
            this.hNu.m(bdUniqueId);
        }
        if (this.hNw != null) {
            this.hNw.h(bdUniqueId);
        }
        if (this.hNq != null) {
            this.hNq.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.aIk().setTag(bdUniqueId);
        if (this.dOP != null) {
            this.dOP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dOP);
        }
        if (this.hNv != null) {
            this.hNv.setBdUniqueId(bdUniqueId);
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
        oVar.KQ(floatInfo.float_url);
        oVar.KP(floatInfo.jump_url);
        oVar.setType(floatInfo.show_type.intValue());
        return oVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.hNx = 0L;
        this.mSkinType = 3;
        this.gZh = false;
        this.hNz = false;
        this.hNA = 0;
        this.gZr = 0;
        this.hNB = false;
        this.ebM = 1;
        this.gJv = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gJt == null) {
                            PersonalizePageView.this.gJt = new k(new i());
                        }
                        PersonalizePageView.this.gJt.a(PersonalizePageView.this.hIe, 2);
                    } else if (PersonalizePageView.this.gJt != null) {
                        PersonalizePageView.this.gJt.pf();
                    }
                }
            }
        };
        this.hMp = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.hNs != null) {
                        PersonalizePageView.this.hNs.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fid", alVar.getFid()).cI("obj_param1", alVar.weight).cI("obj_source", alVar.source).cI("obj_id", alVar.extra).cI("obj_type", sb.toString()).cI("obj_name", str).af(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.eRI = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.eRI != i && PersonalizePageView.this.hIk != null) {
                    PersonalizePageView.this.eRI = i;
                    if (PersonalizePageView.this.eRI == 1) {
                        PersonalizePageView.this.hIk.blG();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.hIk.blH();
                    } else {
                        PersonalizePageView.this.hIk.blG();
                    }
                }
            }
        };
        this.hIl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bYC() {
                if (PersonalizePageView.this.hIk != null) {
                    PersonalizePageView.this.eRI = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.hIe)) {
                        PersonalizePageView.this.hIk.blH();
                    } else {
                        PersonalizePageView.this.hIk.blG();
                    }
                }
            }
        };
        this.hND = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gRw = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("key_first_install", true);

            private void bZu() {
                if (this.gRw) {
                    this.gRw = false;
                    com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.hNt == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bJt = PersonalizePageView.this.bJt();
                PersonalizePageView.this.blr();
                if (bJt) {
                    PersonalizePageView.this.fK(true);
                }
                PersonalizePageView.this.hNt.P(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hNt != null) {
                    PersonalizePageView.this.hNt.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bZu();
                } else if (!this.gRw) {
                    PersonalizePageView.this.hIm.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bZu();
                    PersonalizePageView.this.bYr();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bZu();
                PersonalizePageView.this.hIm.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.blr();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hNu.bZH());
                PersonalizePageView.this.ew(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.haE != null) {
                    PersonalizePageView.this.haE.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bZv() {
                if (PersonalizePageView.this.ePr != null) {
                    PersonalizePageView.this.ePr.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.ePr.endLoadData();
                    PersonalizePageView.this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hNE = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bfN().ye("page_recommend");
                PersonalizePageView.this.hNu.update();
                PersonalizePageView.this.hNu.nN(false);
                PersonalizePageView.this.hNB = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hMR = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hNu != null && PersonalizePageView.this.hNu.bPu() != null) {
                    PersonalizePageView.this.hNu.bPu().bZe();
                }
            }
        };
        this.hNF = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aQv() {
                if (PersonalizePageView.this.hNB) {
                    PersonalizePageView.this.gZr = 0;
                    PersonalizePageView.this.ebM = 1;
                    PersonalizePageView.this.hNB = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hMS = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hNu != null) {
                    PersonalizePageView.this.hNu.nN(true);
                    PersonalizePageView.this.hNu.bZA();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aNT().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aIk().jA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hNG = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aNT().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.dOP = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bXT();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.hIo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bkZ();
            }
        };
        this.gZS = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gZh = true;
                    }
                }
            }
        };
        this.hNH = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.hIm != null && !PersonalizePageView.this.hIm.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hNq == null) {
                            PersonalizePageView.this.hNq = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hNq.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hNr = PersonalizePageView.this.hNq;
                            PersonalizePageView.this.bZr();
                        } else if (PersonalizePageView.this.hNr != PersonalizePageView.this.hNq) {
                            PersonalizePageView.this.hNr = PersonalizePageView.this.hNq;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hNq.setEnable(true);
                        PersonalizePageView.this.hIm.setProgressView(PersonalizePageView.this.hNq);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.hIm.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hNp == null) {
                        PersonalizePageView.this.hNp = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hNr = PersonalizePageView.this.hNp;
                        PersonalizePageView.this.bZr();
                    } else if (PersonalizePageView.this.hNr != PersonalizePageView.this.hNp || !aVar.equals(PersonalizePageView.this.hNp.bZT())) {
                        PersonalizePageView.this.hNr = PersonalizePageView.this.hNp;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hNp.setEnable(true);
                    PersonalizePageView.this.hIm.setProgressView(PersonalizePageView.this.hNp);
                    PersonalizePageView.this.hNp.a(aVar);
                    PersonalizePageView.this.hIm.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hNI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hNC != null) {
                    PersonalizePageView.this.hNC.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hNx = 0L;
        this.mSkinType = 3;
        this.gZh = false;
        this.hNz = false;
        this.hNA = 0;
        this.gZr = 0;
        this.hNB = false;
        this.ebM = 1;
        this.gJv = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gJt == null) {
                            PersonalizePageView.this.gJt = new k(new i());
                        }
                        PersonalizePageView.this.gJt.a(PersonalizePageView.this.hIe, 2);
                    } else if (PersonalizePageView.this.gJt != null) {
                        PersonalizePageView.this.gJt.pf();
                    }
                }
            }
        };
        this.hMp = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.hNs != null) {
                        PersonalizePageView.this.hNs.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fid", alVar.getFid()).cI("obj_param1", alVar.weight).cI("obj_source", alVar.source).cI("obj_id", alVar.extra).cI("obj_type", sb.toString()).cI("obj_name", str).af(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.eRI = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.eRI != i && PersonalizePageView.this.hIk != null) {
                    PersonalizePageView.this.eRI = i;
                    if (PersonalizePageView.this.eRI == 1) {
                        PersonalizePageView.this.hIk.blG();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.hIk.blH();
                    } else {
                        PersonalizePageView.this.hIk.blG();
                    }
                }
            }
        };
        this.hIl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bYC() {
                if (PersonalizePageView.this.hIk != null) {
                    PersonalizePageView.this.eRI = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.hIe)) {
                        PersonalizePageView.this.hIk.blH();
                    } else {
                        PersonalizePageView.this.hIk.blG();
                    }
                }
            }
        };
        this.hND = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gRw = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("key_first_install", true);

            private void bZu() {
                if (this.gRw) {
                    this.gRw = false;
                    com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.hNt == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bJt = PersonalizePageView.this.bJt();
                PersonalizePageView.this.blr();
                if (bJt) {
                    PersonalizePageView.this.fK(true);
                }
                PersonalizePageView.this.hNt.P(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hNt != null) {
                    PersonalizePageView.this.hNt.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bZu();
                } else if (!this.gRw) {
                    PersonalizePageView.this.hIm.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bZu();
                    PersonalizePageView.this.bYr();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bZu();
                PersonalizePageView.this.hIm.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.blr();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hNu.bZH());
                PersonalizePageView.this.ew(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.haE != null) {
                    PersonalizePageView.this.haE.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bZv() {
                if (PersonalizePageView.this.ePr != null) {
                    PersonalizePageView.this.ePr.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.ePr.endLoadData();
                    PersonalizePageView.this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hNE = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bfN().ye("page_recommend");
                PersonalizePageView.this.hNu.update();
                PersonalizePageView.this.hNu.nN(false);
                PersonalizePageView.this.hNB = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hMR = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hNu != null && PersonalizePageView.this.hNu.bPu() != null) {
                    PersonalizePageView.this.hNu.bPu().bZe();
                }
            }
        };
        this.hNF = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aQv() {
                if (PersonalizePageView.this.hNB) {
                    PersonalizePageView.this.gZr = 0;
                    PersonalizePageView.this.ebM = 1;
                    PersonalizePageView.this.hNB = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hMS = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hNu != null) {
                    PersonalizePageView.this.hNu.nN(true);
                    PersonalizePageView.this.hNu.bZA();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aNT().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aIk().jA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hNG = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aNT().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.dOP = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bXT();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.hIo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bkZ();
            }
        };
        this.gZS = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gZh = true;
                    }
                }
            }
        };
        this.hNH = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.hIm != null && !PersonalizePageView.this.hIm.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hNq == null) {
                            PersonalizePageView.this.hNq = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hNq.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hNr = PersonalizePageView.this.hNq;
                            PersonalizePageView.this.bZr();
                        } else if (PersonalizePageView.this.hNr != PersonalizePageView.this.hNq) {
                            PersonalizePageView.this.hNr = PersonalizePageView.this.hNq;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hNq.setEnable(true);
                        PersonalizePageView.this.hIm.setProgressView(PersonalizePageView.this.hNq);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.hIm.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hNp == null) {
                        PersonalizePageView.this.hNp = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hNr = PersonalizePageView.this.hNp;
                        PersonalizePageView.this.bZr();
                    } else if (PersonalizePageView.this.hNr != PersonalizePageView.this.hNp || !aVar.equals(PersonalizePageView.this.hNp.bZT())) {
                        PersonalizePageView.this.hNr = PersonalizePageView.this.hNp;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hNp.setEnable(true);
                    PersonalizePageView.this.hIm.setProgressView(PersonalizePageView.this.hNp);
                    PersonalizePageView.this.hNp.a(aVar);
                    PersonalizePageView.this.hIm.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hNI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hNC != null) {
                    PersonalizePageView.this.hNC.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNx = 0L;
        this.mSkinType = 3;
        this.gZh = false;
        this.hNz = false;
        this.hNA = 0;
        this.gZr = 0;
        this.hNB = false;
        this.ebM = 1;
        this.gJv = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gJt == null) {
                            PersonalizePageView.this.gJt = new k(new i());
                        }
                        PersonalizePageView.this.gJt.a(PersonalizePageView.this.hIe, 2);
                    } else if (PersonalizePageView.this.gJt != null) {
                        PersonalizePageView.this.gJt.pf();
                    }
                }
            }
        };
        this.hMp = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.hNs != null) {
                        PersonalizePageView.this.hNs.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fid", alVar.getFid()).cI("obj_param1", alVar.weight).cI("obj_source", alVar.source).cI("obj_id", alVar.extra).cI("obj_type", sb.toString()).cI("obj_name", str).af(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.eRI = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.eRI != i2 && PersonalizePageView.this.hIk != null) {
                    PersonalizePageView.this.eRI = i2;
                    if (PersonalizePageView.this.eRI == 1) {
                        PersonalizePageView.this.hIk.blG();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.hIk.blH();
                    } else {
                        PersonalizePageView.this.hIk.blG();
                    }
                }
            }
        };
        this.hIl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bYC() {
                if (PersonalizePageView.this.hIk != null) {
                    PersonalizePageView.this.eRI = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.hIe)) {
                        PersonalizePageView.this.hIk.blH();
                    } else {
                        PersonalizePageView.this.hIk.blG();
                    }
                }
            }
        };
        this.hND = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gRw = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("key_first_install", true);

            private void bZu() {
                if (this.gRw) {
                    this.gRw = false;
                    com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i2, int i22, int i3) {
                if (PersonalizePageView.this.hNt == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bJt = PersonalizePageView.this.bJt();
                PersonalizePageView.this.blr();
                if (bJt) {
                    PersonalizePageView.this.fK(true);
                }
                PersonalizePageView.this.hNt.P(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.hNt != null) {
                    PersonalizePageView.this.hNt.y(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bZu();
                } else if (!this.gRw) {
                    PersonalizePageView.this.hIm.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bZu();
                    PersonalizePageView.this.bYr();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bZu();
                PersonalizePageView.this.hIm.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.blr();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hNu.bZH());
                PersonalizePageView.this.ew(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.haE != null) {
                    PersonalizePageView.this.haE.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bZv() {
                if (PersonalizePageView.this.ePr != null) {
                    PersonalizePageView.this.ePr.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.ePr.endLoadData();
                    PersonalizePageView.this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hNE = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bfN().ye("page_recommend");
                PersonalizePageView.this.hNu.update();
                PersonalizePageView.this.hNu.nN(false);
                PersonalizePageView.this.hNB = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hMR = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hNu != null && PersonalizePageView.this.hNu.bPu() != null) {
                    PersonalizePageView.this.hNu.bPu().bZe();
                }
            }
        };
        this.hNF = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aQv() {
                if (PersonalizePageView.this.hNB) {
                    PersonalizePageView.this.gZr = 0;
                    PersonalizePageView.this.ebM = 1;
                    PersonalizePageView.this.hNB = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hMS = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hNu != null) {
                    PersonalizePageView.this.hNu.nN(true);
                    PersonalizePageView.this.hNu.bZA();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aNT().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aIk().jA(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hNG = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aNT().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.dOP = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bXT();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.hIo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bkZ();
            }
        };
        this.gZS = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gZh = true;
                    }
                }
            }
        };
        this.hNH = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.hIm != null && !PersonalizePageView.this.hIm.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hNq == null) {
                            PersonalizePageView.this.hNq = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hNq.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hNr = PersonalizePageView.this.hNq;
                            PersonalizePageView.this.bZr();
                        } else if (PersonalizePageView.this.hNr != PersonalizePageView.this.hNq) {
                            PersonalizePageView.this.hNr = PersonalizePageView.this.hNq;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hNq.setEnable(true);
                        PersonalizePageView.this.hIm.setProgressView(PersonalizePageView.this.hNq);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.hIm.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hNp == null) {
                        PersonalizePageView.this.hNp = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hNr = PersonalizePageView.this.hNp;
                        PersonalizePageView.this.bZr();
                    } else if (PersonalizePageView.this.hNr != PersonalizePageView.this.hNp || !aVar.equals(PersonalizePageView.this.hNp.bZT())) {
                        PersonalizePageView.this.hNr = PersonalizePageView.this.hNp;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hNp.setEnable(true);
                    PersonalizePageView.this.hIm.setProgressView(PersonalizePageView.this.hNp);
                    PersonalizePageView.this.hNp.a(aVar);
                    PersonalizePageView.this.hIm.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hNI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hNC != null) {
                    PersonalizePageView.this.hNC.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hIe = new BdTypeRecyclerView(context);
        this.cWT = new LinearLayoutManager(this.hIe.getContext());
        this.hIe.setLayoutManager(this.cWT);
        this.hIe.setFadingEdgeLength(0);
        this.hIe.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gJt = new k(new i());
            this.gJt.a(this.hIe, 2);
        }
        MessageManager.getInstance().registerListener(this.gJv);
        this.hIm = new BigdaySwipeRefreshLayout(context);
        this.hIm.addView(this.hIe);
        this.ePr = new PbListView(context);
        this.ePr.getView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setLineGone();
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePr.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.ePr.setOnClickListener(this.hIo);
        this.ePr.aQa();
        this.hIe.setNextPage(this.ePr);
        com.baidu.adp.base.e<?> G = com.baidu.adp.base.i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        MessageManager.getInstance().registerListener(this.hNH);
        com.baidu.tbadk.core.bigday.b.aIk().gr(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aNT().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.aIk().jA(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.hIm);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.hNC = new FRSRefreshButton(context);
            int dimens = l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds180);
            addView(this.hNC, layoutParams);
            this.hNC.setOnClickListener(this.hNI);
            this.hNC.setVisibility(8);
        }
        this.hNw = new com.baidu.tieba.homepage.personalize.model.e();
        this.hNs = new ad(context, this.hIe);
        this.hNs.b(this.hNw);
        this.hNu = new e(this.pageContext, this.hIe, this.hNs, this.hIm);
        this.hNv = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.gZS);
        this.hNA = com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew(Context context) {
        if (this.hNy == null) {
            this.hNy = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds200);
            addView(this.hNy, layoutParams);
            this.hNy.setVisibility(8);
            this.hNy.setPageId(this.pageContext.getUniqueId());
            this.haE = new com.baidu.tieba.c.c(this.pageContext, this.hNy, 1);
        }
    }

    public void bZr() {
        if (this.hNr != null) {
            this.hNr.setListPullRefreshListener(this.hNE);
            this.hNr.a(this.hMR);
            this.hNr.a(this.hNF);
            this.hNr.a(this.hMS);
        }
    }

    public void bqI() {
        this.hNs.b(this.hMp);
        this.hNu.a(this.hND);
        this.hNv.a(this);
        bZr();
        this.hIe.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.gZr += i2;
                if (PersonalizePageView.this.hNC != null) {
                    m item = PersonalizePageView.this.hIe.getItem(PersonalizePageView.this.cWT.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.k) {
                        if (((com.baidu.tieba.card.data.k) item).position >= 6) {
                            PersonalizePageView.this.hNC.show();
                        } else {
                            PersonalizePageView.this.hNC.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.cWT != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.gZr < height * 3 || PersonalizePageView.this.ebM != 1) {
                        if (PersonalizePageView.this.gZr < height * 3 && PersonalizePageView.this.ebM == 2) {
                            PersonalizePageView.this.ebM = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.ebM = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.ebM)));
                    }
                    if (PersonalizePageView.this.cWT.getItemCount() - PersonalizePageView.this.cWT.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bkZ();
                    }
                }
            }
        });
        this.hIe.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bkZ();
            }
        });
        this.hIe.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.hNx >= 5000) {
                    PersonalizePageView.this.hNu.cb(i, i2);
                }
            }
        }, 1L);
        this.hIe.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.hNu != null && PersonalizePageView.this.hNu.bPu() != null) {
                        PersonalizePageView.this.hNu.bPu().ct(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                        ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bFA().stopPlay();
                    }
                }
            }
        });
        this.hIe.removeOnScrollListener(this.mOnScrollListener);
        this.hIe.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.hNt = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.ePr != null) {
            this.ePr.setText(getContext().getString(R.string.pb_load_more));
            this.ePr.endLoadData();
            this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hNu.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.hNu != null) {
            this.hNu.nR(!z);
        }
        this.hNz = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.hNz;
    }

    public void e(Long l) {
        this.hNu.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.hNu != null) {
            this.hNu.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void showFloatingView() {
        if (this.hNu != null) {
            this.hNu.showFloatingView();
        }
    }

    public void bZs() {
        if (this.hNu != null) {
            this.hNu.bZs();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.eYg != null) {
                this.eYg.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.hNq != null) {
                this.hNq.changeSkin(i);
            }
            if (this.ePr != null) {
                this.ePr.setTextColor(am.getColor(R.color.cp_cont_d));
                this.ePr.changeSkin(i);
            }
            this.hNs.onChangeSkinType(i);
            if (this.hNu != null) {
                this.hNu.onChangeSkinType(i);
            }
            if (this.hNC != null) {
                this.hNC.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aO(String str, int i) {
        if (this.ePr != null) {
            this.ePr.setText(getContext().getString(R.string.pb_load_more));
            this.ePr.endLoadData();
            this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hNu.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.hNu != null) {
                        PersonalizePageView.this.hNu.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blr() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.eYg != null) {
            this.eYg.dettachView(this);
            this.eYg = null;
            this.hIe.setNextPage(this.ePr);
            this.ePr.setText(getContext().getString(R.string.pb_load_more));
            this.ePr.endLoadData();
            this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.hIm != null) {
            this.hIm.setVisibility(0);
        }
        if (this.hNt != null) {
            this.hNt.bYi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJt() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(boolean z) {
        if (this.eYg == null) {
            this.eYg = new com.baidu.tbadk.k.g(getContext());
            this.eYg.aZ(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
            this.eYg.aYn();
            this.eYg.setWrapStyle(true);
            this.eYg.onChangeSkinType();
        }
        this.eYg.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.hIe.setNextPage(null);
        if (this.hIm != null) {
            this.hIm.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.hNu != null) {
            this.hNu.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.haE != null) {
            this.haE.biI();
        }
        setViewForeground(false);
        if (this.hNu != null) {
            this.hNu.mC(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.hNA < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.hNG, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.hNu != null) {
            this.hNu.nH(z);
        }
        if (this.hIk != null) {
            this.hIk.b(this.hIl);
            this.hIk.a(this.hIl);
            this.hIl.bYC();
        }
    }

    public void bYr() {
        if (this.hNu != null) {
            fK(true);
            this.hNu.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.aIk().aIm();
            com.baidu.tbadk.core.bigday.b.aIk().aIl();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.hNu != null) {
            this.hNu.update();
        } else if (this.hIe != null && this.hIm != null) {
            showFloatingView();
            this.hIe.setSelection(0);
            if (!this.hIm.isRefreshing()) {
                if (this.hNu != null && this.hNu.bPu() != null) {
                    this.hNu.bPu().bZe();
                    this.hNu.nN(false);
                }
                this.hIm.setRefreshing(true);
            }
            if (this.hIl != null) {
                this.hIl.bYC();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gJv);
        MessageManager.getInstance().unRegisterListener(this.gZS);
        MessageManager.getInstance().unRegisterListener(this.hNH);
        this.hNu.onDestroy();
        this.hNs.b((NEGFeedBackView.a) null);
        this.hNs.onDestroy();
        this.hNu.a((e.a) null);
        if (this.hNp != null) {
            this.hNp.setListPullRefreshListener(null);
            this.hNp.a((g.d) null);
            this.hNp.a((g.a) null);
            this.hNp.a((g.b) null);
            this.hNp.release();
        }
        if (this.hNq != null) {
            this.hNq.setListPullRefreshListener(null);
            this.hNq.a((g.d) null);
            this.hNq.a((g.a) null);
            this.hNq.a((g.b) null);
            this.hNq.release();
        }
        this.hIe.setOnSrollToBottomListener(null);
        if (this.hIk != null) {
            this.hIk.b(this.hIl);
        }
        this.hIe.removeOnScrollListener(this.mOnScrollListener);
        if (this.eYg != null) {
            this.eYg.release();
        }
        this.hIe.setRecyclerListener(null);
        if (this.hNv != null) {
            this.hNv.onDestroy();
        }
        if (this.haE != null) {
            this.haE.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.aIk().destroy();
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hNG);
    }

    public void onPause() {
        this.hNu.onPause();
        if (this.hNs != null) {
            this.hNs.onPause();
        }
    }

    public void onResume() {
        if (this.gZh) {
            reload();
            this.gZh = false;
        }
        if (this.hIm != null) {
            this.hIm.resume();
        }
        if (this.hNs != null) {
            this.hNs.onResume();
        }
    }

    public void bXT() {
        if (this.hNs != null) {
            this.hNs.notifyDataSetChanged();
        }
    }

    public void bXU() {
        if (this.hNu != null) {
            this.hNu.mC(true);
        }
        r.bEX().jd(false);
        com.baidu.tieba.a.d.bfN().cF("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hNG);
    }

    public void bZo() {
        this.hNu.bZG();
    }

    public void bZt() {
        this.hNu.bZt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkZ() {
        com.baidu.tieba.homepage.framework.a.bYh().q(System.currentTimeMillis(), 1);
        if (this.ePr != null && !this.ePr.isLoading()) {
            this.ePr.startLoadData();
            this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hNu.bkZ();
    }
}
