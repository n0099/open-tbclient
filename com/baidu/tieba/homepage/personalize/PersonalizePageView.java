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
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.k;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.ab;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.e;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.view.FloatingAnimationView;
import com.baidu.tieba.view.FollowUserButton;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes9.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager dhU;
    private final CustomMessageListener edg;
    private int epY;
    private PbListView fcj;
    private int feB;
    private g flb;
    private m gYq;
    private CustomMessageListener gYs;
    private FollowUserButton.a hWZ;
    private BdTypeRecyclerView hXB;
    private ScrollFragmentTabHost hXH;
    ScrollFragmentTabHost.a hXI;
    private BigdaySwipeRefreshLayout hXJ;
    private View.OnClickListener hXL;
    private CustomMessageListener hoR;
    private boolean hoe;
    private int hoo;
    private com.baidu.tieba.c.c hpD;
    private NEGFeedBackView.a ibD;
    private com.baidu.tieba.homepage.personalize.bigday.b icD;
    private com.baidu.tieba.homepage.personalize.bigday.a icE;
    private a icF;
    private ab icG;
    private com.baidu.tieba.homepage.framework.b icH;
    private e icI;
    private com.baidu.tieba.homepage.personalize.a icJ;
    private com.baidu.tieba.homepage.personalize.model.e icK;
    private long icL;
    private FloatingAnimationView icM;
    private int icN;
    private boolean icO;
    private boolean icP;
    private boolean icQ;
    private int icR;
    private boolean icS;
    private FRSRefreshButton icT;
    private CustomMessageListener icU;
    private e.a icV;
    f.c icW;
    f.a icX;
    private Runnable icY;
    public CustomMessageListener icZ;
    f.d icf;
    f.b icg;
    private View.OnClickListener ida;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes9.dex */
    public interface a {
        void a(f.a aVar);

        void a(f.b bVar);

        void a(f.d dVar);

        void setListPullRefreshListener(f.c cVar);
    }

    static /* synthetic */ int w(PersonalizePageView personalizePageView) {
        int i = personalizePageView.icR + 1;
        personalizePageView.icR = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hXH = scrollFragmentTabHost;
        if (this.hXH != null) {
            this.hXH.b(this.hXI);
            this.hXH.a(this.hXI);
        }
        if (this.icI != null) {
            this.icI.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.icJ != null) {
            this.icJ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.hXJ != null) {
            this.hXJ.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.icG != null) {
            this.icG.setPageUniqueId(bdUniqueId);
        }
        if (this.icI != null) {
            this.icI.o(bdUniqueId);
        }
        if (this.icK != null) {
            this.icK.i(bdUniqueId);
        }
        if (this.icE != null) {
            this.icE.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.aNY().setTag(bdUniqueId);
        if (this.edg != null) {
            this.edg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.edg);
        }
        if (this.icJ != null) {
            this.icJ.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        p pVar = new p();
        pVar.bS(String.valueOf(floatInfo.activity_id));
        pVar.eC(floatInfo.dynamic_url);
        pVar.setEndTime(floatInfo.end_time.longValue() * 1000);
        pVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        pVar.MD(floatInfo.float_url);
        pVar.er(floatInfo.jump_url);
        pVar.setType(floatInfo.show_type.intValue());
        return pVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.icL = 0L;
        this.mSkinType = 3;
        this.hoe = false;
        this.icN = 0;
        this.icO = true;
        this.icP = false;
        this.icQ = false;
        this.icR = 0;
        this.hoo = 0;
        this.icS = false;
        this.epY = 1;
        this.gYs = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gYq == null) {
                            PersonalizePageView.this.gYq = new m(new k());
                        }
                        PersonalizePageView.this.gYq.a(PersonalizePageView.this.hXB, 2);
                    } else if (PersonalizePageView.this.gYq != null) {
                        PersonalizePageView.this.gYq.pl();
                    }
                }
            }
        };
        this.icU = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.icI != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.aTj().aTk(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.ibD = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ak akVar) {
                if (akVar != null) {
                    TiebaStatic.log(new an("c11693").dh("obj_locate", "1").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("nid", akVar.getNid()));
                    TiebaStatic.log(new an("c11989").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ak akVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
                int i = 0;
                if (arrayList != null && akVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (akVar.threadType == 0) {
                        i = 1;
                    } else if (akVar.threadType == 40) {
                        i = 2;
                    } else if (akVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.icG != null) {
                        PersonalizePageView.this.icG.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").dh("tid", akVar.getTid()).dh("nid", akVar.getNid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fid", akVar.getFid()).dh("obj_param1", akVar.weight).dh("obj_source", akVar.source).dh("obj_id", akVar.extra).dh("obj_type", sb.toString()).dh("obj_name", str).ag(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.hWZ = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bk) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bk) tag));
                    }
                }
            }
        };
        this.feB = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.feB != i && PersonalizePageView.this.hXH != null) {
                    PersonalizePageView.this.feB = i;
                    if (PersonalizePageView.this.feB == 1) {
                        PersonalizePageView.this.hXH.brg();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.hXH.brh();
                    } else {
                        PersonalizePageView.this.hXH.brg();
                    }
                }
            }
        };
        this.hXI = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cfg() {
                if (PersonalizePageView.this.hXH != null) {
                    PersonalizePageView.this.feB = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.hXB)) {
                        PersonalizePageView.this.hXH.brh();
                    } else {
                        PersonalizePageView.this.hXH.brg();
                    }
                }
            }
        };
        this.icV = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hgs = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_first_install", true);

            private void cfY() {
                if (this.hgs) {
                    this.hgs = false;
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.icH == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bPO = PersonalizePageView.this.bPO();
                PersonalizePageView.this.bqQ();
                if (bPO) {
                    PersonalizePageView.this.fV(true);
                }
                PersonalizePageView.this.icH.P(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void A(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.icH != null) {
                    PersonalizePageView.this.icH.z(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cfY();
                } else if (!this.hgs) {
                    PersonalizePageView.this.hXJ.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cfY();
                    PersonalizePageView.this.ceU();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cfY();
                PersonalizePageView.this.hXJ.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bqQ();
                p a2 = PersonalizePageView.this.a(PersonalizePageView.this.icI.cgl());
                PersonalizePageView.this.eL(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.hpD != null) {
                    PersonalizePageView.this.hpD.a(a2);
                }
                if (com.baidu.tbadk.core.util.ab.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.deJ().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cfZ() {
                if (PersonalizePageView.this.fcj != null) {
                    PersonalizePageView.this.fcj.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fcj.endLoadData();
                    PersonalizePageView.this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.icW = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bmb().zK("page_recommend");
                PersonalizePageView.this.icI.update();
                PersonalizePageView.this.icI.oj(false);
                PersonalizePageView.this.icS = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.icf = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.icI != null && PersonalizePageView.this.icI.bVS() != null) {
                    PersonalizePageView.this.icI.bVS().cfI();
                }
            }
        };
        this.icX = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void aWA() {
                if (PersonalizePageView.this.icS) {
                    PersonalizePageView.this.hoo = 0;
                    PersonalizePageView.this.epY = 1;
                    PersonalizePageView.this.icS = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.icg = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.icI != null) {
                    PersonalizePageView.this.icI.oj(true);
                    PersonalizePageView.this.icI.cge();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aNY().kc(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.icY = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.edg = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cez();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.hXL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bqx();
            }
        };
        this.hoR = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hoe = true;
                    }
                }
            }
        };
        this.icZ = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.hXJ != null && !PersonalizePageView.this.hXJ.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.icE == null) {
                            PersonalizePageView.this.icE = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.icE.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.icF = PersonalizePageView.this.icE;
                            PersonalizePageView.this.cfV();
                        } else if (PersonalizePageView.this.icF != PersonalizePageView.this.icE) {
                            PersonalizePageView.this.icF = PersonalizePageView.this.icE;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.icE.setEnable(true);
                        PersonalizePageView.this.hXJ.setProgressView(PersonalizePageView.this.icE);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.hXJ.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.icD == null) {
                        PersonalizePageView.this.icD = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.icF = PersonalizePageView.this.icD;
                        PersonalizePageView.this.cfV();
                    } else if (PersonalizePageView.this.icF != PersonalizePageView.this.icD || !aVar.equals(PersonalizePageView.this.icD.cgx())) {
                        PersonalizePageView.this.icF = PersonalizePageView.this.icD;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.icD.setEnable(true);
                    PersonalizePageView.this.hXJ.setProgressView(PersonalizePageView.this.icD);
                    PersonalizePageView.this.icD.a(aVar);
                    PersonalizePageView.this.hXJ.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.ida = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.icT != null) {
                    PersonalizePageView.this.icT.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.icL = 0L;
        this.mSkinType = 3;
        this.hoe = false;
        this.icN = 0;
        this.icO = true;
        this.icP = false;
        this.icQ = false;
        this.icR = 0;
        this.hoo = 0;
        this.icS = false;
        this.epY = 1;
        this.gYs = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gYq == null) {
                            PersonalizePageView.this.gYq = new m(new k());
                        }
                        PersonalizePageView.this.gYq.a(PersonalizePageView.this.hXB, 2);
                    } else if (PersonalizePageView.this.gYq != null) {
                        PersonalizePageView.this.gYq.pl();
                    }
                }
            }
        };
        this.icU = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.icI != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.aTj().aTk(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.ibD = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ak akVar) {
                if (akVar != null) {
                    TiebaStatic.log(new an("c11693").dh("obj_locate", "1").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("nid", akVar.getNid()));
                    TiebaStatic.log(new an("c11989").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ak akVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
                int i = 0;
                if (arrayList != null && akVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (akVar.threadType == 0) {
                        i = 1;
                    } else if (akVar.threadType == 40) {
                        i = 2;
                    } else if (akVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.icG != null) {
                        PersonalizePageView.this.icG.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").dh("tid", akVar.getTid()).dh("nid", akVar.getNid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fid", akVar.getFid()).dh("obj_param1", akVar.weight).dh("obj_source", akVar.source).dh("obj_id", akVar.extra).dh("obj_type", sb.toString()).dh("obj_name", str).ag(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.hWZ = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bk) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bk) tag));
                    }
                }
            }
        };
        this.feB = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.feB != i && PersonalizePageView.this.hXH != null) {
                    PersonalizePageView.this.feB = i;
                    if (PersonalizePageView.this.feB == 1) {
                        PersonalizePageView.this.hXH.brg();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.hXH.brh();
                    } else {
                        PersonalizePageView.this.hXH.brg();
                    }
                }
            }
        };
        this.hXI = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cfg() {
                if (PersonalizePageView.this.hXH != null) {
                    PersonalizePageView.this.feB = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.hXB)) {
                        PersonalizePageView.this.hXH.brh();
                    } else {
                        PersonalizePageView.this.hXH.brg();
                    }
                }
            }
        };
        this.icV = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hgs = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_first_install", true);

            private void cfY() {
                if (this.hgs) {
                    this.hgs = false;
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i, int i2, int i3) {
                if (PersonalizePageView.this.icH == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bPO = PersonalizePageView.this.bPO();
                PersonalizePageView.this.bqQ();
                if (bPO) {
                    PersonalizePageView.this.fV(true);
                }
                PersonalizePageView.this.icH.P(i, i2, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void A(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.icH != null) {
                    PersonalizePageView.this.icH.z(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cfY();
                } else if (!this.hgs) {
                    PersonalizePageView.this.hXJ.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cfY();
                    PersonalizePageView.this.ceU();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cfY();
                PersonalizePageView.this.hXJ.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bqQ();
                p a2 = PersonalizePageView.this.a(PersonalizePageView.this.icI.cgl());
                PersonalizePageView.this.eL(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.hpD != null) {
                    PersonalizePageView.this.hpD.a(a2);
                }
                if (com.baidu.tbadk.core.util.ab.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.deJ().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cfZ() {
                if (PersonalizePageView.this.fcj != null) {
                    PersonalizePageView.this.fcj.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fcj.endLoadData();
                    PersonalizePageView.this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.icW = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bmb().zK("page_recommend");
                PersonalizePageView.this.icI.update();
                PersonalizePageView.this.icI.oj(false);
                PersonalizePageView.this.icS = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.icf = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.icI != null && PersonalizePageView.this.icI.bVS() != null) {
                    PersonalizePageView.this.icI.bVS().cfI();
                }
            }
        };
        this.icX = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void aWA() {
                if (PersonalizePageView.this.icS) {
                    PersonalizePageView.this.hoo = 0;
                    PersonalizePageView.this.epY = 1;
                    PersonalizePageView.this.icS = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.icg = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.icI != null) {
                    PersonalizePageView.this.icI.oj(true);
                    PersonalizePageView.this.icI.cge();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aNY().kc(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.icY = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.edg = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cez();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.hXL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bqx();
            }
        };
        this.hoR = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hoe = true;
                    }
                }
            }
        };
        this.icZ = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.hXJ != null && !PersonalizePageView.this.hXJ.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.icE == null) {
                            PersonalizePageView.this.icE = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.icE.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.icF = PersonalizePageView.this.icE;
                            PersonalizePageView.this.cfV();
                        } else if (PersonalizePageView.this.icF != PersonalizePageView.this.icE) {
                            PersonalizePageView.this.icF = PersonalizePageView.this.icE;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.icE.setEnable(true);
                        PersonalizePageView.this.hXJ.setProgressView(PersonalizePageView.this.icE);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.hXJ.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.icD == null) {
                        PersonalizePageView.this.icD = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.icF = PersonalizePageView.this.icD;
                        PersonalizePageView.this.cfV();
                    } else if (PersonalizePageView.this.icF != PersonalizePageView.this.icD || !aVar.equals(PersonalizePageView.this.icD.cgx())) {
                        PersonalizePageView.this.icF = PersonalizePageView.this.icD;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.icD.setEnable(true);
                    PersonalizePageView.this.hXJ.setProgressView(PersonalizePageView.this.icD);
                    PersonalizePageView.this.icD.a(aVar);
                    PersonalizePageView.this.hXJ.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.ida = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.icT != null) {
                    PersonalizePageView.this.icT.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.icL = 0L;
        this.mSkinType = 3;
        this.hoe = false;
        this.icN = 0;
        this.icO = true;
        this.icP = false;
        this.icQ = false;
        this.icR = 0;
        this.hoo = 0;
        this.icS = false;
        this.epY = 1;
        this.gYs = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.gYq == null) {
                            PersonalizePageView.this.gYq = new m(new k());
                        }
                        PersonalizePageView.this.gYq.a(PersonalizePageView.this.hXB, 2);
                    } else if (PersonalizePageView.this.gYq != null) {
                        PersonalizePageView.this.gYq.pl();
                    }
                }
            }
        };
        this.icU = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.icI != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.aTj().aTk(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.ibD = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ak akVar) {
                if (akVar != null) {
                    TiebaStatic.log(new an("c11693").dh("obj_locate", "1").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("nid", akVar.getNid()));
                    TiebaStatic.log(new an("c11989").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ak akVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
                int i2 = 0;
                if (arrayList != null && akVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        sb.append(arrayList.get(i22)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (akVar.threadType == 0) {
                        i2 = 1;
                    } else if (akVar.threadType == 40) {
                        i2 = 2;
                    } else if (akVar.threadType == 49) {
                        i2 = 3;
                    }
                    if (PersonalizePageView.this.icG != null) {
                        PersonalizePageView.this.icG.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new an("c11693").dh("tid", akVar.getTid()).dh("nid", akVar.getNid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fid", akVar.getFid()).dh("obj_param1", akVar.weight).dh("obj_source", akVar.source).dh("obj_id", akVar.extra).dh("obj_type", sb.toString()).dh("obj_name", str).ag(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.hWZ = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bk) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bk) tag));
                    }
                }
            }
        };
        this.feB = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.feB != i2 && PersonalizePageView.this.hXH != null) {
                    PersonalizePageView.this.feB = i2;
                    if (PersonalizePageView.this.feB == 1) {
                        PersonalizePageView.this.hXH.brg();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.hXH.brh();
                    } else {
                        PersonalizePageView.this.hXH.brg();
                    }
                }
            }
        };
        this.hXI = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cfg() {
                if (PersonalizePageView.this.hXH != null) {
                    PersonalizePageView.this.feB = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.hXB)) {
                        PersonalizePageView.this.hXH.brh();
                    } else {
                        PersonalizePageView.this.hXH.brg();
                    }
                }
            }
        };
        this.icV = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hgs = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_first_install", true);

            private void cfY() {
                if (this.hgs) {
                    this.hgs = false;
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void Q(int i2, int i22, int i3) {
                if (PersonalizePageView.this.icH == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean bPO = PersonalizePageView.this.bPO();
                PersonalizePageView.this.bqQ();
                if (bPO) {
                    PersonalizePageView.this.fV(true);
                }
                PersonalizePageView.this.icH.P(i2, i22, i3);
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void A(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.icH != null) {
                    PersonalizePageView.this.icH.z(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cfY();
                } else if (!this.hgs) {
                    PersonalizePageView.this.hXJ.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cfY();
                    PersonalizePageView.this.ceU();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cfY();
                PersonalizePageView.this.hXJ.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bqQ();
                p a2 = PersonalizePageView.this.a(PersonalizePageView.this.icI.cgl());
                PersonalizePageView.this.eL(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.hpD != null) {
                    PersonalizePageView.this.hpD.a(a2);
                }
                if (com.baidu.tbadk.core.util.ab.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.deJ().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cfZ() {
                if (PersonalizePageView.this.fcj != null) {
                    PersonalizePageView.this.fcj.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fcj.endLoadData();
                    PersonalizePageView.this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.icW = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bmb().zK("page_recommend");
                PersonalizePageView.this.icI.update();
                PersonalizePageView.this.icI.oj(false);
                PersonalizePageView.this.icS = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.icf = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.icI != null && PersonalizePageView.this.icI.bVS() != null) {
                    PersonalizePageView.this.icI.bVS().cfI();
                }
            }
        };
        this.icX = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void aWA() {
                if (PersonalizePageView.this.icS) {
                    PersonalizePageView.this.hoo = 0;
                    PersonalizePageView.this.epY = 1;
                    PersonalizePageView.this.icS = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.icg = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.icI != null) {
                    PersonalizePageView.this.icI.oj(true);
                    PersonalizePageView.this.icI.cge();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.aNY().kc(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.icY = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.w(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.edg = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cez();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.hXL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bqx();
            }
        };
        this.hoR = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hoe = true;
                    }
                }
            }
        };
        this.icZ = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.hXJ != null && !PersonalizePageView.this.hXJ.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.icE == null) {
                            PersonalizePageView.this.icE = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.icE.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.icF = PersonalizePageView.this.icE;
                            PersonalizePageView.this.cfV();
                        } else if (PersonalizePageView.this.icF != PersonalizePageView.this.icE) {
                            PersonalizePageView.this.icF = PersonalizePageView.this.icE;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.icE.setEnable(true);
                        PersonalizePageView.this.hXJ.setProgressView(PersonalizePageView.this.icE);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.hXJ.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.icD == null) {
                        PersonalizePageView.this.icD = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.icF = PersonalizePageView.this.icD;
                        PersonalizePageView.this.cfV();
                    } else if (PersonalizePageView.this.icF != PersonalizePageView.this.icD || !aVar.equals(PersonalizePageView.this.icD.cgx())) {
                        PersonalizePageView.this.icF = PersonalizePageView.this.icD;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.icD.setEnable(true);
                    PersonalizePageView.this.hXJ.setProgressView(PersonalizePageView.this.icD);
                    PersonalizePageView.this.icD.a(aVar);
                    PersonalizePageView.this.hXJ.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.ida = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.icT != null) {
                    PersonalizePageView.this.icT.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hXB = new BdTypeRecyclerView(context);
        this.dhU = new LinearLayoutManager(this.hXB.getContext());
        this.hXB.setLayoutManager(this.dhU);
        this.hXB.setFadingEdgeLength(0);
        this.hXB.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gYq = new m(new k());
            this.gYq.a(this.hXB, 2);
        }
        MessageManager.getInstance().registerListener(this.gYs);
        MessageManager.getInstance().registerListener(this.icU);
        this.hXJ = new BigdaySwipeRefreshLayout(context);
        this.hXJ.addView(this.hXB);
        this.fcj = new PbListView(context);
        this.fcj.getView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setLineGone();
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fcj.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.fcj.setOnClickListener(this.hXL);
        this.fcj.aWf();
        this.hXB.setNextPage(this.fcj);
        com.baidu.adp.base.e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        MessageManager.getInstance().registerListener(this.icZ);
        com.baidu.tbadk.core.bigday.b.aNY().gJ(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.aNY().kc(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.hXJ);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.icT = new FRSRefreshButton(context);
            int dimens = l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds180);
            addView(this.icT, layoutParams);
            this.icT.setOnClickListener(this.ida);
            this.icT.setVisibility(8);
        }
        this.icK = new com.baidu.tieba.homepage.personalize.model.e();
        this.icG = new ab(context, this.hXB);
        this.icG.b(this.icK);
        this.icI = new e(this.pageContext, this.hXB, this.icG, this.hXJ);
        this.icJ = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.hoR);
        this.icR = com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(Context context) {
        if (this.icM == null) {
            this.icM = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.getDimens(context, R.dimen.tbds200), l.getDimens(context, R.dimen.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = l.getDimens(context, R.dimen.tbds200);
            addView(this.icM, layoutParams);
            this.icM.setVisibility(8);
            this.icM.setPageId(this.pageContext.getUniqueId());
            this.hpD = new com.baidu.tieba.c.c(this.pageContext, this.icM, 1);
        }
    }

    public void cfV() {
        if (this.icF != null) {
            this.icF.setListPullRefreshListener(this.icW);
            this.icF.a(this.icf);
            this.icF.a(this.icX);
            this.icF.a(this.icg);
        }
    }

    public void bwC() {
        this.icG.b(this.ibD);
        this.icG.a(this.hWZ);
        this.icI.a(this.icV);
        this.icJ.a(this);
        cfV();
        this.hXB.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.hoo += i2;
                if (PersonalizePageView.this.icT != null) {
                    o item = PersonalizePageView.this.hXB.getItem(PersonalizePageView.this.dhU.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.k) {
                        if (((com.baidu.tieba.card.data.k) item).position >= 6) {
                            PersonalizePageView.this.icT.show();
                        } else {
                            PersonalizePageView.this.icT.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dhU != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.hoo < height * 3 || PersonalizePageView.this.epY != 1) {
                        if (PersonalizePageView.this.hoo < height * 3 && PersonalizePageView.this.epY == 2) {
                            PersonalizePageView.this.epY = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.epY = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.epY)));
                    }
                    if (PersonalizePageView.this.dhU.getItemCount() - PersonalizePageView.this.dhU.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bqx();
                    }
                }
            }
        });
        this.hXB.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bqx();
            }
        });
        this.hXB.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.icL >= 5000) {
                    PersonalizePageView.this.icI.cg(i, i2);
                }
            }
        }, 1L);
        this.hXB.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.icI != null && PersonalizePageView.this.icI.bVS() != null) {
                        PersonalizePageView.this.icI.bVS().ct(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                        ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bLW().stopPlay();
                    }
                }
            }
        });
        this.hXB.removeOnScrollListener(this.mOnScrollListener);
        this.hXB.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.icH = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.fcj != null) {
            this.fcj.setText(getContext().getString(R.string.pb_load_more));
            this.fcj.endLoadData();
            this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.icI.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.icI != null) {
            this.icI.on(!z);
        }
        this.icQ = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.icQ;
    }

    public void e(Long l) {
        this.icI.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.icI != null) {
            this.icI.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void showFloatingView() {
        if (this.icI != null) {
            this.icI.showFloatingView();
        }
    }

    public void cfW() {
        if (this.icI != null) {
            this.icI.cfW();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.flb != null) {
                this.flb.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.icE != null) {
                this.icE.changeSkin(i);
            }
            if (this.fcj != null) {
                this.fcj.setTextColor(am.getColor(R.color.cp_cont_d));
                this.fcj.changeSkin(i);
            }
            this.icG.onChangeSkinType(i);
            if (this.icI != null) {
                this.icI.onChangeSkinType(i);
            }
            if (this.icT != null) {
                this.icT.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aP(String str, int i) {
        if (this.fcj != null) {
            this.fcj.setText(getContext().getString(R.string.pb_load_more));
            this.fcj.endLoadData();
            this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.icI.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.icI != null) {
                        PersonalizePageView.this.icI.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqQ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this);
            this.flb = null;
            this.hXB.setNextPage(this.fcj);
            this.fcj.setText(getContext().getString(R.string.pb_load_more));
            this.fcj.endLoadData();
            this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.hXJ != null) {
            this.hXJ.setVisibility(0);
        }
        if (this.icH != null) {
            this.icH.ceL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPO() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fV(boolean z) {
        if (this.flb == null) {
            this.flb = new g(getContext());
            this.flb.ba(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
            this.flb.bex();
            this.flb.setWrapStyle(true);
            this.flb.onChangeSkinType();
        }
        this.flb.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.hXB.setNextPage(null);
        if (this.hXJ != null) {
            this.hXJ.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.icI != null) {
            this.icI.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.hpD != null) {
            this.hpD.aJZ();
        }
        setViewForeground(false);
        if (this.icI != null) {
            this.icI.mX(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.icR < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.ld().postDelayed(this.icY, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.icI != null) {
            this.icI.oc(z);
        }
        if (this.hXH != null) {
            this.hXH.b(this.hXI);
            this.hXH.a(this.hXI);
            this.hXI.cfg();
        }
    }

    public void ceU() {
        if (this.icI != null) {
            fV(true);
            this.icI.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.aNY().aOa();
            com.baidu.tbadk.core.bigday.b.aNY().aNZ();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.icI != null) {
            this.icI.update();
        } else if (this.hXB != null && this.hXJ != null) {
            showFloatingView();
            this.hXB.setSelection(0);
            if (!this.hXJ.isRefreshing()) {
                if (this.icI != null && this.icI.bVS() != null) {
                    this.icI.bVS().cfI();
                    this.icI.oj(false);
                }
                this.hXJ.setRefreshing(true);
            }
            if (this.hXI != null) {
                this.hXI.cfg();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gYs);
        MessageManager.getInstance().unRegisterListener(this.hoR);
        MessageManager.getInstance().unRegisterListener(this.icZ);
        this.icI.onDestroy();
        this.icG.b((NEGFeedBackView.a) null);
        this.icG.onDestroy();
        this.icI.a((e.a) null);
        if (this.icD != null) {
            this.icD.setListPullRefreshListener(null);
            this.icD.a((f.d) null);
            this.icD.a((f.a) null);
            this.icD.a((f.b) null);
            this.icD.release();
        }
        if (this.icE != null) {
            this.icE.setListPullRefreshListener(null);
            this.icE.a((f.d) null);
            this.icE.a((f.a) null);
            this.icE.a((f.b) null);
            this.icE.release();
        }
        this.hXB.setOnSrollToBottomListener(null);
        if (this.hXH != null) {
            this.hXH.b(this.hXI);
        }
        this.hXB.removeOnScrollListener(this.mOnScrollListener);
        if (this.flb != null) {
            this.flb.release();
        }
        this.hXB.setRecyclerListener(null);
        if (this.icJ != null) {
            this.icJ.onDestroy();
        }
        if (this.hpD != null) {
            this.hpD.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.aNY().destroy();
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.icY);
    }

    public void onPause() {
        this.icI.onPause();
        if (this.icG != null) {
            this.icG.onPause();
        }
    }

    public void onResume() {
        if (this.hoe) {
            reload();
            this.hoe = false;
        }
        if (this.hXJ != null) {
            this.hXJ.resume();
        }
        if (this.icG != null) {
            this.icG.onResume();
        }
    }

    public void cez() {
        if (this.icG != null) {
            this.icG.notifyDataSetChanged();
        }
    }

    public void ceA() {
        if (this.icI != null) {
            this.icI.mX(true);
        }
        s.bLs().jv(false);
        com.baidu.tieba.a.d.bmb().de("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.icY);
    }

    public void cfS() {
        this.icI.cgk();
    }

    public void cfX() {
        this.icI.cfX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqx() {
        com.baidu.tieba.homepage.framework.a.ceK().q(System.currentTimeMillis(), 1);
        if (this.fcj != null && !this.fcj.isLoading()) {
            this.fcj.startLoadData();
            this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.icI.bqx();
    }
}
