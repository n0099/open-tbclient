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
    private LinearLayoutManager bIT;
    private final CustomMessageListener cwZ;
    private g dEq;
    private PbListView dwJ;
    private int dyr;
    private k fhn;
    private CustomMessageListener fhp;
    private CustomMessageListener fwQ;
    private boolean fwc;
    private com.baidu.tieba.c.c fxw;
    private BdTypeRecyclerView gdY;
    private ScrollFragmentTabHost gee;
    ScrollFragmentTabHost.a gef;
    private BigdaySwipeRefreshLayout geg;
    private View.OnClickListener gei;
    private NEGFeedBackView.a giY;
    h.d gjA;
    h.b gjB;
    private com.baidu.tieba.homepage.personalize.bigday.b gjY;
    private com.baidu.tieba.homepage.personalize.bigday.a gjZ;
    private a gka;
    private w gkb;
    private com.baidu.tieba.homepage.framework.b gkc;
    private e gkd;
    private com.baidu.tieba.homepage.personalize.a gke;
    private com.baidu.tieba.homepage.personalize.model.e gkf;
    private long gkg;
    private FloatingAnimationView gkh;
    private boolean gki;
    private int gkj;
    private int gkk;
    private boolean gkl;
    private int gkm;
    private e.a gkn;
    h.c gko;
    h.a gkp;
    private Runnable gkq;
    public CustomMessageListener gkr;
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
        int i = personalizePageView.gkj + 1;
        personalizePageView.gkj = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gee = scrollFragmentTabHost;
        if (this.gee != null) {
            this.gee.b(this.gef);
            this.gee.a(this.gef);
        }
        if (this.gkd != null) {
            this.gkd.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gke != null) {
            this.gke.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.geg != null) {
            this.geg.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gkb != null) {
            this.gkb.setPageUniqueId(bdUniqueId);
        }
        if (this.gkd != null) {
            this.gkd.l(bdUniqueId);
        }
        if (this.gkf != null) {
            this.gkf.h(bdUniqueId);
        }
        if (this.gjZ != null) {
            this.gjZ.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.agy().setTag(bdUniqueId);
        if (this.cwZ != null) {
            this.cwZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cwZ);
        }
        if (this.gke != null) {
            this.gke.setBdUniqueId(bdUniqueId);
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
        this.gkg = 0L;
        this.mSkinType = 3;
        this.fwc = false;
        this.gki = false;
        this.gkj = 0;
        this.gkk = 0;
        this.gkl = false;
        this.gkm = 1;
        this.fhp = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fhn == null) {
                            PersonalizePageView.this.fhn = new k(new i());
                        }
                        PersonalizePageView.this.fhn.a(PersonalizePageView.this.gdY, 2);
                    } else if (PersonalizePageView.this.fhn != null) {
                        PersonalizePageView.this.fhn.jU();
                    }
                }
            }
        };
        this.giY = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.gkb != null) {
                        PersonalizePageView.this.gkb.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fid", ajVar.getFid()).bS("obj_param1", ajVar.weight).bS("obj_source", ajVar.source).bS("obj_id", ajVar.extra).bS("obj_type", sb.toString()).bS("obj_name", str).O(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.dyr = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dyr != i && PersonalizePageView.this.gee != null) {
                    PersonalizePageView.this.dyr = i;
                    if (PersonalizePageView.this.dyr == 1) {
                        PersonalizePageView.this.gee.aJA();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gee.aJB();
                    } else {
                        PersonalizePageView.this.gee.aJA();
                    }
                }
            }
        };
        this.gef = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btR() {
                if (PersonalizePageView.this.gee != null) {
                    PersonalizePageView.this.dyr = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gdY)) {
                        PersonalizePageView.this.gee.aJB();
                    } else {
                        PersonalizePageView.this.gee.aJA();
                    }
                }
            }
        };
        this.gkn = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fou = com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("key_first_install", true);

            private void buH() {
                if (this.fou) {
                    this.fou = false;
                    com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i, int i2, int i3) {
                if (PersonalizePageView.this.gkc == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bfm = PersonalizePageView.this.bfm();
                PersonalizePageView.this.aJo();
                if (bfm) {
                    PersonalizePageView.this.p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gkc.L(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gkc != null) {
                    PersonalizePageView.this.gkc.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    buH();
                } else if (!this.fou) {
                    PersonalizePageView.this.geg.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    buH();
                    PersonalizePageView.this.btG();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                buH();
                PersonalizePageView.this.geg.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJo();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gkd.buU());
                PersonalizePageView.this.du(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fxw != null) {
                    PersonalizePageView.this.fxw.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void buI() {
                if (PersonalizePageView.this.dwJ != null) {
                    PersonalizePageView.this.dwJ.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dwJ.endLoadData();
                }
            }
        };
        this.gko = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aDe().rg("page_recommend");
                PersonalizePageView.this.gkd.update();
                PersonalizePageView.this.gkd.ld(false);
                PersonalizePageView.this.gkl = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gjA = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.gkd != null && PersonalizePageView.this.gkd.bkJ() != null) {
                    PersonalizePageView.this.gkd.bkJ().bur();
                }
            }
        };
        this.gkp = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void anW() {
                if (PersonalizePageView.this.gkl) {
                    PersonalizePageView.this.gkk = 0;
                    PersonalizePageView.this.gkm = 1;
                    PersonalizePageView.this.gkl = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gjB = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.gkd != null) {
                    PersonalizePageView.this.gkd.ld(true);
                    PersonalizePageView.this.gkd.buN();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.alR().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.agy().hr(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gkq = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.alR().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.cwZ = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bsY();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gei = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aIW();
            }
        };
        this.fwQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fwc = true;
                    }
                }
            }
        };
        this.gkr = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.geg != null && !PersonalizePageView.this.geg.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gjZ == null) {
                            PersonalizePageView.this.gjZ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gjZ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gka = PersonalizePageView.this.gjZ;
                            PersonalizePageView.this.buE();
                        } else if (PersonalizePageView.this.gka != PersonalizePageView.this.gjZ) {
                            PersonalizePageView.this.gka = PersonalizePageView.this.gjZ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gjZ.setEnable(true);
                        PersonalizePageView.this.geg.setProgressView(PersonalizePageView.this.gjZ);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.geg.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gjY == null) {
                        PersonalizePageView.this.gjY = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gka = PersonalizePageView.this.gjY;
                        PersonalizePageView.this.buE();
                    } else if (PersonalizePageView.this.gka != PersonalizePageView.this.gjY || !aVar.equals(PersonalizePageView.this.gjY.bvg())) {
                        PersonalizePageView.this.gka = PersonalizePageView.this.gjY;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gjY.setEnable(true);
                    PersonalizePageView.this.geg.setProgressView(PersonalizePageView.this.gjY);
                    PersonalizePageView.this.gjY.a(aVar);
                    PersonalizePageView.this.geg.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gkg = 0L;
        this.mSkinType = 3;
        this.fwc = false;
        this.gki = false;
        this.gkj = 0;
        this.gkk = 0;
        this.gkl = false;
        this.gkm = 1;
        this.fhp = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fhn == null) {
                            PersonalizePageView.this.fhn = new k(new i());
                        }
                        PersonalizePageView.this.fhn.a(PersonalizePageView.this.gdY, 2);
                    } else if (PersonalizePageView.this.fhn != null) {
                        PersonalizePageView.this.fhn.jU();
                    }
                }
            }
        };
        this.giY = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.gkb != null) {
                        PersonalizePageView.this.gkb.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fid", ajVar.getFid()).bS("obj_param1", ajVar.weight).bS("obj_source", ajVar.source).bS("obj_id", ajVar.extra).bS("obj_type", sb.toString()).bS("obj_name", str).O(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.dyr = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dyr != i && PersonalizePageView.this.gee != null) {
                    PersonalizePageView.this.dyr = i;
                    if (PersonalizePageView.this.dyr == 1) {
                        PersonalizePageView.this.gee.aJA();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gee.aJB();
                    } else {
                        PersonalizePageView.this.gee.aJA();
                    }
                }
            }
        };
        this.gef = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btR() {
                if (PersonalizePageView.this.gee != null) {
                    PersonalizePageView.this.dyr = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gdY)) {
                        PersonalizePageView.this.gee.aJB();
                    } else {
                        PersonalizePageView.this.gee.aJA();
                    }
                }
            }
        };
        this.gkn = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fou = com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("key_first_install", true);

            private void buH() {
                if (this.fou) {
                    this.fou = false;
                    com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i, int i2, int i3) {
                if (PersonalizePageView.this.gkc == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bfm = PersonalizePageView.this.bfm();
                PersonalizePageView.this.aJo();
                if (bfm) {
                    PersonalizePageView.this.p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gkc.L(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gkc != null) {
                    PersonalizePageView.this.gkc.u(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    buH();
                } else if (!this.fou) {
                    PersonalizePageView.this.geg.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    buH();
                    PersonalizePageView.this.btG();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                buH();
                PersonalizePageView.this.geg.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJo();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gkd.buU());
                PersonalizePageView.this.du(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fxw != null) {
                    PersonalizePageView.this.fxw.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void buI() {
                if (PersonalizePageView.this.dwJ != null) {
                    PersonalizePageView.this.dwJ.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dwJ.endLoadData();
                }
            }
        };
        this.gko = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aDe().rg("page_recommend");
                PersonalizePageView.this.gkd.update();
                PersonalizePageView.this.gkd.ld(false);
                PersonalizePageView.this.gkl = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gjA = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.gkd != null && PersonalizePageView.this.gkd.bkJ() != null) {
                    PersonalizePageView.this.gkd.bkJ().bur();
                }
            }
        };
        this.gkp = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void anW() {
                if (PersonalizePageView.this.gkl) {
                    PersonalizePageView.this.gkk = 0;
                    PersonalizePageView.this.gkm = 1;
                    PersonalizePageView.this.gkl = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gjB = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.gkd != null) {
                    PersonalizePageView.this.gkd.ld(true);
                    PersonalizePageView.this.gkd.buN();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.alR().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.agy().hr(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gkq = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.alR().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.cwZ = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bsY();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gei = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aIW();
            }
        };
        this.fwQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fwc = true;
                    }
                }
            }
        };
        this.gkr = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.geg != null && !PersonalizePageView.this.geg.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gjZ == null) {
                            PersonalizePageView.this.gjZ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gjZ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gka = PersonalizePageView.this.gjZ;
                            PersonalizePageView.this.buE();
                        } else if (PersonalizePageView.this.gka != PersonalizePageView.this.gjZ) {
                            PersonalizePageView.this.gka = PersonalizePageView.this.gjZ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gjZ.setEnable(true);
                        PersonalizePageView.this.geg.setProgressView(PersonalizePageView.this.gjZ);
                        int i = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.geg.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gjY == null) {
                        PersonalizePageView.this.gjY = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gka = PersonalizePageView.this.gjY;
                        PersonalizePageView.this.buE();
                    } else if (PersonalizePageView.this.gka != PersonalizePageView.this.gjY || !aVar.equals(PersonalizePageView.this.gjY.bvg())) {
                        PersonalizePageView.this.gka = PersonalizePageView.this.gjY;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gjY.setEnable(true);
                    PersonalizePageView.this.geg.setProgressView(PersonalizePageView.this.gjY);
                    PersonalizePageView.this.gjY.a(aVar);
                    PersonalizePageView.this.geg.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gkg = 0L;
        this.mSkinType = 3;
        this.fwc = false;
        this.gki = false;
        this.gkj = 0;
        this.gkk = 0;
        this.gkl = false;
        this.gkm = 1;
        this.fhp = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fhn == null) {
                            PersonalizePageView.this.fhn = new k(new i());
                        }
                        PersonalizePageView.this.fhn.a(PersonalizePageView.this.gdY, 2);
                    } else if (PersonalizePageView.this.fhn != null) {
                        PersonalizePageView.this.fhn.jU();
                    }
                }
            }
        };
        this.giY = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
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
                    if (PersonalizePageView.this.gkb != null) {
                        PersonalizePageView.this.gkb.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fid", ajVar.getFid()).bS("obj_param1", ajVar.weight).bS("obj_source", ajVar.source).bS("obj_id", ajVar.extra).bS("obj_type", sb.toString()).bS("obj_name", str).O(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.dyr = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.dyr != i2 && PersonalizePageView.this.gee != null) {
                    PersonalizePageView.this.dyr = i2;
                    if (PersonalizePageView.this.dyr == 1) {
                        PersonalizePageView.this.gee.aJA();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gee.aJB();
                    } else {
                        PersonalizePageView.this.gee.aJA();
                    }
                }
            }
        };
        this.gef = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btR() {
                if (PersonalizePageView.this.gee != null) {
                    PersonalizePageView.this.dyr = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gdY)) {
                        PersonalizePageView.this.gee.aJB();
                    } else {
                        PersonalizePageView.this.gee.aJA();
                    }
                }
            }
        };
        this.gkn = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            private boolean fou = com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("key_first_install", true);

            private void buH() {
                if (this.fou) {
                    this.fou = false;
                    com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i2, int i22, int i3) {
                if (PersonalizePageView.this.gkc == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bfm = PersonalizePageView.this.bfm();
                PersonalizePageView.this.aJo();
                if (bfm) {
                    PersonalizePageView.this.p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                PersonalizePageView.this.gkc.L(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void v(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.gkc != null) {
                    PersonalizePageView.this.gkc.u(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    buH();
                } else if (!this.fou) {
                    PersonalizePageView.this.geg.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    buH();
                    PersonalizePageView.this.btG();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                buH();
                PersonalizePageView.this.geg.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aJo();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gkd.buU());
                PersonalizePageView.this.du(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.fxw != null) {
                    PersonalizePageView.this.fxw.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void buI() {
                if (PersonalizePageView.this.dwJ != null) {
                    PersonalizePageView.this.dwJ.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.dwJ.endLoadData();
                }
            }
        };
        this.gko = new h.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aDe().rg("page_recommend");
                PersonalizePageView.this.gkd.update();
                PersonalizePageView.this.gkd.ld(false);
                PersonalizePageView.this.gkl = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gjA = new h.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.h.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.gkd != null && PersonalizePageView.this.gkd.bkJ() != null) {
                    PersonalizePageView.this.gkd.bkJ().bur();
                }
            }
        };
        this.gkp = new h.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.h.a
            public void anW() {
                if (PersonalizePageView.this.gkl) {
                    PersonalizePageView.this.gkk = 0;
                    PersonalizePageView.this.gkm = 1;
                    PersonalizePageView.this.gkl = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gjB = new h.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.gkd != null) {
                    PersonalizePageView.this.gkd.ld(true);
                    PersonalizePageView.this.gkd.buN();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.alR().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.agy().hr(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gkq = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.alR().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.cwZ = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bsY();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gei = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aIW();
            }
        };
        this.fwQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.fwc = true;
                    }
                }
            }
        };
        this.gkr = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.geg != null && !PersonalizePageView.this.geg.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gjZ == null) {
                            PersonalizePageView.this.gjZ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gjZ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gka = PersonalizePageView.this.gjZ;
                            PersonalizePageView.this.buE();
                        } else if (PersonalizePageView.this.gka != PersonalizePageView.this.gjZ) {
                            PersonalizePageView.this.gka = PersonalizePageView.this.gjZ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gjZ.setEnable(true);
                        PersonalizePageView.this.geg.setProgressView(PersonalizePageView.this.gjZ);
                        int i2 = (int) (61.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.geg.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gjY == null) {
                        PersonalizePageView.this.gjY = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gka = PersonalizePageView.this.gjY;
                        PersonalizePageView.this.buE();
                    } else if (PersonalizePageView.this.gka != PersonalizePageView.this.gjY || !aVar.equals(PersonalizePageView.this.gjY.bvg())) {
                        PersonalizePageView.this.gka = PersonalizePageView.this.gjY;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gjY.setEnable(true);
                    PersonalizePageView.this.geg.setProgressView(PersonalizePageView.this.gjY);
                    PersonalizePageView.this.gjY.a(aVar);
                    PersonalizePageView.this.geg.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gdY = new BdTypeRecyclerView(context);
        this.bIT = new LinearLayoutManager(this.gdY.getContext());
        this.gdY.setLayoutManager(this.bIT);
        this.gdY.setFadingEdgeLength(0);
        this.gdY.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fhn = new k(new i());
            this.fhn.a(this.gdY, 2);
        }
        MessageManager.getInstance().registerListener(this.fhp);
        this.geg = new BigdaySwipeRefreshLayout(context);
        this.geg.addView(this.gdY);
        this.dwJ = new PbListView(context);
        this.dwJ.getView();
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dwJ.setLineGone();
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dwJ.setTextSize(R.dimen.tbfontsize33);
        this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dwJ.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.dwJ.setOnClickListener(this.gei);
        this.dwJ.anL();
        this.gdY.setNextPage(this.dwJ);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.gkr);
        com.baidu.tbadk.core.bigday.b.agy().dW(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.alR().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.agy().hr(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.geg);
        ((FrameLayout.LayoutParams) this.geg.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.gkf = new com.baidu.tieba.homepage.personalize.model.e();
        this.gkb = new w(context, this.gdY);
        this.gkb.b(this.gkf);
        this.gkd = new e(this.pageContext, this.gdY, this.gkb, this.geg);
        this.gke = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.fwQ);
        this.gkj = com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du(Context context) {
        if (this.gkh == null) {
            this.gkh = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds200);
            addView(this.gkh, layoutParams);
            this.gkh.setVisibility(8);
            this.gkh.setPageId(this.pageContext.getUniqueId());
            this.fxw = new com.baidu.tieba.c.c(this.pageContext, this.gkh, 1);
        }
    }

    public void buE() {
        if (this.gka != null) {
            this.gka.setListPullRefreshListener(this.gko);
            this.gka.a(this.gjA);
            this.gka.a(this.gkp);
            this.gka.a(this.gjB);
        }
    }

    public void aNd() {
        this.gkb.b(this.giY);
        this.gkd.a(this.gkn);
        this.gke.a(this);
        buE();
        this.gdY.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                PersonalizePageView.this.gkk += i2;
                if (PersonalizePageView.this.gkk < height * 3 || PersonalizePageView.this.gkm != 1) {
                    if (PersonalizePageView.this.gkk < height * 3 && PersonalizePageView.this.gkm == 2) {
                        PersonalizePageView.this.gkm = 1;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        return;
                    }
                    return;
                }
                PersonalizePageView.this.gkm = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.gkm)));
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.bIT != null && i == 0 && PersonalizePageView.this.bIT.getItemCount() - PersonalizePageView.this.bIT.findLastVisibleItemPosition() <= 3) {
                    PersonalizePageView.this.aIW();
                }
            }
        });
        this.gdY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aIW();
            }
        });
        this.gdY.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.gkg >= 5000) {
                    PersonalizePageView.this.gkd.bE(i, i2);
                }
            }
        }, 1L);
        this.gdY.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.gkd != null && PersonalizePageView.this.gkd.bkJ() != null) {
                        PersonalizePageView.this.gkd.bkJ().ck(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).baZ().stopPlay();
                    }
                }
            }
        });
        this.gdY.removeOnScrollListener(this.mOnScrollListener);
        this.gdY.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gkc = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.dwJ != null) {
            this.dwJ.setText(getContext().getString(R.string.pb_load_more));
            this.dwJ.endLoadData();
        }
        this.gkd.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.gkd != null) {
            this.gkd.lh(!z);
        }
        this.gki = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.gki;
    }

    public void c(Long l) {
        this.gkd.c(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.w wVar) {
        if (this.gkd != null) {
            this.gkd.setRecommendFrsNavigationAnimDispatcher(wVar);
        }
    }

    public void showFloatingView() {
        if (this.gkd != null) {
            this.gkd.showFloatingView();
        }
    }

    public void buF() {
        if (this.gkd != null) {
            this.gkd.buF();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dEq != null) {
                this.dEq.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.setBackgroundColor(this.geg, R.color.cp_bg_line_e);
            if (this.gjZ != null) {
                this.gjZ.changeSkin(i);
            }
            if (this.dwJ != null) {
                this.dwJ.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dwJ.changeSkin(i);
            }
            this.gkb.onChangeSkinType(i);
            if (this.gkd != null) {
                this.gkd.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aw(String str, int i) {
        if (this.dwJ != null) {
            this.dwJ.setText(getContext().getString(R.string.pb_load_more));
            this.dwJ.endLoadData();
        }
        this.gkd.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.gkd != null) {
                        PersonalizePageView.this.gkd.update();
                    }
                }
            });
        }
        this.refreshView.setSubText(str);
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJo() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.dEq != null) {
            this.dEq.dettachView(this);
            this.dEq = null;
            this.gdY.setNextPage(this.dwJ);
            this.dwJ.setText(getContext().getString(R.string.pb_load_more));
            this.dwJ.endLoadData();
        }
        if (this.geg != null) {
            this.geg.setVisibility(0);
        }
        if (this.gkc != null) {
            this.gkc.btw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfm() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, int i) {
        if (this.dEq == null) {
            if (i < 0) {
                this.dEq = new g(getContext());
            } else {
                this.dEq = new g(getContext(), i);
            }
            this.dEq.onChangeSkinType();
        }
        this.dEq.attachView(this, z);
        this.gdY.setNextPage(null);
        if (this.geg != null) {
            this.geg.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.gkd != null) {
            this.gkd.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.fxw != null) {
            this.fxw.aHJ();
        }
        setViewForeground(false);
        if (this.gkd != null) {
            this.gkd.jT(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.gkj < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.gkq, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gkd != null) {
            this.gkd.kX(z);
        }
        if (this.gee != null) {
            this.gee.b(this.gef);
            this.gee.a(this.gef);
            this.gef.btR();
        }
    }

    public void btG() {
        if (this.gkd != null) {
            p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.gkd.update();
        }
        if (com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") == 1) {
            com.baidu.tbadk.core.bigday.b.agy().agA();
            com.baidu.tbadk.core.bigday.b.agy().agz();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.gkd != null) {
            this.gkd.update();
        } else if (this.gdY != null && this.geg != null) {
            showFloatingView();
            this.gdY.setSelection(0);
            if (!this.geg.isRefreshing()) {
                if (this.gkd != null && this.gkd.bkJ() != null) {
                    this.gkd.bkJ().bur();
                    this.gkd.ld(false);
                }
                this.geg.setRefreshing(true);
            }
            if (this.gef != null) {
                this.gef.btR();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fhp);
        MessageManager.getInstance().unRegisterListener(this.fwQ);
        MessageManager.getInstance().unRegisterListener(this.gkr);
        this.gkd.onDestroy();
        this.gkb.b((NEGFeedBackView.a) null);
        this.gkb.onDestroy();
        this.gkd.a((e.a) null);
        if (this.gjY != null) {
            this.gjY.setListPullRefreshListener(null);
            this.gjY.a((h.d) null);
            this.gjY.a((h.a) null);
            this.gjY.a((h.b) null);
            this.gjY.release();
        }
        if (this.gjZ != null) {
            this.gjZ.setListPullRefreshListener(null);
            this.gjZ.a((h.d) null);
            this.gjZ.a((h.a) null);
            this.gjZ.a((h.b) null);
            this.gjZ.release();
        }
        this.gdY.setOnSrollToBottomListener(null);
        if (this.gee != null) {
            this.gee.b(this.gef);
        }
        this.gdY.removeOnScrollListener(this.mOnScrollListener);
        if (this.dEq != null) {
            this.dEq.release();
        }
        this.gdY.setRecyclerListener(null);
        if (this.gke != null) {
            this.gke.onDestroy();
        }
        if (this.fxw != null) {
            this.fxw.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.agy().destroy();
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.gkq);
    }

    public void onPause() {
        this.gkd.onPause();
        if (this.gkb != null) {
            this.gkb.onPause();
        }
    }

    public void onResume() {
        if (this.fwc) {
            reload();
            this.fwc = false;
        }
        if (this.geg != null) {
            this.geg.resume();
        }
        if (this.gkb != null) {
            this.gkb.onResume();
        }
    }

    public void bsY() {
        if (this.gkb != null) {
            this.gkb.notifyDataSetChanged();
        }
    }

    public void bsZ() {
        if (this.gkd != null) {
            this.gkd.jT(true);
        }
        t.baw().gF(false);
        com.baidu.tieba.a.d.aDe().bO("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.gkq);
    }

    public void buB() {
        this.gkd.buT();
    }

    public void buG() {
        this.gkd.buG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIW() {
        com.baidu.tieba.homepage.framework.a.btv().p(System.currentTimeMillis(), 1);
        if (this.dwJ != null && !this.dwJ.isLoading()) {
            this.dwJ.startLoadData();
            this.dwJ.showEmptyView(0);
        }
        this.gkd.aIW();
    }
}
