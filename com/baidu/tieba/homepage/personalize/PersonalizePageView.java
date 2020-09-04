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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.af;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.e;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.view.FollowUserButton;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes16.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager dCG;
    private final CustomMessageListener eCw;
    private int ePN;
    private PbListView fEa;
    private int fGt;
    private com.baidu.tbadk.k.g fMR;
    private n hDO;
    private CustomMessageListener hDQ;
    private boolean hTJ;
    private int hTT;
    private CustomMessageListener hUI;
    private FollowUserButton.a iFU;
    private ScrollFragmentTabHost iGF;
    ScrollFragmentTabHost.a iGG;
    private BigdaySwipeRefreshLayout iGH;
    private View.OnClickListener iGJ;
    private BdTypeRecyclerView iGz;
    private NEGFeedBackView.a iKB;
    f.d iLd;
    f.b iLe;
    private com.baidu.tieba.homepage.personalize.bigday.b iMK;
    private com.baidu.tieba.homepage.personalize.bigday.a iML;
    private a iMM;
    private af iMN;
    private com.baidu.tieba.homepage.framework.b iMO;
    private e iMP;
    private com.baidu.tieba.homepage.personalize.a iMQ;
    private com.baidu.tieba.homepage.personalize.model.e iMR;
    private long iMS;
    private int iMT;
    private boolean iMU;
    private boolean iMV;
    private boolean iMW;
    private int iMX;
    private boolean iMY;
    private FRSRefreshButton iMZ;
    private CustomMessageListener iNa;
    private e.a iNb;
    f.c iNc;
    f.a iNd;
    private Runnable iNe;
    public CustomMessageListener iNf;
    private View.OnClickListener iNg;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes16.dex */
    public interface a {
        void a(f.a aVar);

        void a(f.b bVar);

        void a(f.d dVar);

        void setListPullRefreshListener(f.c cVar);
    }

    static /* synthetic */ int v(PersonalizePageView personalizePageView) {
        int i = personalizePageView.iMX + 1;
        personalizePageView.iMX = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iGF = scrollFragmentTabHost;
        if (this.iGF != null) {
            this.iGF.b(this.iGG);
            this.iGF.a(this.iGG);
        }
        if (this.iMP != null) {
            this.iMP.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iMQ != null) {
            this.iMQ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.iGH != null) {
            this.iGH.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iMN != null) {
            this.iMN.setPageUniqueId(bdUniqueId);
        }
        if (this.iMP != null) {
            this.iMP.p(bdUniqueId);
        }
        if (this.iMR != null) {
            this.iMR.i(bdUniqueId);
        }
        if (this.iML != null) {
            this.iML.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.bbU().setTag(bdUniqueId);
        if (this.eCw != null) {
            this.eCw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eCw);
        }
        if (this.iMQ != null) {
            this.iMQ.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.iMS = 0L;
        this.mSkinType = 3;
        this.hTJ = false;
        this.iMT = 0;
        this.iMU = true;
        this.iMV = false;
        this.iMW = false;
        this.iMX = 0;
        this.hTT = 0;
        this.iMY = false;
        this.ePN = 1;
        this.hDQ = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hDO == null) {
                            PersonalizePageView.this.hDO = new n(new l());
                        }
                        PersonalizePageView.this.hDO.a(PersonalizePageView.this.iGz, 2);
                    } else if (PersonalizePageView.this.hDO != null) {
                        PersonalizePageView.this.hDO.rc();
                    }
                }
            }
        };
        this.iNa = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iMP != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bhy().bhz(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iKB = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dD("obj_locate", "1").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.iMN != null) {
                        PersonalizePageView.this.iMN.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dD("tid", arVar.getTid()).dD("nid", arVar.getNid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", arVar.getFid()).dD("obj_param1", arVar.weight).dD("obj_source", arVar.source).dD("obj_id", arVar.extra).dD("obj_type", sb.toString()).dD("obj_name", str).ai(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.iFU = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.fGt = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.fGt != i && PersonalizePageView.this.iGF != null) {
                    PersonalizePageView.this.fGt = i;
                    if (PersonalizePageView.this.fGt == 1) {
                        PersonalizePageView.this.iGF.bGm();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.iGF.bGn();
                    } else {
                        PersonalizePageView.this.iGF.bGm();
                    }
                }
            }
        };
        this.iGG = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwO() {
                if (PersonalizePageView.this.iGF != null) {
                    PersonalizePageView.this.fGt = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.iGz)) {
                        PersonalizePageView.this.iGF.bGn();
                    } else {
                        PersonalizePageView.this.iGF.bGm();
                    }
                }
            }
        };
        this.iNb = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hLJ = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_first_install", true);

            private void cxQ() {
                if (this.hLJ) {
                    this.hLJ = false;
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void O(int i, int i2, int i3) {
                if (PersonalizePageView.this.iMO == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cgx = PersonalizePageView.this.cgx();
                PersonalizePageView.this.bFX();
                if (cgx) {
                    PersonalizePageView.this.gT(true);
                }
                PersonalizePageView.this.iMO.N(i, i2, i3);
                q.aYY().aYZ();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.iMO != null) {
                    PersonalizePageView.this.iMO.A(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cxQ();
                } else if (!this.hLJ) {
                    PersonalizePageView.this.iGH.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cxQ();
                    PersonalizePageView.this.cwA();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cxQ();
                PersonalizePageView.this.iGH.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bFX();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dxF().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cxR() {
                if (PersonalizePageView.this.fEa != null) {
                    PersonalizePageView.this.fEa.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fEa.endLoadData();
                    PersonalizePageView.this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.iNc = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bAB().Dj("page_recommend");
                PersonalizePageView.this.iMP.update();
                PersonalizePageView.this.iMP.pG(false);
                PersonalizePageView.this.iMY = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iLd = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.iMP != null && PersonalizePageView.this.iMP.cmW() != null) {
                    PersonalizePageView.this.iMP.cmW().cxq();
                }
            }
        };
        this.iNd = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bkO() {
                if (PersonalizePageView.this.iMY) {
                    PersonalizePageView.this.hTT = 0;
                    PersonalizePageView.this.ePN = 1;
                    PersonalizePageView.this.iMY = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iLe = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.iMP != null) {
                    PersonalizePageView.this.iMP.pG(true);
                    PersonalizePageView.this.iMP.cxW();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bbU().mN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.iNe = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eCw = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cwg();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.iGJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bFE();
            }
        };
        this.hUI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hTJ = true;
                    }
                }
            }
        };
        this.iNf = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iGH != null && !PersonalizePageView.this.iGH.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.iML == null) {
                            PersonalizePageView.this.iML = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.iML.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.iMM = PersonalizePageView.this.iML;
                            PersonalizePageView.this.cxN();
                        } else if (PersonalizePageView.this.iMM != PersonalizePageView.this.iML) {
                            PersonalizePageView.this.iMM = PersonalizePageView.this.iML;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.iML.setEnable(true);
                        PersonalizePageView.this.iGH.setProgressView(PersonalizePageView.this.iML);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.iGH.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.iMK == null) {
                        PersonalizePageView.this.iMK = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.iMM = PersonalizePageView.this.iMK;
                        PersonalizePageView.this.cxN();
                    } else if (PersonalizePageView.this.iMM != PersonalizePageView.this.iMK || !aVar.equals(PersonalizePageView.this.iMK.cyt())) {
                        PersonalizePageView.this.iMM = PersonalizePageView.this.iMK;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.iMK.setEnable(true);
                    PersonalizePageView.this.iGH.setProgressView(PersonalizePageView.this.iMK);
                    PersonalizePageView.this.iMK.a(aVar);
                    PersonalizePageView.this.iGH.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.iNg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.iMZ != null) {
                    PersonalizePageView.this.iMZ.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iMS = 0L;
        this.mSkinType = 3;
        this.hTJ = false;
        this.iMT = 0;
        this.iMU = true;
        this.iMV = false;
        this.iMW = false;
        this.iMX = 0;
        this.hTT = 0;
        this.iMY = false;
        this.ePN = 1;
        this.hDQ = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hDO == null) {
                            PersonalizePageView.this.hDO = new n(new l());
                        }
                        PersonalizePageView.this.hDO.a(PersonalizePageView.this.iGz, 2);
                    } else if (PersonalizePageView.this.hDO != null) {
                        PersonalizePageView.this.hDO.rc();
                    }
                }
            }
        };
        this.iNa = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iMP != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bhy().bhz(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iKB = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dD("obj_locate", "1").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.iMN != null) {
                        PersonalizePageView.this.iMN.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dD("tid", arVar.getTid()).dD("nid", arVar.getNid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", arVar.getFid()).dD("obj_param1", arVar.weight).dD("obj_source", arVar.source).dD("obj_id", arVar.extra).dD("obj_type", sb.toString()).dD("obj_name", str).ai(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.iFU = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.fGt = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.fGt != i && PersonalizePageView.this.iGF != null) {
                    PersonalizePageView.this.fGt = i;
                    if (PersonalizePageView.this.fGt == 1) {
                        PersonalizePageView.this.iGF.bGm();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.iGF.bGn();
                    } else {
                        PersonalizePageView.this.iGF.bGm();
                    }
                }
            }
        };
        this.iGG = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwO() {
                if (PersonalizePageView.this.iGF != null) {
                    PersonalizePageView.this.fGt = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.iGz)) {
                        PersonalizePageView.this.iGF.bGn();
                    } else {
                        PersonalizePageView.this.iGF.bGm();
                    }
                }
            }
        };
        this.iNb = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hLJ = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_first_install", true);

            private void cxQ() {
                if (this.hLJ) {
                    this.hLJ = false;
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void O(int i, int i2, int i3) {
                if (PersonalizePageView.this.iMO == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cgx = PersonalizePageView.this.cgx();
                PersonalizePageView.this.bFX();
                if (cgx) {
                    PersonalizePageView.this.gT(true);
                }
                PersonalizePageView.this.iMO.N(i, i2, i3);
                q.aYY().aYZ();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.iMO != null) {
                    PersonalizePageView.this.iMO.A(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cxQ();
                } else if (!this.hLJ) {
                    PersonalizePageView.this.iGH.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cxQ();
                    PersonalizePageView.this.cwA();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cxQ();
                PersonalizePageView.this.iGH.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bFX();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dxF().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cxR() {
                if (PersonalizePageView.this.fEa != null) {
                    PersonalizePageView.this.fEa.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fEa.endLoadData();
                    PersonalizePageView.this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.iNc = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bAB().Dj("page_recommend");
                PersonalizePageView.this.iMP.update();
                PersonalizePageView.this.iMP.pG(false);
                PersonalizePageView.this.iMY = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iLd = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.iMP != null && PersonalizePageView.this.iMP.cmW() != null) {
                    PersonalizePageView.this.iMP.cmW().cxq();
                }
            }
        };
        this.iNd = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bkO() {
                if (PersonalizePageView.this.iMY) {
                    PersonalizePageView.this.hTT = 0;
                    PersonalizePageView.this.ePN = 1;
                    PersonalizePageView.this.iMY = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iLe = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.iMP != null) {
                    PersonalizePageView.this.iMP.pG(true);
                    PersonalizePageView.this.iMP.cxW();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bbU().mN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.iNe = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eCw = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cwg();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.iGJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bFE();
            }
        };
        this.hUI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hTJ = true;
                    }
                }
            }
        };
        this.iNf = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iGH != null && !PersonalizePageView.this.iGH.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.iML == null) {
                            PersonalizePageView.this.iML = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.iML.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.iMM = PersonalizePageView.this.iML;
                            PersonalizePageView.this.cxN();
                        } else if (PersonalizePageView.this.iMM != PersonalizePageView.this.iML) {
                            PersonalizePageView.this.iMM = PersonalizePageView.this.iML;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.iML.setEnable(true);
                        PersonalizePageView.this.iGH.setProgressView(PersonalizePageView.this.iML);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.iGH.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.iMK == null) {
                        PersonalizePageView.this.iMK = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.iMM = PersonalizePageView.this.iMK;
                        PersonalizePageView.this.cxN();
                    } else if (PersonalizePageView.this.iMM != PersonalizePageView.this.iMK || !aVar.equals(PersonalizePageView.this.iMK.cyt())) {
                        PersonalizePageView.this.iMM = PersonalizePageView.this.iMK;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.iMK.setEnable(true);
                    PersonalizePageView.this.iGH.setProgressView(PersonalizePageView.this.iMK);
                    PersonalizePageView.this.iMK.a(aVar);
                    PersonalizePageView.this.iGH.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.iNg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.iMZ != null) {
                    PersonalizePageView.this.iMZ.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iMS = 0L;
        this.mSkinType = 3;
        this.hTJ = false;
        this.iMT = 0;
        this.iMU = true;
        this.iMV = false;
        this.iMW = false;
        this.iMX = 0;
        this.hTT = 0;
        this.iMY = false;
        this.ePN = 1;
        this.hDQ = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hDO == null) {
                            PersonalizePageView.this.hDO = new n(new l());
                        }
                        PersonalizePageView.this.hDO.a(PersonalizePageView.this.iGz, 2);
                    } else if (PersonalizePageView.this.hDO != null) {
                        PersonalizePageView.this.hDO.rc();
                    }
                }
            }
        };
        this.iNa = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iMP != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bhy().bhz(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iKB = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                if (arVar != null) {
                    TiebaStatic.log(new aq("c11693").dD("obj_locate", "1").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("nid", arVar.getNid()));
                    TiebaStatic.log(new aq("c11989").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    if (PersonalizePageView.this.iMN != null) {
                        PersonalizePageView.this.iMN.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dD("tid", arVar.getTid()).dD("nid", arVar.getNid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", arVar.getFid()).dD("obj_param1", arVar.weight).dD("obj_source", arVar.source).dD("obj_id", arVar.extra).dD("obj_type", sb.toString()).dD("obj_name", str).ai(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.iFU = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.fGt = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.fGt != i2 && PersonalizePageView.this.iGF != null) {
                    PersonalizePageView.this.fGt = i2;
                    if (PersonalizePageView.this.fGt == 1) {
                        PersonalizePageView.this.iGF.bGm();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.iGF.bGn();
                    } else {
                        PersonalizePageView.this.iGF.bGm();
                    }
                }
            }
        };
        this.iGG = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwO() {
                if (PersonalizePageView.this.iGF != null) {
                    PersonalizePageView.this.fGt = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.iGz)) {
                        PersonalizePageView.this.iGF.bGn();
                    } else {
                        PersonalizePageView.this.iGF.bGm();
                    }
                }
            }
        };
        this.iNb = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hLJ = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_first_install", true);

            private void cxQ() {
                if (this.hLJ) {
                    this.hLJ = false;
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void O(int i2, int i22, int i3) {
                if (PersonalizePageView.this.iMO == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cgx = PersonalizePageView.this.cgx();
                PersonalizePageView.this.bFX();
                if (cgx) {
                    PersonalizePageView.this.gT(true);
                }
                PersonalizePageView.this.iMO.N(i2, i22, i3);
                q.aYY().aYZ();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.iMO != null) {
                    PersonalizePageView.this.iMO.A(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cxQ();
                } else if (!this.hLJ) {
                    PersonalizePageView.this.iGH.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cxQ();
                    PersonalizePageView.this.cwA();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cxQ();
                PersonalizePageView.this.iGH.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bFX();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dxF().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cxR() {
                if (PersonalizePageView.this.fEa != null) {
                    PersonalizePageView.this.fEa.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fEa.endLoadData();
                    PersonalizePageView.this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.iNc = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bAB().Dj("page_recommend");
                PersonalizePageView.this.iMP.update();
                PersonalizePageView.this.iMP.pG(false);
                PersonalizePageView.this.iMY = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iLd = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.iMP != null && PersonalizePageView.this.iMP.cmW() != null) {
                    PersonalizePageView.this.iMP.cmW().cxq();
                }
            }
        };
        this.iNd = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bkO() {
                if (PersonalizePageView.this.iMY) {
                    PersonalizePageView.this.hTT = 0;
                    PersonalizePageView.this.ePN = 1;
                    PersonalizePageView.this.iMY = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iLe = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.iMP != null) {
                    PersonalizePageView.this.iMP.pG(true);
                    PersonalizePageView.this.iMP.cxW();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bbU().mN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.iNe = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eCw = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                        com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cwg();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.iGJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bFE();
            }
        };
        this.hUI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hTJ = true;
                    }
                }
            }
        };
        this.iNf = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iGH != null && !PersonalizePageView.this.iGH.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.iML == null) {
                            PersonalizePageView.this.iML = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.iML.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.iMM = PersonalizePageView.this.iML;
                            PersonalizePageView.this.cxN();
                        } else if (PersonalizePageView.this.iMM != PersonalizePageView.this.iML) {
                            PersonalizePageView.this.iMM = PersonalizePageView.this.iML;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.iML.setEnable(true);
                        PersonalizePageView.this.iGH.setProgressView(PersonalizePageView.this.iML);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.iGH.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.iMK == null) {
                        PersonalizePageView.this.iMK = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.iMM = PersonalizePageView.this.iMK;
                        PersonalizePageView.this.cxN();
                    } else if (PersonalizePageView.this.iMM != PersonalizePageView.this.iMK || !aVar.equals(PersonalizePageView.this.iMK.cyt())) {
                        PersonalizePageView.this.iMM = PersonalizePageView.this.iMK;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.iMK.setEnable(true);
                    PersonalizePageView.this.iGH.setProgressView(PersonalizePageView.this.iMK);
                    PersonalizePageView.this.iMK.a(aVar);
                    PersonalizePageView.this.iGH.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.iNg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.iMZ != null) {
                    PersonalizePageView.this.iMZ.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.iGz = new BdTypeRecyclerView(context);
        this.dCG = new LinearLayoutManager(this.iGz.getContext());
        this.iGz.setLayoutManager(this.dCG);
        this.iGz.setFadingEdgeLength(0);
        this.iGz.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hDO = new n(new l());
            this.hDO.a(this.iGz, 2);
        }
        MessageManager.getInstance().registerListener(this.hDQ);
        MessageManager.getInstance().registerListener(this.iNa);
        this.iGH = new BigdaySwipeRefreshLayout(context);
        this.iGH.addView(this.iGz);
        this.fEa = new PbListView(context);
        this.fEa.getView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setLineGone();
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.fEa.setOnClickListener(this.iGJ);
        this.fEa.bkv();
        this.iGz.setNextPage(this.fEa);
        com.baidu.adp.base.e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        MessageManager.getInstance().registerListener(this.iNf);
        com.baidu.tbadk.core.bigday.b.bbU().hR(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.bbU().mN(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.iGH);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.iMZ = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.iMZ, layoutParams);
            this.iMZ.setOnClickListener(this.iNg);
            this.iMZ.setVisibility(8);
        }
        this.iMR = new com.baidu.tieba.homepage.personalize.model.e();
        this.iMN = new af(context, this.iGz);
        this.iMN.b(this.iMR);
        this.iMP = new e(this.pageContext, this.iGz, this.iMN, this.iGH);
        this.iMQ = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.hUI);
        this.iMX = com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cxN() {
        if (this.iMM != null) {
            this.iMM.setListPullRefreshListener(this.iNc);
            this.iMM.a(this.iLd);
            this.iMM.a(this.iNd);
            this.iMM.a(this.iLe);
        }
    }

    public void bMh() {
        this.iMN.b(this.iKB);
        this.iMN.a(this.iFU);
        this.iMP.a(this.iNb);
        this.iMQ.a(this);
        cxN();
        this.iGz.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.hTT += i2;
                if (PersonalizePageView.this.iMZ != null) {
                    com.baidu.adp.widget.ListView.q item = PersonalizePageView.this.iGz.getItem(PersonalizePageView.this.dCG.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.l) {
                        if (((com.baidu.tieba.card.data.l) item).position >= 6) {
                            PersonalizePageView.this.iMZ.show();
                        } else {
                            PersonalizePageView.this.iMZ.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dCG != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.hTT < height * 3 || PersonalizePageView.this.ePN != 1) {
                        if (PersonalizePageView.this.hTT < height * 3 && PersonalizePageView.this.ePN == 2) {
                            PersonalizePageView.this.ePN = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.ePN = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.ePN)));
                    }
                    if (PersonalizePageView.this.dCG.getItemCount() - PersonalizePageView.this.dCG.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bFE();
                    }
                }
            }
        });
        this.iGz.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bFE();
            }
        });
        this.iGz.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.iMS >= 5000) {
                    PersonalizePageView.this.iMP.cx(i, i2);
                }
            }
        }, 1L);
        this.iGz.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.iMP != null && PersonalizePageView.this.iMP.cmW() != null) {
                        PersonalizePageView.this.iMP.cmW().cE(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                        ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).ccF().stopPlay();
                    }
                }
            }
        });
        this.iGz.removeOnScrollListener(this.mOnScrollListener);
        this.iGz.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.iMO = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.fEa != null) {
            this.fEa.setText(getContext().getString(R.string.pb_load_more));
            this.fEa.endLoadData();
            this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.iMP.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.iMP != null) {
            this.iMP.pK(!z);
        }
        this.iMW = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.iMW;
    }

    public void e(Long l) {
        this.iMP.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.iMP != null) {
            this.iMP.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void showFloatingView() {
        if (this.iMP != null) {
            this.iMP.showFloatingView();
        }
    }

    public void cxO() {
        if (this.iMP != null) {
            this.iMP.cxO();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.fMR != null) {
                this.fMR.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.iML != null) {
                this.iML.changeSkin(i);
            }
            if (this.fEa != null) {
                this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
                this.fEa.changeSkin(i);
            }
            this.iMN.onChangeSkinType(i);
            if (this.iMP != null) {
                this.iMP.onChangeSkinType(i);
            }
            if (this.iMZ != null) {
                this.iMZ.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aQ(String str, int i) {
        if (this.fEa != null) {
            this.fEa.setText(getContext().getString(R.string.pb_load_more));
            this.fEa.endLoadData();
            this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.iMP.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.iMP != null) {
                        PersonalizePageView.this.iMP.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFX() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this);
            this.fMR = null;
            this.iGz.setNextPage(this.fEa);
            this.fEa.setText(getContext().getString(R.string.pb_load_more));
            this.fEa.endLoadData();
            this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.iGH != null) {
            this.iGH.setVisibility(0);
        }
        if (this.iMO != null) {
            this.iMO.cwq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgx() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gT(boolean z) {
        if (this.fMR == null) {
            this.fMR = new com.baidu.tbadk.k.g(getContext());
            this.fMR.bn(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.fMR.bta();
            this.fMR.setWrapStyle(true);
            this.fMR.onChangeSkinType();
        }
        this.fMR.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.iGz.setNextPage(null);
        if (this.iGH != null) {
            this.iGH.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.iMP != null) {
            this.iMP.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.iMP != null) {
            this.iMP.ot(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.iMX < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mS().postDelayed(this.iNe, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.iMP != null) {
            this.iMP.pA(z);
        }
        if (this.iGF != null) {
            this.iGF.b(this.iGG);
            this.iGF.a(this.iGG);
            this.iGG.cwO();
        }
    }

    public void cwA() {
        if (this.iMP != null) {
            gT(true);
            this.iMP.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.bbU().bbW();
            com.baidu.tbadk.core.bigday.b.bbU().bbV();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.iMP != null) {
            this.iMP.update();
        } else if (this.iGz != null && this.iGH != null) {
            showFloatingView();
            this.iGz.setSelection(0);
            if (!this.iGH.isRefreshing()) {
                if (this.iMP != null && this.iMP.cmW() != null) {
                    this.iMP.cmW().cxq();
                    this.iMP.pG(false);
                }
                this.iGH.setRefreshing(true);
            }
            if (this.iGG != null) {
                this.iGG.cwO();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hDQ);
        MessageManager.getInstance().unRegisterListener(this.hUI);
        MessageManager.getInstance().unRegisterListener(this.iNf);
        this.iMP.onDestroy();
        this.iMN.b((NEGFeedBackView.a) null);
        this.iMN.onDestroy();
        this.iMP.a((e.a) null);
        if (this.iMK != null) {
            this.iMK.setListPullRefreshListener(null);
            this.iMK.a((f.d) null);
            this.iMK.a((f.a) null);
            this.iMK.a((f.b) null);
            this.iMK.release();
        }
        if (this.iML != null) {
            this.iML.setListPullRefreshListener(null);
            this.iML.a((f.d) null);
            this.iML.a((f.a) null);
            this.iML.a((f.b) null);
            this.iML.release();
        }
        this.iGz.setOnSrollToBottomListener(null);
        if (this.iGF != null) {
            this.iGF.b(this.iGG);
        }
        this.iGz.removeOnScrollListener(this.mOnScrollListener);
        if (this.fMR != null) {
            this.fMR.release();
        }
        this.iGz.setRecyclerListener(null);
        if (this.iMQ != null) {
            this.iMQ.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.bbU().destroy();
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iNe);
    }

    public void onPause() {
        this.iMP.onPause();
        if (this.iMN != null) {
            this.iMN.onPause();
        }
    }

    public void onResume() {
        if (this.hTJ) {
            reload();
            this.hTJ = false;
        }
        if (this.iGH != null) {
            this.iGH.resume();
        }
        if (this.iMN != null) {
            this.iMN.onResume();
        }
    }

    public void cwg() {
        if (this.iMN != null) {
            this.iMN.notifyDataSetChanged();
        }
    }

    public void cwh() {
        if (this.iMP != null) {
            this.iMP.ot(true);
        }
        s.cbY().kM(false);
        com.baidu.tieba.a.d.bAB().dA("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iNe);
    }

    public void cxK() {
        this.iMP.cyd();
    }

    public void cxP() {
        this.iMP.cxP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFE() {
        com.baidu.tieba.homepage.framework.a.cwp().r(System.currentTimeMillis(), 1);
        if (this.fEa != null && !this.fEa.isLoading()) {
            this.fEa.startLoadData();
            this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.iMP.bFE();
    }
}
