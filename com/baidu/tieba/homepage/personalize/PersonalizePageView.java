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
    private LinearLayoutManager cxR;
    private int dBW;
    private final CustomMessageListener doS;
    private PbListView elM;
    private int eog;
    private g euG;
    private BdTypeRecyclerView gYh;
    private ScrollFragmentTabHost gYn;
    ScrollFragmentTabHost.a gYo;
    private BigdaySwipeRefreshLayout gYp;
    private View.OnClickListener gYr;
    private k gbf;
    private CustomMessageListener gbh;
    private boolean gpV;
    private CustomMessageListener gqE;
    private int gqe;
    private com.baidu.tieba.c.c grl;
    g.d hcV;
    g.b hcW;
    private NEGFeedBackView.a hct;
    private com.baidu.tieba.homepage.personalize.a hdA;
    private com.baidu.tieba.homepage.personalize.model.e hdB;
    private long hdC;
    private FloatingAnimationView hdD;
    private boolean hdE;
    private int hdF;
    private boolean hdG;
    private FRSRefreshButton hdH;
    private e.a hdI;
    g.c hdJ;
    g.a hdK;
    private Runnable hdL;
    public CustomMessageListener hdM;
    private View.OnClickListener hdN;
    private com.baidu.tieba.homepage.personalize.bigday.b hdu;
    private com.baidu.tieba.homepage.personalize.bigday.a hdv;
    private a hdw;
    private ad hdx;
    private com.baidu.tieba.homepage.framework.b hdy;
    private e hdz;
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
        int i = personalizePageView.hdF + 1;
        personalizePageView.hdF = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gYn = scrollFragmentTabHost;
        if (this.gYn != null) {
            this.gYn.b(this.gYo);
            this.gYn.a(this.gYo);
        }
        if (this.hdz != null) {
            this.hdz.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hdA != null) {
            this.hdA.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.gYp != null) {
            this.gYp.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hdx != null) {
            this.hdx.setPageUniqueId(bdUniqueId);
        }
        if (this.hdz != null) {
            this.hdz.m(bdUniqueId);
        }
        if (this.hdB != null) {
            this.hdB.h(bdUniqueId);
        }
        if (this.hdv != null) {
            this.hdv.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.azZ().setTag(bdUniqueId);
        if (this.doS != null) {
            this.doS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.doS);
        }
        if (this.hdA != null) {
            this.hdA.setBdUniqueId(bdUniqueId);
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
        oVar.Jd(floatInfo.float_url);
        oVar.Jc(floatInfo.jump_url);
        oVar.setType(floatInfo.show_type.intValue());
        return oVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.hdC = 0L;
        this.mSkinType = 3;
        this.gpV = false;
        this.hdE = false;
        this.hdF = 0;
        this.gqe = 0;
        this.hdG = false;
        this.dBW = 1;
        this.gbh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gbf == null) {
                            PersonalizePageView.this.gbf = new k(new i());
                        }
                        PersonalizePageView.this.gbf.a(PersonalizePageView.this.gYh, 2);
                    } else if (PersonalizePageView.this.gbf != null) {
                        PersonalizePageView.this.gbf.kB();
                    }
                }
            }
        };
        this.hct = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cx("obj_locate", "1").cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.hdx != null) {
                        PersonalizePageView.this.hdx.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("fid", alVar.getFid()).cx("obj_param1", alVar.weight).cx("obj_source", alVar.source).cx("obj_id", alVar.extra).cx("obj_type", sb.toString()).cx("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.eog = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.eog != i && PersonalizePageView.this.gYn != null) {
                    PersonalizePageView.this.eog = i;
                    if (PersonalizePageView.this.eog == 1) {
                        PersonalizePageView.this.gYn.bcR();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gYn.bcS();
                    } else {
                        PersonalizePageView.this.gYn.bcR();
                    }
                }
            }
        };
        this.gYo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bOc() {
                if (PersonalizePageView.this.gYn != null) {
                    PersonalizePageView.this.eog = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gYh)) {
                        PersonalizePageView.this.gYn.bcS();
                    } else {
                        PersonalizePageView.this.gYn.bcR();
                    }
                }
            }
        };
        this.hdI = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gij = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("key_first_install", true);

            private void bOU() {
                if (this.gij) {
                    this.gij = false;
                    com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i, int i2, int i3) {
                if (PersonalizePageView.this.hdy == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bzs = PersonalizePageView.this.bzs();
                PersonalizePageView.this.bcC();
                if (bzs) {
                    PersonalizePageView.this.eN(true);
                }
                PersonalizePageView.this.hdy.M(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hdy != null) {
                    PersonalizePageView.this.hdy.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bOU();
                } else if (!this.gij) {
                    PersonalizePageView.this.gYp.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bOU();
                    PersonalizePageView.this.bNR();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bOU();
                PersonalizePageView.this.gYp.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bcC();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hdz.bPh());
                PersonalizePageView.this.eP(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.grl != null) {
                    PersonalizePageView.this.grl.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bOV() {
                if (PersonalizePageView.this.elM != null) {
                    PersonalizePageView.this.elM.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.elM.endLoadData();
                    PersonalizePageView.this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hdJ = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aXK().wO("page_recommend");
                PersonalizePageView.this.hdz.update();
                PersonalizePageView.this.hdz.mJ(false);
                PersonalizePageView.this.hdG = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hcV = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hdz != null && PersonalizePageView.this.hdz.bEV() != null) {
                    PersonalizePageView.this.hdz.bEV().bOE();
                }
            }
        };
        this.hdK = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aIc() {
                if (PersonalizePageView.this.hdG) {
                    PersonalizePageView.this.gqe = 0;
                    PersonalizePageView.this.dBW = 1;
                    PersonalizePageView.this.hdG = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hcW = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hdz != null) {
                    PersonalizePageView.this.hdz.mJ(true);
                    PersonalizePageView.this.hdz.bPa();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFH().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.azZ().jt(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hdL = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aFH().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.doS = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bNt();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gYr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bck();
            }
        };
        this.gqE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gpV = true;
                    }
                }
            }
        };
        this.hdM = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gYp != null && !PersonalizePageView.this.gYp.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hdv == null) {
                            PersonalizePageView.this.hdv = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hdv.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hdw = PersonalizePageView.this.hdv;
                            PersonalizePageView.this.bOR();
                        } else if (PersonalizePageView.this.hdw != PersonalizePageView.this.hdv) {
                            PersonalizePageView.this.hdw = PersonalizePageView.this.hdv;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hdv.setEnable(true);
                        PersonalizePageView.this.gYp.setProgressView(PersonalizePageView.this.hdv);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gYp.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hdu == null) {
                        PersonalizePageView.this.hdu = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hdw = PersonalizePageView.this.hdu;
                        PersonalizePageView.this.bOR();
                    } else if (PersonalizePageView.this.hdw != PersonalizePageView.this.hdu || !aVar.equals(PersonalizePageView.this.hdu.bPt())) {
                        PersonalizePageView.this.hdw = PersonalizePageView.this.hdu;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hdu.setEnable(true);
                    PersonalizePageView.this.gYp.setProgressView(PersonalizePageView.this.hdu);
                    PersonalizePageView.this.hdu.a(aVar);
                    PersonalizePageView.this.gYp.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hdN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hdH != null) {
                    PersonalizePageView.this.hdH.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hdC = 0L;
        this.mSkinType = 3;
        this.gpV = false;
        this.hdE = false;
        this.hdF = 0;
        this.gqe = 0;
        this.hdG = false;
        this.dBW = 1;
        this.gbh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gbf == null) {
                            PersonalizePageView.this.gbf = new k(new i());
                        }
                        PersonalizePageView.this.gbf.a(PersonalizePageView.this.gYh, 2);
                    } else if (PersonalizePageView.this.gbf != null) {
                        PersonalizePageView.this.gbf.kB();
                    }
                }
            }
        };
        this.hct = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cx("obj_locate", "1").cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.hdx != null) {
                        PersonalizePageView.this.hdx.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("fid", alVar.getFid()).cx("obj_param1", alVar.weight).cx("obj_source", alVar.source).cx("obj_id", alVar.extra).cx("obj_type", sb.toString()).cx("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.eog = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.eog != i && PersonalizePageView.this.gYn != null) {
                    PersonalizePageView.this.eog = i;
                    if (PersonalizePageView.this.eog == 1) {
                        PersonalizePageView.this.gYn.bcR();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gYn.bcS();
                    } else {
                        PersonalizePageView.this.gYn.bcR();
                    }
                }
            }
        };
        this.gYo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bOc() {
                if (PersonalizePageView.this.gYn != null) {
                    PersonalizePageView.this.eog = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gYh)) {
                        PersonalizePageView.this.gYn.bcS();
                    } else {
                        PersonalizePageView.this.gYn.bcR();
                    }
                }
            }
        };
        this.hdI = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gij = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("key_first_install", true);

            private void bOU() {
                if (this.gij) {
                    this.gij = false;
                    com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i, int i2, int i3) {
                if (PersonalizePageView.this.hdy == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bzs = PersonalizePageView.this.bzs();
                PersonalizePageView.this.bcC();
                if (bzs) {
                    PersonalizePageView.this.eN(true);
                }
                PersonalizePageView.this.hdy.M(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.hdy != null) {
                    PersonalizePageView.this.hdy.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bOU();
                } else if (!this.gij) {
                    PersonalizePageView.this.gYp.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bOU();
                    PersonalizePageView.this.bNR();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bOU();
                PersonalizePageView.this.gYp.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bcC();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hdz.bPh());
                PersonalizePageView.this.eP(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.grl != null) {
                    PersonalizePageView.this.grl.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bOV() {
                if (PersonalizePageView.this.elM != null) {
                    PersonalizePageView.this.elM.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.elM.endLoadData();
                    PersonalizePageView.this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hdJ = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aXK().wO("page_recommend");
                PersonalizePageView.this.hdz.update();
                PersonalizePageView.this.hdz.mJ(false);
                PersonalizePageView.this.hdG = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hcV = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hdz != null && PersonalizePageView.this.hdz.bEV() != null) {
                    PersonalizePageView.this.hdz.bEV().bOE();
                }
            }
        };
        this.hdK = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aIc() {
                if (PersonalizePageView.this.hdG) {
                    PersonalizePageView.this.gqe = 0;
                    PersonalizePageView.this.dBW = 1;
                    PersonalizePageView.this.hdG = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hcW = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hdz != null) {
                    PersonalizePageView.this.hdz.mJ(true);
                    PersonalizePageView.this.hdz.bPa();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFH().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.azZ().jt(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hdL = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aFH().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.doS = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bNt();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gYr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bck();
            }
        };
        this.gqE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gpV = true;
                    }
                }
            }
        };
        this.hdM = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gYp != null && !PersonalizePageView.this.gYp.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hdv == null) {
                            PersonalizePageView.this.hdv = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hdv.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hdw = PersonalizePageView.this.hdv;
                            PersonalizePageView.this.bOR();
                        } else if (PersonalizePageView.this.hdw != PersonalizePageView.this.hdv) {
                            PersonalizePageView.this.hdw = PersonalizePageView.this.hdv;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hdv.setEnable(true);
                        PersonalizePageView.this.gYp.setProgressView(PersonalizePageView.this.hdv);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gYp.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hdu == null) {
                        PersonalizePageView.this.hdu = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hdw = PersonalizePageView.this.hdu;
                        PersonalizePageView.this.bOR();
                    } else if (PersonalizePageView.this.hdw != PersonalizePageView.this.hdu || !aVar.equals(PersonalizePageView.this.hdu.bPt())) {
                        PersonalizePageView.this.hdw = PersonalizePageView.this.hdu;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hdu.setEnable(true);
                    PersonalizePageView.this.gYp.setProgressView(PersonalizePageView.this.hdu);
                    PersonalizePageView.this.hdu.a(aVar);
                    PersonalizePageView.this.gYp.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hdN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hdH != null) {
                    PersonalizePageView.this.hdH.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hdC = 0L;
        this.mSkinType = 3;
        this.gpV = false;
        this.hdE = false;
        this.hdF = 0;
        this.gqe = 0;
        this.hdG = false;
        this.dBW = 1;
        this.gbh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gbf == null) {
                            PersonalizePageView.this.gbf = new k(new i());
                        }
                        PersonalizePageView.this.gbf.a(PersonalizePageView.this.gYh, 2);
                    } else if (PersonalizePageView.this.gbf != null) {
                        PersonalizePageView.this.gbf.kB();
                    }
                }
            }
        };
        this.hct = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cx("obj_locate", "1").cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.hdx != null) {
                        PersonalizePageView.this.hdx.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("fid", alVar.getFid()).cx("obj_param1", alVar.weight).cx("obj_source", alVar.source).cx("obj_id", alVar.extra).cx("obj_type", sb.toString()).cx("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.eog = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.eog != i2 && PersonalizePageView.this.gYn != null) {
                    PersonalizePageView.this.eog = i2;
                    if (PersonalizePageView.this.eog == 1) {
                        PersonalizePageView.this.gYn.bcR();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gYn.bcS();
                    } else {
                        PersonalizePageView.this.gYn.bcR();
                    }
                }
            }
        };
        this.gYo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bOc() {
                if (PersonalizePageView.this.gYn != null) {
                    PersonalizePageView.this.eog = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gYh)) {
                        PersonalizePageView.this.gYn.bcS();
                    } else {
                        PersonalizePageView.this.gYn.bcR();
                    }
                }
            }
        };
        this.hdI = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gij = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("key_first_install", true);

            private void bOU() {
                if (this.gij) {
                    this.gij = false;
                    com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void N(int i2, int i22, int i3) {
                if (PersonalizePageView.this.hdy == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bzs = PersonalizePageView.this.bzs();
                PersonalizePageView.this.bcC();
                if (bzs) {
                    PersonalizePageView.this.eN(true);
                }
                PersonalizePageView.this.hdy.M(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.hdy != null) {
                    PersonalizePageView.this.hdy.y(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bOU();
                } else if (!this.gij) {
                    PersonalizePageView.this.gYp.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bOU();
                    PersonalizePageView.this.bNR();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bOU();
                PersonalizePageView.this.gYp.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bcC();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.hdz.bPh());
                PersonalizePageView.this.eP(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.grl != null) {
                    PersonalizePageView.this.grl.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bOV() {
                if (PersonalizePageView.this.elM != null) {
                    PersonalizePageView.this.elM.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.elM.endLoadData();
                    PersonalizePageView.this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.hdJ = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aXK().wO("page_recommend");
                PersonalizePageView.this.hdz.update();
                PersonalizePageView.this.hdz.mJ(false);
                PersonalizePageView.this.hdG = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.hcV = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.hdz != null && PersonalizePageView.this.hdz.bEV() != null) {
                    PersonalizePageView.this.hdz.bEV().bOE();
                }
            }
        };
        this.hdK = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aIc() {
                if (PersonalizePageView.this.hdG) {
                    PersonalizePageView.this.gqe = 0;
                    PersonalizePageView.this.dBW = 1;
                    PersonalizePageView.this.hdG = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.hcW = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.hdz != null) {
                    PersonalizePageView.this.hdz.mJ(true);
                    PersonalizePageView.this.hdz.bPa();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFH().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.azZ().jt(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.hdL = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aFH().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.doS = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                                PersonalizePageView.this.bNt();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gYr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bck();
            }
        };
        this.gqE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gpV = true;
                    }
                }
            }
        };
        this.hdM = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gYp != null && !PersonalizePageView.this.gYp.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.hdv == null) {
                            PersonalizePageView.this.hdv = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.hdv.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.hdw = PersonalizePageView.this.hdv;
                            PersonalizePageView.this.bOR();
                        } else if (PersonalizePageView.this.hdw != PersonalizePageView.this.hdv) {
                            PersonalizePageView.this.hdw = PersonalizePageView.this.hdv;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.hdv.setEnable(true);
                        PersonalizePageView.this.gYp.setProgressView(PersonalizePageView.this.hdv);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gYp.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.hdu == null) {
                        PersonalizePageView.this.hdu = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.hdw = PersonalizePageView.this.hdu;
                        PersonalizePageView.this.bOR();
                    } else if (PersonalizePageView.this.hdw != PersonalizePageView.this.hdu || !aVar.equals(PersonalizePageView.this.hdu.bPt())) {
                        PersonalizePageView.this.hdw = PersonalizePageView.this.hdu;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.hdu.setEnable(true);
                    PersonalizePageView.this.gYp.setProgressView(PersonalizePageView.this.hdu);
                    PersonalizePageView.this.hdu.a(aVar);
                    PersonalizePageView.this.gYp.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.hdN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.hdH != null) {
                    PersonalizePageView.this.hdH.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gYh = new BdTypeRecyclerView(context);
        this.cxR = new LinearLayoutManager(this.gYh.getContext());
        this.gYh.setLayoutManager(this.cxR);
        this.gYh.setFadingEdgeLength(0);
        this.gYh.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gbf = new k(new i());
            this.gbf.a(this.gYh, 2);
        }
        MessageManager.getInstance().registerListener(this.gbh);
        this.gYp = new BigdaySwipeRefreshLayout(context);
        this.gYp.addView(this.gYh);
        this.elM = new PbListView(context);
        this.elM.getView();
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elM.setLineGone();
        this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elM.setTextSize(R.dimen.tbfontsize33);
        this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elM.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.elM.setOnClickListener(this.gYr);
        this.elM.aHL();
        this.gYh.setNextPage(this.elM);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.hdM);
        com.baidu.tbadk.core.bigday.b.azZ().fu(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFH().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.azZ().jt(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.gYp);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.hdH = new FRSRefreshButton(context);
            int dimens = l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds180);
            addView(this.hdH, layoutParams);
            this.hdH.setOnClickListener(this.hdN);
            this.hdH.setVisibility(8);
        }
        this.hdB = new com.baidu.tieba.homepage.personalize.model.e();
        this.hdx = new ad(context, this.gYh);
        this.hdx.b(this.hdB);
        this.hdz = new e(this.pageContext, this.gYh, this.hdx, this.gYp);
        this.hdA = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.gqE);
        this.hdF = com.baidu.tbadk.core.sharedPref.b.aFH().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(Context context) {
        if (this.hdD == null) {
            this.hdD = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds200);
            addView(this.hdD, layoutParams);
            this.hdD.setVisibility(8);
            this.hdD.setPageId(this.pageContext.getUniqueId());
            this.grl = new com.baidu.tieba.c.c(this.pageContext, this.hdD, 1);
        }
    }

    public void bOR() {
        if (this.hdw != null) {
            this.hdw.setListPullRefreshListener(this.hdJ);
            this.hdw.a(this.hcV);
            this.hdw.a(this.hdK);
            this.hdw.a(this.hcW);
        }
    }

    public void initListeners() {
        this.hdx.b(this.hct);
        this.hdz.a(this.hdI);
        this.hdA.a(this);
        bOR();
        this.gYh.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.gqe += i2;
                if (PersonalizePageView.this.hdH != null) {
                    m item = PersonalizePageView.this.gYh.getItem(PersonalizePageView.this.cxR.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.k) {
                        if (((com.baidu.tieba.card.data.k) item).position >= 6) {
                            PersonalizePageView.this.hdH.show();
                        } else {
                            PersonalizePageView.this.hdH.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.cxR != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.gqe < height * 3 || PersonalizePageView.this.dBW != 1) {
                        if (PersonalizePageView.this.gqe < height * 3 && PersonalizePageView.this.dBW == 2) {
                            PersonalizePageView.this.dBW = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.dBW = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.dBW)));
                    }
                    if (PersonalizePageView.this.cxR.getItemCount() - PersonalizePageView.this.cxR.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bck();
                    }
                }
            }
        });
        this.gYh.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bck();
            }
        });
        this.gYh.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.hdC >= 5000) {
                    PersonalizePageView.this.hdz.bV(i, i2);
                }
            }
        }, 1L);
        this.gYh.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.hdz != null && PersonalizePageView.this.hdz.bEV() != null) {
                        PersonalizePageView.this.hdz.bEV().cl(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                        ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bvQ().stopPlay();
                    }
                }
            }
        });
        this.gYh.removeOnScrollListener(this.mOnScrollListener);
        this.gYh.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.hdy = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.elM != null) {
            this.elM.setText(getContext().getString(R.string.pb_load_more));
            this.elM.endLoadData();
            this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hdz.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.hdz != null) {
            this.hdz.mN(!z);
        }
        this.hdE = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.hdE;
    }

    public void e(Long l) {
        this.hdz.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.hdz != null) {
            this.hdz.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void showFloatingView() {
        if (this.hdz != null) {
            this.hdz.showFloatingView();
        }
    }

    public void bOS() {
        if (this.hdz != null) {
            this.hdz.bOS();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.euG != null) {
                this.euG.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.hdv != null) {
                this.hdv.changeSkin(i);
            }
            if (this.elM != null) {
                this.elM.setTextColor(am.getColor(R.color.cp_cont_d));
                this.elM.changeSkin(i);
            }
            this.hdx.onChangeSkinType(i);
            if (this.hdz != null) {
                this.hdz.onChangeSkinType(i);
            }
            if (this.hdH != null) {
                this.hdH.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aE(String str, int i) {
        if (this.elM != null) {
            this.elM.setText(getContext().getString(R.string.pb_load_more));
            this.elM.endLoadData();
            this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hdz.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.hdz != null) {
                        PersonalizePageView.this.hdz.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcC() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.euG != null) {
            this.euG.dettachView(this);
            this.euG = null;
            this.gYh.setNextPage(this.elM);
            this.elM.setText(getContext().getString(R.string.pb_load_more));
            this.elM.endLoadData();
            this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.gYp != null) {
            this.gYp.setVisibility(0);
        }
        if (this.hdy != null) {
            this.hdy.bNI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzs() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(boolean z) {
        if (this.euG == null) {
            this.euG = new com.baidu.tbadk.k.g(getContext());
            this.euG.aN(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
            this.euG.aPY();
            this.euG.setWrapStyle(true);
            this.euG.onChangeSkinType();
        }
        this.euG.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.gYh.setNextPage(null);
        if (this.gYp != null) {
            this.gYp.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.hdz != null) {
            this.hdz.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.grl != null) {
            this.grl.baH();
        }
        setViewForeground(false);
        if (this.hdz != null) {
            this.hdz.lz(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.hdF < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hdL, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.hdz != null) {
            this.hdz.mD(z);
        }
        if (this.gYn != null) {
            this.gYn.b(this.gYo);
            this.gYn.a(this.gYo);
            this.gYo.bOc();
        }
    }

    public void bNR() {
        if (this.hdz != null) {
            eN(true);
            this.hdz.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.azZ().aAb();
            com.baidu.tbadk.core.bigday.b.azZ().aAa();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.hdz != null) {
            this.hdz.update();
        } else if (this.gYh != null && this.gYp != null) {
            showFloatingView();
            this.gYh.setSelection(0);
            if (!this.gYp.isRefreshing()) {
                if (this.hdz != null && this.hdz.bEV() != null) {
                    this.hdz.bEV().bOE();
                    this.hdz.mJ(false);
                }
                this.gYp.setRefreshing(true);
            }
            if (this.gYo != null) {
                this.gYo.bOc();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gbh);
        MessageManager.getInstance().unRegisterListener(this.gqE);
        MessageManager.getInstance().unRegisterListener(this.hdM);
        this.hdz.onDestroy();
        this.hdx.b((NEGFeedBackView.a) null);
        this.hdx.onDestroy();
        this.hdz.a((e.a) null);
        if (this.hdu != null) {
            this.hdu.setListPullRefreshListener(null);
            this.hdu.a((g.d) null);
            this.hdu.a((g.a) null);
            this.hdu.a((g.b) null);
            this.hdu.release();
        }
        if (this.hdv != null) {
            this.hdv.setListPullRefreshListener(null);
            this.hdv.a((g.d) null);
            this.hdv.a((g.a) null);
            this.hdv.a((g.b) null);
            this.hdv.release();
        }
        this.gYh.setOnSrollToBottomListener(null);
        if (this.gYn != null) {
            this.gYn.b(this.gYo);
        }
        this.gYh.removeOnScrollListener(this.mOnScrollListener);
        if (this.euG != null) {
            this.euG.release();
        }
        this.gYh.setRecyclerListener(null);
        if (this.hdA != null) {
            this.hdA.onDestroy();
        }
        if (this.grl != null) {
            this.grl.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.azZ().destroy();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hdL);
    }

    public void onPause() {
        this.hdz.onPause();
        if (this.hdx != null) {
            this.hdx.onPause();
        }
    }

    public void onResume() {
        if (this.gpV) {
            reload();
            this.gpV = false;
        }
        if (this.gYp != null) {
            this.gYp.resume();
        }
        if (this.hdx != null) {
            this.hdx.onResume();
        }
    }

    public void bNt() {
        if (this.hdx != null) {
            this.hdx.notifyDataSetChanged();
        }
    }

    public void bNu() {
        if (this.hdz != null) {
            this.hdz.lz(true);
        }
        r.bvm().id(false);
        com.baidu.tieba.a.d.aXK().cu("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hdL);
    }

    public void bOO() {
        this.hdz.bPg();
    }

    public void bOT() {
        this.hdz.bOT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bck() {
        com.baidu.tieba.homepage.framework.a.bNH().q(System.currentTimeMillis(), 1);
        if (this.elM != null && !this.elM.isLoading()) {
            this.elM.startLoadData();
            this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.hdz.bck();
    }
}
