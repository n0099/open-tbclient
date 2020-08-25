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
    private LinearLayoutManager dCC;
    private final CustomMessageListener eCs;
    private int ePJ;
    private PbListView fDW;
    private int fGp;
    private com.baidu.tbadk.k.g fMN;
    private n hDI;
    private CustomMessageListener hDK;
    private boolean hTD;
    private int hTN;
    private CustomMessageListener hUC;
    private FollowUserButton.a iFO;
    ScrollFragmentTabHost.a iGA;
    private BigdaySwipeRefreshLayout iGB;
    private View.OnClickListener iGD;
    private BdTypeRecyclerView iGt;
    private ScrollFragmentTabHost iGz;
    f.d iKX;
    f.b iKY;
    private NEGFeedBackView.a iKv;
    private com.baidu.tieba.homepage.personalize.bigday.b iME;
    private com.baidu.tieba.homepage.personalize.bigday.a iMF;
    private a iMG;
    private af iMH;
    private com.baidu.tieba.homepage.framework.b iMI;
    private e iMJ;
    private com.baidu.tieba.homepage.personalize.a iMK;
    private com.baidu.tieba.homepage.personalize.model.e iML;
    private long iMM;
    private int iMN;
    private boolean iMO;
    private boolean iMP;
    private boolean iMQ;
    private int iMR;
    private boolean iMS;
    private FRSRefreshButton iMT;
    private CustomMessageListener iMU;
    private e.a iMV;
    f.c iMW;
    f.a iMX;
    private Runnable iMY;
    public CustomMessageListener iMZ;
    private View.OnClickListener iNa;
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
        int i = personalizePageView.iMR + 1;
        personalizePageView.iMR = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iGz = scrollFragmentTabHost;
        if (this.iGz != null) {
            this.iGz.b(this.iGA);
            this.iGz.a(this.iGA);
        }
        if (this.iMJ != null) {
            this.iMJ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iMK != null) {
            this.iMK.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.iGB != null) {
            this.iGB.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iMH != null) {
            this.iMH.setPageUniqueId(bdUniqueId);
        }
        if (this.iMJ != null) {
            this.iMJ.p(bdUniqueId);
        }
        if (this.iML != null) {
            this.iML.i(bdUniqueId);
        }
        if (this.iMF != null) {
            this.iMF.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.bbU().setTag(bdUniqueId);
        if (this.eCs != null) {
            this.eCs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eCs);
        }
        if (this.iMK != null) {
            this.iMK.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.iMM = 0L;
        this.mSkinType = 3;
        this.hTD = false;
        this.iMN = 0;
        this.iMO = true;
        this.iMP = false;
        this.iMQ = false;
        this.iMR = 0;
        this.hTN = 0;
        this.iMS = false;
        this.ePJ = 1;
        this.hDK = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hDI == null) {
                            PersonalizePageView.this.hDI = new n(new l());
                        }
                        PersonalizePageView.this.hDI.a(PersonalizePageView.this.iGt, 2);
                    } else if (PersonalizePageView.this.hDI != null) {
                        PersonalizePageView.this.hDI.rc();
                    }
                }
            }
        };
        this.iMU = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iMJ != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bhy().bhz(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iKv = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
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
                    if (PersonalizePageView.this.iMH != null) {
                        PersonalizePageView.this.iMH.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dD("tid", arVar.getTid()).dD("nid", arVar.getNid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", arVar.getFid()).dD("obj_param1", arVar.weight).dD("obj_source", arVar.source).dD("obj_id", arVar.extra).dD("obj_type", sb.toString()).dD("obj_name", str).ai(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.iFO = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.fGp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.fGp != i && PersonalizePageView.this.iGz != null) {
                    PersonalizePageView.this.fGp = i;
                    if (PersonalizePageView.this.fGp == 1) {
                        PersonalizePageView.this.iGz.bGl();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.iGz.bGm();
                    } else {
                        PersonalizePageView.this.iGz.bGl();
                    }
                }
            }
        };
        this.iGA = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwN() {
                if (PersonalizePageView.this.iGz != null) {
                    PersonalizePageView.this.fGp = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.iGt)) {
                        PersonalizePageView.this.iGz.bGm();
                    } else {
                        PersonalizePageView.this.iGz.bGl();
                    }
                }
            }
        };
        this.iMV = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hLD = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_first_install", true);

            private void cxP() {
                if (this.hLD) {
                    this.hLD = false;
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void O(int i, int i2, int i3) {
                if (PersonalizePageView.this.iMI == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cgw = PersonalizePageView.this.cgw();
                PersonalizePageView.this.bFW();
                if (cgw) {
                    PersonalizePageView.this.gS(true);
                }
                PersonalizePageView.this.iMI.N(i, i2, i3);
                q.aYY().aYZ();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.iMI != null) {
                    PersonalizePageView.this.iMI.A(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cxP();
                } else if (!this.hLD) {
                    PersonalizePageView.this.iGB.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cxP();
                    PersonalizePageView.this.cwz();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cxP();
                PersonalizePageView.this.iGB.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bFW();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dxA().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cxQ() {
                if (PersonalizePageView.this.fDW != null) {
                    PersonalizePageView.this.fDW.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fDW.endLoadData();
                    PersonalizePageView.this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.iMW = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bAA().Di("page_recommend");
                PersonalizePageView.this.iMJ.update();
                PersonalizePageView.this.iMJ.pE(false);
                PersonalizePageView.this.iMS = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iKX = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.iMJ != null && PersonalizePageView.this.iMJ.cmV() != null) {
                    PersonalizePageView.this.iMJ.cmV().cxp();
                }
            }
        };
        this.iMX = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bkO() {
                if (PersonalizePageView.this.iMS) {
                    PersonalizePageView.this.hTN = 0;
                    PersonalizePageView.this.ePJ = 1;
                    PersonalizePageView.this.iMS = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iKY = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.iMJ != null) {
                    PersonalizePageView.this.iMJ.pE(true);
                    PersonalizePageView.this.iMJ.cxV();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bbU().mN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.iMY = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eCs = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                                PersonalizePageView.this.cwf();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.iGD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bFD();
            }
        };
        this.hUC = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hTD = true;
                    }
                }
            }
        };
        this.iMZ = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iGB != null && !PersonalizePageView.this.iGB.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.iMF == null) {
                            PersonalizePageView.this.iMF = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.iMF.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.iMG = PersonalizePageView.this.iMF;
                            PersonalizePageView.this.cxM();
                        } else if (PersonalizePageView.this.iMG != PersonalizePageView.this.iMF) {
                            PersonalizePageView.this.iMG = PersonalizePageView.this.iMF;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.iMF.setEnable(true);
                        PersonalizePageView.this.iGB.setProgressView(PersonalizePageView.this.iMF);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.iGB.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.iME == null) {
                        PersonalizePageView.this.iME = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.iMG = PersonalizePageView.this.iME;
                        PersonalizePageView.this.cxM();
                    } else if (PersonalizePageView.this.iMG != PersonalizePageView.this.iME || !aVar.equals(PersonalizePageView.this.iME.cys())) {
                        PersonalizePageView.this.iMG = PersonalizePageView.this.iME;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.iME.setEnable(true);
                    PersonalizePageView.this.iGB.setProgressView(PersonalizePageView.this.iME);
                    PersonalizePageView.this.iME.a(aVar);
                    PersonalizePageView.this.iGB.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.iNa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.iMT != null) {
                    PersonalizePageView.this.iMT.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iMM = 0L;
        this.mSkinType = 3;
        this.hTD = false;
        this.iMN = 0;
        this.iMO = true;
        this.iMP = false;
        this.iMQ = false;
        this.iMR = 0;
        this.hTN = 0;
        this.iMS = false;
        this.ePJ = 1;
        this.hDK = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hDI == null) {
                            PersonalizePageView.this.hDI = new n(new l());
                        }
                        PersonalizePageView.this.hDI.a(PersonalizePageView.this.iGt, 2);
                    } else if (PersonalizePageView.this.hDI != null) {
                        PersonalizePageView.this.hDI.rc();
                    }
                }
            }
        };
        this.iMU = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iMJ != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bhy().bhz(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iKv = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
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
                    if (PersonalizePageView.this.iMH != null) {
                        PersonalizePageView.this.iMH.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dD("tid", arVar.getTid()).dD("nid", arVar.getNid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", arVar.getFid()).dD("obj_param1", arVar.weight).dD("obj_source", arVar.source).dD("obj_id", arVar.extra).dD("obj_type", sb.toString()).dD("obj_name", str).ai(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.iFO = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.fGp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.fGp != i && PersonalizePageView.this.iGz != null) {
                    PersonalizePageView.this.fGp = i;
                    if (PersonalizePageView.this.fGp == 1) {
                        PersonalizePageView.this.iGz.bGl();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.iGz.bGm();
                    } else {
                        PersonalizePageView.this.iGz.bGl();
                    }
                }
            }
        };
        this.iGA = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwN() {
                if (PersonalizePageView.this.iGz != null) {
                    PersonalizePageView.this.fGp = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.iGt)) {
                        PersonalizePageView.this.iGz.bGm();
                    } else {
                        PersonalizePageView.this.iGz.bGl();
                    }
                }
            }
        };
        this.iMV = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hLD = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_first_install", true);

            private void cxP() {
                if (this.hLD) {
                    this.hLD = false;
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void O(int i, int i2, int i3) {
                if (PersonalizePageView.this.iMI == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cgw = PersonalizePageView.this.cgw();
                PersonalizePageView.this.bFW();
                if (cgw) {
                    PersonalizePageView.this.gS(true);
                }
                PersonalizePageView.this.iMI.N(i, i2, i3);
                q.aYY().aYZ();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.iMI != null) {
                    PersonalizePageView.this.iMI.A(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cxP();
                } else if (!this.hLD) {
                    PersonalizePageView.this.iGB.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cxP();
                    PersonalizePageView.this.cwz();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cxP();
                PersonalizePageView.this.iGB.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bFW();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dxA().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cxQ() {
                if (PersonalizePageView.this.fDW != null) {
                    PersonalizePageView.this.fDW.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fDW.endLoadData();
                    PersonalizePageView.this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.iMW = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bAA().Di("page_recommend");
                PersonalizePageView.this.iMJ.update();
                PersonalizePageView.this.iMJ.pE(false);
                PersonalizePageView.this.iMS = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iKX = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.iMJ != null && PersonalizePageView.this.iMJ.cmV() != null) {
                    PersonalizePageView.this.iMJ.cmV().cxp();
                }
            }
        };
        this.iMX = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bkO() {
                if (PersonalizePageView.this.iMS) {
                    PersonalizePageView.this.hTN = 0;
                    PersonalizePageView.this.ePJ = 1;
                    PersonalizePageView.this.iMS = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iKY = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.iMJ != null) {
                    PersonalizePageView.this.iMJ.pE(true);
                    PersonalizePageView.this.iMJ.cxV();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bbU().mN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.iMY = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eCs = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                                PersonalizePageView.this.cwf();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.iGD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bFD();
            }
        };
        this.hUC = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hTD = true;
                    }
                }
            }
        };
        this.iMZ = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iGB != null && !PersonalizePageView.this.iGB.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.iMF == null) {
                            PersonalizePageView.this.iMF = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.iMF.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.iMG = PersonalizePageView.this.iMF;
                            PersonalizePageView.this.cxM();
                        } else if (PersonalizePageView.this.iMG != PersonalizePageView.this.iMF) {
                            PersonalizePageView.this.iMG = PersonalizePageView.this.iMF;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.iMF.setEnable(true);
                        PersonalizePageView.this.iGB.setProgressView(PersonalizePageView.this.iMF);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.iGB.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.iME == null) {
                        PersonalizePageView.this.iME = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.iMG = PersonalizePageView.this.iME;
                        PersonalizePageView.this.cxM();
                    } else if (PersonalizePageView.this.iMG != PersonalizePageView.this.iME || !aVar.equals(PersonalizePageView.this.iME.cys())) {
                        PersonalizePageView.this.iMG = PersonalizePageView.this.iME;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.iME.setEnable(true);
                    PersonalizePageView.this.iGB.setProgressView(PersonalizePageView.this.iME);
                    PersonalizePageView.this.iME.a(aVar);
                    PersonalizePageView.this.iGB.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.iNa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.iMT != null) {
                    PersonalizePageView.this.iMT.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iMM = 0L;
        this.mSkinType = 3;
        this.hTD = false;
        this.iMN = 0;
        this.iMO = true;
        this.iMP = false;
        this.iMQ = false;
        this.iMR = 0;
        this.hTN = 0;
        this.iMS = false;
        this.ePJ = 1;
        this.hDK = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.hDI == null) {
                            PersonalizePageView.this.hDI = new n(new l());
                        }
                        PersonalizePageView.this.hDI.a(PersonalizePageView.this.iGt, 2);
                    } else if (PersonalizePageView.this.hDI != null) {
                        PersonalizePageView.this.hDI.rc();
                    }
                }
            }
        };
        this.iMU = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iMJ != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.bhy().bhz(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.iKv = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
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
                    if (PersonalizePageView.this.iMH != null) {
                        PersonalizePageView.this.iMH.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new aq("c11693").dD("tid", arVar.getTid()).dD("nid", arVar.getNid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", arVar.getFid()).dD("obj_param1", arVar.weight).dD("obj_source", arVar.source).dD("obj_id", arVar.extra).dD("obj_type", sb.toString()).dD("obj_name", str).ai(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.iFO = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
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
        this.fGp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.fGp != i2 && PersonalizePageView.this.iGz != null) {
                    PersonalizePageView.this.fGp = i2;
                    if (PersonalizePageView.this.fGp == 1) {
                        PersonalizePageView.this.iGz.bGl();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.iGz.bGm();
                    } else {
                        PersonalizePageView.this.iGz.bGl();
                    }
                }
            }
        };
        this.iGA = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwN() {
                if (PersonalizePageView.this.iGz != null) {
                    PersonalizePageView.this.fGp = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.iGt)) {
                        PersonalizePageView.this.iGz.bGm();
                    } else {
                        PersonalizePageView.this.iGz.bGl();
                    }
                }
            }
        };
        this.iMV = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            private boolean hLD = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_first_install", true);

            private void cxP() {
                if (this.hLD) {
                    this.hLD = false;
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void O(int i2, int i22, int i3) {
                if (PersonalizePageView.this.iMI == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cgw = PersonalizePageView.this.cgw();
                PersonalizePageView.this.bFW();
                if (cgw) {
                    PersonalizePageView.this.gS(true);
                }
                PersonalizePageView.this.iMI.N(i2, i22, i3);
                q.aYY().aYZ();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void B(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.iMI != null) {
                    PersonalizePageView.this.iMI.A(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cxP();
                } else if (!this.hLD) {
                    PersonalizePageView.this.iGB.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cxP();
                    PersonalizePageView.this.cwz();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cxP();
                PersonalizePageView.this.iGB.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.bFW();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dxA().startLoad();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cxQ() {
                if (PersonalizePageView.this.fDW != null) {
                    PersonalizePageView.this.fDW.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.fDW.endLoadData();
                    PersonalizePageView.this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.iMW = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bAA().Di("page_recommend");
                PersonalizePageView.this.iMJ.update();
                PersonalizePageView.this.iMJ.pE(false);
                PersonalizePageView.this.iMS = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.iKX = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.iMJ != null && PersonalizePageView.this.iMJ.cmV() != null) {
                    PersonalizePageView.this.iMJ.cmV().cxp();
                }
            }
        };
        this.iMX = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bkO() {
                if (PersonalizePageView.this.iMS) {
                    PersonalizePageView.this.hTN = 0;
                    PersonalizePageView.this.ePJ = 1;
                    PersonalizePageView.this.iMS = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.iKY = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.iMJ != null) {
                    PersonalizePageView.this.iMJ.pE(true);
                    PersonalizePageView.this.iMJ.cxV();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.bbU().mN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        };
        this.iMY = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.eCs = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
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
                                PersonalizePageView.this.cwf();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.iGD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bFD();
            }
        };
        this.hUC = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.hTD = true;
                    }
                }
            }
        };
        this.iMZ = new CustomMessageListener(2921349) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.iGB != null && !PersonalizePageView.this.iGB.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.iMF == null) {
                            PersonalizePageView.this.iMF = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.iMF.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.iMG = PersonalizePageView.this.iMF;
                            PersonalizePageView.this.cxM();
                        } else if (PersonalizePageView.this.iMG != PersonalizePageView.this.iMF) {
                            PersonalizePageView.this.iMG = PersonalizePageView.this.iMF;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.iMF.setEnable(true);
                        PersonalizePageView.this.iGB.setProgressView(PersonalizePageView.this.iMF);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.iGB.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.iME == null) {
                        PersonalizePageView.this.iME = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.iMG = PersonalizePageView.this.iME;
                        PersonalizePageView.this.cxM();
                    } else if (PersonalizePageView.this.iMG != PersonalizePageView.this.iME || !aVar.equals(PersonalizePageView.this.iME.cys())) {
                        PersonalizePageView.this.iMG = PersonalizePageView.this.iME;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.iME.setEnable(true);
                    PersonalizePageView.this.iGB.setProgressView(PersonalizePageView.this.iME);
                    PersonalizePageView.this.iME.a(aVar);
                    PersonalizePageView.this.iGB.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.iNa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.iMT != null) {
                    PersonalizePageView.this.iMT.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.iGt = new BdTypeRecyclerView(context);
        this.dCC = new LinearLayoutManager(this.iGt.getContext());
        this.iGt.setLayoutManager(this.dCC);
        this.iGt.setFadingEdgeLength(0);
        this.iGt.setOverScrollMode(2);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hDI = new n(new l());
            this.hDI.a(this.iGt, 2);
        }
        MessageManager.getInstance().registerListener(this.hDK);
        MessageManager.getInstance().registerListener(this.iMU);
        this.iGB = new BigdaySwipeRefreshLayout(context);
        this.iGB.addView(this.iGt);
        this.fDW = new PbListView(context);
        this.fDW.getView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setLineGone();
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.fDW.setOnClickListener(this.iGD);
        this.fDW.bkv();
        this.iGt.setNextPage(this.fDW);
        com.baidu.adp.base.e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        MessageManager.getInstance().registerListener(this.iMZ);
        com.baidu.tbadk.core.bigday.b.bbU().hQ(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.bbU().mN(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
        addView(this.iGB);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.iMT = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.iMT, layoutParams);
            this.iMT.setOnClickListener(this.iNa);
            this.iMT.setVisibility(8);
        }
        this.iML = new com.baidu.tieba.homepage.personalize.model.e();
        this.iMH = new af(context, this.iGt);
        this.iMH.b(this.iML);
        this.iMJ = new e(this.pageContext, this.iGt, this.iMH, this.iGB);
        this.iMK = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.hUC);
        this.iMR = com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cxM() {
        if (this.iMG != null) {
            this.iMG.setListPullRefreshListener(this.iMW);
            this.iMG.a(this.iKX);
            this.iMG.a(this.iMX);
            this.iMG.a(this.iKY);
        }
    }

    public void bMg() {
        this.iMH.b(this.iKv);
        this.iMH.a(this.iFO);
        this.iMJ.a(this.iMV);
        this.iMK.a(this);
        cxM();
        this.iGt.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.hTN += i2;
                if (PersonalizePageView.this.iMT != null) {
                    com.baidu.adp.widget.ListView.q item = PersonalizePageView.this.iGt.getItem(PersonalizePageView.this.dCC.findLastVisibleItemPosition());
                    if (item instanceof com.baidu.tieba.card.data.l) {
                        if (((com.baidu.tieba.card.data.l) item).position >= 6) {
                            PersonalizePageView.this.iMT.show();
                        } else {
                            PersonalizePageView.this.iMT.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.dCC != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.hTN < height * 3 || PersonalizePageView.this.ePJ != 1) {
                        if (PersonalizePageView.this.hTN < height * 3 && PersonalizePageView.this.ePJ == 2) {
                            PersonalizePageView.this.ePJ = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.ePJ = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.ePJ)));
                    }
                    if (PersonalizePageView.this.dCC.getItemCount() - PersonalizePageView.this.dCC.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bFD();
                    }
                }
            }
        });
        this.iGt.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bFD();
            }
        });
        this.iGt.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.iMM >= 5000) {
                    PersonalizePageView.this.iMJ.cx(i, i2);
                }
            }
        }, 1L);
        this.iGt.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.iMJ != null && PersonalizePageView.this.iMJ.cmV() != null) {
                        PersonalizePageView.this.iMJ.cmV().cE(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                        ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).ccE().stopPlay();
                    }
                }
            }
        });
        this.iGt.removeOnScrollListener(this.mOnScrollListener);
        this.iGt.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.iMI = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.fDW != null) {
            this.fDW.setText(getContext().getString(R.string.pb_load_more));
            this.fDW.endLoadData();
            this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.iMJ.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.iMJ != null) {
            this.iMJ.pI(!z);
        }
        this.iMQ = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.iMQ;
    }

    public void e(Long l) {
        this.iMJ.e(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.iMJ != null) {
            this.iMJ.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void showFloatingView() {
        if (this.iMJ != null) {
            this.iMJ.showFloatingView();
        }
    }

    public void cxN() {
        if (this.iMJ != null) {
            this.iMJ.cxN();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.fMN != null) {
                this.fMN.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.iMF != null) {
                this.iMF.changeSkin(i);
            }
            if (this.fDW != null) {
                this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
                this.fDW.changeSkin(i);
            }
            this.iMH.onChangeSkinType(i);
            if (this.iMJ != null) {
                this.iMJ.onChangeSkinType(i);
            }
            if (this.iMT != null) {
                this.iMT.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aQ(String str, int i) {
        if (this.fDW != null) {
            this.fDW.setText(getContext().getString(R.string.pb_load_more));
            this.fDW.endLoadData();
            this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.iMJ.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.iMJ != null) {
                        PersonalizePageView.this.iMJ.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFW() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this);
            this.fMN = null;
            this.iGt.setNextPage(this.fDW);
            this.fDW.setText(getContext().getString(R.string.pb_load_more));
            this.fDW.endLoadData();
            this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.iGB != null) {
            this.iGB.setVisibility(0);
        }
        if (this.iMI != null) {
            this.iMI.cwp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgw() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gS(boolean z) {
        if (this.fMN == null) {
            this.fMN = new com.baidu.tbadk.k.g(getContext());
            this.fMN.bn(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.fMN.bsZ();
            this.fMN.setWrapStyle(true);
            this.fMN.onChangeSkinType();
        }
        this.fMN.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.iGt.setNextPage(null);
        if (this.iGB != null) {
            this.iGB.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.iMJ != null) {
            this.iMJ.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.iMJ != null) {
            this.iMJ.or(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.iMR < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mS().postDelayed(this.iMY, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.iMJ != null) {
            this.iMJ.py(z);
        }
        if (this.iGz != null) {
            this.iGz.b(this.iGA);
            this.iGz.a(this.iGA);
            this.iGA.cwN();
        }
    }

    public void cwz() {
        if (this.iMJ != null) {
            gS(true);
            this.iMJ.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.bbU().bbW();
            com.baidu.tbadk.core.bigday.b.bbU().bbV();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.iMJ != null) {
            this.iMJ.update();
        } else if (this.iGt != null && this.iGB != null) {
            showFloatingView();
            this.iGt.setSelection(0);
            if (!this.iGB.isRefreshing()) {
                if (this.iMJ != null && this.iMJ.cmV() != null) {
                    this.iMJ.cmV().cxp();
                    this.iMJ.pE(false);
                }
                this.iGB.setRefreshing(true);
            }
            if (this.iGA != null) {
                this.iGA.cwN();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hDK);
        MessageManager.getInstance().unRegisterListener(this.hUC);
        MessageManager.getInstance().unRegisterListener(this.iMZ);
        this.iMJ.onDestroy();
        this.iMH.b((NEGFeedBackView.a) null);
        this.iMH.onDestroy();
        this.iMJ.a((e.a) null);
        if (this.iME != null) {
            this.iME.setListPullRefreshListener(null);
            this.iME.a((f.d) null);
            this.iME.a((f.a) null);
            this.iME.a((f.b) null);
            this.iME.release();
        }
        if (this.iMF != null) {
            this.iMF.setListPullRefreshListener(null);
            this.iMF.a((f.d) null);
            this.iMF.a((f.a) null);
            this.iMF.a((f.b) null);
            this.iMF.release();
        }
        this.iGt.setOnSrollToBottomListener(null);
        if (this.iGz != null) {
            this.iGz.b(this.iGA);
        }
        this.iGt.removeOnScrollListener(this.mOnScrollListener);
        if (this.fMN != null) {
            this.fMN.release();
        }
        this.iGt.setRecyclerListener(null);
        if (this.iMK != null) {
            this.iMK.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.bbU().destroy();
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iMY);
    }

    public void onPause() {
        this.iMJ.onPause();
        if (this.iMH != null) {
            this.iMH.onPause();
        }
    }

    public void onResume() {
        if (this.hTD) {
            reload();
            this.hTD = false;
        }
        if (this.iGB != null) {
            this.iGB.resume();
        }
        if (this.iMH != null) {
            this.iMH.onResume();
        }
    }

    public void cwf() {
        if (this.iMH != null) {
            this.iMH.notifyDataSetChanged();
        }
    }

    public void cwg() {
        if (this.iMJ != null) {
            this.iMJ.or(true);
        }
        s.cbX().kK(false);
        com.baidu.tieba.a.d.bAA().dA("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iMY);
    }

    public void cxJ() {
        this.iMJ.cyc();
    }

    public void cxO() {
        this.iMJ.cxO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFD() {
        com.baidu.tieba.homepage.framework.a.cwo().r(System.currentTimeMillis(), 1);
        if (this.fDW != null && !this.fDW.isLoading()) {
            this.fDW.startLoadData();
            this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.iMJ.bFD();
    }
}
