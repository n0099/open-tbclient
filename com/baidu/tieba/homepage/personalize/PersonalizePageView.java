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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.k;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.m.g;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.w;
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
/* loaded from: classes4.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager bIc;
    private final CustomMessageListener cwi;
    private g dDz;
    private PbListView dvS;
    private int dxA;
    private k fgw;
    private CustomMessageListener fgy;
    private CustomMessageListener fvZ;
    private boolean fvl;
    private com.baidu.tieba.c.c fwF;
    private BdTypeRecyclerView gdh;
    private ScrollFragmentTabHost gdn;
    ScrollFragmentTabHost.a gdo;
    private BigdaySwipeRefreshLayout gdp;
    private View.OnClickListener gdr;
    h.d giJ;
    h.b giK;
    private NEGFeedBackView.a gih;
    public CustomMessageListener gjA;
    private com.baidu.tieba.homepage.personalize.bigday.b gjh;
    private com.baidu.tieba.homepage.personalize.bigday.a gji;
    private a gjj;
    private w gjk;
    private com.baidu.tieba.homepage.framework.b gjl;
    private e gjm;
    private com.baidu.tieba.homepage.personalize.a gjn;
    private com.baidu.tieba.homepage.personalize.model.e gjo;
    private long gjp;
    private FloatingAnimationView gjq;
    private boolean gjr;
    private int gjs;
    private int gjt;
    private boolean gju;
    private int gjv;
    private e.a gjw;
    h.c gjx;
    h.a gjy;
    private Runnable gjz;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.m.h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void a(h.a aVar);

        void a(h.b bVar);

        void a(h.d dVar);

        void setListPullRefreshListener(h.c cVar);
    }

    static /* synthetic */ int v(PersonalizePageView personalizePageView) {
        int i = personalizePageView.gjs + 1;
        personalizePageView.gjs = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gdn = scrollFragmentTabHost;
        if (this.gdn != null) {
            this.gdn.b(this.gdo);
            this.gdn.a(this.gdo);
        }
        if (this.gjm != null) {
            this.gjm.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gjn != null) {
            this.gjn.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.gdp != null) {
            this.gdp.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gjk != null) {
            this.gjk.setPageUniqueId(bdUniqueId);
        }
        if (this.gjm != null) {
            this.gjm.l(bdUniqueId);
        }
        if (this.gjo != null) {
            this.gjo.h(bdUniqueId);
        }
        if (this.gji != null) {
            this.gji.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.agw().setTag(bdUniqueId);
        if (this.cwi != null) {
            this.cwi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cwi);
        }
        if (this.gjn != null) {
            this.gjn.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        o oVar = new o();
        oVar.DR(String.valueOf(floatInfo.activity_id));
        oVar.eq(floatInfo.dynamic_url);
        oVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        oVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        oVar.DQ(floatInfo.float_url);
        oVar.DP(floatInfo.jump_url);
        oVar.setType(floatInfo.show_type.intValue());
        return oVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.gjp = 0L;
        this.mSkinType = 3;
        this.fvl = false;
        this.gjr = false;
        this.gjs = 0;
        this.gjt = 0;
        this.gju = false;
        this.gjv = 1;
        this.fgy = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fgw == null) {
                            PersonalizePageView.this.fgw = new k(new i());
                        }
                        PersonalizePageView.this.fgw.a(PersonalizePageView.this.gdh, 2);
                    } else if (PersonalizePageView.this.fgw != null) {
                        PersonalizePageView.this.fgw.jU();
                    }
                }
            }
        };
        this.gih = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                if (ajVar != null) {
                    TiebaStatic.log(new an("c11693").bS("obj_locate", "1").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
                int i = 0;
                if (arrayList != null && ajVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (ajVar.threadType == 0) {
                        i = 1;
                    } else if (ajVar.threadType == 40) {
                        i = 2;
                    } else if (ajVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.gjk != null) {
                        PersonalizePageView.this.gjk.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fid", ajVar.getFid()).bS("obj_param1", ajVar.weight).bS("obj_source", ajVar.source).bS("obj_id", ajVar.extra).bS("obj_type", sb.toString()).bS("obj_name", str).O(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.dxA = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dxA != i && PersonalizePageView.this.gdn != null) {
                    PersonalizePageView.this.dxA = i;
                    if (PersonalizePageView.this.dxA == 1) {
                        PersonalizePageView.this.gdn.aJy();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gdn.aJz();
                    } else {
                        PersonalizePageView.this.gdn.aJy();
                    }
                }
            }
        };
        this.gdo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btP() {
                if (PersonalizePageView.this.gdn != null) {
                    PersonalizePageView.this.dxA = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gdh)) {
                        PersonalizePageView.this.gdn.aJz();
                    } else {
                        PersonalizePageView.this.gdn.aJy();
                    }
                }
            }
        };
        this.gjw = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fnD = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("key_first_install", true);

            private void buF() {
                if (this.fnD) {
                    this.fnD = false;
                    com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i, int i2, int i3) {
                if (PersonalizePageView.this.gjl == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bfk = PersonalizePageView.this.bfk();
                PersonalizePageView.this.aJm();
                if (bfk) {
                    PersonalizePageView.this.p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gjl.L(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gjl != null) {
                    PersonalizePageView.this.gjl.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    buF();
                } else if (!this.fnD) {
                    PersonalizePageView.this.gdp.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    buF();
                    PersonalizePageView.this.btE();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                buF();
                PersonalizePageView.this.gdp.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJm();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gjm.buS());
                PersonalizePageView.this.du(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fwF != null) {
                    PersonalizePageView.this.fwF.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void buG() {
                if (PersonalizePageView.this.dvS != null) {
                    PersonalizePageView.this.dvS.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dvS.endLoadData();
                }
            }
        };
        this.gjx = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aDc().rg("page_recommend");
                PersonalizePageView.this.gjm.update();
                PersonalizePageView.this.gjm.ld(false);
                PersonalizePageView.this.gju = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.giJ = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.gjm != null && PersonalizePageView.this.gjm.bkH() != null) {
                    PersonalizePageView.this.gjm.bkH().bup();
                }
            }
        };
        this.gjy = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void anU() {
                if (PersonalizePageView.this.gju) {
                    PersonalizePageView.this.gjt = 0;
                    PersonalizePageView.this.gjv = 1;
                    PersonalizePageView.this.gju = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.giK = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.gjm != null) {
                    PersonalizePageView.this.gjm.ld(true);
                    PersonalizePageView.this.gjm.buL();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.alP().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.agw().hq(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gjz = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.cwi = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bsW();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gdr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aIU();
            }
        };
        this.fvZ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fvl = true;
                    }
                }
            }
        };
        this.gjA = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gdp != null && !PersonalizePageView.this.gdp.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gji == null) {
                            PersonalizePageView.this.gji = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gji.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gjj = PersonalizePageView.this.gji;
                            PersonalizePageView.this.buC();
                        } else if (PersonalizePageView.this.gjj != PersonalizePageView.this.gji) {
                            PersonalizePageView.this.gjj = PersonalizePageView.this.gji;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gji.setEnable(true);
                        PersonalizePageView.this.gdp.setProgressView(PersonalizePageView.this.gji);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gdp.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gjh == null) {
                        PersonalizePageView.this.gjh = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gjj = PersonalizePageView.this.gjh;
                        PersonalizePageView.this.buC();
                    } else if (PersonalizePageView.this.gjj != PersonalizePageView.this.gjh || !aVar.equals(PersonalizePageView.this.gjh.bve())) {
                        PersonalizePageView.this.gjj = PersonalizePageView.this.gjh;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gjh.setEnable(true);
                    PersonalizePageView.this.gdp.setProgressView(PersonalizePageView.this.gjh);
                    PersonalizePageView.this.gjh.a(aVar);
                    PersonalizePageView.this.gdp.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjp = 0L;
        this.mSkinType = 3;
        this.fvl = false;
        this.gjr = false;
        this.gjs = 0;
        this.gjt = 0;
        this.gju = false;
        this.gjv = 1;
        this.fgy = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fgw == null) {
                            PersonalizePageView.this.fgw = new k(new i());
                        }
                        PersonalizePageView.this.fgw.a(PersonalizePageView.this.gdh, 2);
                    } else if (PersonalizePageView.this.fgw != null) {
                        PersonalizePageView.this.fgw.jU();
                    }
                }
            }
        };
        this.gih = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                if (ajVar != null) {
                    TiebaStatic.log(new an("c11693").bS("obj_locate", "1").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
                int i = 0;
                if (arrayList != null && ajVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (ajVar.threadType == 0) {
                        i = 1;
                    } else if (ajVar.threadType == 40) {
                        i = 2;
                    } else if (ajVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.gjk != null) {
                        PersonalizePageView.this.gjk.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fid", ajVar.getFid()).bS("obj_param1", ajVar.weight).bS("obj_source", ajVar.source).bS("obj_id", ajVar.extra).bS("obj_type", sb.toString()).bS("obj_name", str).O(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.dxA = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dxA != i && PersonalizePageView.this.gdn != null) {
                    PersonalizePageView.this.dxA = i;
                    if (PersonalizePageView.this.dxA == 1) {
                        PersonalizePageView.this.gdn.aJy();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gdn.aJz();
                    } else {
                        PersonalizePageView.this.gdn.aJy();
                    }
                }
            }
        };
        this.gdo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btP() {
                if (PersonalizePageView.this.gdn != null) {
                    PersonalizePageView.this.dxA = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gdh)) {
                        PersonalizePageView.this.gdn.aJz();
                    } else {
                        PersonalizePageView.this.gdn.aJy();
                    }
                }
            }
        };
        this.gjw = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fnD = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("key_first_install", true);

            private void buF() {
                if (this.fnD) {
                    this.fnD = false;
                    com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i, int i2, int i3) {
                if (PersonalizePageView.this.gjl == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bfk = PersonalizePageView.this.bfk();
                PersonalizePageView.this.aJm();
                if (bfk) {
                    PersonalizePageView.this.p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gjl.L(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gjl != null) {
                    PersonalizePageView.this.gjl.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    buF();
                } else if (!this.fnD) {
                    PersonalizePageView.this.gdp.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    buF();
                    PersonalizePageView.this.btE();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                buF();
                PersonalizePageView.this.gdp.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJm();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gjm.buS());
                PersonalizePageView.this.du(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fwF != null) {
                    PersonalizePageView.this.fwF.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void buG() {
                if (PersonalizePageView.this.dvS != null) {
                    PersonalizePageView.this.dvS.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dvS.endLoadData();
                }
            }
        };
        this.gjx = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aDc().rg("page_recommend");
                PersonalizePageView.this.gjm.update();
                PersonalizePageView.this.gjm.ld(false);
                PersonalizePageView.this.gju = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.giJ = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.gjm != null && PersonalizePageView.this.gjm.bkH() != null) {
                    PersonalizePageView.this.gjm.bkH().bup();
                }
            }
        };
        this.gjy = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void anU() {
                if (PersonalizePageView.this.gju) {
                    PersonalizePageView.this.gjt = 0;
                    PersonalizePageView.this.gjv = 1;
                    PersonalizePageView.this.gju = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.giK = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.gjm != null) {
                    PersonalizePageView.this.gjm.ld(true);
                    PersonalizePageView.this.gjm.buL();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.alP().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.agw().hq(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gjz = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.cwi = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bsW();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gdr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aIU();
            }
        };
        this.fvZ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fvl = true;
                    }
                }
            }
        };
        this.gjA = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gdp != null && !PersonalizePageView.this.gdp.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gji == null) {
                            PersonalizePageView.this.gji = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gji.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gjj = PersonalizePageView.this.gji;
                            PersonalizePageView.this.buC();
                        } else if (PersonalizePageView.this.gjj != PersonalizePageView.this.gji) {
                            PersonalizePageView.this.gjj = PersonalizePageView.this.gji;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gji.setEnable(true);
                        PersonalizePageView.this.gdp.setProgressView(PersonalizePageView.this.gji);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gdp.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gjh == null) {
                        PersonalizePageView.this.gjh = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gjj = PersonalizePageView.this.gjh;
                        PersonalizePageView.this.buC();
                    } else if (PersonalizePageView.this.gjj != PersonalizePageView.this.gjh || !aVar.equals(PersonalizePageView.this.gjh.bve())) {
                        PersonalizePageView.this.gjj = PersonalizePageView.this.gjh;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gjh.setEnable(true);
                    PersonalizePageView.this.gdp.setProgressView(PersonalizePageView.this.gjh);
                    PersonalizePageView.this.gjh.a(aVar);
                    PersonalizePageView.this.gdp.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjp = 0L;
        this.mSkinType = 3;
        this.fvl = false;
        this.gjr = false;
        this.gjs = 0;
        this.gjt = 0;
        this.gju = false;
        this.gjv = 1;
        this.fgy = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fgw == null) {
                            PersonalizePageView.this.fgw = new k(new i());
                        }
                        PersonalizePageView.this.fgw.a(PersonalizePageView.this.gdh, 2);
                    } else if (PersonalizePageView.this.fgw != null) {
                        PersonalizePageView.this.fgw.jU();
                    }
                }
            }
        };
        this.gih = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                if (ajVar != null) {
                    TiebaStatic.log(new an("c11693").bS("obj_locate", "1").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
                int i2 = 0;
                if (arrayList != null && ajVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        sb.append(arrayList.get(i22)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (ajVar.threadType == 0) {
                        i2 = 1;
                    } else if (ajVar.threadType == 40) {
                        i2 = 2;
                    } else if (ajVar.threadType == 49) {
                        i2 = 3;
                    }
                    if (PersonalizePageView.this.gjk != null) {
                        PersonalizePageView.this.gjk.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fid", ajVar.getFid()).bS("obj_param1", ajVar.weight).bS("obj_source", ajVar.source).bS("obj_id", ajVar.extra).bS("obj_type", sb.toString()).bS("obj_name", str).O(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.dxA = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.dxA != i2 && PersonalizePageView.this.gdn != null) {
                    PersonalizePageView.this.dxA = i2;
                    if (PersonalizePageView.this.dxA == 1) {
                        PersonalizePageView.this.gdn.aJy();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gdn.aJz();
                    } else {
                        PersonalizePageView.this.gdn.aJy();
                    }
                }
            }
        };
        this.gdo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btP() {
                if (PersonalizePageView.this.gdn != null) {
                    PersonalizePageView.this.dxA = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gdh)) {
                        PersonalizePageView.this.gdn.aJz();
                    } else {
                        PersonalizePageView.this.gdn.aJy();
                    }
                }
            }
        };
        this.gjw = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fnD = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("key_first_install", true);

            private void buF() {
                if (this.fnD) {
                    this.fnD = false;
                    com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i2, int i22, int i3) {
                if (PersonalizePageView.this.gjl == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bfk = PersonalizePageView.this.bfk();
                PersonalizePageView.this.aJm();
                if (bfk) {
                    PersonalizePageView.this.p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gjl.L(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.gjl != null) {
                    PersonalizePageView.this.gjl.u(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    buF();
                } else if (!this.fnD) {
                    PersonalizePageView.this.gdp.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    buF();
                    PersonalizePageView.this.btE();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                buF();
                PersonalizePageView.this.gdp.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJm();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gjm.buS());
                PersonalizePageView.this.du(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fwF != null) {
                    PersonalizePageView.this.fwF.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void buG() {
                if (PersonalizePageView.this.dvS != null) {
                    PersonalizePageView.this.dvS.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dvS.endLoadData();
                }
            }
        };
        this.gjx = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aDc().rg("page_recommend");
                PersonalizePageView.this.gjm.update();
                PersonalizePageView.this.gjm.ld(false);
                PersonalizePageView.this.gju = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.giJ = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.gjm != null && PersonalizePageView.this.gjm.bkH() != null) {
                    PersonalizePageView.this.gjm.bkH().bup();
                }
            }
        };
        this.gjy = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void anU() {
                if (PersonalizePageView.this.gju) {
                    PersonalizePageView.this.gjt = 0;
                    PersonalizePageView.this.gjv = 1;
                    PersonalizePageView.this.gju = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.giK = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.gjm != null) {
                    PersonalizePageView.this.gjm.ld(true);
                    PersonalizePageView.this.gjm.buL();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.alP().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.agw().hq(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gjz = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.cwi = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bsW();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gdr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aIU();
            }
        };
        this.fvZ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fvl = true;
                    }
                }
            }
        };
        this.gjA = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gdp != null && !PersonalizePageView.this.gdp.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gji == null) {
                            PersonalizePageView.this.gji = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gji.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gjj = PersonalizePageView.this.gji;
                            PersonalizePageView.this.buC();
                        } else if (PersonalizePageView.this.gjj != PersonalizePageView.this.gji) {
                            PersonalizePageView.this.gjj = PersonalizePageView.this.gji;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gji.setEnable(true);
                        PersonalizePageView.this.gdp.setProgressView(PersonalizePageView.this.gji);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gdp.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gjh == null) {
                        PersonalizePageView.this.gjh = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gjj = PersonalizePageView.this.gjh;
                        PersonalizePageView.this.buC();
                    } else if (PersonalizePageView.this.gjj != PersonalizePageView.this.gjh || !aVar.equals(PersonalizePageView.this.gjh.bve())) {
                        PersonalizePageView.this.gjj = PersonalizePageView.this.gjh;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gjh.setEnable(true);
                    PersonalizePageView.this.gdp.setProgressView(PersonalizePageView.this.gjh);
                    PersonalizePageView.this.gjh.a(aVar);
                    PersonalizePageView.this.gdp.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gdh = new BdTypeRecyclerView(context);
        this.bIc = new LinearLayoutManager(this.gdh.getContext());
        this.gdh.setLayoutManager(this.bIc);
        this.gdh.setFadingEdgeLength(0);
        this.gdh.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fgw = new k(new i());
            this.fgw.a(this.gdh, 2);
        }
        MessageManager.getInstance().registerListener(this.fgy);
        this.gdp = new BigdaySwipeRefreshLayout(context);
        this.gdp.addView(this.gdh);
        this.dvS = new PbListView(context);
        this.dvS.getView();
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dvS.setLineGone();
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dvS.setTextSize(R.dimen.tbfontsize33);
        this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dvS.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.dvS.setOnClickListener(this.gdr);
        this.dvS.anJ();
        this.gdh.setNextPage(this.dvS);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.gjA);
        com.baidu.tbadk.core.bigday.b.agw().dW(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.alP().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.agw().hq(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.gdp);
        ((FrameLayout.LayoutParams) this.gdp.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.gjo = new com.baidu.tieba.homepage.personalize.model.e();
        this.gjk = new w(context, this.gdh);
        this.gjk.b(this.gjo);
        this.gjm = new e(this.pageContext, this.gdh, this.gjk, this.gdp);
        this.gjn = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.fvZ);
        this.gjs = com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du(Context context) {
        if (this.gjq == null) {
            this.gjq = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds200);
            addView(this.gjq, layoutParams);
            this.gjq.setVisibility(8);
            this.gjq.setPageId(this.pageContext.getUniqueId());
            this.fwF = new com.baidu.tieba.c.c(this.pageContext, this.gjq, 1);
        }
    }

    public void buC() {
        if (this.gjj != null) {
            this.gjj.setListPullRefreshListener(this.gjx);
            this.gjj.a(this.giJ);
            this.gjj.a(this.gjy);
            this.gjj.a(this.giK);
        }
    }

    public void aNb() {
        this.gjk.b(this.gih);
        this.gjm.a(this.gjw);
        this.gjn.a(this);
        buC();
        this.gdh.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                PersonalizePageView.this.gjt += i2;
                if (PersonalizePageView.this.gjt < height * 3 || PersonalizePageView.this.gjv != 1) {
                    if (PersonalizePageView.this.gjt < height * 3 && PersonalizePageView.this.gjv == 2) {
                        PersonalizePageView.this.gjv = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        return;
                    }
                    return;
                }
                PersonalizePageView.this.gjv = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.gjv)));
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.bIc != null && i == 0 && PersonalizePageView.this.bIc.getItemCount() - PersonalizePageView.this.bIc.findLastVisibleItemPosition() <= 3) {
                    PersonalizePageView.this.aIU();
                }
            }
        });
        this.gdh.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aIU();
            }
        });
        this.gdh.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.gjp >= 5000) {
                    PersonalizePageView.this.gjm.bC(i, i2);
                }
            }
        }, 1L);
        this.gdh.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.gjm != null && PersonalizePageView.this.gjm.bkH() != null) {
                        PersonalizePageView.this.gjm.bkH().ck(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).baX().stopPlay();
                    }
                }
            }
        });
        this.gdh.removeOnScrollListener(this.mOnScrollListener);
        this.gdh.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gjl = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.dvS != null) {
            this.dvS.setText(getContext().getString(R.string.pb_load_more));
            this.dvS.endLoadData();
        }
        this.gjm.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.gjm != null) {
            this.gjm.lh(!z);
        }
        this.gjr = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.gjr;
    }

    public void c(Long l) {
        this.gjm.c(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.w wVar) {
        if (this.gjm != null) {
            this.gjm.setRecommendFrsNavigationAnimDispatcher(wVar);
        }
    }

    public void showFloatingView() {
        if (this.gjm != null) {
            this.gjm.showFloatingView();
        }
    }

    public void buD() {
        if (this.gjm != null) {
            this.gjm.buD();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dDz != null) {
                this.dDz.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.setBackgroundColor(this.gdp, R.color.cp_bg_line_e);
            if (this.gji != null) {
                this.gji.changeSkin(i);
            }
            if (this.dvS != null) {
                this.dvS.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dvS.changeSkin(i);
            }
            this.gjk.onChangeSkinType(i);
            if (this.gjm != null) {
                this.gjm.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aw(String str, int i) {
        if (this.dvS != null) {
            this.dvS.setText(getContext().getString(R.string.pb_load_more));
            this.dvS.endLoadData();
        }
        this.gjm.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.gjm != null) {
                        PersonalizePageView.this.gjm.update();
                    }
                }
            });
        }
        this.refreshView.setSubText(str);
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJm() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.dDz != null) {
            this.dDz.dettachView(this);
            this.dDz = null;
            this.gdh.setNextPage(this.dvS);
            this.dvS.setText(getContext().getString(R.string.pb_load_more));
            this.dvS.endLoadData();
        }
        if (this.gdp != null) {
            this.gdp.setVisibility(0);
        }
        if (this.gjl != null) {
            this.gjl.btu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfk() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, int i) {
        if (this.dDz == null) {
            if (i < 0) {
                this.dDz = new g(getContext());
            } else {
                this.dDz = new g(getContext(), i);
            }
            this.dDz.onChangeSkinType();
        }
        this.dDz.attachView(this, z);
        this.gdh.setNextPage(null);
        if (this.gdp != null) {
            this.gdp.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.gjm != null) {
            this.gjm.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.fwF != null) {
            this.fwF.aHH();
        }
        setViewForeground(false);
        if (this.gjm != null) {
            this.gjm.jT(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.gjs < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.gjz, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gjm != null) {
            this.gjm.kX(z);
        }
        if (this.gdn != null) {
            this.gdn.b(this.gdo);
            this.gdn.a(this.gdo);
            this.gdo.btP();
        }
    }

    public void btE() {
        if (this.gjm != null) {
            p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.gjm.update();
        }
        if (com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.agw().agy();
            com.baidu.tbadk.core.bigday.b.agw().agx();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.gjm != null) {
            this.gjm.update();
        } else if (this.gdh != null && this.gdp != null) {
            showFloatingView();
            this.gdh.setSelection(0);
            if (!this.gdp.isRefreshing()) {
                if (this.gjm != null && this.gjm.bkH() != null) {
                    this.gjm.bkH().bup();
                    this.gjm.ld(false);
                }
                this.gdp.setRefreshing(true);
            }
            if (this.gdo != null) {
                this.gdo.btP();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fgy);
        MessageManager.getInstance().unRegisterListener(this.fvZ);
        MessageManager.getInstance().unRegisterListener(this.gjA);
        this.gjm.onDestroy();
        this.gjk.b((NEGFeedBackView.a) null);
        this.gjk.onDestroy();
        this.gjm.a((e.a) null);
        if (this.gjh != null) {
            this.gjh.setListPullRefreshListener(null);
            this.gjh.a((h.d) null);
            this.gjh.a((h.a) null);
            this.gjh.a((h.b) null);
            this.gjh.release();
        }
        if (this.gji != null) {
            this.gji.setListPullRefreshListener(null);
            this.gji.a((h.d) null);
            this.gji.a((h.a) null);
            this.gji.a((h.b) null);
            this.gji.release();
        }
        this.gdh.setOnSrollToBottomListener(null);
        if (this.gdn != null) {
            this.gdn.b(this.gdo);
        }
        this.gdh.removeOnScrollListener(this.mOnScrollListener);
        if (this.dDz != null) {
            this.dDz.release();
        }
        this.gdh.setRecyclerListener(null);
        if (this.gjn != null) {
            this.gjn.onDestroy();
        }
        if (this.fwF != null) {
            this.fwF.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.agw().destroy();
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.gjz);
    }

    public void onPause() {
        this.gjm.onPause();
        if (this.gjk != null) {
            this.gjk.onPause();
        }
    }

    public void onResume() {
        if (this.fvl) {
            reload();
            this.fvl = false;
        }
        if (this.gdp != null) {
            this.gdp.resume();
        }
        if (this.gjk != null) {
            this.gjk.onResume();
        }
    }

    public void bsW() {
        if (this.gjk != null) {
            this.gjk.notifyDataSetChanged();
        }
    }

    public void bsX() {
        if (this.gjm != null) {
            this.gjm.jT(true);
        }
        t.bau().gF(false);
        com.baidu.tieba.a.d.aDc().bO("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.gjz);
    }

    public void buz() {
        this.gjm.buR();
    }

    public void buE() {
        this.gjm.buE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIU() {
        com.baidu.tieba.homepage.framework.a.btt().p(System.currentTimeMillis(), 1);
        if (this.dvS != null && !this.dvS.isLoading()) {
            this.dvS.startLoadData();
            this.dvS.showEmptyView(0);
        }
        this.gjm.aIU();
    }
}
