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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.BdToken.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.ag;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.e;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.view.FollowUserButton;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes22.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager eeV;
    private final CustomMessageListener feV;
    private int fte;
    private PbListView gjo;
    private int glP;
    private com.baidu.tbadk.k.g gso;
    private boolean iId;
    private int iIn;
    private CustomMessageListener iJc;
    private n isk;
    private CustomMessageListener ism;
    private NEGFeedBackView.a jAz;
    f.d jBb;
    f.b jBc;
    private com.baidu.tieba.homepage.personalize.bigday.b jCI;
    private com.baidu.tieba.homepage.personalize.bigday.a jCJ;
    private a jCK;
    private ag jCL;
    private com.baidu.tieba.homepage.framework.b jCM;
    private e jCN;
    private com.baidu.tieba.homepage.personalize.a jCO;
    private com.baidu.tieba.homepage.personalize.model.e jCP;
    private long jCQ;
    private int jCR;
    private boolean jCS;
    private boolean jCT;
    private boolean jCU;
    private int jCV;
    private boolean jCW;
    private FRSRefreshButton jCX;
    private CustomMessageListener jCY;
    private e.a jCZ;
    f.c jDa;
    f.a jDb;
    private Runnable jDc;
    public CustomMessageListener jDd;
    private View.OnClickListener jDe;
    private FollowUserButton.a juz;
    private ScrollFragmentTabHost jvA;
    ScrollFragmentTabHost.a jvB;
    private BigdaySwipeRefreshLayout jvC;
    private View.OnClickListener jvE;
    private BdTypeRecyclerView jvu;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes22.dex */
    public interface a {
        void a(f.a aVar);

        void a(f.b bVar);

        void a(f.d dVar);

        void setListPullRefreshListener(f.c cVar);
    }

    static /* synthetic */ int v(PersonalizePageView personalizePageView) {
        int i = personalizePageView.jCV + 1;
        personalizePageView.jCV = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jvA = scrollFragmentTabHost;
        if (this.jvA != null) {
            this.jvA.b(this.jvB);
            this.jvA.a(this.jvB);
        }
        if (this.jCN != null) {
            this.jCN.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jCO != null) {
            this.jCO.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.jvC != null) {
            this.jvC.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jCL != null) {
            this.jCL.setPageUniqueId(bdUniqueId);
        }
        if (this.jCN != null) {
            this.jCN.o(bdUniqueId);
        }
        if (this.jCP != null) {
            this.jCP.i(bdUniqueId);
        }
        if (this.jCJ != null) {
            this.jCJ.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.bjP().setTag(bdUniqueId);
        if (this.feV != null) {
            this.feV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.feV);
        }
        if (this.jCO != null) {
            this.jCO.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.jCQ = 0L;
        this.mSkinType = 3;
        this.iId = false;
        this.jCR = 0;
        this.jCS = true;
        this.jCT = false;
        this.jCU = false;
        this.jCV = 0;
        this.iIn = 0;
        this.jCW = false;
        this.fte = 1;
        this.ism = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.isk == null) {
                            PersonalizePageView.this.isk = new n(new l());
                        }
                        PersonalizePageView.this.isk.a(PersonalizePageView.this.jvu, 2);
                    } else if (PersonalizePageView.this.isk != null) {
                        PersonalizePageView.this.isk.rh();
                    }
                }
            }
        };
        this.jCY = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jCN != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bpu().bpv(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jAz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dR("obj_locate", "1").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, ar arVar) {
                int i = 0;
                if (arrayList != null && arVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (arVar.threadType == 0) {
                        i = 1;
                    } else if (arVar.threadType == 40) {
                        i = 2;
                    } else if (arVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.jCL != null) {
                        PersonalizePageView.this.jCL.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dR("tid", arVar.getTid()).dR("nid", arVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", arVar.getFid()).dR("obj_param1", arVar.weight).dR("obj_source", arVar.source).dR("obj_id", arVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).al(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.juz = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bw) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bw) tag));
                    }
                }
            }
        };
        this.glP = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.glP != i && PersonalizePageView.this.jvA != null) {
                    PersonalizePageView.this.glP = i;
                    if (PersonalizePageView.this.glP == 1) {
                        PersonalizePageView.this.jvA.bPq();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jvA.bPr();
                    } else {
                        PersonalizePageView.this.jvA.bPq();
                    }
                }
            }
        };
        this.jvB = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cJL() {
                if (PersonalizePageView.this.jvA != null) {
                    PersonalizePageView.this.glP = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jvu)) {
                        PersonalizePageView.this.jvA.bPr();
                    } else {
                        PersonalizePageView.this.jvA.bPq();
                    }
                }
            }
        };
        this.jCZ = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean iAe = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_first_install", true);

            private void cKP() {
                if (this.iAe) {
                    this.iAe = false;
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void S(int i, int i2, int i3) {
                if (PersonalizePageView.this.jCM == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cmK = PersonalizePageView.this.cmK();
                PersonalizePageView.this.Wk();
                if (cmK) {
                    PersonalizePageView.this.hJ(true);
                }
                PersonalizePageView.this.jCM.R(i, i2, i3);
                q.bgM().bgN();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void C(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jCM != null) {
                    PersonalizePageView.this.jCM.B(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cKP();
                } else if (!this.iAe) {
                    PersonalizePageView.this.jvC.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cKP();
                    PersonalizePageView.this.cJv();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cKP();
                PersonalizePageView.this.jvC.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Wk();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dKU().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cKQ() {
                if (PersonalizePageView.this.gjo != null) {
                    PersonalizePageView.this.gjo.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gjo.endLoadData();
                    PersonalizePageView.this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jDa = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bIR().EY("page_recommend");
                PersonalizePageView.this.jCN.update();
                PersonalizePageView.this.jCN.qV(false);
                PersonalizePageView.this.jCW = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jBb = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jCN != null && PersonalizePageView.this.jCN.czo() != null) {
                    PersonalizePageView.this.jCN.czo().cKn();
                }
            }
        };
        this.jDb = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bsM() {
                if (PersonalizePageView.this.jCW) {
                    PersonalizePageView.this.iIn = 0;
                    PersonalizePageView.this.fte = 1;
                    PersonalizePageView.this.jCW = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jBc = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jCN != null) {
                    PersonalizePageView.this.jCN.qV(true);
                    PersonalizePageView.this.jCN.cKV();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bqh().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bjP().nQ(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.jDc = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.feV = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cIF();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jvE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bOI();
            }
        };
        this.iJc = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iId = true;
                    }
                }
            }
        };
        this.jDd = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jvC != null && !PersonalizePageView.this.jvC.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jCJ == null) {
                            PersonalizePageView.this.jCJ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jCJ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jCK = PersonalizePageView.this.jCJ;
                            PersonalizePageView.this.cKL();
                        } else if (PersonalizePageView.this.jCK != PersonalizePageView.this.jCJ) {
                            PersonalizePageView.this.jCK = PersonalizePageView.this.jCJ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jCJ.setEnable(true);
                        PersonalizePageView.this.jvC.setProgressView(PersonalizePageView.this.jCJ);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jvC.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jCI == null) {
                        PersonalizePageView.this.jCI = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jCK = PersonalizePageView.this.jCI;
                        PersonalizePageView.this.cKL();
                    } else if (PersonalizePageView.this.jCK != PersonalizePageView.this.jCI || !aVar.equals(PersonalizePageView.this.jCI.cLr())) {
                        PersonalizePageView.this.jCK = PersonalizePageView.this.jCI;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jCI.setEnable(true);
                    PersonalizePageView.this.jvC.setProgressView(PersonalizePageView.this.jCI);
                    PersonalizePageView.this.jCI.a(aVar);
                    PersonalizePageView.this.jvC.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jDe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jCX != null) {
                    PersonalizePageView.this.jCX.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCQ = 0L;
        this.mSkinType = 3;
        this.iId = false;
        this.jCR = 0;
        this.jCS = true;
        this.jCT = false;
        this.jCU = false;
        this.jCV = 0;
        this.iIn = 0;
        this.jCW = false;
        this.fte = 1;
        this.ism = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.isk == null) {
                            PersonalizePageView.this.isk = new n(new l());
                        }
                        PersonalizePageView.this.isk.a(PersonalizePageView.this.jvu, 2);
                    } else if (PersonalizePageView.this.isk != null) {
                        PersonalizePageView.this.isk.rh();
                    }
                }
            }
        };
        this.jCY = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jCN != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bpu().bpv(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jAz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dR("obj_locate", "1").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, ar arVar) {
                int i = 0;
                if (arrayList != null && arVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (arVar.threadType == 0) {
                        i = 1;
                    } else if (arVar.threadType == 40) {
                        i = 2;
                    } else if (arVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.jCL != null) {
                        PersonalizePageView.this.jCL.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dR("tid", arVar.getTid()).dR("nid", arVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", arVar.getFid()).dR("obj_param1", arVar.weight).dR("obj_source", arVar.source).dR("obj_id", arVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).al(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.juz = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bw) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bw) tag));
                    }
                }
            }
        };
        this.glP = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.glP != i && PersonalizePageView.this.jvA != null) {
                    PersonalizePageView.this.glP = i;
                    if (PersonalizePageView.this.glP == 1) {
                        PersonalizePageView.this.jvA.bPq();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jvA.bPr();
                    } else {
                        PersonalizePageView.this.jvA.bPq();
                    }
                }
            }
        };
        this.jvB = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cJL() {
                if (PersonalizePageView.this.jvA != null) {
                    PersonalizePageView.this.glP = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jvu)) {
                        PersonalizePageView.this.jvA.bPr();
                    } else {
                        PersonalizePageView.this.jvA.bPq();
                    }
                }
            }
        };
        this.jCZ = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean iAe = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_first_install", true);

            private void cKP() {
                if (this.iAe) {
                    this.iAe = false;
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void S(int i, int i2, int i3) {
                if (PersonalizePageView.this.jCM == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cmK = PersonalizePageView.this.cmK();
                PersonalizePageView.this.Wk();
                if (cmK) {
                    PersonalizePageView.this.hJ(true);
                }
                PersonalizePageView.this.jCM.R(i, i2, i3);
                q.bgM().bgN();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void C(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jCM != null) {
                    PersonalizePageView.this.jCM.B(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cKP();
                } else if (!this.iAe) {
                    PersonalizePageView.this.jvC.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cKP();
                    PersonalizePageView.this.cJv();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cKP();
                PersonalizePageView.this.jvC.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Wk();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dKU().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cKQ() {
                if (PersonalizePageView.this.gjo != null) {
                    PersonalizePageView.this.gjo.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gjo.endLoadData();
                    PersonalizePageView.this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jDa = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bIR().EY("page_recommend");
                PersonalizePageView.this.jCN.update();
                PersonalizePageView.this.jCN.qV(false);
                PersonalizePageView.this.jCW = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jBb = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jCN != null && PersonalizePageView.this.jCN.czo() != null) {
                    PersonalizePageView.this.jCN.czo().cKn();
                }
            }
        };
        this.jDb = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bsM() {
                if (PersonalizePageView.this.jCW) {
                    PersonalizePageView.this.iIn = 0;
                    PersonalizePageView.this.fte = 1;
                    PersonalizePageView.this.jCW = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jBc = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jCN != null) {
                    PersonalizePageView.this.jCN.qV(true);
                    PersonalizePageView.this.jCN.cKV();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bqh().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bjP().nQ(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.jDc = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.feV = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cIF();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jvE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bOI();
            }
        };
        this.iJc = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iId = true;
                    }
                }
            }
        };
        this.jDd = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jvC != null && !PersonalizePageView.this.jvC.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jCJ == null) {
                            PersonalizePageView.this.jCJ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jCJ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jCK = PersonalizePageView.this.jCJ;
                            PersonalizePageView.this.cKL();
                        } else if (PersonalizePageView.this.jCK != PersonalizePageView.this.jCJ) {
                            PersonalizePageView.this.jCK = PersonalizePageView.this.jCJ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jCJ.setEnable(true);
                        PersonalizePageView.this.jvC.setProgressView(PersonalizePageView.this.jCJ);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jvC.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jCI == null) {
                        PersonalizePageView.this.jCI = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jCK = PersonalizePageView.this.jCI;
                        PersonalizePageView.this.cKL();
                    } else if (PersonalizePageView.this.jCK != PersonalizePageView.this.jCI || !aVar.equals(PersonalizePageView.this.jCI.cLr())) {
                        PersonalizePageView.this.jCK = PersonalizePageView.this.jCI;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jCI.setEnable(true);
                    PersonalizePageView.this.jvC.setProgressView(PersonalizePageView.this.jCI);
                    PersonalizePageView.this.jCI.a(aVar);
                    PersonalizePageView.this.jvC.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jDe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jCX != null) {
                    PersonalizePageView.this.jCX.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCQ = 0L;
        this.mSkinType = 3;
        this.iId = false;
        this.jCR = 0;
        this.jCS = true;
        this.jCT = false;
        this.jCU = false;
        this.jCV = 0;
        this.iIn = 0;
        this.jCW = false;
        this.fte = 1;
        this.ism = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.isk == null) {
                            PersonalizePageView.this.isk = new n(new l());
                        }
                        PersonalizePageView.this.isk.a(PersonalizePageView.this.jvu, 2);
                    } else if (PersonalizePageView.this.isk != null) {
                        PersonalizePageView.this.isk.rh();
                    }
                }
            }
        };
        this.jCY = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jCN != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bpu().bpv(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jAz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dR("obj_locate", "1").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, ar arVar) {
                int i2 = 0;
                if (arrayList != null && arVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        sb.append(arrayList.get(i22)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (arVar.threadType == 0) {
                        i2 = 1;
                    } else if (arVar.threadType == 40) {
                        i2 = 2;
                    } else if (arVar.threadType == 49) {
                        i2 = 3;
                    }
                    if (PersonalizePageView.this.jCL != null) {
                        PersonalizePageView.this.jCL.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dR("tid", arVar.getTid()).dR("nid", arVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", arVar.getFid()).dR("obj_param1", arVar.weight).dR("obj_source", arVar.source).dR("obj_id", arVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).al(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.juz = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bw) {
                        TiebaStatic.log(com.baidu.tieba.s.a.c("c13696", (bw) tag));
                    }
                }
            }
        };
        this.glP = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.glP != i2 && PersonalizePageView.this.jvA != null) {
                    PersonalizePageView.this.glP = i2;
                    if (PersonalizePageView.this.glP == 1) {
                        PersonalizePageView.this.jvA.bPq();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jvA.bPr();
                    } else {
                        PersonalizePageView.this.jvA.bPq();
                    }
                }
            }
        };
        this.jvB = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cJL() {
                if (PersonalizePageView.this.jvA != null) {
                    PersonalizePageView.this.glP = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jvu)) {
                        PersonalizePageView.this.jvA.bPr();
                    } else {
                        PersonalizePageView.this.jvA.bPq();
                    }
                }
            }
        };
        this.jCZ = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean iAe = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_first_install", true);

            private void cKP() {
                if (this.iAe) {
                    this.iAe = false;
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void S(int i2, int i22, int i3) {
                if (PersonalizePageView.this.jCM == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cmK = PersonalizePageView.this.cmK();
                PersonalizePageView.this.Wk();
                if (cmK) {
                    PersonalizePageView.this.hJ(true);
                }
                PersonalizePageView.this.jCM.R(i2, i22, i3);
                q.bgM().bgN();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void C(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.jCM != null) {
                    PersonalizePageView.this.jCM.B(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cKP();
                } else if (!this.iAe) {
                    PersonalizePageView.this.jvC.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cKP();
                    PersonalizePageView.this.cJv();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cKP();
                PersonalizePageView.this.jvC.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.Wk();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dKU().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cKQ() {
                if (PersonalizePageView.this.gjo != null) {
                    PersonalizePageView.this.gjo.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.gjo.endLoadData();
                    PersonalizePageView.this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jDa = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bIR().EY("page_recommend");
                PersonalizePageView.this.jCN.update();
                PersonalizePageView.this.jCN.qV(false);
                PersonalizePageView.this.jCW = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jBb = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jCN != null && PersonalizePageView.this.jCN.czo() != null) {
                    PersonalizePageView.this.jCN.czo().cKn();
                }
            }
        };
        this.jDb = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bsM() {
                if (PersonalizePageView.this.jCW) {
                    PersonalizePageView.this.iIn = 0;
                    PersonalizePageView.this.fte = 1;
                    PersonalizePageView.this.jCW = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jBc = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jCN != null) {
                    PersonalizePageView.this.jCN.qV(true);
                    PersonalizePageView.this.jCN.cKV();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bqh().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bjP().nQ(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.jDc = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.feV = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cIF();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jvE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bOI();
            }
        };
        this.iJc = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iId = true;
                    }
                }
            }
        };
        this.jDd = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jvC != null && !PersonalizePageView.this.jvC.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jCJ == null) {
                            PersonalizePageView.this.jCJ = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jCJ.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jCK = PersonalizePageView.this.jCJ;
                            PersonalizePageView.this.cKL();
                        } else if (PersonalizePageView.this.jCK != PersonalizePageView.this.jCJ) {
                            PersonalizePageView.this.jCK = PersonalizePageView.this.jCJ;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jCJ.setEnable(true);
                        PersonalizePageView.this.jvC.setProgressView(PersonalizePageView.this.jCJ);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jvC.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jCI == null) {
                        PersonalizePageView.this.jCI = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jCK = PersonalizePageView.this.jCI;
                        PersonalizePageView.this.cKL();
                    } else if (PersonalizePageView.this.jCK != PersonalizePageView.this.jCI || !aVar.equals(PersonalizePageView.this.jCI.cLr())) {
                        PersonalizePageView.this.jCK = PersonalizePageView.this.jCI;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jCI.setEnable(true);
                    PersonalizePageView.this.jvC.setProgressView(PersonalizePageView.this.jCI);
                    PersonalizePageView.this.jCI.a(aVar);
                    PersonalizePageView.this.jvC.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jDe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jCX != null) {
                    PersonalizePageView.this.jCX.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jvu = new BdTypeRecyclerView(context);
        this.eeV = new LinearLayoutManager(this.jvu.getContext());
        this.jvu.setLayoutManager(this.eeV);
        this.jvu.setFadingEdgeLength(0);
        this.jvu.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.isk = new n(new l());
            this.isk.a(this.jvu, 2);
        }
        MessageManager.getInstance().registerListener(this.ism);
        MessageManager.getInstance().registerListener(this.jCY);
        this.jvC = new BigdaySwipeRefreshLayout(context);
        this.jvC.addView(this.jvu);
        this.gjo = new PbListView(context);
        this.gjo.getView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setLineGone();
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.gjo.setOnClickListener(this.jvE);
        this.gjo.bst();
        this.jvu.setNextPage(this.gjo);
        com.baidu.adp.base.e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        MessageManager.getInstance().registerListener(this.jDd);
        com.baidu.tbadk.core.bigday.b.bjP().iG(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bqh().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.bjP().nQ(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
        addView(this.jvC);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.jCX = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.jCX, layoutParams);
            this.jCX.setOnClickListener(this.jDe);
            this.jCX.setVisibility(8);
        }
        this.jCP = new com.baidu.tieba.homepage.personalize.model.e();
        this.jCL = new ag(context, this.jvu);
        this.jCL.b(this.jCP);
        this.jCN = new e(this.pageContext, this.jvu, this.jCL, this.jvC);
        this.jCO = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.iJc);
        this.jCV = com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cKL() {
        if (this.jCK != null) {
            this.jCK.setListPullRefreshListener(this.jDa);
            this.jCK.a(this.jBb);
            this.jCK.a(this.jDb);
            this.jCK.a(this.jBc);
        }
    }

    public void bWm() {
        this.jCL.b(this.jAz);
        this.jCL.a(this.juz);
        this.jCN.a(this.jCZ);
        this.jCO.a(this);
        cKL();
        this.jvu.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.iIn += i2;
                if (PersonalizePageView.this.jCX != null) {
                    com.baidu.adp.widget.ListView.q item = PersonalizePageView.this.jvu.getItem(PersonalizePageView.this.eeV.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.l) {
                        if (((com.baidu.tieba.card.data.l) item).position >= 6) {
                            PersonalizePageView.this.jCX.show();
                        } else {
                            PersonalizePageView.this.jCX.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.eeV != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.iIn < height * 3 || PersonalizePageView.this.fte != 1) {
                        if (PersonalizePageView.this.iIn < height * 3 && PersonalizePageView.this.fte == 2) {
                            PersonalizePageView.this.fte = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.fte = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.fte)));
                    }
                    if (PersonalizePageView.this.eeV.getItemCount() - PersonalizePageView.this.eeV.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bOI();
                    }
                }
            }
        });
        this.jvu.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bOI();
            }
        });
        this.jvu.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.jCQ >= 5000) {
                    PersonalizePageView.this.jCN.cE(i, i2);
                }
            }
        }, 1L);
        this.jvu.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.jCN != null && PersonalizePageView.this.jCN.czo() != null) {
                        PersonalizePageView.this.jCN.czo().da(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                        ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).coY().stopPlay();
                    }
                }
            }
        });
        this.jvu.removeOnScrollListener(this.mOnScrollListener);
        this.jvu.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.jCM = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.gjo != null) {
            this.gjo.setText(getContext().getString(R.string.pb_load_more));
            this.gjo.endLoadData();
            this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jCN.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.jCN != null) {
            this.jCN.qZ(!z);
        }
        this.jCU = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.jCU;
    }

    public void g(Long l) {
        this.jCN.g(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (this.jCN != null) {
            this.jCN.setRecommendFrsNavigationAnimDispatcher(abVar);
        }
    }

    public void showFloatingView() {
        if (this.jCN != null) {
            this.jCN.showFloatingView();
        }
    }

    public void cKM() {
        if (this.jCN != null) {
            this.jCN.cKM();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.gso != null) {
                this.gso.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jCJ != null) {
                this.jCJ.changeSkin(i);
            }
            if (this.gjo != null) {
                this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
                this.gjo.changeSkin(i);
            }
            this.jCL.onChangeSkinType(i);
            if (this.jCN != null) {
                this.jCN.onChangeSkinType(i);
            }
            if (this.jCX != null) {
                this.jCX.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aU(String str, int i) {
        if (this.gjo != null) {
            this.gjo.setText(getContext().getString(R.string.pb_load_more));
            this.gjo.endLoadData();
            this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jCN.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.jCN != null) {
                        PersonalizePageView.this.jCN.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wk() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this);
            this.gso = null;
            this.jvu.setNextPage(this.gjo);
            this.gjo.setText(getContext().getString(R.string.pb_load_more));
            this.gjo.endLoadData();
            this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.jvC != null) {
            this.jvC.setVisibility(0);
        }
        if (this.jCM != null) {
            this.jCM.cJi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cmK() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hJ(boolean z) {
        if (this.gso == null) {
            this.gso = new com.baidu.tbadk.k.g(getContext());
            this.gso.br(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.gso.bBg();
            this.gso.setWrapStyle(true);
            this.gso.onChangeSkinType();
        }
        this.gso.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.jvu.setNextPage(null);
        if (this.jvC != null) {
            this.jvC.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.jCN != null) {
            this.jCN.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jCN != null) {
            this.jCN.pF(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.jCV < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jDc, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jCN != null) {
            this.jCN.qM(z);
        }
        if (this.jvA != null) {
            this.jvA.b(this.jvB);
            this.jvA.a(this.jvB);
            this.jvB.cJL();
        }
    }

    public void cJv() {
        if (this.jCN != null) {
            hJ(true);
            this.jCN.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.bjP().bjR();
            com.baidu.tbadk.core.bigday.b.bjP().bjQ();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.jCN != null) {
            this.jCN.update();
        } else if (this.jvu != null && this.jvC != null) {
            showFloatingView();
            this.jvu.setSelection(0);
            if (!this.jvC.isRefreshing()) {
                if (this.jCN != null && this.jCN.czo() != null) {
                    this.jCN.czo().cKn();
                    this.jCN.qV(false);
                }
                this.jvC.setRefreshing(true);
            }
            if (this.jvB != null) {
                this.jvB.cJL();
            }
        }
    }

    public void cKN() {
        if (this.refreshView != null) {
            reload();
        } else if (this.jCN != null) {
            this.jCN.update();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ism);
        MessageManager.getInstance().unRegisterListener(this.iJc);
        MessageManager.getInstance().unRegisterListener(this.jDd);
        this.jCN.onDestroy();
        this.jCL.b((NEGFeedBackView.a) null);
        this.jCL.onDestroy();
        this.jCN.a((e.a) null);
        if (this.jCI != null) {
            this.jCI.setListPullRefreshListener(null);
            this.jCI.a((f.d) null);
            this.jCI.a((f.a) null);
            this.jCI.a((f.b) null);
            this.jCI.release();
        }
        if (this.jCJ != null) {
            this.jCJ.setListPullRefreshListener(null);
            this.jCJ.a((f.d) null);
            this.jCJ.a((f.a) null);
            this.jCJ.a((f.b) null);
            this.jCJ.release();
        }
        this.jvu.setOnSrollToBottomListener(null);
        if (this.jvA != null) {
            this.jvA.b(this.jvB);
        }
        this.jvu.removeOnScrollListener(this.mOnScrollListener);
        if (this.gso != null) {
            this.gso.release();
        }
        this.jvu.setRecyclerListener(null);
        if (this.jCO != null) {
            this.jCO.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.bjP().destroy();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jDc);
    }

    public void onPause() {
        this.jCN.onPause();
        if (this.jCL != null) {
            this.jCL.onPause();
        }
    }

    public void onResume() {
        if (this.iId) {
            reload();
            this.iId = false;
        }
        if (this.jvC != null) {
            this.jvC.resume();
        }
        if (this.jCL != null) {
            this.jCL.onResume();
        }
    }

    public void cIF() {
        if (this.jCL != null) {
            this.jCL.notifyDataSetChanged();
        }
    }

    public void cIG() {
        if (this.jCN != null) {
            this.jCN.pF(true);
        }
        t.cor().lN(false);
        com.baidu.tieba.a.d.bIR().dM("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jDc);
    }

    public void cKH() {
        this.jCN.cLc();
    }

    public void cKO() {
        this.jCN.cKO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOI() {
        com.baidu.tieba.homepage.framework.a.cJh().C(System.currentTimeMillis(), 1);
        if (this.gjo != null && !this.gjo.isLoading()) {
            this.gjo.startLoadData();
            this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jCN.bOI();
    }
}
