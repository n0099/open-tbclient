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
import com.baidu.tieba.homepage.personalize.a.ab;
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
    private LinearLayoutManager cxG;
    private int dBJ;
    private final CustomMessageListener doF;
    private PbListView elw;
    private int enO;
    private g euk;
    private BdTypeRecyclerView gXa;
    private ScrollFragmentTabHost gXg;
    ScrollFragmentTabHost.a gXh;
    private BigdaySwipeRefreshLayout gXi;
    private View.OnClickListener gXk;
    private k gax;
    private CustomMessageListener gaz;
    private CustomMessageListener gpU;
    private boolean gpl;
    private int gpu;
    private com.baidu.tieba.c.c gqB;
    g.d hbN;
    g.b hbO;
    private NEGFeedBackView.a hbl;
    private e.a hcA;
    g.c hcB;
    g.a hcC;
    private Runnable hcD;
    public CustomMessageListener hcE;
    private View.OnClickListener hcF;
    private com.baidu.tieba.homepage.personalize.bigday.b hcm;
    private com.baidu.tieba.homepage.personalize.bigday.a hcn;
    private a hco;
    private ab hcp;
    private com.baidu.tieba.homepage.framework.b hcq;
    private e hcr;
    private com.baidu.tieba.homepage.personalize.a hcs;
    private com.baidu.tieba.homepage.personalize.model.e hct;
    private long hcu;
    private FloatingAnimationView hcv;
    private boolean hcw;
    private int hcx;
    private boolean hcy;
    private FRSRefreshButton hcz;
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
        int i = personalizePageView.hcx + 1;
        personalizePageView.hcx = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gXg = scrollFragmentTabHost;
        if (this.gXg != null) {
            this.gXg.b(this.gXh);
            this.gXg.a(this.gXh);
        }
        if (this.hcr != null) {
            this.hcr.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hcs != null) {
            this.hcs.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.gXi != null) {
            this.gXi.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hcp != null) {
            this.hcp.setPageUniqueId(bdUniqueId);
        }
        if (this.hcr != null) {
            this.hcr.m(bdUniqueId);
        }
        if (this.hct != null) {
            this.hct.h(bdUniqueId);
        }
        if (this.hcn != null) {
            this.hcn.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.azW().setTag(bdUniqueId);
        if (this.doF != null) {
            this.doF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.doF);
        }
        if (this.hcs != null) {
            this.hcs.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        o oVar = new o();
        oVar.aC(String.valueOf(floatInfo.activity_id));
        oVar.ee(floatInfo.dynamic_url);
        oVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        oVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        oVar.Je(floatInfo.float_url);
        oVar.Jd(floatInfo.jump_url);
        oVar.setType(floatInfo.show_type.intValue());
        return oVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.hcu = 0L;
        this.mSkinType = 3;
        this.gpl = false;
        this.hcw = false;
        this.hcx = 0;
        this.gpu = 0;
        this.hcy = false;
        this.dBJ = 1;
        this.gaz = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gax == null) {
                            PersonalizePageView.this.gax = new k(new i());
                        }
                        PersonalizePageView.this.gax.a(PersonalizePageView.this.gXa, 2);
                    } else if (PersonalizePageView.this.gax != null) {
                        PersonalizePageView.this.gax.kB();
                    }
                }
            }
        };
        this.hbl = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cy("obj_locate", "1").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.hcp != null) {
                        PersonalizePageView.this.hcp.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", alVar.getFid()).cy("obj_param1", alVar.weight).cy("obj_source", alVar.source).cy("obj_id", alVar.extra).cy("obj_type", sb.toString()).cy("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.enO = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.enO != i && PersonalizePageView.this.gXg != null) {
                    PersonalizePageView.this.enO = i;
                    if (PersonalizePageView.this.enO == 1) {
                        PersonalizePageView.this.gXg.bcN();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gXg.bcO();
                    } else {
                        PersonalizePageView.this.gXg.bcN();
                    }
                }
            }
        };
        this.gXh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNO() {
                if (PersonalizePageView.this.gXg != null) {
                    PersonalizePageView.this.enO = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gXa)) {
                        PersonalizePageView.this.gXg.bcO();
                    } else {
                        PersonalizePageView.this.gXg.bcN();
                    }
                }
            }
        };
        this.hcA = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean ghA = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_first_install", true);

            private void bOG() {
                if (this.ghA) {
                    this.ghA = false;
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i, int i2, int i3) {
                if (PersonalizePageView.this.hcq == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bzm = PersonalizePageView.this.bzm();
                PersonalizePageView.this.bcy();
                if (bzm) {
                    PersonalizePageView.this.eM(true);
                }
                PersonalizePageView.this.hcq.M(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hcq != null) {
                    PersonalizePageView.this.hcq.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bOG();
                } else if (!this.ghA) {
                    PersonalizePageView.this.gXi.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bOG();
                    PersonalizePageView.this.bND();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bOG();
                PersonalizePageView.this.gXi.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bcy();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hcr.bOT());
                PersonalizePageView.this.eQ(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.gqB != null) {
                    PersonalizePageView.this.gqB.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bOH() {
                if (PersonalizePageView.this.elw != null) {
                    PersonalizePageView.this.elw.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.elw.endLoadData();
                    PersonalizePageView.this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hcB = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aXG().wO("page_recommend");
                PersonalizePageView.this.hcr.update();
                PersonalizePageView.this.hcr.mD(false);
                PersonalizePageView.this.hcy = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hbN = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hcr != null && PersonalizePageView.this.hcr.bEL() != null) {
                    PersonalizePageView.this.hcr.bEL().bOq();
                }
            }
        };
        this.hcC = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aHY() {
                if (PersonalizePageView.this.hcy) {
                    PersonalizePageView.this.gpu = 0;
                    PersonalizePageView.this.dBJ = 1;
                    PersonalizePageView.this.hcy = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hbO = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hcr != null) {
                    PersonalizePageView.this.hcr.mD(true);
                    PersonalizePageView.this.hcr.bOM();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFD().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.azW().jt(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hcD = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.doF = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bNf();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gXk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bcg();
            }
        };
        this.gpU = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gpl = true;
                    }
                }
            }
        };
        this.hcE = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gXi != null && !PersonalizePageView.this.gXi.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hcn == null) {
                            PersonalizePageView.this.hcn = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hcn.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hco = PersonalizePageView.this.hcn;
                            PersonalizePageView.this.bOD();
                        } else if (PersonalizePageView.this.hco != PersonalizePageView.this.hcn) {
                            PersonalizePageView.this.hco = PersonalizePageView.this.hcn;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hcn.setEnable(true);
                        PersonalizePageView.this.gXi.setProgressView(PersonalizePageView.this.hcn);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gXi.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hcm == null) {
                        PersonalizePageView.this.hcm = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hco = PersonalizePageView.this.hcm;
                        PersonalizePageView.this.bOD();
                    } else if (PersonalizePageView.this.hco != PersonalizePageView.this.hcm || !aVar.equals(PersonalizePageView.this.hcm.bPf())) {
                        PersonalizePageView.this.hco = PersonalizePageView.this.hcm;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hcm.setEnable(true);
                    PersonalizePageView.this.gXi.setProgressView(PersonalizePageView.this.hcm);
                    PersonalizePageView.this.hcm.a(aVar);
                    PersonalizePageView.this.gXi.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hcF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hcz != null) {
                    PersonalizePageView.this.hcz.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hcu = 0L;
        this.mSkinType = 3;
        this.gpl = false;
        this.hcw = false;
        this.hcx = 0;
        this.gpu = 0;
        this.hcy = false;
        this.dBJ = 1;
        this.gaz = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gax == null) {
                            PersonalizePageView.this.gax = new k(new i());
                        }
                        PersonalizePageView.this.gax.a(PersonalizePageView.this.gXa, 2);
                    } else if (PersonalizePageView.this.gax != null) {
                        PersonalizePageView.this.gax.kB();
                    }
                }
            }
        };
        this.hbl = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cy("obj_locate", "1").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.hcp != null) {
                        PersonalizePageView.this.hcp.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", alVar.getFid()).cy("obj_param1", alVar.weight).cy("obj_source", alVar.source).cy("obj_id", alVar.extra).cy("obj_type", sb.toString()).cy("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.enO = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.enO != i && PersonalizePageView.this.gXg != null) {
                    PersonalizePageView.this.enO = i;
                    if (PersonalizePageView.this.enO == 1) {
                        PersonalizePageView.this.gXg.bcN();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gXg.bcO();
                    } else {
                        PersonalizePageView.this.gXg.bcN();
                    }
                }
            }
        };
        this.gXh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNO() {
                if (PersonalizePageView.this.gXg != null) {
                    PersonalizePageView.this.enO = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gXa)) {
                        PersonalizePageView.this.gXg.bcO();
                    } else {
                        PersonalizePageView.this.gXg.bcN();
                    }
                }
            }
        };
        this.hcA = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean ghA = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_first_install", true);

            private void bOG() {
                if (this.ghA) {
                    this.ghA = false;
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i, int i2, int i3) {
                if (PersonalizePageView.this.hcq == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bzm = PersonalizePageView.this.bzm();
                PersonalizePageView.this.bcy();
                if (bzm) {
                    PersonalizePageView.this.eM(true);
                }
                PersonalizePageView.this.hcq.M(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hcq != null) {
                    PersonalizePageView.this.hcq.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bOG();
                } else if (!this.ghA) {
                    PersonalizePageView.this.gXi.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bOG();
                    PersonalizePageView.this.bND();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bOG();
                PersonalizePageView.this.gXi.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bcy();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hcr.bOT());
                PersonalizePageView.this.eQ(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.gqB != null) {
                    PersonalizePageView.this.gqB.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bOH() {
                if (PersonalizePageView.this.elw != null) {
                    PersonalizePageView.this.elw.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.elw.endLoadData();
                    PersonalizePageView.this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hcB = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aXG().wO("page_recommend");
                PersonalizePageView.this.hcr.update();
                PersonalizePageView.this.hcr.mD(false);
                PersonalizePageView.this.hcy = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hbN = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hcr != null && PersonalizePageView.this.hcr.bEL() != null) {
                    PersonalizePageView.this.hcr.bEL().bOq();
                }
            }
        };
        this.hcC = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aHY() {
                if (PersonalizePageView.this.hcy) {
                    PersonalizePageView.this.gpu = 0;
                    PersonalizePageView.this.dBJ = 1;
                    PersonalizePageView.this.hcy = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hbO = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hcr != null) {
                    PersonalizePageView.this.hcr.mD(true);
                    PersonalizePageView.this.hcr.bOM();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFD().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.azW().jt(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hcD = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.doF = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bNf();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gXk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bcg();
            }
        };
        this.gpU = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gpl = true;
                    }
                }
            }
        };
        this.hcE = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gXi != null && !PersonalizePageView.this.gXi.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hcn == null) {
                            PersonalizePageView.this.hcn = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hcn.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hco = PersonalizePageView.this.hcn;
                            PersonalizePageView.this.bOD();
                        } else if (PersonalizePageView.this.hco != PersonalizePageView.this.hcn) {
                            PersonalizePageView.this.hco = PersonalizePageView.this.hcn;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hcn.setEnable(true);
                        PersonalizePageView.this.gXi.setProgressView(PersonalizePageView.this.hcn);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gXi.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hcm == null) {
                        PersonalizePageView.this.hcm = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hco = PersonalizePageView.this.hcm;
                        PersonalizePageView.this.bOD();
                    } else if (PersonalizePageView.this.hco != PersonalizePageView.this.hcm || !aVar.equals(PersonalizePageView.this.hcm.bPf())) {
                        PersonalizePageView.this.hco = PersonalizePageView.this.hcm;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hcm.setEnable(true);
                    PersonalizePageView.this.gXi.setProgressView(PersonalizePageView.this.hcm);
                    PersonalizePageView.this.hcm.a(aVar);
                    PersonalizePageView.this.gXi.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hcF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hcz != null) {
                    PersonalizePageView.this.hcz.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hcu = 0L;
        this.mSkinType = 3;
        this.gpl = false;
        this.hcw = false;
        this.hcx = 0;
        this.gpu = 0;
        this.hcy = false;
        this.dBJ = 1;
        this.gaz = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gax == null) {
                            PersonalizePageView.this.gax = new k(new i());
                        }
                        PersonalizePageView.this.gax.a(PersonalizePageView.this.gXa, 2);
                    } else if (PersonalizePageView.this.gax != null) {
                        PersonalizePageView.this.gax.kB();
                    }
                }
            }
        };
        this.hbl = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cy("obj_locate", "1").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.hcp != null) {
                        PersonalizePageView.this.hcp.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", alVar.getFid()).cy("obj_param1", alVar.weight).cy("obj_source", alVar.source).cy("obj_id", alVar.extra).cy("obj_type", sb.toString()).cy("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.enO = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.enO != i2 && PersonalizePageView.this.gXg != null) {
                    PersonalizePageView.this.enO = i2;
                    if (PersonalizePageView.this.enO == 1) {
                        PersonalizePageView.this.gXg.bcN();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gXg.bcO();
                    } else {
                        PersonalizePageView.this.gXg.bcN();
                    }
                }
            }
        };
        this.gXh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNO() {
                if (PersonalizePageView.this.gXg != null) {
                    PersonalizePageView.this.enO = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gXa)) {
                        PersonalizePageView.this.gXg.bcO();
                    } else {
                        PersonalizePageView.this.gXg.bcN();
                    }
                }
            }
        };
        this.hcA = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean ghA = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_first_install", true);

            private void bOG() {
                if (this.ghA) {
                    this.ghA = false;
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i2, int i22, int i3) {
                if (PersonalizePageView.this.hcq == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bzm = PersonalizePageView.this.bzm();
                PersonalizePageView.this.bcy();
                if (bzm) {
                    PersonalizePageView.this.eM(true);
                }
                PersonalizePageView.this.hcq.M(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.hcq != null) {
                    PersonalizePageView.this.hcq.y(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bOG();
                } else if (!this.ghA) {
                    PersonalizePageView.this.gXi.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bOG();
                    PersonalizePageView.this.bND();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bOG();
                PersonalizePageView.this.gXi.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bcy();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hcr.bOT());
                PersonalizePageView.this.eQ(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.gqB != null) {
                    PersonalizePageView.this.gqB.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bOH() {
                if (PersonalizePageView.this.elw != null) {
                    PersonalizePageView.this.elw.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.elw.endLoadData();
                    PersonalizePageView.this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hcB = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aXG().wO("page_recommend");
                PersonalizePageView.this.hcr.update();
                PersonalizePageView.this.hcr.mD(false);
                PersonalizePageView.this.hcy = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hbN = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hcr != null && PersonalizePageView.this.hcr.bEL() != null) {
                    PersonalizePageView.this.hcr.bEL().bOq();
                }
            }
        };
        this.hcC = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aHY() {
                if (PersonalizePageView.this.hcy) {
                    PersonalizePageView.this.gpu = 0;
                    PersonalizePageView.this.dBJ = 1;
                    PersonalizePageView.this.hcy = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hbO = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hcr != null) {
                    PersonalizePageView.this.hcr.mD(true);
                    PersonalizePageView.this.hcr.bOM();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFD().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.azW().jt(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hcD = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.doF = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bNf();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gXk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bcg();
            }
        };
        this.gpU = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gpl = true;
                    }
                }
            }
        };
        this.hcE = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gXi != null && !PersonalizePageView.this.gXi.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hcn == null) {
                            PersonalizePageView.this.hcn = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hcn.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hco = PersonalizePageView.this.hcn;
                            PersonalizePageView.this.bOD();
                        } else if (PersonalizePageView.this.hco != PersonalizePageView.this.hcn) {
                            PersonalizePageView.this.hco = PersonalizePageView.this.hcn;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hcn.setEnable(true);
                        PersonalizePageView.this.gXi.setProgressView(PersonalizePageView.this.hcn);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gXi.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hcm == null) {
                        PersonalizePageView.this.hcm = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hco = PersonalizePageView.this.hcm;
                        PersonalizePageView.this.bOD();
                    } else if (PersonalizePageView.this.hco != PersonalizePageView.this.hcm || !aVar.equals(PersonalizePageView.this.hcm.bPf())) {
                        PersonalizePageView.this.hco = PersonalizePageView.this.hcm;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hcm.setEnable(true);
                    PersonalizePageView.this.gXi.setProgressView(PersonalizePageView.this.hcm);
                    PersonalizePageView.this.hcm.a(aVar);
                    PersonalizePageView.this.gXi.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hcF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hcz != null) {
                    PersonalizePageView.this.hcz.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gXa = new BdTypeRecyclerView(context);
        this.cxG = new LinearLayoutManager(this.gXa.getContext());
        this.gXa.setLayoutManager(this.cxG);
        this.gXa.setFadingEdgeLength(0);
        this.gXa.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gax = new k(new i());
            this.gax.a(this.gXa, 2);
        }
        MessageManager.getInstance().registerListener(this.gaz);
        this.gXi = new BigdaySwipeRefreshLayout(context);
        this.gXi.addView(this.gXa);
        this.elw = new PbListView(context);
        this.elw.getView();
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elw.setLineGone();
        this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elw.setTextSize(R.dimen.tbfontsize33);
        this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elw.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.elw.setOnClickListener(this.gXk);
        this.elw.aHH();
        this.gXa.setNextPage(this.elw);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.hcE);
        com.baidu.tbadk.core.bigday.b.azW().ft(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFD().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.azW().jt(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.gXi);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.hcz = new FRSRefreshButton(context);
            int dimens = l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds180);
            addView(this.hcz, layoutParams);
            this.hcz.setOnClickListener(this.hcF);
            this.hcz.setVisibility(8);
        }
        this.hct = new com.baidu.tieba.homepage.personalize.model.e();
        this.hcp = new ab(context, this.gXa);
        this.hcp.b(this.hct);
        this.hcr = new e(this.pageContext, this.gXa, this.hcp, this.gXi);
        this.hcs = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.gpU);
        this.hcx = com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ(Context context) {
        if (this.hcv == null) {
            this.hcv = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds200);
            addView(this.hcv, layoutParams);
            this.hcv.setVisibility(8);
            this.hcv.setPageId(this.pageContext.getUniqueId());
            this.gqB = new com.baidu.tieba.c.c(this.pageContext, this.hcv, 1);
        }
    }

    public void bOD() {
        if (this.hco != null) {
            this.hco.setListPullRefreshListener(this.hcB);
            this.hco.a(this.hbN);
            this.hco.a(this.hcC);
            this.hco.a(this.hbO);
        }
    }

    public void initListeners() {
        this.hcp.b(this.hbl);
        this.hcr.a(this.hcA);
        this.hcs.a(this);
        bOD();
        this.gXa.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.gpu += i2;
                if (PersonalizePageView.this.hcz != null) {
                    m item = PersonalizePageView.this.gXa.getItem(PersonalizePageView.this.cxG.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.k) {
                        if (((com.baidu.tieba.card.data.k) item).position >= 6) {
                            PersonalizePageView.this.hcz.show();
                        } else {
                            PersonalizePageView.this.hcz.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.cxG != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.gpu < height * 3 || PersonalizePageView.this.dBJ != 1) {
                        if (PersonalizePageView.this.gpu < height * 3 && PersonalizePageView.this.dBJ == 2) {
                            PersonalizePageView.this.dBJ = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.dBJ = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.dBJ)));
                    }
                    if (PersonalizePageView.this.cxG.getItemCount() - PersonalizePageView.this.cxG.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bcg();
                    }
                }
            }
        });
        this.gXa.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bcg();
            }
        });
        this.gXa.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.hcu >= 5000) {
                    PersonalizePageView.this.hcr.bU(i, i2);
                }
            }
        }, 1L);
        this.gXa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.hcr != null && PersonalizePageView.this.hcr.bEL() != null) {
                        PersonalizePageView.this.hcr.bEL().cl(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).bvL().stopPlay();
                    }
                }
            }
        });
        this.gXa.removeOnScrollListener(this.mOnScrollListener);
        this.gXa.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.hcq = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.elw != null) {
            this.elw.setText(getContext().getString(R.string.pb_load_more));
            this.elw.endLoadData();
            this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hcr.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.hcr != null) {
            this.hcr.mH(!z);
        }
        this.hcw = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.hcw;
    }

    public void e(Long l) {
        this.hcr.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.hcr != null) {
            this.hcr.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void showFloatingView() {
        if (this.hcr != null) {
            this.hcr.showFloatingView();
        }
    }

    public void bOE() {
        if (this.hcr != null) {
            this.hcr.bOE();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.euk != null) {
                this.euk.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.hcn != null) {
                this.hcn.changeSkin(i);
            }
            if (this.elw != null) {
                this.elw.setTextColor(am.getColor(R.color.cp_cont_d));
                this.elw.changeSkin(i);
            }
            this.hcp.onChangeSkinType(i);
            if (this.hcr != null) {
                this.hcr.onChangeSkinType(i);
            }
            if (this.hcz != null) {
                this.hcz.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aE(String str, int i) {
        if (this.elw != null) {
            this.elw.setText(getContext().getString(R.string.pb_load_more));
            this.elw.endLoadData();
            this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hcr.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.hcr != null) {
                        PersonalizePageView.this.hcr.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.euk != null) {
            this.euk.dettachView(this);
            this.euk = null;
            this.gXa.setNextPage(this.elw);
            this.elw.setText(getContext().getString(R.string.pb_load_more));
            this.elw.endLoadData();
            this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.gXi != null) {
            this.gXi.setVisibility(0);
        }
        if (this.hcq != null) {
            this.hcq.bNu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzm() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(boolean z) {
        if (this.euk == null) {
            this.euk = new com.baidu.tbadk.k.g(getContext());
            this.euk.aN(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
            this.euk.aPU();
            this.euk.setWrapStyle(true);
            this.euk.onChangeSkinType();
        }
        this.euk.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.gXa.setNextPage(null);
        if (this.gXi != null) {
            this.gXi.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.hcr != null) {
            this.hcr.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.gqB != null) {
            this.gqB.baD();
        }
        setViewForeground(false);
        if (this.hcr != null) {
            this.hcr.lt(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.hcx < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hcD, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.hcr != null) {
            this.hcr.mx(z);
        }
        if (this.gXg != null) {
            this.gXg.b(this.gXh);
            this.gXg.a(this.gXh);
            this.gXh.bNO();
        }
    }

    public void bND() {
        if (this.hcr != null) {
            eM(true);
            this.hcr.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.azW().azY();
            com.baidu.tbadk.core.bigday.b.azW().azX();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.hcr != null) {
            this.hcr.update();
        } else if (this.gXa != null && this.gXi != null) {
            showFloatingView();
            this.gXa.setSelection(0);
            if (!this.gXi.isRefreshing()) {
                if (this.hcr != null && this.hcr.bEL() != null) {
                    this.hcr.bEL().bOq();
                    this.hcr.mD(false);
                }
                this.gXi.setRefreshing(true);
            }
            if (this.gXh != null) {
                this.gXh.bNO();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gaz);
        MessageManager.getInstance().unRegisterListener(this.gpU);
        MessageManager.getInstance().unRegisterListener(this.hcE);
        this.hcr.onDestroy();
        this.hcp.b((NEGFeedBackView.a) null);
        this.hcp.onDestroy();
        this.hcr.a((e.a) null);
        if (this.hcm != null) {
            this.hcm.setListPullRefreshListener(null);
            this.hcm.a((g.d) null);
            this.hcm.a((g.a) null);
            this.hcm.a((g.b) null);
            this.hcm.release();
        }
        if (this.hcn != null) {
            this.hcn.setListPullRefreshListener(null);
            this.hcn.a((g.d) null);
            this.hcn.a((g.a) null);
            this.hcn.a((g.b) null);
            this.hcn.release();
        }
        this.gXa.setOnSrollToBottomListener(null);
        if (this.gXg != null) {
            this.gXg.b(this.gXh);
        }
        this.gXa.removeOnScrollListener(this.mOnScrollListener);
        if (this.euk != null) {
            this.euk.release();
        }
        this.gXa.setRecyclerListener(null);
        if (this.hcs != null) {
            this.hcs.onDestroy();
        }
        if (this.gqB != null) {
            this.gqB.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.azW().destroy();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hcD);
    }

    public void onPause() {
        this.hcr.onPause();
        if (this.hcp != null) {
            this.hcp.onPause();
        }
    }

    public void onResume() {
        if (this.gpl) {
            reload();
            this.gpl = false;
        }
        if (this.gXi != null) {
            this.gXi.resume();
        }
        if (this.hcp != null) {
            this.hcp.onResume();
        }
    }

    public void bNf() {
        if (this.hcp != null) {
            this.hcp.notifyDataSetChanged();
        }
    }

    public void bNg() {
        if (this.hcr != null) {
            this.hcr.lt(true);
        }
        r.bvh().ib(false);
        com.baidu.tieba.a.d.aXG().cv("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hcD);
    }

    public void bOA() {
        this.hcr.bOS();
    }

    public void bOF() {
        this.hcr.bOF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcg() {
        com.baidu.tieba.homepage.framework.a.bNt().q(System.currentTimeMillis(), 1);
        if (this.elw != null && !this.elw.isLoading()) {
            this.elw.startLoadData();
            this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hcr.bcg();
    }
}
