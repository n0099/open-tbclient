package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.graphics.Canvas;
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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.n.p;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.t;
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
/* loaded from: classes21.dex */
public class PersonalizePageView extends FrameLayout {
    private LinearLayoutManager edo;
    private final CustomMessageListener fed;
    private int fsp;
    private PbListView giV;
    private int glw;
    private com.baidu.tbadk.k.g grV;
    private boolean iIR;
    private CustomMessageListener iJQ;
    private int iJb;
    private n isY;
    private CustomMessageListener ita;
    f.d jBX;
    f.b jBY;
    private NEGFeedBackView.a jBv;
    private com.baidu.tieba.homepage.personalize.bigday.b jDG;
    private com.baidu.tieba.homepage.personalize.bigday.a jDH;
    private a jDI;
    private af jDJ;
    private com.baidu.tieba.homepage.framework.b jDK;
    private e jDL;
    private com.baidu.tieba.homepage.personalize.a jDM;
    private com.baidu.tieba.homepage.personalize.model.e jDN;
    private long jDO;
    private int jDP;
    private boolean jDQ;
    private boolean jDR;
    private boolean jDS;
    private int jDT;
    private boolean jDU;
    private FRSRefreshButton jDV;
    private CustomMessageListener jDW;
    private e.a jDX;
    f.c jDY;
    f.a jDZ;
    private Runnable jEa;
    public CustomMessageListener jEb;
    private View.OnClickListener jEc;
    private FollowUserButton.a jvg;
    private BdTypeRecyclerView jwg;
    private ScrollFragmentTabHost jwm;
    ScrollFragmentTabHost.a jwn;
    private BigdaySwipeRefreshLayout jwo;
    private View.OnClickListener jwq;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes21.dex */
    public interface a {
        void a(f.a aVar);

        void a(f.b bVar);

        void a(f.d dVar);

        void setListPullRefreshListener(f.c cVar);
    }

    static /* synthetic */ int v(PersonalizePageView personalizePageView) {
        int i = personalizePageView.jDT + 1;
        personalizePageView.jDT = i;
        return i;
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jwm = scrollFragmentTabHost;
        if (this.jwm != null) {
            this.jwm.b(this.jwn);
            this.jwm.a(this.jwn);
        }
        if (this.jDL != null) {
            this.jDL.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jDM != null) {
            this.jDM.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.jwo != null) {
            this.jwo.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jDJ != null) {
            this.jDJ.setPageUniqueId(bdUniqueId);
        }
        if (this.jDL != null) {
            this.jDL.o(bdUniqueId);
        }
        if (this.jDN != null) {
            this.jDN.i(bdUniqueId);
        }
        if (this.jDH != null) {
            this.jDH.setTag(bdUniqueId);
        }
        com.baidu.tbadk.core.bigday.b.biT().setTag(bdUniqueId);
        if (this.fed != null) {
            this.fed.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fed);
        }
        if (this.jDM != null) {
            this.jDM.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.jDO = 0L;
        this.mSkinType = 3;
        this.iIR = false;
        this.jDP = 0;
        this.jDQ = false;
        this.jDR = false;
        this.jDS = false;
        this.jDT = 0;
        this.iJb = 0;
        this.jDU = false;
        this.fsp = 1;
        this.ita = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.isY == null) {
                            PersonalizePageView.this.isY = new n(new l());
                        }
                        PersonalizePageView.this.isY.a(PersonalizePageView.this.jwg, 2);
                    } else if (PersonalizePageView.this.isY != null) {
                        PersonalizePageView.this.isY.rh();
                    }
                }
            }
        };
        this.jDW = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jDL != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.boH().boI(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jBv = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(as asVar) {
                if (asVar != null) {
                    TiebaStatic.log(new ar("c11693").dR("obj_locate", "1").dR("fid", asVar.getFid()).dR("tid", asVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("nid", asVar.getNid()));
                    TiebaStatic.log(new ar("c11989").dR("fid", asVar.getFid()).dR("tid", asVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(as asVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, as asVar) {
                int i = 0;
                if (arrayList != null && asVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (asVar.threadType == 0) {
                        i = 1;
                    } else if (asVar.threadType == 40) {
                        i = 2;
                    } else if (asVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.jDJ != null) {
                        PersonalizePageView.this.jDJ.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dR("tid", asVar.getTid()).dR("nid", asVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", asVar.getFid()).dR("obj_param1", asVar.weight).dR("obj_source", asVar.source).dR("obj_id", asVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).ak(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jvg = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bx) {
                        TiebaStatic.log(com.baidu.tieba.t.a.c("c13696", (bx) tag));
                    }
                }
            }
        };
        this.glw = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.glw != i && PersonalizePageView.this.jwm != null) {
                    PersonalizePageView.this.glw = i;
                    if (PersonalizePageView.this.glw == 1) {
                        PersonalizePageView.this.jwm.bOJ();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jwm.bOK();
                    } else {
                        PersonalizePageView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.jwn = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cJq() {
                if (PersonalizePageView.this.jwm != null) {
                    PersonalizePageView.this.glw = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jwg)) {
                        PersonalizePageView.this.jwm.bOK();
                    } else {
                        PersonalizePageView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.jDX = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iAT = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("key_first_install", true);

            private void cKv() {
                if (this.iAT) {
                    this.iAT = false;
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void U(int i, int i2, int i3) {
                if (PersonalizePageView.this.jDK == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cmm = PersonalizePageView.this.cmm();
                PersonalizePageView.this.VB();
                if (cmm) {
                    PersonalizePageView.this.hM(true);
                }
                PersonalizePageView.this.jDK.T(i, i2, i3);
                q.bgf().bgg();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void D(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jDK != null) {
                    PersonalizePageView.this.jDK.C(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cKv();
                } else if (!this.iAT) {
                    PersonalizePageView.this.jwo.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cKv();
                    PersonalizePageView.this.cJa();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cKv();
                PersonalizePageView.this.jwo.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.VB();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dKT().startLoad();
                }
                PersonalizePageView.this.jDQ = true;
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cKw() {
                if (PersonalizePageView.this.giV != null) {
                    PersonalizePageView.this.giV.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.giV.endLoadData();
                    PersonalizePageView.this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jDY = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bIl().Ez("page_recommend");
                PersonalizePageView.this.jDL.update();
                PersonalizePageView.this.jDL.qY(false);
                PersonalizePageView.this.jDU = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jBX = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jDL != null && PersonalizePageView.this.jDL.cyR() != null) {
                    PersonalizePageView.this.jDL.cyR().cJS();
                }
            }
        };
        this.jDZ = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bsc() {
                if (PersonalizePageView.this.jDU) {
                    PersonalizePageView.this.iJb = 0;
                    PersonalizePageView.this.fsp = 1;
                    PersonalizePageView.this.jDU = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jBY = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jDL != null) {
                    PersonalizePageView.this.jDL.qY(true);
                    PersonalizePageView.this.jDL.cKB();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bpu().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.biT().nM(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.jEa = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fed = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
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
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cIk();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jwq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bOb();
            }
        };
        this.iJQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iIR = true;
                    }
                }
            }
        };
        this.jEb = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jwo != null && !PersonalizePageView.this.jwo.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jDH == null) {
                            PersonalizePageView.this.jDH = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jDH.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jDI = PersonalizePageView.this.jDH;
                            PersonalizePageView.this.cKq();
                        } else if (PersonalizePageView.this.jDI != PersonalizePageView.this.jDH) {
                            PersonalizePageView.this.jDI = PersonalizePageView.this.jDH;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jDH.setEnable(true);
                        PersonalizePageView.this.jwo.setProgressView(PersonalizePageView.this.jDH);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jwo.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jDG == null) {
                        PersonalizePageView.this.jDG = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jDI = PersonalizePageView.this.jDG;
                        PersonalizePageView.this.cKq();
                    } else if (PersonalizePageView.this.jDI != PersonalizePageView.this.jDG || !aVar.equals(PersonalizePageView.this.jDG.cKX())) {
                        PersonalizePageView.this.jDI = PersonalizePageView.this.jDG;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jDG.setEnable(true);
                    PersonalizePageView.this.jwo.setProgressView(PersonalizePageView.this.jDG);
                    PersonalizePageView.this.jDG.a(aVar);
                    PersonalizePageView.this.jwo.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jEc = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jDV != null) {
                    PersonalizePageView.this.jDV.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jDO = 0L;
        this.mSkinType = 3;
        this.iIR = false;
        this.jDP = 0;
        this.jDQ = false;
        this.jDR = false;
        this.jDS = false;
        this.jDT = 0;
        this.iJb = 0;
        this.jDU = false;
        this.fsp = 1;
        this.ita = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.isY == null) {
                            PersonalizePageView.this.isY = new n(new l());
                        }
                        PersonalizePageView.this.isY.a(PersonalizePageView.this.jwg, 2);
                    } else if (PersonalizePageView.this.isY != null) {
                        PersonalizePageView.this.isY.rh();
                    }
                }
            }
        };
        this.jDW = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jDL != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.boH().boI(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jBv = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(as asVar) {
                if (asVar != null) {
                    TiebaStatic.log(new ar("c11693").dR("obj_locate", "1").dR("fid", asVar.getFid()).dR("tid", asVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("nid", asVar.getNid()));
                    TiebaStatic.log(new ar("c11989").dR("fid", asVar.getFid()).dR("tid", asVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(as asVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, as asVar) {
                int i = 0;
                if (arrayList != null && asVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (asVar.threadType == 0) {
                        i = 1;
                    } else if (asVar.threadType == 40) {
                        i = 2;
                    } else if (asVar.threadType == 49) {
                        i = 3;
                    }
                    if (PersonalizePageView.this.jDJ != null) {
                        PersonalizePageView.this.jDJ.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dR("tid", asVar.getTid()).dR("nid", asVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", asVar.getFid()).dR("obj_param1", asVar.weight).dR("obj_source", asVar.source).dR("obj_id", asVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).ak(TiebaInitialize.Params.OBJ_PARAM2, i));
                }
            }
        };
        this.jvg = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bx) {
                        TiebaStatic.log(com.baidu.tieba.t.a.c("c13696", (bx) tag));
                    }
                }
            }
        };
        this.glw = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.glw != i && PersonalizePageView.this.jwm != null) {
                    PersonalizePageView.this.glw = i;
                    if (PersonalizePageView.this.glw == 1) {
                        PersonalizePageView.this.jwm.bOJ();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jwm.bOK();
                    } else {
                        PersonalizePageView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.jwn = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cJq() {
                if (PersonalizePageView.this.jwm != null) {
                    PersonalizePageView.this.glw = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jwg)) {
                        PersonalizePageView.this.jwm.bOK();
                    } else {
                        PersonalizePageView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.jDX = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iAT = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("key_first_install", true);

            private void cKv() {
                if (this.iAT) {
                    this.iAT = false;
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void U(int i, int i2, int i3) {
                if (PersonalizePageView.this.jDK == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cmm = PersonalizePageView.this.cmm();
                PersonalizePageView.this.VB();
                if (cmm) {
                    PersonalizePageView.this.hM(true);
                }
                PersonalizePageView.this.jDK.T(i, i2, i3);
                q.bgf().bgg();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void D(int i, int i2, int i3, int i4) {
                if (PersonalizePageView.this.jDK != null) {
                    PersonalizePageView.this.jDK.C(i, i2, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cKv();
                } else if (!this.iAT) {
                    PersonalizePageView.this.jwo.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cKv();
                    PersonalizePageView.this.cJa();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cKv();
                PersonalizePageView.this.jwo.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.VB();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dKT().startLoad();
                }
                PersonalizePageView.this.jDQ = true;
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cKw() {
                if (PersonalizePageView.this.giV != null) {
                    PersonalizePageView.this.giV.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.giV.endLoadData();
                    PersonalizePageView.this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jDY = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bIl().Ez("page_recommend");
                PersonalizePageView.this.jDL.update();
                PersonalizePageView.this.jDL.qY(false);
                PersonalizePageView.this.jDU = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jBX = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jDL != null && PersonalizePageView.this.jDL.cyR() != null) {
                    PersonalizePageView.this.jDL.cyR().cJS();
                }
            }
        };
        this.jDZ = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bsc() {
                if (PersonalizePageView.this.jDU) {
                    PersonalizePageView.this.iJb = 0;
                    PersonalizePageView.this.fsp = 1;
                    PersonalizePageView.this.jDU = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jBY = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jDL != null) {
                    PersonalizePageView.this.jDL.qY(true);
                    PersonalizePageView.this.jDL.cKB();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bpu().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.biT().nM(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.jEa = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fed = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
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
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cIk();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jwq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bOb();
            }
        };
        this.iJQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iIR = true;
                    }
                }
            }
        };
        this.jEb = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jwo != null && !PersonalizePageView.this.jwo.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jDH == null) {
                            PersonalizePageView.this.jDH = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jDH.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jDI = PersonalizePageView.this.jDH;
                            PersonalizePageView.this.cKq();
                        } else if (PersonalizePageView.this.jDI != PersonalizePageView.this.jDH) {
                            PersonalizePageView.this.jDI = PersonalizePageView.this.jDH;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jDH.setEnable(true);
                        PersonalizePageView.this.jwo.setProgressView(PersonalizePageView.this.jDH);
                        int i = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jwo.setCustomDistances(i, i, i * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jDG == null) {
                        PersonalizePageView.this.jDG = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jDI = PersonalizePageView.this.jDG;
                        PersonalizePageView.this.cKq();
                    } else if (PersonalizePageView.this.jDI != PersonalizePageView.this.jDG || !aVar.equals(PersonalizePageView.this.jDG.cKX())) {
                        PersonalizePageView.this.jDI = PersonalizePageView.this.jDG;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jDG.setEnable(true);
                    PersonalizePageView.this.jwo.setProgressView(PersonalizePageView.this.jDG);
                    PersonalizePageView.this.jDG.a(aVar);
                    PersonalizePageView.this.jwo.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jEc = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jDV != null) {
                    PersonalizePageView.this.jDV.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jDO = 0L;
        this.mSkinType = 3;
        this.iIR = false;
        this.jDP = 0;
        this.jDQ = false;
        this.jDR = false;
        this.jDS = false;
        this.jDT = 0;
        this.iJb = 0;
        this.jDU = false;
        this.fsp = 1;
        this.ita = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (PersonalizePageView.this.isY == null) {
                            PersonalizePageView.this.isY = new n(new l());
                        }
                        PersonalizePageView.this.isY.a(PersonalizePageView.this.jwg, 2);
                    } else if (PersonalizePageView.this.isY != null) {
                        PersonalizePageView.this.isY.rh();
                    }
                }
            }
        };
        this.jDW = new CustomMessageListener(2921456) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jDL != null) {
                    PersonalizePageView.this.d(com.baidu.tbadk.core.feedManager.a.boH().boI(), false, false);
                }
                PersonalizePageView.this.hideLoadingView();
            }
        };
        this.jBv = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.17
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(as asVar) {
                if (asVar != null) {
                    TiebaStatic.log(new ar("c11693").dR("obj_locate", "1").dR("fid", asVar.getFid()).dR("tid", asVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("nid", asVar.getNid()));
                    TiebaStatic.log(new ar("c11989").dR("fid", asVar.getFid()).dR("tid", asVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(as asVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, as asVar) {
                int i2 = 0;
                if (arrayList != null && asVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i22 = 0; i22 < size; i22++) {
                        sb.append(arrayList.get(i22)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (asVar.threadType == 0) {
                        i2 = 1;
                    } else if (asVar.threadType == 40) {
                        i2 = 2;
                    } else if (asVar.threadType == 49) {
                        i2 = 3;
                    }
                    if (PersonalizePageView.this.jDJ != null) {
                        PersonalizePageView.this.jDJ.notifyDataSetChanged();
                    }
                    TiebaStatic.log(new ar("c11693").dR("tid", asVar.getTid()).dR("nid", asVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", asVar.getFid()).dR("obj_param1", asVar.weight).dR("obj_source", asVar.source).dR("obj_id", asVar.extra).dR("obj_type", sb.toString()).dR("obj_name", str).ak(TiebaInitialize.Params.OBJ_PARAM2, i2));
                }
            }
        };
        this.jvg = new FollowUserButton.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.18
            @Override // com.baidu.tieba.view.FollowUserButton.a
            public void onClick(View view) {
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof bx) {
                        TiebaStatic.log(com.baidu.tieba.t.a.c("c13696", (bx) tag));
                    }
                }
            }
        };
        this.glw = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.19
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (PersonalizePageView.this.glw != i2 && PersonalizePageView.this.jwm != null) {
                    PersonalizePageView.this.glw = i2;
                    if (PersonalizePageView.this.glw == 1) {
                        PersonalizePageView.this.jwm.bOJ();
                    } else if (PersonalizePageView.this.a(recyclerView)) {
                        PersonalizePageView.this.jwm.bOK();
                    } else {
                        PersonalizePageView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.jwn = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.20
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cJq() {
                if (PersonalizePageView.this.jwm != null) {
                    PersonalizePageView.this.glw = -1;
                    if (PersonalizePageView.this.a(PersonalizePageView.this.jwg)) {
                        PersonalizePageView.this.jwm.bOK();
                    } else {
                        PersonalizePageView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.jDX = new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.21
            private boolean iAT = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("key_first_install", true);

            private void cKv() {
                if (this.iAT) {
                    this.iAT = false;
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("key_first_install", false);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void U(int i2, int i22, int i3) {
                if (PersonalizePageView.this.jDK == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean cmm = PersonalizePageView.this.cmm();
                PersonalizePageView.this.VB();
                if (cmm) {
                    PersonalizePageView.this.hM(true);
                }
                PersonalizePageView.this.jDK.T(i2, i22, i3);
                q.bgf().bgg();
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void D(int i2, int i22, int i3, int i4) {
                if (PersonalizePageView.this.jDK != null) {
                    PersonalizePageView.this.jDK.C(i2, i22, i3, i4);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 == 1) {
                    if (j.isNetWorkAvailable()) {
                        PersonalizePageView.this.pageContext.showToast(str);
                    }
                    cKv();
                } else if (!this.iAT) {
                    PersonalizePageView.this.jwo.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else {
                    cKv();
                    PersonalizePageView.this.cJa();
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void onSuccess() {
                cKv();
                PersonalizePageView.this.jwo.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.VB();
                if (ae.checkLocationForGoogle(PersonalizePageView.this.getContext())) {
                    MercatorModel.dKT().startLoad();
                }
                PersonalizePageView.this.jDQ = true;
            }

            @Override // com.baidu.tieba.homepage.personalize.e.a
            public void cKw() {
                if (PersonalizePageView.this.giV != null) {
                    PersonalizePageView.this.giV.setText(PersonalizePageView.this.getContext().getString(R.string.recommend_no_more_data));
                    PersonalizePageView.this.giV.endLoadData();
                    PersonalizePageView.this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        };
        this.jDY = new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.22
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                com.baidu.tieba.a.d.bIl().Ez("page_recommend");
                PersonalizePageView.this.jDL.update();
                PersonalizePageView.this.jDL.qY(false);
                PersonalizePageView.this.jDU = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        };
        this.jBX = new f.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.23
            @Override // com.baidu.tbadk.core.view.f.d
            public void onListPullToRefresh(boolean z) {
                if (PersonalizePageView.this.jDL != null && PersonalizePageView.this.jDL.cyR() != null) {
                    PersonalizePageView.this.jDL.cyR().cJS();
                }
            }
        };
        this.jDZ = new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            @Override // com.baidu.tbadk.core.view.f.a
            public void bsc() {
                if (PersonalizePageView.this.jDU) {
                    PersonalizePageView.this.iJb = 0;
                    PersonalizePageView.this.fsp = 1;
                    PersonalizePageView.this.jDU = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                }
            }
        };
        this.jBY = new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // com.baidu.tbadk.core.view.f.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (PersonalizePageView.this.jDL != null) {
                    PersonalizePageView.this.jDL.qY(true);
                    PersonalizePageView.this.jDL.cKB();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH, true));
                com.baidu.tbadk.core.bigday.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bpu().getLong("key_bigday_next_showtime_home", 0L)) {
                    aVar = com.baidu.tbadk.core.bigday.b.biT().nM(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
            }
        };
        this.jEa = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PersonalizePageView.this.pageContext != null) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, PersonalizePageView.v(PersonalizePageView.this));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(PersonalizePageView.this.pageContext.getContext(), 2)));
                }
            }
        };
        this.fed = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
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
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.cIk();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.jwq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.bOb();
            }
        };
        this.iJQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.iIR = true;
                    }
                }
            }
        };
        this.jEb = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PersonalizePageView.this.jwo != null && !PersonalizePageView.this.jwo.isRefreshing()) {
                    if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.bigday.a))) {
                        if (PersonalizePageView.this.jDH == null) {
                            PersonalizePageView.this.jDH = new com.baidu.tieba.homepage.personalize.bigday.a(PersonalizePageView.this.pageContext);
                            PersonalizePageView.this.jDH.changeSkin(PersonalizePageView.this.mSkinType);
                            PersonalizePageView.this.jDI = PersonalizePageView.this.jDH;
                            PersonalizePageView.this.cKq();
                        } else if (PersonalizePageView.this.jDI != PersonalizePageView.this.jDH) {
                            PersonalizePageView.this.jDI = PersonalizePageView.this.jDH;
                        } else {
                            return;
                        }
                        PersonalizePageView.this.jDH.setEnable(true);
                        PersonalizePageView.this.jwo.setProgressView(PersonalizePageView.this.jDH);
                        int i2 = (int) (86.0f * PersonalizePageView.this.getResources().getDisplayMetrics().density);
                        PersonalizePageView.this.jwo.setCustomDistances(i2, i2, i2 * 2);
                        return;
                    }
                    com.baidu.tbadk.core.bigday.a aVar = (com.baidu.tbadk.core.bigday.a) customResponsedMessage.getData();
                    if (PersonalizePageView.this.jDG == null) {
                        PersonalizePageView.this.jDG = new com.baidu.tieba.homepage.personalize.bigday.b(PersonalizePageView.this.pageContext.getContext());
                        PersonalizePageView.this.jDI = PersonalizePageView.this.jDG;
                        PersonalizePageView.this.cKq();
                    } else if (PersonalizePageView.this.jDI != PersonalizePageView.this.jDG || !aVar.equals(PersonalizePageView.this.jDG.cKX())) {
                        PersonalizePageView.this.jDI = PersonalizePageView.this.jDG;
                    } else {
                        return;
                    }
                    PersonalizePageView.this.jDG.setEnable(true);
                    PersonalizePageView.this.jwo.setProgressView(PersonalizePageView.this.jDG);
                    PersonalizePageView.this.jDG.a(aVar);
                    PersonalizePageView.this.jwo.setCustomDistances((int) PersonalizePageView.this.getResources().getDimension(R.dimen.tbds236), (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()) * 0.8d), com.baidu.adp.lib.util.l.getEquipmentHeight(PersonalizePageView.this.pageContext.getContext()));
                }
            }
        };
        this.jEc = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonalizePageView.this.jDV != null) {
                    PersonalizePageView.this.jDV.hide();
                    PersonalizePageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jwg = new BdTypeRecyclerView(context);
        this.edo = new LinearLayoutManager(this.jwg.getContext());
        this.jwg.setLayoutManager(this.edo);
        this.jwg.setFadingEdgeLength(0);
        this.jwg.setOverScrollMode(2);
        if (!com.baidu.tbadk.a.d.bhw()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.jwg.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        }
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.isY = new n(new l());
            this.isY.a(this.jwg, 2);
        }
        MessageManager.getInstance().registerListener(this.ita);
        MessageManager.getInstance().registerListener(this.jDW);
        this.jwo = new BigdaySwipeRefreshLayout(context);
        this.jwo.addView(this.jwg);
        this.giV = new PbListView(context);
        this.giV.getView();
        this.giV.setContainerBackgroundColorResId(R.color.transparent);
        this.giV.setLineGone();
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.setHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        this.giV.setOnClickListener(this.jwq);
        this.giV.brI();
        this.jwg.setNextPage(this.giV);
        com.baidu.adp.base.e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        MessageManager.getInstance().registerListener(this.jEb);
        com.baidu.tbadk.core.bigday.b.biT().iH(true);
        com.baidu.tbadk.core.bigday.a aVar = null;
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bpu().getLong("key_bigday_next_showtime_home", 0L)) {
            aVar = com.baidu.tbadk.core.bigday.b.biT().nM(1);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, aVar));
        addView(this.jwo);
        if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.jDV = new FRSRefreshButton(context);
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds170);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds24);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds180);
            addView(this.jDV, layoutParams);
            this.jDV.setOnClickListener(this.jEc);
            this.jDV.setVisibility(8);
        }
        this.jDN = new com.baidu.tieba.homepage.personalize.model.e();
        this.jDJ = new af(context, this.jwg);
        this.jDJ.b(this.jDN);
        this.jDL = new e(this.pageContext, this.jwg, this.jDJ, this.jwo);
        this.jDM = new com.baidu.tieba.homepage.personalize.a(this.pageContext);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.iJQ);
        this.jDT = com.baidu.tbadk.core.sharedPref.b.bpu().getInt(SharedPrefConfig.SHOW_IS_UNINTEREST_TAG, 0);
    }

    public void cKq() {
        if (this.jDI != null) {
            this.jDI.setListPullRefreshListener(this.jDY);
            this.jDI.a(this.jBX);
            this.jDI.a(this.jDZ);
            this.jDI.a(this.jBY);
        }
    }

    public void bVF() {
        this.jDJ.b(this.jBv);
        this.jDJ.a(this.jvg);
        this.jDL.a(this.jDX);
        this.jDM.a(this);
        cKq();
        this.jwg.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                PersonalizePageView.this.iJb += i2;
                if (PersonalizePageView.this.jDV != null) {
                    com.baidu.adp.widget.ListView.q item = PersonalizePageView.this.jwg.getItem(PersonalizePageView.this.edo.findLastVisibleItemPosition());
                    if (item instanceof k) {
                        if (((k) item).position >= 6) {
                            PersonalizePageView.this.jDV.show();
                        } else {
                            PersonalizePageView.this.jDV.hide();
                        }
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (PersonalizePageView.this.edo != null && i == 0) {
                    int height = ((WindowManager) PersonalizePageView.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
                    if (PersonalizePageView.this.iJb < height * 3 || PersonalizePageView.this.fsp != 1) {
                        if (PersonalizePageView.this.iJb < height * 3 && PersonalizePageView.this.fsp == 2) {
                            PersonalizePageView.this.fsp = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        PersonalizePageView.this.fsp = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(PersonalizePageView.this.fsp)));
                    }
                    if (PersonalizePageView.this.edo.getItemCount() - PersonalizePageView.this.edo.findLastVisibleItemPosition() <= 15) {
                        PersonalizePageView.this.bOb();
                    }
                }
            }
        });
        this.jwg.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.bOb();
            }
        });
        this.jwg.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.jDO >= 5000) {
                    PersonalizePageView.this.jDL.cE(i, i2);
                }
            }
        }, 1L);
        this.jwg.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view;
                if (viewHolder != null && (view = viewHolder.itemView) != null) {
                    if (PersonalizePageView.this.jDL != null && PersonalizePageView.this.jDL.cyR() != null) {
                        PersonalizePageView.this.jDL.cyR().de(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                        ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).coz().stopPlay();
                    }
                }
            }
        });
        this.jwg.removeOnScrollListener(this.mOnScrollListener);
        this.jwg.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.jDK = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.giV != null) {
            this.giV.setText(getContext().getString(R.string.pb_load_more));
            this.giV.endLoadData();
            this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jDL.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.jDL != null) {
            this.jDL.rc(!z);
        }
        this.jDS = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.jDS;
    }

    public void h(Long l) {
        this.jDL.h(l);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.jDL != null) {
            this.jDL.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void showFloatingView() {
        if (this.jDL != null) {
            this.jDL.showFloatingView();
        }
    }

    public void cKr() {
        if (this.jDL != null) {
            this.jDL.cKr();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.grV != null) {
                this.grV.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jDH != null) {
                this.jDH.changeSkin(i);
            }
            if (this.giV != null) {
                this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
                this.giV.changeSkin(i);
            }
            this.jDJ.onChangeSkinType(i);
            if (this.jDL != null) {
                this.jDL.onChangeSkinType(i);
            }
            if (this.jDV != null) {
                this.jDV.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }

    public void aT(String str, int i) {
        if (this.giV != null) {
            this.giV.setText(getContext().getString(R.string.pb_load_more));
            this.giV.endLoadData();
            this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jDL.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.jDL != null) {
                        PersonalizePageView.this.jDL.update();
                    }
                }
            });
        }
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VB() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this);
            this.grV = null;
            this.jwg.setNextPage(this.giV);
            this.giV.setText(getContext().getString(R.string.pb_load_more));
            this.giV.endLoadData();
            this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
        if (this.jwo != null) {
            this.jwo.setVisibility(0);
        }
        if (this.jDK != null) {
            this.jDK.cIN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cmm() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hM(boolean z) {
        if (this.grV == null) {
            this.grV = new com.baidu.tbadk.k.g(getContext());
            this.grV.br(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            this.grV.bAw();
            this.grV.setWrapStyle(true);
            this.grV.onChangeSkinType();
        }
        this.grV.attachView(this, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
        this.jwg.setNextPage(null);
        if (this.jwo != null) {
            this.jwo.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.pageContext.getUniqueId()));
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.jDL != null) {
            this.jDL.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jDL != null) {
            this.jDL.pI(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        if (this.jDT < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jEa, 1000L);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jDL != null) {
            this.jDL.qP(z);
        }
        if (this.jwm != null) {
            this.jwm.b(this.jwn);
            this.jwm.a(this.jwn);
            this.jwn.cJq();
        }
    }

    public void cJa() {
        if (this.jDL != null) {
            hM(true);
            this.jDL.update();
        }
        if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
            com.baidu.tbadk.core.bigday.b.biT().biV();
            com.baidu.tbadk.core.bigday.b.biT().biU();
        }
    }

    public void reload() {
        if (this.refreshView != null && this.jDL != null) {
            this.jDL.update();
        } else if (this.jwg != null && this.jwo != null) {
            showFloatingView();
            this.jwg.setSelection(0);
            if (!this.jwo.isRefreshing()) {
                if (this.jDL != null && this.jDL.cyR() != null) {
                    this.jDL.cyR().cJS();
                    this.jDL.qY(false);
                }
                this.jwo.setRefreshing(true);
            }
            if (this.jwn != null) {
                this.jwn.cJq();
            }
        }
    }

    public void cKs() {
        if (this.refreshView != null) {
            reload();
        } else if (this.jDL != null) {
            this.jDL.update();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ita);
        MessageManager.getInstance().unRegisterListener(this.iJQ);
        MessageManager.getInstance().unRegisterListener(this.jEb);
        this.jDL.onDestroy();
        this.jDJ.b((NEGFeedBackView.a) null);
        this.jDJ.onDestroy();
        this.jDL.a((e.a) null);
        if (this.jDG != null) {
            this.jDG.setListPullRefreshListener(null);
            this.jDG.a((f.d) null);
            this.jDG.a((f.a) null);
            this.jDG.a((f.b) null);
            this.jDG.release();
        }
        if (this.jDH != null) {
            this.jDH.setListPullRefreshListener(null);
            this.jDH.a((f.d) null);
            this.jDH.a((f.a) null);
            this.jDH.a((f.b) null);
            this.jDH.release();
        }
        this.jwg.setOnSrollToBottomListener(null);
        if (this.jwm != null) {
            this.jwm.b(this.jwn);
        }
        this.jwg.removeOnScrollListener(this.mOnScrollListener);
        if (this.grV != null) {
            this.grV.release();
        }
        this.jwg.setRecyclerListener(null);
        if (this.jDM != null) {
            this.jDM.onDestroy();
        }
        com.baidu.tbadk.core.bigday.b.biT().destroy();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jEa);
    }

    public void onPause() {
        this.jDL.onPause();
        if (this.jDJ != null) {
            this.jDJ.onPause();
        }
    }

    public void onResume() {
        if (this.iIR) {
            reload();
            this.iIR = false;
        }
        if (this.jwo != null) {
            this.jwo.resume();
        }
        if (this.jDJ != null) {
            this.jDJ.onResume();
        }
    }

    public void cIk() {
        if (this.jDJ != null) {
            this.jDJ.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jDQ) {
            post(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
                @Override // java.lang.Runnable
                public void run() {
                    PersonalizePageView.this.cKt();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKt() {
        if (!this.jDR) {
            long BO = com.baidu.tieba.homepage.framework.a.cIM().BO(1) + com.baidu.tieba.homepage.framework.a.cIM().getCreateTime();
            long BM = com.baidu.tieba.homepage.framework.a.cIM().BM(1);
            if (BM > 0) {
                BO = System.currentTimeMillis() - BM;
            }
            p pVar = new p();
            pVar.bBR();
            pVar.bBS();
            com.baidu.tbadk.n.n.bBO().ef(BO);
            com.baidu.tbadk.n.n.bBO().eg(pVar.bBT());
        }
        this.jDR = true;
    }

    public void cIl() {
        if (this.jDL != null) {
            this.jDL.pI(true);
        }
        t.cnT().lO(false);
        com.baidu.tieba.a.d.bIl().dL("page_recommend", "show_");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jEa);
    }

    public void cKm() {
        this.jDL.cKI();
    }

    public void cKu() {
        this.jDL.cKu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOb() {
        com.baidu.tieba.homepage.framework.a.cIM().C(System.currentTimeMillis(), 1);
        if (this.giV != null && !this.giV.isLoading()) {
            this.giV.startLoadData();
            this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.jDL.bOb();
    }
}
