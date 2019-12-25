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
/* loaded from: classes6.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager ctr;
    private final CustomMessageListener djU;
    private int dxk;
    private PbListView egU;
    private int eiC;
    private g eoy;
    private k fUZ;
    private CustomMessageListener fVb;
    private View.OnClickListener gRB;
    private BdTypeRecyclerView gRr;
    private ScrollFragmentTabHost gRx;
    ScrollFragmentTabHost.a gRy;
    private BigdaySwipeRefreshLayout gRz;
    private NEGFeedBackView.a gVz;
    private com.baidu.tieba.homepage.personalize.bigday.b gWA;
    private com.baidu.tieba.homepage.personalize.bigday.a gWB;
    private a gWC;
    private ab gWD;
    private com.baidu.tieba.homepage.framework.b gWE;
    private e gWF;
    private com.baidu.tieba.homepage.personalize.a gWG;
    private com.baidu.tieba.homepage.personalize.model.e gWH;
    private long gWI;
    private FloatingAnimationView gWJ;
    private boolean gWK;
    private int gWL;
    private boolean gWM;
    private FRSRefreshButton gWN;
    private e.a gWO;
    g.c gWP;
    g.a gWQ;
    private Runnable gWR;
    public CustomMessageListener gWS;
    private View.OnClickListener gWT;
    g.d gWb;
    g.b gWc;
    private boolean gjL;
    private int gjV;
    private CustomMessageListener gkv;
    private com.baidu.tieba.c.c glc;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes6.dex */
    public interface a {
        void a(g.a aVar);

        void a(g.b bVar);

        void a(g.d dVar);

        void setListPullRefreshListener(g.c cVar);
    }

    static /* synthetic */ int w(PersonalizePageView personalizePageView) {
        int i = personalizePageView.gWL + 1;
        personalizePageView.gWL = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gRx = scrollFragmentTabHost;
        if (this.gRx != null) {
            this.gRx.b(this.gRy);
            this.gRx.a(this.gRy);
        }
        if (this.gWF != null) {
            this.gWF.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gWG != null) {
            this.gWG.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.gRz != null) {
            this.gRz.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gWD != null) {
            this.gWD.setPageUniqueId(bdUniqueId);
        }
        if (this.gWF != null) {
            this.gWF.m(bdUniqueId);
        }
        if (this.gWH != null) {
            this.gWH.h(bdUniqueId);
        }
        if (this.gWB != null) {
            this.gWB.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.axn().setTag(bdUniqueId);
        if (this.djU != null) {
            this.djU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.djU);
        }
        if (this.gWG != null) {
            this.gWG.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        o oVar = new o();
        oVar.IG(String.valueOf(floatInfo.activity_id));
        oVar.ei(floatInfo.dynamic_url);
        oVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        oVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        oVar.IF(floatInfo.float_url);
        oVar.IE(floatInfo.jump_url);
        oVar.setType(floatInfo.show_type.intValue());
        return oVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.gWI = 0L;
        this.mSkinType = 3;
        this.gjL = false;
        this.gWK = false;
        this.gWL = 0;
        this.gjV = 0;
        this.gWM = false;
        this.dxk = 1;
        this.fVb = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fUZ == null) {
                            PersonalizePageView.this.fUZ = new k(new i());
                        }
                        PersonalizePageView.this.fUZ.a(PersonalizePageView.this.gRr, 2);
                    } else if (PersonalizePageView.this.fUZ != null) {
                        PersonalizePageView.this.fUZ.kl();
                    }
                }
            }
        };
        this.gVz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cp("obj_locate", "1").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.gWD != null) {
                        PersonalizePageView.this.gWD.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fid", alVar.getFid()).cp("obj_param1", alVar.weight).cp("obj_source", alVar.source).cp("obj_id", alVar.extra).cp("obj_type", sb.toString()).cp("obj_name", str).Z(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.eiC = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.eiC != i && PersonalizePageView.this.gRx != null) {
                    PersonalizePageView.this.eiC = i;
                    if (PersonalizePageView.this.eiC == 1) {
                        PersonalizePageView.this.gRx.aZW();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gRx.aZX();
                    } else {
                        PersonalizePageView.this.gRx.aZW();
                    }
                }
            }
        };
        this.gRy = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bLd() {
                if (PersonalizePageView.this.gRx != null) {
                    PersonalizePageView.this.eiC = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gRr)) {
                        PersonalizePageView.this.gRx.aZX();
                    } else {
                        PersonalizePageView.this.gRx.aZW();
                    }
                }
            }
        };
        this.gWO = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gca = com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("key_first_install", true);

            private void bLT() {
                if (this.gca) {
                    this.gca = false;
                    com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i, int i2, int i3) {
                if (PersonalizePageView.this.gWE == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bwF = PersonalizePageView.this.bwF();
                PersonalizePageView.this.aZK();
                if (bwF) {
                    PersonalizePageView.this.eA(true);
                }
                PersonalizePageView.this.gWE.L(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gWE != null) {
                    PersonalizePageView.this.gWE.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bLT();
                } else if (!this.gca) {
                    PersonalizePageView.this.gRz.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bLT();
                    PersonalizePageView.this.bKS();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bLT();
                PersonalizePageView.this.gRz.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aZK();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gWF.bMg());
                PersonalizePageView.this.eN(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.glc != null) {
                    PersonalizePageView.this.glc.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bLU() {
                if (PersonalizePageView.this.egU != null) {
                    PersonalizePageView.this.egU.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.egU.endLoadData();
                    PersonalizePageView.this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.gWP = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aUV().wp("page_recommend");
                PersonalizePageView.this.gWF.update();
                PersonalizePageView.this.gWF.mq(false);
                PersonalizePageView.this.gWM = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gWb = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.gWF != null && PersonalizePageView.this.gWF.bCd() != null) {
                    PersonalizePageView.this.gWF.bCd().bLD();
                }
            }
        };
        this.gWQ = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aFn() {
                if (PersonalizePageView.this.gWM) {
                    PersonalizePageView.this.gjV = 0;
                    PersonalizePageView.this.dxk = 1;
                    PersonalizePageView.this.gWM = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gWc = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.gWF != null) {
                    PersonalizePageView.this.gWF.mq(true);
                    PersonalizePageView.this.gWF.bLZ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aCY().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.axn().jb(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gWR = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aCY().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.djU = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bKu();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gRB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aZs();
            }
        };
        this.gkv = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gjL = true;
                    }
                }
            }
        };
        this.gWS = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gRz != null && !PersonalizePageView.this.gRz.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gWB == null) {
                            PersonalizePageView.this.gWB = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gWB.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gWC = PersonalizePageView.this.gWB;
                            PersonalizePageView.this.bLQ();
                        } else if (PersonalizePageView.this.gWC != PersonalizePageView.this.gWB) {
                            PersonalizePageView.this.gWC = PersonalizePageView.this.gWB;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gWB.setEnable(true);
                        PersonalizePageView.this.gRz.setProgressView(PersonalizePageView.this.gWB);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gRz.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gWA == null) {
                        PersonalizePageView.this.gWA = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gWC = PersonalizePageView.this.gWA;
                        PersonalizePageView.this.bLQ();
                    } else if (PersonalizePageView.this.gWC != PersonalizePageView.this.gWA || !aVar.equals(PersonalizePageView.this.gWA.bMs())) {
                        PersonalizePageView.this.gWC = PersonalizePageView.this.gWA;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gWA.setEnable(true);
                    PersonalizePageView.this.gRz.setProgressView(PersonalizePageView.this.gWA);
                    PersonalizePageView.this.gWA.a(aVar);
                    PersonalizePageView.this.gRz.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.gWT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.gWN != null) {
                    PersonalizePageView.this.gWN.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gWI = 0L;
        this.mSkinType = 3;
        this.gjL = false;
        this.gWK = false;
        this.gWL = 0;
        this.gjV = 0;
        this.gWM = false;
        this.dxk = 1;
        this.fVb = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fUZ == null) {
                            PersonalizePageView.this.fUZ = new k(new i());
                        }
                        PersonalizePageView.this.fUZ.a(PersonalizePageView.this.gRr, 2);
                    } else if (PersonalizePageView.this.fUZ != null) {
                        PersonalizePageView.this.fUZ.kl();
                    }
                }
            }
        };
        this.gVz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cp("obj_locate", "1").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.gWD != null) {
                        PersonalizePageView.this.gWD.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fid", alVar.getFid()).cp("obj_param1", alVar.weight).cp("obj_source", alVar.source).cp("obj_id", alVar.extra).cp("obj_type", sb.toString()).cp("obj_name", str).Z(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.eiC = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.eiC != i && PersonalizePageView.this.gRx != null) {
                    PersonalizePageView.this.eiC = i;
                    if (PersonalizePageView.this.eiC == 1) {
                        PersonalizePageView.this.gRx.aZW();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gRx.aZX();
                    } else {
                        PersonalizePageView.this.gRx.aZW();
                    }
                }
            }
        };
        this.gRy = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bLd() {
                if (PersonalizePageView.this.gRx != null) {
                    PersonalizePageView.this.eiC = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gRr)) {
                        PersonalizePageView.this.gRx.aZX();
                    } else {
                        PersonalizePageView.this.gRx.aZW();
                    }
                }
            }
        };
        this.gWO = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gca = com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("key_first_install", true);

            private void bLT() {
                if (this.gca) {
                    this.gca = false;
                    com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i, int i2, int i3) {
                if (PersonalizePageView.this.gWE == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bwF = PersonalizePageView.this.bwF();
                PersonalizePageView.this.aZK();
                if (bwF) {
                    PersonalizePageView.this.eA(true);
                }
                PersonalizePageView.this.gWE.L(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.gWE != null) {
                    PersonalizePageView.this.gWE.y(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bLT();
                } else if (!this.gca) {
                    PersonalizePageView.this.gRz.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bLT();
                    PersonalizePageView.this.bKS();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bLT();
                PersonalizePageView.this.gRz.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aZK();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gWF.bMg());
                PersonalizePageView.this.eN(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.glc != null) {
                    PersonalizePageView.this.glc.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bLU() {
                if (PersonalizePageView.this.egU != null) {
                    PersonalizePageView.this.egU.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.egU.endLoadData();
                    PersonalizePageView.this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.gWP = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aUV().wp("page_recommend");
                PersonalizePageView.this.gWF.update();
                PersonalizePageView.this.gWF.mq(false);
                PersonalizePageView.this.gWM = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gWb = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.gWF != null && PersonalizePageView.this.gWF.bCd() != null) {
                    PersonalizePageView.this.gWF.bCd().bLD();
                }
            }
        };
        this.gWQ = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aFn() {
                if (PersonalizePageView.this.gWM) {
                    PersonalizePageView.this.gjV = 0;
                    PersonalizePageView.this.dxk = 1;
                    PersonalizePageView.this.gWM = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gWc = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.gWF != null) {
                    PersonalizePageView.this.gWF.mq(true);
                    PersonalizePageView.this.gWF.bLZ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aCY().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.axn().jb(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gWR = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aCY().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.djU = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bKu();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gRB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aZs();
            }
        };
        this.gkv = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gjL = true;
                    }
                }
            }
        };
        this.gWS = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gRz != null && !PersonalizePageView.this.gRz.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gWB == null) {
                            PersonalizePageView.this.gWB = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gWB.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gWC = PersonalizePageView.this.gWB;
                            PersonalizePageView.this.bLQ();
                        } else if (PersonalizePageView.this.gWC != PersonalizePageView.this.gWB) {
                            PersonalizePageView.this.gWC = PersonalizePageView.this.gWB;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gWB.setEnable(true);
                        PersonalizePageView.this.gRz.setProgressView(PersonalizePageView.this.gWB);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gRz.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gWA == null) {
                        PersonalizePageView.this.gWA = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gWC = PersonalizePageView.this.gWA;
                        PersonalizePageView.this.bLQ();
                    } else if (PersonalizePageView.this.gWC != PersonalizePageView.this.gWA || !aVar.equals(PersonalizePageView.this.gWA.bMs())) {
                        PersonalizePageView.this.gWC = PersonalizePageView.this.gWA;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gWA.setEnable(true);
                    PersonalizePageView.this.gRz.setProgressView(PersonalizePageView.this.gWA);
                    PersonalizePageView.this.gWA.a(aVar);
                    PersonalizePageView.this.gRz.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.gWT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.gWN != null) {
                    PersonalizePageView.this.gWN.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gWI = 0L;
        this.mSkinType = 3;
        this.gjL = false;
        this.gWK = false;
        this.gWL = 0;
        this.gjV = 0;
        this.gWM = false;
        this.dxk = 1;
        this.fVb = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.fUZ == null) {
                            PersonalizePageView.this.fUZ = new k(new i());
                        }
                        PersonalizePageView.this.fUZ.a(PersonalizePageView.this.gRr, 2);
                    } else if (PersonalizePageView.this.fUZ != null) {
                        PersonalizePageView.this.fUZ.kl();
                    }
                }
            }
        };
        this.gVz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                if (alVar != null) {
                    TiebaStatic.log(new an("c11693").cp("obj_locate", "1").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new an("c11989").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.gWD != null) {
                        PersonalizePageView.this.gWD.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fid", alVar.getFid()).cp("obj_param1", alVar.weight).cp("obj_source", alVar.source).cp("obj_id", alVar.extra).cp("obj_type", sb.toString()).cp("obj_name", str).Z(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.eiC = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.eiC != i2 && PersonalizePageView.this.gRx != null) {
                    PersonalizePageView.this.eiC = i2;
                    if (PersonalizePageView.this.eiC == 1) {
                        PersonalizePageView.this.gRx.aZW();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.gRx.aZX();
                    } else {
                        PersonalizePageView.this.gRx.aZW();
                    }
                }
            }
        };
        this.gRy = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bLd() {
                if (PersonalizePageView.this.gRx != null) {
                    PersonalizePageView.this.eiC = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.gRr)) {
                        PersonalizePageView.this.gRx.aZX();
                    } else {
                        PersonalizePageView.this.gRx.aZW();
                    }
                }
            }
        };
        this.gWO = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            private boolean gca = com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("key_first_install", true);

            private void bLT() {
                if (this.gca) {
                    this.gca = false;
                    com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void M(int i2, int i22, int i3) {
                if (PersonalizePageView.this.gWE == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bwF = PersonalizePageView.this.bwF();
                PersonalizePageView.this.aZK();
                if (bwF) {
                    PersonalizePageView.this.eA(true);
                }
                PersonalizePageView.this.gWE.L(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void z(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.gWE != null) {
                    PersonalizePageView.this.gWE.y(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    bLT();
                } else if (!this.gca) {
                    PersonalizePageView.this.gRz.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    bLT();
                    PersonalizePageView.this.bKS();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                bLT();
                PersonalizePageView.this.gRz.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.aZK();
                o a2 = PersonalizePageView.this.a(PersonalizePageView.this.gWF.bMg());
                PersonalizePageView.this.eN(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.glc != null) {
                    PersonalizePageView.this.glc.a(a2);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void bLU() {
                if (PersonalizePageView.this.egU != null) {
                    PersonalizePageView.this.egU.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.egU.endLoadData();
                    PersonalizePageView.this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.gWP = new g.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.aUV().wp("page_recommend");
                PersonalizePageView.this.gWF.update();
                PersonalizePageView.this.gWF.mq(false);
                PersonalizePageView.this.gWM = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.gWb = new g.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.gWF != null && PersonalizePageView.this.gWF.bCd() != null) {
                    PersonalizePageView.this.gWF.bCd().bLD();
                }
            }
        };
        this.gWQ = new g.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tbadk.core.view.g.a
            public void aFn() {
                if (PersonalizePageView.this.gWM) {
                    PersonalizePageView.this.gjV = 0;
                    PersonalizePageView.this.dxk = 1;
                    PersonalizePageView.this.gWM = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.gWc = new g.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.gWF != null) {
                    PersonalizePageView.this.gWF.mq(true);
                    PersonalizePageView.this.gWF.bLZ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aCY().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.axn().jb(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.gWR = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aCY().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.djU = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
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
                        com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.bKu();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.gRB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.aZs();
            }
        };
        this.gkv = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.gjL = true;
                    }
                }
            }
        };
        this.gWS = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.gRz != null && !PersonalizePageView.this.gRz.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.gWB == null) {
                            PersonalizePageView.this.gWB = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.gWB.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.gWC = PersonalizePageView.this.gWB;
                            PersonalizePageView.this.bLQ();
                        } else if (PersonalizePageView.this.gWC != PersonalizePageView.this.gWB) {
                            PersonalizePageView.this.gWC = PersonalizePageView.this.gWB;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.gWB.setEnable(true);
                        PersonalizePageView.this.gRz.setProgressView(PersonalizePageView.this.gWB);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.gRz.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.gWA == null) {
                        PersonalizePageView.this.gWA = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.gWC = PersonalizePageView.this.gWA;
                        PersonalizePageView.this.bLQ();
                    } else if (PersonalizePageView.this.gWC != PersonalizePageView.this.gWA || !aVar.equals(PersonalizePageView.this.gWA.bMs())) {
                        PersonalizePageView.this.gWC = PersonalizePageView.this.gWA;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.gWA.setEnable(true);
                    PersonalizePageView.this.gRz.setProgressView(PersonalizePageView.this.gWA);
                    PersonalizePageView.this.gWA.a(aVar);
                    PersonalizePageView.this.gRz.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.gWT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.gWN != null) {
                    PersonalizePageView.this.gWN.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gRr = new BdTypeRecyclerView(context);
        this.ctr = new LinearLayoutManager(this.gRr.getContext());
        this.gRr.setLayoutManager(this.ctr);
        this.gRr.setFadingEdgeLength(0);
        this.gRr.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fUZ = new k(new i());
            this.fUZ.a(this.gRr, 2);
        }
        MessageManager.getInstance().registerListener(this.fVb);
        this.gRz = new BigdaySwipeRefreshLayout(context);
        this.gRz.addView(this.gRr);
        this.egU = new PbListView(context);
        this.egU.getView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setLineGone();
        this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
        this.egU.setTextSize(R.dimen.tbfontsize33);
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.egU.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.egU.setOnClickListener(this.gRB);
        this.egU.aEZ();
        this.gRr.setNextPage(this.egU);
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        MessageManager.getInstance().registerListener(this.gWS);
        com.baidu.tbadk.core.bigday.b.axn().fh(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aCY().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.axn().jb(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.gRz);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.gWN = new FRSRefreshButton(context);
            int dimens = l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds180);
            addView(this.gWN, layoutParams);
            this.gWN.setOnClickListener(this.gWT);
            this.gWN.setVisibility(8);
        }
        this.gWH = new com.baidu.tieba.homepage.personalize.model.e();
        this.gWD = new ab(context, this.gRr);
        this.gWD.b(this.gWH);
        this.gWF = new e(this.pageContext, this.gRr, this.gWD, this.gRz);
        this.gWG = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.gkv);
        this.gWL = com.baidu.tbadk.core.sharedPref.b.aCY().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(Context context) {
        if (this.gWJ == null) {
            this.gWJ = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds200);
            addView(this.gWJ, layoutParams);
            this.gWJ.setVisibility(8);
            this.gWJ.setPageId(this.pageContext.getUniqueId());
            this.glc = new com.baidu.tieba.c.c(this.pageContext, this.gWJ, 1);
        }
    }

    public void bLQ() {
        if (this.gWC != null) {
            this.gWC.setListPullRefreshListener(this.gWP);
            this.gWC.a(this.gWb);
            this.gWC.a(this.gWQ);
            this.gWC.a(this.gWc);
        }
    }

    public void initListeners() {
        this.gWD.b(this.gVz);
        this.gWF.a(this.gWO);
        this.gWG.a(this);
        bLQ();
        this.gRr.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.gjV += i2;
                if (PersonalizePageView.this.gWN != null) {
                    m item = PersonalizePageView.this.gRr.getItem(PersonalizePageView.this.ctr.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.k) {
                        if (((com.baidu.tieba.card.data.k) item).position >= 6) {
                            PersonalizePageView.this.gWN.show();
                        } else {
                            PersonalizePageView.this.gWN.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.ctr != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.gjV < height * 3 || PersonalizePageView.this.dxk != 1) {
                        if (PersonalizePageView.this.gjV < height * 3 && PersonalizePageView.this.dxk == 2) {
                            PersonalizePageView.this.dxk = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.dxk = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.dxk)));
                    }
                    if (PersonalizePageView.this.ctr.getItemCount() - PersonalizePageView.this.ctr.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.aZs();
                    }
                }
            }
        });
        this.gRr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.aZs();
            }
        });
        this.gRr.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.gWI >= 5000) {
                    PersonalizePageView.this.gWF.bU(i, i2);
                }
            }
        }, 1L);
        this.gRr.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.gWF != null && PersonalizePageView.this.gWF.bCd() != null) {
                        PersonalizePageView.this.gWF.bCd().cg(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.d) {
                        ((com.baidu.tieba.homepage.personalize.a.d) view.getTag()).btc().stopPlay();
                    }
                }
            }
        });
        this.gRr.removeOnScrollListener(this.mOnScrollListener);
        this.gRr.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.gWE = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.egU != null) {
            this.egU.setText(getContext().getString(R.string.pb_load_more));
            this.egU.endLoadData();
            this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.gWF.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.gWF != null) {
            this.gWF.mu(!z);
        }
        this.gWK = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.gWK;
    }

    public void e(Long l) {
        this.gWF.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.gWF != null) {
            this.gWF.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void showFloatingView() {
        if (this.gWF != null) {
            this.gWF.showFloatingView();
        }
    }

    public void bLR() {
        if (this.gWF != null) {
            this.gWF.bLR();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eoy != null) {
                this.eoy.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.setBackgroundColor(this.gRz, R.color.cp_bg_line_e);
            if (this.gWB != null) {
                this.gWB.changeSkin(i);
            }
            if (this.egU != null) {
                this.egU.setTextColor(am.getColor(R.color.cp_cont_d));
                this.egU.changeSkin(i);
            }
            this.gWD.onChangeSkinType(i);
            if (this.gWF != null) {
                this.gWF.onChangeSkinType(i);
            }
            if (this.gWN != null) {
                this.gWN.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aF(String str, int i) {
        if (this.egU != null) {
            this.egU.setText(getContext().getString(R.string.pb_load_more));
            this.egU.endLoadData();
            this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.gWF.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.gWF != null) {
                        PersonalizePageView.this.gWF.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.eoy != null) {
            this.eoy.dettachView(this);
            this.eoy = null;
            this.gRr.setNextPage(this.egU);
            this.egU.setText(getContext().getString(R.string.pb_load_more));
            this.egU.endLoadData();
            this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.gRz != null) {
            this.gRz.setVisibility(0);
        }
        if (this.gWE != null) {
            this.gWE.bKJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bwF() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA(boolean z) {
        if (this.eoy == null) {
            this.eoy = new com.baidu.tbadk.k.g(getContext());
            this.eoy.mm(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
            this.eoy.aNc();
            this.eoy.setWrapStyle(true);
            this.eoy.onChangeSkinType();
        }
        this.eoy.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.gRr.setNextPage(null);
        if (this.gRz != null) {
            this.gRz.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.gWF != null) {
            this.gWF.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.glc != null) {
            this.glc.aXR();
        }
        setViewForeground(false);
        if (this.gWF != null) {
            this.gWF.lf(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.gWL < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.gy().postDelayed(this.gWR, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gWF != null) {
            this.gWF.mk(z);
        }
        if (this.gRx != null) {
            this.gRx.b(this.gRy);
            this.gRx.a(this.gRy);
            this.gRy.bLd();
        }
    }

    public void bKS() {
        if (this.gWF != null) {
            eA(true);
            this.gWF.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.axn().axp();
            com.baidu.tbadk.core.bigday.b.axn().axo();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.gWF != null) {
            this.gWF.update();
        } else if (this.gRr != null && this.gRz != null) {
            showFloatingView();
            this.gRr.setSelection(0);
            if (!this.gRz.isRefreshing()) {
                if (this.gWF != null && this.gWF.bCd() != null) {
                    this.gWF.bCd().bLD();
                    this.gWF.mq(false);
                }
                this.gRz.setRefreshing(true);
            }
            if (this.gRy != null) {
                this.gRy.bLd();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fVb);
        MessageManager.getInstance().unRegisterListener(this.gkv);
        MessageManager.getInstance().unRegisterListener(this.gWS);
        this.gWF.onDestroy();
        this.gWD.b((NEGFeedBackView.a) null);
        this.gWD.onDestroy();
        this.gWF.a((e.a) null);
        if (this.gWA != null) {
            this.gWA.setListPullRefreshListener(null);
            this.gWA.a((g.d) null);
            this.gWA.a((g.a) null);
            this.gWA.a((g.b) null);
            this.gWA.release();
        }
        if (this.gWB != null) {
            this.gWB.setListPullRefreshListener(null);
            this.gWB.a((g.d) null);
            this.gWB.a((g.a) null);
            this.gWB.a((g.b) null);
            this.gWB.release();
        }
        this.gRr.setOnSrollToBottomListener(null);
        if (this.gRx != null) {
            this.gRx.b(this.gRy);
        }
        this.gRr.removeOnScrollListener(this.mOnScrollListener);
        if (this.eoy != null) {
            this.eoy.release();
        }
        this.gRr.setRecyclerListener(null);
        if (this.gWG != null) {
            this.gWG.onDestroy();
        }
        if (this.glc != null) {
            this.glc.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.axn().destroy();
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.gWR);
    }

    public void onPause() {
        this.gWF.onPause();
        if (this.gWD != null) {
            this.gWD.onPause();
        }
    }

    public void onResume() {
        if (this.gjL) {
            reload();
            this.gjL = false;
        }
        if (this.gRz != null) {
            this.gRz.resume();
        }
        if (this.gWD != null) {
            this.gWD.onResume();
        }
    }

    public void bKu() {
        if (this.gWD != null) {
            this.gWD.notifyDataSetChanged();
        }
    }

    public void bKv() {
        if (this.gWF != null) {
            this.gWF.lf(true);
        }
        r.bsy().hK(false);
        com.baidu.tieba.a.d.aUV().cm("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.gWR);
    }

    public void bLN() {
        this.gWF.bMf();
    }

    public void bLS() {
        this.gWF.bLS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZs() {
        com.baidu.tieba.homepage.framework.a.bKI().q(System.currentTimeMillis(), 1);
        if (this.egU != null && !this.egU.isLoading()) {
            this.egU.startLoadData();
            this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.gWF.aZs();
    }
}
